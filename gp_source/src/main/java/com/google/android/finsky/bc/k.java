package com.google.android.finsky.bc;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.google.android.finsky.be.d;
import com.google.wireless.android.finsky.dfe.e.a.ee;

public final class k
  extends ArrayAdapter
{
  public k(h paramh, Context paramContext, ee[] paramArrayOfee, d paramd)
  {
    super(paramContext, 17367048, paramArrayOfee);
  }
  
  public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getDropDownView(paramInt, paramView, paramViewGroup);
    this.a.a((ee)getItem(paramInt), (TextView)paramView, this.b, null);
    return paramView;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    this.a.a((ee)getItem(paramInt), (TextView)paramView, this.b, null);
    return paramView;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bc/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */