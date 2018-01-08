package com.android.launcher2;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

class HomeShortcutItem
  extends HomeItem
{
  private static final boolean DEBUGGABLE = ;
  boolean customIcon;
  Intent.ShortcutIconResource iconResource;
  Intent intent;
  Bitmap mCustomIconBitmap;
  Uri mIconMovieUri;
  String packageName;
  boolean usingFallbackIcon;
  
  HomeShortcutItem()
  {
    super(BaseItem.Type.HOME_SHORTCUT);
  }
  
  HomeShortcutItem(BaseItem.Type paramType)
  {
    super(paramType);
  }
  
  public static void dumpShortcutInfoList(String paramString1, String paramString2, ArrayList<HomeShortcutItem> paramArrayList)
  {
    if (DEBUGGABLE) {
      Log.d(paramString1, paramString2 + " size=" + paramArrayList.size());
    }
    paramString2 = paramArrayList.iterator();
    while (paramString2.hasNext())
    {
      paramArrayList = (HomeShortcutItem)paramString2.next();
      if (DEBUGGABLE) {
        Log.d(paramString1, "   title=\"" + paramArrayList.mTitle + " icon=" + paramArrayList.mIconBitmap + " customIcon=" + paramArrayList.customIcon);
      }
    }
  }
  
  public ComponentName getComponentName()
  {
    ComponentName localComponentName = null;
    if (this.intent != null) {
      localComponentName = this.intent.getComponent();
    }
    return localComponentName;
  }
  
  public Intent getIntent()
  {
    return this.intent;
  }
  
  public String getPackageName()
  {
    Object localObject2;
    if (this.packageName != null)
    {
      localObject2 = this.packageName;
      return (String)localObject2;
    }
    Object localObject1 = null;
    if (this.intent != null)
    {
      localObject1 = this.intent.getComponent();
      if (localObject1 == null) {
        break label63;
      }
    }
    label63:
    for (localObject1 = ((ComponentName)localObject1).getPackageName();; localObject1 = this.intent.getPackage())
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      localObject2 = localObject1;
      if (this.iconResource == null) {
        break;
      }
      return this.iconResource.packageName;
    }
  }
  
  void onAddToDatabase(ContentValues paramContentValues)
  {
    super.onAddToDatabase(paramContentValues);
    paramContentValues.put("title", this.mTitle);
    String str;
    if (this.intent != null)
    {
      str = this.intent.toUri(0);
      paramContentValues.put("intent", str);
      if (!this.customIcon) {
        break label117;
      }
      paramContentValues.put("iconType", Integer.valueOf(1));
      writeBitmap(paramContentValues, this.mIconBitmap);
      if ((Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE) && (this.mCustomIconBitmap != null)) {
        writeBitmap(paramContentValues, this.mCustomIconBitmap);
      }
    }
    for (;;)
    {
      if ((this.mIconMovie != null) && (this.mIconMovieUri != null)) {
        paramContentValues.put("iconMovieUri", this.mIconMovieUri.toString());
      }
      return;
      str = null;
      break;
      label117:
      if (!this.usingFallbackIcon) {
        writeBitmap(paramContentValues, this.mIconBitmap);
      }
      paramContentValues.put("iconType", Integer.valueOf(0));
      if (this.iconResource != null)
      {
        paramContentValues.put("iconPackage", this.iconResource.packageName);
        paramContentValues.put("iconResource", this.iconResource.resourceName);
      }
    }
  }
  
  final void setActivity(ComponentName paramComponentName, int paramInt)
  {
    this.intent = new Intent("android.intent.action.MAIN");
    this.intent.addCategory("android.intent.category.LAUNCHER");
    this.intent.setComponent(paramComponentName);
    this.intent.setFlags(paramInt);
  }
  
  public void setCustomIcon(Bitmap paramBitmap)
  {
    if ((Launcher.CSCFEATURE_LAUNCHER_THEME_ENABLE) && (this.mCustomIconBitmap != paramBitmap)) {
      this.mCustomIconBitmap = paramBitmap;
    }
  }
  
  public void setIcon(Bitmap paramBitmap)
  {
    if (this.mIconBitmap != paramBitmap)
    {
      this.mIconBitmap = paramBitmap;
      this.mIconShadowBitmap = null;
    }
  }
  
  public String toString()
  {
    return "HomeShortcutItem(title=" + this.mTitle + " id=" + this.mId + " container=" + this.container + " screen=" + this.mScreen + " cellX=" + this.cellX + " cellY=" + this.cellY + " spanX=" + this.spanX + " spanY=" + this.spanY + " dropPos=" + this.dropPos + ")";
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/HomeShortcutItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */