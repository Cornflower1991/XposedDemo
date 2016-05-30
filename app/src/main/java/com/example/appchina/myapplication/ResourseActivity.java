package com.example.appchina.myapplication;

import android.content.res.XResources;

import de.robv.android.xposed.IXposedHookZygoteInit;

/**
 * Created by appchina on 2016/5/30.
 */

public class ResourseActivity implements IXposedHookZygoteInit {
    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {
        XResources.setSystemWideReplacement("android", "bool", "config_unplugTurnsOnScreen", false);
    }
}
