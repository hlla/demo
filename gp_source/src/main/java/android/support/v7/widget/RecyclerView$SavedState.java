package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;

public class RecyclerView$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator CREATOR = new fs();
  public Parcelable a;
  
  RecyclerView$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    ClassLoader localClassLoader = paramClassLoader;
    if (paramClassLoader == null) {
      localClassLoader = ff.class.getClassLoader();
    }
    this.a = paramParcel.readParcelable(localClassLoader);
  }
  
  RecyclerView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.a, 0);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/RecyclerView$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */