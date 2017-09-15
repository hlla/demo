package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;

public final class be
  extends i<bd>
{
  public static final String[] gUn;
  public e gUp;
  
  static
  {
    GMTrace.i(1580682182656L, 11777);
    gUn = new String[] { i.a(bd.gTF, "UserOpenIdInApp") };
    GMTrace.o(1580682182656L, 11777);
  }
  
  public be(e parame)
  {
    super(parame, bd.gTF, "UserOpenIdInApp", null);
    GMTrace.i(1580145311744L, 11773);
    this.gUp = parame;
    parame.eE("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppAppIdUsernameIndex ON UserOpenIdInApp ( appId,username )");
    parame.eE("UserOpenIdInApp", "CREATE INDEX IF NOT EXISTS userOpenIdInAppOpenIdIndex ON UserOpenIdInApp ( openId )");
    GMTrace.o(1580145311744L, 11773);
  }
  
  public final bd RY(String paramString)
  {
    GMTrace.i(1580279529472L, 11774);
    if ((paramString == null) || (paramString.length() <= 0))
    {
      GMTrace.o(1580279529472L, 11774);
      return null;
    }
    Cursor localCursor = this.gUp.a("UserOpenIdInApp", null, "openId=?", new String[] { bf.my(paramString) }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      v.w("MicroMsg.scanner.UserOpenIdInAppStorage", "get null with openId:" + paramString);
      localCursor.close();
      GMTrace.o(1580279529472L, 11774);
      return null;
    }
    paramString = new bd();
    paramString.b(localCursor);
    localCursor.close();
    GMTrace.o(1580279529472L, 11774);
    return paramString;
  }
  
  public final boolean a(bd parambd)
  {
    GMTrace.i(1580413747200L, 11775);
    if ((parambd == null) || (bf.mA(parambd.field_appId)) || (bf.mA(parambd.field_openId)) || (bf.mA(parambd.field_username)))
    {
      v.w("MicroMsg.scanner.UserOpenIdInAppStorage", "wrong argument");
      GMTrace.o(1580413747200L, 11775);
      return false;
    }
    ContentValues localContentValues = parambd.pv();
    if (this.gUp.replace("UserOpenIdInApp", bd.gTF.uvq, localContentValues) > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      v.d("MicroMsg.scanner.UserOpenIdInAppStorage", "replace: appId=%s, username=%s, ret=%s ", new Object[] { parambd.field_appId, parambd.field_username, Boolean.valueOf(bool) });
      GMTrace.o(1580413747200L, 11775);
      return bool;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */