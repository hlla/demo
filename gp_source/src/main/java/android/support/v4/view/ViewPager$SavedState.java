package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ViewPager$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator CREATOR = new au();
  public Parcelable a;
  public ClassLoader b;
  public int c;
  
  ViewPager$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    ClassLoader localClassLoader = paramClassLoader;
    if (paramClassLoader == null) {
      localClassLoader = getClass().getClassLoader();
    }
    this.c = paramParcel.readInt();
    this.a = paramParcel.readParcelable(localClassLoader);
    this.b = localClassLoader;
  }
  
  public ViewPager$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FragmentPager.SavedState{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" position=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.c);
    paramParcel.writeParcelable(this.a, paramInt);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/ViewPager$SavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */