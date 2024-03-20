package app.beelabs.com.codebase.di;


import android.content.Context;

import com.chuckerteam.chucker.api.ChuckerInterceptor;

import java.util.List;

import okhttp3.Interceptor;

/**
 * Created by arysuryawan on 8/21/17.
 */

public interface IApi {

    Object initApiService(Context context, String apiDomain, List<String>  pinnerList, boolean allowUntrusted, Class<IApiService> clazz, int timeout, boolean enableLoggingHttp,String appVersion);

}
