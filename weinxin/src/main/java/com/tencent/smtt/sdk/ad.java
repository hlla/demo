package com.tencent.smtt.sdk;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Method;
import java.util.Map;

public final class ad
{
  public DexLoader wUo;
  
  public ad(DexLoader paramDexLoader)
  {
    this.wUo = paramDexLoader;
  }
  
  public final int a(Context paramContext, String paramString1, Map<String, String> paramMap, String paramString2, ValueCallback<String> paramValueCallback)
  {
    if (l.fP(paramContext)) {
      return -103;
    }
    if (paramString2 == null)
    {
      paramValueCallback = this.wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class, Map.class, ValueCallback.class }, new Object[] { paramContext, paramString1, paramMap, paramValueCallback });
      paramString2 = paramValueCallback;
      if (paramValueCallback == null) {
        paramString2 = this.wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class, Map.class }, new Object[] { paramContext, paramString1, paramMap });
      }
      paramMap = paramString2;
      if (paramString2 == null) {
        paramMap = this.wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString1 });
      }
      if (paramMap == null) {
        return -104;
      }
      return ((Integer)paramMap).intValue();
    }
    paramContext = this.wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[] { Context.class, String.class, String.class }, new Object[] { paramContext, paramString1, paramString2 });
    if (paramContext == null) {
      return -104;
    }
    return ((Integer)paramContext).intValue();
  }
  
  public final boolean ceU()
  {
    try
    {
      Object localObject = this.wUo.getClassLoader().loadClass("com.tencent.tbs.tbsshell.WebCoreProxy").getMethod("canUseX5", new Class[0]);
      ((Method)localObject).setAccessible(true);
      localObject = ((Method)localObject).invoke(null, new Object[0]);
      if ((localObject instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject).booleanValue();
        return bool;
      }
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
    return ((Boolean)localThrowable).booleanValue();
  }
  
  public final Object ceV()
  {
    return this.wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCachFileBaseDir", new Class[0], new Object[0]);
  }
  
  public final IX5WebViewBase gG(Context paramContext)
  {
    Object localObject3 = this.wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createSDKWebview", new Class[] { Context.class }, new Object[] { paramContext });
    if (localObject3 == null) {}
    try
    {
      localObject1 = this.wUo.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
      if ((localObject1 != null) && ((localObject1 instanceof Throwable))) {
        i.cdS().a(paramContext, 325, (Throwable)localObject1);
      }
      if ((localObject1 == null) || (!(localObject1 instanceof String))) {
        break label197;
      }
      i.cdS().a(paramContext, 325, new Throwable((String)localObject1));
    }
    catch (Exception paramContext)
    {
      Object localObject2;
      do
      {
        IX5WebViewBase localIX5WebViewBase;
        Object localObject1 = null;
        localObject2 = localObject3;
        continue;
        localObject1 = null;
        localObject2 = null;
      } while (localObject2 != null);
    }
    localIX5WebViewBase = (IX5WebViewBase)localObject3;
    localObject1 = localIX5WebViewBase;
    localObject2 = localObject3;
    if (localIX5WebViewBase != null)
    {
      localObject1 = localIX5WebViewBase;
      localObject2 = localObject3;
      try
      {
        if (localIX5WebViewBase.getView() != null) {
          break label201;
        }
        i.cdS().a(paramContext, 325, new Throwable("x5webview.getView is null!"));
        localObject2 = null;
        localObject1 = localIX5WebViewBase;
      }
      catch (Exception paramContext)
      {
        localObject1 = localIX5WebViewBase;
        localObject2 = localObject3;
      }
      return (IX5WebViewBase)localObject1;
    }
    label197:
    label201:
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */