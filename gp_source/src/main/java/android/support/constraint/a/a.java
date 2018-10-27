package android.support.constraint.a;

import java.util.Arrays;

public final class a
{
  public int a = 0;
  public int[] b;
  public int[] c;
  public float[] d;
  public final c e;
  public boolean f;
  public int g;
  public int h;
  private int i = 8;
  private final b j;
  
  a(b paramb, c paramc)
  {
    int k = this.i;
    this.b = new int[k];
    this.c = new int[k];
    this.d = new float[k];
    this.g = -1;
    this.h = -1;
    this.f = false;
    this.j = paramb;
    this.e = paramc;
  }
  
  public final float a(h paramh)
  {
    float f2 = 0.0F;
    int k = this.g;
    float f1 = f2;
    int m;
    int n;
    if (k != -1)
    {
      m = 0;
      n = -1;
    }
    for (;;)
    {
      f1 = f2;
      if (k != -1)
      {
        f1 = f2;
        if (m < this.a)
        {
          i1 = this.b[k];
          if (i1 != paramh.c) {
            break label153;
          }
          if (k != this.g) {
            break label137;
          }
          this.g = this.c[k];
        }
      }
      for (;;)
      {
        this.e.b[i1].a(this.j);
        this.a -= 1;
        this.b[k] = -1;
        if (this.f) {
          this.h = k;
        }
        f1 = this.d[k];
        return f1;
        label137:
        paramh = this.c;
        paramh[n] = paramh[k];
      }
      label153:
      int i1 = this.c[k];
      m += 1;
      n = k;
      k = i1;
    }
  }
  
  final h a(int paramInt)
  {
    int m = this.g;
    int k = 0;
    while ((m != -1) && (k < this.a)) {
      if (k != paramInt)
      {
        m = this.c[m];
        k += 1;
      }
      else
      {
        return this.e.b[this.b[m]];
      }
    }
    return null;
  }
  
  final void a(b paramb1, b paramb2)
  {
    int m = this.g;
    int k = 0;
    while ((m != -1) && (k < this.a))
    {
      int n = this.b[m];
      Object localObject = paramb2.c;
      if (n == ((h)localObject).c)
      {
        float f1 = this.d[m];
        a((h)localObject);
        localObject = paramb2.d;
        m = ((a)localObject).g;
        k = 0;
        for (;;)
        {
          if (m == -1) {}
          while (k >= ((a)localObject).a)
          {
            paramb1.a += paramb2.a * f1;
            paramb2.c.a(paramb1);
            m = this.g;
            k = 0;
            break;
          }
          b(this.e.b[localObject.b[m]], localObject.d[m] * f1);
          m = localObject.c[m];
          k += 1;
        }
      }
      m = this.c[m];
      k += 1;
    }
  }
  
  public final void a(h paramh, float paramFloat)
  {
    if (paramFloat != 0.0F)
    {
      int k = this.g;
      Object localObject;
      if (k == -1)
      {
        this.g = 0;
        localObject = this.d;
        k = this.g;
        localObject[k] = paramFloat;
        this.b[k] = paramh.c;
        this.c[k] = -1;
        this.a += 1;
        if (!this.f) {
          this.h += 1;
        }
        return;
      }
      int i1 = 0;
      int n = -1;
      if (k == -1) {}
      label387:
      while (i1 >= this.a)
      {
        m = this.h;
        if (this.f)
        {
          localObject = this.b;
          k = m;
          if (localObject[m] == -1) {}
        }
        for (k = localObject.length;; k = m + 1)
        {
          m = this.b.length;
          if (k >= m) {
            if (this.a >= m) {
              m = k;
            }
          }
          for (;;)
          {
            i1 = this.b.length;
            k = m;
            if (m >= i1)
            {
              k = this.i;
              this.i = (k + k);
              this.f = false;
              this.h = (i1 - 1);
              this.d = Arrays.copyOf(this.d, this.i);
              this.b = Arrays.copyOf(this.b, this.i);
              this.c = Arrays.copyOf(this.c, this.i);
              k = i1;
            }
            localObject = this.b;
            localObject[k] = paramh.c;
            this.d[k] = paramFloat;
            if (n != -1)
            {
              paramh = this.c;
              paramh[k] = paramh[n];
              paramh[n] = k;
            }
            for (;;)
            {
              this.a += 1;
              if (!this.f) {
                this.h += 1;
              }
              if (this.a < localObject.length) {
                break;
              }
              this.f = true;
              return;
              this.c[k] = this.g;
              this.g = k;
            }
            i1 = 0;
            for (;;)
            {
              localObject = this.b;
              if (i1 >= localObject.length) {
                break label387;
              }
              m = i1;
              if (localObject[i1] == -1) {
                break;
              }
              i1 += 1;
            }
            m = k;
            continue;
            m = k;
          }
        }
      }
      int m = this.b[k];
      int i2 = paramh.c;
      if (m == i2)
      {
        this.d[k] = paramFloat;
        return;
      }
      if (m < i2) {}
      for (m = k;; m = n)
      {
        k = this.c[k];
        i1 += 1;
        n = m;
        break;
      }
    }
    a(paramh);
  }
  
  final float b(int paramInt)
  {
    int m = this.g;
    int k = 0;
    while ((m != -1) && (k < this.a)) {
      if (k != paramInt)
      {
        m = this.c[m];
        k += 1;
      }
      else
      {
        return this.d[m];
      }
    }
    return 0.0F;
  }
  
  public final float b(h paramh)
  {
    int m = this.g;
    int k = 0;
    while ((m != -1) && (k < this.a))
    {
      if (this.b[m] == paramh.c) {
        return this.d[m];
      }
      m = this.c[m];
      k += 1;
    }
    return 0.0F;
  }
  
  public final void b(h paramh, float paramFloat)
  {
    int k;
    Object localObject;
    if (paramFloat != 0.0F)
    {
      k = this.g;
      if (k != -1) {
        break label82;
      }
      this.g = 0;
      localObject = this.d;
      k = this.g;
      localObject[k] = paramFloat;
      this.b[k] = paramh.c;
      this.c[k] = -1;
      this.a += 1;
      if (!this.f) {
        this.h += 1;
      }
    }
    label82:
    int i1;
    int n;
    label401:
    int i2;
    do
    {
      return;
      i1 = 0;
      n = -1;
      if (k == -1) {}
      while (i1 >= this.a)
      {
        m = this.h;
        if (this.f)
        {
          localObject = this.b;
          k = m;
          if (localObject[m] == -1) {}
        }
        for (k = localObject.length;; k = m + 1)
        {
          m = this.b.length;
          if (k >= m) {
            if (this.a >= m) {
              m = k;
            }
          }
          for (;;)
          {
            i1 = this.b.length;
            k = m;
            if (m >= i1)
            {
              k = this.i;
              this.i = (k + k);
              this.f = false;
              this.h = (i1 - 1);
              this.d = Arrays.copyOf(this.d, this.i);
              this.b = Arrays.copyOf(this.b, this.i);
              this.c = Arrays.copyOf(this.c, this.i);
              k = i1;
            }
            localObject = this.b;
            localObject[k] = paramh.c;
            this.d[k] = paramFloat;
            if (n != -1)
            {
              paramh = this.c;
              paramh[k] = paramh[n];
              paramh[n] = k;
            }
            for (;;)
            {
              this.a += 1;
              if (!this.f) {
                this.h += 1;
              }
              k = this.h;
              m = localObject.length;
              if (k < m) {
                break;
              }
              this.f = true;
              this.h = (m - 1);
              return;
              this.c[k] = this.g;
              this.g = k;
            }
            i1 = 0;
            for (;;)
            {
              localObject = this.b;
              if (i1 >= localObject.length) {
                break label401;
              }
              m = i1;
              if (localObject[i1] == -1) {
                break;
              }
              i1 += 1;
            }
            m = k;
            continue;
            m = k;
          }
        }
      }
      m = this.b[k];
      i2 = paramh.c;
      if (m != i2) {
        break;
      }
      paramh = this.d;
      paramh[k] += paramFloat;
    } while (paramh[k] != 0.0F);
    if (k == this.g) {
      this.g = this.c[k];
    }
    for (;;)
    {
      this.e.b[m].a(this.j);
      if (this.f) {
        this.h = k;
      }
      this.a -= 1;
      return;
      paramh = this.c;
      paramh[n] = paramh[k];
    }
    if (m < i2) {}
    for (int m = k;; m = n)
    {
      k = this.c[k];
      i1 += 1;
      n = m;
      break;
    }
  }
  
  public final String toString()
  {
    int m = this.g;
    String str = "";
    int k = 0;
    while ((m != -1) && (k < this.a))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" -> ");
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(this.d[m]);
      localStringBuilder.append(" : ");
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(this.e.b[this.b[m]]);
      str = localStringBuilder.toString();
      m = this.c[m];
      k += 1;
    }
    return str;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/constraint/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */