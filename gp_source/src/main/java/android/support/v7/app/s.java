package android.support.v7.app;

import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class s
  implements AdapterView.OnItemClickListener
{
  s(p paramp, AlertController.RecycleListView paramRecycleListView, AlertController paramAlertController) {}
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.d;
    if (paramAdapterView != null) {
      paramAdapterView[paramInt] = this.c.isItemChecked(paramInt);
    }
    this.a.s.onClick(this.b.t, paramInt, this.c.isItemChecked(paramInt));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */