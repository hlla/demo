package com.google.android.finsky.cl.a;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.de;

final class d
  extends h
{
  private final Uri a = new Builder().scheme("http").authority("play.google.com").appendPath("movies").appendPath("shows").build();
  
  d(a parama)
  {
    super((byte)0);
  }
  
  private static String b(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1.startsWith(paramString2)) {
      str = paramString1.substring(paramString2.length());
    }
    return str;
  }
  
  public final Intent a(Document paramDocument, String paramString)
  {
    paramDocument = paramDocument.a;
    if (paramDocument.g == 4) {}
    for (paramDocument = paramDocument.h;; paramDocument = null)
    {
      paramDocument = new Intent("com.google.android.videos.intent.action.VIEW", Uri.parse(paramDocument));
      paramDocument.setPackage("com.google.android.videos");
      paramDocument.setFlags(268451840);
      a(paramDocument, "authAccount", paramString);
      return paramDocument;
    }
  }
  
  public final Intent a(String paramString)
  {
    Intent localIntent = this.b.h.getLaunchIntentForPackage("com.google.android.videos");
    localIntent.setAction("android.intent.action.MAIN");
    localIntent.setFlags(268435456);
    localIntent.addFlags(67108864);
    a(localIntent, "authAccount", paramString);
    return localIntent;
  }
  
  public final String a()
  {
    return "com.google.android.videos";
  }
  
  public final Intent b(Document paramDocument, String paramString)
  {
    paramString = a(paramString);
    Object localObject1 = paramDocument.a;
    if (((de)localObject1).r == 20)
    {
      Object localObject2 = Uri.parse(((de)localObject1).q);
      localObject1 = b(((Uri)localObject2).getQueryParameter("doc"), "tvshow-");
      localObject2 = b(((Uri)localObject2).getQueryParameter("cdid"), "tvseason-");
      paramString.setData(this.a.buildUpon().appendQueryParameter("dl", "true").appendQueryParameter("v", paramDocument.a.f).appendQueryParameter("se", (String)localObject2).appendQueryParameter("sh", (String)localObject1).build());
      return paramString;
    }
    paramString.putExtra("download_video_id", ((de)localObject1).f);
    return paramString;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cl/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */