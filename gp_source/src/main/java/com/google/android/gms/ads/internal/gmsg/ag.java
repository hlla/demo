package com.google.android.gms.ads.internal.gmsg;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.m.d;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.v.f;
import com.google.android.gms.ads.internal.zxxz.GADUrlException;
import com.google.android.gms.ads.internal.zxxz.aa;
import java.util.Map;

@a
public final class ag
  implements u
{
  private final com.google.android.gms.ads.internal.v a;
  private final d b;
  
  public ag(com.google.android.gms.ads.internal.v paramv, d paramd)
  {
    this.a = paramv;
    this.b = paramd;
  }
  
  private static String a(Context paramContext, aa paramaa, String paramString, View paramView, Activity paramActivity)
  {
    Object localObject = paramString;
    if (paramaa != null) {}
    try
    {
      Uri localUri = Uri.parse(paramString);
      localObject = localUri;
      if (paramaa.b(localUri))
      {
        String[] arrayOfString = aa.c;
        int j = arrayOfString.length;
        int i = 0;
        for (;;)
        {
          localObject = localUri;
          if (i >= j) {
            break label91;
          }
          localObject = arrayOfString[i];
          if (localUri.getPath().endsWith((String)localObject)) {
            break;
          }
          i += 1;
        }
        localObject = paramaa.a(localUri, paramContext, paramView, paramActivity);
      }
      label91:
      localObject = ((Uri)localObject).toString();
      return (String)localObject;
    }
    catch (Exception paramContext)
    {
      bt.A.i.a(paramContext, "OpenGmsgHandler.maybeAddClickSignalsToUrl");
      return paramString;
    }
    catch (GADUrlException paramContext) {}
    return paramString;
  }
  
  private final void a(boolean paramBoolean)
  {
    d locald = this.b;
    if (locald != null) {
      locald.a(paramBoolean);
    }
  }
  
  private static boolean a(Map paramMap)
  {
    return "1".equals(paramMap.get("custom_close"));
  }
  
  private static int b(Map paramMap)
  {
    paramMap = (String)paramMap.get("o");
    if (paramMap != null) {
      if (!"p".equalsIgnoreCase(paramMap))
      {
        if (!"l".equalsIgnoreCase(paramMap))
        {
          if ("c".equalsIgnoreCase(paramMap)) {
            return bt.A.g.c();
          }
        }
        else {
          return bt.A.g.a();
        }
      }
      else {
        return bt.A.g.b();
      }
    }
    return -1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/gmsg/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */