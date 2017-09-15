package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class w
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gbL;
  private static final int gfX;
  private static final int ggC;
  private static final int ggD;
  private static final int ggH;
  private static final int ggJ;
  private static final int ggN;
  private static final int ggO;
  private static final int ggP;
  private static final int ggy;
  public int field_UserVersion;
  public String field_addMemberUrl;
  public int field_bitFlag;
  public String field_brandUserName;
  public String field_headImageUrl;
  public boolean field_needToUpdate;
  public String field_profileUrl;
  public String field_userId;
  public String field_userName;
  public String field_userNamePY;
  private boolean gbp;
  private boolean gfJ;
  private boolean ggI;
  private boolean ggK;
  private boolean ggL;
  private boolean ggM;
  private boolean ggm;
  private boolean ggq;
  private boolean ggr;
  private boolean ggv;
  
  static
  {
    GMTrace.i(4117934112768L, 30681);
    gaA = new String[0];
    ggJ = "userId".hashCode();
    gbL = "userName".hashCode();
    ggN = "userNamePY".hashCode();
    gfX = "brandUserName".hashCode();
    ggO = "UserVersion".hashCode();
    ggC = "needToUpdate".hashCode();
    ggy = "headImageUrl".hashCode();
    ggP = "profileUrl".hashCode();
    ggD = "bitFlag".hashCode();
    ggH = "addMemberUrl".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4117934112768L, 30681);
  }
  
  public w()
  {
    GMTrace.i(4117531459584L, 30678);
    this.ggI = true;
    this.gbp = true;
    this.ggK = true;
    this.gfJ = true;
    this.ggL = true;
    this.ggq = true;
    this.ggm = true;
    this.ggM = true;
    this.ggr = true;
    this.ggv = true;
    GMTrace.o(4117531459584L, 30678);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4117665677312L, 30679);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4117665677312L, 30679);
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (ggJ == k)
      {
        this.field_userId = paramCursor.getString(i);
        this.ggI = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gbL == k)
        {
          this.field_userName = paramCursor.getString(i);
        }
        else if (ggN == k)
        {
          this.field_userNamePY = paramCursor.getString(i);
        }
        else if (gfX == k)
        {
          this.field_brandUserName = paramCursor.getString(i);
        }
        else if (ggO == k)
        {
          this.field_UserVersion = paramCursor.getInt(i);
        }
        else
        {
          if (ggC == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (boolean bool = true;; bool = false)
            {
              this.field_needToUpdate = bool;
              break;
            }
          }
          if (ggy == k) {
            this.field_headImageUrl = paramCursor.getString(i);
          } else if (ggP == k) {
            this.field_profileUrl = paramCursor.getString(i);
          } else if (ggD == k) {
            this.field_bitFlag = paramCursor.getInt(i);
          } else if (ggH == k) {
            this.field_addMemberUrl = paramCursor.getString(i);
          } else if (gaJ == k) {
            this.uvp = paramCursor.getLong(i);
          }
        }
      }
    }
    GMTrace.o(4117665677312L, 30679);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4117799895040L, 30680);
    ContentValues localContentValues = new ContentValues();
    if (this.ggI) {
      localContentValues.put("userId", this.field_userId);
    }
    if (this.field_userName == null) {
      this.field_userName = "";
    }
    if (this.gbp) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.field_userNamePY == null) {
      this.field_userNamePY = "";
    }
    if (this.ggK) {
      localContentValues.put("userNamePY", this.field_userNamePY);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.gfJ) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.ggL) {
      localContentValues.put("UserVersion", Integer.valueOf(this.field_UserVersion));
    }
    if (this.ggq) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.ggm) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.ggM) {
      localContentValues.put("profileUrl", this.field_profileUrl);
    }
    if (this.ggr) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.ggv) {
      localContentValues.put("addMemberUrl", this.field_addMemberUrl);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4117799895040L, 30680);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */