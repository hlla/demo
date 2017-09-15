package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class cu
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gaP;
  private static final int gbQ;
  private static final int gbV;
  private static final int gci;
  private static final int ggh;
  private static final int gnj;
  private static final int got;
  private static final int guQ;
  private static final int guR;
  private static final int guS;
  private static final int guT;
  public String field_content;
  public long field_createtime;
  public String field_imgpath;
  public int field_isSend;
  public String field_sayhicontent;
  public String field_sayhiuser;
  public int field_scene;
  public int field_status;
  public long field_svrid;
  public String field_talker;
  public int field_type;
  private boolean gaM;
  private boolean gbu;
  private boolean gbz;
  private boolean gcg;
  private boolean gfT;
  private boolean gmM;
  private boolean god;
  private boolean guL;
  private boolean guM;
  private boolean guN;
  private boolean guO;
  
  static
  {
    GMTrace.i(4152830722048L, 30941);
    gaA = new String[0];
    gnj = "svrid".hashCode();
    gaP = "status".hashCode();
    gbQ = "type".hashCode();
    gci = "scene".hashCode();
    guQ = "createtime".hashCode();
    got = "talker".hashCode();
    gbV = "content".hashCode();
    guR = "sayhiuser".hashCode();
    guS = "sayhicontent".hashCode();
    guT = "imgpath".hashCode();
    ggh = "isSend".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4152830722048L, 30941);
  }
  
  public cu()
  {
    GMTrace.i(4152428068864L, 30938);
    this.gmM = true;
    this.gaM = true;
    this.gbu = true;
    this.gcg = true;
    this.guL = true;
    this.god = true;
    this.gbz = true;
    this.guM = true;
    this.guN = true;
    this.guO = true;
    this.gfT = true;
    GMTrace.o(4152428068864L, 30938);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4152562286592L, 30939);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4152562286592L, 30939);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gnj == k)
      {
        this.field_svrid = paramCursor.getLong(i);
        this.gmM = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gaP == k) {
          this.field_status = paramCursor.getInt(i);
        } else if (gbQ == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (gci == k) {
          this.field_scene = paramCursor.getInt(i);
        } else if (guQ == k) {
          this.field_createtime = paramCursor.getLong(i);
        } else if (got == k) {
          this.field_talker = paramCursor.getString(i);
        } else if (gbV == k) {
          this.field_content = paramCursor.getString(i);
        } else if (guR == k) {
          this.field_sayhiuser = paramCursor.getString(i);
        } else if (guS == k) {
          this.field_sayhicontent = paramCursor.getString(i);
        } else if (guT == k) {
          this.field_imgpath = paramCursor.getString(i);
        } else if (ggh == k) {
          this.field_isSend = paramCursor.getInt(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4152562286592L, 30939);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4152696504320L, 30940);
    ContentValues localContentValues = new ContentValues();
    if (this.gmM) {
      localContentValues.put("svrid", Long.valueOf(this.field_svrid));
    }
    if (this.gaM) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.gbu) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.gcg) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.guL) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.god) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.gbz) {
      localContentValues.put("content", this.field_content);
    }
    if (this.guM) {
      localContentValues.put("sayhiuser", this.field_sayhiuser);
    }
    if (this.guN) {
      localContentValues.put("sayhicontent", this.field_sayhicontent);
    }
    if (this.guO) {
      localContentValues.put("imgpath", this.field_imgpath);
    }
    if (this.gfT) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4152696504320L, 30940);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */