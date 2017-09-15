package com.tencent.mm.p;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.bh;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class d
  extends bh
{
  public static c.a gTF;
  
  static
  {
    GMTrace.i(4506628653056L, 33577);
    c.a locala = new c.a();
    locala.hXn = new Field[14];
    locala.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "cgi";
    locala.uvr.put("cgi", "TEXT");
    localStringBuilder.append(" cgi TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "cmdid";
    locala.uvr.put("cmdid", "INTEGER");
    localStringBuilder.append(" cmdid INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "functionmsgid";
    locala.uvr.put("functionmsgid", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" functionmsgid TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.uvq = "functionmsgid";
    locala.columns[3] = "version";
    locala.uvr.put("version", "LONG");
    localStringBuilder.append(" version LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "preVersion";
    locala.uvr.put("preVersion", "LONG");
    localStringBuilder.append(" preVersion LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "retryinterval";
    locala.uvr.put("retryinterval", "INTEGER");
    localStringBuilder.append(" retryinterval INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "reportid";
    locala.uvr.put("reportid", "INTEGER");
    localStringBuilder.append(" reportid INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "successkey";
    locala.uvr.put("successkey", "INTEGER");
    localStringBuilder.append(" successkey INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "failkey";
    locala.uvr.put("failkey", "INTEGER");
    localStringBuilder.append(" failkey INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "finalfailkey";
    locala.uvr.put("finalfailkey", "INTEGER");
    localStringBuilder.append(" finalfailkey INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "custombuff";
    locala.uvr.put("custombuff", "TEXT");
    localStringBuilder.append(" custombuff TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "addMsg";
    locala.uvr.put("addMsg", "BLOB");
    localStringBuilder.append(" addMsg BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "status";
    locala.uvr.put("status", "INTEGER default '-1' ");
    localStringBuilder.append(" status INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "needShow";
    locala.uvr.put("needShow", "INTEGER default 'false' ");
    localStringBuilder.append(" needShow INTEGER default 'false' ");
    locala.columns[14] = "rowid";
    locala.uvs = localStringBuilder.toString();
    gTF = locala;
    GMTrace.o(4506628653056L, 33577);
  }
  
  public d()
  {
    GMTrace.i(4506225999872L, 33574);
    GMTrace.o(4506225999872L, 33574);
  }
  
  public final void b(bu parambu)
  {
    GMTrace.i(4506494435328L, 33576);
    if (parambu != null) {
      this.field_addMsg = parambu;
    }
    GMTrace.o(4506494435328L, 33576);
  }
  
  protected final c.a sY()
  {
    GMTrace.i(4506360217600L, 33575);
    c.a locala = gTF;
    GMTrace.o(4506360217600L, 33575);
    return locala;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/p/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */