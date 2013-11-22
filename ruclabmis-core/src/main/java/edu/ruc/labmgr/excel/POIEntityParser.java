package edu.ruc.labmgr.excel;

import edu.ruc.labmgr.utils.SysUtil;
import org.apache.poi.ss.usermodel.*;

import java.lang.reflect.ParameterizedType;
import java.util.*;

/**
 * @author lcheng
 * @version 1.0
 *          ${tags}
 */
public abstract class POIEntityParser<T> {

    private static String COL_PROP_BEAN = "colPropMapping";
    private static String COL_PROP_MAP_PREFIX = "CPMAP.";
    private static String DATA_START_PROP = ".DataStart";

    private Class<T> type;
    private String colPropMapPrefix;
    private String dataStartIndexPrefix;

    public POIEntityParser() {
        Class clz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.type = clz;
        this.colPropMapPrefix = COL_PROP_MAP_PREFIX + type.getSimpleName() + ".Field";
        this.dataStartIndexPrefix = COL_PROP_MAP_PREFIX + type.getSimpleName();
    }

    public POIEntityParser(Class<T> clz) {
        this.type = clz;
        this.colPropMapPrefix = COL_PROP_MAP_PREFIX + type.getSimpleName() + ".Field";
        this.dataStartIndexPrefix = COL_PROP_MAP_PREFIX + type.getSimpleName();
    }

    /**
     * 从Excel的一行中解析出Entity-T
     *
     * @param row
     * @return
     */
    public T parseFromRow(Row row) {
        List<ColumnPropMapping> mappings = getColPropMapping();
        Map<String, Object> map = new HashMap<>();
        for (ColumnPropMapping m : mappings) {
            Cell c = row.getCell(m.getIndex());
            if (c != null) {
                switch (c.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        map.put(m.getPropName(), c.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        if (DateUtil.isCellDateFormatted(c)) {
                            map.put(m.getPropName(), c.getDateCellValue());
                        } else {
                            map.put(m.getPropName(), c.getNumericCellValue());
                        }
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        map.put(m.getPropName(), c.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_BLANK:
                        map.put(m.getPropName(), "");
                        break;
                    default:
                        map.put(m.getPropName(), null);
                        break;
                }
            } else {
                map.put(m.getPropName(), null);
            }
        }
        return mapToEntity(map);
    }

    public abstract T mapToEntity(Map<String, Object> map);

    /**
     * 数据行开始的索引
     *
     * @return
     */
    public int getDataStartIndex() {
        Properties p = SysUtil.getBean(COL_PROP_BEAN, Properties.class);
        String startIndex = p.getProperty(this.dataStartIndexPrefix + DATA_START_PROP, "0");
        return Integer.valueOf(startIndex);
    }

    /**
     * 从一个HSSFSheet中解析出一个List<T>
     *
     * @param sheet
     * @return
     */
    public List<T> parseFromSheet(Sheet sheet) {
        assert sheet != null;
        int max = sheet.getLastRowNum();
        int min = getDataStartIndex();
        List<T> result = new ArrayList();
        if (max > min) {
            for (int i = min; i < max; i++) {
                Row row = sheet.getRow(i);
                result.add(parseFromRow(row));
            }
        }
        return result;
    }

    public List<T> parseFromWorkBook(Workbook workbook) {
        assert workbook != null;
        int nos = workbook.getNumberOfSheets();
        List<T> result = new ArrayList<>();
        if (nos > 0) {
            for (int i = 0; i < nos; i++) {
                Sheet sheet = workbook.getSheetAt(i);
                result.addAll(parseFromSheet(sheet));
            }
        }
        return result;
    }

    protected List<ColumnPropMapping> getColPropMapping() {
        Properties p = SysUtil.getBean(COL_PROP_BEAN, Properties.class);
        Map<String, String> colPropMaps = getPropertyStartWith(p, this.colPropMapPrefix);
        List<ColumnPropMapping> result = new ArrayList<ColumnPropMapping>();
        for (String key : colPropMaps.keySet()) {
            result.add(parseColPropMapping(key, colPropMaps.get(key)));
        }
        return result;
    }

    private Map<String, String> getPropertyStartWith(Properties p, String prefix) {
        Set<String> keys = p.stringPropertyNames();
        Map<String, String> result = new HashMap();
        for (String key : keys) {
            if (key.startsWith(prefix)) {
                result.put(key, p.getProperty(key));
            }
        }
        return result;
    }

    private ColumnPropMapping parseColPropMapping(String key, String value) {
        int index = key.lastIndexOf(".");
        if (index > 0) {
            int colNum = Integer.valueOf(key.substring(index + 1));
            String propName = null, colType = null, propType = null;
            String[] vs = value.split(",");
            if (vs.length == 1) {
                propName = vs[0];
                colType = "String";
                propType = "String";
            } else if (vs.length == 2) {
                propName = vs[0];
                propType = vs[1];
            }
            ColumnPropMapping m = new ColumnPropMapping();
            m.setIndex(colNum);
            m.setPropName(propName);
            m.setColType(colType);
            m.setPropType(propType);
            return m;
        }
        return null;
    }

    protected T newType() {
        try {
            T result = this.type.newInstance();
            return result;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
