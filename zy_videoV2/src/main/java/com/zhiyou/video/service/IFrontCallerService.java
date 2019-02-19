package com.zhiyou.video.service;

import com.zhiyou.video.bean.CallerResult;
import com.zhiyou.video.model.CallerModel;
import com.zhiyou.video.util.PageInfo;

import java.util.HashMap;
import java.util.List;

/**
 * @author Mr.lu
 * @Title: IFrontCallerService
 * @ProjectName zy_videoV2
 * @Description: TODO
 * @date 2018/11/12:18:59
 */
public interface IFrontCallerService {
    CallerResult saveCaller(CallerModel caller);

    List<CallerModel> queryCallerModels();

    boolean deleteById(int id);

    CallerModel queryCallerById(int id);

    boolean updateCallerById(CallerModel model);

    int addCallerModel(CallerModel model);

    PageInfo<CallerModel> queryCallerPageList(HashMap map);
}
