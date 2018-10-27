package android.support.design.bottomsheet;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;

public class BottomSheetBehavior$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator CREATOR = new b();
  public final int a;
  
  public BottomSheetBehavior$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    this.a = paramParcel.readInt();
  }
  
  public BottomSheetBehavior$SavedState(Parcelable paramParcelable, int paramInt)
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/bottomsheet/BottomSheetBehavior$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */