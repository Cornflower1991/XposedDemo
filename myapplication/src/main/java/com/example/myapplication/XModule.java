package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by appchina on 2016/5/26.
 */

public class XModule implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        //你想操作的应用的包名，这里为这个项目自身的包名
        if (loadPackageParam.packageName.equals("com.example.appchina.myapplication")) {
            Class clasz = loadPackageParam.classLoader.loadClass("com.example.appchina.myapplication.MainActivity");
            XposedHelpers.findAndHookMethod(clasz, "isEquals", int.class, new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(MethodHookParam methodHookParam) throws Throwable {
                    return null;
                }
            });

            XposedHelpers.findAndHookMethod("android.app.Application", loadPackageParam.classLoader, "onCreate", new XC_MethodHook(1000000) {

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    Context context = (Context) param.thisObject;


                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                }

            });
            if (loadPackageParam.appInfo == null ||
                    (loadPackageParam.appInfo.flags & (ApplicationInfo.FLAG_SYSTEM | ApplicationInfo.FLAG_UPDATED_SYSTEM_APP)) != 0) {
                return;
            } else if (loadPackageParam.isFirstApplication && !"packageName".equals(loadPackageParam.packageName)) {

            }
        }
    }
}


//
//
//    Class clasz = loadPackageParam.classLoader.loadClass("com.example.appchina.myapplication.MainActivity");
////hook MainActivity的 isEquls 方法
//XposedHelpers.findAndHookMethod(clasz, "isEquals", int.class, new XC_MethodHook() {
////这俩个方法任选其一就可以达到效果
////方法执行前进行的操作
//@Override
//protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//        Integer para1 = (Integer) param.args[0];   //获取参数1
//        String s1 = Integer.toString(para1);
//        Log.v("hook before param1:", s1);
//        XposedBridge.log("hook before param1:" + s1);
//        param.args[0] = 3;  //设置参数1，也就是将isEquls的参数恒定设为3
//        Log.v("hook", "before hook!");
//        XposedBridge.log("hook before  update param1:" +  param.args[0]);
//        }
//
//@Override
//protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//        boolean res = (boolean) param.getResult();
//        Log.v("hook after result :", res + "");
//        Integer para1 = (Integer) param.args[0];   //获取参数1
//        String s1 = Integer.toString(para1);
//        param.setResult(true);   //设置返回值，始终为true
//        XposedBridge.log("hook after result:true");
//        Log.v("hook param1:", s1);
//        }
//        });
