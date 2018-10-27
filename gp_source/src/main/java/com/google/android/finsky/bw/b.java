package com.google.android.finsky.bw;

import android.os.Build.VERSION;
import android.support.v4.view.a.a;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;

public final class b
  extends android.support.v4.view.b
{
  private final int b = 16;
  private final String c;
  
  public b(String paramString)
  {
    this.c = paramString;
  }
  
  public final void a(View paramView, a parama)
  {
    super.a(paramView, parama);
    paramView = new android.support.v4.view.a.b(this.b, this.c);
    if (Build.VERSION.SDK_INT >= 21) {
      parama.a.addAction((AccessibilityAction)paramView.e);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */