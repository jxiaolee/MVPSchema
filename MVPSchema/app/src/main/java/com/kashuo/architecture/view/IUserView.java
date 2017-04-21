package com.kashuo.architecture.view;

import com.kashuo.architecture.bean.User;

/**
 * Author:  LiXiao
 * Email:   lixiao@kashuo.com
 * Date:    2017/4/21
 * Description:
 */

public interface IUserView {

    //view层
    String getUserName();

    String getUserPassword();

    void showProgressDialog();

    void hideProgressDialog();

    void gotoMainView(User mUser);

    void showErrorMessage();

    void clearUserName();

    void clearPassword();

}
