package android.support.v7.widget;

import android.support.v4.g.r;
import android.support.v4.g.s;
import java.util.ArrayList;
import java.util.List;

final class x
  implements eg
{
  public int a = 0;
  public final ArrayList b = new ArrayList();
  public final ArrayList c = new ArrayList();
  private final y d;
  private final ef e;
  private r f = new s(30);
  
  x(y paramy)
  {
    this(paramy, (byte)0);
  }
  
  private x(y paramy, byte paramByte)
  {
    this.d = paramy;
    this.e = new ef(this);
  }
  
  private final void a(z paramz, int paramInt)
  {
    this.d.a(paramz);
    switch (paramz.a)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    case 4: 
      this.d.a(paramInt, paramz.b, paramz.c);
      return;
    }
    this.d.a(paramInt, paramz.b);
  }
  
  private final void a(List paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      a((z)paramList.get(i));
      i += 1;
    }
    paramList.clear();
  }
  
  private final int b(int paramInt1, int paramInt2)
  {
    int i = this.c.size() - 1;
    z localz;
    if (i >= 0)
    {
      localz = (z)this.c.get(i);
      int j = localz.a;
      int k;
      int m;
      label66:
      int n;
      if (j == 8)
      {
        j = localz.d;
        k = localz.b;
        if (j < k)
        {
          m = k;
          if (j < k)
          {
            n = j;
            label77:
            if (paramInt1 < n) {
              label83:
              if (paramInt1 < j) {}
            }
          }
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        if (paramInt2 == 1)
        {
          localz.d = (j + 1);
          localz.b = (k + 1);
        }
        else if (paramInt2 == 2)
        {
          localz.d = (j - 1);
          localz.b = (k - 1);
        }
        else
        {
          continue;
          if (paramInt1 > m) {
            break label83;
          }
          if (n != j)
          {
            if (paramInt2 == 1) {
              localz.d = (j + 1);
            }
            for (;;)
            {
              paramInt1 -= 1;
              break;
              if (paramInt2 == 2) {
                localz.d = (j - 1);
              }
            }
          }
          if (paramInt2 == 1) {
            localz.b = (k + 1);
          }
          for (;;)
          {
            paramInt1 += 1;
            break;
            if (paramInt2 == 2) {
              localz.b = (k - 1);
            }
          }
          n = k;
          break label77;
          m = j;
          break label66;
          k = localz.d;
          if (k > paramInt1)
          {
            if (paramInt2 == 1) {
              localz.d = (k + 1);
            } else if (paramInt2 == 2) {
              localz.d = (k - 1);
            }
          }
          else if (j == 1) {
            paramInt1 -= localz.b;
          } else if (j == 2) {
            paramInt1 = localz.b + paramInt1;
          }
        }
      }
    }
    paramInt2 = this.c.size() - 1;
    if (paramInt2 >= 0)
    {
      localz = (z)this.c.get(paramInt2);
      if (localz.a == 8)
      {
        i = localz.b;
        if (i == localz.d)
        {
          label393:
          this.c.remove(paramInt2);
          a(localz);
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        if (i < 0)
        {
          break label393;
          if (localz.b <= 0)
          {
            this.c.remove(paramInt2);
            a(localz);
          }
        }
      }
    }
    return paramInt1;
  }
  
  private final void b(z paramz)
  {
    int i = paramz.a;
    if ((i != 1) && (i != 8))
    {
      int j = b(paramz.d, i);
      i = paramz.d;
      Object localObject;
      switch (paramz.a)
      {
      case 3: 
      default: 
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("op should be remove or update.");
        ((StringBuilder)localObject).append(paramz);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      for (int m = 1;; m = 0)
      {
        int k = 1;
        int n = 1;
        if (n < paramz.b)
        {
          int i1 = b(paramz.d + m * n, paramz.a);
          int i2 = paramz.a;
          switch (i2)
          {
          case 3: 
          default: 
          case 4: 
            label216:
            do
            {
              localObject = a(i2, j, k, paramz.c);
              a((z)localObject, i);
              a((z)localObject);
              j = i;
              if (paramz.a == 4) {
                j = i + k;
              }
              k = 1;
              i = j;
              n += 1;
              j = i1;
              break;
            } while (i1 != j + 1);
          }
          for (;;)
          {
            k += 1;
            i1 = j;
            break label216;
            if (i1 != j) {
              break;
            }
          }
        }
        localObject = paramz.c;
        a(paramz);
        if (k > 0)
        {
          paramz = a(paramz.a, j, k, localObject);
          a(paramz, i);
          a(paramz);
        }
        return;
      }
    }
    throw new IllegalArgumentException("should not dispatch add or move for pre layout");
  }
  
  private final boolean b(int paramInt)
  {
    int m = this.c.size();
    int i = 0;
    if (i < m)
    {
      z localz = (z)this.c.get(i);
      int j = localz.a;
      if (j == 8) {
        if (a(localz.b, i + 1) == paramInt) {}
      }
      for (;;)
      {
        i += 1;
        break;
        return true;
        if (j == 1)
        {
          int k = localz.d;
          int n = localz.b;
          j = k;
          while (j < k + n)
          {
            if (a(j, i + 1) == paramInt) {
              break label117;
            }
            j += 1;
          }
        }
      }
      label117:
      return true;
    }
    return false;
  }
  
  private final void c(z paramz)
  {
    this.c.add(paramz);
    switch (paramz.a)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unknown update op type for ");
      localStringBuilder.append(paramz);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 8: 
      this.d.d(paramz.d, paramz.b);
      return;
    case 4: 
      this.d.a(paramz.d, paramz.b, paramz.c);
      return;
    case 2: 
      this.d.b(paramz.d, paramz.b);
      return;
    }
    this.d.c(paramz.d, paramz.b);
  }
  
  final int a(int paramInt1, int paramInt2)
  {
    int k = this.c.size();
    int j = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = paramInt2;
    z localz;
    int m;
    if (j < k)
    {
      localz = (z)this.c.get(j);
      m = localz.a;
      if (m == 8)
      {
        paramInt1 = localz.d;
        if (paramInt1 == paramInt2) {
          paramInt1 = localz.b;
        }
      }
    }
    for (;;)
    {
      j += 1;
      paramInt2 = paramInt1;
      break;
      int i = paramInt2;
      if (paramInt1 < paramInt2) {
        i = paramInt2 - 1;
      }
      paramInt1 = i;
      if (localz.b <= i)
      {
        paramInt1 = i + 1;
        continue;
        i = localz.d;
        paramInt1 = paramInt2;
        if (i <= paramInt2) {
          if (m == 2)
          {
            paramInt1 = localz.b;
            if (paramInt2 >= i + paramInt1)
            {
              paramInt1 = paramInt2 - paramInt1;
            }
            else
            {
              paramInt1 = -1;
              return paramInt1;
            }
          }
          else
          {
            paramInt1 = paramInt2;
            if (m == 1) {
              paramInt1 = paramInt2 + localz.b;
            }
          }
        }
      }
    }
  }
  
  public final z a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    z localz = (z)this.f.a();
    if (localz == null) {
      return new z(paramInt1, paramInt2, paramInt3, paramObject);
    }
    localz.a = paramInt1;
    localz.d = paramInt2;
    localz.b = paramInt3;
    localz.c = paramObject;
    return localz;
  }
  
  final void a()
  {
    a(this.b);
    a(this.c);
    this.a = 0;
  }
  
  public final void a(z paramz)
  {
    paramz.c = null;
    this.f.a(paramz);
  }
  
  final boolean a(int paramInt)
  {
    return (this.a & paramInt) != 0;
  }
  
  final void b()
  {
    ef localef = this.e;
    ArrayList localArrayList = this.b;
    int i = localArrayList.size() - 1;
    int j = 0;
    label24:
    if (i >= 0) {
      if (((z)localArrayList.get(i)).a != 8) {
        j = 1;
      }
    }
    for (;;)
    {
      i -= 1;
      break label24;
      if (j != 0) {
        for (int k = i;; k = -1)
        {
          int m;
          int n;
          int i2;
          Object localObject1;
          Object localObject2;
          if (k != -1)
          {
            m = k + 1;
            z localz1 = (z)localArrayList.get(k);
            z localz2 = (z)localArrayList.get(m);
            switch (localz2.a)
            {
            case 3: 
            default: 
              break;
            case 1: 
              n = localz1.b;
              i1 = localz2.d;
              if (n >= i1) {}
            case 2: 
            case 4: 
              for (i = -1;; i = 0)
              {
                i2 = localz1.d;
                j = i;
                if (i2 < i1) {
                  j = i + 1;
                }
                if (i1 <= i2) {
                  localz1.d = (localz2.b + i2);
                }
                i = localz2.d;
                if (i <= n) {
                  localz1.b = (n + localz2.b);
                }
                localz2.d = (j + i);
                localArrayList.set(k, localz2);
                localArrayList.set(m, localz1);
                break;
                i = localz1.d;
                n = localz1.b;
                if (i < n) {
                  if (localz2.d == i) {
                    if (localz2.b == n - i)
                    {
                      j = 1;
                      i = 0;
                    }
                  }
                }
                for (;;)
                {
                  i1 = localz2.d;
                  if (n < i1) {
                    localz2.d = (i1 - 1);
                  }
                  do
                  {
                    n = localz1.d;
                    i1 = localz2.d;
                    if (n <= i1)
                    {
                      localz2.d = (i1 + 1);
                      localObject1 = null;
                    }
                    for (;;)
                    {
                      if (j != 0)
                      {
                        localArrayList.set(k, localz2);
                        localArrayList.remove(m);
                        localef.a.a(localz1);
                        break;
                      }
                      if (i == 0)
                      {
                        if (localObject1 == null) {}
                        for (;;)
                        {
                          i = localz1.d;
                          if (i >= localz2.d) {
                            localz1.d = (i - localz2.b);
                          }
                          i = localz1.b;
                          if (i >= localz2.d) {
                            localz1.b = (i - localz2.b);
                          }
                          localArrayList.set(k, localz2);
                          if (localz1.d != localz1.b) {
                            localArrayList.set(m, localz1);
                          }
                          while (localObject1 != null)
                          {
                            localArrayList.add(k, localObject1);
                            break;
                            localArrayList.remove(m);
                          }
                          i = localz1.d;
                          if (i >= ((z)localObject1).d) {
                            localz1.d = (i - ((z)localObject1).b);
                          }
                          i = localz1.b;
                          if (i >= ((z)localObject1).d) {
                            localz1.b = (i - ((z)localObject1).b);
                          }
                        }
                      }
                      if (localObject1 == null) {}
                      for (;;)
                      {
                        i = localz1.d;
                        if (i > localz2.d) {
                          localz1.d = (i - localz2.b);
                        }
                        i = localz1.b;
                        if (i <= localz2.d) {
                          break;
                        }
                        localz1.b = (i - localz2.b);
                        break;
                        i = localz1.d;
                        if (i > ((z)localObject1).d) {
                          localz1.d = (i - ((z)localObject1).b);
                        }
                        i = localz1.b;
                        if (i > ((z)localObject1).d) {
                          localz1.b = (i - ((z)localObject1).b);
                        }
                      }
                      i1 += localz2.b;
                      if (n < i1)
                      {
                        localObject1 = localef.a.a(2, n + 1, i1 - n, null);
                        localz2.b = (localz1.d - localz2.d);
                      }
                      else
                      {
                        localObject1 = null;
                      }
                    }
                    i2 = localz2.b;
                  } while (n >= i1 + i2);
                  localz2.b = (i2 - 1);
                  localz1.a = 2;
                  localz1.b = 1;
                  if (localz2.b != 0) {
                    break;
                  }
                  localArrayList.remove(m);
                  localef.a.a(localz2);
                  break;
                  j = 0;
                  i = 0;
                  continue;
                  j = 0;
                  i = 0;
                  continue;
                  if (localz2.d == n + 1)
                  {
                    if (localz2.b == i - n)
                    {
                      j = 1;
                      i = 1;
                    }
                    else
                    {
                      j = 0;
                      i = 1;
                    }
                  }
                  else
                  {
                    j = 0;
                    i = 1;
                  }
                }
                i = localz1.b;
                j = localz2.d;
                if (i < j)
                {
                  localz2.d = (j - 1);
                  localObject1 = null;
                }
                for (;;)
                {
                  i = localz1.d;
                  j = localz2.d;
                  if (i <= j)
                  {
                    localz2.d = (j + 1);
                    localObject2 = null;
                  }
                  for (;;)
                  {
                    localArrayList.set(m, localz1);
                    if (localz2.b > 0) {
                      localArrayList.set(k, localz2);
                    }
                    for (;;)
                    {
                      if (localObject1 != null) {
                        localArrayList.add(k, localObject1);
                      }
                      if (localObject2 == null) {
                        break;
                      }
                      localArrayList.add(k, localObject2);
                      break;
                      localArrayList.remove(k);
                      localef.a.a(localz2);
                    }
                    j += localz2.b;
                    if (i < j)
                    {
                      j -= i;
                      localObject2 = localef.a.a(4, i + 1, j, localz2.c);
                      localz2.b -= j;
                    }
                    else
                    {
                      localObject2 = null;
                    }
                  }
                  n = localz2.b;
                  if (i < j + n)
                  {
                    localz2.b = (n - 1);
                    localObject1 = localef.a.a(4, localz1.d, 1, localz2.c);
                  }
                  else
                  {
                    localObject1 = null;
                  }
                }
              }
            }
          }
          int i4 = this.b.size();
          int i1 = 0;
          if (i1 < i4)
          {
            localObject1 = (z)this.b.get(i1);
            switch (((z)localObject1).a)
            {
            }
            for (;;)
            {
              i1 += 1;
              break;
              c((z)localObject1);
              continue;
              i2 = ((z)localObject1).d;
              int i5 = ((z)localObject1).b;
              i = 0;
              int i3 = -1;
              j = i2;
              k = i2;
              if (k < i2 + i5)
              {
                if ((this.d.a(k) == null) && (!b(k)))
                {
                  m = i;
                  n = j;
                  if (i3 == 1)
                  {
                    c(a(4, j, i, ((z)localObject1).c));
                    m = 0;
                    n = k;
                  }
                  i = 0;
                  j = n;
                  n = m;
                }
                for (;;)
                {
                  m = n + 1;
                  k += 1;
                  i3 = i;
                  i = m;
                  break;
                  n = i;
                  m = j;
                  if (i3 == 0)
                  {
                    b(a(4, j, i, ((z)localObject1).c));
                    n = 0;
                    m = k;
                  }
                  i = 1;
                  j = m;
                }
              }
              localObject2 = localObject1;
              if (i != ((z)localObject1).b)
              {
                localObject2 = ((z)localObject1).c;
                a((z)localObject1);
                localObject2 = a(4, j, i, localObject2);
              }
              if (i3 != 0)
              {
                c((z)localObject2);
              }
              else
              {
                b((z)localObject2);
                continue;
                i2 = ((z)localObject1).d;
                k = i2 + ((z)localObject1).b;
                j = -1;
                i = i2;
                n = 0;
                if (i < k)
                {
                  if ((this.d.a(i) == null) && (!b(i)))
                  {
                    if (j == 1) {
                      c(a(2, i2, n, null));
                    }
                    for (m = 1;; m = 0)
                    {
                      j = 0;
                      if (m != 0)
                      {
                        m = i - n;
                        i = k - n;
                      }
                      for (k = 1;; k = n)
                      {
                        n = k;
                        k = i;
                        i = m + 1;
                        break;
                        n += 1;
                        m = i;
                        i = k;
                      }
                    }
                  }
                  if (j == 0) {
                    b(a(2, i2, n, null));
                  }
                  for (j = 1;; j = 0)
                  {
                    i3 = 1;
                    m = j;
                    j = i3;
                    break;
                  }
                }
                localObject2 = localObject1;
                if (n != ((z)localObject1).b)
                {
                  a((z)localObject1);
                  localObject2 = a(2, i2, n, null);
                }
                if (j != 0)
                {
                  c((z)localObject2);
                }
                else
                {
                  b((z)localObject2);
                  continue;
                  c((z)localObject1);
                }
              }
            }
          }
          this.b.clear();
          return;
        }
      }
    }
  }
  
  final void c()
  {
    int j = this.c.size();
    int i = 0;
    while (i < j)
    {
      this.d.b((z)this.c.get(i));
      i += 1;
    }
    a(this.c);
    this.a = 0;
  }
  
  final boolean d()
  {
    return this.b.size() > 0;
  }
  
  final void e()
  {
    c();
    int j = this.b.size();
    int i = 0;
    if (i < j)
    {
      z localz = (z)this.b.get(i);
      switch (localz.a)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        this.d.b(localz);
        this.d.d(localz.d, localz.b);
        continue;
        this.d.b(localz);
        this.d.a(localz.d, localz.b, localz.c);
        continue;
        this.d.b(localz);
        this.d.a(localz.d, localz.b);
        continue;
        this.d.b(localz);
        this.d.c(localz.d, localz.b);
      }
    }
    a(this.b);
    this.a = 0;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */