package com.google.android.finsky.bu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import android.text.TextUtils;
import com.android.volley.VolleyError;
import com.google.android.finsky.api.DfeServerError;
import com.google.android.finsky.bb.o;
import com.google.android.finsky.bb.q;
import com.google.android.finsky.billing.common.aa;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.e.u;
import com.google.android.finsky.pagesystem.k;
import com.google.android.finsky.utils.FinskyLog;
import com.google.wireless.android.a.b.a.a.bt;
import java.util.Collection;

public class a
  extends k
  implements q
{
  public com.google.android.finsky.at.b a;
  public b.a ac;
  private com.google.android.finsky.dfemodel.e ad;
  private final bt ae = u.a(0);
  public com.google.android.finsky.at.d c;
  
  protected final void R()
  {
    ((com.google.android.finsky.c)com.google.android.finsky.dt.b.a(com.google.android.finsky.c.class)).a(this);
  }
  
  protected final int V()
  {
    return 0;
  }
  
  protected final void W()
  {
    Object localObject = this.ad;
    if (localObject != null)
    {
      ((com.google.android.finsky.dfemodel.g)localObject).b(this);
      this.ad.b(this);
    }
    com.google.android.finsky.a.ai.ak();
    localObject = aa.b(com.google.android.finsky.a.ai.aq().a(this.aZ.b()));
    String str = this.g.getString("finsky.DetailsShimFragment.docid");
    this.ad = new com.google.android.finsky.dfemodel.e(this.aZ, this.bl, false, str, (Collection)localObject);
    this.ad.a(this);
    this.ad.a(this);
    this.ad.b();
    this.bf.b(3);
    au();
  }
  
  protected final void X() {}
  
  public final void a(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 1)
    {
      this.ac.a();
      paramBundle = com.google.android.finsky.eq.a.a("finsky.sw_home_url");
      this.bh.a(paramBundle);
    }
  }
  
  public final void a(VolleyError paramVolleyError)
  {
    super.a(paramVolleyError);
    if (((paramVolleyError instanceof DfeServerError)) && (com.google.android.finsky.a.ai.X().b()))
    {
      this.ac.a();
      paramVolleyError = com.google.android.finsky.eq.a.a("finsky.sw_home_url");
      String str = Uri.parse(Uri.decode(this.g.getString("finsky.DetailsShimFragment.originalUrl"))).getAuthority();
      if ((!TextUtils.isEmpty(paramVolleyError)) && (TextUtils.equals(str, "play.google.com")))
      {
        paramVolleyError = new o();
        paramVolleyError.a(2131951733).d(2131953724).e(2131952735).a(true).a(this, 1, null);
        paramVolleyError.a().a(this.q, "DetailsShimFragment.errorDialog");
      }
    }
  }
  
  public final void b(int paramInt, Bundle paramBundle) {}
  
  public final void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    W();
  }
  
  public final void e()
  {
    if (!this.bh.d())
    {
      this.be = this.ab.cY().a(12631400L);
      return;
    }
    if (this.ad.c() != null)
    {
      if (this.a.a()) {
        this.c.a(this.ad.c().a.f);
      }
      if (this.g.getString("finsky.DetailsShimFragment.originalUrl") != null) {}
      for (boolean bool = true;; bool = false)
      {
        this.bh.a(this.ad.c(), this.bl, this.g.getString("finsky.DetailsFragment.continueUrl"), this.g.getString("finsky.DetailsFragment.overrideAccount"), bool, this.bg);
        return;
      }
    }
    com.google.android.finsky.bb.f.a(this.q, this, null, this.aW.getString(2131952116), this.bg, 10);
  }
  
  public final void f()
  {
    super.f();
    com.google.android.finsky.dfemodel.e locale = this.ad;
    if (locale != null)
    {
      locale.b(this);
      this.ad.b(this);
    }
  }
  
  public bt getPlayStoreUiElement()
  {
    return this.ae;
  }
  
  public final void q_(int paramInt)
  {
    if ((paramInt == 10) && (j() != null))
    {
      if ((j() instanceof com.google.android.finsky.dj.a)) {
        ((com.google.android.finsky.dj.a)j()).p();
      }
    }
    else {
      return;
    }
    FinskyLog.e("Dialog not hosted by PageFragmentHost. Cannot navigate back.", new Object[0]);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bu/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */