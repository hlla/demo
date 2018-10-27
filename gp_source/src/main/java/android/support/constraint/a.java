package android.support.constraint;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.a.a.f;
import android.support.constraint.a.a.j;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public final class a
  extends ViewGroup.MarginLayoutParams
{
  public int A = 0;
  public int B = 0;
  public int C = 0;
  public int D = 0;
  public boolean E = false;
  public int F = -1;
  public int G = -1;
  public int H = -1;
  public float I = 0.5F;
  public int J = -1;
  public int K = -1;
  public int L = -1;
  public int M = -1;
  public int N = -1;
  public int O = -1;
  public int P = -1;
  public int Q = -1;
  public int R = -1;
  public int S = -1;
  public float T = 0.5F;
  public int U = 0;
  public boolean V = true;
  public float W = 0.0F;
  public f X = new f();
  private int Y = 1;
  public int a = -1;
  public int b = -1;
  public int c = -1;
  public String d = null;
  public int e = -1;
  public int f = -1;
  public int g = -1;
  public int h = -1;
  public int i = -1;
  public int j = -1;
  public int k = -1;
  public int l = -1;
  public int m = -1;
  public int n = -1;
  public int o = -1;
  public int p = -1;
  public float q = -1.0F;
  public float r = 0.5F;
  public int s = 0;
  public boolean t = true;
  public float u = 0.0F;
  public boolean v = false;
  public int w = -1;
  public int x = -1;
  public int y = 0;
  public int z = 0;
  
  public a()
  {
    super(-2, -2);
  }
  
  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, d.a);
    int i3 = paramContext.getIndexCount();
    int i2 = 0;
    int i1;
    if (i2 < i3)
    {
      i1 = paramContext.getIndex(i2);
      if (i1 == d.x)
      {
        this.w = paramContext.getResourceId(i1, this.w);
        if (this.w == -1) {}
      }
    }
    for (;;)
    {
      i2 += 1;
      break;
      this.w = paramContext.getInt(i1, -1);
      continue;
      if (i1 == d.y)
      {
        this.x = paramContext.getResourceId(i1, this.x);
        if (this.x == -1) {
          this.x = paramContext.getInt(i1, -1);
        }
      }
      else if (i1 == d.z)
      {
        this.N = paramContext.getResourceId(i1, this.N);
        if (this.N == -1) {
          this.N = paramContext.getInt(i1, -1);
        }
      }
      else if (i1 == d.A)
      {
        this.O = paramContext.getResourceId(i1, this.O);
        if (this.O == -1) {
          this.O = paramContext.getInt(i1, -1);
        }
      }
      else if (i1 == d.F)
      {
        this.S = paramContext.getResourceId(i1, this.S);
        if (this.S == -1) {
          this.S = paramContext.getInt(i1, -1);
        }
      }
      else if (i1 == d.E)
      {
        this.R = paramContext.getResourceId(i1, this.R);
        if (this.R == -1) {
          this.R = paramContext.getInt(i1, -1);
        }
      }
      else if (i1 == d.j)
      {
        this.c = paramContext.getResourceId(i1, this.c);
        if (this.c == -1) {
          this.c = paramContext.getInt(i1, -1);
        }
      }
      else if (i1 == d.i)
      {
        this.b = paramContext.getResourceId(i1, this.b);
        if (this.b == -1) {
          this.b = paramContext.getInt(i1, -1);
        }
      }
      else if (i1 == d.h)
      {
        this.a = paramContext.getResourceId(i1, this.a);
        if (this.a == -1) {
          this.a = paramContext.getInt(i1, -1);
        }
      }
      else if (i1 == d.M)
      {
        this.e = paramContext.getDimensionPixelOffset(i1, this.e);
      }
      else if (i1 == d.N)
      {
        this.f = paramContext.getDimensionPixelOffset(i1, this.f);
      }
      else if (i1 == d.n)
      {
        this.o = paramContext.getDimensionPixelOffset(i1, this.o);
      }
      else if (i1 == d.o)
      {
        this.p = paramContext.getDimensionPixelOffset(i1, this.p);
      }
      else if (i1 == d.p)
      {
        this.q = paramContext.getFloat(i1, this.q);
      }
      else if (i1 == d.f)
      {
        this.F = paramContext.getInt(i1, this.F);
      }
      else if (i1 == d.B)
      {
        this.P = paramContext.getResourceId(i1, this.P);
        if (this.P == -1) {
          this.P = paramContext.getInt(i1, -1);
        }
      }
      else if (i1 == d.C)
      {
        this.Q = paramContext.getResourceId(i1, this.Q);
        if (this.Q == -1) {
          this.Q = paramContext.getInt(i1, -1);
        }
      }
      else if (i1 == d.m)
      {
        this.h = paramContext.getResourceId(i1, this.h);
        if (this.h == -1) {
          this.h = paramContext.getInt(i1, -1);
        }
      }
      else if (i1 == d.l)
      {
        this.g = paramContext.getResourceId(i1, this.g);
        if (this.g == -1) {
          this.g = paramContext.getInt(i1, -1);
        }
      }
      else if (i1 == d.Q)
      {
        this.k = paramContext.getDimensionPixelSize(i1, this.k);
      }
      else if (i1 == d.T)
      {
        this.n = paramContext.getDimensionPixelSize(i1, this.n);
      }
      else if (i1 == d.R)
      {
        this.l = paramContext.getDimensionPixelSize(i1, this.l);
      }
      else if (i1 == d.O)
      {
        this.i = paramContext.getDimensionPixelSize(i1, this.i);
      }
      else if (i1 == d.S)
      {
        this.m = paramContext.getDimensionPixelSize(i1, this.m);
      }
      else if (i1 == d.P)
      {
        this.j = paramContext.getDimensionPixelSize(i1, this.j);
      }
      else if (i1 == d.t)
      {
        this.r = paramContext.getFloat(i1, this.r);
      }
      else if (i1 == d.G)
      {
        this.T = paramContext.getFloat(i1, this.T);
      }
      else if (i1 == d.k)
      {
        this.d = paramContext.getString(i1);
        this.Y = -1;
        paramAttributeSet = this.d;
        if (paramAttributeSet != null)
        {
          int i4 = paramAttributeSet.length();
          i1 = this.d.indexOf(',');
          if (i1 > 0) {
            if (i1 < i4 - 1)
            {
              paramAttributeSet = this.d.substring(0, i1);
              if (paramAttributeSet.equalsIgnoreCase("W"))
              {
                this.Y = 0;
                label1324:
                i1 += 1;
              }
            }
          }
          for (;;)
          {
            int i5 = this.d.indexOf(':');
            if (i5 < 0) {}
            while (i5 >= i4 - 1)
            {
              paramAttributeSet = this.d.substring(i1);
              if (paramAttributeSet.length() <= 0) {
                break;
              }
              try
              {
                Float.parseFloat(paramAttributeSet);
              }
              catch (NumberFormatException paramAttributeSet) {}
              break;
            }
            paramAttributeSet = this.d.substring(i1, i5);
            String str = this.d.substring(i5 + 1);
            if ((paramAttributeSet.length() <= 0) || (str.length() <= 0)) {
              break;
            }
            try
            {
              float f1 = Float.parseFloat(paramAttributeSet);
              float f2 = Float.parseFloat(str);
              if ((f1 <= 0.0F) || (f2 <= 0.0F)) {
                break;
              }
              if (this.Y != 1)
              {
                Math.abs(f1 / f2);
                break;
              }
              Math.abs(f2 / f1);
            }
            catch (NumberFormatException paramAttributeSet) {}
            if (!paramAttributeSet.equalsIgnoreCase("H")) {
              break label1324;
            }
            this.Y = 1;
            break label1324;
            i1 = 0;
            continue;
            i1 = 0;
          }
        }
      }
      else if (i1 == d.v)
      {
        this.u = paramContext.getFloat(i1, 0.0F);
      }
      else if (i1 == d.I)
      {
        this.W = paramContext.getFloat(i1, 0.0F);
      }
      else if (i1 == d.u)
      {
        this.s = paramContext.getInt(i1, 0);
      }
      else if (i1 == d.H)
      {
        this.U = paramContext.getInt(i1, 0);
      }
      else if (i1 == d.J)
      {
        this.z = paramContext.getInt(i1, 0);
      }
      else if (i1 == d.q)
      {
        this.y = paramContext.getInt(i1, 0);
      }
      else if (i1 == d.L)
      {
        this.D = paramContext.getDimensionPixelSize(i1, this.D);
      }
      else if (i1 == d.K)
      {
        this.B = paramContext.getDimensionPixelSize(i1, this.B);
      }
      else if (i1 == d.s)
      {
        this.C = paramContext.getDimensionPixelSize(i1, this.C);
      }
      else if (i1 == d.r)
      {
        this.A = paramContext.getDimensionPixelSize(i1, this.A);
      }
      else if ((i1 != d.w) && (i1 != d.D))
      {
        continue;
        paramContext.recycle();
        a();
        return;
      }
    }
  }
  
  public a(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public final void a()
  {
    this.v = false;
    this.t = true;
    this.V = true;
    if ((this.width == 0) || (this.width == -1)) {
      this.t = false;
    }
    if ((this.height == 0) || (this.height == -1)) {
      this.V = false;
    }
    if ((this.q != -1.0F) || (this.o != -1) || (this.p != -1))
    {
      this.v = true;
      this.t = true;
      this.V = true;
      if (!(this.X instanceof j)) {
        this.X = new j();
      }
      ((j)this.X).e(this.F);
    }
  }
  
  @TargetApi(17)
  public final void resolveLayoutDirection(int paramInt)
  {
    super.resolveLayoutDirection(paramInt);
    this.L = -1;
    this.M = -1;
    this.J = -1;
    this.K = -1;
    this.G = -1;
    this.H = -1;
    this.G = this.k;
    this.H = this.l;
    this.I = this.r;
    if (getLayoutDirection() == 1)
    {
      paramInt = this.P;
      if (paramInt != -1)
      {
        this.L = paramInt;
        paramInt = this.h;
        if (paramInt != -1) {
          this.K = paramInt;
        }
        paramInt = this.g;
        if (paramInt != -1) {
          this.J = paramInt;
        }
        paramInt = this.m;
        if (paramInt != -1) {
          this.H = paramInt;
        }
        paramInt = this.j;
        if (paramInt != -1) {
          this.G = paramInt;
        }
        this.I = (1.0F - this.r);
      }
    }
    for (;;)
    {
      if ((this.h == -1) && (this.g == -1))
      {
        paramInt = this.N;
        if (paramInt == -1) {
          break label231;
        }
        this.L = paramInt;
      }
      for (;;)
      {
        if ((this.Q == -1) && (this.P == -1))
        {
          paramInt = this.w;
          if (paramInt == -1) {
            break label215;
          }
          this.J = paramInt;
        }
        label215:
        do
        {
          return;
          paramInt = this.x;
        } while (paramInt == -1);
        this.K = paramInt;
        return;
        label231:
        paramInt = this.O;
        if (paramInt != -1) {
          this.M = paramInt;
        }
      }
      paramInt = this.Q;
      if (paramInt == -1) {
        break;
      }
      this.M = paramInt;
      break;
      paramInt = this.P;
      if (paramInt != -1) {
        this.K = paramInt;
      }
      paramInt = this.Q;
      if (paramInt != -1) {
        this.J = paramInt;
      }
      paramInt = this.h;
      if (paramInt != -1) {
        this.L = paramInt;
      }
      paramInt = this.g;
      if (paramInt != -1) {
        this.M = paramInt;
      }
      paramInt = this.m;
      if (paramInt != -1) {
        this.G = paramInt;
      }
      paramInt = this.j;
      if (paramInt != -1) {
        this.H = paramInt;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/constraint/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */