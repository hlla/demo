package com.android.launcher2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;

public class ChameleonUpdateReceiver
  extends BroadcastReceiver
{
  private static final String ACTION_CHAMELEON_UPDATE_LAUNCHER = "android.intent.action.CSC_CHAMELEON_UPDATE_LAUNCHER";
  private static final String TAG = "Launcher.ChameleonUpdateReceiver";
  
  private void resetDBForSprint(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramContext.deleteDatabase("launcher.db"))
      {
        Log.d("Launcher.ChameleonUpdateReceiver", "Launcher Database deleted successfully");
        Process.killProcess(Process.myPid());
        Intent localIntent = new Intent(paramContext, Launcher.class);
        localIntent.setFlags(335544320);
        localIntent.setAction("android.intent.action.MAIN");
        localIntent.addFlags(2097152);
        localIntent.addCategory("android.intent.category.HOME");
        paramContext.startActivity(localIntent);
      }
    }
    else {
      return;
    }
    Log.d("Launcher.ChameleonUpdateReceiver", "Unable to delete launcher database");
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.CSC_CHAMELEON_UPDATE_LAUNCHER".equals(paramIntent.getAction()))
    {
      boolean bool = paramIntent.getBooleanExtra("delete_db", false);
      Log.d("Launcher.ChameleonUpdateReceiver", "Received CSC_CHAMELEON_UPDATE_LAUNCHER intent :: " + bool);
      paramContext = paramContext.getApplicationContext();
      if (paramContext != null) {
        resetDBForSprint(paramContext, bool);
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/ChameleonUpdateReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */