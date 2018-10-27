package android.support.v7.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.a.a.a;
import android.util.DisplayMetrics;

class h
  extends Drawable
  implements Drawable.Callback
{
  public int a = -1;
  private int b = 255;
  private Runnable c;
  private j d;
  private Drawable e;
  private k f;
  private long g;
  private long h;
  private boolean i;
  private Rect j;
  private Drawable k;
  private boolean l;
  
  static int a(Resources paramResources, int paramInt)
  {
    if (paramResources != null) {
      paramInt = paramResources.getDisplayMetrics().densityDpi;
    }
    for (;;)
    {
      int m = paramInt;
      if (paramInt == 0) {
        m = 160;
      }
      return m;
    }
  }
  
  private final void a(Drawable paramDrawable)
  {
    if (this.d == null) {
      this.d = new j();
    }
    Object localObject1 = this.d;
    ((j)localObject1).a = paramDrawable.getCallback();
    paramDrawable.setCallback((Drawable.Callback)localObject1);
    for (;;)
    {
      try
      {
        if (this.f.r <= 0) {
          break label262;
        }
        localObject1 = this.f;
        if (((k)localObject1).t) {
          break label251;
        }
        if (((k)localObject1).u) {
          break label240;
        }
        localObject1 = this.f;
        if (((k)localObject1).v) {
          break label229;
        }
        paramDrawable.setVisible(isVisible(), true);
        paramDrawable.setDither(this.f.p);
        paramDrawable.setState(getState());
        paramDrawable.setLevel(getLevel());
        paramDrawable.setBounds(getBounds());
        if (Build.VERSION.SDK_INT < 23)
        {
          if (Build.VERSION.SDK_INT < 19)
          {
            localObject1 = this.j;
            if ((Build.VERSION.SDK_INT >= 21) && (localObject1 != null)) {
              paramDrawable.setHotspotBounds(((Rect)localObject1).left, ((Rect)localObject1).top, ((Rect)localObject1).right, ((Rect)localObject1).bottom);
            }
            return;
          }
          paramDrawable.setAutoMirrored(this.f.b);
          continue;
        }
        paramDrawable.setLayoutDirection(getLayoutDirection());
      }
      finally
      {
        paramDrawable.setCallback(this.d.a());
      }
      continue;
      label229:
      a.a(paramDrawable, ((k)localObject2).B);
      continue;
      label240:
      a.a(paramDrawable, ((k)localObject2).A);
      continue;
      label251:
      paramDrawable.setColorFilter(((k)localObject2).i);
      continue;
      label262:
      if (this.i) {
        paramDrawable.setAlpha(this.b);
      }
    }
  }
  
  final void a(Resources paramResources)
  {
    this.f.a(paramResources);
  }
  
  protected void a(k paramk)
  {
    this.f = paramk;
    int m = this.a;
    if (m >= 0)
    {
      this.e = paramk.b(m);
      paramk = this.e;
      if (paramk != null) {
        a(paramk);
      }
    }
    this.k = null;
  }
  
  final void a(boolean paramBoolean)
  {
    this.i = true;
    long l1 = SystemClock.uptimeMillis();
    Drawable localDrawable = this.e;
    long l2;
    int m;
    if (localDrawable != null)
    {
      l2 = this.g;
      if (l2 != 0L) {
        if (l2 > l1)
        {
          localDrawable.setAlpha((255 - (int)((l2 - l1) * 255L) / this.f.r) * this.b / 255);
          m = 1;
        }
      }
    }
    for (;;)
    {
      localDrawable = this.k;
      int n;
      if (localDrawable != null)
      {
        l2 = this.h;
        n = m;
        if (l2 != 0L)
        {
          if (l2 <= l1) {
            break label171;
          }
          localDrawable.setAlpha((int)((l2 - l1) * 255L) / this.f.s * this.b / 255);
          n = 1;
        }
      }
      for (;;)
      {
        if ((paramBoolean) && (n != 0)) {
          scheduleSelf(this.c, 16L + l1);
        }
        return;
        label171:
        localDrawable.setVisible(false, false);
        this.k = null;
        this.h = 0L;
        n = m;
        continue;
        this.h = 0L;
        n = m;
      }
      localDrawable.setAlpha(this.b);
      this.g = 0L;
      m = 0;
      continue;
      m = 0;
      continue;
      this.g = 0L;
      m = 0;
    }
  }
  
  final boolean a(int paramInt)
  {
    if (paramInt != this.a)
    {
      long l1 = SystemClock.uptimeMillis();
      Object localObject;
      if (this.f.s > 0)
      {
        localObject = this.k;
        if (localObject != null) {
          ((Drawable)localObject).setVisible(false, false);
        }
        localObject = this.e;
        if (localObject != null)
        {
          this.k = ((Drawable)localObject);
          this.h = (this.f.s + l1);
        }
      }
      for (;;)
      {
        if (paramInt >= 0)
        {
          localObject = this.f;
          if (paramInt < ((k)localObject).x)
          {
            localObject = ((k)localObject).b(paramInt);
            this.e = ((Drawable)localObject);
            this.a = paramInt;
            if (localObject != null)
            {
              paramInt = this.f.r;
              if (paramInt > 0) {
                this.g = (l1 + paramInt);
              }
              a((Drawable)localObject);
            }
          }
        }
        for (;;)
        {
          if ((this.g != 0L) || (this.h != 0L))
          {
            localObject = this.c;
            if (localObject != null) {
              break label193;
            }
            this.c = new i(this);
          }
          for (;;)
          {
            a(true);
            invalidateSelf();
            return true;
            label193:
            unscheduleSelf((Runnable)localObject);
          }
          this.e = null;
          this.a = -1;
        }
        this.k = null;
        this.h = 0L;
        continue;
        localObject = this.e;
        if (localObject != null) {
          ((Drawable)localObject).setVisible(false, false);
        }
      }
    }
    return false;
  }
  
  public void applyTheme(Resources.Theme paramTheme)
  {
    k localk = this.f;
    if (paramTheme != null)
    {
      localk.c();
      int n = localk.x;
      Drawable[] arrayOfDrawable = localk.q;
      int m = 0;
      if (m < n)
      {
        Drawable localDrawable = arrayOfDrawable[m];
        if (localDrawable == null) {}
        for (;;)
        {
          m += 1;
          break;
          if (localDrawable.canApplyTheme())
          {
            arrayOfDrawable[m].applyTheme(paramTheme);
            localk.h |= arrayOfDrawable[m].getChangingConfigurations();
          }
        }
      }
      localk.a(paramTheme.getResources());
    }
  }
  
  k b()
  {
    return this.f;
  }
  
  public boolean canApplyTheme()
  {
    return this.f.canApplyTheme();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Drawable localDrawable = this.e;
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
    localDrawable = this.k;
    if (localDrawable != null) {
      localDrawable.draw(paramCanvas);
    }
  }
  
  public int getAlpha()
  {
    return this.b;
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.f.getChangingConfigurations();
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (this.f.e())
    {
      this.f.c = getChangingConfigurations();
      return this.f;
    }
    return null;
  }
  
  public Drawable getCurrent()
  {
    return this.e;
  }
  
  public void getHotspotBounds(Rect paramRect)
  {
    Rect localRect = this.j;
    if (localRect != null)
    {
      paramRect.set(localRect);
      return;
    }
    super.getHotspotBounds(paramRect);
  }
  
  public int getIntrinsicHeight()
  {
    Object localObject = this.f;
    if (((k)localObject).n)
    {
      if (!((k)localObject).d) {
        ((k)localObject).d();
      }
      return ((k)localObject).j;
    }
    localObject = this.e;
    if (localObject != null) {
      return ((Drawable)localObject).getIntrinsicHeight();
    }
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    Object localObject = this.f;
    if (((k)localObject).n)
    {
      if (!((k)localObject).d) {
        ((k)localObject).d();
      }
      return ((k)localObject).o;
    }
    localObject = this.e;
    if (localObject != null) {
      return ((Drawable)localObject).getIntrinsicWidth();
    }
    return -1;
  }
  
  public int getMinimumHeight()
  {
    Object localObject = this.f;
    if (((k)localObject).n)
    {
      if (!((k)localObject).d) {
        ((k)localObject).d();
      }
      return ((k)localObject).k;
    }
    localObject = this.e;
    if (localObject != null) {
      return ((Drawable)localObject).getMinimumHeight();
    }
    return 0;
  }
  
  public int getMinimumWidth()
  {
    Object localObject = this.f;
    if (((k)localObject).n)
    {
      if (!((k)localObject).d) {
        ((k)localObject).d();
      }
      return ((k)localObject).l;
    }
    localObject = this.e;
    if (localObject != null) {
      return ((Drawable)localObject).getMinimumWidth();
    }
    return 0;
  }
  
  public int getOpacity()
  {
    int m = -2;
    Object localObject = this.e;
    int n = m;
    if (localObject != null)
    {
      n = m;
      if (((Drawable)localObject).isVisible())
      {
        localObject = this.f;
        if (!((k)localObject).e) {
          break label48;
        }
        n = ((k)localObject).y;
      }
    }
    return n;
    label48:
    ((k)localObject).c();
    int i1 = ((k)localObject).x;
    Drawable[] arrayOfDrawable = ((k)localObject).q;
    if (i1 > 0) {
      m = arrayOfDrawable[0].getOpacity();
    }
    n = 1;
    while (n < i1)
    {
      m = Drawable.resolveOpacity(m, arrayOfDrawable[n].getOpacity());
      n += 1;
    }
    ((k)localObject).y = m;
    ((k)localObject).e = true;
    return m;
  }
  
  public void getOutline(Outline paramOutline)
  {
    Drawable localDrawable = this.e;
    if (localDrawable != null) {
      localDrawable.getOutline(paramOutline);
    }
  }
  
  public boolean getPadding(Rect paramRect)
  {
    k localk = this.f;
    Object localObject2;
    Object localObject1;
    Rect localRect;
    int n;
    Drawable[] arrayOfDrawable;
    int m;
    if (!localk.C)
    {
      localObject2 = localk.m;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!localk.f)
        {
          localk.c();
          localRect = new Rect();
          n = localk.x;
          arrayOfDrawable = localk.q;
          localObject1 = null;
          m = 0;
          if (m < n) {
            break label214;
          }
          localk.f = true;
          localk.m = ((Rect)localObject1);
        }
      }
    }
    for (;;)
    {
      boolean bool;
      if (localObject1 != null)
      {
        paramRect.set((Rect)localObject1);
        m = ((Rect)localObject1).left;
        n = ((Rect)localObject1).top;
        int i1 = ((Rect)localObject1).bottom;
        if ((((Rect)localObject1).right | m | n | i1) != 0) {
          bool = true;
        }
      }
      for (;;)
      {
        if ((isAutoMirrored()) && (getLayoutDirection() == 1))
        {
          m = paramRect.left;
          paramRect.left = paramRect.right;
          paramRect.right = m;
        }
        return bool;
        bool = false;
        continue;
        localObject1 = this.e;
        if (localObject1 != null) {
          bool = ((Drawable)localObject1).getPadding(paramRect);
        } else {
          bool = super.getPadding(paramRect);
        }
      }
      label214:
      if (!arrayOfDrawable[m].getPadding(localRect)) {}
      for (;;)
      {
        m += 1;
        break;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Rect(0, 0, 0, 0);
        }
        if (localRect.left > ((Rect)localObject2).left) {
          ((Rect)localObject2).left = localRect.left;
        }
        if (localRect.top > ((Rect)localObject2).top) {
          ((Rect)localObject2).top = localRect.top;
        }
        if (localRect.right > ((Rect)localObject2).right) {
          ((Rect)localObject2).right = localRect.right;
        }
        localObject1 = localObject2;
        if (localRect.bottom > ((Rect)localObject2).bottom)
        {
          ((Rect)localObject2).bottom = localRect.bottom;
          localObject1 = localObject2;
        }
      }
      localObject1 = null;
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    k localk = this.f;
    if (localk != null) {
      localk.b();
    }
    if ((paramDrawable == this.e) && (getCallback() != null)) {
      getCallback().invalidateDrawable(this);
    }
  }
  
  public boolean isAutoMirrored()
  {
    return this.f.b;
  }
  
  public boolean isStateful()
  {
    boolean bool2 = false;
    k localk = this.f;
    if (localk.g) {
      return localk.z;
    }
    localk.c();
    int n = localk.x;
    Drawable[] arrayOfDrawable = localk.q;
    int m = 0;
    for (;;)
    {
      bool1 = bool2;
      if (m >= n) {
        break label70;
      }
      if (arrayOfDrawable[m].isStateful()) {
        break;
      }
      m += 1;
    }
    boolean bool1 = true;
    label70:
    localk.z = bool1;
    localk.g = true;
    return bool1;
  }
  
  public void jumpToCurrentState()
  {
    int n = 1;
    Drawable localDrawable = this.k;
    if (localDrawable != null)
    {
      localDrawable.jumpToCurrentState();
      this.k = null;
    }
    for (int m = 1;; m = 0)
    {
      localDrawable = this.e;
      if (localDrawable != null)
      {
        localDrawable.jumpToCurrentState();
        if (this.i) {
          this.e.setAlpha(this.b);
        }
      }
      if (this.h != 0L)
      {
        this.h = 0L;
        m = n;
      }
      for (;;)
      {
        if (this.g != 0L) {
          this.g = 0L;
        }
        for (;;)
        {
          invalidateSelf();
          do
          {
            return;
          } while (m == 0);
        }
      }
    }
  }
  
  public Drawable mutate()
  {
    if ((!this.l) && (super.mutate() == this))
    {
      k localk = b();
      localk.a();
      a(localk);
      this.l = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = this.k;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
    localDrawable = this.e;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
  }
  
  public boolean onLayoutDirectionChanged(int paramInt)
  {
    k localk = this.f;
    int n = this.a;
    int i1 = localk.x;
    Drawable[] arrayOfDrawable = localk.q;
    int m = 0;
    boolean bool1 = false;
    if (m < i1)
    {
      boolean bool2;
      if (arrayOfDrawable[m] != null) {
        if (Build.VERSION.SDK_INT >= 23)
        {
          bool2 = arrayOfDrawable[m].setLayoutDirection(paramInt);
          label61:
          if (m == n) {
            bool1 = bool2;
          }
        }
      }
      for (;;)
      {
        m += 1;
        break;
        continue;
        bool2 = false;
        break label61;
      }
    }
    localk.w = paramInt;
    return bool1;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    Drawable localDrawable = this.k;
    if (localDrawable != null) {
      return localDrawable.setLevel(paramInt);
    }
    localDrawable = this.e;
    if (localDrawable == null) {
      return false;
    }
    return localDrawable.setLevel(paramInt);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    Drawable localDrawable = this.k;
    if (localDrawable != null) {
      return localDrawable.setState(paramArrayOfInt);
    }
    localDrawable = this.e;
    if (localDrawable == null) {
      return false;
    }
    return localDrawable.setState(paramArrayOfInt);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if ((paramDrawable == this.e) && (getCallback() != null)) {
      getCallback().scheduleDrawable(this, paramRunnable, paramLong);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if ((!this.i) || (this.b != paramInt))
    {
      this.i = true;
      this.b = paramInt;
      Drawable localDrawable = this.e;
      if (localDrawable != null)
      {
        if (this.g != 0L) {
          break label49;
        }
        localDrawable.setAlpha(paramInt);
      }
    }
    return;
    label49:
    a(false);
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    k localk = this.f;
    if (localk.b != paramBoolean)
    {
      localk.b = paramBoolean;
      Drawable localDrawable = this.e;
      if (localDrawable != null) {
        a.a(localDrawable, localk.b);
      }
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    Object localObject = this.f;
    ((k)localObject).t = true;
    if (((k)localObject).i != paramColorFilter)
    {
      ((k)localObject).i = paramColorFilter;
      localObject = this.e;
      if (localObject != null) {
        ((Drawable)localObject).setColorFilter(paramColorFilter);
      }
    }
  }
  
  public void setDither(boolean paramBoolean)
  {
    k localk = this.f;
    if (localk.p != paramBoolean)
    {
      localk.p = paramBoolean;
      Drawable localDrawable = this.e;
      if (localDrawable != null) {
        localDrawable.setDither(localk.p);
      }
    }
  }
  
  public void setHotspot(float paramFloat1, float paramFloat2)
  {
    Drawable localDrawable = this.e;
    if (localDrawable != null) {
      a.a(localDrawable, paramFloat1, paramFloat2);
    }
  }
  
  public void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.j;
    if (localObject == null) {
      this.j = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    for (;;)
    {
      localObject = this.e;
      if (localObject != null) {
        a.a((Drawable)localObject, paramInt1, paramInt2, paramInt3, paramInt4);
      }
      return;
      ((Rect)localObject).set(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    k localk = this.f;
    localk.u = true;
    if (localk.A != paramColorStateList)
    {
      localk.A = paramColorStateList;
      a.a(this.e, paramColorStateList);
    }
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    k localk = this.f;
    localk.v = true;
    if (localk.B != paramMode)
    {
      localk.B = paramMode;
      a.a(this.e, paramMode);
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    Drawable localDrawable = this.k;
    if (localDrawable != null) {
      localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    localDrawable = this.e;
    if (localDrawable != null) {
      localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return bool;
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if ((paramDrawable == this.e) && (getCallback() != null)) {
      getCallback().unscheduleDrawable(this, paramRunnable);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/c/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */