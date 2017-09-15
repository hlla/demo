package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.i;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.cg;
import com.tencent.mm.i.e;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;

public final class i
  extends b
{
  public int gkl;
  private c uNK;
  public View wde;
  
  public i(final Context paramContext)
  {
    super(paramContext);
    GMTrace.i(14512560275456L, 108127);
    this.wde = View.inflate(paramContext, R.i.dfE, null);
    if (this.wde == null)
    {
      GMTrace.o(14512560275456L, 108127);
      return;
    }
    this.gkl = u.getInt(com.tencent.mm.i.g.sV().getValue("InviteFriendsControlFlags"), 0);
    this.wde.setVisibility(8);
    this.wde.setPadding(0, -com.tencent.mm.bg.a.fromDPToPix(paramContext, R.f.aXF), 0, 0);
    if ((this.gkl & 0x1) > 0)
    {
      this.wde.setVisibility(0);
      this.wde.setPadding(0, 0, 0, 0);
    }
    this.wde.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(14508265308160L, 108095);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("Invite_friends", 1);
        d.b(paramContext, "subapp", ".ui.pluginapp.InviteFriendsBy3rdUI", paramAnonymousView);
        com.tencent.mm.plugin.report.service.g.oSF.i(14034, new Object[] { Integer.valueOf(1) });
        GMTrace.o(14508265308160L, 108095);
      }
    });
    this.uNK = new c() {};
    GMTrace.o(14512560275456L, 108127);
  }
  
  public final boolean Xd()
  {
    GMTrace.i(14512828710912L, 108129);
    com.tencent.mm.sdk.b.a.uql.b(this.uNK);
    if ((this.wde != null) && (this.wde.getVisibility() == 0))
    {
      GMTrace.o(14512828710912L, 108129);
      return true;
    }
    GMTrace.o(14512828710912L, 108129);
    return false;
  }
  
  public final void destroy()
  {
    GMTrace.i(14513097146368L, 108131);
    GMTrace.o(14513097146368L, 108131);
  }
  
  public final int getLayoutId()
  {
    GMTrace.i(14512694493184L, 108128);
    GMTrace.o(14512694493184L, 108128);
    return -1;
  }
  
  public final View getView()
  {
    GMTrace.i(14513231364096L, 108132);
    View localView = this.wde;
    GMTrace.o(14513231364096L, 108132);
    return localView;
  }
  
  public final void release()
  {
    GMTrace.i(14512962928640L, 108130);
    com.tencent.mm.sdk.b.a.uql.c(this.uNK);
    GMTrace.o(14512962928640L, 108130);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */