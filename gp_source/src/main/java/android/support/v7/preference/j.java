package android.support.v7.preference;

import android.os.Bundle;
import android.support.v7.app.w;

public final class j
  extends r
{
  public int aa;
  private CharSequence[] ab;
  private CharSequence[] ac;
  
  public final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle == null)
    {
      paramBundle = (ListPreference)S();
      if ((paramBundle.g != null) && (paramBundle.h != null))
      {
        this.aa = paramBundle.b(paramBundle.i);
        this.ab = paramBundle.g;
        this.ac = paramBundle.h;
      }
    }
    else
    {
      this.aa = paramBundle.getInt("ListPreferenceDialogFragment.index", 0);
      this.ab = paramBundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
      this.ac = paramBundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
      return;
    }
    throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
  }
  
  protected final void a(w paramw)
  {
    super.a(paramw);
    paramw.a(this.ab, this.aa, new k(this));
    paramw.a(null, null);
  }
  
  public final void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putInt("ListPreferenceDialogFragment.index", this.aa);
    paramBundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.ab);
    paramBundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.ac);
  }
  
  public final void e(boolean paramBoolean)
  {
    ListPreference localListPreference = (ListPreference)S();
    if (paramBoolean)
    {
      int i = this.aa;
      if (i >= 0) {
        localListPreference.a(this.ac[i].toString());
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */