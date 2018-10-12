package com.example.hiennv.mvparchitecture.utils;

import com.example.hiennv.mvparchitecture.BuildConfig;


import timber.log.Timber;

public class AppLogger {
    /*Su dung Timber duoc goi trong ham onCreate cua application*/
    public static void init() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    /**
     * @param s
     * @param objects
     */
    public static void d(String s, Object... objects) {
        Timber.d(s, objects);
    }

    /**
     * @param throwable
     * @param s
     * @param objects
     */
    public static void d(Throwable throwable, String s, Object... objects) {
        Timber.d(throwable, s, objects);
    }

    /**
     * @param s
     * @param objects
     */
    public static void e(String s, Object... objects) {
        Timber.e(s, objects);
    }

    /**
     * -
     *
     * @param throwable
     * @param s
     * @param objects
     */
    public static void e(Throwable throwable, String s, Object... objects) {
        Timber.e(throwable, s, objects);
    }

    /**
     * @param s
     * @param objects
     */
    public static void i(String s, Object... objects) {
        Timber.i(s, objects);
    }

    /**
     * @param throwable
     * @param s
     * @param objects
     */
    public static void i(Throwable throwable, String s, Object... objects) {
        Timber.i(throwable, s, objects);
    }

    /**
     * @param s
     * @param objects
     */
    public static void w(String s, Object... objects) {
        Timber.i(s, objects);
    }

    /**
     * @param throwable
     * @param s
     * @param objects
     */
    public static void w(Throwable throwable, String s, Object... objects) {
        Timber.w(throwable, s, objects);
    }
}
