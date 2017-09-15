package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.i.e;
import com.tencent.mm.i.g;
import com.tencent.mm.pluginsdk.l.v;
import com.tencent.mm.pluginsdk.l.y;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import java.util.Map;

public final class a
{
  public String desc;
  public String fFN;
  public int fMU;
  public long hUP;
  public long sBs;
  public int size;
  public String url;
  
  public a(String paramString)
  {
    GMTrace.i(787455410176L, 5867);
    Map localMap = bg.q(paramString, "msg");
    this.desc = ((String)localMap.get(".msg.appmsg.des"));
    this.fMU = bf.getInt((String)localMap.get(".msg.alphainfo.clientVersion"), 0);
    this.url = ((String)localMap.get(".msg.alphainfo.url"));
    this.size = bf.getInt((String)localMap.get(".msg.alphainfo.size"), 0);
    this.fFN = ((String)localMap.get(".msg.alphainfo.md5"));
    this.sBs = bf.getLong((String)localMap.get(".msg.alphainfo.maxAge"), 0L);
    this.hUP = bf.getLong((String)localMap.get(".msg.alphainfo.expireTime"), 0L);
    v.i("MicroMsg.AlphaUpdateInfo", "updateInfo, content:%s, clientVersion:%d, url:%s, size:%d, md5:%s, desc:%s, maxAge:%d, expireTime:%d", new Object[] { paramString, Integer.valueOf(this.fMU), this.url, Integer.valueOf(this.size), this.fFN, this.desc, Long.valueOf(this.sBs), Long.valueOf(this.hUP) });
    GMTrace.o(787455410176L, 5867);
  }
  
  private boolean bAI()
  {
    GMTrace.i(787723845632L, 5869);
    ap.yY();
    long l = ((Long)c.vr().get(352274, Long.valueOf(System.currentTimeMillis()))).longValue();
    if ((System.currentTimeMillis() - l > this.sBs) || (System.currentTimeMillis() > this.hUP)) {}
    for (boolean bool = true;; bool = false)
    {
      v.i("MicroMsg.AlphaUpdateInfo", "isExpired: %b", new Object[] { Boolean.valueOf(bool) });
      GMTrace.o(787723845632L, 5869);
      return bool;
    }
  }
  
  public static a bCI()
  {
    GMTrace.i(787321192448L, 5866);
    ap.yY();
    Object localObject = (String)c.vr().get(352273, "");
    if (!bf.mA((String)localObject))
    {
      localObject = new a((String)localObject);
      if ((!((a)localObject).isValid()) || (((a)localObject).bAI()))
      {
        bCJ();
        GMTrace.o(787321192448L, 5866);
        return null;
      }
    }
    else
    {
      GMTrace.o(787321192448L, 5866);
      return null;
    }
    GMTrace.o(787321192448L, 5866);
    return (a)localObject;
  }
  
  public static void bCJ()
  {
    GMTrace.i(787858063360L, 5870);
    ap.yY();
    c.vr().set(352273, null);
    ap.yY();
    c.vr().set(352274, null);
    GMTrace.o(787858063360L, 5870);
  }
  
  private boolean isValid()
  {
    GMTrace.i(787589627904L, 5868);
    if ((this.fMU > d.sXh) && (!bf.mA(this.url)) && (!bf.mA(this.fFN)) && (!bf.mA(this.desc))) {}
    for (boolean bool = true;; bool = false)
    {
      v.i("MicroMsg.AlphaUpdateInfo", "isValid %b", new Object[] { Boolean.valueOf(bool) });
      GMTrace.o(787589627904L, 5868);
      return bool;
    }
  }
  
  public final void bCK()
  {
    GMTrace.i(787992281088L, 5871);
    au localau = new au();
    localau.z(ay.i("weixin", bf.Nz()));
    localau.setType(1);
    localau.setContent(this.desc);
    v.d("MicroMsg.AlphaUpdateInfo", localau.field_content);
    localau.dw(0);
    localau.cH("weixin");
    localau.dv(3);
    ay.i(localau);
    v.i("MicroMsg.AlphaUpdateInfo", "insertUpdateTextMsg");
    bCJ();
    GMTrace.o(787992281088L, 5871);
  }
  
  public final void bCL()
  {
    GMTrace.i(788126498816L, 5872);
    v.i("MicroMsg.AlphaUpdateInfo", "downloadInSilence.");
    if ((!isValid()) || (bAI()))
    {
      GMTrace.o(788126498816L, 5872);
      return;
    }
    int i;
    if (bf.PX(g.sV().getValue("SilentDownloadApkAtWiFi")) != 0) {
      i = 0;
    }
    while (i == 0)
    {
      bCK();
      GMTrace.o(788126498816L, 5872);
      return;
      ap.yY();
      if ((((Integer)c.vr().get(7, Integer.valueOf(0))).intValue() & 0x1000000) == 0)
      {
        i = 1;
        label105:
        if ((!al.isWifi(aa.getContext())) || (i == 0)) {
          break label146;
        }
      }
      label146:
      for (i = 1;; i = 0)
      {
        if ((f.fuP & 0x1) == 0) {
          break label151;
        }
        v.d("MicroMsg.AlphaUpdateInfo", "channel pack, not silence download.");
        i = 0;
        break;
        i = 0;
        break label105;
      }
      label151:
      v.d("MicroMsg.AlphaUpdateInfo", "not channel pack.");
    }
    v.i("MicroMsg.AlphaUpdateInfo", "go to download, %s, %d, %s, %s", new Object[] { this.fFN, Integer.valueOf(this.size), this.desc, this.url });
    l.y.bCk().d(this.fFN, this.size, this.desc.replaceFirst("(\n)*<a.*</a>(\n)*", "\n"), this.url);
    GMTrace.o(788126498816L, 5872);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */