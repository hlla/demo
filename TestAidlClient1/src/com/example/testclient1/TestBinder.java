package com.example.testclient1;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class TestBinder extends Binder implements test {
    private static final java.lang.String DESCRIPTOR = "test";

    public static test b(IBinder iBinder) {

        if ((iBinder == null)) {
            return null;
        }
        android.os.IInterface iin = iBinder.queryLocalInterface(DESCRIPTOR);
        if (((iin != null) && (iin instanceof test))) {
            return ((test) iin);
        }
        return new Proxy(iBinder);
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags)
            throws RemoteException {
        String str2;
        switch (code) {
        case Proxy.TRANSACTION_performAction: {
            data.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            performAction();
            // boolean bool1 = 0 != data.readInt();
            // boolean bool2 = a(bool1);
            // reply.writeNoException();
            // reply.writeInt(bool2 ? 1 : 0);
            return true;
        }
        case Proxy.TRANSACTION_getAdId: {
            data.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            int adid = getAdId();
            reply.writeNoException();
            reply.writeInt(adid);
            return true;
        }

        }
        return super.onTransact(code, data, reply, flags);
    }

    static class Proxy implements test {
        private android.os.IBinder mRemote;
        static final int TRANSACTION_performAction = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_getAdId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);

        Proxy(android.os.IBinder remote) {
            mRemote = remote;
        }

        @Override
        public android.os.IBinder asBinder() {
            return mRemote;
        }

        public java.lang.String getInterfaceDescriptor() {
            return DESCRIPTOR;
        }

        @Override
        public void performAction() throws android.os.RemoteException {
            android.os.Parcel _data = android.os.Parcel.obtain();
            android.os.Parcel _reply = android.os.Parcel.obtain();
            try {
                _data.writeInterfaceToken(DESCRIPTOR);
                mRemote.transact(TRANSACTION_performAction, _data, _reply, 0);
                _reply.readException();
            } finally {
                _reply.recycle();
                _data.recycle();
            }
        }

        @Override
        public int getAdId() throws android.os.RemoteException {
            android.os.Parcel _data = android.os.Parcel.obtain();
            android.os.Parcel _reply = android.os.Parcel.obtain();
            int _result;
            try {
                _data.writeInterfaceToken(DESCRIPTOR);
                mRemote.transact(TRANSACTION_getAdId, _data, _reply, 0);
                _reply.readException();
                _result = _reply.readInt();
            } finally {
                _reply.recycle();
                _data.recycle();
            }
            return _result;
        }

        @Override
        public void testCall() throws RemoteException {
            // TODO Auto-generated method stub

        }
    }
}