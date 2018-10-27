package com.google.android.finsky.bc.a;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.be.d;
import com.google.android.finsky.be.q;
import com.google.android.finsky.be.r;
import com.google.android.finsky.be.t;
import com.google.android.finsky.be.w;
import com.google.wireless.android.finsky.dfe.e.a.dr;
import com.google.wireless.android.finsky.dfe.e.a.du;
import com.google.wireless.android.finsky.dfe.e.a.dv;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ai
  extends m
{
  private final q a;
  private final t b;
  private final dv c;
  private final r d;
  private final w h;
  
  public ai(LayoutInflater paramLayoutInflater, dv paramdv, w paramw, t paramt, r paramr, q paramq)
  {
    super(paramLayoutInflater);
    this.c = paramdv;
    this.h = paramw;
    this.b = paramt;
    this.d = paramr;
    this.a = paramq;
  }
  
  public final int a()
  {
    return 2131625305;
  }
  
  public final void a(d paramd, View paramView)
  {
    paramView = (RadioGroup)paramView;
    Object localObject1 = this.c;
    if ((((dv)localObject1).a & 0x4) == 0) {}
    for (;;)
    {
      localObject1 = this.d;
      Object localObject2 = this.c.e;
      Object localObject3 = new aj(paramView);
      if (((r)localObject1).a.containsKey(localObject2)) {
        ((List)((r)localObject1).a.get(localObject2)).add(localObject3);
      }
      for (;;)
      {
        int j = ((List)((r)localObject1).a.get(localObject2)).size();
        int i = 0;
        if (i >= this.c.d.length) {
          break;
        }
        localObject2 = (RadioButton)this.g.inflate(2131625304, paramView, false);
        localObject1 = this.c.d[i];
        this.e.a(((du)localObject1).b, (TextView)localObject2, paramd, this.h);
        ((RadioButton)localObject2).setOnCheckedChangeListener(new ak(this.c, i, this.h, this.b, this.d, j - 1));
        paramView.addView((View)localObject2);
        localObject3 = this.c;
        if (((((dv)localObject3).a & 0x2) != 0) && (i == ((dv)localObject3).b)) {
          paramView.check(((RadioButton)localObject2).getId());
        }
        if (((du)localObject1).e != null)
        {
          localObject2 = (TextView)this.g.inflate(2131625310, paramView, false);
          this.e.a(((du)localObject1).e, (TextView)localObject2, paramd, this.h);
          paramView.addView((View)localObject2);
        }
        localObject1 = ((du)localObject1).g;
        if (localObject1 == null) {}
        for (;;)
        {
          i += 1;
          break;
          this.a.a((dr)localObject1, null);
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject3);
        ((r)localObject1).a.put(localObject2, localArrayList);
      }
      this.b.a(((dv)localObject1).c, false);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */