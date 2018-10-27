package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ar();
  public FragmentState[] a;
  public int[] b;
  public BackStackState[] c;
  public int d;
  public int e = -1;
  
  public FragmentManagerState() {}
  
  public FragmentManagerState(Parcel paramParcel)
  {
    this.a = ((FragmentState[])paramParcel.createTypedArray(FragmentState.CREATOR));
    this.b = paramParcel.createIntArray();
    this.c = ((BackStackState[])paramParcel.createTypedArray(BackStackState.CREATOR));
    this.e = paramParcel.readInt();
    this.d = paramParcel.readInt();
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.a, paramInt);
    paramParcel.writeIntArray(this.b);
    paramParcel.writeTypedArray(this.c, paramInt);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.d);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/FragmentManagerState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */