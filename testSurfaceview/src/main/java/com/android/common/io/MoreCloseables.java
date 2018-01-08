package com.android.common.io;

import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import java.io.IOException;

public class MoreCloseables
{
  public static void closeQuietly(AssetFileDescriptor paramAssetFileDescriptor)
  {
    if (paramAssetFileDescriptor != null) {}
    try
    {
      paramAssetFileDescriptor.close();
      return;
    }
    catch (IOException paramAssetFileDescriptor) {}
  }
  
  public static void closeQuietly(Cursor paramCursor)
  {
    if (paramCursor != null) {
      paramCursor.close();
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/common/io/MoreCloseables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */