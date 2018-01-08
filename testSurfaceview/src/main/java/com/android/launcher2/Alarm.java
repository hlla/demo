package com.android.launcher2;

import android.os.Handler;
import android.os.SystemClock;

public class Alarm
  implements Runnable
{
  private OnAlarmListener mAlarmListener;
  private boolean mAlarmPending = false;
  private long mAlarmTriggerTime;
  private Handler mHandler = new Handler();
  private boolean mWaitingForCallback;
  
  public boolean alarmPending()
  {
    return this.mAlarmPending;
  }
  
  public void cancelAlarm()
  {
    this.mAlarmTriggerTime = 0L;
    this.mAlarmPending = false;
  }
  
  public void run()
  {
    this.mWaitingForCallback = false;
    if (this.mAlarmTriggerTime != 0L)
    {
      long l = SystemClock.uptimeMillis();
      if (this.mAlarmTriggerTime <= l) {
        break label52;
      }
      this.mHandler.postDelayed(this, Math.max(0L, this.mAlarmTriggerTime - l));
      this.mWaitingForCallback = true;
    }
    label52:
    do
    {
      return;
      this.mAlarmPending = false;
    } while (this.mAlarmListener == null);
    this.mAlarmListener.onAlarm(this);
  }
  
  public void setAlarm(long paramLong)
  {
    long l = SystemClock.uptimeMillis();
    this.mAlarmPending = true;
    this.mAlarmTriggerTime = (l + paramLong);
    if (!this.mWaitingForCallback)
    {
      this.mHandler.postDelayed(this, this.mAlarmTriggerTime - l);
      this.mWaitingForCallback = true;
    }
  }
  
  public void setOnAlarmListener(OnAlarmListener paramOnAlarmListener)
  {
    this.mAlarmListener = paramOnAlarmListener;
  }
  
  public static abstract interface OnAlarmListener
  {
    public abstract void onAlarm(Alarm paramAlarm);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/Alarm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */