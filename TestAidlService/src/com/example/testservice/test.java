/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\workspace\\TestAidlService\\src\\com\\example\\testservice\\test.aidl
 */
package com.example.testservice;

import android.util.Log;

public interface test extends android.os.IInterface {
    static final String TAG = "service_test";

    /** Local-side IPC implementation stub class. */
    public static abstract class Stub extends android.os.Binder implements
            com.example.testservice.test {
        private static final java.lang.String DESCRIPTOR = "com.example.testservice.test";

        /** Construct the stub at attach it to the interface. */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an com.example.testservice.test
         * interface, generating a proxy if needed.
         */
        public static com.example.testservice.test asInterface(
                android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof com.example.testservice.test))) {
                return ((com.example.testservice.test) iin);
            }
            return new com.example.testservice.test.Stub.Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data,
                android.os.Parcel reply, int flags)
                throws android.os.RemoteException {
            switch (code) {
            case INTERFACE_TRANSACTION: {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            case TRANSACTION_performAction: {
                Log.d(TAG, "onTransact performAction 1");
                data.enforceInterface(DESCRIPTOR);
                Log.d(TAG, "onTransact performAction 2");
                this.performAction();
                Log.d(TAG, "onTransact performAction 3");
                return true;
            }
            case TRANSACTION_getAdId: {
                data.enforceInterface(DESCRIPTOR);
                int _result = this.getAdId();
                reply.writeNoException();
                reply.writeInt(_result);
                return true;
            }
            case TRANSACTION_testCall: {
                Log.d(TAG, "onTransact testCall 1");
                data.enforceInterface(DESCRIPTOR);
                Log.d(TAG, "onTransact testCall 2");
                this.testCall();
                Log.d(TAG, "onTransact testCall 3");
                reply.writeNoException();
                return true;
            }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements com.example.testservice.test {
            private android.os.IBinder mRemote;

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
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_performAction, _data,
                            null, android.os.IBinder.FLAG_ONEWAY);
                } finally {
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
                    mRemote.transact(Stub.TRANSACTION_getAdId, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.readInt();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void testCall() throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_testCall, _data, _reply,
                            0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_performAction = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_getAdId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
        static final int TRANSACTION_testCall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    }

    public void performAction() throws android.os.RemoteException;

    public int getAdId() throws android.os.RemoteException;

    public void testCall() throws android.os.RemoteException;
}
