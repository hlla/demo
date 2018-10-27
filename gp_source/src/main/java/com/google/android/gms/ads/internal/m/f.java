package com.google.android.gms.ads.internal.m;

import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.webview.i;
import java.util.Map;

@a
public final class f
{
  public final i a;
  public final boolean b;
  public final String c;
  
  public f(i parami, Map paramMap)
  {
    this.a = parami;
    this.c = ((String)paramMap.get("forceOrientation"));
    if (paramMap.containsKey("allowOrientationChange"))
    {
      this.b = Boolean.parseBoolean((String)paramMap.get("allowOrientationChange"));
      return;
    }
    this.b = true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/m/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */