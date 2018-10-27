package android.support.c;

import android.os.IBinder;
import android.os.Parcel;

final class q
  implements p
{
  private IBinder a;
  
  q(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }
  
  public final boolean a()
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
      localParcel1.writeLong(0L);
      this.a.transact(2, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  public final boolean a(n paramn)
  {
    boolean bool = false;
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    try
    {
      localParcel1.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
      localParcel1.writeStrongBinder(paramn.asBinder());
      this.a.transact(3, localParcel1, localParcel2, 0);
      localParcel2.readException();
      int i = localParcel2.readInt();
      if (i != 0) {
        bool = true;
      }
      return bool;
    }
    finally
    {
      localParcel2.recycle();
      localParcel1.recycle();
    }
  }
  
  /* Error */
  public final boolean a(n paramn, android.net.Uri paramUri, android.os.Bundle paramBundle, java.util.List paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_1
    //   3: istore 6
    //   5: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   8: astore 4
    //   10: invokestatic 23	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   13: astore 7
    //   15: aload 4
    //   17: ldc 25
    //   19: invokevirtual 29	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: ifnull +10 -> 33
    //   26: aload_1
    //   27: invokeinterface 56 1 0
    //   32: astore_3
    //   33: aload 4
    //   35: aload_3
    //   36: invokevirtual 59	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
    //   39: aload_2
    //   40: ifnonnull +73 -> 113
    //   43: aload 4
    //   45: iconst_0
    //   46: invokevirtual 64	android/os/Parcel:writeInt	(I)V
    //   49: aload 4
    //   51: iconst_0
    //   52: invokevirtual 64	android/os/Parcel:writeInt	(I)V
    //   55: aload 4
    //   57: aconst_null
    //   58: invokevirtual 68	android/os/Parcel:writeTypedList	(Ljava/util/List;)V
    //   61: aload_0
    //   62: getfield 15	android/support/c/q:a	Landroid/os/IBinder;
    //   65: iconst_4
    //   66: aload 4
    //   68: aload 7
    //   70: iconst_0
    //   71: invokeinterface 39 5 0
    //   76: pop
    //   77: aload 7
    //   79: invokevirtual 42	android/os/Parcel:readException	()V
    //   82: aload 7
    //   84: invokevirtual 46	android/os/Parcel:readInt	()I
    //   87: istore 5
    //   89: iload 5
    //   91: ifeq +16 -> 107
    //   94: aload 7
    //   96: invokevirtual 49	android/os/Parcel:recycle	()V
    //   99: aload 4
    //   101: invokevirtual 49	android/os/Parcel:recycle	()V
    //   104: iload 6
    //   106: ireturn
    //   107: iconst_0
    //   108: istore 6
    //   110: goto -16 -> 94
    //   113: aload 4
    //   115: iconst_1
    //   116: invokevirtual 64	android/os/Parcel:writeInt	(I)V
    //   119: aload_2
    //   120: aload 4
    //   122: iconst_0
    //   123: invokevirtual 74	android/net/Uri:writeToParcel	(Landroid/os/Parcel;I)V
    //   126: goto -77 -> 49
    //   129: astore_1
    //   130: aload 7
    //   132: invokevirtual 49	android/os/Parcel:recycle	()V
    //   135: aload 4
    //   137: invokevirtual 49	android/os/Parcel:recycle	()V
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	q
    //   0	142	1	paramn	n
    //   0	142	2	paramUri	android.net.Uri
    //   0	142	3	paramBundle	android.os.Bundle
    //   0	142	4	paramList	java.util.List
    //   87	3	5	i	int
    //   3	106	6	bool	boolean
    //   13	118	7	localParcel	Parcel
    // Exception table:
    //   from	to	target	type
    //   15	22	129	finally
    //   26	33	129	finally
    //   33	39	129	finally
    //   43	49	129	finally
    //   49	89	129	finally
    //   113	126	129	finally
  }
  
  public final IBinder asBinder()
  {
    return this.a;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/c/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */