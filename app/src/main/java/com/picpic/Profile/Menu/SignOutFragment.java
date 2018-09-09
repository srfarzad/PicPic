package com.picpic.Profile.Menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.picpic.BaseFragment;
import com.picpic.R;

import butterknife.BindView;
import butterknife.OnClick;

public class SignOutFragment extends BaseFragment {


    @BindView(R.id.edt_login_username)
    AppCompatEditText userName;

    @BindView(R.id.edt_login_password)
    AppCompatEditText password;

    @BindView(R.id.btn_login)
    AppCompatButton logIn;

    @BindView(R.id.tvSignUp)
    AppCompatTextView signUp;



    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_signout;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.tvSignUp)
    public void signUp() {
        startActivity(new Intent(getActivity(), SignUpActivity.class));
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().finish();
    }


}
