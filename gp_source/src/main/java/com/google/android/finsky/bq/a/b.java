package com.google.android.finsky.bq.a;

import android.content.Intent;
import com.google.android.finsky.e.af;
import com.google.android.finsky.navigationmanager.c;

final class b
  implements Runnable
{
  b(a parama, Intent paramIntent, c paramc, af paramaf) {}
  
  public final void run()
  {
    Object localObject = this.b;
    if (localObject != null) {}
    for (localObject = ((Intent)localObject).getStringExtra("completionRedirectUrl");; localObject = null)
    {
      if (localObject != null) {
        this.d.c((String)localObject, this.c);
      }
      while (!this.d.B()) {
        return;
      }
      this.d.a(this.a.a.a, this.c);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bq/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */