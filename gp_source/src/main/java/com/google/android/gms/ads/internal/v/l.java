package com.google.android.gms.ads.internal.v;

import com.google.android.gms.ads.internal.q.a.a;
import java.math.BigInteger;

@a
public final class l
{
  private BigInteger a = BigInteger.ONE;
  private String b = "0";
  
  public final String a()
  {
    try
    {
      String str = this.a.toString();
      this.a = this.a.add(BigInteger.ONE);
      this.b = str;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String b()
  {
    try
    {
      String str = this.b;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/v/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */