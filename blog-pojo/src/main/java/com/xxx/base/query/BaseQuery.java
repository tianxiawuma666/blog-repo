package com.xxx.base.query;

import lombok.Data;

//分页查询的基础
@Data
public class BaseQuery {
    //当前页
    private Integer currentPage = 1;
    //每页显示的条数
    private Integer pageSize = 5;
    //高级查询关键字
    private String keyword;
}
