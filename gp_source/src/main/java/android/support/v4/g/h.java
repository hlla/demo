package android.support.v4.g;

public final class h
  implements Cloneable
{
  public static final Object a = new Object();
  public boolean b = false;
  public Object[] c;
  private long[] d;
  private int e;
  
  public h()
  {
    this(10);
  }
  
  public h(int paramInt)
  {
    if (paramInt == 0) {
      this.d = e.b;
    }
    for (this.c = e.c;; this.c = new Object[paramInt])
    {
      this.e = 0;
      return;
      paramInt = e.b(paramInt);
      this.d = new long[paramInt];
    }
  }
  
  private final h c()
  {
    try
    {
      h localh = (h)super.clone();
      localh.d = ((long[])this.d.clone());
      localh.c = ((Object[])this.c.clone());
      return localh;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  private final void d()
  {
    int k = this.e;
    long[] arrayOfLong = this.d;
    Object[] arrayOfObject = this.c;
    int i = 0;
    int j = 0;
    if (i < k)
    {
      Object localObject = arrayOfObject[i];
      if (localObject == a) {}
      for (;;)
      {
        i += 1;
        break;
        if (i != j)
        {
          arrayOfLong[j] = arrayOfLong[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        j += 1;
      }
    }
    this.b = false;
    this.e = j;
  }
  
  public final int a()
  {
    if (this.b) {
      d();
    }
    return this.e;
  }
  
  public final int a(Object paramObject)
  {
    int j = 0;
    int i = j;
    if (this.b)
    {
      d();
      i = j;
    }
    while (i < this.e)
    {
      j = i;
      if (this.c[i] == paramObject) {
        return j;
      }
      i += 1;
    }
    j = -1;
    return j;
  }
  
  public final long a(int paramInt)
  {
    if (this.b) {
      d();
    }
    return this.d[paramInt];
  }
  
  public final Object a(long paramLong, Object paramObject)
  {
    int i = e.a(this.d, this.e, paramLong);
    Object localObject = paramObject;
    if (i >= 0)
    {
      localObject = paramObject;
      if (this.c[i] != a) {
        localObject = this.c[i];
      }
    }
    return localObject;
  }
  
  public final void a(long paramLong)
  {
    int i = e.a(this.d, this.e, paramLong);
    if ((i >= 0) && (this.c[i] != a))
    {
      this.c[i] = a;
      this.b = true;
    }
  }
  
  public final int b(long paramLong)
  {
    if (this.b) {
      d();
    }
    return e.a(this.d, this.e, paramLong);
  }
  
  public final Object b(int paramInt)
  {
    if (this.b) {
      d();
    }
    return this.c[paramInt];
  }
  
  public final void b()
  {
    int j = this.e;
    Object[] arrayOfObject = this.c;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.e = 0;
    this.b = false;
  }
  
  public final void b(long paramLong, Object paramObject)
  {
    int i = e.a(this.d, this.e, paramLong);
    if (i >= 0)
    {
      this.c[i] = paramObject;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.e) && (this.c[j] == a))
    {
      this.d[j] = paramLong;
      this.c[j] = paramObject;
      return;
    }
    i = j;
    if (this.b)
    {
      i = j;
      if (this.e >= this.d.length)
      {
        d();
        i = e.a(this.d, this.e, paramLong) ^ 0xFFFFFFFF;
      }
    }
    j = this.e;
    Object localObject1;
    if (j >= this.d.length)
    {
      j = e.b(j + 1);
      localObject1 = new long[j];
      Object[] arrayOfObject = new Object[j];
      Object localObject2 = this.d;
      System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      localObject2 = this.c;
      System.arraycopy(localObject2, 0, arrayOfObject, 0, localObject2.length);
      this.d = ((long[])localObject1);
      this.c = arrayOfObject;
    }
    j = this.e - i;
    if (j != 0)
    {
      localObject1 = this.d;
      int k = i + 1;
      System.arraycopy(localObject1, i, localObject1, k, j);
      localObject1 = this.c;
      System.arraycopy(localObject1, i, localObject1, k, this.e - i);
    }
    this.d[i] = paramLong;
    this.c[i] = paramObject;
    this.e += 1;
  }
  
  public final void c(long paramLong, Object paramObject)
  {
    int i = this.e;
    if ((i != 0) && (paramLong <= this.d[(i - 1)]))
    {
      b(paramLong, paramObject);
      return;
    }
    if ((this.b) && (i >= this.d.length)) {
      d();
    }
    i = this.e;
    if (i >= this.d.length)
    {
      int j = e.b(i + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      Object localObject = this.d;
      System.arraycopy(localObject, 0, arrayOfLong, 0, localObject.length);
      localObject = this.c;
      System.arraycopy(localObject, 0, arrayOfObject, 0, localObject.length);
      this.d = arrayOfLong;
      this.c = arrayOfObject;
    }
    this.d[i] = paramLong;
    this.c[i] = paramObject;
    this.e = (i + 1);
  }
  
  public final String toString()
  {
    if (a() <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.e * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.e)
    {
      if (i <= 0) {}
      for (;;)
      {
        localStringBuilder.append(a(i));
        localStringBuilder.append('=');
        Object localObject = b(i);
        if (localObject == this) {
          localStringBuilder.append("(this Map)");
        }
        for (;;)
        {
          i += 1;
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */