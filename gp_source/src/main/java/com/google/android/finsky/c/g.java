package com.google.android.finsky.c;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.android.volley.n;
import com.android.volley.r;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.utils.FinskyLog;

final class g
  implements Runnable
{
  g(f paramf, Context paramContext, Document paramDocument, String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    f localf = this.a;
    Context localContext = this.d;
    Document localDocument = this.e;
    Object localObject2 = this.c;
    String str1 = this.b;
    String str2 = this.f;
    Object localObject1 = localObject2;
    if (localf.d.a())
    {
      localObject1 = Uri.parse((String)localObject2).buildUpon().appendQueryParameter("nb", str1).appendQueryParameter("dim", str2).build();
      localObject1 = localf.d.a((Uri)localObject1, localContext).toString();
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      FinskyLog.d("Empty URL for docid: %s", new Object[] { localDocument.a.s });
      return;
    }
    localObject2 = localf.a;
    localObject1 = new e(localContext, (String)localObject1, new d((String)localObject1, ((i)localObject2).b), new a(localDocument, (String)localObject1, ((i)localObject2).a, ((i)localObject2).b, ((i)localObject2).c), new com.android.volley.f(2500, 1, 1.0F), ((i)localObject2).b);
    localf.e.a((n)localObject1);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */