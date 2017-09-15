package com.tencent.mm.plugin.card.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.o;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.t.f.a;
import java.util.Map;

public final class h
{
  public int his;
  public String hit;
  public String hiu;
  public String hiv;
  public String hiw;
  public String hix;
  public String hiy;
  public String hiz;
  public int ver;
  
  public h()
  {
    GMTrace.i(17256775942144L, 128573);
    GMTrace.o(17256775942144L, 128573);
  }
  
  public static h b(f.a parama)
  {
    GMTrace.i(17256910159872L, 128574);
    parama = parama.hjP;
    h localh = new h();
    localh.hit = bf.ap((String)parama.get(".msg.appmsg.giftcard_info.order_id"), "");
    localh.his = o.aY((String)parama.get(".msg.appmsg.giftcard_info.biz_uin"));
    localh.hiu = bf.ap((String)parama.get(".msg.appmsg.giftcard_info.app_name"), "");
    localh.hiv = bf.ap((String)parama.get(".msg.appmsg.giftcard_info.recv_digest"), "");
    localh.hiw = bf.ap((String)parama.get(".msg.appmsg.giftcard_info.send_digest"), "");
    localh.hix = bf.ap((String)parama.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
    localh.hiy = bf.ap((String)parama.get(".msg.appmsg.giftcard_info.title_color"), "");
    localh.hiz = bf.ap((String)parama.get(".msg.appmsg.giftcard_info.des_color"), "");
    localh.ver = o.aY((String)parama.get(".msg.appmsg.giftcard_info.ver"));
    GMTrace.o(17256910159872L, 128574);
    return localh;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/card/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */