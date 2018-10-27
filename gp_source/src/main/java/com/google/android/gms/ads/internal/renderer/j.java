package com.google.android.gms.ads.internal.renderer;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.ads.internal.q.a.a;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.v.b;
import com.google.android.gms.ads.internal.webview.i;

@a
@TargetApi(19)
public final class j
  extends g
{
  private boolean e = false;
  private PopupWindow f;
  private Object g = new Object();
  
  j(Context paramContext, b paramb, i parami, f paramf)
  {
    super(paramContext, paramb, parami, paramf);
  }
  
  private final void e()
  {
    synchronized (this.g)
    {
      this.e = true;
      Object localObject2 = this.c;
      if (!(localObject2 instanceof Activity)) {}
      while (!((Activity)localObject2).isDestroyed())
      {
        localObject2 = this.f;
        if (localObject2 != null)
        {
          if (((PopupWindow)localObject2).isShowing()) {
            this.f.dismiss();
          }
          this.f = null;
        }
        return;
      }
      this.f = null;
    }
  }
  
  protected final void a(int paramInt)
  {
    e();
    super.a(paramInt);
  }
  
  public final void b()
  {
    e();
    super.b();
  }
  
  protected final void d()
  {
    Window localWindow = null;
    ??? = this.c;
    if ((??? instanceof Activity)) {
      localWindow = ((Activity)???).getWindow();
    }
    if ((localWindow != null) && (localWindow.getDecorView() != null) && (!((Activity)this.c).isDestroyed()))
    {
      FrameLayout localFrameLayout = new FrameLayout(this.c);
      localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      localFrameLayout.addView(this.b.getView(), -1, -1);
      synchronized (this.g)
      {
        if (!this.e)
        {
          this.f = new PopupWindow(localFrameLayout, 1, 1, false);
          this.f.setOutsideTouchable(true);
          this.f.setClippingEnabled(false);
          e.b("Displaying the 1x1 popup off the screen.");
        }
      }
      try
      {
        this.f.showAtLocation(localWindow.getDecorView(), 0, -1, -1);
        return;
        return;
        localObject1 = finally;
        throw ((Throwable)localObject1);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.f = null;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/renderer/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */