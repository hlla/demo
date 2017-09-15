package com.tencent.b.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;
import org.json.JSONObject;

public class i
{
  private static i aQo = null;
  static f aQp = null;
  public static volatile long aQq = 0L;
  static h aQr = null;
  public static Context mContext = null;
  public static Handler mHandler = null;
  public g aQs = null;
  
  private i(Context paramContext)
  {
    HandlerThread localHandlerThread = new HandlerThread(i.class.getSimpleName());
    localHandlerThread.start();
    mHandler = new Handler(localHandlerThread.getLooper());
    paramContext = paramContext.getApplicationContext();
    mContext = paramContext;
    aQq = PreferenceManager.getDefaultSharedPreferences(paramContext).getLong("__MID_LAST_CHECK_TIME__", 0L);
  }
  
  public static i R(Context paramContext)
  {
    if (aQo == null) {}
    try
    {
      if (aQo == null) {
        aQo = new i(paramContext);
      }
      return aQo;
    }
    finally {}
  }
  
  public static void a(f paramf)
  {
    aQp = paramf;
  }
  
  public final String nO()
  {
    if ((this.aQs == null) || (!s.aK(this.aQs.aQm)))
    {
      this.aQs = r.T(mContext).nS();
      if (!s.aK(this.aQs.aQm)) {
        break label100;
      }
    }
    label100:
    for (int i = 2;; i = 1)
    {
      if (mHandler != null) {
        mHandler.post(new n(mContext, i));
      }
      new StringBuilder("wx get mid:").append(this.aQs.aQm);
      return this.aQs.aQm;
    }
  }
  
  public final String nP()
  {
    if ((this.aQs == null) || (!s.aK(this.aQs.aQm))) {
      this.aQs = r.T(mContext).nS();
    }
    return this.aQs.aQm;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/b/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */