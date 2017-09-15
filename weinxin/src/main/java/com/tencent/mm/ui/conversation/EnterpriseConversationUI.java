package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.b;
import com.tencent.mm.modelbiz.c.a;
import com.tencent.mm.modelbiz.c.a.a;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.platformtools.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.a;
import com.tencent.mm.protocal.c.alu;
import com.tencent.mm.protocal.c.asy;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.bdy;
import com.tencent.mm.protocal.c.bdz;
import com.tencent.mm.protocal.c.ng;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ae;
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
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.k.a;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.y.n;
import java.util.HashMap;
import java.util.LinkedList;

public class EnterpriseConversationUI
  extends BaseConversationUI
{
  private View ipa;
  
  public EnterpriseConversationUI()
  {
    GMTrace.i(3406445936640L, 25380);
    GMTrace.o(3406445936640L, 25380);
  }
  
  public void finish()
  {
    GMTrace.i(3406714372096L, 25382);
    if ((this.vZo != null) && ((this.vZo instanceof a))) {
      ((a)this.vZo).hUO = (System.currentTimeMillis() / 1000L);
    }
    super.finish();
    GMTrace.o(3406714372096L, 25382);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3406580154368L, 25381);
    super.onCreate(paramBundle);
    this.ipa = r.eC(this).inflate(R.i.cVG, null);
    setContentView(this.ipa);
    this.vZo = new a();
    aR().aV().a(R.h.ckg, this.vZo).commit();
    com.tencent.mm.pluginsdk.e.a(this, this.ipa);
    GMTrace.o(3406580154368L, 25381);
  }
  
  public static final class a
    extends BaseConversationUI.b
    implements m.b, com.tencent.mm.y.e
  {
    public int fromScene;
    private long gKI;
    long hUO;
    public String htS;
    public com.tencent.mm.ui.base.p irp;
    public boolean jUD;
    TextView jUy;
    public String jZh;
    public long jzx;
    public com.tencent.mm.ui.tools.l klh;
    public n.d nwm;
    public ListView vZD;
    private String vZE;
    private LinearLayout vtP;
    public int vtS;
    private c.a vtV;
    public com.tencent.mm.ui.tools.m wbE;
    public h wbF;
    String wbG;
    private ad wbH;
    public int wbI;
    public String wbJ;
    
    public a()
    {
      GMTrace.i(3457582891008L, 25761);
      this.vtP = null;
      this.wbG = null;
      this.jZh = "";
      this.vtS = 0;
      this.jUD = false;
      this.gKI = 0L;
      this.hUO = 0L;
      this.wbI = -2;
      this.jzx = 0L;
      this.wbJ = null;
      this.vtV = new c.a()
      {
        public final void a(c.a.a paramAnonymousa)
        {
          GMTrace.i(3376246947840L, 25155);
          if ((paramAnonymousa != null) && (!bf.mA(paramAnonymousa.htS)) && (paramAnonymousa.htS.equals(EnterpriseConversationUI.a.this.htS)))
          {
            int i = EnterpriseConversationUI.a.this.vtS;
            EnterpriseConversationUI.a.this.vtS = f.bc(EnterpriseConversationUI.a.this.uRf.uRz, EnterpriseConversationUI.a.this.htS);
            if (EnterpriseConversationUI.a.this.vtS != i) {
              EnterpriseConversationUI.a.this.bTd();
            }
          }
          GMTrace.o(3376246947840L, 25155);
        }
      };
      GMTrace.o(3457582891008L, 25761);
    }
    
    public static void TV(String paramString)
    {
      GMTrace.i(16020899102720L, 119365);
      ap.yY();
      if (com.tencent.mm.u.c.wR().Rb(paramString) == null)
      {
        v.e("MicroMsg.EnterpriseConversationUI", "changed biz stick status failed, contact is null, talker = " + paramString);
        GMTrace.o(16020899102720L, 119365);
        return;
      }
      ap.yY();
      if (com.tencent.mm.u.c.wW().Rs(paramString))
      {
        o.m(paramString, true);
        GMTrace.o(16020899102720L, 119365);
        return;
      }
      com.tencent.mm.u.g.eq(paramString);
      GMTrace.o(16020899102720L, 119365);
    }
    
    public final void TS(String paramString)
    {
      GMTrace.i(16021033320448L, 119366);
      if (bf.mA(paramString))
      {
        v.e("MicroMsg.EnterpriseConversationUI", "Delete Conversation and messages fail because username is null or nil.");
        GMTrace.o(16021033320448L, 119366);
        return;
      }
      ap.yY();
      Object localObject = com.tencent.mm.u.c.wT().Af(paramString);
      ng localng = new ng();
      localng.trH = new avu().OU(bf.mz(paramString));
      localng.tdE = ((ce)localObject).field_msgSvrId;
      ap.yY();
      com.tencent.mm.u.c.wQ().b(new e.a(8, localng));
      this.jUD = false;
      localObject = bOZ();
      getString(R.l.dIG);
      ay.a(paramString, new ay.a()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(3420807233536L, 25487);
          EnterpriseConversationUI.a.this.jUD = true;
          GMTrace.o(3420807233536L, 25487);
        }
      }
      {
        public final void zr()
        {
          GMTrace.i(3404969541632L, 25369);
          if (this.krZ != null) {
            this.krZ.dismiss();
          }
          GMTrace.o(3404969541632L, 25369);
        }
        
        public final boolean zs()
        {
          GMTrace.i(3404835323904L, 25368);
          boolean bool = EnterpriseConversationUI.a.this.jUD;
          GMTrace.o(3404835323904L, 25368);
          return bool;
        }
      });
      ap.yY();
      com.tencent.mm.u.c.wW().Rk(paramString);
      paramString = w.DH().hO(paramString);
      ap.yY();
      com.tencent.mm.u.c.wV().QG(paramString.field_enterpriseFather);
      GMTrace.o(16021033320448L, 119366);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.y.k paramk)
    {
      GMTrace.i(3458790850560L, 25770);
      if ((this.irp != null) && (this.irp.isShowing())) {
        this.irp.dismiss();
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        GMTrace.o(3458790850560L, 25770);
        return;
      }
      if (paramk.getType() == 1394)
      {
        paramString = ((com.tencent.mm.plugin.profile.a.c)paramk).aTn();
        Object localObject = ((com.tencent.mm.plugin.profile.a.c)paramk).aTm();
        if ((localObject == null) || (((bdz)localObject).tjl == null) || (((bdz)localObject).tjl.ret != 0))
        {
          if ((localObject != null) && (((bdz)localObject).tjl != null))
          {
            v.w("MicroMsg.EnterpriseConversationUI", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[] { Integer.valueOf(paramk.getType()), Integer.valueOf(((bdz)localObject).tjl.ret) });
            GMTrace.o(3458790850560L, 25770);
            return;
          }
          v.w("MicroMsg.EnterpriseConversationUI", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[] { Integer.valueOf(paramk.getType()) });
          GMTrace.o(3458790850560L, 25770);
          return;
        }
        if (!paramString.udt)
        {
          GMTrace.o(3458790850560L, 25770);
          return;
        }
        paramk = com.tencent.mm.modelbiz.e.hW(paramString.tjf);
        paramk.field_brandFlag |= 0x1;
        localObject = new alu();
        ((alu)localObject).hAz = paramk.field_brandFlag;
        ((alu)localObject).jLx = paramString.tjf;
        ap.yY();
        com.tencent.mm.u.c.wQ().b(new e.a(47, (com.tencent.mm.bd.a)localObject));
        w.DH().c(paramk, new String[0]);
        ap.yY();
        com.tencent.mm.u.c.wW().Rk(paramk.field_username);
        ap.yY();
        if (com.tencent.mm.u.c.wW().Rv(paramk.field_enterpriseFather) <= 0)
        {
          ap.yY();
          com.tencent.mm.u.c.wW().Rk(paramk.field_enterpriseFather);
          GMTrace.o(3458790850560L, 25770);
          return;
        }
        ap.yY();
        com.tencent.mm.u.c.wV().QG(paramk.field_enterpriseFather);
      }
      GMTrace.o(3458790850560L, 25770);
    }
    
    public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
    {
      GMTrace.i(3459059286016L, 25772);
      GMTrace.o(3459059286016L, 25772);
    }
    
    public final void a(BizInfo paramBizInfo, int paramInt1, int paramInt2)
    {
      GMTrace.i(17878875111424L, 133208);
      b localb = w.DO().hC(this.htS);
      long l1;
      long l2;
      if (localb != null)
      {
        l1 = localb.field_wwCorpId;
        if (localb == null) {
          break label191;
        }
        l2 = localb.field_wwUserVid;
        label45:
        if (paramInt2 <= 0) {
          break label197;
        }
        paramInt2 = 1;
        label51:
        if (paramBizInfo != null) {
          break label202;
        }
      }
      label191:
      label197:
      label202:
      for (long l3 = 0L;; l3 = paramBizInfo.CM())
      {
        com.tencent.mm.plugin.report.service.g.oSF.i(14507, new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
        v.d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", new Object[] { Long.valueOf(l1), Long.valueOf(l3), Long.valueOf(l2), Integer.valueOf(1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
        GMTrace.o(17878875111424L, 133208);
        return;
        l1 = 0L;
        break;
        l2 = 0L;
        break label45;
        paramInt2 = 2;
        break label51;
      }
    }
    
    public final void bTd()
    {
      GMTrace.i(3458656632832L, 25769);
      this.vtS = f.bc(this.uRf.uRz, this.htS);
      Object localObject;
      int i;
      if ((this.vtS == 2) && (this.vtP == null))
      {
        this.vtP = ((LinearLayout)findViewById(R.h.bottom_bar));
        localObject = this.vtP.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = com.tencent.mm.bg.a.T(this.uRf.uRz, R.f.aWS);
        this.vtP.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = r.eC(this.uRf.uRz).inflate(R.i.dbc, this.vtP, false);
        float f = com.tencent.mm.bg.a.dI(this.uRf.uRz);
        ImageView localImageView = (ImageView)((View)localObject).findViewById(R.h.bWq);
        i = localImageView.getLayoutParams().height;
        localImageView.getLayoutParams().height = ((int)(i * f));
        localImageView.getLayoutParams().width = ((int)(f * i));
        localImageView.requestLayout();
        ((TextView)((View)localObject).findViewById(R.h.cIY)).setText(R.l.eeR);
        this.vtP.addView((View)localObject);
        ((View)localObject).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            GMTrace.i(3377454907392L, 25164);
            f.k(EnterpriseConversationUI.a.this.uRf.uRz, EnterpriseConversationUI.a.this.htS, 3);
            GMTrace.o(3377454907392L, 25164);
          }
        });
        f.j(this.uRf.uRz, this.htS, 3);
        f.bd(this.uRf.uRz, this.htS);
      }
      if (this.vtP != null)
      {
        if (this.vtS == 2)
        {
          this.vtP.setVisibility(0);
          localObject = w.DO().hC(this.htS);
          int j;
          label304:
          long l1;
          if (localObject != null)
          {
            i = ((b)localObject).field_qyUin;
            if (localObject == null) {
              break label460;
            }
            j = ((b)localObject).field_userUin;
            if (localObject == null) {
              break label465;
            }
            l1 = ((b)localObject).field_wwCorpId;
            label316:
            if (localObject == null) {
              break label471;
            }
          }
          label460:
          label465:
          label471:
          for (long l2 = ((b)localObject).field_wwUserVid;; l2 = 0L)
          {
            com.tencent.mm.plugin.report.service.g.oSF.i(13656, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2) });
            v.d("MicroMsg.EnterpriseConversationUI", "expose wework btn on session list  report: %s,%s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(l1), Long.valueOf(l2) });
            GMTrace.o(3458656632832L, 25769);
            return;
            i = 0;
            break;
            j = 0;
            break label304;
            l1 = 0L;
            break label316;
          }
        }
        this.vtP.setVisibility(8);
      }
      GMTrace.o(3458656632832L, 25769);
    }
    
    protected final int getLayoutId()
    {
      GMTrace.i(3457851326464L, 25763);
      int i = R.i.dbb;
      GMTrace.o(3457851326464L, 25763);
      return i;
    }
    
    public final String getUserName()
    {
      GMTrace.i(3457985544192L, 25764);
      String str = this.htS;
      GMTrace.o(3457985544192L, 25764);
      return str;
    }
    
    public final void onActivityCreated(Bundle paramBundle)
    {
      GMTrace.i(3457717108736L, 25762);
      super.onActivityCreated(paramBundle);
      this.htS = bOZ().getIntent().getStringExtra("enterprise_biz_name");
      this.vZE = bOZ().getIntent().getStringExtra("enterprise_biz_display_name");
      this.fromScene = bOZ().getIntent().getIntExtra("enterprise_from_scene", 5);
      qL(this.vZE);
      this.vZD = ((ListView)findViewById(R.h.cIZ));
      this.jUy = ((TextView)findViewById(R.h.bLN));
      this.jUy.setText(R.l.eeB);
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(3408727638016L, 25397);
          EnterpriseConversationUI.a.this.finish();
          GMTrace.o(3408727638016L, 25397);
          return true;
        }
      });
      new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(3381615656960L, 25195);
          a.b.a(EnterpriseConversationUI.a.this.vZD);
          GMTrace.o(3381615656960L, 25195);
        }
      };
      if (com.tencent.mm.modelbiz.e.hW(this.htS) != null)
      {
        bTd();
        a(1, R.l.eYc, R.k.dsK, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            GMTrace.i(3374502117376L, 25142);
            paramAnonymousMenuItem = new Intent();
            paramAnonymousMenuItem.putExtra("enterprise_biz_name", EnterpriseConversationUI.a.this.htS);
            paramAnonymousMenuItem.addFlags(67108864);
            com.tencent.mm.bb.d.b(EnterpriseConversationUI.a.this.uRf.uRz, "brandservice", ".ui.EnterpriseBizSearchUI", paramAnonymousMenuItem);
            GMTrace.o(3374502117376L, 25142);
            return true;
          }
        });
        a(2, R.l.dBF, R.k.dsy, new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            GMTrace.i(3377991778304L, 25168);
            if (EnterpriseConversationUI.a.this.wbE != null)
            {
              EnterpriseConversationUI.a.this.wbE.dismiss();
              EnterpriseConversationUI.a.this.wbE = null;
            }
            EnterpriseConversationUI.a.this.wbE = new com.tencent.mm.ui.tools.m(EnterpriseConversationUI.a.this.uRf.uRz);
            EnterpriseConversationUI.a.this.wbE.qHD = new n.c()
            {
              public final void a(com.tencent.mm.ui.base.l paramAnonymous2l)
              {
                GMTrace.i(3449798262784L, 25703);
                if (EnterpriseConversationUI.a.this.vtS == 1)
                {
                  paramAnonymous2l.W(2, R.l.eeS, R.k.dsD);
                  f.j(EnterpriseConversationUI.a.this.uRf.uRz, EnterpriseConversationUI.a.this.htS, 5);
                }
                paramAnonymous2l.W(3, R.l.dZp, R.k.dyn);
                paramAnonymous2l.W(4, R.l.eeA, R.k.dsC);
                paramAnonymous2l.W(5, R.l.dBG, R.k.dsM);
                GMTrace.o(3449798262784L, 25703);
              }
            };
            EnterpriseConversationUI.a.this.wbE.qHE = new n.d()
            {
              public final void c(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
              {
                GMTrace.i(3389534502912L, 25254);
                paramAnonymous2Int = 0;
                switch (paramAnonymous2MenuItem.getItemId())
                {
                }
                for (;;)
                {
                  f.cK(EnterpriseConversationUI.a.this.htS, paramAnonymous2Int);
                  GMTrace.o(3389534502912L, 25254);
                  return;
                  f.k(EnterpriseConversationUI.a.this.uRf.uRz, EnterpriseConversationUI.a.this.htS, 5);
                  continue;
                  paramAnonymous2MenuItem = new Intent(EnterpriseConversationUI.a.this.bOZ(), SelectConversationUI.class);
                  paramAnonymous2MenuItem.putExtra("Select_Talker_Name", EnterpriseConversationUI.a.this.htS);
                  paramAnonymous2MenuItem.putExtra("Select_block_List", EnterpriseConversationUI.a.this.htS);
                  paramAnonymous2MenuItem.putExtra("Select_Send_Card", true);
                  paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
                  EnterpriseConversationUI.a.this.startActivityForResult(paramAnonymous2MenuItem, 1);
                  paramAnonymous2Int = 3;
                  continue;
                  paramAnonymous2Int = 4;
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("enterprise_biz_name", EnterpriseConversationUI.a.this.htS);
                  paramAnonymous2MenuItem.putExtra("enterprise_scene", 2);
                  com.tencent.mm.bb.d.b(EnterpriseConversationUI.a.this.bOZ(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", paramAnonymous2MenuItem);
                  continue;
                  paramAnonymous2MenuItem = new Intent();
                  paramAnonymous2MenuItem.putExtra("Contact_User", EnterpriseConversationUI.a.this.htS);
                  com.tencent.mm.bb.d.b(EnterpriseConversationUI.a.this.bOZ(), "profile", ".ui.ContactInfoUI", paramAnonymous2MenuItem);
                  paramAnonymous2Int = 5;
                }
              }
            };
            EnterpriseConversationUI.a.this.wbE.dL();
            f.cK(EnterpriseConversationUI.a.this.htS, 1);
            GMTrace.o(3377991778304L, 25168);
            return false;
          }
        });
        this.wbF = new h(bOZ(), this.htS, new k.a()
        {
          public final void OI()
          {
            GMTrace.i(3424431112192L, 25514);
            EnterpriseConversationUI.a locala = EnterpriseConversationUI.a.this;
            if (EnterpriseConversationUI.a.this.wbF.getCount() <= 0)
            {
              locala.jUy.setVisibility(0);
              locala.vZD.setVisibility(8);
              GMTrace.o(3424431112192L, 25514);
              return;
            }
            locala.jUy.setVisibility(8);
            locala.vZD.setVisibility(0);
            GMTrace.o(3424431112192L, 25514);
          }
          
          public final void OJ()
          {
            GMTrace.i(3424565329920L, 25515);
            GMTrace.o(3424565329920L, 25515);
          }
        });
        this.wbF.a(new MMSlideDelView.c()
        {
          public final int bY(View paramAnonymousView)
          {
            GMTrace.i(3407385460736L, 25387);
            int i = EnterpriseConversationUI.a.this.vZD.getPositionForView(paramAnonymousView);
            GMTrace.o(3407385460736L, 25387);
            return i;
          }
        });
        this.wbF.a(new MMSlideDelView.f()
        {
          public final void s(View paramAnonymousView, int paramAnonymousInt)
          {
            GMTrace.i(3396111171584L, 25303);
            EnterpriseConversationUI.a.this.vZD.performItemClick(paramAnonymousView, paramAnonymousInt, 0L);
            GMTrace.o(3396111171584L, 25303);
          }
        });
        this.wbF.a(new MMSlideDelView.e()
        {
          public final void aQ(Object paramAnonymousObject)
          {
            GMTrace.i(3382420963328L, 25201);
            if (paramAnonymousObject == null)
            {
              v.e("MicroMsg.EnterpriseConversationUI", "onItemDel object null");
              GMTrace.o(3382420963328L, 25201);
              return;
            }
            paramAnonymousObject = paramAnonymousObject.toString();
            EnterpriseConversationUI.a.this.TS((String)paramAnonymousObject);
            GMTrace.o(3382420963328L, 25201);
          }
        });
        this.vZD.setAdapter(this.wbF);
        this.vZD.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            GMTrace.i(3455972278272L, 25749);
            ae localae = (ae)EnterpriseConversationUI.a.this.wbF.getItem(paramAnonymousInt);
            if (localae == null)
            {
              v.e("MicroMsg.EnterpriseConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(EnterpriseConversationUI.a.this.wbF.getCount()) });
              EnterpriseConversationUI.a.this.wbF.notifyDataSetChanged();
              GMTrace.o(3455972278272L, 25749);
              return;
            }
            if (com.tencent.mm.modelbiz.e.dr(localae.field_username))
            {
              paramAnonymousAdapterView = new Intent(EnterpriseConversationUI.a.this.bOZ(), BizChatConversationUI.class);
              paramAnonymousAdapterView.putExtra("Contact_User", localae.field_username);
              paramAnonymousAdapterView.putExtra("biz_chat_from_scene", 7);
              paramAnonymousAdapterView.addFlags(67108864);
              EnterpriseConversationUI.a.this.startActivity(paramAnonymousAdapterView);
              GMTrace.o(3455972278272L, 25749);
              return;
            }
            if (com.tencent.mm.modelbiz.e.ic(localae.field_username))
            {
              BizInfo localBizInfo = com.tencent.mm.modelbiz.e.hW(localae.field_username);
              if (localBizInfo == null) {}
              for (paramAnonymousAdapterView = null;; paramAnonymousAdapterView = localBizInfo.CL())
              {
                paramAnonymousView = paramAnonymousAdapterView;
                if (paramAnonymousAdapterView == null) {
                  paramAnonymousView = "";
                }
                paramAnonymousAdapterView = new Intent();
                paramAnonymousAdapterView.putExtra("rawUrl", paramAnonymousView);
                paramAnonymousAdapterView.putExtra("useJs", true);
                paramAnonymousAdapterView.putExtra("srcUsername", localae.field_username);
                paramAnonymousAdapterView.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                paramAnonymousAdapterView.addFlags(67108864);
                com.tencent.mm.bb.d.b(EnterpriseConversationUI.a.this.uRf.uRz, "webview", ".ui.tools.WebViewUI", paramAnonymousAdapterView);
                EnterpriseConversationUI.a.this.a(localBizInfo, 2, localae.field_unReadCount);
                GMTrace.o(3455972278272L, 25749);
                return;
              }
            }
            EnterpriseConversationUI.a.this.vZA.a(localae.field_username, null, true);
            EnterpriseConversationUI.a.this.a(com.tencent.mm.modelbiz.e.hW(localae.field_username), 1, localae.field_unReadCount);
            GMTrace.o(3455972278272L, 25749);
          }
        });
        this.klh = new com.tencent.mm.ui.tools.l(bOZ());
        this.nwm = new n.d()
        {
          public final void c(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            GMTrace.i(3396648042496L, 25307);
            switch (paramAnonymousMenuItem.getItemId())
            {
            }
            for (;;)
            {
              GMTrace.o(3396648042496L, 25307);
              return;
              EnterpriseConversationUI.a.this.TS(EnterpriseConversationUI.a.this.jZh);
              GMTrace.o(3396648042496L, 25307);
              return;
              paramAnonymousMenuItem = EnterpriseConversationUI.a.this;
              String str = EnterpriseConversationUI.a.this.jZh;
              ActionBarActivity localActionBarActivity = paramAnonymousMenuItem.uRf.uRz;
              com.tencent.mm.ui.base.g.b(localActionBarActivity, localActionBarActivity.getString(R.l.eex), "", localActionBarActivity.getString(R.l.eew), localActionBarActivity.getString(R.l.dGk), new EnterpriseConversationUI.a.5(paramAnonymousMenuItem, str, localActionBarActivity), null);
              GMTrace.o(3396648042496L, 25307);
              return;
              EnterpriseConversationUI.a.TV(EnterpriseConversationUI.a.this.jZh);
            }
          }
        };
        this.vZD.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
          public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            GMTrace.i(3450335133696L, 25707);
            paramAnonymousAdapterView = (ae)EnterpriseConversationUI.a.this.wbF.getItem(paramAnonymousInt);
            EnterpriseConversationUI.a.this.jZh = paramAnonymousAdapterView.field_username;
            EnterpriseConversationUI.a.this.klh.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, EnterpriseConversationUI.a.this, EnterpriseConversationUI.a.this.nwm);
            GMTrace.o(3450335133696L, 25707);
            return true;
          }
        });
      }
      this.gKI = (System.currentTimeMillis() / 1000L);
      ap.yY();
      paramBundle = com.tencent.mm.u.c.wW().Rl(this.htS);
      if (paramBundle != null)
      {
        this.wbI = paramBundle.field_unReadCount;
        if ((this.wbI == 0) && (paramBundle.field_unReadMuteCount > 0)) {
          this.wbI = -1;
        }
        this.jzx = (paramBundle.field_conversationTime / 1000L);
        if (paramBundle.field_isSend == 1)
        {
          paramBundle = null;
          this.wbJ = paramBundle;
        }
      }
      else
      {
        w.DO().a(this.vtV, bOZ().getMainLooper());
        ap.yY();
        com.tencent.mm.u.c.wW().a(this);
        ap.yY();
        com.tencent.mm.u.c.wR().a(this);
        if (this.wbF != null)
        {
          if (this.wbH != null) {
            break label510;
          }
          this.wbH = new ad()
          {
            public final void handleMessage(Message paramAnonymousMessage)
            {
              GMTrace.i(3450603569152L, 25709);
              int i1;
              LinkedList localLinkedList;
              int i;
              int k;
              int j;
              int m;
              Object localObject1;
              Object localObject2;
              int n;
              if ((paramAnonymousMessage != null) && (paramAnonymousMessage.what == 1) && (EnterpriseConversationUI.a.this.bOZ() != null) && (!EnterpriseConversationUI.a.this.bOZ().isFinishing()))
              {
                i1 = EnterpriseConversationUI.a.this.wbF.getCount();
                paramAnonymousMessage = new LinkedList();
                localLinkedList = new LinkedList();
                i = 0;
                k = 0;
                j = 0;
                m = 0;
                if (m < i1)
                {
                  localObject1 = (ae)EnterpriseConversationUI.a.this.wbF.getItem(m);
                  if (localObject1 == null) {
                    break label977;
                  }
                  localObject2 = ((aj)localObject1).field_username;
                  if (localObject2 == null) {
                    break label977;
                  }
                  if ((!o.eU((String)localObject2)) || (!com.tencent.mm.modelbiz.e.ie((String)localObject2)))
                  {
                    v.d("MicroMsg.EnterpriseConversationUI", "checkEnterpriseChildConv delete conv %s", new Object[] { localObject2 });
                    paramAnonymousMessage.add(localObject2);
                    n = j;
                    j = k;
                    k = i;
                    i = n;
                  }
                }
              }
              for (;;)
              {
                n = m + 1;
                m = k;
                k = j;
                j = i;
                i = m;
                m = n;
                break;
                Object localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rb((String)localObject2);
                boolean bool = ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rs((String)localObject2);
                if ((localObject3 != null) && ((((af)localObject3).field_type & 0x800) != 0))
                {
                  n = 1;
                  label264:
                  if ((n == 0) || (bool)) {
                    break label350;
                  }
                  ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rq((String)localObject2);
                }
                for (;;)
                {
                  if (com.tencent.mm.modelbiz.e.ic((String)localObject2)) {
                    localLinkedList.add(localObject2);
                  }
                  if (((aj)localObject1).field_unReadCount <= 0) {
                    break label977;
                  }
                  if (!o.fJ((String)localObject2)) {
                    break label384;
                  }
                  n = i + 1;
                  i = j;
                  j = k;
                  k = n;
                  break;
                  n = 0;
                  break label264;
                  label350:
                  if ((n == 0) && (bool)) {
                    ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wW().Rr((String)localObject2);
                  }
                }
                label384:
                n = k + 1;
                j = ((aj)localObject1).field_unReadCount + j;
                k = i;
                i = j;
                j = n;
                continue;
                localObject1 = w.DO().hC(EnterpriseConversationUI.a.this.htS);
                long l1;
                label448:
                long l2;
                if (localObject1 != null)
                {
                  m = ((b)localObject1).field_qyUin;
                  if (localObject1 == null) {
                    break label946;
                  }
                  l1 = ((b)localObject1).field_wwCorpId;
                  if (localObject1 == null) {
                    break label952;
                  }
                  l2 = ((b)localObject1).field_wwUserVid;
                  label460:
                  n = 0;
                  if (!bf.mA(EnterpriseConversationUI.a.this.wbJ)) {
                    n = w.DO().hE(EnterpriseConversationUI.a.this.wbJ);
                  }
                  com.tencent.mm.plugin.report.service.g.oSF.i(12892, new Object[] { EnterpriseConversationUI.a.this.htS, Integer.valueOf(EnterpriseConversationUI.a.this.fromScene), Integer.valueOf(i1), "", Integer.valueOf(EnterpriseConversationUI.a.this.wbI), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Long.valueOf(EnterpriseConversationUI.a.this.jzx), Integer.valueOf(n), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
                  v.d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { EnterpriseConversationUI.a.this.htS, Integer.valueOf(EnterpriseConversationUI.a.this.fromScene), Integer.valueOf(i1), "", Integer.valueOf(EnterpriseConversationUI.a.this.wbI), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k), Long.valueOf(EnterpriseConversationUI.a.this.jzx), Integer.valueOf(n), Integer.valueOf(m), Long.valueOf(l1), Long.valueOf(l2) });
                  if (paramAnonymousMessage.size() > 0)
                  {
                    ap.yY();
                    com.tencent.mm.u.c.wW().aw(paramAnonymousMessage);
                    EnterpriseConversationUI.a.this.wbF.OL();
                  }
                  if (w.DR().hB(EnterpriseConversationUI.a.this.htS))
                  {
                    w.DO();
                    com.tencent.mm.modelbiz.c.a(EnterpriseConversationUI.a.this.htS, null);
                  }
                  localObject2 = w.DR();
                  localObject3 = EnterpriseConversationUI.a.this;
                  if (((EnterpriseConversationUI.a)localObject3).wbG == null)
                  {
                    w.DH();
                    localObject1 = com.tencent.mm.modelbiz.d.hS(((EnterpriseConversationUI.a)localObject3).htS);
                    paramAnonymousMessage = (Message)localObject1;
                    if (bf.mA((String)localObject1)) {
                      paramAnonymousMessage = "";
                    }
                    ((EnterpriseConversationUI.a)localObject3).wbG = paramAnonymousMessage;
                  }
                  if (!bf.mA(((EnterpriseConversationUI.a)localObject3).wbG)) {
                    break label958;
                  }
                }
                label946:
                label952:
                label958:
                for (paramAnonymousMessage = null;; paramAnonymousMessage = ((EnterpriseConversationUI.a)localObject3).wbG)
                {
                  ((com.tencent.mm.modelbiz.a)localObject2).hB(paramAnonymousMessage);
                  if (localLinkedList.size() <= 0) {
                    break label967;
                  }
                  i = 0;
                  while (i < localLinkedList.size())
                  {
                    w.DR().hB((String)localLinkedList.get(i));
                    i += 1;
                  }
                  m = 0;
                  break;
                  l1 = 0L;
                  break label448;
                  l2 = 0L;
                  break label460;
                }
                label967:
                GMTrace.o(3450603569152L, 25709);
                return;
                label977:
                n = i;
                i = j;
                j = k;
                k = n;
              }
            }
          };
        }
      }
      for (;;)
      {
        this.wbH.sendEmptyMessageDelayed(1, 500L);
        GMTrace.o(3457717108736L, 25762);
        return;
        paramBundle = paramBundle.field_digestUser;
        break;
        label510:
        this.wbH.removeMessages(1);
      }
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      GMTrace.i(3458522415104L, 25768);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      switch (paramInt1)
      {
      default: 
        GMTrace.o(3458522415104L, 25768);
        return;
      }
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str1 = paramIntent.getStringExtra("be_send_card_name");
        String str2 = paramIntent.getStringExtra("received_card_name");
        boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        com.tencent.mm.plugin.messenger.a.d.aJP().k(str1, str2, bool);
        com.tencent.mm.plugin.messenger.a.d.aJP().cM(paramIntent, str2);
        com.tencent.mm.ui.snackbar.a.e(bOZ(), this.uRf.uRz.getString(R.l.ekN));
        GMTrace.o(3458522415104L, 25768);
        return;
      }
      GMTrace.o(3458522415104L, 25768);
    }
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      GMTrace.i(3458925068288L, 25771);
      super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
      ap.yY();
      x localx = com.tencent.mm.u.c.wR().Rb(this.jZh);
      if (localx == null)
      {
        v.e("MicroMsg.EnterpriseConversationUI", "onCreateContextMenu, contact is null, talker = " + this.jZh);
        GMTrace.o(3458925068288L, 25771);
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
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.h.a(bOZ(), paramView));
      if (localx.tG()) {
        paramContextMenu.add(paramContextMenuInfo.position, 3, 0, R.l.eyS);
      }
      for (;;)
      {
        paramContextMenu.add(paramContextMenuInfo.position, 2, 1, R.l.eeF);
        paramContextMenu.add(paramContextMenuInfo.position, 1, 2, R.l.eyV);
        GMTrace.o(3458925068288L, 25771);
        return;
        paramContextMenu.add(paramContextMenuInfo.position, 3, 0, R.l.eeL);
      }
    }
    
    public final void onDestroy()
    {
      GMTrace.i(3458119761920L, 25765);
      w.DO().a(this.vtV);
      if (ap.zb())
      {
        ap.yY();
        com.tencent.mm.u.c.wW().b(this);
        ap.yY();
        com.tencent.mm.u.c.wR().b(this);
      }
      if (this.wbF != null)
      {
        localObject = this.wbF;
        ((h)localObject).wam.KI();
        if (((h)localObject).vtF != null)
        {
          ((h)localObject).vtF.clear();
          ((h)localObject).vtF = null;
        }
        ((h)localObject).aEP();
        ((com.tencent.mm.ui.k)localObject).uQY = null;
        ap.yY();
        com.tencent.mm.u.c.wW().b((m.b)localObject);
      }
      ap.vd().b(1394, this);
      if ((this.gKI <= 0L) || (this.hUO <= 0L))
      {
        super.onDestroy();
        GMTrace.o(3458119761920L, 25765);
        return;
      }
      long l = this.hUO - this.gKI;
      Object localObject = w.DO().hC(this.htS);
      int i;
      if (localObject != null)
      {
        i = ((b)localObject).field_qyUin;
        label194:
        if (localObject == null) {
          break label314;
        }
      }
      label314:
      for (int j = ((b)localObject).field_userUin;; j = 0)
      {
        com.tencent.mm.plugin.report.service.g.oSF.i(13465, new Object[] { "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(1), Long.valueOf(l) });
        v.d("MicroMsg.EnterpriseConversationUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", new Object[] { Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(1), Long.valueOf(l) });
        break;
        i = 0;
        break label194;
      }
    }
    
    public final void onPause()
    {
      GMTrace.i(3458388197376L, 25767);
      v.v("MicroMsg.EnterpriseConversationUI", "on pause");
      ap.yY();
      com.tencent.mm.u.c.wW().Rn(this.htS);
      if (this.wbF != null) {
        this.wbF.onPause();
      }
      super.onPause();
      GMTrace.o(3458388197376L, 25767);
    }
    
    public final void onResume()
    {
      GMTrace.i(3458253979648L, 25766);
      v.v("MicroMsg.EnterpriseConversationUI", "on resume");
      if (this.wbF != null) {
        this.wbF.onResume();
      }
      super.onResume();
      if (!o.eU(this.htS)) {
        finish();
      }
      GMTrace.o(3458253979648L, 25766);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/EnterpriseConversationUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */