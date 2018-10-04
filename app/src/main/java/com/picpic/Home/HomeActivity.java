package com.picpic.Home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.picpic.BaseActivity;
import com.picpic.R;
import com.picpic.Utils.SectionPagerAdapter;
import com.picpic.dagger.DaggerUserComponnet;
import com.picpic.dagger.User;
import com.picpic.dagger.UserComponnet;
import com.picpic.dagger.UserModule;
import com.picpic.service.UpdateService;

import java.util.concurrent.Executor;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {



    @BindView(R.id.container) ViewPager mViewPager;
    private Context context= HomeActivity.this;

    FirebaseAuth firebaseAuth;


    @Override
    public int setContentView() {
        return R.layout.activity_home;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setUpViewPager(mViewPager);
        firebaseAuth = FirebaseAuth.getInstance();
       // startService(new Intent(getApplicationContext(), UpdateService.class));

       // sendMessage();

       // register();

        login();


        UserComponnet componnet= DaggerUserComponnet.builder().userModule(new UserModule()).build();

      //  componnet.provideUser().setUserContact("Test");


        User user = componnet.provideUser();

        Toast.makeText(getApplicationContext(),user.getUserContact(),Toast.LENGTH_LONG).show();

    }



    private void setUpViewPager(ViewPager viewPager){//, ArrayList<SubcatItem> subItems){

        SectionPagerAdapter viewPagerAdapter=new SectionPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new CameraFragment());
        viewPagerAdapter.addFragment(new HomeFragment());
        viewPagerAdapter.addFragment(new MessageFragment());

        viewPager.setAdapter(viewPagerAdapter);

        viewPager.setCurrentItem(1,true);


//        TabLayout tabLayout=findViewById(R.id.tabs_home);
//        tabLayout.setupWithViewPager(viewPager);
//
//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
//        tabLayout.getTabAt(1).setIcon(R.drawable.ic_logo);
//        tabLayout.getTabAt(2).setIcon(R.drawable.ic_direct);




    }

    private void sendMessage(){

        Intent intent = new Intent();
        intent.setClassName("com.picpic2","com.picpic2.MyReciever");
        intent.setAction("com.picpic2.MyReciever");

        intent.putExtra("name","test");

        sendBroadcast(intent);



    }


    private void login(){


        firebaseAuth.signInWithEmailAndPassword("test@gmail.com","12356320")
                .addOnCompleteListener(HomeActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.e("","");
                    }
                });

    }
    private void register(){

        firebaseAuth.createUserWithEmailAndPassword("test@gmail.com","12356320")
                .addOnCompleteListener(HomeActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        Log.e("","");

                        if(!task.isSuccessful()){

                        }
                        else {

                        }

                    }
                });

    }



}
