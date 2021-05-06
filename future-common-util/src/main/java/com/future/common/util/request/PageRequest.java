package com.future.common.util.request;

import lombok.Data;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author: holmes
 * @date: 2020/7/30 4:16 下午
 */
@Data
public class PageRequest {

    /**
     * 当前页
     */
    @Min(1)
    private Integer pageCurrent = 1;

    /**
     * 每页数量
     */
    @Min(1)
    @Max(100)
    private Integer pageSize = 10;

    @Setter
    private int offset;

    public int getOffset() {
        return (pageCurrent - 1) * pageSize;
    }

}
