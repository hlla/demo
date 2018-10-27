package com.google.android.finsky.b;

import android.support.design.snackbar.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.eu;
import com.google.android.finsky.dfemodel.w;
import com.google.android.finsky.ds.a.ka;
import com.google.android.finsky.layout.ReviewItemLayout;
import com.google.android.finsky.layout.be;
import com.google.android.finsky.navigationmanager.c;
import com.google.android.finsky.ratereview.o;
import java.util.List;

final class k
  implements be
{
  k(j paramj, ka paramka, ReviewItemLayout paramReviewItemLayout, n paramn) {}
  
  public final void a()
  {
    j localj = this.a;
    ka localka = this.b;
    localj.g.a(localj.d, localka, localj.f);
  }
  
  public final void a(ReviewItemLayout paramReviewItemLayout)
  {
    j localj = this.a;
    ka localka = this.b;
    localj.a(paramReviewItemLayout, o.a, localka);
    Snackbar.a(paramReviewItemLayout, 2131953199, 0).d();
  }
  
  public final void a(ReviewItemLayout paramReviewItemLayout, o paramo)
  {
    this.d.setReviewFeedbackActionListener(null);
    j localj = this.a;
    n localn = this.c;
    ka localka = (ka)localj.c.a(localn.a, true);
    int i = localj.e.indexOf(localn);
    localj.a(paramReviewItemLayout, paramo, localka);
    localj.e.remove(i);
    Snackbar.a(paramReviewItemLayout, 2131953199, 0).a(2131953200, new l(localj, localka, i, localn, paramo)).d();
    localj.e(i);
  }
  
  public final void b(ReviewItemLayout paramReviewItemLayout)
  {
    j localj = this.a;
    ka localka = this.b;
    localj.a(paramReviewItemLayout, o.c, localka);
    Snackbar.a(paramReviewItemLayout, 2131953199, 0).d();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */