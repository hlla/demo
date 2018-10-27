package com.google.android.finsky.dn.a.a;

import android.content.Context;
import com.google.android.finsky.dn.a.h;

public final class k
  extends a
{
  private final com.google.android.finsky.dn.a.i a;
  
  public k(p paramp, com.google.android.gms.phenotype.core.common.c paramc, g paramg, Context paramContext, String paramString1, String[] paramArrayOfString, int paramInt, String paramString2, byte[] paramArrayOfByte, com.google.android.finsky.dn.a.i parami, com.google.android.finsky.e.i parami1, com.google.android.finsky.bo.c paramc1)
  {
    super(paramp, paramc, paramContext, paramString1, paramArrayOfString, paramInt, paramString2, paramArrayOfByte, parami1, paramc1);
    this.a = parami;
  }
  
  protected final int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1000;
    case 4: 
      return 2503;
    case 3: 
      return 2502;
    case 2: 
      return 2501;
    case 1: 
      return 2500;
    }
    return 0;
  }
  
  protected final String a(String paramString)
  {
    paramString = this.a.b(paramString);
    if (paramString != null) {
      return paramString.e;
    }
    return null;
  }
  
  protected final boolean a(h paramh, com.google.android.play.b.a.c paramc, String paramString)
  {
    return this.a.a(paramh, paramc, paramString);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dn/a/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */