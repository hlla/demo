package com.tencent.mm.storage;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.q;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class i
  extends q
{
  protected static c.a gTF;
  
  static
  {
    GMTrace.i(17946520846336L, 133712);
    c.a locala = new c.a();
    locala.hXn = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "deviceId";
    locala.uvr.put("deviceId", "TEXT default '' ");
    localStringBuilder.append(" deviceId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[1] = "sessionName";
    locala.uvr.put("sessionName", "TEXT default '' ");
    localStringBuilder.append(" sessionName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "moveTime";
    locala.uvr.put("moveTime", "BLOB default '' ");
    localStringBuilder.append(" moveTime BLOB default '' ");
    locala.columns[3] = "rowid";
    locala.uvs = localStringBuilder.toString();
    gTF = locala;
    GMTrace.o(17946520846336L, 133712);
  }
  
  public i()
  {
    GMTrace.i(17946252410880L, 133710);
    GMTrace.o(17946252410880L, 133710);
  }
  
  protected final c.a sY()
  {
    GMTrace.i(17946386628608L, 133711);
    c.a locala = gTF;
    GMTrace.o(17946386628608L, 133711);
    return locala;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */