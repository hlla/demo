package com.google.android.finsky.bc.a;

import com.google.android.finsky.be.t;
import com.google.android.finsky.be.w;
import com.google.android.finsky.dialogbuilderlayout.DateSpinner;
import com.google.android.finsky.dialogbuilderlayout.f;
import com.google.android.finsky.utils.n;
import com.google.android.play.layout.PlayTextView;
import com.google.wireless.android.finsky.dfe.e.a.ck;
import java.util.Calendar;

final class k
  implements f
{
  k(j paramj) {}
  
  public final void T()
  {
    if (this.a.a.a()) {
      this.a.c.setVisibility(4);
    }
    Object localObject1 = this.a;
    com.google.android.finsky.be.j localj = ((j)localObject1).d;
    Object localObject2 = ((j)localObject1).b;
    String str = ((ck)localObject2).c;
    localObject2 = ((ck)localObject2).b;
    localj.a = ((j)localObject1).a.getCalendarDate();
    localObject1 = localj.b;
    if (localj.a != null) {}
    for (boolean bool = true;; bool = false)
    {
      ((t)localObject1).a((String)localObject2, bool);
      localObject1 = localj.a;
      if (localObject1 == null)
      {
        localj.c.a(str);
        return;
      }
      localj.c.a(str, n.a(((Calendar)localObject1).getTime()));
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */