package com.future.common.util.response;

import lombok.Data;

import java.util.List;

/**
 * @author holmes
 * @date 2020/7/30 4:16 下午
 */
@Data
public class PageResponse<T> {

    /**
     * 返回的数据
     */
    private List<T> list;

    /**
     * 总共条数
     */
    private Integer recordTotal;

    /**
     * 每页个数
     */
    private Integer pageSize;

    /**
     * 一共多少页
     */
    private Integer pageTotal;

    /**
     * 当前页
     */
    private Integer pageCurrent;

    public PageResponse(List<T> list, Integer recordTotal, Integer pageSize, Integer pageCurrent) {
        this.list = list;
        this.recordTotal = recordTotal;
        this.pageSize = pageSize;
        this.pageCurrent = pageCurrent;
        this.pageTotal = getPageTotal();
    }

    public Integer getPageTotal() {
        return this.recordTotal % this.pageSize == 0 ? this.recordTotal / this.pageSize : this.recordTotal / this.pageSize + 1;
    }

}
