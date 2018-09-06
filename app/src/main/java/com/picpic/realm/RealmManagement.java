package com.picpic.realm;

import com.picpic.models.User;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class RealmManagement {


    public void insert(User user) {


      // Create a new object
     //   realm.insert(user);
       // realm.commitTransaction();
    }

    public List<User> getUsersList() {

        Realm realm = Realm.getDefaultInstance();
        RealmResults<User> userRealmResults = realm.where(User.class).findAll();
        return userRealmResults;
    }

}
