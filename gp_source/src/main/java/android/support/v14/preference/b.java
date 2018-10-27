package android.support.v14.preference;

import android.support.v7.preference.TwoStatePreference;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class b
  implements CompoundButton.OnCheckedChangeListener
{
  b(SwitchPreference paramSwitchPreference) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.a.d(paramBoolean);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v14/preference/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */