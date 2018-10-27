package android.support.v4.g;

public final class f
{
  public static void a(Object paramObject, StringBuilder paramStringBuilder)
  {
    if (paramObject != null)
    {
      String str2 = paramObject.getClass().getSimpleName();
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (str2.length() > 0) {}
      }
      else
      {
        str2 = paramObject.getClass().getName();
        int i = str2.lastIndexOf('.');
        str1 = str2;
        if (i > 0) {
          str1 = str2.substring(i + 1);
        }
      }
      paramStringBuilder.append(str1);
      paramStringBuilder.append('{');
      paramStringBuilder.append(Integer.toHexString(System.identityHashCode(paramObject)));
      return;
    }
    paramStringBuilder.append("null");
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/g/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */