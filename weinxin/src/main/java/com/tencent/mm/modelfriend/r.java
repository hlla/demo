package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bf;

public final class r
  extends j
{
  public static final String[] gUn;
  private g hnp;
  
  static
  {
    GMTrace.i(4416568557568L, 32906);
    gUn = new String[] { "CREATE TABLE IF NOT EXISTS invitefriendopen ( username text  PRIMARY KEY , friendtype int  , updatetime int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) " };
    GMTrace.o(4416568557568L, 32906);
  }
  
  public r(g paramg)
  {
    GMTrace.i(4416165904384L, 32903);
    this.hnp = paramg;
    GMTrace.o(4416165904384L, 32903);
  }
  
  public final boolean a(q paramq)
  {
    GMTrace.i(4416300122112L, 32904);
    if (jk(paramq.getUsername()))
    {
      paramq.fRM = -1;
      ContentValues localContentValues = paramq.pv();
      if (this.hnp.update("invitefriendopen", localContentValues, "username=?", new String[] { paramq.getUsername() }) > 0)
      {
        GMTrace.o(4416300122112L, 32904);
        return true;
      }
      GMTrace.o(4416300122112L, 32904);
      return false;
    }
    paramq.fRM = -1;
    paramq = paramq.pv();
    if ((int)this.hnp.insert("invitefriendopen", "username", paramq) != -1)
    {
      GMTrace.o(4416300122112L, 32904);
      return true;
    }
    GMTrace.o(4416300122112L, 32904);
    return false;
  }
  
  public final boolean jk(String paramString)
  {
    GMTrace.i(4416434339840L, 32905);
    paramString = "select invitefriendopen.username,invitefriendopen.friendtype,invitefriendopen.updatetime,invitefriendopen.reserved1,invitefriendopen.reserved2,invitefriendopen.reserved3,invitefriendopen.reserved4 from invitefriendopen   where invitefriendopen.username = \"" + bf.my(paramString) + "\"";
    paramString = this.hnp.a(paramString, null, 2);
    boolean bool = paramString.moveToFirst();
    paramString.close();
    GMTrace.o(4416434339840L, 32905);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */