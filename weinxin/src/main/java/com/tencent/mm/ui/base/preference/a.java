package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.gmtrace.GMTrace;

public final class a
  extends h
{
  private SparseArray<View> vow;
  
  public a(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    super(paramContext, paramSharedPreferences);
    GMTrace.i(3203777167360L, 23870);
    this.vow = new SparseArray();
    GMTrace.o(3203777167360L, 23870);
  }
  
  public final View a(int paramInt, ListView paramListView)
  {
    GMTrace.i(3204045602816L, 23872);
    if ((paramInt > paramListView.getLastVisiblePosition()) || (paramInt < paramListView.getFirstVisiblePosition()))
    {
      GMTrace.o(3204045602816L, 23872);
      return null;
    }
    paramListView = (View)this.vow.get(paramInt);
    GMTrace.o(3204045602816L, 23872);
    return paramListView;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(3203911385088L, 23871);
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    this.vow.put(paramInt, paramView);
    GMTrace.o(3203911385088L, 23871);
    return paramView;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/preference/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */