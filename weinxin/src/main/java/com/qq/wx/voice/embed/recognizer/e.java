package com.qq.wx.voice.embed.recognizer;

import android.os.Handler;

public final class e
{
  public Grammar aIT = null;
  g aIU = new g();
  public byte[] c = null;
  public boolean d = false;
  public boolean e = false;
  
  public final int a(c paramc, byte[] paramArrayOfByte)
  {
    int i = 65234;
    if (!this.d) {
      i = 65232;
    }
    while (!this.e) {
      return i;
    }
    this.aIU.aIV = paramc;
    this.c = paramArrayOfByte;
    if (this.c == null) {
      return 65235;
    }
    try
    {
      new Thread(new a()).start();
      return 0;
    }
    catch (Exception paramc) {}
    return 65234;
  }
  
  private final class a
    implements Runnable
  {
    public a() {}
    
    public final void run()
    {
      if (e.this.aIT.begin() != 0)
      {
        e.this.aIU.a(-102);
        return;
      }
      if (e.this.aIT.recognize(e.this.c, e.this.c.length) != 0)
      {
        e.this.aIU.a(-103);
        return;
      }
      if (e.this.aIT.end() != 0)
      {
        e.this.aIU.a(-104);
        return;
      }
      a locala = new a();
      if (e.this.aIT.getResult(locala) != 0) {
        e.this.aIU.a(-105);
      }
      g localg = e.this.aIU;
      localg.aIW.sendMessage(localg.aIW.obtainMessage(200, locala));
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/qq/wx/voice/embed/recognizer/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */