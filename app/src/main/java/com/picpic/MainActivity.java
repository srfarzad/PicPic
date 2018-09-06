package com.picpic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

   // @BindView(R.id.txt_main) TextView txt_main;
    @BindString(R.string.app_name) String myAppName;


    @Override
    public int setContentView() {
        return R.layout.activity_main;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

  /*  @OnClick(R.id.txt_main)
    public void click(){

        Toast.makeText(getApplicationContext(),myAppName,Toast.LENGTH_LONG).show();

    }*/

}
