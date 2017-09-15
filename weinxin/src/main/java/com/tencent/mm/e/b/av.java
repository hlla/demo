package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class av
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gnm;
  private static final int goA;
  private static final int goB;
  private static final int goC;
  private static final int goD;
  private static final int goE;
  private static final int goF;
  private static final int goG;
  private static final int goH;
  private static final int goI;
  private static final int got;
  private static final int gou;
  private static final int gov;
  private static final int gow;
  private static final int gox;
  private static final int goy;
  private static final int goz;
  public int field_addScene;
  public String field_contentFromUsername;
  public String field_contentFullPhoneNumMD5;
  public String field_contentNickname;
  public String field_contentPhoneNumMD5;
  public String field_contentVerifyContent;
  public String field_displayName;
  public String field_encryptTalker;
  public String field_fmsgContent;
  public int field_fmsgIsSend;
  public long field_fmsgSysRowId;
  public int field_fmsgType;
  public int field_isNew;
  public long field_lastModifiedTime;
  public int field_recvFmsgType;
  public int field_state;
  public String field_talker;
  private boolean gmP;
  private boolean god;
  private boolean goe;
  private boolean gof;
  private boolean gog;
  private boolean goh;
  private boolean goi;
  private boolean goj;
  private boolean gok;
  private boolean gol;
  private boolean gom;
  private boolean gon;
  private boolean goo;
  private boolean gop;
  private boolean goq;
  private boolean gor;
  private boolean gos;
  
  static
  {
    GMTrace.i(4131221667840L, 30780);
    gaA = new String[] { "CREATE INDEX IF NOT EXISTS fmconversation_isnew_Index ON fmessage_conversation(isNew)" };
    got = "talker".hashCode();
    gou = "encryptTalker".hashCode();
    gov = "displayName".hashCode();
    gnm = "state".hashCode();
    gow = "lastModifiedTime".hashCode();
    gox = "isNew".hashCode();
    goy = "addScene".hashCode();
    goz = "fmsgSysRowId".hashCode();
    goA = "fmsgIsSend".hashCode();
    goB = "fmsgType".hashCode();
    goC = "fmsgContent".hashCode();
    goD = "recvFmsgType".hashCode();
    goE = "contentFromUsername".hashCode();
    goF = "contentNickname".hashCode();
    goG = "contentPhoneNumMD5".hashCode();
    goH = "contentFullPhoneNumMD5".hashCode();
    goI = "contentVerifyContent".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4131221667840L, 30780);
  }
  
  public av()
  {
    GMTrace.i(4130819014656L, 30777);
    this.god = true;
    this.goe = true;
    this.gof = true;
    this.gmP = true;
    this.gog = true;
    this.goh = true;
    this.goi = true;
    this.goj = true;
    this.gok = true;
    this.gol = true;
    this.gom = true;
    this.gon = true;
    this.goo = true;
    this.gop = true;
    this.goq = true;
    this.gor = true;
    this.gos = true;
    GMTrace.o(4130819014656L, 30777);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4130953232384L, 30778);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4130953232384L, 30778);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (got == k)
      {
        this.field_talker = paramCursor.getString(i);
        this.god = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gou == k) {
          this.field_encryptTalker = paramCursor.getString(i);
        } else if (gov == k) {
          this.field_displayName = paramCursor.getString(i);
        } else if (gnm == k) {
          this.field_state = paramCursor.getInt(i);
        } else if (gow == k) {
          this.field_lastModifiedTime = paramCursor.getLong(i);
        } else if (gox == k) {
          this.field_isNew = paramCursor.getInt(i);
        } else if (goy == k) {
          this.field_addScene = paramCursor.getInt(i);
        } else if (goz == k) {
          this.field_fmsgSysRowId = paramCursor.getLong(i);
        } else if (goA == k) {
          this.field_fmsgIsSend = paramCursor.getInt(i);
        } else if (goB == k) {
          this.field_fmsgType = paramCursor.getInt(i);
        } else if (goC == k) {
          this.field_fmsgContent = paramCursor.getString(i);
        } else if (goD == k) {
          this.field_recvFmsgType = paramCursor.getInt(i);
        } else if (goE == k) {
          this.field_contentFromUsername = paramCursor.getString(i);
        } else if (goF == k) {
          this.field_contentNickname = paramCursor.getString(i);
        } else if (goG == k) {
          this.field_contentPhoneNumMD5 = paramCursor.getString(i);
        } else if (goH == k) {
          this.field_contentFullPhoneNumMD5 = paramCursor.getString(i);
        } else if (goI == k) {
          this.field_contentVerifyContent = paramCursor.getString(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4130953232384L, 30778);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4131087450112L, 30779);
    ContentValues localContentValues = new ContentValues();
    if (this.field_talker == null) {
      this.field_talker = "0";
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
    if (this.field_displayName == null) {
      this.field_displayName = "";
    }
    if (this.gof) {
      localContentValues.put("displayName", this.field_displayName);
    }
    if (this.gmP) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.gog) {
      localContentValues.put("lastModifiedTime", Long.valueOf(this.field_lastModifiedTime));
    }
    if (this.goh) {
      localContentValues.put("isNew", Integer.valueOf(this.field_isNew));
    }
    if (this.goi) {
      localContentValues.put("addScene", Integer.valueOf(this.field_addScene));
    }
    if (this.goj) {
      localContentValues.put("fmsgSysRowId", Long.valueOf(this.field_fmsgSysRowId));
    }
    if (this.gok) {
      localContentValues.put("fmsgIsSend", Integer.valueOf(this.field_fmsgIsSend));
    }
    if (this.gol) {
      localContentValues.put("fmsgType", Integer.valueOf(this.field_fmsgType));
    }
    if (this.field_fmsgContent == null) {
      this.field_fmsgContent = "";
    }
    if (this.gom) {
      localContentValues.put("fmsgContent", this.field_fmsgContent);
    }
    if (this.gon) {
      localContentValues.put("recvFmsgType", Integer.valueOf(this.field_recvFmsgType));
    }
    if (this.field_contentFromUsername == null) {
      this.field_contentFromUsername = "";
    }
    if (this.goo) {
      localContentValues.put("contentFromUsername", this.field_contentFromUsername);
    }
    if (this.field_contentNickname == null) {
      this.field_contentNickname = "";
    }
    if (this.gop) {
      localContentValues.put("contentNickname", this.field_contentNickname);
    }
    if (this.field_contentPhoneNumMD5 == null) {
      this.field_contentPhoneNumMD5 = "";
    }
    if (this.goq) {
      localContentValues.put("contentPhoneNumMD5", this.field_contentPhoneNumMD5);
    }
    if (this.field_contentFullPhoneNumMD5 == null) {
      this.field_contentFullPhoneNumMD5 = "";
    }
    if (this.gor) {
      localContentValues.put("contentFullPhoneNumMD5", this.field_contentFullPhoneNumMD5);
    }
    if (this.field_contentVerifyContent == null) {
      this.field_contentVerifyContent = "";
    }
    if (this.gos) {
      localContentValues.put("contentVerifyContent", this.field_contentVerifyContent);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4131087450112L, 30779);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */