package com.android.launcher2;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.Settings.System;
import android.util.Log;
import com.samsung.android.theme.SThemeManager;
import java.util.HashMap;

public class ThemeLoader
{
  private static final boolean DEBUGGABLE = ;
  private static final String TAG = "ThemeLoader";
  private static final float THIRD_APP_SCALE_RATE = 0.75F;
  private static Bitmap THIRD_BACKGROUND_BITMAP;
  private static Bitmap THIRD_MENU_BACKGROUND_BITMAP;
  private static Paint mPaint;
  private static final HashMap<String, String> mSamsungWidgetPreviewMap;
  private static final HashMap<String, String> mWidgetPreviewMap = new HashMap();
  private static int sIconHeight = -1;
  private static int sIconWidth;
  private static int sMenuIconWidth = -1;
  private final Context mContext;
  private boolean mIsUseDefaultTheme = true;
  private SThemeManager mThemeMgr;
  
  static
  {
    mSamsungWidgetPreviewMap = new HashMap();
    sIconWidth = -1;
  }
  
  public ThemeLoader(Context paramContext)
  {
    this.mContext = paramContext;
    this.mThemeMgr = new SThemeManager(paramContext);
    String str = Settings.System.getString(this.mContext.getContentResolver(), "current_sec_theme_package");
    if ((str == null) || (str.isEmpty()))
    {
      this.mIsUseDefaultTheme = true;
      return;
    }
    this.mIsUseDefaultTheme = false;
    int i = (int)paramContext.getResources().getDimension(2131624134);
    sIconHeight = i;
    sIconWidth = i;
    paramContext = load3rdpartyIconBitmap();
    if (paramContext != null) {
      THIRD_BACKGROUND_BITMAP = Utilities.createIconBitmap(paramContext, this.mContext);
    }
    mPaint = new Paint();
    mPaint.setAntiAlias(true);
    mPaint.setFilterBitmap(true);
    mPaint.setDither(false);
    initWidgetPreviewMap();
    initSamsungWidgetPreviewMap();
  }
  
  private void initSamsungWidgetPreviewMap()
  {
    mSamsungWidgetPreviewMap.clear();
    mSamsungWidgetPreviewMap.put("com.sec.android.widgetapp.SPlannerAppWidget/Today_mini", "widget_preview_minitoday");
    mSamsungWidgetPreviewMap.put("com.sec.android.widgetapp.SPlannerAppWidget/Month", "widget_preview_month");
  }
  
  private void initWidgetPreviewMap()
  {
    mWidgetPreviewMap.clear();
    mWidgetPreviewMap.put("com.sec.android.widgetapp.alarmwidget", "widget_alarm_preview_01");
    mWidgetPreviewMap.put("com.sec.android.widgetapp.dualclockdigital", "dual_cn_1_24");
    mWidgetPreviewMap.put("com.sec.android.widgetapp.digitalclock", "single_a_cn_4x1_24");
    mWidgetPreviewMap.put("com.sec.android.widgetapp.digitalclock2x1", "single_a_cn_2x1_12");
    mWidgetPreviewMap.put("com.sec.android.app.music", "home_musicplayer_preview");
    mWidgetPreviewMap.put("com.sec.android.app.videoplayer", "videoplayer_preview");
    mWidgetPreviewMap.put("com.sec.android.widgetapp.analogclocksimple", "");
    mWidgetPreviewMap.put("com.sec.android.widgetapp.analogclockunique", "");
  }
  
  public Bitmap getBitmap(String paramString)
  {
    if (this.mIsUseDefaultTheme) {
      return null;
    }
    try
    {
      Bitmap localBitmap = this.mThemeMgr.getItemBitmap(paramString);
      return localBitmap;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Log.e("ThemeLoader", "getBitmap( " + paramString + " ) failed! " + localNotFoundException);
    }
    return null;
  }
  
  public int getColor(String paramString)
  {
    if (this.mIsUseDefaultTheme) {
      return 0;
    }
    try
    {
      int i = this.mThemeMgr.getItemColor(paramString);
      return i;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Log.e("ThemeLoader", "getColor( " + paramString + " ) failed! " + localNotFoundException);
    }
    return 0;
  }
  
  public Drawable getDrawable(String paramString)
  {
    if (this.mIsUseDefaultTheme) {
      return null;
    }
    try
    {
      Drawable localDrawable = this.mThemeMgr.getItemDrawable(paramString);
      return localDrawable;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Log.e("ThemeLoader", "getDrawable( " + paramString + " ) failed! " + localNotFoundException);
    }
    return null;
  }
  
  public String getText(String paramString)
  {
    if (this.mIsUseDefaultTheme) {
      return null;
    }
    try
    {
      String str = (String)this.mThemeMgr.getItemText(paramString);
      return str;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Log.e("ThemeLoader", "getText( " + paramString + " ) failed! " + localNotFoundException);
    }
    return null;
  }
  
  public boolean isSupportFestival()
  {
    boolean bool = true;
    if ("0".equals(this.mThemeMgr.getVersionFromFeature(1))) {
      bool = false;
    }
    return bool;
  }
  
  public boolean isSupportTheme()
  {
    return !"0".equals(this.mThemeMgr.getVersionFromFeature(0));
  }
  
  public boolean isUseDefaultTheme()
  {
    return this.mIsUseDefaultTheme;
  }
  
  public Bitmap load3rdAppIconBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    if (THIRD_BACKGROUND_BITMAP != null)
    {
      Bitmap localBitmap = Bitmap.createBitmap(sIconWidth, sIconHeight, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawBitmap(THIRD_BACKGROUND_BITMAP, 0.0F, 0.0F, mPaint);
      localCanvas.save();
      localCanvas.translate(sIconWidth / 2.0F, sIconHeight / 2.0F);
      localCanvas.scale(0.75F, 0.75F);
      localCanvas.drawBitmap(paramBitmap, -sIconWidth / 2.0F, -sIconHeight / 2.0F, mPaint);
      localCanvas.restore();
      return localBitmap;
    }
    return paramBitmap;
  }
  
  public Bitmap load3rdAppMenuIconBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {}
    while (THIRD_MENU_BACKGROUND_BITMAP == null) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(sMenuIconWidth, sMenuIconWidth, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawBitmap(THIRD_MENU_BACKGROUND_BITMAP, 0.0F, 0.0F, mPaint);
    localCanvas.save();
    localCanvas.translate(sMenuIconWidth / 2.0F, sMenuIconWidth / 2.0F);
    localCanvas.scale(0.75F, 0.75F);
    localCanvas.drawBitmap(paramBitmap, -sMenuIconWidth / 2.0F, -sMenuIconWidth / 2.0F, mPaint);
    localCanvas.restore();
    return localBitmap;
  }
  
  public Bitmap load3rdpartyIconBitmap()
  {
    try
    {
      Bitmap localBitmap = this.mThemeMgr.getPackageIconBitmap("3rd_party_icon");
      return localBitmap;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Log.e("ThemeLoader", "load3rdpartyIconBitmap failed " + localNotFoundException);
    }
    return null;
  }
  
  public Bitmap loadAppIconBitmap(String paramString)
  {
    if ((paramString == null) || (this.mIsUseDefaultTheme)) {}
    do
    {
      return null;
      Object localObject = null;
      try
      {
        Drawable localDrawable = this.mThemeMgr.getPackageIcon(paramString);
        paramString = localDrawable;
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        for (;;)
        {
          Log.e("ThemeLoader", "loadAppIconBitmap( " + paramString + " ) failed! " + localNotFoundException);
          paramString = (String)localObject;
        }
      }
    } while (paramString == null);
    return Utilities.createIconBitmap(paramString, this.mContext);
  }
  
  public Bitmap loadAppIconBitmapByPackageName(String paramString)
  {
    if ((paramString == null) || (this.mIsUseDefaultTheme)) {}
    for (;;)
    {
      return null;
      Object localObject = null;
      try
      {
        paramString = this.mThemeMgr.getPackageIconBitmapStartsWith(paramString);
        if (paramString == null) {
          continue;
        }
        return Utilities.createIconBitmap(paramString, this.mContext);
      }
      catch (Resources.NotFoundException paramString)
      {
        for (;;)
        {
          Log.e("ThemeLoader", "loadAppIconBitmapByPackageName failed " + paramString);
          paramString = (String)localObject;
        }
      }
    }
  }
  
  public Bitmap loadAppMenuIconBitmap(String paramString)
  {
    if ((paramString == null) || (this.mIsUseDefaultTheme)) {}
    do
    {
      return null;
      Object localObject1 = null;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("menu.");
      ((StringBuilder)localObject2).append(paramString);
      try
      {
        localObject2 = this.mThemeMgr.getPackageIcon(((StringBuilder)localObject2).toString());
        paramString = (String)localObject2;
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        for (;;)
        {
          Log.e("ThemeLoader", "loadAppMenuIconBitmap( " + paramString + " ) failed! " + localNotFoundException);
          paramString = (String)localObject1;
        }
      }
    } while (paramString == null);
    return Utilities.createIconBitmap(paramString, this.mContext, sMenuIconWidth);
  }
  
  public Bitmap loadAppsIconBitmap()
  {
    if (this.mIsUseDefaultTheme) {
      return null;
    }
    try
    {
      Bitmap localBitmap = this.mThemeMgr.getPackageIconBitmap("homesceen_apps_icon");
      return localBitmap;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Log.e("ThemeLoader", "loadAppsIconBitmap failed " + localNotFoundException);
    }
    return null;
  }
  
  public Drawable loadIconDrawable(String paramString)
  {
    if (this.mIsUseDefaultTheme) {}
    do
    {
      return null;
      Object localObject = null;
      try
      {
        Drawable localDrawable = this.mThemeMgr.getItemDrawable(paramString);
        paramString = localDrawable;
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        for (;;)
        {
          Log.e("ThemeLoader", "loadIconDrawable( " + paramString + " ) failed! " + localNotFoundException);
          paramString = (String)localObject;
        }
      }
    } while (paramString == null);
    return new BitmapDrawable(this.mContext.getResources(), Utilities.createIconBitmap(paramString, this.mContext));
  }
  
  public Bitmap loadSamsungWidgetPreviewBitmap(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (this.mIsUseDefaultTheme)) {}
    do
    {
      return null;
      paramString1 = paramString1 + "/" + paramString2;
    } while (!mSamsungWidgetPreviewMap.containsKey(paramString1));
    paramString1 = (String)mSamsungWidgetPreviewMap.get(paramString1);
    try
    {
      paramString2 = this.mThemeMgr.getItemBitmap(paramString1);
      return paramString2;
    }
    catch (Resources.NotFoundException paramString2)
    {
      Log.e("ThemeLoader", "loadSamsungWidgetPreviewBitmap( " + paramString1 + " ) failed! " + paramString2);
    }
    return null;
  }
  
  public Drawable loadSamsungWidgetPreviewDrawable(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (this.mIsUseDefaultTheme)) {}
    do
    {
      return null;
      paramString1 = paramString1 + "/" + paramString2;
    } while ((mSamsungWidgetPreviewMap == null) || (!mSamsungWidgetPreviewMap.containsKey(paramString1)));
    paramString1 = (String)mSamsungWidgetPreviewMap.get(paramString1);
    try
    {
      paramString2 = this.mThemeMgr.getItemDrawable(paramString1);
      return paramString2;
    }
    catch (Resources.NotFoundException paramString2)
    {
      Log.e("ThemeLoader", "loadSamsungWidgetPreviewDrawable( " + paramString1 + " ) failed! " + paramString2);
    }
    return null;
  }
  
  public Bitmap loadWidgetPreviewBitmap(String paramString)
  {
    if ((paramString == null) || (this.mIsUseDefaultTheme)) {}
    while (!mWidgetPreviewMap.containsKey(paramString)) {
      return null;
    }
    paramString = (String)mWidgetPreviewMap.get(paramString);
    try
    {
      Bitmap localBitmap = this.mThemeMgr.getItemBitmap(paramString);
      return localBitmap;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Log.e("ThemeLoader", "loadWidgetPreviewBitmap( " + paramString + " ) failed! " + localNotFoundException);
    }
    return null;
  }
  
  public Drawable loadWidgetPreviewDrawable(String paramString)
  {
    if ((paramString == null) || (this.mIsUseDefaultTheme)) {}
    while ((mWidgetPreviewMap == null) || (!mWidgetPreviewMap.containsKey(paramString))) {
      return null;
    }
    paramString = (String)mWidgetPreviewMap.get(paramString);
    try
    {
      Drawable localDrawable = this.mThemeMgr.getItemDrawable(paramString);
      return localDrawable;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Log.e("ThemeLoader", "loadWidgetPreviewImageDrawable( " + paramString + " ) failed! " + localNotFoundException);
    }
    return null;
  }
  
  public void setMenuIconSize(int paramInt)
  {
    sMenuIconWidth = paramInt;
    Object localObject = null;
    try
    {
      Drawable localDrawable = this.mThemeMgr.getItemDrawable("3rd_party_icon_menu");
      localObject = localDrawable;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;)
      {
        Log.e("ThemeLoader", "3rd_party_icon_menu  failed! " + localNotFoundException);
      }
    }
    if (localObject != null) {
      THIRD_MENU_BACKGROUND_BITMAP = Utilities.createIconBitmap((Drawable)localObject, this.mContext, sMenuIconWidth);
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/ThemeLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */