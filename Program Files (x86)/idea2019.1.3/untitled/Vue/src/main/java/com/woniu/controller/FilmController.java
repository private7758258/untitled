package com.woniu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniu.mapper.FilmMapper;
import com.woniu.model.*;
import com.woniu.service.FilmService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author WP
 * @since 2021-01-27
 */
@RestController
@RequestMapping("/film")
@CrossOrigin
public class FilmController {
    @Resource
    private FilmMapper filmMapper;

    private QueryWrapper<Film> wrapper;

    public static Film films;
    @Resource
    private FilmService filmService;

    @GetMapping
    public Result index(PageVo pageVo) {
        System.out.println(pageVo);
        Page<Film> filmPage = new Page<>(pageVo.getCurrent(), pageVo.getSize());
        IPage<Film> page = filmService.page(filmPage, null);
        System.out.println(page + "///////////////////");
        return new Result(true, StatusCode.OK, "电影信息分页查询成功", page);
//        System.out.println(films+"前端获取的");
//        if(ObjectUtils.isEmpty(films)){
////           films.getReleaseYear()==null&&films.getTitle()!=null&&films.getDescription()==null&&films.getRentalRate()==null
//           System.err.println("+=========================================");
//           List<Film> films1 = filmMapper.selectList(null);
//           System.out.println(films1);
//           //设置每页显示的行数
//           p.setSize(8);
//           Page<Film> page = new Page<>(p.getCurrent(),15);
//
//           IPage<Film> film = filmMapper.selectPage(page,null);
//           p.setPages((int) film.getPages());
//           List<Film> records = film.getRecords();
//           System.out.println(records+"数据库查询的");
//           System.err.println(film.getPages()+"======");
//           return new Result<List<Film>>(true,200,"success",records);
//       }else{
//           if(films.getTitle()!=null){
//               wrapper.eq("title",films.getTitle());
//           }
//           if(films.getDescription()!=null){
//               wrapper.eq("description",films.getDescription());
//           }
//           if(films.getReleaseYear()!=null){
//               wrapper.eq("release_year",films.getReleaseYear());
//           }
//           if(films.getRentalRate()!=null){
//               wrapper.eq("rental_rate",films.getRentalRate());
//           }
//           Page<Film> page = new Page<>(p.getCurrent(),15);
//           IPage iPage = filmMapper.selectPage(page, wrapper);
//           List<Film> film = iPage.getRecords();
//           p.setSize(8);
//           p.setPages((int) page.getPages());
//           System.err.println(page.getPages()+"------------");
//           System.out.println(films);
//           return new Result<List<Film>>(true,200,"success",film);
//       }
    }
}

