package org.bomb.duapp.sharding.query;

public class OrderInfoQuery {
    private Long userId;

    private Long orderId;

    private String userName;

    private String sql_sort;

    private Integer pageNo;

    private Integer pageSize;

    private Integer index;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSql_sort() {
        return sql_sort;
    }

    public void setSql_sort(String sql_sort) {
        this.sql_sort = sql_sort;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public OrderInfoQuery buildPage() {
        if (null != pageNo && null != pageSize)
            this.setIndex((pageNo - 1)*pageSize);
        return this;
    }
}
