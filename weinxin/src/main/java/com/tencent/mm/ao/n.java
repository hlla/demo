package com.tencent.mm.ao;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.e;
import com.tencent.mm.bd.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.protocal.c.amt;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.sdk.platformtools.bf;

@Deprecated
public final class n
  extends e.b
{
  private amt hNo;
  
  public n(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    super(1);
    GMTrace.i(13241652609024L, 98658);
    this.hNo = new amt();
    this.hNo.tPF = 2048;
    this.hNo.trH = new avu().OU(bf.mz(paramString1));
    this.hNo.tJy = new avu().OU(bf.mz(paramString2));
    this.hNo.tbS = 0;
    this.hNo.tPG = new avu().OU(bf.mz(paramString3));
    this.hNo.tPH = new avu().OU(bf.mz(paramString4));
    this.hNo.jLP = 0;
    paramString2 = e.c(bf.mz(paramString5), 0, -1);
    paramString3 = this.hNo;
    if (paramString2 == null)
    {
      paramString1 = new byte[0];
      paramString3.tPD = new b(paramString1);
      paramString1 = this.hNo;
      if (paramString2 != null) {
        break label321;
      }
    }
    label321:
    for (int i = 0;; i = paramString2.length)
    {
      paramString1.tPC = i;
      this.hNo.hAl = 0;
      this.hNo.hAp = 0;
      this.hNo.hAo = bf.mz(paramString6);
      this.hNo.hAn = bf.mz(paramString7);
      this.hNo.hAm = bf.mz(paramString8);
      this.hNo.tbV = paramInt;
      this.hNo.tLf = bf.mz(paramString9);
      this.hNo.tPM = 0;
      this.hNo.hAq = bf.mz(paramString10);
      this.hNo.tLh = 0;
      this.hNo.tLg = "";
      this.nxx = this.hNo;
      GMTrace.o(13241652609024L, 98658);
      return;
      paramString1 = paramString2;
      break;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ao/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */