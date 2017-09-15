package com.tencent.mm.modelsimple;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.o;
import com.tencent.mm.ao.i;
import com.tencent.mm.ao.i.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.j;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.ann;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.protocal.c.azz;
import com.tencent.mm.protocal.c.bdr;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.y.a;
import com.tencent.mm.protocal.y.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.aq;
import com.tencent.mm.u.as;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bb.a;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.a;
import com.tencent.mm.y.k.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class w
  extends k
  implements j
{
  public com.tencent.mm.y.e gUt;
  private final String hSm;
  private final String hSn;
  private final String hSo;
  private final String hSp;
  private final String hSq;
  private final String hSr;
  private final int hSs;
  private final int hSt;
  private boolean hSu;
  public boolean hSv;
  private int hsF;
  public com.tencent.mm.network.p htc;
  
  public w(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, int paramInt2)
  {
    GMTrace.i(13165416939520L, 98090);
    this.hSu = true;
    this.hSv = false;
    this.hsF = 2;
    v.d("MicroMsg.NetSceneReg", "NetSceneReg: username = " + paramString1 + " nickname = " + paramString3);
    v.d("MicroMsg.NetSceneReg", "NetSceneReg: bindUin = " + paramInt1 + "bindEmail = " + paramString4 + " bindMobile = " + paramString5);
    v.d("MicroMsg.NetSceneReg", "NetSceneReg: regMode = " + paramInt2 + " ticket: " + paramString6);
    this.hSt = paramInt2;
    this.htc = new as();
    y.a locala = (y.a)this.htc.BG();
    locala.dj(0);
    locala.sYy.jLx = paramString1;
    locala.sYy.tie = bf.PQ(paramString2);
    if (paramInt2 == 4)
    {
      locala.sYy.tie = paramString6;
      v.w("MicroMsg.NetSceneReg", "dkreg rand:" + paramString6 + " reqMd5:" + locala.sYy.tie);
    }
    locala.sYy.jMD = paramString3;
    locala.sYy.tbS = paramInt1;
    locala.sYy.tbT = paramString4;
    locala.sYy.tbU = paramString5;
    locala.sYy.tsG = paramString6;
    locala.sYy.tFz = paramInt2;
    locala.sYy.lcZ = bf.bJI();
    locala.sYy.tsE = com.tencent.mm.compatible.d.p.getSimCountryIso();
    locala.sYy.lda = u.bID();
    locala.sYy.tfV = 0;
    locala.sYy.tQM = 0;
    locala.sYy.tQN = com.tencent.mm.compatible.d.p.getAndroidId();
    locala.sYy.tvj = com.tencent.mm.compatible.d.p.rC();
    locala.sYy.tQO = aa.getContext().getSharedPreferences(aa.bIN(), 0).getString("installreferer", "");
    locala.sYy.tQP = com.tencent.mm.plugin.normsg.a.d.nYa.qt(2);
    locala.sYy.tQQ = aa.getContext().getSharedPreferences(aa.bIN() + "_google_aid", 4).getString("getgoogleaid", "");
    this.hSm = paramString1;
    this.hSn = paramString2;
    this.hSo = paramString3;
    this.hSp = paramString4;
    this.hSq = paramString5;
    this.hSs = paramInt1;
    this.hSr = "";
    if (((paramString6 == null) || (paramString6.length() <= 0)) && (paramString4.length() <= 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.hSu = bool;
      locala.sYy.tfW = com.tencent.mm.kernel.a.uY();
      GMTrace.o(13165416939520L, 98090);
      return;
    }
  }
  
  public w(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt2, String paramString9, String paramString10, String paramString11, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(13165551157248L, 98091);
    this.hSu = true;
    this.hSv = false;
    this.hsF = 2;
    v.i("MicroMsg.NetSceneReg", "init: use:%s pwd:%s nick:%s bindqq:%d email:%s mobile:%s [%s,%s,%s] regmode:%d alias:%s [%s,%s] force:%b avatar:%b", new Object[] { paramString1, bf.Qi(paramString2), paramString3, Integer.valueOf(paramInt1), paramString4, paramString5, paramString6, paramString7, paramString8, Integer.valueOf(paramInt2), paramString9, paramString11, paramString10, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.hSt = paramInt2;
    this.htc = new as();
    paramString6 = (y.a)this.htc.BG();
    paramString6.dj(0);
    paramString6.sYy.jLx = paramString1;
    paramString6.sYy.tie = bf.PQ(paramString2);
    if (paramInt2 == 4)
    {
      paramString6.sYy.tie = paramString8;
      v.w("MicroMsg.NetSceneReg", "dkreg rand:" + paramString8 + " reqMd5:" + paramString6.sYy.tie);
    }
    paramString6.sYy.jMD = paramString3;
    paramString6.sYy.tbS = paramInt1;
    paramString6.sYy.tbT = paramString4;
    paramString6.sYy.tbU = paramString5;
    paramString6.sYy.tsG = paramString8;
    paramString6.sYy.tFz = paramInt2;
    paramString6.sYy.lcZ = bf.bJI();
    paramString6.sYy.tsE = com.tencent.mm.compatible.d.p.getSimCountryIso();
    paramString6.sYy.lda = u.bID();
    paramString6.sYy.tfV = 0;
    paramString6.sYy.hAq = paramString9;
    paramString6.sYy.tFy = paramString11;
    paramString6.sYy.tFx = paramString10;
    paramString7 = paramString6.sYy;
    if (paramBoolean1)
    {
      paramInt2 = 1;
      paramString7.thV = paramInt2;
      paramString7 = paramString6.sYy;
      if (!paramBoolean2) {
        break label647;
      }
      paramInt2 = 1;
      label430:
      paramString7.tQL = paramInt2;
      paramString6.sYy.tfW = com.tencent.mm.kernel.a.uY();
      paramString6.sYy.tQN = com.tencent.mm.compatible.d.p.getAndroidId();
      paramString6.sYy.tvj = com.tencent.mm.compatible.d.p.rC();
      paramString6.sYy.tQO = aa.getContext().getSharedPreferences(aa.bIN(), 0).getString("installreferer", "");
      paramString6.sYy.tQP = com.tencent.mm.plugin.normsg.a.d.nYa.qt(2);
      paramString6.sYy.tQQ = aa.getContext().getSharedPreferences(aa.bIN() + "_google_aid", 4).getString("getgoogleaid", "");
      this.hSm = paramString1;
      this.hSn = paramString2;
      this.hSo = paramString3;
      this.hSp = paramString4;
      this.hSq = paramString5;
      this.hSs = paramInt1;
      this.hSr = paramString9;
      if (((paramString8 != null) && (paramString8.length() > 0)) || ((paramString4 != null) && (paramString4.length() > 0))) {
        break label653;
      }
    }
    label647:
    label653:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      this.hSu = paramBoolean1;
      GMTrace.o(13165551157248L, 98091);
      return;
      paramInt2 = 0;
      break;
      paramInt2 = 0;
      break label430;
    }
  }
  
  public final int FC()
  {
    GMTrace.i(13166893334528L, 98101);
    Object localObject = ((y.b)this.htc.zg()).sYz.tfJ;
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
      GMTrace.o(13166893334528L, 98101);
      return i;
    }
  }
  
  public final byte[] FJ()
  {
    GMTrace.i(13166490681344L, 98098);
    byte[] arrayOfByte = com.tencent.mm.platformtools.n.a(((y.b)this.htc.zg()).sYz.tFA, new byte[0]);
    GMTrace.o(13166490681344L, 98098);
    return arrayOfByte;
  }
  
  public final String FK()
  {
    GMTrace.i(13166624899072L, 98099);
    String str = ((y.b)this.htc.zg()).sYz.tFx;
    GMTrace.o(13166624899072L, 98099);
    return str;
  }
  
  public final String Jr()
  {
    GMTrace.i(13166759116800L, 98100);
    String str = ((y.b)this.htc.zg()).sYz.tQY;
    GMTrace.o(13166759116800L, 98100);
    return str;
  }
  
  public final String Js()
  {
    GMTrace.i(13167027552256L, 98102);
    Object localObject = ((y.b)this.htc.zg()).sYz.tfJ;
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
      } while (localbdr.oSb != 2);
    }
    for (localObject = localbdr.udp;; localObject = "")
    {
      GMTrace.o(13167027552256L, 98102);
      return (String)localObject;
    }
  }
  
  public final int Jt()
  {
    GMTrace.i(13167161769984L, 98103);
    Object localObject = ((y.b)this.htc.zg()).sYz.tfJ;
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
      } while (localbdr.oSb != 3);
    }
    for (int i = bf.getInt(localbdr.udp, 2);; i = 2)
    {
      GMTrace.o(13167161769984L, 98103);
      return i;
    }
  }
  
  public final String Ju()
  {
    GMTrace.i(13167295987712L, 98104);
    Object localObject = ((y.b)this.htc.zg()).sYz.tfJ;
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
      } while (localbdr.oSb != 17);
    }
    for (localObject = localbdr.udp;; localObject = null)
    {
      GMTrace.o(13167295987712L, 98104);
      return (String)localObject;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(13165685374976L, 98092);
    this.gUt = parame1;
    int i = a(parame, this.htc, this);
    GMTrace.o(13165685374976L, 98092);
    return i;
  }
  
  protected final int a(com.tencent.mm.network.p paramp)
  {
    GMTrace.i(13165953810432L, 98094);
    int i = k.b.hsC;
    GMTrace.o(13165953810432L, 98094);
    return i;
  }
  
  public final void a(final int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.p paramp, final byte[] paramArrayOfByte)
  {
    GMTrace.i(13166356463616L, 98097);
    paramArrayOfByte = (y.b)paramp.zg();
    if ((paramInt2 == 4) && (paramInt3 == 65235))
    {
      aq.a(true, paramArrayOfByte.sYz.tig, paramArrayOfByte.sYz.tih, paramArrayOfByte.sYz.tif);
      this.hsF -= 1;
      if (this.hsF <= 0)
      {
        this.gUt.a(3, -1, "", this);
        GMTrace.o(13166356463616L, 98097);
        return;
      }
      a(this.hsm, this.gUt);
      GMTrace.o(13166356463616L, 98097);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramp.BG().sXU.ver;
      v.d("MicroMsg.NetSceneReg", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.h.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(13157095440384L, 98028);
          new m().a(w.this.hsm, new com.tencent.mm.y.e()
          {
            public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, k paramAnonymous2k)
            {
              GMTrace.i(13159511359488L, 98046);
              v.d("MicroMsg.NetSceneReg", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2k.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                w.this.gUt.a(paramAnonymous2Int1, paramAnonymous2Int2, "", w.this);
                GMTrace.o(13159511359488L, 98046);
                return;
              }
              w.this.a(w.this.hsm, w.this.gUt);
              GMTrace.o(13159511359488L, 98046);
            }
          });
          GMTrace.o(13157095440384L, 98028);
        }
      });
      GMTrace.o(13166356463616L, 98097);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(13166356463616L, 98097);
      return;
    }
    paramp = (y.a)paramp.BG();
    v.d("MicroMsg.NetSceneReg", "dkreg: pass:" + paramArrayOfByte.sYz.lcR + " regtype:" + paramArrayOfByte.sYz.tbW + " mode:" + paramp.sYy.tFz);
    if ((paramArrayOfByte.sYz.lcP != 0) && (!this.hSu))
    {
      com.tencent.mm.kernel.h.vJ();
      com.tencent.mm.kernel.h.eO(paramArrayOfByte.sYz.lcP);
      if (paramp.sYy.tFz == 4) {
        com.tencent.mm.kernel.h.vI().vr().set(2, paramp.sYy.jLx);
      }
      com.tencent.mm.kernel.h.vI().vr().set(16, Integer.valueOf(1));
      com.tencent.mm.kernel.h.vI().vr().set(52, Integer.valueOf(paramArrayOfByte.sYz.tbW));
      com.tencent.mm.kernel.h.vI().vr().set(340240, Long.valueOf(System.currentTimeMillis()));
      com.tencent.mm.kernel.h.vI().vr().set(340241, Boolean.valueOf(true));
      if ((this.hSm != null) && (this.hSm.length() > 0) && (this.hSt != 1)) {
        paramArrayOfByte.sYz.jLx = this.hSm;
      }
      paramArrayOfByte.sYz.tbT = this.hSp;
      paramArrayOfByte.sYz.jLP = 0;
      if ((com.tencent.mm.kernel.h.vG().uV()) && (com.tencent.mm.kernel.h.vI().vr() != null))
      {
        paramp = this.hSr;
        paramInt1 = this.hSs;
        String str1 = this.hSo;
        String str2 = this.hSq;
        String str3 = paramArrayOfByte.sYz.jLx;
        String str4 = paramArrayOfByte.sYz.tbT;
        int i = paramArrayOfByte.sYz.jLP;
        String str5 = paramArrayOfByte.sYz.tbZ;
        String str6 = paramArrayOfByte.sYz.tca;
        int j = paramArrayOfByte.sYz.tcb;
        int k = paramArrayOfByte.sYz.tQS;
        String str7 = paramArrayOfByte.sYz.taB;
        String str8 = paramArrayOfByte.sYz.tcc;
        String str9 = paramArrayOfByte.sYz.tfG;
        Object localObject = paramArrayOfByte.sYz.tQR;
        v.i("MicroMsg.HandleAuthResponse", "dkwt updateProfile user:%s alias:%s qq:%s nick:%s email:%s mobile:%s status:%d offuser:%s offnick:%s pushmail:%d sendCard:%d session:%s fsurl:%s pluginFlag:%d atuhkey:%s a2:%s newa2:%s kisd:%s safedev:%d MicroBlog:%s emailpwd:%d", new Object[] { str3, paramp, o.getString(paramInt1), str1, str4, str2, Integer.valueOf(i), str5, str6, Integer.valueOf(j), Integer.valueOf(k), bf.Qi(str7), str8, Integer.valueOf(0), bf.Qi(str9), bf.Qi(null), bf.Qi(null), bf.Qi(null), Integer.valueOf(-1), localObject, Integer.valueOf(0) });
        localObject = com.tencent.mm.kernel.h.vI().vr();
        ao.hlE.L("login_weixin_username", str3);
        ao.hlE.c(str2, paramInt1, str4);
        ((t)localObject).set(2, str3);
        ((t)localObject).set(42, paramp);
        ((t)localObject).set(9, Integer.valueOf(paramInt1));
        ((t)localObject).set(4, str1);
        ((t)localObject).set(5, str4);
        ((t)localObject).set(6, str2);
        ((t)localObject).set(7, Integer.valueOf(i));
        ((t)localObject).set(21, str5);
        ((t)localObject).set(22, str6);
        ((t)localObject).set(57, Integer.valueOf(0));
        ((t)localObject).set(17, Integer.valueOf(j));
        ((t)localObject).set(25, Integer.valueOf(k));
        ((t)localObject).set(1, str7);
        ((t)localObject).set(29, str8);
        ((t)localObject).set(34, Integer.valueOf(0));
        ((t)localObject).set(256, Boolean.valueOf(false));
        v.i("MicroMsg.HandleAuthResponse", "summerstatus USERINFO_FORCE_UPDATE_AUTH set false");
        ((t)localObject).set(-1535680990, str9);
        ((t)localObject).set(46, null);
        ((t)localObject).set(72, null);
        ((t)localObject).set(64, Integer.valueOf(-1));
        ((t)localObject).jV(true);
        ((PluginAuth)com.tencent.mm.kernel.h.j(PluginAuth.class)).getHandleAuthResponseCallbacks().a(paramArrayOfByte, this.hSr, this.hSs, this.hSo, this.hSq, 0);
        aq.a(false, paramArrayOfByte.sYz.tig, paramArrayOfByte.sYz.tih, paramArrayOfByte.sYz.tif);
        com.tencent.mm.kernel.h.vI().vr().jV(true);
        com.tencent.mm.kernel.h.vd().a(new bb(new bb.a()
        {
          public final void a(com.tencent.mm.network.e paramAnonymouse)
          {
            GMTrace.i(13159242924032L, 98044);
            if (paramAnonymouse == null)
            {
              GMTrace.o(13159242924032L, 98044);
              return;
            }
            paramAnonymouse.Cc().i(paramArrayOfByte.idE, paramArrayOfByte.sYz.lcP);
            GMTrace.o(13159242924032L, 98044);
          }
        }), 0);
        v.d("MicroMsg.NetSceneReg", "resp return flag" + paramArrayOfByte.sYz.tQU);
        if ((paramArrayOfByte.sYz.tQU & 0x1) == 0) {
          break label1456;
        }
        bool = true;
        label1192:
        this.hSv = bool;
      }
    }
    else
    {
      paramp = new LinkedList();
      paramp.add(new i.a(21, "android-" + Build.VERSION.SDK_INT + "-" + Build.MODEL));
      ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ().b(new i(paramp));
      if ((paramInt2 == 0) && (paramInt3 == 0)) {
        com.tencent.mm.plugin.c.b.hh(FC());
      }
      paramInt1 = paramArrayOfByte.sYz.tfO;
      v.i("MicroMsg.NetSceneReg", "summerauth mmtls:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.kernel.h.vJ();
      com.tencent.mm.kernel.h.vI().gXM.set(47, Integer.valueOf(paramInt1));
      paramp = com.tencent.mm.kernel.h.vH().gXs.hsI;
      if (paramp != null) {
        if ((paramInt1 & 0x1) != 0) {
          break label1462;
        }
      }
    }
    label1456:
    label1462:
    for (boolean bool = true;; bool = false)
    {
      paramp.bc(bool);
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(13166356463616L, 98097);
      return;
      bool = com.tencent.mm.kernel.h.vG().uV();
      com.tencent.mm.kernel.h.vG();
      v.e("MicroMsg.NetSceneReg", "dkwt ERR: updateProfile acc:%b uin:%s userConfigStg:%s", new Object[] { Boolean.valueOf(bool), o.getString(com.tencent.mm.kernel.a.uH()), com.tencent.mm.kernel.h.vI().vr() });
      break;
      bool = false;
      break label1192;
    }
  }
  
  protected final void a(k.a parama)
  {
    GMTrace.i(13166088028160L, 98095);
    GMTrace.o(13166088028160L, 98095);
  }
  
  public final int getType()
  {
    GMTrace.i(13166222245888L, 98096);
    GMTrace.o(13166222245888L, 98096);
    return 126;
  }
  
  protected final int ub()
  {
    GMTrace.i(13165819592704L, 98093);
    GMTrace.o(13165819592704L, 98093);
    return 3;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */