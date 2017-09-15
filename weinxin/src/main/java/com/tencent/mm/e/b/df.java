package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class df
  extends c
{
  private static final int gDL;
  private static final int gDM;
  private static final int gDN;
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gjS;
  private static final int gkc;
  public String field_conDescription;
  public String field_conPhone;
  public String field_conRemark;
  public String field_contactLabels;
  public String field_encryptUsername;
  private boolean gDI;
  private boolean gDJ;
  private boolean gDK;
  private boolean gjD;
  private boolean gjN;
  
  static
  {
    GMTrace.i(13343926517760L, 99420);
    gaA = new String[0];
    gkc = "encryptUsername".hashCode();
    gjS = "conRemark".hashCode();
    gDL = "contactLabels".hashCode();
    gDM = "conDescription".hashCode();
    gDN = "conPhone".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(13343926517760L, 99420);
  }
  
  public df()
  {
    GMTrace.i(13343523864576L, 99417);
    this.gjN = true;
    this.gjD = true;
    this.gDI = true;
    this.gDJ = true;
    this.gDK = true;
    GMTrace.o(13343523864576L, 99417);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(13343658082304L, 99418);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(13343658082304L, 99418);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gkc == k)
      {
        this.field_encryptUsername = paramCursor.getString(i);
        this.gjN = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gjS == k) {
          this.field_conRemark = paramCursor.getString(i);
        } else if (gDL == k) {
          this.field_contactLabels = paramCursor.getString(i);
        } else if (gDM == k) {
          this.field_conDescription = paramCursor.getString(i);
        } else if (gDN == k) {
          this.field_conPhone = paramCursor.getString(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(13343658082304L, 99418);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(13343792300032L, 99419);
    ContentValues localContentValues = new ContentValues();
    if (this.field_encryptUsername == null) {
      this.field_encryptUsername = "";
    }
    if (this.gjN) {
      localContentValues.put("encryptUsername", this.field_encryptUsername);
    }
    if (this.field_conRemark == null) {
      this.field_conRemark = "";
    }
    if (this.gjD) {
      localContentValues.put("conRemark", this.field_conRemark);
    }
    if (this.field_contactLabels == null) {
      this.field_contactLabels = "";
    }
    if (this.gDI) {
      localContentValues.put("contactLabels", this.field_contactLabels);
    }
    if (this.field_conDescription == null) {
      this.field_conDescription = "";
    }
    if (this.gDJ) {
      localContentValues.put("conDescription", this.field_conDescription);
    }
    if (this.field_conPhone == null) {
      this.field_conPhone = "";
    }
    if (this.gDK) {
      localContentValues.put("conPhone", this.field_conPhone);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(13343792300032L, 99419);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */