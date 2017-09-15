package com.tencent.mm.plugin.base.stub;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.HandlerThread;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.jg.JgClassChecked;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.i;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.i.b;
import com.tencent.mm.plugin.w.a.a.a;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.b;
import com.tencent.mm.protocal.c.azx;
import com.tencent.mm.protocal.c.bfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.q;
import com.tencent.mm.u.q.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.p.a;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.Map;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.ACTIVITYCHECK})
public class WXEntryActivity
  extends AutoLoginActivity
  implements com.tencent.mm.y.e
{
  private String appId;
  private String authority;
  private String content;
  private ProgressDialog isb;
  private int jNt;
  private String uq;
  private Uri uri;
  
  public WXEntryActivity()
  {
    GMTrace.i(12843025956864L, 95688);
    GMTrace.o(12843025956864L, 95688);
  }
  
  private void acG()
  {
    GMTrace.i(12844905005056L, 95702);
    ReportUtil.a(this, ReportUtil.b(r.ad(getIntent()), -2));
    finish();
    GMTrace.o(12844905005056L, 95702);
  }
  
  private void acH()
  {
    GMTrace.i(12845039222784L, 95703);
    ReportUtil.a(this, ReportUtil.b(r.ad(getIntent()), -6));
    finish();
    GMTrace.o(12845039222784L, 95703);
  }
  
  private static boolean checkSumConsistent(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    GMTrace.i(12844368134144L, 95698);
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0))
    {
      v.e("MicroMsg.WXEntryActivity", "checkSumConsistent fail, invalid arguments");
      GMTrace.o(12844368134144L, 95698);
      return false;
    }
    if (paramArrayOfByte1.length != paramArrayOfByte2.length)
    {
      v.e("MicroMsg.WXEntryActivity", "checkSumConsistent fail, length is different");
      GMTrace.o(12844368134144L, 95698);
      return false;
    }
    int i = 0;
    while (i < paramArrayOfByte1.length)
    {
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i])
      {
        GMTrace.o(12844368134144L, 95698);
        return false;
      }
      i += 1;
    }
    GMTrace.o(12844368134144L, 95698);
    return true;
  }
  
  private void goBack()
  {
    GMTrace.i(12844770787328L, 95701);
    View localView = findViewById(R.h.czZ);
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      acH();
      GMTrace.o(12844770787328L, 95701);
      return;
    }
    acG();
    GMTrace.o(12844770787328L, 95701);
  }
  
  private boolean h(k paramk)
  {
    GMTrace.i(12843831263232L, 95694);
    Object localObject = getIntent();
    int i = r.g(getIntent().getExtras(), "_wxapi_command_type");
    v.i("MicroMsg.WXEntryActivity", "dealRequest, cmd = %d, authority = %s", new Object[] { Integer.valueOf(i), this.authority });
    if (("sendreq".equals(this.authority)) || ("sendresp".equals(this.authority)))
    {
      if (!ap.zb())
      {
        v.w("MicroMsg.WXEntryActivity", "accHasReady not ready, do nothing");
        GMTrace.o(12843831263232L, 95694);
        return false;
      }
      com.tencent.mm.pluginsdk.model.app.f localf = com.tencent.mm.pluginsdk.model.app.g.aJ(this.appId, true);
      if (localf == null)
      {
        v.w("MicroMsg.WXEntryActivity", "app not reg, do nothing");
        GMTrace.o(12843831263232L, 95694);
        return false;
      }
      if (!p.b(this, localf, this.uq))
      {
        v.e("MicroMsg.WXEntryActivity", "send fail, check app fail, force to get app info from server again : %s", new Object[] { this.appId });
        an.aRj().Mb(this.appId);
        acH();
        a(this, localf, this.uq, i);
        GMTrace.o(12843831263232L, 95694);
        return false;
      }
      SendMessageToWX.Req localReq = new SendMessageToWX.Req(((Intent)localObject).getExtras());
      if (localReq.scene == 2)
      {
        paramk = new Intent();
        paramk.addFlags(268435456).addFlags(67108864);
        paramk.putExtras(((Intent)localObject).getExtras());
        if ((localReq.message != null) && (localReq.message.getType() == 5))
        {
          v.d("MicroMsg.WXEntryActivity", "report(11954), appId : %s", new Object[] { localf.field_appId });
          localObject = q.fQ("app_" + localf.field_appId);
          q.yC().n((String)localObject, true).l("prePublishId", "app_" + localf.field_appId);
          paramk.putExtra("reportSessionId", (String)localObject);
        }
        com.tencent.mm.bb.d.b(this, "favorite", ".ui.FavOpenApiEntry", paramk);
        GMTrace.o(12843831263232L, 95694);
        return true;
      }
      if ((paramk != null) && (localReq.message != null) && (localReq.message.getType() == 7))
      {
        paramk = ((ah)paramk).JA();
        if ((paramk != null) && (paramk.ueu != null) && (!u.mA(paramk.ueu.url)))
        {
          v.i("MicroMsg.WXEntryActivity", "change appextend to Webpage,url :%s", new Object[] { paramk.ueu.url });
          localReq.message.mediaObject = new WXWebpageObject(paramk.ueu.url);
          paramk = new Bundle();
          localReq.toBundle(paramk);
          ((Intent)localObject).putExtras(paramk);
        }
      }
      startActivity(new Intent(this, UIEntryStub.class).addFlags(268435456).addFlags(67108864).putExtras(((Intent)localObject).getExtras()));
      GMTrace.o(12843831263232L, 95694);
      return true;
    }
    v.e("MicroMsg.WXEntryActivity", "unknown authority, should never reached, authority=" + this.authority);
    GMTrace.o(12843831263232L, 95694);
    return false;
  }
  
  private static byte[] j(String paramString1, int paramInt, String paramString2)
  {
    GMTrace.i(12844233916416L, 95697);
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramString1 != null) {
      localStringBuffer.append(paramString1);
    }
    localStringBuffer.append(paramInt);
    localStringBuffer.append(paramString2);
    localStringBuffer.append("mMcShCsTr");
    paramString1 = com.tencent.mm.a.g.n(localStringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    GMTrace.o(12844233916416L, 95697);
    return paramString1;
  }
  
  private static boolean jB(int paramInt)
  {
    GMTrace.i(12844099698688L, 95696);
    if (paramInt >= 553713665)
    {
      GMTrace.o(12844099698688L, 95696);
      return true;
    }
    GMTrace.o(12844099698688L, 95696);
    return false;
  }
  
  private static String rO(String paramString)
  {
    GMTrace.i(12843697045504L, 95693);
    if (u.mA(paramString))
    {
      GMTrace.o(12843697045504L, 95693);
      return "";
    }
    try
    {
      String str = URLEncoder.encode(paramString);
      GMTrace.o(12843697045504L, 95693);
      return str;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.WXEntryActivity", "urlEncode fail, str = %s, ex = %s", new Object[] { paramString, localException.getMessage() });
      GMTrace.o(12843697045504L, 95693);
    }
    return paramString;
  }
  
  private boolean v(Intent paramIntent)
  {
    GMTrace.i(12843294392320L, 95690);
    this.jNt = r.a(paramIntent, "_mmessage_sdkVersion", 0);
    this.content = r.i(paramIntent, "_mmessage_content");
    if (this.content != null)
    {
      this.uri = Uri.parse(this.content);
      this.authority = this.uri.getAuthority();
      try
      {
        this.appId = this.uri.getQueryParameter("appid");
        this.uq = r.i(paramIntent, "_mmessage_appPackage");
        GMTrace.o(12843294392320L, 95690);
        return true;
      }
      catch (Exception paramIntent)
      {
        v.e("MicroMsg.WXEntryActivity", "init: %s", new Object[] { paramIntent.toString() });
        GMTrace.o(12843294392320L, 95690);
        return false;
      }
    }
    GMTrace.o(12843294392320L, 95690);
    return false;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(12844502351872L, 95699);
    v.i("MicroMsg.WXEntryActivity", "onSceneEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    ap.vd().b(1200, this);
    if ((this.isb != null) && (this.isb.isShowing())) {
      this.isb.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramInt1 = ((ah)paramk).JA().version;
      v.i("MicroMsg.WXEntryActivity", "server appversion = %d", new Object[] { Integer.valueOf(paramInt1) });
      paramString = com.tencent.mm.pluginsdk.model.app.g.aJ(this.appId, false);
      if (paramString == null)
      {
        v.e("MicroMsg.WXEntryActivity", "null appinfo");
        a.a.aRo().Ck(this.appId);
      }
      for (;;)
      {
        h(paramk);
        finish();
        GMTrace.o(12844502351872L, 95699);
        return;
        paramInt2 = paramString.field_appVersion;
        v.i("MicroMsg.WXEntryActivity", "local appversion = %d", new Object[] { Integer.valueOf(paramInt2) });
        if (paramInt2 < paramInt1) {
          a.a.aRo().Ck(this.appId);
        }
      }
    }
    if (p.a.a(this, paramInt1, paramInt2, null, 4))
    {
      v.i("MicroMsg.WXEntryActivity", "mm error processor process this errcode");
      finish();
      GMTrace.o(12844502351872L, 95699);
      return;
    }
    findViewById(R.h.czZ).setVisibility(0);
    zd(R.l.eWb);
    TextView localTextView = (TextView)findViewById(R.h.cED);
    if (!u.mA(paramString))
    {
      paramk = paramString;
      if (paramString.startsWith("autoauth_errmsg_")) {
        paramk = paramString.substring(16);
      }
      paramString = paramk;
      if (paramk.startsWith("<e>"))
      {
        Map localMap = bg.q(paramk, "e");
        paramString = paramk;
        if (localMap != null)
        {
          paramString = paramk;
          if (!u.mA((String)localMap.get(".e.Content"))) {
            paramString = (String)localMap.get(".e.Content");
          }
        }
      }
      localTextView.setText(getString(R.l.eWc, new Object[] { paramString }));
    }
    paramString = (Button)findViewById(R.h.bqL);
    paramk = com.tencent.mm.pluginsdk.model.app.g.m(this, this.appId);
    v.i("MicroMsg.WXEntryActivity", "appName = %s", new Object[] { paramk });
    if (!u.mA(paramk)) {
      paramString.setText(getString(R.l.eVZ) + paramk);
    }
    for (;;)
    {
      paramString.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(12833764933632L, 95619);
          WXEntryActivity.c(WXEntryActivity.this);
          WXEntryActivity.this.finish();
          GMTrace.o(12833764933632L, 95619);
        }
      });
      GMTrace.o(12844502351872L, 95699);
      return;
      paramString.setText(R.l.eVZ);
    }
  }
  
  protected final void a(AutoLoginActivity.b paramb, Intent paramIntent)
  {
    GMTrace.i(12843562827776L, 95692);
    v.d("MicroMsg.WXEntryActivity", "postLogin, loginResult = " + paramb);
    v(paramIntent);
    int i;
    switch (4.jNz[paramb.ordinal()])
    {
    default: 
      v.e("MicroMsg.WXEntryActivity", "postLogin, unknown login result = " + paramb);
      finish();
      GMTrace.o(12843562827776L, 95692);
      return;
    case 1: 
      if ((getIntent() == null) || (getIntent().getExtras() == null))
      {
        v.e("MicroMsg.WXEntryActivity", "checkCanShare fail, invalid intent/extras");
        finish();
        GMTrace.o(12843562827776L, 95692);
        return;
      }
      i = r.g(getIntent().getExtras(), "_wxapi_command_type");
      v.i("MicroMsg.WXEntryActivity", "checkCanShare, cmd = %d", new Object[] { Integer.valueOf(i) });
      if (i == 1)
      {
        v.i("MicroMsg.WXEntryActivity", "it is auth, just dealrequest");
        h(null);
        finish();
        GMTrace.o(12843562827776L, 95692);
        return;
      }
      paramIntent = new SendMessageToWX.Req(getIntent().getExtras());
      paramb = paramIntent.message;
      if (paramb == null)
      {
        v.e("MicroMsg.WXEntryActivity", "wxmsg is null, how could it be?, directly deal request");
        h(null);
        finish();
        GMTrace.o(12843562827776L, 95692);
        return;
      }
      if (paramb.getType() == 36) {
        paramIntent.scene = 0;
      }
      if (paramIntent.scene == 2) {
        i = 3;
      }
      break;
    }
    for (;;)
    {
      if (paramb.getType() == 1)
      {
        paramIntent = (WXTextObject)paramb.mediaObject;
        paramb = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s", new Object[] { this.appId, Integer.valueOf(i), rO(paramIntent.text), "", paramb.getType() });
      }
      for (;;)
      {
        this.isb = com.tencent.mm.ui.base.g.a(this.uRf.uRz, getString(R.l.dIV), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            GMTrace.i(12835912417280L, 95635);
            WXEntryActivity.b(WXEntryActivity.this);
            WXEntryActivity.this.finish();
            GMTrace.o(12835912417280L, 95635);
          }
        });
        ap.vd().a(1200, this);
        paramb = new ah(paramb, 1, new LinkedList());
        ap.vd().a(paramb, 0);
        GMTrace.o(12843562827776L, 95692);
        return;
        if (paramIntent.scene == 1)
        {
          i = 2;
          break;
        }
        if (paramIntent.scene != 0) {
          break label810;
        }
        i = 1;
        break;
        if (paramb.getType() == 5)
        {
          paramIntent = (WXWebpageObject)paramb.mediaObject;
          paramb = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s", new Object[] { this.appId, Integer.valueOf(i), rO(paramb.description), rO(paramIntent.webpageUrl), paramb.getType() });
        }
        else if (paramb.getType() == 36)
        {
          paramIntent = (WXMiniProgramObject)paramb.mediaObject;
          ((b)com.tencent.mm.kernel.h.h(b.class)).a(paramIntent.userName, null);
          paramb = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s&appbrandusername=%s&appbrandpath=%s", new Object[] { this.appId, Integer.valueOf(i), rO(paramb.description), rO(paramIntent.webpageUrl), paramb.getType(), paramIntent.userName, rO(paramIntent.path) });
        }
        else
        {
          paramb = String.format("weixin://dl/business/share/?appid=%s&type=%s&txt=%s&url=%s&msgType=%s", new Object[] { this.appId, Integer.valueOf(i), rO(paramb.description), "", paramb.getType() });
        }
      }
      acG();
      v.e("MicroMsg.WXEntryActivity", "postLogin fail, loginResult = " + paramb);
      break;
      ReportUtil.a(this, ReportUtil.b(r.ad(getIntent()), -1));
      finish();
      v.e("MicroMsg.WXEntryActivity", "postLogin fail, loginResult = " + paramb);
      break;
      label810:
      i = 0;
    }
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(12843965480960L, 95695);
    int i = R.i.dmY;
    GMTrace.o(12843965480960L, 95695);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(12843160174592L, 95689);
    r.b(getIntent(), "key_auto_login_wizard_exit", true);
    super.onCreate(paramBundle);
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(12827725135872L, 95574);
        WXEntryActivity.a(WXEntryActivity.this);
        GMTrace.o(12827725135872L, 95574);
        return false;
      }
    });
    GMTrace.o(12843160174592L, 95689);
  }
  
  protected void onDestroy()
  {
    GMTrace.i(12845173440512L, 95704);
    super.onDestroy();
    ap.vd().b(1200, this);
    GMTrace.o(12845173440512L, 95704);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(12844636569600L, 95700);
    if ((paramKeyEvent.getRepeatCount() == 0) && (paramKeyEvent.getKeyCode() == 4))
    {
      v.i("MicroMsg.WXEntryActivity", "user click back button");
      goBack();
      GMTrace.o(12844636569600L, 95700);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(12844636569600L, 95700);
    return bool;
  }
  
  protected final boolean u(Intent paramIntent)
  {
    GMTrace.i(12843428610048L, 95691);
    if (!v(paramIntent))
    {
      v.e("MicroMsg.WXEntryActivity", "Init failed");
      finish();
      GMTrace.o(12843428610048L, 95691);
      return false;
    }
    if ((!ap.zb()) || (ap.uP()))
    {
      v.w("MicroMsg.WXEntryActivity", "preLogin not login, save the appid : %s", new Object[] { this.appId });
      p.Mj(this.appId);
    }
    if (!jB(this.jNt))
    {
      v.e("MicroMsg.WXEntryActivity", "sdk version is not supported, sdkVersion = " + this.jNt);
      finish();
      GMTrace.o(12843428610048L, 95691);
      return false;
    }
    if (this.uri == null)
    {
      v.e("MicroMsg.WXEntryActivity", "check appid failed, null content");
      finish();
      GMTrace.o(12843428610048L, 95691);
      return false;
    }
    v.i("MicroMsg.WXEntryActivity", "preLogin, appId = " + this.appId);
    if (u.mA(this.appId))
    {
      v.e("MicroMsg.WXEntryActivity", "invalid appid, ignore");
      finish();
      GMTrace.o(12843428610048L, 95691);
      return false;
    }
    v.i("MicroMsg.WXEntryActivity", "preLogin, pkg = " + this.uq);
    if (u.mA(this.uq))
    {
      v.e("MicroMsg.WXEntryActivity", "unknown package, ignore");
      finish();
      GMTrace.o(12843428610048L, 95691);
      return false;
    }
    if (!checkSumConsistent(r.j(paramIntent, "_mmessage_checksum"), j(this.content, this.jNt, this.uq)))
    {
      v.e("MicroMsg.WXEntryActivity", "checksum fail");
      finish();
      GMTrace.o(12843428610048L, 95691);
      return false;
    }
    GMTrace.o(12843428610048L, 95691);
    return true;
  }
  
  @JgClassChecked(author=20, fComment="checked", lastDate="20140429", reviewer=20, vComment={com.jg.EType.RECEIVERCHECK})
  public static class EntryReceiver
    extends BroadcastReceiver
  {
    private static ad handler;
    private String appId;
    private String appName;
    private Context context;
    private long jNS;
    private int jNt;
    private String uq;
    
    public EntryReceiver()
    {
      GMTrace.i(12838865207296L, 95657);
      GMTrace.o(12838865207296L, 95657);
    }
    
    protected static void p(Runnable paramRunnable)
    {
      GMTrace.i(17849884082176L, 132992);
      new AutoLoginActivity.a().b(null, paramRunnable);
      GMTrace.o(17849884082176L, 132992);
    }
    
    public void onReceive(final Context paramContext, final Intent paramIntent)
    {
      GMTrace.i(12838999425024L, 95658);
      if ((paramContext == null) || (paramIntent == null))
      {
        GMTrace.o(12838999425024L, 95658);
        return;
      }
      com.tencent.mm.bb.d.bGH();
      if (handler == null)
      {
        HandlerThread localHandlerThread = com.tencent.mm.sdk.f.e.Qt("WXEntryReceiver");
        localHandlerThread.start();
        handler = new ad(localHandlerThread.getLooper());
      }
      paramContext = new Runnable()
      {
        public final void run()
        {
          GMTrace.i(14892799098880L, 110960);
          WXEntryActivity.EntryReceiver.acI().post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(17849212993536L, 132987);
              WXEntryActivity.EntryReceiver.a(WXEntryActivity.EntryReceiver.this, WXEntryActivity.EntryReceiver.1.this.val$context, WXEntryActivity.EntryReceiver.1.this.jNT);
              GMTrace.o(17849212993536L, 132987);
            }
          });
          GMTrace.o(14892799098880L, 110960);
        }
      };
      if (!com.tencent.mm.kernel.h.vJ().gYz.gYV)
      {
        paramIntent = ((com.tencent.mm.kernel.b.f)com.tencent.mm.kernel.h.vF().vj()).gZo.gZg;
        if (((paramIntent instanceof com.tencent.mm.app.h)) && (((com.tencent.mm.app.h)paramIntent).og())) {
          com.tencent.mm.kernel.h.vJ().a(new com.tencent.mm.kernel.api.h()
          {
            public final void ak(boolean paramAnonymousBoolean)
            {
              GMTrace.i(17850420953088L, 132996);
              GMTrace.o(17850420953088L, 132996);
            }
            
            public final void oh()
            {
              GMTrace.i(17850286735360L, 132995);
              WXEntryActivity.EntryReceiver.p(paramContext);
              com.tencent.mm.kernel.h.vJ().b(this);
              GMTrace.o(17850286735360L, 132995);
            }
          });
        }
        v.w("MicroMsg.WXEntryActivity", "DefaultBootStep was wrong again....");
        GMTrace.o(12838999425024L, 95658);
        return;
      }
      p(paramContext);
      GMTrace.o(12838999425024L, 95658);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/base/stub/WXEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */