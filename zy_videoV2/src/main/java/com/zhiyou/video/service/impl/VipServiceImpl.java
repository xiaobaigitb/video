package com.zhiyou.video.service.impl;

import com.zhiyou.video.mapper.VipMapper;
import com.zhiyou.video.model.VipModel;
import com.zhiyou.video.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mr.lu
 * @Title: VipServiceImpl
 * @ProjectName zy_videoV2
 * @Description: TODO
 * @date 2018/11/18:21:18
 */
@Service
public class VipServiceImpl implements VipService {
    @Autowired
    private VipMapper vipMapper;

    @Override
    public void addVipUser(VipModel vipModel) {
        vipMapper.addVipUser(vipModel);
    }
}
