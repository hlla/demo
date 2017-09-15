package com.tencent.mm.pluginsdk.ui;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;

public final class e
{
  public int sGK;
  public boolean sGL;
  public int sGM;
  public boolean sGN;
  public int sGO;
  public boolean sGP;
  public int sGQ;
  public boolean sGR;
  private int version;
  
  public e(String paramString)
  {
    GMTrace.i(1182860836864L, 8813);
    this.version = 0;
    this.sGK = -7829368;
    this.sGL = false;
    this.sGM = -1593835521;
    this.sGN = false;
    this.sGO = -16777216;
    this.sGP = false;
    this.sGQ = 0;
    this.sGR = false;
    paramString = bg.q(paramString, "chatbg");
    String str = "." + "chatbg";
    try
    {
      this.version = bf.f(Integer.valueOf((String)paramString.get(str + ".$version")));
      this.sGK = ((int)bf.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_color"), 16)), -7829368L));
      this.sGL = bf.f(Boolean.valueOf((String)paramString.get(str + ".$time_show_shadow_color")));
      this.sGM = ((int)bf.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$time_shadow_color"), 16)), 0L));
      this.sGN = bf.f(Boolean.valueOf((String)paramString.get(str + ".$time_show_background")));
      this.sGO = ((int)bf.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_color"), 16)), -16777216L));
      this.sGP = bf.f(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_shadow_color")));
      this.sGQ = ((int)bf.a(Long.valueOf(Long.parseLong((String)paramString.get(str + ".$voice_second_shadow_color"), 16)), 0L));
      this.sGR = bf.f(Boolean.valueOf((String)paramString.get(str + ".$voice_second_show_background")));
      GMTrace.o(1182860836864L, 8813);
      return;
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed");
      v.printErrStackTrace("MicroMsg.ChatBgAttr", paramString, "", new Object[0]);
      GMTrace.o(1182860836864L, 8813);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */