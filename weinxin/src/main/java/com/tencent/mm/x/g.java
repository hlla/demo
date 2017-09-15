package com.tencent.mm.x;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bf;

public final class g
  extends j
{
  public static final String[] gUn;
  com.tencent.mm.bj.g hnp;
  
  static
  {
    GMTrace.i(394197467136L, 2937);
    gUn = new String[] { "CREATE TABLE IF NOT EXISTS hdheadimginfo ( username text  PRIMARY KEY , imgwidth int  , imgheigth int  , imgformat text  , totallen int  , startpos int  , headimgtype int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) " };
    GMTrace.o(394197467136L, 2937);
  }
  
  public g(com.tencent.mm.bj.g paramg)
  {
    GMTrace.i(393794813952L, 2934);
    this.hnp = paramg;
    GMTrace.o(393794813952L, 2934);
  }
  
  public final int a(String paramString, f paramf)
  {
    GMTrace.i(393929031680L, 2935);
    paramf = paramf.pv();
    int i = this.hnp.update("hdheadimginfo", paramf, "username=?", new String[] { paramString });
    GMTrace.o(393929031680L, 2935);
    return i;
  }
  
  public final f hr(String paramString)
  {
    Object localObject = null;
    GMTrace.i(394063249408L, 2936);
    paramString = "select hdheadimginfo.username,hdheadimginfo.imgwidth,hdheadimginfo.imgheigth,hdheadimginfo.imgformat,hdheadimginfo.totallen,hdheadimginfo.startpos,hdheadimginfo.headimgtype,hdheadimginfo.reserved1,hdheadimginfo.reserved2,hdheadimginfo.reserved3,hdheadimginfo.reserved4 from hdheadimginfo   where hdheadimginfo.username = \"" + bf.my(paramString) + "\"";
    Cursor localCursor = this.hnp.a(paramString, null, 2);
    if (localCursor == null)
    {
      GMTrace.o(394063249408L, 2936);
      return null;
    }
    paramString = (String)localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new f();
      paramString.username = localCursor.getString(0);
      paramString.hqY = localCursor.getInt(1);
      paramString.hqZ = localCursor.getInt(2);
      paramString.hra = localCursor.getString(3);
      paramString.hrb = localCursor.getInt(4);
      paramString.hrc = localCursor.getInt(5);
      paramString.hrd = localCursor.getInt(6);
      paramString.hre = localCursor.getString(7);
      paramString.hrf = localCursor.getString(8);
      paramString.hrg = localCursor.getInt(9);
      paramString.hrh = localCursor.getInt(10);
    }
    localCursor.close();
    GMTrace.o(394063249408L, 2936);
    return paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/x/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */