package com.google.android.finsky.bc.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.be.d;
import com.google.android.finsky.be.w;
import com.google.android.finsky.frameworkviews.FlowLayout;
import com.google.android.play.image.FifeImageView;
import com.google.wireless.android.finsky.dfe.e.a.cu;
import com.google.wireless.android.finsky.dfe.e.a.cv;

public final class t
  extends m
{
  private final cu a;
  private final w b;
  
  public t(LayoutInflater paramLayoutInflater, cu paramcu, w paramw)
  {
    super(paramLayoutInflater);
    this.a = paramcu;
    this.b = paramw;
  }
  
  public final int a()
  {
    return 2131625292;
  }
  
  public final void a(d paramd, View paramView)
  {
    paramView = (FlowLayout)paramView;
    h.a(this.a.b, paramView);
    cv[] arrayOfcv = this.a.a;
    if (arrayOfcv != null)
    {
      int j = arrayOfcv.length;
      int i = 0;
      while (i < j)
      {
        cv localcv = arrayOfcv[i];
        View localView = this.g.inflate(2131625293, paramView, false);
        Object localObject = (FifeImageView)localView.findViewById(2131428328);
        this.e.a(localcv.a, (ImageView)localObject, paramd);
        localObject = (TextView)localView.findViewById(2131428414);
        this.e.a(localcv.b, (TextView)localObject, paramd, this.b);
        this.e.a(localcv.c, localView, paramd);
        paramView.addView(localView);
        i += 1;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */