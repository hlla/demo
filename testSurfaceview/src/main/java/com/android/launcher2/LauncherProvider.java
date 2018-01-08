package com.android.launcher2;

import android.app.SearchManager;
import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Xml;
import com.sec.android.app.CscFeature;
import com.sec.android.app.launcher.R.styleable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class LauncherProvider
  extends ContentProvider
{
  static final String AUTHORITY = "com.sec.android.app.launcher.settings";
  static final Uri CONTENT_APPWIDGET_RESET_URI;
  static final String CSC_FILE_MAINMENU = "/system/csc/default_application_order.xml";
  static final String CSC_FILE_WORKSPACE = "/system/csc/default_workspace.xml";
  private static final String DATABASE_NAME = "launcher.db";
  private static final int DATABASE_VERSION = 14;
  private static final boolean DEBUGGABLE = ;
  static final String PARAMETER_NOTIFY = "notify";
  public static final String PREFS_HIDDENADD_HOMEFOLDERIDS = "HomeFolderIds";
  public static final String PREFS_ISCSCLOAD = "PrefsIsCSCLoad";
  public static final String PREFS_PREFESTIVAL = "PrefsPreFestival";
  public static final String PREFS_PRESECRET = "PrefsPreSecret";
  static final String TABLE_APPORDER = "appOrder";
  static final String TABLE_FAVORITES = "favorites";
  static final String TABLE_PUBLIC_PREFERENCES = "prefs";
  private static final String TAG = "LauncherProvider";
  private static LauncherApplication mApp;
  private static String mBasePathForRestore = null;
  private static boolean mIsRestoreHomeScreen;
  protected DatabaseHelper mOpenHelper;
  
  static
  {
    CONTENT_APPWIDGET_RESET_URI = Uri.parse("content://com.sec.android.app.launcher.settings/appWidgetReset");
    mIsRestoreHomeScreen = false;
  }
  
  public static final void beginDocument(XmlPullParser paramXmlPullParser, String paramString)
    throws XmlPullParserException, IOException
  {
    int i;
    do
    {
      i = paramXmlPullParser.next();
    } while ((i != 2) && (i != 1));
    if (i != 2) {
      throw new XmlPullParserException("No start tag found");
    }
    if (!paramXmlPullParser.getName().equals(paramString)) {
      throw new XmlPullParserException("Unexpected start tag: found " + paramXmlPullParser.getName() + ", expected " + paramString);
    }
  }
  
  static String buildOrWhereString(String paramString, int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramArrayOfInt.length - 1;
    while (i >= 0)
    {
      localStringBuilder.append(paramString).append("=").append(paramArrayOfInt[i]);
      if (i > 0) {
        localStringBuilder.append(" OR ");
      }
      i -= 1;
    }
    return localStringBuilder.toString();
  }
  
  protected static long dbInsertAndCheck(DatabaseHelper paramDatabaseHelper, SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, ContentValues paramContentValues)
  {
    if (!paramContentValues.containsKey("_id")) {
      throw new RuntimeException("Error: attempting to add item without specifying an id");
    }
    return paramSQLiteDatabase.insert(paramString1, paramString2, paramContentValues);
  }
  
  private static Bitmap getBitmapFromBackupPath(String paramString1, String paramString2)
  {
    paramString1 = BitmapFactory.decodeFile(paramString1 + "/" + paramString2 + ".jpg");
    if (paramString1 != null) {
      return paramString1;
    }
    return null;
  }
  
  public int LoadAttReady2GoDB(String paramString)
  {
    return 0;
  }
  
  public void addHomeFolderItems(long paramLong, HomeFolderItem paramHomeFolderItem)
  {
    SQLiteDatabase localSQLiteDatabase = getDatabaseHelper().getWritableDatabase();
    Object localObject = null;
    for (;;)
    {
      SQLiteStatement localSQLiteStatement;
      int i;
      try
      {
        localSQLiteStatement = localSQLiteDatabase.compileStatement("INSERT into favorites (_id, itemType, container, screen, cellX, cellY, spanX, spanY, title, intent, iconType, secret, festival) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
        localObject = localSQLiteStatement;
        localSQLiteDatabase.beginTransaction();
        localObject = localSQLiteStatement;
        int k = paramHomeFolderItem.getItemCount();
        i = 0;
        if (i >= k) {
          break label342;
        }
        localObject = localSQLiteStatement;
        HomeShortcutItem localHomeShortcutItem = (HomeShortcutItem)paramHomeFolderItem.getItemAt(i);
        if (localHomeShortcutItem == null) {
          break label367;
        }
        localObject = localSQLiteStatement;
        localSQLiteStatement.bindLong(1, localHomeShortcutItem.mId);
        localObject = localSQLiteStatement;
        if (localHomeShortcutItem.mType != BaseItem.Type.HOME_APPLICATION)
        {
          localObject = localSQLiteStatement;
          if (localHomeShortcutItem.mType != BaseItem.Type.MENU_APP) {}
        }
        else
        {
          localObject = localSQLiteStatement;
          localSQLiteStatement.bindLong(2, 0L);
          localObject = localSQLiteStatement;
          localSQLiteStatement.bindLong(3, paramLong);
          localObject = localSQLiteStatement;
          localSQLiteStatement.bindLong(4, localHomeShortcutItem.mScreen);
          localObject = localSQLiteStatement;
          localSQLiteStatement.bindLong(5, -1L);
          localObject = localSQLiteStatement;
          localSQLiteStatement.bindLong(6, -1L);
          localObject = localSQLiteStatement;
          localSQLiteStatement.bindLong(7, 1L);
          localObject = localSQLiteStatement;
          localSQLiteStatement.bindLong(8, 1L);
          localObject = localSQLiteStatement;
          localSQLiteStatement.bindString(9, localHomeShortcutItem.mTitle);
          localObject = localSQLiteStatement;
          localSQLiteStatement.bindString(10, localHomeShortcutItem.getIntent().toURI());
          localObject = localSQLiteStatement;
          localSQLiteStatement.bindLong(11, 0L);
          localObject = localSQLiteStatement;
          if (!localHomeShortcutItem.mSecretItem) {
            break label336;
          }
          j = 1;
          localObject = localSQLiteStatement;
          localSQLiteStatement.bindLong(12, j);
          localObject = localSQLiteStatement;
          localSQLiteStatement.bindLong(13, 0L);
          localObject = localSQLiteStatement;
          localSQLiteStatement.execute();
          break label367;
        }
        localObject = localSQLiteStatement;
        localSQLiteStatement.bindLong(2, 1L);
        continue;
        int j = 0;
      }
      finally
      {
        if (localObject != null) {
          ((SQLiteStatement)localObject).close();
        }
        localSQLiteDatabase.endTransaction();
      }
      label336:
      continue;
      label342:
      localObject = localSQLiteStatement;
      localSQLiteDatabase.setTransactionSuccessful();
      if (localSQLiteStatement != null) {
        localSQLiteStatement.close();
      }
      localSQLiteDatabase.endTransaction();
      return;
      label367:
      i += 1;
    }
  }
  
  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    SqlArguments localSqlArguments = new SqlArguments(paramUri);
    SQLiteDatabase localSQLiteDatabase = this.mOpenHelper.getWritableDatabase();
    localSQLiteDatabase.beginTransaction();
    try
    {
      int j = paramArrayOfContentValues.length;
      int i = 0;
      while (i < j)
      {
        long l = dbInsertAndCheck(this.mOpenHelper, localSQLiteDatabase, localSqlArguments.table, null, paramArrayOfContentValues[i]);
        if (l < 0L) {
          return 0;
        }
        i += 1;
      }
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
      sendNotify(paramUri);
      return paramArrayOfContentValues.length;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    paramString = new SqlArguments(paramUri, paramString, paramArrayOfString);
    int i = this.mOpenHelper.getWritableDatabase().delete(paramString.table, paramString.where, paramString.args);
    if (i > 0) {
      sendNotify(paramUri);
    }
    return i;
  }
  
  public long generateNewHomeId()
  {
    return getDatabaseHelper().generateNewFavoritesId();
  }
  
  public long generateNewMenuId()
  {
    return getDatabaseHelper().generateNewAppOrderId();
  }
  
  public long generateNewSprintFolderId()
  {
    return getDatabaseHelper().generateNewSprintFolderId();
  }
  
  DatabaseHelper getDatabaseHelper()
  {
    if (this.mOpenHelper == null) {
      this.mOpenHelper = new DatabaseHelper(getContext());
    }
    return this.mOpenHelper;
  }
  
  public int getScreenCount()
  {
    if (!CscFeature.getInstance().getEnableStatus("CscFeature_Common_EnableSprintExtension")) {
      return -1;
    }
    Object localObject2 = this.mOpenHelper.getWritableDatabase();
    Object localObject1 = null;
    long l2 = LauncherApplication.getScreenCount();
    try
    {
      localObject2 = ((SQLiteDatabase)localObject2).rawQuery("SELECT value FROM prefs WHERE key='numScreens'", null);
      long l1 = l2;
      if (localObject2 != null)
      {
        l1 = l2;
        localObject1 = localObject2;
        if (((Cursor)localObject2).moveToNext())
        {
          localObject1 = localObject2;
          l1 = ((Cursor)localObject2).getLong(0);
        }
      }
      return (int)l1;
    }
    finally
    {
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
    }
  }
  
  public int getScreenIndex()
  {
    if (!CscFeature.getInstance().getEnableStatus("CscFeature_Common_EnableSprintExtension")) {
      return -1;
    }
    Object localObject5 = this.mOpenHelper.getWritableDatabase();
    Object localObject3 = null;
    localObject1 = null;
    l2 = LauncherApplication.getHomeScreenIndex();
    try
    {
      localObject5 = ((SQLiteDatabase)localObject5).rawQuery("SELECT value  FROM prefs WHERE key='defaultScreen'", null);
      long l1 = l2;
      if (localObject5 != null)
      {
        l1 = l2;
        localObject1 = localObject5;
        localObject3 = localObject5;
        if (((Cursor)localObject5).moveToNext())
        {
          localObject1 = localObject5;
          localObject3 = localObject5;
          l1 = ((Cursor)localObject5).getLong(0);
        }
      }
      l3 = l1;
      if (localObject5 != null)
      {
        ((Cursor)localObject5).close();
        l3 = l1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject4 = localObject1;
        Log.e("LauncherProvider", "Could not get screen index from db");
        long l3 = l2;
        if (localObject1 != null)
        {
          ((Cursor)localObject1).close();
          l3 = l2;
        }
      }
    }
    finally
    {
      Object localObject4;
      if (localObject4 == null) {
        break label161;
      }
      ((Cursor)localObject4).close();
    }
    return (int)l3;
  }
  
  public HomeShortcutItem getShortcutInfo(HomeItem paramHomeItem)
  {
    HomeShortcutItem localHomeShortcutItem = new HomeShortcutItem();
    SQLiteDatabase localSQLiteDatabase = this.mOpenHelper.getReadableDatabase();
    Object localObject = null;
    HomeItem localHomeItem = null;
    try
    {
      paramHomeItem = localSQLiteDatabase.rawQuery("SELECT title, icon  FROM favorites WHERE _id='" + paramHomeItem.mId + "'", null);
      if (paramHomeItem != null)
      {
        localHomeItem = paramHomeItem;
        localObject = paramHomeItem;
        if (paramHomeItem.moveToNext())
        {
          localHomeItem = paramHomeItem;
          localObject = paramHomeItem;
          localHomeShortcutItem.mTitle = paramHomeItem.getString(0);
          localHomeItem = paramHomeItem;
          localObject = paramHomeItem;
          byte[] arrayOfByte = paramHomeItem.getBlob(1);
          localHomeItem = paramHomeItem;
          localObject = paramHomeItem;
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localHomeItem = paramHomeItem;
          localObject = paramHomeItem;
          localHomeShortcutItem.mIconBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length, localOptions);
        }
      }
      if (paramHomeItem != null) {
        paramHomeItem.close();
      }
      localSQLiteDatabase.close();
      return localHomeShortcutItem;
    }
    catch (Exception paramHomeItem)
    {
      localObject = localHomeItem;
      Log.e("LauncherProvider", "Could not get icon from the database");
      if (localHomeItem != null) {
        localHomeItem.close();
      }
      localSQLiteDatabase.close();
      return localHomeShortcutItem;
    }
    finally
    {
      if (localObject != null) {
        ((Cursor)localObject).close();
      }
      localSQLiteDatabase.close();
    }
  }
  
  public String getType(Uri paramUri)
  {
    paramUri = new SqlArguments(paramUri, null, null);
    if (TextUtils.isEmpty(paramUri.where)) {
      return "vnd.android.cursor.dir/" + paramUri.table;
    }
    return "vnd.android.cursor.item/" + paramUri.table;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    SqlArguments localSqlArguments = new SqlArguments(paramUri);
    SQLiteDatabase localSQLiteDatabase = this.mOpenHelper.getWritableDatabase();
    long l = dbInsertAndCheck(this.mOpenHelper, localSQLiteDatabase, localSqlArguments.table, null, paramContentValues);
    if (l <= 0L) {
      return null;
    }
    paramUri = ContentUris.withAppendedId(paramUri, l);
    sendNotify(paramUri);
    return paramUri;
  }
  
  public ArrayList<String> loadFrontApps()
  {
    return this.mOpenHelper.loadFrontAppOrder();
  }
  
  public void moveAppOrderModify(List<LauncherSettings.AppOrderModify> paramList)
  {
    SQLiteDatabase localSQLiteDatabase = getDatabaseHelper().getWritableDatabase();
    Object localObject = null;
    SQLiteStatement localSQLiteStatement;
    try
    {
      localSQLiteStatement = localSQLiteDatabase.compileStatement("UPDATE appOrder set screen=? where _id=?");
      localObject = localSQLiteStatement;
      localSQLiteDatabase.beginTransaction();
      localObject = localSQLiteStatement;
      paramList = paramList.iterator();
      for (;;)
      {
        localObject = localSQLiteStatement;
        if (!paramList.hasNext()) {
          break;
        }
        localObject = localSQLiteStatement;
        LauncherSettings.AppOrderModify localAppOrderModify = (LauncherSettings.AppOrderModify)paramList.next();
        localObject = localSQLiteStatement;
        localSQLiteStatement.bindLong(1, localAppOrderModify.screen);
        localObject = localSQLiteStatement;
        localSQLiteStatement.bindLong(2, localAppOrderModify.id);
        localObject = localSQLiteStatement;
        localSQLiteStatement.execute();
      }
      localObject = localSQLiteStatement;
    }
    finally
    {
      if (localObject != null) {
        ((SQLiteStatement)localObject).close();
      }
      localSQLiteDatabase.endTransaction();
    }
    localSQLiteDatabase.setTransactionSuccessful();
    if (localSQLiteStatement != null) {
      localSQLiteStatement.close();
    }
    localSQLiteDatabase.endTransaction();
  }
  
  public void moveFavorites(List<LauncherSettings.FavoritePos> paramList)
  {
    SQLiteDatabase localSQLiteDatabase = getDatabaseHelper().getWritableDatabase();
    Object localObject = null;
    SQLiteStatement localSQLiteStatement;
    try
    {
      localSQLiteStatement = localSQLiteDatabase.compileStatement("UPDATE favorites set container=?,screen=?,cellX=?,cellY=?,secret=?,festival=? where _id=?");
      localObject = localSQLiteStatement;
      localSQLiteDatabase.beginTransaction();
      localObject = localSQLiteStatement;
      paramList = paramList.iterator();
      for (;;)
      {
        localObject = localSQLiteStatement;
        if (!paramList.hasNext()) {
          break;
        }
        localObject = localSQLiteStatement;
        LauncherSettings.FavoritePos localFavoritePos = (LauncherSettings.FavoritePos)paramList.next();
        localObject = localSQLiteStatement;
        localSQLiteStatement.bindLong(1, localFavoritePos.container);
        localObject = localSQLiteStatement;
        localSQLiteStatement.bindLong(2, localFavoritePos.screen);
        localObject = localSQLiteStatement;
        localSQLiteStatement.bindLong(3, localFavoritePos.cellX);
        localObject = localSQLiteStatement;
        localSQLiteStatement.bindLong(4, localFavoritePos.cellY);
        localObject = localSQLiteStatement;
        localSQLiteStatement.bindLong(5, localFavoritePos.secret);
        localObject = localSQLiteStatement;
        localSQLiteStatement.bindLong(6, localFavoritePos.festival);
        localObject = localSQLiteStatement;
        localSQLiteStatement.bindLong(7, localFavoritePos.id);
        localObject = localSQLiteStatement;
        localSQLiteStatement.execute();
      }
      localObject = localSQLiteStatement;
    }
    finally
    {
      if (localObject != null) {
        ((SQLiteStatement)localObject).close();
      }
      localSQLiteDatabase.endTransaction();
    }
    localSQLiteDatabase.setTransactionSuccessful();
    if (localSQLiteStatement != null) {
      localSQLiteStatement.close();
    }
    localSQLiteDatabase.endTransaction();
  }
  
  public boolean onCreate()
  {
    mApp = (LauncherApplication)getContext();
    this.mOpenHelper = getDatabaseHelper();
    mApp.setLauncherProvider(this);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramString1 = new SqlArguments(paramUri, paramString1, paramArrayOfString2);
    paramArrayOfString2 = new SQLiteQueryBuilder();
    paramArrayOfString2.setTables(paramString1.table);
    paramArrayOfString1 = paramArrayOfString2.query(this.mOpenHelper.getWritableDatabase(), paramArrayOfString1, paramString1.where, paramString1.args, null, null, paramString2);
    if (paramArrayOfString1 != null) {
      paramArrayOfString1.setNotificationUri(getContext().getContentResolver(), paramUri);
    }
    return paramArrayOfString1;
  }
  
  public int restoreHomeScreenDB(XmlPullParser paramXmlPullParser, String paramString)
  {
    mBasePathForRestore = paramString;
    mIsRestoreHomeScreen = true;
    DatabaseHelper.access$502(this.mOpenHelper, paramXmlPullParser);
    paramXmlPullParser = this.mOpenHelper.getWritableDatabase();
    paramXmlPullParser.delete("favorites", null, null);
    int i = this.mOpenHelper.loadFavorites(paramXmlPullParser, "favorites", false);
    if (i == 0) {
      this.mOpenHelper.loadFavorites(paramXmlPullParser, "favorites", false);
    }
    return i;
  }
  
  protected void sendNotify(Uri paramUri)
  {
    String str = paramUri.getQueryParameter("notify");
    if ((str == null) || ("true".equals(str))) {
      getContext().getContentResolver().notifyChange(paramUri, null);
    }
  }
  
  boolean switchToDynamicMode(int paramInt)
  {
    return getDatabaseHelper().switchToDynamicIfNecessary(paramInt);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    paramString = new SqlArguments(paramUri, paramString, paramArrayOfString);
    int i = this.mOpenHelper.getWritableDatabase().update(paramString.table, paramContentValues, paramString.where, paramString.args);
    if (i > 0) {
      sendNotify(paramUri);
    }
    return i;
  }
  
  public void updateAppItems(List<LauncherSettings.AppOrderModify> paramList)
  {
    SQLiteDatabase localSQLiteDatabase = getDatabaseHelper().getWritableDatabase();
    Iterator localIterator = null;
    Object localObject9 = null;
    LauncherSettings.AppOrderModify localAppOrderModify = null;
    Object localObject7 = null;
    Object localObject14 = null;
    Object localObject12 = null;
    Object localObject15 = null;
    Object localObject10 = null;
    Object localObject16 = null;
    Object localObject8 = null;
    Object localObject17 = null;
    Object localObject11 = null;
    Object localObject13 = null;
    Object localObject1 = localObject17;
    Object localObject2 = localObject15;
    Object localObject3 = localIterator;
    Object localObject4 = localObject16;
    Object localObject5 = localAppOrderModify;
    Object localObject6 = localObject14;
    long l;
    for (;;)
    {
      try
      {
        localSQLiteDatabase.beginTransaction();
        localObject1 = localObject17;
        localObject2 = localObject15;
        localObject3 = localIterator;
        localObject4 = localObject16;
        localObject5 = localAppOrderModify;
        localObject6 = localObject14;
        localIterator = paramList.iterator();
        paramList = (List<LauncherSettings.AppOrderModify>)localObject12;
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        localAppOrderModify = (LauncherSettings.AppOrderModify)localIterator.next();
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        switch (localAppOrderModify.action)
        {
        case 0: 
          localObject1 = localObject11;
          localObject2 = localObject10;
          localObject3 = localObject9;
          localObject4 = localObject8;
          localObject5 = localObject7;
          localObject6 = paramList;
          if (DEBUGGABLE)
          {
            localObject1 = localObject11;
            localObject2 = localObject10;
            localObject3 = localObject9;
            localObject4 = localObject8;
            localObject5 = localObject7;
            localObject6 = paramList;
            Log.d("LauncherProvider", "appOrder insert folder: " + localAppOrderModify.id + ", " + localAppOrderModify.screen + ", " + localAppOrderModify.cell + ", " + localAppOrderModify.title);
          }
          localObject12 = localObject9;
          if (localObject9 == null)
          {
            localObject1 = localObject11;
            localObject2 = localObject10;
            localObject3 = localObject9;
            localObject4 = localObject8;
            localObject5 = localObject7;
            localObject6 = paramList;
            localObject12 = localSQLiteDatabase.compileStatement("INSERT into appOrder (_id,screen,cell,title,secret,color) values(?,?,?,?,?,?)");
          }
          localObject1 = localObject11;
          localObject2 = localObject10;
          localObject3 = localObject12;
          localObject4 = localObject8;
          localObject5 = localObject7;
          localObject6 = paramList;
          ((SQLiteStatement)localObject12).bindLong(1, localAppOrderModify.id);
          localObject1 = localObject11;
          localObject2 = localObject10;
          localObject3 = localObject12;
          localObject4 = localObject8;
          localObject5 = localObject7;
          localObject6 = paramList;
          ((SQLiteStatement)localObject12).bindLong(2, localAppOrderModify.screen);
          localObject1 = localObject11;
          localObject2 = localObject10;
          localObject3 = localObject12;
          localObject4 = localObject8;
          localObject5 = localObject7;
          localObject6 = paramList;
          ((SQLiteStatement)localObject12).bindLong(3, localAppOrderModify.cell);
          localObject1 = localObject11;
          localObject2 = localObject10;
          localObject3 = localObject12;
          localObject4 = localObject8;
          localObject5 = localObject7;
          localObject6 = paramList;
          if (localAppOrderModify.title == null)
          {
            localObject1 = localObject11;
            localObject2 = localObject10;
            localObject3 = localObject12;
            localObject4 = localObject8;
            localObject5 = localObject7;
            localObject6 = paramList;
            ((SQLiteStatement)localObject12).bindNull(4);
            localObject1 = localObject11;
            localObject2 = localObject10;
            localObject3 = localObject12;
            localObject4 = localObject8;
            localObject5 = localObject7;
            localObject6 = paramList;
            if (!localAppOrderModify.secret) {
              break label4078;
            }
            l = 1L;
            label615:
            localObject1 = localObject11;
            localObject2 = localObject10;
            localObject3 = localObject12;
            localObject4 = localObject8;
            localObject5 = localObject7;
            localObject6 = paramList;
            ((SQLiteStatement)localObject12).bindLong(5, l);
            localObject1 = localObject11;
            localObject2 = localObject10;
            localObject3 = localObject12;
            localObject4 = localObject8;
            localObject5 = localObject7;
            localObject6 = paramList;
            if (!LauncherApplication.sIsFolderColorSupport) {
              break label4083;
            }
            localObject1 = localObject11;
            localObject2 = localObject10;
            localObject3 = localObject12;
            localObject4 = localObject8;
            localObject5 = localObject7;
            localObject6 = paramList;
            i = localAppOrderModify.color;
            label703:
            localObject1 = localObject11;
            localObject2 = localObject10;
            localObject3 = localObject12;
            localObject4 = localObject8;
            localObject5 = localObject7;
            localObject6 = paramList;
            ((SQLiteStatement)localObject12).bindLong(6, i);
            localObject1 = localObject11;
            localObject2 = localObject10;
            localObject3 = localObject12;
            localObject4 = localObject8;
            localObject5 = localObject7;
            localObject6 = paramList;
            if (DEBUGGABLE)
            {
              localObject1 = localObject11;
              localObject2 = localObject10;
              localObject3 = localObject12;
              localObject4 = localObject8;
              localObject5 = localObject7;
              localObject6 = paramList;
              Log.d("LauncherProvider", "appOrder insert folder: " + localAppOrderModify.id + ", " + localAppOrderModify.screen + ", " + localAppOrderModify.cell + ", " + localAppOrderModify.title + ", " + localAppOrderModify.secret);
            }
            localObject1 = localObject11;
            localObject2 = localObject10;
            localObject3 = localObject12;
            localObject4 = localObject8;
            localObject5 = localObject7;
            localObject6 = paramList;
            ((SQLiteStatement)localObject12).execute();
            localObject9 = localObject12;
            continue;
          }
          localObject1 = localObject11;
        }
      }
      finally
      {
        if (localObject3 != null) {
          ((SQLiteStatement)localObject3).close();
        }
        if (localObject5 != null) {
          ((SQLiteStatement)localObject5).close();
        }
        if (localObject6 != null) {
          ((SQLiteStatement)localObject6).close();
        }
        if (localObject2 != null) {
          ((SQLiteStatement)localObject2).close();
        }
        if (localObject4 != null) {
          ((SQLiteStatement)localObject4).close();
        }
        if (localObject1 != null) {
          ((SQLiteStatement)localObject1).close();
        }
        localSQLiteDatabase.endTransaction();
      }
      localObject2 = localObject10;
      localObject3 = localObject12;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      ((SQLiteStatement)localObject12).bindString(4, localAppOrderModify.title);
      continue;
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      if (DEBUGGABLE)
      {
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        Log.d("LauncherProvider", "appOrder update folder: " + localAppOrderModify.id + ", " + localAppOrderModify.screen + ", " + localAppOrderModify.cell + ", " + localAppOrderModify.title);
      }
      localObject12 = localObject7;
      if (localObject7 == null)
      {
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        localObject12 = localSQLiteDatabase.compileStatement("UPDATE appOrder set screen=?,cell=?,title=?,secret=? where _id=?");
      }
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject12;
      localObject6 = paramList;
      ((SQLiteStatement)localObject12).bindLong(1, localAppOrderModify.screen);
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject12;
      localObject6 = paramList;
      ((SQLiteStatement)localObject12).bindLong(2, localAppOrderModify.cell);
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject12;
      localObject6 = paramList;
      if (localAppOrderModify.title == null)
      {
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject12;
        localObject6 = paramList;
        ((SQLiteStatement)localObject12).bindNull(3);
      }
      for (;;)
      {
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject12;
        localObject6 = paramList;
        if (!localAppOrderModify.secret) {
          break label4088;
        }
        l = 1L;
        label1342:
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject12;
        localObject6 = paramList;
        ((SQLiteStatement)localObject12).bindLong(4, l);
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject12;
        localObject6 = paramList;
        ((SQLiteStatement)localObject12).bindLong(5, localAppOrderModify.id);
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject12;
        localObject6 = paramList;
        if (DEBUGGABLE)
        {
          localObject1 = localObject11;
          localObject2 = localObject10;
          localObject3 = localObject9;
          localObject4 = localObject8;
          localObject5 = localObject12;
          localObject6 = paramList;
          Log.d("LauncherProvider", "appOrder update folder: " + localAppOrderModify.id + ", " + localAppOrderModify.screen + ", " + localAppOrderModify.cell + ", " + localAppOrderModify.title + ", " + localAppOrderModify.secret);
        }
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject12;
        localObject6 = paramList;
        ((SQLiteStatement)localObject12).execute();
        localObject7 = localObject12;
        break;
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject12;
        localObject6 = paramList;
        ((SQLiteStatement)localObject12).bindString(3, localAppOrderModify.title);
      }
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      if (DEBUGGABLE)
      {
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        Log.d("LauncherProvider", "appOrder update title: " + localAppOrderModify.id + ", " + localAppOrderModify.title);
      }
      localObject12 = paramList;
      if (paramList == null)
      {
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        localObject12 = localSQLiteDatabase.compileStatement("UPDATE appOrder set title=? where _id=?");
      }
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = localObject12;
      if (localAppOrderModify.title == null)
      {
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = localObject12;
        ((SQLiteStatement)localObject12).bindNull(1);
      }
      for (;;)
      {
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = localObject12;
        ((SQLiteStatement)localObject12).bindLong(2, localAppOrderModify.id);
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = localObject12;
        ((SQLiteStatement)localObject12).execute();
        paramList = (List<LauncherSettings.AppOrderModify>)localObject12;
        break;
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = localObject12;
        ((SQLiteStatement)localObject12).bindString(1, localAppOrderModify.title);
      }
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      if (DEBUGGABLE)
      {
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        Log.d("LauncherProvider", "appOrder create app: " + localAppOrderModify.id + ", " + localAppOrderModify.folderId + ", " + localAppOrderModify.screen + ", " + localAppOrderModify.cell + ", " + localAppOrderModify.hidden + ", " + localAppOrderModify.title + ", " + localAppOrderModify.component.flattenToShortString());
      }
      localObject12 = localObject10;
      if (localObject10 == null)
      {
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        localObject12 = localSQLiteDatabase.compileStatement("INSERT into appOrder (_id,folderId,screen,cell,hidden,title,componentName,secret) values(?,?,?,?,?,?,?,?)");
      }
      localObject1 = localObject11;
      localObject2 = localObject12;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      ((SQLiteStatement)localObject12).bindLong(1, localAppOrderModify.id);
      localObject1 = localObject11;
      localObject2 = localObject12;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      ((SQLiteStatement)localObject12).bindLong(2, localAppOrderModify.folderId);
      localObject1 = localObject11;
      localObject2 = localObject12;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      ((SQLiteStatement)localObject12).bindLong(3, localAppOrderModify.screen);
      localObject1 = localObject11;
      localObject2 = localObject12;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      ((SQLiteStatement)localObject12).bindLong(4, localAppOrderModify.cell);
      localObject1 = localObject11;
      localObject2 = localObject12;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      if (!localAppOrderModify.hidden) {
        break label4093;
      }
      l = 1L;
      label2304:
      localObject1 = localObject11;
      localObject2 = localObject12;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      ((SQLiteStatement)localObject12).bindLong(5, l);
      localObject1 = localObject11;
      localObject2 = localObject12;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      if (localAppOrderModify.title == null)
      {
        localObject1 = localObject11;
        localObject2 = localObject12;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        ((SQLiteStatement)localObject12).bindNull(6);
      }
      for (;;)
      {
        localObject1 = localObject11;
        localObject2 = localObject12;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        ((SQLiteStatement)localObject12).bindString(7, localAppOrderModify.component.flattenToShortString());
        localObject1 = localObject11;
        localObject2 = localObject12;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        if (!localAppOrderModify.secret) {
          break label4098;
        }
        l = 1L;
        label2466:
        localObject1 = localObject11;
        localObject2 = localObject12;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        ((SQLiteStatement)localObject12).bindLong(8, l);
        localObject1 = localObject11;
        localObject2 = localObject12;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        if (DEBUGGABLE)
        {
          localObject1 = localObject11;
          localObject2 = localObject12;
          localObject3 = localObject9;
          localObject4 = localObject8;
          localObject5 = localObject7;
          localObject6 = paramList;
          Log.d("LauncherProvider", "appOrder create app: " + localAppOrderModify.id + ", " + localAppOrderModify.folderId + ", " + localAppOrderModify.screen + ", " + localAppOrderModify.cell + ", " + localAppOrderModify.hidden + ", " + localAppOrderModify.title + ", " + localAppOrderModify.secret);
        }
        localObject1 = localObject11;
        localObject2 = localObject12;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        ((SQLiteStatement)localObject12).execute();
        localObject10 = localObject12;
        break;
        localObject1 = localObject11;
        localObject2 = localObject12;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        ((SQLiteStatement)localObject12).bindString(6, localAppOrderModify.title);
      }
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      if (DEBUGGABLE)
      {
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        Log.d("LauncherProvider", "appOrder update app: " + localAppOrderModify.id + ", " + localAppOrderModify.folderId + ", " + localAppOrderModify.screen + ", " + localAppOrderModify.cell + ", " + localAppOrderModify.hidden + ", " + localAppOrderModify.title);
      }
      localObject12 = localObject8;
      if (localObject8 == null)
      {
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        localObject12 = localSQLiteDatabase.compileStatement("UPDATE appOrder set folderId=?,screen=?,cell=?,hidden=?,title=?,secret=? where _id=?");
      }
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject12;
      localObject5 = localObject7;
      localObject6 = paramList;
      ((SQLiteStatement)localObject12).bindLong(1, localAppOrderModify.folderId);
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject12;
      localObject5 = localObject7;
      localObject6 = paramList;
      ((SQLiteStatement)localObject12).bindLong(2, localAppOrderModify.screen);
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject12;
      localObject5 = localObject7;
      localObject6 = paramList;
      ((SQLiteStatement)localObject12).bindLong(3, localAppOrderModify.cell);
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject12;
      localObject5 = localObject7;
      localObject6 = paramList;
      if (!localAppOrderModify.hidden) {
        break label4103;
      }
      l = 1L;
      label3067:
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject12;
      localObject5 = localObject7;
      localObject6 = paramList;
      ((SQLiteStatement)localObject12).bindLong(4, l);
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject12;
      localObject5 = localObject7;
      localObject6 = paramList;
      if (localAppOrderModify.title == null)
      {
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject12;
        localObject5 = localObject7;
        localObject6 = paramList;
        ((SQLiteStatement)localObject12).bindNull(5);
      }
      for (;;)
      {
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject12;
        localObject5 = localObject7;
        localObject6 = paramList;
        if (!localAppOrderModify.secret) {
          break label4108;
        }
        l = 1L;
        label3190:
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject12;
        localObject5 = localObject7;
        localObject6 = paramList;
        ((SQLiteStatement)localObject12).bindLong(6, l);
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject12;
        localObject5 = localObject7;
        localObject6 = paramList;
        ((SQLiteStatement)localObject12).bindLong(7, localAppOrderModify.id);
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject12;
        localObject5 = localObject7;
        localObject6 = paramList;
        if (DEBUGGABLE)
        {
          localObject1 = localObject11;
          localObject2 = localObject10;
          localObject3 = localObject9;
          localObject4 = localObject12;
          localObject5 = localObject7;
          localObject6 = paramList;
          Log.d("LauncherProvider", "appOrder update app: " + localAppOrderModify.id + ", " + localAppOrderModify.folderId + ", " + localAppOrderModify.screen + ", " + localAppOrderModify.cell + ", " + localAppOrderModify.hidden + ", " + localAppOrderModify.title + ", " + localAppOrderModify.secret);
        }
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject12;
        localObject5 = localObject7;
        localObject6 = paramList;
        ((SQLiteStatement)localObject12).execute();
        localObject8 = localObject12;
        break;
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject12;
        localObject5 = localObject7;
        localObject6 = paramList;
        ((SQLiteStatement)localObject12).bindString(5, localAppOrderModify.title);
      }
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      if (DEBUGGABLE)
      {
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        Log.d("LauncherProvider", "appOrder delete item: " + localAppOrderModify.id);
      }
      localObject12 = localObject11;
      if (localObject11 == null)
      {
        localObject1 = localObject11;
        localObject2 = localObject10;
        localObject3 = localObject9;
        localObject4 = localObject8;
        localObject5 = localObject7;
        localObject6 = paramList;
        localObject12 = localSQLiteDatabase.compileStatement("DELETE from appOrder where _id=?");
      }
      localObject1 = localObject12;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      ((SQLiteStatement)localObject12).bindLong(1, localAppOrderModify.id);
      localObject1 = localObject12;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      ((SQLiteStatement)localObject12).execute();
      localObject11 = localObject12;
    }
    localObject1 = localObject11;
    localObject2 = localObject10;
    localObject3 = localObject9;
    localObject4 = localObject8;
    localObject5 = localObject7;
    localObject6 = paramList;
    if (DEBUGGABLE)
    {
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      Log.d("LauncherProvider", "appOrder update color: " + localAppOrderModify.id + ", " + localAppOrderModify.color);
    }
    localObject12 = localObject13;
    if (localObject13 == null)
    {
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      localObject12 = localSQLiteDatabase.compileStatement("UPDATE appOrder set color=? where _id=?");
    }
    localObject1 = localObject11;
    localObject2 = localObject10;
    localObject3 = localObject9;
    localObject4 = localObject8;
    localObject5 = localObject7;
    localObject6 = paramList;
    if (LauncherApplication.sIsFolderColorSupport)
    {
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
    }
    for (int i = localAppOrderModify.color;; i = -1)
    {
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      ((SQLiteStatement)localObject12).bindLong(1, i);
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      ((SQLiteStatement)localObject12).bindLong(2, localAppOrderModify.id);
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      ((SQLiteStatement)localObject12).execute();
      localObject13 = localObject12;
      break;
      localObject1 = localObject11;
      localObject2 = localObject10;
      localObject3 = localObject9;
      localObject4 = localObject8;
      localObject5 = localObject7;
      localObject6 = paramList;
      localSQLiteDatabase.setTransactionSuccessful();
      if (localObject9 != null) {
        ((SQLiteStatement)localObject9).close();
      }
      if (localObject7 != null) {
        ((SQLiteStatement)localObject7).close();
      }
      if (paramList != null) {
        paramList.close();
      }
      if (localObject10 != null) {
        ((SQLiteStatement)localObject10).close();
      }
      if (localObject8 != null) {
        ((SQLiteStatement)localObject8).close();
      }
      if (localObject11 != null) {
        ((SQLiteStatement)localObject11).close();
      }
      localSQLiteDatabase.endTransaction();
      return;
      break;
      label4078:
      l = 0L;
      break label615;
      label4083:
      i = -1;
      break label703;
      label4088:
      l = 0L;
      break label1342;
      label4093:
      l = 0L;
      break label2304;
      label4098:
      l = 0L;
      break label2466;
      label4103:
      l = 0L;
      break label3067;
      label4108:
      l = 0L;
      break label3190;
    }
  }
  
  public void updateScreenCount()
  {
    if (CscFeature.getInstance().getEnableStatus("CscFeature_Common_EnableSprintExtension"))
    {
      SQLiteStatement localSQLiteStatement = getDatabaseHelper().getWritableDatabase().compileStatement("UPDATE prefs SET value=? WHERE key=?");
      localSQLiteStatement.bindLong(1, LauncherApplication.getScreenCount());
      localSQLiteStatement.bindString(2, "numScreens");
      localSQLiteStatement.execute();
      localSQLiteStatement.close();
    }
  }
  
  public void updateScreenIdFavorites(List<LauncherSettings.FavoritePos> paramList)
  {
    SQLiteDatabase localSQLiteDatabase = getDatabaseHelper().getWritableDatabase();
    Object localObject = null;
    SQLiteStatement localSQLiteStatement;
    try
    {
      localSQLiteStatement = localSQLiteDatabase.compileStatement("UPDATE favorites set screen=? where _id=?");
      localObject = localSQLiteStatement;
      localSQLiteDatabase.beginTransaction();
      localObject = localSQLiteStatement;
      paramList = paramList.iterator();
      for (;;)
      {
        localObject = localSQLiteStatement;
        if (!paramList.hasNext()) {
          break;
        }
        localObject = localSQLiteStatement;
        LauncherSettings.FavoritePos localFavoritePos = (LauncherSettings.FavoritePos)paramList.next();
        localObject = localSQLiteStatement;
        localSQLiteStatement.bindLong(1, localFavoritePos.screen);
        localObject = localSQLiteStatement;
        localSQLiteStatement.bindLong(2, localFavoritePos.id);
        localObject = localSQLiteStatement;
        localSQLiteStatement.execute();
      }
      localObject = localSQLiteStatement;
    }
    finally
    {
      if (localObject != null) {
        ((SQLiteStatement)localObject).close();
      }
      localSQLiteDatabase.endTransaction();
    }
    localSQLiteDatabase.setTransactionSuccessful();
    if (localSQLiteStatement != null) {
      localSQLiteStatement.close();
    }
    localSQLiteDatabase.endTransaction();
  }
  
  public void updateScreenIndex()
  {
    if (CscFeature.getInstance().getEnableStatus("CscFeature_Common_EnableSprintExtension"))
    {
      SQLiteStatement localSQLiteStatement = getDatabaseHelper().getWritableDatabase().compileStatement("UPDATE prefs SET value=? WHERE key=?");
      localSQLiteStatement.bindLong(1, LauncherApplication.getHomeScreenIndex());
      localSQLiteStatement.bindString(2, "defaultScreen");
      localSQLiteStatement.execute();
      localSQLiteStatement.close();
    }
  }
  
  protected static class DatabaseHelper
    extends SQLiteOpenHelper
  {
    private static final int TAGS_ALLOWED_HOME = 15;
    private static final int TAGS_ALLOWED_HOTSEAT = 7;
    private static final int TAG_ALLOWED_APP = 1;
    private static final int TAG_ALLOWED_FOLDER = 4;
    private static final int TAG_ALLOWED_SHORTCUT = 2;
    private static final int TAG_ALLOWED_WIDGET = 8;
    private static final String TAG_APP = "favorite";
    private static final String TAG_APPORDER = "appOrder";
    private static final String TAG_APPWIDGET = "appwidget";
    private static final String TAG_CLOCK = "clock";
    private static final String TAG_FAVORITES = "favorites";
    private static final String TAG_FOLDER = "folder";
    private static final String TAG_HOME = "home";
    private static final String TAG_HOTSEAT = "hotseat";
    private static final String TAG_PAGE_COUNT = "PageCount";
    private static final String TAG_SACTIVITYWIDGET = "sactivitywidget";
    private static final String TAG_SCREEN_INDEX = "ScreenIndex";
    private static final String TAG_SEARCH = "search";
    private static final String TAG_SHORTCUT = "shortcut";
    private ArrayList<String> frontMenuApps;
    private final AppWidgetHost mAppWidgetHost;
    private final Context mContext;
    private String mFavoritesPath;
    private boolean mIsAttReady2GoEnable = false;
    private AtomicLong mMaxAppOrderId;
    private AtomicLong mMaxFavoriteCPId;
    private AtomicLong mMaxFavoriteId;
    private AtomicLong mMaxSprintFolderId;
    private boolean mOnlyLoadFrontApps = false;
    private XmlPullParser mParserRestore = null;
    private ArrayList<String> mPreSecretPackageList = new ArrayList();
    private int mSamsungActivityWidgetId;
    private int mSurfaceWidgetId;
    private String mWidgetTitle = null;
    
    DatabaseHelper(Context paramContext)
    {
      super("launcher.db", null, 14);
      if (LauncherProvider.DEBUGGABLE) {
        Log.d("LauncherProvider", "DATABASE_VERSION = 14");
      }
      this.mContext = paramContext;
      this.mAppWidgetHost = new AppWidgetHost(paramContext, 1024);
      if (this.mMaxFavoriteId == null) {
        this.mMaxFavoriteId = getMaxFavoriteID(getWritableDatabase());
      }
      if (this.mMaxAppOrderId == null) {
        this.mMaxAppOrderId = new AtomicLong(initializeMaxId(getWritableDatabase(), "appOrder"));
      }
      if (CscFeature.getInstance().getEnableStatus("CscFeature_Common_EnableSprintExtension"))
      {
        if (!doesTableExist(getWritableDatabase(), "sprintFolder")) {
          createSprintFolderTable(getWritableDatabase());
        }
        this.mMaxSprintFolderId = new AtomicLong(initializeMaxId(getWritableDatabase(), "sprintFolder"));
      }
    }
    
    private long addAppFolder(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues)
    {
      long l = generateNewAppOrderId();
      paramContentValues.put("_id", Long.valueOf(l));
      if (LauncherProvider.dbInsertAndCheck(this, paramSQLiteDatabase, "appOrder", null, paramContentValues) <= 0L) {
        l = -1L;
      }
      return l;
    }
    
    private long addAppShortcut(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues, PackageManager paramPackageManager, String paramString1, String paramString2)
    {
      long l3 = -1L;
      long l2 = l3;
      Object localObject;
      if (paramString1 != null)
      {
        l2 = l3;
        if (paramString2 != null)
        {
          localObject = new ComponentName(paramString1, paramString2);
          try
          {
            ActivityInfo localActivityInfo = paramPackageManager.getActivityInfo((ComponentName)localObject, 0);
            paramString2 = localActivityInfo;
            paramString1 = (String)localObject;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            try
            {
              l2 = generateNewAppOrderId();
              localObject = paramString1;
              l1 = l2;
              paramContentValues.put("_id", Long.valueOf(l2));
              localObject = paramString1;
              l1 = l2;
              paramContentValues.put("componentName", paramString1.flattenToShortString());
              localObject = paramString1;
              l1 = l2;
              paramContentValues.put("title", paramString2.loadLabel(paramPackageManager).toString());
              localObject = paramString1;
              l1 = l2;
              if (LauncherProvider.dbInsertAndCheck(this, paramSQLiteDatabase, "appOrder", null, paramContentValues) >= 0L) {
                break label256;
              }
              return -1L;
              localNameNotFoundException = localNameNotFoundException;
              l1 = l3;
              paramString1 = new ComponentName(paramPackageManager.currentToCanonicalPackageNames(new String[] { paramString1 })[0], paramString2);
            }
            catch (PackageManager.NameNotFoundException paramSQLiteDatabase)
            {
              try
              {
                paramString2 = paramPackageManager.getActivityInfo(paramString1, 0);
              }
              catch (PackageManager.NameNotFoundException paramSQLiteDatabase)
              {
                for (;;)
                {
                  localObject = paramString1;
                  long l1 = l3;
                }
              }
              paramSQLiteDatabase = paramSQLiteDatabase;
            }
          }
          localObject = paramString1;
          l1 = l3;
          l2 = l1;
          if (LauncherProvider.DEBUGGABLE)
          {
            Log.w("LauncherProvider", "Unable to get ActivityInfo for : " + ((ComponentName)localObject).flattenToShortString(), paramSQLiteDatabase);
            return l1;
          }
        }
      }
      label256:
      return l2;
    }
    
    private boolean addAppWidget(SQLiteDatabase paramSQLiteDatabase, String paramString, ContentValues paramContentValues, ComponentName paramComponentName, int paramInt1, int paramInt2)
    {
      boolean bool2 = false;
      AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(this.mContext);
      boolean bool1 = bool2;
      try
      {
        long l = generateNewFavoritesId();
        bool1 = bool2;
        int i = this.mAppWidgetHost.allocateAppWidgetId();
        bool1 = bool2;
        paramContentValues.put("itemType", Integer.valueOf(4));
        bool1 = bool2;
        paramContentValues.put("spanX", Integer.valueOf(paramInt1));
        bool1 = bool2;
        paramContentValues.put("spanY", Integer.valueOf(paramInt2));
        bool1 = bool2;
        paramContentValues.put("appWidgetId", Integer.valueOf(i));
        bool1 = bool2;
        paramContentValues.put("_id", Long.valueOf(l));
        bool1 = bool2;
        LauncherProvider.dbInsertAndCheck(this, paramSQLiteDatabase, paramString, null, paramContentValues);
        boolean bool4 = true;
        boolean bool3 = true;
        bool2 = bool3;
        if (i > -1)
        {
          bool2 = bool3;
          bool1 = bool4;
          if (!localAppWidgetManager.bindAppWidgetIdIfAllowed(i, paramComponentName))
          {
            bool1 = bool4;
            Log.e("LauncherProvider", "Problem allocating appWidgetId; bindAppWidgetIdIfAllowed returned false");
            bool2 = bool3;
          }
        }
      }
      catch (RuntimeException paramSQLiteDatabase)
      {
        do
        {
          bool2 = bool1;
        } while (!LauncherProvider.DEBUGGABLE);
        Log.e("LauncherProvider", "Problem allocating appWidgetId", paramSQLiteDatabase);
      }
      return bool2;
      return bool1;
    }
    
    private boolean addAppWidget(SQLiteDatabase paramSQLiteDatabase, String paramString1, ContentValues paramContentValues, PackageManager paramPackageManager, String paramString2, String paramString3, int paramInt1, int paramInt2)
    {
      if ((paramString2 == null) || (paramString3 == null)) {
        return false;
      }
      int j = 1;
      ComponentName localComponentName1 = new ComponentName(paramString2, paramString3);
      for (;;)
      {
        try
        {
          paramPackageManager.getReceiverInfo(localComponentName1, 0);
          i = j;
        }
        catch (Exception localException1)
        {
          ComponentName localComponentName2 = new ComponentName(paramPackageManager.currentToCanonicalPackageNames(new String[] { paramString2 })[0], paramString3);
          try
          {
            paramPackageManager.getReceiverInfo(localComponentName2, 0);
            Object localObject1 = localComponentName2;
            i = j;
          }
          catch (Exception localException2)
          {
            Object localObject2 = localComponentName2;
            i = j;
            try
            {
              if (!LauncherProvider.mIsRestoreHomeScreen) {
                continue;
              }
              localObject2 = new ComponentName("com.sec.android.app.launcher", "com.android.launcher2.WidgetReceiver");
            }
            catch (Exception paramPackageManager)
            {
              try
              {
                paramPackageManager.getReceiverInfo((ComponentName)localObject2, 0);
                paramContentValues.put("intent", paramString2 + ":" + paramString3);
                paramContentValues.put("title", this.mWidgetTitle);
                i = j;
              }
              catch (Exception paramPackageManager)
              {
                for (;;) {}
              }
              paramPackageManager = paramPackageManager;
              localObject2 = localComponentName2;
            }
          }
        }
        if (i == 0) {
          break;
        }
        return addAppWidget(paramSQLiteDatabase, paramString1, paramContentValues, localComponentName1, paramInt1, paramInt2);
        int i = 0;
      }
      return false;
    }
    
    private boolean addClockWidget(SQLiteDatabase paramSQLiteDatabase, String paramString, ContentValues paramContentValues)
    {
      return addAppWidget(paramSQLiteDatabase, paramString, paramContentValues, new ComponentName("com.android.alarmclock", "com.android.alarmclock.AnalogAppWidgetProvider"), 2, 2);
    }
    
    private long addFolder(SQLiteDatabase paramSQLiteDatabase, String paramString, ContentValues paramContentValues)
    {
      paramContentValues.put("itemType", Integer.valueOf(2));
      paramContentValues.put("spanX", Integer.valueOf(1));
      paramContentValues.put("spanY", Integer.valueOf(1));
      long l = generateNewFavoritesId();
      paramContentValues.put("_id", Long.valueOf(l));
      if (LauncherProvider.dbInsertAndCheck(this, paramSQLiteDatabase, paramString, null, paramContentValues) <= 0L) {
        l = -1L;
      }
      return l;
    }
    
    private long addHomeShortcut(SQLiteDatabase paramSQLiteDatabase, String paramString1, ContentValues paramContentValues, PackageManager paramPackageManager, Intent paramIntent, String paramString2, String paramString3, String paramString4)
    {
      long l3 = -1L;
      long l1 = l3;
      Object localObject1;
      if (paramString2 != null)
      {
        l1 = l3;
        if (paramString3 != null)
        {
          localObject1 = new ComponentName(paramString2, paramString3);
          try
          {
            localActivityInfo = paramPackageManager.getActivityInfo((ComponentName)localObject1, 0);
            localObject2 = localObject1;
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            try
            {
              Object localObject2;
              l1 = generateNewFavoritesId();
              localObject1 = localObject2;
              l2 = l1;
              paramIntent.setComponent((ComponentName)localObject2);
              localObject1 = localObject2;
              l2 = l1;
              paramIntent.setFlags(270532608);
              localObject1 = localObject2;
              l2 = l1;
              paramContentValues.put("intent", paramIntent.toUri(0));
              localObject1 = localObject2;
              l2 = l1;
              paramContentValues.put("title", localActivityInfo.loadLabel(paramPackageManager).toString());
              localObject1 = localObject2;
              l2 = l1;
              paramContentValues.put("itemType", Integer.valueOf(0));
              localObject1 = localObject2;
              l2 = l1;
              paramContentValues.put("spanX", Integer.valueOf(1));
              localObject1 = localObject2;
              l2 = l1;
              paramContentValues.put("spanY", Integer.valueOf(1));
              localObject1 = localObject2;
              l2 = l1;
              paramContentValues.put("_id", Long.valueOf(l1));
              localObject1 = localObject2;
              l2 = l1;
              if (LauncherProvider.dbInsertAndCheck(this, paramSQLiteDatabase, paramString1, null, paramContentValues) >= 0L) {
                break label465;
              }
              return -1L;
              localNameNotFoundException = localNameNotFoundException;
              l2 = l3;
              localComponentName = new ComponentName(paramPackageManager.currentToCanonicalPackageNames(new String[] { paramString2 })[0], paramString3);
            }
            catch (PackageManager.NameNotFoundException paramPackageManager)
            {
              try
              {
                ActivityInfo localActivityInfo = paramPackageManager.getActivityInfo(localComponentName, 0);
              }
              catch (PackageManager.NameNotFoundException paramPackageManager)
              {
                for (;;)
                {
                  long l2;
                  ComponentName localComponentName;
                  localObject1 = localComponentName;
                  l1 = l3;
                }
              }
              paramPackageManager = paramPackageManager;
              l1 = l2;
            }
          }
          localObject1 = localObject2;
          l2 = l3;
          if (LauncherProvider.DEBUGGABLE) {
            Log.w("LauncherProvider", "Unable to add Home app: " + paramString2 + "/" + paramString3);
          }
          if (LauncherProvider.mIsRestoreHomeScreen)
          {
            l1 = generateNewFavoritesId();
            paramIntent.setComponent((ComponentName)localObject1);
            paramIntent.setFlags(270532608);
            paramContentValues.put("intent", paramIntent.toUri(0));
            paramContentValues.put("title", paramString4);
            paramContentValues.put("itemType", Integer.valueOf(0));
            paramContentValues.put("spanX", Integer.valueOf(1));
            paramContentValues.put("spanY", Integer.valueOf(1));
            paramContentValues.put("_id", Long.valueOf(l1));
            if (LauncherProvider.dbInsertAndCheck(this, paramSQLiteDatabase, paramString1, null, paramContentValues) < 0L) {
              return -1L;
            }
          }
        }
      }
      label465:
      return l1;
    }
    
    private boolean addSamsungActivityWidget(SQLiteDatabase paramSQLiteDatabase, String paramString1, ContentValues paramContentValues, PackageManager paramPackageManager, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramString2 != null)
      {
        bool1 = bool2;
        if (paramString3 != null)
        {
          paramPackageManager = new ComponentName(paramString2, paramString3);
          bool1 = bool2;
          if (SamsungWidgetPackageManager.INSTANCE.findWidget(paramPackageManager, paramString4) != null)
          {
            paramString2 = new Intent();
            paramString2.setComponent(paramPackageManager);
            if (paramString4 != null) {
              paramString2.putExtra("com.samsung.sec.android.SAMSUNG_WIDGET.themename", paramString4);
            }
            paramContentValues.put("intent", paramString2.toUri(0));
            paramContentValues.put("itemType", Integer.valueOf(900));
            paramContentValues.put("spanX", Integer.valueOf(paramInt1));
            paramContentValues.put("spanY", Integer.valueOf(paramInt2));
            paramInt1 = this.mSamsungActivityWidgetId + 1;
            this.mSamsungActivityWidgetId = paramInt1;
            paramContentValues.put("appWidgetId", Integer.valueOf(paramInt1));
            paramContentValues.put("_id", Long.valueOf(generateNewFavoritesId()));
            if (LauncherProvider.dbInsertAndCheck(this, paramSQLiteDatabase, paramString1, null, paramContentValues) < 0L) {
              break label192;
            }
            bool1 = true;
          }
        }
      }
      return bool1;
      label192:
      return false;
    }
    
    private boolean addSearchWidget(SQLiteDatabase paramSQLiteDatabase, String paramString, ContentValues paramContentValues, int paramInt1, int paramInt2)
    {
      ComponentName localComponentName = getSearchWidgetProvider();
      if (localComponentName != null) {
        return addAppWidget(paramSQLiteDatabase, paramString, paramContentValues, localComponentName, paramInt1, paramInt2);
      }
      return false;
    }
    
    private boolean addSurfaceWidget(SQLiteDatabase paramSQLiteDatabase, String paramString1, ContentValues paramContentValues, PackageManager paramPackageManager, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramString2 != null)
      {
        bool1 = bool2;
        if (paramString3 != null)
        {
          paramPackageManager = new ComponentName(paramString2, paramString3);
          bool1 = bool2;
          if (SurfaceWidgetPackageManager.INST.findWidget(paramPackageManager, paramString4) != null)
          {
            paramString2 = new Intent();
            paramString2.setComponent(paramPackageManager);
            if (paramString4 != null) {
              paramString2.putExtra("com.samsung.sec.android.SURFACE_WIDGET.themename", paramString4);
            }
            if ((paramString5 == null) || (paramString5.isEmpty())) {
              break label215;
            }
            paramString2.putExtra("instance", Integer.parseInt(paramString5));
          }
        }
      }
      for (;;)
      {
        paramContentValues.put("intent", paramString2.toUri(0));
        paramContentValues.put("itemType", Integer.valueOf(901));
        paramContentValues.put("spanX", Integer.valueOf(paramInt1));
        paramContentValues.put("spanY", Integer.valueOf(paramInt2));
        paramContentValues.put("_id", Long.valueOf(generateNewFavoritesId()));
        paramInt1 = this.mSurfaceWidgetId + 1;
        this.mSurfaceWidgetId = paramInt1;
        paramContentValues.put("appWidgetId", Integer.valueOf(paramInt1));
        LauncherProvider.dbInsertAndCheck(this, paramSQLiteDatabase, paramString1, null, paramContentValues);
        bool1 = true;
        return bool1;
        label215:
        paramString2.putExtra("instance", 1);
      }
    }
    
    private void addToSprintFolderTable(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, boolean paramBoolean)
    {
      if (LauncherProvider.DEBUGGABLE) {
        Log.d("LauncherProvider", "addToSprintFolderTable :: pkgName:" + paramString1 + "/" + paramString2);
      }
      ContentValues localContentValues = new ContentValues();
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        localContentValues.put("packageName", paramString1);
        localContentValues.put("className", paramString2);
        localContentValues.put("isFeatured", Integer.valueOf(i));
        paramSQLiteDatabase.insert("sprintFolder", null, localContentValues);
        return;
      }
    }
    
    private long addUriShortcut(SQLiteDatabase paramSQLiteDatabase, String paramString1, ContentValues paramContentValues, TypedArray paramTypedArray, String paramString2, String paramString3, String paramString4)
    {
      Resources localResources = this.mContext.getResources();
      int i = 0;
      int j = 0;
      if (paramTypedArray != null)
      {
        i = paramTypedArray.getResourceId(7, 0);
        j = paramTypedArray.getResourceId(8, 0);
      }
      Object localObject = paramString2;
      if (paramTypedArray != null) {}
      try
      {
        localObject = paramTypedArray.getString(9);
        paramString2 = (String)localObject;
        localObject = Intent.parseUri((String)localObject, 0);
        if ((paramTypedArray != null) && ((i == 0) || (j == 0)))
        {
          Log.w("LauncherProvider", "Shortcut is missing title or icon resource ID");
          l = -1L;
          return l;
        }
      }
      catch (URISyntaxException paramSQLiteDatabase)
      {
        if (LauncherProvider.DEBUGGABLE) {
          Log.w("LauncherProvider", "Shortcut has malformed uri: " + paramString2);
        }
        return -1L;
      }
      long l = generateNewFavoritesId();
      ((Intent)localObject).setFlags(268435456);
      paramContentValues.put("intent", ((Intent)localObject).toUri(0));
      paramContentValues.put("itemType", Integer.valueOf(1));
      paramContentValues.put("spanX", Integer.valueOf(1));
      paramContentValues.put("spanY", Integer.valueOf(1));
      paramContentValues.put("_id", Long.valueOf(l));
      if (paramTypedArray != null)
      {
        paramContentValues.put("iconType", Integer.valueOf(0));
        paramContentValues.put("iconPackage", this.mContext.getPackageName());
        paramContentValues.put("title", localResources.getString(j));
        paramContentValues.put("iconResource", localResources.getResourceName(i));
        label269:
        if (LauncherProvider.dbInsertAndCheck(this, paramSQLiteDatabase, paramString1, null, paramContentValues) < 0L) {
          return -1L;
        }
      }
      else
      {
        paramString2 = (String)this.mContext.getPackageManager().getCSCPackageItemText(paramString3);
        paramContentValues.put("title", paramString2);
        paramTypedArray = this.mContext.getPackageManager().getCSCPackageItemIcon(paramString4);
        if ((paramString2 == null) || (paramString2.isEmpty()) || (paramTypedArray == null))
        {
          if (!LauncherProvider.mIsRestoreHomeScreen) {
            break label471;
          }
          if (paramString2 == null) {
            paramContentValues.put("title", this.mWidgetTitle);
          }
        }
        paramString3 = new ByteArrayOutputStream();
        if ((!LauncherProvider.mIsRestoreHomeScreen) || (paramTypedArray != null)) {
          break label484;
        }
        paramString2 = LauncherProvider.getBitmapFromBackupPath(LauncherProvider.mBasePathForRestore, paramString4);
        paramTypedArray = paramString2;
        if (paramString2 == null) {
          paramTypedArray = Resources.getSystem();
        }
      }
      label471:
      label484:
      for (paramTypedArray = ((BitmapDrawable)paramTypedArray.getDrawableForDensity(17629184, paramTypedArray.getDisplayMetrics().densityDpi)).getBitmap();; paramTypedArray = ((BitmapDrawable)paramTypedArray).getBitmap())
      {
        paramTypedArray.compress(Bitmap.CompressFormat.PNG, 100, paramString3);
        paramContentValues.put("iconType", Integer.valueOf(1));
        paramContentValues.put("icon", paramString3.toByteArray());
        break label269;
        break;
        Log.w("LauncherProvider", "Shortcut is missing title or icon resource ID from csc resource");
        return -1L;
      }
    }
    
    /* Error */
    private void checkHomescreenArrangement(SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: ldc 110
      //   2: ldc_w 545
      //   5: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   8: pop
      //   9: new 547	java/util/HashMap
      //   12: dup
      //   13: invokespecial 548	java/util/HashMap:<init>	()V
      //   16: astore 4
      //   18: aload_0
      //   19: getfield 120	com/android/launcher2/LauncherProvider$DatabaseHelper:mContext	Landroid/content/Context;
      //   22: invokevirtual 439	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   25: ldc_w 549
      //   28: invokevirtual 553	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
      //   31: astore 5
      //   33: aload 5
      //   35: ldc_w 555
      //   38: invokestatic 561	com/android/internal/util/XmlUtils:beginDocument	(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)V
      //   41: aload 5
      //   43: invokeinterface 566 1 0
      //   48: istore_2
      //   49: aload 5
      //   51: invokestatic 572	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
      //   54: astore 6
      //   56: aload 5
      //   58: invokeinterface 577 1 0
      //   63: istore_3
      //   64: iload_3
      //   65: iconst_3
      //   66: if_icmpne +14 -> 80
      //   69: aload 5
      //   71: invokeinterface 578 1 0
      //   76: iload_2
      //   77: if_icmple +158 -> 235
      //   80: iload_3
      //   81: iconst_1
      //   82: if_icmpeq +153 -> 235
      //   85: iload_3
      //   86: iconst_2
      //   87: if_icmpne -31 -> 56
      //   90: ldc_w 580
      //   93: aload 5
      //   95: invokeinterface 583 1 0
      //   100: invokevirtual 587	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   103: ifeq -47 -> 56
      //   106: aload_0
      //   107: getfield 120	com/android/launcher2/LauncherProvider$DatabaseHelper:mContext	Landroid/content/Context;
      //   110: aload 6
      //   112: getstatic 593	com/sec/android/app/launcher/R$styleable:DBUpgradeMatch	[I
      //   115: invokevirtual 597	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
      //   118: astore 7
      //   120: aload 7
      //   122: iconst_0
      //   123: invokevirtual 448	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
      //   126: astore 9
      //   128: aload 7
      //   130: iconst_1
      //   131: invokevirtual 448	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
      //   134: astore 8
      //   136: aload 9
      //   138: ifnull +82 -> 220
      //   141: aload 8
      //   143: ifnull +77 -> 220
      //   146: aload 9
      //   148: invokestatic 601	android/content/ComponentName:unflattenFromString	(Ljava/lang/String;)Landroid/content/ComponentName;
      //   151: astore 9
      //   153: aload 8
      //   155: invokestatic 601	android/content/ComponentName:unflattenFromString	(Ljava/lang/String;)Landroid/content/ComponentName;
      //   158: astore 8
      //   160: aload 9
      //   162: ifnull +58 -> 220
      //   165: aload 8
      //   167: ifnull +53 -> 220
      //   170: ldc 110
      //   172: new 251	java/lang/StringBuilder
      //   175: dup
      //   176: invokespecial 252	java/lang/StringBuilder:<init>	()V
      //   179: ldc_w 603
      //   182: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   185: aload 9
      //   187: invokevirtual 606	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   190: ldc_w 608
      //   193: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   196: aload 8
      //   198: invokevirtual 606	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   201: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   204: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   207: pop
      //   208: aload 4
      //   210: aload 9
      //   212: aload 8
      //   214: invokeinterface 613 3 0
      //   219: pop
      //   220: aload 7
      //   222: invokevirtual 616	android/content/res/TypedArray:recycle	()V
      //   225: goto -169 -> 56
      //   228: astore 5
      //   230: aload 5
      //   232: invokevirtual 619	org/xmlpull/v1/XmlPullParserException:printStackTrace	()V
      //   235: aload 4
      //   237: invokeinterface 620 1 0
      //   242: ifne +12 -> 254
      //   245: aload_0
      //   246: aload_1
      //   247: aload 4
      //   249: ldc 36
      //   251: invokevirtual 624	com/android/launcher2/LauncherProvider$DatabaseHelper:exchangeComponentFromApp	(Landroid/database/sqlite/SQLiteDatabase;Ljava/util/Map;Ljava/lang/String;)V
      //   254: return
      //   255: astore 5
      //   257: aload 5
      //   259: invokevirtual 625	java/io/IOException:printStackTrace	()V
      //   262: goto -27 -> 235
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	265	0	this	DatabaseHelper
      //   0	265	1	paramSQLiteDatabase	SQLiteDatabase
      //   48	30	2	i	int
      //   63	25	3	j	int
      //   16	232	4	localHashMap	java.util.HashMap
      //   31	63	5	localXmlResourceParser	android.content.res.XmlResourceParser
      //   228	3	5	localXmlPullParserException	XmlPullParserException
      //   255	3	5	localIOException	IOException
      //   54	57	6	localAttributeSet	AttributeSet
      //   118	103	7	localTypedArray	TypedArray
      //   134	79	8	localObject1	Object
      //   126	85	9	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   33	56	228	org/xmlpull/v1/XmlPullParserException
      //   56	64	228	org/xmlpull/v1/XmlPullParserException
      //   69	80	228	org/xmlpull/v1/XmlPullParserException
      //   90	136	228	org/xmlpull/v1/XmlPullParserException
      //   146	160	228	org/xmlpull/v1/XmlPullParserException
      //   170	220	228	org/xmlpull/v1/XmlPullParserException
      //   220	225	228	org/xmlpull/v1/XmlPullParserException
      //   33	56	255	java/io/IOException
      //   56	64	255	java/io/IOException
      //   69	80	255	java/io/IOException
      //   90	136	255	java/io/IOException
      //   146	160	255	java/io/IOException
      //   170	220	255	java/io/IOException
      //   220	225	255	java/io/IOException
    }
    
    /* Error */
    private boolean convertDatabase(SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: invokestatic 108	com/android/launcher2/LauncherProvider:access$000	()Z
      //   3: ifeq +12 -> 15
      //   6: ldc 110
      //   8: ldc_w 629
      //   11: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   14: pop
      //   15: iconst_0
      //   16: istore 4
      //   18: iconst_0
      //   19: istore_3
      //   20: ldc_w 631
      //   23: invokestatic 637	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   26: astore 7
      //   28: aload_0
      //   29: getfield 120	com/android/launcher2/LauncherProvider$DatabaseHelper:mContext	Landroid/content/Context;
      //   32: invokevirtual 641	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
      //   35: astore 8
      //   37: aconst_null
      //   38: astore 5
      //   40: aload 8
      //   42: aload 7
      //   44: aconst_null
      //   45: aconst_null
      //   46: aconst_null
      //   47: aconst_null
      //   48: invokevirtual 647	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   51: astore 6
      //   53: aload 6
      //   55: astore 5
      //   57: aload 5
      //   59: ifnull +54 -> 113
      //   62: aload 5
      //   64: invokeinterface 652 1 0
      //   69: ifle +17 -> 86
      //   72: aload_0
      //   73: aload_1
      //   74: aload 5
      //   76: invokespecial 656	com/android/launcher2/LauncherProvider$DatabaseHelper:copyFromCursor	(Landroid/database/sqlite/SQLiteDatabase;Landroid/database/Cursor;)I
      //   79: istore_2
      //   80: iload_2
      //   81: ifle +60 -> 141
      //   84: iconst_1
      //   85: istore_3
      //   86: aload 5
      //   88: invokeinterface 659 1 0
      //   93: iload_3
      //   94: istore 4
      //   96: iload_3
      //   97: ifeq +16 -> 113
      //   100: aload 8
      //   102: aload 7
      //   104: aconst_null
      //   105: aconst_null
      //   106: invokevirtual 663	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
      //   109: pop
      //   110: iload_3
      //   111: istore 4
      //   113: iload 4
      //   115: ifeq +23 -> 138
      //   118: invokestatic 108	com/android/launcher2/LauncherProvider:access$000	()Z
      //   121: ifeq +12 -> 133
      //   124: ldc 110
      //   126: ldc_w 665
      //   129: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   132: pop
      //   133: aload_0
      //   134: aload_1
      //   135: invokespecial 668	com/android/launcher2/LauncherProvider$DatabaseHelper:convertWidgets	(Landroid/database/sqlite/SQLiteDatabase;)V
      //   138: iload 4
      //   140: ireturn
      //   141: iconst_0
      //   142: istore_3
      //   143: goto -57 -> 86
      //   146: astore_1
      //   147: aload 5
      //   149: invokeinterface 659 1 0
      //   154: aload_1
      //   155: athrow
      //   156: astore 6
      //   158: goto -101 -> 57
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	161	0	this	DatabaseHelper
      //   0	161	1	paramSQLiteDatabase	SQLiteDatabase
      //   79	2	2	i	int
      //   19	124	3	bool1	boolean
      //   16	123	4	bool2	boolean
      //   38	110	5	localObject	Object
      //   51	3	6	localCursor	Cursor
      //   156	1	6	localException	Exception
      //   26	77	7	localUri	Uri
      //   35	66	8	localContentResolver	ContentResolver
      // Exception table:
      //   from	to	target	type
      //   62	80	146	finally
      //   40	53	156	java/lang/Exception
    }
    
    private void convertWidgets(SQLiteDatabase paramSQLiteDatabase)
    {
      AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(this.mContext);
      Object localObject4 = LauncherProvider.buildOrWhereString("itemType", new int[] { 1000, 1002, 1001 });
      Object localObject3 = null;
      Object localObject1 = null;
      paramSQLiteDatabase.beginTransaction();
      try
      {
        localObject4 = paramSQLiteDatabase.query("favorites", new String[] { "_id", "itemType" }, (String)localObject4, null, null, null, null);
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (!LauncherProvider.DEBUGGABLE) {
          break label148;
        }
        localObject1 = localObject4;
        localObject3 = localObject4;
        localStringBuilder = new StringBuilder().append("found upgrade cursor count=");
        if (localObject4 != null) {
          break label557;
        }
        localObject5 = "null";
      }
      catch (SQLException localSQLException2)
      {
        for (;;)
        {
          StringBuilder localStringBuilder;
          localObject3 = localObject1;
          if (LauncherProvider.DEBUGGABLE)
          {
            localObject3 = localObject1;
            Log.w("LauncherProvider", "Problem while allocating appWidgetIds for existing widgets", localSQLException2);
          }
          return;
          localObject1 = localSQLException2;
          localObject3 = localSQLException2;
          i = localSQLException2.getCount();
          Object localObject5 = Integer.valueOf(i);
          continue;
          localObject1 = localSQLException2;
          localObject3 = localSQLException2;
          ((ContentValues)localObject5).put("spanX", Integer.valueOf(2));
          localObject1 = localSQLException2;
          localObject3 = localSQLException2;
          ((ContentValues)localObject5).put("spanY", Integer.valueOf(2));
        }
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
        if (localObject3 == null) {
          break label643;
        }
        ((Cursor)localObject3).close();
      }
      localObject1 = localObject4;
      localObject3 = localObject4;
      Log.d("LauncherProvider", localObject5);
      label148:
      localObject1 = localObject4;
      localObject3 = localObject4;
      localObject5 = new ContentValues();
      int i;
      int j;
      for (;;)
      {
        if (localObject4 == null) {
          break label713;
        }
        localObject1 = localObject4;
        localObject3 = localObject4;
        if (!((Cursor)localObject4).moveToNext()) {
          break label713;
        }
        localObject1 = localObject4;
        localObject3 = localObject4;
        long l = ((Cursor)localObject4).getLong(0);
        localObject1 = localObject4;
        localObject3 = localObject4;
        i = ((Cursor)localObject4).getInt(1);
        localObject1 = localObject4;
        localObject3 = localObject4;
        try
        {
          j = this.mAppWidgetHost.allocateAppWidgetId();
          localObject1 = localObject4;
          localObject3 = localObject4;
          if (LauncherProvider.DEBUGGABLE)
          {
            localObject1 = localObject4;
            localObject3 = localObject4;
            Log.d("LauncherProvider", "allocated appWidgetId=" + j + " for favoriteId=" + l);
          }
          localObject1 = localObject4;
          localObject3 = localObject4;
          ((ContentValues)localObject5).clear();
          localObject1 = localObject4;
          localObject3 = localObject4;
          ((ContentValues)localObject5).put("itemType", Integer.valueOf(4));
          localObject1 = localObject4;
          localObject3 = localObject4;
          ((ContentValues)localObject5).put("appWidgetId", Integer.valueOf(j));
          if (i != 1001) {
            break;
          }
          localObject1 = localObject4;
          localObject3 = localObject4;
          ((ContentValues)localObject5).put("spanX", Integer.valueOf(4));
          localObject1 = localObject4;
          localObject3 = localObject4;
          ((ContentValues)localObject5).put("spanY", Integer.valueOf(1));
          localObject1 = localObject4;
          localObject3 = localObject4;
          paramSQLiteDatabase.update("favorites", (ContentValues)localObject5, "_id=" + l, null);
          if (i != 1000) {
            break label646;
          }
          localObject1 = localObject4;
          localObject3 = localObject4;
          localAppWidgetManager.bindAppWidgetIdIfAllowed(j, new ComponentName("com.android.alarmclock", "com.android.alarmclock.AnalogAppWidgetProvider"));
        }
        catch (RuntimeException localRuntimeException)
        {
          localObject1 = localObject4;
          localObject3 = localObject4;
        }
        if (LauncherProvider.DEBUGGABLE)
        {
          localObject1 = localObject4;
          localObject3 = localObject4;
          Log.e("LauncherProvider", "Problem allocating appWidgetId", localRuntimeException);
        }
      }
      label557:
      label643:
      label646:
      label713:
      do
      {
        if (i == 1002)
        {
          localSQLException1 = localSQLException2;
          localObject3 = localSQLException2;
          localAppWidgetManager.bindAppWidgetIdIfAllowed(j, new ComponentName("com.android.camera", "com.android.camera.PhotoAppWidgetProvider"));
          break;
        }
        if (i != 1001) {
          break;
        }
        SQLException localSQLException1 = localSQLException2;
        localObject3 = localSQLException2;
        localAppWidgetManager.bindAppWidgetIdIfAllowed(j, getSearchWidgetProvider());
        break;
        localSQLException1 = localSQLException2;
        localObject3 = localSQLException2;
        paramSQLiteDatabase.setTransactionSuccessful();
        paramSQLiteDatabase.endTransaction();
      } while (localSQLException2 == null);
      localSQLException2.close();
    }
    
    private int copyFromCursor(SQLiteDatabase paramSQLiteDatabase, Cursor paramCursor)
    {
      int j = paramCursor.getColumnIndexOrThrow("_id");
      int k = paramCursor.getColumnIndexOrThrow("intent");
      int m = paramCursor.getColumnIndexOrThrow("title");
      int n = paramCursor.getColumnIndexOrThrow("iconType");
      int i1 = paramCursor.getColumnIndexOrThrow("icon");
      int i2 = paramCursor.getColumnIndexOrThrow("iconPackage");
      int i3 = paramCursor.getColumnIndexOrThrow("iconResource");
      int i4 = paramCursor.getColumnIndexOrThrow("container");
      int i5 = paramCursor.getColumnIndexOrThrow("itemType");
      int i6 = paramCursor.getColumnIndexOrThrow("screen");
      int i7 = paramCursor.getColumnIndexOrThrow("cellX");
      int i8 = paramCursor.getColumnIndexOrThrow("cellY");
      ContentValues[] arrayOfContentValues = new ContentValues[paramCursor.getCount()];
      int i = 0;
      while (paramCursor.moveToNext())
      {
        ContentValues localContentValues = new ContentValues(paramCursor.getColumnCount());
        localContentValues.put("_id", Long.valueOf(paramCursor.getLong(j)));
        localContentValues.put("intent", paramCursor.getString(k));
        localContentValues.put("title", paramCursor.getString(m));
        localContentValues.put("iconType", Integer.valueOf(paramCursor.getInt(n)));
        localContentValues.put("icon", paramCursor.getBlob(i1));
        localContentValues.put("iconPackage", paramCursor.getString(i2));
        localContentValues.put("iconResource", paramCursor.getString(i3));
        localContentValues.put("container", Integer.valueOf(paramCursor.getInt(i4)));
        localContentValues.put("itemType", Integer.valueOf(paramCursor.getInt(i5)));
        localContentValues.put("appWidgetId", Integer.valueOf(-1));
        localContentValues.put("screen", Integer.valueOf(paramCursor.getInt(i6)));
        localContentValues.put("cellX", Integer.valueOf(paramCursor.getInt(i7)));
        localContentValues.put("cellY", Integer.valueOf(paramCursor.getInt(i8)));
        arrayOfContentValues[i] = localContentValues;
        i += 1;
      }
      paramSQLiteDatabase.beginTransaction();
      j = 0;
      try
      {
        k = arrayOfContentValues.length;
        i = 0;
        while (i < k)
        {
          long l = LauncherProvider.dbInsertAndCheck(this, paramSQLiteDatabase, "favorites", null, arrayOfContentValues[i]);
          if (l < 0L) {
            return 0;
          }
          j += 1;
          i += 1;
        }
        paramSQLiteDatabase.setTransactionSuccessful();
        return j;
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
    }
    
    private void createAppOrderTable(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("CREATE table appOrder (_id integer primary key,folderId integer not null default -1,screen integer not null default -1,cell integer not null default -1,hidden integer not null default 0,title text,componentName text,color integer not null default -1, secret integer not null default 0);");
      this.mMaxAppOrderId = new AtomicLong(0L);
    }
    
    private void createFavorites(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      paramSQLiteDatabase.execSQL("CREATE table " + paramString + " (" + "_id INTEGER PRIMARY KEY," + "itemType INTEGER," + "container INTEGER," + "screen INTEGER," + "cellX INTEGER," + "cellY INTEGER," + "spanX INTEGER," + "spanY INTEGER," + "title TEXT," + "intent TEXT," + "appWidgetId INTEGER NOT NULL DEFAULT -1," + "iconType INTEGER," + "iconPackage TEXT," + "iconResource TEXT," + "iconMovieUri TEXT," + "icon BLOB," + "color INTEGER NOT NULL DEFAULT -1, " + "secret INTEGER NOT NULL DEFAULT 0, " + "festival INTEGER NOT NULL DEFAULT 0" + ");");
    }
    
    private void createPublicPreferences(SQLiteDatabase paramSQLiteDatabase)
    {
      if (!doesTableExist(paramSQLiteDatabase, "prefs"))
      {
        SharedPreferences localSharedPreferences = LauncherProvider.mApp.getSharedPreferences("com.sec.android.app.launcher.prefs", 0);
        CscFeature localCscFeature = CscFeature.getInstance();
        Resources localResources = this.mContext.getResources();
        int j = localResources.getInteger(2131492873);
        int k = localSharedPreferences.getInt("screencount", 0);
        int i;
        if (k > 0)
        {
          i = k;
          if (k <= j) {}
        }
        else
        {
          k = localCscFeature.getInteger("CscFeature_Launcher_TotalPageCount");
          if (k > 0)
          {
            i = k;
            if (k <= j) {}
          }
          else
          {
            k = localResources.getInteger(2131492871);
            if (k > 0)
            {
              i = k;
              if (k <= j) {}
            }
            else
            {
              i = j;
            }
          }
        }
        k = localSharedPreferences.getInt("homescreenindex", -1);
        if (k >= 0)
        {
          j = k;
          if (k < i) {}
        }
        else
        {
          k = localCscFeature.getInteger("CscFeature_Launcher_DefaultPageNumber");
          if (k >= 0)
          {
            j = k;
            if (k < i) {}
          }
          else
          {
            k = localResources.getInteger(2131492874);
            if (k >= 0)
            {
              j = k;
              if (k < i) {}
            }
            else
            {
              j = 0;
            }
          }
        }
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS prefs(key TEXT PRIMARY KEY,value INTEGER);");
        paramSQLiteDatabase = paramSQLiteDatabase.compileStatement("insert into prefs values(?, ?)");
        paramSQLiteDatabase.bindString(1, "defaultScreen");
        paramSQLiteDatabase.bindLong(2, j);
        paramSQLiteDatabase.execute();
        paramSQLiteDatabase.bindString(1, "numScreens");
        paramSQLiteDatabase.bindLong(2, i);
        paramSQLiteDatabase.execute();
        paramSQLiteDatabase.close();
      }
    }
    
    private void createSprintFolderTable(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("CREATE table sprintFolder (_id integer primary key,packageName text,className text,isFeatured integer not null default 0);");
    }
    
    private boolean delAppFolder(SQLiteDatabase paramSQLiteDatabase, long paramLong)
    {
      return paramSQLiteDatabase.delete("appOrder", "_id=" + paramLong, null) != 0;
    }
    
    private boolean delFolder(SQLiteDatabase paramSQLiteDatabase, long paramLong)
    {
      return paramSQLiteDatabase.delete("favorites", "_id=" + paramLong, null) != 0;
    }
    
    private boolean doesTableExist(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      boolean bool1 = false;
      boolean bool2 = false;
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT count(*) from sqlite_master where name=? and type='table'", new String[] { paramString });
      if (paramSQLiteDatabase != null)
      {
        bool1 = bool2;
        if (paramSQLiteDatabase.moveToNext()) {
          if (paramSQLiteDatabase.getLong(0) <= 0L) {
            break label59;
          }
        }
      }
      label59:
      for (bool1 = true;; bool1 = false)
      {
        paramSQLiteDatabase.close();
        return bool1;
      }
    }
    
    private AtomicLong getMaxFavoriteID(SQLiteDatabase paramSQLiteDatabase)
    {
      AtomicLong localAtomicLong = new AtomicLong(initializeMaxId(paramSQLiteDatabase, "favorites"));
      paramSQLiteDatabase = new AtomicLong(initializeMaxId(paramSQLiteDatabase, "favorites"));
      if (localAtomicLong.intValue() > paramSQLiteDatabase.intValue()) {
        return localAtomicLong;
      }
      return paramSQLiteDatabase;
    }
    
    private ComponentName getProviderInPackage(String paramString)
    {
      List localList = AppWidgetManager.getInstance(this.mContext).getInstalledProviders();
      Object localObject;
      if (localList == null)
      {
        localObject = null;
        return (ComponentName)localObject;
      }
      int j = localList.size();
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label82;
        }
        ComponentName localComponentName = ((AppWidgetProviderInfo)localList.get(i)).provider;
        if (localComponentName != null)
        {
          localObject = localComponentName;
          if (localComponentName.getPackageName().equals(paramString)) {
            break;
          }
        }
        i += 1;
      }
      label82:
      return null;
    }
    
    private ComponentName getSearchWidgetProvider()
    {
      ComponentName localComponentName = ((SearchManager)this.mContext.getSystemService("search")).getGlobalSearchActivity();
      if (localComponentName == null) {
        return null;
      }
      return getProviderInPackage(localComponentName.getPackageName());
    }
    
    private ArrayList<String> getTablesList(SQLiteDatabase paramSQLiteDatabase)
    {
      ArrayList localArrayList = new ArrayList();
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
      if (paramSQLiteDatabase != null)
      {
        while (paramSQLiteDatabase.moveToNext())
        {
          String str = paramSQLiteDatabase.getString(0);
          if (LauncherProvider.DEBUGGABLE) {
            Log.d("LauncherProvider", "getTablesList()::" + str);
          }
          if (!"android_metadata".equals(str)) {
            localArrayList.add(str);
          }
        }
        paramSQLiteDatabase.close();
      }
      return localArrayList;
    }
    
    private long initializeMaxId(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select ifnull(max(_id),0) from " + paramString, null);
      long l1 = -1L;
      long l2 = l1;
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToNext()) {
          l1 = paramSQLiteDatabase.getLong(0);
        }
        paramSQLiteDatabase.close();
        l2 = l1;
      }
      if (l2 == -1L) {
        throw new RuntimeException("Error: could not query max id from table " + paramString);
      }
      return l2;
    }
    
    private int loadAppOrderContainer(SQLiteDatabase paramSQLiteDatabase, XmlPullParser paramXmlPullParser, long paramLong, boolean paramBoolean)
      throws XmlPullParserException, IOException
    {
      if (LauncherProvider.DEBUGGABLE) {
        Log.d("LauncherProvider", "loadAppOrderContainer. folderId: " + paramLong);
      }
      ContentValues localContentValues = new ContentValues();
      PackageManager localPackageManager = this.mContext.getPackageManager();
      AttributeSet localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
      int i2 = paramXmlPullParser.getDepth();
      int i = 0;
      int j = 0;
      int k;
      do
      {
        k = paramXmlPullParser.next();
        if (((k == 3) && (paramXmlPullParser.getDepth() <= i2)) || (k == 1)) {
          return j;
        }
      } while (k != 2);
      String str4 = paramXmlPullParser.getName();
      if (LauncherProvider.DEBUGGABLE) {
        Log.d("LauncherProvider", "loadApplicationsContainer. Process tag: " + str4);
      }
      TypedArray localTypedArray = null;
      String str2;
      String str1;
      String str3;
      label181:
      boolean bool2;
      boolean bool1;
      label255:
      int n;
      if (paramBoolean)
      {
        str2 = "";
        str1 = "";
        str3 = paramXmlPullParser.getAttributeValue(null, "screen");
        localContentValues.clear();
        if (!"favorite".equals(str4)) {
          break label622;
        }
        if (!paramBoolean) {
          break label397;
        }
        str2 = paramXmlPullParser.getAttributeValue(null, "packageName");
        str1 = paramXmlPullParser.getAttributeValue(null, "className");
        bool2 = Boolean.parseBoolean(paramXmlPullParser.getAttributeValue(null, "AppOrder_isFrontPosition"));
        bool1 = Boolean.parseBoolean(paramXmlPullParser.getAttributeValue(null, "hidden"));
        if (!this.mOnlyLoadFrontApps) {
          break label418;
        }
        k = i;
        n = j;
        if (!bool1)
        {
          k = i;
          n = j;
          if (bool2)
          {
            k = i;
            n = j;
            if (str1 != null)
            {
              this.frontMenuApps.add(str1);
              n = j;
              k = i;
            }
          }
        }
      }
      for (;;)
      {
        i = k;
        j = n;
        if (localTypedArray == null) {
          break;
        }
        localTypedArray.recycle();
        i = k;
        j = n;
        break;
        localTypedArray = this.mContext.obtainStyledAttributes(localAttributeSet, R.styleable.AppOrder);
        str2 = localTypedArray.getString(1);
        str1 = localTypedArray.getString(0);
        str3 = localTypedArray.getString(2);
        localTypedArray.getBoolean(4, false);
        break label181;
        label397:
        bool2 = localTypedArray.getBoolean(4, false);
        bool1 = localTypedArray.getBoolean(5, false);
        break label255;
        label418:
        if (bool1) {
          localContentValues.put("hidden", Boolean.valueOf(bool1));
        }
        if (paramLong == -1L)
        {
          localContentValues.put("screen", str3);
          localContentValues.put("cell", String.valueOf(i));
        }
        int i1;
        int m;
        for (;;)
        {
          i1 = i;
          m = j;
          if (addAppShortcut(paramSQLiteDatabase, localContentValues, localPackageManager, str2, str1) >= 0L)
          {
            m = j + 1;
            i1 = i + 1;
          }
          k = i1;
          n = m;
          if (!CscFeature.getInstance().getEnableStatus("CscFeature_Common_EnableSprintExtension")) {
            break;
          }
          if (paramLong != getSprintFolderID(true)) {
            break label583;
          }
          addToSprintFolderTable(paramSQLiteDatabase, str2, str1, true);
          k = i1;
          n = m;
          break;
          localContentValues.put("folderId", Long.valueOf(paramLong));
          localContentValues.put("screen", String.valueOf(j));
        }
        label583:
        k = i1;
        n = m;
        if (paramLong == getSprintFolderID(false))
        {
          addToSprintFolderTable(paramSQLiteDatabase, str2, str1, false);
          k = i1;
          n = m;
          continue;
          label622:
          if ((!this.mOnlyLoadFrontApps) && (paramLong == -1L) && ("folder".equals(str4)))
          {
            str1 = null;
            label666:
            long l;
            if (paramBoolean)
            {
              str1 = paramXmlPullParser.getAttributeValue(null, "title");
              localContentValues.put("title", str1);
              localContentValues.put("screen", str3);
              localContentValues.put("cell", String.valueOf(i));
              l = addAppFolder(paramSQLiteDatabase, localContentValues);
              k = i;
              n = j;
              if (l == -1L) {
                continue;
              }
              if (!str1.equalsIgnoreCase(this.mContext.getResources().getString(2131755237))) {
                break label872;
              }
              setSprintFolderId(l, false);
              label752:
              j += 1;
              m = i + 1;
              n = loadAppOrderContainer(paramSQLiteDatabase, paramXmlPullParser, l, paramBoolean);
              k = m;
              i = j;
              if (n == 0)
              {
                k = m;
                i = j;
                if (!CscFeature.getInstance().getEnableStatus("CscFeature_Common_EnableSprintExtension"))
                {
                  if (!delAppFolder(paramSQLiteDatabase, l)) {
                    break label903;
                  }
                  i = j - 1;
                  k = m - 1;
                }
              }
            }
            for (;;)
            {
              n = i + n;
              break;
              k = localTypedArray.getResourceId(3, -1);
              if (k == -1) {
                break label666;
              }
              str1 = this.mContext.getResources().getString(k);
              break label666;
              label872:
              if (!str1.equalsIgnoreCase(this.mContext.getResources().getString(2131755238))) {
                break label752;
              }
              setSprintFolderId(l, true);
              break label752;
              label903:
              k = m;
              i = j;
              if (LauncherProvider.DEBUGGABLE)
              {
                Log.w("LauncherProvider", "Failed to delete empty Appfolder. _id: " + l);
                k = m;
                i = j;
              }
            }
          }
          else
          {
            k = i;
            n = j;
            if (LauncherProvider.DEBUGGABLE)
            {
              Log.e("LauncherProvider", "Invalid tag <" + str4 + "> detected while parsing favorites at line " + paramXmlPullParser.getLineNumber());
              k = i;
              n = j;
            }
          }
        }
      }
    }
    
    /* Error */
    private int loadAppOrderDefaults(SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: ldc 110
      //   4: ldc_w 1013
      //   7: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   10: pop
      //   11: aconst_null
      //   12: astore 9
      //   14: aconst_null
      //   15: astore 13
      //   17: aconst_null
      //   18: astore 14
      //   20: aconst_null
      //   21: astore 15
      //   23: aconst_null
      //   24: astore 8
      //   26: iconst_0
      //   27: istore 4
      //   29: aload 9
      //   31: astore 10
      //   33: aload 13
      //   35: astore 11
      //   37: aload 14
      //   39: astore 12
      //   41: aload 15
      //   43: astore 7
      //   45: new 1015	java/io/File
      //   48: dup
      //   49: ldc_w 1017
      //   52: invokespecial 1018	java/io/File:<init>	(Ljava/lang/String;)V
      //   55: astore 16
      //   57: aload 9
      //   59: astore 10
      //   61: aload 13
      //   63: astore 11
      //   65: aload 14
      //   67: astore 12
      //   69: aload 15
      //   71: astore 7
      //   73: invokestatic 1021	com/android/launcher2/LauncherApplication:getInst	()Lcom/android/launcher2/LauncherApplication;
      //   76: invokevirtual 1024	com/android/launcher2/LauncherApplication:isKnoxMode	()Z
      //   79: istore 5
      //   81: aload 9
      //   83: astore 10
      //   85: aload 13
      //   87: astore 11
      //   89: aload 14
      //   91: astore 12
      //   93: aload 15
      //   95: astore 7
      //   97: invokestatic 1027	com/android/launcher2/LauncherApplication:isOwner	()Z
      //   100: istore 6
      //   102: iload 5
      //   104: ifeq +106 -> 210
      //   107: aload 9
      //   109: astore 10
      //   111: aload 13
      //   113: astore 11
      //   115: aload 14
      //   117: astore 12
      //   119: aload 15
      //   121: astore 7
      //   123: aload_0
      //   124: getfield 120	com/android/launcher2/LauncherProvider$DatabaseHelper:mContext	Landroid/content/Context;
      //   127: invokevirtual 439	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   130: ldc_w 1028
      //   133: invokevirtual 553	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
      //   136: astore 16
      //   138: aload 9
      //   140: astore 10
      //   142: aload 13
      //   144: astore 11
      //   146: aload 14
      //   148: astore 12
      //   150: aload 15
      //   152: astore 7
      //   154: aload 16
      //   156: ldc 27
      //   158: invokestatic 1029	com/android/launcher2/LauncherProvider:beginDocument	(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)V
      //   161: aload 16
      //   163: astore 9
      //   165: aload 8
      //   167: astore 10
      //   169: aload 8
      //   171: astore 11
      //   173: aload 8
      //   175: astore 12
      //   177: aload 8
      //   179: astore 7
      //   181: aload_0
      //   182: aload_1
      //   183: aload 9
      //   185: ldc2_w 206
      //   188: iload 4
      //   190: invokespecial 994	com/android/launcher2/LauncherProvider$DatabaseHelper:loadAppOrderContainer	(Landroid/database/sqlite/SQLiteDatabase;Lorg/xmlpull/v1/XmlPullParser;JZ)I
      //   193: istore_2
      //   194: iload_2
      //   195: istore_3
      //   196: aload 8
      //   198: ifnull +10 -> 208
      //   201: aload 8
      //   203: invokevirtual 1032	java/io/FileReader:close	()V
      //   206: iload_2
      //   207: istore_3
      //   208: iload_3
      //   209: ireturn
      //   210: iload 6
      //   212: ifne +64 -> 276
      //   215: aload 9
      //   217: astore 10
      //   219: aload 13
      //   221: astore 11
      //   223: aload 14
      //   225: astore 12
      //   227: aload 15
      //   229: astore 7
      //   231: aload_0
      //   232: getfield 120	com/android/launcher2/LauncherProvider$DatabaseHelper:mContext	Landroid/content/Context;
      //   235: invokevirtual 439	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   238: ldc_w 1033
      //   241: invokevirtual 553	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
      //   244: astore 16
      //   246: aload 9
      //   248: astore 10
      //   250: aload 13
      //   252: astore 11
      //   254: aload 14
      //   256: astore 12
      //   258: aload 15
      //   260: astore 7
      //   262: aload 16
      //   264: ldc 27
      //   266: invokestatic 1029	com/android/launcher2/LauncherProvider:beginDocument	(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)V
      //   269: aload 16
      //   271: astore 9
      //   273: goto -108 -> 165
      //   276: aload 9
      //   278: astore 10
      //   280: aload 13
      //   282: astore 11
      //   284: aload 14
      //   286: astore 12
      //   288: aload 15
      //   290: astore 7
      //   292: aload 16
      //   294: invokevirtual 1036	java/io/File:isFile	()Z
      //   297: ifeq +90 -> 387
      //   300: aload 9
      //   302: astore 10
      //   304: aload 13
      //   306: astore 11
      //   308: aload 14
      //   310: astore 12
      //   312: aload 15
      //   314: astore 7
      //   316: aload 16
      //   318: invokevirtual 1039	java/io/File:length	()J
      //   321: lconst_0
      //   322: lcmp
      //   323: ifle +64 -> 387
      //   326: aload 9
      //   328: astore 10
      //   330: aload 13
      //   332: astore 11
      //   334: aload 14
      //   336: astore 12
      //   338: aload 15
      //   340: astore 7
      //   342: new 1031	java/io/FileReader
      //   345: dup
      //   346: ldc_w 1017
      //   349: invokespecial 1040	java/io/FileReader:<init>	(Ljava/lang/String;)V
      //   352: astore 8
      //   354: invokestatic 1046	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
      //   357: astore 7
      //   359: aload 7
      //   361: iconst_1
      //   362: invokevirtual 1050	org/xmlpull/v1/XmlPullParserFactory:setNamespaceAware	(Z)V
      //   365: aload 7
      //   367: invokevirtual 1054	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
      //   370: astore 9
      //   372: aload 9
      //   374: aload 8
      //   376: invokeinterface 1058 2 0
      //   381: iconst_1
      //   382: istore 4
      //   384: goto -219 -> 165
      //   387: aload 9
      //   389: astore 10
      //   391: aload 13
      //   393: astore 11
      //   395: aload 14
      //   397: astore 12
      //   399: aload 15
      //   401: astore 7
      //   403: aload_0
      //   404: getfield 120	com/android/launcher2/LauncherProvider$DatabaseHelper:mContext	Landroid/content/Context;
      //   407: invokevirtual 439	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   410: ldc_w 1059
      //   413: invokevirtual 553	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
      //   416: astore 16
      //   418: aload 9
      //   420: astore 10
      //   422: aload 13
      //   424: astore 11
      //   426: aload 14
      //   428: astore 12
      //   430: aload 15
      //   432: astore 7
      //   434: aload 16
      //   436: ldc 27
      //   438: invokestatic 1029	com/android/launcher2/LauncherProvider:beginDocument	(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)V
      //   441: aload 16
      //   443: astore 9
      //   445: goto -280 -> 165
      //   448: astore_1
      //   449: aload 10
      //   451: astore 7
      //   453: invokestatic 108	com/android/launcher2/LauncherProvider:access$000	()Z
      //   456: ifeq +17 -> 473
      //   459: aload 10
      //   461: astore 7
      //   463: ldc 110
      //   465: ldc_w 1061
      //   468: aload_1
      //   469: invokestatic 308	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   472: pop
      //   473: aload 10
      //   475: ifnull -267 -> 208
      //   478: aload 10
      //   480: invokevirtual 1032	java/io/FileReader:close	()V
      //   483: iconst_0
      //   484: ireturn
      //   485: astore_1
      //   486: iconst_0
      //   487: ireturn
      //   488: astore_1
      //   489: aload 11
      //   491: astore 7
      //   493: invokestatic 108	com/android/launcher2/LauncherProvider:access$000	()Z
      //   496: ifeq +17 -> 513
      //   499: aload 11
      //   501: astore 7
      //   503: ldc 110
      //   505: ldc_w 1061
      //   508: aload_1
      //   509: invokestatic 308	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   512: pop
      //   513: aload 11
      //   515: ifnull -307 -> 208
      //   518: aload 11
      //   520: invokevirtual 1032	java/io/FileReader:close	()V
      //   523: iconst_0
      //   524: ireturn
      //   525: astore_1
      //   526: iconst_0
      //   527: ireturn
      //   528: astore_1
      //   529: aload 12
      //   531: astore 7
      //   533: invokestatic 108	com/android/launcher2/LauncherProvider:access$000	()Z
      //   536: ifeq +17 -> 553
      //   539: aload 12
      //   541: astore 7
      //   543: ldc 110
      //   545: ldc_w 1061
      //   548: aload_1
      //   549: invokestatic 308	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   552: pop
      //   553: aload 12
      //   555: ifnull -347 -> 208
      //   558: aload 12
      //   560: invokevirtual 1032	java/io/FileReader:close	()V
      //   563: iconst_0
      //   564: ireturn
      //   565: astore_1
      //   566: iconst_0
      //   567: ireturn
      //   568: astore_1
      //   569: aload 7
      //   571: ifnull +8 -> 579
      //   574: aload 7
      //   576: invokevirtual 1032	java/io/FileReader:close	()V
      //   579: aload_1
      //   580: athrow
      //   581: astore_1
      //   582: iload_2
      //   583: ireturn
      //   584: astore 7
      //   586: goto -7 -> 579
      //   589: astore_1
      //   590: aload 8
      //   592: astore 7
      //   594: goto -25 -> 569
      //   597: astore_1
      //   598: aload 8
      //   600: astore 12
      //   602: goto -73 -> 529
      //   605: astore_1
      //   606: aload 8
      //   608: astore 11
      //   610: goto -121 -> 489
      //   613: astore_1
      //   614: aload 8
      //   616: astore 10
      //   618: goto -169 -> 449
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	621	0	this	DatabaseHelper
      //   0	621	1	paramSQLiteDatabase	SQLiteDatabase
      //   193	390	2	i	int
      //   1	208	3	j	int
      //   27	356	4	bool1	boolean
      //   79	24	5	bool2	boolean
      //   100	111	6	bool3	boolean
      //   43	532	7	localObject1	Object
      //   584	1	7	localException	Exception
      //   592	1	7	localFileReader1	java.io.FileReader
      //   24	591	8	localFileReader2	java.io.FileReader
      //   12	432	9	localObject2	Object
      //   31	586	10	localObject3	Object
      //   35	574	11	localObject4	Object
      //   39	562	12	localObject5	Object
      //   15	408	13	localObject6	Object
      //   18	409	14	localObject7	Object
      //   21	410	15	localObject8	Object
      //   55	387	16	localObject9	Object
      // Exception table:
      //   from	to	target	type
      //   45	57	448	org/xmlpull/v1/XmlPullParserException
      //   73	81	448	org/xmlpull/v1/XmlPullParserException
      //   97	102	448	org/xmlpull/v1/XmlPullParserException
      //   123	138	448	org/xmlpull/v1/XmlPullParserException
      //   154	161	448	org/xmlpull/v1/XmlPullParserException
      //   181	194	448	org/xmlpull/v1/XmlPullParserException
      //   231	246	448	org/xmlpull/v1/XmlPullParserException
      //   262	269	448	org/xmlpull/v1/XmlPullParserException
      //   292	300	448	org/xmlpull/v1/XmlPullParserException
      //   316	326	448	org/xmlpull/v1/XmlPullParserException
      //   342	354	448	org/xmlpull/v1/XmlPullParserException
      //   403	418	448	org/xmlpull/v1/XmlPullParserException
      //   434	441	448	org/xmlpull/v1/XmlPullParserException
      //   478	483	485	java/lang/Exception
      //   45	57	488	java/io/IOException
      //   73	81	488	java/io/IOException
      //   97	102	488	java/io/IOException
      //   123	138	488	java/io/IOException
      //   154	161	488	java/io/IOException
      //   181	194	488	java/io/IOException
      //   231	246	488	java/io/IOException
      //   262	269	488	java/io/IOException
      //   292	300	488	java/io/IOException
      //   316	326	488	java/io/IOException
      //   342	354	488	java/io/IOException
      //   403	418	488	java/io/IOException
      //   434	441	488	java/io/IOException
      //   518	523	525	java/lang/Exception
      //   45	57	528	android/content/res/Resources$NotFoundException
      //   73	81	528	android/content/res/Resources$NotFoundException
      //   97	102	528	android/content/res/Resources$NotFoundException
      //   123	138	528	android/content/res/Resources$NotFoundException
      //   154	161	528	android/content/res/Resources$NotFoundException
      //   181	194	528	android/content/res/Resources$NotFoundException
      //   231	246	528	android/content/res/Resources$NotFoundException
      //   262	269	528	android/content/res/Resources$NotFoundException
      //   292	300	528	android/content/res/Resources$NotFoundException
      //   316	326	528	android/content/res/Resources$NotFoundException
      //   342	354	528	android/content/res/Resources$NotFoundException
      //   403	418	528	android/content/res/Resources$NotFoundException
      //   434	441	528	android/content/res/Resources$NotFoundException
      //   558	563	565	java/lang/Exception
      //   45	57	568	finally
      //   73	81	568	finally
      //   97	102	568	finally
      //   123	138	568	finally
      //   154	161	568	finally
      //   181	194	568	finally
      //   231	246	568	finally
      //   262	269	568	finally
      //   292	300	568	finally
      //   316	326	568	finally
      //   342	354	568	finally
      //   403	418	568	finally
      //   434	441	568	finally
      //   453	459	568	finally
      //   463	473	568	finally
      //   493	499	568	finally
      //   503	513	568	finally
      //   533	539	568	finally
      //   543	553	568	finally
      //   201	206	581	java/lang/Exception
      //   574	579	584	java/lang/Exception
      //   354	381	589	finally
      //   354	381	597	android/content/res/Resources$NotFoundException
      //   354	381	605	java/io/IOException
      //   354	381	613	org/xmlpull/v1/XmlPullParserException
    }
    
    /* Error */
    private int loadDynamicCscFavorites(SQLiteDatabase paramSQLiteDatabase, String paramString, boolean paramBoolean)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 8
      //   3: iconst_0
      //   4: istore 9
      //   6: iconst_0
      //   7: istore 10
      //   9: iconst_0
      //   10: istore 11
      //   12: iconst_0
      //   13: istore 12
      //   15: iconst_0
      //   16: istore 13
      //   18: iconst_0
      //   19: istore 4
      //   21: aconst_null
      //   22: astore 20
      //   24: aconst_null
      //   25: astore 21
      //   27: aconst_null
      //   28: astore 22
      //   30: aconst_null
      //   31: astore 23
      //   33: aconst_null
      //   34: astore 16
      //   36: iconst_0
      //   37: istore 14
      //   39: aload 20
      //   41: astore 17
      //   43: iload 8
      //   45: istore 5
      //   47: aload 21
      //   49: astore 18
      //   51: iload 10
      //   53: istore 6
      //   55: aload 22
      //   57: astore 19
      //   59: iload 12
      //   61: istore 7
      //   63: aload 23
      //   65: astore 15
      //   67: invokestatic 1046	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
      //   70: astore 24
      //   72: aload 20
      //   74: astore 17
      //   76: iload 8
      //   78: istore 5
      //   80: aload 21
      //   82: astore 18
      //   84: iload 10
      //   86: istore 6
      //   88: aload 22
      //   90: astore 19
      //   92: iload 12
      //   94: istore 7
      //   96: aload 23
      //   98: astore 15
      //   100: aload 24
      //   102: iconst_1
      //   103: invokevirtual 1050	org/xmlpull/v1/XmlPullParserFactory:setNamespaceAware	(Z)V
      //   106: aload 20
      //   108: astore 17
      //   110: iload 8
      //   112: istore 5
      //   114: aload 21
      //   116: astore 18
      //   118: iload 10
      //   120: istore 6
      //   122: aload 22
      //   124: astore 19
      //   126: iload 12
      //   128: istore 7
      //   130: aload 23
      //   132: astore 15
      //   134: new 1015	java/io/File
      //   137: dup
      //   138: ldc_w 1064
      //   141: invokespecial 1018	java/io/File:<init>	(Ljava/lang/String;)V
      //   144: astore 25
      //   146: aload 20
      //   148: astore 17
      //   150: iload 8
      //   152: istore 5
      //   154: aload 21
      //   156: astore 18
      //   158: iload 10
      //   160: istore 6
      //   162: aload 22
      //   164: astore 19
      //   166: iload 12
      //   168: istore 7
      //   170: aload 23
      //   172: astore 15
      //   174: aload 25
      //   176: invokevirtual 1036	java/io/File:isFile	()Z
      //   179: ifeq +256 -> 435
      //   182: aload 20
      //   184: astore 17
      //   186: iload 8
      //   188: istore 5
      //   190: aload 21
      //   192: astore 18
      //   194: iload 10
      //   196: istore 6
      //   198: aload 22
      //   200: astore 19
      //   202: iload 12
      //   204: istore 7
      //   206: aload 23
      //   208: astore 15
      //   210: aload 25
      //   212: invokevirtual 1039	java/io/File:length	()J
      //   215: lconst_0
      //   216: lcmp
      //   217: ifle +218 -> 435
      //   220: aload 20
      //   222: astore 17
      //   224: iload 8
      //   226: istore 5
      //   228: aload 21
      //   230: astore 18
      //   232: iload 10
      //   234: istore 6
      //   236: aload 22
      //   238: astore 19
      //   240: iload 12
      //   242: istore 7
      //   244: aload 23
      //   246: astore 15
      //   248: new 1031	java/io/FileReader
      //   251: dup
      //   252: aload 25
      //   254: invokespecial 1067	java/io/FileReader:<init>	(Ljava/io/File;)V
      //   257: astore 16
      //   259: aload 24
      //   261: invokevirtual 1054	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
      //   264: astore 20
      //   266: aload 20
      //   268: aload 16
      //   270: invokeinterface 1058 2 0
      //   275: iconst_1
      //   276: istore 14
      //   278: aload 16
      //   280: astore 17
      //   282: iload 8
      //   284: istore 5
      //   286: aload 16
      //   288: astore 18
      //   290: iload 10
      //   292: istore 6
      //   294: aload 16
      //   296: astore 19
      //   298: iload 12
      //   300: istore 7
      //   302: aload 16
      //   304: astore 15
      //   306: aload 20
      //   308: invokeinterface 566 1 0
      //   313: istore 8
      //   315: aload 16
      //   317: astore 17
      //   319: iload 4
      //   321: istore 5
      //   323: aload 16
      //   325: astore 18
      //   327: iload 4
      //   329: istore 6
      //   331: aload 16
      //   333: astore 19
      //   335: iload 4
      //   337: istore 7
      //   339: aload 16
      //   341: astore 15
      //   343: aload 20
      //   345: invokeinterface 936 1 0
      //   350: istore 9
      //   352: iload 9
      //   354: iconst_3
      //   355: if_icmpne +47 -> 402
      //   358: aload 16
      //   360: astore 17
      //   362: iload 4
      //   364: istore 5
      //   366: aload 16
      //   368: astore 18
      //   370: iload 4
      //   372: istore 6
      //   374: aload 16
      //   376: astore 19
      //   378: iload 4
      //   380: istore 7
      //   382: aload 16
      //   384: astore 15
      //   386: aload 20
      //   388: invokeinterface 566 1 0
      //   393: istore 10
      //   395: iload 10
      //   397: iload 8
      //   399: if_icmple +15 -> 414
      //   402: iload 9
      //   404: iconst_1
      //   405: if_icmpeq +9 -> 414
      //   408: iload 9
      //   410: iconst_1
      //   411: if_icmpne +109 -> 520
      //   414: iload 4
      //   416: istore 5
      //   418: aload 16
      //   420: ifnull +12 -> 432
      //   423: aload 16
      //   425: invokevirtual 1032	java/io/FileReader:close	()V
      //   428: iload 4
      //   430: istore 5
      //   432: iload 5
      //   434: ireturn
      //   435: aload 20
      //   437: astore 17
      //   439: iload 8
      //   441: istore 5
      //   443: aload 21
      //   445: astore 18
      //   447: iload 10
      //   449: istore 6
      //   451: aload 22
      //   453: astore 19
      //   455: iload 12
      //   457: istore 7
      //   459: aload 23
      //   461: astore 15
      //   463: aload_0
      //   464: getfield 120	com/android/launcher2/LauncherProvider$DatabaseHelper:mContext	Landroid/content/Context;
      //   467: invokevirtual 439	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   470: ldc_w 1068
      //   473: invokevirtual 553	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
      //   476: astore 24
      //   478: aload 20
      //   480: astore 17
      //   482: iload 8
      //   484: istore 5
      //   486: aload 21
      //   488: astore 18
      //   490: iload 10
      //   492: istore 6
      //   494: aload 22
      //   496: astore 19
      //   498: iload 12
      //   500: istore 7
      //   502: aload 23
      //   504: astore 15
      //   506: aload 24
      //   508: ldc 36
      //   510: invokestatic 1029	com/android/launcher2/LauncherProvider:beginDocument	(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)V
      //   513: aload 24
      //   515: astore 20
      //   517: goto -239 -> 278
      //   520: iload 9
      //   522: iconst_2
      //   523: if_icmpne -208 -> 315
      //   526: aload 16
      //   528: astore 17
      //   530: iload 4
      //   532: istore 5
      //   534: aload 16
      //   536: astore 18
      //   538: iload 4
      //   540: istore 6
      //   542: aload 16
      //   544: astore 19
      //   546: iload 4
      //   548: istore 7
      //   550: aload 16
      //   552: astore 15
      //   554: aload 20
      //   556: invokeinterface 583 1 0
      //   561: astore 21
      //   563: aload 16
      //   565: astore 17
      //   567: iload 4
      //   569: istore 5
      //   571: aload 16
      //   573: astore 18
      //   575: iload 4
      //   577: istore 6
      //   579: aload 16
      //   581: astore 19
      //   583: iload 4
      //   585: istore 7
      //   587: aload 16
      //   589: astore 15
      //   591: ldc 42
      //   593: aload 21
      //   595: invokevirtual 587	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   598: ifeq +58 -> 656
      //   601: iload_3
      //   602: ifne -287 -> 315
      //   605: aload 16
      //   607: astore 17
      //   609: iload 4
      //   611: istore 5
      //   613: aload 16
      //   615: astore 18
      //   617: iload 4
      //   619: istore 6
      //   621: aload 16
      //   623: astore 19
      //   625: iload 4
      //   627: istore 7
      //   629: aload 16
      //   631: astore 15
      //   633: iload 4
      //   635: aload_0
      //   636: aload_1
      //   637: aload_2
      //   638: aload 20
      //   640: ldc2_w 1069
      //   643: bipush 15
      //   645: iload 14
      //   647: invokespecial 1074	com/android/launcher2/LauncherProvider$DatabaseHelper:loadFavoritesContainer	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;JIZ)I
      //   650: iadd
      //   651: istore 4
      //   653: goto -338 -> 315
      //   656: aload 16
      //   658: astore 17
      //   660: iload 4
      //   662: istore 5
      //   664: aload 16
      //   666: astore 18
      //   668: iload 4
      //   670: istore 6
      //   672: aload 16
      //   674: astore 19
      //   676: iload 4
      //   678: istore 7
      //   680: aload 16
      //   682: astore 15
      //   684: ldc 45
      //   686: aload 21
      //   688: invokevirtual 587	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   691: ifeq +54 -> 745
      //   694: aload 16
      //   696: astore 17
      //   698: iload 4
      //   700: istore 5
      //   702: aload 16
      //   704: astore 18
      //   706: iload 4
      //   708: istore 6
      //   710: aload 16
      //   712: astore 19
      //   714: iload 4
      //   716: istore 7
      //   718: aload 16
      //   720: astore 15
      //   722: iload 4
      //   724: aload_0
      //   725: aload_1
      //   726: aload_2
      //   727: aload 20
      //   729: ldc2_w 1075
      //   732: bipush 7
      //   734: iload 14
      //   736: invokespecial 1074	com/android/launcher2/LauncherProvider$DatabaseHelper:loadFavoritesContainer	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;JIZ)I
      //   739: iadd
      //   740: istore 4
      //   742: goto -427 -> 315
      //   745: aload 16
      //   747: astore 17
      //   749: iload 4
      //   751: istore 5
      //   753: aload 16
      //   755: astore 18
      //   757: iload 4
      //   759: istore 6
      //   761: aload 16
      //   763: astore 19
      //   765: iload 4
      //   767: istore 7
      //   769: aload 16
      //   771: astore 15
      //   773: ldc 110
      //   775: new 251	java/lang/StringBuilder
      //   778: dup
      //   779: invokespecial 252	java/lang/StringBuilder:<init>	()V
      //   782: ldc_w 1001
      //   785: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   788: aload 21
      //   790: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   793: ldc_w 1003
      //   796: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   799: aload 20
      //   801: invokeinterface 1006 1 0
      //   806: invokevirtual 700	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   809: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   812: invokestatic 304	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   815: pop
      //   816: goto -501 -> 315
      //   819: astore_1
      //   820: iload 5
      //   822: istore 4
      //   824: aload 17
      //   826: astore 15
      //   828: ldc 110
      //   830: ldc_w 1078
      //   833: aload_1
      //   834: invokestatic 308	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   837: pop
      //   838: iload 4
      //   840: istore 5
      //   842: aload 17
      //   844: ifnull -412 -> 432
      //   847: aload 17
      //   849: invokevirtual 1032	java/io/FileReader:close	()V
      //   852: iload 4
      //   854: ireturn
      //   855: astore_1
      //   856: iload 4
      //   858: ireturn
      //   859: astore_1
      //   860: aload 18
      //   862: astore 15
      //   864: ldc 110
      //   866: ldc_w 1078
      //   869: aload_1
      //   870: invokestatic 308	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   873: pop
      //   874: iload 6
      //   876: istore 5
      //   878: aload 18
      //   880: ifnull -448 -> 432
      //   883: aload 18
      //   885: invokevirtual 1032	java/io/FileReader:close	()V
      //   888: iload 6
      //   890: ireturn
      //   891: astore_1
      //   892: iload 6
      //   894: ireturn
      //   895: astore_1
      //   896: aload 19
      //   898: astore 15
      //   900: ldc 110
      //   902: ldc_w 1078
      //   905: aload_1
      //   906: invokestatic 308	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   909: pop
      //   910: iload 7
      //   912: istore 5
      //   914: aload 19
      //   916: ifnull -484 -> 432
      //   919: aload 19
      //   921: invokevirtual 1032	java/io/FileReader:close	()V
      //   924: iload 7
      //   926: ireturn
      //   927: astore_1
      //   928: iload 7
      //   930: ireturn
      //   931: astore_1
      //   932: aload 15
      //   934: ifnull +8 -> 942
      //   937: aload 15
      //   939: invokevirtual 1032	java/io/FileReader:close	()V
      //   942: aload_1
      //   943: athrow
      //   944: astore_1
      //   945: iload 4
      //   947: ireturn
      //   948: astore_2
      //   949: goto -7 -> 942
      //   952: astore_1
      //   953: aload 16
      //   955: astore 15
      //   957: goto -25 -> 932
      //   960: astore_1
      //   961: aload 16
      //   963: astore 19
      //   965: iload 13
      //   967: istore 7
      //   969: goto -73 -> 896
      //   972: astore_1
      //   973: aload 16
      //   975: astore 18
      //   977: iload 11
      //   979: istore 6
      //   981: goto -121 -> 860
      //   984: astore_1
      //   985: aload 16
      //   987: astore 17
      //   989: iload 9
      //   991: istore 4
      //   993: goto -169 -> 824
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	996	0	this	DatabaseHelper
      //   0	996	1	paramSQLiteDatabase	SQLiteDatabase
      //   0	996	2	paramString	String
      //   0	996	3	paramBoolean	boolean
      //   19	973	4	i	int
      //   45	868	5	j	int
      //   53	927	6	k	int
      //   61	907	7	m	int
      //   1	482	8	n	int
      //   4	986	9	i1	int
      //   7	484	10	i2	int
      //   10	968	11	i3	int
      //   13	486	12	i4	int
      //   16	950	13	i5	int
      //   37	698	14	bool	boolean
      //   65	891	15	localObject1	Object
      //   34	952	16	localFileReader	java.io.FileReader
      //   41	947	17	localObject2	Object
      //   49	927	18	localObject3	Object
      //   57	907	19	localObject4	Object
      //   22	778	20	localObject5	Object
      //   25	764	21	str	String
      //   28	467	22	localObject6	Object
      //   31	472	23	localObject7	Object
      //   70	444	24	localObject8	Object
      //   144	109	25	localFile	File
      // Exception table:
      //   from	to	target	type
      //   67	72	819	org/xmlpull/v1/XmlPullParserException
      //   100	106	819	org/xmlpull/v1/XmlPullParserException
      //   134	146	819	org/xmlpull/v1/XmlPullParserException
      //   174	182	819	org/xmlpull/v1/XmlPullParserException
      //   210	220	819	org/xmlpull/v1/XmlPullParserException
      //   248	259	819	org/xmlpull/v1/XmlPullParserException
      //   306	315	819	org/xmlpull/v1/XmlPullParserException
      //   343	352	819	org/xmlpull/v1/XmlPullParserException
      //   386	395	819	org/xmlpull/v1/XmlPullParserException
      //   463	478	819	org/xmlpull/v1/XmlPullParserException
      //   506	513	819	org/xmlpull/v1/XmlPullParserException
      //   554	563	819	org/xmlpull/v1/XmlPullParserException
      //   591	601	819	org/xmlpull/v1/XmlPullParserException
      //   633	653	819	org/xmlpull/v1/XmlPullParserException
      //   684	694	819	org/xmlpull/v1/XmlPullParserException
      //   722	742	819	org/xmlpull/v1/XmlPullParserException
      //   773	816	819	org/xmlpull/v1/XmlPullParserException
      //   847	852	855	java/lang/Exception
      //   67	72	859	java/io/IOException
      //   100	106	859	java/io/IOException
      //   134	146	859	java/io/IOException
      //   174	182	859	java/io/IOException
      //   210	220	859	java/io/IOException
      //   248	259	859	java/io/IOException
      //   306	315	859	java/io/IOException
      //   343	352	859	java/io/IOException
      //   386	395	859	java/io/IOException
      //   463	478	859	java/io/IOException
      //   506	513	859	java/io/IOException
      //   554	563	859	java/io/IOException
      //   591	601	859	java/io/IOException
      //   633	653	859	java/io/IOException
      //   684	694	859	java/io/IOException
      //   722	742	859	java/io/IOException
      //   773	816	859	java/io/IOException
      //   883	888	891	java/lang/Exception
      //   67	72	895	android/content/res/Resources$NotFoundException
      //   100	106	895	android/content/res/Resources$NotFoundException
      //   134	146	895	android/content/res/Resources$NotFoundException
      //   174	182	895	android/content/res/Resources$NotFoundException
      //   210	220	895	android/content/res/Resources$NotFoundException
      //   248	259	895	android/content/res/Resources$NotFoundException
      //   306	315	895	android/content/res/Resources$NotFoundException
      //   343	352	895	android/content/res/Resources$NotFoundException
      //   386	395	895	android/content/res/Resources$NotFoundException
      //   463	478	895	android/content/res/Resources$NotFoundException
      //   506	513	895	android/content/res/Resources$NotFoundException
      //   554	563	895	android/content/res/Resources$NotFoundException
      //   591	601	895	android/content/res/Resources$NotFoundException
      //   633	653	895	android/content/res/Resources$NotFoundException
      //   684	694	895	android/content/res/Resources$NotFoundException
      //   722	742	895	android/content/res/Resources$NotFoundException
      //   773	816	895	android/content/res/Resources$NotFoundException
      //   919	924	927	java/lang/Exception
      //   67	72	931	finally
      //   100	106	931	finally
      //   134	146	931	finally
      //   174	182	931	finally
      //   210	220	931	finally
      //   248	259	931	finally
      //   306	315	931	finally
      //   343	352	931	finally
      //   386	395	931	finally
      //   463	478	931	finally
      //   506	513	931	finally
      //   554	563	931	finally
      //   591	601	931	finally
      //   633	653	931	finally
      //   684	694	931	finally
      //   722	742	931	finally
      //   773	816	931	finally
      //   828	838	931	finally
      //   864	874	931	finally
      //   900	910	931	finally
      //   423	428	944	java/lang/Exception
      //   937	942	948	java/lang/Exception
      //   259	275	952	finally
      //   259	275	960	android/content/res/Resources$NotFoundException
      //   259	275	972	java/io/IOException
      //   259	275	984	org/xmlpull/v1/XmlPullParserException
    }
    
    /* Error */
    private int loadFavorites(SQLiteDatabase paramSQLiteDatabase, String paramString, boolean paramBoolean)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 10
      //   3: iconst_0
      //   4: istore 9
      //   6: iconst_0
      //   7: istore 8
      //   9: iconst_0
      //   10: istore 13
      //   12: iconst_0
      //   13: istore 11
      //   15: iconst_0
      //   16: istore 12
      //   18: iconst_0
      //   19: istore 4
      //   21: invokestatic 108	com/android/launcher2/LauncherProvider:access$000	()Z
      //   24: ifeq +39 -> 63
      //   27: ldc 110
      //   29: new 251	java/lang/StringBuilder
      //   32: dup
      //   33: invokespecial 252	java/lang/StringBuilder:<init>	()V
      //   36: ldc_w 1080
      //   39: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   42: aload_2
      //   43: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   46: ldc_w 1082
      //   49: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   52: iload_3
      //   53: invokevirtual 1085	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   56: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   59: invokestatic 118	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   62: pop
      //   63: aconst_null
      //   64: astore 29
      //   66: aconst_null
      //   67: astore 32
      //   69: aconst_null
      //   70: astore 30
      //   72: aconst_null
      //   73: astore 31
      //   75: aconst_null
      //   76: astore 28
      //   78: iconst_0
      //   79: istore 14
      //   81: aload 29
      //   83: astore 25
      //   85: iload 10
      //   87: istore 5
      //   89: aload 32
      //   91: astore 26
      //   93: iload 8
      //   95: istore 6
      //   97: aload 30
      //   99: astore 24
      //   101: iload 11
      //   103: istore 7
      //   105: aload 31
      //   107: astore 21
      //   109: invokestatic 1046	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
      //   112: astore 33
      //   114: aload 29
      //   116: astore 25
      //   118: iload 10
      //   120: istore 5
      //   122: aload 32
      //   124: astore 26
      //   126: iload 8
      //   128: istore 6
      //   130: aload 30
      //   132: astore 24
      //   134: iload 11
      //   136: istore 7
      //   138: aload 31
      //   140: astore 21
      //   142: aload 33
      //   144: iconst_1
      //   145: invokevirtual 1050	org/xmlpull/v1/XmlPullParserFactory:setNamespaceAware	(Z)V
      //   148: aconst_null
      //   149: astore 23
      //   151: aconst_null
      //   152: astore 27
      //   154: aload 29
      //   156: astore 25
      //   158: iload 10
      //   160: istore 5
      //   162: aload 32
      //   164: astore 26
      //   166: iload 8
      //   168: istore 6
      //   170: aload 30
      //   172: astore 24
      //   174: iload 11
      //   176: istore 7
      //   178: aload 31
      //   180: astore 21
      //   182: aload_0
      //   183: getfield 120	com/android/launcher2/LauncherProvider$DatabaseHelper:mContext	Landroid/content/Context;
      //   186: invokevirtual 439	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   189: astore 22
      //   191: aload 29
      //   193: astore 25
      //   195: iload 10
      //   197: istore 5
      //   199: aload 32
      //   201: astore 26
      //   203: iload 8
      //   205: istore 6
      //   207: aload 30
      //   209: astore 24
      //   211: iload 11
      //   213: istore 7
      //   215: aload 31
      //   217: astore 21
      //   219: new 1015	java/io/File
      //   222: dup
      //   223: ldc_w 1087
      //   226: invokespecial 1018	java/io/File:<init>	(Ljava/lang/String;)V
      //   229: astore 20
      //   231: aload 29
      //   233: astore 25
      //   235: iload 10
      //   237: istore 5
      //   239: aload 32
      //   241: astore 26
      //   243: iload 8
      //   245: istore 6
      //   247: aload 30
      //   249: astore 24
      //   251: iload 11
      //   253: istore 7
      //   255: aload 31
      //   257: astore 21
      //   259: invokestatic 1021	com/android/launcher2/LauncherApplication:getInst	()Lcom/android/launcher2/LauncherApplication;
      //   262: invokevirtual 1024	com/android/launcher2/LauncherApplication:isKnoxMode	()Z
      //   265: istore 16
      //   267: aload 29
      //   269: astore 25
      //   271: iload 10
      //   273: istore 5
      //   275: aload 32
      //   277: astore 26
      //   279: iload 8
      //   281: istore 6
      //   283: aload 30
      //   285: astore 24
      //   287: iload 11
      //   289: istore 7
      //   291: aload 31
      //   293: astore 21
      //   295: invokestatic 1027	com/android/launcher2/LauncherApplication:isOwner	()Z
      //   298: istore 15
      //   300: aload 29
      //   302: astore 25
      //   304: iload 10
      //   306: istore 5
      //   308: aload 32
      //   310: astore 26
      //   312: iload 8
      //   314: istore 6
      //   316: aload 30
      //   318: astore 24
      //   320: iload 11
      //   322: istore 7
      //   324: aload 31
      //   326: astore 21
      //   328: aload_0
      //   329: getfield 120	com/android/launcher2/LauncherProvider$DatabaseHelper:mContext	Landroid/content/Context;
      //   332: invokevirtual 475	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
      //   335: ldc_w 1089
      //   338: invokevirtual 1092	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
      //   341: istore 17
      //   343: aload 29
      //   345: astore 25
      //   347: iload 10
      //   349: istore 5
      //   351: aload 32
      //   353: astore 26
      //   355: iload 8
      //   357: istore 6
      //   359: aload 30
      //   361: astore 24
      //   363: iload 11
      //   365: istore 7
      //   367: aload 31
      //   369: astore 21
      //   371: invokestatic 319	com/android/launcher2/LauncherProvider:access$200	()Z
      //   374: ifeq +475 -> 849
      //   377: aload 29
      //   379: astore 25
      //   381: iload 10
      //   383: istore 5
      //   385: aload 32
      //   387: astore 26
      //   389: iload 8
      //   391: istore 6
      //   393: aload 30
      //   395: astore 24
      //   397: iload 11
      //   399: istore 7
      //   401: aload 31
      //   403: astore 21
      //   405: aload_0
      //   406: getfield 93	com/android/launcher2/LauncherProvider$DatabaseHelper:mParserRestore	Lorg/xmlpull/v1/XmlPullParser;
      //   409: astore 33
      //   411: aload 29
      //   413: astore 25
      //   415: iload 10
      //   417: istore 5
      //   419: aload 32
      //   421: astore 26
      //   423: iload 8
      //   425: istore 6
      //   427: aload 30
      //   429: astore 24
      //   431: iload 11
      //   433: istore 7
      //   435: aload 31
      //   437: astore 21
      //   439: aload 33
      //   441: invokeinterface 1095 1 0
      //   446: pop
      //   447: iconst_1
      //   448: istore 15
      //   450: aload 33
      //   452: astore 23
      //   454: iload 15
      //   456: istore 14
      //   458: aload 28
      //   460: astore 20
      //   462: aload 27
      //   464: astore 22
      //   466: aload 29
      //   468: astore 25
      //   470: iload 10
      //   472: istore 5
      //   474: aload 32
      //   476: astore 26
      //   478: iload 8
      //   480: istore 6
      //   482: aload 30
      //   484: astore 24
      //   486: iload 11
      //   488: istore 7
      //   490: aload 31
      //   492: astore 21
      //   494: invokestatic 808	com/android/launcher2/LauncherProvider:access$100	()Lcom/android/launcher2/LauncherApplication;
      //   497: ifnull +140 -> 637
      //   500: aload 29
      //   502: astore 25
      //   504: iload 10
      //   506: istore 5
      //   508: aload 32
      //   510: astore 26
      //   512: iload 8
      //   514: istore 6
      //   516: aload 30
      //   518: astore 24
      //   520: iload 11
      //   522: istore 7
      //   524: aload 31
      //   526: astore 21
      //   528: invokestatic 808	com/android/launcher2/LauncherProvider:access$100	()Lcom/android/launcher2/LauncherApplication;
      //   531: ldc_w 810
      //   534: iconst_0
      //   535: invokevirtual 816	com/android/launcher2/LauncherApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
      //   538: invokeinterface 1099 1 0
      //   543: astore 20
      //   545: aload 29
      //   547: astore 25
      //   549: iload 10
      //   551: istore 5
      //   553: aload 32
      //   555: astore 26
      //   557: iload 8
      //   559: istore 6
      //   561: aload 30
      //   563: astore 24
      //   565: iload 11
      //   567: istore 7
      //   569: aload 31
      //   571: astore 21
      //   573: aload 20
      //   575: ldc_w 1101
      //   578: iconst_1
      //   579: invokeinterface 1107 3 0
      //   584: pop
      //   585: aload 29
      //   587: astore 25
      //   589: iload 10
      //   591: istore 5
      //   593: aload 32
      //   595: astore 26
      //   597: iload 8
      //   599: istore 6
      //   601: aload 30
      //   603: astore 24
      //   605: iload 11
      //   607: istore 7
      //   609: aload 31
      //   611: astore 21
      //   613: aload 20
      //   615: invokeinterface 1110 1 0
      //   620: pop
      //   621: aload 27
      //   623: astore 22
      //   625: aload 28
      //   627: astore 20
      //   629: iload 15
      //   631: istore 14
      //   633: aload 33
      //   635: astore 23
      //   637: aload 22
      //   639: ifnull +42 -> 681
      //   642: aload 20
      //   644: astore 25
      //   646: iload 10
      //   648: istore 5
      //   650: aload 20
      //   652: astore 26
      //   654: iload 8
      //   656: istore 6
      //   658: aload 20
      //   660: astore 24
      //   662: iload 11
      //   664: istore 7
      //   666: aload 20
      //   668: astore 21
      //   670: aload 22
      //   672: ldc 36
      //   674: invokestatic 1029	com/android/launcher2/LauncherProvider:beginDocument	(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)V
      //   677: aload 22
      //   679: astore 23
      //   681: aload 20
      //   683: astore 25
      //   685: iload 10
      //   687: istore 5
      //   689: aload 20
      //   691: astore 26
      //   693: iload 8
      //   695: istore 6
      //   697: aload 20
      //   699: astore 24
      //   701: iload 11
      //   703: istore 7
      //   705: aload 20
      //   707: astore 21
      //   709: aload 23
      //   711: invokeinterface 566 1 0
      //   716: istore 8
      //   718: aload 20
      //   720: astore 25
      //   722: iload 4
      //   724: istore 5
      //   726: aload 20
      //   728: astore 26
      //   730: iload 4
      //   732: istore 6
      //   734: aload 20
      //   736: astore 24
      //   738: iload 4
      //   740: istore 7
      //   742: aload 20
      //   744: astore 21
      //   746: aload 23
      //   748: invokeinterface 936 1 0
      //   753: istore 10
      //   755: iload 10
      //   757: iconst_3
      //   758: if_icmpne +47 -> 805
      //   761: aload 20
      //   763: astore 25
      //   765: iload 4
      //   767: istore 5
      //   769: aload 20
      //   771: astore 26
      //   773: iload 4
      //   775: istore 6
      //   777: aload 20
      //   779: astore 24
      //   781: iload 4
      //   783: istore 7
      //   785: aload 20
      //   787: astore 21
      //   789: aload 23
      //   791: invokeinterface 566 1 0
      //   796: istore 9
      //   798: iload 9
      //   800: iload 8
      //   802: if_icmple +15 -> 817
      //   805: iload 10
      //   807: iconst_1
      //   808: if_icmpeq +9 -> 817
      //   811: iload 10
      //   813: iconst_1
      //   814: if_icmpne +782 -> 1596
      //   817: iload 4
      //   819: istore 5
      //   821: aload 20
      //   823: ifnull +12 -> 835
      //   826: aload 20
      //   828: invokevirtual 1032	java/io/FileReader:close	()V
      //   831: iload 4
      //   833: istore 5
      //   835: invokestatic 319	com/android/launcher2/LauncherProvider:access$200	()Z
      //   838: ifeq +8 -> 846
      //   841: iconst_0
      //   842: invokestatic 1114	com/android/launcher2/LauncherProvider:access$202	(Z)Z
      //   845: pop
      //   846: iload 5
      //   848: ireturn
      //   849: iload 16
      //   851: ifeq +48 -> 899
      //   854: aload 29
      //   856: astore 25
      //   858: iload 10
      //   860: istore 5
      //   862: aload 32
      //   864: astore 26
      //   866: iload 8
      //   868: istore 6
      //   870: aload 30
      //   872: astore 24
      //   874: iload 11
      //   876: istore 7
      //   878: aload 31
      //   880: astore 21
      //   882: aload 22
      //   884: ldc_w 1115
      //   887: invokevirtual 553	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
      //   890: astore 22
      //   892: aload 28
      //   894: astore 20
      //   896: goto -259 -> 637
      //   899: iload 15
      //   901: ifne +48 -> 949
      //   904: aload 29
      //   906: astore 25
      //   908: iload 10
      //   910: istore 5
      //   912: aload 32
      //   914: astore 26
      //   916: iload 8
      //   918: istore 6
      //   920: aload 30
      //   922: astore 24
      //   924: iload 11
      //   926: istore 7
      //   928: aload 31
      //   930: astore 21
      //   932: aload 22
      //   934: ldc_w 1116
      //   937: invokevirtual 553	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
      //   940: astore 22
      //   942: aload 28
      //   944: astore 20
      //   946: goto -309 -> 637
      //   949: iconst_0
      //   950: ifeq +269 -> 1219
      //   953: aload 29
      //   955: astore 25
      //   957: iload 10
      //   959: istore 5
      //   961: aload 32
      //   963: astore 26
      //   965: iload 8
      //   967: istore 6
      //   969: aload 30
      //   971: astore 24
      //   973: iload 11
      //   975: istore 7
      //   977: aload 31
      //   979: astore 21
      //   981: aload_0
      //   982: iconst_0
      //   983: putfield 91	com/android/launcher2/LauncherProvider$DatabaseHelper:mIsAttReady2GoEnable	Z
      //   986: aload 29
      //   988: astore 25
      //   990: iload 10
      //   992: istore 5
      //   994: aload 32
      //   996: astore 26
      //   998: iload 8
      //   1000: istore 6
      //   1002: aload 30
      //   1004: astore 24
      //   1006: iload 11
      //   1008: istore 7
      //   1010: aload 31
      //   1012: astore 21
      //   1014: new 1015	java/io/File
      //   1017: dup
      //   1018: aload_0
      //   1019: getfield 1118	com/android/launcher2/LauncherProvider$DatabaseHelper:mFavoritesPath	Ljava/lang/String;
      //   1022: invokespecial 1018	java/io/File:<init>	(Ljava/lang/String;)V
      //   1025: astore 20
      //   1027: aload 29
      //   1029: astore 25
      //   1031: iload 10
      //   1033: istore 5
      //   1035: aload 32
      //   1037: astore 26
      //   1039: iload 8
      //   1041: istore 6
      //   1043: aload 30
      //   1045: astore 24
      //   1047: iload 11
      //   1049: istore 7
      //   1051: aload 31
      //   1053: astore 21
      //   1055: aload 20
      //   1057: invokevirtual 1036	java/io/File:isFile	()Z
      //   1060: ifeq +45 -> 1105
      //   1063: aload 29
      //   1065: astore 25
      //   1067: iload 10
      //   1069: istore 5
      //   1071: aload 32
      //   1073: astore 26
      //   1075: iload 8
      //   1077: istore 6
      //   1079: aload 30
      //   1081: astore 24
      //   1083: iload 11
      //   1085: istore 7
      //   1087: aload 31
      //   1089: astore 21
      //   1091: aload 20
      //   1093: invokevirtual 1039	java/io/File:length	()J
      //   1096: lstore 18
      //   1098: lload 18
      //   1100: lconst_0
      //   1101: lcmp
      //   1102: ifne +17 -> 1119
      //   1105: iconst_0
      //   1106: ifeq +11 -> 1117
      //   1109: new 1120	java/lang/NullPointerException
      //   1112: dup
      //   1113: invokespecial 1121	java/lang/NullPointerException:<init>	()V
      //   1116: athrow
      //   1117: iconst_0
      //   1118: ireturn
      //   1119: aload 29
      //   1121: astore 25
      //   1123: iload 10
      //   1125: istore 5
      //   1127: aload 32
      //   1129: astore 26
      //   1131: iload 8
      //   1133: istore 6
      //   1135: aload 30
      //   1137: astore 24
      //   1139: iload 11
      //   1141: istore 7
      //   1143: aload 31
      //   1145: astore 21
      //   1147: new 1031	java/io/FileReader
      //   1150: dup
      //   1151: aload_0
      //   1152: getfield 1118	com/android/launcher2/LauncherProvider$DatabaseHelper:mFavoritesPath	Ljava/lang/String;
      //   1155: invokespecial 1040	java/io/FileReader:<init>	(Ljava/lang/String;)V
      //   1158: astore 20
      //   1160: aload 20
      //   1162: astore 21
      //   1164: aload 20
      //   1166: astore 23
      //   1168: aload 20
      //   1170: astore 22
      //   1172: aload 20
      //   1174: astore 24
      //   1176: aload 33
      //   1178: invokevirtual 1054	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
      //   1181: astore 25
      //   1183: aload 20
      //   1185: astore 21
      //   1187: aload 20
      //   1189: astore 23
      //   1191: aload 20
      //   1193: astore 22
      //   1195: aload 20
      //   1197: astore 24
      //   1199: aload 25
      //   1201: aload 20
      //   1203: invokeinterface 1058 2 0
      //   1208: aload 25
      //   1210: astore 23
      //   1212: aload 27
      //   1214: astore 22
      //   1216: goto -579 -> 637
      //   1219: aload 29
      //   1221: astore 25
      //   1223: iload 10
      //   1225: istore 5
      //   1227: aload 32
      //   1229: astore 26
      //   1231: iload 8
      //   1233: istore 6
      //   1235: aload 30
      //   1237: astore 24
      //   1239: iload 11
      //   1241: istore 7
      //   1243: aload 31
      //   1245: astore 21
      //   1247: aload 20
      //   1249: invokevirtual 1036	java/io/File:isFile	()Z
      //   1252: ifeq +249 -> 1501
      //   1255: aload 29
      //   1257: astore 25
      //   1259: iload 10
      //   1261: istore 5
      //   1263: aload 32
      //   1265: astore 26
      //   1267: iload 8
      //   1269: istore 6
      //   1271: aload 30
      //   1273: astore 24
      //   1275: iload 11
      //   1277: istore 7
      //   1279: aload 31
      //   1281: astore 21
      //   1283: aload 20
      //   1285: invokevirtual 1039	java/io/File:length	()J
      //   1288: lconst_0
      //   1289: lcmp
      //   1290: ifle +211 -> 1501
      //   1293: aload 29
      //   1295: astore 25
      //   1297: iload 10
      //   1299: istore 5
      //   1301: aload 32
      //   1303: astore 26
      //   1305: iload 8
      //   1307: istore 6
      //   1309: aload 30
      //   1311: astore 24
      //   1313: iload 11
      //   1315: istore 7
      //   1317: aload 31
      //   1319: astore 21
      //   1321: new 1031	java/io/FileReader
      //   1324: dup
      //   1325: aload 20
      //   1327: invokespecial 1067	java/io/FileReader:<init>	(Ljava/io/File;)V
      //   1330: astore 20
      //   1332: aload 20
      //   1334: astore 21
      //   1336: aload 20
      //   1338: astore 23
      //   1340: aload 20
      //   1342: astore 22
      //   1344: aload 20
      //   1346: astore 24
      //   1348: aload 33
      //   1350: invokevirtual 1054	org/xmlpull/v1/XmlPullParserFactory:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
      //   1353: astore 25
      //   1355: aload 20
      //   1357: astore 21
      //   1359: aload 20
      //   1361: astore 23
      //   1363: aload 20
      //   1365: astore 22
      //   1367: aload 20
      //   1369: astore 24
      //   1371: aload 25
      //   1373: aload 20
      //   1375: invokeinterface 1058 2 0
      //   1380: iconst_1
      //   1381: istore 14
      //   1383: aload 20
      //   1385: astore 21
      //   1387: aload 20
      //   1389: astore 23
      //   1391: aload 20
      //   1393: astore 22
      //   1395: aload 20
      //   1397: astore 24
      //   1399: invokestatic 808	com/android/launcher2/LauncherProvider:access$100	()Lcom/android/launcher2/LauncherApplication;
      //   1402: ifnull +1078 -> 2480
      //   1405: aload 20
      //   1407: astore 21
      //   1409: aload 20
      //   1411: astore 23
      //   1413: aload 20
      //   1415: astore 22
      //   1417: aload 20
      //   1419: astore 24
      //   1421: invokestatic 808	com/android/launcher2/LauncherProvider:access$100	()Lcom/android/launcher2/LauncherApplication;
      //   1424: ldc_w 810
      //   1427: iconst_0
      //   1428: invokevirtual 816	com/android/launcher2/LauncherApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
      //   1431: invokeinterface 1099 1 0
      //   1436: astore 26
      //   1438: aload 20
      //   1440: astore 21
      //   1442: aload 20
      //   1444: astore 23
      //   1446: aload 20
      //   1448: astore 22
      //   1450: aload 20
      //   1452: astore 24
      //   1454: aload 26
      //   1456: ldc_w 1101
      //   1459: iconst_1
      //   1460: invokeinterface 1107 3 0
      //   1465: pop
      //   1466: aload 20
      //   1468: astore 21
      //   1470: aload 20
      //   1472: astore 23
      //   1474: aload 20
      //   1476: astore 22
      //   1478: aload 20
      //   1480: astore 24
      //   1482: aload 26
      //   1484: invokeinterface 1110 1 0
      //   1489: pop
      //   1490: aload 25
      //   1492: astore 23
      //   1494: aload 27
      //   1496: astore 22
      //   1498: goto -861 -> 637
      //   1501: iload 17
      //   1503: ifne +48 -> 1551
      //   1506: aload 29
      //   1508: astore 25
      //   1510: iload 10
      //   1512: istore 5
      //   1514: aload 32
      //   1516: astore 26
      //   1518: iload 8
      //   1520: istore 6
      //   1522: aload 30
      //   1524: astore 24
      //   1526: iload 11
      //   1528: istore 7
      //   1530: aload 31
      //   1532: astore 21
      //   1534: aload 22
      //   1536: ldc_w 1122
      //   1539: invokevirtual 553	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
      //   1542: astore 22
      //   1544: aload 28
      //   1546: astore 20
      //   1548: goto -911 -> 637
      //   1551: aload 29
      //   1553: astore 25
      //   1555: iload 10
      //   1557: istore 5
      //   1559: aload 32
      //   1561: astore 26
      //   1563: iload 8
      //   1565: istore 6
      //   1567: aload 30
      //   1569: astore 24
      //   1571: iload 11
      //   1573: istore 7
      //   1575: aload 31
      //   1577: astore 21
      //   1579: aload 22
      //   1581: ldc_w 1123
      //   1584: invokevirtual 553	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
      //   1587: astore 22
      //   1589: aload 28
      //   1591: astore 20
      //   1593: goto -956 -> 637
      //   1596: iload 10
      //   1598: iconst_2
      //   1599: if_icmpne -881 -> 718
      //   1602: aload 20
      //   1604: astore 25
      //   1606: iload 4
      //   1608: istore 5
      //   1610: aload 20
      //   1612: astore 26
      //   1614: iload 4
      //   1616: istore 6
      //   1618: aload 20
      //   1620: astore 24
      //   1622: iload 4
      //   1624: istore 7
      //   1626: aload 20
      //   1628: astore 21
      //   1630: aload 23
      //   1632: invokeinterface 583 1 0
      //   1637: astore 22
      //   1639: aload 20
      //   1641: astore 25
      //   1643: iload 4
      //   1645: istore 5
      //   1647: aload 20
      //   1649: astore 26
      //   1651: iload 4
      //   1653: istore 6
      //   1655: aload 20
      //   1657: astore 24
      //   1659: iload 4
      //   1661: istore 7
      //   1663: aload 20
      //   1665: astore 21
      //   1667: ldc 42
      //   1669: aload 22
      //   1671: invokevirtual 587	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1674: ifeq +58 -> 1732
      //   1677: iload_3
      //   1678: ifne -960 -> 718
      //   1681: aload 20
      //   1683: astore 25
      //   1685: iload 4
      //   1687: istore 5
      //   1689: aload 20
      //   1691: astore 26
      //   1693: iload 4
      //   1695: istore 6
      //   1697: aload 20
      //   1699: astore 24
      //   1701: iload 4
      //   1703: istore 7
      //   1705: aload 20
      //   1707: astore 21
      //   1709: iload 4
      //   1711: aload_0
      //   1712: aload_1
      //   1713: aload_2
      //   1714: aload 23
      //   1716: ldc2_w 1069
      //   1719: bipush 15
      //   1721: iload 14
      //   1723: invokespecial 1074	com/android/launcher2/LauncherProvider$DatabaseHelper:loadFavoritesContainer	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;JIZ)I
      //   1726: iadd
      //   1727: istore 4
      //   1729: goto -1011 -> 718
      //   1732: aload 20
      //   1734: astore 25
      //   1736: iload 4
      //   1738: istore 5
      //   1740: aload 20
      //   1742: astore 26
      //   1744: iload 4
      //   1746: istore 6
      //   1748: aload 20
      //   1750: astore 24
      //   1752: iload 4
      //   1754: istore 7
      //   1756: aload 20
      //   1758: astore 21
      //   1760: ldc 45
      //   1762: aload 22
      //   1764: invokevirtual 587	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1767: ifeq +54 -> 1821
      //   1770: aload 20
      //   1772: astore 25
      //   1774: iload 4
      //   1776: istore 5
      //   1778: aload 20
      //   1780: astore 26
      //   1782: iload 4
      //   1784: istore 6
      //   1786: aload 20
      //   1788: astore 24
      //   1790: iload 4
      //   1792: istore 7
      //   1794: aload 20
      //   1796: astore 21
      //   1798: iload 4
      //   1800: aload_0
      //   1801: aload_1
      //   1802: aload_2
      //   1803: aload 23
      //   1805: ldc2_w 1075
      //   1808: bipush 7
      //   1810: iload 14
      //   1812: invokespecial 1074	com/android/launcher2/LauncherProvider$DatabaseHelper:loadFavoritesContainer	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Lorg/xmlpull/v1/XmlPullParser;JIZ)I
      //   1815: iadd
      //   1816: istore 4
      //   1818: goto -1100 -> 718
      //   1821: aload 20
      //   1823: astore 25
      //   1825: iload 4
      //   1827: istore 5
      //   1829: aload 20
      //   1831: astore 26
      //   1833: iload 4
      //   1835: istore 6
      //   1837: aload 20
      //   1839: astore 24
      //   1841: iload 4
      //   1843: istore 7
      //   1845: aload 20
      //   1847: astore 21
      //   1849: ldc 48
      //   1851: aload 22
      //   1853: invokevirtual 587	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1856: ifeq +181 -> 2037
      //   1859: aload 20
      //   1861: astore 25
      //   1863: iload 4
      //   1865: istore 5
      //   1867: aload 20
      //   1869: astore 26
      //   1871: iload 4
      //   1873: istore 6
      //   1875: aload 20
      //   1877: astore 24
      //   1879: iload 4
      //   1881: istore 7
      //   1883: aload 20
      //   1885: astore 21
      //   1887: aload 23
      //   1889: invokeinterface 936 1 0
      //   1894: iconst_4
      //   1895: if_icmpne -1177 -> 718
      //   1898: aload 20
      //   1900: astore 25
      //   1902: iload 4
      //   1904: istore 5
      //   1906: aload 20
      //   1908: astore 26
      //   1910: iload 4
      //   1912: istore 6
      //   1914: aload 20
      //   1916: astore 24
      //   1918: iload 4
      //   1920: istore 7
      //   1922: aload 20
      //   1924: astore 21
      //   1926: aload 23
      //   1928: invokeinterface 1126 1 0
      //   1933: invokestatic 407	java/lang/Integer:parseInt	(Ljava/lang/String;)I
      //   1936: istore 9
      //   1938: aload 20
      //   1940: astore 25
      //   1942: iload 4
      //   1944: istore 5
      //   1946: aload 20
      //   1948: astore 26
      //   1950: iload 4
      //   1952: istore 6
      //   1954: aload 20
      //   1956: astore 24
      //   1958: iload 4
      //   1960: istore 7
      //   1962: aload 20
      //   1964: astore 21
      //   1966: aload_0
      //   1967: getfield 120	com/android/launcher2/LauncherProvider$DatabaseHelper:mContext	Landroid/content/Context;
      //   1970: iload 9
      //   1972: iconst_0
      //   1973: invokestatic 1130	com/android/launcher2/LauncherApplication:setScreenCount	(Landroid/content/Context;IZ)V
      //   1976: goto -1258 -> 718
      //   1979: astore_1
      //   1980: iload 5
      //   1982: istore 4
      //   1984: aload 25
      //   1986: astore 21
      //   1988: invokestatic 108	com/android/launcher2/LauncherProvider:access$000	()Z
      //   1991: ifeq +17 -> 2008
      //   1994: aload 25
      //   1996: astore 21
      //   1998: ldc 110
      //   2000: ldc_w 1078
      //   2003: aload_1
      //   2004: invokestatic 308	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   2007: pop
      //   2008: iload 4
      //   2010: istore 5
      //   2012: aload 25
      //   2014: ifnull -1179 -> 835
      //   2017: aload 25
      //   2019: invokevirtual 1032	java/io/FileReader:close	()V
      //   2022: iload 4
      //   2024: istore 5
      //   2026: goto -1191 -> 835
      //   2029: astore_1
      //   2030: iload 4
      //   2032: istore 5
      //   2034: goto -1199 -> 835
      //   2037: aload 20
      //   2039: astore 25
      //   2041: iload 4
      //   2043: istore 5
      //   2045: aload 20
      //   2047: astore 26
      //   2049: iload 4
      //   2051: istore 6
      //   2053: aload 20
      //   2055: astore 24
      //   2057: iload 4
      //   2059: istore 7
      //   2061: aload 20
      //   2063: astore 21
      //   2065: ldc 54
      //   2067: aload 22
      //   2069: invokevirtual 587	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2072: ifeq +177 -> 2249
      //   2075: aload 20
      //   2077: astore 25
      //   2079: iload 4
      //   2081: istore 5
      //   2083: aload 20
      //   2085: astore 26
      //   2087: iload 4
      //   2089: istore 6
      //   2091: aload 20
      //   2093: astore 24
      //   2095: iload 4
      //   2097: istore 7
      //   2099: aload 20
      //   2101: astore 21
      //   2103: aload 23
      //   2105: invokeinterface 936 1 0
      //   2110: iconst_4
      //   2111: if_icmpne -1393 -> 718
      //   2114: aload 20
      //   2116: astore 25
      //   2118: iload 4
      //   2120: istore 5
      //   2122: aload 20
      //   2124: astore 26
      //   2126: iload 4
      //   2128: istore 6
      //   2130: aload 20
      //   2132: astore 24
      //   2134: iload 4
      //   2136: istore 7
      //   2138: aload 20
      //   2140: astore 21
      //   2142: aload 23
      //   2144: invokeinterface 1126 1 0
      //   2149: invokestatic 407	java/lang/Integer:parseInt	(Ljava/lang/String;)I
      //   2152: istore 9
      //   2154: aload 20
      //   2156: astore 25
      //   2158: iload 4
      //   2160: istore 5
      //   2162: aload 20
      //   2164: astore 26
      //   2166: iload 4
      //   2168: istore 6
      //   2170: aload 20
      //   2172: astore 24
      //   2174: iload 4
      //   2176: istore 7
      //   2178: aload 20
      //   2180: astore 21
      //   2182: aload_0
      //   2183: getfield 120	com/android/launcher2/LauncherProvider$DatabaseHelper:mContext	Landroid/content/Context;
      //   2186: iload 9
      //   2188: iconst_0
      //   2189: invokestatic 1133	com/android/launcher2/LauncherApplication:setHomeScreenIndex	(Landroid/content/Context;IZ)V
      //   2192: goto -1474 -> 718
      //   2195: astore_1
      //   2196: aload 26
      //   2198: astore 21
      //   2200: invokestatic 108	com/android/launcher2/LauncherProvider:access$000	()Z
      //   2203: ifeq +17 -> 2220
      //   2206: aload 26
      //   2208: astore 21
      //   2210: ldc 110
      //   2212: ldc_w 1078
      //   2215: aload_1
      //   2216: invokestatic 308	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   2219: pop
      //   2220: iload 6
      //   2222: istore 5
      //   2224: aload 26
      //   2226: ifnull -1391 -> 835
      //   2229: aload 26
      //   2231: invokevirtual 1032	java/io/FileReader:close	()V
      //   2234: iload 6
      //   2236: istore 5
      //   2238: goto -1403 -> 835
      //   2241: astore_1
      //   2242: iload 6
      //   2244: istore 5
      //   2246: goto -1411 -> 835
      //   2249: aload 20
      //   2251: astore 25
      //   2253: iload 4
      //   2255: istore 5
      //   2257: aload 20
      //   2259: astore 26
      //   2261: iload 4
      //   2263: istore 6
      //   2265: aload 20
      //   2267: astore 24
      //   2269: iload 4
      //   2271: istore 7
      //   2273: aload 20
      //   2275: astore 21
      //   2277: invokestatic 108	com/android/launcher2/LauncherProvider:access$000	()Z
      //   2280: ifeq -1562 -> 718
      //   2283: aload 20
      //   2285: astore 25
      //   2287: iload 4
      //   2289: istore 5
      //   2291: aload 20
      //   2293: astore 26
      //   2295: iload 4
      //   2297: istore 6
      //   2299: aload 20
      //   2301: astore 24
      //   2303: iload 4
      //   2305: istore 7
      //   2307: aload 20
      //   2309: astore 21
      //   2311: ldc 110
      //   2313: new 251	java/lang/StringBuilder
      //   2316: dup
      //   2317: invokespecial 252	java/lang/StringBuilder:<init>	()V
      //   2320: ldc_w 1001
      //   2323: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2326: aload 22
      //   2328: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2331: ldc_w 1003
      //   2334: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2337: aload 23
      //   2339: invokeinterface 1006 1 0
      //   2344: invokevirtual 700	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   2347: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2350: invokestatic 304	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   2353: pop
      //   2354: goto -1636 -> 718
      //   2357: astore_1
      //   2358: aload 24
      //   2360: astore 21
      //   2362: invokestatic 108	com/android/launcher2/LauncherProvider:access$000	()Z
      //   2365: ifeq +17 -> 2382
      //   2368: aload 24
      //   2370: astore 21
      //   2372: ldc 110
      //   2374: ldc_w 1078
      //   2377: aload_1
      //   2378: invokestatic 308	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   2381: pop
      //   2382: iload 7
      //   2384: istore 5
      //   2386: aload 24
      //   2388: ifnull -1553 -> 835
      //   2391: aload 24
      //   2393: invokevirtual 1032	java/io/FileReader:close	()V
      //   2396: iload 7
      //   2398: istore 5
      //   2400: goto -1565 -> 835
      //   2403: astore_1
      //   2404: iload 7
      //   2406: istore 5
      //   2408: goto -1573 -> 835
      //   2411: astore_1
      //   2412: aload 21
      //   2414: ifnull +8 -> 2422
      //   2417: aload 21
      //   2419: invokevirtual 1032	java/io/FileReader:close	()V
      //   2422: aload_1
      //   2423: athrow
      //   2424: astore_1
      //   2425: goto -1308 -> 1117
      //   2428: astore_1
      //   2429: iload 4
      //   2431: istore 5
      //   2433: goto -1598 -> 835
      //   2436: astore_2
      //   2437: goto -15 -> 2422
      //   2440: astore_1
      //   2441: goto -29 -> 2412
      //   2444: astore_1
      //   2445: aload 23
      //   2447: astore 24
      //   2449: iload 12
      //   2451: istore 7
      //   2453: goto -95 -> 2358
      //   2456: astore_1
      //   2457: aload 22
      //   2459: astore 26
      //   2461: iload 13
      //   2463: istore 6
      //   2465: goto -269 -> 2196
      //   2468: astore_1
      //   2469: aload 24
      //   2471: astore 25
      //   2473: iload 9
      //   2475: istore 4
      //   2477: goto -493 -> 1984
      //   2480: aload 25
      //   2482: astore 23
      //   2484: aload 27
      //   2486: astore 22
      //   2488: goto -1851 -> 637
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2491	0	this	DatabaseHelper
      //   0	2491	1	paramSQLiteDatabase	SQLiteDatabase
      //   0	2491	2	paramString	String
      //   0	2491	3	paramBoolean	boolean
      //   19	2457	4	i	int
      //   87	2345	5	j	int
      //   95	2369	6	k	int
      //   103	2349	7	m	int
      //   7	1557	8	n	int
      //   4	2470	9	i1	int
      //   1	1599	10	i2	int
      //   13	1559	11	i3	int
      //   16	2434	12	i4	int
      //   10	2452	13	i5	int
      //   79	1732	14	bool1	boolean
      //   298	602	15	bool2	boolean
      //   265	585	16	bool3	boolean
      //   341	1161	17	bool4	boolean
      //   1096	3	18	l	long
      //   229	2079	20	localObject1	Object
      //   107	2311	21	localObject2	Object
      //   189	2298	22	localObject3	Object
      //   149	2334	23	localObject4	Object
      //   99	2371	24	localObject5	Object
      //   83	2398	25	localObject6	Object
      //   91	2369	26	localObject7	Object
      //   152	2333	27	localObject8	Object
      //   76	1514	28	localObject9	Object
      //   64	1488	29	localObject10	Object
      //   70	1498	30	localObject11	Object
      //   73	1503	31	localObject12	Object
      //   67	1493	32	localObject13	Object
      //   112	1237	33	localObject14	Object
      // Exception table:
      //   from	to	target	type
      //   109	114	1979	org/xmlpull/v1/XmlPullParserException
      //   142	148	1979	org/xmlpull/v1/XmlPullParserException
      //   182	191	1979	org/xmlpull/v1/XmlPullParserException
      //   219	231	1979	org/xmlpull/v1/XmlPullParserException
      //   259	267	1979	org/xmlpull/v1/XmlPullParserException
      //   295	300	1979	org/xmlpull/v1/XmlPullParserException
      //   328	343	1979	org/xmlpull/v1/XmlPullParserException
      //   371	377	1979	org/xmlpull/v1/XmlPullParserException
      //   405	411	1979	org/xmlpull/v1/XmlPullParserException
      //   439	447	1979	org/xmlpull/v1/XmlPullParserException
      //   494	500	1979	org/xmlpull/v1/XmlPullParserException
      //   528	545	1979	org/xmlpull/v1/XmlPullParserException
      //   573	585	1979	org/xmlpull/v1/XmlPullParserException
      //   613	621	1979	org/xmlpull/v1/XmlPullParserException
      //   670	677	1979	org/xmlpull/v1/XmlPullParserException
      //   709	718	1979	org/xmlpull/v1/XmlPullParserException
      //   746	755	1979	org/xmlpull/v1/XmlPullParserException
      //   789	798	1979	org/xmlpull/v1/XmlPullParserException
      //   882	892	1979	org/xmlpull/v1/XmlPullParserException
      //   932	942	1979	org/xmlpull/v1/XmlPullParserException
      //   981	986	1979	org/xmlpull/v1/XmlPullParserException
      //   1014	1027	1979	org/xmlpull/v1/XmlPullParserException
      //   1055	1063	1979	org/xmlpull/v1/XmlPullParserException
      //   1091	1098	1979	org/xmlpull/v1/XmlPullParserException
      //   1147	1160	1979	org/xmlpull/v1/XmlPullParserException
      //   1247	1255	1979	org/xmlpull/v1/XmlPullParserException
      //   1283	1293	1979	org/xmlpull/v1/XmlPullParserException
      //   1321	1332	1979	org/xmlpull/v1/XmlPullParserException
      //   1534	1544	1979	org/xmlpull/v1/XmlPullParserException
      //   1579	1589	1979	org/xmlpull/v1/XmlPullParserException
      //   1630	1639	1979	org/xmlpull/v1/XmlPullParserException
      //   1667	1677	1979	org/xmlpull/v1/XmlPullParserException
      //   1709	1729	1979	org/xmlpull/v1/XmlPullParserException
      //   1760	1770	1979	org/xmlpull/v1/XmlPullParserException
      //   1798	1818	1979	org/xmlpull/v1/XmlPullParserException
      //   1849	1859	1979	org/xmlpull/v1/XmlPullParserException
      //   1887	1898	1979	org/xmlpull/v1/XmlPullParserException
      //   1926	1938	1979	org/xmlpull/v1/XmlPullParserException
      //   1966	1976	1979	org/xmlpull/v1/XmlPullParserException
      //   2065	2075	1979	org/xmlpull/v1/XmlPullParserException
      //   2103	2114	1979	org/xmlpull/v1/XmlPullParserException
      //   2142	2154	1979	org/xmlpull/v1/XmlPullParserException
      //   2182	2192	1979	org/xmlpull/v1/XmlPullParserException
      //   2277	2283	1979	org/xmlpull/v1/XmlPullParserException
      //   2311	2354	1979	org/xmlpull/v1/XmlPullParserException
      //   2017	2022	2029	java/lang/Exception
      //   109	114	2195	java/io/IOException
      //   142	148	2195	java/io/IOException
      //   182	191	2195	java/io/IOException
      //   219	231	2195	java/io/IOException
      //   259	267	2195	java/io/IOException
      //   295	300	2195	java/io/IOException
      //   328	343	2195	java/io/IOException
      //   371	377	2195	java/io/IOException
      //   405	411	2195	java/io/IOException
      //   439	447	2195	java/io/IOException
      //   494	500	2195	java/io/IOException
      //   528	545	2195	java/io/IOException
      //   573	585	2195	java/io/IOException
      //   613	621	2195	java/io/IOException
      //   670	677	2195	java/io/IOException
      //   709	718	2195	java/io/IOException
      //   746	755	2195	java/io/IOException
      //   789	798	2195	java/io/IOException
      //   882	892	2195	java/io/IOException
      //   932	942	2195	java/io/IOException
      //   981	986	2195	java/io/IOException
      //   1014	1027	2195	java/io/IOException
      //   1055	1063	2195	java/io/IOException
      //   1091	1098	2195	java/io/IOException
      //   1147	1160	2195	java/io/IOException
      //   1247	1255	2195	java/io/IOException
      //   1283	1293	2195	java/io/IOException
      //   1321	1332	2195	java/io/IOException
      //   1534	1544	2195	java/io/IOException
      //   1579	1589	2195	java/io/IOException
      //   1630	1639	2195	java/io/IOException
      //   1667	1677	2195	java/io/IOException
      //   1709	1729	2195	java/io/IOException
      //   1760	1770	2195	java/io/IOException
      //   1798	1818	2195	java/io/IOException
      //   1849	1859	2195	java/io/IOException
      //   1887	1898	2195	java/io/IOException
      //   1926	1938	2195	java/io/IOException
      //   1966	1976	2195	java/io/IOException
      //   2065	2075	2195	java/io/IOException
      //   2103	2114	2195	java/io/IOException
      //   2142	2154	2195	java/io/IOException
      //   2182	2192	2195	java/io/IOException
      //   2277	2283	2195	java/io/IOException
      //   2311	2354	2195	java/io/IOException
      //   2229	2234	2241	java/lang/Exception
      //   109	114	2357	android/content/res/Resources$NotFoundException
      //   142	148	2357	android/content/res/Resources$NotFoundException
      //   182	191	2357	android/content/res/Resources$NotFoundException
      //   219	231	2357	android/content/res/Resources$NotFoundException
      //   259	267	2357	android/content/res/Resources$NotFoundException
      //   295	300	2357	android/content/res/Resources$NotFoundException
      //   328	343	2357	android/content/res/Resources$NotFoundException
      //   371	377	2357	android/content/res/Resources$NotFoundException
      //   405	411	2357	android/content/res/Resources$NotFoundException
      //   439	447	2357	android/content/res/Resources$NotFoundException
      //   494	500	2357	android/content/res/Resources$NotFoundException
      //   528	545	2357	android/content/res/Resources$NotFoundException
      //   573	585	2357	android/content/res/Resources$NotFoundException
      //   613	621	2357	android/content/res/Resources$NotFoundException
      //   670	677	2357	android/content/res/Resources$NotFoundException
      //   709	718	2357	android/content/res/Resources$NotFoundException
      //   746	755	2357	android/content/res/Resources$NotFoundException
      //   789	798	2357	android/content/res/Resources$NotFoundException
      //   882	892	2357	android/content/res/Resources$NotFoundException
      //   932	942	2357	android/content/res/Resources$NotFoundException
      //   981	986	2357	android/content/res/Resources$NotFoundException
      //   1014	1027	2357	android/content/res/Resources$NotFoundException
      //   1055	1063	2357	android/content/res/Resources$NotFoundException
      //   1091	1098	2357	android/content/res/Resources$NotFoundException
      //   1147	1160	2357	android/content/res/Resources$NotFoundException
      //   1247	1255	2357	android/content/res/Resources$NotFoundException
      //   1283	1293	2357	android/content/res/Resources$NotFoundException
      //   1321	1332	2357	android/content/res/Resources$NotFoundException
      //   1534	1544	2357	android/content/res/Resources$NotFoundException
      //   1579	1589	2357	android/content/res/Resources$NotFoundException
      //   1630	1639	2357	android/content/res/Resources$NotFoundException
      //   1667	1677	2357	android/content/res/Resources$NotFoundException
      //   1709	1729	2357	android/content/res/Resources$NotFoundException
      //   1760	1770	2357	android/content/res/Resources$NotFoundException
      //   1798	1818	2357	android/content/res/Resources$NotFoundException
      //   1849	1859	2357	android/content/res/Resources$NotFoundException
      //   1887	1898	2357	android/content/res/Resources$NotFoundException
      //   1926	1938	2357	android/content/res/Resources$NotFoundException
      //   1966	1976	2357	android/content/res/Resources$NotFoundException
      //   2065	2075	2357	android/content/res/Resources$NotFoundException
      //   2103	2114	2357	android/content/res/Resources$NotFoundException
      //   2142	2154	2357	android/content/res/Resources$NotFoundException
      //   2182	2192	2357	android/content/res/Resources$NotFoundException
      //   2277	2283	2357	android/content/res/Resources$NotFoundException
      //   2311	2354	2357	android/content/res/Resources$NotFoundException
      //   2391	2396	2403	java/lang/Exception
      //   109	114	2411	finally
      //   142	148	2411	finally
      //   182	191	2411	finally
      //   219	231	2411	finally
      //   259	267	2411	finally
      //   295	300	2411	finally
      //   328	343	2411	finally
      //   371	377	2411	finally
      //   405	411	2411	finally
      //   439	447	2411	finally
      //   494	500	2411	finally
      //   528	545	2411	finally
      //   573	585	2411	finally
      //   613	621	2411	finally
      //   670	677	2411	finally
      //   709	718	2411	finally
      //   746	755	2411	finally
      //   789	798	2411	finally
      //   882	892	2411	finally
      //   932	942	2411	finally
      //   981	986	2411	finally
      //   1014	1027	2411	finally
      //   1055	1063	2411	finally
      //   1091	1098	2411	finally
      //   1147	1160	2411	finally
      //   1247	1255	2411	finally
      //   1283	1293	2411	finally
      //   1321	1332	2411	finally
      //   1534	1544	2411	finally
      //   1579	1589	2411	finally
      //   1630	1639	2411	finally
      //   1667	1677	2411	finally
      //   1709	1729	2411	finally
      //   1760	1770	2411	finally
      //   1798	1818	2411	finally
      //   1849	1859	2411	finally
      //   1887	1898	2411	finally
      //   1926	1938	2411	finally
      //   1966	1976	2411	finally
      //   1988	1994	2411	finally
      //   1998	2008	2411	finally
      //   2065	2075	2411	finally
      //   2103	2114	2411	finally
      //   2142	2154	2411	finally
      //   2182	2192	2411	finally
      //   2200	2206	2411	finally
      //   2210	2220	2411	finally
      //   2277	2283	2411	finally
      //   2311	2354	2411	finally
      //   2362	2368	2411	finally
      //   2372	2382	2411	finally
      //   1109	1117	2424	java/lang/Exception
      //   826	831	2428	java/lang/Exception
      //   2417	2422	2436	java/lang/Exception
      //   1176	1183	2440	finally
      //   1199	1208	2440	finally
      //   1348	1355	2440	finally
      //   1371	1380	2440	finally
      //   1399	1405	2440	finally
      //   1421	1438	2440	finally
      //   1454	1466	2440	finally
      //   1482	1490	2440	finally
      //   1176	1183	2444	android/content/res/Resources$NotFoundException
      //   1199	1208	2444	android/content/res/Resources$NotFoundException
      //   1348	1355	2444	android/content/res/Resources$NotFoundException
      //   1371	1380	2444	android/content/res/Resources$NotFoundException
      //   1399	1405	2444	android/content/res/Resources$NotFoundException
      //   1421	1438	2444	android/content/res/Resources$NotFoundException
      //   1454	1466	2444	android/content/res/Resources$NotFoundException
      //   1482	1490	2444	android/content/res/Resources$NotFoundException
      //   1176	1183	2456	java/io/IOException
      //   1199	1208	2456	java/io/IOException
      //   1348	1355	2456	java/io/IOException
      //   1371	1380	2456	java/io/IOException
      //   1399	1405	2456	java/io/IOException
      //   1421	1438	2456	java/io/IOException
      //   1454	1466	2456	java/io/IOException
      //   1482	1490	2456	java/io/IOException
      //   1176	1183	2468	org/xmlpull/v1/XmlPullParserException
      //   1199	1208	2468	org/xmlpull/v1/XmlPullParserException
      //   1348	1355	2468	org/xmlpull/v1/XmlPullParserException
      //   1371	1380	2468	org/xmlpull/v1/XmlPullParserException
      //   1399	1405	2468	org/xmlpull/v1/XmlPullParserException
      //   1421	1438	2468	org/xmlpull/v1/XmlPullParserException
      //   1454	1466	2468	org/xmlpull/v1/XmlPullParserException
      //   1482	1490	2468	org/xmlpull/v1/XmlPullParserException
    }
    
    private int loadFavoritesContainer(SQLiteDatabase paramSQLiteDatabase, String paramString, XmlPullParser paramXmlPullParser, long paramLong, int paramInt, boolean paramBoolean)
      throws XmlPullParserException, IOException
    {
      if (LauncherProvider.DEBUGGABLE) {
        Log.d("LauncherProvider", "loadFavoritesContainer. containerType: " + paramLong + ", allowedTags: " + paramInt);
      }
      Intent localIntent = new Intent("android.intent.action.MAIN", null);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      ContentValues localContentValues = new ContentValues();
      PackageManager localPackageManager = this.mContext.getPackageManager();
      AttributeSet localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
      int m = paramXmlPullParser.getDepth();
      int j = 0;
      Object localObject4 = null;
      Object localObject5 = null;
      Object localObject3 = null;
      Object localObject2 = null;
      int i;
      do
      {
        i = paramXmlPullParser.next();
        if (((i == 3) && (paramXmlPullParser.getDepth() <= m)) || (i == 1))
        {
          if (localObject2 != null)
          {
            paramSQLiteDatabase = LauncherProvider.mApp.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
            paramSQLiteDatabase.putString("HomeFolderIds", (String)localObject2);
            paramSQLiteDatabase.commit();
          }
          return j;
        }
      } while (i != 2);
      Object localObject11 = paramXmlPullParser.getName();
      if (LauncherProvider.DEBUGGABLE) {
        Log.d("LauncherProvider", "loadFavoritesContainer. Process tag: " + (String)localObject11);
      }
      TypedArray localTypedArray;
      Object localObject8;
      Object localObject9;
      Object localObject6;
      Object localObject7;
      Object localObject10;
      Object localObject1;
      if (paramBoolean)
      {
        localTypedArray = null;
        localObject8 = paramXmlPullParser.getAttributeValue(null, "packageName");
        localObject9 = paramXmlPullParser.getAttributeValue(null, "className");
        localObject6 = paramXmlPullParser.getAttributeValue(null, "screen");
        localObject7 = paramXmlPullParser.getAttributeValue(null, "x");
        localObject10 = paramXmlPullParser.getAttributeValue(null, "y");
        paramXmlPullParser.getAttributeValue(null, "secret");
        localObject1 = paramXmlPullParser.getAttributeValue(null, "festival");
        this.mWidgetTitle = paramXmlPullParser.getAttributeValue(null, "title");
        label338:
        localContentValues.clear();
        localContentValues.put("container", Long.valueOf(paramLong));
        localContentValues.put("screen", (String)localObject6);
        localContentValues.put("cellX", (String)localObject7);
        localContentValues.put("cellY", (String)localObject10);
        if (LauncherApplication.sFestivalPageLauncher)
        {
          if (localObject1 != null) {
            break label633;
          }
          localObject1 = "0";
          label402:
          localContentValues.put("festival", (String)localObject1);
        }
        if (((paramInt & 0x1) == 0) || (!"favorite".equals(localObject11))) {
          break label636;
        }
        localObject5 = paramXmlPullParser.getAttributeValue(null, "title");
        localObject6 = localObject5;
        localObject7 = localObject4;
        localObject10 = localObject3;
        localObject1 = localObject2;
        i = j;
        if (addHomeShortcut(paramSQLiteDatabase, paramString, localContentValues, localPackageManager, localIntent, (String)localObject8, (String)localObject9, (String)localObject5) >= 0L)
        {
          i = j + 1;
          localObject1 = localObject2;
          localObject10 = localObject3;
          localObject7 = localObject4;
          localObject6 = localObject5;
        }
      }
      for (;;)
      {
        localObject5 = localObject6;
        localObject4 = localObject7;
        localObject3 = localObject10;
        localObject2 = localObject1;
        j = i;
        if (paramBoolean == true) {
          break;
        }
        localTypedArray.recycle();
        localObject5 = localObject6;
        localObject4 = localObject7;
        localObject3 = localObject10;
        localObject2 = localObject1;
        j = i;
        break;
        localTypedArray = this.mContext.obtainStyledAttributes(localAttributeSet, R.styleable.Favorite);
        localObject8 = localTypedArray.getString(1);
        localObject9 = localTypedArray.getString(0);
        localObject6 = localTypedArray.getString(2);
        localObject7 = localTypedArray.getString(3);
        localObject10 = localTypedArray.getString(4);
        localTypedArray.getString(12);
        localObject1 = localTypedArray.getString(13);
        break label338;
        label633:
        break label402;
        label636:
        if (((paramInt & 0x2) != 0) && ("shortcut".equals(localObject11)))
        {
          if (paramBoolean)
          {
            localObject4 = paramXmlPullParser.getAttributeValue(null, "uri");
            localObject5 = paramXmlPullParser.getAttributeValue(null, "title");
            localObject3 = paramXmlPullParser.getAttributeValue(null, "icon");
          }
          localObject6 = localObject5;
          localObject7 = localObject4;
          localObject10 = localObject3;
          localObject1 = localObject2;
          i = j;
          if (addUriShortcut(paramSQLiteDatabase, paramString, localContentValues, localTypedArray, (String)localObject4, (String)localObject5, (String)localObject3) >= 0L)
          {
            i = j + 1;
            localObject6 = localObject5;
            localObject7 = localObject4;
            localObject10 = localObject3;
            localObject1 = localObject2;
          }
        }
        else
        {
          if (((paramInt & 0x8) != 0) && ("search".equals(localObject11)))
          {
            localObject7 = "4";
            localObject1 = "1";
            if (paramBoolean)
            {
              localObject6 = paramXmlPullParser.getAttributeValue(null, "spanX");
              localObject1 = paramXmlPullParser.getAttributeValue(null, "spanY");
            }
            for (;;)
            {
              if (localObject6 != null)
              {
                localObject8 = localObject6;
                if (!((String)localObject6).equalsIgnoreCase("null")) {}
              }
              else
              {
                localObject8 = "4";
              }
              if (localObject1 != null)
              {
                localObject9 = localObject1;
                if (!((String)localObject1).equalsIgnoreCase("null")) {}
              }
              else
              {
                localObject9 = "1";
              }
              localObject6 = localObject5;
              localObject7 = localObject4;
              localObject10 = localObject3;
              localObject1 = localObject2;
              i = j;
              if (!addSearchWidget(paramSQLiteDatabase, paramString, localContentValues, Integer.parseInt((String)localObject8), Integer.parseInt((String)localObject9))) {
                break;
              }
              i = j + 1;
              localObject6 = localObject5;
              localObject7 = localObject4;
              localObject10 = localObject3;
              localObject1 = localObject2;
              break;
              if (localTypedArray.getString(5) != null) {
                localObject7 = localTypedArray.getString(5);
              }
              localObject6 = localObject7;
              if (localTypedArray.getString(6) != null)
              {
                localObject1 = localTypedArray.getString(6);
                localObject6 = localObject7;
              }
            }
          }
          if (((paramInt & 0x8) != 0) && ("clock".equals(localObject11)))
          {
            localObject6 = localObject5;
            localObject7 = localObject4;
            localObject10 = localObject3;
            localObject1 = localObject2;
            i = j;
            if (addClockWidget(paramSQLiteDatabase, paramString, localContentValues))
            {
              i = j + 1;
              localObject6 = localObject5;
              localObject7 = localObject4;
              localObject10 = localObject3;
              localObject1 = localObject2;
            }
          }
          else
          {
            Object localObject12;
            if (((paramInt & 0x8) != 0) && ("appwidget".equals(localObject11)))
            {
              if (paramBoolean) {
                localObject6 = paramXmlPullParser.getAttributeValue(null, "spanX");
              }
              for (localObject1 = paramXmlPullParser.getAttributeValue(null, "spanY");; localObject1 = localTypedArray.getString(6))
              {
                if (localObject6 != null)
                {
                  localObject11 = localObject6;
                  if (!((String)localObject6).equalsIgnoreCase("null")) {}
                }
                else
                {
                  localObject11 = "1";
                }
                if (localObject1 != null)
                {
                  localObject12 = localObject1;
                  if (!((String)localObject1).equalsIgnoreCase("null")) {}
                }
                else
                {
                  localObject12 = "1";
                }
                localObject6 = localObject5;
                localObject7 = localObject4;
                localObject10 = localObject3;
                localObject1 = localObject2;
                i = j;
                if (!addAppWidget(paramSQLiteDatabase, paramString, localContentValues, localPackageManager, (String)localObject8, (String)localObject9, Integer.parseInt((String)localObject11), Integer.parseInt((String)localObject12))) {
                  break;
                }
                i = j + 1;
                localObject6 = localObject5;
                localObject7 = localObject4;
                localObject10 = localObject3;
                localObject1 = localObject2;
                break;
                localObject6 = localTypedArray.getString(5);
              }
            }
            label1294:
            int k;
            if (((paramInt & 0x4) != 0) && ("folder".equals(localObject11)))
            {
              localObject1 = null;
              boolean bool;
              long l;
              if (paramBoolean == true)
              {
                localObject1 = paramXmlPullParser.getAttributeValue(null, "title");
                bool = Boolean.parseBoolean(paramXmlPullParser.getAttributeValue(null, "hideAddButton"));
                localContentValues.put("title", (String)localObject1);
                l = addFolder(paramSQLiteDatabase, paramString, localContentValues);
                localObject6 = localObject5;
                localObject7 = localObject4;
                localObject10 = localObject3;
                localObject1 = localObject2;
                i = j;
                if (l >= 0L) {
                  j += 1;
                }
              }
              else
              {
                for (;;)
                {
                  try
                  {
                    k = loadFavoritesContainer(paramSQLiteDatabase, paramString, paramXmlPullParser, l, paramInt & 0xFFFFFFF3, paramBoolean);
                    if (k != 0) {
                      break label1572;
                    }
                    bool = delFolder(paramSQLiteDatabase, l);
                    if (bool)
                    {
                      i = j - 1;
                      localObject1 = localObject2;
                      i += k;
                      localObject6 = localObject5;
                      localObject7 = localObject4;
                      localObject10 = localObject3;
                      break;
                      i = localTypedArray.getResourceId(8, -1);
                      if (i != -1) {
                        localObject1 = this.mContext.getResources().getString(i);
                      }
                      bool = localTypedArray.getBoolean(14, false);
                      break label1294;
                    }
                    localObject1 = localObject2;
                    i = j;
                    if (!LauncherProvider.DEBUGGABLE) {
                      continue;
                    }
                    Log.w("LauncherProvider", "Failed to delete empty folder. _id: " + l);
                    localObject1 = localObject2;
                    i = j;
                    continue;
                    if (!LauncherProvider.DEBUGGABLE) {
                      break;
                    }
                  }
                  catch (IOException localIOException)
                  {
                    localObject6 = localObject5;
                    localObject7 = localObject4;
                    localObject10 = localObject3;
                    localObject1 = localObject2;
                    i = j;
                  }
                  Log.w("LauncherProvider", "Failed to load favorites", localIOException);
                  localObject6 = localObject5;
                  localObject7 = localObject4;
                  localObject10 = localObject3;
                  localObject1 = localObject2;
                  i = j;
                  break;
                  label1572:
                  localObject1 = localObject2;
                  i = j;
                  if (bool) {
                    if (localObject2 != null)
                    {
                      localObject1 = (String)localObject2 + Long.toString(l) + ":";
                      i = j;
                    }
                    else
                    {
                      localObject1 = Long.toString(l) + ":";
                      i = j;
                    }
                  }
                }
              }
            }
            else
            {
              if (((paramInt & 0x8) != 0) && ("sactivitywidget".equals(localObject11)))
              {
                if (paramBoolean)
                {
                  localObject7 = paramXmlPullParser.getAttributeValue(null, "themeName");
                  localObject11 = paramXmlPullParser.getAttributeValue(null, "instance");
                  localObject6 = paramXmlPullParser.getAttributeValue(null, "spanX");
                }
                for (localObject1 = paramXmlPullParser.getAttributeValue(null, "spanY");; localObject1 = localTypedArray.getString(6))
                {
                  localObject12 = localObject7;
                  if (localObject7 != null) {
                    if (!((String)localObject7).isEmpty())
                    {
                      localObject12 = localObject7;
                      if (!((String)localObject7).equalsIgnoreCase("null")) {}
                    }
                    else
                    {
                      localObject12 = null;
                    }
                  }
                  Object localObject13;
                  if (localObject6 != null)
                  {
                    localObject13 = localObject6;
                    if (!((String)localObject6).equalsIgnoreCase("null")) {}
                  }
                  else
                  {
                    localObject13 = "1";
                  }
                  Object localObject14;
                  if (localObject1 != null)
                  {
                    localObject14 = localObject1;
                    if (!((String)localObject1).equalsIgnoreCase("null")) {}
                  }
                  else
                  {
                    localObject14 = "1";
                  }
                  k = j;
                  if (addSamsungActivityWidget(paramSQLiteDatabase, paramString, localContentValues, localPackageManager, localIOException, (String)localObject9, (String)localObject12, Integer.parseInt((String)localObject13), Integer.parseInt((String)localObject14))) {
                    k = j + 1;
                  }
                  localObject6 = localObject5;
                  localObject7 = localObject4;
                  localObject10 = localObject3;
                  localObject1 = localObject2;
                  i = k;
                  if (!addSurfaceWidget(paramSQLiteDatabase, paramString, localContentValues, localPackageManager, localIOException, (String)localObject9, (String)localObject12, (String)localObject11, Integer.parseInt((String)localObject13), Integer.parseInt((String)localObject14))) {
                    break;
                  }
                  i = k + 1;
                  localObject6 = localObject5;
                  localObject7 = localObject4;
                  localObject10 = localObject3;
                  localObject1 = localObject2;
                  break;
                  localObject7 = localTypedArray.getString(10);
                  localObject11 = localTypedArray.getString(11);
                  localObject6 = localTypedArray.getString(5);
                }
              }
              localObject6 = localObject5;
              localObject7 = localObject4;
              localObject10 = localObject3;
              localObject1 = localObject2;
              i = j;
              if (LauncherProvider.DEBUGGABLE)
              {
                Log.e("LauncherProvider", "Invalid tag <" + (String)localObject11 + "> detected while parsing favorites at line " + paramXmlPullParser.getLineNumber());
                localObject6 = localObject5;
                localObject7 = localObject4;
                localObject10 = localObject3;
                localObject1 = localObject2;
                i = j;
              }
            }
          }
        }
      }
    }
    
    private void normalizeIcons(SQLiteDatabase paramSQLiteDatabase)
    {
      Log.d("LauncherProvider", "normalizing icons");
      paramSQLiteDatabase.beginTransaction();
      Object localObject5 = null;
      Cursor localCursor2 = null;
      Object localObject4 = null;
      Object localObject3 = null;
      int i = 0;
      Cursor localCursor1 = localCursor2;
      Object localObject2 = localObject5;
      for (;;)
      {
        try
        {
          SQLiteStatement localSQLiteStatement = paramSQLiteDatabase.compileStatement("UPDATE favorites SET icon=? WHERE _id=?");
          localCursor1 = localCursor2;
          localObject3 = localSQLiteStatement;
          localObject2 = localObject5;
          localObject4 = localSQLiteStatement;
          localCursor2 = paramSQLiteDatabase.rawQuery("SELECT _id, icon FROM favorites WHERE iconType=1", null);
          if ((localCursor2 != null) && (localSQLiteStatement != null))
          {
            localCursor1 = localCursor2;
            localObject3 = localSQLiteStatement;
            localObject2 = localCursor2;
            localObject4 = localSQLiteStatement;
            int j = localCursor2.getColumnIndexOrThrow("_id");
            localCursor1 = localCursor2;
            localObject3 = localSQLiteStatement;
            localObject2 = localCursor2;
            localObject4 = localSQLiteStatement;
            int k = localCursor2.getColumnIndexOrThrow("icon");
            localCursor1 = localCursor2;
            localObject3 = localSQLiteStatement;
            localObject2 = localCursor2;
            localObject4 = localSQLiteStatement;
            if (localCursor2.moveToNext())
            {
              localCursor1 = localCursor2;
              localObject3 = localSQLiteStatement;
              localObject2 = localCursor2;
              localObject4 = localSQLiteStatement;
              long l = localCursor2.getLong(j);
              localCursor1 = localCursor2;
              localObject3 = localSQLiteStatement;
              localObject2 = localCursor2;
              localObject4 = localSQLiteStatement;
              localObject5 = localCursor2.getBlob(k);
              localCursor1 = localCursor2;
              localObject3 = localSQLiteStatement;
              localObject2 = localCursor2;
              localObject4 = localSQLiteStatement;
              try
              {
                localObject5 = Utilities.resampleIconBitmap(BitmapFactory.decodeByteArray((byte[])localObject5, 0, localObject5.length), this.mContext);
                if (localObject5 == null) {
                  continue;
                }
                localCursor1 = localCursor2;
                localObject3 = localSQLiteStatement;
                localObject2 = localCursor2;
                localObject4 = localSQLiteStatement;
                localSQLiteStatement.bindLong(1, l);
                localCursor1 = localCursor2;
                localObject3 = localSQLiteStatement;
                localObject2 = localCursor2;
                localObject4 = localSQLiteStatement;
                byte[] arrayOfByte = HomeItem.flattenBitmap((Bitmap)localObject5);
                if (arrayOfByte != null)
                {
                  localCursor1 = localCursor2;
                  localObject3 = localSQLiteStatement;
                  localObject2 = localCursor2;
                  localObject4 = localSQLiteStatement;
                  localSQLiteStatement.bindBlob(2, arrayOfByte);
                  localCursor1 = localCursor2;
                  localObject3 = localSQLiteStatement;
                  localObject2 = localCursor2;
                  localObject4 = localSQLiteStatement;
                  localSQLiteStatement.execute();
                }
                localCursor1 = localCursor2;
                localObject3 = localSQLiteStatement;
                localObject2 = localCursor2;
                localObject4 = localSQLiteStatement;
                ((Bitmap)localObject5).recycle();
              }
              catch (Exception localException)
              {
                if (i == 0)
                {
                  localCursor1 = localCursor2;
                  localObject3 = localSQLiteStatement;
                  localObject2 = localCursor2;
                  localObject4 = localSQLiteStatement;
                  if (!LauncherProvider.DEBUGGABLE) {
                    break label685;
                  }
                  localCursor1 = localCursor2;
                  localObject3 = localSQLiteStatement;
                  localObject2 = localCursor2;
                  localObject4 = localSQLiteStatement;
                  Log.e("LauncherProvider", "Failed normalizing icon " + l, localException);
                  break label685;
                }
                localCursor1 = localCursor2;
                localObject3 = localSQLiteStatement;
                localObject2 = localCursor2;
                localObject4 = localSQLiteStatement;
                if (!LauncherProvider.DEBUGGABLE) {
                  break label685;
                }
              }
              localCursor1 = localCursor2;
              localObject3 = localSQLiteStatement;
              localObject2 = localCursor2;
              localObject4 = localSQLiteStatement;
              Log.e("LauncherProvider", "Also failed normalizing icon " + l);
            }
          }
        }
        catch (SQLException localSQLException)
        {
          localObject2 = localCursor1;
          localObject4 = localObject3;
          if (LauncherProvider.DEBUGGABLE)
          {
            localObject2 = localCursor1;
            localObject4 = localObject3;
            Log.w("LauncherProvider", "Problem while allocating appWidgetIds for existing widgets", localSQLException);
          }
          paramSQLiteDatabase.endTransaction();
          if (localObject3 != null) {
            ((SQLiteStatement)localObject3).close();
          }
          if (localCursor1 != null) {
            localCursor1.close();
          }
          return;
          localCursor1 = localCursor2;
          localObject3 = localSQLException;
          localObject2 = localCursor2;
          localObject4 = localSQLException;
          paramSQLiteDatabase.setTransactionSuccessful();
          paramSQLiteDatabase.endTransaction();
          if (localSQLException != null) {
            localSQLException.close();
          }
          if (localCursor2 == null) {
            continue;
          }
          localCursor2.close();
          return;
          localCursor1 = localCursor2;
          localObject3 = localSQLException;
          localObject2 = localCursor2;
          localObject4 = localSQLException;
          Log.w("LauncherProvider", "Failed to create cursor while normalizing icons");
          continue;
        }
        finally
        {
          paramSQLiteDatabase.endTransaction();
          if (localObject4 != null) {
            ((SQLiteStatement)localObject4).close();
          }
          if (localObject2 != null) {
            ((Cursor)localObject2).close();
          }
        }
        label685:
        i = 1;
      }
    }
    
    private void renamePrefsFile()
    {
      if (new File("/data/data/com.sec.android.app.launcher/shared_prefs/com.android.launcher2.prefs.xml").renameTo(new File("/data/data/com.sec.android.app.launcher/shared_prefs/com.sec.android.app.launcher.prefs.xml")))
      {
        Log.d("LauncherProvider", "renamePrefsFile:: File renamed successfull !");
        return;
      }
      Log.d("LauncherProvider", "renamePrefsFile:: File renamed operation failed");
    }
    
    private void resetCount()
    {
      SharedPreferences.Editor localEditor = this.mContext.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
      localEditor.putInt("homescreenindex", -1);
      localEditor.putInt("homescreenindex.simple", -1);
      localEditor.putInt("screencount", -1);
      localEditor.putInt("screencount.simple", -1);
      localEditor.commit();
    }
    
    private void sendAppWidgetResetNotify()
    {
      this.mContext.getContentResolver().notifyChange(LauncherProvider.CONTENT_APPWIDGET_RESET_URI, null);
    }
    
    private boolean updateContactsShortcuts(SQLiteDatabase paramSQLiteDatabase)
    {
      Object localObject4 = null;
      Object localObject1 = null;
      Object localObject5 = LauncherProvider.buildOrWhereString("itemType", new int[] { 1 });
      paramSQLiteDatabase.beginTransaction();
      do
      {
        try
        {
          localObject5 = paramSQLiteDatabase.query("favorites", new String[] { "_id", "intent" }, (String)localObject5, null, null, null, null);
          if (localObject5 == null) {
            break label693;
          }
          localObject1 = localObject5;
          localObject4 = localObject5;
          if (LauncherProvider.DEBUGGABLE)
          {
            localObject1 = localObject5;
            localObject4 = localObject5;
            Log.d("LauncherProvider", "found upgrade cursor count=" + ((Cursor)localObject5).getCount());
          }
          localObject1 = localObject5;
          localObject4 = localObject5;
          localContentValues = new ContentValues();
          localObject1 = localObject5;
          localObject4 = localObject5;
          i = ((Cursor)localObject5).getColumnIndex("_id");
          localObject1 = localObject5;
          localObject4 = localObject5;
          j = ((Cursor)localObject5).getColumnIndex("intent");
        }
        catch (SQLException localSQLException)
        {
          for (;;)
          {
            ContentValues localContentValues;
            int i;
            int j;
            long l;
            Object localObject6;
            Intent localIntent;
            String str;
            if (LauncherProvider.DEBUGGABLE)
            {
              localObject1 = localSQLException;
              localObject4 = localSQLException;
              Log.e("LauncherProvider", "Problem upgrading shortcut", localURISyntaxException);
            }
          }
        }
        finally
        {
          paramSQLiteDatabase.endTransaction();
          if (localObject4 == null) {
            break;
          }
          ((Cursor)localObject4).close();
        }
        localObject1 = localObject5;
        localObject4 = localObject5;
        if (!((Cursor)localObject5).moveToNext()) {
          break label663;
        }
        localObject1 = localObject5;
        localObject4 = localObject5;
        l = ((Cursor)localObject5).getLong(i);
        localObject1 = localObject5;
        localObject4 = localObject5;
        localObject6 = ((Cursor)localObject5).getString(j);
      } while (localObject6 == null);
      localObject1 = localObject5;
      localObject4 = localObject5;
      label663:
      Object localObject3 = localSQLException;
      localObject4 = localSQLException;
      paramSQLiteDatabase.setTransactionSuccessful();
      for (;;)
      {
        paramSQLiteDatabase.endTransaction();
        if (localSQLException != null) {
          localSQLException.close();
        }
        return true;
        label693:
        localObject3 = localSQLException;
        localObject4 = localSQLException;
        Log.w("LauncherProvider", "Failed to create cursor for updateContactsShortcuts");
      }
    }
    
    public void exchangeComponentFromApp(SQLiteDatabase paramSQLiteDatabase, Map<ComponentName, ComponentName> paramMap, String paramString)
    {
      Log.d("LauncherProvider", "exchangeComponentFromApp");
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT _id,intent FROM " + paramString + " WHERE intent IS NOT NULL", null);
      if (localCursor != null) {}
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.compileStatement("UPDATE " + paramString + " SET intent=? WHERE _id=?");
        while (localCursor.moveToNext())
        {
          long l = localCursor.getLong(0);
          try
          {
            paramString = Intent.parseUri(localCursor.getString(1), 0);
            ComponentName localComponentName = paramString.getComponent();
            if (localComponentName != null)
            {
              localComponentName = (ComponentName)paramMap.get(localComponentName);
              if (localComponentName != null)
              {
                paramSQLiteDatabase.bindLong(2, l);
                paramSQLiteDatabase.bindString(1, paramString.setComponent(localComponentName).toUri(0));
                paramSQLiteDatabase.execute();
              }
            }
          }
          catch (URISyntaxException paramString) {}
        }
        paramSQLiteDatabase.close();
        return;
      }
      finally
      {
        localCursor.close();
      }
    }
    
    public long generateNewAppOrderId()
    {
      if (this.mMaxAppOrderId == null) {
        throw new RuntimeException("Error: mMaxAppOrderId was not initialized");
      }
      return this.mMaxAppOrderId.incrementAndGet();
    }
    
    public long generateNewFavoritesId()
    {
      if (this.mMaxFavoriteId == null) {
        throw new RuntimeException("Error: mMaxFavoriteId was not initialized");
      }
      return this.mMaxFavoriteId.incrementAndGet();
    }
    
    public long generateNewSprintFolderId()
    {
      if (this.mMaxSprintFolderId == null) {
        throw new RuntimeException("Error: mMaxSprintFolderId was not initialized");
      }
      return this.mMaxSprintFolderId.incrementAndGet();
    }
    
    public long getSprintFolderID(boolean paramBoolean)
    {
      if (LauncherProvider.DEBUGGABLE) {
        Log.d("LauncherProvider", "getSprintFolderID :: isFeatured: " + paramBoolean);
      }
      SharedPreferences localSharedPreferences = this.mContext.getSharedPreferences("com.sec.android.app.launcher.prefs", 0);
      if (paramBoolean) {
        return localSharedPreferences.getLong("sprintFeaturedFolderID", 0L);
      }
      return localSharedPreferences.getLong("sprintFolderID", 0L);
    }
    
    public ArrayList<String> loadFrontAppOrder()
    {
      this.frontMenuApps = new ArrayList();
      this.mOnlyLoadFrontApps = true;
      loadAppOrderDefaults(null);
      this.mOnlyLoadFrontApps = false;
      return this.frontMenuApps;
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      if (LauncherProvider.DEBUGGABLE) {
        Log.d("LauncherProvider", "creating new launcher database");
      }
      File localFile = new File(this.mContext.getApplicationInfo().dataDir + "/databases");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      this.mAppWidgetHost.deleteHost();
      sendAppWidgetResetNotify();
      this.mMaxFavoriteId = new AtomicLong(0L);
      createFavorites(paramSQLiteDatabase, "favorites");
      if (CscFeature.getInstance().getEnableStatus("CscFeature_Common_EnableSprintExtension")) {
        createSprintFolderTable(paramSQLiteDatabase);
      }
      this.mMaxFavoriteId.set(0L);
      createAppOrderTable(paramSQLiteDatabase);
      if (!convertDatabase(paramSQLiteDatabase)) {
        loadFavorites(paramSQLiteDatabase, "favorites", false);
      }
      loadAppOrderDefaults(paramSQLiteDatabase);
    }
    
    public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      Log.i("LauncherProvider", "onDowngrade triggered :: oldVersion:" + paramInt1 + " newVersion:" + paramInt2);
      if (paramInt2 < 13) {
        LauncherProvider.mApp.getFileStreamPath("com.sec.android.app.launcher.prefs").delete();
      }
      if (paramInt1 != 14)
      {
        Iterator localIterator = getTablesList(paramSQLiteDatabase).iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if ((!str.equals("favorites")) && (!str.equals("appOrder")) && (!str.equals("prefs")))
          {
            paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
            if (LauncherProvider.DEBUGGABLE) {
              Log.d("LauncherProvider", "onDownGrade:: Dropping extra table:" + str);
            }
          }
        }
        paramInt1 = 0;
        if ((!doesTableExist(paramSQLiteDatabase, "favorites")) || (!doesTableExist(paramSQLiteDatabase, "appOrder")))
        {
          if (LauncherProvider.DEBUGGABLE) {
            Log.d("LauncherProvider", "onDownGrade:: favorites/appOrder doesnot exist");
          }
          paramInt1 = 1;
        }
        if (paramInt1 != 0)
        {
          Log.w("LauncherProvider", "Destroying all old data.");
          resetCount();
          paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS favorites");
          paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS appOrder");
          if (CscFeature.getInstance().getEnableStatus("CscFeature_Common_EnableSprintExtension")) {
            paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS prefs");
          }
          onCreate(paramSQLiteDatabase);
        }
      }
    }
    
    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      if (CscFeature.getInstance().getEnableStatus("CscFeature_Common_EnableSprintExtension"))
      {
        if (LauncherProvider.DEBUGGABLE) {
          Log.d("LauncherProvider", "onOpen triggered");
        }
        createPublicPreferences(paramSQLiteDatabase);
        return;
      }
      super.onOpen(paramSQLiteDatabase);
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      if (LauncherProvider.DEBUGGABLE) {
        Log.d("LauncherProvider", "onUpgrade triggered");
      }
      paramInt2 = paramInt1;
      paramInt1 = paramInt2;
      if (paramInt2 < 3) {
        paramSQLiteDatabase.beginTransaction();
      }
      try
      {
        paramSQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN appWidgetId INTEGER NOT NULL DEFAULT -1;");
        paramSQLiteDatabase.setTransactionSuccessful();
        paramInt2 = 3;
      }
      catch (SQLException localSQLException1)
      {
        for (;;)
        {
          if (LauncherProvider.DEBUGGABLE) {
            Log.e("LauncherProvider", localSQLException1.getMessage(), localSQLException1);
          }
          paramSQLiteDatabase.endTransaction();
        }
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
      paramInt1 = paramInt2;
      if (paramInt2 == 3)
      {
        convertWidgets(paramSQLiteDatabase);
        paramInt1 = paramInt2;
      }
      paramInt2 = paramInt1;
      if (paramInt1 < 4) {
        paramInt2 = 4;
      }
      paramInt1 = paramInt2;
      if (paramInt2 < 6) {
        paramSQLiteDatabase.beginTransaction();
      }
      try
      {
        paramSQLiteDatabase.execSQL("UPDATE favorites SET screen=(screen + 1);");
        paramSQLiteDatabase.setTransactionSuccessful();
      }
      catch (SQLException localSQLException2)
      {
        for (;;)
        {
          if (LauncherProvider.DEBUGGABLE) {
            Log.e("LauncherProvider", localSQLException2.getMessage(), localSQLException2);
          }
          paramSQLiteDatabase.endTransaction();
        }
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
      paramInt1 = paramInt2;
      if (updateContactsShortcuts(paramSQLiteDatabase)) {
        paramInt1 = 6;
      }
      paramInt2 = paramInt1;
      if (paramInt1 < 7)
      {
        convertWidgets(paramSQLiteDatabase);
        paramInt2 = 7;
      }
      paramInt1 = paramInt2;
      if (paramInt2 < 8)
      {
        normalizeIcons(paramSQLiteDatabase);
        paramInt1 = 8;
      }
      paramInt2 = paramInt1;
      if (paramInt1 < 9)
      {
        if (this.mMaxFavoriteId == null) {
          this.mMaxFavoriteId = getMaxFavoriteID(paramSQLiteDatabase);
        }
        loadFavorites(paramSQLiteDatabase, "favorites", true);
        createAppOrderTable(paramSQLiteDatabase);
        loadAppOrderDefaults(paramSQLiteDatabase);
        paramInt2 = 9;
      }
      if (LauncherApplication.getSmallestWidth() >= 600)
      {
        paramInt1 = paramInt2;
        if (paramInt2 == 9) {}
      }
      else
      {
        paramInt1 = paramInt2;
        if (paramInt2 < 11) {
          paramSQLiteDatabase.beginTransaction();
        }
      }
      try
      {
        paramSQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN iconMovieUri TEXT");
        paramSQLiteDatabase.setTransactionSuccessful();
        paramInt1 = 11;
      }
      catch (SQLException localSQLException3)
      {
        for (;;)
        {
          if (LauncherProvider.DEBUGGABLE) {
            Log.e("LauncherProvider", localSQLException3.getMessage(), localSQLException3);
          }
          paramSQLiteDatabase.endTransaction();
          paramInt1 = paramInt2;
        }
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
      paramInt2 = paramInt1;
      if (paramInt1 == 12) {
        paramSQLiteDatabase.beginTransaction();
      }
      try
      {
        paramSQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN festival INTEGER");
        paramSQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN color INTEGER NOT NULL DEFAULT -1");
        paramSQLiteDatabase.execSQL("ALTER TABLE appOrder ADD COLUMN color INTEGER NOT NULL DEFAULT -1");
        paramSQLiteDatabase.setTransactionSuccessful();
        paramInt1 = 14;
      }
      catch (SQLException localSQLException4)
      {
        for (;;)
        {
          if (LauncherProvider.DEBUGGABLE) {
            Log.e("LauncherProvider", localSQLException4.getMessage(), localSQLException4);
          }
          paramSQLiteDatabase.endTransaction();
        }
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
      checkHomescreenArrangement(paramSQLiteDatabase);
      renamePrefsFile();
      paramInt2 = paramInt1;
      paramInt1 = paramInt2;
      if (paramInt2 < 13) {
        paramSQLiteDatabase.beginTransaction();
      }
      try
      {
        paramSQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN color INTEGER NOT NULL DEFAULT -1");
        paramSQLiteDatabase.execSQL("ALTER TABLE appOrder ADD COLUMN color INTEGER NOT NULL DEFAULT -1");
        paramSQLiteDatabase.setTransactionSuccessful();
        paramInt1 = 13;
      }
      catch (SQLException localSQLException5)
      {
        for (;;)
        {
          if (LauncherProvider.DEBUGGABLE) {
            Log.e("LauncherProvider", localSQLException5.getMessage(), localSQLException5);
          }
          paramSQLiteDatabase.endTransaction();
          paramInt1 = paramInt2;
        }
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
      checkHomescreenArrangement(paramSQLiteDatabase);
      renamePrefsFile();
      paramInt2 = paramInt1;
      if (paramInt1 < 14) {
        paramSQLiteDatabase.beginTransaction();
      }
      try
      {
        paramSQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN secret INTEGER");
        paramSQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN festival INTEGER");
        paramSQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN pkgName TEXT");
        paramSQLiteDatabase.execSQL("ALTER TABLE appOrder ADD COLUMN secret INTEGER");
        paramSQLiteDatabase.setTransactionSuccessful();
        paramInt2 = 14;
      }
      catch (SQLException localSQLException6)
      {
        for (;;)
        {
          if (LauncherProvider.DEBUGGABLE) {
            Log.e("LauncherProvider", localSQLException6.getMessage(), localSQLException6);
          }
          paramSQLiteDatabase.endTransaction();
          paramInt2 = paramInt1;
        }
      }
      finally
      {
        paramSQLiteDatabase.endTransaction();
      }
      if (paramInt2 != 14)
      {
        Log.w("LauncherProvider", "Destroying all old data.");
        resetCount();
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS favorites");
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS appOrder");
        onCreate(paramSQLiteDatabase);
      }
    }
    
    public void setSprintFolderId(long paramLong, boolean paramBoolean)
    {
      if (LauncherProvider.DEBUGGABLE) {
        Log.d("LauncherProvider", "setSprintFolderID :" + paramLong + " , isFeatured : " + paramBoolean);
      }
      SharedPreferences.Editor localEditor = this.mContext.getSharedPreferences("com.sec.android.app.launcher.prefs", 0).edit();
      if (paramBoolean) {
        localEditor.putLong("sprintFeaturedFolderID", paramLong);
      }
      for (;;)
      {
        localEditor.commit();
        return;
        localEditor.putLong("sprintFolderID", paramLong);
      }
    }
    
    boolean switchToDynamicIfNecessary(int paramInt)
    {
      Log.d("DYNAMIC_CSC_J-TDD", "switchToDynamicIfNecessary basicEasymode : " + paramInt);
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      boolean bool = false;
      if (this.mContext.getContentResolver() != null) {
        this.mContext.getContentResolver().delete(Uri.parse("content://com.android.launcher2.settings/favorites"), null, null);
      }
      loadDynamicCscFavorites(localSQLiteDatabase, "favorites", false);
      if (paramInt == 1) {
        bool = true;
      }
      return bool;
    }
  }
  
  private static class SqlArguments
  {
    public final String[] args;
    public final String table;
    public final String where;
    
    SqlArguments(Uri paramUri)
    {
      if (paramUri.getPathSegments().size() == 1)
      {
        this.table = ((String)paramUri.getPathSegments().get(0));
        this.where = null;
        this.args = null;
        return;
      }
      throw new IllegalArgumentException("Invalid URI: " + paramUri);
    }
    
    SqlArguments(Uri paramUri, String paramString, String[] paramArrayOfString)
    {
      if (paramUri.getPathSegments().size() == 1)
      {
        this.table = ((String)paramUri.getPathSegments().get(0));
        this.where = paramString;
        this.args = paramArrayOfString;
        return;
      }
      if (paramUri.getPathSegments().size() != 2) {
        throw new IllegalArgumentException("Invalid URI: " + paramUri);
      }
      if (!TextUtils.isEmpty(paramString)) {
        throw new UnsupportedOperationException("WHERE clause not supported: " + paramUri);
      }
      this.table = ((String)paramUri.getPathSegments().get(0));
      this.where = ("_id=" + ContentUris.parseId(paramUri));
      this.args = null;
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/LauncherProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */