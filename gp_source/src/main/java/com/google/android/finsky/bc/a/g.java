package com.google.android.finsky.bc.a;

import android.support.v4.g.v;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.finsky.be.d;
import com.google.android.finsky.be.t;
import com.google.android.finsky.be.w;
import com.google.android.finsky.be.y;
import com.google.android.finsky.dialogbuilderlayout.CheckedGroupView;
import com.google.android.finsky.dialogbuilderlayout.CheckedView;
import com.google.wireless.android.finsky.dfe.e.a.cf;
import com.google.wireless.android.finsky.dfe.e.a.du;
import com.google.wireless.android.finsky.dfe.e.a.ee;

public final class g
  extends m
{
  public final cf a;
  public final t b;
  public final w c;
  private final y d;
  
  public g(LayoutInflater paramLayoutInflater, cf paramcf, w paramw, t paramt, y paramy)
  {
    super(paramLayoutInflater);
    this.a = paramcf;
    this.c = paramw;
    this.b = paramt;
    this.d = paramy;
  }
  
  public final int a()
  {
    return 2131625286;
  }
  
  public final void a(d paramd, View paramView)
  {
    CheckedGroupView localCheckedGroupView = (CheckedGroupView)paramView;
    h localh = new h(this);
    localCheckedGroupView.setCheckedChangeListener(localh);
    boolean bool = this.a.b;
    int i = 0;
    paramView = this.a.e;
    if (i < paramView.length)
    {
      du localdu = paramView[i];
      Object localObject = this.g.inflate(2131625287, localCheckedGroupView, false);
      paramView = (LinearLayout)localObject;
      int j = 0;
      label76:
      if (j < paramView.getChildCount()) {
        if (!(paramView.getChildAt(j) instanceof CheckedView)) {}
      }
      for (paramView = (CheckedView)paramView.getChildAt(j);; paramView = null)
      {
        if (bool) {
          paramView.setCheckMarkDrawable(null);
        }
        for (;;)
        {
          this.e.a(localdu.b, paramView, paramd, this.c);
          j = localdu.a;
          if ((j & 0x2) != 0) {}
          for (;;)
          {
            TextView localTextView = (TextView)((View)localObject).findViewById(2131427640);
            ee localee = localdu.c;
            if (localee != null) {
              this.e.a(localee, localTextView, paramd, this.c);
            }
            localTextView.setVisibility(0);
            com.google.android.finsky.bc.h.a(localTextView, localTextView, 2131231027, localdu.f, 2131231029, localdu.d, this.d);
            do
            {
              localCheckedGroupView.addView((View)localObject);
              j = paramView.getId();
              localh.a.put(Integer.valueOf(j), Integer.valueOf(i));
              localh.a(localdu, false);
              localObject = this.a;
              if (((((cf)localObject).a & 0x2) != 0) && (i == ((cf)localObject).c)) {
                localCheckedGroupView.a(paramView.getId());
              }
              if (localdu.e != null)
              {
                paramView = (TextView)this.g.inflate(2131625310, localCheckedGroupView, false);
                this.e.a(localdu.e, paramView, paramd, this.c);
                this.d.a(paramView, localdu.e.i, null);
                localCheckedGroupView.addView(paramView);
              }
              i += 1;
              break;
            } while ((j & 0x4) == 0);
          }
          paramView.setCompoundDrawables(null, null, null, null);
        }
        j += 1;
        break label76;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */