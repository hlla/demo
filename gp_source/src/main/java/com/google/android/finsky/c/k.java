package com.google.android.finsky.c;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.google.android.finsky.dp.a;

final class k
  implements OnTouchListener
{
  public final a a;
  
  k(a parama)
  {
    this.a = parama;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent != null) {
      this.a.a(paramView.getContext(), new l(this, paramMotionEvent));
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */