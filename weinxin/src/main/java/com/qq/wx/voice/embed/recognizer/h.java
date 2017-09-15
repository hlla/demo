package com.qq.wx.voice.embed.recognizer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

final class h
  extends Handler
{
  h(g paramg) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      int i = paramMessage.getData().getInt("errorCode");
      this.aIU.aIV.cO(i);
      return;
    }
    paramMessage = (a)paramMessage.obj;
    this.aIU.aIV.a(paramMessage);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/qq/wx/voice/embed/recognizer/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */