package com.tencent.wcdb.repair;

import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;

public class RepairKit
{
  public static final int FLAG_ALL_TABLES = 2;
  public static final int FLAG_NO_CREATE_TABLES = 1;
  private static final int INTEGRITY_DATA = 2;
  private static final int INTEGRITY_HEADER = 1;
  private static final int INTEGRITY_KDF_SALT = 4;
  private int mIntegrityFlags;
  private MasterInfo mMasterInfo;
  private long mNativePtr;
  
  public RepairKit(String paramString, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, MasterInfo paramMasterInfo)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    if (paramMasterInfo == null) {}
    for (byte[] arrayOfByte = null;; arrayOfByte = paramMasterInfo.mKDFSalt)
    {
      this.mNativePtr = nativeInit(paramString, paramArrayOfByte, paramSQLiteCipherSpec, arrayOfByte);
      if (this.mNativePtr != 0L) {
        break;
      }
      throw new SQLiteException("Failed initialize RepairKit.");
    }
    this.mIntegrityFlags = nativeIntegrityFlags(this.mNativePtr);
    this.mMasterInfo = paramMasterInfo;
  }
  
  public static String lastError()
  {
    return nativeLastError();
  }
  
  private static native void nativeFini(long paramLong);
  
  public static native void nativeFreeMaster(long paramLong);
  
  private static native long nativeInit(String paramString, byte[] paramArrayOfByte1, SQLiteCipherSpec paramSQLiteCipherSpec, byte[] paramArrayOfByte2);
  
  private static native int nativeIntegrityFlags(long paramLong);
  
  private static native String nativeLastError();
  
  public static native long nativeLoadMaster(String paramString, byte[] paramArrayOfByte1, String[] paramArrayOfString, byte[] paramArrayOfByte2);
  
  public static native long nativeMakeMaster(String[] paramArrayOfString);
  
  private static native boolean nativeOutput(long paramLong1, long paramLong2, long paramLong3, int paramInt);
  
  public static native boolean nativeSaveMaster(long paramLong, String paramString, byte[] paramArrayOfByte);
  
  protected void finalize()
  {
    release();
    super.finalize();
  }
  
  public boolean isDataCorrupted()
  {
    return (this.mIntegrityFlags & 0x2) == 0;
  }
  
  public boolean isHeaderCorrupted()
  {
    return (this.mIntegrityFlags & 0x1) == 0;
  }
  
  public boolean isSaltCorrupted()
  {
    return (this.mIntegrityFlags & 0x4) == 0;
  }
  
  public boolean output(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    long l1 = 0L;
    if (this.mNativePtr == 0L) {
      throw new IllegalArgumentException();
    }
    if (this.mMasterInfo == null) {}
    for (;;)
    {
      long l2 = paramSQLiteDatabase.acquireNativeConnectionHandle("repair", false, false);
      boolean bool = nativeOutput(this.mNativePtr, l2, l1, paramInt);
      paramSQLiteDatabase.releaseNativeConnection(l2, null);
      this.mIntegrityFlags = nativeIntegrityFlags(this.mNativePtr);
      return bool;
      l1 = this.mMasterInfo.mMasterPtr;
    }
  }
  
  public void release()
  {
    if (this.mMasterInfo != null)
    {
      this.mMasterInfo.release();
      this.mMasterInfo = null;
    }
    if (this.mNativePtr != 0L)
    {
      nativeFini(this.mNativePtr);
      this.mNativePtr = 0L;
    }
  }
  
  public static class MasterInfo
  {
    public byte[] mKDFSalt;
    public long mMasterPtr;
    
    private MasterInfo(long paramLong, byte[] paramArrayOfByte)
    {
      this.mMasterPtr = paramLong;
      this.mKDFSalt = paramArrayOfByte;
    }
    
    public static MasterInfo load(String paramString, byte[] paramArrayOfByte, String[] paramArrayOfString)
    {
      if (paramString == null) {
        return make(paramArrayOfString);
      }
      byte[] arrayOfByte = new byte[16];
      long l = RepairKit.nativeLoadMaster(paramString, paramArrayOfByte, paramArrayOfString, arrayOfByte);
      if (l == 0L) {
        throw new SQLiteException("Cannot create MasterInfo.");
      }
      return new MasterInfo(l, arrayOfByte);
    }
    
    public static MasterInfo make(String[] paramArrayOfString)
    {
      long l = RepairKit.nativeMakeMaster(paramArrayOfString);
      if (l == 0L) {
        throw new SQLiteException("Cannot create MasterInfo.");
      }
      return new MasterInfo(l, null);
    }
    
    public static boolean save(SQLiteDatabase paramSQLiteDatabase, String paramString, byte[] paramArrayOfByte)
    {
      long l = paramSQLiteDatabase.acquireNativeConnectionHandle("backupMaster", true, false);
      boolean bool = RepairKit.nativeSaveMaster(l, paramString, paramArrayOfByte);
      paramSQLiteDatabase.releaseNativeConnection(l, null);
      return bool;
    }
    
    protected void finalize()
    {
      release();
      super.finalize();
    }
    
    public void release()
    {
      if (this.mMasterPtr == 0L) {
        return;
      }
      RepairKit.nativeFreeMaster(this.mMasterPtr);
      this.mMasterPtr = 0L;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/wcdb/repair/RepairKit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */