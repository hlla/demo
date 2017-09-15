package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class ao
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gbQ;
  private static final int gbV;
  private static final int gcZ;
  private static final int gfv;
  private static final int gmD;
  private static final int gmz;
  private static final int gnA;
  private static final int gnB;
  private static final int gnC;
  private static final int gnD;
  private static final int gnE;
  private static final int gni;
  private static final int gnj;
  private static final int gnk;
  private static final int gnl;
  private static final int gnm;
  private static final int gnn;
  private static final int gno;
  private static final int gnp;
  private static final int gnq;
  private static final int gnr;
  private static final int gns;
  private static final int gnt;
  private static final int gnu;
  private static final int gnv;
  private static final int gnw;
  private static final int gnx;
  private static final int gny;
  private static final int gnz;
  public String field_activityid;
  public String field_aeskey;
  public String field_app_id;
  public int field_catalog;
  public String field_cdnUrl;
  public String field_content;
  public String field_designerID;
  public String field_encrypturl;
  public String field_framesInfo;
  public String field_groupId;
  public int field_height;
  public int field_idx;
  public long field_lastUseTime;
  public String field_md5;
  public String field_name;
  public int field_needupload;
  public String field_reserved1;
  public String field_reserved2;
  public int field_reserved3;
  public int field_reserved4;
  public int field_size;
  public int field_source;
  public int field_start;
  public int field_state;
  public String field_svrid;
  public int field_temp;
  public String field_thumbUrl;
  public int field_type;
  public int field_width;
  private boolean gbu;
  private boolean gbz;
  private boolean gcW;
  private boolean gfr;
  private boolean glZ;
  private boolean gmL;
  private boolean gmM;
  private boolean gmN;
  private boolean gmO;
  private boolean gmP;
  private boolean gmQ;
  private boolean gmR;
  private boolean gmS;
  private boolean gmT;
  private boolean gmU;
  private boolean gmV;
  private boolean gmW;
  private boolean gmX;
  private boolean gmY;
  private boolean gmZ;
  private boolean gmd;
  private boolean gna;
  private boolean gnb;
  private boolean gnc;
  private boolean gnd;
  private boolean gne;
  private boolean gnf;
  private boolean gng;
  private boolean gnh;
  
  static
  {
    GMTrace.i(4140348473344L, 30848);
    gaA = new String[] { "CREATE INDEX IF NOT EXISTS emojiGroupIndex ON EmojiInfo(catalog)" };
    gni = "md5".hashCode();
    gnj = "svrid".hashCode();
    gnk = "catalog".hashCode();
    gbQ = "type".hashCode();
    gcZ = "size".hashCode();
    gnl = "start".hashCode();
    gnm = "state".hashCode();
    gnn = "name".hashCode();
    gbV = "content".hashCode();
    gno = "reserved1".hashCode();
    gnp = "reserved2".hashCode();
    gnq = "reserved3".hashCode();
    gnr = "reserved4".hashCode();
    gns = "app_id".hashCode();
    gnt = "groupId".hashCode();
    gmz = "lastUseTime".hashCode();
    gnu = "framesInfo".hashCode();
    gmD = "idx".hashCode();
    gnv = "temp".hashCode();
    gfv = "source".hashCode();
    gnw = "needupload".hashCode();
    gnx = "designerID".hashCode();
    gny = "thumbUrl".hashCode();
    gnz = "cdnUrl".hashCode();
    gnA = "encrypturl".hashCode();
    gnB = "aeskey".hashCode();
    gnC = "width".hashCode();
    gnD = "height".hashCode();
    gnE = "activityid".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4140348473344L, 30848);
  }
  
  public ao()
  {
    GMTrace.i(4139811602432L, 30844);
    this.gmL = true;
    this.gmM = true;
    this.gmN = true;
    this.gbu = true;
    this.gcW = true;
    this.gmO = true;
    this.gmP = true;
    this.gmQ = true;
    this.gbz = true;
    this.gmR = true;
    this.gmS = true;
    this.gmT = true;
    this.gmU = true;
    this.gmV = true;
    this.gmW = true;
    this.glZ = true;
    this.gmX = true;
    this.gmd = true;
    this.gmY = true;
    this.gfr = true;
    this.gmZ = true;
    this.gna = true;
    this.gnb = true;
    this.gnc = true;
    this.gnd = true;
    this.gne = true;
    this.gnf = true;
    this.gng = true;
    this.gnh = true;
    GMTrace.o(4139811602432L, 30844);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4139945820160L, 30845);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4139945820160L, 30845);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gni == k)
      {
        this.field_md5 = paramCursor.getString(i);
        this.gmL = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gnj == k) {
          this.field_svrid = paramCursor.getString(i);
        } else if (gnk == k) {
          this.field_catalog = paramCursor.getInt(i);
        } else if (gbQ == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (gcZ == k) {
          this.field_size = paramCursor.getInt(i);
        } else if (gnl == k) {
          this.field_start = paramCursor.getInt(i);
        } else if (gnm == k) {
          this.field_state = paramCursor.getInt(i);
        } else if (gnn == k) {
          this.field_name = paramCursor.getString(i);
        } else if (gbV == k) {
          this.field_content = paramCursor.getString(i);
        } else if (gno == k) {
          this.field_reserved1 = paramCursor.getString(i);
        } else if (gnp == k) {
          this.field_reserved2 = paramCursor.getString(i);
        } else if (gnq == k) {
          this.field_reserved3 = paramCursor.getInt(i);
        } else if (gnr == k) {
          this.field_reserved4 = paramCursor.getInt(i);
        } else if (gns == k) {
          this.field_app_id = paramCursor.getString(i);
        } else if (gnt == k) {
          this.field_groupId = paramCursor.getString(i);
        } else if (gmz == k) {
          this.field_lastUseTime = paramCursor.getLong(i);
        } else if (gnu == k) {
          this.field_framesInfo = paramCursor.getString(i);
        } else if (gmD == k) {
          this.field_idx = paramCursor.getInt(i);
        } else if (gnv == k) {
          this.field_temp = paramCursor.getInt(i);
        } else if (gfv == k) {
          this.field_source = paramCursor.getInt(i);
        } else if (gnw == k) {
          this.field_needupload = paramCursor.getInt(i);
        } else if (gnx == k) {
          this.field_designerID = paramCursor.getString(i);
        } else if (gny == k) {
          this.field_thumbUrl = paramCursor.getString(i);
        } else if (gnz == k) {
          this.field_cdnUrl = paramCursor.getString(i);
        } else if (gnA == k) {
          this.field_encrypturl = paramCursor.getString(i);
        } else if (gnB == k) {
          this.field_aeskey = paramCursor.getString(i);
        } else if (gnC == k) {
          this.field_width = paramCursor.getInt(i);
        } else if (gnD == k) {
          this.field_height = paramCursor.getInt(i);
        } else if (gnE == k) {
          this.field_activityid = paramCursor.getString(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4139945820160L, 30845);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4140080037888L, 30846);
    ContentValues localContentValues = new ContentValues();
    if (this.gmL) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.gmM) {
      localContentValues.put("svrid", this.field_svrid);
    }
    if (this.gmN) {
      localContentValues.put("catalog", Integer.valueOf(this.field_catalog));
    }
    if (this.gbu) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.gcW) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.gmO) {
      localContentValues.put("start", Integer.valueOf(this.field_start));
    }
    if (this.gmP) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.gmQ) {
      localContentValues.put("name", this.field_name);
    }
    if (this.gbz) {
      localContentValues.put("content", this.field_content);
    }
    if (this.gmR) {
      localContentValues.put("reserved1", this.field_reserved1);
    }
    if (this.gmS) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.gmT) {
      localContentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
    }
    if (this.gmU) {
      localContentValues.put("reserved4", Integer.valueOf(this.field_reserved4));
    }
    if (this.gmV) {
      localContentValues.put("app_id", this.field_app_id);
    }
    if (this.field_groupId == null) {
      this.field_groupId = "";
    }
    if (this.gmW) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.glZ) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.field_framesInfo == null) {
      this.field_framesInfo = "";
    }
    if (this.gmX) {
      localContentValues.put("framesInfo", this.field_framesInfo);
    }
    if (this.gmd) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.gmY) {
      localContentValues.put("temp", Integer.valueOf(this.field_temp));
    }
    if (this.gfr) {
      localContentValues.put("source", Integer.valueOf(this.field_source));
    }
    if (this.gmZ) {
      localContentValues.put("needupload", Integer.valueOf(this.field_needupload));
    }
    if (this.gna) {
      localContentValues.put("designerID", this.field_designerID);
    }
    if (this.gnb) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.gnc) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.gnd) {
      localContentValues.put("encrypturl", this.field_encrypturl);
    }
    if (this.gne) {
      localContentValues.put("aeskey", this.field_aeskey);
    }
    if (this.gnf) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.gng) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.gnh) {
      localContentValues.put("activityid", this.field_activityid);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4140080037888L, 30846);
    return localContentValues;
  }
  
  public void reset()
  {
    GMTrace.i(4140214255616L, 30847);
    GMTrace.o(4140214255616L, 30847);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */