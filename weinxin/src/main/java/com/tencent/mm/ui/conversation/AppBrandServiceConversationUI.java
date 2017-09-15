package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.e.a.kj;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.a;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.ng;
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
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.k.a;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.r;
import java.math.BigInteger;
import java.util.HashMap;

@android.support.a.a
public final class AppBrandServiceConversationUI
  extends BaseConversationUI
{
  private View ipa;
  
  public AppBrandServiceConversationUI()
  {
    GMTrace.i(3414499000320L, 25440);
    GMTrace.o(3414499000320L, 25440);
  }
  
  protected final En_5b8fbb1e.a bYg()
  {
    GMTrace.i(3414901653504L, 25443);
    AppBrandServiceChattingUI.a locala = new AppBrandServiceChattingUI.a();
    GMTrace.o(3414901653504L, 25443);
    return locala;
  }
  
  public final void finish()
  {
    GMTrace.i(3414767435776L, 25442);
    super.finish();
    GMTrace.o(3414767435776L, 25442);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3414633218048L, 25441);
    super.onCreate(paramBundle);
    this.ipa = r.eC(this).inflate(R.i.cVG, null);
    setContentView(this.ipa);
    this.vZo = new AppBrandServiceConversationFmUI();
    aR().aV().a(R.h.ckg, this.vZo).commit();
    e.a(this, this.ipa);
    GMTrace.o(3414633218048L, 25441);
  }
  
  @android.support.a.a
  public static class AppBrandServiceConversationFmUI
    extends BaseConversationUI.b
    implements n.d
  {
    public String fJC;
    public int fromScene;
    private com.tencent.mm.ui.base.p irp;
    String ivn;
    public boolean jUD;
    TextView jUy;
    public String jkM;
    public com.tencent.mm.ui.tools.l klh;
    public ae vUE;
    public ListView vYV;
    public d vYW;
    private String vYX;
    private com.tencent.mm.ui.d.a vwh;
    
    public AppBrandServiceConversationFmUI()
    {
      GMTrace.i(3452079964160L, 25720);
      this.fJC = "";
      this.irp = null;
      this.jUD = false;
      GMTrace.o(3452079964160L, 25720);
    }
    
    private void bYh()
    {
      GMTrace.i(3453019488256L, 25727);
      if (this.vYW == null)
      {
        v.d("MicroMsg.AppBrandServiceConversationFmUI", "adapter is null!");
        GMTrace.o(3453019488256L, 25727);
        return;
      }
      ap.yY();
      Object localObject1 = com.tencent.mm.u.c.wW().Rl("appbrandcustomerservicemsg");
      if ((localObject1 != null) && (!bf.mA(((aj)localObject1).field_username))) {}
      for (int j = ((aj)localObject1).field_unReadCount;; j = 0)
      {
        localObject1 = (ae)this.vYW.getItem(0);
        Object localObject2;
        if ((localObject1 != null) && (!bf.mA(((aj)localObject1).field_username)))
        {
          localObject2 = bf.mz(((aj)localObject1).field_content);
          localObject1 = ((com.tencent.mm.plugin.appbrand.i.b)h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(((aj)localObject1).field_username);
          if (localObject1 == null)
          {
            localObject1 = null;
            this.ivn = ((String)localObject1);
          }
        }
        for (localObject1 = localObject2;; localObject1 = "")
        {
          int k;
          label165:
          int m;
          if (j > 0)
          {
            int n = this.vYW.getCount();
            k = 0;
            int i = 0;
            m = i;
            if (k >= n) {
              break label229;
            }
            localObject2 = (ae)this.vYW.getItem(k);
            m = ((aj)localObject2).field_unReadCount;
            if (((aj)localObject2).field_unReadMuteCount + m <= 0) {
              break label359;
            }
            i += 1;
          }
          label229:
          label359:
          for (;;)
          {
            k += 1;
            break label165;
            localObject1 = ((WxaAttributes)localObject1).field_appId;
            break;
            m = 0;
            v.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), sceneId : %s, unReadCount %d, unReadAppCount %d, lastPushAppId %s, lastPushMsg %s", new Object[] { Integer.valueOf(13797), this.jkM, Integer.valueOf(j), Integer.valueOf(m), this.ivn, localObject1 });
            com.tencent.mm.plugin.report.service.g.oSF.i(13797, new Object[] { this.jkM, Integer.valueOf(j), Integer.valueOf(m), this.ivn, Long.valueOf(bf.Nz()), Integer.valueOf(0), localObject1 });
            GMTrace.o(3453019488256L, 25727);
            return;
          }
        }
      }
    }
    
    public final void TS(String paramString)
    {
      GMTrace.i(3453287923712L, 25729);
      if (bf.mA(paramString))
      {
        v.e("MicroMsg.AppBrandServiceConversationFmUI", "Delete Conversation and messages fail because username is null or nil.");
        GMTrace.o(3453287923712L, 25729);
        return;
      }
      v.i("MicroMsg.AppBrandServiceConversationFmUI", "async del msg talker:%s", new Object[] { paramString });
      ap.yY();
      final Object localObject = com.tencent.mm.u.c.wT().Af(paramString);
      ng localng = new ng();
      localng.trH = new avu().OU(bf.mz(paramString));
      localng.tdE = ((ce)localObject).field_msgSvrId;
      ap.yY();
      com.tencent.mm.u.c.wQ().b(new e.a(8, localng));
      this.jUD = false;
      localObject = bOZ();
      getString(R.l.dIG);
      localObject = com.tencent.mm.ui.base.g.a((Context)localObject, getString(R.l.dIV), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          GMTrace.i(3451945746432L, 25719);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.jUD = true;
          GMTrace.o(3451945746432L, 25719);
        }
      });
      v.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), eventId : %s, appId %s, sceneId %s", new Object[] { Integer.valueOf(13798), Integer.valueOf(5), this.ivn, this.jkM });
      com.tencent.mm.plugin.report.service.g.oSF.i(13798, new Object[] { Integer.valueOf(5), this.ivn, Integer.valueOf(0), this.jkM, Long.valueOf(bf.Nz()) });
      ay.a(paramString, new ay.a()
      {
        public final void zr()
        {
          GMTrace.i(3425504854016L, 25522);
          if (localObject != null) {
            localObject.dismiss();
          }
          GMTrace.o(3425504854016L, 25522);
        }
        
        public final boolean zs()
        {
          GMTrace.i(3425370636288L, 25521);
          boolean bool = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.jUD;
          GMTrace.o(3425370636288L, 25521);
          return bool;
        }
      });
      ap.yY();
      com.tencent.mm.u.c.wW().Rk(paramString);
      GMTrace.o(3453287923712L, 25729);
    }
    
    public final void c(MenuItem paramMenuItem, int paramInt)
    {
      GMTrace.i(3453422141440L, 25730);
      ap.yY();
      x localx = com.tencent.mm.u.c.wR().Rb(this.fJC);
      if ((localx == null) || ((int)localx.gTG == 0))
      {
        v.e("MicroMsg.AppBrandServiceConversationFmUI", "changed biz stick status failed, contact is null, talker = " + this.fJC);
        GMTrace.o(3453422141440L, 25730);
        return;
      }
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        GMTrace.o(3453422141440L, 25730);
        return;
        this.vwh.username = this.fJC;
        this.vwh.scene = this.fromScene;
        this.vwh.vcY = this.jkM;
        this.vwh.vcZ = true;
        this.vwh.show(3);
        GMTrace.o(3453422141440L, 25730);
        return;
        this.vwh.username = this.fJC;
        this.vwh.scene = this.fromScene;
        this.vwh.vcY = this.jkM;
        this.vwh.vcZ = true;
        this.vwh.show(4);
        GMTrace.o(3453422141440L, 25730);
        return;
        TS(this.fJC);
      }
    }
    
    protected final int getLayoutId()
    {
      GMTrace.i(3452348399616L, 25722);
      int i = R.i.doU;
      GMTrace.o(3452348399616L, 25722);
      return i;
    }
    
    public final String getUserName()
    {
      GMTrace.i(3452482617344L, 25723);
      String str = this.vYX;
      GMTrace.o(3452482617344L, 25723);
      return str;
    }
    
    public final void onActivityCreated(Bundle paramBundle)
    {
      GMTrace.i(3452214181888L, 25721);
      v.i("MicroMsg.AppBrandServiceConversationFmUI", "onActivityCreated");
      super.onActivityCreated(paramBundle);
      this.vYX = getStringExtra("Contact_User");
      if (TextUtils.isEmpty(this.vYX)) {
        this.vYX = "appbrandcustomerservicemsg";
      }
      this.fromScene = getIntExtra("app_brand_conversation_from_scene", 1);
      v.i("MicroMsg.AppBrandServiceConversationFmUI", "fromScene:%d", new Object[] { Integer.valueOf(this.fromScene) });
      ap.yY();
      paramBundle = new BigInteger(Integer.toBinaryString(com.tencent.mm.u.c.uH()), 2).toString();
      this.jkM = (System.currentTimeMillis() + paramBundle);
      qL(getString(R.l.dDD));
      this.vYV = ((ListView)findViewById(R.h.cIZ));
      this.jUy = ((TextView)findViewById(R.h.bLN));
      this.jUy.setText(R.l.dDO);
      b(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(3380541915136L, 25187);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.finish();
          GMTrace.o(3380541915136L, 25187);
          return true;
        }
      });
      this.vwh = new com.tencent.mm.ui.d.a(bOZ());
      this.vYW = new a(bOZ(), this.vYX, new k.a()
      {
        public final void OI()
        {
          GMTrace.i(3429934039040L, 25555);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI localAppBrandServiceConversationFmUI = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this;
          if (AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.vYW.getCount() <= 0)
          {
            localAppBrandServiceConversationFmUI.jUy.setVisibility(0);
            localAppBrandServiceConversationFmUI.vYV.setVisibility(8);
            GMTrace.o(3429934039040L, 25555);
            return;
          }
          localAppBrandServiceConversationFmUI.jUy.setVisibility(8);
          localAppBrandServiceConversationFmUI.vYV.setVisibility(0);
          GMTrace.o(3429934039040L, 25555);
        }
        
        public final void OJ()
        {
          GMTrace.i(3430068256768L, 25556);
          GMTrace.o(3430068256768L, 25556);
        }
      });
      this.vYW.a(new MMSlideDelView.c()
      {
        public final int bY(View paramAnonymousView)
        {
          GMTrace.i(3375038988288L, 25146);
          int i = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.vYV.getPositionForView(paramAnonymousView);
          GMTrace.o(3375038988288L, 25146);
          return i;
        }
      });
      this.vYW.a(new MMSlideDelView.f()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt)
        {
          GMTrace.i(3373965246464L, 25138);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.vYV.performItemClick(paramAnonymousView, paramAnonymousInt, 0L);
          GMTrace.o(3373965246464L, 25138);
        }
      });
      this.vYV.setAdapter(this.vYW);
      this.klh = new com.tencent.mm.ui.tools.l(bOZ());
      this.vYV.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          GMTrace.i(3397453348864L, 25313);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.vUE = ((ae)AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.vYW.getItem(paramAnonymousInt));
          paramAnonymousView = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.vUE;
          if (paramAnonymousView == null)
          {
            v.e("MicroMsg.AppBrandServiceConversationFmUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.vYW.getCount()) });
            AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.vYW.notifyDataSetChanged();
            GMTrace.o(3397453348864L, 25313);
            return;
          }
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.fJC = paramAnonymousView.field_username;
          paramAnonymousAdapterView = new Bundle();
          paramAnonymousAdapterView.putBoolean("finish_direct", false);
          paramAnonymousAdapterView.putBoolean("key_need_send_video", false);
          paramAnonymousAdapterView.putString("key_scene_id", AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.jkM);
          paramAnonymousAdapterView.putInt("app_brand_chatting_from_scene", AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.fromScene);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.vZA.a(paramAnonymousView.field_username, paramAnonymousAdapterView, true);
          paramAnonymousAdapterView = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this;
          paramAnonymousView = paramAnonymousView.field_username;
          paramAnonymousInt = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.fromScene;
          ap.yY();
          ae localae = com.tencent.mm.u.c.wW().Rl(paramAnonymousView);
          if (localae == null)
          {
            v.e("MicroMsg.AppBrandServiceConversationFmUI", "cvs:%s is null, error", new Object[] { paramAnonymousView });
            GMTrace.o(3397453348864L, 25313);
            return;
          }
          int i = localae.field_unReadCount;
          paramAnonymousView = bf.mz(paramAnonymousAdapterView.jkM);
          v.d("MicroMsg.AppBrandServiceConversationFmUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", new Object[] { Integer.valueOf(13799), paramAnonymousAdapterView.ivn, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), paramAnonymousView });
          com.tencent.mm.plugin.report.service.g.oSF.i(13799, new Object[] { paramAnonymousAdapterView.ivn, Integer.valueOf(paramAnonymousInt), Integer.valueOf(i), paramAnonymousView, Long.valueOf(bf.Nz()) });
          GMTrace.o(3397453348864L, 25313);
        }
      });
      this.vYV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          GMTrace.i(3377723342848L, 25166);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.vUE = ((ae)AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.vYW.getItem(paramAnonymousInt));
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.fJC = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.vUE.field_username;
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.klh.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this, AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this);
          GMTrace.o(3377723342848L, 25166);
          return true;
        }
      });
      this.vYW.a(new MMSlideDelView.c()
      {
        public final int bY(View paramAnonymousView)
        {
          GMTrace.i(3382689398784L, 25203);
          int i = AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.vYV.getPositionForView(paramAnonymousView);
          GMTrace.o(3382689398784L, 25203);
          return i;
        }
      });
      this.vYW.a(new MMSlideDelView.f()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt)
        {
          GMTrace.i(3381078786048L, 25191);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.vYV.performItemClick(paramAnonymousView, paramAnonymousInt, 0L);
          GMTrace.o(3381078786048L, 25191);
        }
      });
      this.vYW.a(new MMSlideDelView.e()
      {
        public final void aQ(Object paramAnonymousObject)
        {
          GMTrace.i(3462548946944L, 25798);
          if (paramAnonymousObject == null)
          {
            v.e("MicroMsg.AppBrandServiceConversationFmUI", "onItemDel object null");
            GMTrace.o(3462548946944L, 25798);
            return;
          }
          paramAnonymousObject = paramAnonymousObject.toString();
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.TS((String)paramAnonymousObject);
          GMTrace.o(3462548946944L, 25798);
        }
      });
      a(1, R.k.dtv, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(3372488851456L, 25127);
          paramAnonymousMenuItem = new Intent(AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.uRf.uRz, ServiceNotifySettingsUI.class);
          paramAnonymousMenuItem.putExtra("mode", 1);
          paramAnonymousMenuItem.putExtra("scene_id", AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.jkM);
          AppBrandServiceConversationUI.AppBrandServiceConversationFmUI.this.startActivity(paramAnonymousMenuItem);
          GMTrace.o(3372488851456L, 25127);
          return true;
        }
      });
      ap.yY();
      com.tencent.mm.u.c.wW().a(this.vYW);
      paramBundle = new com.tencent.mm.e.a.p();
      com.tencent.mm.sdk.b.a.uql.m(paramBundle);
      bYh();
      GMTrace.o(3452214181888L, 25721);
    }
    
    public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      GMTrace.i(3453153705984L, 25728);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      if ((this.fJC != null) && (!this.fJC.isEmpty())) {
        this.fJC = "";
      }
      if (paramInt2 != -1)
      {
        GMTrace.o(3453153705984L, 25728);
        return;
      }
      GMTrace.o(3453153705984L, 25728);
    }
    
    public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      GMTrace.i(3453556359168L, 25731);
      super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
      paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
      paramContextMenuInfo = ((com.tencent.mm.plugin.appbrand.i.b)h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(this.fJC);
      int i;
      if ((paramContextMenuInfo != null) && ((paramContextMenuInfo.field_appOpt & 0x2) > 0))
      {
        i = 1;
        if (i == 0) {
          break label108;
        }
        paramContextMenu.add(paramView.position, 1, 0, R.l.dEK);
      }
      for (;;)
      {
        paramContextMenu.add(paramView.position, 3, 0, R.l.ebn);
        GMTrace.o(3453556359168L, 25731);
        return;
        i = 0;
        break;
        label108:
        paramContextMenu.add(paramView.position, 2, 0, R.l.dEL);
      }
    }
    
    public final void onDestroy()
    {
      GMTrace.i(3452616835072L, 25724);
      if (ap.zb())
      {
        ap.yY();
        com.tencent.mm.u.c.wW().b(this.vYW);
      }
      if (this.vYW != null) {
        this.vYW.onDestroy();
      }
      super.onDestroy();
      GMTrace.o(3452616835072L, 25724);
    }
    
    public final void onPause()
    {
      GMTrace.i(3452885270528L, 25726);
      v.i("MicroMsg.AppBrandServiceConversationFmUI", "on pause");
      ap.yY();
      com.tencent.mm.u.c.wW().Rn(this.vYX);
      if (this.vYW != null) {
        this.vYW.onPause();
      }
      super.onPause();
      GMTrace.o(3452885270528L, 25726);
    }
    
    public final void onResume()
    {
      GMTrace.i(3452751052800L, 25725);
      v.i("MicroMsg.AppBrandServiceConversationFmUI", "on resume");
      if (this.vYW != null) {
        this.vYW.onResume();
      }
      super.onResume();
      GMTrace.o(3452751052800L, 25725);
    }
    
    private static final class a
      extends d
    {
      private Paint jVY;
      private String username;
      private HashMap<String, Boolean> vYZ;
      private HashMap<String, String> vZa;
      private com.tencent.mm.sdk.b.c<kj> vwf;
      
      a(Context paramContext, String paramString, k.a parama)
      {
        super(parama);
        GMTrace.i(3379736608768L, 25181);
        this.jVY = new Paint();
        this.username = paramString;
        this.vYZ = new HashMap();
        this.vZa = new HashMap();
        this.vwf = new com.tencent.mm.sdk.b.c() {};
        com.tencent.mm.sdk.b.a.uql.b(this.vwf);
        GMTrace.o(3379736608768L, 25181);
      }
      
      public final void OL()
      {
        GMTrace.i(3379870826496L, 25182);
        ap.yY();
        setCursor(com.tencent.mm.u.c.wW().c(o.hle, this.jzO, this.username));
        if (this.uQY != null) {
          this.uQY.OI();
        }
        super.notifyDataSetChanged();
        GMTrace.o(3379870826496L, 25182);
      }
      
      protected final void a(String paramString, d.g paramg)
      {
        GMTrace.i(3380005044224L, 25183);
        Object localObject1 = (Boolean)this.vYZ.get(paramString);
        boolean bool;
        if (localObject1 == null)
        {
          Object localObject2 = ((com.tencent.mm.plugin.appbrand.i.b)h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(paramString);
          if ((localObject2 != null) && ((((WxaAttributes)localObject2).field_appOpt & 0x2) > 0))
          {
            bool = true;
            this.vYZ.put(paramString, localObject1);
            label72:
            if (!bool) {
              break label591;
            }
            paramg.vtM.setVisibility(0);
            paramg.vtM.setImageResource(R.k.dvm);
            label95:
            localObject2 = (String)this.vZa.get(paramString);
            localObject1 = localObject2;
            if (TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject2 = com.tencent.mm.ui.d.b.SS(com.tencent.mm.ui.d.b.SR(paramString));
              localObject1 = localObject2;
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                this.vZa.put(paramString, localObject2);
                localObject1 = localObject2;
              }
            }
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label680;
            }
            paramg.waD.setVisibility(0);
            localObject1 = this.context.getString(R.l.dFY, new Object[] { localObject1 });
            paramg.waD.setText((CharSequence)localObject1);
            if (this.context.getResources().getDisplayMetrics() == null) {
              break label716;
            }
          }
        }
        label270:
        label338:
        label345:
        label490:
        label591:
        label636:
        label644:
        label668:
        label680:
        label716:
        for (int i = this.context.getResources().getDisplayMetrics().widthPixels;; i = 0)
        {
          int k;
          int j;
          float f1;
          float f2;
          if (com.tencent.mm.bg.a.dM(this.context))
          {
            k = this.context.getResources().getDimensionPixelOffset(R.f.aXB);
            j = this.context.getResources().getDimensionPixelOffset(R.f.aWO);
            int m = this.context.getResources().getDimensionPixelOffset(R.f.aXs);
            int n = this.context.getResources().getDimensionPixelOffset(R.f.aXG);
            localObject1 = (d.d)this.vtF.get(paramString);
            if ((localObject1 == null) || (((d.d)localObject1).nickName == null)) {
              break label636;
            }
            localObject1 = ((d.d)localObject1).nickName.toString();
            if (localObject1 != null) {
              break label644;
            }
            f1 = 0.0F;
            f2 = 48.0F + f1;
            int i1 = this.context.getResources().getDimensionPixelOffset(R.f.aWP);
            int i2 = this.context.getResources().getDimensionPixelOffset(R.f.aXw);
            v.i("MicroMsg.ConversationAdapter", "screenWidth:%d, avatarLayoutWidth:%d, timeTVWidth:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j) });
            f1 = 0.0F;
            if (i > 0) {
              f1 = i - k - m - n - j;
            }
            if ((f2 > f1) || (f2 >= f1) || (f1 <= 0.0F)) {
              break label668;
            }
            f1 = Math.min(f2 / f1, (f1 - i1 - i2 - 48.0F) / f1);
            f2 = 1.0F - f1;
            localObject1 = (LinearLayout.LayoutParams)paramg.vtJ.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = 0;
            ((LinearLayout.LayoutParams)localObject1).weight = f1;
            paramg.vtJ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            localObject1 = (LinearLayout.LayoutParams)paramg.waD.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = 0;
            ((LinearLayout.LayoutParams)localObject1).weight = f2;
            paramg.waD.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          for (;;)
          {
            a.b.m(paramg.ipb, paramString);
            GMTrace.o(3380005044224L, 25183);
            return;
            bool = false;
            break;
            bool = ((Boolean)localObject1).booleanValue();
            break label72;
            paramg.vtM.setVisibility(8);
            break label95;
            k = this.context.getResources().getDimensionPixelOffset(R.f.aXC);
            j = this.context.getResources().getDimensionPixelOffset(R.f.aWP);
            break label270;
            localObject1 = "";
            break label338;
            this.jVY.setTextSize(this.vtC);
            f1 = this.jVY.measureText((String)localObject1);
            break label345;
            f2 = 0.4F;
            f1 = 0.6F;
            break label490;
            localObject1 = (LinearLayout.LayoutParams)paramg.vtJ.getLayoutParams();
            ((LinearLayout.LayoutParams)localObject1).width = -1;
            ((LinearLayout.LayoutParams)localObject1).weight = 0.0F;
            paramg.vtJ.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
        }
      }
      
      public final void detach()
      {
        GMTrace.i(3380139261952L, 25184);
        this.vYZ = null;
        com.tencent.mm.sdk.b.a.uql.c(this.vwf);
        GMTrace.o(3380139261952L, 25184);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/conversation/AppBrandServiceConversationUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */