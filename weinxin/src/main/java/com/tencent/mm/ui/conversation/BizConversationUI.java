package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.platformtools.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.a;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.ng;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.a;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.k.a;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.b;
import com.tencent.mm.y.n;
import java.util.Map;

public class BizConversationUI
  extends BaseConversationUI
{
  private View ipa;
  
  public BizConversationUI()
  {
    GMTrace.i(3417720225792L, 25464);
    GMTrace.o(3417720225792L, 25464);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    GMTrace.i(3417988661248L, 25466);
    super.onConfigurationChanged(paramConfiguration);
    e.a(this, this.ipa);
    GMTrace.o(3417988661248L, 25466);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3417854443520L, 25465);
    super.onCreate(paramBundle);
    this.ipa = r.eC(this).inflate(R.i.cVG, null);
    setContentView(this.ipa);
    this.vZo = new a();
    aR().aV().a(R.h.ckg, this.vZo).commit();
    e.a(this, this.ipa);
    GMTrace.o(3417854443520L, 25465);
  }
  
  public static final class a
    extends BaseConversationUI.b
  {
    public String fJC;
    public String htS;
    private com.tencent.mm.ui.base.p irp;
    public boolean jUD;
    TextView jUy;
    public int jZe;
    public int jZf;
    public com.tencent.mm.ui.widget.g jZi;
    public n.d nwm;
    private com.tencent.mm.sdk.b.c oSW;
    public com.tencent.mm.storage.ae vUE;
    public d vYW;
    public ListView vZD;
    private String vZE;
    public long vZF;
    
    public a()
    {
      GMTrace.i(3391816204288L, 25271);
      this.fJC = "";
      this.vZF = 0L;
      this.jZe = 0;
      this.jZf = 0;
      this.irp = null;
      this.jUD = false;
      this.nwm = new n.d()
      {
        public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          GMTrace.i(14683822096384L, 109403);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            GMTrace.o(14683822096384L, 109403);
            return;
            ap.yY();
            paramAnonymousMenuItem = com.tencent.mm.u.c.wR().Rb(BizConversationUI.a.this.fJC);
            if (paramAnonymousMenuItem == null)
            {
              v.e("MicroMsg.BizConversationUI", "changed biz stick status failed, contact is null, talker = " + BizConversationUI.a.this.fJC);
              GMTrace.o(14683822096384L, 109403);
              return;
            }
            if (paramAnonymousMenuItem.tG())
            {
              com.tencent.mm.plugin.report.service.g.oSF.i(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2) });
              o.m(BizConversationUI.a.this.fJC, true);
              GMTrace.o(14683822096384L, 109403);
              return;
            }
            com.tencent.mm.plugin.report.service.g.oSF.i(13307, new Object[] { paramAnonymousMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2) });
            o.l(BizConversationUI.a.this.fJC, true);
            GMTrace.o(14683822096384L, 109403);
            return;
            ap.yY();
            paramAnonymousMenuItem = com.tencent.mm.u.c.wR().Rb(BizConversationUI.a.this.fJC);
            b.a(w.DH().hO(BizConversationUI.a.this.fJC), BizConversationUI.a.this.bOZ(), paramAnonymousMenuItem, 2);
            GMTrace.o(14683822096384L, 109403);
            return;
            BizConversationUI.a.this.TS(BizConversationUI.a.this.fJC);
          }
        }
      };
      this.oSW = new com.tencent.mm.sdk.b.c() {};
      GMTrace.o(3391816204288L, 25271);
    }
    
    public final void TS(String paramString)
    {
      GMTrace.i(16020496449536L, 119362);
      if (bf.mA(paramString))
      {
        v.e("MicroMsg.BizConversationUI", "Delete Conversation and messages fail because username is null or nil.");
        GMTrace.o(16020496449536L, 119362);
        return;
      }
      if ("officialaccounts".equals(this.htS)) {
        com.tencent.mm.plugin.report.service.g.oSF.i(13773, new Object[] { Integer.valueOf(0), Integer.valueOf(this.vUE.field_unReadCount), Integer.valueOf(0), this.vUE.field_username });
      }
      ap.yY();
      Object localObject1 = com.tencent.mm.u.c.wT().Af(paramString);
      Object localObject2 = new ng();
      ((ng)localObject2).trH = new avu().OU(bf.mz(paramString));
      ((ng)localObject2).tdE = ((ce)localObject1).field_msgSvrId;
      ap.yY();
      com.tencent.mm.u.c.wQ().b(new e.a(8, (com.tencent.mm.bd.a)localObject2));
      this.jUD = false;
      localObject1 = bOZ();
      getString(R.l.dIG);
      ay.a(paramString, new ay.a()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(14687982845952L, 109434);
          BizConversationUI.a.this.jUD = true;
          GMTrace.o(14687982845952L, 109434);
        }
      }
      {
        public final void zr()
        {
          GMTrace.i(14679392911360L, 109370);
          if (this.krZ != null) {
            this.krZ.dismiss();
          }
          GMTrace.o(14679392911360L, 109370);
        }
        
        public final boolean zs()
        {
          GMTrace.i(14679258693632L, 109369);
          boolean bool = BizConversationUI.a.this.jUD;
          GMTrace.o(14679258693632L, 109369);
          return bool;
        }
      });
      ap.yY();
      localObject1 = com.tencent.mm.u.c.wR().Rb(paramString);
      ap.yY();
      localObject2 = com.tencent.mm.u.c.wW().Rl(paramString);
      ap.yY();
      com.tencent.mm.u.c.wW().Rk(paramString);
      if ((localObject2 != null) && ((((com.tencent.mm.storage.ae)localObject2).eC(4194304)) || ((localObject1 != null) && (((x)localObject1).bKU()) && (!com.tencent.mm.j.a.ez(((af)localObject1).field_type)) && (((aj)localObject2).field_conversationTime < w.DT()))))
      {
        paramString = new i(paramString);
        ap.vd().a(paramString, 0);
      }
      GMTrace.o(16020496449536L, 119362);
    }
    
    protected final int getLayoutId()
    {
      GMTrace.i(3392084639744L, 25273);
      int i = R.i.doU;
      GMTrace.o(3392084639744L, 25273);
      return i;
    }
    
    public final String getUserName()
    {
      GMTrace.i(3392218857472L, 25274);
      String str = this.htS;
      GMTrace.o(3392218857472L, 25274);
      return str;
    }
    
    public final void onActivityCreated(Bundle paramBundle)
    {
      GMTrace.i(3391950422016L, 25272);
      super.onActivityCreated(paramBundle);
      this.htS = bOZ().getIntent().getStringExtra("enterprise_biz_name");
      if (bf.mA(this.htS)) {
        this.htS = "officialaccounts";
      }
      if (bf.mz(this.htS).equals("officialaccounts")) {
        com.tencent.mm.plugin.report.service.g.oSF.A(11404, "");
      }
      this.vZE = bOZ().getIntent().getStringExtra("enterprise_biz_display_name");
      if (bf.mA(this.vZE)) {
        this.vZE = getString(R.l.dOH);
      }
      qL(this.vZE);
      this.vZD = ((ListView)findViewById(R.h.cIZ));
      this.jUy = ((TextView)findViewById(R.h.bLN));
      this.jUy.setText(R.l.eek);
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(3419733491712L, 25479);
          BizConversationUI.a.this.finish();
          GMTrace.o(3419733491712L, 25479);
          return true;
        }
      });
      new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(3372757286912L, 25129);
          a.b.a(BizConversationUI.a.this.vZD);
          GMTrace.o(3372757286912L, 25129);
        }
      };
      this.vYW = new a(bOZ(), this.htS, new k.a()
      {
        public final void OI()
        {
          GMTrace.i(3425773289472L, 25524);
          BizConversationUI.a locala = BizConversationUI.a.this;
          if (BizConversationUI.a.this.vYW.getCount() <= 0)
          {
            locala.jUy.setVisibility(0);
            locala.vZD.setVisibility(8);
            GMTrace.o(3425773289472L, 25524);
            return;
          }
          locala.jUy.setVisibility(8);
          locala.vZD.setVisibility(0);
          GMTrace.o(3425773289472L, 25524);
        }
        
        public final void OJ()
        {
          GMTrace.i(3425907507200L, 25525);
          GMTrace.o(3425907507200L, 25525);
        }
      });
      this.vYW.a(new MMSlideDelView.c()
      {
        public final int bY(View paramAnonymousView)
        {
          GMTrace.i(3420538798080L, 25485);
          int i = BizConversationUI.a.this.vZD.getPositionForView(paramAnonymousView);
          GMTrace.o(3420538798080L, 25485);
          return i;
        }
      });
      this.vYW.a(new MMSlideDelView.f()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt)
        {
          GMTrace.i(3375307423744L, 25148);
          BizConversationUI.a.this.vZD.performItemClick(paramAnonymousView, paramAnonymousInt, 0L);
          GMTrace.o(3375307423744L, 25148);
        }
      });
      this.vZD.setAdapter(this.vYW);
      this.jZi = new com.tencent.mm.ui.widget.g(bOZ());
      this.vZD.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          GMTrace.i(3407653896192L, 25389);
          BizConversationUI.a.this.vUE = ((com.tencent.mm.storage.ae)BizConversationUI.a.this.vYW.getItem(paramAnonymousInt));
          BizConversationUI.a.this.fJC = BizConversationUI.a.this.vUE.field_username;
          paramAnonymousAdapterView = BizConversationUI.a.this.vUE;
          if (paramAnonymousAdapterView == null)
          {
            v.e("MicroMsg.BizConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(BizConversationUI.a.this.vYW.getCount()) });
            BizConversationUI.a.this.vYW.notifyDataSetChanged();
            GMTrace.o(3407653896192L, 25389);
            return;
          }
          paramAnonymousView = new Bundle();
          paramAnonymousView.putInt("biz_click_item_unread_count", BizConversationUI.a.this.vUE.field_unReadCount);
          paramAnonymousView.putInt("biz_click_item_position", paramAnonymousInt + 1);
          BizConversationUI.a.this.vZA.a(paramAnonymousAdapterView.field_username, paramAnonymousView, true);
          GMTrace.o(3407653896192L, 25389);
        }
      });
      this.vZD.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          GMTrace.i(14687714410496L, 109432);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            GMTrace.o(14687714410496L, 109432);
            return false;
            BizConversationUI.a.this.jZe = ((int)paramAnonymousMotionEvent.getRawX());
            BizConversationUI.a.this.jZf = ((int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      this.vZD.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          GMTrace.i(14687580192768L, 109431);
          BizConversationUI.a.this.vUE = ((com.tencent.mm.storage.ae)BizConversationUI.a.this.vYW.getItem(paramAnonymousInt));
          BizConversationUI.a.this.fJC = BizConversationUI.a.this.vUE.field_username;
          BizConversationUI.a.this.jZi.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizConversationUI.a.this, BizConversationUI.a.this.nwm, BizConversationUI.a.this.jZe, BizConversationUI.a.this.jZf);
          GMTrace.o(14687580192768L, 109431);
          return true;
        }
      });
      this.vYW.a(new MMSlideDelView.c()
      {
        public final int bY(View paramAnonymousView)
        {
          GMTrace.i(14678453387264L, 109363);
          int i = BizConversationUI.a.this.vZD.getPositionForView(paramAnonymousView);
          GMTrace.o(14678453387264L, 109363);
          return i;
        }
      });
      this.vYW.a(new MMSlideDelView.f()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt)
        {
          GMTrace.i(14683151007744L, 109398);
          BizConversationUI.a.this.vZD.performItemClick(paramAnonymousView, paramAnonymousInt, 0L);
          GMTrace.o(14683151007744L, 109398);
        }
      });
      this.vYW.a(new MMSlideDelView.e()
      {
        public final void aQ(Object paramAnonymousObject)
        {
          GMTrace.i(14681943048192L, 109389);
          if (paramAnonymousObject == null)
          {
            v.e("MicroMsg.BizConversationUI", "onItemDel object null");
            GMTrace.o(14681943048192L, 109389);
            return;
          }
          paramAnonymousObject = paramAnonymousObject.toString();
          BizConversationUI.a.this.TS((String)paramAnonymousObject);
          GMTrace.o(14681943048192L, 109389);
        }
      });
      if ("officialaccounts".equals(this.htS))
      {
        paramBundle = com.tencent.mm.u.c.c.Az().dX("100045");
        if ((!paramBundle.isValid()) || (!"1".equals(paramBundle.bKA().get("isOpenSearch")))) {
          break label489;
        }
      }
      label489:
      for (boolean bool = true;; bool = false)
      {
        v.d("MicroMsg.BizConversationUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          a(1, R.l.eYc, R.k.dsK, new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              GMTrace.i(3387387019264L, 25238);
              if (com.tencent.mm.as.d.Ij())
              {
                paramAnonymousMenuItem = com.tencent.mm.as.d.Im();
                paramAnonymousMenuItem.putExtra("title", BizConversationUI.a.this.getString(R.l.enj));
                paramAnonymousMenuItem.putExtra("searchbar_tips", BizConversationUI.a.this.getString(R.l.enj));
                paramAnonymousMenuItem.putExtra("KRightBtn", true);
                paramAnonymousMenuItem.putExtra("ftsneedkeyboard", true);
                paramAnonymousMenuItem.putExtra("publishIdPrefix", "bs");
                paramAnonymousMenuItem.putExtra("ftsType", 2);
                paramAnonymousMenuItem.putExtra("ftsbizscene", 11);
                paramAnonymousMenuItem.putExtra("rawUrl", com.tencent.mm.as.d.m(com.tencent.mm.as.d.a(11, true, 2)));
                paramAnonymousMenuItem.putExtra("key_load_js_without_delay", true);
                paramAnonymousMenuItem.addFlags(67108864);
                com.tencent.mm.bb.d.b(aa.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", paramAnonymousMenuItem);
              }
              for (;;)
              {
                GMTrace.o(3387387019264L, 25238);
                return true;
                v.e("MicroMsg.BizConversationUI", "fts h5 template not avail");
              }
            }
          });
        }
        ap.yY();
        com.tencent.mm.u.c.wW().a(this.vYW);
        this.vZF = System.currentTimeMillis();
        com.tencent.mm.sdk.b.a.uql.b(this.oSW);
        GMTrace.o(3391950422016L, 25272);
        return;
      }
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      GMTrace.i(3392755728384L, 25278);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if ((this.fJC != null) && (!this.fJC.isEmpty())) {
        this.fJC = "";
      }
      if (paramInt2 != -1)
      {
        GMTrace.o(3392755728384L, 25278);
        return;
      }
      GMTrace.o(3392755728384L, 25278);
    }
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      GMTrace.i(3392889946112L, 25279);
      super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
      ap.yY();
      x localx = com.tencent.mm.u.c.wR().Rb(this.fJC);
      if (localx == null)
      {
        v.e("MicroMsg.BizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.fJC);
        GMTrace.o(3392889946112L, 25279);
        return;
      }
      String str = localx.tL();
      paramView = str;
      if (str.toLowerCase().endsWith("@chatroom"))
      {
        paramView = str;
        if (bf.mA(localx.field_nickname)) {
          paramView = getString(R.l.dVj);
        }
      }
      paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      paramContextMenu.setHeaderTitle(h.a(bOZ(), paramView));
      if (com.tencent.mm.j.a.ez(localx.field_type))
      {
        if (!localx.tG()) {
          break label217;
        }
        paramContextMenu.add(paramContextMenuInfo.position, 1, 0, R.l.eyS);
      }
      for (;;)
      {
        paramContextMenu.add(paramContextMenuInfo.position, 2, 0, R.l.eyO);
        paramContextMenu.add(paramContextMenuInfo.position, 3, 0, R.l.eyV);
        GMTrace.o(3392889946112L, 25279);
        return;
        label217:
        paramContextMenu.add(paramContextMenuInfo.position, 1, 0, R.l.eac);
      }
    }
    
    public final void onDestroy()
    {
      GMTrace.i(3392353075200L, 25275);
      ap.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(14683016790016L, 109397);
          if ((!ap.zb()) || (!"officialaccounts".equals(BizConversationUI.a.this.htS)))
          {
            GMTrace.o(14683016790016L, 109397);
            return;
          }
          long l3 = System.currentTimeMillis();
          int j = 0;
          int k = 0;
          int i = 0;
          long l1 = 0L;
          StringBuilder localStringBuilder = new StringBuilder("");
          ap.yY();
          Cursor localCursor = com.tencent.mm.u.c.wW().c(o.hkZ, null, BizConversationUI.a.this.htS);
          int i1;
          if (localCursor != null)
          {
            int i3 = localCursor.getColumnIndex("unReadCount");
            int i4 = localCursor.getColumnIndex("conversationTime");
            int i5 = localCursor.getColumnIndex("flag");
            i1 = localCursor.getCount();
            com.tencent.mm.storage.ae localae = new com.tencent.mm.storage.ae();
            if (localCursor.moveToNext())
            {
              localae.t(localCursor.getLong(i5));
              m = localCursor.getInt(i3);
              long l2;
              int n;
              if (m > 0)
              {
                l2 = localCursor.getLong(i4);
                n = k + 1;
                k = j + m;
                j = m;
                m = k;
                label211:
                if (!localCursor.isFirst()) {
                  break label300;
                }
              }
              label300:
              for (String str = "";; str = ".")
              {
                localStringBuilder.append(str).append(j);
                ap.yY();
                l1 = l2;
                k = n;
                j = m;
                if (!com.tencent.mm.u.c.wW().g(localae)) {
                  break;
                }
                i += 1;
                l1 = l2;
                k = n;
                j = m;
                break;
                int i2 = 0;
                l2 = l1;
                n = k;
                m = j;
                j = i2;
                break label211;
              }
            }
            localCursor.close();
          }
          for (int m = i1;; m = 0)
          {
            com.tencent.mm.plugin.report.service.g.oSF.i(13771, new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j), Long.valueOf(l1 / 1000L), Integer.valueOf(i), localStringBuilder.toString() });
            v.v("MicroMsg.BizConversationUI", "report use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l3) });
            GMTrace.o(14683016790016L, 109397);
            return;
            j = 0;
            k = 0;
            l1 = 0L;
            i = 0;
          }
        }
      });
      if ((this.vZF != 0L) && ("officialaccounts".equals(this.htS))) {
        com.tencent.mm.plugin.report.service.g.oSF.i(13932, new Object[] { Integer.valueOf((int)(System.currentTimeMillis() - this.vZF) / 1000) });
      }
      com.tencent.mm.sdk.b.a.uql.c(this.oSW);
      if (ap.zb())
      {
        ap.yY();
        com.tencent.mm.u.c.wW().b(this.vYW);
      }
      if (this.vYW != null) {
        this.vYW.onDestroy();
      }
      super.onDestroy();
      GMTrace.o(3392353075200L, 25275);
    }
    
    public final void onPause()
    {
      GMTrace.i(3392621510656L, 25277);
      v.i("MicroMsg.BizConversationUI", "on pause");
      ap.yY();
      com.tencent.mm.u.c.wW().Rn(this.htS);
      if (this.vYW != null) {
        this.vYW.onPause();
      }
      super.onPause();
      GMTrace.o(3392621510656L, 25277);
    }
    
    public final void onResume()
    {
      GMTrace.i(3392487292928L, 25276);
      v.v("MicroMsg.BizConversationUI", "on resume");
      if (this.vYW != null) {
        this.vYW.onResume();
      }
      super.onResume();
      GMTrace.o(3392487292928L, 25276);
    }
    
    private static final class a
      extends d
    {
      private String fRk;
      
      public a(Context paramContext, String paramString, k.a parama)
      {
        super(parama);
        GMTrace.i(3418525532160L, 25470);
        this.fRk = paramString;
        GMTrace.o(3418525532160L, 25470);
      }
      
      public final void OL()
      {
        GMTrace.i(3418659749888L, 25471);
        ap.yY();
        setCursor(com.tencent.mm.u.c.wW().c(o.hkZ, this.jzO, this.fRk));
        if (this.uQY != null) {
          this.uQY.OI();
        }
        super.notifyDataSetChanged();
        GMTrace.o(3418659749888L, 25471);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/BizConversationUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */