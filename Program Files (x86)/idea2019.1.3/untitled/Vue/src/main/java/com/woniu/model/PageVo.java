package com.woniu.model;

import lombok.Data;

import java.util.List;

@Data
public class PageVo {
    private Integer current;
    private Integer size;
    private Integer pages;
    private List<Film> film;
    private Integer total;
}
