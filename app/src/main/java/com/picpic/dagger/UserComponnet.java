package com.picpic.dagger;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = UserModule.class)
public interface UserComponnet {

    User provideUser();

}
