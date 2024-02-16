package app.beelabs.com.codebase.di.manager;

import android.content.Context;

import java.util.List;

import app.beelabs.com.codebase.base.BaseManager;
import app.beelabs.com.codebase.di.IApi;
import app.beelabs.com.codebase.di.IApiService;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by arysuryawan on 8/21/17.
 */

public class ApiManager extends BaseManager implements IApi {
    private Object api;
    private String apiDomain = "";


    @Override
    public Object initApiService(Context context, String apiDomain, List<String> pinnerList, boolean allowUntrusted, Class<IApiService> clazz, int timeout, boolean enableLoggingHttp) {
        if (api == null || !this.apiDomain.equals(apiDomain)) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(apiDomain)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .client(getHttpClient(context,apiDomain,pinnerList,allowUntrusted, timeout, enableLoggingHttp))
                    .build();
            api = retrofit.create(clazz);
            this.apiDomain = apiDomain;
        }
        return api;
    }
}
