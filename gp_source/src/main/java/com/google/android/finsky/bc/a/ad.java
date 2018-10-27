package com.google.android.finsky.bc.a;

import android.widget.EditText;
import com.google.android.finsky.be.x;
import com.google.android.finsky.bw.t;
import com.google.wireless.android.finsky.dfe.e.a.de;
import com.google.wireless.android.finsky.dfe.e.a.df;

final class ad
  implements x
{
  ad(aa paramaa, boolean paramBoolean, EditText paramEditText) {}
  
  public final void a()
  {
    Object localObject = this.a.a;
    if ((((de)localObject).b) && (!this.b))
    {
      localObject = ((de)localObject).d;
      if ((localObject != null) && (((df)localObject).d())) {
        t.a(this.c.getContext(), this.c, this.a.a.d.e);
      }
    }
    else
    {
      return;
    }
    t.a(this.c.getContext(), this.c);
  }
  
  public final void a(String paramString)
  {
    if (paramString != null) {
      this.c.setText(paramString);
    }
  }
  
  public final void b()
  {
    t.a(this.c.getContext(), this.c);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */