package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;

final class aw
  implements AdapterView.OnItemClickListener
{
  aw(av paramav) {}
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.d.setSelection(paramInt);
    if (this.a.d.getOnItemClickListener() != null)
    {
      paramAdapterView = this.a;
      paramAdapterView.d.performItemClick(paramView, paramInt, paramAdapterView.a.getItemId(paramInt));
    }
    this.a.c();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */