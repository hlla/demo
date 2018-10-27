package com.google.android.finsky.q;

import android.content.Intent;
import android.content.RestrictionsManager;
import android.os.Build.VERSION;
import android.support.v4.app.o;
import com.google.android.finsky.ba.d;
import com.google.android.finsky.ba.e;
import com.google.android.finsky.bo.c;
import com.google.android.finsky.bo.f;
import com.google.android.finsky.cl.b;

final class j
  implements e
{
  j(a parama, boolean paramBoolean) {}
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Object localObject;
      if ((((c)this.a.W.a()).cY().a(12603770L)) && (Build.VERSION.SDK_INT >= 21))
      {
        if (!((RestrictionsManager)this.a.getSystemService("restrictions")).hasRestrictionsProvider())
        {
          localObject = this.a;
          ((a)localObject).startActivity(((b)((a)localObject).i_.a()).d(this.a));
          this.a.finish();
          return;
        }
        localObject = ((d)this.a.al.a()).a(this.a);
        if (localObject != null) {
          this.a.startActivityForResult((Intent)localObject, 24);
        }
      }
      else
      {
        localObject = this.a;
        ((a)localObject).startActivity(((b)((a)localObject).i_.a()).d(this.a));
        this.a.finish();
        return;
      }
    }
    this.a.g(this.b);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/q/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */