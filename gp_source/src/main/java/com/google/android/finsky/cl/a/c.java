package com.google.android.finsky.cl.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.finsky.api.n;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.o;

final class c
  extends h
{
  c(a parama)
  {
    super((byte)0);
  }
  
  private final Intent a(Document paramDocument, String paramString1, String paramString2)
  {
    Intent localIntent = this.a.h.getLaunchIntentForPackage("com.android.vending");
    localIntent.setAction(paramString1);
    localIntent.setFlags(268435456);
    a(localIntent, "account", paramString2);
    localIntent.putExtra("asset_package", paramDocument.U().t);
    return localIntent;
  }
  
  public final Intent a(Document paramDocument, String paramString)
  {
    String str = paramDocument.U().t;
    Object localObject1 = this.a.b.a(str, false);
    if (localObject1 != null)
    {
      localObject1 = ((com.google.android.finsky.l.b)localObject1).a;
      if (localObject1 != null) {
        localObject1 = ((com.google.android.finsky.cg.c)localObject1).h;
      }
    }
    for (;;)
    {
      a locala = this.a;
      PackageManager localPackageManager = locala.h;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      for (Object localObject2 = locala.c(locala.b(str, (String)localObject1));; localObject2 = null)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          if (!com.google.android.finsky.ba.a.b(locala.c)) {
            break label172;
          }
        }
        label172:
        for (localObject2 = localPackageManager.getLeanbackLaunchIntentForPackage(str);; localObject2 = localPackageManager.getLaunchIntentForPackage(str))
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = locala.e.a(locala.c, str, n.a(str), locala.a.a(null));
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = a(paramDocument, "android.intent.action.RUN", paramString);
          }
          ((Intent)localObject2).setFlags(268435456);
          return (Intent)localObject2;
        }
      }
      localObject1 = null;
      continue;
      localObject1 = null;
    }
  }
  
  public final Intent a(String paramString)
  {
    Intent localIntent = new Intent("com.google.android.finsky.VIEW_MY_DOWNLOADS");
    Context localContext = this.a.c;
    localIntent.setClass(localContext, j.a(localContext));
    localIntent.setFlags(268435456);
    a(localIntent, "account", paramString);
    return localIntent;
  }
  
  public final String a()
  {
    return "com.android.vending";
  }
  
  public final Intent b(Document paramDocument, String paramString)
  {
    return a(paramDocument, "android.intent.action.VIEW", paramString);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cl/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */