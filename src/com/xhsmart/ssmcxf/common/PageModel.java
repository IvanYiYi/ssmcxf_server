package com.xhsmart.ssmcxf.common;

/**
 * 分页实体
 *
 * @author YiPeng
 * @version 1.0
 * @email yipeng@china-xinghan.com
 * @date 2017年06月7日 下午4:19:45
 */
public class PageModel {
    /**
     * 定义默认一页显示的记录条数
     */
    private final static int PAGE_SIZE = 50;
    /**
     * 当前页码
     */
    private int pageIndex;
    /**
     * 每页显示的记录数
     */
    private int pageSize;
    /**
     * 总记录条数
     */
    private int recordCount;

    /**
     * setter and getter method
     */
    public int getPageIndex() {
        this.pageIndex = pageIndex <= 1 ? 1 : pageIndex;
        return this.pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize <= 0 ? PAGE_SIZE : pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    /**
     * limit的第一个问号
     */
    public int getStartRow() {
        /** 当前页码不能大于总页数 */
        int totalSize = this.getRecordCount() % this.getPageSize() != 0
                ? this.getRecordCount() / this.getPageSize() + 1
                : this.getRecordCount() / this.getPageSize();
        this.pageIndex = this.getPageIndex() >= totalSize ? totalSize : this.getPageIndex();
        return (this.getPageIndex() - 1) * this.getPageSize();
    }


}