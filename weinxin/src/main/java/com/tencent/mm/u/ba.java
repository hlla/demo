package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import java.util.Map;

public final class ba
{
  public static int hmY;
  
  static
  {
    GMTrace.i(646661013504L, 4818);
    hmY = 0;
    GMTrace.o(646661013504L, 4818);
  }
  
  public static void gp(String paramString)
  {
    GMTrace.i(646526795776L, 4817);
    v.i("MicroMsg.MsgSourceHelper", "parseMsgSource  has been Deprecated  by dk. at 20151218 [%s] %s ", new Object[] { paramString, "" });
    GMTrace.o(646526795776L, 4817);
  }
  
  public static int k(au paramau)
  {
    GMTrace.i(646124142592L, 4814);
    if (paramau == null)
    {
      GMTrace.o(646124142592L, 4814);
      return 0;
    }
    paramau = bg.q(paramau.gxv, "msgsource");
    if (paramau != null)
    {
      paramau = (String)paramau.get(".msgsource.bizflag");
      if (bf.mA(paramau)) {}
    }
    for (int i = bf.getInt(paramau, 0);; i = 0)
    {
      GMTrace.o(646124142592L, 4814);
      return i;
    }
  }
  
  public static void q(String paramString, boolean paramBoolean)
  {
    GMTrace.i(645855707136L, 4812);
    if ("bizflag".equals(paramString))
    {
      if (paramBoolean)
      {
        hmY |= 0x1;
        GMTrace.o(645855707136L, 4812);
        return;
      }
      hmY &= 0xFFFFFFFE;
    }
    GMTrace.o(645855707136L, 4812);
  }
  
  public static String zA()
  {
    GMTrace.i(646392578048L, 4816);
    String str = (String)h.vI().vr().get(70, null);
    if (!bf.mA(str)) {
      h.vI().vr().set(70, "");
    }
    v.d("MicroMsg.MsgSourceHelper", "getMsg ccr[%s]", new Object[] { str });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<msgsource>");
    localStringBuilder.append(bf.mz(str));
    if (hmY != 0)
    {
      localStringBuilder.append("<");
      localStringBuilder.append("bizflag");
      localStringBuilder.append(">");
      localStringBuilder.append(hmY);
      localStringBuilder.append("</");
      localStringBuilder.append("bizflag");
      localStringBuilder.append(">");
    }
    localStringBuilder.append("</msgsource>");
    str = localStringBuilder.toString();
    GMTrace.o(646392578048L, 4816);
    return str;
  }
  
  public static String zy()
  {
    GMTrace.i(645989924864L, 4813);
    Object localObject = new StringBuilder();
    if (hmY != 0)
    {
      ((StringBuilder)localObject).append("<");
      ((StringBuilder)localObject).append("bizflag");
      ((StringBuilder)localObject).append(">");
      ((StringBuilder)localObject).append(hmY);
      ((StringBuilder)localObject).append("</");
      ((StringBuilder)localObject).append("bizflag");
      ((StringBuilder)localObject).append(">");
    }
    localObject = ((StringBuilder)localObject).toString();
    GMTrace.o(645989924864L, 4813);
    return (String)localObject;
  }
  
  public static String zz()
  {
    GMTrace.i(646258360320L, 4815);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(bf.mz(zy()));
    if (((StringBuilder)localObject).length() > 0)
    {
      ((StringBuilder)localObject).insert(0, "<msgsource>");
      ((StringBuilder)localObject).append("</msgsource>");
      localObject = ((StringBuilder)localObject).toString();
      GMTrace.o(646258360320L, 4815);
      return (String)localObject;
    }
    GMTrace.o(646258360320L, 4815);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */