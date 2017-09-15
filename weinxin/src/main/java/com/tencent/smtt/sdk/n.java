package com.tencent.smtt.sdk;

import android.os.HandlerThread;

final class n
  extends HandlerThread
{
  private static n wSR;
  
  private n(String paramString)
  {
    super(paramString);
  }
  
  public static n cep()
  {
    try
    {
      if (wSR == null)
      {
        localn = new n("TbsHandlerThread");
        wSR = localn;
        localn.start();
      }
      n localn = wSR;
      return localn;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */