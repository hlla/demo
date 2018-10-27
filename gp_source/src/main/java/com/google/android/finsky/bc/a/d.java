package com.google.android.finsky.bc.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.be.w;
import com.google.android.finsky.be.y;
import com.google.wireless.android.finsky.dfe.e.a.ce;

public final class d
  extends m
{
  public final ce a;
  public final w b;
  public final y c;
  
  public d(LayoutInflater paramLayoutInflater, ce paramce, y paramy, w paramw)
  {
    super(paramLayoutInflater);
    this.a = paramce;
    this.c = paramy;
    this.b = paramw;
  }
  
  public final int a()
  {
    switch (this.a.g)
    {
    default: 
      return 2131625285;
    }
    return 2131625308;
  }
  
  public final void a(com.google.android.finsky.be.d paramd, View paramView)
  {
    CompoundButton localCompoundButton = (CompoundButton)paramView;
    this.e.a(this.a.f, localCompoundButton, paramd, this.b);
    localCompoundButton.setChecked(this.a.c);
    paramView = this.a.h;
    if ((!TextUtils.isEmpty(paramView)) && (this.b.c(paramView))) {
      localCompoundButton.setChecked(Boolean.parseBoolean(this.b.b(paramView)));
    }
    if (localCompoundButton.isChecked()) {}
    for (paramView = this.a.d;; paramView = this.a.e)
    {
      paramd = new e(this, paramd);
      if (!TextUtils.isEmpty(paramView)) {
        this.c.a(paramView, false);
      }
      paramView = this.a;
      if ((paramView.a & 0x8) != 0) {
        this.c.a(paramView.e, new f(localCompoundButton, paramd));
      }
      localCompoundButton.setOnCheckedChangeListener(paramd);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */