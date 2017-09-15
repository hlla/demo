package com.tencent.mm.plugin.subapp.c;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;

public final class e
{
  private static final f<Integer, e> hjT;
  public String fCN;
  public int hhg;
  public String hhh;
  public int qRC;
  public int qRD;
  public String qRE;
  public int qRF;
  public int qRG;
  public int qRH;
  public int qRI;
  
  static
  {
    GMTrace.i(5843437223936L, 43537);
    hjT = new f(100);
    GMTrace.o(5843437223936L, 43537);
  }
  
  public e()
  {
    GMTrace.i(5843168788480L, 43535);
    GMTrace.o(5843168788480L, 43535);
  }
  
  public static e Hi(String paramString)
  {
    GMTrace.i(5843303006208L, 43536);
    if (bf.mA(paramString))
    {
      GMTrace.o(5843303006208L, 43536);
      return null;
    }
    int i = paramString.indexOf('<');
    Object localObject = paramString;
    if (i > 0) {
      localObject = paramString.substring(i);
    }
    i = ((String)localObject).hashCode();
    paramString = (e)hjT.get(Integer.valueOf(i));
    if (paramString != null)
    {
      GMTrace.o(5843303006208L, 43536);
      return paramString;
    }
    paramString = bg.q((String)localObject, "msg");
    if (paramString == null)
    {
      v.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse msg failed");
      GMTrace.o(5843303006208L, 43536);
      return null;
    }
    try
    {
      localObject = new e();
      ((e)localObject).hhg = bf.getInt((String)paramString.get(".msg.appmsg.appattach.totallen"), 0);
      ((e)localObject).fCN = ((String)paramString.get(".msg.appmsg.appattach.attachid"));
      ((e)localObject).hhh = ((String)paramString.get(".msg.appmsg.appattach.fileext"));
      ((e)localObject).qRC = bf.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindtime"), 0);
      ((e)localObject).qRD = bf.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindid"), 0);
      ((e)localObject).qRE = ((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindattachid"));
      ((e)localObject).qRF = bf.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindattachtotallen"), 0);
      ((e)localObject).qRG = bf.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$remindformat"), 0);
      ((e)localObject).qRH = bf.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$originformat"), 0);
      ((e)localObject).qRI = bf.getInt((String)paramString.get(".msg.appmsg.voicecmd.reminder.$msgsvrid"), 0);
      hjT.k(Integer.valueOf(i), localObject);
      GMTrace.o(5843303006208L, 43536);
      return (e)localObject;
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.VoiceRemindAppMsgExInfo", "parse amessage xml failed");
      v.printErrStackTrace("MicroMsg.VoiceRemindAppMsgExInfo", paramString, "", new Object[0]);
      GMTrace.o(5843303006208L, 43536);
    }
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */