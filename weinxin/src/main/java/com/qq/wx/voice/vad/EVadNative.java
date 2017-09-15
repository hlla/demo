package com.qq.wx.voice.vad;

public class EVadNative
{
  public native int AddData(long paramLong, short[] paramArrayOfShort, int paramInt);
  
  public native long Init(int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4);
  
  public native int Release(long paramLong);
  
  public native int Reset(long paramLong);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/qq/wx/voice/vad/EVadNative.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */