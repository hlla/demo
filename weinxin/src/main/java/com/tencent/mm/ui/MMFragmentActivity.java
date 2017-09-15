package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.d.t;
import com.tencent.mm.e.a.d.a;
import com.tencent.mm.s.a.a;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import com.tencent.mm.ui.widget.j.a;
import com.tencent.mm.vending.e.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class MMFragmentActivity
  extends ActionBarActivity
  implements SwipeBackLayout.a, j.a, com.tencent.mm.vending.e.b
{
  String className;
  public boolean jba;
  public SwipeBackLayout uSO;
  ArrayList<WeakReference<q>> uSU;
  private b uSV;
  private com.tencent.mm.vending.a.a uSW;
  private a uSX;
  private View uSY;
  
  public MMFragmentActivity()
  {
    GMTrace.i(1657320505344L, 12348);
    this.uSU = new ArrayList();
    this.uSW = new com.tencent.mm.vending.a.a();
    this.uSX = new a();
    this.uSY = null;
    GMTrace.o(1657320505344L, 12348);
  }
  
  private void ai(Intent paramIntent)
  {
    GMTrace.i(1658662682624L, 12358);
    if (paramIntent == null)
    {
      paramIntent = null;
      if (paramIntent == null) {
        break label152;
      }
      if (!paramIntent.getClassName().startsWith(paramIntent.getPackageName())) {
        break label81;
      }
      paramIntent = paramIntent.getClassName();
      label38:
      if ((com.tencent.mm.ui.base.b.ST(paramIntent) & 0x2) != 0) {
        break label109;
      }
    }
    label81:
    label109:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label114;
      }
      super.overridePendingTransition(a.uTe, a.uTf);
      GMTrace.o(1658662682624L, 12358);
      return;
      paramIntent = paramIntent.getComponent();
      break;
      paramIntent = paramIntent.getPackageName() + paramIntent.getClassName();
      break label38;
    }
    label114:
    if ((com.tencent.mm.ui.base.b.ST(paramIntent) & 0x4) != 0) {}
    for (i = 1; i == 0; i = 0)
    {
      com.tencent.mm.ui.base.b.eL(this);
      GMTrace.o(1658662682624L, 12358);
      return;
    }
    com.tencent.mm.ui.base.b.eO(this);
    label152:
    GMTrace.o(1658662682624L, 12358);
  }
  
  private boolean bPY()
  {
    GMTrace.i(1659870642176L, 12367);
    if ((com.tencent.mm.compatible.util.d.eo(19)) && (com.tencent.mm.compatible.h.a.rX()))
    {
      if ((bin()) && (com.tencent.mm.ui.base.b.x(getClass())))
      {
        GMTrace.o(1659870642176L, 12367);
        return true;
      }
      GMTrace.o(1659870642176L, 12367);
      return false;
    }
    GMTrace.o(1659870642176L, 12367);
    return false;
  }
  
  public void O(float paramFloat)
  {
    GMTrace.i(1660810166272L, 12374);
    v.v("ashutest", "ashutest::on swipe %f, duration %d", new Object[] { Float.valueOf(paramFloat), Long.valueOf(240L) });
    Window localWindow;
    if (this.uSY == null)
    {
      localWindow = getWindow();
      if (cO().cP() == null) {
        break label106;
      }
    }
    label106:
    for (View localView = cO().cP().getCustomView();; localView = null)
    {
      this.uSY = x.a(localWindow, localView);
      localView = this.uSY;
      if (Float.compare(1.0F, paramFloat) > 0) {
        break;
      }
      com.tencent.mm.ui.tools.j.n(localView, 0.0F);
      GMTrace.o(1660810166272L, 12374);
      return;
    }
    com.tencent.mm.ui.tools.j.n(localView, localView.getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
    GMTrace.o(1660810166272L, 12374);
  }
  
  public boolean VC()
  {
    GMTrace.i(1661615472640L, 12380);
    GMTrace.o(1661615472640L, 12380);
    return false;
  }
  
  public void VD()
  {
    GMTrace.i(1661078601728L, 12376);
    if (!isFinishing()) {
      finish();
    }
    overridePendingTransition(0, 0);
    this.jba = false;
    GMTrace.o(1661078601728L, 12376);
  }
  
  public void VE()
  {
    GMTrace.i(1661347037184L, 12378);
    this.jba = true;
    GMTrace.o(1661347037184L, 12378);
  }
  
  public final void a(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    GMTrace.i(1659736424448L, 12366);
    super.a(paramFragment, paramIntent, paramInt);
    ai(paramIntent);
    GMTrace.o(1659736424448L, 12366);
  }
  
  public void a(com.tencent.mm.vending.e.a parama)
  {
    GMTrace.i(1657454723072L, 12349);
    this.uSW.wzr.a(parama);
    GMTrace.o(1657454723072L, 12349);
  }
  
  public final void aQ()
  {
    GMTrace.i(1661883908096L, 12382);
    if (bPC() != null)
    {
      q localq = bPC();
      if (localq.uRf.bPU()) {
        localq.uRf.aQ();
      }
      for (int i = 1; i != 0; i = 0)
      {
        GMTrace.o(1661883908096L, 12382);
        return;
      }
    }
    super.aQ();
    GMTrace.o(1661883908096L, 12382);
  }
  
  public boolean bDR()
  {
    GMTrace.i(18915438624768L, 140931);
    if (aa.bIR())
    {
      com.tencent.mm.e.a.d locald = new com.tencent.mm.e.a.d();
      locald.fCa.cFR = 1;
      com.tencent.mm.sdk.b.a.uql.m(locald);
      boolean bool1 = locald.fCa.fCb;
      boolean bool2 = locald.fCa.isReady;
      boolean bool3 = locald.fCa.fCc;
      if ((bool1) && ((!bool2) || (!bool3)))
      {
        v.i("MicroMsg.MMFragmentActivity", "summerasyncinit isLogin but accReady isInitializedNotifyAllDone[%b, %b] return false stack[%s]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), bf.bJP() });
        GMTrace.o(18915438624768L, 140931);
        return false;
      }
    }
    GMTrace.o(18915438624768L, 140931);
    return true;
  }
  
  public q bPC()
  {
    GMTrace.i(1658394247168L, 12356);
    int i = this.uSU.size();
    if (i == 0)
    {
      GMTrace.o(1658394247168L, 12356);
      return null;
    }
    q localq = (q)((WeakReference)this.uSU.get(i - 1)).get();
    if ((localq != null) && (localq.isShowing()))
    {
      GMTrace.o(1658394247168L, 12356);
      return localq;
    }
    GMTrace.o(1658394247168L, 12356);
    return null;
  }
  
  public final boolean bQd()
  {
    GMTrace.i(1660273295360L, 12370);
    if (com.tencent.mm.compatible.util.d.eo(19))
    {
      if ((!com.tencent.mm.ui.base.b.x(getClass())) || (!bxM())) {
        break label67;
      }
      ae.v(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(1604572938240L, 11955);
          com.tencent.mm.ui.base.b.ad(MMFragmentActivity.this);
          GMTrace.o(1604572938240L, 11955);
        }
      });
    }
    label67:
    label103:
    while (bPY())
    {
      bQe();
      GMTrace.o(1660273295360L, 12370);
      return true;
      if ((com.tencent.mm.ui.base.b.w(getClass()) & 0x10) != 0) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label103;
        }
        ae.v(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(2532017438720L, 18865);
            com.tencent.mm.ui.base.b.ad(MMFragmentActivity.this);
            GMTrace.o(2532017438720L, 18865);
          }
        });
        break;
      }
    }
    GMTrace.o(1660273295360L, 12370);
    return false;
  }
  
  protected void bQe()
  {
    GMTrace.i(1660407513088L, 12371);
    ViewGroup localViewGroup1 = (ViewGroup)getWindow().getDecorView();
    this.uSO = ((SwipeBackLayout)LayoutInflater.from(this).inflate(a.h.heD, localViewGroup1, false));
    this.uSO.init();
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    getWindow().getDecorView().setBackgroundDrawable(null);
    ViewGroup localViewGroup2 = (ViewGroup)localViewGroup1.getChildAt(0);
    localViewGroup2.setBackgroundResource(a.d.transparent);
    localViewGroup1.removeView(localViewGroup2);
    this.uSO.addView(localViewGroup2);
    this.uSO.Ih = localViewGroup2;
    localViewGroup1.addView(this.uSO);
    this.uSO.wvH = this;
    GMTrace.o(1660407513088L, 12371);
  }
  
  public boolean bin()
  {
    GMTrace.i(1660004859904L, 12368);
    GMTrace.o(1660004859904L, 12368);
    return true;
  }
  
  public boolean bxM()
  {
    GMTrace.i(1660139077632L, 12369);
    GMTrace.o(1660139077632L, 12369);
    return true;
  }
  
  public void d(boolean paramBoolean, int paramInt)
  {
    long l = 120L;
    GMTrace.i(1660944384000L, 12375);
    v.v("ashutest", "ashutest:: on settle %B, speed %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.uSY == null) {
      this.uSY = x.a(getWindow(), cO().cP().getCustomView());
    }
    View localView = this.uSY;
    if (paramBoolean)
    {
      if (paramInt > 0) {}
      for (;;)
      {
        com.tencent.mm.ui.tools.j.a(localView, l, 0.0F, null);
        GMTrace.o(1660944384000L, 12375);
        return;
        l = 240L;
      }
    }
    if (paramInt > 0) {}
    for (;;)
    {
      com.tencent.mm.ui.tools.j.a(localView, l, localView.getWidth() * -1 / 4, null);
      GMTrace.o(1660944384000L, 12375);
      return;
      l = 240L;
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    GMTrace.i(1661481254912L, 12379);
    if ((bPY()) && (paramKeyEvent.getKeyCode() == 4) && (this.uSO.caE()))
    {
      v.w("ashutest", "ashutest::IS SwipeBack ING, ignore KeyBack Event");
      GMTrace.o(1661481254912L, 12379);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    GMTrace.o(1661481254912L, 12379);
    return bool;
  }
  
  public void finish()
  {
    int j = 1;
    GMTrace.i(1658796900352L, 12359);
    super.finish();
    if ((com.tencent.mm.ui.base.b.w(getClass()) & 0x2) == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      super.overridePendingTransition(a.uTg, a.uTh);
      GMTrace.o(1658796900352L, 12359);
      return;
    }
    if ((com.tencent.mm.ui.base.b.w(getClass()) & 0x4) != 0) {}
    for (i = j; i == 0; i = 0)
    {
      com.tencent.mm.ui.base.b.eN(this);
      GMTrace.o(1658796900352L, 12359);
      return;
    }
    com.tencent.mm.ui.base.b.eO(this);
    GMTrace.o(1658796900352L, 12359);
  }
  
  public Resources getResources()
  {
    GMTrace.i(1660675948544L, 12373);
    if ((getAssets() != null) && (aa.getResources() != null))
    {
      localResources = aa.getResources();
      GMTrace.o(1660675948544L, 12373);
      return localResources;
    }
    Resources localResources = super.getResources();
    GMTrace.o(1660675948544L, 12373);
    return localResources;
  }
  
  public Object getSystemService(String paramString)
  {
    GMTrace.i(1660541730816L, 12372);
    Object localObject = super.getSystemService(paramString);
    if ("layout_inflater".equals(paramString))
    {
      paramString = r.b((LayoutInflater)localObject);
      GMTrace.o(1660541730816L, 12372);
      return paramString;
    }
    GMTrace.o(1660541730816L, 12372);
    return localObject;
  }
  
  public void onCancel()
  {
    GMTrace.i(1661212819456L, 12377);
    this.jba = false;
    GMTrace.o(1661212819456L, 12377);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    GMTrace.i(1661749690368L, 12381);
    super.onConfigurationChanged(paramConfiguration);
    if (cO().cP() != null)
    {
      paramConfiguration = (ViewGroup)findViewById(a.g.JZ);
      if (paramConfiguration != null)
      {
        paramConfiguration = paramConfiguration.findViewById(a.g.JL);
        if ((paramConfiguration != null) && ((paramConfiguration instanceof Toolbar)))
        {
          paramConfiguration = (Toolbar)paramConfiguration;
          ViewGroup.LayoutParams localLayoutParams = paramConfiguration.getLayoutParams();
          if (localLayoutParams != null) {
            localLayoutParams.height = com.tencent.mm.compatible.util.a.e(this);
          }
          paramConfiguration.setLayoutParams(localLayoutParams);
        }
      }
    }
    GMTrace.o(1661749690368L, 12381);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool1 = true;
    GMTrace.i(1657588940800L, 12350);
    this.className = getClass().getName();
    w.aB(3, this.className);
    super.onCreate(paramBundle);
    if (!bDR()) {
      for (;;)
      {
        try
        {
          boolean bool2 = com.tencent.mm.sdk.a.b.foreground;
          if (paramBundle == null) {
            continue;
          }
          v.e("MicroMsg.MMFragmentActivity", "summerasyncinit not init activity foreground[%b] savedInstanceState[%b], activity[%s, %d]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), getClass().getSimpleName(), Integer.valueOf(hashCode()) });
          finish();
        }
        catch (Throwable paramBundle)
        {
          v.printErrStackTrace("MicroMsg.MMFragmentActivity", paramBundle, "summerasyncinit finish:", new Object[0]);
          continue;
        }
        System.exit(0);
        GMTrace.o(1657588940800L, 12350);
        return;
        bool1 = false;
      }
    }
    this.uSV = new b();
    paramBundle = this.uSV;
    paramBundle.uTi = NfcAdapter.getDefaultAdapter(paramBundle.uSZ);
    Object localObject = new Intent();
    ((Intent)localObject).setClassName(aa.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI");
    ((Intent)localObject).addFlags(536870912);
    paramBundle.ama = PendingIntent.getActivity(paramBundle.uSZ, 0, (Intent)localObject, 0);
    localObject = new IntentFilter("android.nfc.action.NDEF_DISCOVERED");
    try
    {
      ((IntentFilter)localObject).addDataType("*/*");
      IntentFilter localIntentFilter = new IntentFilter("android.nfc.action.TECH_DISCOVERED");
      localIntentFilter.addDataScheme("vnd.android.nfc");
      paramBundle.uTj = new IntentFilter[] { localObject, localIntentFilter, new IntentFilter("android.nfc.action.TAG_DISCOVERED") };
      paramBundle.uTk = new String[][] { { NfcA.class.getName(), IsoDep.class.getName() } };
      GMTrace.o(1657588940800L, 12350);
      return;
    }
    catch (IntentFilter.MalformedMimeTypeException paramBundle)
    {
      throw new RuntimeException("fail", paramBundle);
    }
  }
  
  public void onDestroy()
  {
    GMTrace.i(1657723158528L, 12351);
    this.uSW.wzr.dead();
    super.onDestroy();
    GMTrace.o(1657723158528L, 12351);
  }
  
  public void onPause()
  {
    GMTrace.i(1658125811712L, 12354);
    w.aB(2, this.className);
    super.onPause();
    if (bPY())
    {
      if (this.uSO != null) {
        this.uSO.mEnable = false;
      }
      if (!isFinishing()) {
        com.tencent.mm.ui.widget.j.a(this);
      }
    }
    b localb;
    if (this.uSV != null)
    {
      localb = this.uSV;
      if (localb.uTi == null) {}
    }
    try
    {
      localb.uTi.disableForegroundDispatch(localb.uSZ);
      this.uSW.wzs.dead();
      GMTrace.o(1658125811712L, 12354);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        v.e("MicroMsg.MMFragmentActivity", "lo-nfc-onPause: exp:" + localIllegalStateException.getLocalizedMessage());
      }
    }
  }
  
  public void onResume()
  {
    GMTrace.i(1658260029440L, 12355);
    w.aB(1, this.className);
    super.onResume();
    if (bPY())
    {
      com.tencent.mm.ui.widget.j.b(this);
      O(1.0F);
      if (this.uSO != null)
      {
        this.uSO.mEnable = true;
        this.uSO.wrX = false;
      }
    }
    if (this.uSV != null)
    {
      b localb = this.uSV;
      if (localb.uTi != null) {
        try
        {
          localb.uTi.enableForegroundDispatch(localb.uSZ, localb.ama, localb.uTj, localb.uTk);
          GMTrace.o(1658260029440L, 12355);
          return;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          v.e("MicroMsg.MMFragmentActivity", "lo-nfc-onResume: exp:" + localIllegalStateException.getLocalizedMessage());
        }
      }
    }
    GMTrace.o(1658260029440L, 12355);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    GMTrace.i(1658528464896L, 12357);
    if (Build.VERSION.SDK_INT < 11) {
      super.onSaveInstanceState(paramBundle);
    }
    GMTrace.o(1658528464896L, 12357);
  }
  
  public void onStart()
  {
    GMTrace.i(1657991593984L, 12353);
    super.onStart();
    GMTrace.o(1657991593984L, 12353);
  }
  
  public void onStop()
  {
    GMTrace.i(1657857376256L, 12352);
    this.uSW.wzt.dead();
    super.onStop();
    GMTrace.o(1657857376256L, 12352);
  }
  
  @TargetApi(11)
  public void startActivities(Intent[] paramArrayOfIntent)
  {
    GMTrace.i(1659065335808L, 12361);
    super.startActivities(paramArrayOfIntent);
    ai(null);
    GMTrace.o(1659065335808L, 12361);
  }
  
  @TargetApi(16)
  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    GMTrace.i(1658931118080L, 12360);
    super.startActivities(paramArrayOfIntent, paramBundle);
    ai(null);
    GMTrace.o(1658931118080L, 12360);
  }
  
  public void startActivity(Intent paramIntent)
  {
    GMTrace.i(1659199553536L, 12362);
    super.startActivity(paramIntent);
    ai(paramIntent);
    GMTrace.o(1659199553536L, 12362);
  }
  
  @TargetApi(16)
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    GMTrace.i(1659333771264L, 12363);
    super.startActivity(paramIntent, paramBundle);
    ai(paramIntent);
    GMTrace.o(1659333771264L, 12363);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    GMTrace.i(1659467988992L, 12364);
    super.startActivityForResult(paramIntent, paramInt);
    ai(paramIntent);
    GMTrace.o(1659467988992L, 12364);
  }
  
  @TargetApi(16)
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    GMTrace.i(1659602206720L, 12365);
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    ai(paramIntent);
    GMTrace.o(1659602206720L, 12365);
  }
  
  public static final class a
  {
    public static int uTa;
    public static int uTb;
    public static int uTc;
    public static int uTd;
    public static int uTe;
    public static int uTf;
    public static int uTg;
    public static int uTh;
    
    static
    {
      GMTrace.i(2918430277632L, 21744);
      boolean bool2 = com.tencent.mm.compatible.util.d.eo(19);
      boolean bool1 = com.tencent.mm.compatible.h.a.rX() & bool2;
      if (bool1)
      {
        i = a.a.aRN;
        uTa = i;
        if (!bool1) {
          break label110;
        }
        i = a.a.aRM;
        label41:
        uTb = i;
        if (!bool1) {
          break label117;
        }
        i = a.a.aRL;
        label53:
        uTc = i;
        if (!bool1) {
          break label124;
        }
      }
      label110:
      label117:
      label124:
      for (int i = a.a.aRO;; i = a.a.aRn)
      {
        uTd = i;
        uTe = uTa;
        uTf = uTb;
        uTg = uTc;
        uTh = uTd;
        GMTrace.o(2918430277632L, 21744);
        return;
        i = a.a.aRm;
        break;
        i = a.a.aQL;
        break label41;
        i = a.a.aQL;
        break label53;
      }
    }
    
    public a()
    {
      GMTrace.i(2918161842176L, 21742);
      GMTrace.o(2918161842176L, 21742);
    }
    
    public static void bQf()
    {
      GMTrace.i(2918296059904L, 21743);
      t localt = p.gQX;
      boolean bool = t.rQ();
      v.i("MicroMsg.MMFragmentActivity", "lm: setAnimationStyle swipbackType = " + bool);
      if (!bool)
      {
        GMTrace.o(2918296059904L, 21743);
        return;
      }
      bool = com.tencent.mm.compatible.util.d.eo(19);
      bool = com.tencent.mm.compatible.h.a.rX() & bool;
      v.i("MicroMsg.MMFragmentActivity", "lm: setAnimationStyle supportSwipe = " + bool);
      if (bool)
      {
        i = a.a.aRN;
        uTa = i;
        if (!bool) {
          break label174;
        }
        i = a.a.aRM;
        label105:
        uTb = i;
        if (!bool) {
          break label181;
        }
        i = a.a.aRL;
        label117:
        uTc = i;
        if (!bool) {
          break label188;
        }
      }
      label174:
      label181:
      label188:
      for (int i = a.a.aRO;; i = a.a.aRn)
      {
        uTd = i;
        uTe = uTa;
        uTf = uTb;
        uTg = uTc;
        uTh = uTd;
        GMTrace.o(2918296059904L, 21743);
        return;
        i = a.a.aRm;
        break;
        i = a.a.aQL;
        break label105;
        i = a.a.aQL;
        break label117;
      }
    }
  }
  
  private final class b
  {
    PendingIntent ama;
    NfcAdapter uTi;
    IntentFilter[] uTj;
    String[][] uTk;
    
    public b()
    {
      GMTrace.i(2933596880896L, 21857);
      GMTrace.o(2933596880896L, 21857);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/MMFragmentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */