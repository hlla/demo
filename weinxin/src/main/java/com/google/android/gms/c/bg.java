package com.google.android.gms.c;

import java.util.Arrays;

final class bg
{
  final byte[] aCK;
  final int tag;
  
  bg(int paramInt, byte[] paramArrayOfByte)
  {
    this.tag = paramInt;
    this.aCK = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof bg)) {
        return false;
      }
      paramObject = (bg)paramObject;
    } while ((this.tag == ((bg)paramObject).tag) && (Arrays.equals(this.aCK, ((bg)paramObject).aCK)));
    return false;
  }
  
  public final int hashCode()
  {
    return (this.tag + 527) * 31 + Arrays.hashCode(this.aCK);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/c/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */