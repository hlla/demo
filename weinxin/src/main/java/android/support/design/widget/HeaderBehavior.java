package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.o;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v4.widget.q;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

abstract class HeaderBehavior<V extends View>
  extends ViewOffsetBehavior<V>
{
  private VelocityTracker fk;
  private int fl = -1;
  private Runnable iA;
  public q iB;
  private boolean iC;
  private int iD;
  private int iE = -1;
  
  public HeaderBehavior() {}
  
  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void ae()
  {
    if (this.fk == null) {
      this.fk = VelocityTracker.obtain();
    }
  }
  
  int H()
  {
    return I();
  }
  
  int a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = I();
    int j = 0;
    int i = j;
    if (paramInt2 != 0)
    {
      i = j;
      if (k >= paramInt2)
      {
        i = j;
        if (k <= paramInt3)
        {
          paramInt1 = n.b(paramInt1, paramInt2, paramInt3);
          i = j;
          if (k != paramInt1)
          {
            f(paramInt1);
            i = k - paramInt1;
          }
        }
      }
    }
    return i;
  }
  
  void a(CoordinatorLayout paramCoordinatorLayout, V paramV) {}
  
  final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt, float paramFloat)
  {
    if (this.iA != null)
    {
      paramV.removeCallbacks(this.iA);
      this.iA = null;
    }
    if (this.iB == null) {
      this.iB = q.a(paramV.getContext(), null);
    }
    this.iB.a(I(), 0, Math.round(paramFloat), 0, 0, paramInt, 0);
    if (this.iB.computeScrollOffset())
    {
      this.iA = new a(paramCoordinatorLayout, paramV);
      z.a(paramV, this.iA);
      return true;
    }
    a(paramCoordinatorLayout, paramV);
    return false;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (this.iE < 0) {
      this.iE = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    if ((paramMotionEvent.getAction() == 2) && (this.iC)) {
      return true;
    }
    switch (o.d(paramMotionEvent))
    {
    }
    for (;;)
    {
      if (this.fk != null) {
        this.fk.addMovement(paramMotionEvent);
      }
      return this.iC;
      this.iC = false;
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((d(paramV)) && (paramCoordinatorLayout.b(paramV, i, j)))
      {
        this.iD = j;
        this.fl = o.c(paramMotionEvent, 0);
        ae();
        continue;
        i = this.fl;
        if (i != -1)
        {
          i = o.b(paramMotionEvent, i);
          if (i != -1)
          {
            i = (int)o.e(paramMotionEvent, i);
            if (Math.abs(i - this.iD) > this.iE)
            {
              this.iC = true;
              this.iD = i;
              continue;
              this.iC = false;
              this.fl = -1;
              if (this.fk != null)
              {
                this.fk.recycle();
                this.fk = null;
              }
            }
          }
        }
      }
    }
  }
  
  final int b(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramCoordinatorLayout, paramV, H() - paramInt1, paramInt2, paramInt3);
  }
  
  int b(V paramV)
  {
    return paramV.getHeight();
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (this.iE < 0) {
      this.iE = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    switch (o.d(paramMotionEvent))
    {
    }
    for (;;)
    {
      if (this.fk != null) {
        this.fk.addMovement(paramMotionEvent);
      }
      boolean bool1 = true;
      do
      {
        do
        {
          do
          {
            return bool1;
            i = (int)paramMotionEvent.getX();
            j = (int)paramMotionEvent.getY();
            bool1 = bool2;
          } while (!paramCoordinatorLayout.b(paramV, i, j));
          bool1 = bool2;
        } while (!d(paramV));
        this.iD = j;
        this.fl = o.c(paramMotionEvent, 0);
        ae();
        break;
        i = o.b(paramMotionEvent, this.fl);
        bool1 = bool2;
      } while (i == -1);
      int k = (int)o.e(paramMotionEvent, i);
      int j = this.iD - k;
      int i = j;
      if (!this.iC)
      {
        i = j;
        if (Math.abs(j) > this.iE)
        {
          this.iC = true;
          if (j <= 0) {
            break label260;
          }
        }
      }
      label260:
      for (i = j - this.iE; this.iC; i = j + this.iE)
      {
        this.iD = k;
        b(paramCoordinatorLayout, paramV, i, c(paramV), 0);
        break;
      }
      if (this.fk != null)
      {
        this.fk.addMovement(paramMotionEvent);
        this.fk.computeCurrentVelocity(1000);
        float f = y.b(this.fk, this.fl);
        a(paramCoordinatorLayout, paramV, -b(paramV), f);
      }
      this.iC = false;
      this.fl = -1;
      if (this.fk != null)
      {
        this.fk.recycle();
        this.fk = null;
      }
    }
  }
  
  final int c(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    return a(paramCoordinatorLayout, paramV, paramInt, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
  
  int c(V paramV)
  {
    return -paramV.getHeight();
  }
  
  boolean d(V paramV)
  {
    return false;
  }
  
  private final class a
    implements Runnable
  {
    private final CoordinatorLayout iF;
    private final V iG;
    
    a(V paramV)
    {
      this.iF = paramV;
      View localView;
      this.iG = localView;
    }
    
    public final void run()
    {
      if ((this.iG != null) && (HeaderBehavior.this.iB != null))
      {
        if (HeaderBehavior.this.iB.computeScrollOffset())
        {
          HeaderBehavior.this.c(this.iF, this.iG, HeaderBehavior.this.iB.getCurrY());
          z.a(this.iG, this);
        }
      }
      else {
        return;
      }
      HeaderBehavior.this.a(this.iF, this.iG);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/HeaderBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */