package com.zhiyou.video.app;

import com.zhiyou.video.model.UserModel;
import com.zhiyou.video.service.IFrontUserService;
import com.zhiyou.video.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class Intelligence {

    /**
     * 定时获取用户表中的状态，如果为 0，表示刚注册，修改用户的权限
     */
    @Autowired
    IFrontUserService frontUserService;
    @Autowired
    UserRoleService userRoleService;
    @Transactional
    public void autoUpdateRole(){
        List<UserModel> userModelList=frontUserService.selectUserList();
        System.out.println(userModelList.toString());
        for (UserModel user :
                userModelList) {
            //如果为 0，表示刚注册，修改用户的权限
            if (user.getStatus() == 0){
                //获取该用户的ID
                int userId = user.getId();
                //将用户权限表中插入数据
                userRoleService.addUserRoleModel(userId,2);
                //插入之后修改，用户的状态
                frontUserService.updateUserStatus(userId);
                //插入之后修改，用户的权限
                frontUserService.updateUserRoleId(userId);
                //插入之后修改，用户的学科id
                frontUserService.updateUserSubjectById(userId);
            }
        }
    }

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring.xml");
    }

    /**
     * 定时将用户的信息发送到阿里云进行比对
     */
}
