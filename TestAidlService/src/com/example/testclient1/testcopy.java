/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\workspace\\TestAidlService\\src\\com\\example\\testclient1\\testcopy.aidl
 */

package com.example.testclient1;

public interface testcopy extends android.os.IInterface
{
    /** Local-side IPC implementation stub class. */
    public static abstract class Stub extends android.os.Binder implements
            com.example.testclient1.testcopy
    {
        private static final java.lang.String DESCRIPTOR = "com.example.testclient1.testcopy";

        /** Construct the stub at attach it to the interface. */
        public Stub()
        {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an com.example.testclient1.testcopy
         * interface, generating a proxy if needed.
         */
        public static com.example.testclient1.testcopy asInterface(android.os.IBinder obj)
        {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof com.example.testclient1.testcopy))) {
                return ((com.example.testclient1.testcopy) iin);
            }
            return new com.example.testclient1.testcopy.Stub.Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder()
        {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply,
                int flags) throws android.os.RemoteException
        {
            switch (code)
            {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_performAction: {
                    data.enforceInterface(DESCRIPTOR);
                    com.example.testclient1.School _arg0;
                    _arg0 = new com.example.testclient1.School();
                    this.performAction(_arg0);
                    if ((_arg0 != null)) {
                        reply.writeInt(1);
                        _arg0.writeToParcel(reply,
                                android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    }
                    else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_getAdId: {
                    data.enforceInterface(DESCRIPTOR);
                    com.example.testclient1.School _result = this.getAdId();
                    reply.writeNoException();
                    if ((_result != null)) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply,
                                android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    }
                    else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_testCall: {
                    data.enforceInterface(DESCRIPTOR);
                    java.util.List<com.example.testclient1.School> _arg0;
                    _arg0 = data.createTypedArrayList(com.example.testclient1.School.CREATOR);
                    this.testCall(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_test: {
                    data.enforceInterface(DESCRIPTOR);
                    java.util.List<com.example.testclient1.School> _result = this.test();
                    reply.writeNoException();
                    reply.writeTypedList(_result);
                    return true;
                }
                case TRANSACTION_testout: {
                    data.enforceInterface(DESCRIPTOR);
                    com.example.testclient1.School _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = com.example.testclient1.School.CREATOR.createFromParcel(data);
                    }
                    else {
                        _arg0 = null;
                    }
                    this.testout(_arg0);
                    reply.writeNoException();
                    if ((_arg0 != null)) {
                        reply.writeInt(1);
                        _arg0.writeToParcel(reply,
                                android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    }
                    else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_testArray: {
                    data.enforceInterface(DESCRIPTOR);
                    com.example.testclient1.School _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = com.example.testclient1.School.CREATOR.createFromParcel(data);
                    }
                    else {
                        _arg0 = null;
                    }
                    com.example.testclient1.School[] _result = this.testArray(_arg0);
                    reply.writeNoException();
                    reply.writeTypedArray(_result,
                            android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements com.example.testclient1.testcopy
        {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote)
            {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder()
            {
                return mRemote;
            }

            public java.lang.String getInterfaceDescriptor()
            {
                return DESCRIPTOR;
            }

            @Override
            public void performAction(com.example.testclient1.School sc)
                    throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_performAction, _data, null,
                            android.os.IBinder.FLAG_ONEWAY);
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public com.example.testclient1.School getAdId() throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                com.example.testclient1.School _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_getAdId, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        _result = com.example.testclient1.School.CREATOR.createFromParcel(_reply);
                    }
                    else {
                        _result = null;
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void testCall(java.util.List<com.example.testclient1.School> ssss)
                    throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeTypedList(ssss);
                    mRemote.transact(Stub.TRANSACTION_testCall, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public java.util.List<com.example.testclient1.School> test()
                    throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                java.util.List<com.example.testclient1.School> _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_test, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArrayList(com.example.testclient1.School.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }

            @Override
            public void testout(com.example.testclient1.School sc)
                    throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((sc != null)) {
                        _data.writeInt(1);
                        sc.writeToParcel(_data, 0);
                    }
                    else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_testout, _data, _reply, 0);
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
            public com.example.testclient1.School[] testArray(com.example.testclient1.School sc)
                    throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                com.example.testclient1.School[] _result;
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((sc != null)) {
                        _data.writeInt(1);
                        sc.writeToParcel(_data, 0);
                    }
                    else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_testArray, _data, _reply, 0);
                    _reply.readException();
                    _result = _reply.createTypedArray(com.example.testclient1.School.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
                return _result;
            }
        }

        static final int TRANSACTION_performAction = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_getAdId = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
        static final int TRANSACTION_testCall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
        static final int TRANSACTION_test = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
        static final int TRANSACTION_testout = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
        static final int TRANSACTION_testArray = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
    }

    public void performAction(com.example.testclient1.School sc) throws android.os.RemoteException;

    public com.example.testclient1.School getAdId() throws android.os.RemoteException;

    public void testCall(java.util.List<com.example.testclient1.School> ssss)
            throws android.os.RemoteException;

    public java.util.List<com.example.testclient1.School> test() throws android.os.RemoteException;

    public void testout(com.example.testclient1.School sc) throws android.os.RemoteException;

    public com.example.testclient1.School[] testArray(com.example.testclient1.School sc)
            throws android.os.RemoteException;
}
