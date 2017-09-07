/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/letv/workspace_app/Testanr/src/main/aidl/letv/com/testanr/ICallback.aidl
 */
package letv.com.testanr;

import android.os.Process;
import android.util.Log;

public interface ICallback extends android.os.IInterface {
    String TAG = "Testanr_ICallback";

    /**
     * Local-side IPC implementation stub class.
     */
    public static abstract class Stub extends android.os.Binder implements ICallback {
        private static final String DESCRIPTOR = "letv.com.testanr.ICallback";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an letv.com.testanr.ICallback interface,
         * generating a proxy if needed.
         */
        public static ICallback asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof ICallback))) {
                return ((ICallback) iin);
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
                            () + " ,pid=" + Process.myPid() + " this" + this,
                    exception);
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_showTYResult: {
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0;
                    _arg0 = data.readString();
                    this.showTYResult(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_showOWResult: {
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0;
                    _arg0 = data.readString();
                    this.showOWResult(_arg0);
//                    reply.writeNoException();
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements ICallback {
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
                return DESCRIPTOR;
            }

            @Override
            public void showTYResult(String result) throws android.os.RemoteException {
                Log.d(TAG, "showTYResult" + " tid=" + Thread
                        .currentThread().getId() + ",tName=" + Thread.currentThread().getName
                        () + " ,pid=" + Process.myPid());
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(result);
                    mRemote.transact(Stub.TRANSACTION_showTYResult, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void showOWResult(String result) throws android.os.RemoteException {
                Log.d(TAG, "showOWResult" + " tid=" + Thread
                        .currentThread().getId() + ",tName=" + Thread.currentThread().getName
                        () + " ,pid=" + Process.myPid());
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(result);
                    mRemote.transact(Stub.TRANSACTION_showOWResult, _data, _reply, android.os.IBinder
                            .FLAG_ONEWAY);
//                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_showTYResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_showOWResult = (android.os.IBinder.FIRST_CALL_TRANSACTION
                + 1);
    }

    public void showTYResult(String result) throws android.os.RemoteException;

    public void showOWResult(String result) throws android.os.RemoteException;
}
