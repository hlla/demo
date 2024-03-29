package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract interface r
  extends IInterface
{
  public abstract void a(int paramInt, IBinder paramIBinder, Bundle paramBundle);
  
  public abstract void b(int paramInt, Bundle paramBundle);
  
  public static abstract class a
    extends Binder
    implements r
  {
    public a()
    {
      attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
    }
    
    public static r h(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
      if ((localIInterface != null) && ((localIInterface instanceof r))) {
        return (r)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      IBinder localIBinder = null;
      Object localObject = null;
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.common.internal.IGmsCallbacks");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
        paramInt1 = paramParcel1.readInt();
        localIBinder = paramParcel1.readStrongBinder();
        if (paramParcel1.readInt() != 0) {
          localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        }
        a(paramInt1, localIBinder, (Bundle)localObject);
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.common.internal.IGmsCallbacks");
      paramInt1 = paramParcel1.readInt();
      localObject = localIBinder;
      if (paramParcel1.readInt() != 0) {
        localObject = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
      }
      b(paramInt1, (Bundle)localObject);
      paramParcel2.writeNoException();
      return true;
    }
    
    private static final class a
      implements r
    {
      private IBinder ahE;
      
      a(IBinder paramIBinder)
      {
        this.ahE = paramIBinder;
      }
      
      /* Error */
      public final void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
      {
        // Byte code:
        //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 28
        //   14: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: iload_1
        //   20: invokevirtual 36	android/os/Parcel:writeInt	(I)V
        //   23: aload 4
        //   25: aload_2
        //   26: invokevirtual 39	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   29: aload_3
        //   30: ifnull +48 -> 78
        //   33: aload 4
        //   35: iconst_1
        //   36: invokevirtual 36	android/os/Parcel:writeInt	(I)V
        //   39: aload_3
        //   40: aload 4
        //   42: iconst_0
        //   43: invokevirtual 45	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   46: aload_0
        //   47: getfield 18	com/google/android/gms/common/internal/r$a$a:ahE	Landroid/os/IBinder;
        //   50: iconst_1
        //   51: aload 4
        //   53: aload 5
        //   55: iconst_0
        //   56: invokeinterface 51 5 0
        //   61: pop
        //   62: aload 5
        //   64: invokevirtual 54	android/os/Parcel:readException	()V
        //   67: aload 5
        //   69: invokevirtual 57	android/os/Parcel:recycle	()V
        //   72: aload 4
        //   74: invokevirtual 57	android/os/Parcel:recycle	()V
        //   77: return
        //   78: aload 4
        //   80: iconst_0
        //   81: invokevirtual 36	android/os/Parcel:writeInt	(I)V
        //   84: goto -38 -> 46
        //   87: astore_2
        //   88: aload 5
        //   90: invokevirtual 57	android/os/Parcel:recycle	()V
        //   93: aload 4
        //   95: invokevirtual 57	android/os/Parcel:recycle	()V
        //   98: aload_2
        //   99: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	100	0	this	a
        //   0	100	1	paramInt	int
        //   0	100	2	paramIBinder	IBinder
        //   0	100	3	paramBundle	Bundle
        //   3	91	4	localParcel1	Parcel
        //   8	81	5	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   10	29	87	finally
        //   33	46	87	finally
        //   46	67	87	finally
        //   78	84	87	finally
      }
      
      public final IBinder asBinder()
      {
        return this.ahE;
      }
      
      /* Error */
      public final void b(int paramInt, Bundle paramBundle)
      {
        // Byte code:
        //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 28
        //   12: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_3
        //   16: iload_1
        //   17: invokevirtual 36	android/os/Parcel:writeInt	(I)V
        //   20: aload_2
        //   21: ifnull +44 -> 65
        //   24: aload_3
        //   25: iconst_1
        //   26: invokevirtual 36	android/os/Parcel:writeInt	(I)V
        //   29: aload_2
        //   30: aload_3
        //   31: iconst_0
        //   32: invokevirtual 45	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   35: aload_0
        //   36: getfield 18	com/google/android/gms/common/internal/r$a$a:ahE	Landroid/os/IBinder;
        //   39: iconst_2
        //   40: aload_3
        //   41: aload 4
        //   43: iconst_0
        //   44: invokeinterface 51 5 0
        //   49: pop
        //   50: aload 4
        //   52: invokevirtual 54	android/os/Parcel:readException	()V
        //   55: aload 4
        //   57: invokevirtual 57	android/os/Parcel:recycle	()V
        //   60: aload_3
        //   61: invokevirtual 57	android/os/Parcel:recycle	()V
        //   64: return
        //   65: aload_3
        //   66: iconst_0
        //   67: invokevirtual 36	android/os/Parcel:writeInt	(I)V
        //   70: goto -35 -> 35
        //   73: astore_2
        //   74: aload 4
        //   76: invokevirtual 57	android/os/Parcel:recycle	()V
        //   79: aload_3
        //   80: invokevirtual 57	android/os/Parcel:recycle	()V
        //   83: aload_2
        //   84: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	85	0	this	a
        //   0	85	1	paramInt	int
        //   0	85	2	paramBundle	Bundle
        //   3	77	3	localParcel1	Parcel
        //   7	68	4	localParcel2	Parcel
        // Exception table:
        //   from	to	target	type
        //   9	20	73	finally
        //   24	35	73	finally
        //   35	55	73	finally
        //   65	70	73	finally
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/internal/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */