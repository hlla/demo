package com.tencent.mm.pluginsdk.ui.chat;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

final class h
{
  private ContentResolver hRk;
  protected Context mContext;
  
  protected h(Context paramContext)
  {
    GMTrace.i(968917778432L, 7219);
    this.mContext = paramContext;
    this.hRk = this.mContext.getContentResolver();
    GMTrace.o(968917778432L, 7219);
  }
  
  private String Na(String paramString)
  {
    GMTrace.i(969051996160L, 7220);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.RecentPhotoTips.ImageQuery", "null or nill imageId");
      GMTrace.o(969051996160L, 7220);
      return null;
    }
    Object localObject = "image_id=\"" + paramString + "\"";
    try
    {
      localObject = this.hRk.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, null, (String)localObject, null, null);
      if (localObject == null)
      {
        v.e("MicroMsg.RecentPhotoTips.ImageQuery", "get cursor null:" + paramString);
        GMTrace.o(969051996160L, 7220);
        return null;
      }
    }
    catch (Exception paramString)
    {
      v.e("MicroMsg.RecentPhotoTips.ImageQuery", "query thumb exception e : %s", new Object[] { paramString.toString() });
      GMTrace.o(969051996160L, 7220);
      return null;
    }
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        paramString = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndexOrThrow("_data"));
      } while (((Cursor)localObject).moveToNext());
    }
    for (;;)
    {
      ((Cursor)localObject).close();
      GMTrace.o(969051996160L, 7220);
      return paramString;
      paramString = null;
    }
  }
  
  public final ArrayList<g> bFT()
  {
    GMTrace.i(969186213888L, 7221);
    ArrayList localArrayList = new ArrayList();
    Object localObject = "date_added desc limit 1";
    bf.NA();
    try
    {
      localObject = this.hRk.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id", "_data", "date_added" }, null, null, (String)localObject);
      if (localObject == null)
      {
        GMTrace.o(969186213888L, 7221);
        return localArrayList;
      }
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.RecentPhotoTips.ImageQuery", "query photo exception e : %s", new Object[] { localException.toString() });
      GMTrace.o(969186213888L, 7221);
      return null;
    }
    if (((Cursor)localObject).moveToFirst()) {}
    for (;;)
    {
      String str1 = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndexOrThrow("_id"));
      String str2 = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndexOrThrow("_data"));
      String str3 = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndexOrThrow("date_added"));
      String str4 = Na(str1);
      if ((bf.mA(str2)) || (!com.tencent.mm.a.e.aO(str2))) {
        v.e("MicroMsg.RecentPhotoTips.ImageQuery", "file not exist");
      }
      while (!((Cursor)localObject).moveToNext())
      {
        ((Cursor)localObject).close();
        GMTrace.o(969186213888L, 7221);
        return localException;
        if (str2.startsWith(com.tencent.mm.compatible.util.e.gSp))
        {
          v.i("MicroMsg.RecentPhotoTips.ImageQuery", "exclude weixin path image");
        }
        else
        {
          g localg = new g();
          localg.sOG = bf.getLong(str1, 0L);
          localg.mcU = bf.getLong(str3, 0L);
          if ((!bf.mA(str4)) && (com.tencent.mm.a.e.aO(str4))) {
            localg.fKq = str4;
          }
          if ((!bf.mA(str2)) && (com.tencent.mm.a.e.aO(str2))) {
            localg.sOH = str2;
          }
          if ((bf.mA(localg.sOH)) && (bf.mA(localg.sOH))) {
            v.e("MicroMsg.RecentPhotoTips.ImageQuery", "thumb file and orignal file both not exist");
          } else {
            localException.add(localg);
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract int bFQ();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/chat/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */