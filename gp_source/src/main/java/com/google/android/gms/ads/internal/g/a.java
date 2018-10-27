package com.google.android.gms.ads.internal.g;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.request.a.l;
import com.google.android.gms.ads.internal.v.f;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

@com.google.android.gms.ads.internal.q.a.a
public final class a
{
  public String a = null;
  public Context b = null;
  public String c;
  public Map d;
  
  public a(Context paramContext, String paramString)
  {
    this.b = paramContext;
    this.a = paramString;
    this.c = ((String)com.google.android.gms.ads.internal.f.n.N.a());
    this.d = new LinkedHashMap();
    this.d.put("s", "gmob_sdk");
    this.d.put("v", "3");
    this.d.put("os", Build.VERSION.RELEASE);
    this.d.put("sdk", Build.VERSION.SDK);
    paramString = this.d;
    Object localObject = bt.A.e;
    paramString.put("device", com.google.android.gms.ads.internal.util.n.b());
    localObject = this.d;
    if (paramContext.getApplicationContext() != null) {}
    for (paramString = paramContext.getApplicationContext().getPackageName();; paramString = paramContext.getPackageName())
    {
      ((Map)localObject).put("app", paramString);
      paramString = this.d;
      localObject = bt.A.e;
      if (!com.google.android.gms.ads.internal.util.n.l(paramContext)) {}
      for (paramContext = "0";; paramContext = "1")
      {
        paramString.put("is_lite_sdk", paramContext);
        paramContext = bt.A.p.a(this.b);
        try
        {
          paramContext.get();
          this.d.put("network_coarse", Integer.toString(((l)paramContext.get()).u));
          this.d.put("network_fine", Integer.toString(((l)paramContext.get()).v));
          return;
        }
        catch (Exception paramContext)
        {
          bt.A.i.a(paramContext, "CsiConfiguration.CsiConfiguration");
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */