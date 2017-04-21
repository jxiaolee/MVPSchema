package com.kashuo.architecture.presenter;

import android.os.Handler;

import com.kashuo.architecture.bean.User;
import com.kashuo.architecture.model.IUserImp;
import com.kashuo.architecture.model.IUserModel;
import com.kashuo.architecture.model.OnLoginListener;
import com.kashuo.architecture.view.IUserView;

/**
 * Author:  LiXiao
 * Email:   lixiao@kashuo.com
 * Date:    2017/4/21
 * Description:
 */

public class UserLoginPresenter {

    private IUserModel iUserModel;
    private IUserView iUserView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserView iUserView) {
        this.iUserView = iUserView;
        iUserModel = new IUserImp();
    }

    public void doLogin() {
        iUserView.showProgressDialog();

        iUserModel.login(iUserView.getUserName(), iUserView.getUserPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User mUser) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserView.gotoMainView(mUser);
                        iUserView.hideProgressDialog();
                    }
                });
            }

            @Override
            public void loginFailed() {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        iUserView.showErrorMessage();
                        iUserView.hideProgressDialog();
                    }
                });
            }
        });

    }

    public void doReset() {
        iUserView.clearUserName();
        iUserView.clearPassword();
    }

}
