package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.v;
import junit.framework.Assert;

public final class ac
  extends j
{
  public static final String[] gUn;
  public final g hnp;
  
  static
  {
    GMTrace.i(4428513935360L, 32995);
    gUn = new String[] { "CREATE TABLE IF NOT EXISTS qqgroup ( grouopid int PRIMARY KEY,membernum int,weixinnum int,insert_time int,lastupdate_time int,needupdate int,updatekey text,groupname text,reserved1 text ,reserved2 text ,reserved3 int ,reserved4 int )" };
    GMTrace.o(4428513935360L, 32995);
  }
  
  public ac(g paramg)
  {
    GMTrace.i(4428111282176L, 32992);
    this.hnp = paramg;
    GMTrace.o(4428111282176L, 32992);
  }
  
  public final boolean a(ab paramab)
  {
    GMTrace.i(4428379717632L, 32994);
    if (paramab != null) {}
    ContentValues localContentValues;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      localContentValues = paramab.FM();
      if (localContentValues.size() > 0) {
        break;
      }
      v.e("MicroMsg.QQGroupStorage", "update failed, no values set");
      GMTrace.o(4428379717632L, 32994);
      return false;
    }
    if (this.hnp.update("qqgroup", localContentValues, "grouopid= ?", new String[] { paramab.hBB }) <= 0)
    {
      GMTrace.o(4428379717632L, 32994);
      return false;
    }
    doNotify();
    GMTrace.o(4428379717632L, 32994);
    return true;
  }
  
  public final ab fI(int paramInt)
  {
    ab localab = null;
    GMTrace.i(4428245499904L, 32993);
    Cursor localCursor = this.hnp.a("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup  where grouopid = " + paramInt, null, 2);
    if (localCursor == null)
    {
      GMTrace.o(4428245499904L, 32993);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localab = new ab();
      localab.b(localCursor);
    }
    localCursor.close();
    GMTrace.o(4428245499904L, 32993);
    return localab;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */