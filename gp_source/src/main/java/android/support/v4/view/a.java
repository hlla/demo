package android.support.v4.view;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

final class a
  implements Parcelable.ClassLoaderCreator
{
  private static AbsSavedState a(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    if (paramParcel.readParcelable(paramClassLoader) != null) {
      throw new IllegalStateException("superState must be null");
    }
    return AbsSavedState.d;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */