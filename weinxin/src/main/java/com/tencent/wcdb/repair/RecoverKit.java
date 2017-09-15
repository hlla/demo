package com.tencent.wcdb.repair;

import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;

public class RecoverKit
{
  public static final int RESULT_CANCELED = 1;
  public static final int RESULT_FAILED = -1;
  public static final int RESULT_OK = 0;
  static final String TAG = "WCDB.DBBackup";
  private SQLiteDatabase mDB;
  private int mFailedCount;
  private String mLastError;
  private long mNativePtr;
  private int mSuccessCount;
  
  public RecoverKit(SQLiteDatabase paramSQLiteDatabase, String paramString, byte[] paramArrayOfByte)
  {
    this.mDB = paramSQLiteDatabase;
    this.mLastError = null;
    this.mNativePtr = nativeInit(paramString, paramArrayOfByte);
    if (this.mNativePtr == 0L) {
      throw new SQLiteException("Failed initialize recover context.");
    }
  }
  
  private static native void nativeCancel(long paramLong);
  
  private static native int nativeFailureCount(long paramLong);
  
  private static native void nativeFinish(long paramLong);
  
  private static native long nativeInit(String paramString, byte[] paramArrayOfByte);
  
  private static native String nativeLastError(long paramLong);
  
  private static native int nativeRun(long paramLong1, long paramLong2, boolean paramBoolean);
  
  private static native int nativeSuccessCount(long paramLong);
  
  public void cancel()
  {
    if (this.mNativePtr != 0L) {
      nativeCancel(this.mNativePtr);
    }
  }
  
  public int failureCount()
  {
    return this.mFailedCount;
  }
  
  protected void finalize()
  {
    release();
    super.finalize();
  }
  
  public String lastError()
  {
    return this.mLastError;
  }
  
  public void release()
  {
    if (this.mNativePtr != 0L)
    {
      nativeFinish(this.mNativePtr);
      this.mNativePtr = 0L;
    }
  }
  
  public int run(boolean paramBoolean)
  {
    if (this.mNativePtr == 0L) {
      throw new IllegalStateException("RecoverKit not initialized.");
    }
    long l = this.mDB.acquireNativeConnectionHandle("recover", false, false);
    int i = nativeRun(this.mNativePtr, l, paramBoolean);
    this.mDB.releaseNativeConnection(l, null);
    this.mSuccessCount = nativeSuccessCount(this.mNativePtr);
    this.mFailedCount = nativeFailureCount(this.mNativePtr);
    this.mLastError = nativeLastError(this.mNativePtr);
    nativeFinish(this.mNativePtr);
    this.mNativePtr = 0L;
    return i;
  }
  
  public int successCount()
  {
    return this.mSuccessCount;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/wcdb/repair/RecoverKit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */