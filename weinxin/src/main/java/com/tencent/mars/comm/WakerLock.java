package com.tencent.mars.comm;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mm.jni.a.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.v;

public class WakerLock
{
  private static final String TAG = "MicroMsg.WakerLock";
  private static long lastChecktime = 0L;
  private static Boolean shouldLock = null;
  public IAutoUnlockCallback autoUnlockCallback = null;
  private Context context;
  public String mCreatePosStackLine = null;
  private ad mHandler = null;
  private Runnable mReleaser = new Runnable()
  {
    public void run()
    {
      if (WakerLock.this.wakeLock.isHeld())
      {
        v.w("MicroMsg.WakerLock", "unlock by fucking handler! [%d,%d] @[%s]", new Object[] { Integer.valueOf(WakerLock.this.hashCode()), Integer.valueOf(WakerLock.this.wakeLock.hashCode()), WakerLock.this.mCreatePosStackLine });
        WakerLock.this.unLock();
        if (WakerLock.this.autoUnlockCallback != null) {
          WakerLock.this.autoUnlockCallback.autoUnlockCallback();
        }
      }
    }
  };
  public PowerManager.WakeLock wakeLock = null;
  
  public WakerLock(Context paramContext)
  {
    this.wakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "WakerLock:" + hashCode());
    this.wakeLock.setReferenceCounted(false);
    this.mHandler = new ad(paramContext.getMainLooper());
    this.context = paramContext;
    v.i("MicroMsg.WakerLock", "init [%d,%d] @[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), this.mCreatePosStackLine });
  }
  
  public WakerLock(Context paramContext, IAutoUnlockCallback paramIAutoUnlockCallback)
  {
    this(paramContext);
    this.autoUnlockCallback = paramIAutoUnlockCallback;
  }
  
  private static final boolean checkShouldLock()
  {
    boolean bool2;
    boolean bool3;
    if ((bf.aA(lastChecktime) > 10000L) || (shouldLock == null))
    {
      bool2 = l.dY(aa.getContext());
      bool3 = l.dZ(aa.getContext());
      if ((bool2) || (bool3)) {
        break label106;
      }
    }
    label106:
    for (boolean bool1 = true;; bool1 = false)
    {
      shouldLock = Boolean.valueOf(bool1);
      v.i("MicroMsg.WakerLock", "checkShouldLock screen:%b chatging:%b res:%b checkTime:%d ", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), shouldLock, Long.valueOf(bf.aA(lastChecktime)) });
      lastChecktime = bf.NA();
      return shouldLock.booleanValue();
    }
  }
  
  private String getCallerStack()
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
      if (!localStackTraceElement.getClassName().contains(WakerLock.class.getName())) {
        return localStackTraceElement.toString();
      }
      i += 1;
    }
    return "<native>";
  }
  
  protected void finalize()
  {
    v.i("MicroMsg.WakerLock", "finalize unlock [%d,%d] @[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), this.mCreatePosStackLine });
    unLock();
    super.finalize();
  }
  
  public String getCreatePosStackLine()
  {
    return this.mCreatePosStackLine;
  }
  
  public int innerWakeLockHashCode()
  {
    return this.wakeLock.hashCode();
  }
  
  public boolean isLocking()
  {
    try
    {
      boolean bool = this.wakeLock.isHeld();
      v.i("MicroMsg.WakerLock", "check is held [%d,%d] :%b caller:[%s] @[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), Boolean.valueOf(bool), getCallerStack(), getCreatePosStackLine() });
      return bool;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.WakerLock", localException, "", new Object[] { "" });
    }
    return false;
  }
  
  public void lock()
  {
    lock(getCallerStack());
  }
  
  public void lock(long paramLong)
  {
    lock(paramLong, getCallerStack());
  }
  
  public void lock(long paramLong, String paramString)
  {
    try
    {
      if (!checkShouldLock()) {
        return;
      }
      if (this.wakeLock.isHeld()) {
        unLock();
      }
      a.a(this, paramString);
      v.i("MicroMsg.WakerLock", "lock [%d,%d] traceMsg:[%s] @[%s] limit time:%d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), paramString, getCreatePosStackLine(), Long.valueOf(paramLong) });
      this.wakeLock.acquire();
      if (paramLong == -1L)
      {
        this.mHandler.removeCallbacks(this.mReleaser);
        return;
      }
    }
    catch (Exception paramString)
    {
      v.printErrStackTrace("MicroMsg.WakerLock", paramString, "", new Object[] { "" });
      return;
    }
    this.mHandler.postDelayed(this.mReleaser, paramLong);
  }
  
  public void lock(String paramString)
  {
    lock(-1L, paramString);
  }
  
  public void unLock()
  {
    if (this.wakeLock.isHeld())
    {
      this.mHandler.removeCallbacks(this.mReleaser);
      a.c(this);
      v.i("MicroMsg.WakerLock", "unlock [%d,%d] caller:[%s] @[%s]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.wakeLock.hashCode()), getCallerStack(), getCreatePosStackLine() });
    }
    try
    {
      this.wakeLock.release();
      return;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.WakerLock", localException, "", new Object[] { "" });
    }
  }
  
  public static abstract interface IAutoUnlockCallback
  {
    public abstract void autoUnlockCallback();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mars/comm/WakerLock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */