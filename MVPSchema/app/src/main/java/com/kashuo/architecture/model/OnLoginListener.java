package com.kashuo.architecture.model;

import com.kashuo.architecture.bean.User;

/**
 * Author:  LiXiao
 * Email:   lixiao@kashuo.com
 * Date:    2017/4/21
 * Description:
 */

public interface OnLoginListener {

    //登录的回调方法
    void loginSuccess(User mUser);

    void loginFailed();

}
