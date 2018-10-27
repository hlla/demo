package com.google.android.finsky.bc.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.be.d;
import com.google.android.finsky.be.w;
import com.google.wireless.android.finsky.dfe.e.a.cy;
import com.google.wireless.android.finsky.dfe.e.a.dl;
import com.google.wireless.android.finsky.dfe.e.a.ee;

public final class v
  extends m
{
  private final cy a;
  private final w b;
  
  public v(LayoutInflater paramLayoutInflater, cy paramcy, w paramw)
  {
    super(paramLayoutInflater);
    this.a = paramcy;
    this.b = paramw;
  }
  
  public final int a()
  {
    return 2131625296;
  }
  
  public final void a(d paramd, View paramView)
  {
    this.e.a(this.a.e, (ImageView)paramView.findViewById(2131429328), paramd);
    this.e.a(this.a.f, (TextView)paramView.findViewById(2131429330), paramd, this.b);
    this.e.a(this.a.a, (ImageView)paramView.findViewById(2131428024), paramd);
    this.e.a(this.a.b, (TextView)paramView.findViewById(2131428027), paramd, this.b);
    LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131428552);
    paramView = (LinearLayout)paramView.findViewById(2131428553);
    this.e.a(this.a.d, localLinearLayout, paramd);
    this.e.a(this.a.d, paramView, paramd);
    dl[] arrayOfdl = this.a.c;
    int j = arrayOfdl.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfdl[i];
      TextView localTextView2 = (TextView)this.g.inflate(2131625310, localLinearLayout, false);
      TextView localTextView1 = (TextView)this.g.inflate(2131625310, paramView, false);
      ee localee = ((dl)localObject).a;
      if (localee != null)
      {
        this.e.a(localee, localTextView2, paramd, this.b);
        localLinearLayout.addView(localTextView2);
        localLinearLayout.setVisibility(0);
      }
      localObject = ((dl)localObject).b;
      if (localObject != null)
      {
        this.e.a((ee)localObject, localTextView1, paramd, this.b);
        paramView.addView(localTextView1);
        paramView.setVisibility(0);
      }
      i += 1;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */