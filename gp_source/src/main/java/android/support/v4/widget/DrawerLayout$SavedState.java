package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;

public class DrawerLayout$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator CREATOR = new w();
  public int a;
  public int b;
  public int c;
  public int f;
  public int g = 0;
  
  public DrawerLayout$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    this.g = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.a = paramParcel.readInt();
  }
  
  public DrawerLayout$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/DrawerLayout$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */