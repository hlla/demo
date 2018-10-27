package android.support.v14.preference;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.preference.Preference.BaseSavedState;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class MultiSelectListPreference$SavedState
  extends Preference.BaseSavedState
{
  public static final Parcelable.Creator CREATOR = new a();
  public Set a;
  
  MultiSelectListPreference$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    int i = paramParcel.readInt();
    this.a = new HashSet();
    String[] arrayOfString = new String[i];
    paramParcel.readStringArray(arrayOfString);
    Collections.addAll(this.a, arrayOfString);
  }
  
  MultiSelectListPreference$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.a.size());
    Set localSet = this.a;
    paramParcel.writeStringArray((String[])localSet.toArray(new String[localSet.size()]));
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v14/preference/MultiSelectListPreference$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */