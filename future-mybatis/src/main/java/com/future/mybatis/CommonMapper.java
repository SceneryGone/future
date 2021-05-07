package com.future.mybatis;

import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ids.SelectByIdsMapper;

/**
 * 通用类
 *
 * @author future
 * @date 2021/05/06 10:16
 */
public interface CommonMapper<T> extends BaseMapper<T>, InsertListMapper<T>, SelectByIdsMapper<T> {



}