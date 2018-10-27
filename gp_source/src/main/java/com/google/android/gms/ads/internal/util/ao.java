package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.a.v;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@a
public final class ao
{
  public String a = "";
  private String b = "";
  private boolean c = false;
  private final Object d = new Object();
  private String e = "";
  
  private final String a(Context paramContext)
  {
    synchronized (this.d)
    {
      if (!TextUtils.isEmpty(this.e)) {}
      do
      {
        paramContext = this.e;
        return paramContext;
        localn = bt.A.e;
        this.e = n.c(paramContext, "debug_signals_id.txt");
      } while (!TextUtils.isEmpty(this.e));
      n localn = bt.A.e;
      this.e = n.a();
      localn = bt.A.e;
      n.b(paramContext, "debug_signals_id.txt", this.e);
    }
  }
  
  protected static void a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!(paramContext instanceof Activity))
    {
      e.d("Can not create dialog without Activity Context");
      return;
    }
    n.a.post(new ap(paramContext, paramString, paramBoolean1, paramBoolean2));
  }
  
  private final Uri b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = Uri.parse(paramString1).buildUpon();
    paramString1.appendQueryParameter("linkedDeviceId", a(paramContext));
    paramString1.appendQueryParameter("adSlotPath", paramString2);
    paramString1.appendQueryParameter("afmaVersion", paramString3);
    return paramString1.build();
  }
  
  private static String d(Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("User-Agent", bt.A.e.b(paramContext, paramString2));
    new ax(paramContext);
    paramString2 = ax.a(0, paramString1, localHashMap, null);
    try
    {
      paramContext = (String)paramString2.get(((Integer)com.google.android.gms.ads.internal.f.n.V.a()).intValue(), TimeUnit.MILLISECONDS);
      return paramContext;
    }
    catch (TimeoutException localTimeoutException)
    {
      paramContext = String.valueOf(paramString1);
      if (paramContext.length() == 0)
      {
        paramContext = new String("Timeout while retriving a response from: ");
        e.c(paramContext, localTimeoutException);
        paramString2.cancel(true);
        return null;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        paramContext = String.valueOf(paramString1);
        if (paramContext.length() != 0) {
          break;
        }
        paramContext = new String("Interrupted while retriving a response from: ");
        e.c(paramContext, localInterruptedException);
        paramString2.cancel(true);
      }
    }
    catch (Exception paramString2)
    {
      label109:
      label134:
      paramContext = String.valueOf(paramString1);
      if (paramContext.length() != 0) {}
    }
    for (paramContext = new String("Error retriving a response from: ");; paramContext = "Error retriving a response from: ".concat(paramContext))
    {
      e.c(paramContext, paramString2);
      break label109;
      paramContext = "Timeout while retriving a response from: ".concat(paramContext);
      break;
      paramContext = "Interrupted while retriving a response from: ".concat(paramContext);
      break label134;
    }
  }
  
  public final String a()
  {
    synchronized (this.d)
    {
      String str = this.b;
      return str;
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramString3 = b(paramContext, (String)com.google.android.gms.ads.internal.f.n.Q.a(), paramString3, paramString1).buildUpon();
    paramString3.appendQueryParameter("debugData", paramString2);
    paramString2 = bt.A.e;
    n.a(paramContext, paramString1, paramString3.build().toString());
  }
  
  /* Error */
  final boolean a(Context paramContext, String arg2, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: aload_1
    //   3: getstatic 215	com/google/android/gms/ads/internal/f/n:aF	Lcom/google/android/gms/ads/internal/f/c;
    //   6: invokevirtual 150	com/google/android/gms/ads/internal/f/c:a	()Ljava/lang/Object;
    //   9: checkcast 170	java/lang/String
    //   12: aload_2
    //   13: aload_3
    //   14: invokespecial 202	com/google/android/gms/ads/internal/util/ao:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    //   17: invokevirtual 207	android/net/Uri:toString	()Ljava/lang/String;
    //   20: aload_3
    //   21: invokestatic 217	com/google/android/gms/ads/internal/util/ao:d	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   24: astore_1
    //   25: aload_1
    //   26: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   29: ifeq +10 -> 39
    //   32: ldc -37
    //   34: invokestatic 221	com/google/android/gms/ads/internal/util/e:b	(Ljava/lang/String;)V
    //   37: iconst_0
    //   38: ireturn
    //   39: aload_1
    //   40: invokevirtual 224	java/lang/String:trim	()Ljava/lang/String;
    //   43: astore_1
    //   44: new 226	org/json/JSONObject
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 227	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   52: astore_2
    //   53: aload_2
    //   54: ldc -27
    //   56: invokevirtual 232	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore_1
    //   60: aload_0
    //   61: aload_2
    //   62: ldc -22
    //   64: invokevirtual 232	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: putfield 29	com/google/android/gms/ads/internal/util/ao:a	Ljava/lang/String;
    //   70: aload_0
    //   71: getfield 19	com/google/android/gms/ads/internal/util/ao:d	Ljava/lang/Object;
    //   74: astore_2
    //   75: aload_2
    //   76: monitorenter
    //   77: aload_0
    //   78: aload_1
    //   79: putfield 25	com/google/android/gms/ads/internal/util/ao:b	Ljava/lang/String;
    //   82: aload_2
    //   83: monitorexit
    //   84: iconst_1
    //   85: ireturn
    //   86: astore_1
    //   87: ldc -20
    //   89: aload_1
    //   90: invokestatic 238	com/google/android/gms/ads/internal/util/e:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   93: iconst_0
    //   94: ireturn
    //   95: astore_1
    //   96: aload_2
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	ao
    //   0	100	1	paramContext	Context
    //   0	100	3	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   44	70	86	org/json/JSONException
    //   77	84	95	finally
    //   96	98	95	finally
  }
  
  public final boolean b()
  {
    synchronized (this.d)
    {
      boolean bool = this.c;
      return bool;
    }
  }
  
  final boolean b(Context arg1, String paramString1, String paramString2)
  {
    ??? = d(???, b(???, (String)com.google.android.gms.ads.internal.f.n.U.a(), paramString1, paramString2).toString(), paramString2);
    if (TextUtils.isEmpty(???))
    {
      e.b("Not linked for debug signals.");
      return false;
    }
    ??? = ???.trim();
    try
    {
      ??? = new JSONObject(???).optString("debug_mode");
      boolean bool = "1".equals(???);
      synchronized (this.d)
      {
        this.c = bool;
        return bool;
      }
      return false;
    }
    catch (JSONException ???)
    {
      e.e("Fail to get debug mode response json.", ???);
    }
  }
  
  final void c(Context paramContext, String paramString1, String paramString2)
  {
    n localn = bt.A.e;
    n.a(paramContext, b(paramContext, (String)com.google.android.gms.ads.internal.f.n.R.a(), paramString1, paramString2));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */