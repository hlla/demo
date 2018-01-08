package com.android.common.userhappiness;

import android.content.Context;
import android.content.Intent;

public class UserHappinessSignals
{
  private static boolean mHasVoiceLoggingInfo = false;
  
  public static void setHasVoiceLoggingInfo(boolean paramBoolean)
  {
    mHasVoiceLoggingInfo = paramBoolean;
  }
  
  public static void userAcceptedImeText(Context paramContext)
  {
    if (mHasVoiceLoggingInfo)
    {
      Intent localIntent = new Intent("com.android.common.speech.LOG_EVENT");
      localIntent.putExtra("app_name", "voiceime");
      localIntent.putExtra("extra_event", 21);
      localIntent.putExtra("", paramContext.getPackageName());
      localIntent.putExtra("timestamp", System.currentTimeMillis());
      paramContext.sendBroadcast(localIntent);
      setHasVoiceLoggingInfo(false);
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/common/userhappiness/UserHappinessSignals.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */