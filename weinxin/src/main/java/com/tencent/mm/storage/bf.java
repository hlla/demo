package com.tencent.mm.storage;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.dj;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class bf
  extends dj
{
  protected static c.a gTF;
  
  static
  {
    GMTrace.i(1568871022592L, 11689);
    c.a locala = new c.a();
    locala.hXn = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.uvr.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.uvq = "msgId";
    locala.columns[1] = "cmsgId";
    locala.uvr.put("cmsgId", "TEXT");
    localStringBuilder.append(" cmsgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "content";
    locala.uvr.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    locala.columns[3] = "rowid";
    locala.uvs = localStringBuilder.toString();
    gTF = locala;
    GMTrace.o(1568871022592L, 11689);
  }
  
  public bf()
  {
    GMTrace.i(1568602587136L, 11687);
    GMTrace.o(1568602587136L, 11687);
  }
  
  public final void RZ(String paramString)
  {
    GMTrace.i(14589601251328L, 108701);
    if (com.tencent.mm.sdk.platformtools.bf.mA(paramString))
    {
      GMTrace.o(14589601251328L, 108701);
      return;
    }
    this.field_cmsgId = paramString;
    GMTrace.o(14589601251328L, 108701);
  }
  
  protected final c.a sY()
  {
    GMTrace.i(1568736804864L, 11688);
    GMTrace.o(1568736804864L, 11688);
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */