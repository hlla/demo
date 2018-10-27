package com.google.android.finsky.cq.c;

import android.support.v4.g.w;
import android.util.SparseIntArray;

public final class g
{
  public static final String a = new String("UNKNOWN");
  public final SparseIntArray b = new SparseIntArray();
  public final SparseIntArray c = new SparseIntArray();
  public final SparseIntArray d = new SparseIntArray();
  public final SparseIntArray e = new SparseIntArray();
  public final w f = new w();
  public final SparseIntArray g = new SparseIntArray();
  public final SparseIntArray h = new SparseIntArray();
  
  public static Object a(Class paramClass)
  {
    if (paramClass.isInstance(a)) {
      return paramClass.cast(a);
    }
    Integer localInteger = Integer.valueOf(-2);
    if (paramClass.isInstance(localInteger)) {
      return paramClass.cast(localInteger);
    }
    throw new RuntimeException("Unsupported type.");
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cq/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */