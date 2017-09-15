package com.tencent.qqpinyin.voicerecoapi;

public class TRVADNative
{
  public native int mfeClose();
  
  public native int mfeDetect();
  
  public native int mfeEnableNoiseDetection(boolean paramBoolean);
  
  public native int mfeExit();
  
  public native int mfeGetCallbackData(byte[] paramArrayOfByte, int paramInt);
  
  public native int mfeGetEndFrame();
  
  public native int mfeGetParam(int paramInt);
  
  public native int mfeGetStartFrame();
  
  public native int mfeInit(int paramInt1, int paramInt2);
  
  public native int mfeOpen();
  
  public native int mfeSendData(short[] paramArrayOfShort, int paramInt);
  
  public native void mfeSetLogLevel(int paramInt);
  
  public native int mfeSetParam(int paramInt1, int paramInt2);
  
  public native int mfeStart();
  
  public native int mfeStop();
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/qqpinyin/voicerecoapi/TRVADNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */