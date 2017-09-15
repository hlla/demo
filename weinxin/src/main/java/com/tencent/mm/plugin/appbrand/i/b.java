package com.tencent.mm.plugin.appbrand.i;

import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;

public abstract interface b
  extends a
{
  public abstract void a(String paramString, a parama);
  
  public abstract WxaAttributes og(String paramString);
  
  public abstract void oh(String paramString);
  
  public static abstract interface a
  {
    public abstract void c(WxaAttributes paramWxaAttributes);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/appbrand/i/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */