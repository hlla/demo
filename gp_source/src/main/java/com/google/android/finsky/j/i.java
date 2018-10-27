package com.google.android.finsky.j;

import android.content.Context;
import android.content.res.Resources;
import java.util.Comparator;

public enum i
{
  public final Comparator g;
  public boolean h;
  public final int i;
  public final int j;
  public final int k;
  private final int m;
  
  private i(int paramInt2, int paramInt3, Comparator paramComparator, int paramInt4, boolean paramBoolean, int paramInt5)
  {
    this.k = paramInt2;
    this.m = paramInt3;
    this.g = paramComparator;
    this.j = paramInt4;
    this.h = paramBoolean;
    this.i = paramInt5;
  }
  
  public static i a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < values().length) && (values()[paramInt].h)) {
      return values()[paramInt];
    }
    return a;
  }
  
  public final String a(Context paramContext)
  {
    return paramContext.getResources().getString(this.m);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/j/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */