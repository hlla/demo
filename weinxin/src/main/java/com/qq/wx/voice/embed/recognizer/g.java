package com.qq.wx.voice.embed.recognizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

final class g
{
  public c aIV;
  Handler aIW = new h(this);
  
  public final void a(int paramInt)
  {
    Message localMessage = this.aIW.obtainMessage(100);
    Bundle localBundle = new Bundle();
    localBundle.putInt("errorCode", paramInt);
    localMessage.setData(localBundle);
    this.aIW.sendMessage(localMessage);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/qq/wx/voice/embed/recognizer/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */