package com.jia.jelly.smart.liveData;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.jia.jelly.smart.model.Product;
import com.jia.jelly.smart.model.Resource;

import java.util.List;

public class NameViewModel extends AndroidViewModel {
    private MutableLiveData<String> mCurrentName;
    private UserRepository mUserRepository;

    private MutableLiveData<List<String>> mNameListData;

    public NameViewModel(@NonNull Application application) {
        super(application);
        mUserRepository = new UserRepository();
    }

    public LiveData<Resource<String>> getCurrentName() {
        return mUserRepository.getCurrentName();
    }

    public MutableLiveData<List<String>> getmNameListData() {
        if (mNameListData == null) {
            mNameListData = new MutableLiveData<>();
        }
        return mNameListData;
    }
}
