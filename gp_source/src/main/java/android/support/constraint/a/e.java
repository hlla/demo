package android.support.constraint.a;

import java.util.ArrayList;
import java.util.Arrays;

public final class e
{
  private static int f = 1000;
  public final c a;
  public d b = new d();
  public int c;
  public int d;
  public b[] e;
  private int g = 32;
  private boolean[] h;
  private int i;
  private int j;
  private h[] k;
  private int l;
  private int m = 0;
  private b[] n;
  
  public e()
  {
    int i1 = this.g;
    this.i = i1;
    this.e = null;
    this.h = new boolean[i1];
    this.c = 1;
    this.d = 0;
    this.j = i1;
    this.k = new h[f];
    this.l = 0;
    i1 = this.g;
    this.n = new b[i1];
    this.e = new b[i1];
    f();
    this.a = new c();
  }
  
  public static b a(e parame, h paramh1, h paramh2, int paramInt1, float paramFloat, h paramh3, h paramh4, int paramInt2, boolean paramBoolean)
  {
    b localb = parame.b();
    localb.a(paramh1, paramh2, paramInt1, paramFloat, paramh3, paramh4, paramInt2);
    if (paramBoolean)
    {
      paramh1 = parame.d();
      parame = parame.d();
      paramh1.g = 4;
      parame.g = 4;
      localb.a(paramh1, parame);
    }
    return localb;
  }
  
  public static b a(e parame, h paramh1, h paramh2, int paramInt, boolean paramBoolean)
  {
    b localb = parame.b();
    localb.a(paramh1, paramh2, paramInt);
    if (paramBoolean) {
      parame.a(localb, 1);
    }
    return localb;
  }
  
  private final h a(i parami)
  {
    Object localObject = (h)this.a.c.a();
    if (localObject == null) {}
    for (parami = new h(parami);; parami = (i)localObject)
    {
      if (this.l >= f)
      {
        i1 = f;
        f = i1 + i1;
        this.k = ((h[])Arrays.copyOf(this.k, f));
      }
      localObject = this.k;
      int i1 = this.l;
      this.l = (i1 + 1);
      localObject[i1] = parami;
      return parami;
      ((h)localObject).a();
      ((h)localObject).f = parami;
    }
  }
  
  public static int b(Object paramObject)
  {
    paramObject = ((android.support.constraint.a.a.a)paramObject).e;
    if (paramObject != null) {
      return (int)(((h)paramObject).a + 0.5F);
    }
    return 0;
  }
  
  private final void e()
  {
    int i1 = this.g;
    this.g = (i1 + i1);
    this.e = ((b[])Arrays.copyOf(this.e, this.g));
    c localc = this.a;
    localc.b = ((h[])Arrays.copyOf(localc.b, this.g));
    i1 = this.g;
    this.h = new boolean[i1];
    this.i = i1;
    this.j = i1;
    this.b.a.clear();
  }
  
  private final void f()
  {
    int i1 = 0;
    for (;;)
    {
      Object localObject = this.e;
      if (i1 >= localObject.length) {
        break;
      }
      localObject = localObject[i1];
      if (localObject != null) {
        this.a.a.a(localObject);
      }
      this.e[i1] = null;
      i1 += 1;
    }
  }
  
  public final int a(d paramd)
  {
    int i1 = 0;
    while (i1 < this.c)
    {
      this.h[i1] = false;
      i1 += 1;
    }
    i1 = 0;
    int i6 = 0;
    int i2 = 0;
    for (;;)
    {
      if (i1 == 0)
      {
        int i8 = paramd.a.size();
        int i7 = 0;
        Object localObject1 = null;
        int i3 = 0;
        Object localObject3;
        int i4;
        float f1;
        Object localObject2;
        int i5;
        while (i7 < i8)
        {
          localObject3 = (h)paramd.a.get(i7);
          i4 = i3;
          i3 = 5;
          if (i3 < 0)
          {
            i7 += 1;
            i3 = i4;
          }
          else
          {
            f1 = localObject3.h[i3];
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              i5 = i4;
            }
            for (;;)
            {
              if (f1 <= 0.0F)
              {
                localObject1 = localObject2;
                i4 = i5;
              }
              for (;;)
              {
                i3 -= 1;
                break;
                i4 = i5;
                localObject1 = localObject2;
                if (i3 > i5)
                {
                  localObject1 = null;
                  i4 = i3;
                }
              }
              i5 = i4;
              localObject2 = localObject1;
              if (f1 < 0.0F)
              {
                i5 = i4;
                localObject2 = localObject1;
                if (i3 >= i4)
                {
                  i5 = i3;
                  localObject2 = localObject3;
                }
              }
            }
          }
        }
        if (localObject1 != null)
        {
          localObject2 = this.h;
          i3 = ((h)localObject1).c;
          if (localObject2[i3] == 0)
          {
            localObject2[i3] = 1;
            i2 += 1;
            if (i2 >= this.c)
            {
              i1 = 1;
              label267:
              if (localObject1 != null)
              {
                f1 = Float.MAX_VALUE;
                i4 = -1;
                i3 = 0;
                if (i3 < this.d)
                {
                  localObject2 = this.e[i3];
                  i5 = i4;
                  float f2 = f1;
                  if (((b)localObject2).c.f != i.d)
                  {
                    localObject3 = ((b)localObject2).d;
                    i8 = ((a)localObject3).g;
                    if (i8 != -1) {
                      break label360;
                    }
                    f2 = f1;
                    i5 = i4;
                  }
                  for (;;)
                  {
                    i3 += 1;
                    i4 = i5;
                    f1 = f2;
                    break;
                    label360:
                    i7 = 0;
                    for (;;)
                    {
                      i5 = i4;
                      f2 = f1;
                      if (i8 == -1) {
                        break;
                      }
                      i5 = i4;
                      f2 = f1;
                      if (i7 >= ((a)localObject3).a) {
                        break;
                      }
                      if (localObject3.b[i8] == ((h)localObject1).c) {
                        break label426;
                      }
                      i8 = localObject3.c[i8];
                      i7 += 1;
                    }
                    label426:
                    float f3 = ((b)localObject2).d.b((h)localObject1);
                    i5 = i4;
                    f2 = f1;
                    if (f3 < 0.0F)
                    {
                      f3 = -((b)localObject2).a / f3;
                      i5 = i4;
                      f2 = f1;
                      if (f3 < f1)
                      {
                        i5 = i3;
                        f2 = f3;
                      }
                    }
                  }
                }
                if (i4 >= 0)
                {
                  localObject2 = this.e[i4];
                  ((b)localObject2).c.b = -1;
                  ((b)localObject2).a((h)localObject1);
                  ((b)localObject2).c.b = i4;
                  i3 = 0;
                  while (i3 < this.d)
                  {
                    this.e[i3].a((b)localObject2);
                    i3 += 1;
                  }
                  paramd.a(this);
                }
              }
            }
          }
        }
        try
        {
          b(paramd);
          for (;;)
          {
            i6 += 1;
            break;
            i1 = 1;
            continue;
            i1 = 1;
          }
          break label267;
          localObject1 = null;
          break label267;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            com.google.e.a.a.a.a.a.a.a(localException);
          }
        }
      }
    }
    return i6;
  }
  
  public final h a(Object paramObject)
  {
    android.support.constraint.a.a.a locala = null;
    Object localObject = locala;
    int i1;
    if (paramObject != null)
    {
      if (this.c + 1 >= this.i) {
        e();
      }
      localObject = locala;
      if ((paramObject instanceof android.support.constraint.a.a.a))
      {
        locala = (android.support.constraint.a.a.a)paramObject;
        localObject = locala.e;
        paramObject = localObject;
        if (localObject == null)
        {
          locala.a();
          paramObject = locala.e;
        }
        i1 = ((h)paramObject).c;
        if ((i1 == -1) || (i1 > this.m) || (this.a.b[i1] == null)) {
          break label100;
        }
        localObject = paramObject;
      }
    }
    return (h)localObject;
    label100:
    if (i1 == -1) {}
    for (;;)
    {
      this.m += 1;
      this.c += 1;
      ((h)paramObject).c = this.m;
      ((h)paramObject).f = i.d;
      this.a.b[this.m] = paramObject;
      return (h)paramObject;
      ((h)paramObject).a();
    }
  }
  
  public final void a()
  {
    int i1 = 0;
    c localc = this.a;
    h[] arrayOfh = localc.b;
    if (i1 < arrayOfh.length)
    {
      localc = arrayOfh[i1];
      if (localc == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        localc.a();
      }
    }
    localc.c.a(this.k, this.l);
    this.l = 0;
    Arrays.fill(this.a.b, null);
    this.m = 0;
    this.b.a.clear();
    this.c = 1;
    f();
    this.d = 0;
  }
  
  public final void a(b paramb)
  {
    Object localObject1 = null;
    int i3 = 0;
    if (paramb != null)
    {
      if ((this.d + 1 >= this.j) || (this.c + 1 >= this.i)) {
        e();
      }
      Object localObject2;
      Object localObject3;
      int i2;
      int i1;
      if (!paramb.b) {
        if (this.d > 0)
        {
          localObject2 = paramb.d;
          localObject3 = this.e;
          i2 = ((a)localObject2).g;
          i1 = 0;
        }
      }
      for (;;)
      {
        if (i2 == -1) {}
        float f1;
        a locala;
        label251:
        while (i1 >= ((a)localObject2).a)
        {
          if (paramb.d.a == 0) {
            paramb.b = true;
          }
          f1 = paramb.a;
          if (f1 < 0.0F)
          {
            paramb.a = (-f1);
            localObject2 = paramb.d;
            i2 = ((a)localObject2).g;
            i1 = 0;
          }
          for (;;)
          {
            if (i2 == -1) {}
            while (i1 >= ((a)localObject2).a)
            {
              locala = paramb.d;
              i2 = locala.g;
              i1 = 0;
              localObject3 = null;
              if ((i2 != -1) && (i1 < locala.a))
              {
                localObject2 = locala.d;
                f1 = localObject2[i2];
                if (f1 >= 0.0F) {
                  if (f1 < 0.001F)
                  {
                    localObject2[i2] = 0.0F;
                    f1 = 0.0F;
                    if (f1 != 0.0F)
                    {
                      localObject2 = locala.e.b[locala.b[i2]];
                      if (((h)localObject2).f != i.d)
                      {
                        if (f1 >= 0.0F)
                        {
                          localObject2 = localObject1;
                          localObject4 = localObject3;
                        }
                        for (;;)
                        {
                          i2 = locala.c[i2];
                          i1 += 1;
                          localObject1 = localObject2;
                          localObject3 = localObject4;
                          break;
                          if (localObject3 != null)
                          {
                            if (((h)localObject2).g < ((h)localObject3).g)
                            {
                              localObject4 = localObject2;
                              localObject2 = localObject1;
                            }
                            else
                            {
                              localObject4 = localObject3;
                              localObject2 = localObject1;
                            }
                          }
                          else
                          {
                            localObject4 = localObject2;
                            localObject2 = localObject1;
                          }
                        }
                      }
                      if (f1 >= 0.0F) {}
                    }
                  }
                }
              }
              for (;;)
              {
                if (localObject2 == null) {}
                for (;;)
                {
                  if (paramb.d.a == 0) {
                    paramb.b = true;
                  }
                  localObject1 = paramb.c;
                  if ((localObject1 == null) || ((((h)localObject1).f != i.d) && (paramb.a < 0.0F))) {
                    break;
                  }
                  localObject1 = this.e[this.d];
                  if (localObject1 != null) {
                    this.a.a.a(localObject1);
                  }
                  if (!paramb.b) {
                    paramb.a();
                  }
                  localObject1 = this.e;
                  i1 = this.d;
                  localObject1[i1] = paramb;
                  localObject1 = paramb.c;
                  ((h)localObject1).b = i1;
                  this.d = (i1 + 1);
                  int i4 = ((h)localObject1).e;
                  if (i4 <= 0) {
                    break;
                  }
                  for (;;)
                  {
                    localObject1 = this.n;
                    i1 = localObject1.length;
                    if (i1 >= i4) {
                      break;
                    }
                    this.n = new b[i1 + i1];
                  }
                  i1 = 0;
                  for (;;)
                  {
                    i2 = i3;
                    if (i1 >= i4) {
                      break;
                    }
                    localObject1[i1] = paramb.c.d[i1];
                    i1 += 1;
                  }
                  while (i2 < i4)
                  {
                    localObject2 = localObject1[i2];
                    if (localObject2 != paramb)
                    {
                      ((b)localObject2).d.a((b)localObject2, paramb);
                      ((b)localObject2).a();
                    }
                    i2 += 1;
                  }
                  paramb.a((h)localObject2);
                }
                localObject4 = localObject3;
                if (localObject1 == null) {
                  break label251;
                }
                localObject4 = localObject3;
                localObject2 = localObject1;
                break label251;
                localObject4 = localObject3;
                localObject2 = localObject1;
                break label251;
                break;
                if (f1 > -0.001F)
                {
                  localObject2[i2] = 0.0F;
                  f1 = 0.0F;
                  break;
                }
                break;
                if (localObject1 != null) {
                  localObject2 = localObject1;
                } else {
                  localObject2 = localObject3;
                }
              }
            }
            localObject3 = ((a)localObject2).d;
            localObject3[i2] = (-localObject3[i2]);
            i2 = localObject2.c[i2];
            i1 += 1;
          }
        }
        Object localObject4 = localObject2.e.b[localObject2.b[i2]];
        if (((h)localObject4).b != -1)
        {
          f1 = localObject2.d[i2];
          ((a)localObject2).a((h)localObject4);
          localObject4 = localObject3[localObject4.b];
          if (!((b)localObject4).b)
          {
            locala = ((b)localObject4).d;
            i2 = locala.g;
            i1 = 0;
          }
          for (;;)
          {
            if (i2 == -1) {}
            while (i1 >= locala.a)
            {
              paramb.a += ((b)localObject4).a * f1;
              ((b)localObject4).c.a(paramb);
              i2 = ((a)localObject2).g;
              i1 = 0;
              break;
            }
            ((a)localObject2).b(localObject2.e.b[locala.b[i2]], locala.d[i2] * f1);
            i2 = locala.c[i2];
            i1 += 1;
          }
        }
        i2 = localObject2.c[i2];
        i1 += 1;
      }
    }
  }
  
  public final void a(b paramb, int paramInt)
  {
    h localh = d();
    paramb.d.a(localh, paramInt);
  }
  
  public final void a(h paramh, int paramInt)
  {
    int i1 = paramh.b;
    if (i1 != -1)
    {
      localb = this.e[i1];
      if (localb.b)
      {
        localb.a = paramInt;
        return;
      }
      localb = b();
      localb.a(paramh, paramInt);
      a(localb);
      return;
    }
    b localb = b();
    localb.c = paramh;
    float f1 = paramInt;
    paramh.a = f1;
    localb.a = f1;
    localb.b = true;
    a(localb);
  }
  
  public final void a(h paramh1, h paramh2, int paramInt1, float paramFloat, h paramh3, h paramh4, int paramInt2)
  {
    b localb = b();
    localb.a(paramh1, paramh2, paramInt1, paramFloat, paramh3, paramh4, paramInt2);
    paramh1 = d();
    paramh2 = d();
    paramh1.g = 4;
    paramh2.g = 4;
    localb.a(paramh1, paramh2);
    a(localb);
  }
  
  public final void a(h paramh1, h paramh2, int paramInt1, int paramInt2)
  {
    b localb = b();
    h localh = c();
    localh.g = paramInt2;
    localb.a(paramh1, paramh2, localh, paramInt1);
    a(localb);
  }
  
  public final int b(d paramd)
  {
    int i1 = 0;
    while (i1 < this.d) {
      if ((this.e[i1].c.f == i.d) || (this.e[i1].a >= 0.0F))
      {
        i1 += 1;
      }
      else
      {
        int i7 = 0;
        int i8 = 0;
        i1 = i7;
        if (i8 != 0) {
          break label486;
        }
        float f1 = Float.MAX_VALUE;
        int i3 = 0;
        i2 = -1;
        i1 = -1;
        int i4 = 0;
        b localb;
        if (i4 < this.d)
        {
          localb = this.e[i4];
          float f2;
          int i10;
          int i9;
          int i6;
          if (localb.c.f == i.d)
          {
            f2 = f1;
            i10 = i3;
            i9 = i2;
            i6 = i1;
          }
          int i5;
          do
          {
            do
            {
              i4 += 1;
              i1 = i6;
              i2 = i9;
              i3 = i10;
              f1 = f2;
              break;
              i6 = i1;
              i9 = i2;
              i10 = i3;
              f2 = f1;
            } while (localb.a >= 0.0F);
            i5 = 1;
            i6 = i1;
            i9 = i2;
            i10 = i3;
            f2 = f1;
          } while (i5 >= this.c);
          h localh = this.a.b[i5];
          float f3 = localb.d.b(localh);
          if (f3 > 0.0F)
          {
            i6 = 0;
            if (i6 < 6)
            {
              f2 = localh.h[i6] / f3;
              if (f2 >= f1) {
                label263:
                if (i6 > i3)
                {
                  i1 = i5;
                  i2 = i4;
                  i3 = i6;
                  f1 = f2;
                }
              }
              for (;;)
              {
                i6 += 1;
                break;
                continue;
                if (i6 != i3) {
                  break label263;
                }
                i1 = i5;
                i2 = i4;
                i3 = i6;
                f1 = f2;
              }
            }
            i6 = i1;
            i1 = i3;
            i3 = i6;
          }
          for (;;)
          {
            i6 = i5 + 1;
            i5 = i1;
            i1 = i3;
            i3 = i5;
            i5 = i6;
            break;
            i6 = i3;
            i3 = i1;
            i1 = i6;
          }
        }
        if (i2 != -1)
        {
          localb = this.e[i2];
          localb.c.b = -1;
          localb.a(this.a.b[i1]);
          localb.c.b = i2;
          i1 = 0;
          while (i1 < this.d)
          {
            this.e[i1].a(localb);
            i1 += 1;
          }
          paramd.a(this);
        }
        for (i1 = i8;; i1 = 1)
        {
          i7 += 1;
          i8 = i1;
          break;
        }
      }
    }
    i1 = 0;
    label486:
    int i2 = 0;
    while ((i2 < this.d) && ((this.e[i2].c.f == i.d) || (this.e[i2].a >= 0.0F))) {
      i2 += 1;
    }
    return i1;
  }
  
  public final b b()
  {
    b localb = (b)this.a.a.a();
    if (localb != null)
    {
      localb.c = null;
      a locala = localb.d;
      locala.g = -1;
      locala.h = -1;
      locala.f = false;
      locala.a = 0;
      localb.a = 0.0F;
      localb.b = false;
      return localb;
    }
    return new b(this.a);
  }
  
  public final void b(h paramh1, h paramh2, int paramInt1, int paramInt2)
  {
    b localb = b();
    h localh = c();
    localh.g = paramInt2;
    localb.b(paramh1, paramh2, localh, paramInt1);
    a(localb);
  }
  
  public final b c(h paramh1, h paramh2, int paramInt1, int paramInt2)
  {
    b localb = b();
    localb.a(paramh1, paramh2, paramInt1);
    paramh1 = d();
    paramh2 = d();
    paramh1.g = paramInt2;
    paramh2.g = paramInt2;
    localb.a(paramh1, paramh2);
    a(localb);
    return localb;
  }
  
  public final h c()
  {
    if (this.c + 1 >= this.i) {
      e();
    }
    h localh = a(i.b);
    this.m += 1;
    this.c += 1;
    int i1 = this.m;
    localh.c = i1;
    this.a.b[i1] = localh;
    return localh;
  }
  
  public final h d()
  {
    if (this.c + 1 >= this.i) {
      e();
    }
    h localh = a(i.a);
    this.m += 1;
    this.c += 1;
    int i1 = this.m;
    localh.c = i1;
    this.a.b[i1] = localh;
    return localh;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/constraint/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */