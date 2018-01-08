package com.android.launcher2;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.util.Log;

public class BadgeCountReceiver
  extends BroadcastReceiver
{
  private static final String ACTION_BADGE_COUNT_UPDATE = "android.intent.action.BADGE_COUNT_UPDATE";
  private static final String BADGECOUNT = "badgecount";
  private static final String BADGE_AUTHORITY = "com.sec.badge";
  private static final Uri BADGE_URI = Uri.parse("content://com.sec.badge/apps");
  private static final String CLASSNAME = "class";
  private static final boolean DEBUGGABLE = ;
  private static final String INTENT_DATA_BADGE_COUNT = "badge_count";
  private static final String INTENT_DATA_BADGE_COUNT_CLASS_NAME = "badge_count_class_name";
  private static final String INTENT_DATA_BADGE_COUNT_PACKAGE_NAME = "badge_count_package_name";
  private static final String PACKAGENAME = "package";
  private static final String TAG = "BadgeCountReceiver";
  private final Context mContext;
  private final ContentResolver mResolver;
  private final ContentValues mValues = new ContentValues();
  private final String[] mWhereValues = new String[2];
  
  private BadgeCountReceiver(Context paramContext)
  {
    this.mContext = paramContext;
    this.mResolver = paramContext.getContentResolver();
  }
  
  public static BadgeCountReceiver initialize(Context paramContext)
  {
    BadgeCountReceiver localBadgeCountReceiver = new BadgeCountReceiver(paramContext);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.BADGE_COUNT_UPDATE");
    paramContext.registerReceiver(localBadgeCountReceiver, localIntentFilter);
    return localBadgeCountReceiver;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i;
    String str;
    if (paramIntent.getAction().equals("android.intent.action.BADGE_COUNT_UPDATE"))
    {
      i = paramIntent.getIntExtra("badge_count", 0);
      str = paramIntent.getStringExtra("badge_count_package_name");
      paramIntent = paramIntent.getStringExtra("badge_count_class_name");
      if ((str == null) || (paramIntent == null)) {
        Log.e("BadgeCountReceiver", "packageName or className not specified");
      }
    }
    else
    {
      return;
    }
    if (DEBUGGABLE) {
      Log.d("BadgeCountReceiver", "packageName: " + str + ", className: " + paramIntent + ", count: " + i);
    }
    paramContext = paramIntent;
    if ("KDI".equals(Launcher.readSalesCode()))
    {
      paramContext = paramIntent;
      if ("com.kddi.android.cmail".equals(str)) {
        paramContext = "com.kddi.android.cmail.ui.list.ThreadListActivity";
      }
    }
    this.mValues.clear();
    this.mValues.put("badgecount", Integer.valueOf(i));
    this.mWhereValues[0] = str;
    this.mWhereValues[1] = paramContext;
    if (this.mResolver.update(BADGE_URI, this.mValues, "package=? AND class=?", this.mWhereValues) == 0)
    {
      this.mValues.put("package", str);
      this.mValues.put("class", paramContext);
      this.mResolver.insert(BADGE_URI, this.mValues);
    }
    this.mValues.clear();
    paramContext = this.mWhereValues;
    this.mWhereValues[1] = null;
    paramContext[0] = null;
  }
  
  public void unregister()
  {
    this.mContext.unregisterReceiver(this);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/BadgeCountReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */