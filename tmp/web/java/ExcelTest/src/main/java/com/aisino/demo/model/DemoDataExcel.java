package com.aisino.demo.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author: 86177
 * @create: 2021-07-28 08:47
 * @MONTH_NAME_SHORT: 七月
 * @DAY_NAME_FULL: 星期三
 * @desc：学生表
 **/
@Data
public class DemoDataExcel {
    @ExcelProperty("学生姓名")
    private String name;
    @ExcelProperty("学生编号")
    private Integer id;
}
