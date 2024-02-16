package app.beelabs.com.codebase.base;


import android.content.Context;

import java.util.List;

import app.beelabs.com.codebase.di.IApi;
import app.beelabs.com.codebase.di.component.AppComponent;

/**
 * Created by arysuryawan on 8/18/17.
 */

public class BaseApi {
    private String apiDomain;

    private static BaseApi baseApi;

    public static BaseApi getInstance() {
        if (baseApi == null)
            baseApi = new BaseApi();
        return baseApi;
    }

    public String getApiDomain() {
        return apiDomain;
    }

    public void setApiDomain(String apiDomain) {
        this.apiDomain = apiDomain;
    }
    public Object setupApi(AppComponent appComponent, Context context, List<String> pinnerList ,Class clazz, boolean allowUntrusted, int timeout, boolean enableLoggingHttp) {
        IApi api = appComponent.getApi();
        return api.initApiService(context,getApiDomain(),pinnerList, allowUntrusted, clazz, timeout, enableLoggingHttp);
    }
}











