package com.tencent.mm.pluginsdk.model.app;

import android.net.Uri;
import com.tencent.gmtrace.GMTrace;

public final class ap
{
  public static ap sCY;
  public static long sCZ;
  public int code;
  public String[] projection;
  public String sCW;
  public String[] sCX;
  public String selection;
  public String[] selectionArgs;
  public Uri uri;
  
  static
  {
    GMTrace.i(792153030656L, 5902);
    sCY = null;
    sCZ = -1L;
    GMTrace.o(792153030656L, 5902);
  }
  
  public ap(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, int paramInt, String[] paramArrayOfString3)
  {
    GMTrace.i(792018812928L, 5901);
    this.uri = null;
    this.projection = null;
    this.selection = "";
    this.selectionArgs = null;
    this.sCW = "";
    this.code = -1;
    this.sCX = null;
    this.uri = paramUri;
    this.projection = paramArrayOfString1;
    this.selection = paramString1;
    this.selectionArgs = paramArrayOfString2;
    this.sCW = paramString2;
    this.code = paramInt;
    this.sCX = paramArrayOfString3;
    GMTrace.o(792018812928L, 5901);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/model/app/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */