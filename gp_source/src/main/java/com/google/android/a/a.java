package com.google.android.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class a
  implements IInterface
{
  public final String mDescriptor;
  public final IBinder mRemote;
  
  public a(IBinder paramIBinder, String paramString)
  {
    this.mRemote = paramIBinder;
    this.mDescriptor = paramString;
  }
  
  public IBinder asBinder()
  {
    return this.mRemote;
  }
  
  public Parcel obtainAndWriteInterfaceToken()
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken(this.mDescriptor);
    return localParcel;
  }
  
  public Parcel transactAndReadException(int paramInt, Parcel paramParcel)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.mRemote.transact(paramInt, paramParcel, localParcel, 0);
      localParcel.readException();
      return localParcel;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    finally
    {
      paramParcel.recycle();
    }
  }
  
  public void transactAndReadExceptionReturnVoid(int paramInt, Parcel paramParcel)
  {
    Parcel localParcel = Parcel.obtain();
    try
    {
      this.mRemote.transact(paramInt, paramParcel, localParcel, 0);
      localParcel.readException();
      return;
    }
    finally
    {
      paramParcel.recycle();
      localParcel.recycle();
    }
  }
  
  public void transactOneway(int paramInt, Parcel paramParcel)
  {
    try
    {
      this.mRemote.transact(paramInt, paramParcel, null, 1);
      return;
    }
    finally
    {
      paramParcel.recycle();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */