package com.tencent.mm.plugin.record.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.co;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class k
  extends co
  implements f.a
{
  protected static c.a gTF;
  
  static
  {
    GMTrace.i(7505992220672L, 55924);
    c.a locala = new c.a();
    locala.hXn = new Field[10];
    locala.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.uvr.put("localId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" localId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.uvq = "localId";
    locala.columns[1] = "msgId";
    locala.uvr.put("msgId", "LONG default '-1' ");
    localStringBuilder.append(" msgId LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "oriMsgId";
    locala.uvr.put("oriMsgId", "LONG default '-1' ");
    localStringBuilder.append(" oriMsgId LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "toUser";
    locala.uvr.put("toUser", "TEXT default '' ");
    localStringBuilder.append(" toUser TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "title";
    locala.uvr.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "desc";
    locala.uvr.put("desc", "TEXT");
    localStringBuilder.append(" desc TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "dataProto";
    locala.uvr.put("dataProto", "BLOB");
    localStringBuilder.append(" dataProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[7] = "type";
    locala.uvr.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "status";
    locala.uvr.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "favFrom";
    locala.uvr.put("favFrom", "TEXT");
    localStringBuilder.append(" favFrom TEXT");
    locala.columns[10] = "rowid";
    locala.uvs = localStringBuilder.toString();
    gTF = locala;
    GMTrace.o(7505992220672L, 55924);
  }
  
  public k()
  {
    GMTrace.i(7505589567488L, 55921);
    GMTrace.o(7505589567488L, 55921);
  }
  
  public final int aWv()
  {
    GMTrace.i(7505858002944L, 55923);
    int i = this.field_localId;
    GMTrace.o(7505858002944L, 55923);
    return i;
  }
  
  protected final c.a sY()
  {
    GMTrace.i(7505723785216L, 55922);
    c.a locala = gTF;
    GMTrace.o(7505723785216L, 55922);
    return locala;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/record/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */