package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;
import android.util.SparseArray;

public class CoordinatorLayout$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator CREATOR = new m();
  public SparseArray a;
  
  public CoordinatorLayout$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    int j = paramParcel.readInt();
    int[] arrayOfInt = new int[j];
    paramParcel.readIntArray(arrayOfInt);
    paramParcel = paramParcel.readParcelableArray(paramClassLoader);
    this.a = new SparseArray(j);
    int i = 0;
    while (i < j)
    {
      this.a.append(arrayOfInt[i], paramParcel[i]);
      i += 1;
    }
  }
  
  public CoordinatorLayout$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int j = 0;
    super.writeToParcel(paramParcel, paramInt);
    Object localObject = this.a;
    if (localObject != null) {}
    for (int i = ((SparseArray)localObject).size();; i = 0)
    {
      paramParcel.writeInt(i);
      localObject = new int[i];
      Parcelable[] arrayOfParcelable = new Parcelable[i];
      while (j < i)
      {
        localObject[j] = this.a.keyAt(j);
        arrayOfParcelable[j] = ((Parcelable)this.a.valueAt(j));
        j += 1;
      }
      paramParcel.writeIntArray((int[])localObject);
      paramParcel.writeParcelableArray(arrayOfParcelable, paramInt);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/widget/CoordinatorLayout$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */