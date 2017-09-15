package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class t
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gaP;
  private static final int gbV;
  private static final int gfW;
  private static final int gfX;
  private static final int gfY;
  private static final int gfZ;
  private static final int gfy;
  private static final int gga;
  private static final int ggb;
  private static final int ggc;
  private static final int ggd;
  private static final int gge;
  private static final int ggf;
  private static final int ggg;
  private static final int ggh;
  private static final int ggi;
  private static final int ggj;
  public int field_atCount;
  public long field_bizChatId;
  public String field_brandUserName;
  public int field_chatType;
  public String field_content;
  public String field_digest;
  public String field_digestUser;
  public String field_editingMsg;
  public long field_flag;
  public int field_isSend;
  public long field_lastMsgID;
  public long field_lastMsgTime;
  public int field_msgCount;
  public String field_msgType;
  public int field_newUnReadCount;
  public int field_status;
  public int field_unReadCount;
  private boolean gaM;
  private boolean gbz;
  private boolean gfI;
  private boolean gfJ;
  private boolean gfK;
  private boolean gfL;
  private boolean gfM;
  private boolean gfN;
  private boolean gfO;
  private boolean gfP;
  private boolean gfQ;
  private boolean gfR;
  private boolean gfS;
  private boolean gfT;
  private boolean gfU;
  private boolean gfV;
  private boolean gfw;
  
  static
  {
    GMTrace.i(4149609496576L, 30917);
    gaA = new String[0];
    gfW = "bizChatId".hashCode();
    gfX = "brandUserName".hashCode();
    gfY = "unReadCount".hashCode();
    gfZ = "newUnReadCount".hashCode();
    gga = "lastMsgID".hashCode();
    ggb = "lastMsgTime".hashCode();
    gbV = "content".hashCode();
    ggc = "digest".hashCode();
    ggd = "digestUser".hashCode();
    gge = "atCount".hashCode();
    ggf = "editingMsg".hashCode();
    ggg = "chatType".hashCode();
    gaP = "status".hashCode();
    ggh = "isSend".hashCode();
    ggi = "msgType".hashCode();
    ggj = "msgCount".hashCode();
    gfy = "flag".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4149609496576L, 30917);
  }
  
  public t()
  {
    GMTrace.i(4149206843392L, 30914);
    this.gfI = true;
    this.gfJ = true;
    this.gfK = true;
    this.gfL = true;
    this.gfM = true;
    this.gfN = true;
    this.gbz = true;
    this.gfO = true;
    this.gfP = true;
    this.gfQ = true;
    this.gfR = true;
    this.gfS = true;
    this.gaM = true;
    this.gfT = true;
    this.gfU = true;
    this.gfV = true;
    this.gfw = true;
    GMTrace.o(4149206843392L, 30914);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4149341061120L, 30915);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4149341061120L, 30915);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gfW == k)
      {
        this.field_bizChatId = paramCursor.getLong(i);
        this.gfI = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gfX == k) {
          this.field_brandUserName = paramCursor.getString(i);
        } else if (gfY == k) {
          this.field_unReadCount = paramCursor.getInt(i);
        } else if (gfZ == k) {
          this.field_newUnReadCount = paramCursor.getInt(i);
        } else if (gga == k) {
          this.field_lastMsgID = paramCursor.getLong(i);
        } else if (ggb == k) {
          this.field_lastMsgTime = paramCursor.getLong(i);
        } else if (gbV == k) {
          this.field_content = paramCursor.getString(i);
        } else if (ggc == k) {
          this.field_digest = paramCursor.getString(i);
        } else if (ggd == k) {
          this.field_digestUser = paramCursor.getString(i);
        } else if (gge == k) {
          this.field_atCount = paramCursor.getInt(i);
        } else if (ggf == k) {
          this.field_editingMsg = paramCursor.getString(i);
        } else if (ggg == k) {
          this.field_chatType = paramCursor.getInt(i);
        } else if (gaP == k) {
          this.field_status = paramCursor.getInt(i);
        } else if (ggh == k) {
          this.field_isSend = paramCursor.getInt(i);
        } else if (ggi == k) {
          this.field_msgType = paramCursor.getString(i);
        } else if (ggj == k) {
          this.field_msgCount = paramCursor.getInt(i);
        } else if (gfy == k) {
          this.field_flag = paramCursor.getLong(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4149341061120L, 30915);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4149475278848L, 30916);
    ContentValues localContentValues = new ContentValues();
    if (this.gfI) {
      localContentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
    }
    if (this.gfJ) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.gfK) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.gfL) {
      localContentValues.put("newUnReadCount", Integer.valueOf(this.field_newUnReadCount));
    }
    if (this.gfM) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.gfN) {
      localContentValues.put("lastMsgTime", Long.valueOf(this.field_lastMsgTime));
    }
    if (this.gbz) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.gfO) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.gfP) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.gfQ) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.gfR) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.gfS) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.gaM) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.gfT) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.field_msgType == null) {
      this.field_msgType = "";
    }
    if (this.gfU) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.gfV) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.gfw) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4149475278848L, 30916);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */