package com.google.android.gms.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.ads.internal.f.c;
import com.google.android.gms.ads.internal.f.n;
import com.google.android.gms.ads.internal.q.a.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

@a
public final class bs
{
  private Context a;
  private final BroadcastReceiver b = new bt(this);
  private boolean c = false;
  private boolean d;
  private final Map e = new WeakHashMap();
  
  public final void a(Context paramContext)
  {
    try
    {
      if (!this.c)
      {
        this.a = paramContext.getApplicationContext();
        if (this.a == null) {
          this.a = paramContext;
        }
        n.a(this.a);
        this.d = ((Boolean)n.ar.a()).booleanValue();
        paramContext = new IntentFilter();
        paramContext.addAction("android.intent.action.SCREEN_ON");
        paramContext.addAction("android.intent.action.SCREEN_OFF");
        paramContext.addAction("android.intent.action.USER_PRESENT");
        this.a.registerReceiver(this.b, paramContext);
        this.c = true;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void a(Context paramContext, BroadcastReceiver paramBroadcastReceiver)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 63	com/google/android/gms/ads/internal/util/bs:d	Z
    //   6: ifeq +17 -> 23
    //   9: aload_0
    //   10: getfield 25	com/google/android/gms/ads/internal/util/bs:e	Ljava/util/Map;
    //   13: aload_2
    //   14: invokeinterface 87 2 0
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_1
    //   24: aload_2
    //   25: invokevirtual 91	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   28: goto -8 -> 20
    //   31: astore_1
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	bs
    //   0	36	1	paramContext	Context
    //   0	36	2	paramBroadcastReceiver	BroadcastReceiver
    // Exception table:
    //   from	to	target	type
    //   2	20	31	finally
    //   23	28	31	finally
  }
  
  /* Error */
  public final void a(Context paramContext, BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 63	com/google/android/gms/ads/internal/util/bs:d	Z
    //   6: ifeq +18 -> 24
    //   9: aload_0
    //   10: getfield 25	com/google/android/gms/ads/internal/util/bs:e	Ljava/util/Map;
    //   13: aload_2
    //   14: aload_3
    //   15: invokeinterface 96 3 0
    //   20: pop
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_1
    //   25: aload_2
    //   26: aload_3
    //   27: invokevirtual 80	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   30: pop
    //   31: goto -10 -> 21
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	bs
    //   0	39	1	paramContext	Context
    //   0	39	2	paramBroadcastReceiver	BroadcastReceiver
    //   0	39	3	paramIntentFilter	IntentFilter
    // Exception table:
    //   from	to	target	type
    //   2	21	34	finally
    //   24	31	34	finally
  }
  
  final void a(Context paramContext, Intent paramIntent)
  {
    try
    {
      Iterator localIterator = this.e.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((IntentFilter)localEntry.getValue()).hasAction(paramIntent.getAction())) {
          ((BroadcastReceiver)localEntry.getKey()).onReceive(paramContext, paramIntent);
        }
      }
    }
    finally {}
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */