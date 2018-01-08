package com.android.launcher2;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class Outliner
{
  static
  {
    System.loadLibrary("drawglfunction");
  }
  
  public static Bitmap boxOutline(int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ALPHA_8);
    if (!nBoxOutline(localBitmap)) {
      throw new IllegalStateException("Failed to create box outline.");
    }
    return localBitmap;
  }
  
  private static native boolean nBoxOutline(Bitmap paramBitmap);
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/Outliner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */