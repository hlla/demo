package com.google.android.finsky.c;

import android.net.Uri;
import android.text.TextUtils;
import com.android.volley.NoConnectionError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.m;
import com.android.volley.w;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.e.u;
import com.google.android.finsky.externalreferrer.f;
import com.google.android.finsky.utils.FinskyLog;
import java.util.Map;

final class a
  implements w
{
  public final Document a;
  public final com.google.android.finsky.e.i b;
  private final String c;
  private final com.google.android.finsky.api.i d;
  private final f e;
  
  a(Document paramDocument, String paramString, com.google.android.finsky.api.i parami, com.google.android.finsky.e.i parami1, f paramf)
  {
    this.a = paramDocument;
    this.c = paramString;
    this.d = parami;
    this.b = parami1;
    this.e = paramf;
  }
  
  public final void a(VolleyError paramVolleyError)
  {
    Object localObject = paramVolleyError.b;
    if ((localObject != null) && (((m)localObject).f == 302) && (((m)localObject).c.containsKey("Location")))
    {
      localObject = (String)((m)localObject).c.get("Location");
      paramVolleyError = new com.google.android.finsky.e.d(1100).a(this.a.a.s);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        FinskyLog.d("Empty Location header from 302 URL: %s", new Object[] { FinskyLog.a(this.c) });
        this.b.cV().a(paramVolleyError.a, null, -1L);
        return;
      }
      localObject = Uri.parse((String)localObject).getQueryParameter("referrer");
      paramVolleyError.e((String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.e.a((String)localObject, null, this.a.c(), "adclick");
      }
      for (;;)
      {
        this.d.a().b(this.a.a.s, (String)localObject, new b(this, (String)localObject), new c(this));
        break;
        FinskyLog.c("Missing referrer in location header field for URL[%s]", new Object[] { FinskyLog.a(this.c) });
      }
    }
    if ((paramVolleyError instanceof NoConnectionError)) {
      FinskyLog.c("No connection error or timeout error", new Object[0]);
    }
    for (;;)
    {
      paramVolleyError = new com.google.android.finsky.e.d(1107).a(this.a.a.s).a(1).a(paramVolleyError);
      this.b.cV().a(paramVolleyError.a, null, -1L);
      return;
      if ((paramVolleyError instanceof TimeoutError)) {
        break;
      }
      FinskyLog.d("Unexpected error response for URL[%s], docid[%s]: %s", new Object[] { FinskyLog.a(this.c), this.a.a.s, paramVolleyError.getMessage() });
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */