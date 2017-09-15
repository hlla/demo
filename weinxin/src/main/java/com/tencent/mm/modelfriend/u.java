package com.tencent.mm.modelfriend;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.c.azz;
import com.tencent.mm.protocal.c.bdr;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.p.a;
import com.tencent.mm.protocal.p.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.aq;
import com.tencent.mm.y.i;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class u
  extends k
  implements j
{
  private com.tencent.mm.y.e gUt;
  private int hsF;
  public com.tencent.mm.network.p htc;
  
  private u(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    GMTrace.i(4436432781312L, 33054);
    this.hsF = 2;
    this.htc = new a();
    p.a locala = (p.a)this.htc.BG();
    locala.sYi.tgi = paramInt;
    locala.sYi.thD = paramString1;
    locala.sYi.lda = com.tencent.mm.sdk.platformtools.u.bID();
    locala.sYi.tie = bf.PQ(paramString2);
    locala.sYi.tsD = paramString3;
    locala.sYi.tfW = ap.uY();
    locala.sYi.tsE = com.tencent.mm.compatible.d.p.getSimCountryIso();
    locala.sYi.tsF = 1;
    GMTrace.o(4436432781312L, 33054);
  }
  
  public u(String paramString1, String paramString2)
  {
    this(1, paramString1, paramString2, "");
    GMTrace.i(4436701216768L, 33056);
    GMTrace.o(4436701216768L, 33056);
  }
  
  public u(String paramString1, String paramString2, String paramString3)
  {
    this(2, paramString1, paramString2, paramString3);
    GMTrace.i(4436566999040L, 33055);
    GMTrace.o(4436566999040L, 33055);
  }
  
  public final int FC()
  {
    GMTrace.i(4437372305408L, 33061);
    Object localObject = ((p.b)this.htc.zg()).sYj.tfJ;
    bdr localbdr;
    if ((localObject != null) && (((azz)localObject).tZD != null) && (((azz)localObject).tZD.size() > 0))
    {
      localObject = ((azz)localObject).tZD.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localbdr = (bdr)((Iterator)localObject).next();
      } while (localbdr.oSb != 1);
    }
    for (int i = bf.getInt(localbdr.udp, 0);; i = 0)
    {
      GMTrace.o(4437372305408L, 33061);
      return i;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(4436835434496L, 33057);
    this.gUt = parame1;
    int i = a(parame, this.htc, this);
    GMTrace.o(4436835434496L, 33057);
    return i;
  }
  
  protected final int a(com.tencent.mm.network.p paramp)
  {
    GMTrace.i(4437238087680L, 33060);
    int i = k.b.hsC;
    GMTrace.o(4437238087680L, 33060);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(4436969652224L, 33058);
    v.i("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramp = (p.b)paramp.zg();
    if ((paramInt2 == 4) && (paramInt3 == 65235))
    {
      aq.a(true, paramp.sYj.tig, paramp.sYj.tih, paramp.sYj.tif);
      this.hsF -= 1;
      if (this.hsF <= 0)
      {
        this.gUt.a(3, -1, "", this);
        GMTrace.o(4436969652224L, 33058);
        return;
      }
      a(this.hsm, this.gUt);
      GMTrace.o(4436969652224L, 33058);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(4436969652224L, 33058);
      return;
    }
    aq.a(false, paramp.sYj.tig, paramp.sYj.tih, paramp.sYj.tif);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      b.hh(FC());
    }
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(4436969652224L, 33058);
  }
  
  public final int getType()
  {
    GMTrace.i(4437506523136L, 33062);
    GMTrace.o(4437506523136L, 33062);
    return 481;
  }
  
  protected final int ub()
  {
    GMTrace.i(4437103869952L, 33059);
    GMTrace.o(4437103869952L, 33059);
    return 5;
  }
  
  public static final class a
    extends i
  {
    private p.a hBn;
    private p.b hBo;
    
    public a()
    {
      GMTrace.i(4418581823488L, 32921);
      this.hBn = new p.a();
      this.hBo = new p.b();
      GMTrace.o(4418581823488L, 32921);
    }
    
    public final int BD()
    {
      GMTrace.i(4419252912128L, 32926);
      GMTrace.o(4419252912128L, 32926);
      return 1;
    }
    
    public final int getType()
    {
      GMTrace.i(4418716041216L, 32922);
      GMTrace.o(4418716041216L, 32922);
      return 481;
    }
    
    public final String getUri()
    {
      GMTrace.i(4418850258944L, 32923);
      GMTrace.o(4418850258944L, 32923);
      return "/cgi-bin/micromsg-bin/emailreg";
    }
    
    protected final k.d zf()
    {
      GMTrace.i(4419118694400L, 32925);
      p.a locala = this.hBn;
      GMTrace.o(4419118694400L, 32925);
      return locala;
    }
    
    public final k.e zg()
    {
      GMTrace.i(4418984476672L, 32924);
      p.b localb = this.hBo;
      GMTrace.o(4418984476672L, 32924);
      return localb;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */