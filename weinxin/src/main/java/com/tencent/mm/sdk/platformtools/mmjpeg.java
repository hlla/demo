package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import com.tencent.gmtrace.GMTrace;

class mmjpeg
{
  mmjpeg()
  {
    GMTrace.i(13768457191424L, 102583);
    GMTrace.o(13768457191424L, 102583);
  }
  
  public static native int convertToProgressive(String paramString1, String paramString2);
  
  public static native boolean decodeToBitmap(String paramString, Bitmap paramBitmap);
  
  public static native int isProgressiveFile(String paramString);
  
  public static native JpegParams queryParams(String paramString);
  
  public static native int queryQuality(String paramString);
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/mmjpeg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */