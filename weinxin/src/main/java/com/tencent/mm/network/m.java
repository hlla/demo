package com.tencent.mm.network;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.gmtrace.GMTrace;

public abstract interface m
  extends IInterface
{
  public abstract void cU(int paramInt);
  
  public static abstract class a
    extends Binder
    implements m
  {
    public a()
    {
      GMTrace.i(13669807161344L, 101848);
      attachInterface(this, "com.tencent.mm.network.IOnNetworkChange_AIDL");
      GMTrace.o(13669807161344L, 101848);
    }
    
    public static m E(IBinder paramIBinder)
    {
      GMTrace.i(13669941379072L, 101849);
      if (paramIBinder == null)
      {
        GMTrace.o(13669941379072L, 101849);
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.tencent.mm.network.IOnNetworkChange_AIDL");
      if ((localIInterface != null) && ((localIInterface instanceof m)))
      {
        paramIBinder = (m)localIInterface;
        GMTrace.o(13669941379072L, 101849);
        return paramIBinder;
      }
      paramIBinder = new a(paramIBinder);
      GMTrace.o(13669941379072L, 101849);
      return paramIBinder;
    }
    
    public IBinder asBinder()
    {
      GMTrace.i(13670075596800L, 101850);
      GMTrace.o(13670075596800L, 101850);
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      GMTrace.i(13670209814528L, 101851);
      switch (paramInt1)
      {
      default: 
        boolean bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
        GMTrace.o(13670209814528L, 101851);
        return bool;
      case 1598968902: 
        paramParcel2.writeString("com.tencent.mm.network.IOnNetworkChange_AIDL");
        GMTrace.o(13670209814528L, 101851);
        return true;
      }
      paramParcel1.enforceInterface("com.tencent.mm.network.IOnNetworkChange_AIDL");
      cU(paramParcel1.readInt());
      paramParcel2.writeNoException();
      GMTrace.o(13670209814528L, 101851);
      return true;
    }
    
    private static final class a
      implements m
    {
      private IBinder mRemote;
      
      a(IBinder paramIBinder)
      {
        GMTrace.i(13655177428992L, 101739);
        this.mRemote = paramIBinder;
        GMTrace.o(13655177428992L, 101739);
      }
      
      public final IBinder asBinder()
      {
        GMTrace.i(13655311646720L, 101740);
        IBinder localIBinder = this.mRemote;
        GMTrace.o(13655311646720L, 101740);
        return localIBinder;
      }
      
      public final void cU(int paramInt)
      {
        GMTrace.i(13655445864448L, 101741);
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.tencent.mm.network.IOnNetworkChange_AIDL");
          localParcel1.writeInt(paramInt);
          this.mRemote.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          localParcel2.recycle();
          localParcel1.recycle();
          GMTrace.o(13655445864448L, 101741);
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/network/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */