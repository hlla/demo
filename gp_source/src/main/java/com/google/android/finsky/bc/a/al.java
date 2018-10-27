package com.google.android.finsky.bc.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.be.d;
import com.google.android.finsky.be.t;
import com.google.wireless.android.finsky.dfe.e.a.dw;

public final class al
  extends m
{
  private final dw a;
  private final t b;
  
  public al(LayoutInflater paramLayoutInflater, dw paramdw, t paramt)
  {
    super(paramLayoutInflater);
    this.a = paramdw;
    this.b = paramt;
  }
  
  public final int a()
  {
    if (this.a.c != null) {
      return 2131625306;
    }
    return 2131625280;
  }
  
  public final void a(d paramd, View paramView)
  {
    Object localObject = this.a;
    if (((dw)localObject).c != null)
    {
      localObject = (Button)paramView.findViewById(2131428905);
      this.e.a(this.a.b, (Button)localObject, paramd);
      this.e.a(this.a.c, (Button)paramView.findViewById(2131429180), paramd);
    }
    for (paramd = (d)localObject;; paramd = paramView)
    {
      paramView = this.a.a;
      if ((paramView != null) && (paramView.length > 0)) {
        this.b.a(paramView, new am(paramd));
      }
      return;
      paramView = (Button)paramView;
      this.e.a(((dw)localObject).b, paramView, paramd);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */