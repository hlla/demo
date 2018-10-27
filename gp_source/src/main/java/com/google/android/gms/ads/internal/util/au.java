package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.q.a.a;
import java.util.List;

@a
public final class au
{
  public final int[] a;
  public final double[] b;
  public final double[] c;
  public final String[] d;
  public int e;
  
  public au(aw paramaw)
  {
    int i = paramaw.a.size();
    this.d = ((String[])paramaw.c.toArray(new String[i]));
    this.b = a(paramaw.a);
    this.c = a(paramaw.b);
    this.a = new int[i];
    this.e = 0;
  }
  
  private static double[] a(List paramList)
  {
    double[] arrayOfDouble = new double[paramList.size()];
    int i = 0;
    while (i < arrayOfDouble.length)
    {
      arrayOfDouble[i] = ((Double)paramList.get(i)).doubleValue();
      i += 1;
    }
    return arrayOfDouble;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/util/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */