package com.tencent.mm.modelbiz.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.v;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class f
  extends v
{
  protected static c.a gTF;
  
  static
  {
    GMTrace.i(4564073840640L, 34005);
    c.a locala = new c.a();
    locala.hXn = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "brandUserName";
    locala.uvr.put("brandUserName", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" brandUserName TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.uvq = "brandUserName";
    locala.columns[1] = "userId";
    locala.uvr.put("userId", "TEXT");
    localStringBuilder.append(" userId TEXT");
    locala.columns[2] = "rowid";
    locala.uvs = localStringBuilder.toString();
    gTF = locala;
    GMTrace.o(4564073840640L, 34005);
  }
  
  public f()
  {
    GMTrace.i(4563805405184L, 34003);
    GMTrace.o(4563805405184L, 34003);
  }
  
  protected final c.a sY()
  {
    GMTrace.i(4563939622912L, 34004);
    c.a locala = gTF;
    GMTrace.o(4563939622912L, 34004);
    return locala;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelbiz/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */