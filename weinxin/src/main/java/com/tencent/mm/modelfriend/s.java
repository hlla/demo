package com.tencent.mm.modelfriend;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsimple.m;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.azz;
import com.tencent.mm.protocal.c.bdr;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.c.ge;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.m.a;
import com.tencent.mm.protocal.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.aq;
import com.tencent.mm.y.i;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.a;
import com.tencent.mm.y.k.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class s
  extends k
  implements j
{
  public static a hBh;
  public com.tencent.mm.y.e gUt;
  private int hsF;
  public final p htc;
  
  public s(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    GMTrace.i(13173335785472L, 98149);
    this.gUt = null;
    this.hsF = 2;
    this.htc = new b();
    m.a locala = (m.a)this.htc.BG();
    locala.sYa.tgi = paramInt1;
    v.d("MicroMsg.NetSceneBindMobileForReg", "Get mobile:" + paramString1 + " opcode:" + paramInt1 + " verifyCode:" + paramString2);
    locala.sYa.thR = paramString1;
    locala.sYa.thS = paramString2;
    locala.sYa.thT = paramInt2;
    locala.sYa.thU = paramString3;
    locala.sYa.lda = u.bID();
    locala.sYa.tfW = a.uY();
    if ((bf.mA(locala.sYa.thW)) && (bf.mA(locala.sYa.thX)))
    {
      paramString2 = locala.sYa;
      if (hBh == null) {
        break label232;
      }
    }
    label232:
    for (paramString1 = hBh.FG();; paramString1 = "")
    {
      paramString2.thW = paramString1;
      locala.sYa.thX = d.sXf;
      GMTrace.o(13173335785472L, 98149);
      return;
    }
  }
  
  public s(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    this(paramString1, paramInt1, paramString2, 0, paramString3);
    GMTrace.i(13173201567744L, 98148);
    ((m.a)this.htc.BG()).sYa.tfK = paramString4;
    GMTrace.o(13173201567744L, 98148);
  }
  
  public s(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this(paramString1, 11, paramString2, 0, paramString3, paramString4);
    GMTrace.i(13173067350016L, 98147);
    paramString1 = (m.a)this.htc.BG();
    paramString1.sYa.thW = paramString5;
    paramString1.sYa.thX = paramString6;
    GMTrace.o(13173067350016L, 98147);
  }
  
  private int FC()
  {
    GMTrace.i(13175885922304L, 98168);
    Object localObject = ((m.b)this.htc.zg()).sYb.tfJ;
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
      GMTrace.o(13175885922304L, 98168);
      return i;
    }
  }
  
  public final int AJ()
  {
    GMTrace.i(13173738438656L, 98152);
    int i = ((m.a)this.htc.BG()).sYa.tgi;
    GMTrace.o(13173738438656L, 98152);
    return i;
  }
  
  public final int FA()
  {
    GMTrace.i(13175617486848L, 98166);
    Object localObject = ((m.b)this.htc.zg()).sYb.tfJ;
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
      } while (localbdr.oSb != 5);
    }
    for (int i = bf.getInt(localbdr.udp, 0);; i = 0)
    {
      GMTrace.o(13175617486848L, 98166);
      return i;
    }
  }
  
  public final boolean FB()
  {
    GMTrace.i(13175751704576L, 98167);
    Object localObject = ((m.b)this.htc.zg()).sYb.tfJ;
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
      } while (localbdr.oSb != 7);
    }
    for (int i = bf.getInt(localbdr.udp, 0);; i = 0)
    {
      if (i > 0)
      {
        GMTrace.o(13175751704576L, 98167);
        return true;
      }
      GMTrace.o(13175751704576L, 98167);
      return false;
    }
  }
  
  public final boolean FD()
  {
    GMTrace.i(13176020140032L, 98169);
    Object localObject = ((m.b)this.htc.zg()).sYb.tfJ;
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
      } while (localbdr.oSb != 10);
    }
    for (int i = bf.getInt(localbdr.udp, 0);; i = 0)
    {
      if (i > 0)
      {
        GMTrace.o(13176020140032L, 98169);
        return true;
      }
      GMTrace.o(13176020140032L, 98169);
      return false;
    }
  }
  
  public final String FE()
  {
    GMTrace.i(13176154357760L, 98170);
    Object localObject = ((m.b)this.htc.zg()).sYb.tfJ;
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
      } while (localbdr.oSb != 14);
    }
    for (localObject = localbdr.udp;; localObject = null)
    {
      GMTrace.o(13176154357760L, 98170);
      return (String)localObject;
    }
  }
  
  public final String FF()
  {
    GMTrace.i(13176288575488L, 98171);
    Object localObject = ((m.b)this.htc.zg()).sYb.tfJ;
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
      } while (localbdr.oSb != 15);
    }
    for (localObject = localbdr.udp;; localObject = null)
    {
      GMTrace.o(13176288575488L, 98171);
      return (String)localObject;
    }
  }
  
  public final String Fu()
  {
    GMTrace.i(13174677962752L, 98159);
    String str = ((m.b)this.htc.zg()).sYb.tie;
    GMTrace.o(13174677962752L, 98159);
    return str;
  }
  
  public final String Fv()
  {
    GMTrace.i(13174946398208L, 98161);
    String str = ((m.b)this.htc.zg()).sYb.fGM;
    GMTrace.o(13174946398208L, 98161);
    return str;
  }
  
  public final String Fw()
  {
    GMTrace.i(13175080615936L, 98162);
    String str = ((m.b)this.htc.zg()).sYb.tfK;
    GMTrace.o(13175080615936L, 98162);
    return str;
  }
  
  public final String Fx()
  {
    GMTrace.i(13175214833664L, 98163);
    String str = ((m.b)this.htc.zg()).sYb.til;
    GMTrace.o(13175214833664L, 98163);
    return str;
  }
  
  public final int Fy()
  {
    GMTrace.i(13175349051392L, 98164);
    Object localObject = ((m.b)this.htc.zg()).sYb.tfJ;
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
      } while (localbdr.oSb != 6);
    }
    for (int i = bf.getInt(localbdr.udp, 3);; i = 3)
    {
      GMTrace.o(13175349051392L, 98164);
      return i;
    }
  }
  
  public final int Fz()
  {
    GMTrace.i(13175483269120L, 98165);
    Object localObject = ((m.b)this.htc.zg()).sYb.tfJ;
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
      } while (localbdr.oSb != 4);
    }
    for (int i = bf.getInt(localbdr.udp, 30);; i = 30)
    {
      GMTrace.o(13175483269120L, 98165);
      return i;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(13173872656384L, 98153);
    this.gUt = parame1;
    parame1 = (m.a)this.htc.BG();
    if ((parame1.sYa.thR == null) || (parame1.sYa.thR.length() <= 0))
    {
      v.e("MicroMsg.NetSceneBindMobileForReg", "doScene getMobile Error: " + parame1.sYa.thR);
      GMTrace.o(13173872656384L, 98153);
      return -1;
    }
    if (((parame1.sYa.tgi == 6) || (parame1.sYa.tgi == 9)) && ((parame1.sYa.thS == null) || (parame1.sYa.thS.length() <= 0)))
    {
      v.e("MicroMsg.NetSceneBindMobileForReg", "doScene getVerifyCode Error: " + parame1.sYa.thR);
      GMTrace.o(13173872656384L, 98153);
      return -1;
    }
    int i = a(parame, this.htc, this);
    GMTrace.o(13173872656384L, 98153);
    return i;
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(13174275309568L, 98156);
    int i = k.b.hsC;
    GMTrace.o(13174275309568L, 98156);
    return i;
  }
  
  public final void a(final int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(13174543745024L, 98158);
    v.d("MicroMsg.NetSceneBindMobileForReg", "dkidc onGYNetEnd  errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramArrayOfByte = (m.b)paramp.zg();
    if ((paramInt2 == 4) && (paramInt3 == 65235))
    {
      aq.a(true, paramArrayOfByte.sYb.tig, paramArrayOfByte.sYb.tih, paramArrayOfByte.sYb.tif);
      this.hsF -= 1;
      if (this.hsF <= 0)
      {
        this.gUt.a(3, -1, "", this);
        GMTrace.o(13174543745024L, 98158);
        return;
      }
      a(this.hsm, this.gUt);
      GMTrace.o(13174543745024L, 98158);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramp.BG().sXU.ver;
      v.d("MicroMsg.NetSceneBindMobileForReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      h.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(13177362317312L, 98179);
          new m().a(s.this.hsm, new com.tencent.mm.y.e()
          {
            public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, k paramAnonymous2k)
            {
              GMTrace.i(13177764970496L, 98182);
              v.d("MicroMsg.NetSceneBindMobileForReg", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2k.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                s.this.gUt.a(paramAnonymous2Int1, paramAnonymous2Int2, "", s.this);
                GMTrace.o(13177764970496L, 98182);
                return;
              }
              s.this.a(s.this.hsm, s.this.gUt);
              GMTrace.o(13177764970496L, 98182);
            }
          });
          GMTrace.o(13177362317312L, 98179);
        }
      });
      GMTrace.o(13174543745024L, 98158);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      v.e("MicroMsg.NetSceneBindMobileForReg", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(13174543745024L, 98158);
      return;
    }
    aq.a(false, paramArrayOfByte.sYb.tig, paramArrayOfByte.sYb.tih, paramArrayOfByte.sYb.tif);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      b.hh(FC());
    }
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(13174543745024L, 98158);
  }
  
  protected final void a(k.a parama)
  {
    GMTrace.i(13174409527296L, 98157);
    GMTrace.o(13174409527296L, 98157);
  }
  
  public final void fG(int paramInt)
  {
    GMTrace.i(13173470003200L, 98150);
    ((m.a)this.htc.BG()).sYa.thZ = paramInt;
    GMTrace.o(13173470003200L, 98150);
  }
  
  public final void fH(int paramInt)
  {
    GMTrace.i(13173604220928L, 98151);
    ((m.a)this.htc.BG()).sYa.tia = paramInt;
    GMTrace.o(13173604220928L, 98151);
  }
  
  public final int getType()
  {
    GMTrace.i(13174006874112L, 98154);
    GMTrace.o(13174006874112L, 98154);
    return 145;
  }
  
  public final String getUsername()
  {
    GMTrace.i(13174812180480L, 98160);
    String str = ((m.b)this.htc.zg()).sYb.tfa;
    GMTrace.o(13174812180480L, 98160);
    return str;
  }
  
  protected final int ub()
  {
    GMTrace.i(13174141091840L, 98155);
    GMTrace.o(13174141091840L, 98155);
    return 3;
  }
  
  public static abstract interface a
  {
    public abstract String FG();
  }
  
  public static final class b
    extends i
  {
    private final m.a hBl;
    private final m.b hBm;
    
    public b()
    {
      GMTrace.i(13176422793216L, 98172);
      this.hBl = new m.a();
      this.hBm = new m.b();
      GMTrace.o(13176422793216L, 98172);
    }
    
    public final int BD()
    {
      GMTrace.i(13177093881856L, 98177);
      GMTrace.o(13177093881856L, 98177);
      return 1;
    }
    
    public final int getType()
    {
      GMTrace.i(13176825446400L, 98175);
      GMTrace.o(13176825446400L, 98175);
      return 145;
    }
    
    public final String getUri()
    {
      GMTrace.i(13176959664128L, 98176);
      GMTrace.o(13176959664128L, 98176);
      return "/cgi-bin/micromsg-bin/bindopmobileforreg";
    }
    
    protected final k.d zf()
    {
      GMTrace.i(13176557010944L, 98173);
      m.a locala = this.hBl;
      GMTrace.o(13176557010944L, 98173);
      return locala;
    }
    
    public final k.e zg()
    {
      GMTrace.i(13176691228672L, 98174);
      m.b localb = this.hBm;
      GMTrace.o(13176691228672L, 98174);
      return localb;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */