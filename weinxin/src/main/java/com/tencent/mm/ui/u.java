package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.mk;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.a.qk.b;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bg;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mm.ui.tools.q;

public final class u
  extends q
{
  private static final int[] uUd;
  public LayoutInflater Du;
  public Context mContext;
  public SparseArray<c> uTZ;
  private a uUb;
  t uUc;
  
  static
  {
    GMTrace.i(1702954532864L, 12688);
    uUd = new int[] { 2, 1, 4, 10, 3, Integer.MAX_VALUE };
    GMTrace.o(1702954532864L, 12688);
  }
  
  public u(ActionBarActivity paramActionBarActivity)
  {
    super(paramActionBarActivity);
    GMTrace.i(1701880791040L, 12680);
    this.uUc = null;
    this.mContext = paramActionBarActivity;
    this.Du = LayoutInflater.from(paramActionBarActivity);
    lI(false);
    this.uUc = t.bQo();
    GMTrace.o(1701880791040L, 12680);
  }
  
  public static d zr(int paramInt)
  {
    GMTrace.i(1702283444224L, 12683);
    Object localObject = aa.getContext();
    switch (paramInt)
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      GMTrace.o(1702283444224L, 12683);
      return (d)localObject;
      if (HomeUI.uOq.booleanValue())
      {
        localObject = new d(1, ((Context)localObject).getString(R.l.eAB), "", R.k.dxV, R.e.aWt);
      }
      else
      {
        localObject = new d(1, ((Context)localObject).getString(R.l.eAB), "", R.k.dxW, 0);
        continue;
        if (HomeUI.uOr.booleanValue())
        {
          localObject = new d(2, ((Context)localObject).getString(R.l.eAE), "", R.k.dye, R.e.aWt);
        }
        else
        {
          localObject = new d(2, ((Context)localObject).getString(R.l.eAE), "", R.k.dyf, 0);
          continue;
          localObject = new d(3, ((Context)localObject).getString(R.l.eAF), "", R.k.dvh, 0);
          continue;
          if (1 == bf.getInt(com.tencent.mm.i.g.sV().getValue("VOIPCallType"), 0))
          {
            localObject = new d(4, ((Context)localObject).getString(R.l.eAG), "", R.k.dyp, 0);
          }
          else
          {
            localObject = new d(4, ((Context)localObject).getString(R.l.eAC), "", R.k.dxX, 0);
            continue;
            localObject = new d(5, ((Context)localObject).getString(R.l.eST), "", R.k.dyk, 0);
            continue;
            localObject = new d(6, ((Context)localObject).getString(R.l.eSI), "", R.k.dyb, 0);
            continue;
            localObject = new d(7, ((Context)localObject).getString(R.l.eSJ), "", R.k.dxZ, 0);
            continue;
            localObject = new d(8, ((Context)localObject).getString(R.l.ecR), "", R.k.dya, 0);
            continue;
            localObject = new d(9, ((Context)localObject).getString(R.l.eSV), "", R.k.dyi, 0);
            continue;
            localObject = new d(10, ((Context)localObject).getString(R.l.ejX), "", R.k.dyl, 0);
            continue;
            localObject = new d(11, ((Context)localObject).getString(R.l.eWG), "", R.k.dyh, 0);
            continue;
            localObject = new d(12, ((Context)localObject).getString(R.l.eph), "", R.k.dyd, 0);
            continue;
            localObject = new d(13, ((Context)localObject).getString(R.l.eVB), "", R.k.dyo, 0);
            continue;
            localObject = new d(14, ((Context)localObject).getString(R.l.eCU), "", R.k.dyj, 0);
            continue;
            localObject = new d(15, ((Context)localObject).getString(R.l.dPb), "", R.k.dxY, 0);
            continue;
            localObject = new d(16, ((Context)localObject).getString(R.l.eRN), "", R.k.dyq, 0);
            continue;
            localObject = new d(17, ((Context)localObject).getString(R.l.eAs), "", R.k.dyg, 0);
            continue;
            localObject = new d(18, ((Context)localObject).getString(R.l.ejY), "", R.k.dym, 0);
            continue;
            localObject = new d(19, ((Context)localObject).getString(R.l.ejZ), "", R.k.dsB, 0);
            continue;
            ap.yY();
            if (((Integer)com.tencent.mm.u.c.vr().get(w.a.uCm, Integer.valueOf(0))).intValue() > 1) {
              break;
            }
            localObject = new d(20, ((Context)localObject).getString(R.l.dCI), "", R.k.dyV, 0);
            continue;
            localObject = new d(Integer.MAX_VALUE, ((Context)localObject).getString(R.l.eSq), "", R.k.dyc, 0);
            continue;
            localObject = new d(2147483645, ((Context)localObject).getString(R.l.eSh), "", R.k.dyc, 0);
            continue;
            ap.yY();
            if (((Integer)com.tencent.mm.u.c.vr().get(w.a.uCm, Integer.valueOf(0))).intValue() != 8) {
              break;
            }
            localObject = new d(22, ((Context)localObject).getString(R.l.fiz), "", R.k.dxU, 0);
            continue;
            localObject = new d(2147483646, "TIT", "", R.k.dxZ, 0);
          }
        }
      }
    }
  }
  
  protected final BaseAdapter aew()
  {
    GMTrace.i(1702417661952L, 12684);
    if (this.uUb == null) {
      this.uUb = new a((byte)0);
    }
    a locala = this.uUb;
    GMTrace.o(1702417661952L, 12684);
    return locala;
  }
  
  public final boolean dL()
  {
    int j = 0;
    GMTrace.i(1702015008768L, 12681);
    this.uUc.kx(false);
    if (this.uUc.uTZ.size() != 0) {
      this.uTZ = this.uUc.uTZ;
    }
    try
    {
      ap.yY();
      if (((Boolean)com.tencent.mm.u.c.vr().get(w.a.uAt, Boolean.valueOf(false))).booleanValue())
      {
        int i = j;
        while (i < this.uTZ.size())
        {
          j = ((c)this.uTZ.get(i)).uUi.uUl;
          if (j != 2147483646)
          {
            i += 1;
            continue;
            v.d("MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one");
            if (this.uTZ != null) {
              this.uTZ.clear();
            }
            for (;;)
            {
              i = 0;
              while (i < uUd.length)
              {
                c localc = new c(zr(uUd[i]));
                this.uTZ.put(i, localc);
                i += 1;
              }
              this.uTZ = new SparseArray();
            }
          }
        }
        if (i == this.uTZ.size()) {
          this.uTZ.put(this.uTZ.size(), new c(zr(2147483646)));
        }
      }
    }
    catch (Exception localException)
    {
      boolean bool;
      for (;;) {}
    }
    if (this.uUb != null) {
      this.uUb.notifyDataSetChanged();
    }
    bool = super.dL();
    GMTrace.o(1702015008768L, 12681);
    return bool;
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, final View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    boolean bool2 = false;
    GMTrace.i(1702149226496L, 12682);
    if ((this.mContext instanceof ActionBarActivity)) {
      ((ActionBarActivity)this.mContext).aQ();
    }
    int j = ((c)this.uTZ.get(paramInt)).uUi.uUl;
    com.tencent.mm.plugin.report.service.g.oSF.i(11104, new Object[] { Integer.valueOf(j) });
    switch (j)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      for (;;)
      {
        this.uUc.zq(j);
        dismiss();
        GMTrace.o(1702149226496L, 12682);
        return;
        new Intent().putExtra("invite_friend_scene", 2);
        com.tencent.mm.bb.d.b(this.mContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
        continue;
        paramAdapterView = new Intent(this.mContext, SelectContactUI.class);
        paramAdapterView.putExtra("titile", this.mContext.getString(R.l.dCJ));
        paramAdapterView.putExtra("list_type", 0);
        paramAdapterView.putExtra("list_attr", com.tencent.mm.ui.contact.s.q(new int[] { com.tencent.mm.ui.contact.s.vWQ, 256, 512 }));
        paramAdapterView.putExtra("scene", 7);
        this.mContext.startActivity(paramAdapterView);
        continue;
        paramAdapterView = new Intent();
        paramAdapterView.setClassName(this.mContext, "com.tencent.mm.ui.tools.ShareImageRedirectUI");
        this.mContext.startActivity(paramAdapterView);
        continue;
        paramAdapterView = new qk();
        paramAdapterView.fXk.fXm = true;
        com.tencent.mm.sdk.b.a.uql.m(paramAdapterView);
        paramAdapterView = paramAdapterView.fXl.fXo;
        if (!bf.mA(paramAdapterView))
        {
          v.v("MicroMsg.PlusSubMenuHelper", "Talkroom is on: " + paramAdapterView);
          com.tencent.mm.ui.base.g.b(this.mContext, this.mContext.getString(R.l.eXr), "", this.mContext.getString(R.l.dHL), this.mContext.getString(R.l.dGk), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(3093852848128L, 23051);
              qk localqk = new qk();
              localqk.fXk.fXn = true;
              com.tencent.mm.sdk.b.a.uql.m(localqk);
              VoipAddressUI.eY(u.this.mContext);
              paramAnonymousDialogInterface.dismiss();
              GMTrace.o(3093852848128L, 23051);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              GMTrace.i(1682687655936L, 12537);
              paramAnonymousDialogInterface.dismiss();
              GMTrace.o(1682687655936L, 12537);
            }
          });
        }
        else
        {
          VoipAddressUI.eY(this.mContext);
          continue;
          ap.yY();
          if (!com.tencent.mm.u.c.isSDCardAvailable())
          {
            com.tencent.mm.ui.base.s.eP(this.mContext);
          }
          else
          {
            ap.yY();
            paramAdapterView = (String)com.tencent.mm.u.c.vr().get(2, null);
            paramView = new Intent();
            paramView.putExtra("sns_userName", paramAdapterView);
            paramView.setFlags(536870912);
            paramView.addFlags(67108864);
            ap.yY();
            paramInt = bf.a((Integer)com.tencent.mm.u.c.vr().get(68389, null), 0);
            ap.yY();
            com.tencent.mm.u.c.vr().set(68389, Integer.valueOf(paramInt + 1));
            com.tencent.mm.bb.d.b(this.mContext, "sns", ".ui.SnsUserUI", paramView);
            continue;
            com.tencent.mm.bb.d.w(this.mContext, "favorite", ".ui.FavoriteIndexUI");
            continue;
            com.tencent.mm.bb.d.b(this.mContext, "mall", ".ui.MallIndexUI", new Intent());
            continue;
            paramAdapterView = new Intent();
            paramAdapterView.putExtra("preceding_scence", 2);
            com.tencent.mm.bb.d.b(this.mContext, "emoji", ".ui.v2.EmojiStoreV2UI", paramAdapterView);
            continue;
            com.tencent.mm.bb.d.b(this.mContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
            continue;
            com.tencent.mm.plugin.report.service.g.oSF.i(11265, new Object[] { Integer.valueOf(3) });
            if ((!com.tencent.mm.n.a.aI(this.mContext)) && (!com.tencent.mm.n.a.aH(this.mContext)))
            {
              com.tencent.mm.bb.d.w(this.mContext, "scanner", ".ui.BaseScanUI");
              continue;
              ap.yY();
              if (com.tencent.mm.u.c.isSDCardAvailable()) {
                break;
              }
              com.tencent.mm.ui.base.s.eP(this.mContext);
            }
          }
        }
      }
      f.rU(10);
      ap.yY();
      paramAdapterView = (String)com.tencent.mm.u.c.vr().get(68377, null);
      ap.yY();
      com.tencent.mm.u.c.vr().set(68377, "");
      paramView = new Intent();
      paramView.putExtra("sns_timeline_NeedFirstLoadint", true);
      if (bf.mA(paramAdapterView)) {
        break;
      }
    }
    for (boolean bool1 = false;; bool1 = true)
    {
      if (com.tencent.mm.plugin.sns.b.m.pPa != null) {
        if (com.tencent.mm.plugin.sns.b.m.pPa.Ks() > 0) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        paramView.putExtra("sns_resume_state", bool1);
        com.tencent.mm.bb.d.b(this.mContext, "sns", ".ui.En_424b8e16", paramView);
        break;
        continue;
        ap.yY();
        if (!com.tencent.mm.u.c.isSDCardAvailable())
        {
          com.tencent.mm.ui.base.s.eP(this.mContext);
          break;
        }
        com.tencent.mm.bb.d.w(this.mContext, "game", ".ui.GameCenterUI");
        new ad().postDelayed(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(1602962325504L, 11943);
            Intent localIntent = new Intent();
            localIntent.setComponent(new ComponentName(d.g.uMO, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            localIntent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
            u.this.mContext.sendBroadcast(localIntent);
            GMTrace.o(1602962325504L, 11943);
          }
        }, 100L);
        break;
        com.tencent.mm.sdk.b.a.uql.m(new mk());
        com.tencent.mm.bb.d.w(this.mContext, "shake", ".ui.ShakeReportUI");
        break;
        ap.yY();
        if (!bf.f((Boolean)com.tencent.mm.u.c.vr().get(4103, null)))
        {
          com.tencent.mm.bb.d.w(this.mContext, "nearby", ".ui.NearbyFriendsIntroUI");
          break;
        }
        paramAdapterView = bg.zM();
        if (paramAdapterView == null)
        {
          com.tencent.mm.bb.d.w(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
          break;
        }
        paramView = bf.mz(paramAdapterView.getProvince());
        paramInt = bf.a(Integer.valueOf(paramAdapterView.gkh), 0);
        if ((bf.mA(paramView)) || (paramInt == 0))
        {
          com.tencent.mm.bb.d.w(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
          break;
        }
        ap.yY();
        paramAdapterView = (Boolean)com.tencent.mm.u.c.vr().get(4104, null);
        if ((paramAdapterView == null) || (!paramAdapterView.booleanValue()))
        {
          paramAdapterView = LauncherUI.bPy();
          if (paramAdapterView != null) {
            paramAdapterView.uPX.SC("tab_find_friend");
          }
          com.tencent.mm.az.a.dl(this.mContext);
          break;
        }
        paramAdapterView = View.inflate(this.mContext, R.i.dgz, null);
        paramView = (CheckBox)paramAdapterView.findViewById(R.h.caP);
        paramView.setChecked(false);
        com.tencent.mm.ui.base.g.a(this.mContext, this.mContext.getString(R.l.dIG), paramAdapterView, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            GMTrace.i(2103997104128L, 15676);
            if (paramView != null)
            {
              ap.yY();
              paramAnonymousDialogInterface = com.tencent.mm.u.c.vr();
              if (paramView.isChecked()) {
                break label84;
              }
            }
            label84:
            for (boolean bool = true;; bool = false)
            {
              paramAnonymousDialogInterface.set(4104, Boolean.valueOf(bool));
              paramAnonymousDialogInterface = LauncherUI.bPy();
              if (paramAnonymousDialogInterface != null) {
                paramAnonymousDialogInterface.uPX.SC("tab_find_friend");
              }
              com.tencent.mm.az.a.dl(u.this.mContext);
              GMTrace.o(2103997104128L, 15676);
              return;
            }
          }
        }, null);
        break;
        paramAdapterView = bg.zL();
        if ((bf.a(Integer.valueOf(paramAdapterView.gkh), 0) <= 0) || (bf.mA(paramAdapterView.getProvince())))
        {
          com.tencent.mm.bb.d.w(this.mContext, "bottle", ".ui.BottleWizardStep1");
          break;
        }
        com.tencent.mm.bb.d.w(this.mContext, "bottle", ".ui.BottleBeachUI");
        break;
        ap.yY();
        if (com.tencent.mm.u.c.wM())
        {
          com.tencent.mm.bb.d.w(this.mContext, "webwx", ".ui.WebWXLogoutUI");
          break;
        }
        com.tencent.mm.bb.d.w(this.mContext, "webwx", ".ui.WebWeiXinIntroductionUI");
        break;
        if ((com.tencent.mm.u.m.xW() & 0x10000) == 0) {}
        for (paramInt = i;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label1468;
          }
          com.tencent.mm.bb.d.w(this.mContext, "masssend", ".ui.MassSendHistoryUI");
          break;
        }
        label1468:
        com.tencent.mm.bb.d.b(this.mContext, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
        break;
        com.tencent.mm.bb.d.w(this.mContext, "radar", ".ui.RadarSearchUI");
        break;
        com.tencent.mm.bb.d.w(this.mContext, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
        break;
        com.tencent.mm.plugin.report.service.g.oSF.A(10919, "1-6");
        com.tencent.mm.pluginsdk.d.dq(this.mContext);
        break;
        paramAdapterView = new Intent();
        ap.yY();
        paramView = (String)com.tencent.mm.u.c.vr().get(w.a.uFH, "");
        if (!bf.mA(paramView))
        {
          paramAdapterView.putExtra("rawUrl", paramView);
          paramAdapterView.putExtra("showShare", true);
          paramAdapterView.putExtra("show_bottom", false);
          com.tencent.mm.bb.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", paramAdapterView);
          break;
        }
        com.tencent.mm.pluginsdk.d.dq(this.mContext);
        break;
        paramAdapterView = this.mContext;
        paramView = new Intent();
        paramView.putExtra("key_from_scene", 2);
        com.tencent.mm.bb.d.b(paramAdapterView, "offline", ".ui.WalletOfflineEntranceUI", paramView);
        if (!com.tencent.mm.q.c.uk().aD(262159, 266248)) {
          break;
        }
        com.tencent.mm.q.c.uk().aE(262159, 266248);
        com.tencent.mm.plugin.report.service.g.oSF.i(14396, new Object[] { Integer.valueOf(2) });
        break;
        com.tencent.mm.pluginsdk.wallet.e.P(this.mContext, 1);
        break;
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("key_from_scene", 2);
        com.tencent.mm.bb.d.b(this.mContext, "offline", ".ui.WalletOfflineEntranceUI", paramAdapterView);
        break;
      }
    }
  }
  
  private final class a
    extends BaseAdapter
  {
    private a()
    {
      GMTrace.i(2065610833920L, 15390);
      GMTrace.o(2065610833920L, 15390);
    }
    
    public final int getCount()
    {
      GMTrace.i(2065745051648L, 15391);
      int i = u.this.uTZ.size();
      GMTrace.o(2065745051648L, 15391);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      GMTrace.i(2065879269376L, 15392);
      GMTrace.o(2065879269376L, 15392);
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      GMTrace.i(2066013487104L, 15393);
      GMTrace.o(2066013487104L, 15393);
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      GMTrace.i(2066147704832L, 15394);
      paramView = (u.c)u.this.uTZ.get(paramInt);
      paramViewGroup = u.this.Du.inflate(R.i.dji, paramViewGroup, false);
      Object localObject = (TextView)paramViewGroup.findViewById(R.h.title);
      if (!bf.mA(paramView.uUi.uUj)) {
        ((TextView)localObject).setText(paramView.uUi.uUj);
      }
      if (paramView.uUi.textColor > 0) {
        ((TextView)localObject).setTextColor(com.tencent.mm.bg.a.b(aa.getContext(), paramView.uUi.textColor));
      }
      localObject = (ImageView)paramViewGroup.findViewById(R.h.icon);
      TextView localTextView;
      View localView;
      if (paramView.uUi.icon > 0)
      {
        ((ImageView)localObject).setVisibility(0);
        ((ImageView)localObject).setImageResource(((u.c)u.this.uTZ.get(paramInt)).uUi.icon);
        if (!bf.mA(paramView.uUi.uUk)) {
          ((ImageView)localObject).setContentDescription(paramView.uUi.uUk);
        }
        localObject = paramViewGroup.findViewById(R.h.cnJ);
        localTextView = (TextView)paramViewGroup.findViewById(R.h.cKz);
        localTextView.setBackgroundResource(com.tencent.mm.ui.tools.s.fg(u.this.mContext));
        localView = paramViewGroup.findViewById(R.h.cmW);
        if (!paramView.uUg) {
          break label279;
        }
        ((View)localObject).setVisibility(0);
        label241:
        if (paramInt != getCount() - 1) {
          break label377;
        }
        paramViewGroup.setBackgroundResource(R.g.bkn);
      }
      for (;;)
      {
        GMTrace.o(2066147704832L, 15394);
        return paramViewGroup;
        ((ImageView)localObject).setVisibility(8);
        break;
        label279:
        if (paramView.fCB > 0)
        {
          localTextView.setVisibility(0);
          if (paramView.fCB > 99)
          {
            localTextView.setText(R.l.eYH);
            break label241;
          }
          localTextView.setText(paramView.fCB);
          break label241;
        }
        if (paramView.uUh)
        {
          localView.setVisibility(0);
          break label241;
        }
        ((View)localObject).setVisibility(8);
        localTextView.setVisibility(8);
        localView.setVisibility(8);
        break label241;
        label377:
        paramViewGroup.setBackgroundResource(R.g.bkm);
      }
    }
  }
  
  public static final class b
  {
    int hTc;
    int id;
    int order;
    int uUf;
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this(paramInt1, paramInt2, paramInt3, 0);
      GMTrace.i(2077421993984L, 15478);
      GMTrace.o(2077421993984L, 15478);
    }
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      GMTrace.i(2077556211712L, 15479);
      this.id = paramInt1;
      this.uUf = paramInt2;
      this.hTc = paramInt3;
      this.order = paramInt4;
      GMTrace.o(2077556211712L, 15479);
    }
  }
  
  public static final class c
  {
    int fCB;
    boolean uUg;
    boolean uUh;
    u.d uUi;
    
    public c(u.d paramd)
    {
      GMTrace.i(2876017475584L, 21428);
      this.uUg = false;
      this.uUh = false;
      this.fCB = 0;
      this.uUi = paramd;
      GMTrace.o(2876017475584L, 21428);
    }
  }
  
  public static final class d
  {
    int icon;
    int textColor;
    String uUj;
    String uUk;
    int uUl;
    
    public d(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
    {
      GMTrace.i(2537654583296L, 18907);
      this.uUj = paramString1;
      this.uUk = paramString2;
      this.icon = paramInt2;
      this.uUl = paramInt1;
      this.textColor = paramInt3;
      GMTrace.o(2537654583296L, 18907);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */