package com.tencent.mm.u;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.o;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.ac;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.aez;
import com.tencent.mm.protocal.c.afa;
import com.tencent.mm.protocal.c.akq;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.protocal.c.ane;
import com.tencent.mm.protocal.c.ang;
import com.tencent.mm.protocal.c.ap;
import com.tencent.mm.protocal.c.avt;
import com.tencent.mm.protocal.c.bgb;
import com.tencent.mm.protocal.c.bmd;
import com.tencent.mm.protocal.c.bpj;
import com.tencent.mm.protocal.c.dr;
import com.tencent.mm.protocal.c.du;
import com.tencent.mm.protocal.c.dv;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.protocal.c.ek;
import com.tencent.mm.protocal.c.hq;
import com.tencent.mm.protocal.c.hr;
import com.tencent.mm.protocal.c.or;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.i.a;
import com.tencent.mm.protocal.i.b;
import com.tencent.mm.protocal.i.c;
import com.tencent.mm.protocal.i.d;
import com.tencent.mm.protocal.i.e;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.n.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.y.i;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class aq
  extends i
  implements i.c
{
  private static a hlY;
  private final int hlV;
  private final i.f hlW;
  private final i.g hlX;
  
  static
  {
    GMTrace.i(13484318261248L, 100466);
    hlY = null;
    GMTrace.o(13484318261248L, 100466);
  }
  
  public aq(int paramInt)
  {
    GMTrace.i(13482573430784L, 100453);
    if ((paramInt == 702) || (paramInt == 701)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.hlV = paramInt;
      if (paramInt != 702) {
        break;
      }
      this.hlW = new i.a();
      this.hlX = new i.b();
      GMTrace.o(13482573430784L, 100453);
      return;
    }
    this.hlW = new i.d();
    this.hlX = new i.e();
    GMTrace.o(13482573430784L, 100453);
  }
  
  public static void a(a parama)
  {
    GMTrace.i(13483110301696L, 100457);
    hlY = parama;
    GMTrace.o(13483110301696L, 100457);
  }
  
  public static void a(boolean paramBoolean, hr paramhr, ane paramane, afa paramafa)
  {
    GMTrace.i(13483378737152L, 100459);
    int i;
    int j;
    label22:
    int k;
    label29:
    int m;
    label36:
    int n;
    label43:
    int i1;
    if (paramhr == null)
    {
      i = -1;
      if (paramhr != null) {
        break label202;
      }
      j = -1;
      if (paramafa != null) {
        break label211;
      }
      k = -1;
      if (paramane != null) {
        break label220;
      }
      m = -1;
      if (paramane != null) {
        break label229;
      }
      n = -1;
      if (paramane != null) {
        break label238;
      }
      i1 = -1;
      label50:
      if (paramane != null) {
        break label247;
      }
      str = "null";
      label58:
      if (paramane != null) {
        break label256;
      }
    }
    label202:
    label211:
    label220:
    label229:
    label238:
    label247:
    label256:
    for (Object localObject1 = "null";; localObject1 = paramane.tQt)
    {
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo resetnewwork:%b iplist[l:%d s:%d] hostList[%d] noop[%d %d] typing[%d] port[%s] timeout[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), str, localObject1 });
      if ((paramafa != null) && (paramafa.jLs != null) && (paramafa.jLs.size() > 0)) {
        break label265;
      }
      com.tencent.mm.sdk.platformtools.v.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", new Object[] { bf.bJP() });
      GMTrace.o(13483378737152L, 100459);
      return;
      i = paramhr.tki;
      break;
      j = paramhr.tkj;
      break label22;
      k = paramafa.jLr;
      break label29;
      m = paramane.tQu;
      break label36;
      n = paramane.tQv;
      break label43;
      i1 = paramane.tQw;
      break label50;
      str = paramane.tQs;
      break label58;
    }
    label265:
    if ((paramafa == null) || (paramafa.jLs == null) || (paramafa.jLs.size() <= 0))
    {
      com.tencent.mm.sdk.platformtools.v.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", new Object[] { bf.bJP() });
      GMTrace.o(13483378737152L, 100459);
      return;
    }
    localObject1 = new LinkedList();
    ((List)localObject1).clear();
    Object localObject2 = paramhr.tkm.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (hq)((Iterator)localObject2).next();
      str = "";
      if (((hq)localObject3).tkh != null) {
        str = ((hq)localObject3).tkh.bGP();
      }
      ((List)localObject1).add(new com.tencent.mm.protocal.n(((hq)localObject3).type, ((hq)localObject3).tkg.bGP(), ((hq)localObject3).port, str));
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo short type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((hq)localObject3).type), Integer.valueOf(((hq)localObject3).port), ((hq)localObject3).tkg.bGP() });
    }
    String str = com.tencent.mm.protocal.n.bT((List)localObject1);
    localObject1 = new LinkedList();
    localObject2 = paramhr.tkl.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (hq)((Iterator)localObject2).next();
      paramhr = "";
      if (((hq)localObject3).tkh != null) {
        paramhr = ((hq)localObject3).tkh.bGP();
      }
      ((List)localObject1).add(new com.tencent.mm.protocal.n(((hq)localObject3).type, ((hq)localObject3).tkg.bGP(), ((hq)localObject3).port, paramhr));
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo long type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((hq)localObject3).type), Integer.valueOf(((hq)localObject3).port), ((hq)localObject3).tkg.bGP() });
    }
    localObject1 = com.tencent.mm.protocal.n.bT((List)localObject1);
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo builtin ip long[%s] short[%s]", new Object[] { localObject1, str });
    h.vJ();
    h.vI().gXM.set(2, str);
    localObject2 = aa.getContext().getSharedPreferences("system_config_prefs", 0);
    ((SharedPreferences)localObject2).edit().putString("builtin_short_ips", str).commit();
    h.vJ();
    h.vI().gXM.set(3, localObject1);
    h.vJ();
    h.vI().gXM.set(6, paramane.tQs);
    h.vJ();
    h.vI().gXM.set(7, paramane.tQt);
    String[] arrayOfString1;
    String[] arrayOfString2;
    int[] arrayOfInt;
    if (paramane.tQw != 0)
    {
      h.vJ();
      paramhr = h.vI().gXM;
      if (paramane.tQw > 60)
      {
        i = 60;
        paramhr.set(35, Integer.valueOf(i));
      }
    }
    else
    {
      ac.f(paramane.tQu, paramane.tQx);
      localObject3 = com.tencent.mm.protocal.n.et(paramane.tQs, paramane.tQt);
      paramhr = "";
      paramane = "";
      arrayOfString1 = new String[paramafa.jLs.size()];
      arrayOfString2 = new String[paramafa.jLs.size()];
      arrayOfInt = new int[paramafa.jLs.size()];
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMReqRespAuth", "hostlist.Count=%d", new Object[] { Integer.valueOf(paramafa.jLr) });
      paramafa = paramafa.jLs.iterator();
      i = 0;
    }
    for (;;)
    {
      if (!paramafa.hasNext()) {
        break label1168;
      }
      aez localaez = (aez)paramafa.next();
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMReqRespAuth", "dkidc host org:%s sub:%s", new Object[] { localaez.tIG, localaez.tIH });
      arrayOfString1[i] = localaez.tIG;
      arrayOfString2[i] = localaez.tIH;
      arrayOfInt[i] = localaez.tII;
      j = i + 1;
      i = j;
      if (!bf.mA(localaez.tIG))
      {
        i = j;
        if (!bf.mA(localaez.tIH))
        {
          if (localaez.tIG.equals("short.weixin.qq.com"))
          {
            h.vJ();
            h.vI().gXM.set(24, localaez.tIH);
            paramane = localaez.tIH;
            i = j;
            continue;
            i = paramane.tQw;
            break;
          }
          if (localaez.tIG.equals("long.weixin.qq.com"))
          {
            h.vJ();
            h.vI().gXM.set(25, localaez.tIH);
            paramhr = localaez.tIH;
            i = j;
          }
          else
          {
            i = j;
            if (localaez.tIG.equals("support.weixin.qq.com"))
            {
              i = j;
              if (!bf.mA(localaez.tIH))
              {
                ((SharedPreferences)localObject2).edit().putString("support.weixin.qq.com", localaez.tIH).commit();
                i = j;
              }
            }
          }
        }
      }
    }
    label1168:
    h.vJ();
    paramafa = h.vH().gXs.hsI;
    if ((arrayOfString1.length > 0) && (paramafa != null)) {
      paramafa.setHostInfo(arrayOfString1, arrayOfString2, arrayOfInt);
    }
    if (!bf.mA(paramhr))
    {
      h.vJ();
      h.vI().gXM.set(25, paramhr);
    }
    if (!bf.mA(paramane))
    {
      h.vJ();
      h.vI().gXM.set(24, paramane);
    }
    if (paramafa != null) {
      paramafa.a(paramBoolean, str, (String)localObject1, ((n.a)localObject3).sYc, ((n.a)localObject3).sYd, ((n.a)localObject3).sYe, ((n.a)localObject3).sYf, paramane, paramhr);
    }
    GMTrace.o(13483378737152L, 100459);
  }
  
  public static int b(p paramp)
  {
    GMTrace.i(13484184043520L, 100465);
    Object localObject2 = (i.f)paramp.BG();
    i.g localg = (i.g)paramp.zg();
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo type:%d, hashcode:%d, ret:%d, stack[%s]", new Object[] { Integer.valueOf(((i.f)localObject2).zi()), Integer.valueOf(paramp.hashCode()), Integer.valueOf(localg.sXI), bf.bJP() });
    int i;
    if (localg.sXI != 0)
    {
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", new Object[] { Integer.valueOf(localg.sXI) });
      i = localg.sXI;
      GMTrace.o(13484184043520L, 100465);
      return i;
    }
    bgb localbgb = localg.sXG;
    int k = localbgb.ueL;
    Object localObject1;
    int j;
    byte[] arrayOfByte;
    if ((k & 0x1) != 0)
    {
      localObject1 = localbgb.ueM;
      j = ((dr)localObject1).tfN;
      com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMReqRespAuth", "decodeAndRetriveAccInfo authResultFlag:%d UpdateFlag:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(((dr)localObject1).tfM) });
      paramp = ((dr)localObject1).tfx;
      arrayOfByte = com.tencent.mm.platformtools.n.a(((dr)localObject1).tfy);
      int m = paramp.tfZ.tXB;
      int n = paramp.tsC;
      if (arrayOfByte == null)
      {
        i = -1;
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), bf.Qi(bf.bl(arrayOfByte)) });
        localObject1 = com.tencent.mm.platformtools.n.a(paramp.tfZ);
        localObject2 = ((i.f)localObject2).sXF;
        if (bf.bm((byte[])localObject1)) {
          break label641;
        }
        m = localObject1.length;
        Object localObject3 = bf.Qi(bf.bl((byte[])localObject1));
        if (localObject2 != null) {
          break label628;
        }
        i = -1;
        label321:
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMReqRespAuth", "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s", new Object[] { Integer.valueOf(m), localObject3, Integer.valueOf(i), bf.Qi(bf.bl((byte[])localObject2)) });
        localObject3 = new PByteArray();
        m = MMProtocalJni.computerKeyWithAllStr(paramp.tsC, (byte[])localObject1, (byte[])localObject2, (PByteArray)localObject3, 0);
        paramp = ((PByteArray)localObject3).value;
        if (paramp != null) {
          break label635;
        }
        i = -1;
        label401:
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMReqRespAuth", "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(i), bf.Qi(bf.bl(paramp)) });
        label438:
        if (paramp == null) {
          break label668;
        }
        localObject1 = paramp;
        label445:
        localg.sXH = ((byte[])localObject1);
        if ((j & 0x4) == 0) {
          break label767;
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMReqRespAuth", "summerauth must decode session key");
        if (bf.bm(paramp)) {
          break label728;
        }
        paramp = MMProtocalJni.aesDecrypt(arrayOfByte, paramp);
        if (arrayOfByte != null) {
          break label676;
        }
        i = -1;
        label487:
        localObject1 = bf.Qi(bf.bl(arrayOfByte));
        if (paramp != null) {
          break label683;
        }
        j = -1;
        label503:
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMReqRespAuth", "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s", new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(j), bf.Qi(bf.bl(paramp)) });
        if (bf.bm(paramp)) {
          break label689;
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMReqRespAuth", "summerauth decode session key succ session:%s", new Object[] { bf.Qi(bf.bl(paramp)) });
        localg.aW(paramp);
        localg.sXI = 1;
        label585:
        if ((k & 0x2) == 0) {
          break label830;
        }
        localg.idH = localbgb.ueN.jLx;
      }
    }
    for (;;)
    {
      i = localg.sXI;
      GMTrace.o(13484184043520L, 100465);
      return i;
      i = arrayOfByte.length;
      break;
      label628:
      i = localObject2.length;
      break label321;
      label635:
      i = paramp.length;
      break label401;
      label641:
      c.oRz.a(148L, 24L, 1L, false);
      com.tencent.mm.sdk.platformtools.v.w("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key is null!");
      paramp = null;
      break label438;
      label668:
      localObject1 = new byte[0];
      break label445;
      label676:
      i = arrayOfByte.length;
      break label487;
      label683:
      j = paramp.length;
      break label503;
      label689:
      c.oRz.a(148L, 25L, 1L, false);
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed ret null!");
      localg.aW(new byte[0]);
      localg.sXI = 2;
      break label585;
      label728:
      c.oRz.a(148L, 26L, 1L, false);
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed as agreedECDHKey is null!");
      localg.aW(new byte[0]);
      localg.sXI = 2;
      break label585;
      label767:
      c.oRz.a(148L, 27L, 1L, false);
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMReqRespAuth", "summerauth not need decode session key");
      localg.aW(arrayOfByte);
      localg.sXI = 1;
      break label585;
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMReqRespAuth", "summerauth auth sect not set so ret failed");
      localg.aW(new byte[0]);
      localg.sXI = 2;
      break label585;
      label830:
      com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMReqRespAuth", "summerauth acct sect not set!");
    }
  }
  
  private p fb(int paramInt)
  {
    GMTrace.i(13482707648512L, 100454);
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMReqRespAuth", "summerauth autoAuthReq authReqFlag:%d, this:%d, stack:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), bf.bJP() });
    Object localObject6 = (i.f)BG();
    Object localObject5 = (i.g)this.hlX;
    Object localObject4 = ar.ze();
    int i = ((SharedPreferences)localObject4).getInt("key_auth_update_version", 0);
    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMReqRespAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.sXh) });
    long l;
    ek localek;
    if (i < d.sXh)
    {
      if (this.hlV == 702)
      {
        i = 12;
        ((k.d)localObject6).sXQ = i;
        localObject1 = c.oRz;
        if (this.hlV != 702) {
          break label315;
        }
      }
      label315:
      for (l = 14L;; l = 13L)
      {
        ((c)localObject1).a(148L, l, 1L, false);
        localek = new ek();
        localek.tgP = paramInt;
        localek.tfF = new avt().bb(new byte[0]);
        localek.tfE = new avt().bb(new byte[0]);
        localObject1 = new bmd();
        localek.tgN = ((bmd)localObject1);
        ((bmd)localObject1).tiq = "";
        ((bmd)localObject1).tip = "";
        ((bmd)localObject1).uke = "";
        localObject1 = new bpj();
        localek.tgO = ((bpj)localObject1);
        ((bpj)localObject1).tFy = "";
        ((bpj)localObject1).tFx = "";
        if (h.vG().uV()) {
          break label348;
        }
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.MMReqRespAuth", "autoAuthReq build autoauth Req  , failed  acc not ready");
        GMTrace.o(13482707648512L, 100454);
        return null;
        i = 16;
        break;
      }
    }
    if (this.hlV == 702) {}
    for (i = 2;; i = 1)
    {
      ((k.d)localObject6).sXQ = i;
      break;
    }
    label348:
    h.vJ();
    Object localObject1 = bf.mz((String)h.vI().vr().get(2, null));
    h.vJ();
    Object localObject7 = new o(bf.a((Integer)h.vI().vr().get(9, null), 0));
    if (bf.mA((String)localObject1)) {
      localObject1 = ((o)localObject7).toString();
    }
    for (;;)
    {
      h.vJ();
      Object localObject2 = h.vG().gWS;
      l = ((o)localObject7).longValue();
      boolean bool;
      Object localObject3;
      if (this.hlV == 701)
      {
        bool = true;
        localObject3 = ((com.tencent.mm.y.v)localObject2).a(l, "", bool);
        if (localObject3 != null) {
          break label722;
        }
        paramInt = -1;
        label468:
        if (localObject3 != null) {
          break label729;
        }
        localObject2 = "null";
        label477:
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMReqRespAuth", "summerauth loginbuf username:%s, qq:%s, len:%d, content:[%s]", new Object[] { localObject1, localObject7, Integer.valueOf(paramInt), localObject2 });
        localObject7 = new avt();
        if (!bf.bm((byte[])localObject3)) {
          break label742;
        }
        localObject2 = new byte[0];
        localek.tgM = ((avt)localObject7).bb((byte[])localObject2);
        if (this.hlV != 702) {
          break label860;
        }
        localObject2 = (i.a)localObject6;
        localObject3 = (i.b)localObject5;
        localObject5 = new du();
        localObject6 = new dx();
        ((i.a)localObject2).sXB.tga = ((dx)localObject6);
        ((i.a)localObject2).sXB.tgb = ((du)localObject5);
        localObject7 = bf.PS(((SharedPreferences)localObject4).getString("_auth_key", ""));
        localObject4 = new dv();
        if (bf.bm((byte[])localObject7)) {
          break label782;
        }
        ((du)localObject5).tfz = new avt().bb((byte[])localObject7);
      }
      for (;;)
      {
        try
        {
          ((dv)localObject4).aD((byte[])localObject7);
          if (((dv)localObject4).tfY == null) {
            break label817;
          }
          ((dx)localObject6).tgc = ((dv)localObject4).tfY;
          ((du)localObject5).tfS = localek;
          ((i.a)localObject2).username = ((String)localObject1);
          ((i.g)localObject3).idH = ((String)localObject1);
          GMTrace.o(13482707648512L, 100454);
          return this;
          bool = false;
          break;
          label722:
          paramInt = localObject3.length;
          break label468;
          label729:
          localObject2 = bf.Qi(bf.bl((byte[])localObject3));
          break label477;
          label742:
          localObject2 = localObject3;
        }
        catch (IOException localIOException)
        {
          c.oRz.a(148L, 15L, 1L, false);
          com.tencent.mm.sdk.platformtools.v.printErrStackTrace("MicroMsg.MMReqRespAuth", localIOException, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
          continue;
        }
        label782:
        c.oRz.a(148L, 16L, 1L, false);
        ((du)localObject5).tfz = new avt().bb(new byte[0]);
        continue;
        label817:
        c.oRz.a(148L, 17L, 1L, false);
        ((dx)localObject6).tgc = new avt().bb(new byte[0]);
        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey null!");
        continue;
        label860:
        localObject3 = (i.d)localObject6;
        localObject2 = new aks();
        localObject4 = new akq();
        ((i.d)localObject3).sXD.tMP = ((aks)localObject2);
        ((i.d)localObject3).sXD.tMQ = ((akq)localObject4);
        ((akq)localObject4).tMO = 2;
        ((akq)localObject4).tfS = localek;
        ((aks)localObject2).jLx = ((String)localObject1);
        h.vJ();
        localObject1 = bf.mz((String)h.vI().vr().get(3, null));
        h.vJ();
        ((aks)localObject2).tie = bf.mz((String)h.vI().vr().get(19, null));
        ((aks)localObject2).tio = ((String)localObject1);
      }
    }
  }
  
  public static SharedPreferences ze()
  {
    GMTrace.i(15694750023680L, 116935);
    SharedPreferences localSharedPreferences = ar.ze();
    GMTrace.o(15694750023680L, 116935);
    return localSharedPreferences;
  }
  
  public final void a(i.f paramf, i.g paramg, int paramInt1, int paramInt2, String paramString)
  {
    GMTrace.i(13483244519424L, 100458);
    if (!h.vG().uV())
    {
      com.tencent.mm.sdk.platformtools.v.e("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd but account not ready");
      GMTrace.o(13483244519424L, 100458);
      return;
    }
    bgb localbgb = paramg.sXG;
    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if ((paramInt1 == 4) && (paramInt2 == 65235))
      {
        c.oRz.a(148L, 18L, 1L, false);
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC");
        if ((localbgb != null) && (localbgb.ueO != null))
        {
          a(true, paramg.sXG.ueO.tig, paramg.sXG.ueO.tih, paramg.sXG.ueO.tif);
          GMTrace.o(13483244519424L, 100458);
          return;
        }
        com.tencent.mm.sdk.platformtools.v.w("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC but NetworkSectResp is null");
      }
      GMTrace.o(13483244519424L, 100458);
      return;
    }
    if (hlY != null) {
      hlY.a(paramf, paramg);
    }
    GMTrace.o(13483244519424L, 100458);
  }
  
  public final p aI(int paramInt1, int paramInt2)
  {
    GMTrace.i(13482976083968L, 100456);
    p localp = new aq(paramInt1).fb(paramInt2);
    GMTrace.o(13482976083968L, 100456);
    return localp;
  }
  
  public final int getType()
  {
    GMTrace.i(13483915608064L, 100463);
    int i = this.hlW.zi();
    GMTrace.o(13483915608064L, 100463);
    return i;
  }
  
  public final String getUri()
  {
    GMTrace.i(13484049825792L, 100464);
    String str = this.hlW.getUri();
    GMTrace.o(13484049825792L, 100464);
    return str;
  }
  
  public final int zd()
  {
    GMTrace.i(13482841866240L, 100455);
    if (h.vG().uV())
    {
      h.vJ();
      h.vG();
      int i = a.uH();
      GMTrace.o(13482841866240L, 100455);
      return i;
    }
    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.MMReqRespAuth", "dkwt acc NOT Ready , the fucking MMReqRespBase need the fucking uin ???  if u find this log , fuck dk. %s", new Object[] { bf.bJP() });
    GMTrace.o(13482841866240L, 100455);
    return 0;
  }
  
  protected final k.d zf()
  {
    GMTrace.i(13483647172608L, 100461);
    i.f localf = this.hlW;
    GMTrace.o(13483647172608L, 100461);
    return localf;
  }
  
  public final k.e zg()
  {
    GMTrace.i(15694884241408L, 116936);
    i.g localg = this.hlX;
    GMTrace.o(15694884241408L, 116936);
    return localg;
  }
  
  public static abstract interface a
  {
    public abstract void a(i.f paramf, i.g paramg);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */