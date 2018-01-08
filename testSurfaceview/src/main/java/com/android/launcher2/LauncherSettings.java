package com.android.launcher2;

import android.content.ComponentName;
import android.net.Uri;
import android.provider.BaseColumns;

class LauncherSettings
{
  static final class AppOrder
  {
    static final String CELL = "cell";
    static final String COLOR = "color";
    static final String COMPONENT_NAME = "componentName";
    static final Uri CONTENT_URI = Uri.parse("content://com.sec.android.app.launcher.settings/appOrder");
    static final String FOLDER_ID = "folderId";
    static final String HIDDEN = "hidden";
    static final String ID = "_id";
    static final String SCREEN = "screen";
    static final String SECRET = "secret";
    static final String TITLE = "title";
  }
  
  public static class AppOrderModify
  {
    public static final int CREATE_APP = 3;
    public static final int CREATE_FOLDER = 0;
    public static final int DELETE_ITEM = 5;
    public static final int UPDATE_APP = 4;
    public static final int UPDATE_COLOR = 6;
    public static final int UPDATE_FOLDER = 1;
    public static final int UPDATE_TITLE = 2;
    public int action;
    public int cell;
    public int color;
    public ComponentName component;
    public long folderId;
    public boolean hidden;
    public long id;
    public int screen;
    public boolean secret;
    public String title;
  }
  
  public static class ExchangeComponent
  {
    public static final String MATCHED_APP = "matchedapp";
    public static final String MATCHED_WIDGET = "matchedwidget";
  }
  
  public static class FavoritePos
  {
    public int cellX;
    public int cellY;
    public long container;
    public int festival;
    public long id;
    public int screen;
    public int secret;
  }
  
  static final class Favorites
    implements BaseColumns
  {
    static final String APPWIDGET_ID = "appWidgetId";
    static final String CELLX = "cellX";
    static final String CELLY = "cellY";
    static final String COLOR = "color";
    static final String CONTAINER = "container";
    static final int CONTAINER_DESKTOP = -100;
    static final int CONTAINER_HOTSEAT = -101;
    static final int CONTAINER_MENU = -102;
    static final Uri CONTENT_URI = Uri.parse("content://com.sec.android.app.launcher.settings/favorites?notify=true");
    static final Uri CONTENT_URI_NO_NOTIFICATION = Uri.parse("content://com.sec.android.app.launcher.settings/favorites?notify=false");
    static final String DND_HEADER = "DragAndDropBinding";
    static final int DND_ITEM_TYPE_APPLICATION = 0;
    static final int DND_ITEM_TYPE_APPWIDGET = 3;
    static final int DND_ITEM_TYPE_SAMSUNG_APPWIDGET = 4;
    static final int DND_ITEM_TYPE_SHORTCUT = 1;
    static final int DND_ITEM_TYPE_SHORTCUT_INSTALL = 2;
    static final int DND_ITEM_TYPE_SURFACE_WIDGET = 5;
    static final String FESTIVAL = "festival";
    static final String ICON = "icon";
    static final String ICON_MOVIE_URI = "iconMovieUri";
    static final String ICON_PACKAGE = "iconPackage";
    static final String ICON_RESOURCE = "iconResource";
    static final String ICON_TYPE = "iconType";
    static final int ICON_TYPE_BITMAP = 1;
    static final int ICON_TYPE_RESOURCE = 0;
    static final String INTENT = "intent";
    static final String ITEM_TYPE = "itemType";
    static final int ITEM_TYPE_APPLICATION = 0;
    static final int ITEM_TYPE_APPWIDGET = 4;
    static final int ITEM_TYPE_FOLDER = 2;
    static final int ITEM_TYPE_LIVE_FOLDER = 3;
    static final int ITEM_TYPE_SAMSUNG_APPWIDGET = 900;
    static final int ITEM_TYPE_SHORTCUT = 1;
    static final int ITEM_TYPE_SHORTCUT_INSTALL = 100;
    static final int ITEM_TYPE_SURFACE_WIDGET = 901;
    static final int ITEM_TYPE_WIDGET_CLOCK = 1000;
    static final int ITEM_TYPE_WIDGET_PHOTO_FRAME = 1002;
    static final int ITEM_TYPE_WIDGET_SEARCH = 1001;
    static final String SAMPLE_PKG_NAME = "pkgName";
    static final String SCREEN = "screen";
    static final String SECRET = "secret";
    static final String SPANX = "spanX";
    static final String SPANY = "spanY";
    static final String TITLE = "title";
    
    static Uri CONTENT_URI()
    {
      return Uri.parse("content://com.sec.android.app.launcher.settings/favorites?notify=true");
    }
    
    static Uri CONTENT_URI_NO_NOTIFICATION()
    {
      return Uri.parse("content://com.sec.android.app.launcher.settings/favorites?notify=false");
    }
    
    static int convertToLocalItemType(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return -1;
      case 0: 
        return 0;
      case 1: 
        return 1;
      case 3: 
        return 4;
      case 4: 
        return 900;
      case 5: 
        return 901;
      }
      return 100;
    }
    
    static Uri getContentUri(long paramLong, boolean paramBoolean)
    {
      return Uri.parse("content://com.sec.android.app.launcher.settings/favorites/" + paramLong + "?" + "notify" + "=" + paramBoolean);
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/LauncherSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */