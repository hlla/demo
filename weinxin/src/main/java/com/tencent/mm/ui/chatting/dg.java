package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ai;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class dg
  implements ai
{
  final En_5b8fbb1e.a vFW;
  dm vFX;
  
  public dg(En_5b8fbb1e.a parama)
  {
    GMTrace.i(2151778615296L, 16032);
    this.vFW = parama;
    this.vFX = new dm();
    GMTrace.o(2151778615296L, 16032);
  }
  
  private void cA(List<au> paramList)
  {
    GMTrace.i(2152315486208L, 16036);
    if ((this.vFX != null) && (this.vFW != null)) {
      this.vFX.a(this.vFW.bOZ(), paramList);
    }
    GMTrace.o(2152315486208L, 16036);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
  {
    GMTrace.i(2152583921664L, 16038);
    GMTrace.o(2152583921664L, 16038);
  }
  
  public final void a(au paramau)
  {
    GMTrace.i(2151912833024L, 16033);
    if (this.vFW == null)
    {
      v.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui is null.");
      GMTrace.o(2151912833024L, 16033);
      return;
    }
    this.vFW.bTv();
    if ((!paramau.field_talker.equals(this.vFW.bTW())) || (!paramau.bMa()))
    {
      GMTrace.o(2151912833024L, 16033);
      return;
    }
    at(paramau);
    GMTrace.o(2151912833024L, 16033);
  }
  
  public final void at(au paramau)
  {
    GMTrace.i(2152181268480L, 16035);
    if (paramau == null)
    {
      GMTrace.o(2152181268480L, 16035);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramau);
    cA(localArrayList);
    GMTrace.o(2152181268480L, 16035);
  }
  
  public final Looper getLooper()
  {
    GMTrace.i(2152449703936L, 16037);
    Looper localLooper = Looper.getMainLooper();
    GMTrace.o(2152449703936L, 16037);
    return localLooper;
  }
  
  public final void p(List<au> paramList)
  {
    GMTrace.i(2152047050752L, 16034);
    if (this.vFW == null)
    {
      v.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui is null.");
      GMTrace.o(2152047050752L, 16034);
      return;
    }
    if (o.dH(this.vFW.bTW()))
    {
      GMTrace.o(2152047050752L, 16034);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      au localau = (au)paramList.next();
      if ((localau.field_talker.equals(this.vFW.bTW())) && (localau.bMa())) {
        localArrayList.add(localau);
      }
    }
    cA(localArrayList);
    GMTrace.o(2152047050752L, 16034);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/dg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */