package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.amt;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.t;

public final class bg
{
  public String countryCode;
  public int gkh;
  public int gkq;
  public String gkv;
  private String hnu;
  private String hnv;
  public String hnw;
  public String hnx;
  public String signature;
  
  public bg()
  {
    GMTrace.i(13291984257024L, 99033);
    this.gkq = 0;
    this.gkh = 0;
    this.hnu = "";
    this.hnv = "";
    this.signature = "";
    this.gkv = "";
    this.countryCode = "";
    this.hnx = "";
    this.hnw = "";
    GMTrace.o(13291984257024L, 99033);
  }
  
  public static amt a(bg parambg)
  {
    GMTrace.i(13291850039296L, 99032);
    h.vI().vr().set(12289, Integer.valueOf(parambg.gkq));
    h.vI().vr().set(12290, Integer.valueOf(parambg.gkh));
    if (a.N((String)h.vI().vr().get(12293, null), parambg.getProvince())) {
      h.vI().vr().set(12293, parambg.getProvince());
    }
    if (a.N((String)h.vI().vr().get(12292, null), parambg.getCity())) {
      h.vI().vr().set(12292, parambg.getCity());
    }
    if (a.N((String)h.vI().vr().get(12291, null), parambg.signature)) {
      h.vI().vr().set(12291, parambg.signature);
    }
    if (a.N((String)h.vI().vr().get(12307, null), parambg.gkv)) {
      h.vI().vr().set(12307, parambg.gkv);
    }
    if (a.N((String)h.vI().vr().get(12324, null), parambg.countryCode)) {
      h.vI().vr().set(12324, parambg.countryCode);
    }
    if (a.N((String)h.vI().vr().get(12325, null), parambg.hnx)) {
      h.vI().vr().set(12325, parambg.hnx);
    }
    if (a.N((String)h.vI().vr().get(12326, null), parambg.hnw)) {
      h.vI().vr().set(12326, parambg.hnw);
    }
    amt localamt = new amt();
    localamt.tPF = 128;
    localamt.trH = new avu().OU("");
    localamt.tJy = new avu().OU("");
    localamt.tbS = 0;
    localamt.tPG = new avu().OU("");
    localamt.tPH = new avu().OU("");
    localamt.jLP = 0;
    byte[] arrayOfByte2 = com.tencent.mm.a.e.c("", 0, -1);
    byte[] arrayOfByte1;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = new byte[0];
      localamt.tPD = new b(arrayOfByte1);
      if (arrayOfByte2 != null) {
        break label604;
      }
    }
    label604:
    for (int i = 0;; i = arrayOfByte2.length)
    {
      localamt.tPC = i;
      localamt.hAl = parambg.gkh;
      localamt.hAp = parambg.gkq;
      localamt.hAo = bf.mz(parambg.signature);
      localamt.hAn = bf.mz(parambg.hnw);
      localamt.hAm = bf.mz(parambg.hnx);
      localamt.tbV = 0;
      localamt.tLf = bf.mz(parambg.gkv);
      localamt.tPM = 0;
      localamt.hAq = "";
      localamt.tLh = 0;
      localamt.tLg = "";
      localamt.hAu = bf.mz(parambg.countryCode);
      GMTrace.o(13291850039296L, 99032);
      return localamt;
      arrayOfByte1 = arrayOfByte2;
      break;
    }
  }
  
  public static bg zL()
  {
    GMTrace.i(13291581603840L, 99030);
    bg localbg = new bg();
    localbg.gkq = 1;
    localbg.gkh = bf.a((Integer)h.vI().vr().get(12290, null), 0);
    localbg.hnu = ((String)h.vI().vr().get(12293, null));
    localbg.hnv = ((String)h.vI().vr().get(12292, null));
    localbg.signature = ((String)h.vI().vr().get(12291, null));
    localbg.gkv = ((String)h.vI().vr().get(12307, null));
    localbg.countryCode = ((String)h.vI().vr().get(12324, null));
    localbg.hnx = ((String)h.vI().vr().get(12325, null));
    localbg.hnw = ((String)h.vI().vr().get(12326, null));
    GMTrace.o(13291581603840L, 99030);
    return localbg;
  }
  
  public static bg zM()
  {
    GMTrace.i(13291715821568L, 99031);
    if (bf.a((Integer)h.vI().vr().get(12289, null), 0) == 0)
    {
      GMTrace.o(13291715821568L, 99031);
      return null;
    }
    bg localbg = zL();
    GMTrace.o(13291715821568L, 99031);
    return localbg;
  }
  
  public final String getCity()
  {
    GMTrace.i(13292118474752L, 99034);
    if (!bf.mA(this.countryCode))
    {
      if (bf.mA(this.hnx)) {
        break label109;
      }
      if (!bf.mA(this.hnw)) {
        break label84;
      }
      this.hnv = RegionCodeDecoder.bMF().eL(this.countryCode, this.hnx);
    }
    while (bf.mA(this.hnv))
    {
      str = bf.mz(this.hnw);
      GMTrace.o(13292118474752L, 99034);
      return str;
      label84:
      this.hnv = RegionCodeDecoder.bMF().ac(this.countryCode, this.hnx, this.hnw);
      continue;
      label109:
      this.hnv = "";
    }
    String str = this.hnv;
    GMTrace.o(13292118474752L, 99034);
    return str;
  }
  
  public final String getProvince()
  {
    GMTrace.i(13292252692480L, 99035);
    if (!bf.mA(this.countryCode)) {
      if ((bf.mA(this.hnx)) || (bf.mA(this.hnw)) || (!RegionCodeDecoder.RQ(this.countryCode))) {
        break label94;
      }
    }
    label94:
    for (this.hnu = RegionCodeDecoder.bMF().eL(this.countryCode, this.hnx); bf.mA(this.hnu); this.hnu = RegionCodeDecoder.bMF().RR(this.countryCode))
    {
      str = bf.mz(this.hnx);
      GMTrace.o(13292252692480L, 99035);
      return str;
    }
    String str = this.hnu;
    GMTrace.o(13292252692480L, 99035);
    return str;
  }
  
  private static final class a
  {
    public static boolean N(String paramString1, String paramString2)
    {
      GMTrace.i(13286212894720L, 98990);
      if (bf.mA(paramString1))
      {
        GMTrace.o(13286212894720L, 98990);
        return true;
      }
      paramString1 = decode(encode(paramString1));
      if ((bf.mA(paramString1)) || (!paramString1.equals(paramString2)))
      {
        GMTrace.o(13286212894720L, 98990);
        return true;
      }
      GMTrace.o(13286212894720L, 98990);
      return false;
    }
    
    private static String decode(String paramString)
    {
      GMTrace.i(13286481330176L, 98992);
      if ((bf.mA(paramString)) || (paramString.length() % 2 != 0))
      {
        GMTrace.o(13286481330176L, 98992);
        return "";
      }
      String str = "";
      int i = 0;
      try
      {
        while (i < paramString.length())
        {
          str = str + (char)Integer.parseInt(paramString.substring(i, i + 2), 16);
          i += 2;
        }
        GMTrace.o(13286481330176L, 98992);
      }
      catch (Exception paramString)
      {
        GMTrace.o(13286481330176L, 98992);
        return "";
      }
      return str;
    }
    
    private static String encode(String paramString)
    {
      GMTrace.i(13286347112448L, 98991);
      char[] arrayOfChar = paramString.toCharArray();
      try
      {
        int j = arrayOfChar.length;
        paramString = "";
        int i = 0;
        while (i < j)
        {
          int k = arrayOfChar[i];
          paramString = paramString + String.format("%02x", new Object[] { Integer.valueOf(k) });
          i += 1;
        }
        GMTrace.o(13286347112448L, 98991);
      }
      catch (Exception paramString)
      {
        GMTrace.o(13286347112448L, 98991);
        return "";
      }
      return paramString;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */