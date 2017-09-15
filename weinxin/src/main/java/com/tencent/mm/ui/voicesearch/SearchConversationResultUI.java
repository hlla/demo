package com.tencent.mm.ui.voicesearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ae;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.k.a;
import com.tencent.mm.ui.l;
import java.util.LinkedList;

public class SearchConversationResultUI
  extends MMActivity
{
  private String username;
  private ListView wpN;
  private a wpO;
  private String wpP;
  private TextView wpQ;
  
  public SearchConversationResultUI()
  {
    GMTrace.i(2844073656320L, 21190);
    this.wpP = null;
    GMTrace.o(2844073656320L, 21190);
  }
  
  protected final void KD()
  {
    GMTrace.i(2844342091776L, 21192);
    this.wpN = ((ListView)findViewById(R.h.cNs));
    this.wpQ = ((TextView)findViewById(R.h.bLY));
    this.wpO = new a(getApplicationContext(), new k.a()
    {
      public final void OI()
      {
        GMTrace.i(2848234405888L, 21221);
        GMTrace.o(2848234405888L, 21221);
      }
      
      public final void OJ()
      {
        GMTrace.i(2848100188160L, 21220);
        GMTrace.o(2848100188160L, 21220);
      }
    });
    if (this.wpO != null) {
      this.wpO.cK(new LinkedList());
    }
    this.wpN.setAdapter(this.wpO);
    this.wpQ.setVisibility(8);
    this.username = getIntent().getStringExtra("SearchConversationResult_User");
    this.wpP = getIntent().getStringExtra("SearchConversationResult_Error");
    qL(getString(R.l.dpy));
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(2845818486784L, 21203);
        SearchConversationResultUI.this.finish();
        GMTrace.o(2845818486784L, 21203);
        return true;
      }
    });
    this.wpN.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(2833202020352L, 21109);
        if (paramAnonymousInt < SearchConversationResultUI.a(SearchConversationResultUI.this).getHeaderViewsCount())
        {
          GMTrace.o(2833202020352L, 21109);
          return;
        }
        paramAnonymousInt -= SearchConversationResultUI.a(SearchConversationResultUI.this).getHeaderViewsCount();
        paramAnonymousAdapterView = (ae)SearchConversationResultUI.b(SearchConversationResultUI.this).getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          v.e("MicroMsg.VoiceSearchResultUI", "null user at position = " + paramAnonymousInt);
          GMTrace.o(2833202020352L, 21109);
          return;
        }
        v.d("MicroMsg.VoiceSearchResultUI", "username " + paramAnonymousAdapterView.field_username);
        if (o.fa(paramAnonymousAdapterView.field_username))
        {
          if (m.ye())
          {
            paramAnonymousAdapterView = new Intent().putExtra("finish_direct", true);
            d.b(SearchConversationResultUI.this.uRf.uRz, "tmessage", ".ui.TConversationUI", paramAnonymousAdapterView);
            GMTrace.o(2833202020352L, 21109);
            return;
          }
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          GMTrace.o(2833202020352L, 21109);
          return;
        }
        if (o.fc(paramAnonymousAdapterView.field_username))
        {
          if (m.yb())
          {
            paramAnonymousAdapterView = new Intent().putExtra("finish_direct", true);
            d.b(SearchConversationResultUI.this.uRf.uRz, "qmessage", ".ui.QConversationUI", paramAnonymousAdapterView);
            GMTrace.o(2833202020352L, 21109);
            return;
          }
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          GMTrace.o(2833202020352L, 21109);
          return;
        }
        if (o.fb(paramAnonymousAdapterView.field_username))
        {
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          GMTrace.o(2833202020352L, 21109);
          return;
        }
        if (o.fg(paramAnonymousAdapterView.field_username))
        {
          MMAppMgr.cancelNotification(paramAnonymousAdapterView.field_username);
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          GMTrace.o(2833202020352L, 21109);
          return;
        }
        if (o.eY(paramAnonymousAdapterView.field_username))
        {
          if (m.yn())
          {
            SearchConversationResultUI.a(SearchConversationResultUI.this, En_5b8fbb1e.class, new Intent().putExtra("Chat_User", paramAnonymousAdapterView.field_username).putExtra("finish_direct", true));
            GMTrace.o(2833202020352L, 21109);
            return;
          }
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          GMTrace.o(2833202020352L, 21109);
          return;
        }
        if (o.fl(paramAnonymousAdapterView.field_username))
        {
          if (m.yi())
          {
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("type", 20);
            d.b(SearchConversationResultUI.this, "readerapp", ".ui.ReaderAppUI", paramAnonymousAdapterView);
            GMTrace.o(2833202020352L, 21109);
            return;
          }
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          GMTrace.o(2833202020352L, 21109);
          return;
        }
        if (o.ft(paramAnonymousAdapterView.field_username))
        {
          if (m.yj())
          {
            paramAnonymousAdapterView = new Intent();
            paramAnonymousAdapterView.putExtra("type", 11);
            d.b(SearchConversationResultUI.this, "readerapp", ".ui.ReaderAppUI", paramAnonymousAdapterView);
            GMTrace.o(2833202020352L, 21109);
            return;
          }
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          GMTrace.o(2833202020352L, 21109);
          return;
        }
        if (o.fd(paramAnonymousAdapterView.field_username))
        {
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          GMTrace.o(2833202020352L, 21109);
          return;
        }
        if (o.fe(paramAnonymousAdapterView.field_username))
        {
          if (m.yl())
          {
            paramAnonymousAdapterView = new Intent().putExtra("finish_direct", true);
            d.b(SearchConversationResultUI.this, "masssend", ".ui.MassSendHistoryUI", paramAnonymousAdapterView);
            GMTrace.o(2833202020352L, 21109);
            return;
          }
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          GMTrace.o(2833202020352L, 21109);
          return;
        }
        if (o.fk(paramAnonymousAdapterView.field_username))
        {
          if (m.yf())
          {
            SearchConversationResultUI.b(SearchConversationResultUI.this, En_5b8fbb1e.class, new Intent().putExtra("Chat_User", paramAnonymousAdapterView.field_username).putExtra("finish_direct", true));
            GMTrace.o(2833202020352L, 21109);
            return;
          }
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          GMTrace.o(2833202020352L, 21109);
          return;
        }
        if ((o.fi(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (o.fj(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (o.ff(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (o.fm(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (o.fn(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (o.eZ(SearchConversationResultUI.c(SearchConversationResultUI.this))) || (o.fw(SearchConversationResultUI.c(SearchConversationResultUI.this))))
        {
          d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousAdapterView.field_username));
          GMTrace.o(2833202020352L, 21109);
          return;
        }
        SearchConversationResultUI.c(SearchConversationResultUI.this, En_5b8fbb1e.class, new Intent().putExtra("Chat_User", paramAnonymousAdapterView.field_username).putExtra("finish_direct", true));
        GMTrace.o(2833202020352L, 21109);
      }
    });
    String str = this.username;
    this.wpQ.setVisibility(8);
    if (this.wpO != null) {
      this.wpO.yB(str);
    }
    GMTrace.o(2844342091776L, 21192);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2844744744960L, 21195);
    int i = R.i.dpy;
    GMTrace.o(2844744744960L, 21195);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2844207874048L, 21191);
    super.onCreate(paramBundle);
    KD();
    GMTrace.o(2844207874048L, 21191);
  }
  
  public void onDestroy()
  {
    GMTrace.i(2844476309504L, 21193);
    super.onDestroy();
    this.wpO.aEP();
    GMTrace.o(2844476309504L, 21193);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2844610527232L, 21194);
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2844610527232L, 21194);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/voicesearch/SearchConversationResultUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */