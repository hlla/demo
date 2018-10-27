package android.support.v7.g;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class f
{
  private final e a;
  private final boolean b;
  private final int[] c;
  private final int d;
  private final int[] e;
  private final int f;
  private final List g;
  
  f(e parame, List paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    this.g = paramList;
    this.e = paramArrayOfInt1;
    this.c = paramArrayOfInt2;
    Arrays.fill(this.e, 0);
    Arrays.fill(this.c, 0);
    this.a = parame;
    this.f = parame.a();
    this.d = parame.b();
    this.b = paramBoolean;
    if (!this.g.isEmpty()) {}
    for (parame = (i)this.g.get(0);; parame = null)
    {
      if (parame == null) {}
      for (;;)
      {
        parame = new i();
        parame.d = 0;
        parame.e = 0;
        parame.a = false;
        parame.c = 0;
        parame.b = false;
        this.g.add(0, parame);
        do
        {
          int j = this.f;
          int i = this.d;
          int m = this.g.size() - 1;
          if (m < 0) {
            return;
          }
          parame = (i)this.g.get(m);
          int i2 = parame.d;
          int n = parame.c;
          int i1 = parame.e;
          int k;
          if (this.b)
          {
            for (;;)
            {
              k = i;
              if (j <= i2 + n) {
                break;
              }
              k = j - 1;
              if (this.e[k] == 0)
              {
                a(j, i, m, false);
                j = k;
              }
              else
              {
                j = k;
              }
            }
            while (k > n + i1)
            {
              i = k - 1;
              if (this.c[i] == 0)
              {
                a(j, k, m, true);
                k = i;
              }
              else
              {
                k = i;
              }
            }
            i = 0;
          }
          for (;;)
          {
            if (i < parame.c)
            {
              k = parame.d + i;
              n = parame.e + i;
              if (!this.a.b(k, n)) {}
              for (j = 2;; j = 1)
              {
                this.e[k] = (n << 5 | j);
                this.c[n] = (j | k << 5);
                i += 1;
                break;
              }
            }
            j = parame.d;
            i = parame.e;
            m -= 1;
            break;
            i = 0;
          }
          if (parame.d != 0) {
            break;
          }
        } while (parame.e == 0);
      }
    }
  }
  
  private static g a(List paramList, int paramInt, boolean paramBoolean)
  {
    int i = paramList.size() - 1;
    g localg1;
    if (i >= 0)
    {
      g localg2 = (g)paramList.get(i);
      if (localg2.b != paramInt) {}
      while (localg2.c != paramBoolean)
      {
        i -= 1;
        break;
      }
      paramList.remove(i);
      paramInt = i;
      localg1 = localg2;
      if (paramInt < paramList.size())
      {
        localg1 = (g)paramList.get(paramInt);
        int j = localg1.a;
        if (!paramBoolean) {}
        for (i = -1;; i = 1)
        {
          localg1.a = (i + j);
          paramInt += 1;
          break;
        }
      }
    }
    else
    {
      localg1 = null;
    }
    return localg1;
  }
  
  private final boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int m = 4;
    int i;
    if (!paramBoolean) {
      i = paramInt1 - 1;
    }
    for (int j = i;; j = paramInt2)
    {
      int k = i;
      i = paramInt2;
      paramInt2 = k;
      if (paramInt3 >= 0)
      {
        i locali = (i)this.g.get(paramInt3);
        int n = locali.d;
        k = locali.c;
        int i1 = locali.e;
        if (!paramBoolean)
        {
          paramInt2 = i - 1;
          label77:
          if (paramInt2 >= k + i1) {}
        }
        for (;;)
        {
          paramInt2 = locali.d;
          i = locali.e;
          paramInt3 -= 1;
          break;
          if (!this.a.a(j, paramInt2))
          {
            paramInt2 -= 1;
            break label77;
          }
          if (!this.a.b(j, paramInt2)) {}
          for (paramInt3 = 4;; paramInt3 = 8)
          {
            paramInt1 -= 1;
            this.e[paramInt1] = (paramInt2 << 5 | 0x10);
            this.c[paramInt2] = (paramInt3 | paramInt1 << 5);
            return true;
          }
          paramInt2 -= 1;
          while (paramInt2 >= n + k)
          {
            if (this.a.a(paramInt2, j)) {
              break label209;
            }
            paramInt2 -= 1;
          }
        }
        label209:
        if (!this.a.b(paramInt2, j)) {}
        for (paramInt1 = m;; paramInt1 = 8)
        {
          this.c[j] = (paramInt2 << 5 | 0x10);
          this.e[paramInt2] = (j << 5 | paramInt1);
          return true;
        }
      }
      return false;
      paramInt2 -= 1;
      i = paramInt1;
    }
  }
  
  public final void a(j paramj)
  {
    if ((paramj instanceof b)) {}
    for (paramj = (b)paramj;; paramj = new b(paramj))
    {
      ArrayList localArrayList = new ArrayList();
      int k = this.f;
      int j = this.d;
      int i = this.g.size() - 1;
      if (i >= 0)
      {
        i locali = (i)this.g.get(i);
        int n = locali.c;
        int i1 = locali.d + n;
        int i2 = locali.e + n;
        int m;
        int i3;
        Object localObject;
        if (i1 < k)
        {
          k -= i1;
          if (this.b)
          {
            k -= 1;
            if (k >= 0)
            {
              m = i1 + k;
              i3 = this.e[m];
              int i4 = i3 & 0x1F;
              switch (i4)
              {
              default: 
                paramj = new StringBuilder();
                paramj.append("unknown flag for pos ");
                paramj.append(m);
                paramj.append(" ");
                paramj.append(Long.toBinaryString(i4));
                throw new IllegalStateException(paramj.toString());
              case 0: 
                paramj.b(m, 1);
                i3 = localArrayList.size();
                m = 0;
              case 16: 
                while (m < i3)
                {
                  localObject = (g)localArrayList.get(m);
                  ((g)localObject).a -= 1;
                  m += 1;
                  continue;
                  localArrayList.add(new g(m, m, true));
                }
              }
              for (;;)
              {
                k -= 1;
                break;
                localObject = a(localArrayList, i3 >> 5, false);
                paramj.c(m, ((g)localObject).a - 1);
                if (i4 == 4) {
                  paramj.a(((g)localObject).a - 1, 1, this.a.a(m));
                }
              }
            }
          }
          else
          {
            paramj.b(i1, k);
          }
        }
        if (i2 < j)
        {
          j -= i2;
          if (this.b)
          {
            j -= 1;
            if (j >= 0)
            {
              m = i2 + j;
              i3 = this.c[m];
              k = i3 & 0x1F;
              switch (k)
              {
              default: 
                paramj = new StringBuilder();
                paramj.append("unknown flag for pos ");
                paramj.append(m);
                paramj.append(" ");
                paramj.append(Long.toBinaryString(k));
                throw new IllegalStateException(paramj.toString());
              case 0: 
                paramj.a(i1, 1);
                m = localArrayList.size();
                k = 0;
              case 16: 
                while (k < m)
                {
                  localObject = (g)localArrayList.get(k);
                  ((g)localObject).a += 1;
                  k += 1;
                  continue;
                  localArrayList.add(new g(m, i1, false));
                }
              }
              for (;;)
              {
                j -= 1;
                break;
                m = i3 >> 5;
                paramj.c(a(localArrayList, m, true).a, i1);
                if (k == 4) {
                  paramj.a(i1, 1, this.a.a(m));
                }
              }
            }
          }
          else
          {
            paramj.a(i1, j);
          }
        }
        j = n - 1;
        for (;;)
        {
          if (j < 0)
          {
            k = locali.d;
            j = locali.e;
            i -= 1;
            break;
          }
          localObject = this.e;
          k = locali.d + j;
          if ((localObject[k] & 0x1F) == 2) {
            paramj.a(k, 1, this.a.a(k));
          }
          j -= 1;
        }
      }
      paramj.a();
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/g/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */