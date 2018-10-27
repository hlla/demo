package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AbsSavedState
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new a();
  public static final AbsSavedState d = new AbsSavedState.1();
  public final Parcelable e;
  
  private AbsSavedState()
  {
    this.e = null;
  }
  
  public AbsSavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    paramClassLoader = paramParcel.readParcelable(paramClassLoader);
    paramParcel = paramClassLoader;
    if (paramClassLoader == null) {
      paramParcel = d;
    }
    this.e = paramParcel;
  }
  
  public AbsSavedState(Parcelable paramParcelable)
  {
    if (paramParcelable == null) {
      throw new IllegalArgumentException("superState must not be null");
    }
    Parcelable localParcelable = paramParcelable;
    if (paramParcelable == d) {
      localParcelable = null;
    }
    this.e = localParcelable;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.e, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/AbsSavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */