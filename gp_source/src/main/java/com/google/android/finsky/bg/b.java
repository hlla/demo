package com.google.android.finsky.bg;

import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.finsky.dfemodel.Document;
import com.google.android.finsky.ds.a.o;
import com.google.android.finsky.e.af;
import com.google.android.finsky.e.aq;
import com.google.android.finsky.e.f;
import com.google.android.finsky.waitforwifi.d;
import com.google.android.finsky.waitforwifi.g;

final class b
  implements OnClickListener
{
  b(a parama, af paramaf, aq paramaq, Document paramDocument, View paramView) {}
  
  public final void onClick(View paramView)
  {
    this.d.a(new f(this.e).a(2911));
    paramView = this.a.a;
    Document localDocument = this.b;
    View localView = this.c;
    if (!paramView.a(localDocument))
    {
      paramView.a(localDocument.U().t);
      localView.setVisibility(8);
      return;
    }
    d.a(localView.getContext(), new g(paramView, localDocument, localView));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bg/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */