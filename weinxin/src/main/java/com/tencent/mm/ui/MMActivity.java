package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.a.d;
import com.tencent.mm.e.a.d.a;
import com.tencent.mm.s.a.d;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

@com.tencent.mm.ui.base.a(0)
public abstract class MMActivity
  extends MMFragmentActivity
{
  String className;
  public boolean uRe;
  public l uRf;
  public a uRg;
  public boolean uRh;
  
  public MMActivity()
  {
    GMTrace.i(2091246419968L, 15581);
    this.uRe = false;
    this.uRf = new l()
    {
      protected final void Sz()
      {
        GMTrace.i(2085340839936L, 15537);
        MMActivity.this.Sz();
        GMTrace.o(2085340839936L, 15537);
      }
      
      public final boolean WV()
      {
        GMTrace.i(2085743493120L, 15540);
        boolean bool = MMActivity.this.WV();
        GMTrace.o(2085743493120L, 15540);
        return bool;
      }
      
      protected final String aFH()
      {
        GMTrace.i(2084938186752L, 15534);
        String str = MMActivity.this.aFH();
        GMTrace.o(2084938186752L, 15534);
        return str;
      }
      
      protected final void bF(View paramAnonymousView)
      {
        GMTrace.i(2084803969024L, 15533);
        MMActivity.this.bF(paramAnonymousView);
        GMTrace.o(2084803969024L, 15533);
      }
      
      protected final boolean bPE()
      {
        GMTrace.i(2085609275392L, 15539);
        boolean bool = MMActivity.this.bPE();
        GMTrace.o(2085609275392L, 15539);
        return bool;
      }
      
      protected final View bPQ()
      {
        GMTrace.i(2085072404480L, 15535);
        GMTrace.o(2085072404480L, 15535);
        return null;
      }
      
      public final void bil()
      {
        GMTrace.i(2085206622208L, 15536);
        MMActivity.this.bil();
        GMTrace.o(2085206622208L, 15536);
      }
      
      public final boolean byc()
      {
        GMTrace.i(2085877710848L, 15541);
        boolean bool = MMActivity.this.byc();
        GMTrace.o(2085877710848L, 15541);
        return bool;
      }
      
      protected final String getClassName()
      {
        GMTrace.i(2085475057664L, 15538);
        String str = MMActivity.this.getClass().getName();
        GMTrace.o(2085475057664L, 15538);
        return str;
      }
      
      protected final int getLayoutId()
      {
        GMTrace.i(2084669751296L, 15532);
        int i = MMActivity.this.getLayoutId();
        GMTrace.o(2084669751296L, 15532);
        return i;
      }
    };
    this.uRg = null;
    this.uRh = false;
    GMTrace.o(2091246419968L, 15581);
  }
  
  public static void O(Activity paramActivity)
  {
    GMTrace.i(2101044314112L, 15654);
    InputMethodManager localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      GMTrace.o(2101044314112L, 15654);
      return;
    }
    paramActivity = paramActivity.getCurrentFocus();
    if (paramActivity == null)
    {
      GMTrace.o(2101044314112L, 15654);
      return;
    }
    if (paramActivity.getWindowToken() == null)
    {
      GMTrace.o(2101044314112L, 15654);
      return;
    }
    localInputMethodManager.toggleSoftInput(0, 2);
    GMTrace.o(2101044314112L, 15654);
  }
  
  public static void bPG()
  {
    GMTrace.i(2094736080896L, 15607);
    l.bPG();
    GMTrace.o(2094736080896L, 15607);
  }
  
  public static Locale et(Context paramContext)
  {
    GMTrace.i(2091649073152L, 15584);
    paramContext = l.et(paramContext);
    GMTrace.o(2091649073152L, 15584);
    return paramContext;
  }
  
  @Deprecated
  public void KD()
  {
    GMTrace.i(2091380637696L, 15582);
    GMTrace.o(2091380637696L, 15582);
  }
  
  public final void L(CharSequence paramCharSequence)
  {
    GMTrace.i(2096346693632L, 15619);
    this.uRf.L(paramCharSequence);
    GMTrace.o(2096346693632L, 15619);
  }
  
  public int Om()
  {
    GMTrace.i(2093393903616L, 15597);
    GMTrace.o(2093393903616L, 15597);
    return -1;
  }
  
  public final void SD(String paramString)
  {
    GMTrace.i(2096615129088L, 15621);
    this.uRf.SD(paramString);
    GMTrace.o(2096615129088L, 15621);
  }
  
  public void Sz()
  {
    GMTrace.i(2091783290880L, 15585);
    GMTrace.o(2091783290880L, 15585);
  }
  
  public void VD()
  {
    GMTrace.i(2093125468160L, 15595);
    if (!byb()) {
      this.uRf.bPS();
    }
    super.VD();
    GMTrace.o(2093125468160L, 15595);
  }
  
  public boolean WV()
  {
    GMTrace.i(2092454379520L, 15590);
    GMTrace.o(2092454379520L, 15590);
    return false;
  }
  
  public final void Y(Runnable paramRunnable)
  {
    GMTrace.i(2099433701376L, 15642);
    l locall = this.uRf;
    if (locall.Gx == null)
    {
      GMTrace.o(2099433701376L, 15642);
      return;
    }
    locall.Gx.getCustomView().setOnClickListener(new l.2(locall, paramRunnable));
    GMTrace.o(2099433701376L, 15642);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    GMTrace.i(2099031048192L, 15639);
    this.uRf.a(paramInt1, paramInt2, paramInt3, paramOnMenuItemClickListener);
    GMTrace.o(2099031048192L, 15639);
  }
  
  public final void a(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    GMTrace.i(2098762612736L, 15637);
    this.uRf.a(paramInt1, paramInt2, paramOnMenuItemClickListener);
    GMTrace.o(2098762612736L, 15637);
  }
  
  public void a(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    GMTrace.i(2098494177280L, 15635);
    this.uRf.a(paramInt, 0, paramString, paramOnMenuItemClickListener, null, l.b.uSi);
    GMTrace.o(2098494177280L, 15635);
  }
  
  public final void a(int paramInt1, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt2)
  {
    GMTrace.i(2098628395008L, 15636);
    this.uRf.a(paramInt1, paramString, paramOnMenuItemClickListener, null, paramInt2);
    GMTrace.o(2098628395008L, 15636);
  }
  
  public final void a(Dialog paramDialog)
  {
    GMTrace.i(2094333427712L, 15604);
    l locall = this.uRf;
    if (paramDialog != null)
    {
      if (locall.uRE == null) {
        locall.uRE = new ArrayList();
      }
      locall.uRE.add(paramDialog);
    }
    GMTrace.o(2094333427712L, 15604);
  }
  
  public final void a(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    GMTrace.i(2099299483648L, 15641);
    l.a locala = this.uRf.zl(1);
    if (locala != null)
    {
      locala.oTr = paramOnMenuItemClickListener;
      locala.lJL = null;
    }
    GMTrace.o(2099299483648L, 15641);
  }
  
  public final void a(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, int paramInt)
  {
    GMTrace.i(2099702136832L, 15644);
    this.uRf.a(paramOnMenuItemClickListener, paramInt);
    GMTrace.o(2099702136832L, 15644);
  }
  
  public final void a(a parama, Intent paramIntent, int paramInt)
  {
    GMTrace.i(2101581185024L, 15658);
    this.uRg = parama;
    startActivityForResult(paramIntent, paramInt);
    GMTrace.o(2101581185024L, 15658);
  }
  
  public final void a(p paramp)
  {
    GMTrace.i(2098359959552L, 15634);
    this.uRf.a(true, paramp);
    GMTrace.o(2098359959552L, 15634);
  }
  
  public final void a(Class<?> paramClass, Intent paramIntent)
  {
    GMTrace.i(2101446967296L, 15657);
    paramIntent.setClass(this, paramClass);
    startActivity(paramIntent);
    GMTrace.o(2101446967296L, 15657);
  }
  
  public final void aA(int paramInt, String paramString)
  {
    GMTrace.i(2099165265920L, 15640);
    l locall = this.uRf;
    l.a locala = locall.zl(paramInt);
    if ((locala != null) && (!bf.ap(paramString, "").equals(locala.text)))
    {
      locala.text = paramString;
      locall.aQ();
    }
    GMTrace.o(2099165265920L, 15640);
  }
  
  public String aFH()
  {
    GMTrace.i(2095407169536L, 15612);
    GMTrace.o(2095407169536L, 15612);
    return "";
  }
  
  public void aGY()
  {
    GMTrace.i(2100641660928L, 15651);
    this.uRf.aqY();
    GMTrace.o(2100641660928L, 15651);
  }
  
  public void aHc()
  {
    GMTrace.i(2100910096384L, 15653);
    this.uRf.aHc();
    GMTrace.o(2100910096384L, 15653);
  }
  
  public final void ae(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(2097688870912L, 15629);
    this.uRf.a(false, paramInt, paramBoolean);
    GMTrace.o(2097688870912L, 15629);
  }
  
  public final void af(int paramInt, boolean paramBoolean)
  {
    GMTrace.i(2097957306368L, 15631);
    this.uRf.b(false, paramInt, paramBoolean);
    GMTrace.o(2097957306368L, 15631);
  }
  
  public void azo()
  {
    GMTrace.i(2093528121344L, 15598);
    if (Om() == -1)
    {
      this.uRe = getSharedPreferences(aa.bIN(), 0).getBoolean("settings_landscape_mode", false);
      if (this.uRe)
      {
        setRequestedOrientation(-1);
        GMTrace.o(2093528121344L, 15598);
        return;
      }
      setRequestedOrientation(1);
      GMTrace.o(2093528121344L, 15598);
      return;
    }
    setRequestedOrientation(Om());
    GMTrace.o(2093528121344L, 15598);
  }
  
  public void b(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    GMTrace.i(2099567919104L, 15643);
    this.uRf.a(paramOnMenuItemClickListener, 0);
    GMTrace.o(2099567919104L, 15643);
  }
  
  public boolean bDR()
  {
    GMTrace.i(2092185944064L, 15588);
    if (aa.bIR())
    {
      d locald = new d();
      locald.fCa.cFR = 0;
      com.tencent.mm.sdk.b.a.uql.m(locald);
      boolean bool1 = locald.fCa.fCb;
      boolean bool2 = locald.fCa.isReady;
      boolean bool3 = locald.fCa.fCc;
      if ((bool1) && ((!bool2) || (!bool3)))
      {
        v.i("MicroMsg.MMActivity", "summerasyncinit isLogin but accReady isInitializedNotifyAllDone[%b, %b] return false stack[%s]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), bf.bJP() });
        GMTrace.o(2092185944064L, 15588);
        return false;
      }
    }
    GMTrace.o(2092185944064L, 15588);
    return true;
  }
  
  public void bF(View paramView)
  {
    GMTrace.i(2092320161792L, 15589);
    setContentView(paramView);
    GMTrace.o(2092320161792L, 15589);
  }
  
  public boolean bPE()
  {
    GMTrace.i(2091917508608L, 15586);
    GMTrace.o(2091917508608L, 15586);
    return false;
  }
  
  public final ActionBarActivity bPF()
  {
    GMTrace.i(2094467645440L, 15605);
    ActionBarActivity localActionBarActivity = this.uRf.uRz;
    GMTrace.o(2094467645440L, 15605);
    return localActionBarActivity;
  }
  
  public final void bPH()
  {
    GMTrace.i(2097152000000L, 15625);
    l locall = this.uRf;
    if (locall.uRF == null)
    {
      GMTrace.o(2097152000000L, 15625);
      return;
    }
    locall.uRF.setVisibility(8);
    GMTrace.o(2097152000000L, 15625);
  }
  
  public final void bPI()
  {
    GMTrace.i(2097286217728L, 15626);
    l locall = this.uRf;
    if (locall.Gx != null)
    {
      locall.Gx.setDisplayHomeAsUpEnabled(false);
      if ((locall.uRH != null) && (locall.uRJ != null))
      {
        locall.uRH.setVisibility(8);
        locall.uRJ.setVisibility(0);
      }
    }
    GMTrace.o(2097286217728L, 15626);
  }
  
  public final boolean bPJ()
  {
    GMTrace.i(2098091524096L, 15632);
    Iterator localIterator = this.uRf.uRC.iterator();
    while (localIterator.hasNext())
    {
      l.a locala = (l.a)localIterator.next();
      if (locala.uSc == 0)
      {
        boolean bool = locala.fFL;
        GMTrace.o(2098091524096L, 15632);
        return bool;
      }
    }
    GMTrace.o(2098091524096L, 15632);
    return false;
  }
  
  public final boolean bPK()
  {
    GMTrace.i(2098225741824L, 15633);
    Iterator localIterator = this.uRf.uRC.iterator();
    while (localIterator.hasNext())
    {
      l.a locala = (l.a)localIterator.next();
      if (locala.uSc == 0)
      {
        boolean bool = locala.visible;
        GMTrace.o(2098225741824L, 15633);
        return bool;
      }
    }
    GMTrace.o(2098225741824L, 15633);
    return false;
  }
  
  public final CharSequence bPL()
  {
    GMTrace.i(2100104790016L, 15647);
    Object localObject = this.uRf;
    if (((l)localObject).Gx == null)
    {
      GMTrace.o(2100104790016L, 15647);
      return null;
    }
    if (((l)localObject).uRq != null)
    {
      localObject = ((l)localObject).uRq;
      GMTrace.o(2100104790016L, 15647);
      return (CharSequence)localObject;
    }
    localObject = ((l)localObject).Gx.getTitle();
    GMTrace.o(2100104790016L, 15647);
    return (CharSequence)localObject;
  }
  
  public final void bPM()
  {
    boolean bool = true;
    GMTrace.i(2100239007744L, 15648);
    l locall = this.uRf;
    if (locall.Gx != null) {}
    for (;;)
    {
      v.v("MicroMsg.MMActivityController", "showTitleView hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
      if (locall.Gx != null) {
        locall.Gx.show();
      }
      GMTrace.o(2100239007744L, 15648);
      return;
      bool = false;
    }
  }
  
  public final boolean bPN()
  {
    boolean bool = true;
    GMTrace.i(2100373225472L, 15649);
    l locall = this.uRf;
    if (locall.Gx != null) {}
    for (;;)
    {
      v.v("MicroMsg.MMActivityController", "isTitleShowing hasTitle:%b", new Object[] { Boolean.valueOf(bool) });
      if (locall.Gx != null) {
        break;
      }
      GMTrace.o(2100373225472L, 15649);
      return false;
      bool = false;
    }
    bool = locall.Gx.isShowing();
    GMTrace.o(2100373225472L, 15649);
    return bool;
  }
  
  public final void bPO()
  {
    GMTrace.i(2101849620480L, 15660);
    l locall = this.uRf;
    locall.uRJ.setVisibility(0);
    locall.uRI.setVisibility(8);
    locall.uRH.setVisibility(8);
    GMTrace.o(2101849620480L, 15660);
  }
  
  public final void bPP()
  {
    GMTrace.i(2101983838208L, 15661);
    l locall = this.uRf;
    if (locall.mContext != null) {
      locall.Z(locall.uRz);
    }
    GMTrace.o(2101983838208L, 15661);
  }
  
  public void bil()
  {
    GMTrace.i(2092588597248L, 15591);
    GMTrace.o(2092588597248L, 15591);
  }
  
  public boolean byb()
  {
    GMTrace.i(2093259685888L, 15596);
    GMTrace.o(2093259685888L, 15596);
    return false;
  }
  
  public boolean byc()
  {
    GMTrace.i(2094064992256L, 15602);
    GMTrace.o(2094064992256L, 15602);
    return true;
  }
  
  public final void cT(boolean paramBoolean)
  {
    GMTrace.i(2092857032704L, 15593);
    this.uRf.cT(paramBoolean);
    GMTrace.o(2092857032704L, 15593);
  }
  
  public final void cW(View paramView)
  {
    GMTrace.i(2100775878656L, 15652);
    this.uRf.cV(paramView);
    GMTrace.o(2100775878656L, 15652);
  }
  
  public final void d(boolean paramBoolean, long paramLong)
  {
    GMTrace.i(16765136404480L, 124910);
    this.uRf.d(paramBoolean, paramLong);
    GMTrace.o(16765136404480L, 124910);
  }
  
  public void finish()
  {
    GMTrace.i(2101178531840L, 15655);
    super.finish();
    int i = r.a(getIntent(), "MMActivity.OverrideEnterAnimation", -1);
    int j = r.a(getIntent(), "MMActivity.OverrideExitAnimation", -1);
    if (i != -1) {
      super.overridePendingTransition(i, j);
    }
    GMTrace.o(2101178531840L, 15655);
  }
  
  public abstract int getLayoutId();
  
  public final void km(boolean paramBoolean)
  {
    GMTrace.i(2095675604992L, 15614);
    this.uRf.km(paramBoolean);
    GMTrace.o(2095675604992L, 15614);
  }
  
  public final void kn(boolean paramBoolean)
  {
    GMTrace.i(2097420435456L, 15627);
    this.uRf.kn(paramBoolean);
    GMTrace.o(2097420435456L, 15627);
  }
  
  public final void ko(boolean paramBoolean)
  {
    GMTrace.i(2097554653184L, 15628);
    this.uRf.a(true, -1, paramBoolean);
    GMTrace.o(2097554653184L, 15628);
  }
  
  public final void kp(boolean paramBoolean)
  {
    GMTrace.i(2097823088640L, 15630);
    this.uRf.b(true, -1, paramBoolean);
    GMTrace.o(2097823088640L, 15630);
  }
  
  public final void kq(boolean paramBoolean)
  {
    GMTrace.i(2099836354560L, 15645);
    l locall = this.uRf;
    if (locall.uRI != null)
    {
      if (paramBoolean)
      {
        locall.uRI.setVisibility(0);
        GMTrace.o(2099836354560L, 15645);
        return;
      }
      locall.uRI.setVisibility(8);
    }
    GMTrace.o(2099836354560L, 15645);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    GMTrace.i(2101715402752L, 15659);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.uRg != null) {
      this.uRg.a(paramInt1, paramInt2, paramIntent);
    }
    this.uRg = null;
    GMTrace.o(2101715402752L, 15659);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool1 = true;
    GMTrace.i(2092051726336L, 15587);
    super.onCreate(paramBundle);
    if (!bDR()) {
      for (;;)
      {
        try
        {
          boolean bool2 = b.foreground;
          if (paramBundle == null) {
            continue;
          }
          v.e("MicroMsg.MMActivity", "summerasyncinit not init activity foreground[%b] savedInstanceState[%b], activity[%s, %d]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), getClass().getSimpleName(), Integer.valueOf(hashCode()) });
          finish();
        }
        catch (Throwable paramBundle)
        {
          v.printErrStackTrace("MicroMsg.MMActivity", paramBundle, "summerasyncinit finish:", new Object[0]);
          continue;
        }
        System.exit(0);
        GMTrace.o(2092051726336L, 15587);
        return;
        bool1 = false;
      }
    }
    this.uRf.a(getBaseContext(), this);
    v.i("MicroMsg.MMActivity", "checktask onCreate:%s#0x%x, taskid:%d, task:%s", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bf.eq(this) });
    bQd();
    GMTrace.o(2092051726336L, 15587);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    GMTrace.i(2095004516352L, 15609);
    if (this.uRf.onCreateOptionsMenu(paramMenu))
    {
      GMTrace.o(2095004516352L, 15609);
      return true;
    }
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    GMTrace.o(2095004516352L, 15609);
    return bool;
  }
  
  public void onDestroy()
  {
    GMTrace.i(2094601863168L, 15606);
    v.i("MicroMsg.MMActivity", "checktask onDestroy:%s#0x%x task:%s ", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), bf.eq(this) });
    super.onDestroy();
    com.tencent.mm.sdk.platformtools.a.cR(this.uRf.ipa);
    com.tencent.mm.sdk.platformtools.a.dU(this.uRf.uRz);
    this.uRf.onDestroy();
    this.uRh = true;
    GMTrace.o(2094601863168L, 15606);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2093930774528L, 15601);
    if (this.uRf.onKeyDown(paramInt, paramKeyEvent))
    {
      GMTrace.o(2093930774528L, 15601);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2093930774528L, 15601);
    return bool;
  }
  
  @TargetApi(17)
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2093796556800L, 15600);
    if (this.uRf.onKeyUp(paramInt, paramKeyEvent))
    {
      GMTrace.o(2093796556800L, 15600);
      return true;
    }
    try
    {
      boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
      GMTrace.o(2093796556800L, 15600);
      return bool;
    }
    catch (Exception paramKeyEvent)
    {
      v.printErrStackTrace("MicroMsg.MMActivity", paramKeyEvent, "java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState", new Object[0]);
      GMTrace.o(2093796556800L, 15600);
    }
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    GMTrace.i(2095272951808L, 15611);
    boolean bool = this.uRf.onOptionsItemSelected(paramMenuItem);
    GMTrace.o(2095272951808L, 15611);
    return bool;
  }
  
  public void onPause()
  {
    GMTrace.i(2094870298624L, 15608);
    long l = System.currentTimeMillis();
    w.aB(2, this.className);
    super.onPause();
    this.uRf.onPause();
    boolean bool = isFinishing();
    v.v("MicroMsg.INIT", "KEVIN MMActivity onPause: %d ms, isFinishing %B, hash:#0x%x", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool), Integer.valueOf(hashCode()) });
    GMTrace.o(2094870298624L, 15608);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    GMTrace.i(2095138734080L, 15610);
    this.uRf.onPrepareOptionsMenu(paramMenu);
    boolean bool = super.onPrepareOptionsMenu(paramMenu);
    GMTrace.o(2095138734080L, 15610);
    return bool;
  }
  
  public void onResume()
  {
    GMTrace.i(2094199209984L, 15603);
    long l = System.currentTimeMillis();
    w.aB(1, this.className);
    super.onResume();
    v.v("MicroMsg.INIT", "KEVIN MMActivity super.onResume " + (System.currentTimeMillis() - l));
    this.uRf.onResume();
    v.v("MicroMsg.INIT", "KEVIN MMActivity onResume :%dms, hash:#0x%x", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(hashCode()) });
    GMTrace.o(2094199209984L, 15603);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    GMTrace.i(2092722814976L, 15592);
    if (Build.VERSION.SDK_INT < 11) {
      super.onSaveInstanceState(paramBundle);
    }
    GMTrace.o(2092722814976L, 15592);
  }
  
  public void onStart()
  {
    GMTrace.i(2093662339072L, 15599);
    azo();
    super.onStart();
    GMTrace.o(2093662339072L, 15599);
  }
  
  public void qL(String paramString)
  {
    GMTrace.i(2096212475904L, 15618);
    this.uRf.qL(paramString);
    GMTrace.o(2096212475904L, 15618);
  }
  
  public void ra(int paramInt)
  {
    GMTrace.i(2092991250432L, 15594);
    this.uRf.ipa.setVisibility(paramInt);
    if (paramInt == 0)
    {
      bPM();
      GMTrace.o(2092991250432L, 15594);
      return;
    }
    this.uRf.bPW();
    GMTrace.o(2092991250432L, 15594);
  }
  
  public final void v(Class<?> paramClass)
  {
    GMTrace.i(2101312749568L, 15656);
    Intent localIntent = new Intent();
    localIntent.setClass(this, paramClass);
    startActivity(localIntent);
    GMTrace.o(2101312749568L, 15656);
  }
  
  public final void za(int paramInt)
  {
    GMTrace.i(2091514855424L, 15583);
    l locall = this.uRf;
    if (locall.ipa != null)
    {
      if (locall.uRo == null) {
        locall.uRo = ((FrameLayout)locall.ipa.findViewById(a.g.cka));
      }
      locall.uRo.setBackgroundResource(paramInt);
      locall.uRl.setBackgroundResource(paramInt);
    }
    GMTrace.o(2091514855424L, 15583);
  }
  
  public final void zb(int paramInt)
  {
    GMTrace.i(2095944040448L, 15616);
    l locall = this.uRf;
    if (locall.Gx != null) {
      if (paramInt == 0)
      {
        locall.Gx.show();
        if (Build.VERSION.SDK_INT >= 21)
        {
          locall.uRz.getWindow().setStatusBarColor(locall.uRz.getResources().getColor(a.d.aVV));
          GMTrace.o(2095944040448L, 15616);
        }
      }
      else
      {
        locall.Gx.hide();
        if (Build.VERSION.SDK_INT >= 21) {
          locall.uRz.getWindow().setStatusBarColor(locall.uRz.getResources().getColor(a.d.black));
        }
      }
    }
    GMTrace.o(2095944040448L, 15616);
  }
  
  public final void zc(int paramInt)
  {
    GMTrace.i(2096078258176L, 15617);
    l locall = this.uRf;
    if (locall.Gx != null) {
      locall.uRG.setTextColor(paramInt);
    }
    GMTrace.o(2096078258176L, 15617);
  }
  
  public final void zd(int paramInt)
  {
    GMTrace.i(2096480911360L, 15620);
    this.uRf.zd(paramInt);
    GMTrace.o(2096480911360L, 15620);
  }
  
  public final void ze(int paramInt)
  {
    GMTrace.i(2096749346816L, 15622);
    this.uRf.ze(paramInt);
    GMTrace.o(2096749346816L, 15622);
  }
  
  public final void zf(int paramInt)
  {
    GMTrace.i(2096883564544L, 15623);
    this.uRf.uRG.setVisibility(paramInt);
    GMTrace.o(2096883564544L, 15623);
  }
  
  public final void zg(int paramInt)
  {
    GMTrace.i(2097017782272L, 15624);
    l locall = this.uRf;
    if (locall.Gx == null)
    {
      GMTrace.o(2097017782272L, 15624);
      return;
    }
    locall.uRr = 0;
    locall.uRt = null;
    if (paramInt == 0)
    {
      locall.uRs = 0;
      locall.uRu = null;
    }
    for (;;)
    {
      locall.bPT();
      GMTrace.o(2097017782272L, 15624);
      return;
      if (locall.uRs != paramInt)
      {
        locall.uRs = paramInt;
        locall.uRu = locall.dT(locall.mContext.getResources().getDimensionPixelSize(a.e.aWD), locall.uRs);
      }
    }
  }
  
  public final void zh(int paramInt)
  {
    GMTrace.i(17512729149440L, 130480);
    l locall = this.uRf;
    if (locall.uRF == null)
    {
      GMTrace.o(17512729149440L, 130480);
      return;
    }
    locall.uRF.setBackgroundColor(paramInt);
    GMTrace.o(17512729149440L, 130480);
  }
  
  public final boolean zi(int paramInt)
  {
    GMTrace.i(2099970572288L, 15646);
    boolean bool = this.uRf.zi(paramInt);
    GMTrace.o(2099970572288L, 15646);
    return bool;
  }
  
  public final void zj(int paramInt)
  {
    GMTrace.i(2100507443200L, 15650);
    this.uRf.zj(paramInt);
    GMTrace.o(2100507443200L, 15650);
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/MMActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */