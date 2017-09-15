package com.tencent.mm.plugin.chatroom.d;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.afz;
import com.tencent.mm.protocal.c.aga;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k
  extends com.tencent.mm.y.k
  implements j
{
  public au fTa;
  private final b gUq;
  private com.tencent.mm.y.e gUt;
  public int krk;
  
  public k(String paramString, List<String> paramList)
  {
    GMTrace.i(9061441470464L, 67513);
    Object localObject = new b.a();
    ((b.a)localObject).hrV = new afz();
    ((b.a)localObject).hrW = new aga();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    ((b.a)localObject).hrU = 610;
    ((b.a)localObject).hrX = 0;
    ((b.a)localObject).hrY = 0;
    this.gUq = ((b.a)localObject).BE();
    localObject = (afz)this.gUq.hrS.hsa;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      ali localali = new ali();
      localali.trN = n.mw(str);
      localLinkedList.add(localali);
    }
    ((afz)localObject).tde = localLinkedList;
    ((afz)localObject).krk = localLinkedList.size();
    ((afz)localObject).tdf = n.mw(paramString);
    ((afz)localObject).tJw = 0;
    GMTrace.o(9061441470464L, 67513);
  }
  
  public k(String paramString1, List<String> paramList, String paramString2, au paramau)
  {
    GMTrace.i(9061575688192L, 67514);
    this.fTa = paramau;
    paramau = new b.a();
    paramau.hrV = new afz();
    paramau.hrW = new aga();
    paramau.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
    paramau.hrU = 610;
    paramau.hrX = 0;
    paramau.hrY = 0;
    this.gUq = paramau.BE();
    paramau = (afz)this.gUq.hrS.hsa;
    LinkedList localLinkedList = new LinkedList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      ali localali = new ali();
      localali.trN = n.mw(str);
      localLinkedList.add(localali);
    }
    this.krk = localLinkedList.size();
    paramau.tde = localLinkedList;
    paramau.krk = localLinkedList.size();
    paramau.tdf = n.mw(paramString1);
    paramau.tJw = 2;
    paramau.tJx = paramString2;
    GMTrace.o(9061575688192L, 67514);
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.y.e parame1)
  {
    GMTrace.i(9061709905920L, 67515);
    this.gUt = parame1;
    int i = a(parame, this.gUq, this);
    GMTrace.o(9061709905920L, 67515);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, p paramp, byte[] paramArrayOfByte)
  {
    GMTrace.i(9061978341376L, 67517);
    v.d("MicroMsg.NetSceneInviteChatRoomMember", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    this.gUt.a(paramInt2, paramInt3, paramString, this);
    GMTrace.o(9061978341376L, 67517);
  }
  
  public final int getType()
  {
    GMTrace.i(9061844123648L, 67516);
    GMTrace.o(9061844123648L, 67516);
    return 610;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/chatroom/d/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */