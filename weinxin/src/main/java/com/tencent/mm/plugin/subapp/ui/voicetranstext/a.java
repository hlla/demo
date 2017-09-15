package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ast;
import com.tencent.mm.protocal.c.bib;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bjp;
import com.tencent.mm.protocal.c.lg;
import com.tencent.mm.protocal.c.lh;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;

public final class a
  extends k
  implements j
{
  public static int qUh;
  public static int qUi;
  public static int qUj;
  private b hrN;
  private String mFileName;
  public int mState;
  private com.tencent.mm.y.e nVH;
  private String qUd;
  private int qUe;
  private bjk qUf;
  private long qUg;
  public bjp qUk;
  public bib qUl;
  public ast qUm;
  int qUn;
  
  static
  {
    GMTrace.i(5770691215360L, 42995);
    qUh = 1;
    qUi = 2;
    qUj = 3;
    GMTrace.o(5770691215360L, 42995);
  }
  
  public a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    GMTrace.i(5769885908992L, 42989);
    this.mState = -1;
    a(paramString1, paramInt1, paramInt2, paramLong, paramString2);
    GMTrace.o(5769885908992L, 42989);
  }
  
  public a(String paramString1, int paramInt, String paramString2)
  {
    GMTrace.i(5769751691264L, 42988);
    this.mState = -1;
    a(paramString1, paramInt, -1, -1L, paramString2);
    GMTrace.o(5769751691264L, 42988);
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    GMTrace.i(5770020126720L, 42990);
    b.a locala = new b.a();
    locala.hrV = new lg();
    locala.hrW = new lh();
    locala.uri = "/cgi-bin/micromsg-bin/checkvoicetrans";
    locala.hrU = 546;
    locala.hrX = 0;
    locala.hrY = 0;
    this.mFileName = paramString2;
    this.hrN = locala.BE();
    v.i("MicroMsg.NetSceneCheckVoiceTrans", "voiceId:%s, totalLen:%d, encodeType: %d, svrMsgId: %s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    if (paramInt2 >= 0) {
      this.qUf = d.aq(paramInt2, paramString2);
    }
    if (paramLong > 0L) {
      this.qUg = paramLong;
    }
    this.qUd = paramString1;
    this.qUe = paramInt1;
    GMTrace.o(5770020126720L, 42990);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(5770288562176L, 42992);
    this.nVH = parame1;
    parame1 = (lg)this.hrN.hrS.hsa;
    parame1.tpP = this.qUd;
    parame1.tfd = this.qUe;
    parame1.tpQ = this.qUf;
    parame1.tdE = this.qUg;
    int i = a(parame, this.hrN, this);
    GMTrace.o(5770288562176L, 42992);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(5770422779904L, 42993);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramp = (lh)this.hrN.hrT.hsa;
      if (paramp == null)
      {
        GMTrace.o(5770422779904L, 42993);
        return;
      }
      this.qUk = paramp.tpR;
      this.mState = paramp.jLP;
      this.qUl = paramp.tpS;
      this.qUm = paramp.tpT;
      this.qUn = paramp.tpU;
    }
    for (;;)
    {
      this.nVH.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(5770422779904L, 42993);
      return;
      v.i("MicroMsg.NetSceneCheckVoiceTrans", "end checkVoiceTrans, & errType:%d, errCode:%d, voiceId: %s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.qUd });
    }
  }
  
  public final boolean bnb()
  {
    GMTrace.i(5770556997632L, 42994);
    if ((this.qUk != null) && (!bf.mA(this.qUk.uhu)))
    {
      GMTrace.o(5770556997632L, 42994);
      return true;
    }
    GMTrace.o(5770556997632L, 42994);
    return false;
  }
  
  public final int getType()
  {
    GMTrace.i(5770154344448L, 42991);
    GMTrace.o(5770154344448L, 42991);
    return 546;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/ui/voicetranstext/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */