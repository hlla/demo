package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class cf
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gbN;
  private static final int gnm;
  private static final int gnt;
  private static final int gxM;
  private static final int gxN;
  private static final int gxO;
  private static final int gxP;
  private static final int gxQ;
  private static final int gxR;
  public long field_createTime;
  public String field_groupId;
  public String field_inviteUserName;
  public int field_memberCount;
  public int field_roomId;
  public long field_roomKey;
  public int field_routeId;
  public int field_state;
  public String field_wxGroupId;
  private boolean gbr;
  private boolean gmP;
  private boolean gmW;
  private boolean gxG;
  private boolean gxH;
  private boolean gxI;
  private boolean gxJ;
  private boolean gxK;
  private boolean gxL;
  
  static
  {
    GMTrace.i(4122229080064L, 30713);
    gaA = new String[0];
    gxM = "wxGroupId".hashCode();
    gnt = "groupId".hashCode();
    gxN = "roomId".hashCode();
    gxO = "roomKey".hashCode();
    gxP = "routeId".hashCode();
    gxQ = "inviteUserName".hashCode();
    gxR = "memberCount".hashCode();
    gbN = "createTime".hashCode();
    gnm = "state".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4122229080064L, 30713);
  }
  
  public cf()
  {
    GMTrace.i(4121826426880L, 30710);
    this.gxG = true;
    this.gmW = true;
    this.gxH = true;
    this.gxI = true;
    this.gxJ = true;
    this.gxK = true;
    this.gxL = true;
    this.gbr = true;
    this.gmP = true;
    GMTrace.o(4121826426880L, 30710);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4121960644608L, 30711);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4121960644608L, 30711);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gxM == k)
      {
        this.field_wxGroupId = paramCursor.getString(i);
        this.gxG = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gnt == k) {
          this.field_groupId = paramCursor.getString(i);
        } else if (gxN == k) {
          this.field_roomId = paramCursor.getInt(i);
        } else if (gxO == k) {
          this.field_roomKey = paramCursor.getLong(i);
        } else if (gxP == k) {
          this.field_routeId = paramCursor.getInt(i);
        } else if (gxQ == k) {
          this.field_inviteUserName = paramCursor.getString(i);
        } else if (gxR == k) {
          this.field_memberCount = paramCursor.getInt(i);
        } else if (gbN == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (gnm == k) {
          this.field_state = paramCursor.getInt(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4121960644608L, 30711);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4122094862336L, 30712);
    ContentValues localContentValues = new ContentValues();
    if (this.gxG) {
      localContentValues.put("wxGroupId", this.field_wxGroupId);
    }
    if (this.gmW) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.gxH) {
      localContentValues.put("roomId", Integer.valueOf(this.field_roomId));
    }
    if (this.gxI) {
      localContentValues.put("roomKey", Long.valueOf(this.field_roomKey));
    }
    if (this.gxJ) {
      localContentValues.put("routeId", Integer.valueOf(this.field_routeId));
    }
    if (this.gxK) {
      localContentValues.put("inviteUserName", this.field_inviteUserName);
    }
    if (this.gxL) {
      localContentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
    }
    if (this.gbr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.gmP) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4122094862336L, 30712);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */