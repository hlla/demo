package com.tencent.mm.storage;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.s;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class m
  extends s
{
  protected static c.a gTF;
  
  static
  {
    GMTrace.i(17946923499520L, 133715);
    c.a locala = new c.a();
    locala.hXn = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "sessionName";
    locala.uvr.put("sessionName", "TEXT default '' ");
    localStringBuilder.append(" sessionName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[1] = "startTime";
    locala.uvr.put("startTime", "LONG default '0' ");
    localStringBuilder.append(" startTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "endTime";
    locala.uvr.put("endTime", "LONG default '0' ");
    localStringBuilder.append(" endTime LONG default '0' ");
    locala.columns[3] = "rowid";
    locala.uvs = localStringBuilder.toString();
    gTF = locala;
    GMTrace.o(17946923499520L, 133715);
  }
  
  public m()
  {
    GMTrace.i(17946655064064L, 133713);
    GMTrace.o(17946655064064L, 133713);
  }
  
  protected final c.a sY()
  {
    GMTrace.i(17946789281792L, 133714);
    c.a locala = gTF;
    GMTrace.o(17946789281792L, 133714);
    return locala;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */