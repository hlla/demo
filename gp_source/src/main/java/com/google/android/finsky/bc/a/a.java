package com.google.android.finsky.bc.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.be.d;
import com.google.android.finsky.be.t;
import com.google.android.finsky.billing.common.LightPurchaseButtonBarLayout;
import com.google.android.play.image.FifeImageView;
import com.google.wireless.android.finsky.dfe.e.a.ca;
import com.google.wireless.android.finsky.dfe.e.a.dc;

public final class a
  extends m
{
  private final ca a;
  private final t b;
  
  public a(LayoutInflater paramLayoutInflater, ca paramca, t paramt)
  {
    super(paramLayoutInflater);
    this.a = paramca;
    this.b = paramt;
  }
  
  public final int a()
  {
    return 2131625281;
  }
  
  public final void a(d paramd, View paramView)
  {
    paramView.setPadding(0, 0, 0, 0);
    if (this.a.d) {
      ((LightPurchaseButtonBarLayout)paramView.findViewById(2131427778)).setShouldShowLogo(false);
    }
    Object localObject1 = (FifeImageView)paramView.findViewById(2131428855);
    Object localObject2 = this.a;
    dc localdc = ((ca)localObject2).g;
    if (localdc != null) {
      this.e.a(localdc, (ImageView)localObject1, paramd);
    }
    for (;;)
    {
      localObject1 = (Button)paramView.findViewById(2131427777);
      this.e.a(this.a.e, (Button)localObject1, paramd);
      localObject2 = this.a.c;
      if ((localObject2 != null) && (localObject2.length > 0)) {
        this.b.a((String[])localObject2, new b((Button)localObject1));
      }
      this.e.a(this.a.f, (Button)paramView.findViewById(2131429180), paramd);
      return;
      if ((((ca)localObject2).a & 0x2) != 0) {
        switch (((ca)localObject2).b)
        {
        default: 
          ((FifeImageView)localObject1).setImageResource(2131231161);
          break;
        case 1: 
          ((FifeImageView)localObject1).setImageResource(2131231020);
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */