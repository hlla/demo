package com.tencent.mm.ui.chatting;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import java.util.Map;

final class dj
{
  public String fZv;
  public String hih;
  public String hkg;
  public String hkh;
  public String hki;
  public String hkj;
  public String hkk;
  public long time;
  public String title;
  public int type;
  public String url;
  
  dj()
  {
    GMTrace.i(2376727527424L, 17708);
    GMTrace.o(2376727527424L, 17708);
  }
  
  public static dj ai(Map<String, String> paramMap)
  {
    GMTrace.i(2376861745152L, 17709);
    dj localdj = new dj();
    localdj.title = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.title"));
    localdj.url = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.url"));
    localdj.fZv = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.native_url"));
    localdj.hkg = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.shorturl"));
    localdj.hkh = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.longurl"));
    localdj.time = bf.getLong((String)paramMap.get(".msg.appmsg.mmreader.category.item.pub_time"), 0L);
    localdj.hki = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.cover"));
    localdj.hkj = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.tweetid"));
    localdj.hkk = ((String)paramMap.get(".msg.appmsg.mmreader.category.item.digest"));
    localdj.type = bf.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
    localdj.hih = ((String)paramMap.get(".msg.appmsg.template_id"));
    GMTrace.o(2376861745152L, 17709);
    return localdj;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */