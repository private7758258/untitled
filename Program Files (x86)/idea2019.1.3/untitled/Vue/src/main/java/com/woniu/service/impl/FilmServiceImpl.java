package com.woniu.service.impl;

import com.woniu.model.Film;
import com.woniu.mapper.FilmMapper;
import com.woniu.service.FilmService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ppf
 * @since 2021-02-04
 */
@Service
public class FilmServiceImpl extends ServiceImpl<FilmMapper, Film> implements FilmService {

}
