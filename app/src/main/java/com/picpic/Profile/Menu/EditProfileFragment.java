package com.picpic.Profile.Menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.picpic.BaseFragment;
import com.picpic.R;
import com.picpic.models.User;
import com.picpic.realm.RealmManagement;

import butterknife.BindView;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class EditProfileFragment extends BaseFragment {

    @BindView(R.id.home_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.txtTitile_toolbar)
    TextView title;

    @BindView(R.id.edt_name) AppCompatEditText edt_name;
    @BindView(R.id.edt_username) AppCompatEditText edt_username;
    @BindView(R.id.edt_website) AppCompatEditText edt_website;
    @BindView(R.id.edt_bio) AppCompatEditText edt_bio;
    @BindView(R.id.edt_email) AppCompatEditText edt_email;
    @BindView(R.id.edt_phone) AppCompatEditText edt_phone;

    @BindView(R.id.spi_gender)Spinner spi_gender;

    RealmManagement realmManagement;


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_editprofile;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        realmManagement = new RealmManagement();

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(mToolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);

        title.setText(getString(R.string.Edit_Profile));

        setHasOptionsMenu(true);





    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.check_icon, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.ic_check) {

            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            User user = realm.createObject(User.class);
            user.setEmail(edt_email.getText().toString());
            user.setPhoneNumber(edt_phone.getText().toString());
            user.setUsername(edt_username.getText().toString());
            user.setPassword("123");
            user.setName(edt_name.getText().toString());
            user.setBio(edt_bio.getText().toString());
            user.setGender(1);
            user.setWebsite(edt_website.getText().toString());
            //realmManagement.insert(user);

            realm.copyToRealm(user);
           // realm.insert(user);
            realm.commitTransaction();
            RealmQuery<User> query = realm.where(User.class);

           // List<User> users = realmManagement.getUsersList();


            RealmResults<User> pups = realm.where(User.class)
                    .findAll();
            String bioo = pups.get(0).getBio();

            Log.e("","");


        } else {
            getActivity().onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }



}
