package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;

public abstract class bh
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gaP;
  private static final int gdR;
  private static final int grH;
  private static final int grI;
  private static final int grJ;
  private static final int grK;
  private static final int grL;
  private static final int grM;
  private static final int grN;
  private static final int grO;
  private static final int grP;
  private static final int grQ;
  private static final int grR;
  private static final int grS;
  public bu field_addMsg;
  public String field_cgi;
  public int field_cmdid;
  public String field_custombuff;
  public int field_failkey;
  public int field_finalfailkey;
  public String field_functionmsgid;
  public boolean field_needShow;
  public long field_preVersion;
  public int field_reportid;
  public int field_retryinterval;
  public int field_status;
  public int field_successkey;
  public long field_version;
  private boolean gaM;
  private boolean gdK;
  private boolean grA;
  private boolean grB;
  private boolean grC;
  private boolean grD;
  private boolean grE;
  private boolean grF;
  private boolean grG;
  private boolean grv;
  private boolean grw;
  private boolean grx;
  private boolean gry;
  private boolean grz;
  
  static
  {
    GMTrace.i(4169473720320L, 31065);
    gaA = new String[0];
    grH = "cgi".hashCode();
    grI = "cmdid".hashCode();
    grJ = "functionmsgid".hashCode();
    gdR = "version".hashCode();
    grK = "preVersion".hashCode();
    grL = "retryinterval".hashCode();
    grM = "reportid".hashCode();
    grN = "successkey".hashCode();
    grO = "failkey".hashCode();
    grP = "finalfailkey".hashCode();
    grQ = "custombuff".hashCode();
    grR = "addMsg".hashCode();
    gaP = "status".hashCode();
    grS = "needShow".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4169473720320L, 31065);
  }
  
  public bh()
  {
    GMTrace.i(4169071067136L, 31062);
    this.grv = true;
    this.grw = true;
    this.grx = true;
    this.gdK = true;
    this.gry = true;
    this.grz = true;
    this.grA = true;
    this.grB = true;
    this.grC = true;
    this.grD = true;
    this.grE = true;
    this.grF = true;
    this.gaM = true;
    this.grG = true;
    GMTrace.o(4169071067136L, 31062);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4169205284864L, 31063);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4169205284864L, 31063);
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (grH == k) {
        this.field_cgi = paramCursor.getString(i);
      }
      for (;;)
      {
        i += 1;
        break;
        if (grI == k)
        {
          this.field_cmdid = paramCursor.getInt(i);
        }
        else if (grJ == k)
        {
          this.field_functionmsgid = paramCursor.getString(i);
          this.grx = true;
        }
        else if (gdR == k)
        {
          this.field_version = paramCursor.getLong(i);
        }
        else if (grK == k)
        {
          this.field_preVersion = paramCursor.getLong(i);
        }
        else if (grL == k)
        {
          this.field_retryinterval = paramCursor.getInt(i);
        }
        else if (grM == k)
        {
          this.field_reportid = paramCursor.getInt(i);
        }
        else if (grN == k)
        {
          this.field_successkey = paramCursor.getInt(i);
        }
        else if (grO == k)
        {
          this.field_failkey = paramCursor.getInt(i);
        }
        else if (grP == k)
        {
          this.field_finalfailkey = paramCursor.getInt(i);
        }
        else if (grQ == k)
        {
          this.field_custombuff = paramCursor.getString(i);
        }
        else if (grR == k)
        {
          try
          {
            byte[] arrayOfByte = paramCursor.getBlob(i);
            if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
              continue;
            }
            this.field_addMsg = ((bu)new bu().aD(arrayOfByte));
          }
          catch (IOException localIOException)
          {
            v.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException.getMessage());
          }
        }
        else if (gaP == k)
        {
          this.field_status = paramCursor.getInt(i);
        }
        else
        {
          if (grS == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (boolean bool = true;; bool = false)
            {
              this.field_needShow = bool;
              break;
            }
          }
          if (gaJ == k) {
            this.uvp = paramCursor.getLong(i);
          }
        }
      }
    }
    GMTrace.o(4169205284864L, 31063);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4169339502592L, 31064);
    ContentValues localContentValues = new ContentValues();
    if (this.grv) {
      localContentValues.put("cgi", this.field_cgi);
    }
    if (this.grw) {
      localContentValues.put("cmdid", Integer.valueOf(this.field_cmdid));
    }
    if (this.grx) {
      localContentValues.put("functionmsgid", this.field_functionmsgid);
    }
    if (this.gdK) {
      localContentValues.put("version", Long.valueOf(this.field_version));
    }
    if (this.gry) {
      localContentValues.put("preVersion", Long.valueOf(this.field_preVersion));
    }
    if (this.grz) {
      localContentValues.put("retryinterval", Integer.valueOf(this.field_retryinterval));
    }
    if (this.grA) {
      localContentValues.put("reportid", Integer.valueOf(this.field_reportid));
    }
    if (this.grB) {
      localContentValues.put("successkey", Integer.valueOf(this.field_successkey));
    }
    if (this.grC) {
      localContentValues.put("failkey", Integer.valueOf(this.field_failkey));
    }
    if (this.grD) {
      localContentValues.put("finalfailkey", Integer.valueOf(this.field_finalfailkey));
    }
    if (this.grE) {
      localContentValues.put("custombuff", this.field_custombuff);
    }
    if ((this.grF) && (this.field_addMsg != null)) {}
    try
    {
      localContentValues.put("addMsg", this.field_addMsg.toByteArray());
      if (this.gaM) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.grG) {
        localContentValues.put("needShow", Boolean.valueOf(this.field_needShow));
      }
      if (this.uvp > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.uvp));
      }
      GMTrace.o(4169339502592L, 31064);
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        v.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException.getMessage());
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */