package com.jia.jelly.smart.liveData;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

public class UserRepository {

    public MutableLiveData<String> getCurrentName() {
        MutableLiveData<String> currentNameLd = new MutableLiveData<>();
        currentNameLd.setValue("张三");
        return currentNameLd;
    }
}
