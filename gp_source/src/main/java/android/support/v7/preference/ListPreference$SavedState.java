package android.support.v7.preference;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class ListPreference$SavedState
  extends Preference.BaseSavedState
{
  public static final Parcelable.Creator CREATOR = new i();
  public String a;
  
  public ListPreference$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readString();
  }
  
  public ListPreference$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/ListPreference$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */