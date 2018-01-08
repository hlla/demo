package com.android.launcher2;

import android.content.ComponentName;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HomeItem
  extends BaseItem
  implements Cloneable
{
  public int cellX = -1;
  public int cellY = -1;
  public long container = -1L;
  public int[] dropPos = null;
  public int mFestivalType = 0;
  public int spanX = 1;
  public int spanY = 1;
  
  public HomeItem()
  {
    super(BaseItem.Type.HOME_UNKNOWN);
  }
  
  protected HomeItem(BaseItem.Type paramType)
  {
    super(paramType);
  }
  
  static byte[] flattenBitmap(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramBitmap.getWidth() * paramBitmap.getHeight() * 4);
    try
    {
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      localByteArrayOutputStream.flush();
      localByteArrayOutputStream.close();
      paramBitmap = localByteArrayOutputStream.toByteArray();
      return paramBitmap;
    }
    catch (IOException paramBitmap)
    {
      Log.w("Favorite", "Could not write icon");
    }
    return null;
  }
  
  private int mapTypeToDbValue()
  {
    switch (this.mType)
    {
    default: 
      return -1;
    case ???: 
      return 0;
    case ???: 
      return 1;
    case ???: 
      return 2;
    case ???: 
      return 4;
    case ???: 
      return 900;
    }
    return 901;
  }
  
  static void writeBitmap(ContentValues paramContentValues, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      paramContentValues.put("icon", flattenBitmap(paramBitmap));
    }
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public ComponentName getComponentName()
  {
    return null;
  }
  
  public String getPackageName()
  {
    return null;
  }
  
  public int getSpanX()
  {
    return this.spanX;
  }
  
  public int getSpanY()
  {
    return this.spanY;
  }
  
  public BaseItem.Type mapDbValueToType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return BaseItem.Type.HOME_APPLICATION;
    case 1: 
      return BaseItem.Type.HOME_SHORTCUT;
    case 2: 
      return BaseItem.Type.HOME_FOLDER;
    case 4: 
      return BaseItem.Type.HOME_WIDGET;
    case 900: 
      return BaseItem.Type.HOME_SAMSUNG_WIDGET;
    }
    return BaseItem.Type.HOME_SURFACE_WIDGET;
  }
  
  void onAddToDatabase(ContentValues paramContentValues)
  {
    paramContentValues.put("itemType", Integer.valueOf(mapTypeToDbValue()));
    paramContentValues.put("container", Long.valueOf(this.container));
    paramContentValues.put("screen", Integer.valueOf(this.mScreen));
    paramContentValues.put("cellX", Integer.valueOf(this.cellX));
    paramContentValues.put("cellY", Integer.valueOf(this.cellY));
    paramContentValues.put("spanX", Integer.valueOf(this.spanX));
    paramContentValues.put("spanY", Integer.valueOf(this.spanY));
    if (this.mSecretItem) {}
    for (int i = 1;; i = 0)
    {
      paramContentValues.put("secret", Integer.valueOf(i));
      paramContentValues.put("festival", Integer.valueOf(this.mFestivalType));
      return;
    }
  }
  
  public String toString()
  {
    return "HomeItem(id=" + this.mId + " container=" + this.container + " screen=" + this.mScreen + " cellX=" + this.cellX + " cellY=" + this.cellY + " spanX=" + this.spanX + " spanY=" + this.spanY + " dropPos=" + this.dropPos + ")";
  }
  
  void updateValuesWithCoordinates(ContentValues paramContentValues, int paramInt1, int paramInt2)
  {
    paramContentValues.put("cellX", Integer.valueOf(paramInt1));
    paramContentValues.put("cellY", Integer.valueOf(paramInt2));
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/HomeItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */