package com.android.launcher2;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

public class LauncherProviderID
  extends ContentProvider
{
  static final String AUTHORITY = "com.sec.android.app.launcher.settings.id";
  static final Uri CONTENT_APPWIDGET_UNBIND_URI = Uri.parse("content://com.sec.android.app.launcher.settings.id/appWidgetUnbind");
  private static final String FAVORITES = "favorites";
  static final String PARAMETER_INITID = "initId";
  private static final String SPRINTFOLDER = "sprintFolder";
  static final Uri SPRINTFOLDER_URI = Uri.parse("content://com.sec.android.app.launcher.settings/sprintFolder?notify=true");
  private static final String TAG = "Launcher.LauncherProviderID";
  static final String WIDGET_CLS_NAME = "widgetClsName";
  static final String WIDGET_PKG_NAME = "widgetPkgName";
  private LauncherProvider mLauncherProvider;
  
  private LauncherProvider getLauncherProvider()
  {
    if (this.mLauncherProvider == null) {
      this.mLauncherProvider = ((LauncherApplication)getContext()).getLauncherProvider();
    }
    return this.mLauncherProvider;
  }
  
  private Uri handleWidget(SQLiteDatabase paramSQLiteDatabase, Uri paramUri, ContentValues paramContentValues)
  {
    if ((paramContentValues.getAsInteger("itemType").intValue() == 4) && (paramContentValues.containsKey("appWidgetId")) && (paramContentValues.getAsInteger("appWidgetId").intValue() == -1) && (paramContentValues.containsKey("widgetPkgName")))
    {
      Object localObject1 = paramContentValues.getAsString("widgetPkgName");
      Object localObject2 = paramContentValues.getAsString("widgetClsName");
      paramContentValues.remove("widgetPkgName");
      paramContentValues.remove("widgetClsName");
      localObject1 = new ComponentName((String)localObject1, (String)localObject2);
      localObject2 = AppWidgetManager.getInstance(getContext());
      int i = 0;
      Iterator localIterator = ((AppWidgetManager)localObject2).getInstalledProviders().iterator();
      while (localIterator.hasNext()) {
        if (((AppWidgetProviderInfo)localIterator.next()).provider.equals(localObject1)) {
          i = 1;
        }
      }
      if (i == 0) {
        break label241;
      }
      i = new AppWidgetHost(getContext(), 1024).allocateAppWidgetId();
      paramContentValues.put("appWidgetId", Integer.valueOf(i));
      getLauncherProvider();
      long l = LauncherProvider.dbInsertAndCheck(getLauncherProvider().getDatabaseHelper(), paramSQLiteDatabase, "favorites", null, paramContentValues);
      if (l <= 0L) {
        return null;
      }
      if (((AppWidgetManager)localObject2).bindAppWidgetIdIfAllowed(i, (ComponentName)localObject1)) {
        return ContentUris.withAppendedId(paramUri, l);
      }
      Log.e("Launcher.LauncherProviderID", "Problem allocating appWidgetId");
    }
    for (;;)
    {
      return null;
      label241:
      Log.d("Launcher.LauncherProviderID", "No insertion for widget");
    }
  }
  
  private void initValues(Uri paramUri, ContentValues paramContentValues)
  {
    String str = paramUri.getQueryParameter("initId");
    if ((str == null) || ("true".equals(str)))
    {
      if (paramContentValues.getAsInteger("_id").intValue() == 0)
      {
        if (!paramUri.getPathSegments().contains("favorites")) {
          break label76;
        }
        Log.d("Launcher.LauncherProviderID", "Generating a new ID: Favoriates");
      }
      for (long l = getLauncherProvider().generateNewHomeId();; l = getLauncherProvider().generateNewSprintFolderId())
      {
        paramContentValues.put("_id", Long.valueOf(l));
        return;
        label76:
        Log.d("Launcher.LauncherProviderID", "Generating a new ID: sprintFolder");
      }
    }
    Log.d("Launcher.LauncherProviderID", "Using old ID on insert");
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    LauncherProvider localLauncherProvider = getLauncherProvider();
    if (CONTENT_APPWIDGET_UNBIND_URI.equals(paramUri))
    {
      Log.d("Launcher.LauncherProviderID", "Unbinding widget");
      new AppWidgetHost(getContext(), 1024).deleteAppWidgetId(Integer.valueOf(paramArrayOfString[0]).intValue());
      return 1;
    }
    return localLauncherProvider.delete(paramUri, paramString, paramArrayOfString);
  }
  
  public String getType(Uri paramUri)
  {
    return getLauncherProvider().getType(paramUri);
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    LauncherProvider localLauncherProvider = getLauncherProvider();
    initValues(paramUri, paramContentValues);
    if (paramUri.getPathSegments().contains("favorites"))
    {
      SQLiteDatabase localSQLiteDatabase = localLauncherProvider.getDatabaseHelper().getWritableDatabase();
      Uri localUri = handleWidget(localSQLiteDatabase, paramUri, paramContentValues);
      if (localUri != null) {
        return localUri;
      }
      if (paramContentValues.containsKey("widgetPkgName")) {
        paramContentValues.remove("widgetPkgName");
      }
      if (paramContentValues.containsKey("widgetClsName")) {
        paramContentValues.remove("widgetClsName");
      }
      Log.d("Launcher.LauncherProviderID", "About to insert");
      localSQLiteDatabase.close();
    }
    return localLauncherProvider.insert(paramUri, paramContentValues);
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return getLauncherProvider().query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return getLauncherProvider().update(paramUri, paramContentValues, paramString, paramArrayOfString);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/LauncherProviderID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */