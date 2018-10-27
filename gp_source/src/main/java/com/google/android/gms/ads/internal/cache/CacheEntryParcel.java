package com.google.android.gms.ads.internal.cache;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.InputStream;

@com.google.android.gms.ads.internal.q.a.a
public class CacheEntryParcel
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new f();
  private ParcelFileDescriptor a;
  
  public CacheEntryParcel()
  {
    this(null);
  }
  
  public CacheEntryParcel(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.a = paramParcelFileDescriptor;
  }
  
  private final ParcelFileDescriptor c()
  {
    try
    {
      ParcelFileDescriptor localParcelFileDescriptor = this.a;
      return localParcelFileDescriptor;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/google/android/gms/ads/internal/cache/CacheEntryParcel:a	Landroid/os/ParcelFileDescriptor;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	CacheEntryParcel
    //   12	7	1	bool	boolean
    //   6	2	2	localParcelFileDescriptor	ParcelFileDescriptor
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public final InputStream b()
  {
    ParcelFileDescriptor.AutoCloseInputStream localAutoCloseInputStream = null;
    try
    {
      ParcelFileDescriptor localParcelFileDescriptor = this.a;
      if (localParcelFileDescriptor != null)
      {
        localAutoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(localParcelFileDescriptor);
        this.a = null;
      }
      return localAutoCloseInputStream;
    }
    finally {}
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, c(), paramInt);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, i);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/cache/CacheEntryParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */