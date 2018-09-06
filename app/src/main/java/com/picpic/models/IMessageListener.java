package com.picpic.models;

import java.util.List;

public interface IMessageListener<T> {

    public void onResponse(List<T> posts);

    public void onResponse(T posts);

    public void onError(String error);
}
