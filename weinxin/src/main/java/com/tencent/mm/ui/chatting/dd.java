package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.e;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.s;
import java.io.FileInputStream;

public final class dd
  implements j
{
  private Context context;
  private x jht;
  private boolean vFD;
  private boolean vFE;
  private String vzP;
  
  public dd(Context paramContext, x paramx, String paramString)
  {
    GMTrace.i(2115808264192L, 15764);
    this.vFD = true;
    this.vFE = true;
    this.context = paramContext;
    this.jht = paramx;
    this.vzP = paramString;
    if (x.eO(this.vzP)) {
      this.vFE = false;
    }
    if (x.QN(this.vzP)) {
      this.vFD = false;
    }
    if (x.QL(this.vzP)) {
      this.vFD = false;
    }
    if ((this.jht != null) && (x.eO(this.jht.field_username))) {
      paramContext = this.vzP;
    }
    for (;;)
    {
      if (o.eQ(paramContext)) {
        this.vFE = false;
      }
      GMTrace.o(2115808264192L, 15764);
      return;
      if (this.jht == null) {
        paramContext = null;
      } else {
        paramContext = this.jht.field_username;
      }
    }
  }
  
  public final boolean aJL()
  {
    GMTrace.i(2116210917376L, 15767);
    boolean bool = this.vFE;
    GMTrace.o(2116210917376L, 15767);
    return bool;
  }
  
  public final boolean aJM()
  {
    GMTrace.i(2116345135104L, 15768);
    boolean bool = this.vFD;
    GMTrace.o(2116345135104L, 15768);
    return bool;
  }
  
  public final void aJN()
  {
    GMTrace.i(2116479352832L, 15769);
    GMTrace.o(2116479352832L, 15769);
  }
  
  public final void n(com.tencent.mm.storage.a.c paramc)
  {
    GMTrace.i(2115942481920L, 15765);
    ap.yY();
    if (!com.tencent.mm.u.c.isSDCardAvailable())
    {
      s.eP(this.context);
      GMTrace.o(2115942481920L, 15765);
      return;
    }
    if (paramc == null)
    {
      GMTrace.o(2115942481920L, 15765);
      return;
    }
    if ((this.jht.field_username.equals("medianote")) && ((m.xP() & 0x4000) == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramc.field_start = 0;
      paramc.field_state = com.tencent.mm.storage.a.c.uJr;
      ((com.tencent.mm.plugin.emoji.b.c)h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().d(paramc);
      localObject = new au();
      ((au)localObject).setType(47);
      ((au)localObject).cH("medianote");
      ((au)localObject).dw(1);
      if (paramc.bCM()) {
        ((au)localObject).setContent(aj.a(m.xL(), 0L, false, paramc.EQ(), false, ""));
      }
      ((au)localObject).cI(paramc.EQ());
      ((au)localObject).z(ay.gk(((ce)localObject).field_talker));
      ((au)localObject).dv(2);
      ap.yY();
      com.tencent.mm.u.c.wT().L((au)localObject);
      GMTrace.o(2115942481920L, 15765);
      return;
    }
    d locald = ((com.tencent.mm.plugin.emoji.b.c)h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr();
    if (bf.mA(this.vzP)) {}
    for (Object localObject = this.jht.field_username;; localObject = this.vzP)
    {
      locald.a((String)localObject, paramc, null);
      GMTrace.o(2115942481920L, 15765);
      return;
    }
  }
  
  public final void o(com.tencent.mm.storage.a.c paramc)
  {
    GMTrace.i(2116076699648L, 15766);
    ap.yY();
    if (!com.tencent.mm.u.c.isSDCardAvailable())
    {
      s.eP(this.context);
      GMTrace.o(2116076699648L, 15766);
      return;
    }
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    Object localObject = new StringBuilder();
    ap.yY();
    localObject = com.tencent.mm.u.c.xi() + paramc.EQ();
    if (e.aO((String)localObject + "_thumb"))
    {
      int i = e.aN((String)localObject + "_thumb");
      localWXMediaMessage.thumbData = e.c((String)localObject + "_thumb", 0, i);
    }
    for (;;)
    {
      localWXMediaMessage.mediaObject = new WXEmojiObject((String)localObject);
      l.a(localWXMediaMessage, paramc.field_app_id, null, this.vzP, 1, paramc.EQ());
      GMTrace.o(2116076699648L, 15766);
      return;
      try
      {
        FileInputStream localFileInputStream = new FileInputStream((String)localObject);
        localWXMediaMessage.setThumbImage(BackwardSupportUtil.b.a(localFileInputStream, 1.0F));
        localFileInputStream.close();
      }
      catch (Exception localException)
      {
        v.printErrStackTrace("MicroMsg.ChattingSmileyPanelImpl", localException, "", new Object[0]);
        v.e("MicroMsg.ChattingSmileyPanelImpl", "sendAppMsgEmoji Fail cause there is no thumb");
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */