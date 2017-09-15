package com.c.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.util.Base64;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  int aJA = 0;
  int aJB = 0;
  int aJC = 0;
  int aJD = 0;
  private String aJE = "203";
  private final WifiManager aJq;
  private final LocationManager aJr;
  final SensorManager aJs;
  final PackageManager aJt;
  PackageInfo aJu;
  String aJv;
  String aJw;
  String aJx;
  private int aJy = 0;
  private int aJz = 0;
  String imei;
  final Context mContext;
  private String version = "2.0.1";
  String versionName;
  
  public f(Context paramContext)
  {
    this.mContext = paramContext;
    this.aJq = ((WifiManager)this.mContext.getSystemService("wifi"));
    this.aJr = ((LocationManager)this.mContext.getSystemService("location"));
    this.aJs = ((SensorManager)this.mContext.getSystemService("sensor"));
    this.aJt = this.mContext.getPackageManager();
    this.aJu = new PackageInfo();
    try
    {
      this.aJu = this.aJt.getPackageInfo(this.mContext.getPackageName(), 0);
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
  
  private static String ay(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private boolean nj()
  {
    try
    {
      boolean bool = this.aJr.isProviderEnabled("gps");
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  @SuppressLint({"NewApi"})
  private boolean nk()
  {
    boolean bool1 = false;
    boolean bool2;
    if (this.aJq != null)
    {
      bool2 = this.aJq.isWifiEnabled();
      bool1 = bool2;
      if (!bool2) {
        bool1 = bool2;
      }
    }
    try
    {
      if (Build.VERSION.SDK_INT >= 18) {
        bool1 = this.aJq.isScanAlwaysAvailable();
      }
      return bool1;
    }
    catch (Error localError)
    {
      return bool2;
    }
    catch (Exception localException) {}
    return bool2;
  }
  
  public final String k(byte[] paramArrayOfByte)
  {
    int j = 1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("version", this.version);
    localHashMap.put("app_name", ay(this.versionName));
    if (this.aJv != null)
    {
      localHashMap.put("app_label", ay(Base64.encodeToString(this.aJv.getBytes(), 0)));
      if (!nj()) {
        break label301;
      }
      i = 1;
      label76:
      this.aJz = i;
      if ((this.aJq == null) || (!this.aJq.isWifiEnabled())) {
        break label306;
      }
      i = 1;
      label100:
      if ((i | nk()) == 0) {
        break label311;
      }
    }
    label301:
    label306:
    label311:
    for (int i = j;; i = 0)
    {
      this.aJy = i;
      localHashMap.put("chips", Integer.toBinaryString(this.aJD | 0x0 | this.aJC << 1 | this.aJB << 2 | this.aJA << 3 | this.aJz << 4 | this.aJy << 5));
      localHashMap.put("source", this.aJE);
      localHashMap.put("query", new String(paramArrayOfByte));
      try
      {
        paramArrayOfByte = new JSONObject(localHashMap);
        localHashMap = new HashMap();
        localHashMap.put("model", ay(Base64.encodeToString(this.aJw.getBytes(), 0)));
        localHashMap.put("version", ay(this.aJx));
        localHashMap.put("imei", ay(this.imei));
        paramArrayOfByte = paramArrayOfByte.put("attribute", new JSONObject(localHashMap)).toString();
        return paramArrayOfByte;
      }
      catch (JSONException paramArrayOfByte) {}
      localHashMap.put("app_label", "");
      break;
      i = 0;
      break label76;
      i = 0;
      break label100;
    }
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/c/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */