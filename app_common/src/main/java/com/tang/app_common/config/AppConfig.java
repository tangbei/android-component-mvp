package com.tang.app_common.config;

import android.os.Environment;

/**
 * 描述:
 * 作者 : Tong
 * e-mail : itangbei@sina.com
 * 创建时间: 2019/9/16.
 */
public class AppConfig {

    public static final String TAG = "";

    public static final String BASE_URL = "https://b.toolmall.com";

    public static final int maxRetries = 3;//请求重试次数

    public static final int retryDelaySecond = 2;//请求重试间隔

    public static class Path {

        public static final String APP_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/arouter/";

        public static final String APP_PATH_GLIDE = "glide";

        public static final String APP_PATH_CACHE = APP_PATH + "cache/";
    }
}
