package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class ae
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gjA;
  private static final int gjB;
  private static final int gjk;
  private static final int gjl;
  private static final int gjm;
  private static final int gjn;
  private static final int gjo;
  private static final int gjp;
  private static final int gjq;
  private static final int gjr;
  private static final int gjs;
  private static final int gjt;
  private static final int gju;
  private static final int gjv;
  private static final int gjw;
  private static final int gjx;
  private static final int gjy;
  private static final int gjz;
  public long field_addtime;
  public long field_chatroomLocalVersion;
  public int field_chatroomVersion;
  public int field_chatroomdataflag;
  public String field_chatroomname;
  public String field_chatroomnick;
  public String field_chatroomnotice;
  public String field_chatroomnoticeEditor;
  public long field_chatroomnoticePublishTime;
  public String field_displayname;
  public int field_isShowname;
  public String field_memberlist;
  public long field_modifytime;
  public byte[] field_roomdata;
  public int field_roomflag;
  public String field_roomowner;
  public String field_selfDisplayName;
  public int field_style;
  private boolean giS;
  private boolean giT;
  private boolean giU;
  private boolean giV;
  private boolean giW;
  private boolean giX;
  private boolean giY;
  private boolean giZ;
  private boolean gja;
  private boolean gjb;
  private boolean gjc;
  private boolean gjd;
  private boolean gje;
  private boolean gjf;
  private boolean gjg;
  private boolean gjh;
  private boolean gji;
  private boolean gjj;
  
  static
  {
    GMTrace.i(4168399978496L, 31057);
    gaA = new String[0];
    gjk = "chatroomname".hashCode();
    gjl = "addtime".hashCode();
    gjm = "memberlist".hashCode();
    gjn = "displayname".hashCode();
    gjo = "chatroomnick".hashCode();
    gjp = "roomflag".hashCode();
    gjq = "roomowner".hashCode();
    gjr = "roomdata".hashCode();
    gjs = "isShowname".hashCode();
    gjt = "selfDisplayName".hashCode();
    gju = "style".hashCode();
    gjv = "chatroomdataflag".hashCode();
    gjw = "modifytime".hashCode();
    gjx = "chatroomnotice".hashCode();
    gjy = "chatroomVersion".hashCode();
    gjz = "chatroomnoticeEditor".hashCode();
    gjA = "chatroomnoticePublishTime".hashCode();
    gjB = "chatroomLocalVersion".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4168399978496L, 31057);
  }
  
  public ae()
  {
    GMTrace.i(4167997325312L, 31054);
    this.giS = true;
    this.giT = true;
    this.giU = true;
    this.giV = true;
    this.giW = true;
    this.giX = true;
    this.giY = true;
    this.giZ = true;
    this.gja = true;
    this.gjb = true;
    this.gjc = true;
    this.gjd = true;
    this.gje = true;
    this.gjf = true;
    this.gjg = true;
    this.gjh = true;
    this.gji = true;
    this.gjj = true;
    GMTrace.o(4167997325312L, 31054);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4168131543040L, 31055);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4168131543040L, 31055);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gjk == k)
      {
        this.field_chatroomname = paramCursor.getString(i);
        this.giS = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gjl == k) {
          this.field_addtime = paramCursor.getLong(i);
        } else if (gjm == k) {
          this.field_memberlist = paramCursor.getString(i);
        } else if (gjn == k) {
          this.field_displayname = paramCursor.getString(i);
        } else if (gjo == k) {
          this.field_chatroomnick = paramCursor.getString(i);
        } else if (gjp == k) {
          this.field_roomflag = paramCursor.getInt(i);
        } else if (gjq == k) {
          this.field_roomowner = paramCursor.getString(i);
        } else if (gjr == k) {
          this.field_roomdata = paramCursor.getBlob(i);
        } else if (gjs == k) {
          this.field_isShowname = paramCursor.getInt(i);
        } else if (gjt == k) {
          this.field_selfDisplayName = paramCursor.getString(i);
        } else if (gju == k) {
          this.field_style = paramCursor.getInt(i);
        } else if (gjv == k) {
          this.field_chatroomdataflag = paramCursor.getInt(i);
        } else if (gjw == k) {
          this.field_modifytime = paramCursor.getLong(i);
        } else if (gjx == k) {
          this.field_chatroomnotice = paramCursor.getString(i);
        } else if (gjy == k) {
          this.field_chatroomVersion = paramCursor.getInt(i);
        } else if (gjz == k) {
          this.field_chatroomnoticeEditor = paramCursor.getString(i);
        } else if (gjA == k) {
          this.field_chatroomnoticePublishTime = paramCursor.getLong(i);
        } else if (gjB == k) {
          this.field_chatroomLocalVersion = paramCursor.getLong(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4168131543040L, 31055);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4168265760768L, 31056);
    ContentValues localContentValues = new ContentValues();
    if (this.field_chatroomname == null) {
      this.field_chatroomname = "";
    }
    if (this.giS) {
      localContentValues.put("chatroomname", this.field_chatroomname);
    }
    if (this.giT) {
      localContentValues.put("addtime", Long.valueOf(this.field_addtime));
    }
    if (this.giU) {
      localContentValues.put("memberlist", this.field_memberlist);
    }
    if (this.giV) {
      localContentValues.put("displayname", this.field_displayname);
    }
    if (this.giW) {
      localContentValues.put("chatroomnick", this.field_chatroomnick);
    }
    if (this.giX) {
      localContentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
    }
    if (this.giY) {
      localContentValues.put("roomowner", this.field_roomowner);
    }
    if (this.giZ) {
      localContentValues.put("roomdata", this.field_roomdata);
    }
    if (this.gja) {
      localContentValues.put("isShowname", Integer.valueOf(this.field_isShowname));
    }
    if (this.gjb) {
      localContentValues.put("selfDisplayName", this.field_selfDisplayName);
    }
    if (this.gjc) {
      localContentValues.put("style", Integer.valueOf(this.field_style));
    }
    if (this.gjd) {
      localContentValues.put("chatroomdataflag", Integer.valueOf(this.field_chatroomdataflag));
    }
    if (this.gje) {
      localContentValues.put("modifytime", Long.valueOf(this.field_modifytime));
    }
    if (this.gjf) {
      localContentValues.put("chatroomnotice", this.field_chatroomnotice);
    }
    if (this.gjg) {
      localContentValues.put("chatroomVersion", Integer.valueOf(this.field_chatroomVersion));
    }
    if (this.gjh) {
      localContentValues.put("chatroomnoticeEditor", this.field_chatroomnoticeEditor);
    }
    if (this.gji) {
      localContentValues.put("chatroomnoticePublishTime", Long.valueOf(this.field_chatroomnoticePublishTime));
    }
    if (this.gjj) {
      localContentValues.put("chatroomLocalVersion", Long.valueOf(this.field_chatroomLocalVersion));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4168265760768L, 31056);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */