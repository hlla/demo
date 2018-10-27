package com.google.android.finsky.b.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.e.f;
import com.google.android.play.layout.g;

final class d
  implements OnClickListener
{
  d(c paramc, Context paramContext, af paramaf, aq paramaq) {}
  
  public final void onClick(View paramView)
  {
    paramView = new g(this.b, this.a.a);
    Resources localResources = this.b.getResources();
    this.d.b(new f(this.c).a(238));
    paramView.a(1, localResources.getString(2131952192), true, this.a);
    paramView.a(2, localResources.getString(2131952103), true, this.a);
    this.a.a.setImageResource(2131231393);
    paramView.a = new e(this);
    paramView.a();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/b/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */