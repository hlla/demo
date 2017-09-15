package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;

public final class de
{
  private LinearLayout kXu;
  private View.OnClickListener oOv;
  private FrameLayout vFF;
  private ChatFooterCustom vzH;
  
  public de(ChatFooterCustom paramChatFooterCustom)
  {
    GMTrace.i(2108560506880L, 15710);
    this.oOv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(2391625695232L, 17819);
        com.tencent.mm.plugin.sport.b.d.mJ(1);
        o.eW("gh_43f2581f6fd6");
        Intent localIntent = new Intent();
        localIntent.putExtra("key_is_latest", true);
        localIntent.putExtra("rank_id", "#");
        localIntent.putExtra("key_only_show_latest_rank", true);
        localIntent.putExtra("app_username", n.eK("gh_43f2581f6fd6"));
        localIntent.putExtra("device_type", 1);
        com.tencent.mm.bb.d.b(paramAnonymousView.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", localIntent);
        GMTrace.o(2391625695232L, 17819);
      }
    };
    this.vzH = paramChatFooterCustom;
    GMTrace.o(2108560506880L, 15710);
  }
  
  public final void bRW()
  {
    GMTrace.i(2108694724608L, 15711);
    v.i("MicroMsg.Sport.ChattingSportFooterHandler", "initFooter");
    this.vzH.findViewById(R.h.bAu).setVisibility(8);
    this.vzH.findViewById(R.h.bAp).setVisibility(8);
    this.kXu = ((LinearLayout)this.vzH.findViewById(R.h.bAq));
    this.kXu.setWeightSum(1.0F);
    this.vFF = ((FrameLayout)this.kXu.getChildAt(0));
    this.vFF.setVisibility(0);
    this.vFF.setOnClickListener(this.oOv);
    ((TextView)this.vFF.getChildAt(0).findViewById(R.h.bAs)).setText(R.l.egy);
    this.vFF.getChildAt(0).findViewById(R.h.bAr).setVisibility(8);
    this.vFF.getChildAt(1).setVisibility(8);
    int i = 1;
    while (i < 6)
    {
      this.kXu.getChildAt(i).setVisibility(8);
      i += 1;
    }
    GMTrace.o(2108694724608L, 15711);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */