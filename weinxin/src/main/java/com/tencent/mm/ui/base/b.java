package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.a;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class b
{
  public static int ST(String paramString)
  {
    GMTrace.i(3182302330880L, 23710);
    paramString = SU(paramString);
    if (paramString != null)
    {
      int i = w(paramString);
      GMTrace.o(3182302330880L, 23710);
      return i;
    }
    GMTrace.o(3182302330880L, 23710);
    return 0;
  }
  
  private static Class<?> SU(String paramString)
  {
    GMTrace.i(3182570766336L, 23712);
    try
    {
      Class localClass = Class.forName(paramString);
      GMTrace.o(3182570766336L, 23712);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      v.printErrStackTrace("MicroMsg.ActivityUtil", localClassNotFoundException, "", new Object[0]);
      v.e("MicroMsg.ActivityUtil", "Class %s not found in dex", new Object[] { paramString });
      GMTrace.o(3182570766336L, 23712);
    }
    return null;
  }
  
  public static void ad(Activity paramActivity)
  {
    GMTrace.i(3182839201792L, 23714);
    try
    {
      Method localMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(paramActivity, new Object[0]);
      GMTrace.o(3182839201792L, 23714);
      return;
    }
    catch (Throwable paramActivity)
    {
      v.printErrStackTrace("MicroMsg.ActivityUtil", paramActivity, "call convertActivityFromTranslucent Fail: %s", new Object[] { paramActivity.getMessage() });
      GMTrace.o(3182839201792L, 23714);
    }
  }
  
  public static void eL(Context paramContext)
  {
    GMTrace.i(3182973419520L, 23715);
    if ((paramContext == null) || (!(paramContext instanceof Activity)))
    {
      GMTrace.o(3182973419520L, 23715);
      return;
    }
    ((Activity)paramContext).overridePendingTransition(a.a.aRm, a.a.aQL);
    GMTrace.o(3182973419520L, 23715);
  }
  
  public static void eM(Context paramContext)
  {
    GMTrace.i(3183107637248L, 23716);
    if ((paramContext == null) || (!(paramContext instanceof Activity)))
    {
      GMTrace.o(3183107637248L, 23716);
      return;
    }
    ((Activity)paramContext).overridePendingTransition(a.a.aRm, a.a.aRn);
    GMTrace.o(3183107637248L, 23716);
  }
  
  public static void eN(Context paramContext)
  {
    GMTrace.i(3183376072704L, 23718);
    if ((paramContext == null) || (!(paramContext instanceof Activity)))
    {
      GMTrace.o(3183376072704L, 23718);
      return;
    }
    ((Activity)paramContext).overridePendingTransition(a.a.aQL, a.a.aRn);
    GMTrace.o(3183376072704L, 23718);
  }
  
  public static void eO(Context paramContext)
  {
    GMTrace.i(3183510290432L, 23719);
    if ((paramContext == null) || (!(paramContext instanceof Activity)))
    {
      GMTrace.o(3183510290432L, 23719);
      return;
    }
    ((Activity)paramContext).overridePendingTransition(a.a.aQL, a.a.aQL);
    GMTrace.o(3183510290432L, 23719);
  }
  
  public static int w(Class<?> paramClass)
  {
    GMTrace.i(3182436548608L, 23711);
    Object localObject;
    do
    {
      localObject = (a)paramClass.getAnnotation(a.class);
      if (localObject != null)
      {
        int i = ((a)localObject).value();
        GMTrace.o(3182436548608L, 23711);
        return i;
      }
      localObject = paramClass.getSuperclass();
      paramClass = (Class<?>)localObject;
    } while (localObject != null);
    GMTrace.o(3182436548608L, 23711);
    return 0;
  }
  
  public static void x(Context paramContext, Intent paramIntent)
  {
    GMTrace.i(3183241854976L, 23717);
    if ((paramIntent == null) || (paramContext == null) || (!(paramContext instanceof Activity)))
    {
      GMTrace.o(3183241854976L, 23717);
      return;
    }
    if (paramIntent.getBooleanExtra("animation_pop_in", false)) {
      ((Activity)paramContext).overridePendingTransition(a.a.aRm, a.a.aQL);
    }
    GMTrace.o(3183241854976L, 23717);
  }
  
  public static boolean x(Class<?> paramClass)
  {
    GMTrace.i(3182704984064L, 23713);
    if ((w(paramClass) & 0x1) == 0)
    {
      GMTrace.o(3182704984064L, 23713);
      return true;
    }
    GMTrace.o(3182704984064L, 23713);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void kD(boolean paramBoolean);
  }
  
  private static final class b
    implements InvocationHandler
  {
    public WeakReference<b.a> vdQ;
    
    public b()
    {
      GMTrace.i(3357859119104L, 25018);
      GMTrace.o(3357859119104L, 25018);
    }
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      boolean bool2 = false;
      GMTrace.i(3357993336832L, 25019);
      if (this.vdQ == null)
      {
        v.i("MicroMsg.ActivityUtil", "swipe invoke fail, callbackRef NULL!");
        GMTrace.o(3357993336832L, 25019);
        return null;
      }
      paramObject = (b.a)this.vdQ.get();
      if (paramObject == null)
      {
        v.i("MicroMsg.ActivityUtil", "swipe invoke fail, callback NULL!");
        GMTrace.o(3357993336832L, 25019);
        return null;
      }
      boolean bool1 = bool2;
      if (paramArrayOfObject != null)
      {
        bool1 = bool2;
        if (paramArrayOfObject.length > 0)
        {
          bool1 = bool2;
          if ((paramArrayOfObject[0] instanceof Boolean)) {
            bool1 = ((Boolean)paramArrayOfObject[0]).booleanValue();
          }
        }
      }
      ((b.a)paramObject).kD(bool1);
      GMTrace.o(3357993336832L, 25019);
      return null;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */