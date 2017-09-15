package com.tencent.mm.ui.bizchat;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.modelbiz.a.b.a;
import com.tencent.mm.modelbiz.a.b.a.b;
import com.tencent.mm.modelbiz.a.d;
import com.tencent.mm.modelbiz.a.d.a;
import com.tencent.mm.modelbiz.a.d.a.b;
import com.tencent.mm.modelbiz.a.s;
import com.tencent.mm.modelbiz.m;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.k.a;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.k;

public class BizChatFavUI
  extends MMActivity
  implements m
{
  private n.d jUC;
  private TextView jUy;
  private ListView jUz;
  private long jZq;
  private String jZw;
  private p jhu;
  private boolean uOa;
  private b.a vtT;
  private d.a vtU;
  private c vtZ;
  
  public BizChatFavUI()
  {
    GMTrace.i(2986076012544L, 22248);
    GMTrace.o(2986076012544L, 22248);
  }
  
  protected final void KD()
  {
    GMTrace.i(2987149754368L, 22256);
    this.jUz = ((ListView)findViewById(R.h.cIZ));
    this.jUy = ((TextView)findViewById(R.h.bLN));
    this.jUy.setText(R.l.dOO);
    this.jUz.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        GMTrace.i(2974533287936L, 22162);
        GMTrace.o(2974533287936L, 22162);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        GMTrace.i(2974399070208L, 22161);
        com.tencent.mm.ah.n.GX().bi(paramAnonymousInt);
        GMTrace.o(2974399070208L, 22161);
      }
    });
    this.vtZ = new c(this, new k.a()
    {
      public final void OI()
      {
        GMTrace.i(3000839962624L, 22358);
        BizChatFavUI.this.qL(com.tencent.mm.u.n.eK(BizChatFavUI.a(BizChatFavUI.this)));
        if (BizChatFavUI.c(BizChatFavUI.this).getCount() <= 0)
        {
          BizChatFavUI.d(BizChatFavUI.this).setVisibility(0);
          BizChatFavUI.e(BizChatFavUI.this).setVisibility(8);
          GMTrace.o(3000839962624L, 22358);
          return;
        }
        BizChatFavUI.d(BizChatFavUI.this).setVisibility(8);
        BizChatFavUI.e(BizChatFavUI.this).setVisibility(0);
        GMTrace.o(3000839962624L, 22358);
      }
      
      public final void OJ()
      {
        GMTrace.i(3000974180352L, 22359);
        GMTrace.o(3000974180352L, 22359);
      }
    }, this.jZw);
    this.vtZ.a(new MMSlideDelView.c()
    {
      public final int bY(View paramAnonymousView)
      {
        GMTrace.i(2990907850752L, 22284);
        int i = BizChatFavUI.e(BizChatFavUI.this).getPositionForView(paramAnonymousView);
        GMTrace.o(2990907850752L, 22284);
        return i;
      }
    });
    this.vtZ.a(new MMSlideDelView.f()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt)
      {
        GMTrace.i(2985404923904L, 22243);
        BizChatFavUI.e(BizChatFavUI.this).performItemClick(paramAnonymousView, paramAnonymousInt, 0L);
        GMTrace.o(2985404923904L, 22243);
      }
    });
    this.vtZ.a(new MMSlideDelView.e()
    {
      public final void aQ(Object paramAnonymousObject)
      {
        GMTrace.i(2970238320640L, 22130);
        if (paramAnonymousObject == null)
        {
          v.e("MicroMsg.BizChatFavUI", "onItemDel object null");
          GMTrace.o(2970238320640L, 22130);
          return;
        }
        GMTrace.o(2970238320640L, 22130);
      }
    });
    this.jUz.setAdapter(this.vtZ);
    this.jUC = new n.d()
    {
      public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        GMTrace.i(2984599617536L, 22237);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          GMTrace.o(2984599617536L, 22237);
          return;
          BizChatFavUI.a(BizChatFavUI.this, BizChatFavUI.f(BizChatFavUI.this));
        }
      }
    };
    final l locall = new l(this);
    this.jUz.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(3001242615808L, 22361);
        if (paramAnonymousInt < BizChatFavUI.e(BizChatFavUI.this).getHeaderViewsCount())
        {
          v.w("MicroMsg.BizChatFavUI", "on header view long click, ignore");
          GMTrace.o(3001242615808L, 22361);
          return true;
        }
        locall.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizChatFavUI.this, BizChatFavUI.g(BizChatFavUI.this));
        GMTrace.o(3001242615808L, 22361);
        return true;
      }
    });
    this.jUz.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(2972117368832L, 22144);
        paramAnonymousAdapterView = (com.tencent.mm.modelbiz.a.c)BizChatFavUI.c(BizChatFavUI.this).getItem(paramAnonymousInt);
        BizChatFavUI.b(BizChatFavUI.this, paramAnonymousAdapterView.field_bizChatLocalId);
        GMTrace.o(2972117368832L, 22144);
      }
    });
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(2982452133888L, 22221);
        BizChatFavUI.this.finish();
        GMTrace.o(2982452133888L, 22221);
        return true;
      }
    });
    GMTrace.o(2987149754368L, 22256);
  }
  
  public final void a(int paramInt, k paramk)
  {
    GMTrace.i(2987015536640L, 22255);
    if (this.jhu != null) {
      this.jhu.dismiss();
    }
    GMTrace.o(2987015536640L, 22255);
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2986344448000L, 22250);
    int i = R.i.daY;
    GMTrace.o(2986344448000L, 22250);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2986210230272L, 22249);
    super.onCreate(paramBundle);
    this.jZw = getIntent().getStringExtra("Contact_User");
    v.i("MicroMsg.BizChatFavUI", "[regitListener]");
    this.vtT = new b.a()
    {
      public final void a(b.a.b paramAnonymousb)
      {
        GMTrace.i(3000571527168L, 22356);
        if ((paramAnonymousb != null) && (paramAnonymousb.hwp != null) && (BizChatFavUI.a(BizChatFavUI.this).equals(paramAnonymousb.hwp.field_brandUserName)))
        {
          v.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChatConv change");
          if (BizChatFavUI.b(BizChatFavUI.this)) {
            BizChatFavUI.c(BizChatFavUI.this).OL();
          }
        }
        GMTrace.o(3000571527168L, 22356);
      }
    };
    this.vtU = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        GMTrace.i(2962990563328L, 22076);
        if ((paramAnonymousb != null) && (paramAnonymousb.hwz != null))
        {
          v.i("MicroMsg.BizChatFavUI", "bizChatExtension bizChat change");
          v.d("MicroMsg.BizChatFavUI", "needToUpdate:%s", new Object[] { Boolean.valueOf(com.tencent.mm.modelbiz.w.DJ().aa(paramAnonymousb.hwo).field_needToUpdate) });
          if (BizChatFavUI.b(BizChatFavUI.this)) {
            BizChatFavUI.c(BizChatFavUI.this).OL();
          }
        }
        GMTrace.o(2962990563328L, 22076);
      }
    };
    com.tencent.mm.modelbiz.w.DK().a(this.vtT, getMainLooper());
    com.tencent.mm.modelbiz.w.DJ().a(this.vtU, getMainLooper());
    KD();
    com.tencent.mm.modelbiz.w.DN();
    paramBundle = new s(this.jZw);
    com.tencent.mm.kernel.h.vH().gXs.a(paramBundle, 0);
    GMTrace.o(2986210230272L, 22249);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    GMTrace.i(2986881318912L, 22254);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    this.jZq = ((com.tencent.mm.modelbiz.a.c)this.vtZ.getItem(paramView.position)).field_bizChatLocalId;
    paramContextMenu.add(paramView.position, 0, 1, R.l.dOP);
    GMTrace.o(2986881318912L, 22254);
  }
  
  public void onDestroy()
  {
    GMTrace.i(2986478665728L, 22251);
    v.i("MicroMsg.BizChatFavUI", "[unRegitListener]");
    com.tencent.mm.modelbiz.w.DK().a(this.vtT);
    com.tencent.mm.modelbiz.w.DJ().a(this.vtU);
    this.vtZ.aEP();
    super.onDestroy();
    GMTrace.o(2986478665728L, 22251);
  }
  
  public void onPause()
  {
    GMTrace.i(2986747101184L, 22253);
    this.vtZ.onPause();
    this.uOa = false;
    ap.getNotification().db("");
    super.onPause();
    GMTrace.o(2986747101184L, 22253);
  }
  
  public void onResume()
  {
    GMTrace.i(2986612883456L, 22252);
    super.onResume();
    ap.yY();
    x localx = com.tencent.mm.u.c.wR().Rb(this.jZw);
    if ((localx == null) || (!com.tencent.mm.j.a.ez(localx.field_type)))
    {
      finish();
      GMTrace.o(2986612883456L, 22252);
      return;
    }
    zj(8);
    this.uOa = true;
    this.vtZ.a(null, null);
    ap.getNotification().db(this.jZw);
    GMTrace.o(2986612883456L, 22252);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bizchat/BizChatFavUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */