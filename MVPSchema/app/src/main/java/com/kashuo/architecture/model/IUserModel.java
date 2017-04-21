package com.kashuo.architecture.model;

/**
 * Author:  LiXiao
 * Email:   lixiao@kashuo.com
 * Date:    2017/4/21
 * Description:
 */

public interface IUserModel {

    //MVP模式中的Model层，用来处理业务逻辑。
    public void login(String userName, String userPassword, OnLoginListener onLoginListener);

}
