package com.google.android.gms.c;

final class ba
  implements Cloneable
{
  static final bb aCB = new bb();
  boolean aCC = false;
  int[] aCD;
  bb[] aCE;
  int hP;
  
  public ba()
  {
    this(10);
  }
  
  private ba(int paramInt)
  {
    paramInt = P(paramInt);
    this.aCD = new int[paramInt];
    this.aCE = new bb[paramInt];
    this.hP = 0;
  }
  
  static int P(int paramInt)
  {
    int j = paramInt * 4;
    paramInt = 4;
    for (;;)
    {
      int i = j;
      if (paramInt < 32)
      {
        if (j <= (1 << paramInt) - 12) {
          i = (1 << paramInt) - 12;
        }
      }
      else {
        return i / 4;
      }
      paramInt += 1;
    }
  }
  
  public final bb cr(int paramInt)
  {
    if (this.aCC) {
      gc();
    }
    return this.aCE[paramInt];
  }
  
  final int cs(int paramInt)
  {
    int j = this.hP;
    int i = 0;
    j -= 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = this.aCD[k];
      if (m < paramInt)
      {
        i = k + 1;
      }
      else
      {
        j = k;
        if (m <= paramInt) {
          return j;
        }
        j = k - 1;
      }
    }
    j = i ^ 0xFFFFFFFF;
    return j;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    label71:
    label93:
    label131:
    label138:
    label141:
    for (;;)
    {
      return true;
      if (!(paramObject instanceof ba)) {
        return false;
      }
      paramObject = (ba)paramObject;
      if (size() != ((ba)paramObject).size()) {
        return false;
      }
      Object localObject = this.aCD;
      int[] arrayOfInt = ((ba)paramObject).aCD;
      int j = this.hP;
      int i = 0;
      if (i < j) {
        if (localObject[i] != arrayOfInt[i])
        {
          i = 0;
          if (i != 0)
          {
            localObject = this.aCE;
            paramObject = ((ba)paramObject).aCE;
            j = this.hP;
            i = 0;
            if (i >= j) {
              break label138;
            }
            if (localObject[i].equals(paramObject[i])) {
              break label131;
            }
          }
        }
      }
      for (i = 0;; i = 1)
      {
        if (i != 0) {
          break label141;
        }
        return false;
        i += 1;
        break;
        i = 1;
        break label71;
        i += 1;
        break label93;
      }
    }
  }
  
  final void gc()
  {
    int m = this.hP;
    int[] arrayOfInt = this.aCD;
    bb[] arrayOfbb = this.aCE;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      bb localbb = arrayOfbb[i];
      k = j;
      if (localbb != aCB)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfbb[j] = localbb;
          arrayOfbb[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.aCC = false;
    this.hP = j;
  }
  
  public final int hashCode()
  {
    if (this.aCC) {
      gc();
    }
    int j = 17;
    int i = 0;
    while (i < this.hP)
    {
      j = (j * 31 + this.aCD[i]) * 31 + this.aCE[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public final boolean isEmpty()
  {
    return size() == 0;
  }
  
  public final ba lx()
  {
    int i = 0;
    int j = size();
    ba localba = new ba(j);
    System.arraycopy(this.aCD, 0, localba.aCD, 0, j);
    while (i < j)
    {
      if (this.aCE[i] != null) {
        localba.aCE[i] = this.aCE[i].ly();
      }
      i += 1;
    }
    localba.hP = j;
    return localba;
  }
  
  public final int size()
  {
    if (this.aCC) {
      gc();
    }
    return this.hP;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/c/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */