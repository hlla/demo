/*
 * Tencent is pleased to support the open source community by making
 * Tencent GT (Version 2.4 and subsequent versions) available.
 *
 * Notwithstanding anything to the contrary herein, any previous version
 * of Tencent GT shall not be subject to the license hereunder.
 * All right, title, and interest, including all intellectual property rights,
 * in and to the previous version of Tencent GT (including any and all copies thereof)
 * shall be owned and retained by Tencent and subject to the license under the
 * Tencent GT End User License Agreement (http://gt.qq.com/wp-content/EULA_EN.html).
 * 
 * Copyright (C) 2015 THL A29 Limited, a Tencent company. All rights reserved.
 * 
 * Licensed under the MIT License (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://opensource.org/licenses/MIT
 * 
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.tencent.wstt.gt.api.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.UUID;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;

import com.tencent.wstt.gt.GTApp;

/**
 * 设备信息工具类。
 */
public class DeviceUtils {

	/**
	 * 获取设备型号
	 *
	 * @return 设备型号
	 */
	public static String getDevModel() {
		return Build.MODEL;
	}

	public static String getHardware() {
		return Build.HARDWARE;
	}

	/**
	 * 获取SDK版本
	 *
	 * @return SDK版本
	 */
	public static String getSDKVersion() {
		String version = "";
		version = Build.VERSION.RELEASE;
		return version;
	}

	/**
	 * 获取手机IMEI
	 *
	 * @param context
	 *            应用程序的上下文环境
	 * @return 手机IMEI
	 */
	public static String getIMEI() {
		TelephonyManager tm = (TelephonyManager) GTApp.getContext()
				.getSystemService(Context.TELEPHONY_SERVICE);
		return tm.getDeviceId();
	}

	/**
	 * 获取设备dip(device independent pixels)
	 *
	 * @param mactivity
	 *            应用程序最前端的activity对象
	 * @return 设备dip
	 */
	public static int getDevDensityDpi(Activity mactivity) {
		DisplayMetrics metric = new DisplayMetrics();
		mactivity.getWindowManager().getDefaultDisplay().getMetrics(metric);
		int densityDpi = metric.densityDpi;
		return densityDpi;
	}

	/**
	 * 获取设备density
	 *
	 * @param mactivity
	 *            应用程序最前端的activity对象
	 * @return 设备density
	 */
	public static float getDevDensity(Activity mactivity) {
		DisplayMetrics metric = new DisplayMetrics();
		mactivity.getWindowManager().getDefaultDisplay().getMetrics(metric);
		float density = metric.density;
		return density;
	}

	public static float getDevDensity() {
		DisplayMetrics metric = new DisplayMetrics();
		metric = GTApp.getContext().getResources().getDisplayMetrics();
		float density = metric.density;
		return density;
	}

	/**
	 * 获取设备比例因子
	 *
	 * @param mactivity
	 *            应用程序最前端的activity对象
	 * @return 设备比例因子
	 */
	public static float getDevScaledDensity(Activity mactivity) {
		DisplayMetrics metric = new DisplayMetrics();
		mactivity.getWindowManager().getDefaultDisplay().getMetrics(metric);
		float scaledDensity = metric.scaledDensity;
		return scaledDensity;
	}

	/**
	 * 获取设备屏幕宽度
	 *
	 * @param context
	 *            应用程序的上下文环境
	 * @return 设备屏幕宽度
	 */
	public static int getDevWidth() {
		WindowManager wm = (WindowManager) GTApp.getContext().getSystemService(
				Context.WINDOW_SERVICE);
		int width = 480;
		if (null != wm.getDefaultDisplay()) {
			width = wm.getDefaultDisplay().getWidth();
		}
		return width;
	}

	/**
	 * 获取设备屏幕高度
	 *
	 * @param context
	 *            应用程序的上下文环境
	 * @return 设备屏幕高度
	 */
	public static int getDevHeight() {
		WindowManager wm = (WindowManager) GTApp.getContext().getSystemService(
				Context.WINDOW_SERVICE);
		int height = 800;
		if (null != wm.getDefaultDisplay()) {
			height = wm.getDefaultDisplay().getHeight();
		}
		return height;
	}

	/**
	 * 获取设备屏幕宽度
	 *
	 * @param mactivity
	 *            应用程序最前端的activity对象
	 * @return 设备屏幕宽度
	 */
	public static int getDisplayWidth(Activity mactivity) {
		return mactivity.getWindowManager().getDefaultDisplay().getWidth();
	}

	/**
	 * 获取设备屏幕高度
	 *
	 * @param mactivity
	 *            应用程序最前端的activity对象
	 * @return 设备屏幕高度
	 */
	public static int getDisplayHeight(Activity mactivity) {
		return mactivity.getWindowManager().getDefaultDisplay().getHeight();
	}

	@SuppressLint("NewApi")
	public static int getRealScreenHeightIncludeNavBar(Context context) {
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
			DisplayMetrics metrics = new DisplayMetrics();
			wm.getDefaultDisplay().getMetrics(metrics);
			wm.getDefaultDisplay().getRealMetrics(metrics);
			return metrics.heightPixels;
		} else {
			return getDisplayHeight(context);
		}
	}

	public static int getDisplayWidth(@NonNull Context context) {
		return getDisplaySize(context)[0];
	}

	public static int getDisplayHeight(@NonNull Context context) {
		return getDisplaySize(context)[1];
	}

	public static int[] getDisplaySize(@NonNull Context context) {
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		return new int[]{size.x, size.y};
	}

	/**
     * @param c context
     * @return height of navigation bar
     */
    public static int getNavBarHeight(Context c) {
		boolean hasMenuKey = ViewConfiguration.get(c).hasPermanentMenuKey();
		boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);

		if (!hasMenuKey && !hasBackKey) {
			//The device has a navigation bar
			Resources r = c.getResources();

			int ori = r.getConfiguration().orientation;
			int id;
			if (isTablet(c)) {
				id = r.getIdentifier(ori == Configuration.ORIENTATION_PORTRAIT ? "navigation_bar_height" : "navigation_bar_height_landscape", "dimen", "android");
			} else {
				id = r.getIdentifier(ori == Configuration.ORIENTATION_PORTRAIT ? "navigation_bar_height" : "navigation_bar_width", "dimen", "android");
			}

			if (id > 0) {
				return r.getDimensionPixelSize(id);
			}
		}
		return 0;
	}


	private static boolean isTablet(Context c) {
		return (c.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
				>= Configuration.SCREENLAYOUT_SIZE_LARGE;
	}

	/**
	 * 获取状态栏高度
	 *
	 * @param context
	 *            应用程序的上下文环境
	 * @return 状态栏高度
	 */
	public static int getStatusBarHeight(Context context) {
		Class<?> c = null;
		Object obj = null;
		Field field = null;
		int x = 0;
		int sbar = 0;
		try {
			c = Class.forName("com.android.internal.R$dimen");
			obj = c.newInstance();
			field = c.getField("status_bar_height");
			x = Integer.parseInt(field.get(obj).toString());
			sbar = context.getResources().getDimensionPixelSize(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sbar;
	}

	/**
	 * 获取手机本地IP
	 */
	public static void getLocalIP() {
		String ipaddress = "";
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface
					.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = en.nextElement();
				for (Enumeration<InetAddress> enumIpAddr = intf
						.getInetAddresses(); enumIpAddr.hasMoreElements();) {
					InetAddress inetAddress = enumIpAddr.nextElement();
					if (!inetAddress.isLoopbackAddress()) {
						ipaddress = ipaddress + ";"
								+ inetAddress.getHostAddress().toString();
					}
				}
			}
		} catch (SocketException ex) {
		}
	}

	/**
	 * 检测网络是否可用
	 *
	 * @param context
	 *            应用程序的上下文环境
	 * @return true 网络可用；false 网络不可用
	 */
	public static boolean checkNetWork() {
		boolean flag = false;
		ConnectivityManager cManager = (ConnectivityManager) GTApp.getContext()
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (cManager.getActiveNetworkInfo() != null)
			flag = cManager.getActiveNetworkInfo().isAvailable();
		return flag;
	}

	/**
	 * 获取设备UUID
	 *
	 * @param context
	 *            应用程序的上下文环境
	 * @return 设备UUID
	 */
	public static String getUUID() {
		Context context = GTApp.getContext();
		TelephonyManager tm = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		String tmDevice = "";
		String tmSerial = "";
		String androidId = "";
		tmDevice = tm.getDeviceId();
		tmSerial = tm.getSimSerialNumber();
		androidId = android.provider.Settings.Secure.getString(
				context.getContentResolver(),
				android.provider.Settings.Secure.ANDROID_ID);
		UUID deviceUuid;
		String uniqueId = "0";
		if (null != tmDevice) {
			if (null == tmSerial) {
				deviceUuid = new UUID(androidId.hashCode(),
						((long) tmDevice.hashCode() << 32));
			} else {
				deviceUuid = new UUID(androidId.hashCode(),
						((long) tmDevice.hashCode() << 32)
								| tmSerial.hashCode());
			}
			uniqueId = deviceUuid.toString();
		}
		return uniqueId;
	}

	public static boolean getMobileDataStatus(String getMobileDataEnabled) {
		ConnectivityManager cm = (ConnectivityManager) GTApp.getContext()
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		Class cmClass = cm.getClass();
		Class[] argClasses = null;
		Object[] argObjects = null;
		Boolean isOpen = false;
		try {
			Method method = cmClass.getMethod(getMobileDataEnabled, argClasses);
			isOpen = (Boolean) method.invoke(cm, argObjects);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return isOpen;
	}

	public static void setMobileDataStatus(boolean enable) {
		ConnectivityManager conMgr = (ConnectivityManager) GTApp.getContext()
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		Class<?> conMgrClass = null;
		Field iConMgrField = null;
		Object iConMgr = null;
		Class<?> iConMgrClass = null;
		Method setMobileDataEnableMethod = null;
		try {
			conMgrClass = Class.forName(conMgr.getClass().getName());
			iConMgrField = conMgrClass.getDeclaredField("mService");
			iConMgrField.setAccessible(true);
			iConMgr = iConMgrField.get(conMgr);
			iConMgrClass = Class.forName(iConMgr.getClass().getName());
			setMobileDataEnableMethod = iConMgrClass.getDeclaredMethod(
					"setMobileDataEnabled", Boolean.TYPE);
			setMobileDataEnableMethod.setAccessible(true);
			setMobileDataEnableMethod.invoke(iConMgr, enable);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static String getABI() {
		String CPU_ABI = Build.CPU_ABI;
		String CPU_ABI2 = Build.CPU_ABI2;



		return CPU_ABI + " " + CPU_ABI2;
	}
}
