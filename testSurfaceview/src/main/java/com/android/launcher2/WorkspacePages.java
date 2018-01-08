package com.android.launcher2;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class WorkspacePages
{
  private static final String PREFERENCES_EMPTYPAGES = "emptypages";
  private static boolean[] mPages = null;
  
  static boolean addPageAt(int paramInt, Context paramContext)
  {
    readPreferences(paramContext);
    if ((paramInt < 0) || (paramInt >= mPages.length)) {
      return false;
    }
    int i = paramInt + 1;
    while (i < mPages.length)
    {
      mPages[i] = mPages[(i - 1)];
      i += 1;
    }
    mPages[paramInt] = false;
    writePreferences(paramContext);
    return true;
  }
  
  static boolean deletePageAt(int paramInt, Context paramContext)
  {
    readPreferences(paramContext);
    if ((paramInt < 0) || (paramInt >= mPages.length)) {
      return false;
    }
    paramInt += 1;
    while (paramInt < mPages.length)
    {
      mPages[(paramInt - 1)] = mPages[paramInt];
      paramInt += 1;
    }
    mPages[(mPages.length - 1)] = false;
    writePreferences(paramContext);
    return true;
  }
  
  static boolean itemAddedToPage(int paramInt, Context paramContext)
  {
    boolean bool = true;
    readPreferences(paramContext);
    if ((paramInt < 0) || (paramInt >= mPages.length)) {
      bool = false;
    }
    while (mPages[paramInt] != 0) {
      return bool;
    }
    mPages[paramInt] = true;
    writePreferences(paramContext);
    return true;
  }
  
  static boolean movePage(int paramInt1, int paramInt2, Context paramContext)
  {
    readPreferences(paramContext);
    if ((paramInt1 < 0) || (paramInt1 >= mPages.length) || (paramInt2 < 0) || (paramInt2 >= mPages.length)) {
      return false;
    }
    if (paramInt1 != paramInt2)
    {
      int i = mPages[paramInt1];
      if (paramInt1 < paramInt2) {
        while (paramInt1 < paramInt2)
        {
          mPages[paramInt1] = mPages[(paramInt1 + 1)];
          paramInt1 += 1;
        }
      }
      while (paramInt1 > paramInt2)
      {
        mPages[paramInt1] = mPages[(paramInt1 - 1)];
        paramInt1 -= 1;
      }
      mPages[paramInt2] = i;
      writePreferences(paramContext);
    }
    return true;
  }
  
  static boolean pageHasAlwaysBeenEmpty(int paramInt, Context paramContext)
  {
    readPreferences(paramContext);
    return (paramInt < 0) || (paramInt >= mPages.length) || (mPages[paramInt] == 0);
  }
  
  private static void readPreferences(Context paramContext)
  {
    if (mPages != null) {}
    for (;;)
    {
      return;
      int j = LauncherApplication.getMaxScreenCount();
      int i = j;
      if (LauncherApplication.sFestivalPageLauncher) {
        i = j + LauncherApplication.getMaxFestivalScreenCount();
      }
      mPages = new boolean[i];
      i = 0;
      while (i < mPages.length)
      {
        mPages[i] = false;
        i += 1;
      }
      paramContext = paramContext.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).getString("emptypages", "");
      j = Math.min(paramContext.length(), mPages.length);
      i = 0;
      if (i < j)
      {
        boolean[] arrayOfBoolean = mPages;
        if (paramContext.charAt(i) == 't') {}
        for (int k = 1;; k = 0)
        {
          arrayOfBoolean[i] = k;
          i += 1;
          break;
        }
      }
      i = j;
      while (i < mPages.length)
      {
        mPages[i] = false;
        i += 1;
      }
    }
  }
  
  private static void writePreferences(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder(mPages.length);
    int i = 0;
    if (i < mPages.length)
    {
      if (mPages[i] != 0) {}
      for (char c = 't';; c = 'f')
      {
        localStringBuilder.append(c);
        i += 1;
        break;
      }
    }
    paramContext = paramContext.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
    paramContext.putString("emptypages", localStringBuilder.toString());
    paramContext.commit();
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/WorkspacePages.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */