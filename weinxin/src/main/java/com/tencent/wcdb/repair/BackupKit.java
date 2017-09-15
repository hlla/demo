package com.tencent.wcdb.repair;

import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import java.util.Arrays;

public class BackupKit
{
  public static final int FLAG_FIX_CORRUPTION = 4;
  public static final int FLAG_INCREMENTAL = 16;
  public static final int FLAG_NO_CIPHER = 1;
  public static final int FLAG_NO_COMPRESS = 2;
  public static final int FLAG_NO_CREATE_TABLE = 8;
  public static final int RESULT_CANCELED = 1;
  public static final int RESULT_FAILED = -1;
  public static final int RESULT_OK = 0;
  static final String TAG = "WCDB.DBBackup";
  private SQLiteDatabase mDB;
  private String mLastError;
  private long mNativePtr;
  private int mStatementCount;
  private String[] mTableDesc;
  
  public BackupKit(SQLiteDatabase paramSQLiteDatabase, String paramString, byte[] paramArrayOfByte, int paramInt, String[] paramArrayOfString)
  {
    this.mDB = paramSQLiteDatabase;
    this.mLastError = null;
    this.mTableDesc = ((String[])Arrays.copyOf(paramArrayOfString, paramArrayOfString.length));
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    this.mNativePtr = nativeInit(paramString, paramArrayOfByte, paramInt);
    if (this.mNativePtr == 0L) {
      throw new SQLiteException("Failed initialize backup context.");
    }
  }
  
  private static native void nativeCancel(long paramLong);
  
  private static native void nativeFinish(long paramLong);
  
  private static native long nativeInit(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  private static native String nativeLastError(long paramLong);
  
  private static native int nativeRun(long paramLong1, long paramLong2, String[] paramArrayOfString);
  
  private static native int nativeStatementCount(long paramLong);
  
  public void cancel()
  {
    if (this.mNativePtr != 0L) {
      nativeCancel(this.mNativePtr);
    }
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
  
  public int run()
  {
    if (this.mNativePtr == 0L) {
      throw new IllegalStateException("BackupKit not initialized.");
    }
    long l = this.mDB.acquireNativeConnectionHandle("backup", false, false);
    int i = nativeRun(this.mNativePtr, l, this.mTableDesc);
    this.mDB.releaseNativeConnection(l, null);
    this.mStatementCount = nativeStatementCount(this.mNativePtr);
    this.mLastError = nativeLastError(this.mNativePtr);
    nativeFinish(this.mNativePtr);
    this.mNativePtr = 0L;
    return i;
  }
  
  public int statementCount()
  {
    return this.mStatementCount;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/wcdb/repair/BackupKit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */