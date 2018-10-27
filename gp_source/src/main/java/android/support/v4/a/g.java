package android.support.v4.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.v4.content.a.e;
import android.support.v4.content.a.f;
import android.support.v4.e.r;
import android.support.v4.g.v;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

final class g
  extends j
{
  public static final Method a;
  private static final Method b;
  private static final Class c;
  private static final Constructor d;
  
  static
  {
    Object localObject2 = null;
    try
    {
      localClass = Class.forName("android.graphics.FontFamily");
      localConstructor = localClass.getConstructor(new Class[0]);
      Method localMethod2 = localClass.getMethod("addFontWeightStyle", new Class[] { ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE });
      localMethod1 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(localClass, 1).getClass() });
      localObject2 = localMethod2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Method localMethod1;
        Log.e("TypefaceCompatApi24Impl", localClassNotFoundException.getClass().getName(), localClassNotFoundException);
        Object localObject1 = null;
        Constructor localConstructor = null;
        Class localClass = null;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    d = localConstructor;
    c = localClass;
    a = (Method)localObject2;
    b = localMethod1;
  }
  
  private static Typeface a(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(c, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = (Typeface)b.invoke(null, new Object[] { localObject });
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
  
  private static Object a()
  {
    try
    {
      Object localObject = d.newInstance(new Object[0]);
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException(localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;) {}
    }
  }
  
  private static boolean a(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      paramBoolean = ((Boolean)a.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) })).booleanValue();
      return paramBoolean;
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
  
  public final Typeface a(Context paramContext, CancellationSignal paramCancellationSignal, r[] paramArrayOfr, int paramInt)
  {
    Object localObject = a();
    v localv = new v();
    int j = paramArrayOfr.length;
    int i = 0;
    while (i < j)
    {
      r localr = paramArrayOfr[i];
      Uri localUri = localr.d;
      ByteBuffer localByteBuffer = (ByteBuffer)localv.get(localUri);
      paramCancellationSignal = localByteBuffer;
      if (localByteBuffer == null)
      {
        paramCancellationSignal = n.a(paramContext, null, localUri);
        localv.put(localUri, paramCancellationSignal);
      }
      if (a(localObject, paramCancellationSignal, localr.c, localr.e, localr.a)) {
        i += 1;
      } else {
        return null;
      }
    }
    return Typeface.create(a(localObject), paramInt);
  }
  
  public final Typeface a(Context paramContext, e parame, Resources paramResources, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = a();
    f[] arrayOff = parame.a;
    int i = arrayOff.length;
    paramInt = 0;
    while (paramInt < i)
    {
      f localf = arrayOff[paramInt];
      ByteBuffer localByteBuffer = n.a(paramContext, paramResources, localf.c);
      parame = (e)localObject1;
      if (localByteBuffer == null) {
        return parame;
      }
      parame = (e)localObject1;
      if (!a(localObject2, localByteBuffer, localf.d, localf.f, localf.b)) {
        return parame;
      }
      paramInt += 1;
    }
    parame = a(localObject2);
    return parame;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */