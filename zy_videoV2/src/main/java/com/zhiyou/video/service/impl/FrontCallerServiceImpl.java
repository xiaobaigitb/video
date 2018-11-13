package com.zhiyou.video.service.impl;

import com.zhiyou.video.mapper.FrontCallerMapper;
import com.zhiyou.video.model.CallerModel;
import com.zhiyou.video.service.IFrontCallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mr.lu
 * @Title: FrontCallerServiceImpl
 * @ProjectName zy_videoV2
 * @Description: TODO
 * @date 2018/11/12:19:01
 */
@Service
public class FrontCallerServiceImpl implements IFrontCallerService {
    @Autowired
    FrontCallerMapper callerMapper;

    @Override
    public int saveCaller(CallerModel caller) {
        return callerMapper.saveCaller(caller);
    }
}
