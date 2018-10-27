package com.google.android.gms.ads.internal.x;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import com.google.android.gms.ads.internal.q.a.a;
import java.util.Collections;
import java.util.Map;

@a
public final class l
{
  public final Map a;
  public final Uri b;
  public final String c;
  
  @TargetApi(21)
  public l(WebResourceRequest paramWebResourceRequest)
  {
    this(str, localUri, paramWebResourceRequest.getRequestHeaders());
  }
  
  public l(String paramString)
  {
    this(paramString, Uri.parse(paramString), null);
  }
  
  private l(String paramString, Uri paramUri, Map paramMap)
  {
    this.c = paramString;
    this.b = paramUri;
    paramString = paramMap;
    if (paramMap == null) {
      paramString = Collections.emptyMap();
    }
    this.a = paramString;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/x/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */