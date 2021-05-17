package com.future.framework.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author future
 * @date 2021/05/12 15:03
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private Integer id;

    private String name;


}
