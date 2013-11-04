package edu.ruc.labmgr.excel;

/**
 * @author lcheng
 * @version 1.0
 *          ${tags}
 */
public class ColumnPropMapping {

    private int index;
    private String propName;
    private String colType;
    private String propType;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public String getColType() {
        return colType;
    }

    public void setColType(String colType) {
        this.colType = colType;
    }

    public String getPropType() {
        return propType;
    }

    public void setPropType(String propType) {
        this.propType = propType;
    }
}
