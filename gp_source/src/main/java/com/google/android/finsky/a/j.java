package com.google.android.finsky.a;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ac;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.google.android.finsky.drawer.a;
import com.google.android.finsky.frameworkviews.ad;
import com.google.android.finsky.utils.FinskyLog;

public final class j
{
  public ad a;
  public PopupWindow.OnDismissListener b;
  private final Handler c = new Handler(Looper.getMainLooper());
  
  public final void a(a parama, String paramString)
  {
    if (!parama.f()) {
      throw new IllegalStateException("showAccountTooltip called without an open drawer");
    }
    if (!parama.j()) {
      parama.i();
    }
    a(parama, paramString, 0);
  }
  
  final void a(a parama, String paramString, int paramInt)
  {
    View localView = parama.getProfileInfoView();
    if (localView != null) {}
    for (localView = localView.findViewById(2131429525);; localView = null)
    {
      if ((localView != null) && (!ac.I(localView)))
      {
        new l(this, localView, parama, paramString, paramInt);
        return;
      }
      if (!parama.j()) {}
      while (localView == null)
      {
        if (paramInt >= 4) {
          break;
        }
        this.c.postDelayed(new k(this, parama, paramString, paramInt), 1000L);
        return;
      }
      if (localView != null)
      {
        parama = (TextView)LayoutInflater.from(localView.getContext()).inflate(2131625123, null);
        parama.setText(paramString);
        parama = new ad(parama, localView, 3);
        parama.a();
        this.a = parama;
        parama = this.b;
        if (parama != null) {
          this.a.a(parama);
        }
        parama = new Rect();
        localView.getGlobalVisibleRect(parama);
        this.a.a(parama);
        return;
      }
      FinskyLog.e("The account list view is null!", new Object[0]);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */