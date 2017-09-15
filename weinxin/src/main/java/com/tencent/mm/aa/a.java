package com.tencent.mm.aa;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.m;
import java.util.Map;

public final class a
{
  private static int hxg;
  private static int hxh;
  
  static
  {
    GMTrace.i(1370497220608L, 10211);
    hxg = 0;
    hxh = 0;
    GMTrace.o(1370497220608L, 10211);
  }
  
  public static String a(a parama)
  {
    GMTrace.i(1370228785152L, 10209);
    if (parama == null)
    {
      GMTrace.o(1370228785152L, 10209);
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append(bf.mz(parama.hxq));
    localStringBuilder.append("\n-------------------\n");
    localStringBuilder.append(bf.mz(parama.hxo));
    localStringBuilder.append("\n-------------------\n");
    localStringBuilder.append(bf.mz(parama.hxl));
    parama = localStringBuilder.toString();
    GMTrace.o(1370228785152L, 10209);
    return parama;
  }
  
  public static String b(a parama)
  {
    GMTrace.i(1370363002880L, 10210);
    StringBuilder localStringBuilder = new StringBuilder("");
    if (!m.eH(parama.fOl))
    {
      localStringBuilder.append(parama.hxi);
      localStringBuilder.append(": ");
    }
    if (bf.mA(parama.hxq)) {
      if (bf.mA(parama.hxo)) {
        parama = parama.hxl;
      }
    }
    for (;;)
    {
      localStringBuilder.append(parama);
      parama = localStringBuilder.toString();
      GMTrace.o(1370363002880L, 10210);
      return parama;
      parama = parama.hxo;
      continue;
      parama = parama.hxq;
    }
  }
  
  public static final class a
  {
    private static final f<Integer, a> hjT;
    public String fOl;
    public String hxi;
    public String hxj;
    public String hxk;
    public String hxl;
    public String hxm;
    public String hxn;
    public String hxo;
    public String hxp;
    public String hxq;
    public String toUser;
    
    static
    {
      GMTrace.i(1370094567424L, 10208);
      hjT = new f(100);
      GMTrace.o(1370094567424L, 10208);
    }
    
    public a()
    {
      GMTrace.i(1369826131968L, 10206);
      GMTrace.o(1369826131968L, 10206);
    }
    
    public static final a iH(String paramString)
    {
      GMTrace.i(1369960349696L, 10207);
      if (bf.mA(paramString))
      {
        v.e("MicroMsg.BrandQALogic", "empty xml to parse");
        GMTrace.o(1369960349696L, 10207);
        return null;
      }
      int i = paramString.indexOf("<qamsg");
      Object localObject = paramString;
      if (i > 0) {
        localObject = paramString.substring(i);
      }
      i = ((String)localObject).hashCode();
      paramString = (a)hjT.get(Integer.valueOf(i));
      if (paramString != null)
      {
        GMTrace.o(1369960349696L, 10207);
        return paramString;
      }
      paramString = bg.q((String)localObject, "qamsg");
      if (paramString == null)
      {
        v.e("MicroMsg.BrandQALogic", "parse msg failed");
        GMTrace.o(1369960349696L, 10207);
        return null;
      }
      try
      {
        localObject = new a();
        ((a)localObject).fOl = ((String)paramString.get(".qamsg.$fromUser"));
        ((a)localObject).hxi = ((String)paramString.get(".qamsg.$fromNickname"));
        ((a)localObject).toUser = ((String)paramString.get(".qamsg.$title"));
        ((a)localObject).hxj = ((String)paramString.get(".qamsg.question.$id"));
        ((a)localObject).hxk = ((String)paramString.get(".qamsg.question.$fromUser"));
        ((a)localObject).hxl = ((String)paramString.get(".qamsg.question.content"));
        ((a)localObject).hxm = ((String)paramString.get(".qamsg.answer.$id"));
        ((a)localObject).hxn = ((String)paramString.get(".qamsg.answer.$fromUser"));
        ((a)localObject).hxo = ((String)paramString.get(".qamsg.answer.content"));
        ((a)localObject).hxm = ((String)paramString.get(".qamsg.answer1.$id"));
        ((a)localObject).hxp = ((String)paramString.get(".qamsg.answer1.$fromUser"));
        ((a)localObject).hxq = ((String)paramString.get(".qamsg.answer1.content"));
        hjT.k(Integer.valueOf(i), localObject);
        GMTrace.o(1369960349696L, 10207);
        return (a)localObject;
      }
      catch (Exception paramString)
      {
        v.e("MicroMsg.BrandQALogic", "parse qamessage xml failed");
        v.printErrStackTrace("MicroMsg.BrandQALogic", paramString, "", new Object[0]);
        GMTrace.o(1369960349696L, 10207);
      }
      return null;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/aa/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */