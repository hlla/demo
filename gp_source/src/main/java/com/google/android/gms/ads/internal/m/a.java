package com.google.android.gms.ads.internal.m;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.webview.i;
import java.util.Map;

@com.google.android.gms.ads.internal.q.a.a
public final class a
  extends m
{
  public String a;
  public String c;
  public long d;
  public String e;
  public final Context f;
  private final Map g;
  public long p_;
  
  public a(i parami, Map paramMap)
  {
    super(parami, "createCalendarEvent");
    this.g = paramMap;
    this.f = parami.getActivityContext();
    this.a = c("description");
    this.e = c("summary");
    this.d = d("start_ticks");
    this.p_ = d("end_ticks");
    this.c = c("location");
  }
  
  private final String c(String paramString)
  {
    if (!TextUtils.isEmpty((CharSequence)this.g.get(paramString))) {
      return (String)this.g.get(paramString);
    }
    return "";
  }
  
  private final long d(String paramString)
  {
    paramString = (String)this.g.get(paramString);
    if (paramString != null) {}
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return -1L;
    return -1L;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/m/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */