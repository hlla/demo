package com.tencent.mm.plugin.appbrand.i;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;

public abstract interface c
  extends a
{
  public abstract void a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, AppBrandStatObject paramAppBrandStatObject);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/appbrand/i/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */