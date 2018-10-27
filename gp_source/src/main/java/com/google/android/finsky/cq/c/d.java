package com.google.android.finsky.cq.c;

import android.support.v7.widget.fj;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public final class d
{
  public static fj a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new c((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new c(paramLayoutParams);
  }
  
  public static c a(int paramInt)
  {
    if (paramInt != 0) {
      return new c(-1, -2);
    }
    return new c(-2, -1);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cq/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */