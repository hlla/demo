package android.support.v7.preference;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

final class aq
  implements SeekBar.OnSeekBarChangeListener
{
  aq(SeekBarPreference paramSeekBarPreference) {}
  
  public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      SeekBarPreference localSeekBarPreference = this.a;
      if (!localSeekBarPreference.e) {
        localSeekBarPreference.a(paramSeekBar);
      }
    }
  }
  
  public final void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.a.e = true;
  }
  
  public final void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    this.a.e = false;
    int i = paramSeekBar.getProgress();
    SeekBarPreference localSeekBarPreference = this.a;
    if (i + localSeekBarPreference.b != localSeekBarPreference.d) {
      localSeekBarPreference.a(paramSeekBar);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */