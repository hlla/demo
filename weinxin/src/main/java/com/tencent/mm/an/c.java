package com.tencent.mm.an;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.chatroom.c.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import java.util.LinkedList;
import java.util.Map;

public final class c
  extends a
{
  public String fGM;
  public String hMM;
  public LinkedList<String> hMN;
  public int hMP;
  public LinkedList<String> hMQ;
  public LinkedList<String> hMR;
  public String hMS;
  public String hMT;
  public String hMU;
  public String text;
  
  public c(Map<String, String> paramMap, au paramau)
  {
    super(paramMap, paramau);
    GMTrace.i(315277443072L, 2349);
    this.hMN = new LinkedList();
    this.hMQ = new LinkedList();
    this.hMR = new LinkedList();
    this.hMS = null;
    this.hMT = null;
    this.hMU = null;
    this.text = null;
    GMTrace.o(315277443072L, 2349);
  }
  
  protected final boolean HV()
  {
    int i = 0;
    GMTrace.i(315411660800L, 2350);
    if (this.values == null)
    {
      v.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] values == null ");
      GMTrace.o(315411660800L, 2350);
      return false;
    }
    v.i("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bf.mz(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bf.mA(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")))
    {
      this.hMM = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.RoomName"));
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text")) {
        this.hMU = bf.mz((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername")) {
        this.hMS = bf.mz((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason")) {
        this.hMT = bf.mz((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason"));
      }
      if (this.values.containsKey(hME)) {
        this.text = bf.mz((String)this.values.get(hME));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket")) {
        this.fGM = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize")) {
        this.hMP = bf.getInt((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize"), 0);
      }
      if (!this.fTa.bMp())
      {
        this.hMJ.add(Integer.valueOf(this.text.length()));
        this.hMI.add(this.hMU);
        this.hMG = (this.text + this.hMU);
        this.hMK.add(Integer.valueOf(this.hMG.length()));
        if (i >= this.hMP) {
          break label773;
        }
        if (i != 0) {
          break label638;
        }
        this.hMN.add(bf.mz((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.username")));
        this.hMQ.add(bf.mz((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.nickname")));
        this.hMR.add(bf.mz((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.headimgurl")));
      }
      for (;;)
      {
        i += 1;
        break;
        this.hMI.clear();
        this.hMJ.clear();
        this.hMK.clear();
        this.hMG = (this.text + " ");
        this.hMJ.add(Integer.valueOf(this.hMG.length()));
        this.hMI.add(aa.getContext().getString(c.a.esc));
        this.hMG += aa.getContext().getString(c.a.esc);
        this.hMK.add(Integer.valueOf(this.hMG.length()));
        break;
        label638:
        this.hMN.add(bf.mz((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".username")));
        this.hMQ.add(bf.mz((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".nickname")));
        this.hMR.add(bf.mz((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".headimgurl")));
      }
      label773:
      GMTrace.o(315411660800L, 2350);
      return true;
    }
    v.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type err :%s", new Object[] { bf.mz(this.TYPE) });
    GMTrace.o(315411660800L, 2350);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/an/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */