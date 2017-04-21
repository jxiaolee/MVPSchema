package com.kashuo.architecture.mvpschema;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kashuo.architecture.bean.User;
import com.kashuo.architecture.presenter.UserLoginPresenter;
import com.kashuo.architecture.view.IUserView;

public class MainActivity extends AppCompatActivity implements IUserView {

    private Button mBtnLogin, mBtnReset;
    private EditText mETUserName, mETUserPassword;
    private ProgressBar mPbLoading;

    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.doLogin();
            }
        });

        mBtnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserLoginPresenter.doReset();
            }
        });
    }

    public void initWidgets() {
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnReset = (Button) findViewById(R.id.btn_reset);
        mETUserName = (EditText) findViewById(R.id.et_username);
        mETUserPassword = (EditText) findViewById(R.id.et_password);

        mPbLoading = (ProgressBar) findViewById(R.id.pg_loading);
    }

    @Override
    public String getUserName() {
        return mETUserName.getText().toString();
    }

    @Override
    public String getUserPassword() {
        return mETUserPassword.getText().toString();
    }

    @Override
    public void showProgressDialog() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressDialog() {
        mPbLoading.setVisibility(View.INVISIBLE);
    }

    @Override
    public void gotoMainView(User mUser) {
        Toast.makeText(this, mUser.getUserName() + " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearUserName() {
        mETUserName.setText("");
    }

    @Override
    public void clearPassword() {
        mETUserPassword.setText("");
    }
}
