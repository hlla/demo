package com.tencent.mm.av;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.cu;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public class j
  extends cu
{
  protected static c.a gTF;
  protected static Field[] hXn;
  
  static
  {
    GMTrace.i(1424050094080L, 10610);
    hXn = cu.u(j.class);
    c.a locala = new c.a();
    locala.hXn = new Field[11];
    locala.columns = new String[12];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "svrid";
    locala.uvr.put("svrid", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" svrid LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.uvq = "svrid";
    locala.columns[1] = "status";
    locala.uvr.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.uvr.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "scene";
    locala.uvr.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "createtime";
    locala.uvr.put("createtime", "LONG");
    localStringBuilder.append(" createtime LONG");
    localStringBuilder.append(", ");
    locala.columns[5] = "talker";
    locala.uvr.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "content";
    locala.uvr.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "sayhiuser";
    locala.uvr.put("sayhiuser", "TEXT");
    localStringBuilder.append(" sayhiuser TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "sayhicontent";
    locala.uvr.put("sayhicontent", "TEXT");
    localStringBuilder.append(" sayhicontent TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "imgpath";
    locala.uvr.put("imgpath", "TEXT");
    localStringBuilder.append(" imgpath TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "isSend";
    locala.uvr.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    locala.columns[11] = "rowid";
    locala.uvs = localStringBuilder.toString();
    gTF = locala;
    GMTrace.o(1424050094080L, 10610);
  }
  
  public j()
  {
    GMTrace.i(1423915876352L, 10609);
    GMTrace.o(1423915876352L, 10609);
  }
  
  protected final c.a sY()
  {
    GMTrace.i(1423781658624L, 10608);
    c.a locala = gTF;
    GMTrace.o(1423781658624L, 10608);
    return locala;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/av/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */