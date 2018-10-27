package com.google.android.finsky.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.google.android.finsky.ds.a.cn;
import java.util.List;

public final class a
  extends ArrayAdapter
{
  private int a;
  
  public a(Context paramContext, List paramList)
  {
    super(paramContext, 17367049, paramList);
    this.a = paramContext.getResources().getDimensionPixelSize(2131167276);
  }
  
  public final View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(getContext()).inflate(17367049, paramViewGroup, false);
    }
    paramView = (cn)getItem(paramInt);
    paramViewGroup = (TextView)localView.findViewById(16908308);
    paramViewGroup.setText(paramView.c);
    paramViewGroup.setMinWidth(this.a);
    return localView;
  }
  
  @SuppressLint({"ViewHolder"})
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = LayoutInflater.from(getContext()).inflate(2131625147, paramViewGroup, false);
    paramViewGroup = (cn)getItem(paramInt);
    ((TextView)paramView).setText(paramViewGroup.c);
    return paramView;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */