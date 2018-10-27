package com.google.android.finsky.e;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.finsky.e.a.a;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.play.b.a.p;
import com.google.protobuf.nano.h;
import com.google.wireless.android.a.b.a.a.bg;
import com.google.wireless.android.a.b.a.a.bh;
import com.google.wireless.android.a.b.a.a.bm;

public final class af
{
  public final i a;
  public final String b;
  private final String c;
  private long d;
  private final boolean e;
  
  public af(long paramLong, String paramString1, boolean paramBoolean, String paramString2, i parami)
  {
    this.d = paramLong;
    if (!TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      this.b = paramString1;
      this.e = paramBoolean;
      if (!TextUtils.isEmpty(paramString2)) {}
      for (;;)
      {
        this.c = paramString2;
        this.a = parami;
        return;
        paramString2 = null;
      }
      paramString1 = null;
    }
  }
  
  static af a(Account paramAccount, String paramString, i parami)
  {
    if (paramAccount != null) {}
    for (paramAccount = paramAccount.name;; paramAccount = null) {
      return new af(-1L, paramString, false, paramAccount, parami);
    }
  }
  
  static af a(Bundle paramBundle, Intent paramIntent, af paramaf, i parami)
  {
    if (paramBundle == null)
    {
      paramBundle = paramaf;
      if (paramIntent != null) {
        paramBundle = a(paramIntent.getExtras(), paramaf, parami);
      }
      return paramBundle;
    }
    return a(paramBundle, paramaf, parami);
  }
  
  static af a(Bundle paramBundle, af paramaf, i parami)
  {
    if (paramBundle == null)
    {
      FinskyLog.c("Null bundle, which breaks event chain!. Creating a new logging context.", new Object[0]);
      return paramaf;
    }
    if (!paramBundle.containsKey("com.google.android.finsky.analytics.LoggingContext.KEY_LAST_EVENT_ID"))
    {
      FinskyLog.c("No LoggingContext in the bundle, which breaks event chain!. Creating a new logging context.", new Object[0]);
      return paramaf;
    }
    return new af(paramBundle.getLong("com.google.android.finsky.analytics.LoggingContext.KEY_LAST_EVENT_ID", -1L), paramBundle.getString("com.google.android.finsky.analytics.LoggingContext.KEY_REASON"), Boolean.parseBoolean(paramBundle.getString("com.google.android.finsky.analytics.LoggingContext.KEY_USE_DEFAULT_LOGGER")), paramBundle.getString("com.google.android.finsky.analytics.LoggingContext.KEY_ACCOUNT"), parami);
  }
  
  private final af a(bh parambh, aq paramaq, boolean paramBoolean)
  {
    if (paramaq != null) {
      u.b(paramaq);
    }
    if (paramBoolean) {
      return a().a(parambh, null);
    }
    return a(parambh, null);
  }
  
  static af a(String paramString, i parami)
  {
    return new af(-1L, paramString, true, null, parami);
  }
  
  @Deprecated
  private final void a(long paramLong)
  {
    try
    {
      this.d = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private final u d()
  {
    if (this.e) {
      return this.a.cV();
    }
    return this.a.d(this.c);
  }
  
  public final af a()
  {
    return new af(b(), this.b, this.e, this.c, this.a);
  }
  
  public final af a(Account paramAccount)
  {
    long l = b();
    String str = this.b;
    if (paramAccount != null) {}
    for (paramAccount = paramAccount.name;; paramAccount = null) {
      return new af(l, str, false, paramAccount, this.a);
    }
  }
  
  public final af a(d paramd)
  {
    return a(paramd.a, null);
  }
  
  public final af a(f paramf)
  {
    af localaf = this;
    if (!paramf.b()) {
      localaf = a(paramf.a(), paramf.a, false);
    }
    return localaf;
  }
  
  public final af a(g paramg)
  {
    paramg = paramg.a;
    u localu = d();
    try
    {
      a(localu.a(paramg, b()));
      return this;
    }
    finally {}
  }
  
  public final af a(z paramz)
  {
    return a(paramz.a(), null);
  }
  
  public final af a(bg parambg, p paramp)
  {
    if (parambg.d()) {}
    for (;;)
    {
      u localu = d();
      try
      {
        a(localu.a(parambg, paramp, b()));
        return this;
      }
      finally {}
      if ((TextUtils.isEmpty(parambg.aj)) && (!TextUtils.isEmpty(this.b))) {
        parambg.b(this.b);
      }
    }
  }
  
  public final af a(bh parambh, p paramp)
  {
    u localu = d();
    try
    {
      long l = b();
      u.a(parambh);
      a(localu.a(3, localu.b(parambh), paramp, l));
      return this;
    }
    finally {}
  }
  
  public final af a(bm parambm, p paramp)
  {
    u localu = d();
    try
    {
      a(localu.a(parambm, paramp, b()));
      return this;
    }
    finally {}
  }
  
  public final af a(String paramString)
  {
    return new af(b(), paramString, this.e, this.c, this.a);
  }
  
  public final void a(Intent paramIntent)
  {
    Bundle localBundle2 = paramIntent.getExtras();
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    a(localBundle1);
    paramIntent.putExtras(localBundle1);
  }
  
  public final void a(Bundle paramBundle)
  {
    paramBundle.putLong("com.google.android.finsky.analytics.LoggingContext.KEY_LAST_EVENT_ID", this.d);
    String str = this.b;
    if (str != null) {
      paramBundle.putString("com.google.android.finsky.analytics.LoggingContext.KEY_REASON", str);
    }
    paramBundle.putString("com.google.android.finsky.analytics.LoggingContext.KEY_ACCOUNT", this.c);
    paramBundle.putString("com.google.android.finsky.analytics.LoggingContext.KEY_USE_DEFAULT_LOGGER", String.valueOf(this.e));
  }
  
  public final long b()
  {
    try
    {
      long l = this.d;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final af b(f paramf)
  {
    af localaf = this;
    if (!paramf.b()) {
      localaf = a(paramf.a(), paramf.a, true);
    }
    return localaf;
  }
  
  public final af b(String paramString)
  {
    return new af(b(), this.b, false, paramString, this.a);
  }
  
  public final a c()
  {
    a locala = new a();
    long l = this.d;
    locala.b |= 0x1;
    locala.c = l;
    String str = this.b;
    if (str != null) {
      locala.a(str);
    }
    str = this.c;
    if (str != null) {
      locala.b(str);
    }
    locala.a(this.e);
    return locala;
  }
  
  public final String toString()
  {
    String str = h.a(c());
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + 2);
    localStringBuilder.append("<");
    localStringBuilder.append(str);
    localStringBuilder.append(">");
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/e/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */