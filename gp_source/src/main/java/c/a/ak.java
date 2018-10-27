package c.a;

import java.util.Arrays;

public abstract class ak
  extends d
  implements am
{
  public static final Object d = new Object();
  public static final Object e = new Object();
  public am f = this;
  public transient Object[] g;
  
  protected static void b(Object paramObject1, Object paramObject2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Equal objects must have equal hashcodes. During rehashing, Trove discovered that the following two objects claim to be equal (as in java.lang.Object.equals()) but their hashCodes (or those calculated by your TObjectHashingStrategy) are not equal.This violates the general contract of java.lang.Object.hashCode().  See bullet point two in that method's documentation. object #1 =");
    localStringBuilder.append(paramObject1);
    localStringBuilder.append("; object #2 =");
    localStringBuilder.append(paramObject2);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  protected final int a()
  {
    return this.g.length;
  }
  
  protected final int a(Object paramObject)
  {
    am localam = this.f;
    Object[] arrayOfObject = this.g;
    int k = arrayOfObject.length;
    int m = localam.c(paramObject) & 0x7FFFFFFF;
    int j = m % k;
    Object localObject2 = arrayOfObject[j];
    if (localObject2 != d)
    {
      Object localObject1;
      int i;
      if (localObject2 != e)
      {
        localObject1 = localObject2;
        i = j;
        if (localam.a(localObject2, paramObject)) {}
      }
      else
      {
        j -= m % (k - 2) + 1;
        i = j;
        if (j < 0) {
          i = j + k;
        }
        localObject1 = arrayOfObject[i];
        if (localObject1 != d) {
          break label126;
        }
      }
      for (;;)
      {
        if (localObject1 == d) {
          i = -1;
        }
        return i;
        label126:
        j = i;
        if (localObject1 == e) {
          break;
        }
        j = i;
        if (!this.f.a(localObject1, paramObject)) {
          break;
        }
      }
    }
    return -1;
  }
  
  public final boolean a(ao paramao)
  {
    Object[] arrayOfObject = this.g;
    int i = arrayOfObject.length;
    for (;;)
    {
      int j = i - 1;
      if (i <= 0) {
        break;
      }
      if (arrayOfObject[j] != d)
      {
        if (arrayOfObject[j] != e)
        {
          if (paramao.execute(arrayOfObject[j])) {
            i = j;
          } else {
            return false;
          }
        }
        else {
          i = j;
        }
      }
      else {
        i = j;
      }
    }
    return true;
  }
  
  public final boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 != null) {
      return paramObject1.equals(paramObject2);
    }
    return paramObject2 == null;
  }
  
  protected final int b(Object paramObject)
  {
    am localam = this.f;
    Object[] arrayOfObject = this.g;
    int m = arrayOfObject.length;
    int k = localam.c(paramObject) & 0x7FFFFFFF;
    int i = k % m;
    Object localObject1 = arrayOfObject[i];
    int j = i;
    int n;
    if (localObject1 != d)
    {
      if ((localObject1 != e) && (localam.a(localObject1, paramObject))) {
        break label272;
      }
      n = k % (m - 2) + 1;
      j = i;
      if (localObject1 != e) {
        break label200;
      }
      if (localObject1 != e) {
        break label185;
      }
      k = i;
      if (localObject1 != d)
      {
        if (localObject1 == e) {}
        while (!localam.a(localObject1, paramObject))
        {
          k -= n;
          j = k;
          if (k < 0) {
            j = k + m;
          }
          localObject1 = arrayOfObject[j];
          k = j;
          break;
        }
      }
      j = i;
      if (localObject1 != d) {
        j = -k - 1;
      }
    }
    label185:
    do
    {
      return j;
      j = i;
    } while (localObject1 == d);
    return -i - 1;
    for (;;)
    {
      label200:
      i = j - n;
      j = i;
      if (i < 0) {
        j = i + m;
      }
      Object localObject2 = arrayOfObject[j];
      localObject1 = localObject2;
      i = j;
      if (localObject2 == d) {
        break;
      }
      localObject1 = localObject2;
      i = j;
      if (localObject2 == e) {
        break;
      }
      localObject1 = localObject2;
      i = j;
      if (localam.a(localObject2, paramObject)) {
        break;
      }
    }
    label272:
    return -i - 1;
  }
  
  public ak b()
  {
    ak localak = (ak)super.clone();
    localak.g = ((Object[])this.g.clone());
    return localak;
  }
  
  protected void b(int paramInt)
  {
    this.g[paramInt] = e;
    super.b(paramInt);
  }
  
  protected int c(int paramInt)
  {
    paramInt = super.c(paramInt);
    this.g = new Object[paramInt];
    Arrays.fill(this.g, d);
    return paramInt;
  }
  
  public final int c(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject.hashCode();
    }
    return 0;
  }
  
  public boolean contains(Object paramObject)
  {
    return a(paramObject) >= 0;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/c/a/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */