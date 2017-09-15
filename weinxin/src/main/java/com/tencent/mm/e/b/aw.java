package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class aw
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gbN;
  private static final int gbQ;
  private static final int ggh;
  private static final int goM;
  private static final int goN;
  private static final int goO;
  private static final int got;
  private static final int gou;
  public String field_chatroomName;
  public long field_createTime;
  public String field_encryptTalker;
  public int field_isSend;
  public String field_msgContent;
  public long field_svrId;
  public String field_talker;
  public int field_type;
  private boolean gbr;
  private boolean gbu;
  private boolean gfT;
  private boolean goJ;
  private boolean goK;
  private boolean goL;
  private boolean god;
  private boolean goe;
  
  static
  {
    GMTrace.i(4141422215168L, 30856);
    gaA = new String[0];
    goM = "msgContent".hashCode();
    ggh = "isSend".hashCode();
    got = "talker".hashCode();
    gou = "encryptTalker".hashCode();
    goN = "svrId".hashCode();
    gbQ = "type".hashCode();
    gbN = "createTime".hashCode();
    goO = "chatroomName".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4141422215168L, 30856);
  }
  
  public aw()
  {
    GMTrace.i(4141019561984L, 30853);
    this.goJ = true;
    this.gfT = true;
    this.god = true;
    this.goe = true;
    this.goK = true;
    this.gbu = true;
    this.gbr = true;
    this.goL = true;
    GMTrace.o(4141019561984L, 30853);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4141153779712L, 30854);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4141153779712L, 30854);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (goM == k) {
        this.field_msgContent = paramCursor.getString(i);
      }
      for (;;)
      {
        i += 1;
        break;
        if (ggh == k) {
          this.field_isSend = paramCursor.getInt(i);
        } else if (got == k) {
          this.field_talker = paramCursor.getString(i);
        } else if (gou == k) {
          this.field_encryptTalker = paramCursor.getString(i);
        } else if (goN == k) {
          this.field_svrId = paramCursor.getLong(i);
        } else if (gbQ == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (gbN == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (goO == k) {
          this.field_chatroomName = paramCursor.getString(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4141153779712L, 30854);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4141287997440L, 30855);
    ContentValues localContentValues = new ContentValues();
    if (this.field_msgContent == null) {
      this.field_msgContent = "";
    }
    if (this.goJ) {
      localContentValues.put("msgContent", this.field_msgContent);
    }
    if (this.gfT) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.god) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_encryptTalker == null) {
      this.field_encryptTalker = "";
    }
    if (this.goe) {
      localContentValues.put("encryptTalker", this.field_encryptTalker);
    }
    if (this.goK) {
      localContentValues.put("svrId", Long.valueOf(this.field_svrId));
    }
    if (this.gbu) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.gbr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.field_chatroomName == null) {
      this.field_chatroomName = "";
    }
    if (this.goL) {
      localContentValues.put("chatroomName", this.field_chatroomName);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4141287997440L, 30855);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */