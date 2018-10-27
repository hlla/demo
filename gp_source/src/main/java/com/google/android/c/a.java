package com.google.android.c;

public final class a
{
  public int a;
  private final byte[] b;
  
  a(byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
  }
  
  public final int a()
  {
    int i = this.a;
    this.a = (i + 4);
    byte[] arrayOfByte = this.b;
    int j = i + 1;
    int k = j + 1;
    return arrayOfByte[i] & 0xFF | (arrayOfByte[j] & 0xFF) << 8 | (arrayOfByte[k] & 0xFF) << 16 | (arrayOfByte[(k + 1)] & 0xFF) << 24;
  }
  
  public final short b()
  {
    int i = this.a;
    this.a = (i + 2);
    byte[] arrayOfByte = this.b;
    int j = arrayOfByte[i];
    return (short)((arrayOfByte[(i + 1)] & 0xFF) << 8 | j & 0xFF);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */