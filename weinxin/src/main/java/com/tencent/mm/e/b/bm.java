package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class bm
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gbN;
  private static final int gbV;
  private static final int gfy;
  private static final int gno;
  private static final int gnp;
  private static final int gnq;
  private static final int gnr;
  private static final int gsA;
  private static final int gsv;
  private static final int gsw;
  private static final int gsx;
  private static final int gsy;
  private static final int gsz;
  public String field_content;
  public long field_createTime;
  public int field_flag;
  public String field_fromUserName;
  public int field_msgSeq;
  public String field_msgSource;
  public long field_newMsgId;
  public long field_originSvrId;
  public int field_reserved1;
  public long field_reserved2;
  public String field_reserved3;
  public String field_reserved4;
  public String field_toUserName;
  private boolean gbr;
  private boolean gbz;
  private boolean gfw;
  private boolean gmR;
  private boolean gmS;
  private boolean gmT;
  private boolean gmU;
  private boolean gsp;
  private boolean gsq;
  private boolean gsr;
  private boolean gss;
  private boolean gst;
  private boolean gsu;
  
  static
  {
    GMTrace.i(4153904463872L, 30949);
    gaA = new String[0];
    gsv = "originSvrId".hashCode();
    gsw = "newMsgId".hashCode();
    gsx = "fromUserName".hashCode();
    gsy = "toUserName".hashCode();
    gbN = "createTime".hashCode();
    gbV = "content".hashCode();
    gsz = "msgSource".hashCode();
    gsA = "msgSeq".hashCode();
    gfy = "flag".hashCode();
    gno = "reserved1".hashCode();
    gnp = "reserved2".hashCode();
    gnq = "reserved3".hashCode();
    gnr = "reserved4".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4153904463872L, 30949);
  }
  
  public bm()
  {
    GMTrace.i(4153501810688L, 30946);
    this.gsp = true;
    this.gsq = true;
    this.gsr = true;
    this.gss = true;
    this.gbr = true;
    this.gbz = true;
    this.gst = true;
    this.gsu = true;
    this.gfw = true;
    this.gmR = true;
    this.gmS = true;
    this.gmT = true;
    this.gmU = true;
    GMTrace.o(4153501810688L, 30946);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4153636028416L, 30947);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4153636028416L, 30947);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gsv == k)
      {
        this.field_originSvrId = paramCursor.getLong(i);
        this.gsp = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gsw == k) {
          this.field_newMsgId = paramCursor.getLong(i);
        } else if (gsx == k) {
          this.field_fromUserName = paramCursor.getString(i);
        } else if (gsy == k) {
          this.field_toUserName = paramCursor.getString(i);
        } else if (gbN == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (gbV == k) {
          this.field_content = paramCursor.getString(i);
        } else if (gsz == k) {
          this.field_msgSource = paramCursor.getString(i);
        } else if (gsA == k) {
          this.field_msgSeq = paramCursor.getInt(i);
        } else if (gfy == k) {
          this.field_flag = paramCursor.getInt(i);
        } else if (gno == k) {
          this.field_reserved1 = paramCursor.getInt(i);
        } else if (gnp == k) {
          this.field_reserved2 = paramCursor.getLong(i);
        } else if (gnq == k) {
          this.field_reserved3 = paramCursor.getString(i);
        } else if (gnr == k) {
          this.field_reserved4 = paramCursor.getString(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4153636028416L, 30947);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4153770246144L, 30948);
    ContentValues localContentValues = new ContentValues();
    if (this.gsp) {
      localContentValues.put("originSvrId", Long.valueOf(this.field_originSvrId));
    }
    if (this.gsq) {
      localContentValues.put("newMsgId", Long.valueOf(this.field_newMsgId));
    }
    if (this.field_fromUserName == null) {
      this.field_fromUserName = "";
    }
    if (this.gsr) {
      localContentValues.put("fromUserName", this.field_fromUserName);
    }
    if (this.field_toUserName == null) {
      this.field_toUserName = "";
    }
    if (this.gss) {
      localContentValues.put("toUserName", this.field_toUserName);
    }
    if (this.gbr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.gbz) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_msgSource == null) {
      this.field_msgSource = "";
    }
    if (this.gst) {
      localContentValues.put("msgSource", this.field_msgSource);
    }
    if (this.gsu) {
      localContentValues.put("msgSeq", Integer.valueOf(this.field_msgSeq));
    }
    if (this.gfw) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.gmR) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.gmS) {
      localContentValues.put("reserved2", Long.valueOf(this.field_reserved2));
    }
    if (this.field_reserved3 == null) {
      this.field_reserved3 = "";
    }
    if (this.gmT) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if (this.field_reserved4 == null) {
      this.field_reserved4 = "";
    }
    if (this.gmU) {
      localContentValues.put("reserved4", this.field_reserved4);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4153770246144L, 30948);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */