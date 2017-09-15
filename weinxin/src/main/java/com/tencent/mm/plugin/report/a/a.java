package com.tencent.mm.plugin.report.a;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.al;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class a
  extends al
{
  protected static c.a gTF;
  
  static
  {
    GMTrace.i(13108777058304L, 97668);
    c.a locala = new c.a();
    locala.hXn = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "bakLogId";
    locala.uvr.put("bakLogId", "INTEGER");
    localStringBuilder.append(" bakLogId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[1] = "valueStr";
    locala.uvr.put("valueStr", "TEXT");
    localStringBuilder.append(" valueStr TEXT");
    locala.columns[2] = "rowid";
    locala.uvs = localStringBuilder.toString();
    gTF = locala;
    GMTrace.o(13108777058304L, 97668);
  }
  
  protected final c.a sY()
  {
    GMTrace.i(13108642840576L, 97667);
    c.a locala = gTF;
    GMTrace.o(13108642840576L, 97667);
    return locala;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/report/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */