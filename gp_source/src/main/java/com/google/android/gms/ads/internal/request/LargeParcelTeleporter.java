package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.bt;
import com.google.android.gms.ads.internal.util.e;
import com.google.android.gms.ads.internal.v.f;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.g;
import java.io.IOException;

@com.google.android.gms.ads.internal.q.a.a
public final class LargeParcelTeleporter
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator CREATOR = new aj();
  private ParcelFileDescriptor a;
  private Parcelable b;
  private boolean c;
  
  public LargeParcelTeleporter(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    this.a = paramParcelFileDescriptor;
    this.b = null;
    this.c = true;
  }
  
  public LargeParcelTeleporter(SafeParcelable paramSafeParcelable)
  {
    this.a = null;
    this.b = paramSafeParcelable;
    this.c = false;
  }
  
  private final ParcelFileDescriptor a()
  {
    Parcel localParcel;
    if (this.a == null) {
      localParcel = Parcel.obtain();
    }
    try
    {
      this.b.writeToParcel(localParcel, 0);
      byte[] arrayOfByte = localParcel.marshall();
      localParcel.recycle();
      this.a = a(arrayOfByte);
      return this.a;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  private static ParcelFileDescriptor a(byte[] paramArrayOfByte)
  {
    try
    {
      ParcelFileDescriptor[] arrayOfParcelFileDescriptor = ParcelFileDescriptor.createPipe();
      localAutoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(arrayOfParcelFileDescriptor[1]);
      e.c("Error transporting the ad response", paramArrayOfByte);
    }
    catch (IOException paramArrayOfByte)
    {
      try
      {
        new Thread(new ai(localAutoCloseOutputStream, paramArrayOfByte)).start();
        paramArrayOfByte = arrayOfParcelFileDescriptor[0];
        return paramArrayOfByte;
      }
      catch (IOException paramArrayOfByte)
      {
        ParcelFileDescriptor.AutoCloseOutputStream localAutoCloseOutputStream;
        for (;;) {}
      }
      paramArrayOfByte = paramArrayOfByte;
      localAutoCloseOutputStream = null;
    }
    bt.A.i.a(paramArrayOfByte, "LargeParcelTeleporter.pipeData.2");
    g.a(localAutoCloseOutputStream);
    return null;
  }
  
  /* Error */
  public final SafeParcelable a(Parcelable.Creator paramCreator)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:c	Z
    //   4: ifeq +99 -> 103
    //   7: aload_0
    //   8: getfield 27	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:a	Landroid/os/ParcelFileDescriptor;
    //   11: astore_3
    //   12: aload_3
    //   13: ifnonnull +10 -> 23
    //   16: ldc 112
    //   18: invokestatic 115	com/google/android/gms/ads/internal/util/e:c	(Ljava/lang/String;)V
    //   21: aconst_null
    //   22: areturn
    //   23: new 117	java/io/DataInputStream
    //   26: dup
    //   27: new 119	android/os/ParcelFileDescriptor$AutoCloseInputStream
    //   30: dup
    //   31: aload_3
    //   32: invokespecial 120	android/os/ParcelFileDescriptor$AutoCloseInputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   35: invokespecial 123	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore_3
    //   39: aload_3
    //   40: invokevirtual 127	java/io/DataInputStream:readInt	()I
    //   43: newarray <illegal type>
    //   45: astore 4
    //   47: aload 4
    //   49: arraylength
    //   50: istore_2
    //   51: aload_3
    //   52: aload 4
    //   54: iconst_0
    //   55: iload_2
    //   56: invokevirtual 131	java/io/DataInputStream:readFully	([BII)V
    //   59: aload_3
    //   60: invokestatic 109	com/google/android/gms/common/util/g:a	(Ljava/io/Closeable;)V
    //   63: invokestatic 39	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   66: astore_3
    //   67: aload_3
    //   68: aload 4
    //   70: iconst_0
    //   71: iload_2
    //   72: invokevirtual 134	android/os/Parcel:unmarshall	([BII)V
    //   75: aload_3
    //   76: iconst_0
    //   77: invokevirtual 138	android/os/Parcel:setDataPosition	(I)V
    //   80: aload_0
    //   81: aload_1
    //   82: aload_3
    //   83: invokeinterface 144 2 0
    //   88: checkcast 146	com/google/android/gms/common/internal/safeparcel/SafeParcelable
    //   91: putfield 29	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:b	Landroid/os/Parcelable;
    //   94: aload_3
    //   95: invokevirtual 52	android/os/Parcel:recycle	()V
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 31	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:c	Z
    //   103: aload_0
    //   104: getfield 29	com/google/android/gms/ads/internal/request/LargeParcelTeleporter:b	Landroid/os/Parcelable;
    //   107: checkcast 146	com/google/android/gms/common/internal/safeparcel/SafeParcelable
    //   110: areturn
    //   111: astore_1
    //   112: ldc -108
    //   114: aload_1
    //   115: invokestatic 87	com/google/android/gms/ads/internal/util/e:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   118: aload_3
    //   119: invokestatic 109	com/google/android/gms/common/util/g:a	(Ljava/io/Closeable;)V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_1
    //   125: aload_3
    //   126: invokestatic 109	com/google/android/gms/common/util/g:a	(Ljava/io/Closeable;)V
    //   129: aload_1
    //   130: athrow
    //   131: astore_1
    //   132: aload_3
    //   133: invokevirtual 52	android/os/Parcel:recycle	()V
    //   136: aload_1
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	LargeParcelTeleporter
    //   0	138	1	paramCreator	Parcelable.Creator
    //   50	22	2	i	int
    //   11	122	3	localObject	Object
    //   45	24	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   39	59	111	java/io/IOException
    //   39	59	124	finally
    //   112	118	124	finally
    //   67	94	131	finally
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a();
    int i = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 20293);
    com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, 2, this.a, paramInt);
    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, i);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/gms/ads/internal/request/LargeParcelTeleporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */