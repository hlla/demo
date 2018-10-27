package android.support.v4.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.support.v4.content.a.e;
import android.support.v4.e.r;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class h
  extends f
{
  public final Method a;
  public final Class b;
  private final Method c;
  private final Method d;
  private final Method e;
  private final Constructor f;
  private final Method g;
  
  public h()
  {
    try
    {
      localClass = Class.forName("android.graphics.FontFamily");
      localConstructor = localClass.getConstructor(new Class[0]);
      localMethod3 = localClass.getMethod("addFontFromAssetManager", new Class[] { AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class });
      localMethod2 = localClass.getMethod("addFontFromBuffer", new Class[] { ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE });
      localObject3 = localClass.getMethod("freeze", new Class[0]);
      localMethod4 = localClass.getMethod("abortCreation", new Class[0]);
      localMethod1 = a(localClass);
      localObject2 = localMethod4;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Method localMethod1;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("Unable to collect necessary methods for class ");
        ((StringBuilder)localObject3).append(localClassNotFoundException.getClass().getName());
        Log.e("TypefaceCompatApi26Impl", ((StringBuilder)localObject3).toString(), localClassNotFoundException);
        Method localMethod4 = null;
        localObject3 = null;
        Method localMethod2 = null;
        Method localMethod3 = null;
        Constructor localConstructor = null;
        Class localClass = null;
        Object localObject1 = localObject2;
        localObject2 = localMethod4;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    this.b = localClass;
    this.f = localConstructor;
    this.d = localMethod3;
    this.e = localMethod2;
    this.g = ((Method)localObject3);
    this.c = ((Method)localObject2);
    this.a = localMethod1;
  }
  
  private final boolean a()
  {
    if (this.d == null) {
      Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
    }
    return this.d != null;
  }
  
  private final boolean a(Context paramContext, Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3, FontVariationAxis[] paramArrayOfFontVariationAxis)
  {
    try
    {
      boolean bool = ((Boolean)this.d.invoke(paramObject, new Object[] { paramContext.getAssets(), paramString, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramArrayOfFontVariationAxis })).booleanValue();
      return bool;
    }
    catch (IllegalAccessException paramContext)
    {
      throw new RuntimeException(paramContext);
    }
    catch (InvocationTargetException paramContext)
    {
      for (;;) {}
    }
  }
  
  private final boolean a(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      boolean bool = ((Boolean)this.e.invoke(paramObject, new Object[] { paramByteBuffer, Integer.valueOf(paramInt1), null, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) })).booleanValue();
      return bool;
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
  
  private final Object b()
  {
    try
    {
      Object localObject = this.f.newInstance(new Object[0]);
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
  
  private final boolean b(Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)this.g.invoke(paramObject, new Object[0])).booleanValue();
      return bool;
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
  
  private final void c(Object paramObject)
  {
    try
    {
      this.c.invoke(paramObject, new Object[0]);
      return;
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
  
  public final Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject = null;
    if (!a()) {
      paramContext = super.a(paramContext, paramResources, paramInt1, paramString, paramInt2);
    }
    do
    {
      return paramContext;
      paramResources = b();
      if (!a(paramContext, paramResources, paramString, 0, -1, -1, null))
      {
        c(paramResources);
        return null;
      }
      paramContext = (Context)localObject;
    } while (!b(paramResources));
    return a(paramResources);
  }
  
  public final Typeface a(Context paramContext, CancellationSignal paramCancellationSignal, r[] paramArrayOfr, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public final Typeface a(Context paramContext, e parame, Resources paramResources, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  protected Typeface a(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(this.b, 1);
      Array.set(localObject, 0, paramObject);
      paramObject = this.a;
      Integer localInteger = Integer.valueOf(-1);
      paramObject = (Typeface)((Method)paramObject).invoke(null, new Object[] { localObject, localInteger, localInteger });
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
  
  protected Method a(Class paramClass)
  {
    paramClass = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[] { Array.newInstance(paramClass, 1).getClass(), Integer.TYPE, Integer.TYPE });
    paramClass.setAccessible(true);
    return paramClass;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */