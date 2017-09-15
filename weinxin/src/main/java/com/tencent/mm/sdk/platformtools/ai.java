package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.gmtrace.GMTrace;

public class ai
  extends ad
{
  private static int uqZ;
  private final boolean iVV;
  private boolean mStop;
  private long urK;
  private final a urL;
  private final int ura;
  
  public ai(Looper paramLooper, a parama, boolean paramBoolean)
  {
    super(paramLooper);
    GMTrace.i(13877710422016L, 103397);
    this.urK = 0L;
    this.mStop = false;
    this.urL = parama;
    this.ura = bJf();
    this.iVV = paramBoolean;
    if (paramLooper.getThread().getName().equals("initThread")) {
      v.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", new Object[] { bf.bJP() });
    }
    GMTrace.o(13877710422016L, 103397);
  }
  
  public ai(a parama, boolean paramBoolean)
  {
    GMTrace.i(13877576204288L, 103396);
    this.urK = 0L;
    this.mStop = false;
    this.urL = parama;
    this.ura = bJf();
    this.iVV = paramBoolean;
    if (getLooper().getThread().getName().equals("initThread")) {
      v.e("MicroMsg.MTimerHandler", "MTimerHandler can not init handler with initThread looper, stack %s", new Object[] { bf.bJP() });
    }
    GMTrace.o(13877576204288L, 103396);
  }
  
  private static int bJf()
  {
    GMTrace.i(13877844639744L, 103398);
    if (uqZ >= 8192) {
      uqZ = 0;
    }
    int i = uqZ + 1;
    uqZ = i;
    GMTrace.o(13877844639744L, 103398);
    return i;
  }
  
  public final void KI()
  {
    GMTrace.i(13878247292928L, 103401);
    removeMessages(this.ura);
    this.mStop = true;
    GMTrace.o(13878247292928L, 103401);
  }
  
  public final boolean bJg()
  {
    GMTrace.i(13878515728384L, 103403);
    if ((this.mStop) || (!hasMessages(this.ura)))
    {
      GMTrace.o(13878515728384L, 103403);
      return true;
    }
    GMTrace.o(13878515728384L, 103403);
    return false;
  }
  
  protected void finalize()
  {
    GMTrace.i(13877978857472L, 103399);
    KI();
    super.finalize();
    GMTrace.o(13877978857472L, 103399);
  }
  
  public void handleMessage(Message paramMessage)
  {
    GMTrace.i(13878113075200L, 103400);
    if (paramMessage.what == this.ura)
    {
      if (this.urL == null)
      {
        GMTrace.o(13878113075200L, 103400);
        return;
      }
      if (!this.urL.oQ())
      {
        GMTrace.o(13878113075200L, 103400);
        return;
      }
      if ((this.iVV) && (!this.mStop)) {
        sendEmptyMessageDelayed(this.ura, this.urK);
      }
    }
    GMTrace.o(13878113075200L, 103400);
  }
  
  public String toString()
  {
    GMTrace.i(13878649946112L, 103404);
    if (this.urL == null)
    {
      str = "MTimerHandler(" + getClass().getName() + "){mCallBack = null}";
      GMTrace.o(13878649946112L, 103404);
      return str;
    }
    String str = "MTimerHandler(" + getClass().getName() + "){mCallBack = " + this.urL.getClass().getName() + "}";
    GMTrace.o(13878649946112L, 103404);
    return str;
  }
  
  public final void v(long paramLong1, long paramLong2)
  {
    GMTrace.i(13878381510656L, 103402);
    this.urK = paramLong2;
    KI();
    this.mStop = false;
    sendEmptyMessageDelayed(this.ura, paramLong1);
    GMTrace.o(13878381510656L, 103402);
  }
  
  public static abstract interface a
  {
    public abstract boolean oQ();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */