package com.jia.jelly.smart.liveData;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.jia.jelly.smart.model.Product;
import com.jia.jelly.smart.model.Resource;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class UserRepository {

    public LiveData<Resource<String>> getCurrentName() {
        MutableLiveData<Resource<String>> currentNameLd = new MutableLiveData<>();
        OkGo.<String>get("https://blog.csdn.net/zhuzp_blog/article/details/78871527").cacheMode(CacheMode.NO_CACHE).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Log.i("=================", response.toString());
                Resource<String> resource = Resource.success(response.toString());
                currentNameLd.setValue(resource);
            }

            @Override
            public void onError(Response<String> response) {
                super.onError(response);
                Resource<String> resource = Resource.success(response.toString());
                currentNameLd.setValue(resource);
            }
        });
        return currentNameLd;
    }
}
