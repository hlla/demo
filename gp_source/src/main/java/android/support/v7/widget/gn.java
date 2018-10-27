package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class gn
  implements AdapterView.OnItemClickListener
{
  gn(SearchView paramSearchView) {}
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.onItemClicked(paramInt, 0, null);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/gn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */