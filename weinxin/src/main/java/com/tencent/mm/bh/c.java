package com.tencent.mm.bh;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.f.a.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.svg.b.b;

public final class c
{
  com.tencent.mm.svg.a.a unK;
  
  static
  {
    GMTrace.i(371783106560L, 2770);
    com.tencent.mm.compatible.f.a.a(new a());
    b.jY(aa.getContext().getSharedPreferences("wechat_svg_debug", 4).getBoolean("open_tag", false));
    GMTrace.o(371783106560L, 2770);
  }
  
  public c()
  {
    GMTrace.i(371380453376L, 2767);
    this.unK = new com.tencent.mm.svg.a.a();
    GMTrace.o(371380453376L, 2767);
  }
  
  public static void jI(boolean paramBoolean)
  {
    GMTrace.i(371648888832L, 2769);
    aa.getContext().getSharedPreferences("wechat_svg_debug", 4).edit().putBoolean("open_tag", paramBoolean).commit();
    b.jY(paramBoolean);
    GMTrace.o(371648888832L, 2769);
  }
  
  public final Drawable c(Resources paramResources, int paramInt)
  {
    GMTrace.i(371514671104L, 2768);
    Drawable localDrawable = null;
    if (this.unK.d(paramResources, paramInt)) {
      localDrawable = com.tencent.mm.svg.a.a.c(paramResources, paramInt);
    }
    GMTrace.o(371514671104L, 2768);
    return localDrawable;
  }
  
  public static final class a
    implements a.a
  {
    com.tencent.mm.svg.a.a unK;
    
    public a()
    {
      GMTrace.i(371112017920L, 2765);
      this.unK = new com.tencent.mm.svg.a.a();
      GMTrace.o(371112017920L, 2765);
    }
    
    public final Bitmap decodeResource(Resources paramResources, int paramInt, BitmapFactory.Options paramOptions)
    {
      GMTrace.i(371246235648L, 2766);
      if (this.unK.d(paramResources, paramInt))
      {
        float f = 0.0F;
        if (paramOptions != null) {
          f = paramOptions.inDensity / 160.0F;
        }
        paramResources = com.tencent.mm.svg.a.a.b(paramResources, paramInt, f);
        GMTrace.o(371246235648L, 2766);
        return paramResources;
      }
      GMTrace.o(371246235648L, 2766);
      return null;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bh/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */