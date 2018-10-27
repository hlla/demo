package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.util.ag;
import com.google.android.gms.ads.internal.util.bj;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.util.n;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.c;

@com.google.android.gms.ads.internal.q.a.a
public final class s
  extends o
  implements b, c
{
  private ag c;
  private com.google.android.gms.ads.internal.util.c.a d;
  private final m e;
  private Context f;
  private t g;
  private final Object h = new Object();
  private VersionInfoParcel i;
  
  public s(Context paramContext, VersionInfoParcel paramVersionInfoParcel, com.google.android.gms.ads.internal.util.c.a parama, m paramm)
  {
    super(parama, paramm);
    this.f = paramContext;
    this.i = paramVersionInfoParcel;
    this.d = parama;
    this.e = paramm;
    this.g = new t(paramContext, bt.A.t.a(), this, this);
    this.g.r();
  }
  
  public final void a()
  {
    c();
  }
  
  public final void a(int paramInt)
  {
    e.b("Disconnected from remote ad request service.");
  }
  
  public final void a(ConnectionResult paramConnectionResult)
  {
    e.b("Cannot connect to remote service, fallback to local instance.");
    this.c = new r(this.f, this.d, this.e);
    this.c.c();
    paramConnectionResult = new Bundle();
    paramConnectionResult.putString("action", "gms_connection_failed_fallback_to_local");
    n localn = bt.A.e;
    n.b(this.f, this.i.a, "gmob-apps", paramConnectionResult, true);
  }
  
  public final void d()
  {
    synchronized (this.h)
    {
      if (this.g.k()) {
        this.g.f();
      }
      while (!this.g.l())
      {
        Binder.flushPendingCommands();
        return;
      }
    }
  }
  
  /* Error */
  public final z e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/google/android/gms/ads/internal/request/s:h	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 66	com/google/android/gms/ads/internal/request/s:g	Lcom/google/android/gms/ads/internal/request/t;
    //   11: invokevirtual 144	com/google/android/gms/ads/internal/request/t:d	()Lcom/google/android/gms/ads/internal/request/z;
    //   14: astore_2
    //   15: aload_1
    //   16: monitorexit
    //   17: aload_2
    //   18: areturn
    //   19: aload_1
    //   20: monitorexit
    //   21: aconst_null
    //   22: areturn
    //   23: astore_2
    //   24: aload_1
    //   25: monitorexit
    //   26: aload_2
    //   27: athrow
    //   28: astore_2
    //   29: goto -10 -> 19
    //   32: astore_2
    //   33: goto -14 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	s
    //   14	4	2	localz	z
    //   23	4	2	localObject2	Object
    //   28	1	2	localDeadObjectException	android.os.DeadObjectException
    //   32	1	2	localIllegalStateException	IllegalStateException
    // Exception table:
    //   from	to	target	type
    //   7	15	23	finally
    //   15	17	23	finally
    //   19	21	23	finally
    //   24	26	23	finally
    //   7	15	28	android/os/DeadObjectException
    //   7	15	32	java/lang/IllegalStateException
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */