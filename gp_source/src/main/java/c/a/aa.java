package c.a;

public abstract class aa
  extends ap
  implements ae
{
  public ae c = this;
  public transient long[] d;
  
  public final boolean a(long paramLong)
  {
    return b(paramLong) >= 0;
  }
  
  public final boolean a(aj paramaj)
  {
    boolean bool2 = true;
    byte[] arrayOfByte = this.f;
    long[] arrayOfLong = this.d;
    int i = arrayOfLong.length;
    for (;;)
    {
      int j = i - 1;
      boolean bool1 = bool2;
      if (i > 0)
      {
        if (arrayOfByte[j] == 1)
        {
          if (paramaj.a(arrayOfLong[j]))
          {
            i = j;
            continue;
          }
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i = j;
    }
  }
  
  protected final int b(long paramLong)
  {
    byte[] arrayOfByte = this.f;
    long[] arrayOfLong = this.d;
    int k = arrayOfByte.length;
    int m = 0x7FFFFFFF & this.c.d(paramLong);
    int j = m % k;
    int n = arrayOfByte[j];
    int i = j;
    if (n != 0)
    {
      if (n != 2) {
        break label139;
      }
      j -= m % (k - 2) + 1;
      i = j;
      if (j < 0) {
        i = j + k;
      }
      n = arrayOfByte[i];
      if (n != 0) {
        break label115;
      }
    }
    for (;;)
    {
      j = i;
      if (arrayOfByte[i] == 0) {
        j = -1;
      }
      return j;
      label115:
      j = i;
      if (n == 2) {
        break;
      }
      j = i;
      if (arrayOfLong[i] != paramLong) {
        break;
      }
      continue;
      label139:
      if (arrayOfLong[j] != paramLong) {
        break;
      }
      i = j;
    }
  }
  
  protected void b(int paramInt)
  {
    this.d[paramInt] = 0L;
    super.b(paramInt);
  }
  
  protected int c(int paramInt)
  {
    paramInt = super.c(paramInt);
    this.d = new long[paramInt];
    return paramInt;
  }
  
  protected final int c(long paramLong)
  {
    byte[] arrayOfByte = this.f;
    long[] arrayOfLong = this.d;
    int m = arrayOfByte.length;
    int k = 0x7FFFFFFF & this.c.d(paramLong);
    int i = k % m;
    int i1 = arrayOfByte[i];
    int j = i;
    if (i1 != 0) {
      if (i1 == 1) {
        break label234;
      }
    }
    label105:
    label234:
    while (arrayOfLong[i] != paramLong)
    {
      int n = k % (m - 2) + 1;
      k = i;
      if (i1 == 2) {}
      for (;;)
      {
        k = arrayOfByte[i];
        if (k == 2)
        {
          k = i;
          i1 = arrayOfByte[k];
          if (i1 == 0)
          {
            j = i;
            if (i1 == 1) {
              j = -k - 1;
            }
          }
        }
        do
        {
          return j;
          if (i1 == 2) {}
          for (;;)
          {
            j = k - n;
            k = j;
            if (j >= 0) {
              break;
            }
            k = j + m;
            break;
            if (arrayOfLong[k] == paramLong) {
              break label105;
            }
          }
          j = i;
        } while (k != 1);
        return -i - 1;
        do
        {
          i = k - n;
          j = i;
          if (i < 0) {
            j = i + m;
          }
          i = j;
          if (arrayOfByte[j] != 1) {
            break;
          }
          k = j;
        } while (arrayOfLong[j] != paramLong);
        i = j;
      }
    }
    return -i - 1;
  }
  
  public Object clone()
  {
    aa localaa = (aa)super.clone();
    localaa.d = ((long[])this.d.clone());
    return localaa;
  }
  
  public final int d(long paramLong)
  {
    return (int)(paramLong >>> 32 ^ paramLong) * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/c/a/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */