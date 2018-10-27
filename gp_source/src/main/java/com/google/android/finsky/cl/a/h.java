package com.google.android.finsky.cl.a;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.finsky.dfemodel.Document;

abstract class h
{
  static final void a(Intent paramIntent, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      paramIntent.putExtra(paramString1, paramString2);
    }
  }
  
  public abstract Intent a(Document paramDocument, String paramString);
  
  public abstract Intent a(String paramString);
  
  protected Intent a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(paramString1));
    localIntent.setPackage(a());
    a(localIntent, "authAccount", paramString2);
    return localIntent;
  }
  
  public abstract String a();
  
  public Intent b(Document paramDocument, String paramString)
  {
    return a(paramDocument, paramString);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/cl/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */