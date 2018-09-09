package com.picpic.Profile.Menu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;

import com.picpic.BaseActivity;
import com.picpic.Profile.AccountSettingsActivity;
import com.picpic.R;

import butterknife.BindView;
import butterknife.OnClick;

public class SignUpActivity extends BaseActivity {

    @BindView(R.id.edt_signup_username)
    AppCompatEditText username;

    @BindView(R.id.edt_signup_password)
    AppCompatEditText password;

    @BindView(R.id.tvLogIn)
    AppCompatTextView logIn;


    private Context mContext=SignUpActivity.this;


    @Override
    public int setContentView() {
        return R.layout.activity_signup;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.tvLogIn)
    public void logInClick(){

        Bundle bundle=new Bundle();
        bundle.putInt("fragNum",1);
        Intent intent=new Intent(mContext,AccountSettingsActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
