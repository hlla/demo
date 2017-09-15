package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

final class d<T>
  implements Parcelable.ClassLoaderCreator<T>
{
  private final c<T> vp;
  
  public d(c<T> paramc)
  {
    this.vp = paramc;
  }
  
  public final T createFromParcel(Parcel paramParcel)
  {
    return (T)this.vp.createFromParcel(paramParcel, null);
  }
  
  public final T createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    return (T)this.vp.createFromParcel(paramParcel, paramClassLoader);
  }
  
  public final T[] newArray(int paramInt)
  {
    return this.vp.newArray(paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/os/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */