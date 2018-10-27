package com.google.android.finsky.be;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.android.volley.w;
import com.google.android.finsky.api.d;
import com.google.android.finsky.billing.common.PurchaseParams;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.dfemodel.e;
import com.google.android.finsky.dfemodel.g;
import com.google.android.finsky.dfemodel.h;
import com.google.android.finsky.dfemodel.v;
import com.google.android.finsky.utils.FinskyLog;
import com.google.common.base.a;
import com.google.common.base.u;

public final class n
  implements w, v
{
  public final boolean a;
  public final Context b;
  public final u c;
  public u d;
  public o e;
  public Toast f;
  
  public n(boolean paramBoolean, Context paramContext, d paramd, PurchaseParams paramPurchaseParams, Bundle paramBundle)
  {
    if ((paramBundle != null) && (paramBundle.containsKey("DialogFetchDocumentModel.doc"))) {}
    for (this.d = u.b((Document)paramBundle.get("DialogFetchDocumentModel.doc"));; this.d = u.c(paramPurchaseParams.m))
    {
      this.a = paramBoolean;
      this.b = paramContext;
      if (b())
      {
        new h();
        this.c = u.b(h.b(paramd, paramPurchaseParams.l));
        ((e)this.c.b()).a(this);
        ((e)this.c.b()).a(this);
        return;
      }
      this.c = a.a;
      return;
    }
  }
  
  private final void c()
  {
    Toast localToast = this.f;
    if (localToast != null) {
      localToast.cancel();
    }
  }
  
  public final u a()
  {
    if (!this.d.a()) {
      FinskyLog.e("asyncFetchDocument must be called before getDocument.", new Object[0]);
    }
    return this.d;
  }
  
  public final void a(VolleyError paramVolleyError)
  {
    c();
    this.e.a(paramVolleyError);
  }
  
  public final boolean b()
  {
    Document localDocument;
    if (this.d.a()) {
      localDocument = (Document)this.d.b();
    }
    return (localDocument.U() == null) || (localDocument.U().u.length == 0);
  }
  
  public final void e()
  {
    c();
    if (((e)this.c.b()).c() == null)
    {
      FinskyLog.e("Document is null after the backend fetch.", new Object[0]);
      return;
    }
    this.d = u.b(((e)this.c.b()).c());
    o localo = this.e;
    this.d.b();
    localo.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/be/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */