package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class z
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gdh;
  private static final int geH;
  private static final int ghI;
  private static final int ghJ;
  private static final int ghK;
  private static final int ghL;
  public String field_brandUsername;
  public String field_headImgUrl;
  public int field_kfType;
  public String field_nickname;
  public String field_openId;
  public long field_updateTime;
  private boolean gdd;
  private boolean gel;
  private boolean ghE;
  private boolean ghF;
  private boolean ghG;
  private boolean ghH;
  
  static
  {
    GMTrace.i(4174439776256L, 31102);
    gaA = new String[0];
    geH = "openId".hashCode();
    ghI = "brandUsername".hashCode();
    ghJ = "headImgUrl".hashCode();
    ghK = "nickname".hashCode();
    ghL = "kfType".hashCode();
    gdh = "updateTime".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4174439776256L, 31102);
  }
  
  public z()
  {
    GMTrace.i(4174037123072L, 31099);
    this.gel = true;
    this.ghE = true;
    this.ghF = true;
    this.ghG = true;
    this.ghH = true;
    this.gdd = true;
    GMTrace.o(4174037123072L, 31099);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4174171340800L, 31100);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4174171340800L, 31100);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (geH == k)
      {
        this.field_openId = paramCursor.getString(i);
        this.gel = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (ghI == k) {
          this.field_brandUsername = paramCursor.getString(i);
        } else if (ghJ == k) {
          this.field_headImgUrl = paramCursor.getString(i);
        } else if (ghK == k) {
          this.field_nickname = paramCursor.getString(i);
        } else if (ghL == k) {
          this.field_kfType = paramCursor.getInt(i);
        } else if (gdh == k) {
          this.field_updateTime = paramCursor.getLong(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4174171340800L, 31100);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4174305558528L, 31101);
    ContentValues localContentValues = new ContentValues();
    if (this.gel) {
      localContentValues.put("openId", this.field_openId);
    }
    if (this.field_brandUsername == null) {
      this.field_brandUsername = "";
    }
    if (this.ghE) {
      localContentValues.put("brandUsername", this.field_brandUsername);
    }
    if (this.ghF) {
      localContentValues.put("headImgUrl", this.field_headImgUrl);
    }
    if (this.ghG) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.ghH) {
      localContentValues.put("kfType", Integer.valueOf(this.field_kfType));
    }
    if (this.gdd) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4174305558528L, 31101);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */