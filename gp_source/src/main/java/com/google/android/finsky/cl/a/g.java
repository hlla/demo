package com.google.android.finsky.cl.a;

import android.content.Intent;
import com.google.android.finsky.dfemodel.Document;

final class g
  extends h
{
  g()
  {
    super((byte)0);
  }
  
  private final Intent b(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    a(localIntent, "authAccount", paramString);
    localIntent.setFlags(268435456);
    localIntent.setPackage(a());
    return localIntent;
  }
  
  public final Intent a(Document paramDocument, String paramString)
  {
    return b(paramString);
  }
  
  public final Intent a(String paramString)
  {
    return b(paramString);
  }
  
  protected final Intent a(String paramString1, String paramString2)
  {
    return b(paramString2);
  }
  
  public final String a()
  {
    return "com.google.android.play.games";
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cl/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */