package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

final class go
  implements AdapterView.OnItemSelectedListener
{
  go(SearchView paramSearchView) {}
  
  public final void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.onItemSelected(paramInt);
  }
  
  public final void onNothingSelected(AdapterView paramAdapterView) {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/go.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */