package android.support.v4.g;

public final class u
{
  public static int a(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException();
    }
    return paramInt;
  }
  
  public static Object a(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    return paramObject;
  }
  
  public static Object a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      throw new NullPointerException(String.valueOf(paramObject2));
    }
    return paramObject1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */