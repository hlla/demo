package com.google.android.gms.ads.internal.mediation.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.c.j;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.k;
import com.google.android.gms.ads.internal.util.n;
import com.google.android.gms.ads.internal.v.f;
import com.google.android.gms.ads.mediation.g;

@com.google.android.gms.ads.internal.q.a.a
public final class a
  implements g
{
  public Activity a;
  public com.google.android.gms.ads.mediation.h b;
  private Uri c;
  
  public final void a()
  {
    k.b("Destroying AdMobCustomTabsAdapter adapter.");
  }
  
  public final void a(Context paramContext, com.google.android.gms.ads.mediation.h paramh, Bundle paramBundle1, com.google.android.gms.ads.mediation.a parama, Bundle paramBundle2)
  {
    this.b = paramh;
    if (this.b == null)
    {
      k.e("Listener not set for mediation. Returning.");
      return;
    }
    if (!(paramContext instanceof Activity))
    {
      k.e("AdMobCustomTabs can only work with Activity context. Bailing out.");
      this.b.b(0);
      return;
    }
    if (!com.google.android.gms.ads.internal.i.a.a(paramContext))
    {
      k.e("Default browser does not support custom tabs. Bailing out.");
      this.b.b(0);
      return;
    }
    paramh = paramBundle1.getString("tab_url");
    if (TextUtils.isEmpty(paramh))
    {
      k.e("The tab_url retrieved from mediation metadata is empty. Bailing out.");
      this.b.b(0);
      return;
    }
    this.a = ((Activity)paramContext);
    this.c = Uri.parse(paramh);
    this.b.j();
  }
  
  public final void b()
  {
    k.b("Pausing AdMobCustomTabsAdapter adapter.");
  }
  
  public final void c()
  {
    k.b("Resuming AdMobCustomTabsAdapter adapter.");
  }
  
  public final void f()
  {
    Object localObject = new j().a();
    ((android.support.c.i)localObject).a.setData(this.c);
    localObject = new AdOverlayInfoParcel(new AdLauncherIntentInfoParcel(((android.support.c.i)localObject).a), null, new b(this), null, new VersionInfoParcel(0, 0, false));
    n.a.post(new c(this, (AdOverlayInfoParcel)localObject));
    bt.A.i.d.a(com.google.android.gms.ads.internal.v.i.b, com.google.android.gms.ads.internal.v.i.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/mediation/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */