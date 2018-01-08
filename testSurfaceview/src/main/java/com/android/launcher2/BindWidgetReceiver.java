package com.android.launcher2;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BindWidgetReceiver
  extends BroadcastReceiver
{
  public static final String ACTION_BIND_WIDGET = "com.android.launcher.action.BIND_WIDGET";
  public static final String ACTION_BIND_WIDGET_COMPLETE = "com.android.launcher.action.BIND_WIDGET_COMPLETE";
  public static final String ACTION_UNBIND_WIDGET = "com.android.launcher.action.UNBIND_WIDGET";
  public static final String EXTRA_COMPONENT = "componentName";
  public static final String EXTRA_SPANX = "spanX";
  public static final String EXTRA_SPANY = "spanY";
  public static final String EXTRA_WIDGET_NAME = "widgetName";
  private static final String TAG = "Launcher.BindWidgetReceiver";
  private static final int[] mCoordinates = new int[2];
  private static int mCountX;
  private static int mCountY;
  
  private boolean bindWidget(Context paramContext, Intent paramIntent, int paramInt, boolean paramBoolean)
  {
    boolean bool2 = false;
    ComponentName localComponentName = ComponentName.unflattenFromString(paramIntent.getStringExtra("componentName"));
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = paramIntent.getIntExtra("spanX", -1);
    arrayOfInt[1] = paramIntent.getIntExtra("spanX", -1);
    boolean bool1 = bool2;
    if (findEmptyCell(paramContext, mCoordinates, paramInt, arrayOfInt))
    {
      paramContext = (LauncherApplication)paramContext.getApplicationContext();
      if (paramContext == null) {
        break label171;
      }
    }
    label171:
    for (paramContext = paramContext.getLauncher();; paramContext = null)
    {
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.mHomeView != null)
        {
          paramIntent = new HomeWidgetItem(localComponentName, -1);
          paramIntent.setPosition(paramInt);
          paramIntent.cellX = mCoordinates[0];
          paramIntent.cellY = mCoordinates[1];
          paramIntent.spanX = arrayOfInt[0];
          paramIntent.spanY = arrayOfInt[1];
          paramIntent.container = -100L;
          paramIntent.mSecretItem = paramBoolean;
          paramContext.mHomeView.addWidgetFromIntent(paramIntent);
          bool1 = true;
        }
      }
      return bool1;
    }
  }
  
  private static boolean findEmptyCell(Context paramContext, int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int i = mCountX;
    int j = mCountY;
    boolean[][] arrayOfBoolean = (boolean[][])Array.newInstance(Boolean.TYPE, new int[] { i, j });
    Iterator localIterator = LauncherModel.getItemsInLocalCoordinates(paramContext, -100L, paramInt).iterator();
    int k;
    int m;
    int n;
    while (localIterator.hasNext())
    {
      HomeItem localHomeItem = (HomeItem)localIterator.next();
      k = localHomeItem.cellX;
      m = localHomeItem.cellY;
      n = localHomeItem.spanX;
      int i1 = localHomeItem.spanY;
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
    return CellLayout.findVacantCell(paramArrayOfInt1, paramArrayOfInt2[0], paramArrayOfInt2[1], mCountX, mCountY, arrayOfBoolean);
  }
  
  public void bindWidget(Context paramContext, Intent paramIntent)
  {
    Object localObject1 = ComponentName.unflattenFromString(paramIntent.getStringExtra("componentName"));
    Object localObject2 = new int[2];
    localObject2[0] = paramIntent.getIntExtra("spanX", -1);
    localObject2[1] = paramIntent.getIntExtra("spanX", -1);
    if ((localObject1 == null) || (((ComponentName)localObject1).equals("")) || (localObject2[0] <= 0) || (localObject2[1] <= 0))
    {
      if ((localObject1 == null) || (((ComponentName)localObject1).equals(""))) {
        Log.d("Launcher.BindWidgetReceiver", "ComponentName is null or empty");
      }
      if ((localObject2[0] <= 0) || (localObject2[1] <= 0)) {
        Log.d("Launcher.BindWidgetReceiver", "Span [" + localObject2[0] + "," + localObject2[1] + "]");
      }
    }
    for (;;)
    {
      return;
      ((ComponentName)localObject1).getPackageName();
      paramContext.getPackageManager();
      int j;
      Object localObject3;
      int i;
      boolean bool2;
      int k;
      if (0 == 0)
      {
        localObject1 = null;
        localObject2 = (LauncherApplication)paramContext.getApplicationContext();
        if (localObject2 != null) {
          localObject1 = ((LauncherApplication)localObject2).getLauncher();
        }
        j = 0;
        localObject2 = null;
        Resources localResources = null;
        localObject3 = localResources;
        if (localObject1 != null)
        {
          HomeView localHomeView = ((Launcher)localObject1).getHomeView();
          localObject2 = localHomeView;
          localObject3 = localResources;
          if (localHomeView != null)
          {
            localObject3 = localHomeView.getWorkspace();
            localObject2 = localHomeView;
          }
        }
        i = j;
        if (localObject2 != null)
        {
          i = j;
          if (localObject3 != null)
          {
            j = ((HomeView)localObject2).getCurrentPage();
            i = j;
            if (LauncherApplication.sFestivalPageLauncher)
            {
              i = j;
              if (Launcher.sIsFestivalModeOn)
              {
                i = j;
                if (((CellLayout)((Workspace)localObject3).getChildAt(j)).getPageType() == 2) {
                  i = 0;
                }
              }
            }
          }
        }
        localResources = paramContext.getResources();
        mCountX = localResources.getInteger(2131492897);
        mCountY = localResources.getInteger(2131492898);
        bool2 = bindWidget(paramContext, paramIntent, i, false);
        bool1 = bool2;
        if (bool2) {
          break label558;
        }
        bool1 = bool2;
        if (localObject2 == null) {
          break label558;
        }
        bool1 = bool2;
        if (localObject3 == null) {
          break label558;
        }
        if (0 == 0) {
          break label446;
        }
        j = 0;
        k = LauncherApplication.getSecretScreenCount();
      }
      while ((j < k) && (!bool2))
      {
        if (j != i) {
          bool2 = bindWidget(paramContext, paramIntent, j, false);
        }
        if ((bool2) && (j != ((Workspace)localObject3).getCurrentPage())) {
          ((Workspace)localObject3).snapToPage(j);
        }
        j += 1;
        continue;
        throw new NullPointerException();
        label446:
        j = LauncherApplication.getSecretScreenCount();
        k = LauncherApplication.getScreenCount();
      }
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (k < LauncherApplication.getMaxScreenCount())
        {
          bool1 = bool2;
          if (localObject2 != null)
          {
            bool1 = bool2;
            if (localObject3 != null)
            {
              if (0 == 0) {
                break label590;
              }
              bool1 = bool2;
              if (LauncherApplication.getSecretScreenCount() < LauncherApplication.getMaxScreenCount())
              {
                i = LauncherApplication.getSecretScreenCount() + 1;
                ((Workspace)localObject3).insertWorkspaceScreen(i, false);
                bool2 = bindWidget(paramContext, paramIntent, i, false);
                bool1 = bool2;
                if (bool2)
                {
                  ((Workspace)localObject3).snapToPage(i);
                  bool1 = bool2;
                }
              }
            }
          }
        }
      }
      label558:
      while (!bool1)
      {
        paramIntent = paramContext.getString(2131755034);
        if (localObject1 == null) {
          break label710;
        }
        Toast.makeText(((Launcher)localObject1).getBaseContext(), paramIntent, 0).show();
        return;
        label590:
        bool1 = bool2;
        if (LauncherApplication.getScreenCount() < LauncherApplication.getMaxScreenCount()) {
          if ((LauncherApplication.sFestivalPageLauncher) && (Launcher.sIsFestivalModeOn))
          {
            i = ((Workspace)localObject3).getChildCount() - LauncherApplication.getFestivalScreenCount();
            ((Workspace)localObject3).insertWorkspaceScreen(i, false);
            bool2 = bindWidget(paramContext, paramIntent, i, false);
            bool1 = bool2;
            if (bool2)
            {
              ((Workspace)localObject3).snapToPage(i);
              bool1 = bool2;
            }
          }
          else
          {
            ((HomeView)localObject2).addPage();
            i = ((Workspace)localObject3).getChildCount() - 1;
            bool2 = bindWidget(paramContext, paramIntent, i, false);
            bool1 = bool2;
            if (bool2)
            {
              ((Workspace)localObject3).snapToPage(i);
              bool1 = bool2;
            }
          }
        }
      }
    }
    label710:
    Toast.makeText(paramContext, paramIntent, 0).show();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || ((!"com.android.launcher.action.BIND_WIDGET".equals(paramIntent.getAction())) && (!"com.android.launcher.action.UNBIND_WIDGET".equals(paramIntent.getAction())))) {}
    do
    {
      return;
      if ("com.android.launcher.action.BIND_WIDGET".equals(paramIntent.getAction()))
      {
        bindWidget(paramContext, paramIntent);
        return;
      }
    } while (!"com.android.launcher.action.UNBIND_WIDGET".equals(paramIntent.getAction()));
    unBindWidget(paramContext, paramIntent);
  }
  
  public void unBindWidget(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("appWidgetId", 0);
    ArrayList localArrayList = new ArrayList();
    if (i != 0)
    {
      paramIntent = paramContext.getContentResolver();
      Object localObject1 = LauncherSettings.Favorites.CONTENT_URI;
      Object localObject2 = Integer.toString(i);
      paramIntent = paramIntent.query((Uri)localObject1, new String[] { "_id", "screen" }, "appWidgetId=?", new String[] { localObject2 }, null);
      if (paramIntent != null)
      {
        i = paramIntent.getColumnIndexOrThrow("_id");
        int j = paramIntent.getColumnIndexOrThrow("screen");
        while (paramIntent.moveToNext()) {
          localArrayList.add(new int[] { paramIntent.getInt(i), paramIntent.getInt(j) });
        }
        if (paramIntent != null) {
          paramIntent.close();
        }
        if (localArrayList.size() > 0)
        {
          localObject1 = null;
          paramIntent = (LauncherApplication)paramContext.getApplicationContext();
          if (paramIntent != null) {
            localObject1 = paramIntent.getLauncher();
          }
          paramIntent = null;
          if (localObject1 != null) {
            paramIntent = ((Launcher)localObject1).getHomeView();
          }
          i = 0;
          while (i < localArrayList.size())
          {
            localObject1 = (int[])localArrayList.get(i);
            localObject2 = (CellLayoutWithResizableWidgets)paramIntent.getCellLayout(-100L, localObject1[1]);
            List localList = ((CellLayoutWithResizableWidgets)localObject2).allItems();
            j = 0;
            while (j < localList.size())
            {
              final Object localObject3 = (BaseItem)localList.get(j);
              if (((localObject3 instanceof HomeWidgetItem)) && (((BaseItem)localObject3).mId == localObject1[0]))
              {
                ((CellLayoutWithResizableWidgets)localObject2).removeItem((BaseItem)localObject3);
                LauncherModel.deleteItemFromDatabase(paramContext, (HomeWidgetItem)localObject3);
                localObject3 = (HomeWidgetItem)localObject3;
                final LauncherAppWidgetHost localLauncherAppWidgetHost = paramIntent.getAppWidgetHost();
                if (localLauncherAppWidgetHost != null) {
                  new Thread("Unbind widget from BindWidgetReceiver")
                  {
                    public void run()
                    {
                      localLauncherAppWidgetHost.deleteAppWidgetId(localObject3.appWidgetId);
                    }
                  }.start();
                }
              }
              j += 1;
            }
            i += 1;
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/BindWidgetReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */