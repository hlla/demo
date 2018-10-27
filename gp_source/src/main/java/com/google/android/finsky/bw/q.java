package com.google.android.finsky.bw;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

public abstract class q
  implements OnGlobalLayoutListener
{
  private View a;
  
  public q(View paramView)
  {
    this.a = paramView;
    this.a.getViewTreeObserver().addOnGlobalLayoutListener(this);
  }
  
  public final void a()
  {
    View localView = this.a;
    if (localView != null)
    {
      localView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      this.a = null;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */