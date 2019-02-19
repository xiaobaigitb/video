package com.zhiyou.video.mapper;

import com.zhiyou.video.model.CallerModel;
import com.zhiyou.video.util.PageInfo;

import java.util.HashMap;
import java.util.List;

/**
 * @author Mr.lu
 * @Title: FrontCallerMapper
 * @ProjectName zy_videoV2
 * @Description: TODO
 * @date 2018/11/12:19:03
 */
public interface FrontCallerMapper {
    int saveCaller(CallerModel caller);

    CallerModel queryCallerByTel(String tel);

    List<CallerModel> queryCallerModels();

    boolean deleteById(int id);

    CallerModel queryCallerById(int id);

    boolean updateCallerById(CallerModel model);

    int addCallerModel(CallerModel model);

    List<CallerModel> queryCallerPageList(HashMap map);

    int queryCallerListCount(HashMap map);
}
