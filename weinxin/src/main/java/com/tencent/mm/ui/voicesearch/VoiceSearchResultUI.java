package com.tencent.mm.ui.voicesearch;

import android.content.Intent;
import android.database.Cursor;
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
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bh;
import com.tencent.mm.u.bi;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.ui.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VoiceSearchResultUI
  extends MMActivity
{
  private int hND;
  private int lpR;
  int showType;
  private ListView wpN;
  private String wpP;
  private TextView wpQ;
  private b wqb;
  private String[] wqc;
  private boolean wqd;
  boolean wqe;
  
  public VoiceSearchResultUI()
  {
    GMTrace.i(2839510253568L, 21156);
    this.wpP = null;
    this.lpR = -1;
    this.showType = 1;
    this.hND = 2;
    this.wqd = false;
    this.wqe = false;
    GMTrace.o(2839510253568L, 21156);
  }
  
  private static String[] H(String[] paramArrayOfString)
  {
    GMTrace.i(2839912906752L, 21159);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      GMTrace.o(2839912906752L, 21159);
      return paramArrayOfString;
    }
    v.d("MicroMsg.VoiceSearchResultUI", "oldlist.length " + paramArrayOfString.length);
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str1 = paramArrayOfString[i];
      String str2 = n.eK(str1);
      v.d("MicroMsg.VoiceSearchResultUI", "displayname " + str2);
      if ((!localHashMap.containsValue(str2)) || (!o.dH(str1)))
      {
        v.d("MicroMsg.VoiceSearchResultUI", "username " + str1);
        localHashMap.put(str2, str1);
        localArrayList.add(str1);
      }
      i += 1;
    }
    paramArrayOfString = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    GMTrace.o(2839912906752L, 21159);
    return paramArrayOfString;
  }
  
  private void I(String[] paramArrayOfString)
  {
    GMTrace.i(2840583995392L, 21164);
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayOfString != null) && (this.wqb != null))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = paramArrayOfString[i];
        if (this.wqb.Uu(str)) {
          localArrayList.add(str);
        }
        i += 1;
      }
    }
    if (localArrayList.size() == 0)
    {
      this.wpQ.setVisibility(0);
      if (this.wpP != null) {
        this.wpQ.setText(this.wpP);
      }
    }
    for (;;)
    {
      if (this.wqb != null) {
        this.wqb.cW(localArrayList);
      }
      GMTrace.o(2840583995392L, 21164);
      return;
      this.wpQ.setText(getString(R.l.dCq));
      continue;
      this.wpQ.setVisibility(8);
    }
  }
  
  static boolean Uv(String paramString)
  {
    GMTrace.i(2840449777664L, 21163);
    Cursor[] arrayOfCursor = new Cursor[2];
    arrayOfCursor[0] = ap.yY().hks.a(o.hkZ, null, paramString);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    try
    {
      while (arrayOfCursor[0].moveToNext())
      {
        String str = arrayOfCursor[0].getString(arrayOfCursor[0].getColumnIndex("username"));
        localArrayList1.add(str);
        if (!str.endsWith("@chatroom")) {
          localArrayList2.add(str);
        }
        v.d("MicroMsg.VoiceSearchResultUI", "block user " + str);
      }
      int i;
      int j;
      return false;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.VoiceSearchResultUI", localException, "", new Object[0]);
      arrayOfCursor[1] = ap.yY().hkt.a(paramString, "@micromsg.with.all.biz.qq.com", localArrayList1, localArrayList2);
      i = arrayOfCursor[1].getCount();
      j = arrayOfCursor[0].getCount();
      arrayOfCursor[0].close();
      arrayOfCursor[1].close();
      v.d("MicroMsg.VoiceSearchResultUI", "contactCount " + i + " conversationCount " + j);
      if (i + j <= 1)
      {
        GMTrace.o(2840449777664L, 21163);
        return true;
      }
      GMTrace.o(2840449777664L, 21163);
    }
  }
  
  protected final void KD()
  {
    GMTrace.i(2839778689024L, 21158);
    this.wpN = ((ListView)findViewById(R.h.cNs));
    this.wpQ = ((TextView)findViewById(R.h.bLY));
    this.wqc = getIntent().getStringArrayExtra("VoiceSearchResultUI_Resultlist");
    this.wpP = getIntent().getStringExtra("VoiceSearchResultUI_Error");
    this.lpR = getIntent().getIntExtra("VoiceSearchResultUI_VoiceId", -1);
    this.showType = getIntent().getIntExtra("VoiceSearchResultUI_ShowType", 1);
    int i;
    LinkedList localLinkedList;
    if (this.showType == 1)
    {
      i = 2;
      this.hND = i;
      this.wqe = getIntent().getBooleanExtra("VoiceSearchResultUI_IsVoiceControl", false);
      v.i("MicroMsg.VoiceSearchResultUI", "showType = %s, isVoiceControl = %s", new Object[] { Integer.valueOf(this.showType), Boolean.valueOf(this.wqe) });
      this.wqb = new b(getApplicationContext(), this.showType);
      this.wqb.lN(false);
      localLinkedList = new LinkedList();
      switch (this.showType)
      {
      case 1: 
      default: 
        label220:
        if (this.wqb != null) {
          this.wqb.cK(localLinkedList);
        }
        this.wpN.setAdapter(this.wqb);
        this.wpQ.setVisibility(8);
        v.d("MicroMsg.VoiceSearchResultUI", "voiceId  " + this.lpR);
        if (this.showType == 2)
        {
          qL("");
          this.wqc = H(this.wqc);
        }
        break;
      }
    }
    for (;;)
    {
      qL(getString(R.l.dpy));
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(2847831752704L, 21218);
          StringBuilder localStringBuilder;
          if (!VoiceSearchResultUI.a(VoiceSearchResultUI.this))
          {
            paramAnonymousMenuItem = g.oSF;
            localStringBuilder = new StringBuilder().append(VoiceSearchResultUI.b(VoiceSearchResultUI.this)).append(",").append(VoiceSearchResultUI.c(VoiceSearchResultUI.this)).append(",");
            if (VoiceSearchResultUI.d(VoiceSearchResultUI.this) != null) {
              break label130;
            }
          }
          label130:
          for (int i = 0;; i = VoiceSearchResultUI.d(VoiceSearchResultUI.this).length)
          {
            paramAnonymousMenuItem.A(10452, i + ",0");
            if (VoiceSearchResultUI.e(VoiceSearchResultUI.this)) {
              VoiceSearchResultUI.this.moveTaskToBack(true);
            }
            VoiceSearchResultUI.this.finish();
            GMTrace.o(2847831752704L, 21218);
            return true;
          }
        }
      });
      this.wpN.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          GMTrace.i(2848905494528L, 21226);
          if (!VoiceSearchResultUI.a(VoiceSearchResultUI.this))
          {
            paramAnonymousAdapterView = g.oSF;
            paramAnonymousView = new StringBuilder().append(VoiceSearchResultUI.b(VoiceSearchResultUI.this)).append(",").append(VoiceSearchResultUI.c(VoiceSearchResultUI.this)).append(",");
            if (VoiceSearchResultUI.d(VoiceSearchResultUI.this) != null) {
              break label151;
            }
          }
          Object localObject;
          label151:
          for (int i = 0;; i = VoiceSearchResultUI.d(VoiceSearchResultUI.this).length)
          {
            paramAnonymousAdapterView.A(10452, i + "," + paramAnonymousInt);
            localObject = VoiceSearchResultUI.f(VoiceSearchResultUI.this).kK(paramAnonymousInt);
            paramAnonymousAdapterView = VoiceSearchResultUI.this;
            paramAnonymousView = ((af)localObject).field_username;
            localObject = ((x)localObject).tL();
            if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0)) {
              break;
            }
            GMTrace.o(2848905494528L, 21226);
            return;
          }
          v.d("MicroMsg.VoiceSearchResultUI", "dealSelectContact " + paramAnonymousView);
          if (paramAnonymousAdapterView.showType == 3)
          {
            localObject = new Intent();
            ((Intent)localObject).putExtra("Select_Conv_User", paramAnonymousView);
            paramAnonymousAdapterView.setResult(-1, (Intent)localObject);
            paramAnonymousAdapterView.finish();
            GMTrace.o(2848905494528L, 21226);
            return;
          }
          if ((paramAnonymousAdapterView.showType == 1) || (o.fF(paramAnonymousView)) || (o.eV(paramAnonymousView)) || (o.dH(paramAnonymousView)) || (o.eS(paramAnonymousView)) || (VoiceSearchResultUI.Uv((String)localObject)))
          {
            if (paramAnonymousAdapterView.showType == 1)
            {
              localObject = new Intent();
              ((Intent)localObject).putExtra("Contact_User", paramAnonymousView);
              if (o.eS(paramAnonymousView)) {
                ((Intent)localObject).putExtra("Is_group_card", true);
              }
              if ((paramAnonymousView != null) && (paramAnonymousView.length() > 0))
              {
                e.a((Intent)localObject, paramAnonymousView);
                if (paramAnonymousAdapterView.wqe)
                {
                  paramAnonymousAdapterView.a(En_5b8fbb1e.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
                  paramAnonymousAdapterView.finish();
                  GMTrace.o(2848905494528L, 21226);
                  return;
                }
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", (Intent)localObject);
              }
              GMTrace.o(2848905494528L, 21226);
              return;
            }
            if (paramAnonymousAdapterView.showType == 2)
            {
              if (bf.mA(paramAnonymousView))
              {
                v.e("MicroMsg.VoiceSearchResultUI", "username is null " + paramAnonymousView);
                GMTrace.o(2848905494528L, 21226);
                return;
              }
              if (o.fa(paramAnonymousView))
              {
                if (m.ye())
                {
                  paramAnonymousView = new Intent().putExtra("finish_direct", true);
                  d.b(paramAnonymousAdapterView.uRf.uRz, "tmessage", ".ui.TConversationUI", paramAnonymousView);
                  GMTrace.o(2848905494528L, 21226);
                  return;
                }
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                GMTrace.o(2848905494528L, 21226);
                return;
              }
              if (o.fc(paramAnonymousView))
              {
                if (m.yb())
                {
                  paramAnonymousView = new Intent().putExtra("finish_direct", true);
                  d.b(paramAnonymousAdapterView.uRf.uRz, "qmessage", ".ui.QConversationUI", paramAnonymousView);
                  GMTrace.o(2848905494528L, 21226);
                  return;
                }
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                GMTrace.o(2848905494528L, 21226);
                return;
              }
              if (o.fb(paramAnonymousView))
              {
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                GMTrace.o(2848905494528L, 21226);
                return;
              }
              if (o.fg(paramAnonymousView))
              {
                MMAppMgr.cancelNotification(paramAnonymousView);
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                GMTrace.o(2848905494528L, 21226);
                return;
              }
              if (o.eY(paramAnonymousView))
              {
                if (m.yn())
                {
                  paramAnonymousAdapterView.a(En_5b8fbb1e.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
                  GMTrace.o(2848905494528L, 21226);
                  return;
                }
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                GMTrace.o(2848905494528L, 21226);
                return;
              }
              if (o.fl(paramAnonymousView))
              {
                if (m.yi())
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("type", 20);
                  d.b(paramAnonymousAdapterView, "readerapp", ".ui.ReaderAppUI", paramAnonymousView);
                  GMTrace.o(2848905494528L, 21226);
                  return;
                }
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                GMTrace.o(2848905494528L, 21226);
                return;
              }
              if (o.ft(paramAnonymousView))
              {
                if (m.yj())
                {
                  paramAnonymousView = new Intent();
                  paramAnonymousView.putExtra("type", 11);
                  d.b(paramAnonymousAdapterView, "readerapp", ".ui.ReaderAppUI", paramAnonymousView);
                  GMTrace.o(2848905494528L, 21226);
                  return;
                }
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                GMTrace.o(2848905494528L, 21226);
                return;
              }
              if (o.fd(paramAnonymousView))
              {
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                GMTrace.o(2848905494528L, 21226);
                return;
              }
              if (o.fe(paramAnonymousView))
              {
                if (m.yl())
                {
                  d.b(paramAnonymousAdapterView, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                  GMTrace.o(2848905494528L, 21226);
                  return;
                }
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                GMTrace.o(2848905494528L, 21226);
                return;
              }
              if (o.fk(paramAnonymousView))
              {
                if (m.yf())
                {
                  paramAnonymousAdapterView.a(En_5b8fbb1e.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
                  GMTrace.o(2848905494528L, 21226);
                  return;
                }
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                GMTrace.o(2848905494528L, 21226);
                return;
              }
              if ((o.fi(paramAnonymousView)) || (o.fj(paramAnonymousView)) || (o.ff(paramAnonymousView)) || (o.fm(paramAnonymousView)) || (o.fn(paramAnonymousView)) || (o.eZ(paramAnonymousView)) || (o.fw(paramAnonymousView)))
              {
                d.b(paramAnonymousAdapterView, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", paramAnonymousView));
                GMTrace.o(2848905494528L, 21226);
                return;
              }
              paramAnonymousAdapterView.a(En_5b8fbb1e.class, new Intent().putExtra("Chat_User", paramAnonymousView).putExtra("finish_direct", true));
              GMTrace.o(2848905494528L, 21226);
            }
          }
          else
          {
            paramAnonymousView = new Intent(paramAnonymousAdapterView, SearchConversationResultUI.class);
            paramAnonymousView.putExtra("SearchConversationResult_User", (String)localObject);
            paramAnonymousAdapterView.startActivity(paramAnonymousView);
          }
          GMTrace.o(2848905494528L, 21226);
        }
      });
      I(this.wqc);
      GMTrace.o(2839778689024L, 21158);
      return;
      i = 1;
      break;
      localLinkedList.add("lbsapp");
      localLinkedList.add("shakeapp");
      localLinkedList.add("qqfriend");
      localLinkedList.add("facebookapp");
      localLinkedList.add("feedsapp");
      localLinkedList.add("fmessage");
      localLinkedList.add("voipapp");
      localLinkedList.add("voicevoipapp");
      localLinkedList.add("voiceinputapp");
      localLinkedList.add("linkedinplugin");
      localLinkedList.add("notifymessage");
      i = m.xW();
      if ((i & 0x1) != 0) {
        localLinkedList.add("qqmail");
      }
      if ((!o.yy()) || ((i & 0x2) != 0)) {
        localLinkedList.add("tmessage");
      }
      if ((i & 0x20) != 0) {
        localLinkedList.add("qmessage");
      }
      if ((i & 0x80) != 0) {
        localLinkedList.add("qqsync");
      }
      if ((i & 0x10) != 0) {
        localLinkedList.add("medianote");
      }
      if ((0x80000 & i) != 0) {
        localLinkedList.add("newsapp");
      }
      if (((0x40000 & i) != 0) || (!o.yx())) {
        localLinkedList.add("blogapp");
      }
      if ((0x10000 & i) != 0) {
        localLinkedList.add("masssendapp");
      }
      if ((i & 0x2000000) == 0) {
        break label220;
      }
      localLinkedList.add("voiceinputapp");
      break label220;
      qL(getString(R.l.dpy));
    }
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2840718213120L, 21165);
    int i = R.i.dpy;
    GMTrace.o(2840718213120L, 21165);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2839644471296L, 21157);
    super.onCreate(paramBundle);
    KD();
    this.wqd = false;
    GMTrace.o(2839644471296L, 21157);
  }
  
  public void onDestroy()
  {
    GMTrace.i(2840047124480L, 21160);
    super.onDestroy();
    this.wqb.aEP();
    GMTrace.o(2840047124480L, 21160);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2840315559936L, 21162);
    if (4 == paramInt)
    {
      g localg;
      StringBuilder localStringBuilder;
      if (!this.wqd)
      {
        localg = g.oSF;
        localStringBuilder = new StringBuilder().append(this.hND).append(",").append(this.lpR).append(",");
        if (this.wqc != null) {
          break label121;
        }
      }
      label121:
      for (int i = 0;; i = this.wqc.length)
      {
        localg.A(10452, i + ",0");
        if (!this.wqe) {
          break;
        }
        moveTaskToBack(true);
        finish();
        GMTrace.o(2840315559936L, 21162);
        return true;
      }
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2840315559936L, 21162);
    return bool;
  }
  
  public void onPause()
  {
    GMTrace.i(2840181342208L, 21161);
    super.onPause();
    this.wqd = true;
    GMTrace.o(2840181342208L, 21161);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/voicesearch/VoiceSearchResultUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */