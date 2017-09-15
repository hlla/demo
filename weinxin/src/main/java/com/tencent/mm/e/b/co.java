package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;

public abstract class co
  extends c
{
  public static final String[] gaA;
  private static final int gaI;
  private static final int gaJ;
  private static final int gaP;
  private static final int gbQ;
  private static final int gft;
  private static final int gnK;
  private static final int gpd;
  private static final int gpz;
  private static final int gzJ;
  private static final int gzK;
  private static final int gzL;
  public ru field_dataProto;
  public String field_desc;
  public String field_favFrom;
  public int field_localId;
  public long field_msgId;
  public long field_oriMsgId;
  public int field_status;
  public String field_title;
  public String field_toUser;
  public int field_type;
  private boolean gaE;
  private boolean gaM;
  private boolean gbu;
  private boolean gfp;
  private boolean gnG;
  private boolean gpb;
  private boolean gpl;
  private boolean gzG;
  private boolean gzH;
  private boolean gzI;
  
  static
  {
    GMTrace.i(4134040240128L, 30801);
    gaA = new String[0];
    gpd = "localId".hashCode();
    gaI = "msgId".hashCode();
    gzJ = "oriMsgId".hashCode();
    gpz = "toUser".hashCode();
    gft = "title".hashCode();
    gnK = "desc".hashCode();
    gzK = "dataProto".hashCode();
    gbQ = "type".hashCode();
    gaP = "status".hashCode();
    gzL = "favFrom".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4134040240128L, 30801);
  }
  
  public co()
  {
    GMTrace.i(4133637586944L, 30798);
    this.gpb = true;
    this.gaE = true;
    this.gzG = true;
    this.gpl = true;
    this.gfp = true;
    this.gnG = true;
    this.gzH = true;
    this.gbu = true;
    this.gaM = true;
    this.gzI = true;
    GMTrace.o(4133637586944L, 30798);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4133771804672L, 30799);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4133771804672L, 30799);
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gpd == k)
      {
        this.field_localId = paramCursor.getInt(i);
        this.gpb = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gaI == k) {
          this.field_msgId = paramCursor.getLong(i);
        } else if (gzJ == k) {
          this.field_oriMsgId = paramCursor.getLong(i);
        } else if (gpz == k) {
          this.field_toUser = paramCursor.getString(i);
        } else if (gft == k) {
          this.field_title = paramCursor.getString(i);
        } else if (gnK == k) {
          this.field_desc = paramCursor.getString(i);
        } else if (gzK == k) {
          try
          {
            byte[] arrayOfByte = paramCursor.getBlob(i);
            if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
              continue;
            }
            this.field_dataProto = ((ru)new ru().aD(arrayOfByte));
          }
          catch (IOException localIOException)
          {
            v.e("MicroMsg.SDK.BaseRecordMessageInfo", localIOException.getMessage());
          }
        } else if (gbQ == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (gaP == k) {
          this.field_status = paramCursor.getInt(i);
        } else if (gzL == k) {
          this.field_favFrom = paramCursor.getString(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4133771804672L, 30799);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4133906022400L, 30800);
    ContentValues localContentValues = new ContentValues();
    if (this.gpb) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.gaE) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.gzG) {
      localContentValues.put("oriMsgId", Long.valueOf(this.field_oriMsgId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.gpl) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.gfp) {
      localContentValues.put("title", this.field_title);
    }
    if (this.gnG) {
      localContentValues.put("desc", this.field_desc);
    }
    if ((this.gzH) && (this.field_dataProto != null)) {}
    try
    {
      localContentValues.put("dataProto", this.field_dataProto.toByteArray());
      if (this.gbu) {
        localContentValues.put("type", Integer.valueOf(this.field_type));
      }
      if (this.gaM) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.gzI) {
        localContentValues.put("favFrom", this.field_favFrom);
      }
      if (this.uvp > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.uvp));
      }
      GMTrace.o(4133906022400L, 30800);
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        v.e("MicroMsg.SDK.BaseRecordMessageInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */