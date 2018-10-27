package com.google.android.play.dfe.api;

import android.net.Uri;
import com.android.volley.n;
import com.android.volley.w;
import com.android.volley.x;

public abstract interface d
{
  public static final Uri a = Uri.parse("https://android.clients.google.com/fdfe/");
  public static final Uri b = Uri.parse("api/plusProfile");
  public static final Uri c = Uri.parse("api/userProfile");
  
  static
  {
    Uri.parse("api/experiments");
    Uri.parse("api/searchSuggest");
  }
  
  public abstract n a(x paramx, w paramw);
  
  public abstract n a(x paramx, w paramw, boolean paramBoolean);
  
  public abstract void a();
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/play/dfe/api/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */