package android.support.v4.g;

public final class w
  implements Cloneable
{
  public static final Object a = new Object();
  public boolean b = false;
  public int[] c;
  public int d;
  public Object[] e;
  
  public w()
  {
    this(10);
  }
  
  public w(int paramInt)
  {
    if (paramInt == 0) {
      this.c = e.a;
    }
    for (this.e = e.c;; this.e = new Object[paramInt])
    {
      this.d = 0;
      return;
      paramInt = e.a(paramInt);
      this.c = new int[paramInt];
    }
  }
  
  private final w d()
  {
    try
    {
      w localw = (w)super.clone();
      localw.c = ((int[])this.c.clone());
      localw.e = ((Object[])this.e.clone());
      return localw;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public final Object a(int paramInt, Object paramObject)
  {
    paramInt = e.a(this.c, this.d, paramInt);
    Object localObject = paramObject;
    if (paramInt >= 0)
    {
      localObject = paramObject;
      if (this.e[paramInt] != a) {
        localObject = this.e[paramInt];
      }
    }
    return localObject;
  }
  
  public final void a()
  {
    int k = this.d;
    int[] arrayOfInt = this.c;
    Object[] arrayOfObject = this.e;
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
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        j += 1;
      }
    }
    this.b = false;
    this.d = j;
  }
  
  public final void a(int paramInt)
  {
    paramInt = e.a(this.c, this.d, paramInt);
    if ((paramInt >= 0) && (this.e[paramInt] != a))
    {
      this.e[paramInt] = a;
      this.b = true;
    }
  }
  
  public final int b()
  {
    if (this.b) {
      a();
    }
    return this.d;
  }
  
  public final int b(int paramInt)
  {
    if (this.b) {
      a();
    }
    return this.c[paramInt];
  }
  
  public final void b(int paramInt, Object paramObject)
  {
    int i = e.a(this.c, this.d, paramInt);
    if (i >= 0)
    {
      this.e[i] = paramObject;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.d) && (this.e[j] == a))
    {
      this.c[j] = paramInt;
      this.e[j] = paramObject;
      return;
    }
    i = j;
    if (this.b)
    {
      i = j;
      if (this.d >= this.c.length)
      {
        a();
        i = e.a(this.c, this.d, paramInt) ^ 0xFFFFFFFF;
      }
    }
    j = this.d;
    Object localObject1;
    if (j >= this.c.length)
    {
      j = e.a(j + 1);
      localObject1 = new int[j];
      Object[] arrayOfObject = new Object[j];
      Object localObject2 = this.c;
      System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      localObject2 = this.e;
      System.arraycopy(localObject2, 0, arrayOfObject, 0, localObject2.length);
      this.c = ((int[])localObject1);
      this.e = arrayOfObject;
    }
    j = this.d - i;
    if (j != 0)
    {
      localObject1 = this.c;
      int k = i + 1;
      System.arraycopy(localObject1, i, localObject1, k, j);
      localObject1 = this.e;
      System.arraycopy(localObject1, i, localObject1, k, this.d - i);
    }
    this.c[i] = paramInt;
    this.e[i] = paramObject;
    this.d += 1;
  }
  
  public final Object c(int paramInt)
  {
    if (this.b) {
      a();
    }
    return this.e[paramInt];
  }
  
  public final void c()
  {
    int j = this.d;
    Object[] arrayOfObject = this.e;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.d = 0;
    this.b = false;
  }
  
  public final void c(int paramInt, Object paramObject)
  {
    int i = this.d;
    if ((i != 0) && (paramInt <= this.c[(i - 1)]))
    {
      b(paramInt, paramObject);
      return;
    }
    if ((this.b) && (i >= this.c.length)) {
      a();
    }
    i = this.d;
    if (i >= this.c.length)
    {
      int j = e.a(i + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      Object localObject = this.c;
      System.arraycopy(localObject, 0, arrayOfInt, 0, localObject.length);
      localObject = this.e;
      System.arraycopy(localObject, 0, arrayOfObject, 0, localObject.length);
      this.c = arrayOfInt;
      this.e = arrayOfObject;
    }
    this.c[i] = paramInt;
    this.e[i] = paramObject;
    this.d = (i + 1);
  }
  
  public final int d(int paramInt)
  {
    if (this.b) {
      a();
    }
    return e.a(this.c, this.d, paramInt);
  }
  
  public final String toString()
  {
    if (b() <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.d * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.d)
    {
      if (i <= 0) {}
      for (;;)
      {
        localStringBuilder.append(b(i));
        localStringBuilder.append('=');
        Object localObject = c(i);
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */