package com.example.hp.myapplication.alldata;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class AppInfo implements Serializable {
    /** 序列号 */
    private static final long serialVersionUID = -6660233212727684115L;
    /** 名称 */
    public String name;
    /** (路径) */
    public String path;
    /** 图标 */
    public Drawable icon;
    /** 包名 */
    public String packageName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
