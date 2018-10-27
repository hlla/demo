package com.google.android.finsky.a;

import android.accounts.Account;
import android.content.Context;
import android.net.Uri;
import android.support.v4.app.v;
import android.support.v4.widget.u;
import android.text.TextUtils;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.google.android.finsky.accounts.b;
import com.google.android.finsky.e.af;
import com.google.android.finsky.frameworkviews.ad;
import com.google.android.finsky.frameworkviews.ae;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.t;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public static final int a = "ACCOUNT_MISMATCH".hashCode();
  public final com.google.android.finsky.accounts.c b;
  public final Context c;
  public final com.google.android.finsky.drawer.a d;
  public final b.a e;
  public final com.google.android.finsky.bo.c f;
  public final v g;
  public af h;
  public g i;
  public final com.google.android.finsky.navigationmanager.c j;
  public int k = 0;
  public final com.google.android.finsky.ev.a l;
  public boolean m = false;
  private final com.google.android.finsky.accounts.a n;
  private b o;
  private u p;
  private com.google.android.finsky.navigationmanager.d q;
  private OnDismissListener r;
  
  public a(Context paramContext, com.google.android.finsky.accounts.a parama, com.google.android.finsky.accounts.c paramc, com.google.android.finsky.ev.a parama1, com.google.android.finsky.bo.c paramc1, b.a parama2, com.google.android.finsky.drawer.a parama3, com.google.android.finsky.navigationmanager.c paramc2, v paramv)
  {
    this.c = paramContext;
    this.n = parama;
    this.b = paramc;
    this.l = parama1;
    this.d = parama3;
    this.j = paramc2;
    this.f = paramc1;
    this.e = parama2;
    this.g = paramv;
  }
  
  private static String a(Uri paramUri)
  {
    String str = null;
    if (paramUri != null) {}
    try
    {
      str = paramUri.getQueryParameter("ah");
      return str;
    }
    catch (Exception localException)
    {
      FinskyLog.d("Error parsing account hash uri: %s", new Object[] { paramUri });
    }
    return null;
  }
  
  public final String a(String paramString, Uri paramUri)
  {
    Object localObject = paramString;
    if (paramString == null)
    {
      paramString = a(paramUri);
      if ((TextUtils.isEmpty(paramString)) || (!"1".equals(paramUri.getQueryParameter("amb")))) {
        break label118;
      }
      paramUri = this.b.cQ();
      if (TextUtils.isEmpty(paramString)) {
        break label113;
      }
      paramUri = paramUri.iterator();
      while (paramUri.hasNext())
      {
        localObject = (Account)paramUri.next();
        if (t.a(((Account)localObject).name.getBytes()).equals(paramString)) {
          paramString = ((Account)localObject).name;
        }
      }
    }
    for (;;)
    {
      localObject = paramString;
      if (paramString == null) {
        localObject = "UNKNOWN_ACCOUNT";
      }
      return (String)localObject;
      paramString = null;
      continue;
      label113:
      paramString = null;
    }
    label118:
    return null;
  }
  
  public final void a()
  {
    if (this.o == null)
    {
      this.o = new d(this);
      this.q = new e(this);
      this.p = new f(this);
      this.r = new c(this);
    }
    this.d.a(this.p);
    this.j.a(this.q);
    this.n.a(this.o);
    Object localObject = (j)this.e.a();
    OnDismissListener localOnDismissListener = this.r;
    ((j)localObject).b = localOnDismissListener;
    localObject = ((j)localObject).a;
    if (localObject != null) {
      ((ad)localObject).a(localOnDismissListener);
    }
  }
  
  public final void a(int paramInt)
  {
    af localaf = this.h;
    if (localaf == null)
    {
      FinskyLog.e("Null logging context while trying to log state change: %d", new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    localaf.a(new com.google.android.finsky.e.d(paramInt).a, null);
  }
  
  public final void b()
  {
    int i1 = this.k;
    if (i1 != 0) {
      if (i1 == 2) {
        break label105;
      }
    }
    for (;;)
    {
      this.k = 0;
      this.m = false;
      this.i = null;
      Object localObject = ((j)this.e.a()).a;
      if (localObject != null)
      {
        localObject = ((ad)localObject).a.g;
        if (localObject != null) {
          ((PopupWindow)localObject).dismiss();
        }
      }
      this.n.b(this.o);
      this.d.b(this.p);
      this.j.b(this.q);
      return;
      label105:
      a(4055);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */