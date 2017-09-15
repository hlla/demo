package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class c
  extends i<b>
{
  public static final String[] gUn;
  e gUp;
  
  static
  {
    GMTrace.i(791347724288L, 5896);
    gUn = new String[] { i.a(b.gTF, "appattach") };
    GMTrace.o(791347724288L, 5896);
  }
  
  public c(e parame)
  {
    super(parame, b.gTF, "appattach", null);
    GMTrace.i(790945071104L, 5893);
    this.gUp = parame;
    GMTrace.o(790945071104L, 5893);
  }
  
  public final b LV(String paramString)
  {
    GMTrace.i(791079288832L, 5894);
    b localb = new b();
    localb.field_mediaSvrId = paramString;
    if (b(localb, new String[] { "mediaSvrId" }))
    {
      GMTrace.o(791079288832L, 5894);
      return localb;
    }
    if (b(localb, new String[] { "mediaId" }))
    {
      GMTrace.o(791079288832L, 5894);
      return localb;
    }
    GMTrace.o(791079288832L, 5894);
    return null;
  }
  
  public final b eb(long paramLong)
  {
    GMTrace.i(791213506560L, 5895);
    b localb = new b();
    localb.field_msgInfoId = paramLong;
    if (b(localb, new String[] { "msgInfoId" }))
    {
      GMTrace.o(791213506560L, 5895);
      return localb;
    }
    GMTrace.o(791213506560L, 5895);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */