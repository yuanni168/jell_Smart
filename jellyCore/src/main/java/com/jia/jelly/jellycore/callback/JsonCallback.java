
package com.jia.jelly.jellycore.callback;

import com.jia.jelly.jellycore.utils.base_utils.JsonConvert;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.request.base.Request;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * okhttp json callback
 *
 * @param <T>
 */
public abstract class JsonCallback<T> extends AbsCallback<T> {

    private Type type;
    private Class<T> clazz;

    public JsonCallback() {
    }

    public JsonCallback(Type type) {
        this.type = type;
    }

    public JsonCallback(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void onStart(Request<T, ? extends Request> request) {
        super.onStart(request);
    }


    @Override
    public T convertResponse(Response response) throws Throwable {
        ResponseBody body = response.body();
        if (body == null) {
            return null;
        }
        T data = null;
        if (type != null) {
            data = JsonConvert.fromJson(body.charStream(), type);
        }
        if (clazz != null) {
            data = JsonConvert.fromJson(body.charStream(), clazz);
        }
        return data;
    }
} 