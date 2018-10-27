package android.support.v7.preference;

import android.os.Bundle;
import android.support.v7.app.w;
import android.support.v7.preference.internal.AbstractMultiSelectListPreference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class l
  extends r
{
  public CharSequence[] aa;
  public Set ab = new HashSet();
  public boolean ac;
  private CharSequence[] ad;
  
  public final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (paramBundle == null)
    {
      paramBundle = (AbstractMultiSelectListPreference)S();
      if ((paramBundle.a() == null) || (paramBundle.b() == null)) {
        throw new IllegalStateException("MultiSelectListPreference requires an entries array and an entryValues array.");
      }
      this.ab.clear();
      this.ab.addAll(paramBundle.c());
      this.ac = false;
      this.ad = paramBundle.a();
      this.aa = paramBundle.b();
      return;
    }
    this.ab.clear();
    this.ab.addAll(paramBundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
    this.ac = paramBundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
    this.ad = paramBundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
    this.aa = paramBundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
  }
  
  protected final void a(w paramw)
  {
    super.a(paramw);
    int j = this.aa.length;
    boolean[] arrayOfBoolean = new boolean[j];
    int i = 0;
    while (i < j)
    {
      arrayOfBoolean[i] = this.ab.contains(this.aa[i].toString());
      i += 1;
    }
    paramw.a(this.ad, arrayOfBoolean, new m(this));
  }
  
  public final void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList(this.ab));
    paramBundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.ac);
    paramBundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.ad);
    paramBundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.aa);
  }
  
  public final void e(boolean paramBoolean)
  {
    AbstractMultiSelectListPreference localAbstractMultiSelectListPreference = (AbstractMultiSelectListPreference)S();
    if ((paramBoolean) && (this.ac)) {
      localAbstractMultiSelectListPreference.a(this.ab);
    }
    this.ac = false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */