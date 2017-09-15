package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.qp;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.widget.MMTextView;

final class df
  implements View.OnClickListener
{
  public En_5b8fbb1e.a vAn;
  
  public df(En_5b8fbb1e.a parama)
  {
    GMTrace.i(2177951072256L, 16227);
    this.vAn = parama;
    GMTrace.o(2177951072256L, 16227);
  }
  
  public final void onClick(View paramView)
  {
    GMTrace.i(2178085289984L, 16228);
    v.d("MicroMsg.ChattingTranslateClickListener", "tranlsate view clicked");
    if (!(paramView instanceof ChattingTranslateView))
    {
      GMTrace.o(2178085289984L, 16228);
      return;
    }
    Object localObject = (ChattingTranslateView)paramView;
    if (((ChattingTranslateView)localObject).vFQ == ChattingTranslateView.a.vFT) {}
    for (int i = 1; i != 0; i = 0)
    {
      GMTrace.o(2178085289984L, 16228);
      return;
    }
    MMTextView localMMTextView = (MMTextView)paramView.getTag();
    if (localMMTextView == null)
    {
      GMTrace.o(2178085289984L, 16228);
      return;
    }
    paramView = (ds)localMMTextView.getTag();
    boolean bool = paramView.fTa.bMi();
    if (((ChattingTranslateView)localObject).vFQ == ChattingTranslateView.a.vFU) {}
    for (i = 1; i != 0; i = 0)
    {
      ((ChattingTranslateView)localObject).bUE();
      this.vAn.a(paramView.fTa.field_msgId, ChattingTranslateView.a.vFS);
      localMMTextView.setText(paramView.fTa.field_content);
      h.d(localMMTextView, 1);
      GMTrace.o(2178085289984L, 16228);
      return;
    }
    if (((ChattingTranslateView)localObject).vFQ == ChattingTranslateView.a.vFS) {
      i = 1;
    }
    while (i != 0) {
      if (bool)
      {
        ((ChattingTranslateView)localObject).Tw(paramView.fTa.field_transBrandWording);
        this.vAn.a(paramView.fTa.field_msgId, ChattingTranslateView.a.vFU);
        localMMTextView.setText(paramView.fTa.field_transContent);
        h.d(localMMTextView, 1);
        GMTrace.o(2178085289984L, 16228);
        return;
        i = 0;
      }
      else
      {
        ((ChattingTranslateView)localObject).bUF();
        localObject = new qp();
        ((qp)localObject).fXx.fXz = false;
        ((qp)localObject).fXx.id = paramView.fTa.field_msgId;
        ((qp)localObject).fXx.fXy = paramView.fTa.field_content;
        ((qp)localObject).fXx.type = 0;
        a.uql.m((b)localObject);
        this.vAn.a(paramView.fTa.field_msgId, ChattingTranslateView.a.vFT);
      }
    }
    GMTrace.o(2178085289984L, 16228);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */