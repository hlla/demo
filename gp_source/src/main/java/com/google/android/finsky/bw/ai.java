package com.google.android.finsky.bw;

public final class ai
{
  private final int a;
  private final int b;
  private final int c;
  private final float d;
  private final boolean e;
  
  public ai(float paramFloat, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.d = paramFloat;
    this.e = paramBoolean;
    this.c = paramInt1;
    this.b = paramInt2;
    this.a = paramInt3;
  }
  
  private static int b(aj paramaj, int paramInt1, int paramInt2)
  {
    int m = paramaj.getPeekableChildCount();
    int j = 0;
    int k = 0;
    if (j < m)
    {
      int i = paramaj.a(j);
      if (paramInt1 <= 0) {
        i = 0;
      }
      for (;;)
      {
        i += paramInt2;
        paramaj.a(j, i);
        k += i;
        j += 1;
        break;
        if (i < paramInt1) {
          i = paramInt1 - i;
        } else {
          i = 0;
        }
      }
    }
    return k;
  }
  
  public final void a(aj paramaj, int paramInt1, int paramInt2)
  {
    int n;
    int k;
    int i;
    int j;
    if (paramInt2 != 0)
    {
      paramaj.ax_();
      n = paramaj.getPeekableChildCount();
      k = 0;
      i = paramInt1;
      for (;;)
      {
        if (k < n)
        {
          j = paramaj.a(k) + i;
          if (j <= paramInt2)
          {
            k += 1;
            i = j;
          }
          else if (k != n - 1)
          {
            j = 1;
          }
        }
      }
    }
    for (;;)
    {
      if (j != 0)
      {
        i1 = paramaj.a(k);
        i2 = paramaj.i_(k);
        i3 = i1 - (i2 + i2);
        f = i1;
        n = Math.round(this.d * f);
        j = Math.round(f * (1.0F - this.d));
        m = (int)Math.round(i2 + i3 / 3.0D);
        paramInt1 = n;
        if (n <= i2) {
          paramInt1 = m;
        }
        if (paramInt1 + i > paramInt2)
        {
          k -= 1;
          paramInt1 = paramInt2 - (i - Math.round(paramaj.a(k) * this.d));
          if (paramInt1 >= 10)
          {
            paramInt1 /= (k + k + 1);
            b(paramaj, 0, paramInt1 + paramInt1);
          }
        }
      }
      while (!this.e) {
        for (;;)
        {
          int i1;
          int i2;
          int i3;
          float f;
          return;
          paramInt1 = j;
          if (j >= i2 + i3) {
            paramInt1 = i1 - m;
          }
          paramInt1 = paramInt2 - Math.min(paramInt1 + i, paramInt2);
        }
      }
      i += paramInt1;
      if (i > paramInt2)
      {
        paramInt1 = i - (paramInt1 + paramInt1);
        k = 0;
      }
      for (;;)
      {
        if (n == 1) {
          i = this.c;
        }
        for (;;)
        {
          if (i > 0) {}
          for (j = b(paramaj, i, 0) + paramInt1;; j = paramInt1)
          {
            m = paramInt2 - j;
            if (m >= this.a) {}
            for (;;)
            {
              if (j > paramInt2) {
                paramaj.ax_();
              }
              for (;;)
              {
                paramInt1 = (paramInt2 - paramInt1) / 2 + k;
                paramaj.b_(paramInt1, paramInt1);
                return;
                paramInt1 = j;
              }
              if (m > 10) {
                j = b(paramaj, i, m / n) + paramInt1;
              }
            }
          }
          if (n == 2) {
            i = this.b;
          } else {
            i = 0;
          }
        }
        k = paramInt1;
        paramInt1 = i;
      }
      int m = j - paramInt1;
      if (m > paramInt2)
      {
        j = 1;
      }
      else if (!paramaj.ay_())
      {
        j = 0;
        i = m;
        paramInt1 = 0;
      }
      else
      {
        j = 1;
        continue;
        j = 0;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */