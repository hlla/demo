package com.tencent.mm.plugin.downloader.b;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class b
  extends i<a>
{
  public static final String[] gUn;
  
  static
  {
    GMTrace.i(18591571247104L, 138518);
    gUn = new String[] { i.a(a.gTF, "FileDownloadInfo"), "CREATE INDEX IF NOT EXISTS filedownloadinfo_appId  on FileDownloadInfo  (  appId )", "CREATE INDEX IF NOT EXISTS filedownloadinfo_status  on FileDownloadInfo  (  status )" };
    GMTrace.o(18591571247104L, 138518);
  }
  
  public b(e parame)
  {
    super(parame, a.gTF, "FileDownloadInfo", null);
    GMTrace.i(18590900158464L, 138513);
    GMTrace.o(18590900158464L, 138513);
  }
  
  public static String r(ArrayList<String> paramArrayList)
  {
    GMTrace.i(18591168593920L, 138515);
    if (bf.bV(paramArrayList))
    {
      GMTrace.o(18591168593920L, 138515);
      return "1=1";
    }
    String str = "";
    int i = 0;
    while (i < paramArrayList.size() - 1)
    {
      str = str + "appId=\"" + (String)paramArrayList.get(i) + "\" or ";
      i += 1;
    }
    paramArrayList = str + "appId=\"" + (String)paramArrayList.get(paramArrayList.size() - 1) + "\"";
    GMTrace.o(18591168593920L, 138515);
    return paramArrayList;
  }
  
  public final boolean akM()
  {
    GMTrace.i(18591437029376L, 138517);
    boolean bool = eE("FileDownloadInfo", "delete from FileDownloadInfo");
    GMTrace.o(18591437029376L, 138517);
    return bool;
  }
  
  public final a bh(long paramLong)
  {
    a locala = null;
    GMTrace.i(18591302811648L, 138516);
    if (paramLong < 0L)
    {
      v.e("MicroMsg.FileDownloadInfoStorage", "download id is not avaiable");
      GMTrace.o(18591302811648L, 138516);
      return null;
    }
    Cursor localCursor = rawQuery("select * from FileDownloadInfo where downloadId=" + paramLong, new String[0]);
    if (localCursor == null)
    {
      GMTrace.o(18591302811648L, 138516);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      locala = new a();
      locala.b(localCursor);
    }
    if (localCursor != null) {
      localCursor.close();
    }
    GMTrace.o(18591302811648L, 138516);
    return locala;
  }
  
  public final a tA(String paramString)
  {
    Object localObject = null;
    GMTrace.i(18591034376192L, 138514);
    if (bf.mA(paramString))
    {
      v.e("MicroMsg.FileDownloadInfoStorage", "appId is null");
      GMTrace.o(18591034376192L, 138514);
      return null;
    }
    Cursor localCursor = rawQuery("select * from FileDownloadInfo where appId=\"" + paramString + "\"", new String[0]);
    if (localCursor == null)
    {
      GMTrace.o(18591034376192L, 138514);
      return null;
    }
    paramString = (String)localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new a();
      paramString.b(localCursor);
    }
    if (localCursor != null) {
      localCursor.close();
    }
    GMTrace.o(18591034376192L, 138514);
    return paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/downloader/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */