package com.woniu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pages implements Serializable {
    private Integer pages; // 总页码
    private Integer size;  //每页显示行数
    private Integer current; //当前页码
    private Integer total;
    private List<Film> film;
}
