package com.tencent.map.geolocation.internal;

import android.util.Pair;

public abstract interface TencentHttpClient
{
  public abstract Pair<byte[], String> postSync(String paramString, byte[] paramArrayOfByte);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/map/geolocation/internal/TencentHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */