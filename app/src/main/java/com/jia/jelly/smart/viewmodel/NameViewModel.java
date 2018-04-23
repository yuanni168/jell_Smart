package com.jia.jelly.smart.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class NameViewModel extends ViewModel {
    private MutableLiveData<String> mCurrentName;

    public MutableLiveData<String> getmCurrentName() {
        if (mCurrentName == null) {
            mCurrentName = new MutableLiveData<>();
        }
        return mCurrentName;
    }
}
