package android.support.v7.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.SparseArray;

abstract class k
  extends Drawable.ConstantState
{
  public ColorStateList A;
  public PorterDuff.Mode B;
  public boolean C = false;
  private boolean D;
  private int E = 160;
  private SparseArray F;
  private boolean G;
  private final h H;
  private Resources I;
  private boolean a;
  public boolean b;
  public int c;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  public int h;
  public ColorFilter i;
  public int j;
  public int k;
  public int l;
  public Rect m;
  public boolean n = false;
  public int o;
  public boolean p = true;
  public Drawable[] q;
  public int r = 0;
  public int s = 0;
  public boolean t;
  public boolean u;
  public boolean v;
  public int w;
  public int x;
  public int y;
  public boolean z;
  
  k(k paramk, h paramh, Resources paramResources)
  {
    this.H = paramh;
    if (paramResources != null) {
      paramh = paramResources;
    }
    for (;;)
    {
      this.I = paramh;
      if (paramk != null) {}
      for (int i1 = paramk.E;; i1 = 0)
      {
        this.E = h.a(paramResources, i1);
        if (paramk != null)
        {
          this.c = paramk.c;
          this.h = paramk.h;
          this.D = true;
          this.a = true;
          this.C = paramk.C;
          this.n = paramk.n;
          this.p = paramk.p;
          this.G = paramk.G;
          this.w = paramk.w;
          this.r = paramk.r;
          this.s = paramk.s;
          this.b = paramk.b;
          this.i = paramk.i;
          this.t = paramk.t;
          this.A = paramk.A;
          this.B = paramk.B;
          this.u = paramk.u;
          this.v = paramk.v;
          if (paramk.E == this.E)
          {
            if (paramk.f)
            {
              this.m = new Rect(paramk.m);
              this.f = true;
            }
            if (paramk.d)
            {
              this.o = paramk.o;
              this.j = paramk.j;
              this.l = paramk.l;
              this.k = paramk.k;
              this.d = true;
            }
          }
          if (paramk.e)
          {
            this.y = paramk.y;
            this.e = true;
          }
          if (paramk.g)
          {
            this.z = paramk.z;
            this.g = true;
          }
          paramh = paramk.q;
          this.q = new Drawable[paramh.length];
          this.x = paramk.x;
          paramk = paramk.F;
          if (paramk != null) {}
          for (this.F = paramk.clone();; this.F = new SparseArray(this.x))
          {
            int i3 = this.x;
            i1 = i2;
            if (i1 >= i3) {
              break;
            }
            paramk = paramh[i1];
            if (paramk == null) {}
            for (;;)
            {
              i1 += 1;
              break;
              paramk = paramk.getConstantState();
              if (paramk != null) {
                this.F.put(i1, paramk);
              } else {
                this.q[i1] = paramh[i1];
              }
            }
          }
        }
        this.q = new Drawable[10];
        this.x = 0;
        return;
      }
      if (paramk != null) {
        paramh = paramk.I;
      } else {
        paramh = null;
      }
    }
  }
  
  private final Drawable b(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramDrawable.setLayoutDirection(this.w);
    }
    paramDrawable = paramDrawable.mutate();
    paramDrawable.setCallback(this.H);
    return paramDrawable;
  }
  
  public final int a(Drawable paramDrawable)
  {
    int i1 = this.x;
    if (i1 >= this.q.length) {
      b(i1, i1 + 10);
    }
    paramDrawable.mutate();
    paramDrawable.setVisible(false, true);
    paramDrawable.setCallback(this.H);
    this.q[i1] = paramDrawable;
    this.x += 1;
    this.h |= paramDrawable.getChangingConfigurations();
    b();
    this.m = null;
    this.f = false;
    this.d = false;
    this.D = false;
    return i1;
  }
  
  void a()
  {
    int i2 = this.x;
    Drawable[] arrayOfDrawable = this.q;
    int i1 = 0;
    if (i1 < i2)
    {
      Drawable localDrawable = arrayOfDrawable[i1];
      if (localDrawable == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        localDrawable.mutate();
      }
    }
    this.G = true;
  }
  
  final void a(Resources paramResources)
  {
    if (paramResources != null)
    {
      this.I = paramResources;
      int i1 = h.a(paramResources, this.E);
      int i2 = this.E;
      this.E = i1;
      if (i2 != i1)
      {
        this.d = false;
        this.f = false;
      }
    }
  }
  
  public final Drawable b(int paramInt)
  {
    Drawable localDrawable = this.q[paramInt];
    Object localObject = localDrawable;
    if (localDrawable == null)
    {
      localObject = this.F;
      if (localObject == null) {
        break label98;
      }
      int i1 = ((SparseArray)localObject).indexOfKey(paramInt);
      if (i1 < 0) {
        break label98;
      }
      localDrawable = b(((Drawable.ConstantState)this.F.valueAt(i1)).newDrawable(this.I));
      this.q[paramInt] = localDrawable;
      this.F.removeAt(i1);
      localObject = localDrawable;
      if (this.F.size() == 0)
      {
        this.F = null;
        localObject = localDrawable;
      }
    }
    return (Drawable)localObject;
    label98:
    return null;
  }
  
  final void b()
  {
    this.e = false;
    this.g = false;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Drawable[] arrayOfDrawable = new Drawable[paramInt2];
    System.arraycopy(this.q, 0, arrayOfDrawable, 0, paramInt1);
    this.q = arrayOfDrawable;
  }
  
  final void c()
  {
    Object localObject = this.F;
    if (localObject != null)
    {
      int i2 = ((SparseArray)localObject).size();
      int i1 = 0;
      while (i1 < i2)
      {
        int i3 = this.F.keyAt(i1);
        localObject = (Drawable.ConstantState)this.F.valueAt(i1);
        this.q[i3] = b(((Drawable.ConstantState)localObject).newDrawable(this.I));
        i1 += 1;
      }
      this.F = null;
    }
  }
  
  public boolean canApplyTheme()
  {
    int i2 = this.x;
    Drawable[] arrayOfDrawable = this.q;
    int i1 = 0;
    if (i1 < i2)
    {
      Object localObject = arrayOfDrawable[i1];
      if (localObject != null) {
        if (((Drawable)localObject).canApplyTheme()) {}
      }
      do
      {
        i1 += 1;
        break;
        return true;
        localObject = (Drawable.ConstantState)this.F.get(i1);
      } while ((localObject == null) || (!((Drawable.ConstantState)localObject).canApplyTheme()));
      return true;
    }
    return false;
  }
  
  protected final void d()
  {
    int i1 = 0;
    this.d = true;
    c();
    int i2 = this.x;
    Drawable[] arrayOfDrawable = this.q;
    this.j = -1;
    this.o = -1;
    this.k = 0;
    this.l = 0;
    if (i1 < i2)
    {
      Drawable localDrawable = arrayOfDrawable[i1];
      int i3 = localDrawable.getIntrinsicWidth();
      if (i3 > this.o) {
        this.o = i3;
      }
      i3 = localDrawable.getIntrinsicHeight();
      if (i3 > this.j) {
        this.j = i3;
      }
      i3 = localDrawable.getMinimumWidth();
      if (i3 > this.l) {
        this.l = i3;
      }
      i3 = localDrawable.getMinimumHeight();
      if (i3 <= this.k) {}
      for (;;)
      {
        i1 += 1;
        break;
        this.k = i3;
      }
    }
  }
  
  public final boolean e()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if (this.D)
        {
          bool = this.a;
          return bool;
        }
        c();
        this.D = true;
        int i2 = this.x;
        Drawable[] arrayOfDrawable = this.q;
        int i1 = 0;
        if (i1 < i2)
        {
          if (arrayOfDrawable[i1].getConstantState() != null)
          {
            i1 += 1;
            continue;
          }
          this.a = false;
          continue;
        }
        this.a = true;
      }
      finally {}
      bool = true;
    }
  }
  
  public int getChangingConfigurations()
  {
    return this.c | this.h;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/c/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */