package com.tencent.map.geolocation.internal;

import org.eclipse.jdt.annotation.NonNull;

public abstract interface TencentLog
{
  public static final String LOGNAME = "txwatchdog";
  public static final String PREFIX = "txwatchdog_";
  
  public abstract String getDirString();
  
  public abstract void println(String paramString1, int paramInt, @NonNull String paramString2);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/map/geolocation/internal/TencentLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */