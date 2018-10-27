package android.support.v7.preference;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.SeekBar;

final class ar
  implements View.OnKeyListener
{
  ar(SeekBarPreference paramSeekBarPreference) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0)
    {
      paramView = this.a;
      if (!paramView.a) {
        break label57;
      }
    }
    label50:
    label57:
    do
    {
      if ((paramInt != 23) && (paramInt != 66))
      {
        paramView = paramView.c;
        if (paramView != null) {
          break label50;
        }
        Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
      }
      do
      {
        return false;
        return paramView.onKeyDown(paramInt, paramKeyEvent);
      } while (paramInt == 21);
    } while (paramInt != 22);
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */