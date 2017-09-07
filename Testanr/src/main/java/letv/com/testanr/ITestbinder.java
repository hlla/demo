/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/letv/workspace_app/Testanr/src/main/aidl/letv/com/testanr/ITestbinder.aidl
 */
package letv.com.testanr;

import android.os.Process;
import android.util.Log;

public interface ITestbinder extends android.os.IInterface {
    String TAG = "Testanr_ITestbinder";

    /**
     * Local-side IPC implementation stub class.
     */
    public static abstract class Stub extends android.os.Binder implements ITestbinder {
        private static final String DESCRIPTOR = "letv.com.testanr.ITestbinder";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an letv.com.testanr.ITestbinder interface,
         * generating a proxy if needed.
         */
        public static ITestbinder asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof ITestbinder))) {
                return ((ITestbinder) iin);
            }
            return new Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int
                flags) throws android.os.RemoteException {
            Exception exception = new Exception("onTransact");
            exception.printStackTrace();
            Log.d(TAG, "onTransact: code=" + code + " reply=" + reply + " tid=" + Thread
                            .currentThread().getId() + ",tName=" + Thread.currentThread().getName
                            () + " ,pid=" + Process.myPid() + " this=" + this,
                    exception);
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_getAdId: {
                    data.enforceInterface(DESCRIPTOR);
                    java.lang.String _arg0;
                    _arg0 = data.readString();
                    int _result = this.getAdId(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                }
                case TRANSACTION_testCall: {
                    data.enforceInterface(DESCRIPTOR);
                    java.util.List<letv.com.testanr.School> _arg0;
                    _arg0 = data.createTypedArrayList(letv.com.testanr.School.CREATOR);
                    this.testCall(_arg0);
                    return true;
                }
                case TRANSACTION_test: {
                    data.enforceInterface(DESCRIPTOR);
                    letv.com.testanr.School _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = letv.com.testanr.School.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    java.util.List<letv.com.testanr.School> _result = this.test(_arg0);
                    reply.writeNoException();
                    reply.writeTypedList(_result);
                    return true;
                }
                case TRANSACTION_testSchool: {
                    data.enforceInterface(DESCRIPTOR);
                    letv.com.testanr.School _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = letv.com.testanr.School.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    this.testSchool(_arg0);
                    reply.writeNoException();
                    if ((_arg0 != null)) {
                        reply.writeInt(1);
                        _arg0.writeToParcel(reply, android.os.Parcelable
                                .PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_testArray: {
                    data.enforceInterface(DESCRIPTOR);
                    letv.com.testanr.School _arg0;
                    _arg0 = new letv.com.testanr.School();
                    letv.com.testanr.School[] _result = this.testArray(_arg0);
                    reply.writeNoException();
                    reply.writeTypedArray(_result, android.os.Parcelable
                            .PARCELABLE_WRITE_RETURN_VALUE);
                    if ((_arg0 != null)) {
                        reply.writeInt(1);
                        _arg0.writeToParcel(reply, android.os.Parcelable
                                .PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_unregisterCallback: {
                    data.enforceInterface(DESCRIPTOR);
                    letv.com.testanr.ICallback _arg0;
                    _arg0 = letv.com.testanr.ICallback.Stub.asInterface(data.readStrongBinder());
                    this.unregisterCallback(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_registerCallback: {
                    Log.d(TAG, "onTransact: register 1");
                    data.enforceInterface(DESCRIPTOR);
                    letv.com.testanr.ICallback _arg0;
                    _arg0 = letv.com.testanr.ICallback.Stub.asInterface(data.readStrongBinder());
                    this.registerCallback(_arg0);
                    reply.writeNoException();
                    Log.d(TAG, "onTransact: register 2");
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements ITestbinder {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                Exception exception = new Exception("asBinder");
                exception.printStackTrace();
                Log.d(TAG, "asBinder: mRemote=" + mRemote + " tid=" + Thread
                        .currentThread().getId() + ",tName=" + Thread.currentThread().getName
                        () + " ,pid=" + Process.myPid(), exception);
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                Exception exception = new Exception("onTransact");
                exception.printStackTrace();
                Log.d(TAG, "getInterfaceDescriptor" + " tid=" + Thread
                        .currentThread().getId() + ",tName=" + Thread.currentThread().getName
                        () + " ,pid=" + Process.myPid(), exception);
                return DESCRIPTOR;
            }

            @Override
            public int getAdId(java.lang.String aa) throws android.os.RemoteException {
                Log.d(TAG, "getAdId" + " tid=" + Thread
                        .currentThread().getId() + ",tName=" + Thread.currentThread().getName
                        () + " ,pid=" + Process.myPid());
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                int _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(aa);
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
            public void testCall(java.util.List<School> ssss) throws android.os.RemoteException {
                Log.d(TAG, "testCall" + " tid=" + Thread
                        .currentThread().getId() + ",tName=" + Thread.currentThread().getName
                        () + " ,pid=" + Process.myPid());
                android.os.Parcel _data = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeTypedList(ssss);
                    mRemote.transact(Stub.TRANSACTION_testCall, _data, null, android.os.IBinder
                            .FLAG_ONEWAY);
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public java.util.List<letv.com.testanr.School> test(letv.com.testanr.School sc)
                    throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.util.List<letv.com.testanr.School> _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((sc != null)) {
                        _data.writeInt(1);
                        sc.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_test, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(letv.com.testanr.School.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void testSchool(letv.com.testanr.School sc) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                Log.d(TAG, "testSchool" + " tid=" + Thread
                        .currentThread().getId() + ",tName=" + Thread.currentThread().getName
                        () + " ,pid=" + Process.myPid());
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((sc != null)) {
                        _data.writeInt(1);
                        sc.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_testSchool, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        sc.readFromParcel(_reply);
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public letv.com.testanr.School[] testArray(letv.com.testanr.School sc) throws android
                    .os.RemoteException {
                Log.d(TAG, "testArray" + " tid=" + Thread
                        .currentThread().getId() + ",tName=" + Thread.currentThread().getName
                        () + " ,pid=" + Process.myPid());
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                letv.com.testanr.School[] _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_testArray, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArray(letv.com.testanr.School.CREATOR);
                    if ((0 != _reply.readInt())) {
                        sc.readFromParcel(_reply);
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void unregisterCallback(letv.com.testanr.ICallback cb) throws android.os
                    .RemoteException {
                Log.d(TAG, "unregisterCallback" + " tid=" + Thread
                        .currentThread().getId() + ",tName=" + Thread.currentThread().getName
                        () + " ,pid=" + Process.myPid());
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((cb != null)) ? (cb.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_unregisterCallback, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void registerCallback(letv.com.testanr.ICallback cb) throws android.os
                    .RemoteException {
                Log.d(TAG, "registerCallback" + " tid=" + Thread
                        .currentThread().getId() + ",tName=" + Thread.currentThread().getName
                        () + " ,pid=" + Process.myPid());
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((cb != null)) ? (cb.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_registerCallback, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_getAdId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_testCall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
        static final int TRANSACTION_test = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
        static final int TRANSACTION_testSchool = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
        static final int TRANSACTION_testArray = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
        static final int TRANSACTION_unregisterCallback = (android.os.IBinder
                .FIRST_CALL_TRANSACTION + 5);
        static final int TRANSACTION_registerCallback = (android.os.IBinder
                .FIRST_CALL_TRANSACTION + 6);
    }

    public int getAdId(java.lang.String aa) throws android.os.RemoteException;

    public void testCall(java.util.List<letv.com.testanr.School> ssss) throws android.os
            .RemoteException;

    public java.util.List<letv.com.testanr.School> test(letv.com.testanr.School sc) throws
            android.os.RemoteException;

    public void testSchool(letv.com.testanr.School sc) throws android.os.RemoteException;

    public letv.com.testanr.School[] testArray(letv.com.testanr.School sc) throws android.os
            .RemoteException;

    public void unregisterCallback(letv.com.testanr.ICallback cb) throws android.os.RemoteException;

    public void registerCallback(letv.com.testanr.ICallback cb) throws android.os.RemoteException;
}
