package android.support.v7.preference;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class EditTextPreference$SavedState
  extends Preference.BaseSavedState
{
  public static final Parcelable.Creator CREATOR = new g();
  public String a;
  
  public EditTextPreference$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readString();
  }
  
  public EditTextPreference$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/EditTextPreference$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */