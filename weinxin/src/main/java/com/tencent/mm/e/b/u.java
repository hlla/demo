package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class u
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gfX;
  private static final int ggA;
  private static final int ggB;
  private static final int ggC;
  private static final int ggD;
  private static final int ggE;
  private static final int ggF;
  private static final int ggG;
  private static final int ggH;
  private static final int ggg;
  private static final int ggw;
  private static final int ggx;
  private static final int ggy;
  private static final int ggz;
  public String field_addMemberUrl;
  public int field_bitFlag;
  public long field_bizChatLocalId;
  public String field_bizChatServId;
  public String field_brandUserName;
  public String field_chatName;
  public String field_chatNamePY;
  public int field_chatType;
  public int field_chatVersion;
  public String field_headImageUrl;
  public int field_maxMemberCnt;
  public boolean field_needToUpdate;
  public String field_ownerUserId;
  public String field_userList;
  private boolean gfJ;
  private boolean gfS;
  private boolean ggk;
  private boolean ggl;
  private boolean ggm;
  private boolean ggn;
  private boolean ggo;
  private boolean ggp;
  private boolean ggq;
  private boolean ggr;
  private boolean ggs;
  private boolean ggt;
  private boolean ggu;
  private boolean ggv;
  
  static
  {
    GMTrace.i(4114847105024L, 30658);
    gaA = new String[0];
    ggw = "bizChatLocalId".hashCode();
    ggx = "bizChatServId".hashCode();
    gfX = "brandUserName".hashCode();
    ggg = "chatType".hashCode();
    ggy = "headImageUrl".hashCode();
    ggz = "chatName".hashCode();
    ggA = "chatNamePY".hashCode();
    ggB = "chatVersion".hashCode();
    ggC = "needToUpdate".hashCode();
    ggD = "bitFlag".hashCode();
    ggE = "maxMemberCnt".hashCode();
    ggF = "ownerUserId".hashCode();
    ggG = "userList".hashCode();
    ggH = "addMemberUrl".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4114847105024L, 30658);
  }
  
  public u()
  {
    GMTrace.i(4114444451840L, 30655);
    this.ggk = true;
    this.ggl = true;
    this.gfJ = true;
    this.gfS = true;
    this.ggm = true;
    this.ggn = true;
    this.ggo = true;
    this.ggp = true;
    this.ggq = true;
    this.ggr = true;
    this.ggs = true;
    this.ggt = true;
    this.ggu = true;
    this.ggv = true;
    GMTrace.o(4114444451840L, 30655);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4114578669568L, 30656);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4114578669568L, 30656);
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (ggw == k)
      {
        this.field_bizChatLocalId = paramCursor.getLong(i);
        this.ggk = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (ggx == k)
        {
          this.field_bizChatServId = paramCursor.getString(i);
        }
        else if (gfX == k)
        {
          this.field_brandUserName = paramCursor.getString(i);
        }
        else if (ggg == k)
        {
          this.field_chatType = paramCursor.getInt(i);
        }
        else if (ggy == k)
        {
          this.field_headImageUrl = paramCursor.getString(i);
        }
        else if (ggz == k)
        {
          this.field_chatName = paramCursor.getString(i);
        }
        else if (ggA == k)
        {
          this.field_chatNamePY = paramCursor.getString(i);
        }
        else if (ggB == k)
        {
          this.field_chatVersion = paramCursor.getInt(i);
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
          if (ggD == k) {
            this.field_bitFlag = paramCursor.getInt(i);
          } else if (ggE == k) {
            this.field_maxMemberCnt = paramCursor.getInt(i);
          } else if (ggF == k) {
            this.field_ownerUserId = paramCursor.getString(i);
          } else if (ggG == k) {
            this.field_userList = paramCursor.getString(i);
          } else if (ggH == k) {
            this.field_addMemberUrl = paramCursor.getString(i);
          } else if (gaJ == k) {
            this.uvp = paramCursor.getLong(i);
          }
        }
      }
    }
    GMTrace.o(4114578669568L, 30656);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4114712887296L, 30657);
    ContentValues localContentValues = new ContentValues();
    if (this.ggk) {
      localContentValues.put("bizChatLocalId", Long.valueOf(this.field_bizChatLocalId));
    }
    if (this.ggl) {
      localContentValues.put("bizChatServId", this.field_bizChatServId);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.gfJ) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.gfS) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.ggm) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.field_chatName == null) {
      this.field_chatName = "";
    }
    if (this.ggn) {
      localContentValues.put("chatName", this.field_chatName);
    }
    if (this.field_chatNamePY == null) {
      this.field_chatNamePY = "";
    }
    if (this.ggo) {
      localContentValues.put("chatNamePY", this.field_chatNamePY);
    }
    if (this.ggp) {
      localContentValues.put("chatVersion", Integer.valueOf(this.field_chatVersion));
    }
    if (this.ggq) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.ggr) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.ggs) {
      localContentValues.put("maxMemberCnt", Integer.valueOf(this.field_maxMemberCnt));
    }
    if (this.ggt) {
      localContentValues.put("ownerUserId", this.field_ownerUserId);
    }
    if (this.ggu) {
      localContentValues.put("userList", this.field_userList);
    }
    if (this.ggv) {
      localContentValues.put("addMemberUrl", this.field_addMemberUrl);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4114712887296L, 30657);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */