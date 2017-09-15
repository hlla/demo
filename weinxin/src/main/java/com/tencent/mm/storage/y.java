package com.tencent.mm.storage;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.ag;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class y
  extends ag
{
  protected static c.a gTF;
  
  static
  {
    GMTrace.i(13198434500608L, 98336);
    c.a locala = new c.a();
    locala.hXn = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.uvr.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.uvq = "username";
    locala.columns[1] = "cmdbuf";
    locala.uvr.put("cmdbuf", "BLOB default '' ");
    localStringBuilder.append(" cmdbuf BLOB default '' ");
    locala.columns[2] = "rowid";
    locala.uvs = localStringBuilder.toString();
    gTF = locala;
    GMTrace.o(13198434500608L, 98336);
  }
  
  public y()
  {
    GMTrace.i(13198166065152L, 98334);
    GMTrace.o(13198166065152L, 98334);
  }
  
  protected final c.a sY()
  {
    GMTrace.i(13198300282880L, 98335);
    c.a locala = gTF;
    GMTrace.o(13198300282880L, 98335);
    return locala;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */