package com.tencent.mm.ap;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bf;
import junit.framework.Assert;

public final class b
  extends j
{
  public static final String[] gUn;
  public g hnp;
  
  static
  {
    GMTrace.i(12936978366464L, 96388);
    gUn = new String[] { "CREATE TABLE IF NOT EXISTS chattingbginfo ( username text  PRIMARY KEY , bgflag int  , path text  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) " };
    GMTrace.o(12936978366464L, 96388);
  }
  
  public b(g paramg)
  {
    GMTrace.i(12936441495552L, 96384);
    this.hnp = paramg;
    GMTrace.o(12936441495552L, 96384);
  }
  
  public final boolean a(a parama)
  {
    GMTrace.i(12936575713280L, 96385);
    parama.fRM = -1;
    ContentValues localContentValues = parama.pv();
    if ((int)this.hnp.insert("chattingbginfo", "username", localContentValues) != -1)
    {
      Qq(parama.getUsername());
      GMTrace.o(12936575713280L, 96385);
      return true;
    }
    GMTrace.o(12936575713280L, 96385);
    return false;
  }
  
  public final boolean b(a parama)
  {
    GMTrace.i(12936709931008L, 96386);
    if (parama != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ContentValues localContentValues = parama.pv();
      if (localContentValues.size() <= 0) {
        break;
      }
      if (this.hnp.update("chattingbginfo", localContentValues, "username= ?", new String[] { parama.getUsername() }) <= 0) {
        break;
      }
      Qq(parama.getUsername());
      GMTrace.o(12936709931008L, 96386);
      return true;
    }
    GMTrace.o(12936709931008L, 96386);
    return false;
  }
  
  public final a jU(String paramString)
  {
    Object localObject = null;
    GMTrace.i(12936844148736L, 96387);
    paramString = "select chattingbginfo.username,chattingbginfo.bgflag,chattingbginfo.path,chattingbginfo.reserved1,chattingbginfo.reserved2,chattingbginfo.reserved3,chattingbginfo.reserved4 from chattingbginfo   where chattingbginfo.username = \"" + bf.my(paramString) + "\"";
    Cursor localCursor = this.hnp.a(paramString, null, 2);
    if (localCursor == null)
    {
      GMTrace.o(12936844148736L, 96387);
      return null;
    }
    paramString = (String)localObject;
    if (localCursor.moveToFirst())
    {
      paramString = new a();
      paramString.b(localCursor);
    }
    localCursor.close();
    GMTrace.o(12936844148736L, 96387);
    return paramString;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ap/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */