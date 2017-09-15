package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class di
  extends c
{
  private static final int gEo;
  private static final int gEp;
  private static final int gEq;
  private static final int gEr;
  private static final int gEs;
  private static final int gEt;
  private static final int gEu;
  private static final int gEv;
  private static final int gEw;
  private static final int gEx;
  private static final int gEy;
  private static final int gEz;
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gaP;
  private static final int gcH;
  private static final int gno;
  private static final int gnp;
  private static final int guQ;
  public String field_clientid;
  public long field_createtime;
  public String field_filename;
  public int field_filenowsize;
  public String field_human;
  public long field_lastmodifytime;
  public long field_msgid;
  public int field_msglocalid;
  public int field_nettimes;
  public int field_offset;
  public int field_reserved1;
  public String field_reserved2;
  public int field_status;
  public int field_totallen;
  public String field_user;
  public int field_voiceformat;
  public int field_voicelenght;
  private boolean gEc;
  private boolean gEd;
  private boolean gEe;
  private boolean gEf;
  private boolean gEg;
  private boolean gEh;
  private boolean gEi;
  private boolean gEj;
  private boolean gEk;
  private boolean gEl;
  private boolean gEm;
  private boolean gEn;
  private boolean gaM;
  private boolean gcq;
  private boolean gmR;
  private boolean gmS;
  private boolean guL;
  
  static
  {
    GMTrace.i(4168936849408L, 31061);
    gaA = new String[] { "CREATE INDEX IF NOT EXISTS voiceRemindFileNameIndex ON VoiceRemindInfo(filename)" };
    gEo = "filename".hashCode();
    gEp = "user".hashCode();
    gEq = "msgid".hashCode();
    gcH = "offset".hashCode();
    gEr = "filenowsize".hashCode();
    gEs = "totallen".hashCode();
    gaP = "status".hashCode();
    guQ = "createtime".hashCode();
    gEt = "lastmodifytime".hashCode();
    gEu = "clientid".hashCode();
    gEv = "voicelenght".hashCode();
    gEw = "msglocalid".hashCode();
    gEx = "human".hashCode();
    gEy = "voiceformat".hashCode();
    gEz = "nettimes".hashCode();
    gno = "reserved1".hashCode();
    gnp = "reserved2".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4168936849408L, 31061);
  }
  
  public di()
  {
    GMTrace.i(4168534196224L, 31058);
    this.gEc = true;
    this.gEd = true;
    this.gEe = true;
    this.gcq = true;
    this.gEf = true;
    this.gEg = true;
    this.gaM = true;
    this.guL = true;
    this.gEh = true;
    this.gEi = true;
    this.gEj = true;
    this.gEk = true;
    this.gEl = true;
    this.gEm = true;
    this.gEn = true;
    this.gmR = true;
    this.gmS = true;
    GMTrace.o(4168534196224L, 31058);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4168668413952L, 31059);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4168668413952L, 31059);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gEo == k) {
        this.field_filename = paramCursor.getString(i);
      }
      for (;;)
      {
        i += 1;
        break;
        if (gEp == k) {
          this.field_user = paramCursor.getString(i);
        } else if (gEq == k) {
          this.field_msgid = paramCursor.getLong(i);
        } else if (gcH == k) {
          this.field_offset = paramCursor.getInt(i);
        } else if (gEr == k) {
          this.field_filenowsize = paramCursor.getInt(i);
        } else if (gEs == k) {
          this.field_totallen = paramCursor.getInt(i);
        } else if (gaP == k) {
          this.field_status = paramCursor.getInt(i);
        } else if (guQ == k) {
          this.field_createtime = paramCursor.getLong(i);
        } else if (gEt == k) {
          this.field_lastmodifytime = paramCursor.getLong(i);
        } else if (gEu == k) {
          this.field_clientid = paramCursor.getString(i);
        } else if (gEv == k) {
          this.field_voicelenght = paramCursor.getInt(i);
        } else if (gEw == k) {
          this.field_msglocalid = paramCursor.getInt(i);
        } else if (gEx == k) {
          this.field_human = paramCursor.getString(i);
        } else if (gEy == k) {
          this.field_voiceformat = paramCursor.getInt(i);
        } else if (gEz == k) {
          this.field_nettimes = paramCursor.getInt(i);
        } else if (gno == k) {
          this.field_reserved1 = paramCursor.getInt(i);
        } else if (gnp == k) {
          this.field_reserved2 = paramCursor.getString(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4168668413952L, 31059);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4168802631680L, 31060);
    ContentValues localContentValues = new ContentValues();
    if (this.gEc) {
      localContentValues.put("filename", this.field_filename);
    }
    if (this.gEd) {
      localContentValues.put("user", this.field_user);
    }
    if (this.gEe) {
      localContentValues.put("msgid", Long.valueOf(this.field_msgid));
    }
    if (this.gcq) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.gEf) {
      localContentValues.put("filenowsize", Integer.valueOf(this.field_filenowsize));
    }
    if (this.gEg) {
      localContentValues.put("totallen", Integer.valueOf(this.field_totallen));
    }
    if (this.gaM) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.guL) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.gEh) {
      localContentValues.put("lastmodifytime", Long.valueOf(this.field_lastmodifytime));
    }
    if (this.gEi) {
      localContentValues.put("clientid", this.field_clientid);
    }
    if (this.gEj) {
      localContentValues.put("voicelenght", Integer.valueOf(this.field_voicelenght));
    }
    if (this.gEk) {
      localContentValues.put("msglocalid", Integer.valueOf(this.field_msglocalid));
    }
    if (this.gEl) {
      localContentValues.put("human", this.field_human);
    }
    if (this.gEm) {
      localContentValues.put("voiceformat", Integer.valueOf(this.field_voiceformat));
    }
    if (this.gEn) {
      localContentValues.put("nettimes", Integer.valueOf(this.field_nettimes));
    }
    if (this.gmR) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.gmS) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4168802631680L, 31060);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */