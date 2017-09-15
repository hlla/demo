package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ag.a;
import com.tencent.mm.u.ag.f;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import junit.framework.Assert;

public final class e
  implements AdapterView.OnItemClickListener
{
  private Activity activity;
  private g vZM;
  private ListView vZj;
  
  public e(g paramg, ListView paramListView, Activity paramActivity)
  {
    GMTrace.i(14482092851200L, 107900);
    this.vZM = paramg;
    this.vZj = paramListView;
    this.activity = paramActivity;
    GMTrace.o(14482092851200L, 107900);
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    GMTrace.i(14482227068928L, 107901);
    if (paramInt < this.vZj.getHeaderViewsCount())
    {
      GMTrace.o(14482227068928L, 107901);
      return;
    }
    paramInt -= this.vZj.getHeaderViewsCount();
    paramAdapterView = (ae)this.vZM.yL(paramInt);
    if (paramAdapterView == null)
    {
      v.e("MicroMsg.ConversationClickListener", "null user at position = " + paramInt);
      GMTrace.o(14482227068928L, 107901);
      return;
    }
    if (o.fa(paramAdapterView.field_username)) {
      if (m.yd())
      {
        d.w(this.activity, "tmessage", ".ui.TConversationUI");
        paramInt = 0;
        if (paramInt != 0)
        {
          f.rU(9);
          paramView = (LauncherUI)this.activity;
          if (paramView == null) {
            break label1061;
          }
        }
      }
    }
    label1056:
    label1061:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("Launcher should not be empty.", bool);
      paramView.a(paramAdapterView.field_username, null, true);
      GMTrace.o(14482227068928L, 107901);
      return;
      d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
      paramInt = 0;
      break;
      if (o.fb(paramAdapterView.field_username))
      {
        if (m.yc())
        {
          d.w(this.activity, "bottle", ".ui.BottleConversationUI");
          paramInt = 0;
          break;
        }
        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
        paramInt = 0;
        break;
      }
      if (o.fg(paramAdapterView.field_username))
      {
        MMAppMgr.cancelNotification(paramAdapterView.field_username);
        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
        paramInt = 0;
        break;
      }
      if (o.eY(paramAdapterView.field_username))
      {
        h.vJ();
        if (bf.f((Integer)h.vI().vr().get(17, null)) == 1) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt != 0) {
            break label1056;
          }
          d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
          paramInt = 0;
          break;
        }
      }
      if (o.fl(paramAdapterView.field_username))
      {
        if (m.yi())
        {
          paramView = new Intent();
          paramView.addFlags(67108864);
          paramView.putExtra("type", 20);
          d.b(this.activity, "readerapp", ".ui.ReaderAppUI", paramView);
          paramInt = 0;
          break;
        }
        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
        paramInt = 0;
        break;
      }
      if (o.ft(paramAdapterView.field_username))
      {
        if (m.yj())
        {
          paramView = new Intent();
          paramView.addFlags(67108864);
          paramView.putExtra("type", 11);
          d.b(this.activity, "readerapp", ".ui.ReaderAppUI", paramView);
          paramInt = 0;
          break;
        }
        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
        paramInt = 0;
        break;
      }
      if (o.fd(paramAdapterView.field_username))
      {
        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
        paramInt = 0;
        break;
      }
      if (o.fe(paramAdapterView.field_username))
      {
        if (m.yl())
        {
          paramView = new Intent().addFlags(67108864);
          d.b(this.activity, "masssend", ".ui.MassSendHistoryUI", paramView);
          paramInt = 0;
          break;
        }
        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAdapterView.field_username));
        paramInt = 0;
        break;
      }
      if (o.fs(paramAdapterView.field_username))
      {
        if (ag.a.hlD != null) {
          ag.a.hlD.gd(paramAdapterView.field_username);
        }
        paramInt = 1;
        break;
      }
      if (o.fu(paramAdapterView.field_username))
      {
        this.activity.startActivity(new Intent(this.activity, BizConversationUI.class));
        paramInt = 0;
        break;
      }
      if ((o.eV(paramAdapterView.field_username)) && (com.tencent.mm.modelbiz.e.ib(paramAdapterView.field_username)))
      {
        if (!o.eU(paramAdapterView.field_username))
        {
          com.tencent.mm.ui.base.g.bk(this.activity, this.activity.getString(R.l.eeH));
          GMTrace.o(14482227068928L, 107901);
          return;
        }
        paramView = new Intent(this.activity, EnterpriseConversationUI.class);
        paramView.putExtra("enterprise_biz_name", paramAdapterView.field_username);
        paramView.putExtra("enterprise_biz_display_name", n.eK(paramAdapterView.field_username));
        paramView.putExtra("enterprise_from_scene", 1);
        this.activity.startActivity(paramView);
        paramInt = 0;
        break;
      }
      if ((o.eV(paramAdapterView.field_username)) && (com.tencent.mm.modelbiz.e.dr(paramAdapterView.field_username)))
      {
        if (!o.eU(paramAdapterView.field_username))
        {
          com.tencent.mm.ui.base.g.bk(this.activity, this.activity.getString(R.l.eeH));
          GMTrace.o(14482227068928L, 107901);
          return;
        }
        paramView = new Intent(this.activity, BizChatConversationUI.class);
        paramView.putExtra("Contact_User", paramAdapterView.field_username);
        paramView.putExtra("biz_chat_from_scene", 1);
        paramView.addFlags(67108864);
        this.activity.startActivity(paramView);
        paramInt = 0;
        break;
      }
      if (o.fD(paramAdapterView.field_username))
      {
        paramView = new Intent();
        paramView.setClassName(this.activity, "com.tencent.mm.ui.conversation.AppBrandServiceConversationUI");
        paramView.putExtra("Contact_User", paramAdapterView.field_username);
        paramView.putExtra("app_brand_conversation_from_scene", 1);
        paramView.addFlags(67108864);
        this.activity.startActivity(paramView);
        paramInt = 0;
        break;
      }
      paramInt = 1;
      break;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */