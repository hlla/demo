package com.google.android.finsky.bq.a;

import android.accounts.Account;
import android.support.v4.app.Fragment;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.android.volley.w;
import com.android.volley.x;
import com.google.android.finsky.bq.a;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.de;
import java.util.Iterator;
import java.util.Set;

final class f
  implements w, x
{
  public final Account a;
  public final Fragment b;
  public final a c;
  
  public f(e parame, Fragment paramFragment, Account paramAccount, a parama)
  {
    this.b = paramFragment;
    this.a = paramAccount;
    this.c = parama;
  }
  
  public final void a(VolleyError paramVolleyError)
  {
    paramVolleyError = this.d.g.iterator();
    while (paramVolleyError.hasNext())
    {
      com.google.android.finsky.bq.e locale = (com.google.android.finsky.bq.e)paramVolleyError.next();
      if ((this.b.s_()) && (locale.a(this.a.name, this.c.a.a.s))) {
        if (this.c.b) {
          break label115;
        }
      }
    }
    label115:
    for (int i = 2131952287;; i = 2131952285)
    {
      Toast.makeText(this.b.by_(), i, 1).show();
      paramVolleyError = this.c;
      paramVolleyError.b ^= true;
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bq/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */