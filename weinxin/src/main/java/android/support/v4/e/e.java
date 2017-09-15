package android.support.v4.e;

public final class e<E>
  implements Cloneable
{
  public static final Object vT = new Object();
  public int hP;
  public boolean vU = false;
  public long[] vV;
  public Object[] vW;
  
  public e()
  {
    this((byte)0);
  }
  
  private e(byte paramByte)
  {
    paramByte = b.Q(10);
    this.vV = new long[paramByte];
    this.vW = new Object[paramByte];
    this.hP = 0;
  }
  
  private e<E> bE()
  {
    try
    {
      e locale = (e)super.clone();
      return localCloneNotSupportedException1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        locale.vV = ((long[])this.vV.clone());
        locale.vW = ((Object[])this.vW.clone());
        return locale;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  private void gc()
  {
    int m = this.hP;
    long[] arrayOfLong = this.vV;
    Object[] arrayOfObject = this.vW;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != vT)
      {
        if (i != j)
        {
          arrayOfLong[j] = arrayOfLong[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.vU = false;
    this.hP = j;
  }
  
  private long keyAt(int paramInt)
  {
    if (this.vU) {
      gc();
    }
    return this.vV[paramInt];
  }
  
  public final E get(long paramLong)
  {
    int i = b.a(this.vV, this.hP, paramLong);
    if ((i < 0) || (this.vW[i] == vT)) {
      return null;
    }
    return (E)this.vW[i];
  }
  
  public final void put(long paramLong, E paramE)
  {
    int i = b.a(this.vV, this.hP, paramLong);
    if (i >= 0)
    {
      this.vW[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.hP) && (this.vW[j] == vT))
    {
      this.vV[j] = paramLong;
      this.vW[j] = paramE;
      return;
    }
    i = j;
    if (this.vU)
    {
      i = j;
      if (this.hP >= this.vV.length)
      {
        gc();
        i = b.a(this.vV, this.hP, paramLong) ^ 0xFFFFFFFF;
      }
    }
    if (this.hP >= this.vV.length)
    {
      j = b.Q(this.hP + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.vV, 0, arrayOfLong, 0, this.vV.length);
      System.arraycopy(this.vW, 0, arrayOfObject, 0, this.vW.length);
      this.vV = arrayOfLong;
      this.vW = arrayOfObject;
    }
    if (this.hP - i != 0)
    {
      System.arraycopy(this.vV, i, this.vV, i + 1, this.hP - i);
      System.arraycopy(this.vW, i, this.vW, i + 1, this.hP - i);
    }
    this.vV[i] = paramLong;
    this.vW[i] = paramE;
    this.hP += 1;
  }
  
  public final int size()
  {
    if (this.vU) {
      gc();
    }
    return this.hP;
  }
  
  public final String toString()
  {
    if (size() <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.hP * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.hP)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(keyAt(i));
      localStringBuilder.append('=');
      Object localObject = valueAt(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public final E valueAt(int paramInt)
  {
    if (this.vU) {
      gc();
    }
    return (E)this.vW[paramInt];
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */