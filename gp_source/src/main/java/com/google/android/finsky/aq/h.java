package com.google.android.finsky.aq;

import android.content.Context;
import java.util.concurrent.Executors;

public final class h
  implements g
{
  private final Context a;
  private final com.google.android.finsky.bo.c b;
  private final com.google.android.finsky.af.d c;
  
  public h(Context paramContext, com.google.android.finsky.af.d paramd, com.google.android.finsky.bo.c paramc)
  {
    this.a = paramContext;
    this.c = paramd;
    this.b = paramc;
  }
  
  public final a a(String paramString, int paramInt, e[] paramArrayOfe)
  {
    com.google.android.finsky.af.c localc = this.c.a(Executors.newSingleThreadExecutor(new i(paramString)));
    return new a(this.a, localc, paramString, paramInt, paramArrayOfe);
  }
  
  public final f a(a parama, String paramString, com.google.android.finsky.utils.a.a parama1, com.google.android.finsky.utils.a.a parama2, com.google.android.finsky.utils.a.a parama3, int paramInt, com.google.android.finsky.utils.a.a parama4)
  {
    return new j(this.b, parama.b, parama, paramString, parama1, parama2, parama3, paramInt, ((Long)com.google.android.finsky.ag.d.bn.b()).longValue(), parama4);
  }
  
  public final f a(String paramString, e parame, com.google.android.finsky.utils.a.a parama1, com.google.android.finsky.utils.a.a parama2, com.google.android.finsky.utils.a.a parama3, com.google.android.finsky.utils.a.a parama4)
  {
    paramString = a(paramString, 1, new e[] { parame });
    return new j(this.b, paramString.b, paramString, parame.b, parama1, parama2, parama3, 0, ((Long)com.google.android.finsky.ag.d.bn.b()).longValue(), parama4);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/aq/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */