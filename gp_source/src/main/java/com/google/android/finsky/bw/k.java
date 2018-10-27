package com.google.android.finsky.bw;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.widget.TextView;
import com.google.android.finsky.ba.a;
import com.google.android.finsky.bo.c;
import com.google.android.finsky.bo.f;

public final class k
{
  public final c a;
  private float b;
  private final Context c;
  private final a d;
  
  public k(Context paramContext, c paramc, a parama)
  {
    this.c = paramContext;
    this.a = paramc;
    this.d = parama;
  }
  
  public static int a(int paramInt, Resources paramResources)
  {
    return (int)(paramInt * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  public static boolean j(Resources paramResources)
  {
    return (paramResources.getBoolean(2131034157)) && (!paramResources.getBoolean(2131034151));
  }
  
  public static int k(Resources paramResources)
  {
    return a(paramResources.getConfiguration().screenWidthDp, paramResources);
  }
  
  public static int l(Resources paramResources)
  {
    return a(paramResources.getConfiguration().screenHeightDp, paramResources);
  }
  
  public static boolean m(Resources paramResources)
  {
    int i = k(paramResources);
    return l(paramResources) > i;
  }
  
  public final float a()
  {
    if ((this.d.d) && (!this.a.cY().a(12652928L))) {
      return 0.0F;
    }
    return 0.25F;
  }
  
  public final int a(Context paramContext, int paramInt)
  {
    if (this.b == 0.0F) {
      this.b = paramContext.getResources().getDisplayMetrics().density;
    }
    return Math.round(paramInt / this.b);
  }
  
  public final int a(Resources paramResources)
  {
    if (!this.a.cY().a(12652928L)) {
      return paramResources.getDimensionPixelSize(2131165849);
    }
    return Math.max(paramResources.getDimensionPixelSize(2131165850), (k(paramResources) - paramResources.getDimensionPixelSize(2131165865)) / 2);
  }
  
  public final int a(Resources paramResources, boolean paramBoolean)
  {
    int j = k(paramResources);
    if (!paramBoolean) {}
    for (int i = g(paramResources);; i = j) {
      return (j - Math.min(j, i)) / 2;
    }
  }
  
  public final void a(Resources paramResources, TextView paramTextView)
  {
    if (!this.a.cY().a(12652928L)) {}
    for (int i = 2131165861;; i = 2131165862)
    {
      paramTextView.setTextSize(0, paramResources.getDimensionPixelSize(i));
      return;
    }
  }
  
  public final void a(Resources paramResources, TextView... paramVarArgs)
  {
    if (!this.a.cY().a(12652928L)) {}
    for (int i = 2131165953;; i = 2131165954)
    {
      int j = paramResources.getDimensionPixelSize(i);
      int k = paramVarArgs.length;
      i = 0;
      while (i < k)
      {
        paramVarArgs[i].setTextSize(0, j);
        i += 1;
      }
    }
  }
  
  public final int b()
  {
    return this.c.getResources().getDisplayMetrics().widthPixels;
  }
  
  public final int b(Resources paramResources)
  {
    if (this.a.cY().a(12652928L)) {
      return paramResources.getDimensionPixelSize(2131165869);
    }
    return paramResources.getDimensionPixelSize(2131165868);
  }
  
  public final void b(Resources paramResources, TextView paramTextView)
  {
    if (!this.a.cY().a(12652928L)) {}
    for (int i = 2131165857;; i = 2131165858)
    {
      paramTextView.setTextSize(0, paramResources.getDimensionPixelSize(i));
      return;
    }
  }
  
  public final int c()
  {
    return this.c.getResources().getDisplayMetrics().heightPixels;
  }
  
  public final int c(Resources paramResources)
  {
    if (this.a.cY().a(12652928L)) {
      return paramResources.getDimensionPixelSize(2131165848);
    }
    return paramResources.getDimensionPixelSize(2131165847);
  }
  
  public final int d(Resources paramResources)
  {
    if (!this.a.cY().a(12652928L)) {}
    for (int i = 2131165845;; i = 2131165846) {
      return paramResources.getDimensionPixelSize(i);
    }
  }
  
  public final int e(Resources paramResources)
  {
    if (this.a.cY().a(12652928L)) {
      return paramResources.getDimensionPixelSize(2131165951);
    }
    return paramResources.getDimensionPixelSize(2131165950);
  }
  
  public final int f(Resources paramResources)
  {
    if (!this.a.cY().a(12652928L)) {}
    for (int i = 2131165944;; i = 2131165945) {
      return paramResources.getDimensionPixelSize(i);
    }
  }
  
  public final int g(Resources paramResources)
  {
    int i = k(paramResources);
    int j = a(paramResources);
    return i - (j + j);
  }
  
  public final int h(Resources paramResources)
  {
    if (paramResources.getBoolean(2131034135)) {
      return Math.min((int)g(paramResources) / paramResources.getDimensionPixelSize(2131166428), 5);
    }
    return paramResources.getInteger(2131492906);
  }
  
  public final int i(Resources paramResources)
  {
    if (!this.a.cY().a(12652928L)) {}
    for (int i = 2131165839;; i = 2131165840) {
      return paramResources.getDimensionPixelSize(i);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */