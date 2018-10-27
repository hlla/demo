package com.google.android.finsky.b;

import android.support.v7.widget.eu;
import android.support.v7.widget.ev;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.de;
import com.google.android.finsky.ds.a.ka;
import com.google.android.finsky.ratereview.o;
import com.google.android.finsky.ratereview.s;
import java.util.List;

final class l
  implements OnClickListener
{
  l(j paramj, ka paramka, int paramInt, n paramn, o paramo) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.a;
    ka localka = this.d;
    int i = this.b;
    n localn = this.e;
    o localo = this.c;
    paramView.h.b(paramView.d.a.s, localka.d, localo);
    paramView.e.add(i, localn);
    paramView.b.a(i, 1);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */