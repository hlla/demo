package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.DexLoader;
import dalvik.system.DexClassLoader;

final class z
{
  protected DexLoader wUo = null;
  
  public z(DexLoader paramDexLoader)
  {
    this.wUo = paramDexLoader;
  }
  
  public final void a(Object paramObject, Activity paramActivity, int paramInt)
  {
    this.wUo.invokeMethod(paramObject, "com.tencent.tbs.player.TbsPlayerProxy", "onActivity", new Class[] { Activity.class, Integer.TYPE }, new Object[] { paramActivity, Integer.valueOf(paramInt) });
  }
  
  public final boolean a(Object paramObject1, Bundle paramBundle, FrameLayout paramFrameLayout, Object paramObject2)
  {
    paramObject1 = this.wUo.invokeMethod(paramObject1, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[] { Bundle.class, FrameLayout.class }, new Object[] { paramBundle, paramFrameLayout });
    if ((paramObject1 instanceof Boolean)) {
      return ((Boolean)paramObject1).booleanValue();
    }
    return false;
  }
  
  public final Object gz(Context paramContext)
  {
    DexLoader localDexLoader = this.wUo;
    DexClassLoader localDexClassLoader = this.wUo.getClassLoader();
    return localDexLoader.newInstance("com.tencent.tbs.player.TbsPlayerProxy", new Class[] { Context.class, DexClassLoader.class }, new Object[] { paramContext, localDexClassLoader });
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */