package com.google.android.finsky.be;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import com.google.android.finsky.billing.common.PurchaseParams;
import com.google.android.finsky.billing.common.q;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.e.af;
import com.google.android.finsky.installqueue.InstallRequest;
import com.google.android.finsky.installqueue.g;
import com.google.android.finsky.library.r;
import com.google.android.finsky.utils.FinskyLog;
import java.util.List;

public class a
  extends com.google.android.finsky.billing.lightpurchase.f
{
  public boolean e;
  private final int f;
  private final Context g;
  private final String h;
  private final b i;
  private final com.google.android.finsky.bo.f j;
  private final com.google.android.finsky.cl.b k;
  private af l;
  
  public a(com.google.android.finsky.accounts.c paramc, Context paramContext, int paramInt, String paramString, b paramb, com.google.android.finsky.av.a parama, com.google.android.finsky.bo.f paramf, com.google.android.finsky.cl.b paramb1, com.google.android.finsky.library.c paramc1, r paramr, g paramg, Bundle paramBundle)
  {
    super(parama, paramc1, paramr, paramg, paramc, paramBundle);
    this.g = paramContext;
    this.f = paramInt;
    this.h = paramString;
    this.i = paramb;
    this.j = paramf;
    this.k = paramb1;
    if (paramBundle != null)
    {
      this.e = paramBundle.getBoolean("BottomSheetAutoInstallDependencyHelper.acquire_pending");
      return;
    }
    this.e = false;
  }
  
  /* Error */
  public final void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	com/google/android/finsky/be/a:e	Z
    //   6: ifeq +17 -> 23
    //   9: iload_1
    //   10: iconst_m1
    //   11: if_icmpeq +15 -> 26
    //   14: aload_0
    //   15: invokevirtual 54	com/google/android/finsky/billing/lightpurchase/f:b	()V
    //   18: aload_0
    //   19: iconst_0
    //   20: putfield 47	com/google/android/finsky/be/a:e	Z
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: invokevirtual 56	com/google/android/finsky/billing/lightpurchase/f:a	()V
    //   30: goto -12 -> 18
    //   33: astore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_2
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	a
    //   0	38	1	paramInt	int
    //   33	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	33	finally
    //   14	18	33	finally
    //   18	23	33	finally
    //   26	30	33	finally
  }
  
  protected final void a(Account paramAccount, List paramList)
  {
    for (;;)
    {
      try
      {
        if (this.e)
        {
          FinskyLog.d("Acquire already pending", new Object[0]);
          b();
          return;
        }
        if (paramList.size() > 1)
        {
          b();
          FinskyLog.e("Expect to acquire only one dependency", new Object[0]);
          continue;
        }
        if (!paramList.isEmpty()) {
          break label72;
        }
      }
      finally {}
      a();
      continue;
      label72:
      paramList = (Document)paramList.get(0);
      Object localObject = new q();
      ((q)localObject).i = 2;
      ((q)localObject).k = paramList.c();
      ((q)localObject).l = paramList.a.s;
      localObject = ((q)localObject).a(paramList.i(), paramList.a.I, this.h, this.f).a();
      paramAccount = this.k.a(paramAccount, this.g, this.j, this.l, paramList, (PurchaseParams)localObject, null, true, 0);
      this.i.a(paramAccount);
      this.e = true;
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putBoolean("BottomSheetAutoInstallDependencyHelper.acquire_pending", this.e);
  }
  
  public final void a(InstallRequest paramInstallRequest, af paramaf)
  {
    this.l = paramaf;
    super.a(paramInstallRequest);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/be/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */