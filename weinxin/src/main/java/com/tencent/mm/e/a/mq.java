package com.tencent.mm.e.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.b.b;

public final class mq
  extends b
{
  public a fTM;
  
  public mq()
  {
    this((byte)0);
    GMTrace.i(4250541228032L, 31669);
    GMTrace.o(4250541228032L, 31669);
  }
  
  private mq(byte paramByte)
  {
    GMTrace.i(4250675445760L, 31670);
    this.fTM = new a();
    this.uqr = false;
    this.nDP = null;
    GMTrace.o(4250675445760L, 31670);
  }
  
  public static final class a
  {
    public Context context;
    public Intent intent;
    
    public a()
    {
      GMTrace.i(4355902144512L, 32454);
      GMTrace.o(4355902144512L, 32454);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/a/mq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */