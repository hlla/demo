package android.support.v7.preference;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class PreferenceGroup$SavedState
  extends Preference.BaseSavedState
{
  public static final Parcelable.Creator CREATOR = new ad();
  public int a;
  
  PreferenceGroup$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readInt();
  }
  
  PreferenceGroup$SavedState(Parcelable paramParcelable, int paramInt)
  {
    super(paramParcelable);
    this.a = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/PreferenceGroup$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */