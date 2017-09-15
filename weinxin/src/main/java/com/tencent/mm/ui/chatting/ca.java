package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.storage.au;

final class ca
  implements bz.a
{
  ca()
  {
    GMTrace.i(2506113417216L, 18672);
    GMTrace.o(2506113417216L, 18672);
  }
  
  public final void a(ag.a parama, int paramInt, En_5b8fbb1e.a parama1, au paramau)
  {
    GMTrace.i(2506247634944L, 18673);
    parama = (bz.b)parama;
    parama.stp.setText(paramau.field_content);
    Bundle localBundle = new Bundle();
    localBundle.putString("chatroom_name", parama1.bTW());
    localBundle.putLong("msg_id", paramau.field_msgId);
    if ((paramau.field_flag & 0x8) != 0)
    {
      h.a(parama.stp, 1, false, localBundle);
      parama.stp.setClickable(true);
    }
    for (;;)
    {
      parama.stp.invalidate();
      GMTrace.o(2506247634944L, 18673);
      return;
      h.a(parama.stp, localBundle);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */