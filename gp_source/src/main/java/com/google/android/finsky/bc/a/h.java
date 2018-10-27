package com.google.android.finsky.bc.a;

import android.support.v4.g.a;
import android.support.v4.g.v;
import android.text.TextUtils;
import com.google.android.finsky.be.t;
import com.google.android.finsky.be.w;
import com.google.android.finsky.dialogbuilderlayout.CheckedView;
import com.google.android.finsky.dialogbuilderlayout.b;
import com.google.wireless.android.finsky.dfe.e.a.cf;
import com.google.wireless.android.finsky.dfe.e.a.du;
import com.google.wireless.android.finsky.dfe.e.a.ee;

final class h
  implements b
{
  public final a a = new a();
  private boolean b = false;
  
  h(g paramg) {}
  
  public final void a(CheckedView paramCheckedView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = ((Integer)this.a.get(Integer.valueOf(paramCheckedView.getId()))).intValue();
      Object localObject = this.c.a;
      paramCheckedView = localObject.e[i];
      if (!TextUtils.isEmpty(((cf)localObject).f))
      {
        localObject = this.c;
        ((g)localObject).c.a(((g)localObject).a.f, paramCheckedView.h);
      }
      a(paramCheckedView, true);
    }
  }
  
  final void a(du paramdu, boolean paramBoolean)
  {
    if ((paramdu.b.i != null) && (!TextUtils.isEmpty(this.c.a.d)))
    {
      this.b |= paramBoolean;
      paramdu = this.c;
      paramdu.b.a(paramdu.a.d, this.b);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */