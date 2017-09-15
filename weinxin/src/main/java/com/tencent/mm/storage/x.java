package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.af;
import com.tencent.mm.i.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class x
  extends com.tencent.mm.j.a
  implements Cloneable
{
  public String uGR;
  public CharSequence uxg;
  
  public x()
  {
    GMTrace.i(13308090384384L, 99153);
    this.uGR = null;
    GMTrace.o(13308090384384L, 99153);
  }
  
  public x(String paramString)
  {
    super(paramString);
    GMTrace.i(13307956166656L, 99152);
    this.uGR = null;
    GMTrace.o(13307956166656L, 99152);
  }
  
  public static boolean QL(String paramString)
  {
    GMTrace.i(13308224602112L, 99154);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@t.qq.com");
      GMTrace.o(13308224602112L, 99154);
      return bool;
    }
    GMTrace.o(13308224602112L, 99154);
    return false;
  }
  
  public static boolean QM(String paramString)
  {
    GMTrace.i(17534875074560L, 130645);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@qr");
      GMTrace.o(17534875074560L, 130645);
      return bool;
    }
    GMTrace.o(17534875074560L, 130645);
    return false;
  }
  
  public static boolean QN(String paramString)
  {
    GMTrace.i(13308493037568L, 99156);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@qqim");
      GMTrace.o(13308493037568L, 99156);
      return bool;
    }
    GMTrace.o(13308493037568L, 99156);
    return false;
  }
  
  public static boolean QO(String paramString)
  {
    GMTrace.i(13308627255296L, 99157);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@fb");
      GMTrace.o(13308627255296L, 99157);
      return bool;
    }
    GMTrace.o(13308627255296L, 99157);
    return false;
  }
  
  public static boolean QP(String paramString)
  {
    GMTrace.i(13309164126208L, 99161);
    boolean bool = aO(paramString, false);
    GMTrace.o(13309164126208L, 99161);
    return bool;
  }
  
  public static String QQ(String paramString)
  {
    GMTrace.i(13309298343936L, 99162);
    if (eO(paramString))
    {
      String[] arrayOfString = paramString.split(":");
      if ((arrayOfString == null) || (arrayOfString.length <= 0))
      {
        GMTrace.o(13309298343936L, 99162);
        return paramString;
      }
      paramString = arrayOfString[0];
      GMTrace.o(13309298343936L, 99162);
      return paramString;
    }
    if ((paramString != null) && (paramString.contains("@")))
    {
      GMTrace.o(13309298343936L, 99162);
      return "";
    }
    paramString = paramString + "@bottle";
    GMTrace.o(13309298343936L, 99162);
    return paramString;
  }
  
  public static boolean aO(String paramString, boolean paramBoolean)
  {
    GMTrace.i(17535009292288L, 130646);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.Contact", "Contact invisibleUsername username == null or nil");
      GMTrace.o(17535009292288L, 130646);
      return false;
    }
    String str = ((com.tencent.mm.plugin.zero.b.a)h.h(com.tencent.mm.plugin.zero.b.a.class)).sW().z("HideWechatID", "idprefix");
    Object localObject = str;
    if (str == null) {
      localObject = "wx_;wxid_;gh_;a0;a1;a2;a3;a4;a5;a6;a7;a8;a9;q0;q1;q2;q3;q4;q5;q6;q7;q8;q9;qq0;qq1;qq2;qq3;qq4;qq5;qq6;qq7;qq8;qq9;f0;f1;f2;f3;f4;f5;f6;f7;f8;f9;F0;F1;F2;F3;F4;F5;F6;F7;F8;F9;";
    }
    localObject = ((String)localObject).split(";");
    int i = 0;
    while (i < localObject.length)
    {
      if ((localObject[i] != null) && (paramString.startsWith(localObject[i])))
      {
        if ((localObject[i].equals("wxid_")) && (paramBoolean))
        {
          GMTrace.o(17535009292288L, 130646);
          return false;
        }
        GMTrace.o(17535009292288L, 130646);
        return true;
      }
      i += 1;
    }
    GMTrace.o(17535009292288L, 130646);
    return false;
  }
  
  public static boolean bKT()
  {
    GMTrace.i(17535143510016L, 130647);
    GMTrace.o(17535143510016L, 130647);
    return false;
  }
  
  public static int bKV()
  {
    GMTrace.i(13309566779392L, 99164);
    GMTrace.o(13309566779392L, 99164);
    return 16;
  }
  
  public static int bKW()
  {
    GMTrace.i(13309700997120L, 99165);
    GMTrace.o(13309700997120L, 99165);
    return 8;
  }
  
  public static boolean eO(String paramString)
  {
    GMTrace.i(13308761473024L, 99158);
    if (paramString != null)
    {
      if ((paramString.contains("@bottle:")) || (paramString.endsWith("@bottle")))
      {
        GMTrace.o(13308761473024L, 99158);
        return true;
      }
      GMTrace.o(13308761473024L, 99158);
      return false;
    }
    GMTrace.o(13308761473024L, 99158);
    return false;
  }
  
  public static boolean em(String paramString)
  {
    GMTrace.i(13309029908480L, 99160);
    if (paramString != null)
    {
      boolean bool = paramString.endsWith("@app");
      GMTrace.o(13309029908480L, 99160);
      return bool;
    }
    GMTrace.o(13309029908480L, 99160);
    return false;
  }
  
  public static String h(Cursor paramCursor)
  {
    GMTrace.i(13309969432576L, 99167);
    paramCursor = paramCursor.getString(paramCursor.getColumnIndex("username"));
    GMTrace.o(13309969432576L, 99167);
    return paramCursor;
  }
  
  public static boolean yx(int paramInt)
  {
    GMTrace.i(13308895690752L, 99159);
    if ((paramInt & 0x8) > 0)
    {
      GMTrace.o(13308895690752L, 99159);
      return true;
    }
    GMTrace.o(13308895690752L, 99159);
    return false;
  }
  
  public final boolean bKU()
  {
    GMTrace.i(13309432561664L, 99163);
    if ((this.field_verifyFlag & 0x8) > 0)
    {
      GMTrace.o(13309432561664L, 99163);
      return true;
    }
    GMTrace.o(13309432561664L, 99163);
    return false;
  }
  
  public final boolean bKX()
  {
    GMTrace.i(13309835214848L, 99166);
    if ((int)bf.Nz() - this.gky > 86400L)
    {
      GMTrace.o(13309835214848L, 99166);
      return true;
    }
    GMTrace.o(13309835214848L, 99166);
    return false;
  }
  
  public final String bKY()
  {
    GMTrace.i(13310372085760L, 99170);
    Object localObject = this.gkx;
    if (bf.mA((String)localObject))
    {
      GMTrace.o(13310372085760L, 99170);
      return "";
    }
    localObject = ((String)localObject).split("_");
    if ((localObject == null) || (localObject.length < 2))
    {
      GMTrace.o(13310372085760L, 99170);
      return "";
    }
    localObject = bf.mz(localObject[1]);
    GMTrace.o(13310372085760L, 99170);
    return (String)localObject;
  }
  
  public final void bKZ()
  {
    GMTrace.i(13311177392128L, 99176);
    Object localObject = this.gkx;
    if (bf.mA((String)localObject))
    {
      GMTrace.o(13311177392128L, 99176);
      return;
    }
    localObject = ((String)localObject).split("_");
    if (localObject.length > 0)
    {
      if (localObject.length > 2)
      {
        if (RegionCodeDecoder.RQ(localObject[0])) {
          super.cf(RegionCodeDecoder.bMF().eL(localObject[0], localObject[1]));
        }
        for (;;)
        {
          super.cg(RegionCodeDecoder.bMF().ac(localObject[0], localObject[1], localObject[2]));
          GMTrace.o(13311177392128L, 99176);
          return;
          super.cf(RegionCodeDecoder.bMF().RR(localObject[0]));
        }
      }
      if (localObject.length == 2)
      {
        super.cf(RegionCodeDecoder.bMF().RR(localObject[0]));
        super.cg(RegionCodeDecoder.bMF().eL(localObject[0], localObject[1]));
        GMTrace.o(13311177392128L, 99176);
        return;
      }
      super.cf(RegionCodeDecoder.bMF().RR(localObject[0]));
      super.cg("");
    }
    GMTrace.o(13311177392128L, 99176);
  }
  
  public final x bLa()
  {
    GMTrace.i(13311311609856L, 99177);
    try
    {
      x localx = (x)super.clone();
      GMTrace.o(13311311609856L, 99177);
      return localx;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.printErrStackTrace("MicroMsg.Contact", localException, "", new Object[0]);
        v.e("MicroMsg.Contact", "clone Contact error. e: " + localException.toString());
        Object localObject = null;
      }
    }
  }
  
  @Deprecated
  public final void cf(String paramString)
  {
    GMTrace.i(13310640521216L, 99172);
    super.cf(paramString);
    GMTrace.o(13310640521216L, 99172);
  }
  
  @Deprecated
  public final void cg(String paramString)
  {
    GMTrace.i(13310774738944L, 99173);
    super.cg(paramString);
    GMTrace.o(13310774738944L, 99173);
  }
  
  public final void ck(String paramString)
  {
    GMTrace.i(13310103650304L, 99168);
    super.ck(paramString);
    bKZ();
    GMTrace.o(13310103650304L, 99168);
  }
  
  public final String getCity()
  {
    GMTrace.i(13311043174400L, 99175);
    String str = super.getCity();
    GMTrace.o(13311043174400L, 99175);
    return str;
  }
  
  public final String getCityCode()
  {
    GMTrace.i(13310506303488L, 99171);
    Object localObject = this.gkx;
    if (bf.mA((String)localObject))
    {
      GMTrace.o(13310506303488L, 99171);
      return "";
    }
    localObject = ((String)localObject).split("_");
    if ((localObject == null) || (localObject.length < 3))
    {
      GMTrace.o(13310506303488L, 99171);
      return "";
    }
    localObject = bf.mz(localObject[2]);
    GMTrace.o(13310506303488L, 99171);
    return (String)localObject;
  }
  
  public final String getCountryCode()
  {
    GMTrace.i(13310237868032L, 99169);
    Object localObject = this.gkx;
    if (bf.mA((String)localObject))
    {
      GMTrace.o(13310237868032L, 99169);
      return "";
    }
    localObject = ((String)localObject).split("_");
    if ((localObject == null) || (localObject.length <= 0))
    {
      GMTrace.o(13310237868032L, 99169);
      return "";
    }
    localObject = bf.mz(localObject[0]);
    GMTrace.o(13310237868032L, 99169);
    return (String)localObject;
  }
  
  public final String getProvince()
  {
    GMTrace.i(13310908956672L, 99174);
    String str = super.getProvince();
    GMTrace.o(13310908956672L, 99174);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */