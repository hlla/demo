package android.support.v4.e;

public final class j<E>
  implements Cloneable
{
  private static final Object vT = new Object();
  private int hP;
  private boolean vU = false;
  private Object[] vW;
  private int[] wn;
  
  public j()
  {
    this(10);
  }
  
  public j(int paramInt)
  {
    if (paramInt == 0) {
      this.wn = b.vQ;
    }
    for (this.vW = b.vS;; this.vW = new Object[paramInt])
    {
      this.hP = 0;
      return;
      paramInt = b.P(paramInt);
      this.wn = new int[paramInt];
    }
  }
  
  private j<E> bH()
  {
    try
    {
      j localj = (j)super.clone();
      return localCloneNotSupportedException1;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        localj.wn = ((int[])this.wn.clone());
        localj.vW = ((Object[])this.vW.clone());
        return localj;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      return null;
    }
  }
  
  private void gc()
  {
    int m = this.hP;
    int[] arrayOfInt = this.wn;
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
          arrayOfInt[j] = arrayOfInt[i];
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
  
  public final void clear()
  {
    int j = this.hP;
    Object[] arrayOfObject = this.vW;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.hP = 0;
    this.vU = false;
  }
  
  public final E get(int paramInt)
  {
    paramInt = b.a(this.wn, this.hP, paramInt);
    if ((paramInt < 0) || (this.vW[paramInt] == vT)) {
      return null;
    }
    return (E)this.vW[paramInt];
  }
  
  public final int indexOfKey(int paramInt)
  {
    if (this.vU) {
      gc();
    }
    return b.a(this.wn, this.hP, paramInt);
  }
  
  public final int keyAt(int paramInt)
  {
    if (this.vU) {
      gc();
    }
    return this.wn[paramInt];
  }
  
  public final void put(int paramInt, E paramE)
  {
    int i = b.a(this.wn, this.hP, paramInt);
    if (i >= 0)
    {
      this.vW[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.hP) && (this.vW[j] == vT))
    {
      this.wn[j] = paramInt;
      this.vW[j] = paramE;
      return;
    }
    i = j;
    if (this.vU)
    {
      i = j;
      if (this.hP >= this.wn.length)
      {
        gc();
        i = b.a(this.wn, this.hP, paramInt) ^ 0xFFFFFFFF;
      }
    }
    if (this.hP >= this.wn.length)
    {
      j = b.P(this.hP + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.wn, 0, arrayOfInt, 0, this.wn.length);
      System.arraycopy(this.vW, 0, arrayOfObject, 0, this.vW.length);
      this.wn = arrayOfInt;
      this.vW = arrayOfObject;
    }
    if (this.hP - i != 0)
    {
      System.arraycopy(this.wn, i, this.wn, i + 1, this.hP - i);
      System.arraycopy(this.vW, i, this.vW, i + 1, this.hP - i);
    }
    this.wn[i] = paramInt;
    this.vW[i] = paramE;
    this.hP += 1;
  }
  
  public final void remove(int paramInt)
  {
    paramInt = b.a(this.wn, this.hP, paramInt);
    if ((paramInt >= 0) && (this.vW[paramInt] != vT))
    {
      this.vW[paramInt] = vT;
      this.vU = true;
    }
  }
  
  public final void removeAt(int paramInt)
  {
    if (this.vW[paramInt] != vT)
    {
      this.vW[paramInt] = vT;
      this.vU = true;
    }
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


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/e/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */