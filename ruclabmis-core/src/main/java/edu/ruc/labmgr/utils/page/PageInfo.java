package edu.ruc.labmgr.utils.page;

import java.io.Serializable;

public class PageInfo implements Serializable {

    private static final long serialVersionUID = 587754556498974978L;

    //总页数
    private int totalPage;
    //总记录数
    private int totalResult;
    //当前页
    private int currentPage;
    //当前显示到的ID, 在mysql limit 中就是第一个参数.
    private int currentResult;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(int totalResult) {
        this.totalResult = totalResult;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentResult() {
        return currentResult;
    }

    public void setCurrentResult(int currentResult) {
        this.currentResult = currentResult;
    }

}
