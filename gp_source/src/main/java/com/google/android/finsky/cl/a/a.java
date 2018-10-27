package com.google.android.finsky.cl.a;

import android.accounts.Account;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.v;
import android.text.TextUtils;
import android.widget.Toast;
import com.google.android.finsky.activities.inlineappinstaller.InlineConsumptionAppInstallerActivity;
import com.google.android.finsky.api.n;
import com.google.android.finsky.billing.common.PurchaseParams;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.bp;
import com.google.android.finsky.ds.a.by;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.library.r;
import com.google.android.finsky.notification.u;
import com.google.android.finsky.utils.FinskyLog;
import com.google.android.finsky.utils.ParcelableProto;
import com.google.android.finsky.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  implements com.google.android.finsky.cl.a
{
  public final com.google.android.finsky.e.a a;
  public final com.google.android.finsky.l.a b;
  public final Context c;
  public final com.google.android.finsky.bo.c d;
  public final com.google.android.finsky.cl.b e;
  public final com.google.android.finsky.library.c f;
  public final r g;
  public final PackageManager h;
  private final b.a i;
  private final h j = new b(this);
  private final h k = new g();
  private final h l = new e();
  private final h m = new f(this);
  private final h n = new c(this);
  private final u o;
  private final com.google.android.finsky.dh.a p;
  private final h q = new d(this);
  
  static
  {
    new ArrayList().add(Integer.valueOf(2));
  }
  
  public a(Context paramContext, b.a parama, com.google.android.finsky.e.a parama1, com.google.android.finsky.cl.b paramb, com.google.android.finsky.library.c paramc, com.google.android.finsky.l.a parama2, com.google.android.finsky.dh.a parama3, com.google.android.finsky.bo.c paramc1, PackageManager paramPackageManager, u paramu, r paramr)
  {
    this.c = paramContext;
    this.i = parama;
    this.a = parama1;
    this.e = paramb;
    this.f = paramc;
    this.b = parama2;
    this.p = parama3;
    this.d = paramc1;
    this.h = paramPackageManager;
    this.o = paramu;
    this.g = paramr;
  }
  
  private static boolean a(PackageManager paramPackageManager, String paramString)
  {
    boolean bool2 = false;
    paramString = paramPackageManager.getLaunchIntentForPackage(paramString);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      paramPackageManager = paramPackageManager.queryIntentActivities(paramString, 65536);
      bool1 = bool2;
      if (paramPackageManager != null)
      {
        bool1 = bool2;
        if (!paramPackageManager.isEmpty()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private final Intent b(Document paramDocument, Account paramAccount)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramDocument != null)
    {
      de localde = paramDocument.a;
      int i1 = localde.g;
      localObject1 = localObject2;
      if (localde.f != null)
      {
        switch (i1)
        {
        case 5: 
        default: 
          paramDocument = new StringBuilder(47);
          paramDocument.append("Cannot open an item from the corpus ");
          paramDocument.append(i1);
          throw new IllegalStateException(paramDocument.toString());
        }
        localObject1 = a(paramDocument, paramAccount.name);
      }
    }
    return (Intent)localObject1;
  }
  
  private final boolean c()
  {
    return a(this.h, "com.google.android.apps.books");
  }
  
  private final boolean d()
  {
    if (a(this.h, "com.google.android.videos")) {
      return this.p.a("com.google.android.videos").f >= ((Integer)com.google.android.finsky.ag.d.fA.b()).intValue();
    }
    return false;
  }
  
  private final boolean e()
  {
    if (a(this.h, "com.google.android.apps.magazines")) {
      return this.p.a("com.google.android.apps.magazines").f >= ((Integer)com.google.android.finsky.ag.d.dt.b()).intValue();
    }
    return false;
  }
  
  private final h h(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      StringBuilder localStringBuilder = new StringBuilder(27);
      localStringBuilder.append("Unknown backend ");
      localStringBuilder.append(paramInt);
      throw new IllegalStateException(localStringBuilder.toString());
    case 6: 
      return this.l;
    case 4: 
      return this.q;
    case 3: 
      return this.n;
    case 2: 
      return this.m;
    }
    return this.j;
  }
  
  private final h i(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder(28);
      localStringBuilder.append("Unknown app type ");
      localStringBuilder.append(paramInt);
      throw new IllegalStateException(localStringBuilder.toString());
    case 5: 
      return this.q;
    case 4: 
      return this.m;
    case 3: 
      return this.l;
    case 2: 
      return this.j;
    }
    return this.k;
  }
  
  public final Intent a(int paramInt, String paramString)
  {
    return h(paramInt).a(paramString);
  }
  
  public final Intent a(int paramInt, String paramString1, String paramString2)
  {
    return h(paramInt).a(paramString1, paramString2);
  }
  
  public final Intent a(Uri paramUri)
  {
    Uri localUri = paramUri;
    if (paramUri.getScheme() == null)
    {
      paramUri = String.valueOf(paramUri.toString());
      if (paramUri.length() != 0) {
        break label59;
      }
    }
    label59:
    for (paramUri = new String("http://");; paramUri = "http://".concat(paramUri))
    {
      localUri = Uri.parse(paramUri);
      paramUri = new Intent("android.intent.action.VIEW", localUri);
      paramUri.setFlags(524288);
      return paramUri;
    }
  }
  
  public final Intent a(Uri paramUri, String paramString)
  {
    paramUri = a(paramUri);
    if (!TextUtils.isEmpty(paramString)) {
      paramUri.setPackage(paramString);
    }
    return paramUri;
  }
  
  public final Intent a(Document paramDocument, String paramString)
  {
    return h(paramDocument.a.g).a(paramDocument, paramString);
  }
  
  public final Intent a(Class paramClass, String paramString1, String paramString2)
  {
    paramClass = new Intent(this.c, paramClass);
    paramClass.putExtra(paramString1, paramString2);
    return paramClass;
  }
  
  public final String a(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return null;
    case 6: 
      return "com.google.android.apps.magazines";
    case 4: 
      return "com.google.android.videos";
    case 3: 
      return "com.android.vending";
    case 2: 
      return "com.google.android.music";
    }
    return "com.google.android.apps.books";
  }
  
  public final void a(Context paramContext, aq paramaq, af paramaf, String paramString1, boolean paramBoolean, String paramString2)
  {
    a(paramContext, paramString1, paramBoolean, paramString2);
    paramaf.a(new com.google.android.finsky.e.f(paramaq).a(202));
  }
  
  public final void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/plain");
    localIntent.setFlags(524288);
    localIntent.putExtra("android.intent.extra.TEXT", paramString1);
    if (paramBoolean) {
      localIntent.putExtra("android.intent.extra.SUBJECT", this.c.getString(2131953346, new Object[] { paramString2 }));
    }
    for (;;)
    {
      paramContext.startActivity(Intent.createChooser(localIntent, paramContext.getString(2131953344, new Object[] { paramString2 })));
      return;
      localIntent.putExtra("android.intent.extra.SUBJECT", this.c.getString(2131953345, new Object[] { paramString2 }));
    }
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, v paramv, Fragment paramFragment)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = this.c;
      Toast.makeText(paramString, paramString.getString(2131952525), 0).show();
    }
    while (paramv.a("app_needed_dialog") != null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("dialog_details_url", n.a(paramString));
    paramString = new com.google.android.finsky.bb.o();
    paramString.a(paramInt1).d(2131952812).e(2131951830);
    paramString.a(paramFragment, paramInt2, localBundle);
    paramString.a().a(paramv, "app_needed_dialog");
  }
  
  public final boolean a()
  {
    if (a(this.h, "com.google.android.music")) {
      return this.p.a("com.google.android.music").f >= ((Integer)com.google.android.finsky.ag.d.fz.b()).intValue();
    }
    return false;
  }
  
  public final boolean a(int paramInt, Intent paramIntent)
  {
    if (b(paramInt))
    {
      Object localObject = this.h.queryIntentActivities(paramIntent, 65536);
      paramIntent = a(paramInt);
      if (!TextUtils.isEmpty(paramIntent))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramIntent.equals(((ResolveInfo)((Iterator)localObject).next()).activityInfo.packageName)) {
            return true;
          }
        }
        return false;
      }
      return false;
    }
    return false;
  }
  
  public final boolean a(Activity paramActivity, Intent paramIntent)
  {
    Object localObject = paramIntent.getData();
    if ((Build.VERSION.SDK_INT >= 23) && (this.d.cY().a(12611636L))) {
      paramIntent.setData(Uri.parse("https:"));
    }
    paramIntent.setComponent(null);
    List localList = this.h.queryIntentActivities(paramIntent, 0);
    paramIntent.setData((Uri)localObject);
    int i1 = 0;
    if (i1 < localList.size())
    {
      localObject = ((ResolveInfo)localList.get(i1)).activityInfo;
      if (!((ActivityInfo)localObject).packageName.equals(this.c.getPackageName())) {}
    }
    for (;;)
    {
      i1 += 1;
      break;
      paramIntent.setPackage(((ActivityInfo)localObject).packageName);
      try
      {
        paramActivity.startActivity(paramIntent);
        return true;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        FinskyLog.c("Failed to use package %s to view URI", new Object[] { ((ActivityInfo)localObject).packageName });
      }
      ((com.google.android.finsky.bb.a)this.i.a()).a(paramActivity, 2131952759).show();
      return false;
    }
  }
  
  public final boolean a(Context paramContext, Account paramAccount, Document paramDocument, v paramv, Fragment paramFragment, int paramInt, PurchaseParams paramPurchaseParams)
  {
    if (!this.d.cY().a(12650840L)) {}
    for (;;)
    {
      if (!a(paramDocument, paramAccount))
      {
        paramAccount = b(paramDocument, paramAccount);
        paramv = this.h.resolveActivity(paramAccount, 0);
        if (paramAccount == null) {
          Toast.makeText(paramContext, paramContext.getString(2131952525), 0).show();
        }
        for (;;)
        {
          if ((this.d.cY().a(12650840L)) && (paramDocument.a.g == 3)) {
            this.b.b.b(paramDocument.cC(), null);
          }
          return false;
          if (paramv == null) {
            break;
          }
          if (paramDocument.U() != null) {
            this.o.a(paramDocument.U().t);
          }
          if (paramPurchaseParams != null)
          {
            paramAccount.putExtra("backend", paramPurchaseParams.k.a);
            paramAccount.putExtra("backend_docid", paramPurchaseParams.k.b);
            paramAccount.putExtra("document_type", paramPurchaseParams.k.c);
            paramAccount.putExtra("full_docid", paramPurchaseParams.l);
            paramAccount.putExtra("calling_package", paramPurchaseParams.f);
          }
          paramContext.startActivity(paramAccount);
        }
      }
      int i1 = paramDocument.a.g;
      paramContext = l.a(paramContext, Activity.class);
      if (!this.d.cY().a(12603704L)) {
        a(a(i1), e(i1), paramInt, paramv, paramFragment);
      }
      for (;;)
      {
        return true;
        if (((i1 != 1) && (i1 != 6)) || (paramContext == null)) {
          break;
        }
        paramv = this.c;
        paramDocument = paramDocument.a;
        paramFragment = this.a.a(null);
        paramv = new Intent(paramv, InlineConsumptionAppInstallerActivity.class);
        paramv.putExtra("account", paramAccount);
        paramv.putExtra("mediaDoc", ParcelableProto.a(paramDocument));
        paramFragment.a(paramv);
        paramContext.startActivityForResult(paramv, 25);
      }
      if (paramDocument.a.g == 3)
      {
        com.google.android.finsky.l.b localb = this.b.a(paramDocument.cC(), false);
        if (localb != null)
        {
          com.google.android.finsky.cg.c localc = localb.a;
          if ((localc != null) && (localc.h != null) && (!a(paramDocument.cC(), localb.a.h))) {
            this.b.b.b(paramDocument.cC(), null);
          }
        }
      }
    }
  }
  
  public final boolean a(Intent paramIntent)
  {
    boolean bool2 = false;
    paramIntent = this.h.queryIntentActivities(paramIntent, 0);
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (!paramIntent.isEmpty()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean a(Document paramDocument, Account paramAccount)
  {
    Object localObject = a(paramDocument.a.g);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      com.google.android.finsky.dh.b localb = this.p.a((String)localObject);
      if ((localb != null) && ((!"com.google.android.videos".equals(localObject)) || (localb.f >= ((Integer)com.google.android.finsky.ag.d.fA.b()).intValue())) && ((!"com.google.android.apps.magazines".equals(localObject)) || (localb.f >= ((Integer)com.google.android.finsky.ag.d.dt.b()).intValue())))
      {
        if (paramDocument == null) {}
        by[] arrayOfby;
        do
        {
          do
          {
            paramDocument = b(paramDocument, paramAccount);
            if (paramDocument != null) {
              return a(paramDocument) ^ true;
            }
            return true;
          } while (!"com.google.android.apps.magazines".equals(localObject));
          localObject = paramDocument.a;
          arrayOfby = ((de)localObject).w;
        } while ((arrayOfby == null) || (arrayOfby.length <= 0) || (((de)localObject).r != 15) || (arrayOfby[0].b) || (localb.f >= ((Integer)com.google.android.finsky.ag.d.fS.b()).intValue()));
      }
      return true;
    }
    return false;
  }
  
  public final boolean a(String paramString1, String paramString2)
  {
    return a(new Intent("android.intent.action.VIEW", Uri.parse(paramString2)).setPackage(paramString1));
  }
  
  public final Intent b(int paramInt, String paramString)
  {
    return i(paramInt).a(paramString);
  }
  
  public final Intent b(int paramInt, String paramString1, String paramString2)
  {
    return i(paramInt).a(paramString1, paramString2);
  }
  
  public final Intent b(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("authAccount");
    localObject = a(j.a(this.c), "authAccount", (String)localObject);
    ((Intent)localObject).setData(paramIntent.getData());
    ((Intent)localObject).setAction("android.intent.action.VIEW");
    return (Intent)localObject;
  }
  
  public final Intent b(Uri paramUri)
  {
    paramUri = new Intent("android.intent.action.SENDTO", paramUri);
    paramUri.setFlags(524288);
    return paramUri;
  }
  
  public final Intent b(Uri paramUri, String paramString)
  {
    Uri localUri = paramUri;
    if (paramUri != null) {
      localUri = Uri.parse(paramUri.toString().trim());
    }
    paramUri = new Intent("android.intent.action.VIEW", localUri);
    paramUri.setPackage("com.google.android.youtube");
    paramUri.putExtra("authAccount", paramString);
    paramUri.putExtra("force_fullscreen", true);
    paramUri.putExtra("finish_on_ended", true);
    paramUri.putExtra("app_package", "com.android.vending");
    paramUri.setFlags(524288);
    return c(paramUri);
  }
  
  public final Intent b(Document paramDocument, String paramString)
  {
    return h(paramDocument.a.g).b(paramDocument, paramString);
  }
  
  public final Intent b(Class paramClass, String paramString1, String paramString2)
  {
    paramClass = new Intent(this.c, paramClass);
    paramClass.setData(new Builder().scheme(paramString1).authority(paramString2).build());
    return paramClass;
  }
  
  public final Intent b(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    Builder localBuilder = new Builder();
    localBuilder.scheme("market");
    localBuilder.authority("details");
    localBuilder.appendQueryParameter("id", paramString1);
    localBuilder.appendQueryParameter("url", paramString2);
    localIntent.setData(localBuilder.build());
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.setPackage("com.android.vending");
    return localIntent;
  }
  
  public final String b()
  {
    if (this.d.cY().a(12620775L)) {
      return (String)com.google.android.finsky.ag.d.fD.b();
    }
    return (String)com.google.android.finsky.ag.d.fE.b();
  }
  
  public final boolean b(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 5: 
    default: 
      return false;
    case 6: 
      return e();
    case 4: 
      return d();
    case 2: 
      return a();
    }
    return c();
  }
  
  public final boolean b(int paramInt, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (c(paramInt))
      {
        Object localObject = this.h.queryIntentActivities(paramIntent, 65536);
        paramIntent = d(paramInt);
        if (!TextUtils.isEmpty(paramIntent))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            if (paramIntent.equals(((ResolveInfo)((Iterator)localObject).next()).activityInfo.packageName)) {
              return true;
            }
          }
          return false;
        }
        return false;
      }
      return false;
    }
    return false;
  }
  
  public final Intent c(Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (this.h.resolveActivity(paramIntent, 65536) == null)
    {
      localIntent = new Intent(paramIntent.getAction(), paramIntent.getData());
      localIntent.setFlags(paramIntent.getFlags());
    }
    return localIntent;
  }
  
  public final Intent c(Uri paramUri, String paramString)
  {
    if ((a(this.h, "com.google.android.videos")) && (this.p.a("com.google.android.videos").f >= ((Integer)com.google.android.finsky.ag.d.lc.b()).intValue()))
    {
      paramUri = new Intent("com.google.android.videos.intent.action.trailers.VIEW", paramUri);
      paramUri.putExtra("authAccount", paramString);
      paramUri.setPackage("com.google.android.videos");
      paramUri.setFlags(524288);
      return c(paramUri);
    }
    return b(paramUri, paramString);
  }
  
  public final boolean c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      if (a(this.h, "com.google.android.play.games")) {
        return this.p.a("com.google.android.play.games").f >= ((Integer)com.google.android.finsky.ag.d.fy.b()).intValue();
      }
      return false;
    case 5: 
      return d();
    case 4: 
      return a();
    case 3: 
      return e();
    }
    return c();
  }
  
  public final boolean c(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (b(2))
    {
      paramString1 = a(2, paramString1, paramString2);
      paramString1 = this.h.queryIntentActivities(paramString1, 65536);
      bool1 = bool2;
      if (paramString1 != null)
      {
        bool1 = bool2;
        if (!paramString1.isEmpty()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final Intent d(String paramString1, String paramString2)
  {
    return a(2, paramString1, paramString2);
  }
  
  public final String d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 5: 
      return "com.google.android.videos";
    case 4: 
      return "com.google.android.music";
    case 3: 
      return "com.google.android.apps.magazines";
    case 2: 
      return "com.google.android.apps.books";
    }
    return "com.google.android.play.games";
  }
  
  public final int e(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 5: 
    case 7: 
    case 8: 
    default: 
      return -1;
    case 9: 
      return 2131952366;
    case 6: 
      return 2131952732;
    case 4: 
      return 2131953592;
    case 2: 
      return 2131952639;
    }
    return 2131951816;
  }
  
  public final int f(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 5: 
      return 2131953592;
    case 4: 
      return 2131952639;
    case 3: 
      return 2131952732;
    case 2: 
      return 2131951816;
    }
    return 2131952345;
  }
  
  public final int g(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return e(paramInt);
    case 6: 
      return 2131952733;
    }
    return 2131951817;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cl/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */