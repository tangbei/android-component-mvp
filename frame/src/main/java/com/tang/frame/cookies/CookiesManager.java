package com.tang.frame.cookies;

import android.support.annotation.NonNull;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * 描述:
 * 作者 : Tong
 * e-mail : itangbei@sina.com
 * 创建时间: 2019/9/16.
 */
@Deprecated
public class CookiesManager implements CookieJar {

    private static final PersistentCookieStore COOKIE_STORE = PersistentCookieStore.getCookieStore();

    @Override
    public void saveFromResponse(@NonNull HttpUrl url, @NonNull List<Cookie> cookies) {
        if (cookies.size() > 0) {
            for (Cookie item : cookies) {
                COOKIE_STORE.add(url, item);
            }
        }
    }

    @Override
    public List<Cookie> loadForRequest(@NonNull HttpUrl url) {
        return COOKIE_STORE.get(url);
    }

    /**
     * 清除所有cookie
     */
    public static void clearAllCookies() {
        COOKIE_STORE.removeAll();
    }

    /**
     * 清除指定cookie
     *
     * @param url HttpUrl
     * @param cookie Cookie
     * @return if clear cookies
     */
    public static boolean clearCookies(HttpUrl url, Cookie cookie) {
        return COOKIE_STORE.remove(url, cookie);
    }

    /**
     * 获取cookies
     *
     * @return List<Cookie>
     */
    public static List<Cookie> getCookies() {
        return COOKIE_STORE.getCookies();
    }
}
