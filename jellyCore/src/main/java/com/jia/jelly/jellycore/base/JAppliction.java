
package com.jia.jelly.jellycore.base;

import android.app.Application;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.DBCookieStore;
import com.lzy.okgo.cookie.store.MemoryCookieStore;
import com.lzy.okgo.https.HttpsUtils;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;
import com.readystatesoftware.chuck.ChuckInterceptor;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

/**
 *
 */
public class JAppliction extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initOkGo();
    }

    private void initOkGo() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        //log相关 
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor("OkGo");
        loggingInterceptor.setPrintLevel(HttpLoggingInterceptor.Level.BODY);
        loggingInterceptor.setColorLevel(Level.INFO);
        builder.addInterceptor(loggingInterceptor);
        builder.addInterceptor(new ChuckInterceptor(this));

        //超时时间设置，默认60秒 
        builder.readTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        builder.writeTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);
        builder.connectTimeout(OkGo.DEFAULT_MILLISECONDS, TimeUnit.MILLISECONDS);

        builder.cookieJar(new CookieJarImpl(new MemoryCookieStore()));
        HttpsUtils.SSLParams sslParams1 = HttpsUtils.getSslSocketFactory();
        builder.sslSocketFactory(sslParams1.sSLSocketFactory, sslParams1.trustManager);

        // 其他统一的配置
        OkGo.getInstance().init(this)
                .setOkHttpClient(builder.build())
                .setCacheMode(CacheMode.NO_CACHE)
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)
                .setRetryCount(3);
    }

}