package com.google.android.finsky.bc.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.be.d;
import com.google.android.finsky.be.w;
import com.google.android.play.image.FifeImageView;
import com.google.wireless.android.finsky.dfe.e.a.dk;

public final class ae
  extends m
{
  public final dk a;
  private final w b;
  
  public ae(LayoutInflater paramLayoutInflater, dk paramdk, w paramw)
  {
    super(paramLayoutInflater);
    this.a = paramdk;
    this.b = paramw;
  }
  
  public final int a()
  {
    return 2131625299;
  }
  
  public final void a(d paramd, View paramView)
  {
    FifeImageView localFifeImageView;
    if (this.a.d != null)
    {
      localFifeImageView = (FifeImageView)paramView.findViewById(2131428303);
      this.e.a(this.a.d, localFifeImageView, paramd);
    }
    this.e.a(this.a.f, (TextView)paramView.findViewById(2131429479), paramd, this.b);
    this.e.a(this.a.e, (TextView)paramView.findViewById(2131429366), paramd, this.b);
    this.e.a(this.a.c, (Button)paramView.findViewById(2131427981), paramd);
    if (this.a.a != null)
    {
      localFifeImageView = (FifeImageView)paramView.findViewById(2131427666);
      this.e.a(this.a.a, localFifeImageView, paramd);
    }
    if (this.a.b != null) {
      paramView.setOnClickListener(new af(this, paramd));
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */