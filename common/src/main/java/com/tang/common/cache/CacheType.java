package com.tang.common.cache;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.tang.common.manager.RepositoryManager;

/**
 * 描述:
 * 作者 : Tong
 * e-mail : itangbei@sina.com
 * 创建时间: 2019/9/16.
 */
public interface CacheType {

    int RETROFIT_SERVICE_CACHE_TYPE_ID = 0;
    int CACHE_SERVICE_CACHE_TYPE_ID = 1;
    int EXTRAS_TYPE_ID = 2;
    int ACTIVITY_CACHE_TYPE_ID = 3;
    int FRAGMENT_CACHE_TYPE_ID = 4;
    /**
     * {@link RepositoryManager}中存储 Retrofit Service 的容器
     */
    CacheType RETROFIT_SERVICE_CACHE = new CacheType() {
        private static final int MAX_SIZE = 150;
        private static final float MAX_SIZE_MULTIPLIER = 0.002f;

        @Override
        public int getCacheTypeId() {
            return RETROFIT_SERVICE_CACHE_TYPE_ID;
        }

        @Override
        public int calculateCacheSize(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            int targetMemoryCacheSize = (int) (activityManager.getMemoryClass() * MAX_SIZE_MULTIPLIER * 1024);
            if (targetMemoryCacheSize >= MAX_SIZE) {
                return MAX_SIZE;
            }
            return targetMemoryCacheSize;
        }
    };

    /**
     * {@link RepositoryManager} 中储存 Cache Service 的容器
     */
    CacheType CACHE_SERVICE_CACHE = new CacheType() {
        private static final int MAX_SIZE = 150;
        private static final float MAX_SIZE_MULTIPLIER = 0.002f;

        @Override
        public int getCacheTypeId() {
            return CACHE_SERVICE_CACHE_TYPE_ID;
        }

        @Override
        public int calculateCacheSize(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            int targetMemoryCacheSize = (int) (activityManager.getMemoryClass() * MAX_SIZE_MULTIPLIER * 1024);
            if (targetMemoryCacheSize >= MAX_SIZE) {
                return MAX_SIZE;
            }
            return targetMemoryCacheSize;
        }
    };

    /**
     */
    CacheType EXTRAS = new CacheType() {
        private static final int MAX_SIZE = 500;
        private static final float MAX_SIZE_MULTIPLIER = 0.005f;

        @Override
        public int getCacheTypeId() {
            return EXTRAS_TYPE_ID;
        }

        @Override
        public int calculateCacheSize(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            int targetMemoryCacheSize = (int) (activityManager.getMemoryClass() * MAX_SIZE_MULTIPLIER * 1024);
            if (targetMemoryCacheSize >= MAX_SIZE) {
                return MAX_SIZE;
            }
            return targetMemoryCacheSize;
        }
    };

    /**
     * {@link Activity} 中存储数据的容器
     */
    CacheType ACTIVITY_CACHE = new CacheType() {
        private static final int MAX_SIZE = 80;
        private static final float MAX_SIZE_MULTIPLIER = 0.0008f;

        @Override
        public int getCacheTypeId() {
            return ACTIVITY_CACHE_TYPE_ID;
        }

        @Override
        public int calculateCacheSize(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            int targetMemoryCacheSize = (int) (activityManager.getMemoryClass() * MAX_SIZE_MULTIPLIER * 1024);
            if (targetMemoryCacheSize >= MAX_SIZE) {
                return MAX_SIZE;
            }
            return targetMemoryCacheSize;
        }
    };

    /**
     * {@link Fragment} 中存储数据的容器
     */
    CacheType FRAGMENT_CACHE = new CacheType() {
        private static final int MAX_SIZE = 80;
        private static final float MAX_SIZE_MULTIPLIER = 0.0008f;

        @Override
        public int getCacheTypeId() {
            return FRAGMENT_CACHE_TYPE_ID;
        }

        @Override
        public int calculateCacheSize(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            int targetMemoryCacheSize = (int) (activityManager.getMemoryClass() * MAX_SIZE_MULTIPLIER * 1024);
            if (targetMemoryCacheSize >= MAX_SIZE) {
                return MAX_SIZE;
            }
            return targetMemoryCacheSize;
        }
    };

    /**
     * 返回框架内需要缓存的模块对应的 {@code id}
     *
     * @return
     */
    int getCacheTypeId();

    /**
     * 计算对应模块需要的缓存大小
     *
     * @return
     */
    int calculateCacheSize(Context context);
}
