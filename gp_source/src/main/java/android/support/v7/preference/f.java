package android.support.v7.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

final class f
  implements AdapterView.OnItemSelectedListener
{
  f(DropDownPreference paramDropDownPreference) {}
  
  public final void onItemSelected(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt >= 0)
    {
      paramAdapterView = this.a.h[paramInt].toString();
      if (!paramAdapterView.equals(this.a.i)) {
        this.a.a(paramAdapterView);
      }
    }
  }
  
  public final void onNothingSelected(AdapterView paramAdapterView) {}
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */