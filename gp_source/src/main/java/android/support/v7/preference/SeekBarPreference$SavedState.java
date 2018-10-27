package android.support.v7.preference;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class SeekBarPreference$SavedState
  extends Preference.BaseSavedState
{
  public static final Parcelable.Creator CREATOR = new as();
  public int a;
  public int b;
  public int c;
  
  public SeekBarPreference$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.c = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.a = paramParcel.readInt();
  }
  
  public SeekBarPreference$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/SeekBarPreference$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */