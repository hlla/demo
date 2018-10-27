package com.google.android.finsky.bc.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.be.d;
import com.google.android.finsky.be.w;
import com.google.android.finsky.bw.l;
import com.google.android.finsky.ds.a.bu;
import com.google.android.play.image.FifeImageView;
import com.google.wireless.android.finsky.dfe.e.a.da;
import com.google.wireless.android.finsky.dfe.e.a.dc;

public final class x
  extends m
{
  private final da a;
  private final w b;
  
  public x(LayoutInflater paramLayoutInflater, da paramda, w paramw)
  {
    super(paramLayoutInflater);
    this.a = paramda;
    this.b = paramw;
  }
  
  public final int a()
  {
    return 2131625288;
  }
  
  public final void a(d paramd, View paramView)
  {
    Object localObject = this.a.b;
    if (localObject != null)
    {
      localObject = ((dc)localObject).d;
      FifeImageView localFifeImageView = (FifeImageView)paramView.findViewById(2131429467);
      this.f.a(localFifeImageView, (bu)localObject, -1);
      this.e.a(this.a.b.g, localFifeImageView, paramd);
    }
    this.e.a(this.a.d, (TextView)paramView.findViewById(2131429479), paramd, this.b);
    this.e.a(this.a.e, (TextView)paramView.findViewById(2131429485), paramd, this.b);
    this.e.a(this.a.c, (TextView)paramView.findViewById(2131428535), paramd, this.b);
    if (this.a.a) {
      paramView.findViewById(2131427666).setVisibility(0);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */