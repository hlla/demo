package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.p;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.awm;
import com.tencent.mm.protocal.c.bcl;
import com.tencent.mm.protocal.c.mx;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.f;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.aa;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.AbstractTabChildActivity.a;
import com.tencent.mm.ui.HomeUI;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.e.a;
import com.tencent.mm.ui.p.a;
import com.tencent.mm.ui.q;
import com.tencent.mm.y.n;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AddressUI
  extends FragmentActivity
{
  public q vvZ;
  
  public AddressUI()
  {
    GMTrace.i(1737716924416L, 12947);
    GMTrace.o(1737716924416L, 12947);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    GMTrace.i(1737851142144L, 12948);
    super.onCreate(paramBundle);
    paramBundle = aR();
    if (paramBundle.E(16908290) == null)
    {
      this.vvZ = new a();
      this.vvZ.setArguments(getIntent().getExtras());
      paramBundle.aV().a(16908290, this.vvZ).commit();
    }
    GMTrace.o(1737851142144L, 12948);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    GMTrace.i(1737985359872L, 12949);
    GMTrace.o(1737985359872L, 12949);
  }
  
  public static class a
    extends AbstractTabChildActivity.a
    implements com.tencent.mm.y.e
  {
    private final long hXu;
    private ProgressDialog isb;
    public int jZe;
    public int jZf;
    public com.tencent.mm.ui.widget.g jZi;
    List<String> jzO;
    com.tencent.mm.pluginsdk.ui.d krI;
    public n.d lky;
    private Animation lwb;
    public ListView mYn;
    public boolean ngn;
    public TextView uVX;
    public String vSQ;
    private String vSR;
    private BizContactEntranceView vTA;
    private b vTB;
    private b vTC;
    private b vTD;
    private ContactCountView vTE;
    public i vTF;
    boolean vTG;
    private boolean vTH;
    private LinearLayout vTI;
    private Animation vTJ;
    private VerticalScrollBar.a vTK;
    List<String> vTL;
    private Runnable vTM;
    TextView vTo;
    private TextView vTp;
    public a vTq;
    public com.tencent.mm.ui.voicesearch.b vTr;
    private String vTs;
    public String vTt;
    private int vTu;
    private AlphabetScrollBar vTv;
    private LinearLayout vTw;
    public boolean vTx;
    private boolean vTy;
    private k vTz;
    
    public a()
    {
      GMTrace.i(1813952593920L, 13515);
      this.isb = null;
      this.vTt = "";
      this.vTw = null;
      this.vTx = false;
      this.ngn = false;
      this.vTy = false;
      this.vTH = true;
      this.hXu = 180000L;
      this.lky = new n.d()
      {
        public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          GMTrace.i(1844285800448L, 13741);
          switch (paramAnonymousMenuItem.getItemId())
          {
          default: 
            GMTrace.o(1844285800448L, 13741);
            return;
          case 1: 
          case 2: 
            AddressUI.a.this.TK(AddressUI.a.this.vTt);
            GMTrace.o(1844285800448L, 13741);
            return;
          }
          paramAnonymousMenuItem = AddressUI.a.this;
          Object localObject = AddressUI.a.this.vTt;
          ap.yY();
          localObject = com.tencent.mm.u.c.wR().Rb((String)localObject);
          if (com.tencent.mm.j.a.ez(((af)localObject).field_type))
          {
            Intent localIntent = new Intent();
            localIntent.setClass(paramAnonymousMenuItem.uRf.uRz, ContactRemarkInfoModUI.class);
            localIntent.putExtra("Contact_User", ((af)localObject).field_username);
            localIntent.putExtra("view_mode", true);
            paramAnonymousMenuItem.uRf.uRz.startActivity(localIntent);
          }
          GMTrace.o(1844285800448L, 13741);
        }
      };
      this.vTK = new VerticalScrollBar.a()
      {
        public final void rZ(String paramAnonymousString)
        {
          int i = 0;
          GMTrace.i(1781203468288L, 13271);
          if (AddressUI.a.this.getString(R.l.ePn).equals(paramAnonymousString))
          {
            AddressUI.a.this.mYn.setSelection(0);
            GMTrace.o(1781203468288L, 13271);
            return;
          }
          Object localObject = AddressUI.a.this.vTq;
          v.v("MicroMsg.AddressAdapter", "getSections");
          localObject = ((a)localObject).vSW;
          if (localObject == null)
          {
            GMTrace.o(1781203468288L, 13271);
            return;
          }
          if ("↑".equals(paramAnonymousString))
          {
            AddressUI.a.this.mYn.setSelection(0);
            GMTrace.o(1781203468288L, 13271);
            return;
          }
          if ("☆".equals(paramAnonymousString))
          {
            AddressUI.a.this.mYn.setSelection(AddressUI.a.this.mYn.getHeaderViewsCount());
            GMTrace.o(1781203468288L, 13271);
            return;
          }
          do
          {
            i += 1;
            if ((i >= localObject.length) || (localObject[i] == null)) {
              break;
            }
          } while (!localObject[i].equals(paramAnonymousString));
          i = AddressUI.a.this.vTq.getPositionForSection(i);
          AddressUI.a.this.mYn.setSelection(i + AddressUI.a.this.mYn.getHeaderViewsCount());
          GMTrace.o(1781203468288L, 13271);
          return;
          GMTrace.o(1781203468288L, 13271);
        }
      };
      this.krI = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(1832474640384L, 13653);
          if (paramAnonymousInt1 < 2)
          {
            GMTrace.o(1832474640384L, 13653);
            return;
          }
          if (!AddressUI.a.this.vTx) {
            AddressUI.a.this.vTx = true;
          }
          GMTrace.o(1832474640384L, 13653);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          GMTrace.i(1832608858112L, 13654);
          if (paramAnonymousInt == 2) {
            com.tencent.mm.bl.d.bNY().cJ(AddressUI.class.getName() + ".Listview", 4);
          }
          GMTrace.o(1832608858112L, 13654);
        }
      });
      this.jzO = new LinkedList();
      this.vTL = new LinkedList();
      this.vTM = new Runnable()
      {
        public final void run()
        {
          GMTrace.i(1738924883968L, 12956);
          AddressUI.a locala = AddressUI.a.this;
          LauncherUI localLauncherUI = (LauncherUI)locala.uRf.uRz;
          if ((localLauncherUI == null) || (localLauncherUI.uPX.lBf == 1))
          {
            BackwardSupportUtil.c.a(locala.mYn);
            new ad().postDelayed(new AddressUI.a.3(locala), 300L);
          }
          GMTrace.o(1738924883968L, 12956);
        }
      };
      GMTrace.o(1813952593920L, 13515);
    }
    
    private void bXA()
    {
      GMTrace.i(1814892118016L, 13522);
      this.jzO = new LinkedList();
      this.vTL = new LinkedList();
      com.tencent.mm.bb.d.bGH();
      this.jzO.add("tmessage");
      this.vTL.addAll(this.jzO);
      if (!this.jzO.contains("officialaccounts")) {
        this.jzO.add("officialaccounts");
      }
      this.jzO.add("helper_entry");
      if (this.vTq != null) {
        this.vTq.cK(this.jzO);
      }
      if (this.vTr != null) {
        this.vTr.cK(this.vTL);
      }
      GMTrace.o(1814892118016L, 13522);
    }
    
    public final void TK(String paramString)
    {
      GMTrace.i(16014456651776L, 119317);
      ap.yY();
      com.tencent.mm.u.c.wR().b(this.vTq);
      ap.yY();
      x localx = com.tencent.mm.u.c.wR().Rb(paramString);
      localx.td();
      o.t(localx);
      if (o.dH(paramString))
      {
        ap.yY();
        com.tencent.mm.u.c.wR().Rh(paramString);
        ap.yY();
        com.tencent.mm.u.c.xa().gb(paramString);
      }
      for (;;)
      {
        this.vTq.cU(paramString, 5);
        ap.yY();
        com.tencent.mm.u.c.wR().a(this.vTq);
        GMTrace.o(16014456651776L, 119317);
        return;
        ap.yY();
        com.tencent.mm.u.c.wR().a(paramString, localx);
      }
    }
    
    public final boolean WV()
    {
      GMTrace.i(1814355247104L, 13518);
      GMTrace.o(1814355247104L, 13518);
      return true;
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.y.k paramk)
    {
      GMTrace.i(1814757900288L, 13521);
      if (this.isb != null)
      {
        this.isb.dismiss();
        this.isb = null;
      }
      if (!u.bp(this.uRf.uRz))
      {
        GMTrace.o(1814757900288L, 13521);
        return;
      }
      if (p.a.a(this.uRf.uRz, paramInt1, paramInt2, paramString, 4))
      {
        GMTrace.o(1814757900288L, 13521);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        GMTrace.o(1814757900288L, 13521);
        return;
      }
      GMTrace.o(1814757900288L, 13521);
    }
    
    public final void bOX()
    {
      GMTrace.i(1816502730752L, 13534);
      if (this.vTz != null) {
        k.bXN();
      }
      GMTrace.o(1816502730752L, 13534);
    }
    
    protected final void bOb()
    {
      GMTrace.i(1815160553472L, 13524);
      v.v("MicroMsg.AddressUI", "address ui on create");
      v.v("MicroMsg.AddressUI", "on address ui create");
      this.vTx = false;
      this.ngn = false;
      this.vTy = false;
      this.vSQ = null;
      this.vSR = null;
      this.vTs = null;
      ap.vd().a(138, this);
      this.vSQ = "@all.contact.without.chatroom";
      this.vSR = getStringExtra("Contact_GroupFilter_Str");
      this.vTs = getString(R.l.eqA);
      this.vTu = getIntExtra("List_Type", 2);
      v.v("MicroMsg.AddressUI", "on address ui init view, %s", new Object[] { getResources().getDisplayMetrics() });
      if (this.mYn != null)
      {
        if (this.vTz != null) {
          this.mYn.removeHeaderView(this.vTz);
        }
        if (this.vTA != null) {
          this.mYn.removeHeaderView(this.vTA);
        }
        if (this.vTB != null) {
          this.mYn.removeHeaderView(this.vTB);
        }
        if (this.vTD != null) {
          this.mYn.removeHeaderView(this.vTD);
        }
      }
      this.mYn = ((ListView)findViewById(R.h.bnu));
      this.mYn.setScrollingCacheEnabled(false);
      this.vTo = ((TextView)findViewById(R.h.bLF));
      this.vTo.setText(R.l.dCo);
      this.uVX = ((TextView)findViewById(R.h.bLY));
      this.uVX.setText(R.l.dCq);
      this.vTp = ((TextView)findViewById(R.h.bMb));
      this.vTp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(1713020862464L, 12763);
          GMTrace.o(1713020862464L, 12763);
        }
      });
      this.vTq = new a(this.uRf.uRz, this.vSQ, this.vSR, this.vTu);
      this.mYn.setAdapter(null);
      this.vTq.a(new e.a()
      {
        public final void OI()
        {
          GMTrace.i(1794759458816L, 13372);
          AddressUI.a locala = AddressUI.a.this;
          AddressUI.a.this.vTq.getCount();
          locala.vTo.setVisibility(8);
          locala.mYn.setVisibility(0);
          AddressUI.a.this.vTq.bXx();
          GMTrace.o(1794759458816L, 13372);
        }
        
        public final void OJ()
        {
          GMTrace.i(1794893676544L, 13373);
          GMTrace.o(1794893676544L, 13373);
        }
      });
      this.vTq.vTd = true;
      this.vTq.l(this);
      this.vTq.a(new MMSlideDelView.c()
      {
        public final int bY(View paramAnonymousView)
        {
          GMTrace.i(1830327156736L, 13637);
          int i = AddressUI.a.this.mYn.getPositionForView(paramAnonymousView);
          GMTrace.o(1830327156736L, 13637);
          return i;
        }
      });
      this.vTq.a(new MMSlideDelView.f()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt)
        {
          GMTrace.i(1714228822016L, 12772);
          AddressUI.a.this.mYn.performItemClick(paramAnonymousView, paramAnonymousInt, 0L);
          GMTrace.o(1714228822016L, 12772);
        }
      });
      this.vTq.a(new MMSlideDelView.e()
      {
        public final void aQ(Object paramAnonymousObject)
        {
          GMTrace.i(1844017364992L, 13739);
          if (paramAnonymousObject == null)
          {
            v.e("MicroMsg.AddressUI", "onItemDel object null");
            GMTrace.o(1844017364992L, 13739);
            return;
          }
          AddressUI.a.this.TK(paramAnonymousObject.toString());
          GMTrace.o(1844017364992L, 13739);
        }
      });
      this.vTr = new com.tencent.mm.ui.voicesearch.b(this.uRf.uRz, 1);
      this.vTr.lN(true);
      this.vTI = new LinearLayout(this.uRf.uRz);
      this.vTI.setOrientation(1);
      this.mYn.addHeaderView(this.vTI);
      this.vTC = new b(this.uRf.uRz, b.a.vTT);
      this.vTI.addView(this.vTC);
      ap.yY();
      ((Boolean)com.tencent.mm.u.c.vr().get(w.a.uAb, Boolean.valueOf(false))).booleanValue();
      this.vTC.setVisible(false);
      this.vTz = new k(this.uRf.uRz);
      this.vTI.addView(this.vTz);
      this.vTB = new b(this.uRf.uRz, b.a.vTR);
      this.vTI.addView(this.vTB);
      this.vTB.setVisible(true);
      this.vTD = new b(this.uRf.uRz, b.a.vTS);
      this.vTI.addView(this.vTD);
      this.vTD.setVisible(true);
      ListView localListView = this.mYn;
      ContactCountView localContactCountView = new ContactCountView(this.uRf.uRz);
      this.vTE = localContactCountView;
      localListView.addFooterView(localContactCountView, null, false);
      if (com.tencent.mm.bb.d.Jr("brandservice"))
      {
        this.vTA = new BizContactEntranceView(this.uRf.uRz);
        this.vTI.addView(this.vTA);
        this.vTA.setVisible(true);
        this.vTF = new i(this.uRf.uRz, new i.a()
        {
          public final void BF(int paramAnonymousInt)
          {
            GMTrace.i(1786840612864L, 13313);
            if (AddressUI.a.this.vTF == null)
            {
              GMTrace.o(1786840612864L, 13313);
              return;
            }
            if (paramAnonymousInt <= 0)
            {
              AddressUI.a.this.vTF.setVisibility(8);
              GMTrace.o(1786840612864L, 13313);
              return;
            }
            AddressUI.a.this.vTF.setVisibility(0);
            GMTrace.o(1786840612864L, 13313);
          }
        });
        if (this.vTF.bXL() <= 0) {
          this.vTF.setVisibility(8);
        }
        this.vTI.addView(this.vTF);
      }
      this.jZi = new com.tencent.mm.ui.widget.g(this.uRf.uRz);
      this.vTq.vTb = new a.a() {};
      this.mYn.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          GMTrace.i(1842138316800L, 13725);
          paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
          if (AddressUI.a.this.vTr == null) {}
          for (paramAnonymousAdapterView = AddressUI.a.this.vTr;; paramAnonymousAdapterView = Boolean.valueOf(AddressUI.a.this.vTr.wpW))
          {
            v.i("MicroMsg.AddressUI", paramAnonymousAdapterView);
            if ((paramAnonymousInt != 0) || ("@biz.contact".equals(AddressUI.a.this.vSQ))) {
              break;
            }
            GMTrace.o(1842138316800L, 13725);
            return;
          }
          if (paramAnonymousInt < AddressUI.a.this.mYn.getHeaderViewsCount())
          {
            GMTrace.o(1842138316800L, 13725);
            return;
          }
          paramAnonymousInt -= AddressUI.a.this.mYn.getHeaderViewsCount();
          Object localObject;
          if ((AddressUI.a.this.vTr != null) && (AddressUI.a.this.vTr.wpW))
          {
            boolean bool1 = AddressUI.a.this.vTr.nF(paramAnonymousInt);
            boolean bool2 = AddressUI.a.this.vTr.Cf(paramAnonymousInt);
            v.i("MicroMsg.AddressUI", "onItemClick " + bool2);
            if (bool2)
            {
              AddressUI.a.this.vTr.Us("");
              GMTrace.o(1842138316800L, 13725);
              return;
            }
            if (bool1)
            {
              paramAnonymousView = AddressUI.a.this.vTr.Ce(paramAnonymousInt);
              paramAnonymousAdapterView = paramAnonymousView.trH.tXF;
              ap.yY();
              localObject = com.tencent.mm.u.c.wR().Rb(paramAnonymousAdapterView);
              if (com.tencent.mm.j.a.ez(((af)localObject).field_type))
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
                  com.tencent.mm.bb.d.b(AddressUI.a.this.uRf.uRz, "profile", ".ui.ContactInfoUI", paramAnonymousView);
                }
                GMTrace.o(1842138316800L, 13725);
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
                com.tencent.mm.bb.d.b(AddressUI.a.this.uRf.uRz, "profile", ".ui.ContactInfoUI", (Intent)localObject);
                GMTrace.o(1842138316800L, 13725);
                return;
              }
              catch (IOException localIOException)
              {
                for (;;)
                {
                  v.printErrStackTrace("MicroMsg.AddressUI", localIOException, "", new Object[0]);
                }
              }
            }
            paramAnonymousAdapterView = AddressUI.a.this.vTr.kK(paramAnonymousInt);
            if (paramAnonymousAdapterView == null)
            {
              v.e("MicroMsg.AddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(AddressUI.a.this.vTr.getCount()), Integer.valueOf(paramAnonymousInt) });
              GMTrace.o(1842138316800L, 13725);
              return;
            }
            paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
            if (o.fu(paramAnonymousAdapterView))
            {
              paramAnonymousAdapterView = new Intent(AddressUI.a.this.uRf.uRz, AddressUI.class);
              paramAnonymousAdapterView.putExtra("Contact_GroupFilter_Type", "@biz.contact");
              AddressUI.a.this.startActivity(paramAnonymousAdapterView);
              GMTrace.o(1842138316800L, 13725);
              return;
            }
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
            paramAnonymousView.putExtra("Contact_Scene", 3);
            if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0)) {
              com.tencent.mm.bb.d.b(AddressUI.a.this.uRf.uRz, "profile", ".ui.ContactInfoUI", paramAnonymousView);
            }
            GMTrace.o(1842138316800L, 13725);
            return;
          }
          paramAnonymousAdapterView = (f)AddressUI.a.this.vTq.yL(paramAnonymousInt);
          if (paramAnonymousAdapterView != null)
          {
            paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
            paramAnonymousView = AddressUI.a.this;
            if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.length() <= 0))
            {
              GMTrace.o(1842138316800L, 13725);
              return;
            }
            if (o.fu(paramAnonymousAdapterView))
            {
              v.e("MicroMsg.AddressUI", "error, 4.5 do not contain this contact %s", new Object[] { paramAnonymousAdapterView });
              GMTrace.o(1842138316800L, 13725);
              return;
            }
            localObject = new Intent();
            ((Intent)localObject).putExtra("Contact_User", paramAnonymousAdapterView);
            if (o.eS(paramAnonymousAdapterView)) {
              ((Intent)localObject).putExtra("Is_group_card", true);
            }
            if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
            {
              e.a((Intent)localObject, paramAnonymousAdapterView);
              com.tencent.mm.bb.d.b(paramAnonymousView.uRf.uRz, "profile", ".ui.ContactInfoUI", (Intent)localObject);
            }
          }
          GMTrace.o(1842138316800L, 13725);
        }
      });
      this.mYn.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          GMTrace.i(1806704836608L, 13461);
          v.i("MicroMsg.AddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = " + paramAnonymousInt);
          if (paramAnonymousInt < AddressUI.a.this.mYn.getHeaderViewsCount())
          {
            v.w("MicroMsg.AddressUI", "on item long click, but match header view");
            GMTrace.o(1806704836608L, 13461);
            return true;
          }
          if ((AddressUI.a.this.vTr != null) && (AddressUI.a.this.vTr.wpW))
          {
            GMTrace.o(1806704836608L, 13461);
            return true;
          }
          paramAnonymousAdapterView = (f)AddressUI.a.this.vTq.yL(paramAnonymousInt - AddressUI.a.this.mYn.getHeaderViewsCount());
          if (paramAnonymousAdapterView == null)
          {
            v.e("MicroMsg.AddressUI", "cont is null. position:%d, header count:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(AddressUI.a.this.mYn.getHeaderViewsCount()) });
            GMTrace.o(1806704836608L, 13461);
            return true;
          }
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          if ((o.fu(paramAnonymousAdapterView)) || (o.fv(paramAnonymousAdapterView)))
          {
            GMTrace.o(1806704836608L, 13461);
            return true;
          }
          AddressUI.a.this.vTt = paramAnonymousAdapterView;
          AddressUI.a.this.jZi.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, AddressUI.a.this, AddressUI.a.this.lky, AddressUI.a.this.jZe, AddressUI.a.this.jZf);
          GMTrace.o(1806704836608L, 13461);
          return true;
        }
      });
      this.mYn.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          GMTrace.i(1795162112000L, 13375);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            GMTrace.o(1795162112000L, 13375);
            return false;
            AddressUI.a.this.aqY();
            AddressUI.a.this.jZe = ((int)paramAnonymousMotionEvent.getRawX());
            AddressUI.a.this.jZf = ((int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      this.mYn.setOnScrollListener(this.krI);
      this.mYn.setDrawingCacheEnabled(false);
      this.vTv = ((AlphabetScrollBar)findViewById(R.h.bnE));
      this.vTv.voh = this.vTK;
      ap.yY();
      com.tencent.mm.u.c.wR().a(this.vTq);
      if (this.vTF != null) {
        w.DH().a(this.vTF, null);
      }
      GMTrace.o(1815160553472L, 13524);
    }
    
    protected final void bOc()
    {
      GMTrace.i(1815294771200L, 13525);
      v.v("MicroMsg.AddressUI", "address ui on resume");
      long l = System.currentTimeMillis();
      ap.yY();
      if (l - u.d((Long)com.tencent.mm.u.c.vr().get(340226, null)) >= 180000L) {
        bXC();
      }
      Object localObject;
      if (this.vTH)
      {
        this.vTH = false;
        this.vTG = false;
        bXA();
        this.mYn.setAdapter(this.vTq);
        this.mYn.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(1715973652480L, 12785);
            v.i("MicroMsg.AddressUI", "post to first init finish");
            View localView = AddressUI.a.this.findViewById(R.h.cbM);
            if (localView != null)
            {
              localView.setVisibility(8);
              localView.startAnimation(AnimationUtils.loadAnimation(AddressUI.a.this.uRf.uRz, R.a.aQY));
            }
            GMTrace.o(1715973652480L, 12785);
          }
        });
        this.vTr.lM(false);
        if (this.vTA != null)
        {
          localObject = this.vTA;
          ((BizContactEntranceView)localObject).bXD();
          ((BizContactEntranceView)localObject).setVisible(true);
        }
        if (this.vTF != null)
        {
          if (this.vTF.bXL() > 0) {
            break label416;
          }
          this.vTF.setVisibility(8);
        }
      }
      for (;;)
      {
        ap.yY();
        this.vTx = ((Boolean)com.tencent.mm.u.c.vr().get(12296, Boolean.valueOf(false))).booleanValue();
        if (this.vTu == 2)
        {
          ap.yY();
          localObject = com.tencent.mm.u.c.wR().Rb(m.xL());
          if ((localObject != null) && ((!com.tencent.mm.j.a.ez(((af)localObject).field_type)) || (!u.mA(((af)localObject).field_conRemark)) || (!u.mA(((af)localObject).field_conRemarkPYFull)) || (!u.mA(((af)localObject).field_conRemarkPYShort))))
          {
            ((x)localObject).tc();
            ((x)localObject).bP("");
            ((x)localObject).bV("");
            ((x)localObject).bW("");
            ap.yY();
            com.tencent.mm.u.c.wR().a(m.xL(), (x)localObject);
          }
        }
        if (this.vTr != null) {
          this.vTr.onResume();
        }
        this.vTq.uMW = false;
        ae.v(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(1777982242816L, 13247);
            a locala = AddressUI.a.this.vTq;
            v.i(locala.TAG, "newcursor resume ");
            locala.uMQ = true;
            locala.aR("resume", true);
            GMTrace.o(1777982242816L, 13247);
          }
        });
        if (this.vTz != null)
        {
          this.vTz.vVL = true;
          k.bXN();
        }
        localObject = (LauncherUI)this.uRf.uRz;
        if (localObject != null) {
          ((LauncherUI)localObject).uPX.Y(this.vTM);
        }
        GMTrace.o(1815294771200L, 13525);
        return;
        if (!this.vTG) {
          break;
        }
        this.vTG = false;
        com.tencent.mm.sdk.f.e.b(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(1730737602560L, 12895);
            Process.setThreadPriority(10);
            AddressUI.a.this.bXB();
            GMTrace.o(1730737602560L, 12895);
          }
        }, "AddressUI_updateUIData", 4);
        this.vTE.bXE();
        break;
        label416:
        this.vTF.setVisibility(0);
      }
    }
    
    protected final void bOd()
    {
      GMTrace.i(1815563206656L, 13527);
      GMTrace.o(1815563206656L, 13527);
    }
    
    protected final void bOe()
    {
      GMTrace.i(1815697424384L, 13528);
      v.i("MicroMsg.AddressUI", "AddressUI on Pause");
      ap.yY();
      com.tencent.mm.u.c.vr().set(340226, Long.valueOf(System.currentTimeMillis()));
      ap.yY();
      com.tencent.mm.u.c.vr().set(12296, Boolean.valueOf(this.vTx));
      if (this.vTr != null) {
        this.vTr.onPause();
      }
      this.vTq.bXy();
      ae.v(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(1793551499264L, 13363);
          AddressUI.a.this.vTq.pause();
          GMTrace.o(1793551499264L, 13363);
        }
      });
      if (this.vTz != null) {
        this.vTz.vVL = false;
      }
      LauncherUI localLauncherUI = (LauncherUI)this.uRf.uRz;
      if (localLauncherUI != null) {
        localLauncherUI.uPX.Z(this.vTM);
      }
      GMTrace.o(1815697424384L, 13528);
    }
    
    protected final void bOf()
    {
      GMTrace.i(1815831642112L, 13529);
      GMTrace.o(1815831642112L, 13529);
    }
    
    protected final void bOg()
    {
      GMTrace.i(1815965859840L, 13530);
      v.v("MicroMsg.AddressUI", "onDestory");
      if (this.vTv != null) {
        this.vTv.voh = null;
      }
      ap.vd().b(138, this);
      Object localObject;
      if (this.vTq != null)
      {
        this.vTq.ke(true);
        localObject = this.vTq;
        if (((a)localObject).hAM != null)
        {
          ((a)localObject).hAM.detach();
          ((a)localObject).hAM = null;
        }
        this.vTq.bOB();
      }
      if (this.vTr != null)
      {
        this.vTr.detach();
        this.vTr.aEP();
      }
      if ((ap.zb()) && (this.vTq != null))
      {
        ap.yY();
        com.tencent.mm.u.c.wR().b(this.vTq);
      }
      if ((ap.zb()) && (this.vTF != null)) {
        w.DH().a(this.vTF);
      }
      if (this.vTz != null)
      {
        localObject = this.vTz;
        if (ap.zb()) {
          com.tencent.mm.av.l.Kz().f(((k)localObject).vVK);
        }
        this.vTz = null;
      }
      if (this.vTA != null) {
        this.vTA = null;
      }
      if (this.vTB != null) {
        this.vTB = null;
      }
      if (this.vTD != null) {
        this.vTD = null;
      }
      GMTrace.o(1815965859840L, 13530);
    }
    
    public final void bOh()
    {
      GMTrace.i(1816368513024L, 13533);
      v.v("MicroMsg.AddressUI", "request to top");
      if (this.mYn != null) {
        BackwardSupportUtil.c.a(this.mYn);
      }
      GMTrace.o(1816368513024L, 13533);
    }
    
    public final void bOi()
    {
      GMTrace.i(1816100077568L, 13531);
      if (this.vTq != null)
      {
        a locala = this.vTq;
        locala.vTh.clear();
        locala.vTf.clear();
        locala.vTg = false;
      }
      v.i("MicroMsg.INIT", "KEVIN Address turnTobg");
      if (this.vTA != null) {
        this.vTA.destroyDrawingCache();
      }
      if (this.vTB != null) {
        this.vTB.destroyDrawingCache();
      }
      if (this.vTD != null) {
        this.vTD.destroyDrawingCache();
      }
      if (this.vTE != null) {
        this.vTE.destroyDrawingCache();
      }
      if (this.vTz != null) {
        this.vTz.destroyDrawingCache();
      }
      GMTrace.o(1816100077568L, 13531);
    }
    
    public final void bOj()
    {
      GMTrace.i(1816234295296L, 13532);
      v.v("MicroMsg.INIT", "KEVIN Address turnTofg");
      GMTrace.o(1816234295296L, 13532);
    }
    
    public final void bXB()
    {
      try
      {
        GMTrace.i(1815428988928L, 13526);
        long l = System.currentTimeMillis();
        bXA();
        v.i("MicroMsg.AddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - l));
        l = System.currentTimeMillis();
        if (this.vTq != null)
        {
          v.v("MicroMsg.AddressUI", "post to do refresh");
          ae.v(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(1716242087936L, 12787);
              AddressUI.a.this.vTq.bXz();
              GMTrace.o(1716242087936L, 12787);
            }
          });
        }
        if (this.vTr != null) {
          ae.v(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(1746172641280L, 13010);
              v.v("MicroMsg.AddressUI", "post search adapter to do refresh");
              AddressUI.a.this.vTr.a(null, null);
              GMTrace.o(1746172641280L, 13010);
            }
          });
        }
        v.i("MicroMsg.AddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - l));
        GMTrace.o(1815428988928L, 13526);
        return;
      }
      finally {}
    }
    
    public final void bXC()
    {
      GMTrace.i(1817710690304L, 13543);
      if (this.mYn != null) {
        this.mYn.setSelection(0);
      }
      GMTrace.o(1817710690304L, 13543);
    }
    
    public final boolean bin()
    {
      GMTrace.i(1814221029376L, 13517);
      GMTrace.o(1814221029376L, 13517);
      return false;
    }
    
    protected final int getLayoutId()
    {
      GMTrace.i(1814086811648L, 13516);
      int i = R.i.cTw;
      GMTrace.o(1814086811648L, 13516);
      return i;
    }
    
    public final void ls(boolean paramBoolean)
    {
      GMTrace.i(1814489464832L, 13519);
      if (this.vTv != null)
      {
        if (this.lwb == null)
        {
          this.lwb = AnimationUtils.loadAnimation(this.uRf.uRz, R.a.aQV);
          this.lwb.setDuration(200L);
        }
        if (this.vTJ == null)
        {
          this.vTJ = AnimationUtils.loadAnimation(this.uRf.uRz, R.a.aQV);
          this.vTJ.setDuration(200L);
        }
        if (paramBoolean)
        {
          if (this.vTv.getVisibility() != 0)
          {
            this.vTv.setVisibility(0);
            this.vTv.startAnimation(this.lwb);
            GMTrace.o(1814489464832L, 13519);
          }
        }
        else if (4 != this.vTv.getVisibility())
        {
          this.vTv.setVisibility(8);
          this.vTv.startAnimation(this.vTJ);
        }
      }
      GMTrace.o(1814489464832L, 13519);
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      GMTrace.i(1815026335744L, 13523);
      v.i("MicroMsg.AddressUI", "onAcvityResult requestCode: %d", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt1 == 6) && (paramInt2 == -1))
      {
        bPa();
        finish();
        GMTrace.o(1815026335744L, 13523);
        return;
      }
      if (paramInt2 != -1)
      {
        GMTrace.o(1815026335744L, 13523);
        return;
      }
      switch (paramInt1)
      {
      default: 
        GMTrace.o(1815026335744L, 13523);
        return;
      }
      if (this.uOa) {
        bOZ().setResult(-1);
      }
      for (;;)
      {
        finish();
        break;
        bOZ().setResult(-1, paramIntent);
      }
    }
    
    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      GMTrace.i(1814623682560L, 13520);
      super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
      paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      ap.yY();
      x localx = com.tencent.mm.u.c.wR().Rb(this.vTt);
      if (localx == null)
      {
        v.e("MicroMsg.AddressUI", "onCreateContextMenu, contact is null, username = " + this.vTt);
        GMTrace.o(1814623682560L, 13520);
        return;
      }
      if (m.xL().equals(localx.field_username))
      {
        GMTrace.o(1814623682560L, 13520);
        return;
      }
      if (o.eS(this.vTt))
      {
        paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.h.a(paramView.getContext(), localx.tL()));
        paramContextMenu.add(paramContextMenuInfo.position, 2, 0, R.l.dCn);
        GMTrace.o(1814623682560L, 13520);
        return;
      }
      if ((o.fh(this.vTt)) || (o.fx(this.vTt)))
      {
        GMTrace.o(1814623682560L, 13520);
        return;
      }
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.h.a(paramView.getContext(), localx.tL()));
      if ((com.tencent.mm.j.a.ez(localx.field_type)) && (localx.field_deleteFlag != 1)) {
        paramContextMenu.add(paramContextMenuInfo.position, 7, 0, R.l.dYF);
      }
      GMTrace.o(1814623682560L, 13520);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/AddressUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */