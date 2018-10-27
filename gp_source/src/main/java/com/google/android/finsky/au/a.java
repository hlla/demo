package com.google.android.finsky.au;

import android.accounts.Account;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.design.snackbar.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.o;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.android.volley.n;
import com.android.volley.x;
import com.google.android.finsky.datasync.ak;
import com.google.android.finsky.dfemodel.DfeToc;
import com.google.android.finsky.ds.a.bp;
import com.google.android.finsky.ds.a.jj;
import com.google.android.finsky.ds.a.jk;
import com.google.android.finsky.ds.a.jt;
import com.google.android.finsky.ds.a.jx;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.e.g;
import com.google.android.finsky.e.u;
import com.google.android.finsky.e.z;
import com.google.android.finsky.layoutswitcher.i;
import com.google.android.finsky.layoutswitcher.j;
import com.google.android.finsky.pagesystem.ContentFrame;
import com.google.android.finsky.pagesystem.k;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.bl;
import com.google.android.finsky.utils.t;
import com.google.wireless.android.a.b.a.a.bt;
import java.util.Iterator;
import java.util.List;

public final class a
  extends k
  implements x, com.google.android.finsky.api.y
{
  public b.a a;
  public b.a aa;
  public String ac;
  public b.a ad;
  public b.a ae;
  public b.a af;
  public boolean ag;
  public final com.google.android.finsky.e.y ah = new com.google.android.finsky.e.y(6382, this.aw);
  private boolean ai;
  private int aj;
  private int ak;
  private View am;
  private final aq an = new com.google.android.finsky.e.y(6381, getParentNode());
  private View ao;
  private boolean ap;
  private String aq;
  private n ar;
  private jt as;
  private boolean at;
  private final bt au = u.a(18);
  private Uri av;
  private final aq aw = new com.google.android.finsky.e.y(6380, getParentNode());
  public b.a c;
  
  public static a a(Uri paramUri, String paramString, af paramaf, DfeToc paramDfeToc, com.google.android.finsky.accounts.c paramc, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    a locala = new a();
    Uri localUri = bl.a(paramUri);
    String str = localUri.getQueryParameter("ah");
    paramUri = paramaf;
    if (!TextUtils.isEmpty(str))
    {
      paramUri = paramc.cQ().iterator();
      do
      {
        if (!paramUri.hasNext()) {
          break;
        }
        paramc = (Account)paramUri.next();
      } while (!t.a(paramc.name.getBytes()).equals(str));
    }
    for (paramUri = paramc.name;; paramUri = null)
    {
      if (TextUtils.isEmpty(paramUri)) {
        locala.d("DeepLinkShimFragment.overrideAccountMissing", true);
      }
      for (paramUri = paramaf;; paramUri = paramaf.b(paramUri))
      {
        if (!TextUtils.isEmpty(paramString)) {
          locala.a("DeepLinkShimFragment.referringPackage", paramString);
        }
        locala.a(paramDfeToc, localUri.toString());
        locala.b(paramUri);
        if (paramInt1 != 0) {
          locala.b("DeepLinkShimFragment.customContentFrameLayoutId", paramInt1);
        }
        if (paramInt2 != 0) {
          locala.b("DeepLinkShimFragment.customDeepLinkDisconnectionLayoutId", paramInt2);
        }
        locala.d("DeepLinkShimFragment.allowDisconnectionPrompt", paramBoolean1);
        locala.d("DeepLinkShimFragment.shouldSwitchToLoadingImmediately", paramBoolean2);
        return locala;
        locala.d(paramUri);
        locala.a("DeepLinkShimFragment.overrideAccount", paramUri);
      }
    }
  }
  
  private static String a(Uri paramUri)
  {
    String str = paramUri.getQueryParameter("url");
    paramUri = str;
    if (TextUtils.isEmpty(str)) {
      paramUri = null;
    }
    return paramUri;
  }
  
  private final void a(int paramInt, byte[] paramArrayOfByte)
  {
    g localg = new g(paramInt).a(this.bl).c(this.ac).d(this.aq).a(paramArrayOfByte);
    if (paramInt == 1) {
      if (paramArrayOfByte != null) {
        break label74;
      }
    }
    for (;;)
    {
      paramArrayOfByte = this.as.k;
      if (paramArrayOfByte != null) {
        localg.b(paramArrayOfByte.b);
      }
      label74:
      do
      {
        this.bg.a(localg);
        return;
      } while (paramArrayOfByte.length != 0);
    }
  }
  
  private final String an()
  {
    String str2 = this.g.getString("DeepLinkShimFragment.overrideAccount");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.aZ.c();
    }
    return str1;
  }
  
  private final void ao()
  {
    if ((this.ar != null) && (this.ab.cY().a(12643017L)))
    {
      this.ar.d();
      this.ar = null;
    }
  }
  
  protected final void R()
  {
    ((e)com.google.android.finsky.dt.b.a(e.class)).a(this);
  }
  
  protected final int V()
  {
    return 0;
  }
  
  protected final void W()
  {
    k(1718);
    a(12, null);
    ao();
    if (this.ab.cY().a(12611365L)) {}
    for (this.ar = ((ak)this.af.a()).a(this.bl, this.aq, this, this, this, this.aZ, this.bg);; this.ar = this.aZ.a(this.bl, this.aq, this, this, this))
    {
      this.aZ.m(this.bl, new b(this), new c(this));
      if (!this.at)
      {
        au();
        return;
      }
      this.bf.b(0);
      return;
    }
  }
  
  protected final void X() {}
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    boolean bool;
    if (((com.google.android.finsky.at.b)this.c.a()).a())
    {
      Object localObject = (FrameLayout)paramLayoutInflater;
      paramViewGroup = (FrameLayout)((FrameLayout)localObject).findViewById(2131428709);
      paramViewGroup.removeAllViews();
      localObject = LayoutInflater.from(((FrameLayout)localObject).getContext());
      this.ao = ((LayoutInflater)localObject).inflate(com.google.android.finsky.bs.a.R.intValue(), paramViewGroup, false);
      paramViewGroup.addView(this.ao);
      int j = this.ak;
      int i = j;
      if (j == 0) {
        i = com.google.android.finsky.bs.a.Q.intValue();
      }
      this.am = ((LayoutInflater)localObject).inflate(i, paramViewGroup, false);
      paramViewGroup.addView(this.am);
      this.am.findViewById(2131427714).setVisibility(0);
      paramViewGroup = (TextView)this.am.findViewById(2131428053);
      paramViewGroup.setVisibility(0);
      paramViewGroup.setText(2131952102);
      ((TextView)this.am.findViewById(2131428050)).setText(2131952098);
      this.am.findViewById(2131428048).setVisibility(0);
      if (paramBundle == null) {
        break label232;
      }
      if (!paramBundle.getBoolean("notification_requested", false)) {
        break label226;
      }
      bool = true;
    }
    for (;;)
    {
      this.ag = bool;
      return paramLayoutInflater;
      label226:
      bool = false;
      continue;
      label232:
      bool = false;
    }
  }
  
  protected final com.google.android.finsky.layoutswitcher.e a(ContentFrame paramContentFrame)
  {
    if (((com.google.android.finsky.at.b)this.c.a()).a())
    {
      paramContentFrame = this.h_.a(paramContentFrame, 2131428708, this);
      paramContentFrame.b = 2131428510;
      paramContentFrame.a = 2;
      return paramContentFrame.a();
    }
    return super.a(paramContentFrame);
  }
  
  public final void a()
  {
    com.google.android.finsky.e.d locald = new com.google.android.finsky.e.d(1104).d(this.bl).e(this.ac).a(2);
    this.bg.a(locald);
  }
  
  final void a(int paramInt, VolleyError paramVolleyError)
  {
    paramVolleyError = new com.google.android.finsky.e.d(paramInt).d(this.bl).a(paramVolleyError).e(this.ac).a(1);
    this.bg.a(paramVolleyError);
  }
  
  public final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    i(5);
    paramBundle = this.g;
    this.av = Uri.parse(this.bl);
    this.ad.a();
    this.ac = com.google.android.finsky.externalreferrer.f.a(this.av);
    this.aq = paramBundle.getString("DeepLinkShimFragment.referringPackage");
    this.ap = paramBundle.getBoolean("DeepLinkShimFragment.overrideAccountMissing", false);
    this.aj = paramBundle.getInt("DeepLinkShimFragment.customContentFrameLayoutId");
    this.ak = paramBundle.getInt("DeepLinkShimFragment.customDeepLinkDisconnectionLayoutId");
    this.ai = paramBundle.getBoolean("DeepLinkShimFragment.allowDisconnectionPrompt");
    this.at = paramBundle.getBoolean("DeepLinkShimFragment.shouldSwitchToLoadingImmediately");
  }
  
  public final void a(VolleyError paramVolleyError)
  {
    FinskyLog.d("Error on resolveLink: %s", new Object[] { paramVolleyError });
    a(1104, paramVolleyError);
    if ((this.ai) && (j() != null) && (((com.google.android.finsky.at.b)this.c.a()).a()))
    {
      this.aa.a();
      if (com.google.android.finsky.at.d.b(paramVolleyError))
      {
        if (j() != null)
        {
          this.bi.a_(c(2131951729));
          this.bi.a(0, 0, false);
          this.bi.q();
          a(c(com.google.android.finsky.bs.a.ai.intValue()));
          if (this.ag) {
            break label227;
          }
          if (this.am.getVisibility() != 0)
          {
            this.am.setVisibility(0);
            this.am.findViewById(com.google.android.finsky.bs.a.C.intValue()).setOnClickListener(new d(this, j().getIntent()));
            this.bg.a(new z().b(this.aw));
          }
        }
        else
        {
          return;
        }
        Snackbar.a(this.U, c(2131952101), 0).d();
        return;
        label227:
        am();
        return;
      }
    }
    this.bh.a(this.ba, this.bg);
  }
  
  protected final int ag_()
  {
    int j = this.aj;
    int i = j;
    if (j == 0) {
      i = super.ag_();
    }
    return i;
  }
  
  protected final boolean ah_()
  {
    return true;
  }
  
  public final boolean ai_()
  {
    return false;
  }
  
  public final boolean aj()
  {
    if (((com.google.android.finsky.at.b)this.c.a()).a())
    {
      this.bh.a(this.ba, this.bg);
      return true;
    }
    return super.aj();
  }
  
  final void am()
  {
    this.ao.setVisibility(0);
    this.am.setVisibility(8);
    this.bg.a(new z().b(this.an));
  }
  
  public final void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    W();
  }
  
  public final void e()
  {
    int i = 0;
    if ((this.ab.cY().a(12631400L)) && (!this.bh.d())) {
      this.be = true;
    }
    while ((this.as == null) || (!at())) {
      return;
    }
    if (((com.google.android.finsky.at.b)this.c.a()).a()) {
      ((com.google.android.finsky.at.d)this.aa.a()).a(this.bg, j().getIntent());
    }
    this.bh.w();
    k(1719);
    Object localObject2 = this.as;
    Object localObject1 = ((jt)localObject2).G;
    if (((jt)localObject2).h.length() > 0)
    {
      a(1, (byte[])localObject1);
      ((com.google.android.finsky.externalreferrer.f)this.ad.a()).a(this.ac, this.aq, this.as.k, "deeplink");
      localObject1 = this.as;
      if (this.ab.cY().a(12629614L)) {
        ((jt)localObject1).a(Uri.parse(((jt)localObject1).h).buildUpon().appendQueryParameter("nocache_irl", Boolean.toString(true)).build().toString());
      }
      localObject1 = this.bh;
      localObject2 = this.as;
      ((com.google.android.finsky.navigationmanager.c)localObject1).a(((jt)localObject2).h, ((jt)localObject2).k, a(this.av), this.g.getString("DeepLinkShimFragment.overrideAccount"), this.bl, this.bg);
      return;
    }
    if (this.as.t.length() > 0)
    {
      a(14, (byte[])localObject1);
      ((com.google.android.finsky.externalreferrer.f)this.ad.a()).a(this.ac, this.aq, this.as.k, "deeplink");
      this.bh.a(this.as.t, a(this.av), this.g.getString("DeepLinkShimFragment.overrideAccount"), this.bl);
      return;
    }
    if (this.as.i.length() > 0)
    {
      a(30, (byte[])localObject1);
      ((com.google.android.finsky.externalreferrer.f)this.ad.a()).a(this.ac, this.aq, this.as.k, "deeplink");
      this.bh.b(this.as.i, a(this.av), this.g.getString("DeepLinkShimFragment.overrideAccount"), this.bl);
      return;
    }
    if (this.as.e.length() > 0)
    {
      a(2, (byte[])localObject1);
      if (this.as.d()) {
        i = this.as.E;
      }
      this.bh.a(this.as.e, null, true, -1, i, this.ba, null, this.bg);
      return;
    }
    if (this.as.F.length() > 0)
    {
      a(3, (byte[])localObject1);
      if (this.as.d()) {}
      for (i = this.as.E;; i = 0)
      {
        localObject1 = this.bh;
        localObject2 = this.as;
        ((com.google.android.finsky.navigationmanager.c)localObject1).a(((jt)localObject2).F, ((jt)localObject2).A, ((jt)localObject2).c, i, null, 3, this.bg);
        return;
      }
    }
    if (this.as.M.length() > 0)
    {
      a(8, (byte[])localObject1);
      this.bh.e();
      return;
    }
    if (this.as.v.length() > 0)
    {
      a(10, (byte[])localObject1);
      this.bh.a(10, this.bg);
      return;
    }
    localObject2 = this.as;
    if (((jt)localObject2).j != null)
    {
      FinskyLog.a("Direct purchase deprecated.", new Object[0]);
      localObject2 = this.as.j;
      a(4, (byte[])localObject1);
      ((com.google.android.finsky.externalreferrer.f)this.ad.a()).a(this.ac, this.aq, this.as.j.c, "deeplink");
      this.bh.a(((jk)localObject2).a, a(this.av), this.g.getString("DeepLinkShimFragment.overrideAccount"), this.bl, this.bg);
      return;
    }
    if (((jt)localObject2).r.length() > 0)
    {
      a(5, (byte[])localObject1);
      localObject1 = this.as;
      i = ((jt)localObject1).c;
      if (i == 0)
      {
        this.bh.a(this.ba, ((jt)localObject1).r, this.bg);
        return;
      }
      this.bh.a(this.ba, i, this.bg);
      return;
    }
    localObject2 = this.as;
    if (((jt)localObject2).a != null)
    {
      this.bh.a(this.ba, this.bg);
      this.bh.a(this.aZ.c(), this.as.a, this.bg);
      return;
    }
    if (((jt)localObject2).C != null)
    {
      a(6, (byte[])localObject1);
      this.bh.a(this.ba, this.bg);
      this.bh.a(this.aZ.c(), this.as.C, this.bg);
      return;
    }
    if (((jt)localObject2).p.length() > 0)
    {
      a(13, (byte[])localObject1);
      this.bh.a(this.bg);
      return;
    }
    if (this.as.y.length() > 0)
    {
      a(15, (byte[])localObject1);
      if (this.ab.cY().a(12658206L))
      {
        this.bh.c(this.bg);
        return;
      }
      this.bh.a(32, this.bg);
      return;
    }
    af localaf;
    if (this.as.x.length() > 0)
    {
      a(16, (byte[])localObject1);
      localObject1 = this.bh;
      localObject2 = this.as.k;
      localaf = this.bg;
      this.aZ.c();
      ((com.google.android.finsky.navigationmanager.c)localObject1).a(31, (bp)localObject2, localaf);
      return;
    }
    if (this.as.D.length() > 0)
    {
      a(17, (byte[])localObject1);
      localObject1 = this.bh;
      localObject2 = this.as.k;
      localaf = this.bg;
      this.aZ.c();
      ((com.google.android.finsky.navigationmanager.c)localObject1).a(20, (bp)localObject2, localaf);
      return;
    }
    localObject2 = this.as;
    if (((jt)localObject2).l != null)
    {
      a(20, (byte[])localObject1);
      this.bh.d(this.bg);
      return;
    }
    if (((jt)localObject2).n != null)
    {
      a(21, (byte[])localObject1);
      this.bh.a(33, this.bg);
      return;
    }
    if (((jt)localObject2).o != null)
    {
      a(23, (byte[])localObject1);
      this.bh.a(this.as.o);
      return;
    }
    if (!TextUtils.isEmpty(((jt)localObject2).z))
    {
      a(26, (byte[])localObject1);
      this.bh.b(this.ba, this.as.z, this.bg);
      return;
    }
    if (!TextUtils.isEmpty(this.as.m))
    {
      a(27, (byte[])localObject1);
      this.bh.b(this.as.m, this.bg);
      return;
    }
    localObject2 = this.as;
    if (((jt)localObject2).K != null)
    {
      this.bh.a(35, this.bg);
      return;
    }
    if (((jt)localObject2).b())
    {
      a(29, (byte[])localObject1);
      this.bh.a(this.ba, this.as.w, false, this.bg);
      return;
    }
    if (!TextUtils.isEmpty(this.as.I))
    {
      a(33, (byte[])localObject1);
      this.bh.a(this.as.I, this.bg, an(), this.ap);
      return;
    }
    if (!TextUtils.isEmpty(this.as.u))
    {
      a(34, (byte[])localObject1);
      this.bh.a(null, this.as.u, this.bg, an(), this.ap);
      return;
    }
    localObject2 = this.as;
    if (((jt)localObject2).L != null)
    {
      a(19, (byte[])localObject1);
      localObject1 = this.bh;
      localObject2 = this.as;
      ((com.google.android.finsky.navigationmanager.c)localObject1).a((jt)localObject2, ((jt)localObject2).L.d, this.bg, an(), this.ap);
      return;
    }
    if (((jt)localObject2).g != null)
    {
      a(28, (byte[])localObject1);
      localObject1 = this.bh;
      localObject2 = this.as;
      ((com.google.android.finsky.navigationmanager.c)localObject1).a((jt)localObject2, ((jt)localObject2).g.c, this.bg, an(), this.ap);
      return;
    }
    a(0, (byte[])localObject1);
    localObject1 = new Intent("android.intent.action.VIEW");
    ((Intent)localObject1).setData(Uri.parse(this.bl));
    ((Intent)localObject1).addFlags(268435456);
    ((Intent)localObject1).putExtra("dont_resolve_again", true);
    ((com.google.android.finsky.cl.a)this.a.a()).a(j(), (Intent)localObject1);
  }
  
  public final void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    if (((com.google.android.finsky.at.b)this.c.a()).a()) {
      paramBundle.putBoolean("notification_requested", this.ag);
    }
  }
  
  public final void f()
  {
    super.f();
    ao();
  }
  
  public final bt getPlayStoreUiElement()
  {
    return this.au;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/au/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */