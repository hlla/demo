package com.google.android.gms.c;

import java.io.IOException;

public final class bd
  extends IOException
{
  private bd(String paramString)
  {
    super(paramString);
  }
  
  static bd lA()
  {
    return new bd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }
  
  static bd lB()
  {
    return new bd("CodedInputStream encountered a malformed varint.");
  }
  
  static bd lC()
  {
    return new bd("Protocol message contained an invalid tag (zero).");
  }
  
  static bd lD()
  {
    return new bd("Protocol message end-group tag did not match expected tag.");
  }
  
  static bd lE()
  {
    return new bd("Protocol message tag had invalid wire type.");
  }
  
  static bd lF()
  {
    return new bd("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }
  
  static bd lz()
  {
    return new bd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/c/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */