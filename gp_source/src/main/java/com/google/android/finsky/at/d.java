package com.google.android.finsky.at;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Parcelable;
import android.support.v4.app.cg;
import android.text.TextUtils;
import com.android.volley.NoConnectionError;
import com.android.volley.VolleyError;
import com.android.volley.w;
import com.android.volley.x;
import com.google.android.finsky.bs.a;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.dfemodel.g;
import com.google.android.finsky.dfemodel.v;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.ag;
import com.google.android.finsky.e.z;
import com.google.android.finsky.utils.FinskyLog;
import java.util.concurrent.TimeUnit;

public final class d
  implements w, x, com.google.android.finsky.api.y, v
{
  public boolean a;
  public af b;
  public final ag c;
  public final com.google.android.finsky.e.y d = new com.google.android.finsky.e.y(913, this.l);
  private final Context e;
  private com.google.android.finsky.dfemodel.e f;
  private BroadcastReceiver g;
  private Intent h;
  private String i;
  private final com.google.android.finsky.api.i j;
  private BroadcastReceiver k;
  private final com.google.android.finsky.e.y l = new com.google.android.finsky.e.y(912, null);
  private boolean m;
  
  static
  {
    TimeUnit.DAYS.toMillis(3L);
  }
  
  public d(Context paramContext, com.google.android.finsky.api.i parami, ag paramag)
  {
    this.e = paramContext;
    this.j = parami;
    this.c = paramag;
  }
  
  public static boolean b(VolleyError paramVolleyError)
  {
    return paramVolleyError instanceof NoConnectionError;
  }
  
  private final void h()
  {
    if (this.g == null)
    {
      this.g = new e(this);
      this.e.registerReceiver(this.g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }
  }
  
  private final void i()
  {
    BroadcastReceiver localBroadcastReceiver = this.g;
    if (localBroadcastReceiver != null)
    {
      this.e.unregisterReceiver(localBroadcastReceiver);
      this.g = null;
    }
  }
  
  private final void j()
  {
    SharedPreferences localSharedPreferences = this.e.getSharedPreferences("notification_on_reconnection", 0);
    localSharedPreferences.edit().putString("saved_dfe_account", this.i).apply();
    Object localObject = this.h;
    if (localObject != null) {}
    for (localObject = ((Intent)localObject).toUri(0);; localObject = null)
    {
      localSharedPreferences.edit().putString("saved_notification_request", (String)localObject).apply();
      if (this.b != null)
      {
        localObject = new Intent();
        this.b.a((Intent)localObject);
        localSharedPreferences.edit().putString("saved_logging_context", ((Intent)localObject).toUri(0)).apply();
      }
      localSharedPreferences.edit().putLong("saved_timestamp", com.google.android.finsky.utils.i.a()).apply();
      return;
    }
  }
  
  private final void k()
  {
    if (this.h != null)
    {
      localObject1 = this.f;
      if ((localObject1 == null) || (((com.google.android.finsky.dfemodel.e)localObject1).c() == null) || (this.f.c().a.I == null)) {
        break label289;
      }
    }
    label289:
    for (Object localObject1 = this.e.getString(a.am.intValue(), new Object[] { this.f.c().a.I });; localObject1 = this.e.getString(a.al.intValue()))
    {
      localObject1 = new cg(this.e).a(2131231086).a((CharSequence)localObject1).b(this.e.getString(a.ak.intValue()));
      Object localObject2 = this.h;
      Intent localIntent = (Intent)((Intent)localObject2).clone();
      localIntent.setPackage(this.e.getPackageName());
      localIntent.putExtra("reconnection_original_intent", (Parcelable)localObject2);
      localIntent.putExtra("notification_on_reconnection", true);
      ((cg)localObject1).e = PendingIntent.getActivity(this.e, 0, localIntent, 0);
      localObject2 = new Intent("notification_delete");
      ((Intent)localObject2).setPackage(this.e.getPackageName());
      localObject2 = PendingIntent.getBroadcast(this.e, 0, (Intent)localObject2, 0);
      if (this.k == null) {
        this.k = new f(this);
      }
      this.e.registerReceiver(this.k, new IntentFilter("notification_delete"));
      localObject1 = ((cg)localObject1).a((PendingIntent)localObject2);
      ((NotificationManager)this.e.getSystemService("notification")).notify("notification_on_reconnection", 1, ((cg)localObject1).b());
      this.b.a(new z().b(this.l));
      return;
    }
  }
  
  private final void l()
  {
    ((NotificationManager)this.e.getSystemService("notification")).cancel("notification_on_reconnection", 1);
    BroadcastReceiver localBroadcastReceiver = this.k;
    if (localBroadcastReceiver != null)
    {
      this.e.unregisterReceiver(localBroadcastReceiver);
      this.k = null;
    }
  }
  
  private final com.google.android.finsky.api.d m()
  {
    com.google.android.finsky.api.d locald = this.j.a(this.i);
    if (locald == null) {
      FinskyLog.d("Finsky API is null for account %s", new Object[] { this.i });
    }
    return locald;
  }
  
  public final void a()
  {
    this.m = false;
  }
  
  public final void a(VolleyError paramVolleyError)
  {
    FinskyLog.d("Volley error on DeeplinkDisconnectionManager: %s", new Object[] { paramVolleyError.getMessage() });
    paramVolleyError = this.h;
    if (paramVolleyError != null) {
      FinskyLog.d("   request url was %s", new Object[] { paramVolleyError.getDataString() });
    }
    this.m = false;
  }
  
  /* Error */
  public final void a(af paramaf, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ldc 98
    //   5: iconst_0
    //   6: invokevirtual 312	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   9: istore_3
    //   10: iload_3
    //   11: ifne +58 -> 69
    //   14: aload_0
    //   15: getfield 123	com/google/android/finsky/at/d:h	Landroid/content/Intent;
    //   18: ifnull +85 -> 103
    //   21: aload_2
    //   22: ldc -38
    //   24: invokevirtual 316	android/content/Intent:hasExtra	(Ljava/lang/String;)Z
    //   27: ifeq +73 -> 100
    //   30: aload_2
    //   31: ldc -38
    //   33: invokevirtual 320	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   36: checkcast 125	android/content/Intent
    //   39: astore_2
    //   40: aload_0
    //   41: getfield 123	com/google/android/finsky/at/d:h	Landroid/content/Intent;
    //   44: iconst_0
    //   45: invokevirtual 129	android/content/Intent:toUri	(I)Ljava/lang/String;
    //   48: astore 4
    //   50: aload_2
    //   51: ifnull +44 -> 95
    //   54: aload_2
    //   55: iconst_0
    //   56: invokevirtual 129	android/content/Intent:toUri	(I)Ljava/lang/String;
    //   59: astore_2
    //   60: aload 4
    //   62: aload_2
    //   63: invokestatic 326	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   66: ifeq +26 -> 92
    //   69: iload_3
    //   70: ifne +18 -> 88
    //   73: aload_1
    //   74: new 328	com/google/android/finsky/e/d
    //   77: dup
    //   78: sipush 548
    //   81: invokespecial 331	com/google/android/finsky/e/d:<init>	(I)V
    //   84: invokevirtual 334	com/google/android/finsky/e/af:a	(Lcom/google/android/finsky/e/d;)Lcom/google/android/finsky/e/af;
    //   87: pop
    //   88: aload_0
    //   89: invokevirtual 336	com/google/android/finsky/at/d:c	()V
    //   92: aload_0
    //   93: monitorexit
    //   94: return
    //   95: aconst_null
    //   96: astore_2
    //   97: goto -37 -> 60
    //   100: goto -60 -> 40
    //   103: aload_2
    //   104: ifnonnull -12 -> 92
    //   107: goto -38 -> 69
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	d
    //   0	115	1	paramaf	af
    //   0	115	2	paramIntent	Intent
    //   9	61	3	bool	boolean
    //   48	13	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	10	110	finally
    //   14	40	110	finally
    //   40	50	110	finally
    //   54	60	110	finally
    //   60	69	110	finally
    //   73	88	110	finally
    //   88	92	110	finally
  }
  
  public final void a(String paramString)
  {
    try
    {
      com.google.android.finsky.dfemodel.e locale = this.f;
      if ((locale != null) && (locale.c() != null) && (TextUtils.equals(paramString, this.f.c().a.f))) {
        c();
      }
      return;
    }
    finally {}
  }
  
  public final void a(String paramString, af paramaf, Intent paramIntent)
  {
    if (paramIntent != null) {}
    try
    {
      c();
      this.i = paramString;
      this.h = paramIntent;
      this.b = paramaf;
      h();
      j();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void b()
  {
    try
    {
      g();
      if (this.h != null)
      {
        h();
        if (this.a) {
          f();
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final void c()
  {
    try
    {
      l();
      this.i = null;
      this.h = null;
      this.b = null;
      this.f = null;
      j();
      i();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final void d()
  {
    try
    {
      l();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void e()
  {
    this.f.p();
    k();
    this.m = false;
  }
  
  final void f()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.h;
        if (localObject1 != null)
        {
          if ((localObject1 != null) && (!this.m))
          {
            if (this.f != null) {
              k();
            }
          }
          else {
            return;
          }
          localObject1 = m();
          if (localObject1 == null) {
            continue;
          }
          this.m = true;
          ((com.google.android.finsky.api.d)localObject1).a(this.h.getDataString(), null, this, this, this);
          continue;
        }
        i();
      }
      finally {}
    }
  }
  
  final void g()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.e.getSystemService("connectivity")).getActiveNetworkInfo();
    boolean bool;
    if (localNetworkInfo != null) {
      if (localNetworkInfo.isConnectedOrConnecting()) {
        bool = true;
      }
    }
    for (;;)
    {
      this.a = bool;
      return;
      bool = false;
      continue;
      bool = false;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/at/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */