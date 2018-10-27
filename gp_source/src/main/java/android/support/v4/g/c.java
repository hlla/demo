package android.support.v4.g;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class c
  implements Collection, Set
{
  private static final int[] c = new int[0];
  private static final Object[] d = new Object[0];
  private static Object[] g;
  private static int h;
  private static Object[] i;
  private static int j;
  public Object[] a;
  public int b;
  private j e;
  private int[] f;
  
  public c()
  {
    this(0);
  }
  
  public c(int paramInt)
  {
    if (paramInt == 0)
    {
      this.f = c;
      this.a = d;
    }
    for (;;)
    {
      this.b = 0;
      return;
      b(paramInt);
    }
  }
  
  public c(Collection paramCollection)
  {
    this();
    if (paramCollection != null) {
      addAll(paramCollection);
    }
  }
  
  private final int a()
  {
    int i1 = this.b;
    if (i1 != 0)
    {
      int m = e.a(this.f, i1, 0);
      int k = m;
      int n;
      if (m >= 0)
      {
        k = m;
        if (this.a[m] != null) {
          n = m + 1;
        }
      }
      for (;;)
      {
        if (n >= i1) {}
        label88:
        while (this.f[n] != 0)
        {
          m -= 1;
          while ((m >= 0) && (this.f[m] == 0))
          {
            k = m;
            if (this.a[m] == null) {
              break label88;
            }
            m -= 1;
          }
          k = n ^ 0xFFFFFFFF;
          return k;
        }
        if (this.a[n] == null) {
          break;
        }
        n += 1;
      }
      return n;
    }
    return -1;
  }
  
  private final int a(Object paramObject, int paramInt)
  {
    int i1 = this.b;
    if (i1 != 0)
    {
      int m = e.a(this.f, i1, paramInt);
      int k = m;
      int n;
      if (m >= 0)
      {
        k = m;
        if (!paramObject.equals(this.a[m])) {
          n = m + 1;
        }
      }
      for (;;)
      {
        if (n >= i1) {}
        label114:
        while (this.f[n] != paramInt)
        {
          m -= 1;
          while ((m >= 0) && (this.f[m] == paramInt))
          {
            k = m;
            if (paramObject.equals(this.a[m])) {
              break label114;
            }
            m -= 1;
          }
          k = n ^ 0xFFFFFFFF;
          return k;
        }
        if (paramObject.equals(this.a[n])) {
          break;
        }
        n += 1;
      }
      return n;
    }
    return -1;
  }
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    int k = paramArrayOfInt.length;
    if (k == 8) {}
    try
    {
      if (j < 10)
      {
        paramArrayOfObject[0] = i;
        paramArrayOfObject[1] = paramArrayOfInt;
        paramInt -= 1;
      }
      for (;;)
      {
        if (paramInt < 2)
        {
          i = paramArrayOfObject;
          j += 1;
          return;
        }
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      if (k == 4) {
        for (;;)
        {
          try
          {
            if (h < 10)
            {
              paramArrayOfObject[0] = g;
              paramArrayOfObject[1] = paramArrayOfInt;
              paramInt -= 1;
              if (paramInt < 2)
              {
                g = paramArrayOfObject;
                h += 1;
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
  
  private final void b(int paramInt)
  {
    if (paramInt == 8) {}
    for (;;)
    {
      Object[] arrayOfObject;
      try
      {
        if (i != null)
        {
          arrayOfObject = i;
          this.a = arrayOfObject;
          i = (Object[])arrayOfObject[0];
          this.f = ((int[])arrayOfObject[1]);
          arrayOfObject[1] = null;
          arrayOfObject[0] = null;
          j -= 1;
          return;
        }
        this.f = new int[paramInt];
        this.a = new Object[paramInt];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (g != null)
          {
            arrayOfObject = g;
            this.a = arrayOfObject;
            g = (Object[])arrayOfObject[0];
            this.f = ((int[])arrayOfObject[1]);
            arrayOfObject[1] = null;
            arrayOfObject[0] = null;
            h -= 1;
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
  
  public final Object a(int paramInt)
  {
    int k = 8;
    Object[] arrayOfObject = this.a;
    Object localObject = arrayOfObject[paramInt];
    int m = this.b;
    if (m <= 1)
    {
      a(this.f, arrayOfObject, m);
      this.f = c;
      this.a = d;
      this.b = 0;
    }
    int[] arrayOfInt;
    do
    {
      return localObject;
      arrayOfInt = this.f;
      int n = arrayOfInt.length;
      if ((n <= 8) || (m >= n / 3))
      {
        this.b = (m - 1);
        k = this.b;
        if (paramInt < k)
        {
          m = paramInt + 1;
          System.arraycopy(arrayOfInt, m, arrayOfInt, paramInt, k - paramInt);
          arrayOfObject = this.a;
          System.arraycopy(arrayOfObject, m, arrayOfObject, paramInt, this.b - paramInt);
        }
        this.a[this.b] = null;
        return localObject;
      }
      if (m > 8) {
        k = (m >> 1) + m;
      }
      b(k);
      this.b -= 1;
      if (paramInt > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.f, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.a, 0, paramInt);
      }
      k = this.b;
    } while (paramInt >= k);
    m = paramInt + 1;
    System.arraycopy(arrayOfInt, m, this.f, paramInt, k - paramInt);
    System.arraycopy(arrayOfObject, m, this.a, paramInt, this.b - paramInt);
    return localObject;
  }
  
  public final boolean add(Object paramObject)
  {
    int n = 8;
    int m;
    int k;
    if (paramObject != null)
    {
      m = paramObject.hashCode();
      k = a(paramObject, m);
    }
    for (;;)
    {
      if (k < 0)
      {
        int i1 = k ^ 0xFFFFFFFF;
        int i3 = this.b;
        Object localObject = this.f;
        int i2 = localObject.length;
        if (i3 < i2)
        {
          k = this.b;
          if (i1 < k)
          {
            localObject = this.f;
            n = i1 + 1;
            System.arraycopy(localObject, i1, localObject, n, k - i1);
            localObject = this.a;
            System.arraycopy(localObject, i1, localObject, n, this.b - i1);
          }
          this.f[i1] = m;
          this.a[i1] = paramObject;
          this.b += 1;
          return true;
        }
        if (i3 >= 8) {
          k = (i3 >> 1) + i3;
        }
        for (;;)
        {
          Object[] arrayOfObject = this.a;
          b(k);
          int[] arrayOfInt = this.f;
          if (arrayOfInt.length > 0)
          {
            System.arraycopy(localObject, 0, arrayOfInt, 0, i2);
            System.arraycopy(arrayOfObject, 0, this.a, 0, arrayOfObject.length);
          }
          a((int[])localObject, arrayOfObject, this.b);
          break;
          k = n;
          if (i3 < 4) {
            k = 4;
          }
        }
      }
      return false;
      k = a();
      m = 0;
    }
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    boolean bool = false;
    int k = this.b + paramCollection.size();
    int[] arrayOfInt = this.f;
    if (arrayOfInt.length < k)
    {
      Object[] arrayOfObject = this.a;
      b(k);
      k = this.b;
      if (k > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.f, 0, k);
        System.arraycopy(arrayOfObject, 0, this.a, 0, this.b);
      }
      a(arrayOfInt, arrayOfObject, this.b);
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      bool |= add(paramCollection.next());
    }
    return (byte)bool;
  }
  
  public final void clear()
  {
    int k = this.b;
    if (k != 0)
    {
      a(this.f, this.a, k);
      this.f = c;
      this.a = d;
      this.b = 0;
    }
  }
  
  public final boolean contains(Object paramObject)
  {
    return a(paramObject) >= 0;
  }
  
  public final boolean containsAll(Collection paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    int k;
    if (this != paramObject)
    {
      bool1 = bool2;
      if ((paramObject instanceof Set))
      {
        paramObject = (Set)paramObject;
        bool1 = bool2;
        if (size() == ((Set)paramObject).size()) {
          k = 0;
        }
      }
    }
    try
    {
      while (k < this.b)
      {
        boolean bool3 = ((Set)paramObject).contains(this.a[k]);
        bool1 = bool2;
        if (!bool3) {
          break label80;
        }
        k += 1;
      }
      bool1 = true;
      label80:
      return bool1;
    }
    catch (ClassCastException paramObject)
    {
      return false;
    }
    catch (NullPointerException paramObject) {}
    return true;
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int[] arrayOfInt = this.f;
    int n = this.b;
    int m = 0;
    while (k < n)
    {
      m += arrayOfInt[k];
      k += 1;
    }
    return m;
  }
  
  public final boolean isEmpty()
  {
    return this.b <= 0;
  }
  
  public final Iterator iterator()
  {
    if (this.e == null) {
      this.e = new d(this);
    }
    return this.e.d().iterator();
  }
  
  public final boolean remove(Object paramObject)
  {
    int k = a(paramObject);
    if (k >= 0)
    {
      a(k);
      return true;
    }
    return false;
  }
  
  public final boolean removeAll(Collection paramCollection)
  {
    paramCollection = paramCollection.iterator();
    boolean bool = false;
    while (paramCollection.hasNext()) {
      bool |= remove(paramCollection.next());
    }
    return (byte)bool;
  }
  
  public final boolean retainAll(Collection paramCollection)
  {
    int k = this.b;
    boolean bool = false;
    k -= 1;
    while (k >= 0)
    {
      if (!paramCollection.contains(this.a[k]))
      {
        a(k);
        bool = true;
      }
      k -= 1;
    }
    return bool;
  }
  
  public final int size()
  {
    return this.b;
  }
  
  public final Object[] toArray()
  {
    int k = this.b;
    Object[] arrayOfObject = new Object[k];
    System.arraycopy(this.a, 0, arrayOfObject, 0, k);
    return arrayOfObject;
  }
  
  public final Object[] toArray(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length < this.b) {
      paramArrayOfObject = (Object[])Array.newInstance(paramArrayOfObject.getClass().getComponentType(), this.b);
    }
    for (;;)
    {
      System.arraycopy(this.a, 0, paramArrayOfObject, 0, this.b);
      int k = paramArrayOfObject.length;
      int m = this.b;
      if (k > m) {
        paramArrayOfObject[m] = null;
      }
      return paramArrayOfObject;
    }
  }
  
  public final String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.b * 14);
    localStringBuilder.append('{');
    int k = 0;
    if (k < this.b)
    {
      if (k <= 0) {}
      for (;;)
      {
        Object localObject = this.a[k];
        if (localObject == this) {
          localStringBuilder.append("(this Set)");
        }
        for (;;)
        {
          k += 1;
          break;
          localStringBuilder.append(localObject);
        }
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */