package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bj.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class ai
  extends j
  implements b
{
  public static final String[] gUn;
  private g hnp;
  
  static
  {
    GMTrace.i(13198971371520L, 98340);
    gUn = new String[] { "CREATE TABLE IF NOT EXISTS DeletedConversationInfo ( userName TEXT  PRIMARY KEY , lastSeq LONG  , reserved1 INT  , reserved2 LONG  , reserved3 TEXT  ) " };
    GMTrace.o(13198971371520L, 98340);
  }
  
  public ai(g paramg)
  {
    GMTrace.i(13198568718336L, 98337);
    this.hnp = paramg;
    GMTrace.o(13198568718336L, 98337);
  }
  
  public final long Ab(String paramString)
  {
    GMTrace.i(13198837153792L, 98339);
    if (bf.mA(paramString))
    {
      GMTrace.o(13198837153792L, 98339);
      return 0L;
    }
    Object localObject = "select lastSeq from DeletedConversationInfo where userName = \"" + bf.my(paramString) + "\"";
    localObject = this.hnp.a((String)localObject, null, 2);
    if (localObject == null)
    {
      v.e("MicroMsg.DeletedConversationInfoStorage", "getLastSeq failed " + paramString);
      GMTrace.o(13198837153792L, 98339);
      return 0L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      long l = ((Cursor)localObject).getLong(0);
      ((Cursor)localObject).close();
      GMTrace.o(13198837153792L, 98339);
      return l;
    }
    ((Cursor)localObject).close();
    GMTrace.o(13198837153792L, 98339);
    return 0L;
  }
  
  public final boolean v(String paramString, long paramLong)
  {
    GMTrace.i(13198702936064L, 98338);
    if (bf.mA(paramString))
    {
      GMTrace.o(13198702936064L, 98338);
      return false;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("userName", paramString);
    localContentValues.put("lastSeq", Long.valueOf(paramLong));
    if ((int)this.hnp.replace("DeletedConversationInfo", "userName", localContentValues) != -1)
    {
      Qq(paramString);
      GMTrace.o(13198702936064L, 98338);
      return true;
    }
    GMTrace.o(13198702936064L, 98338);
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */