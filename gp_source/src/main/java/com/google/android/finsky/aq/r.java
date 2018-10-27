package com.google.android.finsky.aq;

public class r
{
  public static String a(int paramInt)
  {
    int i = 0;
    if (paramInt != 0)
    {
      StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
      Object localObject = r.class.getCanonicalName();
      localObject = ((String)localObject).substring(0, ((String)localObject).lastIndexOf(".") + 1);
      for (;;)
      {
        int j = arrayOfStackTraceElement.length;
        if ((i >= j) || (!arrayOfStackTraceElement[i].getClassName().startsWith((String)localObject)))
        {
          paramInt = Math.min(j, i + paramInt);
          localObject = new StringBuilder();
          while (i < paramInt)
          {
            ((StringBuilder)localObject).append(arrayOfStackTraceElement[i]);
            ((StringBuilder)localObject).append("\n");
            i += 1;
          }
          return ((StringBuilder)localObject).toString();
        }
        i += 1;
      }
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/aq/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */