package android.support.v7.g;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class c
{
  private static final Comparator a = new d();
  
  public static f a(e parame)
  {
    return a(parame, true);
  }
  
  public static f a(e parame, boolean paramBoolean)
  {
    int i = parame.a();
    int j = parame.b();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new h(i, j));
    int i2 = i + j + Math.abs(i - j);
    i = i2 + i2;
    int[] arrayOfInt1 = new int[i];
    int[] arrayOfInt2 = new int[i];
    ArrayList localArrayList3 = new ArrayList();
    if (!localArrayList2.isEmpty())
    {
      h localh2 = (h)localArrayList2.remove(localArrayList2.size() - 1);
      int i3 = localh2.d;
      i = localh2.c;
      int i4 = localh2.b;
      int i5 = i - i3;
      int i6 = localh2.a - i4;
      Object localObject;
      if (i5 <= 0) {
        localObject = null;
      }
      for (;;)
      {
        if (localObject == null)
        {
          localArrayList3.add(localh2);
          break;
        }
        if (((i)localObject).c > 0) {
          localArrayList1.add(localObject);
        }
        ((i)localObject).d += localh2.d;
        ((i)localObject).e += localh2.b;
        if (localArrayList3.isEmpty()) {}
        for (h localh1 = new h();; localh1 = (h)localArrayList3.remove(localArrayList3.size() - 1))
        {
          localh1.d = localh2.d;
          localh1.b = localh2.b;
          if (((i)localObject).b)
          {
            localh1.c = ((i)localObject).d;
            localh1.a = ((i)localObject).e;
          }
          for (;;)
          {
            localArrayList2.add(localh1);
            if (((i)localObject).b) {
              if (((i)localObject).a)
              {
                i = ((i)localObject).d;
                j = ((i)localObject).c;
                localh2.d = (i + j + 1);
                localh2.b = (((i)localObject).e + j);
              }
            }
            for (;;)
            {
              localArrayList2.add(localh2);
              break;
              i = ((i)localObject).d;
              j = ((i)localObject).c;
              localh2.d = (i + j);
              localh2.b = (((i)localObject).e + j + 1);
              continue;
              i = ((i)localObject).d;
              j = ((i)localObject).c;
              localh2.d = (i + j);
              localh2.b = (((i)localObject).e + j);
            }
            if (((i)localObject).a)
            {
              localh1.c = (((i)localObject).d - 1);
              localh1.a = ((i)localObject).e;
            }
            else
            {
              localh1.c = ((i)localObject).d;
              localh1.a = (((i)localObject).e - 1);
            }
          }
        }
        if (i6 > 0)
        {
          int i7 = i5 - i6;
          int i8 = (i5 + i6 + 1) / 2;
          i = i2 - i8 - 1;
          j = i2 + i8 + 1;
          Arrays.fill(arrayOfInt1, i, j, 0);
          Arrays.fill(arrayOfInt2, i + i7, j + i7, i5);
          int i9 = i7 % 2;
          j = 0;
          int k;
          int m;
          boolean bool;
          int n;
          int i1;
          for (;;)
          {
            if (j > i8) {
              break label1164;
            }
            k = -j;
            m = k;
            if (m <= j) {
              break label882;
            }
            m = k;
            if (m <= j)
            {
              int i10 = m + i7;
              if (i10 == j + i7) {}
              for (;;)
              {
                i = arrayOfInt2[(i2 + i10 - 1)];
                bool = false;
                n = i;
                i1 = i - i10;
                i = n;
                n = i1;
                for (;;)
                {
                  if (i <= 0) {}
                  while ((n <= 0) || (!parame.a(i3 + i - 1, i4 + n - 1)))
                  {
                    n = i2 + i10;
                    arrayOfInt2[n] = i;
                    if (i9 != 0) {}
                    while ((i10 < k) || (i10 > j) || (arrayOfInt1[n] < arrayOfInt2[n]))
                    {
                      m += 2;
                      break;
                    }
                    localObject = new i();
                    i = arrayOfInt2[n];
                    ((i)localObject).d = i;
                    ((i)localObject).e = (((i)localObject).d - i10);
                    ((i)localObject).c = (arrayOfInt1[n] - i);
                    ((i)localObject).a = bool;
                    ((i)localObject).b = true;
                    break;
                  }
                  i -= 1;
                  n -= 1;
                }
                if (i10 == k + i7) {}
                do
                {
                  i = arrayOfInt2[(i2 + i10 + 1)] - 1;
                  bool = true;
                  break;
                  i = i2 + i10;
                } while (arrayOfInt2[(i - 1)] >= arrayOfInt2[(i + 1)]);
              }
            }
            j += 1;
          }
          label882:
          if (m == k) {}
          for (;;)
          {
            i = arrayOfInt1[(i2 + m + 1)];
            bool = false;
            n = i;
            i1 = i - m;
            i = n;
            n = i1;
            for (;;)
            {
              if (i >= i5) {}
              while ((n >= i6) || (!parame.a(i3 + i, i4 + n)))
              {
                n = i2 + m;
                arrayOfInt1[n] = i;
                if (i9 == 0) {}
                while ((m < i7 - j + 1) || (m > i7 + j - 1) || (arrayOfInt1[n] < arrayOfInt2[n]))
                {
                  m += 2;
                  break;
                }
                localObject = new i();
                i = arrayOfInt2[n];
                ((i)localObject).d = i;
                ((i)localObject).e = (((i)localObject).d - m);
                ((i)localObject).c = (arrayOfInt1[n] - i);
                ((i)localObject).a = bool;
                ((i)localObject).b = false;
                break;
              }
              i += 1;
              n += 1;
            }
            if (m == j) {}
            do
            {
              i = arrayOfInt1[(i2 + m - 1)] + 1;
              bool = true;
              break;
              i = i2 + m;
            } while (arrayOfInt1[(i - 1)] >= arrayOfInt1[(i + 1)]);
          }
        }
        localObject = null;
      }
    }
    Collections.sort(localArrayList1, a);
    return new f(parame, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
    label1164:
    throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/g/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */