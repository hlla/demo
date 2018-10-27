package com.google.android.finsky.bc.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.be.d;
import com.google.android.finsky.be.w;
import com.google.wireless.android.finsky.dfe.e.a.cm;
import com.google.wireless.android.finsky.dfe.e.a.ee;

public final class l
  extends m
{
  private final cm a;
  private final w b;
  
  public l(LayoutInflater paramLayoutInflater, cm paramcm, w paramw)
  {
    super(paramLayoutInflater);
    this.a = paramcm;
    this.b = paramw;
  }
  
  public final int a()
  {
    return 2131625290;
  }
  
  public final void a(d paramd, View paramView)
  {
    this.e.a(this.a.d, (TextView)paramView.findViewById(2131429479), paramd, this.b);
    this.e.a(this.a.c, (ImageView)paramView.findViewById(2131428303), paramd);
    this.e.a(this.a.a, (Button)paramView.findViewById(2131427575), paramd);
    paramView = (LinearLayout)paramView.findViewById(2131427867);
    ee[] arrayOfee = this.a.b;
    int j = arrayOfee.length;
    int i = 0;
    while (i < j)
    {
      ee localee = arrayOfee[i];
      TextView localTextView = (TextView)this.g.inflate(2131625311, paramView, false);
      this.e.a(localee, localTextView, paramd, this.b);
      paramView.addView(localTextView);
      i += 1;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */