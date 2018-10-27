package com.google.android.finsky.bc.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.bc.k;
import com.google.android.finsky.be.d;
import com.google.android.finsky.be.w;
import com.google.android.finsky.be.y;
import com.google.wireless.android.finsky.dfe.e.a.eb;
import com.google.wireless.android.finsky.dfe.e.a.ee;

public final class an
  extends m
{
  private final eb a;
  private final w b;
  private final y c;
  
  public an(LayoutInflater paramLayoutInflater, eb parameb, w paramw, y paramy)
  {
    super(paramLayoutInflater);
    this.a = parameb;
    this.b = paramw;
    this.c = paramy;
  }
  
  public final int a()
  {
    return 2131625307;
  }
  
  public final void a(d paramd, View paramView)
  {
    Spinner localSpinner = (Spinner)paramView;
    Object localObject2 = this.b.b(this.a.d);
    paramView = null;
    int i = 0;
    for (;;)
    {
      localObject1 = this.a;
      String[] arrayOfString = ((eb)localObject1).e;
      if (i >= arrayOfString.length) {
        break;
      }
      this.c.a(arrayOfString[i], false);
      localObject1 = paramView;
      if (localObject2 != null)
      {
        localObject1 = paramView;
        if (((String)localObject2).equals(this.a.e[i])) {
          localObject1 = Integer.valueOf(i);
        }
      }
      i += 1;
      paramView = (View)localObject1;
    }
    localSpinner.setOnItemSelectedListener(new ao(paramd, this.b, (eb)localObject1, this.c, paramView));
    Object localObject1 = this.e;
    localObject2 = this.a.c;
    if (localObject2.length != 0)
    {
      paramd = new k((h)localObject1, localSpinner.getContext(), (ee[])localObject2, paramd);
      paramd.setDropDownViewResource(17367049);
      localSpinner.setAdapter(paramd);
    }
    if (paramView != null) {
      localSpinner.setSelection(paramView.intValue());
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */