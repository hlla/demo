package com.google.android.gms.ads.internal.js;

import android.content.Context;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.a.aa;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.x.m;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

@a
public final class b
  extends l
  implements h, n
{
  public o a;
  public final m b;
  
  public b(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    try
    {
      this.b = new m(paramContext, new g(this));
      this.b.setWillNotDraw(true);
      this.b.addJavascriptInterface(new f(this), "GoogleJsInterface");
      bt.A.e.a(paramContext, paramVersionInfoParcel.a, this.b.getSettings());
      this.c = this;
      return;
    }
    finally {}
  }
  
  public final void a()
  {
    this.b.destroy();
  }
  
  public final void a(o paramo)
  {
    this.a = paramo;
  }
  
  public final void a(String paramString)
  {
    b(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", new Object[] { paramString }));
  }
  
  public final void a(String paramString1, String paramString2)
  {
    i.a(this, paramString1, paramString2);
  }
  
  public final void a(String paramString, Map paramMap)
  {
    i.a(this, paramString, paramMap);
  }
  
  public final void a(String paramString, JSONObject paramJSONObject)
  {
    i.b(this, paramString, paramJSONObject);
  }
  
  public final av b()
  {
    return new aw(this);
  }
  
  public final void b(String paramString)
  {
    aa.b.execute(new c(this, paramString));
  }
  
  public final void b(String paramString, JSONObject paramJSONObject)
  {
    i.a(this, paramString, paramJSONObject);
  }
  
  public final void c(String paramString)
  {
    aa.b.execute(new d(this, paramString));
  }
  
  public final void d(String paramString)
  {
    aa.b.execute(new e(this, paramString));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/js/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */