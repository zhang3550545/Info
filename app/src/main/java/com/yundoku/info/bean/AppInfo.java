package com.yundoku.info.bean;

import java.util.List;

public class AppInfo {

    public String packageName;

    public String versionName;

    public int versionCode;

    public long firstInstallTime;

    public long lastUpdateTime;

    public String appName;

    public int targetSdkVersion;

    public boolean isSystemApp;

    public List<String> activityNames;

    public List<String> serviceNames;

    public List<String> receiveNames;

    public List<String> providerNames;

    public List<String> permissionNames;

    @Override
    public String toString() {
        return "AppInfo{" +
                "packageName='" + packageName + '\'' +
                ", versionName='" + versionName + '\'' +
                ", versionCode=" + versionCode +
                ", firstInstallTime=" + firstInstallTime +
                ", lastUpdateTime=" + lastUpdateTime +
                ", appName='" + appName + '\'' +
                ", targetSdkVersion=" + targetSdkVersion +
                ", isSystemApp=" + isSystemApp +
                ", activityNames=" + activityNames +
                ", serviceNames=" + serviceNames +
                ", receiveNames=" + receiveNames +
                ", providerNames=" + providerNames +
                ", permissionNames=" + permissionNames +
                '}';
    }
}
