package com.google.android.finsky.bw;

import android.view.View;

public final class aq
{
  private final int[] a = new int[2];
  
  public final int a(View paramView)
  {
    paramView.getLocationInWindow(this.a);
    return this.a[0] + paramView.getWidth() / 2;
  }
  
  public final boolean a(View paramView1, View paramView2)
  {
    int i = c(paramView1);
    int j = d(paramView1);
    int k = b(paramView2);
    if (k < i) {}
    while (k > j) {
      return false;
    }
    return true;
  }
  
  public final int b(View paramView)
  {
    paramView.getLocationInWindow(this.a);
    return this.a[1] + paramView.getHeight() / 2;
  }
  
  public final int c(View paramView)
  {
    paramView.getLocationInWindow(this.a);
    return this.a[1];
  }
  
  public final int d(View paramView)
  {
    return c(paramView) + paramView.getHeight();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */