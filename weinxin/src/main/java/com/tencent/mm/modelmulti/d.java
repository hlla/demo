package com.tencent.mm.modelmulti;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.g;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.booter.f;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.network.a;
import com.tencent.mm.network.j;
import com.tencent.mm.network.s;
import com.tencent.mm.network.z;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.plugin.zero.a.b;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.anq;
import com.tencent.mm.protocal.c.anr;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.w.a;
import com.tencent.mm.protocal.w.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.k.b;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class d
  extends com.tencent.mm.y.k
  implements j
{
  protected static int cCe;
  private int errCode;
  private int errType;
  private String fOW;
  private com.tencent.mm.y.e gUt;
  private int hJN;
  private g.a hJO;
  private StringBuilder hJP;
  private long hJQ;
  public boolean hJR;
  private ai hqz;
  
  static
  {
    GMTrace.i(13440294846464L, 100138);
    cCe = 7;
    GMTrace.o(13440294846464L, 100138);
  }
  
  public d()
  {
    GMTrace.i(13438818451456L, 100127);
    this.errType = 0;
    this.errCode = 0;
    this.fOW = "";
    this.hJN = 0;
    this.hJP = new StringBuilder();
    this.hJQ = -1L;
    this.hJR = false;
    v.d("MicroMsg.NetPushSync", "dksord NetSceneSync hash:%d stack:%s", new Object[] { Integer.valueOf(hashCode()), bf.bJP() });
    this.hJO = new g.a();
    this.hJP.append("stack:" + bf.bJP() + " time:" + bf.Nz());
    GMTrace.o(13438818451456L, 100127);
  }
  
  public d(final w.b paramb, int paramInt, long paramLong)
  {
    this();
    GMTrace.i(13438952669184L, 100128);
    this.hJN = paramInt;
    this.hJQ = paramLong;
    v.d("MicroMsg.NetPushSync", "dkpush do scene resp SCENE_SYNC_WAIT");
    this.hqz = new ai(z.MS(), new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(13436805185536L, 100112);
        d.this.hJR = true;
        d.a locala = new d.a(paramb);
        d.this.a(-1, 0, 0, "", locala, null);
        GMTrace.o(13436805185536L, 100112);
        return false;
      }
    }, false);
    GMTrace.o(13438952669184L, 100128);
  }
  
  public final boolean BJ()
  {
    GMTrace.i(13439489540096L, 100132);
    boolean bool = super.BJ();
    GMTrace.o(13439489540096L, 100132);
    return bool;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    boolean bool = false;
    GMTrace.i(13439892193280L, 100135);
    this.gUt = parame1;
    this.hJP.append(" lastd:" + this.hsn + " dotime:" + bf.Nz() + " net:" + al.getNetType(aa.getContext()));
    int i = hashCode();
    int j = cCe;
    if (this.hqz != null) {
      bool = true;
    }
    v.i("MicroMsg.NetPushSync", "doScene[%d] selector:%d pusher:%b ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(bool) });
    if (this.hqz != null)
    {
      c(parame);
      this.hqz.v(0L, 0L);
      this.hqz = null;
      GMTrace.o(13439892193280L, 100135);
      return -1;
    }
    parame1 = new a();
    parame1.uin = z.MP().idW.uH();
    anq localanq = ((w.a)parame1.BG()).sYw;
    localanq.tmu = cCe;
    localanq.tmv = n.G(bf.PS(aa.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", "")));
    localanq.tcg = 1;
    localanq.tRg = new lu();
    localanq.tfX = com.tencent.mm.protocal.d.DEVICE_TYPE;
    i = a(parame, parame1, this);
    GMTrace.o(13439892193280L, 100135);
    return i;
  }
  
  protected final int a(com.tencent.mm.network.p paramp)
  {
    GMTrace.i(13439355322368L, 100131);
    int i = k.b.hsC;
    GMTrace.o(13439355322368L, 100131);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(13440026411008L, 100136);
    if ((paramp == null) || (paramp.getType() != 138))
    {
      if (paramp == null) {}
      for (paramInt1 = -2;; paramInt1 = paramp.getType())
      {
        v.e("MicroMsg.NetPushSync", "onGYNetEnd error type:%d", new Object[] { Integer.valueOf(paramInt1) });
        GMTrace.o(13440026411008L, 100136);
        return;
      }
    }
    this.hJP.append(" endtime:" + bf.Nz());
    v.i("MicroMsg.NetPushSync", "onGYNetEnd: %d [%d,%d,%s] hash isnotifydata:%b time:%d [%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Boolean.valueOf(this.hJR), Long.valueOf(this.hJO.se()), this.hJP });
    w.b localb;
    label269:
    label357:
    label446:
    label472:
    label524:
    Object localObject1;
    if ((paramInt2 == 4) && (paramInt3 == 63530))
    {
      paramInt2 = 0;
      paramInt3 = 0;
      paramInt1 = 1;
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        this.gUt.a(paramInt2, paramInt3, paramString, this);
        GMTrace.o(13440026411008L, 100136);
        return;
      }
      localb = (w.b)paramp.zg();
      if (paramInt1 == 0)
      {
        paramString = n.a(((w.a)paramp.BG()).sYw.tmv);
        if (paramString == null)
        {
          paramInt1 = -1;
          v.d("MicroMsg.NetPushSync", "dkpush req Key : %d[%s]", new Object[] { Integer.valueOf(paramInt1), bf.bl(paramString) });
          if (!bf.bm(paramString)) {
            break label1829;
          }
          paramString = bf.PS(aa.getContext().getSharedPreferences("notify_sync_pref", 4).getString("notify_sync_key_keybuf", ""));
          v.d("MicroMsg.NetPushSync", "dkpush userinfo key : %d[%s]", new Object[] { Integer.valueOf(paramString.length), bf.bl(paramString) });
          paramp = n.a(localb.sYx.tmv);
          paramArrayOfByte = ad.g(paramString, paramp);
          if (paramArrayOfByte != null)
          {
            paramString = paramArrayOfByte;
            if (paramArrayOfByte.length > 0) {}
          }
          else
          {
            v.w("MicroMsg.NetPushSync", "merge key failed, use server side instead");
            paramString = paramp;
          }
          localb.sYx.tmv = n.G(paramString);
          if ((localb.sYx.tmy != null) && (localb.sYx.tmy.jLs != null)) {
            break label734;
          }
          paramInt1 = 0;
          v.i("MicroMsg.NetPushSync", "newMsgSize:%d", new Object[] { Integer.valueOf(paramInt1) });
          if (paramString != null) {
            break label752;
          }
          paramInt2 = -1;
          v.d("MicroMsg.NetPushSync", "newMsgSize:%d, mergeKey: %d[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), bf.bl(paramString) });
        }
      }
      else
      {
        paramArrayOfByte = localb.sYx.tmy.jLs.iterator();
        paramInt2 = 0;
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (lt)paramArrayOfByte.next();
          if (((lt)localObject1).tqs == 5) {
            paramString = n.a(((lt)localObject1).tqt);
          }
        }
      }
    }
    for (;;)
    {
      Object localObject2;
      long l;
      label734:
      label752:
      String str;
      try
      {
        localObject2 = new bu();
        ((bu)localObject2).aD(paramString);
        int i = ((bu)localObject2).mrC;
        paramString = ((bu)localObject2).tdx.tXF;
        l = ((bu)localObject2).tdE;
        if (((bu)localObject2).tdD == null)
        {
          paramInt1 = 0;
          if (((bu)localObject2).tdz.tXF != null) {
            continue;
          }
          paramInt3 = 0;
          v.i("MicroMsg.NetPushSync", "oreh msgType:%d, talker:%s, newmsgID:%d, pushContent.len:%d, content.len:%d", new Object[] { Integer.valueOf(i), paramString, Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt3) });
          paramInt1 = ((bu)localObject2).mrC;
          paramString = ((bu)localObject2).tdx.tXF;
          paramp = ((bu)localObject2).tdz.tXF;
          if (paramInt1 != 50) {
            continue;
          }
          v.i("MicroMsg.NetPushSync", "hit voip");
          paramInt1 = 1;
          if (paramInt1 == 0) {
            continue;
          }
          paramInt2 = 1;
          break label524;
          paramInt1 = paramString.length;
          break label269;
          paramInt1 = localb.sYx.tmy.jLs.size();
          break label446;
          paramInt2 = paramString.length;
          break label472;
        }
        paramInt1 = ((bu)localObject2).tdD.length();
        continue;
        paramInt3 = ((bu)localObject2).tdz.tXF.length();
        continue;
        if ((bf.mA(paramp)) || (bf.mA(paramString)))
        {
          v.w("MicroMsg.NetPushSync", "check should launch to mm ,content or from username is null.");
          break label1837;
        }
        if ((paramInt1 == 9998) && (paramString.equalsIgnoreCase("weixin")))
        {
          v.i("MicroMsg.NetPushSync", "hit ipxx");
          paramInt1 = 1;
          continue;
        }
        if ((paramInt1 != 10002) || (!paramp.contains("revokemsg"))) {
          break label1837;
        }
        v.i("MicroMsg.NetPushSync", "hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
        paramInt1 = 1;
        continue;
        l = ((bu)localObject2).tdE;
        str = ((bu)localObject2).tdx.tXF;
        paramString = ((bu)localObject2).tdD;
        paramInt1 = ((bu)localObject2).mrC;
        if (!bf.mA(paramString)) {
          break label986;
        }
        v.i("MicroMsg.NetPushSync", "showNotifyCation pushContent is null, skip");
        if (((bu)localObject2).mrC != 10002) {
          break label1218;
        }
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label524;
        }
        v.i("MicroMsg.NetPushSync", "need remove pushContent");
        ((bu)localObject2).tdD = null;
        ((lt)localObject1).tqt = n.G(((bu)localObject2).toByteArray());
      }
      catch (IOException paramString)
      {
        v.printErrStackTrace("MicroMsg.NetPushSync", paramString, "", new Object[0]);
      }
      break label524;
      label986:
      PString localPString1 = new PString();
      PString localPString2 = new PString();
      paramp = bf.PW(paramString);
      paramInt3 = paramp.indexOf("<pushcontent");
      paramString = paramp;
      if (paramInt3 > 0) {
        paramString = paramp.substring(paramInt3);
      }
      paramString = bg.q(paramString, "pushcontent");
      if (paramString == null) {
        v.e("MicroMsg.NetPushSync", "inval xml");
      }
      for (;;)
      {
        paramString = (PluginZero)com.tencent.mm.kernel.h.j(PluginZero.class);
        if (paramString.szm == null) {
          break;
        }
        paramp = com.tencent.mm.compatible.util.e.hgk + g.n(new StringBuilder("mm").append(z.MP().idW.uH()).toString().getBytes());
        paramString.szm.a(l, str, localPString2.value, localPString1.value, paramp + "/avatar/", paramInt1);
        break;
        localPString1.value = ((String)paramString.get(".pushcontent.$content"));
        localPString2.value = ((String)paramString.get(".pushcontent.$nickname"));
      }
      label1218:
      paramInt1 = 0;
      continue;
      try
      {
        paramp = localb.sYx.toByteArray();
        paramInt3 = z.MP().idW.uH();
        paramString = f.dM(paramInt3);
        paramInt1 = f.cU(paramString) + 1;
        paramArrayOfByte = paramString + "/syncResp.bin" + paramInt1;
        localObject1 = g.n((com.tencent.mm.compatible.d.p.rA() + paramInt3).getBytes());
        localObject2 = com.tencent.mm.a.k.b(paramp, ((String)localObject1).getBytes());
        v.i("MicroMsg.NotifySyncMgr", "writeFile %d, len:%d, resultLen:%d, file:%s, dump %s -> %s, key:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramp.length), Integer.valueOf(localObject2.length), paramArrayOfByte, f.v(paramp), f.v((byte[])localObject2), f.v(((String)localObject1).getBytes()) });
        if (bf.bm((byte[])localObject2)) {
          v.e("MicroMsg.NotifySyncMgr", "encry failed");
        }
        for (;;)
        {
          v.d("MicroMsg.NetPushSync", "onRespHandled sync");
          aa.getContext().getSharedPreferences("notify_sync_pref", 4).edit().putString("notify_sync_key_keybuf", bf.bo(n.a(localb.sYx.tmv))).commit();
          v.d("MicroMsg.NetPushSync", "dkpush pushSyncFlag:%d", new Object[] { Integer.valueOf(this.hJN) });
          if (paramInt2 != 0) {
            break label1741;
          }
          if (((localb.sYx.tkt & cCe) == 0) || (super.BJ())) {
            break label1736;
          }
          paramInt1 = 1;
          v.i("MicroMsg.NetPushSync", "continue flag=" + localb.sYx.tkt + ", selector=" + cCe + ", limit reach=" + super.BJ());
          if (paramInt1 == 0) {
            break label1741;
          }
          a(this.hsm, this.gUt);
          if (paramInt2 != 0) {
            CoreService.pT();
          }
          GMTrace.o(13440026411008L, 100136);
          return;
          paramInt3 = com.tencent.mm.a.e.b(paramArrayOfByte, (byte[])localObject2, localObject2.length);
          boolean bool = com.tencent.mm.a.e.aO(paramArrayOfByte);
          if ((paramInt3 == 0) && (bool)) {
            break;
          }
          v.e("MicroMsg.NotifySyncMgr", "writeFile failed:!!!!!, writeResult:%d, writedFileExit:%b", new Object[] { Integer.valueOf(paramInt3), Boolean.valueOf(bool) });
        }
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          v.e("MicroMsg.NetPushSync", "write syncResp buf err:%s", new Object[] { paramString });
          v.printErrStackTrace("MicroMsg.NetPushSync", paramString, "", new Object[0]);
          continue;
          paramp = String.valueOf(paramInt1).getBytes();
          com.tencent.mm.a.e.b(paramString + "/syncResp.ini", paramp, paramp.length);
          continue;
          label1736:
          paramInt1 = 0;
          continue;
          label1741:
          if ((this.hJN & 0x1) > 0)
          {
            v.i("MicroMsg.NetPushSync", "oreh NotifyData ack");
            new h(this.hJQ, n.a(localb.sYx.tmv), z.MP().idW.uH()).a(z.MP(), new com.tencent.mm.y.e()
            {
              public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.y.k paramAnonymousk)
              {
                GMTrace.i(13429154775040L, 100055);
                v.i("MicroMsg.NetPushSync", "NetSceneNotifyData onSceneEnd: %d, %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
                paramAnonymousk.hss = true;
                GMTrace.o(13429154775040L, 100055);
              }
            });
          }
          this.gUt.a(this.errType, this.errCode, this.fOW, this);
        }
      }
      label1829:
      break label357;
      paramInt1 = 0;
      break;
      label1837:
      paramInt1 = 0;
    }
  }
  
  protected final void cancel()
  {
    GMTrace.i(13439757975552L, 100134);
    super.cancel();
    GMTrace.o(13439757975552L, 100134);
  }
  
  public final String getInfo()
  {
    GMTrace.i(13439086886912L, 100129);
    String str = this.hJP.toString();
    GMTrace.o(13439086886912L, 100129);
    return str;
  }
  
  public final int getType()
  {
    GMTrace.i(13439623757824L, 100133);
    GMTrace.o(13439623757824L, 100133);
    return 138;
  }
  
  protected final int ub()
  {
    GMTrace.i(13439221104640L, 100130);
    GMTrace.o(13439221104640L, 100130);
    return 500;
  }
  
  public static final class a
    implements com.tencent.mm.network.p
  {
    private final w.a hJU;
    private final w.b hJV;
    private final boolean hJW;
    int uin;
    
    public a()
    {
      GMTrace.i(13434255048704L, 100093);
      this.hJU = new w.a();
      this.hJV = new w.b();
      this.hJW = false;
      GMTrace.o(13434255048704L, 100093);
    }
    
    public a(w.b paramb)
    {
      GMTrace.i(13434389266432L, 100094);
      this.hJU = new w.a();
      this.hJV = paramb;
      this.hJW = true;
      GMTrace.o(13434389266432L, 100094);
    }
    
    public final int BD()
    {
      GMTrace.i(13435194572800L, 100100);
      GMTrace.o(13435194572800L, 100100);
      return 0;
    }
    
    public final k.d BG()
    {
      GMTrace.i(13434926137344L, 100098);
      this.hJU.sXP = com.tencent.mm.compatible.d.p.rB();
      this.hJU.sXO = com.tencent.mm.protocal.d.DEVICE_TYPE;
      this.hJU.sXN = com.tencent.mm.protocal.d.sXh;
      this.hJU.dj(this.uin);
      w.a locala = this.hJU;
      GMTrace.o(13434926137344L, 100098);
      return locala;
    }
    
    public final boolean BH()
    {
      GMTrace.i(13435060355072L, 100099);
      GMTrace.o(13435060355072L, 100099);
      return false;
    }
    
    public final int getType()
    {
      GMTrace.i(13434657701888L, 100096);
      GMTrace.o(13434657701888L, 100096);
      return 138;
    }
    
    public final String getUri()
    {
      GMTrace.i(13434791919616L, 100097);
      GMTrace.o(13434791919616L, 100097);
      return "/cgi-bin/micromsg-bin/newsync";
    }
    
    public final k.e zg()
    {
      GMTrace.i(13434523484160L, 100095);
      w.b localb = this.hJV;
      GMTrace.o(13434523484160L, 100095);
      return localb;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelmulti/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */