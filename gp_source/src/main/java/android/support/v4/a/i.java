package android.support.v4.a;

import android.graphics.Typeface;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class i
  extends h
{
  protected final Typeface a(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(this.b, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = this.a;
      Integer localInteger = Integer.valueOf(-1);
      paramObject = (Typeface)((Method)paramObject).invoke(null, new Object[] { localObject, "sans-serif", localInteger, localInteger });
      return (Typeface)paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException((Throwable)paramObject);
    }
    catch (InvocationTargetException paramObject)
    {
      for (;;) {}
    }
  }
  
  protected final Method a(Class paramClass)
  {
    paramClass = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(paramClass, 1).getClass(), String.class, Integer.TYPE, Integer.TYPE });
    paramClass.setAccessible(true);
    return paramClass;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */