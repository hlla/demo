package com.android.launcher2;

import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BadgeCache
{
  private static final String[] BADGE_COLUMNS;
  public static final Uri BADGE_URI;
  private static final boolean DEBUGGABLE = ;
  private static final int INITIAL_BADGE_CAPACITY = 20;
  private static final String TAG = "BadgeCache";
  public static final String[][] USING_BADGE_APPS_LIST;
  private static final Integer ZERO;
  private final Application mApp;
  private final Map<ComponentName, Integer> mBadges = new HashMap(20);
  
  static
  {
    BADGE_URI = Uri.parse("content://com.sec.badge/apps");
    BADGE_COLUMNS = new String[] { "package", "class", "badgecount" };
    ZERO = Integer.valueOf(0);
    String[] arrayOfString1 = { "com.android.mms", "com.android.mms.ui.ConversationComposer" };
    String[] arrayOfString2 = { "com.android.contacts", "com.android.dialer.DialtactsActivity" };
    String[] arrayOfString3 = { "com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.SamsungAppsMainActivity" };
    String[] arrayOfString4 = { "com.samsung.contacts", "com.samsung.contacts.activities.DialtactsActivity" };
    String[] arrayOfString5 = { "com.android.jcontacts", "com.android.jcontacts.activities.DialtactsActivity" };
    USING_BADGE_APPS_LIST = new String[][] { arrayOfString1, { "com.android.email", "com.android.email.activity.Welcome" }, arrayOfString2, arrayOfString3, arrayOfString4, arrayOfString5 };
  }
  
  public BadgeCache(Application paramApplication)
  {
    this.mApp = paramApplication;
  }
  
  int getBadgeCount(ComponentName paramComponentName)
  {
    int i = 0;
    paramComponentName = (Integer)this.mBadges.get(paramComponentName);
    if (paramComponentName != null) {
      i = paramComponentName.intValue();
    }
    return i;
  }
  
  Map<ComponentName, Integer> updateBadgeCounts()
  {
    Object localObject1 = Collections.emptyMap();
    Cursor localCursor = this.mApp.getContentResolver().query(BADGE_URI, BADGE_COLUMNS, null, null, null);
    if (localCursor != null)
    {
      localObject1 = this.mBadges.entrySet().iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((Map.Entry)((Iterator)localObject1).next()).setValue(ZERO);
      }
      localObject1 = new boolean[USING_BADGE_APPS_LIST.length];
      label141:
      label285:
      label361:
      while (localCursor.moveToNext())
      {
        Object localObject2 = localCursor.getString(0);
        String str = localCursor.getString(1);
        int m = localCursor.getInt(2);
        if ((localObject2 != null) && (str != null))
        {
          int k = -1;
          int i = 0;
          int j = k;
          if (i < USING_BADGE_APPS_LIST.length)
          {
            if ((USING_BADGE_APPS_LIST[i][0].equals(localObject2)) && (USING_BADGE_APPS_LIST[i][1].equals(str))) {
              j = i;
            }
          }
          else
          {
            if (DEBUGGABLE) {
              Log.d("BadgeCache", "1. updateBadgeCounts: " + (String)localObject2 + " = " + m);
            }
            if (m > 0)
            {
              if ((j < 0) || (localObject1[j] == 0)) {
                break label285;
              }
              Log.e("BadgeCache", "2. Do not updateBadgeCounts!!, multiple data for appIndex=" + j);
            }
          }
          for (;;)
          {
            if (j < 0) {
              break label361;
            }
            localObject1[j] = 1;
            break;
            i += 1;
            break label141;
            localObject2 = new ComponentName((String)localObject2, str);
            this.mBadges.put(localObject2, Integer.valueOf(m));
            if (DEBUGGABLE) {
              Log.d("BadgeCache", "2. updateBadgeCounts: " + ((ComponentName)localObject2).flattenToShortString() + " = " + m);
            }
          }
        }
      }
      localCursor.close();
      localObject1 = Collections.unmodifiableMap(this.mBadges);
    }
    return (Map<ComponentName, Integer>)localObject1;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/BadgeCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */