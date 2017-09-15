package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.af;
import com.tencent.mm.j.a;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.awm;
import com.tencent.mm.protocal.c.bcl;
import com.tencent.mm.protocal.c.mx;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.aa;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.voicesearch.VoiceSearchResultUI;
import com.tencent.mm.y.k;
import java.io.IOException;

public class ChatroomContactUI
  extends MMActivity
  implements j.a, com.tencent.mm.y.e
{
  private int jZe;
  private int jZf;
  private com.tencent.mm.ui.widget.g jZi;
  private com.tencent.mm.pluginsdk.ui.d krI;
  private TextView lEO;
  private n.d lky;
  private ListView mYn;
  private VoiceSearchLayout uOF;
  private ContactCountView vTE;
  private com.tencent.mm.ui.voicesearch.b vTr;
  private String vTt;
  private d vUA;
  private p vUz;
  
  public ChatroomContactUI()
  {
    GMTrace.i(1807510142976L, 13467);
    this.jZe = 0;
    this.jZf = 0;
    this.lky = new n.d()
    {
      public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        GMTrace.i(1821871439872L, 13574);
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          GMTrace.o(1821871439872L, 13574);
          return;
        }
        ChatroomContactUI.TM(ChatroomContactUI.a(ChatroomContactUI.this));
        GMTrace.o(1821871439872L, 13574);
      }
    };
    this.krI = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(1779861291008L, 13261);
        GMTrace.o(1779861291008L, 13261);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        GMTrace.i(1779727073280L, 13260);
        GMTrace.o(1779727073280L, 13260);
      }
    });
    GMTrace.o(1807510142976L, 13467);
  }
  
  private void aFI()
  {
    GMTrace.i(1808583884800L, 13475);
    if (this.vUA != null) {
      this.vUA.a(null, null);
    }
    if (this.vTr != null) {
      this.vTr.a(null, null);
    }
    GMTrace.o(1808583884800L, 13475);
  }
  
  public final void KD()
  {
    GMTrace.i(1808047013888L, 13471);
    ((TextView)findViewById(R.h.bLY)).setVisibility(8);
    this.mYn = ((ListView)findViewById(R.h.bnu));
    this.mYn.setAdapter(null);
    this.lEO = ((TextView)findViewById(R.h.bLY));
    this.lEO.setText(R.l.dCp);
    this.vUA = new d(this, "@all.chatroom.contact");
    this.vUA.kl(true);
    this.vTr = new com.tencent.mm.ui.voicesearch.b(this.uRf.uRz, 1);
    this.vTr.vSQ = "@all.chatroom.contact";
    this.vUz = new p((byte)0);
    this.vUz.a(new com.tencent.mm.pluginsdk.ui.tools.p.a()
    {
      public final void OE()
      {
        GMTrace.i(1783485169664L, 13288);
        GMTrace.o(1783485169664L, 13288);
      }
      
      public final void OF()
      {
        GMTrace.i(1783619387392L, 13289);
        GMTrace.o(1783619387392L, 13289);
      }
      
      public final void OG()
      {
        GMTrace.i(1783216734208L, 13286);
        GMTrace.o(1783216734208L, 13286);
      }
      
      public final void OH()
      {
        GMTrace.i(16857612419072L, 125599);
        GMTrace.o(16857612419072L, 125599);
      }
      
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong, int paramAnonymousInt)
      {
        GMTrace.i(1784022040576L, 13292);
        v.v("MicroMsg.ChatroomContactUI", "onVoiceReturn");
        if (paramAnonymousBoolean)
        {
          Intent localIntent = new Intent(ChatroomContactUI.this.uRf.uRz, VoiceSearchResultUI.class);
          localIntent.putExtra("VoiceSearchResultUI_Resultlist", paramAnonymousArrayOfString);
          localIntent.putExtra("VoiceSearchResultUI_VoiceId", paramAnonymousLong);
          localIntent.putExtra("VoiceSearchResultUI_ShowType", paramAnonymousInt);
          ChatroomContactUI.this.uRf.uRz.startActivity(localIntent);
          GMTrace.o(1784022040576L, 13292);
          return;
        }
        paramAnonymousArrayOfString = new Intent(ChatroomContactUI.this.uRf.uRz, VoiceSearchResultUI.class);
        paramAnonymousArrayOfString.putExtra("VoiceSearchResultUI_Resultlist", new String[0]);
        paramAnonymousArrayOfString.putExtra("VoiceSearchResultUI_Error", ChatroomContactUI.this.uRf.uRz.getString(R.l.eln));
        paramAnonymousArrayOfString.putExtra("VoiceSearchResultUI_VoiceId", paramAnonymousLong);
        paramAnonymousArrayOfString.putExtra("VoiceSearchResultUI_ShowType", paramAnonymousInt);
        ChatroomContactUI.this.uRf.uRz.startActivity(paramAnonymousArrayOfString);
        GMTrace.o(1784022040576L, 13292);
      }
      
      public final void aed()
      {
        GMTrace.i(1783753605120L, 13290);
        v.v("MicroMsg.ChatroomContactUI", "onVoiceSearchStart");
        ChatroomContactUI.this.aGY();
        GMTrace.o(1783753605120L, 13290);
      }
      
      public final void aee()
      {
        GMTrace.i(1783887822848L, 13291);
        GMTrace.o(1783887822848L, 13291);
      }
      
      public final boolean mQ(String paramAnonymousString)
      {
        GMTrace.i(1784156258304L, 13293);
        GMTrace.o(1784156258304L, 13293);
        return false;
      }
      
      public final void mR(String paramAnonymousString)
      {
        GMTrace.i(1783350951936L, 13287);
        v.d("MicroMsg.ChatroomContactUI", "onSearchBarChange %s", new Object[] { paramAnonymousString });
        paramAnonymousString = com.tencent.mm.platformtools.u.my(paramAnonymousString);
        ChatroomContactUI.a(ChatroomContactUI.this, paramAnonymousString);
        GMTrace.o(1783350951936L, 13287);
      }
    });
    a(this.vUz);
    this.vUA.a(new MMSlideDelView.c()
    {
      public final int bY(View paramAnonymousView)
      {
        GMTrace.i(1738253795328L, 12951);
        int i = ChatroomContactUI.b(ChatroomContactUI.this).getPositionForView(paramAnonymousView);
        GMTrace.o(1738253795328L, 12951);
        return i;
      }
    });
    this.vUA.a(new MMSlideDelView.f()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt)
      {
        GMTrace.i(1842406752256L, 13727);
        ChatroomContactUI.b(ChatroomContactUI.this).performItemClick(paramAnonymousView, paramAnonymousInt, 0L);
        GMTrace.o(1842406752256L, 13727);
      }
    });
    this.vUA.a(new MMSlideDelView.e()
    {
      public final void aQ(Object paramAnonymousObject)
      {
        GMTrace.i(1757715365888L, 13096);
        if (paramAnonymousObject == null)
        {
          v.e("MicroMsg.ChatroomContactUI", "onItemDel object null");
          GMTrace.o(1757715365888L, 13096);
          return;
        }
        ChatroomContactUI.TM(paramAnonymousObject.toString());
        ChatroomContactUI.c(ChatroomContactUI.this);
        GMTrace.o(1757715365888L, 13096);
      }
    });
    this.mYn.setOnScrollListener(this.krI);
    this.vUA.sLl = this.krI;
    this.jZi = new com.tencent.mm.ui.widget.g(this.uRf.uRz);
    this.mYn.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(1780129726464L, 13263);
        paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
        if (ChatroomContactUI.d(ChatroomContactUI.this) == null) {}
        for (paramAnonymousAdapterView = ChatroomContactUI.d(ChatroomContactUI.this);; paramAnonymousAdapterView = Boolean.valueOf(ChatroomContactUI.d(ChatroomContactUI.this).wpW))
        {
          v.d("MicroMsg.ChatroomContactUI", paramAnonymousAdapterView);
          if (paramAnonymousInt >= ChatroomContactUI.b(ChatroomContactUI.this).getHeaderViewsCount()) {
            break;
          }
          GMTrace.o(1780129726464L, 13263);
          return;
        }
        paramAnonymousInt -= ChatroomContactUI.b(ChatroomContactUI.this).getHeaderViewsCount();
        if ((ChatroomContactUI.d(ChatroomContactUI.this) != null) && (ChatroomContactUI.d(ChatroomContactUI.this).wpW))
        {
          boolean bool1 = ChatroomContactUI.d(ChatroomContactUI.this).nF(paramAnonymousInt);
          boolean bool2 = ChatroomContactUI.d(ChatroomContactUI.this).Cf(paramAnonymousInt);
          v.d("MicroMsg.ChatroomContactUI", "onItemClick " + bool2);
          if (bool2)
          {
            paramAnonymousView = ChatroomContactUI.d(ChatroomContactUI.this);
            if (ChatroomContactUI.e(ChatroomContactUI.this) == null) {}
            for (paramAnonymousAdapterView = "";; paramAnonymousAdapterView = ChatroomContactUI.e(ChatroomContactUI.this).bzR())
            {
              paramAnonymousView.Us(paramAnonymousAdapterView);
              GMTrace.o(1780129726464L, 13263);
              return;
            }
          }
          if (bool1)
          {
            paramAnonymousView = ChatroomContactUI.d(ChatroomContactUI.this).Ce(paramAnonymousInt);
            paramAnonymousAdapterView = paramAnonymousView.trH.tXF;
            ap.yY();
            Object localObject = c.wR().Rb(paramAnonymousAdapterView);
            if (a.ez(((af)localObject).field_type))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
              paramAnonymousView.putExtra("Contact_Scene", 3);
              if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
              {
                if (((x)localObject).bKU()) {
                  com.tencent.mm.plugin.report.service.g.oSF.A(10298, paramAnonymousAdapterView + ",3");
                }
                e.a(paramAnonymousView, paramAnonymousAdapterView);
                com.tencent.mm.bb.d.b(ChatroomContactUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
              }
              GMTrace.o(1780129726464L, 13263);
              return;
            }
            localObject = new Intent();
            ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.trH.tXF);
            ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.hAq);
            ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.tJy.tXF);
            ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.hAo);
            ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.ab(paramAnonymousView.hAu, paramAnonymousView.hAm, paramAnonymousView.hAn));
            ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.hAl);
            ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.tLe);
            ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.tLd);
            ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.tLh);
            ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.tLf);
            ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.tLg);
            ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.tLj.hAw);
            ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.tLj.hAy);
            ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.tLj.hAx);
            if (paramAnonymousView.tLk != null) {}
            try
            {
              ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.tLk.toByteArray());
              if ((paramAnonymousView.tLd & 0x8) > 0) {
                com.tencent.mm.plugin.report.service.g.oSF.A(10298, paramAnonymousAdapterView + ",3");
              }
              com.tencent.mm.bb.d.b(ChatroomContactUI.this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
              GMTrace.o(1780129726464L, 13263);
              return;
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                v.printErrStackTrace("MicroMsg.ChatroomContactUI", localIOException, "", new Object[0]);
              }
            }
          }
          paramAnonymousAdapterView = ChatroomContactUI.d(ChatroomContactUI.this).kK(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            v.e("MicroMsg.ChatroomContactUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(ChatroomContactUI.d(ChatroomContactUI.this).getCount()), Integer.valueOf(paramAnonymousInt) });
            GMTrace.o(1780129726464L, 13263);
            return;
          }
          u.h(ChatroomContactUI.e(ChatroomContactUI.this).bzR(), 9, 3, paramAnonymousInt + 1);
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          paramAnonymousView = new Intent(ChatroomContactUI.this.uRf.uRz, En_5b8fbb1e.class);
          paramAnonymousView.addFlags(67108864);
          paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView);
          paramAnonymousView.putExtra("Chat_Mode", 1);
          ChatroomContactUI.this.uRf.uRz.startActivity(paramAnonymousView);
          GMTrace.o(1780129726464L, 13263);
          return;
        }
        paramAnonymousAdapterView = ((x)ChatroomContactUI.f(ChatroomContactUI.this).getItem(paramAnonymousInt)).field_username;
        ChatroomContactUI.b(ChatroomContactUI.this, paramAnonymousAdapterView);
        GMTrace.o(1780129726464L, 13263);
      }
    });
    this.mYn.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(1752615092224L, 13058);
        v.d("MicroMsg.ChatroomContactUI", "onItemLongClick, targetview is SearchBar::ListView, pos = " + paramAnonymousInt);
        if (paramAnonymousInt < ChatroomContactUI.b(ChatroomContactUI.this).getHeaderViewsCount())
        {
          v.w("MicroMsg.ChatroomContactUI", "on item long click, but match header view");
          GMTrace.o(1752615092224L, 13058);
          return true;
        }
        if ((ChatroomContactUI.d(ChatroomContactUI.this) != null) && (ChatroomContactUI.d(ChatroomContactUI.this).wpW))
        {
          GMTrace.o(1752615092224L, 13058);
          return true;
        }
        paramAnonymousAdapterView = ((x)ChatroomContactUI.f(ChatroomContactUI.this).getItem(paramAnonymousInt - ChatroomContactUI.b(ChatroomContactUI.this).getHeaderViewsCount())).field_username;
        if ((o.fu(paramAnonymousAdapterView)) || (o.fv(paramAnonymousAdapterView)))
        {
          GMTrace.o(1752615092224L, 13058);
          return true;
        }
        ChatroomContactUI.c(ChatroomContactUI.this, paramAnonymousAdapterView);
        ChatroomContactUI.j(ChatroomContactUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ChatroomContactUI.this, ChatroomContactUI.g(ChatroomContactUI.this), ChatroomContactUI.h(ChatroomContactUI.this), ChatroomContactUI.i(ChatroomContactUI.this));
        GMTrace.o(1752615092224L, 13058);
        return true;
      }
    });
    this.mYn.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(1839319744512L, 13704);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          if (ChatroomContactUI.f(ChatroomContactUI.this) != null)
          {
            paramAnonymousView = ChatroomContactUI.f(ChatroomContactUI.this);
            if (paramAnonymousView.hAM != null) {
              paramAnonymousView.hAM.onTouchEvent(paramAnonymousMotionEvent);
            }
          }
          if (ChatroomContactUI.d(ChatroomContactUI.this) != null)
          {
            paramAnonymousView = ChatroomContactUI.d(ChatroomContactUI.this);
            if (paramAnonymousView.hAM != null) {
              paramAnonymousView.hAM.onTouchEvent(paramAnonymousMotionEvent);
            }
          }
          GMTrace.o(1839319744512L, 13704);
          return false;
          ChatroomContactUI.this.aGY();
          ChatroomContactUI.a(ChatroomContactUI.this, (int)paramAnonymousMotionEvent.getRawX());
          ChatroomContactUI.b(ChatroomContactUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    });
    Object localObject = this.mYn;
    ContactCountView localContactCountView = new ContactCountView(this);
    this.vTE = localContactCountView;
    ((ListView)localObject).addFooterView(localContactCountView, null, false);
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(1804288917504L, 13443);
        ChatroomContactUI.this.finish();
        GMTrace.o(1804288917504L, 13443);
        return false;
      }
    });
    a(0, R.l.dBF, R.k.dsy, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(1752883527680L, 13060);
        paramAnonymousMenuItem = new Intent(ChatroomContactUI.this, SelectContactUI.class);
        paramAnonymousMenuItem.putExtra("titile", ChatroomContactUI.this.getString(R.l.dCJ));
        paramAnonymousMenuItem.putExtra("list_type", 0);
        paramAnonymousMenuItem.putExtra("list_attr", s.q(new int[] { s.vWQ, 256, 512 }));
        ChatroomContactUI.this.uRf.uRz.startActivity(paramAnonymousMenuItem);
        GMTrace.o(1752883527680L, 13060);
        return false;
      }
    });
    new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(1842675187712L, 13729);
        BackwardSupportUtil.c.a(ChatroomContactUI.b(ChatroomContactUI.this));
        GMTrace.o(1842675187712L, 13729);
      }
    };
    this.mYn.setAdapter(this.vUA);
    this.vTr.lM(false);
    this.mYn.setVisibility(0);
    this.uOF = new VoiceSearchLayout(this);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.uOF.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.uOF.xj(BackwardSupportUtil.b.a(this, 100.0F));
    this.uOF.setVisibility(8);
    ((ViewGroup)findViewById(R.h.cND)).addView(this.uOF);
    if (this.uOF != null) {
      this.uOF.sJU = new VoiceSearchLayout.b()
      {
        public final void jq(boolean paramAnonymousBoolean)
        {
          GMTrace.i(1707249500160L, 12720);
          v.d("MicroMsg.ChatroomContactUI", "visible " + paramAnonymousBoolean);
          if (paramAnonymousBoolean)
          {
            int i = ChatroomContactUI.b(ChatroomContactUI.this).getFirstVisiblePosition();
            v.d("MicroMsg.ChatroomContactUI", "getFirstVisiblePosition  " + i);
            if (i > 0) {
              ChatroomContactUI.b(ChatroomContactUI.this).post(new Runnable()
              {
                public final void run()
                {
                  GMTrace.i(1746709512192L, 13014);
                  ChatroomContactUI.b(ChatroomContactUI.this).setSelection(0);
                  GMTrace.o(1746709512192L, 13014);
                }
              });
            }
          }
          GMTrace.o(1707249500160L, 12720);
        }
      };
    }
    if (this.vUA.getCount() == 0)
    {
      this.lEO.setSingleLine(false);
      this.lEO.setPadding(40, 0, 40, 0);
      this.lEO.setVisibility(0);
    }
    GMTrace.o(1808047013888L, 13471);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(1808718102528L, 13476);
    if (!com.tencent.mm.platformtools.u.bp(this))
    {
      GMTrace.o(1808718102528L, 13476);
      return;
    }
    if (com.tencent.mm.ui.p.a.a(this, paramInt1, paramInt2, paramString, 4))
    {
      GMTrace.o(1808718102528L, 13476);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      GMTrace.o(1808718102528L, 13476);
      return;
    }
    switch (paramk.getType())
    {
    }
    for (;;)
    {
      GMTrace.o(1808718102528L, 13476);
      return;
      aFI();
    }
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.l paraml)
  {
    GMTrace.i(1808852320256L, 13477);
    if (this.vTE != null)
    {
      this.vTE.vUD = 2;
      this.vTE.bXE();
    }
    GMTrace.o(1808852320256L, 13477);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(1807644360704L, 13468);
    int i = R.i.cWY;
    GMTrace.o(1807644360704L, 13468);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(1807778578432L, 13469);
    super.onCreate(paramBundle);
    zd(R.l.dCj);
    KD();
    ap.vd().a(138, this);
    ap.yY();
    c.wR().a(this.vUA);
    GMTrace.o(1807778578432L, 13469);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    GMTrace.i(1807912796160L, 13470);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    ap.yY();
    if (c.wR().Rb(this.vTt) == null)
    {
      v.e("MicroMsg.ChatroomContactUI", "onCreateContextMenu, contact is null, username = " + this.vTt);
      GMTrace.o(1807912796160L, 13470);
      return;
    }
    if (o.eS(this.vTt))
    {
      paramContextMenu.setHeaderTitle(h.a(paramView.getContext(), com.tencent.mm.u.n.eK(this.vTt)));
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, R.l.dCn);
      GMTrace.o(1807912796160L, 13470);
      return;
    }
    GMTrace.o(1807912796160L, 13470);
  }
  
  protected void onDestroy()
  {
    GMTrace.i(1808449667072L, 13474);
    super.onDestroy();
    ap.vd().b(138, this);
    ap.yY();
    c.wR().b(this.vUA);
    d locald = this.vUA;
    if (locald.hAM != null)
    {
      locald.hAM.detach();
      locald.hAM = null;
    }
    this.vUA.aEP();
    this.vUA.uQY = null;
    this.vTr.detach();
    this.vTr.aEP();
    GMTrace.o(1808449667072L, 13474);
  }
  
  protected void onPause()
  {
    GMTrace.i(1808315449344L, 13473);
    super.onPause();
    ap.yY();
    c.xa().f(this);
    if (this.vUz != null)
    {
      p localp = this.vUz;
      localp.bZF();
      localp.cancel();
    }
    if (this.vTr != null) {
      this.vTr.onPause();
    }
    GMTrace.o(1808315449344L, 13473);
  }
  
  protected void onResume()
  {
    GMTrace.i(1808181231616L, 13472);
    super.onResume();
    if (this.vTE != null)
    {
      this.vTE.vUD = 2;
      this.vTE.bXE();
    }
    ap.yY();
    c.xa().c(this);
    if ((this.vUz != null) && (this.uOF != null))
    {
      com.tencent.mm.bb.d.bGH();
      if ((com.tencent.mm.ai.b.Hq()) || (!com.tencent.mm.sdk.platformtools.u.bID().equals("zh_CN"))) {
        break label127;
      }
      this.vUz.sVU = true;
      this.vUz.o(this.uOF);
    }
    for (;;)
    {
      if (this.vTr != null) {
        this.vTr.onResume();
      }
      GMTrace.o(1808181231616L, 13472);
      return;
      label127:
      this.vUz.sVU = false;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/ChatroomContactUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */