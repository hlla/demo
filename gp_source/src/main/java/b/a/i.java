package b.a;

public final class i
{
  public static Object a(Object paramObject)
  {
    if (paramObject == null) {
      throw new NullPointerException();
    }
    return paramObject;
  }
  
  public static Object a(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      throw new NullPointerException(paramString);
    }
    return paramObject;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/b/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */