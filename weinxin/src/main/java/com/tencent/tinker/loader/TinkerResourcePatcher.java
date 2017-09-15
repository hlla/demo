package com.tencent.tinker.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.ArrayMap;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class TinkerResourcePatcher
{
  private static Collection<WeakReference<Resources>> xfi = null;
  private static Object xfj = null;
  private static AssetManager xfk = null;
  private static Method xfl = null;
  private static Method xfm = null;
  private static Field xfn = null;
  private static Field xfo = null;
  private static Field xfp = null;
  private static Field xfq = null;
  private static Field xfr = null;
  private static Field xfs = null;
  
  public static void bJ(Context paramContext, String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      Object localObject1 = xfq;
      Object localObject2 = xfr;
      int i = 0;
      Object localObject3;
      Object localObject5;
      while (i < 2)
      {
        localObject3 = ((Map)new Field[] { localObject1, localObject2 }[i].get(xfj)).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = ((WeakReference)((Map.Entry)((Iterator)localObject3).next()).getValue()).get();
          if ((localObject5 != null) && (paramString != null)) {
            xfp.set(localObject5, paramString);
          }
        }
        i += 1;
      }
      if (((Integer)xfl.invoke(xfk, new Object[] { paramString })).intValue() == 0) {
        throw new IllegalStateException("Could not create new AssetManager");
      }
      xfm.invoke(xfk, new Object[0]);
      localObject1 = xfi.iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Resources)((WeakReference)((Iterator)localObject1).next()).get();
          if (localObject2 == null) {
            continue;
          }
          try
          {
            xfn.set(localObject2, xfk);
          }
          catch (Throwable localThrowable1)
          {
            try
            {
              for (;;)
              {
                localObject3 = ShareReflectUtil.b(Resources.class, "mTypedArrayPool");
                localObject5 = ((Field)localObject3).get(localObject2);
                Field localField = ShareReflectUtil.a(localObject5, "mPool");
                Constructor localConstructor = localObject5.getClass().getConstructor(new Class[] { Integer.TYPE });
                localConstructor.setAccessible(true);
                ((Field)localObject3).set(localObject2, localConstructor.newInstance(new Object[] { Integer.valueOf(((Object[])(Object[])localField.get(localObject5)).length) }));
                ((Resources)localObject2).updateConfiguration(((Resources)localObject2).getConfiguration(), ((Resources)localObject2).getDisplayMetrics());
                break;
                localThrowable1 = localThrowable1;
                Object localObject4 = xfo.get(localObject2);
                localObject5 = ShareReflectUtil.a(localObject4, "mAssets");
                ((Field)localObject5).setAccessible(true);
                ((Field)localObject5).set(localObject4, xfk);
              }
            }
            catch (Throwable localThrowable2)
            {
              for (;;)
              {
                new StringBuilder("clearPreloadTypedArrayIssue failed, ignore error: ").append(localThrowable2);
              }
            }
          }
        }
      }
      if (Build.VERSION.SDK_INT >= 24) {}
      try
      {
        if (xfs != null) {
          xfs.set(paramContext.getApplicationInfo(), paramString);
        }
        if (hw(paramContext)) {
          continue;
        }
        throw new TinkerRuntimeException("checkResInstall failed");
      }
      catch (Throwable paramString)
      {
        for (;;) {}
      }
    }
  }
  
  public static void hv(Context paramContext)
  {
    Object localObject2 = Class.forName("android.app.ActivityThread");
    xfj = ShareReflectUtil.c(paramContext, (Class)localObject2);
    try
    {
      localObject1 = Class.forName("android.app.LoadedApk");
      localObject1 = ((Class)localObject1).getDeclaredField("mResDir");
      xfp = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Class)localObject2).getDeclaredField("mPackages");
      xfq = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Class)localObject2).getDeclaredField("mResourcePackages");
      xfr = (Field)localObject1;
      ((Field)localObject1).setAccessible(true);
      if (paramContext.getAssets().getClass().getName().equals("android.content.res.BaiduAssetManager"))
      {
        xfk = (AssetManager)Class.forName("android.content.res.BaiduAssetManager").getConstructor(new Class[0]).newInstance(new Object[0]);
        paramContext = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
        xfl = paramContext;
        paramContext.setAccessible(true);
        paramContext = AssetManager.class.getDeclaredMethod("ensureStringBlocks", new Class[0]);
        xfm = paramContext;
        paramContext.setAccessible(true);
        if (Build.VERSION.SDK_INT < 19) {
          break label309;
        }
        paramContext = Class.forName("android.app.ResourcesManager");
        localObject1 = paramContext.getDeclaredMethod("getInstance", new Class[0]);
        ((Method)localObject1).setAccessible(true);
        localObject1 = ((Method)localObject1).invoke(null, new Object[0]);
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        try
        {
          Object localObject1;
          localObject2 = paramContext.getDeclaredField("mActiveResources");
          ((Field)localObject2).setAccessible(true);
          xfi = ((ArrayMap)((Field)localObject2).get(localObject1)).values();
          if (xfi != null) {
            break;
          }
          throw new IllegalStateException("resource references is null");
          localClassNotFoundException = localClassNotFoundException;
          localClass = Class.forName("android.app.ActivityThread$PackageInfo");
          continue;
          xfk = (AssetManager)AssetManager.class.getConstructor(new Class[0]).newInstance(new Object[0]);
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          Class localClass;
          paramContext = paramContext.getDeclaredField("mResourceReferences");
          paramContext.setAccessible(true);
          xfi = (Collection)paramContext.get(localClass);
          continue;
        }
        label309:
        paramContext = localNoSuchFieldException.getDeclaredField("mActiveResources");
        paramContext.setAccessible(true);
        xfi = ((HashMap)paramContext.get(xfj)).values();
      }
      if (Build.VERSION.SDK_INT >= 24) {}
      for (;;)
      {
        try
        {
          paramContext = Resources.class.getDeclaredField("mResourcesImpl");
          xfo = paramContext;
          paramContext.setAccessible(true);
        }
        catch (Throwable paramContext)
        {
          try
          {
            xfs = ShareReflectUtil.b(ApplicationInfo.class, "publicSourceDir");
            return;
          }
          catch (NoSuchFieldException paramContext) {}
          paramContext = paramContext;
          paramContext = Resources.class.getDeclaredField("mAssets");
          xfn = paramContext;
          paramContext.setAccessible(true);
          continue;
        }
        paramContext = Resources.class.getDeclaredField("mAssets");
        xfn = paramContext;
        paramContext.setAccessible(true);
      }
    }
  }
  
  private static boolean hw(Context paramContext)
  {
    try
    {
      paramContext.getAssets().open("only_use_to_test_tinker_resource.txt");
      return true;
    }
    catch (Throwable paramContext)
    {
      new StringBuilder("checkResUpdate failed, can't find test resource assets file only_use_to_test_tinker_resource.txt e:").append(paramContext.getMessage());
    }
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/tinker/loader/TinkerResourcePatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */