package android.support.v4.g;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class v
{
  private static Object[] c;
  private static int d;
  private static Object[] f;
  private static int g;
  public Object[] a;
  public int b;
  private int[] e;
  
  public v()
  {
    this.e = e.a;
    this.a = e.c;
    this.b = 0;
  }
  
  public v(int paramInt)
  {
    if (paramInt == 0)
    {
      this.e = e.a;
      this.a = e.c;
    }
    for (;;)
    {
      this.b = 0;
      return;
      e(paramInt);
    }
  }
  
  public v(v paramv)
  {
    this();
    if (paramv != null)
    {
      int j = paramv.b;
      a(this.b + j);
      if (this.b != 0) {
        while (i < j)
        {
          put(paramv.b(i), paramv.c(i));
          i += 1;
        }
      }
      if (j > 0)
      {
        System.arraycopy(paramv.e, 0, this.e, 0, j);
        System.arraycopy(paramv.a, 0, this.a, 0, j + j);
        this.b = j;
      }
    }
  }
  
  private final int a()
  {
    int m = this.b;
    if (m != 0)
    {
      int j = a(this.e, m, 0);
      int i = j;
      int k;
      if (j >= 0)
      {
        i = j;
        if (this.a[(j + j)] != null) {
          k = j + 1;
        }
      }
      for (;;)
      {
        if (k >= m) {}
        label92:
        while (this.e[k] != 0)
        {
          j -= 1;
          while ((j >= 0) && (this.e[j] == 0))
          {
            i = j;
            if (this.a[(j + j)] == null) {
              break label92;
            }
            j -= 1;
          }
          i = k ^ 0xFFFFFFFF;
          return i;
        }
        if (this.a[(k + k)] == null) {
          break;
        }
        k += 1;
      }
      return k;
    }
    return -1;
  }
  
  private final int a(Object paramObject, int paramInt)
  {
    int m = this.b;
    if (m != 0)
    {
      int j = a(this.e, m, paramInt);
      int i = j;
      int k;
      if (j >= 0)
      {
        i = j;
        if (!paramObject.equals(this.a[(j + j)])) {
          k = j + 1;
        }
      }
      for (;;)
      {
        if (k >= m) {}
        label120:
        while (this.e[k] != paramInt)
        {
          j -= 1;
          while ((j >= 0) && (this.e[j] == paramInt))
          {
            i = j;
            if (paramObject.equals(this.a[(j + j)])) {
              break label120;
            }
            j -= 1;
          }
          i = k ^ 0xFFFFFFFF;
          return i;
        }
        if (paramObject.equals(this.a[(k + k)])) {
          break;
        }
        k += 1;
      }
      return k;
    }
    return -1;
  }
  
  private static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = e.a(paramArrayOfInt, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (ArrayIndexOutOfBoundsException paramArrayOfInt)
    {
      throw new ConcurrentModificationException();
    }
  }
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    int i = paramArrayOfInt.length;
    if (i == 8) {}
    try
    {
      if (g < 10)
      {
        paramArrayOfObject[0] = f;
        paramArrayOfObject[1] = paramArrayOfInt;
        paramInt = paramInt + paramInt - 1;
      }
      for (;;)
      {
        if (paramInt < 2)
        {
          f = paramArrayOfObject;
          g += 1;
          return;
        }
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      if (i == 4) {
        for (;;)
        {
          try
          {
            if (d < 10)
            {
              paramArrayOfObject[0] = c;
              paramArrayOfObject[1] = paramArrayOfInt;
              paramInt = paramInt + paramInt - 1;
              if (paramInt < 2)
              {
                c = paramArrayOfObject;
                d += 1;
              }
            }
            else
            {
              return;
            }
          }
          finally {}
          paramArrayOfObject[paramInt] = null;
          paramInt -= 1;
        }
      }
      return;
    }
    finally {}
  }
  
  private final void e(int paramInt)
  {
    if (paramInt == 8) {}
    for (;;)
    {
      Object[] arrayOfObject;
      try
      {
        if (f != null)
        {
          arrayOfObject = f;
          this.a = arrayOfObject;
          f = (Object[])arrayOfObject[0];
          this.e = ((int[])arrayOfObject[1]);
          arrayOfObject[1] = null;
          arrayOfObject[0] = null;
          g -= 1;
          return;
        }
        this.e = new int[paramInt];
        this.a = new Object[paramInt + paramInt];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (c != null)
          {
            arrayOfObject = c;
            this.a = arrayOfObject;
            c = (Object[])arrayOfObject[0];
            this.e = ((int[])arrayOfObject[1]);
            arrayOfObject[1] = null;
            arrayOfObject[0] = null;
            d -= 1;
            return;
          }
        }
        finally {}
      }
    }
  }
  
  public final int a(Object paramObject)
  {
    if (paramObject != null) {
      return a(paramObject, paramObject.hashCode());
    }
    return a();
  }
  
  public final void a(int paramInt)
  {
    int i = this.b;
    int[] arrayOfInt = this.e;
    if (arrayOfInt.length < paramInt)
    {
      Object[] arrayOfObject = this.a;
      e(paramInt);
      if (this.b > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.e, 0, i);
        System.arraycopy(arrayOfObject, 0, this.a, 0, i + i);
      }
      a(arrayOfInt, arrayOfObject, i);
    }
    if (this.b != i) {
      throw new ConcurrentModificationException();
    }
  }
  
  final int b(Object paramObject)
  {
    int i = 1;
    int j = 1;
    int k = this.b;
    k += k;
    Object[] arrayOfObject = this.a;
    if (paramObject != null)
    {
      i = j;
      while (i < k) {
        if (!paramObject.equals(arrayOfObject[i])) {
          i += 2;
        } else {
          return i >> 1;
        }
      }
    }
    for (;;)
    {
      return -1;
      while (i < k)
      {
        if (arrayOfObject[i] == null) {
          break label79;
        }
        i += 2;
      }
    }
    label79:
    return i >> 1;
  }
  
  public final Object b(int paramInt)
  {
    return this.a[(paramInt + paramInt)];
  }
  
  public final Object c(int paramInt)
  {
    return this.a[(paramInt + paramInt + 1)];
  }
  
  public void clear()
  {
    int i = this.b;
    if (i > 0)
    {
      int[] arrayOfInt = this.e;
      Object[] arrayOfObject = this.a;
      this.e = e.a;
      this.a = e.c;
      this.b = 0;
      a(arrayOfInt, arrayOfObject, i);
    }
    if (this.b > 0) {
      throw new ConcurrentModificationException();
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    return a(paramObject) >= 0;
  }
  
  public boolean containsValue(Object paramObject)
  {
    return b(paramObject) >= 0;
  }
  
  public final Object d(int paramInt)
  {
    int j = 8;
    int i = 0;
    Object[] arrayOfObject = this.a;
    int m = paramInt + paramInt;
    Object localObject = arrayOfObject[(m + 1)];
    int k = this.b;
    if (k <= 1)
    {
      a(this.e, arrayOfObject, k);
      this.e = e.a;
      this.a = e.c;
      paramInt = i;
    }
    for (;;)
    {
      if (k != this.b) {
        throw new ConcurrentModificationException();
      }
      this.b = paramInt;
      return localObject;
      i = k - 1;
      int[] arrayOfInt = this.e;
      int n = arrayOfInt.length;
      if ((n <= 8) || (k >= n / 3))
      {
        if (paramInt < i)
        {
          j = paramInt + 1;
          n = i - paramInt;
          System.arraycopy(arrayOfInt, j, arrayOfInt, paramInt, n);
          arrayOfObject = this.a;
          System.arraycopy(arrayOfObject, j + j, arrayOfObject, m, n + n);
        }
        arrayOfObject = this.a;
        paramInt = i + i;
        arrayOfObject[paramInt] = null;
        arrayOfObject[(paramInt + 1)] = null;
        paramInt = i;
      }
      else
      {
        if (k > 8) {
          j = (k >> 1) + k;
        }
        e(j);
        if (k != this.b) {
          throw new ConcurrentModificationException();
        }
        if (paramInt > 0)
        {
          System.arraycopy(arrayOfInt, 0, this.e, 0, paramInt);
          System.arraycopy(arrayOfObject, 0, this.a, 0, m);
        }
        if (paramInt < i)
        {
          j = paramInt + 1;
          n = i - paramInt;
          System.arraycopy(arrayOfInt, j, this.e, paramInt, n);
          System.arraycopy(arrayOfObject, j + j, this.a, m, n + n);
          paramInt = i;
        }
        else
        {
          paramInt = i;
        }
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    int i;
    if (this != paramObject)
    {
      if ((paramObject instanceof v))
      {
        paramObject = (v)paramObject;
        if (size() == ((v)paramObject).size()) {
          i = 0;
        }
      }
      label94:
      do
      {
        do
        {
          try
          {
            if (i < this.b)
            {
              localObject1 = b(i);
              localObject2 = c(i);
              localObject3 = ((v)paramObject).get(localObject1);
              if (localObject2 != null)
              {
                if (localObject2.equals(localObject3)) {
                  break;
                }
              }
              else if (localObject3 == null)
              {
                bool = ((v)paramObject).containsKey(localObject1);
                if (bool) {
                  break;
                }
              }
              return false;
            }
            return true;
          }
          catch (ClassCastException paramObject)
          {
            Object localObject1;
            Object localObject2;
            Object localObject3;
            boolean bool;
            return false;
          }
          catch (NullPointerException paramObject)
          {
            return false;
          }
        } while (!(paramObject instanceof Map));
        paramObject = (Map)paramObject;
      } while (size() != ((Map)paramObject).size());
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < this.b)
        {
          localObject1 = b(i);
          localObject2 = c(i);
          localObject3 = ((Map)paramObject).get(localObject1);
          if (localObject2 != null)
          {
            if (!localObject2.equals(localObject3)) {
              break label94;
            }
            break label218;
          }
          if (localObject3 != null) {
            break label94;
          }
          bool = ((Map)paramObject).containsKey(localObject1);
          if (bool) {
            break label218;
          }
          return false;
        }
        return true;
      }
      catch (ClassCastException paramObject)
      {
        return false;
      }
      catch (NullPointerException paramObject)
      {
        return false;
      }
      return true;
      i += 1;
      break;
      label218:
      i += 1;
    }
  }
  
  public Object get(Object paramObject)
  {
    int i = a(paramObject);
    if (i >= 0) {
      return this.a[(i + i + 1)];
    }
    return null;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = this.e;
    Object[] arrayOfObject = this.a;
    int n = this.b;
    int i = 1;
    int j = 0;
    int k = 0;
    if (j < n)
    {
      Object localObject = arrayOfObject[i];
      int i1 = arrayOfInt[j];
      if (localObject != null) {}
      for (int m = localObject.hashCode();; m = 0)
      {
        k += (m ^ i1);
        j += 1;
        i += 2;
        break;
      }
    }
    return k;
  }
  
  public boolean isEmpty()
  {
    return this.b <= 0;
  }
  
  public Object put(Object paramObject1, Object paramObject2)
  {
    int k = 8;
    int m = this.b;
    int i;
    int j;
    if (paramObject1 == null)
    {
      i = a();
      j = 0;
    }
    for (;;)
    {
      if (i >= 0)
      {
        i = i + i + 1;
        paramObject1 = this.a;
        localObject = paramObject1[i];
        paramObject1[i] = paramObject2;
        return localObject;
      }
      int n = i ^ 0xFFFFFFFF;
      Object localObject = this.e;
      int i1 = localObject.length;
      if (m >= i1)
      {
        if (m < 8) {
          break label305;
        }
        i = (m >> 1) + m;
      }
      for (;;)
      {
        Object[] arrayOfObject = this.a;
        e(i);
        if (m != this.b) {
          throw new ConcurrentModificationException();
        }
        int[] arrayOfInt = this.e;
        if (arrayOfInt.length > 0)
        {
          System.arraycopy(localObject, 0, arrayOfInt, 0, i1);
          System.arraycopy(arrayOfObject, 0, this.a, 0, arrayOfObject.length);
        }
        a((int[])localObject, arrayOfObject, m);
        if (n < m)
        {
          localObject = this.e;
          i = n + 1;
          System.arraycopy(localObject, n, localObject, i, m - n);
          localObject = this.a;
          k = this.b - n;
          System.arraycopy(localObject, n + n, localObject, i + i, k + k);
        }
        i = this.b;
        if (m == i)
        {
          localObject = this.e;
          if (n < localObject.length) {}
        }
        else
        {
          throw new ConcurrentModificationException();
        }
        localObject[n] = j;
        localObject = this.a;
        j = n + n;
        localObject[j] = paramObject1;
        localObject[(j + 1)] = paramObject2;
        this.b = (i + 1);
        return null;
        label305:
        i = k;
        if (m < 4) {
          i = 4;
        }
      }
      j = paramObject1.hashCode();
      i = a(paramObject1, j);
    }
  }
  
  public Object remove(Object paramObject)
  {
    int i = a(paramObject);
    if (i < 0) {
      return null;
    }
    return d(i);
  }
  
  public int size()
  {
    return this.b;
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.b * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.b)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = b(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        localStringBuilder.append('=');
        localObject = c(i);
        if (localObject == this) {
          localStringBuilder.append("(this Map)");
        }
        for (;;)
        {
          i += 1;
          break;
          localStringBuilder.append(localObject);
        }
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */