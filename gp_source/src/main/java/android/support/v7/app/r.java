package android.support.v7.app;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class r
  implements AdapterView.OnItemClickListener
{
  r(p paramp, AlertController paramAlertController) {}
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.t.onClick(this.b.t, paramInt);
    if (!this.a.k) {
      this.b.t.dismiss();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */