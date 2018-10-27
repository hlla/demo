package android.support.v7.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

final class dw
  implements AdapterView.OnItemSelectedListener
{
  dw(du paramdu) {}
  
  public final void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt != -1)
    {
      paramAdapterView = this.a.h;
      if (paramAdapterView != null) {
        paramAdapterView.a = false;
      }
    }
  }
  
  public final void onNothingSelected(AdapterView paramAdapterView) {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */