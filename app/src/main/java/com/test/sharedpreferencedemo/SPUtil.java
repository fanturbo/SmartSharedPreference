package com.test.sharedpreferencedemo;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences辅助类
 */
public class SPUtil {


    /**
     * 存字符串
     *
     * @param key    键
     * @param values 值
     */
    public static void putString(String key, String values) {
        putString(key, values, false);
    }

    /**
     * 存字符串
     *
     * @param key       键
     * @param values    值
     * @param commitNow 是否立即存储
     */
    public static void putString(String key, String values, boolean commitNow) {
        SharedPreferences sp = App.geInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        if (commitNow) {
            sp.edit().putString(key, values).commit();
        } else {
            sp.edit().putString(key, values).apply();
        }
    }


    /**
     * 取字符串
     *
     * @param key 键
     * @return 取出的值
     */
    public static String getString(String key) {
        return getString(key, null);
    }

    /**
     * 取字符串
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 取出的值
     */
    public static String getString(String key, String defaultValue) {
        SharedPreferences sp = App.geInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getString(key, defaultValue);
    }


    /**
     * 存布尔值
     *
     * @param key    键
     * @param values 值
     */
    public static void putBoolean(String key, boolean values) {
        putBoolean(key, values, false);
    }

    /**
     * 存布尔值
     *
     * @param key       键
     * @param values    值
     * @param commitNow 是否立即存储
     */
    public static void putBoolean(String key, boolean values, boolean commitNow) {
        SharedPreferences sp = App.geInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        if (commitNow) {
            sp.edit().putBoolean(key, values).commit();
        } else {
            sp.edit().putBoolean(key, values).apply();
        }
    }

    /**
     * 取布尔值
     *
     * @param key 键
     * @return true/false
     */
    public static boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    /**
     * 取布尔值
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return true/false
     */
    public static boolean getBoolean(String key, boolean defaultValue) {
        SharedPreferences sp = App.geInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getBoolean(key, false);
    }

    /**
     * 存int值
     *
     * @param key    键
     * @param values 值
     */
    public static void putInt(String key, int values) {
        putInt(key, values, false);
    }

    /**
     * 存int值
     *
     * @param key       键
     * @param values    值
     * @param commitNow 是否立即存储
     */
    public static void putInt(String key, int values, boolean commitNow) {
        SharedPreferences sp = App.geInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        if (commitNow) {
            sp.edit().putInt(key, values).commit();
        } else {
            sp.edit().putInt(key, values).apply();
        }
    }

    /**
     * 取int值
     *
     * @return 取出的值
     */
    public static int getInt(String key) {
        return getInt(key, 0);
    }

    /**
     * 取int值
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 取出的值
     */
    public static int getInt(String key, int defaultValue) {
        SharedPreferences sp = App.geInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getInt(key, defaultValue);
    }

    /**
     * 存long值
     *
     * @param key    键
     * @param values 值
     */
    public static void putLong(String key, long values) {
        putLong(key, values, false);
    }

    /**
     * 存long值
     *
     * @param key       键
     * @param values    值
     * @param commitNow 是否立即存储
     */
    public static void putLong(String key, long values, boolean commitNow) {
        SharedPreferences sp = App.geInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        if (commitNow) {
            sp.edit().putLong(key, values).commit();
        } else {
            sp.edit().putLong(key, values).apply();
        }
    }

    /**
     * 取long值
     *
     * @return 取出的值
     */
    public static long getLong(String key) {
        return getLong(key, 0);
    }

    /**
     * 取long值
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 取出的值
     */
    public static long getLong(String key, long defaultValue) {
        SharedPreferences sp = App.geInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getLong(key, defaultValue);
    }
}