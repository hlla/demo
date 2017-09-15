package android.support.design.widget;

import android.support.v4.view.o;
import android.support.v4.view.z;
import android.support.v4.widget.u;
import android.support.v4.widget.u.a;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class s<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  public u fc;
  private boolean fd;
  private final u.a fp = new u.a()
  {
    private int fl = -1;
    private int jN;
    
    public final void a(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      boolean bool = true;
      this.fl = -1;
      int j = paramAnonymousView.getWidth();
      int i;
      if (paramAnonymousFloat1 != 0.0F) {
        if (z.J(paramAnonymousView) == 1)
        {
          i = 1;
          if (s.this.jJ != 2) {
            break label114;
          }
          i = 1;
          label45:
          if (i == 0) {
            break label290;
          }
          if (paramAnonymousView.getLeft() >= this.jN) {
            break label278;
          }
          i = this.jN - j;
          label70:
          if (!s.this.fc.q(i, paramAnonymousView.getTop())) {
            break label302;
          }
          z.a(paramAnonymousView, new s.b(s.this, paramAnonymousView, bool));
        }
      }
      label114:
      label278:
      label290:
      label302:
      while ((!bool) || (s.this.jG == null))
      {
        return;
        i = 0;
        break;
        if (s.this.jJ == 0)
        {
          if (i != 0)
          {
            if (paramAnonymousFloat1 < 0.0F)
            {
              i = 1;
              break label45;
            }
            i = 0;
            break label45;
          }
          if (paramAnonymousFloat1 > 0.0F)
          {
            i = 1;
            break label45;
          }
          i = 0;
          break label45;
        }
        if (s.this.jJ == 1)
        {
          if (i != 0)
          {
            if (paramAnonymousFloat1 > 0.0F)
            {
              i = 1;
              break label45;
            }
            i = 0;
            break label45;
          }
          if (paramAnonymousFloat1 < 0.0F)
          {
            i = 1;
            break label45;
          }
          i = 0;
          break label45;
          i = paramAnonymousView.getLeft();
          int k = this.jN;
          int m = Math.round(paramAnonymousView.getWidth() * s.this.jK);
          if (Math.abs(i - k) >= m)
          {
            i = 1;
            break label45;
          }
          i = 0;
          break label45;
        }
        i = 0;
        break label45;
        i = this.jN + j;
        break label70;
        i = this.jN;
        bool = false;
        break label70;
      }
      s.this.jG.onDismiss(paramAnonymousView);
    }
    
    public final void a(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      float f1 = this.jN + paramAnonymousView.getWidth() * s.this.jL;
      float f2 = this.jN + paramAnonymousView.getWidth() * s.this.jM;
      if (paramAnonymousInt1 <= f1)
      {
        z.d(paramAnonymousView, 1.0F);
        return;
      }
      if (paramAnonymousInt1 >= f2)
      {
        z.d(paramAnonymousView, 0.0F);
        return;
      }
      z.d(paramAnonymousView, s.l(1.0F - s.c(f1, f2, paramAnonymousInt1)));
    }
    
    public final boolean b(View paramAnonymousView, int paramAnonymousInt)
    {
      return (this.fl == -1) && (s.this.r(paramAnonymousView));
    }
    
    public final int c(View paramAnonymousView, int paramAnonymousInt)
    {
      return paramAnonymousView.getTop();
    }
    
    public final int d(View paramAnonymousView, int paramAnonymousInt)
    {
      int i;
      int j;
      if (z.J(paramAnonymousView) == 1)
      {
        i = 1;
        if (s.this.jJ != 0) {
          break label72;
        }
        if (i == 0) {
          break label53;
        }
        i = this.jN - paramAnonymousView.getWidth();
        j = this.jN;
      }
      for (;;)
      {
        return s.d(i, paramAnonymousInt, j);
        i = 0;
        break;
        label53:
        i = this.jN;
        j = this.jN + paramAnonymousView.getWidth();
        continue;
        label72:
        if (s.this.jJ == 1)
        {
          if (i != 0)
          {
            i = this.jN;
            j = this.jN + paramAnonymousView.getWidth();
          }
          else
          {
            i = this.jN - paramAnonymousView.getWidth();
            j = this.jN;
          }
        }
        else
        {
          i = this.jN - paramAnonymousView.getWidth();
          j = this.jN + paramAnonymousView.getWidth();
        }
      }
    }
    
    public final void f(View paramAnonymousView, int paramAnonymousInt)
    {
      this.fl = paramAnonymousInt;
      this.jN = paramAnonymousView.getLeft();
      paramAnonymousView = paramAnonymousView.getParent();
      if (paramAnonymousView != null) {
        paramAnonymousView.requestDisallowInterceptTouchEvent(true);
      }
    }
    
    public final void j(int paramAnonymousInt)
    {
      if (s.this.jG != null) {
        s.this.jG.w(paramAnonymousInt);
      }
    }
    
    public final int s(View paramAnonymousView)
    {
      return paramAnonymousView.getWidth();
    }
  };
  public a jG;
  private float jH = 0.0F;
  private boolean jI;
  public int jJ = 2;
  public float jK = 0.5F;
  public float jL = 0.0F;
  public float jM = 0.5F;
  
  static float c(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }
  
  public static int d(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }
  
  public static float l(float paramFloat)
  {
    return Math.min(Math.max(0.0F, paramFloat), 1.0F);
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    switch (o.d(paramMotionEvent))
    {
    case 2: 
    default: 
      if (paramCoordinatorLayout.b(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        break;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.fd = bool;
      do
      {
        if (!this.fd) {
          break;
        }
        return false;
      } while (!this.fd);
      this.fd = false;
      return false;
    }
    if (this.fc == null) {
      if (!this.jI) {
        break label129;
      }
    }
    label129:
    for (paramCoordinatorLayout = u.a(paramCoordinatorLayout, this.jH, this.fp);; paramCoordinatorLayout = u.a(paramCoordinatorLayout, this.fp))
    {
      this.fc = paramCoordinatorLayout;
      return this.fc.j(paramMotionEvent);
    }
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.fc != null)
    {
      this.fc.k(paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public boolean r(View paramView)
  {
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void onDismiss(View paramView);
    
    public abstract void w(int paramInt);
  }
  
  private final class b
    implements Runnable
  {
    private final boolean jP;
    private final View mView;
    
    b(View paramView, boolean paramBoolean)
    {
      this.mView = paramView;
      this.jP = paramBoolean;
    }
    
    public final void run()
    {
      if ((s.this.fc != null) && (s.this.fc.cH())) {
        z.a(this.mView, this);
      }
      while ((!this.jP) || (s.this.jG == null)) {
        return;
      }
      s.this.jG.onDismiss(this.mView);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */