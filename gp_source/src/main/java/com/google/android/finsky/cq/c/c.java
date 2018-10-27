package com.google.android.finsky.cq.c;

import android.content.Context;
import android.support.v7.widget.fj;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.google.android.finsky.cq.a.a;

public final class c
  extends fj
  implements a
{
  public int e;
  public int f = 0;
  public int g;
  public int h;
  public int i;
  public int j;
  public String k;
  public int l;
  
  public c(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public c(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public c(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public c(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString, int paramInt6)
  {
    this.i = paramInt1;
    this.l = paramInt2;
    this.j = paramInt3;
    this.g = paramInt4;
    this.h = paramInt5;
    this.k = paramString;
    this.e = paramInt6;
  }
  
  public final boolean a()
  {
    return (this.g == 0) || (this.j == 0);
  }
  
  public final boolean b()
  {
    return (this.g == 0) || (this.j + this.l == this.i);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cq/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */