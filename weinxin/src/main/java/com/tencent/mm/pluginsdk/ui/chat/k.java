package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.gh;
import com.tencent.mm.e.a.mn;
import com.tencent.mm.e.a.px;
import com.tencent.mm.e.b.af;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class k
  implements View.OnClickListener
{
  private Context context;
  
  public k(Context paramContext)
  {
    GMTrace.i(996835065856L, 7427);
    this.context = paramContext;
    GMTrace.o(996835065856L, 7427);
  }
  
  public final void onClick(View paramView)
  {
    int j = 1;
    GMTrace.i(996969283584L, 7428);
    Object localObject = paramView.getTag();
    if ((localObject instanceof b))
    {
      localObject = (b)localObject;
      int i;
      if ((localObject == null) || (paramView == null))
      {
        v.w("MicroMsg.SourceClickListener", "localAppRedirectHandle: but info or v is null");
        i = 0;
      }
      for (;;)
      {
        if (i == 0)
        {
          paramView = p.e(this.context, ((b)localObject).appId, ((b)localObject).fTc);
          localObject = new px();
          ((px)localObject).fWN.fWO = paramView;
          ((px)localObject).fWN.context = this.context;
          com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
        }
        GMTrace.o(996969283584L, 7428);
        return;
        if ("wx7fa037cc7dfabad5".equals(((b)localObject).appId))
        {
          com.tencent.mm.plugin.sport.b.d.mJ(33);
          ap.yY();
          if (com.tencent.mm.j.a.ez(c.wR().Rb("gh_43f2581f6fd6").field_type))
          {
            paramView = new Intent();
            paramView.putExtra("Chat_User", "gh_43f2581f6fd6");
            paramView.putExtra("finish_direct", true);
            com.tencent.mm.bb.d.a(this.context, ".ui.chatting.En_5b8fbb1e", paramView);
            i = j;
          }
          else
          {
            paramView = new Intent();
            paramView.putExtra("Contact_User", "gh_43f2581f6fd6");
            com.tencent.mm.bb.d.b(this.context, "profile", ".ui.ContactInfoUI", paramView);
            i = j;
          }
        }
        else if ("wx485a97c844086dc9".equals(((b)localObject).appId))
        {
          paramView = new Intent();
          paramView.putExtra("shake_music", true);
          com.tencent.mm.bb.d.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
          i = j;
        }
        else if ("wxfbc915ff7c30e335".equals(((b)localObject).appId))
        {
          i = j;
          if (!com.tencent.mm.ai.b.Hp())
          {
            paramView = new Intent();
            paramView.putExtra("BaseScanUI_select_scan_mode", 1);
            i = j;
            if (!com.tencent.mm.n.a.aI(this.context))
            {
              i = j;
              if (!com.tencent.mm.n.a.aH(this.context))
              {
                com.tencent.mm.bb.d.b(this.context, "scanner", ".ui.BaseScanUI", paramView);
                i = j;
              }
            }
          }
        }
        else if ("wx482a4001c37e2b74".equals(((b)localObject).appId))
        {
          i = j;
          if (!com.tencent.mm.ai.b.Hp())
          {
            paramView = new Intent();
            paramView.putExtra("BaseScanUI_select_scan_mode", 2);
            i = j;
            if (!com.tencent.mm.n.a.aI(this.context))
            {
              i = j;
              if (!com.tencent.mm.n.a.aH(this.context))
              {
                com.tencent.mm.bb.d.b(this.context, "scanner", ".ui.BaseScanUI", paramView);
                i = j;
              }
            }
          }
        }
        else if ("wx751a1acca5688ba3".equals(((b)localObject).appId))
        {
          i = j;
          if (!com.tencent.mm.ai.b.Hp())
          {
            paramView = new Intent();
            paramView.putExtra("BaseScanUI_select_scan_mode", 5);
            i = j;
            if (!com.tencent.mm.n.a.aI(this.context))
            {
              i = j;
              if (!com.tencent.mm.n.a.aH(this.context))
              {
                com.tencent.mm.bb.d.b(this.context, "scanner", ".ui.BaseScanUI", paramView);
                i = j;
              }
            }
          }
        }
        else
        {
          if (!"wxaf060266bfa9a35c".equals(((b)localObject).appId)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("shake_tv", true);
          com.tencent.mm.bb.d.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
          i = j;
        }
      }
    }
    if ((localObject instanceof a))
    {
      paramView = (a)localObject;
      localObject = new gh();
      ((gh)localObject).fLs.actionCode = 2;
      ((gh)localObject).fLs.scene = paramView.scene;
      ((gh)localObject).fLs.extMsg = ("chatting_src=" + paramView.scene);
      ((gh)localObject).fLs.appId = paramView.appId;
      ((gh)localObject).fLs.context = this.context;
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
      localObject = new mn();
      ((mn)localObject).fTD.context = this.context;
      ((mn)localObject).fTD.scene = paramView.scene;
      ((mn)localObject).fTD.fTE = paramView.appId;
      ((mn)localObject).fTD.packageName = paramView.fwG;
      ((mn)localObject).fTD.msgType = paramView.sOQ;
      ((mn)localObject).fTD.fOl = paramView.fTz;
      ((mn)localObject).fTD.fTF = 5;
      ((mn)localObject).fTD.mediaTagName = paramView.sOR;
      ((mn)localObject).fTD.fTG = paramView.fTG;
      ((mn)localObject).fTD.fTH = "";
      com.tencent.mm.sdk.b.a.uql.m((com.tencent.mm.sdk.b.b)localObject);
    }
    GMTrace.o(996969283584L, 7428);
  }
  
  public static final class a
  {
    public String appId;
    public long fTG;
    public String fTc;
    public String fTz;
    public String fwG;
    public int sOQ;
    public String sOR;
    public int scene;
    
    public a()
    {
      GMTrace.i(1029047320576L, 7667);
      GMTrace.o(1029047320576L, 7667);
    }
  }
  
  public static final class b
  {
    public String appId;
    public String fTc;
    
    public b()
    {
      GMTrace.i(984352817152L, 7334);
      GMTrace.o(984352817152L, 7334);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/chat/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */