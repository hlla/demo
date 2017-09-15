package com.tencent.mm.storage;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.d;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.u.c.a;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;

public final class c
  extends d
  implements Serializable
{
  protected static c.a gTF;
  private Map<String, String> uxd;
  
  static
  {
    GMTrace.i(1580011094016L, 11772);
    c.a locala = new c.a();
    locala.hXn = new Field[9];
    locala.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "layerId";
    locala.uvr.put("layerId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" layerId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.uvq = "layerId";
    locala.columns[1] = "business";
    locala.uvr.put("business", "TEXT");
    localStringBuilder.append(" business TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "expId";
    locala.uvr.put("expId", "TEXT");
    localStringBuilder.append(" expId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "sequence";
    locala.uvr.put("sequence", "LONG");
    localStringBuilder.append(" sequence LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "prioritylevel";
    locala.uvr.put("prioritylevel", "INTEGER default '0' ");
    localStringBuilder.append(" prioritylevel INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "startTime";
    locala.uvr.put("startTime", "LONG");
    localStringBuilder.append(" startTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "endTime";
    locala.uvr.put("endTime", "LONG");
    localStringBuilder.append(" endTime LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "needReport";
    locala.uvr.put("needReport", "INTEGER");
    localStringBuilder.append(" needReport INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "rawXML";
    locala.uvr.put("rawXML", "TEXT default '' ");
    localStringBuilder.append(" rawXML TEXT default '' ");
    locala.columns[9] = "rowid";
    locala.uvs = localStringBuilder.toString();
    gTF = locala;
    GMTrace.o(1580011094016L, 11772);
  }
  
  public c()
  {
    GMTrace.i(1579474223104L, 11768);
    this.uxd = null;
    GMTrace.o(1579474223104L, 11768);
  }
  
  public final Map<String, String> bKA()
  {
    GMTrace.i(1579876876288L, 11771);
    if (this.uxd == null) {
      this.uxd = a.gD(this.field_rawXML);
    }
    Map localMap = this.uxd;
    GMTrace.o(1579876876288L, 11771);
    return localMap;
  }
  
  public final boolean isValid()
  {
    GMTrace.i(1579742658560L, 11770);
    long l = bf.Nz();
    if ((l >= this.field_startTime) && (l <= this.field_endTime))
    {
      GMTrace.o(1579742658560L, 11770);
      return true;
    }
    GMTrace.o(1579742658560L, 11770);
    return false;
  }
  
  protected final c.a sY()
  {
    GMTrace.i(1579608440832L, 11769);
    c.a locala = gTF;
    GMTrace.o(1579608440832L, 11769);
    return locala;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */