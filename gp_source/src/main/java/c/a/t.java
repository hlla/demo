package c.a;

public abstract class t
  extends ap
  implements u
{
  public u c = this;
  public transient int[] d;
  
  protected void b(int paramInt)
  {
    this.d[paramInt] = 0;
    super.b(paramInt);
  }
  
  protected int c(int paramInt)
  {
    paramInt = super.c(paramInt);
    this.d = new int[paramInt];
    return paramInt;
  }
  
  public Object clone()
  {
    t localt = (t)super.clone();
    localt.d = ((int[])this.d.clone());
    return localt;
  }
  
  protected final int e(int paramInt)
  {
    byte[] arrayOfByte = this.f;
    int[] arrayOfInt = this.d;
    int k = arrayOfByte.length;
    int m = 0x7FFFFFFF & this.c.g(paramInt);
    int j = m % k;
    int n = arrayOfByte[j];
    int i = j;
    if (n != 0)
    {
      if (n != 2) {
        break label125;
      }
      j -= m % (k - 2) + 1;
      i = j;
      if (j < 0) {
        i = j + k;
      }
      n = arrayOfByte[i];
      if (n != 0) {
        break label104;
      }
    }
    for (;;)
    {
      paramInt = i;
      if (arrayOfByte[i] == 0) {
        paramInt = -1;
      }
      return paramInt;
      label104:
      j = i;
      if (n == 2) {
        break;
      }
      j = i;
      if (arrayOfInt[i] != paramInt) {
        break;
      }
      continue;
      label125:
      if (arrayOfInt[j] != paramInt) {
        break;
      }
      i = j;
    }
  }
  
  protected final int f(int paramInt)
  {
    byte[] arrayOfByte = this.f;
    int[] arrayOfInt = this.d;
    int m = arrayOfByte.length;
    int k = 0x7FFFFFFF & this.c.g(paramInt);
    int i = k % m;
    int i1 = arrayOfByte[i];
    int j = i;
    if (i1 != 0) {
      if (i1 == 1) {
        break label216;
      }
    }
    label104:
    label216:
    while (arrayOfInt[i] != paramInt)
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
            if (arrayOfInt[k] == paramInt) {
              break label104;
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
        } while (arrayOfInt[j] != paramInt);
        i = j;
      }
    }
    return -i - 1;
  }
  
  public final int g(int paramInt)
  {
    return paramInt * 31;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/c/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */