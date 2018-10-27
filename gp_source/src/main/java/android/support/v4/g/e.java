package android.support.v4.g;

public final class e
{
  public static final int[] a = new int[0];
  public static final long[] b = new long[0];
  public static final Object[] c = new Object[0];
  
  public static int a(int paramInt)
  {
    return c(paramInt * 4) / 4;
  }
  
  public static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = paramInt1 - 1;
    paramInt1 = 0;
    while (paramInt1 <= i)
    {
      int j = paramInt1 + i >>> 1;
      int k = paramArrayOfInt[j];
      if (k < paramInt2) {
        paramInt1 = j + 1;
      } else if (k > paramInt2) {
        i = j - 1;
      } else {
        return j;
      }
    }
    return paramInt1 ^ 0xFFFFFFFF;
  }
  
  static int a(long[] paramArrayOfLong, int paramInt, long paramLong)
  {
    int i = paramInt - 1;
    paramInt = 0;
    while (paramInt <= i)
    {
      int j = paramInt + i >>> 1;
      long l = paramArrayOfLong[j];
      if (l < paramLong) {
        paramInt = j + 1;
      } else if (l > paramLong) {
        i = j - 1;
      } else {
        return j;
      }
    }
    return paramInt ^ 0xFFFFFFFF;
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool2;
    if (paramObject1 != paramObject2)
    {
      if (paramObject1 == null) {
        break label31;
      }
      bool1 = bool3;
      if (!paramObject1.equals(paramObject2)) {}
    }
    label31:
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public static int b(int paramInt)
  {
    return c(paramInt * 8) / 8;
  }
  
  private static int c(int paramInt)
  {
    int i = 4;
    int j;
    for (;;)
    {
      j = paramInt;
      if (i >= 32) {
        break;
      }
      j = (1 << i) - 12;
      if (paramInt <= j) {
        break;
      }
      i += 1;
    }
    return j;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */