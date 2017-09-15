package com.tencent.mm.kernel.b;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.bn.a;
import com.tencent.mm.bn.a.a;
import com.tencent.mm.booter.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.tinker.loader.app.ApplicationLifeCycle;

public final class f
  extends e
{
  public c gKs;
  public MMApplicationLike gZq;
  public a<ApplicationLifeCycle> gZr;
  public com.tencent.mm.compatible.loader.e mProfileCompat;
  
  public f(String paramString, Application paramApplication, MMApplicationLike paramMMApplicationLike)
  {
    super(paramString, paramApplication);
    GMTrace.i(13518812217344L, 100723);
    this.gZr = new a();
    aa.Pq(paramString);
    this.gZq = paramMMApplicationLike;
    GMTrace.o(13518812217344L, 100723);
  }
  
  public final String getPackageName()
  {
    GMTrace.i(18789005524992L, 139989);
    String str = aa.getPackageName();
    GMTrace.o(18789005524992L, 139989);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/kernel/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */