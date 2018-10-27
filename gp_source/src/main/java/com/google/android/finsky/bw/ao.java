package com.google.android.finsky.bw;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.play.utils.j;

public final class ao
{
  public static void a(View paramView, Rect paramRect, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = (paramInt1 - paramView.getHeight()) / 2;
    paramInt1 = (paramInt2 - paramView.getWidth()) / 2;
    paramView.getHitRect(paramRect);
    if (paramInt1 > 0) {}
    for (paramInt1 = -paramInt1;; paramInt1 = 0)
    {
      paramInt2 = i;
      if (j > 0) {
        paramInt2 = -j;
      }
      paramRect.inset(paramInt1, paramInt2);
      return;
    }
  }
  
  public static void a(View paramView, Rect paramRect1, Rect paramRect2)
  {
    int i = paramView.getResources().getDimensionPixelSize(2131166014);
    Object localObject = paramView.getParent();
    if (!(localObject instanceof View)) {
      FinskyLog.c("Parent not a View; bailing out...", new Object[0]);
    }
    do
    {
      return;
      localObject = (View)localObject;
      if ((paramView.getVisibility() != 0) || ((paramView.getWidth() >= i) && (paramView.getHeight() >= i)))
      {
        paramRect1.setEmpty();
        paramRect2.setEmpty();
        ((View)localObject).setTouchDelegate(null);
        return;
      }
      a(paramView, paramRect1, i, i);
    } while (paramRect1.equals(paramRect2));
    paramRect2.set(paramRect1);
    ((View)localObject).setTouchDelegate(new j(paramRect1, paramView));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */