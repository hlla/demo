package com.google.ads;

import com.google.android.gms.ads.g;

@Deprecated
public final class c
{
  public static final c a;
  public static final c b = new c(468, 60);
  public static final c c = new c(728, 90);
  public static final c d;
  public static final c e = new c(160, 600);
  public static final c f = new c(-1, -2);
  public final g g;
  
  static
  {
    a = new c(320, 50);
    d = new c(300, 250);
  }
  
  private c(int paramInt1, int paramInt2)
  {
    this(new g(paramInt1, paramInt2));
  }
  
  public c(g paramg)
  {
    this.g = paramg;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof c))
    {
      paramObject = (c)paramObject;
      return this.g.equals(((c)paramObject).g);
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.g.hashCode();
  }
  
  public final String toString()
  {
    return this.g.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/ads/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */