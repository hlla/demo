package com.tencent.mm.modelsimple;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.o;
import com.tencent.mm.e.a.it;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.auth.PluginAuth;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.akq;
import com.tencent.mm.protocal.c.akr;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.protocal.c.ang;
import com.tencent.mm.protocal.c.ap;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.azz;
import com.tencent.mm.protocal.c.bdr;
import com.tencent.mm.protocal.c.bgb;
import com.tencent.mm.protocal.c.bmd;
import com.tencent.mm.protocal.c.bme;
import com.tencent.mm.protocal.c.bpj;
import com.tencent.mm.protocal.c.bpk;
import com.tencent.mm.protocal.c.dr;
import com.tencent.mm.protocal.c.ek;
import com.tencent.mm.protocal.i.d;
import com.tencent.mm.protocal.i.e;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.aq;
import com.tencent.mm.u.bb;
import com.tencent.mm.u.bb.a;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.a;
import com.tencent.mm.y.k.b;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParserException;

public final class u
  extends k
  implements j
{
  private int errCode;
  private int errType;
  public com.tencent.mm.y.e gUt;
  private String hRZ;
  private String hSa;
  private boolean hSb;
  private boolean hSc;
  private int hSd;
  private int hSe;
  private boolean hSf;
  private int hsF;
  public final p htc;
  
  public u(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this("", "", paramInt, paramString1, paramString2, paramString3, 0, "", false, false);
    GMTrace.i(13162329931776L, 98067);
    GMTrace.o(13162329931776L, 98067);
  }
  
  public u(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(13162598367232L, 98069);
    this.hRZ = "";
    this.hSa = "";
    this.hSb = false;
    this.hSc = false;
    this.errType = 0;
    this.errCode = 0;
    this.hsF = 3;
    this.hSd = 0;
    this.hSe = 0;
    this.hSf = false;
    Object localObject1 = new StringBuilder("summerauth NetSceneManualAuth this: ").append(this).append(" account: ").append(paramString1).append(" rawPsw len: ");
    int i;
    Object localObject2;
    label309:
    Object localObject3;
    if (paramString2 == null)
    {
      i = -1;
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneManualAuth", i + " secCodetype: " + paramInt1 + " secCode: " + paramString3 + " sid: " + paramString4 + " encryptKey: " + paramString5 + " inputType: " + paramInt2 + " authTicket: " + paramString6 + " useRawPwd: " + paramBoolean1 + " isMobileAutoLogin: " + paramBoolean2 + " stack: " + bf.bJP());
      this.hSc = paramBoolean2;
      this.htc = new aq(701);
      localObject2 = (i.d)this.htc.BG();
      i = aq.ze().getInt("key_auth_update_version", 0);
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneManualAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(com.tencent.mm.protocal.d.sXh) });
      if (i != 0) {
        break label818;
      }
      ((k.d)localObject2).sXQ = 1;
      com.tencent.mm.plugin.report.c.oRz.a(148L, 0L, 1L, false);
      ((i.d)localObject2).sXE = true;
      ((i.d)localObject2).dj(0);
      localObject1 = new aks();
      localObject3 = new akq();
      ((i.d)localObject2).sXD.tMP = ((aks)localObject1);
      ((i.d)localObject2).sXD.tMQ = ((akq)localObject3);
      ((akq)localObject3).tMO = paramInt2;
      localObject2 = new ek();
      ((akq)localObject3).tfS = ((ek)localObject2);
      ((ek)localObject2).tfK = paramString6;
      ((ek)localObject2).tgP = 0;
      ((ek)localObject2).tfF = new avt().bb(new byte[0]);
      ((ek)localObject2).tfE = new avt().bb(new byte[0]);
      paramString6 = new bmd();
      ((ek)localObject2).tgN = paramString6;
      paramString6.tiq = "";
      paramString6.tip = "";
      paramString6.uke = "";
      localObject3 = new bpj();
      ((ek)localObject2).tgO = ((bpj)localObject3);
      ((bpj)localObject3).tFy = "";
      ((bpj)localObject3).tFx = "";
      if (paramInt1 != 1) {
        break label857;
      }
      paramString6.tiq = paramString3;
      paramString6.tip = paramString4;
      paramString6.uke = paramString5;
      ((bpj)localObject3).tFy = "";
      ((bpj)localObject3).tFx = "";
      label532:
      if ((!bf.mA(paramString1)) || (!h.vG().uV())) {
        break label908;
      }
      com.tencent.mm.plugin.report.c.oRz.a(148L, 2L, 1L, false);
      this.hRZ = ((String)h.vI().vr().get(3, null));
      this.hSa = ((String)h.vI().vr().get(19, null));
      paramString1 = (i.e)this.htc.zg();
      paramString2 = bf.mz((String)h.vI().vr().get(2, null));
      if (!bf.mA(paramString2)) {
        break label900;
      }
      paramString2 = new o(bf.a((Integer)h.vI().vr().get(9, null), 0)).toString();
      label667:
      ((aks)localObject1).jLx = paramString2;
      paramString4 = null;
      paramString1 = paramString4;
      if (paramInt1 != 1)
      {
        paramString1 = paramString4;
        if (paramInt1 != 3)
        {
          if (paramInt1 != 2) {
            break label960;
          }
          paramString1 = h.vG().gWS.b(bf.getLong(paramString2, 0L), paramString3);
        }
      }
      label714:
      if (paramString1 != null) {
        break label993;
      }
    }
    label818:
    label857:
    label900:
    label908:
    label960:
    label993:
    for (paramInt1 = -1;; paramInt1 = paramString1.length)
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneManualAuth", "summerauth loginbuf len:%d content:[%s]", new Object[] { Integer.valueOf(paramInt1), bf.Qi(bf.bl(paramString1)) });
      paramString3 = new avt();
      paramString2 = paramString1;
      if (bf.bm(paramString1)) {
        paramString2 = new byte[0];
      }
      ((ek)localObject2).tgM = paramString3.bb(paramString2);
      ((aks)localObject1).tie = this.hSa;
      ((aks)localObject1).tio = this.hRZ;
      GMTrace.o(13162598367232L, 98069);
      return;
      i = paramString2.length();
      break;
      if (i < com.tencent.mm.protocal.d.sXh)
      {
        ((k.d)localObject2).sXQ = 16;
        com.tencent.mm.plugin.report.c.oRz.a(148L, 1L, 1L, false);
        break label309;
      }
      ((k.d)localObject2).sXQ = 1;
      break label309;
      if (paramInt1 != 3) {
        break label532;
      }
      paramString6.tiq = "";
      paramString6.tip = "";
      paramString6.uke = "";
      ((bpj)localObject3).tFy = paramString3;
      ((bpj)localObject3).tFx = paramString4;
      break label532;
      paramString1.idH = paramString2;
      break label667;
      if ((paramBoolean1) || (paramBoolean2))
      {
        this.hRZ = paramString2;
        this.hSa = paramString2;
        paramString2 = paramString1;
        break label667;
      }
      this.hRZ = bf.PQ(bf.mz(paramString2));
      this.hSa = bf.PR(bf.mz(paramString2));
      paramString2 = paramString1;
      break label667;
      paramString1 = paramString4;
      if (!bf.PI(paramString2)) {
        break label714;
      }
      paramString1 = h.vG().gWS.a(bf.getLong(paramString2, 0L), this.hSa, true);
      break label714;
    }
  }
  
  public u(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(paramString1, paramString2, 0, "", "", "", paramInt, paramString3, false, false);
    GMTrace.i(13162464149504L, 98068);
    GMTrace.o(13162464149504L, 98068);
  }
  
  public final byte[] FJ()
  {
    GMTrace.i(13164074762240L, 98080);
    if (((i.e)this.htc.zg()).sXG.ueM == null)
    {
      GMTrace.o(13164074762240L, 98080);
      return new byte[0];
    }
    int i = Jj();
    byte[] arrayOfByte;
    if (i == 3)
    {
      if (((i.e)this.htc.zg()).sXG.ueM.tfD != null)
      {
        arrayOfByte = com.tencent.mm.platformtools.n.a(((i.e)this.htc.zg()).sXG.ueM.tfD.tFA, new byte[0]);
        GMTrace.o(13164074762240L, 98080);
        return arrayOfByte;
      }
    }
    else if (i == 1)
    {
      if (((i.e)this.htc.zg()).sXG.ueM.tfC != null)
      {
        arrayOfByte = com.tencent.mm.platformtools.n.a(((i.e)this.htc.zg()).sXG.ueM.tfC.tdB, new byte[0]);
        GMTrace.o(13164074762240L, 98080);
        return arrayOfByte;
      }
    }
    else if ((i == 2) && (((i.d)this.htc.BG()).sXD.tMP != null))
    {
      h.vG().gWS.a(bf.getLong(((i.d)this.htc.BG()).sXD.tMP.jLx, 0L), com.tencent.mm.platformtools.n.a(((i.e)this.htc.zg()).sXG.ueM.tfB));
      arrayOfByte = h.vG().gWS.R(bf.getLong(((i.d)this.htc.BG()).sXD.tMP.jLx, 0L));
      GMTrace.o(13164074762240L, 98080);
      return arrayOfByte;
    }
    GMTrace.o(13164074762240L, 98080);
    return new byte[0];
  }
  
  public final String FK()
  {
    GMTrace.i(13163940544512L, 98079);
    if (((i.e)this.htc.zg()).sXG.ueM == null)
    {
      GMTrace.o(13163940544512L, 98079);
      return "";
    }
    int i = Jj();
    String str;
    if (i == 3)
    {
      if (((i.e)this.htc.zg()).sXG.ueM.tfD != null)
      {
        str = bf.mz(((i.e)this.htc.zg()).sXG.ueM.tfD.tFx);
        GMTrace.o(13163940544512L, 98079);
        return str;
      }
    }
    else if ((i == 1) && (((i.e)this.htc.zg()).sXG.ueM.tfC != null))
    {
      str = bf.mz(((i.e)this.htc.zg()).sXG.ueM.tfC.tip);
      GMTrace.o(13163940544512L, 98079);
      return str;
    }
    GMTrace.o(13163940544512L, 98079);
    return "";
  }
  
  public final String Fw()
  {
    GMTrace.i(13164477415424L, 98083);
    String str = ((i.e)this.htc.zg()).sXG.ueM.tfK;
    GMTrace.o(13164477415424L, 98083);
    return str;
  }
  
  public final int Fy()
  {
    GMTrace.i(13163672109056L, 98077);
    if (((i.e)this.htc.zg()).sXG.ueM == null)
    {
      GMTrace.o(13163672109056L, 98077);
      return 3;
    }
    Object localObject = ((i.e)this.htc.zg()).sXG.ueM.tfJ;
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
      GMTrace.o(13163672109056L, 98077);
      return i;
    }
  }
  
  public final u Jh()
  {
    GMTrace.i(14605573160960L, 108820);
    this.hSf = true;
    GMTrace.o(14605573160960L, 108820);
    return this;
  }
  
  public final String Ji()
  {
    GMTrace.i(13163806326784L, 98078);
    if (((i.e)this.htc.zg()).sXG.ueM == null)
    {
      GMTrace.o(13163806326784L, 98078);
      return "";
    }
    String str = ((i.e)this.htc.zg()).sXG.ueM.tfI;
    GMTrace.o(13163806326784L, 98078);
    return str;
  }
  
  public final int Jj()
  {
    GMTrace.i(13164208979968L, 98081);
    if (((i.e)this.htc.zg()).sXG.ueM == null)
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR AuthSectResp or WxVerifyCodeRespInfo is null");
      GMTrace.o(13164208979968L, 98081);
      return 0;
    }
    if (this.errType != 4)
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR errType :%d", new Object[] { Integer.valueOf(this.errType) });
      GMTrace.o(13164208979968L, 98081);
      return 0;
    }
    if (this.errCode == 65225)
    {
      GMTrace.o(13164208979968L, 98081);
      return 2;
    }
    if (this.errCode == -6)
    {
      GMTrace.o(13164208979968L, 98081);
      return 1;
    }
    if (this.errCode == 65226)
    {
      GMTrace.o(13164208979968L, 98081);
      return 3;
    }
    GMTrace.o(13164208979968L, 98081);
    return 0;
  }
  
  public final String Jk()
  {
    GMTrace.i(13164343197696L, 98082);
    if (((i.e)this.htc.zg()).sXG.ueM == null)
    {
      GMTrace.o(13164343197696L, 98082);
      return "";
    }
    if ((Jj() == 1) && (((i.e)this.htc.zg()).sXG.ueM.tfC != null))
    {
      if (((i.e)this.htc.zg()).sXG.ueM.tfC.uke != null)
      {
        String str = ((i.e)this.htc.zg()).sXG.ueM.tfC.uke;
        GMTrace.o(13164343197696L, 98082);
        return str;
      }
      GMTrace.o(13164343197696L, 98082);
      return null;
    }
    GMTrace.o(13164343197696L, 98082);
    return "";
  }
  
  public final String Jl()
  {
    GMTrace.i(13164611633152L, 98084);
    String str = ((i.e)this.htc.zg()).sXG.ueN.tbU;
    GMTrace.o(13164611633152L, 98084);
    return str;
  }
  
  public final int Jm()
  {
    GMTrace.i(13164745850880L, 98085);
    if (((i.e)this.htc.zg()).sXG.ueM == null)
    {
      GMTrace.o(13164745850880L, 98085);
      return 0;
    }
    Object localObject = ((i.e)this.htc.zg()).sXG.ueM.tfJ;
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
      } while (localbdr.oSb != 11);
    }
    for (int i = bf.getInt(localbdr.udp, 0);; i = 0)
    {
      GMTrace.o(13164745850880L, 98085);
      return i;
    }
  }
  
  public final BindWordingContent Jn()
  {
    GMTrace.i(13164880068608L, 98086);
    if (((i.e)this.htc.zg()).sXG.ueM == null)
    {
      GMTrace.o(13164880068608L, 98086);
      return null;
    }
    Object localObject1 = ((i.e)this.htc.zg()).sXG.ueM.tfJ;
    bdr localbdr;
    if ((localObject1 != null) && (((azz)localObject1).tZD != null) && (((azz)localObject1).tZD.size() > 0))
    {
      localObject1 = ((azz)localObject1).tZD.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localbdr = (bdr)((Iterator)localObject1).next();
      } while (localbdr.oSb != 12);
    }
    Object localObject3;
    for (localObject1 = localbdr.udp;; localObject3 = null)
    {
      if (localObject1 != null) {
        new a();
      }
      for (;;)
      {
        try
        {
          localObject1 = a.kw((String)localObject1);
          GMTrace.o(13164880068608L, 98086);
          return (BindWordingContent)localObject1;
        }
        catch (XmlPullParserException localXmlPullParserException)
        {
          com.tencent.mm.sdk.platformtools.v.printErrStackTrace("MicroMsg.NetSceneManualAuth", localXmlPullParserException, "", new Object[0]);
          Object localObject2 = null;
          continue;
        }
        catch (IOException localIOException)
        {
          com.tencent.mm.sdk.platformtools.v.printErrStackTrace("MicroMsg.NetSceneManualAuth", localIOException, "", new Object[0]);
        }
        localObject3 = null;
      }
    }
  }
  
  public final String Jo()
  {
    GMTrace.i(13165014286336L, 98087);
    if (((i.e)this.htc.zg()).sXG.ueM == null)
    {
      GMTrace.o(13165014286336L, 98087);
      return "";
    }
    Object localObject = ((i.e)this.htc.zg()).sXG.ueM.tfJ;
    if ((localObject != null) && (((azz)localObject).tZD != null) && (((azz)localObject).tZD.size() > 0))
    {
      localObject = ((azz)localObject).tZD.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bdr localbdr = (bdr)((Iterator)localObject).next();
        if (localbdr.oSb == 16)
        {
          localObject = localbdr.udp;
          GMTrace.o(13165014286336L, 98087);
          return (String)localObject;
        }
      }
    }
    GMTrace.o(13165014286336L, 98087);
    return "";
  }
  
  public final int Jp()
  {
    GMTrace.i(13165148504064L, 98088);
    if (((i.e)this.htc.zg()).sXG.ueM == null)
    {
      GMTrace.o(13165148504064L, 98088);
      return 0;
    }
    Object localObject = ((i.e)this.htc.zg()).sXG.ueM.tfJ;
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
      } while (localbdr.oSb != 13);
    }
    for (int i = bf.getInt(localbdr.udp, 0);; i = 0)
    {
      GMTrace.o(13165148504064L, 98088);
      return i;
    }
  }
  
  public final boolean Jq()
  {
    GMTrace.i(13165282721792L, 98089);
    if (((i.e)this.htc.zg()).sXG.ueM == null)
    {
      GMTrace.o(13165282721792L, 98089);
      return true;
    }
    Object localObject = ((i.e)this.htc.zg()).sXG.ueM.tfJ;
    if ((localObject != null) && (((azz)localObject).tZD != null) && (((azz)localObject).tZD.size() > 0))
    {
      localObject = ((azz)localObject).tZD.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bdr localbdr = (bdr)((Iterator)localObject).next();
        if (localbdr.oSb == 18) {
          if (bf.getInt(localbdr.udp, 0) == 1)
          {
            GMTrace.o(13165282721792L, 98089);
            return false;
          }
        }
      }
    }
    GMTrace.o(13165282721792L, 98089);
    return true;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(13163403673600L, 98075);
    this.gUt = parame1;
    int i = a(parame, this.htc, this);
    GMTrace.o(13163403673600L, 98075);
    return i;
  }
  
  protected final int a(p paramp)
  {
    GMTrace.i(13163135238144L, 98073);
    int i = k.b.hsC;
    GMTrace.o(13163135238144L, 98073);
    return i;
  }
  
  public final void a(final int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(13163537891328L, 98076);
    paramArrayOfByte = (i.d)paramp.BG();
    final i.e locale = (i.e)paramp.zg();
    this.errType = paramInt2;
    this.errCode = paramInt3;
    bgb localbgb = locale.sXG;
    if (localbgb == null)
    {
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.NetSceneManualAuth", "summerauth error unifyAuthResp is null!");
      this.gUt.a(4, -1, "", this);
      com.tencent.mm.plugin.report.c.oRz.a(148L, 3L, 1L, false);
      GMTrace.o(13163537891328L, 98076);
      return;
    }
    paramInt1 = localbgb.ueL;
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneManualAuth", "summerauth errType:%d, errCode:%d, errMsg:%s unifyAuthResp:%s, unifyFlag:%d, auth:%s, acct:%s, network:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, localbgb, Integer.valueOf(paramInt1), localbgb.ueM, localbgb.ueN, localbgb.ueO });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == 65235))
      {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC");
        com.tencent.mm.plugin.report.c.oRz.a(148L, 4L, 1L, false);
        if ((localbgb != null) && (localbgb.ueO != null)) {
          aq.a(true, localbgb.ueO.tig, localbgb.ueO.tih, localbgb.ueO.tif);
        }
        for (;;)
        {
          this.hsF -= 1;
          if (this.hsF > 0) {
            break;
          }
          com.tencent.mm.sdk.platformtools.v.w("MicroMsg.NetSceneManualAuth", "summerauth err and return with no try!");
          this.gUt.a(3, -1, "", this);
          GMTrace.o(13163537891328L, 98076);
          return;
          com.tencent.mm.sdk.platformtools.v.w("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC but NetworkSectResp is null");
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC do scene again redirectCount:%d", new Object[] { Integer.valueOf(this.hsF) });
        a(this.hsm, this.gUt);
        GMTrace.o(13163537891328L, 98076);
        return;
      }
      if ((!this.hSf) && (paramInt2 == 4) && (paramInt3 == -102))
      {
        com.tencent.mm.plugin.report.c.oRz.a(148L, 5L, 1L, false);
        paramInt1 = paramp.BG().sXU.ver;
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
        h.vL().D(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(13157363875840L, 98030);
            new m().a(u.this.hsm, new com.tencent.mm.y.e()
            {
              public final void a(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, k paramAnonymous2k)
              {
                GMTrace.i(13156827004928L, 98026);
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneManualAuth", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2k.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
                if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
                {
                  u.this.gUt.a(paramAnonymous2Int1, paramAnonymous2Int2, "", u.this);
                  GMTrace.o(13156827004928L, 98026);
                  return;
                }
                u.this.a(u.this.hsm, u.this.gUt);
                GMTrace.o(13156827004928L, 98026);
              }
            });
            GMTrace.o(13157363875840L, 98030);
          }
          
          public final String toString()
          {
            GMTrace.i(13157498093568L, 98031);
            String str = super.toString() + "|onGYNetEnd1";
            GMTrace.o(13157498093568L, 98031);
            return str;
          }
        });
        GMTrace.o(13163537891328L, 98076);
        return;
      }
      if ((paramInt2 == 4) && (paramInt3 == 65319))
      {
        this.gUt.a(paramInt2, paramInt3, paramString, this);
        com.tencent.mm.plugin.report.c.oRz.a(148L, 47L, 1L, false);
        GMTrace.o(13163537891328L, 98076);
        return;
      }
      if ((paramInt2 == 4) && (paramInt3 == 65318))
      {
        this.gUt.a(paramInt2, paramInt3, paramString, this);
        com.tencent.mm.plugin.report.c.oRz.a(148L, 53L, 1L, false);
        GMTrace.o(13163537891328L, 98076);
        return;
      }
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.NetSceneManualAuth", "summerauth Failed. callback and return now ! [%d ,%d ,%s]", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt2), paramString });
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      com.tencent.mm.plugin.report.c.oRz.a(148L, 6L, 1L, false);
      GMTrace.o(13163537891328L, 98076);
      return;
    }
    if ((paramInt1 & 0x2) != 0)
    {
      ap localap = localbgb.ueN;
      if ((localap == null) || (bf.mA(localap.jLx)))
      {
        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.NetSceneManualAuth", "summerauth UserName is null and return false!");
        this.gUt.a(4, -1, "", this);
        GMTrace.o(13163537891328L, 98076);
      }
    }
    else
    {
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.NetSceneManualAuth", "summerauth acct resp is null and return false!");
      this.gUt.a(4, -1, "", this);
      GMTrace.o(13163537891328L, 98076);
      return;
    }
    if (aq.b(paramp) == 2)
    {
      com.tencent.mm.plugin.report.c.oRz.a(148L, 7L, 1L, false);
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneManualAuth", "summerauth decode faild loginDecodeFailedTry:%d", new Object[] { Integer.valueOf(this.hSe) });
      this.hSe += 1;
      if (this.hSe > 1)
      {
        this.gUt.a(4, -1, "", this);
        GMTrace.o(13163537891328L, 98076);
        return;
      }
      ((i.d)this.hst.BG()).sXD.tMQ.tfS.tgP = 1;
      a(this.hsm, this.gUt);
      GMTrace.o(13163537891328L, 98076);
      return;
    }
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneManualAuth", "summerauth decode succeed!");
    h.vL().bIY();
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneManualAuth", "summerauth dkidc setAccUin Begin thread:[%s,%d]", new Object[] { Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())) });
    com.tencent.mm.u.u.a(locale.sXG, false);
    ((PluginAuth)h.j(PluginAuth.class)).getHandleAuthResponseCallbacks().a(paramArrayOfByte, locale, false);
    if (this.hSc) {
      h.vI().vr().set(2, paramArrayOfByte.sXD.tMP.jLx);
    }
    h.vH().gXs.a(new bb(new bb.a()
    {
      public final void a(com.tencent.mm.network.e paramAnonymouse)
      {
        GMTrace.i(13159779794944L, 98048);
        if ((paramAnonymouse == null) || (paramAnonymouse.Cc() == null) || (locale.idE == null) || (locale.sXG == null) || (locale.sXG.ueM == null))
        {
          com.tencent.mm.plugin.report.c.oRz.a(148L, 8L, 1L, false);
          com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneManualAuth", "[arthurdan.NetSceneManualAuthCrash] fatal error dispatcher == null || null == dispatcher.getAccInfo() || null == resp.getSession() || null == resp.rImpl || null == resp.rImpl.AuthSectResp !!!");
          GMTrace.o(13159779794944L, 98048);
          return;
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneLocalProxy setSessionInfo session:%s, uin:%d", new Object[] { bf.Qi(bf.bl(locale.idE)), Integer.valueOf(locale.sXG.ueM.lcP) });
        paramAnonymouse.Cc().i(locale.idE, locale.sXG.ueM.lcP);
        GMTrace.o(13159779794944L, 98048);
      }
    }), 0);
    if (bf.f((Integer)h.vI().vr().get(15, null)) != 0) {
      ((com.tencent.mm.plugin.zero.b.b)h.h(com.tencent.mm.plugin.zero.b.b.class)).Hz().gg(10);
    }
    paramInt1 = localbgb.ueM.tfN;
    if ((paramInt1 & 0x8) == 0)
    {
      paramp = com.tencent.mm.u.m.xL();
      if (!TextUtils.isEmpty(paramp))
      {
        paramp = new r(paramp);
        h.vH().gXs.a(paramp, 0);
      }
      paramInt1 = 4;
      if ((paramArrayOfByte.sXD.tMQ.tfS.tgM == null) || (paramArrayOfByte.sXD.tMQ.tfS.tgM.tXB <= 0)) {
        break label1353;
      }
      paramInt1 = 1;
      label1122:
      com.tencent.mm.plugin.report.b.d.o(1, paramInt1, paramArrayOfByte.sXD.tMP.jLx);
      if ((paramInt2 == 0) && (paramInt3 == 0))
      {
        paramp = ((i.e)this.htc.zg()).sXG.ueM.tfJ;
        if ((paramp == null) || (paramp.tZD == null) || (paramp.tZD.size() <= 0)) {
          break label1373;
        }
        paramp = paramp.tZD.iterator();
        do
        {
          if (!paramp.hasNext()) {
            break;
          }
          paramArrayOfByte = (bdr)paramp.next();
        } while (paramArrayOfByte.oSb != 1);
      }
    }
    label1353:
    label1373:
    for (paramInt1 = bf.getInt(paramArrayOfByte.udp, 0);; paramInt1 = 0)
    {
      com.tencent.mm.plugin.c.b.hh(paramInt1);
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneManualAuth", "publishManualAuthEvent");
      paramp = new it();
      paramp.fOj.fDL = true;
      com.tencent.mm.sdk.b.a.uql.m(paramp);
      h.vL().bJa();
      this.gUt.a(paramInt2, paramInt3, paramString, this);
      GMTrace.o(13163537891328L, 98076);
      return;
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneManualAuth", "summerauth not need getProfile authResultFlag:%d", new Object[] { Integer.valueOf(paramInt1) });
      com.tencent.mm.plugin.report.c.oRz.a(148L, 9L, 1L, false);
      break;
      if (paramArrayOfByte.sXD.tMQ.tMO != 1) {
        break label1122;
      }
      paramInt1 = 2;
      break label1122;
    }
  }
  
  protected final void a(k.a parama)
  {
    GMTrace.i(13163269455872L, 98074);
    GMTrace.o(13163269455872L, 98074);
  }
  
  public final int getType()
  {
    GMTrace.i(13162866802688L, 98071);
    GMTrace.o(13162866802688L, 98071);
    return 701;
  }
  
  public final void kD(String paramString)
  {
    GMTrace.i(13162732584960L, 98070);
    i.d locald = (i.d)this.htc.BG();
    locald.sXD.tMP.tie = paramString;
    locald.sXD.tMP.tio = paramString;
    locald.sXD.tMQ.tfS.tgM = new avt().bb(new byte[0]);
    this.hRZ = paramString;
    this.hSa = paramString;
    GMTrace.o(13162732584960L, 98070);
  }
  
  protected final int ub()
  {
    GMTrace.i(13163001020416L, 98072);
    GMTrace.o(13163001020416L, 98072);
    return 5;
  }
  
  public static final class a
  {
    public String fGM;
    public String fNx;
    public String hSj;
    public Bundle hSk;
    public int type;
    public String username;
    
    public a()
    {
      GMTrace.i(13160987754496L, 98057);
      GMTrace.o(13160987754496L, 98057);
    }
    
    public final String toString()
    {
      GMTrace.i(13161121972224L, 98058);
      String str = String.format("AuthBioInfo hash[%d], type[%d]. username[%s], ticket[%s], helpUrlp[%s], wording[%s], extra[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.type), this.username, bf.Qi(this.fGM), this.hSj, this.fNx, this.hSk });
      GMTrace.o(13161121972224L, 98058);
      return str;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelsimple/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */