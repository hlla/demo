package android.support.constraint.a;

import java.util.Arrays;

public final class b
{
  public float a = 0.0F;
  public boolean b = false;
  public h c = null;
  public final a d;
  
  public b(c paramc)
  {
    this.d = new a(this, paramc);
  }
  
  public final b a(float paramFloat1, float paramFloat2, float paramFloat3, h paramh1, int paramInt1, h paramh2, int paramInt2, h paramh3, int paramInt3, h paramh4, int paramInt4)
  {
    if (paramFloat2 == 0.0F) {}
    while (paramFloat1 == paramFloat3)
    {
      this.a = (-paramInt1 - paramInt2 + paramInt3 + paramInt4);
      this.d.a(paramh1, 1.0F);
      this.d.a(paramh2, -1.0F);
      this.d.a(paramh4, 1.0F);
      this.d.a(paramh3, -1.0F);
      return this;
    }
    paramFloat1 = paramFloat1 / paramFloat2 / (paramFloat3 / paramFloat2);
    this.a = (-paramInt1 - paramInt2 + paramInt3 * paramFloat1 + paramInt4 * paramFloat1);
    this.d.a(paramh1, 1.0F);
    this.d.a(paramh2, -1.0F);
    this.d.a(paramh4, paramFloat1);
    this.d.a(paramh3, -paramFloat1);
    return this;
  }
  
  public final b a(h paramh, int paramInt)
  {
    if (paramInt < 0)
    {
      this.a = (-paramInt);
      this.d.a(paramh, 1.0F);
      return this;
    }
    this.a = paramInt;
    this.d.a(paramh, -1.0F);
    return this;
  }
  
  public final b a(h paramh1, h paramh2)
  {
    this.d.a(paramh1, 1.0F);
    this.d.a(paramh2, -1.0F);
    return this;
  }
  
  public final b a(h paramh1, h paramh2, int paramInt)
  {
    if (paramInt == 0)
    {
      this.d.a(paramh1, -1.0F);
      this.d.a(paramh2, 1.0F);
      return this;
    }
    if (paramInt < 0) {
      paramInt = -paramInt;
    }
    for (int i = 1;; i = 0)
    {
      this.a = paramInt;
      if (i == 0) {
        break;
      }
      this.d.a(paramh1, 1.0F);
      this.d.a(paramh2, -1.0F);
      return this;
    }
  }
  
  final b a(h paramh1, h paramh2, int paramInt1, float paramFloat, h paramh3, h paramh4, int paramInt2)
  {
    if (paramh2 == paramh3)
    {
      this.d.a(paramh1, 1.0F);
      this.d.a(paramh4, 1.0F);
      this.d.a(paramh2, -2.0F);
      return this;
    }
    if (paramFloat == 0.5F)
    {
      this.d.a(paramh1, 1.0F);
      this.d.a(paramh2, -1.0F);
      this.d.a(paramh3, -1.0F);
      this.d.a(paramh4, 1.0F);
      if (paramInt1 > 0) {}
      for (;;)
      {
        this.a = (-paramInt1 + paramInt2);
        return this;
        if (paramInt2 <= 0) {
          break;
        }
      }
    }
    if (paramFloat <= 0.0F)
    {
      this.d.a(paramh1, -1.0F);
      this.d.a(paramh2, 1.0F);
      this.a = paramInt1;
      return this;
    }
    if (paramFloat < 1.0F)
    {
      float f = 1.0F - paramFloat;
      this.d.a(paramh1, f);
      this.d.a(paramh2, -f);
      this.d.a(paramh3, -paramFloat);
      this.d.a(paramh4, paramFloat);
      if (paramInt1 > 0) {}
      for (;;)
      {
        this.a = (f * -paramInt1 + paramInt2 * paramFloat);
        return this;
        if (paramInt2 <= 0) {
          break;
        }
      }
    }
    this.d.a(paramh3, -1.0F);
    this.d.a(paramh4, 1.0F);
    this.a = paramInt2;
    return this;
  }
  
  public final b a(h paramh1, h paramh2, h paramh3, int paramInt)
  {
    if (paramInt == 0)
    {
      this.d.a(paramh1, -1.0F);
      this.d.a(paramh2, 1.0F);
      this.d.a(paramh3, 1.0F);
      return this;
    }
    if (paramInt < 0) {
      paramInt = -paramInt;
    }
    for (int i = 1;; i = 0)
    {
      this.a = paramInt;
      if (i == 0) {
        break;
      }
      this.d.a(paramh1, 1.0F);
      this.d.a(paramh2, -1.0F);
      this.d.a(paramh3, -1.0F);
      return this;
    }
  }
  
  public final b a(h paramh1, h paramh2, h paramh3, h paramh4, float paramFloat)
  {
    this.d.a(paramh1, -1.0F);
    this.d.a(paramh2, 1.0F);
    this.d.a(paramh3, paramFloat);
    this.d.a(paramh4, -paramFloat);
    return this;
  }
  
  final void a()
  {
    a locala = this.d;
    int j = locala.g;
    int i = 0;
    if ((j != -1) && (i < locala.a))
    {
      h localh = locala.e.b[locala.b[j]];
      int k = 0;
      label48:
      int m = localh.e;
      if (k < m) {
        if (localh.d[k] != this) {}
      }
      for (;;)
      {
        j = locala.c[j];
        i += 1;
        break;
        k += 1;
        break label48;
        b[] arrayOfb = localh.d;
        k = arrayOfb.length;
        if (m >= k) {
          localh.d = ((b[])Arrays.copyOf(arrayOfb, k + k));
        }
        arrayOfb = localh.d;
        k = localh.e;
        arrayOfb[k] = this;
        localh.e = (k + 1);
      }
    }
  }
  
  final void a(h paramh)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      this.d.a((h)localObject, -1.0F);
      this.c = null;
    }
    float f = -this.d.a(paramh);
    this.c = paramh;
    if (f != 1.0F)
    {
      this.a /= f;
      paramh = this.d;
      int j = paramh.g;
      int i = 0;
      while ((j != -1) && (i < paramh.a))
      {
        localObject = paramh.d;
        localObject[j] /= f;
        j = paramh.c[j];
        i += 1;
      }
    }
  }
  
  final boolean a(b paramb)
  {
    this.d.a(this, paramb);
    return true;
  }
  
  public final b b(h paramh1, h paramh2, h paramh3, int paramInt)
  {
    if (paramInt == 0)
    {
      this.d.a(paramh1, -1.0F);
      this.d.a(paramh2, 1.0F);
      this.d.a(paramh3, -1.0F);
      return this;
    }
    if (paramInt < 0) {
      paramInt = -paramInt;
    }
    for (int i = 1;; i = 0)
    {
      this.a = paramInt;
      if (i == 0) {
        break;
      }
      this.d.a(paramh1, 1.0F);
      this.d.a(paramh2, -1.0F);
      this.d.a(paramh3, 1.0F);
      return this;
    }
  }
  
  public final String toString()
  {
    if (this.c == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append("0");
    }
    for (Object localObject1 = ((StringBuilder)localObject1).toString();; localObject1 = ((StringBuilder)localObject1).toString())
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" = ");
      localObject1 = ((StringBuilder)localObject2).toString();
      if (this.a != 0.0F)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(this.a);
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      for (int i = 1;; i = 0)
      {
        int m = this.d.a;
        int j = 0;
        if (j < m)
        {
          Object localObject3 = this.d.a(j);
          int k = i;
          localObject2 = localObject1;
          float f;
          if (localObject3 != null)
          {
            f = this.d.b(j);
            localObject2 = ((h)localObject3).toString();
            if (i == 0) {
              break label360;
            }
            if (f > 0.0F) {
              break label325;
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(" - ");
            localObject1 = ((StringBuilder)localObject3).toString();
            f = -f;
          }
          for (;;)
          {
            if (f != 1.0F)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append((String)localObject1);
              ((StringBuilder)localObject3).append(f);
              ((StringBuilder)localObject3).append(" ");
              ((StringBuilder)localObject3).append((String)localObject2);
            }
            for (localObject1 = ((StringBuilder)localObject3).toString();; localObject1 = ((StringBuilder)localObject3).toString())
            {
              k = 1;
              localObject2 = localObject1;
              j += 1;
              i = k;
              localObject1 = localObject2;
              break;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append((String)localObject1);
              ((StringBuilder)localObject3).append((String)localObject2);
            }
            label325:
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(" + ");
            localObject1 = ((StringBuilder)localObject3).toString();
            continue;
            label360:
            if (f < 0.0F)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append((String)localObject1);
              ((StringBuilder)localObject3).append("- ");
              localObject1 = ((StringBuilder)localObject3).toString();
              f = -f;
            }
          }
        }
        localObject2 = localObject1;
        if (i == 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("0.0");
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        return (String)localObject2;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(this.c);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/constraint/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */