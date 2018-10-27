package com.google.android.finsky.cl.a;

import android.content.Intent;
import android.content.pm.PackageManager;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.de;

final class f
  extends h
{
  f(a parama)
  {
    super((byte)0);
  }
  
  public final Intent a(Document paramDocument, String paramString)
  {
    Intent localIntent = new Intent("com.google.android.music.PLAY");
    localIntent.putExtra("storeId", paramDocument.a.f);
    a(localIntent, "authAccount", paramString);
    localIntent.setFlags(268435456);
    return localIntent;
  }
  
  public final Intent a(String paramString)
  {
    Intent localIntent = this.a.h.getLaunchIntentForPackage("com.google.android.music");
    localIntent.setAction("android.intent.action.VIEW");
    a(localIntent, "authAccount", paramString);
    localIntent.setFlags(268435456);
    return localIntent;
  }
  
  public final String a()
  {
    return "com.google.android.music";
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cl/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */