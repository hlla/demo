package com.tencent.mm.an;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.chatroom.c.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class b
  extends a
{
  public String fGM;
  public String hMM;
  public LinkedList<String> hMN;
  public String hMO;
  public String text;
  
  public b(Map<String, String> paramMap, au paramau)
  {
    super(paramMap, paramau);
    GMTrace.i(315814313984L, 2353);
    this.hMN = new LinkedList();
    this.text = null;
    this.hMO = null;
    this.fGM = null;
    GMTrace.o(315814313984L, 2353);
  }
  
  protected final boolean HV()
  {
    GMTrace.i(315948531712L, 2354);
    if (this.values == null)
    {
      v.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] values == null ");
      GMTrace.o(315948531712L, 2354);
      return false;
    }
    v.i("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type:%s, values size:%s", new Object[] { bf.mz(this.TYPE), Integer.valueOf(this.values.size()) });
    if ((!bf.mA(this.TYPE)) && (this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")))
    {
      this.hMM = ((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.RoomName"));
      if (this.values.containsKey(hME)) {
        this.text = bf.mz((String)this.values.get(hME));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text")) {
        this.hMO = bf.mz((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.text"));
      }
      if (this.values.containsKey(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket")) {
        this.fGM = bf.mz((String)this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.ticket"));
      }
      this.hMG = this.text;
      if (!this.fTa.bMp())
      {
        this.hMI.add(this.hMO);
        this.hMJ.add(Integer.valueOf(this.hMG.length()));
        this.hMG += this.hMO;
        this.hMK.add(Integer.valueOf(this.hMG.length()));
      }
      for (;;)
      {
        Iterator localIterator = this.values.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (str.startsWith(".sysmsg.NewXmlChatRoomAccessVerifyApproval.link.memberlist.username")) {
            this.hMN.add(this.values.get(str));
          }
        }
        this.hMG = (this.hMG + " " + aa.getContext().getString(c.a.kqF));
      }
      GMTrace.o(315948531712L, 2354);
      return true;
    }
    v.e("MicroMsg.ChatroomAccessVerifyApprovalNewXmlMsg", "[parseXml] type err :%s", new Object[] { bf.mz(this.TYPE) });
    GMTrace.o(315948531712L, 2354);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/an/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */