package com.android.launcher2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.widget.Toast;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InstallShortcutReceiver
  extends BroadcastReceiver
{
  public static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
  public static final String SHORTCUT_MIMETYPE = "com.android.launcher/shortcut";
  private static final int[] mCoordinates = new int[2];
  private static int mCountX;
  private static int mCountY;
  
  private boolean createPageAddShortcut(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = false;
    LauncherApplication localLauncherApplication = (LauncherApplication)paramContext.getApplicationContext();
    Launcher localLauncher = null;
    if (localLauncherApplication != null) {
      localLauncher = localLauncherApplication.getLauncher();
    }
    int i = LauncherApplication.getScreenCount();
    if (i >= LauncherApplication.getMaxScreenCount()) {
      return false;
    }
    Intent localIntent = (Intent)paramIntent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
    boolean bool1 = bool2;
    if (localIntent != null)
    {
      bool1 = bool2;
      if (paramContext.getPackageManager().getLaunchIntentForPackage(localIntent.getPackage()) != null)
      {
        if (localLauncher != null) {
          break label115;
        }
        LauncherApplication.setScreenCount(paramContext, i + 1);
      }
    }
    for (;;)
    {
      localLauncherApplication.getModel().addShortcut(paramContext, paramIntent, -100L, i, 0, 0, true);
      bool1 = true;
      return bool1;
      label115:
      if ((LauncherApplication.sFestivalPageLauncher) && (Launcher.sIsFestivalModeOn)) {
        localLauncher.mHomeView.getWorkspace().insertWorkspaceScreen(i, false);
      } else {
        localLauncher.mHomeView.addPage();
      }
    }
  }
  
  private static boolean findEmptyCell(Context paramContext, int[] paramArrayOfInt, int paramInt)
  {
    int i = mCountX;
    int j = mCountY;
    boolean[][] arrayOfBoolean = (boolean[][])Array.newInstance(Boolean.TYPE, new int[] { i, j });
    Object localObject1 = LauncherModel.getItemsInLocalCoordinates(paramContext, -100L, paramInt);
    Object localObject2 = LauncherModel.sAddedHomeItems.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      HomeItem localHomeItem = (HomeItem)((Iterator)localObject2).next();
      if (paramInt == localHomeItem.mScreen) {
        ((ArrayList)localObject1).add(localHomeItem);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    int k;
    int m;
    int n;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (HomeItem)((Iterator)localObject1).next();
      k = ((HomeItem)localObject2).cellX;
      m = ((HomeItem)localObject2).cellY;
      n = ((HomeItem)localObject2).spanX;
      int i1 = ((HomeItem)localObject2).spanY;
      i = k;
      while ((i < k + n) && (i < mCountX))
      {
        j = m;
        while ((j < m + i1) && (j < mCountY))
        {
          arrayOfBoolean[i][j] = 1;
          j += 1;
        }
        i += 1;
      }
    }
    paramContext = paramContext.getSharedPreferences("com.sec.android.app.launcher.prefs", 0);
    if (paramContext.getInt("tempScreen", -1) == paramInt)
    {
      j = paramContext.getInt("tempCellX", -1);
      k = paramContext.getInt("tempCellY", -1);
      m = paramContext.getInt("tempSpanX", -1);
      n = paramContext.getInt("tempSpanY", -1);
      paramInt = j;
      while ((paramInt < j + m) && (paramInt < mCountX))
      {
        i = k;
        while ((i < k + n) && (i < mCountY))
        {
          arrayOfBoolean[paramInt][i] = 1;
          i += 1;
        }
        paramInt += 1;
      }
    }
    return CellLayout.findVacantCell(paramArrayOfInt, 1, 1, mCountX, mCountY, arrayOfBoolean);
  }
  
  private boolean installShortcut(Context paramContext, Intent paramIntent, int paramInt)
  {
    boolean bool = false;
    if (findEmptyCell(paramContext, mCoordinates, paramInt))
    {
      LauncherApplication localLauncherApplication = (LauncherApplication)paramContext.getApplicationContext();
      Intent localIntent = (Intent)paramIntent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
      if ((localIntent != null) && (paramContext.getPackageManager().getLaunchIntentForPackage(localIntent.getPackage()) != null)) {
        localLauncherApplication.getModel().addShortcut(paramContext, paramIntent, -100L, paramInt, mCoordinates[0], mCoordinates[1], true);
      }
      bool = true;
    }
    return bool;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject1 = paramIntent.getStringExtra("android.intent.extra.shortcut.NAME");
    Object localObject2 = (Intent)paramIntent.getParcelableExtra("android.intent.extra.shortcut.INTENT");
    if ((!"com.android.launcher.action.INSTALL_SHORTCUT".equals(paramIntent.getAction())) || (localObject2 == null) || (localObject1 == null) || (((String)localObject1).length() <= 0)) {
      return;
    }
    if (((Intent)localObject2).getAction() == null) {
      ((Intent)localObject2).setAction("android.intent.action.VIEW");
    }
    Launcher localLauncher = null;
    Object localObject3 = (LauncherApplication)paramContext.getApplicationContext();
    if (localObject3 != null) {
      localLauncher = ((LauncherApplication)localObject3).getLauncher();
    }
    if ((!paramIntent.getBooleanExtra("duplicate", true)) && (LauncherModel.shortcutExists(paramContext, (String)localObject1, (Intent)localObject2))) {
      paramIntent = paramContext.getString(2131755038, new Object[] { localObject1 });
    }
    for (;;)
    {
      if (("DCM".equals(Launcher.readSalesCode())) || ("KDI".equals(Launcher.readSalesCode())))
      {
        localObject1 = LauncherApplication.getInst().getPackageManager();
        localObject2 = new ArrayList();
        localObject3 = new ArrayList();
        ((PackageManager)localObject1).getPreferredActivities((List)localObject2, (List)localObject3, LauncherApplication.getInst().getPackageName());
        if (((List)localObject3).size() <= 0) {
          break;
        }
      }
      if (localLauncher == null) {
        break label366;
      }
      Toast.makeText(localLauncher.getBaseContext(), paramIntent, 0).show();
      return;
      int j = LauncherApplication.getHomeScreenIndex();
      localObject2 = paramContext.getResources();
      mCountX = ((Resources)localObject2).getInteger(2131492897);
      mCountY = ((Resources)localObject2).getInteger(2131492898);
      boolean bool2 = installShortcut(paramContext, paramIntent, j);
      boolean bool1 = bool2;
      if (!bool2)
      {
        int k = LauncherApplication.getScreenCount();
        int i = 0;
        while ((i < k) && (!bool2))
        {
          if (i != j) {
            bool2 = installShortcut(paramContext, paramIntent, i);
          }
          i += 1;
        }
        bool1 = bool2;
        if (!bool2) {
          bool1 = createPageAddShortcut(paramContext, paramIntent);
        }
      }
      if (bool1) {
        paramIntent = paramContext.getString(2131755036, new Object[] { localObject1 });
      } else {
        paramIntent = paramContext.getString(2131755035);
      }
    }
    label366:
    Toast.makeText(paramContext, paramIntent, 0).show();
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/InstallShortcutReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */