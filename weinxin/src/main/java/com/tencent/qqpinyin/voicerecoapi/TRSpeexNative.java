package com.tencent.qqpinyin.voicerecoapi;

public class TRSpeexNative
{
  public native int nativeTRSpeexDecode(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2);
  
  public native int nativeTRSpeexDecodeInit();
  
  public native int nativeTRSpeexDecodeRelease(int paramInt);
  
  native int nativeTRSpeexEncode(int paramInt1, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2);
  
  native int nativeTRSpeexInit();
  
  native int nativeTRSpeexRelease(int paramInt);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/qqpinyin/voicerecoapi/TRSpeexNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */