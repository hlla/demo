package com.tencent.mm.av;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.aw;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class f
  extends aw
{
  protected static c.a gTF;
  
  static
  {
    GMTrace.i(1422842134528L, 10601);
    c.a locala = new c.a();
    locala.hXn = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgContent";
    locala.uvr.put("msgContent", "TEXT default '' ");
    localStringBuilder.append(" msgContent TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[1] = "isSend";
    locala.uvr.put("isSend", "INTEGER default '0' ");
    localStringBuilder.append(" isSend INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "talker";
    locala.uvr.put("talker", "TEXT default '' ");
    localStringBuilder.append(" talker TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "encryptTalker";
    locala.uvr.put("encryptTalker", "TEXT default '' ");
    localStringBuilder.append(" encryptTalker TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "svrId";
    locala.uvr.put("svrId", "LONG default '0' ");
    localStringBuilder.append(" svrId LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "type";
    locala.uvr.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "createTime";
    locala.uvr.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "chatroomName";
    locala.uvr.put("chatroomName", "TEXT default '' ");
    localStringBuilder.append(" chatroomName TEXT default '' ");
    locala.columns[8] = "rowid";
    locala.uvs = localStringBuilder.toString();
    gTF = locala;
    GMTrace.o(1422842134528L, 10601);
  }
  
  public f()
  {
    GMTrace.i(1422439481344L, 10598);
    GMTrace.o(1422439481344L, 10598);
  }
  
  public final boolean Kq()
  {
    GMTrace.i(1422707916800L, 10600);
    if (this.field_isSend % 2 == 0)
    {
      GMTrace.o(1422707916800L, 10600);
      return true;
    }
    GMTrace.o(1422707916800L, 10600);
    return false;
  }
  
  protected final c.a sY()
  {
    GMTrace.i(1422573699072L, 10599);
    c.a locala = gTF;
    GMTrace.o(1422573699072L, 10599);
    return locala;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/av/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */