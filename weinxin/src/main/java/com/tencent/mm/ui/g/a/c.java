package com.tencent.mm.ui.g.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;

public final class c
{
  protected static String wdZ;
  protected static String wea;
  protected static String web;
  private String ivn;
  public String vqP;
  private long wec;
  public long wed;
  public Activity wee;
  private String[] wef;
  private int weg;
  public a weh;
  private final long wei;
  
  static
  {
    GMTrace.i(2913598439424L, 21708);
    wdZ = "https://m.facebook.com/dialog/";
    wea = "https://graph.facebook.com/";
    web = "https://api.facebook.com/restserver.php";
    GMTrace.o(2913598439424L, 21708);
  }
  
  public c(String paramString)
  {
    GMTrace.i(2912122044416L, 21697);
    this.vqP = null;
    this.wec = 0L;
    this.wed = 0L;
    this.wei = 86400000L;
    this.ivn = paramString;
    GMTrace.o(2912122044416L, 21697);
  }
  
  private void a(Activity paramActivity, String[] paramArrayOfString)
  {
    GMTrace.i(2912390479872L, 21699);
    Bundle localBundle = new Bundle();
    if (paramArrayOfString.length > 0) {
      localBundle.putString("scope", TextUtils.join(",", paramArrayOfString));
    }
    CookieSyncManager.createInstance(paramActivity);
    a(paramActivity, "oauth", localBundle, new a()
    {
      public final void a(b paramAnonymousb)
      {
        GMTrace.i(2909840343040L, 21680);
        v.d("Facebook-authorize", "Login failed: " + paramAnonymousb);
        c.this.weh.a(paramAnonymousb);
        GMTrace.o(2909840343040L, 21680);
      }
      
      public final void a(d paramAnonymousd)
      {
        GMTrace.i(2909974560768L, 21681);
        v.d("Facebook-authorize", "Login failed: " + paramAnonymousd);
        c.this.weh.a(paramAnonymousd);
        GMTrace.o(2909974560768L, 21681);
      }
      
      public final void m(Bundle paramAnonymousBundle)
      {
        GMTrace.i(2909706125312L, 21679);
        CookieSyncManager.getInstance().sync();
        c.this.TW(paramAnonymousBundle.getString("access_token"));
        c.this.TX(paramAnonymousBundle.getString("expires_in"));
        if (c.this.bYH())
        {
          v.d("Facebook-authorize", "Login Success! access_token=" + c.this.vqP + " expires=" + c.this.wed);
          c.this.weh.m(paramAnonymousBundle);
          GMTrace.o(2909706125312L, 21679);
          return;
        }
        c.this.weh.a(new d("Failed to receive access token."));
        GMTrace.o(2909706125312L, 21679);
      }
      
      public final void onCancel()
      {
        GMTrace.i(2910108778496L, 21682);
        v.d("Facebook-authorize", "Login canceled");
        c.this.weh.onCancel();
        GMTrace.o(2910108778496L, 21682);
      }
    });
    GMTrace.o(2912390479872L, 21699);
  }
  
  public final void TW(String paramString)
  {
    GMTrace.i(2913195786240L, 21705);
    this.vqP = paramString;
    this.wec = System.currentTimeMillis();
    GMTrace.o(2913195786240L, 21705);
  }
  
  public final void TX(String paramString)
  {
    GMTrace.i(2913330003968L, 21706);
    if (paramString != null) {
      if (!paramString.equals("0")) {
        break label39;
      }
    }
    label39:
    for (long l = 0L;; l = System.currentTimeMillis() + bf.PY(paramString) * 1000L)
    {
      this.wed = l;
      GMTrace.o(2913330003968L, 21706);
      return;
    }
  }
  
  public final String a(String paramString1, Bundle paramBundle, String paramString2)
  {
    GMTrace.i(2912793133056L, 21702);
    paramBundle.putString("format", "json");
    if (bYH()) {
      paramBundle.putString("access_token", this.vqP);
    }
    if (paramString1 != null) {}
    for (paramString1 = wea + paramString1;; paramString1 = web)
    {
      paramString1 = e.e(paramString1, paramString2, paramBundle);
      GMTrace.o(2912793133056L, 21702);
      return paramString1;
    }
  }
  
  public final void a(Activity paramActivity, String[] paramArrayOfString, a parama)
  {
    GMTrace.i(2912256262144L, 21698);
    this.weh = parama;
    a(paramActivity, paramArrayOfString);
    g.oSF.a(582L, 0L, 1L, false);
    GMTrace.o(2912256262144L, 21698);
  }
  
  public final void a(Context paramContext, String paramString, Bundle paramBundle, a parama)
  {
    GMTrace.i(2912927350784L, 21703);
    String str = wdZ + paramString;
    paramBundle.putString("display", "touch");
    paramBundle.putString("redirect_uri", "fbconnect://success");
    if (paramString.equals("oauth"))
    {
      paramBundle.putString("type", "user_agent");
      paramBundle.putString("client_id", this.ivn);
    }
    for (;;)
    {
      if (bYH()) {
        paramBundle.putString("access_token", this.vqP);
      }
      paramString = str + "?" + e.ae(paramBundle);
      if (paramContext.checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
        break;
      }
      e.A(paramContext, "Error", "Application requires permission to access the Internet");
      GMTrace.o(2912927350784L, 21703);
      return;
      paramBundle.putString("app_id", this.ivn);
    }
    new f(paramContext, paramString, parama).show();
    GMTrace.o(2912927350784L, 21703);
  }
  
  public final boolean bYH()
  {
    GMTrace.i(2913061568512L, 21704);
    if ((this.vqP != null) && ((this.wed == 0L) || (System.currentTimeMillis() < this.wed)))
    {
      GMTrace.o(2913061568512L, 21704);
      return true;
    }
    GMTrace.o(2913061568512L, 21704);
    return false;
  }
  
  public final void e(int paramInt1, int paramInt2, Intent paramIntent)
  {
    GMTrace.i(2912524697600L, 21700);
    if (paramInt1 == this.weg)
    {
      if (paramInt2 == -1)
      {
        String str2 = paramIntent.getStringExtra("error");
        String str1 = str2;
        if (str2 == null) {
          str1 = paramIntent.getStringExtra("error_type");
        }
        if (str1 != null)
        {
          if ((str1.equals("service_disabled")) || (str1.equals("AndroidAuthKillSwitchException")))
          {
            v.d("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
            a(this.wee, this.wef);
            GMTrace.o(2912524697600L, 21700);
            return;
          }
          if ((str1.equals("access_denied")) || (str1.equals("OAuthAccessDeniedException")))
          {
            v.d("Facebook-authorize", "Login canceled by user.");
            this.weh.onCancel();
            GMTrace.o(2912524697600L, 21700);
            return;
          }
          str2 = paramIntent.getStringExtra("error_description");
          paramIntent = str1;
          if (str2 != null) {
            paramIntent = str1 + ":" + str2;
          }
          v.d("Facebook-authorize", "Login failed: " + paramIntent);
          this.weh.a(new d(paramIntent));
          GMTrace.o(2912524697600L, 21700);
          return;
        }
        TW(paramIntent.getStringExtra("access_token"));
        TX(paramIntent.getStringExtra("expires_in"));
        if (bYH())
        {
          v.d("Facebook-authorize", "Login Success! access_token=" + this.vqP + " expires=" + this.wed);
          this.weh.m(paramIntent.getExtras());
          GMTrace.o(2912524697600L, 21700);
          return;
        }
        this.weh.a(new d("Failed to receive access token."));
        GMTrace.o(2912524697600L, 21700);
        return;
      }
      if (paramInt2 == 0)
      {
        if (paramIntent != null)
        {
          v.d("Facebook-authorize", "Login failed: " + paramIntent.getStringExtra("error"));
          this.weh.a(new b(paramIntent.getStringExtra("error"), paramIntent.getIntExtra("error_code", -1), paramIntent.getStringExtra("failing_url")));
          GMTrace.o(2912524697600L, 21700);
          return;
        }
        v.d("Facebook-authorize", "Login canceled by user.");
        this.weh.onCancel();
      }
    }
    GMTrace.o(2912524697600L, 21700);
  }
  
  public final String fb(Context paramContext)
  {
    GMTrace.i(2912658915328L, 21701);
    CookieSyncManager.createInstance(paramContext);
    CookieManager.getInstance().removeAllCookie();
    TW(null);
    this.wed = 0L;
    GMTrace.o(2912658915328L, 21701);
    return null;
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
    
    public abstract void a(d paramd);
    
    public abstract void m(Bundle paramBundle);
    
    public abstract void onCancel();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/g/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */