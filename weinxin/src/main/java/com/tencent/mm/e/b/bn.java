package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class bn
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gaP;
  private static final int gdj;
  private static final int ghK;
  private static final int gsO;
  private static final int gsP;
  private static final int gsQ;
  private static final int gsR;
  private static final int gsS;
  private static final int gsT;
  private static final int gsU;
  private static final int gsV;
  private static final int gsW;
  private static final int gsX;
  private static final int gsY;
  private static final int gsZ;
  private static final int gta;
  public String field_big_url;
  public String field_contecttype;
  public int field_googlecgistatus;
  public String field_googlegmail;
  public String field_googleid;
  public String field_googleitemid;
  public String field_googlename;
  public String field_googlenamepy;
  public String field_googlephotourl;
  public String field_nickname;
  public String field_nicknameqp;
  public int field_ret;
  public String field_small_url;
  public int field_status;
  public String field_username;
  public String field_usernamepy;
  private boolean gaM;
  private boolean gdi;
  private boolean ghG;
  private boolean gsB;
  private boolean gsC;
  private boolean gsD;
  private boolean gsE;
  private boolean gsF;
  private boolean gsG;
  private boolean gsH;
  private boolean gsI;
  private boolean gsJ;
  private boolean gsK;
  private boolean gsL;
  private boolean gsM;
  private boolean gsN;
  
  static
  {
    GMTrace.i(4130147926016L, 30772);
    gaA = new String[0];
    gsO = "googleid".hashCode();
    gsP = "googlename".hashCode();
    gsQ = "googlephotourl".hashCode();
    gsR = "googlegmail".hashCode();
    gdj = "username".hashCode();
    ghK = "nickname".hashCode();
    gsS = "nicknameqp".hashCode();
    gsT = "usernamepy".hashCode();
    gsU = "small_url".hashCode();
    gsV = "big_url".hashCode();
    gsW = "ret".hashCode();
    gaP = "status".hashCode();
    gsX = "googleitemid".hashCode();
    gsY = "googlecgistatus".hashCode();
    gsZ = "contecttype".hashCode();
    gta = "googlenamepy".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4130147926016L, 30772);
  }
  
  public bn()
  {
    GMTrace.i(4129745272832L, 30769);
    this.gsB = true;
    this.gsC = true;
    this.gsD = true;
    this.gsE = true;
    this.gdi = true;
    this.ghG = true;
    this.gsF = true;
    this.gsG = true;
    this.gsH = true;
    this.gsI = true;
    this.gsJ = true;
    this.gaM = true;
    this.gsK = true;
    this.gsL = true;
    this.gsM = true;
    this.gsN = true;
    GMTrace.o(4129745272832L, 30769);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4129879490560L, 30770);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4129879490560L, 30770);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gsO == k) {
        this.field_googleid = paramCursor.getString(i);
      }
      for (;;)
      {
        i += 1;
        break;
        if (gsP == k)
        {
          this.field_googlename = paramCursor.getString(i);
        }
        else if (gsQ == k)
        {
          this.field_googlephotourl = paramCursor.getString(i);
        }
        else if (gsR == k)
        {
          this.field_googlegmail = paramCursor.getString(i);
        }
        else if (gdj == k)
        {
          this.field_username = paramCursor.getString(i);
        }
        else if (ghK == k)
        {
          this.field_nickname = paramCursor.getString(i);
        }
        else if (gsS == k)
        {
          this.field_nicknameqp = paramCursor.getString(i);
        }
        else if (gsT == k)
        {
          this.field_usernamepy = paramCursor.getString(i);
        }
        else if (gsU == k)
        {
          this.field_small_url = paramCursor.getString(i);
        }
        else if (gsV == k)
        {
          this.field_big_url = paramCursor.getString(i);
        }
        else if (gsW == k)
        {
          this.field_ret = paramCursor.getInt(i);
        }
        else if (gaP == k)
        {
          this.field_status = paramCursor.getInt(i);
        }
        else if (gsX == k)
        {
          this.field_googleitemid = paramCursor.getString(i);
          this.gsK = true;
        }
        else if (gsY == k)
        {
          this.field_googlecgistatus = paramCursor.getInt(i);
        }
        else if (gsZ == k)
        {
          this.field_contecttype = paramCursor.getString(i);
        }
        else if (gta == k)
        {
          this.field_googlenamepy = paramCursor.getString(i);
        }
        else if (gaJ == k)
        {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(4129879490560L, 30770);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4130013708288L, 30771);
    ContentValues localContentValues = new ContentValues();
    if (this.gsB) {
      localContentValues.put("googleid", this.field_googleid);
    }
    if (this.gsC) {
      localContentValues.put("googlename", this.field_googlename);
    }
    if (this.gsD) {
      localContentValues.put("googlephotourl", this.field_googlephotourl);
    }
    if (this.gsE) {
      localContentValues.put("googlegmail", this.field_googlegmail);
    }
    if (this.gdi) {
      localContentValues.put("username", this.field_username);
    }
    if (this.ghG) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.gsF) {
      localContentValues.put("nicknameqp", this.field_nicknameqp);
    }
    if (this.gsG) {
      localContentValues.put("usernamepy", this.field_usernamepy);
    }
    if (this.gsH) {
      localContentValues.put("small_url", this.field_small_url);
    }
    if (this.gsI) {
      localContentValues.put("big_url", this.field_big_url);
    }
    if (this.gsJ) {
      localContentValues.put("ret", Integer.valueOf(this.field_ret));
    }
    if (this.gaM) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.gsK) {
      localContentValues.put("googleitemid", this.field_googleitemid);
    }
    if (this.gsL) {
      localContentValues.put("googlecgistatus", Integer.valueOf(this.field_googlecgistatus));
    }
    if (this.gsM) {
      localContentValues.put("contecttype", this.field_contecttype);
    }
    if (this.gsN) {
      localContentValues.put("googlenamepy", this.field_googlenamepy);
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(4130013708288L, 30771);
    return localContentValues;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */