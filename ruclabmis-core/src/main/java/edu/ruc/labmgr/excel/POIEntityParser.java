package edu.ruc.labmgr.excel;

import edu.ruc.labmgr.utils.SysUtil;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

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

    private Class<T> type;
    private String colPropMapPrefix;

    public POIEntityParser() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        ;
        this.colPropMapPrefix = COL_PROP_MAP_PREFIX + type.getSimpleName();
    }

    /**
     * 从Excel的一行中解析出Entity-T
     *
     * @param row
     * @return
     */
    public T parseFromRow(HSSFRow row) {
        List<ColumnPropMapping> mappings = getColPropMapping();
        Map<String,Object> map = new HashMap<>();
        for (ColumnPropMapping m : mappings) {
            HSSFCell c = row.getCell(m.getIndex());
            switch (c.getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    map.put(m.getPropName(),c.getStringCellValue());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    map.put(m.getPropName(),c.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    map.put(m.getPropName(),c.getBooleanCellValue());
                    break;
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
        return -1;
    }

    /**
     * 从一个HSSFSheet中解析出一个List<T>
     *
     * @param sheet
     * @return
     */
    public List<T> parseFromSheet(HSSFSheet sheet) {
        assert sheet != null;
        int max = sheet.getLastRowNum();
        int min = getDataStartIndex();
        List<T> result = new ArrayList();
        if (max > min) {
            for (int i = min; i < max; i++) {
                HSSFRow row = sheet.getRow(i);
                result.add(parseFromRow(row));
            }
        }
        return result;
    }

    public List<T> parseFromWorkBook(HSSFWorkbook workbook) {
        assert workbook != null;
        int nos = workbook.getNumberOfSheets();
        List<T> result = new ArrayList<>();
        if (nos > 0) {
            for (int i = 0; i < nos; i++) {
                HSSFSheet sheet = workbook.getSheetAt(i);
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

//    private T newType() {
//        try {
//            T result = this.type.newInstance();
//            return result;
//        } catch (InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
