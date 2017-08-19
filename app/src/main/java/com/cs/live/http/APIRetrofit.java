package com.cs.live.http;

import com.cs.live.utils.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit网络请求
 */

public class APIRetrofit {

    /**
     *  默认超时时间 单位/秒
     */
    private static final int DEFAULT_TIME_OUT = 10;

    private static Retrofit mRetrofit;

    private static OkHttpClient sOKHttpClient;

    public static APIService getAPIService(){
        return getInstance().create(APIService.class);
    }

    private static Retrofit getInstance(){
        if(mRetrofit == null){
            synchronized (APIRetrofit.class){
                if(mRetrofit == null){
                    mRetrofit = new Retrofit.Builder()
                            .baseUrl(Constants.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(getsOKHttpClient())
                            .build();
                }
            }
        }

        return mRetrofit;
    }

    private static OkHttpClient getsOKHttpClient(){
        if(sOKHttpClient == null){
            synchronized (APIRetrofit.class){
                if(sOKHttpClient == null){
                    sOKHttpClient = new OkHttpClient.Builder()
                            .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                            .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                            .writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                            .build();
                }
            }
        }

        return sOKHttpClient;
    }


}
