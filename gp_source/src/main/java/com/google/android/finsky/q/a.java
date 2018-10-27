package com.google.android.finsky.q;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.cq;
import android.support.v4.app.o;
import android.support.v7.app.x;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.android.volley.VolleyError;
import com.google.android.finsky.dfemodel.DfeToc;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.ag;
import com.google.android.finsky.e.z;
import com.google.android.finsky.installer.p;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.bl;
import java.util.Arrays;
import java.util.List;

public abstract class a
  extends x
  implements com.google.android.finsky.navigationmanager.b, com.google.android.finsky.navigationmanager.l, r, u
{
  private static boolean i = false;
  public b.a H;
  public b.a I;
  public b.a J;
  public b.a K;
  public b.a L;
  public b.a M;
  public boolean N = false;
  public boolean O = false;
  public b.a P;
  public b.a Q;
  public b.a R;
  public b.a S;
  public b.a T;
  public b.a U;
  public b.a V;
  public b.a W;
  public b.a X;
  public b.a Y;
  public b.a Z;
  public int aa;
  public b.a ab;
  public boolean ac = false;
  public boolean ad;
  public b.a ae;
  public b.a af;
  public af ag;
  public b.a ah;
  public Runnable ai;
  public b.a aj;
  public b.a ak;
  public b.a al;
  public b.a am;
  public boolean an;
  public b.a ao;
  public b.a ap;
  public b.a aq;
  public b.a ar;
  public b.a as;
  public b.a at;
  public b.a au;
  public b.a av;
  public b.a aw;
  public boolean ax;
  private final Handler e = new Handler(Looper.getMainLooper());
  private boolean f = false;
  private com.google.android.finsky.cy.e g;
  private boolean h;
  public b.a i_;
  
  private static Bundle a(Context paramContext)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("pendingIntent", PendingIntent.getBroadcast(paramContext, 0, new Intent(), 0));
    localBundle.putString("introMessage", paramContext.getString(2131951674));
    localBundle.putBoolean("allowSkip", false);
    return localBundle;
  }
  
  private final void m()
  {
    startActivityForResult(AccountManager.newChooseAccountIntent(((com.google.android.finsky.accounts.c)this.I.a()).cT(), null, ((com.google.android.finsky.accounts.a)this.H.a()).c(), true, null, "androidmarket", null, a(this)), 23);
    this.ag.a(new z().a(310));
  }
  
  public final void G()
  {
    finish();
  }
  
  public final boolean H()
  {
    return this.an;
  }
  
  final String I()
  {
    Object localObject = getIntent().getStringExtra("authAccount");
    if (localObject != null)
    {
      Account localAccount = ((com.google.android.finsky.accounts.a)this.H.a()).b((String)localObject);
      if (localAccount == null)
      {
        FinskyLog.e("This app was called with an intent that specified the account %s, which is not a valid account on this device", new Object[] { localObject });
        finish();
        return null;
      }
      return localAccount.name;
    }
    localObject = ((com.google.android.finsky.accounts.c)this.I.a()).cU();
    if (!((com.google.android.finsky.accounts.a)this.H.a()).c((String)localObject))
    {
      localObject = ((com.google.android.finsky.accounts.a)this.H.a()).b();
      if (localObject != null) {
        return ((Account)localObject).name;
      }
      return null;
    }
    return (String)localObject;
  }
  
  public void I_()
  {
    super.I_();
    b(false);
    Object localObject = (s)this.M.a();
    if (!android.support.v4.os.a.a())
    {
      NetworkInfo[] arrayOfNetworkInfo = ((ConnectivityManager)((s)localObject).a.getSystemService("connectivity")).getAllNetworkInfo();
      int k = arrayOfNetworkInfo.length;
      int j = 0;
      if (j < k)
      {
        NetworkInfo localNetworkInfo = arrayOfNetworkInfo[j];
        if (localNetworkInfo == null) {}
        while (localNetworkInfo.getDetailedState() != DetailedState.BLOCKED)
        {
          j += 1;
          break;
        }
        if (((s)localObject).b.i()) {
          q.a(O_(), this, this.ag);
        }
      }
    }
    for (;;)
    {
      localObject = this.ai;
      if (localObject != null) {
        ((Runnable)localObject).run();
      }
      while (!this.f) {
        return;
      }
      this.f = false;
      e(true);
      return;
      q.a(O_());
    }
  }
  
  public void J()
  {
    this.ax = true;
    Intent localIntent = ((com.google.android.finsky.cl.b)this.i_.a()).a(this, I(), ((com.google.android.finsky.ev.a)this.ar.a()).a);
    localIntent.setFlags(67108864);
    startActivityForResult(localIntent, 20);
  }
  
  public final af J_()
  {
    return this.ag;
  }
  
  public void K()
  {
    Object localObject = ((com.google.android.finsky.bo.c)this.W.a()).cY();
    if (((!((com.google.android.finsky.bo.f)localObject).a(12639710L)) && (!((com.google.android.finsky.bo.f)localObject).a(12639720L))) || (getWindow().peekDecorView() != null))
    {
      localObject = (ViewGroup)getWindow().findViewById(2131427761);
      if (localObject != null) {
        ((ViewGroup)localObject).findViewById(2131428825).setVisibility(0);
      }
    }
  }
  
  public void L()
  {
    ViewGroup localViewGroup = (ViewGroup)getWindow().findViewById(2131427761);
    if (localViewGroup != null) {
      localViewGroup.findViewById(2131428825).setVisibility(8);
    }
  }
  
  final void M()
  {
    ((com.google.android.finsky.bo.a)this.V.a()).b();
    ((com.google.android.finsky.dn.e)this.U.a()).e();
  }
  
  public final void N()
  {
    a(new n(this));
  }
  
  public final void O()
  {
    this.ai = null;
    recreate();
  }
  
  public af P()
  {
    return ((ag)this.ah.a()).cW();
  }
  
  public final void Q()
  {
    a(new e(this));
  }
  
  public final void a(Account paramAccount, Intent paramIntent)
  {
    a(paramAccount, paramIntent, false, 0);
  }
  
  public final void a(Account paramAccount, Intent paramIntent, boolean paramBoolean, int paramInt)
  {
    this.ai = null;
    Account localAccount = paramAccount;
    if (paramAccount == null) {
      if (!((com.google.android.finsky.accounts.a)this.H.a()).a(((com.google.android.finsky.accounts.c)this.I.a()).cU())) {
        break label194;
      }
    }
    label194:
    for (localAccount = ((com.google.android.finsky.accounts.c)this.I.a()).cT();; localAccount = ((com.google.android.finsky.accounts.a)this.H.a()).b())
    {
      y();
      if (paramIntent != null) {
        setIntent(paramIntent);
      }
      for (;;)
      {
        if (!paramBoolean) {}
        for (;;)
        {
          ((com.google.android.finsky.ev.a)this.ar.a()).a(null);
          ((com.google.android.finsky.accounts.a)this.H.a()).c(localAccount);
          if (localAccount == null)
          {
            O();
            return;
          }
          e(true);
          return;
          ((com.google.android.finsky.volley.h)this.av.a()).a(null, paramInt);
        }
        paramAccount = ((com.google.android.finsky.cl.b)this.i_.a()).h(this);
        paramAccount.setAction("android.intent.action.MAIN");
        setIntent(paramAccount);
      }
    }
  }
  
  public final void a(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
  }
  
  public void a(VolleyError paramVolleyError) {}
  
  public final void a(Runnable paramRunnable)
  {
    if (!this.an)
    {
      paramRunnable.run();
      return;
    }
    this.ai = paramRunnable;
  }
  
  public void a(String paramString, Intent paramIntent)
  {
    Object localObject = ((com.google.android.finsky.e.i)this.T.a()).cV();
    Integer localInteger = Integer.valueOf(0);
    ((com.google.android.finsky.e.u)localObject).a(new com.google.android.finsky.e.d(406).b(localInteger).a(localInteger).b(null).a, null, -1L);
    localObject = ((com.google.android.finsky.accounts.a)this.H.a()).b(paramString);
    if (localObject == null) {
      throw new IllegalArgumentException(String.format("Error, could not switch to %s because the account could not be found on the device", new Object[] { FinskyLog.a(paramString) }));
    }
    a((Account)localObject, paramIntent);
  }
  
  public void a(boolean paramBoolean)
  {
    d("onReady");
    this.ac = false;
    this.ad = true;
  }
  
  public final void b(boolean paramBoolean)
  {
    if (this.an != paramBoolean)
    {
      this.an = paramBoolean;
      c(paramBoolean);
    }
  }
  
  public final void c(String paramString)
  {
    a(new d(this, paramString));
  }
  
  public void c(boolean paramBoolean) {}
  
  final void d(String paramString)
  {
    if (((com.google.android.finsky.bo.c)this.W.a()).cY().a(12660263L)) {
      FinskyLog.a(paramString, new Object[0]);
    }
  }
  
  final void d(boolean paramBoolean)
  {
    d("Fire OnReady runnable");
    ((p)this.ab.a()).b();
    ((com.google.android.finsky.dt.a)this.Z.a()).dg();
    L();
    f localf = new f(this, paramBoolean);
    this.e.post(localf);
  }
  
  protected final void e(boolean paramBoolean)
  {
    Object localObject1 = null;
    d("Start initializing");
    K();
    this.ac = true;
    this.ad = false;
    d("Setup account");
    Object localObject2 = I();
    if (localObject2 == null)
    {
      if ((((com.google.android.finsky.accounts.c)this.I.a()).cQ().isEmpty()) && (com.google.android.finsky.ey.a.a((com.google.android.finsky.ba.g)this.ao.a(), (com.google.android.finsky.bo.c)this.W.a())))
      {
        localObject1 = ((com.google.android.finsky.cl.b)this.i_.a()).i(this);
        this.ag.a(null).a((Intent)localObject1);
        startActivity((Intent)localObject1);
        finish();
      }
      for (;;)
      {
        if (paramBoolean)
        {
          localObject1 = getIntent();
          if ("android.intent.action.VIEW".equals(((Intent)localObject1).getAction()))
          {
            localObject2 = ((Intent)localObject1).getDataString();
            if ((localObject2 != null) && (!((Intent)localObject1).getBooleanExtra("dont_resolve_again", false)))
            {
              Object localObject3 = bl.a(Uri.parse((String)localObject2));
              this.X.a();
              localObject1 = com.google.android.finsky.externalreferrer.f.a((Uri)localObject3);
              localObject2 = ((com.google.android.finsky.e.i)this.T.a()).cV();
              localObject3 = ((Uri)localObject3).toString();
              ((com.google.android.finsky.e.u)localObject2).a(new com.google.android.finsky.e.g(12).a((String)localObject3).b(null).c((String)localObject1).d(null).a(null).a, -1L);
            }
          }
        }
        return;
        localObject1 = ((com.google.android.finsky.accounts.a)this.H.a()).c()[0];
        AccountManager.get(this).addAccount((String)localObject1, "androidmarket", null, a(this), null, new m(this), null);
      }
    }
    if (!(((String)localObject2).equals(((com.google.android.finsky.accounts.c)this.I.a()).cU()) ^ true))
    {
      if (((com.google.android.finsky.accounts.a)this.H.a()).a((String)localObject2))
      {
        d("Maybe clear cache");
        localObject1 = (com.google.android.finsky.bo.a)this.V.a();
        localObject2 = (com.google.android.finsky.dn.e)this.U.a();
        if ((!((com.google.android.finsky.bo.a)localObject1).a()) && (!((com.google.android.finsky.dn.e)localObject2).d()))
        {
          f(paramBoolean);
          return;
        }
        int j;
        if (((com.google.android.finsky.dn.e)this.U.a()).c("Phenotype", "enable_cache_clearing_ps_exp", ((com.google.android.finsky.accounts.c)this.I.a()).cS())) {
          if (((Boolean)com.google.android.finsky.ag.c.at.a()).booleanValue()) {
            j = 1;
          }
        }
        for (;;)
        {
          if ((((com.google.android.finsky.bo.c)this.W.a()).cY().a(12642551L)) || (((Boolean)com.google.android.finsky.ag.c.as.a()).booleanValue())) {}
          while ((j != 0) || (((Boolean)com.google.android.finsky.ag.d.r.b()).booleanValue()))
          {
            ((com.google.android.finsky.volley.h)this.av.a()).a(new g(this, paramBoolean), 9);
            return;
          }
          M();
          f(paramBoolean);
          return;
          j = 0;
          continue;
          j = 0;
        }
      }
      if (paramBoolean) {}
      for (localObject1 = getIntent();; localObject1 = null)
      {
        a(null, (Intent)localObject1);
        break;
      }
    }
    if (paramBoolean) {
      localObject1 = getIntent();
    }
    a((String)localObject2, (Intent)localObject1);
  }
  
  final void f(boolean paramBoolean)
  {
    d("Try warm up user settings cache");
    ((com.google.android.finsky.fd.a)this.at.a()).a(I());
    d("Start loading libraries");
    ((com.google.android.finsky.l.a)this.L.a()).b.d();
    ((com.google.android.finsky.library.c)this.ae.a()).d();
    d("Load toc");
    boolean[] arrayOfBoolean = new boolean[1];
    com.google.android.finsky.api.d locald = ((com.google.android.finsky.api.i)this.S.a()).a();
    com.google.android.finsky.bo.f localf = ((com.google.android.finsky.bo.c)this.W.a()).cY();
    String str = ((com.google.android.finsky.accounts.c)this.I.a()).cU();
    ((com.google.android.finsky.eu.c)this.aq.a()).a(locald, true, true, new h(this, arrayOfBoolean, localf, locald, str, paramBoolean));
    s();
  }
  
  protected final void g(boolean paramBoolean)
  {
    d("Load plus profile");
    d("Wait for user settings");
    if (((com.google.android.finsky.fd.a)this.at.a()).c(I()))
    {
      boolean[] arrayOfBoolean = new boolean[1];
      arrayOfBoolean[0] = true;
      k localk = new k(this, arrayOfBoolean, paramBoolean);
      ((com.google.android.finsky.fd.a)this.at.a()).a(localk);
      new Handler(getMainLooper()).postDelayed(new l(this, arrayOfBoolean, localk, paramBoolean), 10000L);
      return;
    }
    h(paramBoolean);
  }
  
  final void h(boolean paramBoolean)
  {
    d("Check Tos acceptance");
    Object localObject = ((com.google.android.finsky.ev.a)this.ar.a()).a;
    if (localObject == null) {}
    while (!((com.google.android.finsky.tos.c)this.as.a()).a(I(), (DfeToc)localObject))
    {
      d("Setup wait for wifi");
      if (((com.google.android.finsky.bo.c)this.W.a()).cY().a(12653638L))
      {
        localObject = (com.google.android.finsky.waitforwifi.a)this.aw.a();
        af localaf = this.ag;
        if (!((com.google.android.finsky.waitforwifi.a)localObject).f)
        {
          ((com.google.android.finsky.waitforwifi.a)localObject).f = true;
          if (((com.google.android.finsky.waitforwifi.a)localObject).b.a() == null) {
            ((com.google.android.finsky.waitforwifi.a)localObject).b.a(Long.valueOf(com.google.android.finsky.utils.i.a()));
          }
          if (((com.google.android.finsky.waitforwifi.a)localObject).c.cY().a(12644633L)) {
            ((com.google.android.finsky.waitforwifi.a)localObject).d.a(new com.google.android.finsky.waitforwifi.b((com.google.android.finsky.waitforwifi.a)localObject, localaf));
          }
        }
      }
      for (;;)
      {
        d("Wait for libraries");
        ((com.google.android.finsky.af.d)this.af.a()).b(Arrays.asList(new com.google.android.finsky.af.e[] { ((com.google.android.finsky.l.a)this.L.a()).b.d(), ((com.google.android.finsky.library.c)this.ae.a()).d() })).a(new c(this, paramBoolean));
        return;
        localObject = (com.google.android.finsky.waitforwifi.a)this.aw.a();
        ((com.google.android.finsky.waitforwifi.a)localObject).a.c();
        ((com.google.android.finsky.waitforwifi.a)localObject).b.c();
        com.google.android.finsky.billing.common.e.a.a(Integer.valueOf(1));
      }
    }
    J();
  }
  
  public abstract void l();
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    case 21: 
    case 24: 
    case 23: 
      do
      {
        do
        {
          return;
          this.ax = false;
          if (((com.google.android.finsky.accounts.a)this.H.a()).b() == null)
          {
            FinskyLog.a("No new account added: Assume the user canceled and finish.", new Object[0]);
            finish();
            return;
          }
          this.ag.a(new com.google.android.finsky.e.d(563));
          this.f = true;
          return;
          if (paramInt2 == -1)
          {
            ((com.google.android.finsky.ba.d)this.al.a()).b = true;
            g(true);
            return;
          }
          finish();
          return;
          if (paramInt2 == -1) {
            break;
          }
        } while ((!((com.google.android.finsky.bo.c)this.W.a()).cY().a(12608498L)) || (paramInt2 != 0));
        finish();
        return;
        paramIntent = paramIntent.getStringExtra("authAccount");
      } while (paramIntent == null);
      FinskyLog.a("b/5160617: Switch account to %s on resume", new Object[] { FinskyLog.a(paramIntent) });
      c(paramIntent);
      return;
    case 22: 
      if (paramInt2 != 0)
      {
        this.ax = false;
        this.f = true;
        return;
      }
      m();
      return;
    }
    this.ax = false;
    if (paramInt2 == 0)
    {
      if ((((com.google.android.finsky.bo.c)this.W.a()).cY().a(12608498L)) && (((com.google.android.finsky.accounts.a)this.H.a()).a().length > 1))
      {
        m();
        return;
      }
      finish();
      return;
    }
    this.f = true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    l();
    d("AuthenticatedActivity onCreate");
    if (((com.google.android.finsky.recoverymode.a)this.ak.a()).b())
    {
      super.onCreate(paramBundle);
      ((com.google.android.finsky.recoverymode.a)this.ak.a()).e();
      finish();
      return;
    }
    if (getResources().getBoolean(2131034127)) {}
    for (;;)
    {
      Object localObject = paramBundle;
      String str;
      if (paramBundle != null)
      {
        this.ax = paramBundle.getBoolean("waiting_for_user_input");
        localObject = I();
        str = paramBundle.getString("last_used_account");
        if (localObject != null) {
          break label471;
        }
        localObject = null;
      }
      for (;;)
      {
        this.ag = ((com.google.android.finsky.e.a)this.J.a()).a((Bundle)localObject, getIntent(), P());
        super.onCreate((Bundle)localObject);
        if (!((com.google.android.finsky.ba.g)this.ao.a()).a())
        {
          startActivity(((com.google.android.finsky.cl.b)this.i_.a()).f(this));
          finish();
          return;
        }
        if ((((com.google.android.finsky.ba.g)this.ao.a()).f() != 0) || (!((com.google.android.finsky.fc.d)this.au.a()).a()) || (((com.google.android.finsky.accounts.c)this.I.a()).cR() != null))
        {
          K();
          boolean bool2;
          if (!i)
          {
            ((com.google.android.finsky.dt.a)this.Z.a()).dh();
            boolean bool1 = ((com.google.android.finsky.en.a)this.ap.a()).a();
            if (bool1)
            {
              com.google.android.finsky.ag.c.T.c();
              com.google.android.finsky.ag.c.S.c();
            }
            bool2 = ((com.google.android.finsky.en.a)this.ap.a()).b();
            if (bool1)
            {
              FinskyLog.a("Diff version or system, clear token & cache", new Object[0]);
              ((com.google.android.finsky.deviceconfig.d)this.R.a()).a(((com.google.android.finsky.api.i)this.S.a()).a());
              ((com.google.android.finsky.volley.h)this.av.a()).a(new b(this), 3);
            }
          }
          for (;;)
          {
            i = true;
            return;
            if (bool2) {
              break;
            }
            e(true);
            continue;
            if (this.ax) {
              FinskyLog.a("Waiting for user to return from auth screen.", new Object[0]);
            } else {
              e(true);
            }
          }
        }
        startActivity(((com.google.android.finsky.cl.b)this.i_.a()).d(this, this.ag));
        finish();
        return;
        label471:
        if (str == null) {}
        while (((String)localObject).equals(str))
        {
          if (!((com.google.android.finsky.bo.a)this.V.a()).a())
          {
            localObject = paramBundle;
            if (!((com.google.android.finsky.dn.e)this.U.a()).d()) {
              break;
            }
            localObject = null;
            break;
          }
          localObject = null;
          break;
        }
        localObject = null;
      }
      com.google.android.play.utils.k.c(this);
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    boolean bool2 = true;
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    boolean bool1 = bool2;
    if ("android.intent.action.MAIN".equals(paramIntent.getAction()))
    {
      bool1 = bool2;
      if (paramIntent.hasCategory("android.intent.category.LAUNCHER")) {
        bool1 = false;
      }
    }
    e(bool1);
  }
  
  public void onPause()
  {
    super.onPause();
    ((com.google.android.finsky.flushlogs.a)this.Y.a()).a();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.N)
    {
      this.N = false;
      d(this.O);
    }
    ((com.google.android.finsky.flushlogs.a)this.Y.a()).c();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    b(true);
    paramBundle.putBoolean("waiting_for_user_input", this.ax);
    paramBundle.putString("last_used_account", I());
    this.ag.a(paramBundle);
    super.onSaveInstanceState(paramBundle);
  }
  
  public boolean onSearchRequested()
  {
    return (((com.google.android.finsky.tos.c)this.as.a()).a()) && (super.onSearchRequested());
  }
  
  public void onStart()
  {
    super.onStart();
    d("AuthenticatedActivity onStart");
    com.google.android.finsky.cy.e.a();
    if (this.g == null)
    {
      this.g = new com.google.android.finsky.cy.e();
      registerReceiver(this.g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
      this.h = true;
    }
    b(false);
    if (((com.google.android.finsky.at.b)this.P.a()).a()) {
      ((com.google.android.finsky.at.d)this.Q.a()).b();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    com.google.android.finsky.cy.e locale = this.g;
    if (locale != null) {
      this.h = false;
    }
    try
    {
      unregisterReceiver(locale);
      this.g = null;
      com.google.android.finsky.cy.e.a();
      b(true);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        FinskyLog.b(localIllegalArgumentException, "NetworkChangeReceiver was unregistered!", new Object[0]);
      }
    }
  }
  
  public void s() {}
  
  public boolean t()
  {
    return false;
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    super.unregisterReceiver(paramBroadcastReceiver);
    com.google.android.finsky.cy.e locale = this.g;
    if ((locale != null) && (locale == paramBroadcastReceiver) && (this.h)) {
      FinskyLog.e("NetworkChangeReceiver unregistered unexpectedly!", new Object[0]);
    }
  }
  
  public void y() {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/q/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */