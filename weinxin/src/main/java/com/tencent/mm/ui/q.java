package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.e.a.jt;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;

public abstract class q
  extends h
  implements View.OnAttachStateChangeListener, com.tencent.mm.ui.i.a
{
  String className;
  public l uRf;
  protected ActionBarActivity uSM;
  public boolean uSN;
  public SwipeBackLayout uSO;
  private q uSP;
  private boolean uSQ;
  private com.tencent.mm.ui.i.a uSR;
  private boolean uSS;
  
  public q()
  {
    GMTrace.i(2850516107264L, 21238);
    this.uSN = false;
    this.uRf = new l()
    {
      protected final void Sz()
      {
        GMTrace.i(1873679482880L, 13960);
        q.Sz();
        GMTrace.o(1873679482880L, 13960);
      }
      
      public final boolean WV()
      {
        GMTrace.i(1874082136064L, 13963);
        boolean bool = q.this.WV();
        GMTrace.o(1874082136064L, 13963);
        return bool;
      }
      
      protected final String aFH()
      {
        GMTrace.i(1873276829696L, 13957);
        String str = q.this.aFH();
        GMTrace.o(1873276829696L, 13957);
        return str;
      }
      
      protected final void bF(View paramAnonymousView)
      {
        GMTrace.i(1873142611968L, 13956);
        q.this.bF(paramAnonymousView);
        GMTrace.o(1873142611968L, 13956);
      }
      
      protected final boolean bPE()
      {
        GMTrace.i(1873947918336L, 13962);
        GMTrace.o(1873947918336L, 13962);
        return false;
      }
      
      protected final View bPQ()
      {
        GMTrace.i(1873411047424L, 13958);
        View localView = q.this.bPQ();
        GMTrace.o(1873411047424L, 13958);
        return localView;
      }
      
      public final void bil()
      {
        GMTrace.i(1873545265152L, 13959);
        q.this.bil();
        GMTrace.o(1873545265152L, 13959);
      }
      
      protected final String getClassName()
      {
        GMTrace.i(1873813700608L, 13961);
        String str = q.this.getClass().getName();
        GMTrace.o(1873813700608L, 13961);
        return str;
      }
      
      protected final int getLayoutId()
      {
        GMTrace.i(1873008394240L, 13955);
        int i = q.this.getLayoutId();
        GMTrace.o(1873008394240L, 13955);
        return i;
      }
    };
    this.uSQ = false;
    this.uSS = false;
    GMTrace.o(2850516107264L, 21238);
  }
  
  public q(boolean paramBoolean)
  {
    super(paramBoolean);
    GMTrace.i(2850650324992L, 21239);
    this.uSN = false;
    this.uRf = new l()
    {
      protected final void Sz()
      {
        GMTrace.i(1873679482880L, 13960);
        q.Sz();
        GMTrace.o(1873679482880L, 13960);
      }
      
      public final boolean WV()
      {
        GMTrace.i(1874082136064L, 13963);
        boolean bool = q.this.WV();
        GMTrace.o(1874082136064L, 13963);
        return bool;
      }
      
      protected final String aFH()
      {
        GMTrace.i(1873276829696L, 13957);
        String str = q.this.aFH();
        GMTrace.o(1873276829696L, 13957);
        return str;
      }
      
      protected final void bF(View paramAnonymousView)
      {
        GMTrace.i(1873142611968L, 13956);
        q.this.bF(paramAnonymousView);
        GMTrace.o(1873142611968L, 13956);
      }
      
      protected final boolean bPE()
      {
        GMTrace.i(1873947918336L, 13962);
        GMTrace.o(1873947918336L, 13962);
        return false;
      }
      
      protected final View bPQ()
      {
        GMTrace.i(1873411047424L, 13958);
        View localView = q.this.bPQ();
        GMTrace.o(1873411047424L, 13958);
        return localView;
      }
      
      public final void bil()
      {
        GMTrace.i(1873545265152L, 13959);
        q.this.bil();
        GMTrace.o(1873545265152L, 13959);
      }
      
      protected final String getClassName()
      {
        GMTrace.i(1873813700608L, 13961);
        String str = q.this.getClass().getName();
        GMTrace.o(1873813700608L, 13961);
        return str;
      }
      
      protected final int getLayoutId()
      {
        GMTrace.i(1873008394240L, 13955);
        int i = q.this.getLayoutId();
        GMTrace.o(1873008394240L, 13955);
        return i;
      }
    };
    this.uSQ = false;
    this.uSS = false;
    GMTrace.o(2850650324992L, 21239);
  }
  
  private void H(boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(2858971824128L, 21301);
    if (paramBoolean1 == this.uSS)
    {
      GMTrace.o(2858971824128L, 21301);
      return;
    }
    boolean bool1;
    label83:
    boolean bool2;
    if (this.uSP == null)
    {
      paramBoolean1 = this.uSQ;
      if ((!isAdded()) || (this.pm) || (this.mView == null) || (this.mView.getWindowToken() == null) || (this.mView.getVisibility() != 0)) {
        break label350;
      }
      bool1 = true;
      bool2 = getUserVisibleHint();
      if ((!paramBoolean1) || (!bool1) || (!bool2) || (paramBoolean2)) {
        break label356;
      }
    }
    label350:
    label356:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      v.i("MicroMsg.MMFragment", "[filterAndNotifyVisibility] visible = %s parent = %s, super = %s, hint = %s name:%s", new Object[] { Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool1), Boolean.valueOf(bool2), getClass().getName() });
      if (paramBoolean2 != this.uSS)
      {
        this.uSS = paramBoolean2;
        paramBoolean1 = this.uSS;
        if (this.uSR != null) {
          this.uSR.ku(paramBoolean1);
        }
        int j = -1;
        Object localObject = this.oW;
        int i = j;
        if (localObject != null)
        {
          i = j;
          if (((Bundle)localObject).containsKey(getClass().getName())) {
            i = ((Bundle)localObject).getInt(getClass().getName());
          }
        }
        v.i("MicroMsg.MMFragment", "[onVisibilityChanged] visible:%s name:%s id:%s", new Object[] { Boolean.valueOf(paramBoolean1), getClass().getName(), Integer.valueOf(i) });
        localObject = new jt();
        ((jt)localObject).fPY.name = getClass().getName();
        ((jt)localObject).fPY.id = i;
        ((jt)localObject).fPY.visible = paramBoolean1;
        com.tencent.mm.sdk.b.a.uql.m((b)localObject);
      }
      GMTrace.o(2858971824128L, 21301);
      return;
      paramBoolean1 = this.uSP.uSS;
      break;
      bool1 = false;
      break label83;
    }
  }
  
  protected static void Sz()
  {
    GMTrace.i(2850784542720L, 21240);
    GMTrace.o(2850784542720L, 21240);
  }
  
  private void kv(boolean paramBoolean)
  {
    GMTrace.i(2858837606400L, 21300);
    this.uSQ = paramBoolean;
    H(paramBoolean, false);
    GMTrace.o(2858837606400L, 21300);
  }
  
  public void SD(String paramString)
  {
    GMTrace.i(2854676856832L, 21269);
    this.uRf.SD(paramString);
    GMTrace.o(2854676856832L, 21269);
  }
  
  public final void SE(String paramString)
  {
    GMTrace.i(2854408421376L, 21267);
    this.uRf.SE(paramString);
    GMTrace.o(2854408421376L, 21267);
  }
  
  public void VD()
  {
    GMTrace.i(2851589849088L, 21246);
    GMTrace.o(2851589849088L, 21246);
  }
  
  public boolean WV()
  {
    GMTrace.i(2851455631360L, 21245);
    GMTrace.o(2851455631360L, 21245);
    return false;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    GMTrace.i(2855750598656L, 21277);
    this.uRf.a(paramInt1, paramInt2, paramInt3, paramOnMenuItemClickListener);
    GMTrace.o(2855750598656L, 21277);
  }
  
  public final void a(int paramInt1, int paramInt2, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    GMTrace.i(2855616380928L, 21276);
    this.uRf.a(paramInt1, paramInt2, paramOnMenuItemClickListener);
    GMTrace.o(2855616380928L, 21276);
  }
  
  public final void a(ActionBarActivity paramActionBarActivity)
  {
    GMTrace.i(2852395155456L, 21252);
    this.uSM = paramActionBarActivity;
    GMTrace.o(2852395155456L, 21252);
  }
  
  public final void a(boolean paramBoolean, p paramp)
  {
    GMTrace.i(2855482163200L, 21275);
    this.uRf.a(paramBoolean, paramp);
    GMTrace.o(2855482163200L, 21275);
  }
  
  public String aFH()
  {
    GMTrace.i(2853871550464L, 21263);
    GMTrace.o(2853871550464L, 21263);
    return "";
  }
  
  public final void aM()
  {
    GMTrace.i(2851052978176L, 21242);
    View localView;
    if (bPY())
    {
      localView = this.uRf.ipa;
      ViewGroup localViewGroup = (ViewGroup)localView.getParent();
      if (localViewGroup == null) {
        break label128;
      }
      this.uSO = ((SwipeBackLayout)LayoutInflater.from(bOZ()).inflate(a.h.heD, localViewGroup, false));
      localViewGroup.removeView(localView);
      localViewGroup.addView(this.uSO);
    }
    for (;;)
    {
      this.uSO.addView(localView);
      this.uSO.Ih = localView;
      this.uSO.lR(true);
      this.uSO.wvH = new SwipeBackLayout.a()
      {
        public final void VD()
        {
          GMTrace.i(3063788077056L, 22827);
          q.this.VD();
          GMTrace.o(3063788077056L, 22827);
        }
        
        public final void VE()
        {
          GMTrace.i(3064056512512L, 22829);
          q.this.bPZ();
          GMTrace.o(3064056512512L, 22829);
        }
        
        public final void onCancel()
        {
          GMTrace.i(3063922294784L, 22828);
          q.this.bQa();
          GMTrace.o(3063922294784L, 22828);
        }
      };
      this.mView.addOnAttachStateChangeListener(this);
      GMTrace.o(2851052978176L, 21242);
      return;
      label128:
      this.uSO = ((SwipeBackLayout)LayoutInflater.from(bOZ()).inflate(a.h.heD, null));
    }
  }
  
  public final Activity aYw()
  {
    GMTrace.i(2852529373184L, 21253);
    ActionBarActivity localActionBarActivity = this.uRf.uRz;
    GMTrace.o(2852529373184L, 21253);
    return localActionBarActivity;
  }
  
  public boolean aqY()
  {
    GMTrace.i(2856421687296L, 21282);
    boolean bool = this.uRf.aqY();
    GMTrace.o(2856421687296L, 21282);
    return bool;
  }
  
  public void b(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    GMTrace.i(2856019034112L, 21279);
    this.uRf.a(paramOnMenuItemClickListener, 0);
    GMTrace.o(2856019034112L, 21279);
  }
  
  public void bF(View paramView)
  {
    GMTrace.i(2852126720000L, 21250);
    GMTrace.o(2852126720000L, 21250);
  }
  
  public final FragmentActivity bOZ()
  {
    GMTrace.i(2856958558208L, 21286);
    if (this.uRf.uRz != null)
    {
      localObject = this.uRf.uRz;
      GMTrace.o(2856958558208L, 21286);
      return (FragmentActivity)localObject;
    }
    Object localObject = super.aG();
    GMTrace.o(2856958558208L, 21286);
    return (FragmentActivity)localObject;
  }
  
  public View bPQ()
  {
    GMTrace.i(2854139985920L, 21265);
    GMTrace.o(2854139985920L, 21265);
    return null;
  }
  
  public final boolean bPY()
  {
    GMTrace.i(2851187195904L, 21243);
    if ((d.eo(19)) && (com.tencent.mm.compatible.h.a.rX()))
    {
      boolean bool = bin();
      GMTrace.o(2851187195904L, 21243);
      return bool;
    }
    GMTrace.o(2851187195904L, 21243);
    return false;
  }
  
  public void bPZ()
  {
    GMTrace.i(2851724066816L, 21247);
    GMTrace.o(2851724066816L, 21247);
  }
  
  public void bQa()
  {
    GMTrace.i(2851858284544L, 21248);
    GMTrace.o(2851858284544L, 21248);
  }
  
  public final Resources bQb()
  {
    GMTrace.i(2856824340480L, 21285);
    Object localObject = super.aG();
    if (localObject == null)
    {
      localObject = aa.getContext().getResources();
      GMTrace.o(2856824340480L, 21285);
      return (Resources)localObject;
    }
    localObject = ((FragmentActivity)localObject).getResources();
    GMTrace.o(2856824340480L, 21285);
    return (Resources)localObject;
  }
  
  public final Resources bQc()
  {
    GMTrace.i(2857092775936L, 21287);
    Resources localResources = bOZ().getResources();
    GMTrace.o(2857092775936L, 21287);
    return localResources;
  }
  
  public void bil()
  {
    GMTrace.i(2852260937728L, 21251);
    GMTrace.o(2852260937728L, 21251);
  }
  
  public boolean bin()
  {
    GMTrace.i(2851321413632L, 21244);
    GMTrace.o(2851321413632L, 21244);
    return true;
  }
  
  public final void cT(boolean paramBoolean)
  {
    GMTrace.i(2852663590912L, 21254);
    this.uRf.cT(paramBoolean);
    GMTrace.o(2852663590912L, 21254);
  }
  
  public final String e(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(2857361211392L, 21289);
    paramVarArgs = bOZ().getString(paramInt, paramVarArgs);
    GMTrace.o(2857361211392L, 21289);
    return paramVarArgs;
  }
  
  public void finish()
  {
    GMTrace.i(2856555905024L, 21283);
    super.finish();
    int i = bOZ().getIntent().getIntExtra("MMActivity.OverrideEnterAnimation", -1);
    int j = bOZ().getIntent().getIntExtra("MMActivity.OverrideExitAnimation", -1);
    if (i != -1) {
      this.uRf.uRz.overridePendingTransition(i, j);
    }
    GMTrace.o(2856555905024L, 21283);
  }
  
  public abstract int getLayoutId();
  
  public final void kn(boolean paramBoolean)
  {
    GMTrace.i(2854945292288L, 21271);
    this.uRf.kn(paramBoolean);
    GMTrace.o(2854945292288L, 21271);
  }
  
  public final void ko(boolean paramBoolean)
  {
    GMTrace.i(2855079510016L, 21272);
    this.uRf.a(true, -1, paramBoolean);
    GMTrace.o(2855079510016L, 21272);
  }
  
  public final void kp(boolean paramBoolean)
  {
    GMTrace.i(2855213727744L, 21273);
    this.uRf.b(true, -1, paramBoolean);
    GMTrace.o(2855213727744L, 21273);
  }
  
  public final void kt(boolean paramBoolean)
  {
    GMTrace.i(2855347945472L, 21274);
    this.uRf.b(false, 2, paramBoolean);
    GMTrace.o(2855347945472L, 21274);
  }
  
  public final void ku(boolean paramBoolean)
  {
    GMTrace.i(2858703388672L, 21299);
    H(paramBoolean, false);
    GMTrace.o(2858703388672L, 21299);
  }
  
  public final void onAttach(Context paramContext)
  {
    GMTrace.i(2858032300032L, 21294);
    super.onAttach(paramContext);
    paramContext = this.pj;
    if ((paramContext != null) && ((paramContext instanceof q)))
    {
      this.uSP = ((q)paramContext);
      this.uSP.uSR = this;
    }
    H(true, false);
    GMTrace.o(2858032300032L, 21294);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2850918760448L, 21241);
    super.onCreate(paramBundle);
    this.uRf.a(bOZ().getBaseContext(), (ActionBarActivity)bOZ());
    GMTrace.o(2850918760448L, 21241);
  }
  
  public void onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    GMTrace.i(2853468897280L, 21260);
    if (!this.uRf.onCreateOptionsMenu(paramMenu)) {
      super.onCreateOptionsMenu(paramMenu, paramMenuInflater);
    }
    GMTrace.o(2853468897280L, 21260);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    GMTrace.i(2851992502272L, 21249);
    aH();
    paramLayoutInflater = this.uRf.ipa;
    GMTrace.o(2851992502272L, 21249);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    GMTrace.i(2853200461824L, 21258);
    super.onDestroy();
    this.uRf.onDestroy();
    GMTrace.o(2853200461824L, 21258);
  }
  
  public void onDestroyView()
  {
    GMTrace.i(2858300735488L, 21296);
    super.onDestroyView();
    this.mView.removeOnAttachStateChangeListener(this);
    GMTrace.o(2858300735488L, 21296);
  }
  
  public void onDetach()
  {
    GMTrace.i(2858166517760L, 21295);
    if (this.uSP != null) {
      this.uSP.uSR = null;
    }
    super.onDetach();
    H(false, false);
    this.uSP = null;
    GMTrace.o(2858166517760L, 21295);
  }
  
  public final void onHiddenChanged(boolean paramBoolean)
  {
    GMTrace.i(2857763864576L, 21292);
    super.onHiddenChanged(paramBoolean);
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      H(bool, paramBoolean);
      GMTrace.o(2857763864576L, 21292);
      return;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2852932026368L, 21256);
    if (this.uRf.onKeyDown(paramInt, paramKeyEvent))
    {
      GMTrace.o(2852932026368L, 21256);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(2852932026368L, 21256);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2852797808640L, 21255);
    if (this.uRf.onKeyUp(paramInt, paramKeyEvent))
    {
      GMTrace.o(2852797808640L, 21255);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    GMTrace.o(2852797808640L, 21255);
    return bool;
  }
  
  public final boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    GMTrace.i(2853737332736L, 21262);
    boolean bool = this.uRf.onOptionsItemSelected(paramMenuItem);
    GMTrace.o(2853737332736L, 21262);
    return bool;
  }
  
  public void onPause()
  {
    GMTrace.i(2853334679552L, 21259);
    long l = System.currentTimeMillis();
    w.aB(2, this.className);
    super.onPause();
    if (this.uSN) {
      this.uSN = false;
    }
    for (;;)
    {
      v.v("MicroMsg.INIT", "KEVIN MMActivity onPause:" + (System.currentTimeMillis() - l));
      kv(false);
      GMTrace.o(2853334679552L, 21259);
      return;
      this.uRf.onPause();
    }
  }
  
  public final void onPrepareOptionsMenu(Menu paramMenu)
  {
    GMTrace.i(2853603115008L, 21261);
    this.uRf.onPrepareOptionsMenu(paramMenu);
    super.onPrepareOptionsMenu(paramMenu);
    GMTrace.o(2853603115008L, 21261);
  }
  
  public void onResume()
  {
    GMTrace.i(2853066244096L, 21257);
    long l = System.currentTimeMillis();
    w.aB(1, this.className);
    super.onResume();
    v.v("MicroMsg.INIT", "KEVIN MMActivity super..onResume " + (System.currentTimeMillis() - l));
    this.uRf.onResume();
    v.v("MicroMsg.INIT", "KEVIN MMActivity onResume :" + (System.currentTimeMillis() - l));
    kv(true);
    GMTrace.o(2853066244096L, 21257);
  }
  
  public void onStart()
  {
    GMTrace.i(2857495429120L, 21290);
    this.uRf.onStart();
    super.onStart();
    kv(true);
    GMTrace.o(2857495429120L, 21290);
  }
  
  public void onStop()
  {
    GMTrace.i(2857629646848L, 21291);
    super.onStop();
    kv(false);
    GMTrace.o(2857629646848L, 21291);
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    GMTrace.i(2858434953216L, 21297);
    H(true, false);
    GMTrace.o(2858434953216L, 21297);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    GMTrace.i(2858569170944L, 21298);
    H(false, false);
    GMTrace.o(2858569170944L, 21298);
  }
  
  public void qL(String paramString)
  {
    GMTrace.i(2854274203648L, 21266);
    this.uRf.qL(paramString);
    GMTrace.o(2854274203648L, 21266);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    GMTrace.i(2857898082304L, 21293);
    v.i("MicroMsg.MMFragment", "[setUserVisibleHint] isVisibleToUser:%s name:%s", new Object[] { Boolean.valueOf(paramBoolean), getClass().getName() });
    super.setUserVisibleHint(paramBoolean);
    H(paramBoolean, false);
    GMTrace.o(2857898082304L, 21293);
  }
  
  public final void startActivity(Intent paramIntent)
  {
    GMTrace.i(2856690122752L, 21284);
    super.startActivity(paramIntent);
    GMTrace.o(2856690122752L, 21284);
  }
  
  public void zd(int paramInt)
  {
    GMTrace.i(2854542639104L, 21268);
    this.uRf.zd(paramInt);
    GMTrace.o(2854542639104L, 21268);
  }
  
  public void ze(int paramInt)
  {
    GMTrace.i(2854811074560L, 21270);
    this.uRf.ze(paramInt);
    GMTrace.o(2854811074560L, 21270);
  }
  
  public void zj(int paramInt)
  {
    GMTrace.i(2856287469568L, 21281);
    this.uRf.zj(paramInt);
    GMTrace.o(2856287469568L, 21281);
  }
  
  public final void zm(int paramInt)
  {
    GMTrace.i(2855884816384L, 21278);
    l locall = this.uRf;
    l.a locala = locall.zl(2);
    if ((locala != null) && (locala.uSd != paramInt))
    {
      locala.uSd = paramInt;
      locall.aQ();
    }
    GMTrace.o(2855884816384L, 21278);
  }
  
  public void zn(int paramInt)
  {
    GMTrace.i(2856153251840L, 21280);
    l locall = this.uRf;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      locall.uRy = bool;
      locall.bPT();
      GMTrace.o(2856153251840L, 21280);
      return;
    }
  }
  
  public final String zo(int paramInt)
  {
    GMTrace.i(2857226993664L, 21288);
    String str = bOZ().getString(paramInt);
    GMTrace.o(2857226993664L, 21288);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */