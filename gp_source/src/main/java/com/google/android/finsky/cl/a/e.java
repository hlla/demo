package com.google.android.finsky.cl.a;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.de;

final class e
  extends h
{
  private final Uri a = new Builder().scheme("http").authority("play.google.com").appendPath("magazines").appendPath("reader").build();
  private final Uri b = this.a.buildUpon().appendPath("home").appendPath("carousel").build();
  private final Uri c = this.a.buildUpon().appendPath("issue").build();
  private final Uri d = this.a.buildUpon().appendPath("news").build();
  private final Uri e = this.a.buildUpon().appendPath("verify_subscription").build();
  
  e()
  {
    super((byte)0);
  }
  
  private static Intent b()
  {
    return new Intent("android.intent.action.VIEW").setPackage("com.google.android.apps.magazines");
  }
  
  public final Intent a(Document paramDocument, String paramString)
  {
    Intent localIntent = b();
    de localde = paramDocument.a;
    int i = localde.r;
    if (i == 15)
    {
      paramDocument = Uri.parse(localde.q).getQueryParameter("doc");
      localIntent.setData(this.e.buildUpon().appendPath(paramDocument.substring(paramDocument.indexOf("-") + 1)).build());
    }
    for (;;)
    {
      localIntent.setFlags(268435456);
      localIntent.addFlags(67108864);
      a(localIntent, "authAccount", paramString);
      return localIntent;
      if (i == 24) {}
      while (i == 25)
      {
        localIntent.setData(this.d.buildUpon().appendPath(paramDocument.a.f).build());
        break;
      }
      localIntent.setData(this.c.buildUpon().appendPath(paramDocument.a.f).build());
    }
  }
  
  public final Intent a(String paramString)
  {
    Intent localIntent = b();
    localIntent.setData(this.b);
    localIntent.setFlags(268435456);
    localIntent.addFlags(67108864);
    a(localIntent, "authAccount", paramString);
    return localIntent;
  }
  
  public final String a()
  {
    return "com.google.android.apps.magazines";
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cl/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */