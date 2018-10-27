package com.google.android.finsky.bc.a;

import android.accounts.Account;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.finsky.bc.h;
import com.google.android.finsky.be.d;
import com.google.android.finsky.be.w;
import com.google.android.finsky.dt.b;
import com.google.android.play.image.FifeImageView;
import com.google.wireless.android.finsky.dfe.e.a.ec;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ap
  extends m
{
  public final ec a;
  public final String b;
  public final as c;
  private final w d;
  
  public ap(LayoutInflater paramLayoutInflater, ec paramec, w paramw, String paramString, as paramas)
  {
    super(paramLayoutInflater);
    ((o)b.a(o.class)).a(this);
    this.a = paramec;
    this.d = paramw;
    this.b = paramString;
    this.c = paramas;
  }
  
  public final int a()
  {
    return 2131625309;
  }
  
  public final void a(d paramd, View paramView)
  {
    paramView = (LinearLayout)paramView;
    Object localObject1 = this.c.a(this.a.b);
    Collections.sort((List)localObject1, new aq(this));
    localObject1 = ((List)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Account)((Iterator)localObject1).next();
      View localView = LayoutInflater.from(paramView.getContext()).inflate(2131625122, null);
      TextView localTextView = (TextView)localView.findViewById(2131427361);
      this.e.a(this.a.a, localTextView, paramd, this.d);
      localTextView.setText(((Account)localObject2).name);
      if (this.b.equals(((Account)localObject2).name))
      {
        localObject2 = (FifeImageView)localView.findViewById(2131429218);
        this.e.a(this.a.c, (ImageView)localObject2, paramd);
      }
      for (;;)
      {
        paramView.addView(localView);
        break;
        localView.setClickable(true);
        localView.setBackgroundResource(2131231280);
        localView.setOnClickListener(new ar(this, (Account)localObject2));
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/a/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */