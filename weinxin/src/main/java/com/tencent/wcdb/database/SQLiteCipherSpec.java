package com.tencent.wcdb.database;

public class SQLiteCipherSpec
{
  public static final String CIPHER_AES256CBC = "aes-256-cbc";
  public static final String CIPHER_DEVLOCK = "devlock";
  public static final String CIPHER_XXTEA = "xxtea";
  public String cipher;
  public boolean hmacEnabled = true;
  public int kdfIteration;
  public int pageSize = SQLiteGlobal.defaultPageSize;
  
  public SQLiteCipherSpec() {}
  
  public SQLiteCipherSpec(SQLiteCipherSpec paramSQLiteCipherSpec)
  {
    this.cipher = paramSQLiteCipherSpec.cipher;
    this.kdfIteration = paramSQLiteCipherSpec.kdfIteration;
    this.hmacEnabled = paramSQLiteCipherSpec.hmacEnabled;
    this.pageSize = paramSQLiteCipherSpec.pageSize;
  }
  
  public SQLiteCipherSpec setCipher(String paramString)
  {
    this.cipher = paramString;
    return this;
  }
  
  public SQLiteCipherSpec setKDFIteration(int paramInt)
  {
    this.kdfIteration = paramInt;
    return this;
  }
  
  public SQLiteCipherSpec setPageSize(int paramInt)
  {
    this.pageSize = paramInt;
    return this;
  }
  
  public SQLiteCipherSpec setSQLCipherVersion(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unsupported SQLCipher version: " + paramInt);
    case 1: 
      this.hmacEnabled = false;
      this.kdfIteration = 4000;
      return this;
    case 2: 
      this.hmacEnabled = true;
      this.kdfIteration = 4000;
      return this;
    }
    this.hmacEnabled = true;
    this.kdfIteration = 64000;
    return this;
  }
  
  public SQLiteCipherSpec withHMACEnabled(boolean paramBoolean)
  {
    this.hmacEnabled = paramBoolean;
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/wcdb/database/SQLiteCipherSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */