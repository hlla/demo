package com.google.android.hotword.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IHotwordService
  extends IInterface
{
  public abstract void requestHotwordDetection(String paramString, boolean paramBoolean)
    throws RemoteException;
  
  public static abstract class Stub
    extends Binder
    implements IHotwordService
  {
    private static final String DESCRIPTOR = "com.google.android.hotword.service.IHotwordService";
    static final int TRANSACTION_requestHotwordDetection = 1;
    
    public Stub()
    {
      attachInterface(this, "com.google.android.hotword.service.IHotwordService");
    }
    
    public static IHotwordService asInterface(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.hotword.service.IHotwordService");
      if ((localIInterface != null) && ((localIInterface instanceof IHotwordService))) {
        return (IHotwordService)localIInterface;
      }
      return new Proxy(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.hotword.service.IHotwordService");
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.hotword.service.IHotwordService");
      paramParcel2 = paramParcel1.readString();
      if (paramParcel1.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        requestHotwordDetection(paramParcel2, bool);
        return true;
      }
    }
    
    private static class Proxy
      implements IHotwordService
    {
      private IBinder mRemote;
      
      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.mRemote;
      }
      
      public String getInterfaceDescriptor()
      {
        return "com.google.android.hotword.service.IHotwordService";
      }
      
      /* Error */
      public void requestHotwordDetection(String paramString, boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_3
        //   2: invokestatic 36	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore 4
        //   7: aload 4
        //   9: ldc 26
        //   11: invokevirtual 40	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload 4
        //   16: aload_1
        //   17: invokevirtual 43	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   20: iload_2
        //   21: ifeq +30 -> 51
        //   24: aload 4
        //   26: iload_3
        //   27: invokevirtual 47	android/os/Parcel:writeInt	(I)V
        //   30: aload_0
        //   31: getfield 19	com/google/android/hotword/service/IHotwordService$Stub$Proxy:mRemote	Landroid/os/IBinder;
        //   34: iconst_1
        //   35: aload 4
        //   37: aconst_null
        //   38: iconst_1
        //   39: invokeinterface 53 5 0
        //   44: pop
        //   45: aload 4
        //   47: invokevirtual 56	android/os/Parcel:recycle	()V
        //   50: return
        //   51: iconst_0
        //   52: istore_3
        //   53: goto -29 -> 24
        //   56: astore_1
        //   57: aload 4
        //   59: invokevirtual 56	android/os/Parcel:recycle	()V
        //   62: aload_1
        //   63: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	64	0	this	Proxy
        //   0	64	1	paramString	String
        //   0	64	2	paramBoolean	boolean
        //   1	52	3	i	int
        //   5	53	4	localParcel	Parcel
        // Exception table:
        //   from	to	target	type
        //   7	20	56	finally
        //   24	45	56	finally
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/google/android/hotword/service/IHotwordService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */