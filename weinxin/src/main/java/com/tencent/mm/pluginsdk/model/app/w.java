package com.tencent.mm.pluginsdk.model.app;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.network.j;
import com.tencent.mm.y.b;

public abstract class w
  implements j
{
  public b lbI;
  
  public w()
  {
    GMTrace.i(812419907584L, 6053);
    GMTrace.o(812419907584L, 6053);
  }
  
  public abstract byte[] aBo();
  
  public abstract void ar(byte[] paramArrayOfByte);
  
  public abstract int getType();
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */