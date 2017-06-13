package com.yundoku.info.utils;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;

import com.yundoku.info.bean.AccountInfo;
import com.yundoku.info.bean.AppInfo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class InfoUtil {

    /**
     * 获取手机中的应用关于包中的信息
     */
    public static List<AppInfo> getAppInfoList(Context context) {

        PackageManager packageManager = context.getPackageManager();
        List<PackageInfo> packages = packageManager.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
        List<AppInfo> list = new LinkedList<>();
        for (PackageInfo packageInfo : packages) {
            AppInfo info = new AppInfo();
            info.packageName = packageInfo.packageName;
            info.versionName = packageInfo.versionName;
            info.versionCode = packageInfo.versionCode;
            info.firstInstallTime = packageInfo.firstInstallTime;
            info.lastUpdateTime = packageInfo.lastUpdateTime;
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            info.appName = packageManager.getApplicationLabel(applicationInfo).toString();
            info.targetSdkVersion = applicationInfo.targetSdkVersion;
            info.isSystemApp = (ApplicationInfo.FLAG_SYSTEM & applicationInfo.flags) != 0;
            list.add(info);
        }

        List<PackageInfo> packages1 = packageManager.getInstalledPackages(PackageManager.GET_ACTIVITIES);
        Map<String, List<String>> map1 = new HashMap<>();
        for (PackageInfo packageInfo : packages1) {
            List<String> activityLists = new LinkedList<>();
            ActivityInfo[] activities = packageInfo.activities;
            if (activities != null && activities.length > 0) {
                for (ActivityInfo activityInfo : activities) {
                    activityLists.add(activityInfo.name);
                }
            }
            map1.put(packageInfo.packageName, activityLists);
        }

        List<PackageInfo> packages2 = packageManager.getInstalledPackages(PackageManager.GET_SERVICES);
        Map<String, List<String>> map2 = new HashMap<>();
        for (PackageInfo packageInfo : packages2) {
            List<String> serviceLists = new LinkedList<>();
            ServiceInfo[] services = packageInfo.services;
            if (services != null && services.length > 0) {
                for (ServiceInfo serviceInfo : services) {
                    serviceLists.add(serviceInfo.name);
                }
            }
            map2.put(packageInfo.packageName, serviceLists);
        }

        List<PackageInfo> packages3 = packageManager.getInstalledPackages(PackageManager.GET_RECEIVERS);
        Map<String, List<String>> map3 = new HashMap<>();
        for (PackageInfo packageInfo : packages3) {
            List<String> receiveLists = new LinkedList<>();
            ActivityInfo[] receivers = packageInfo.receivers;
            if (receivers != null && receivers.length > 0) {
                for (ActivityInfo receiveInfo : receivers) {
                    receiveLists.add(receiveInfo.name);
                }
            }
            map3.put(packageInfo.packageName, receiveLists);
        }

        List<PackageInfo> packages4 = packageManager.getInstalledPackages(PackageManager.GET_PROVIDERS);
        Map<String, List<String>> map4 = new HashMap<>();
        for (PackageInfo packageInfo : packages4) {
            List<String> providerLists = new LinkedList<>();
            ProviderInfo[] providers = packageInfo.providers;
            if (providers != null && providers.length > 0) {
                for (ProviderInfo providerInfo : providers) {
                    providerLists.add(providerInfo.name);
                }
            }
            map4.put(packageInfo.packageName, providerLists);
        }

        List<PackageInfo> packages5 = packageManager.getInstalledPackages(PackageManager.GET_PERMISSIONS);
        Map<String, List<String>> map5 = new HashMap<>();
        for (PackageInfo packageInfo : packages5) {
            List<String> permissionLists = new LinkedList<>();
            PermissionInfo[] permissions = packageInfo.permissions;
            if (permissions != null && permissions.length > 0) {
                for (PermissionInfo permissionInfo : permissions) {
                    permissionLists.add(permissionInfo.name);
                }
            }
            map5.put(packageInfo.packageName, permissionLists);
        }

        for (AppInfo info : list) {
            List<String> list1 = map1.get(info.packageName);
            if (list1 == null) list1 = new LinkedList<>();
            List<String> list2 = map2.get(info.packageName);
            if (list2 == null) list2 = new LinkedList<>();
            List<String> list3 = map3.get(info.packageName);
            if (list3 == null) list3 = new LinkedList<>();
            List<String> list4 = map4.get(info.packageName);
            if (list4 == null) list4 = new LinkedList<>();
            List<String> list5 = map5.get(info.packageName);
            if (list5 == null) list5 = new LinkedList<>();

            info.activityNames = list1;
            info.serviceNames = list2;
            info.receiveNames = list3;
            info.providerNames = list4;
            info.permissionNames = list5;
        }

        return list;
    }


    /**
     * 获取账户信息，设置中的账号里的APP的账号
     */
    public static List<AccountInfo> getAccountInfoList(Context context) {
        List<AccountInfo> list = new LinkedList<>();
        AccountManager accountManager = AccountManager.get(context);
        Account[] accounts = accountManager.getAccounts();
        for (Account ac : accounts) {
            AccountInfo info = new AccountInfo();
            info.name = ac.name;
            info.type = ac.type;
            list.add(info);
        }
        return list;
    }

}
