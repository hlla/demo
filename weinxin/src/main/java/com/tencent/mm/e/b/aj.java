package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;

public abstract class aj
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gaP;
  private static final int gbV;
  private static final int gdj;
  private static final int gfY;
  private static final int gfy;
  private static final int ggc;
  private static final int ggd;
  private static final int gge;
  private static final int ggf;
  private static final int ggh;
  private static final int ggi;
  private static final int ggj;
  private static final int glm;
  private static final int gln;
  private static final int glo;
  private static final int glp;
  private static final int glq;
  private static final int glr;
  private static final int gls;
  private static final int glt;
  private static final int glu;
  private static final int glv;
  private static final int glw;
  private static final int glx;
  private static final int gly;
  public int field_UnDeliverCount;
  public int field_UnReadInvite;
  public int field_atCount;
  public int field_attrflag;
  public int field_chatmode;
  public String field_content;
  public long field_conversationTime;
  private String field_customNotify;
  public String field_digest;
  public String field_digestUser;
  public String field_editingMsg;
  public long field_firstUnDeliverSeq;
  public long field_flag;
  private int field_hasTrunc;
  public int field_isSend;
  public long field_lastSeq;
  public int field_msgCount;
  public String field_msgType;
  public String field_parentRef;
  public int field_showTips;
  public long field_sightTime;
  public int field_status;
  public int field_unReadCount;
  public int field_unReadMuteCount;
  public String field_username;
  private boolean gaM;
  private boolean gbz;
  private boolean gdi;
  private boolean gfK;
  private boolean gfO;
  private boolean gfP;
  private boolean gfQ;
  private boolean gfR;
  private boolean gfT;
  private boolean gfU;
  private boolean gfV;
  private boolean gfw;
  private boolean gkZ;
  private boolean gla;
  private boolean glb;
  public boolean glc;
  private boolean gld;
  private boolean gle;
  private boolean glf;
  public boolean glg;
  private boolean glh;
  private boolean gli;
  private boolean glj;
  private boolean glk;
  private boolean gll;
  
  static
  {
    GMTrace.i(13361240604672L, 99549);
    gaA = new String[0];
    ggj = "msgCount".hashCode();
    gdj = "username".hashCode();
    gfY = "unReadCount".hashCode();
    glm = "chatmode".hashCode();
    gaP = "status".hashCode();
    ggh = "isSend".hashCode();
    gln = "conversationTime".hashCode();
    gbV = "content".hashCode();
    ggi = "msgType".hashCode();
    glo = "customNotify".hashCode();
    glp = "showTips".hashCode();
    gfy = "flag".hashCode();
    ggc = "digest".hashCode();
    ggd = "digestUser".hashCode();
    glq = "hasTrunc".hashCode();
    glr = "parentRef".hashCode();
    gls = "attrflag".hashCode();
    ggf = "editingMsg".hashCode();
    gge = "atCount".hashCode();
    glt = "sightTime".hashCode();
    glu = "unReadMuteCount".hashCode();
    glv = "lastSeq".hashCode();
    glw = "UnDeliverCount".hashCode();
    glx = "UnReadInvite".hashCode();
    gly = "firstUnDeliverSeq".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(13361240604672L, 99549);
  }
  
  public aj()
  {
    GMTrace.i(13357482508288L, 99521);
    this.gfV = false;
    this.gdi = false;
    this.gfK = false;
    this.gkZ = false;
    this.gaM = false;
    this.gfT = false;
    this.gla = false;
    this.gbz = false;
    this.gfU = false;
    this.glb = false;
    this.glc = false;
    this.gfw = false;
    this.gfO = false;
    this.gfP = false;
    this.gld = false;
    this.gle = false;
    this.glf = false;
    this.gfR = false;
    this.gfQ = false;
    this.glg = false;
    this.glh = false;
    this.gli = false;
    this.glj = false;
    this.glk = false;
    this.gll = false;
    GMTrace.o(13357482508288L, 99521);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(13360972169216L, 99547);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(13360972169216L, 99547);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (ggj == k) {
        this.field_msgCount = paramCursor.getInt(i);
      }
      for (;;)
      {
        i += 1;
        break;
        if (gdj == k)
        {
          this.field_username = paramCursor.getString(i);
          this.gdi = true;
        }
        else if (gfY == k)
        {
          this.field_unReadCount = paramCursor.getInt(i);
        }
        else if (glm == k)
        {
          this.field_chatmode = paramCursor.getInt(i);
        }
        else if (gaP == k)
        {
          this.field_status = paramCursor.getInt(i);
        }
        else if (ggh == k)
        {
          this.field_isSend = paramCursor.getInt(i);
        }
        else if (gln == k)
        {
          this.field_conversationTime = paramCursor.getLong(i);
        }
        else if (gbV == k)
        {
          this.field_content = paramCursor.getString(i);
        }
        else if (ggi == k)
        {
          this.field_msgType = paramCursor.getString(i);
        }
        else if (glo == k)
        {
          this.field_customNotify = paramCursor.getString(i);
        }
        else if (glp == k)
        {
          this.field_showTips = paramCursor.getInt(i);
        }
        else if (gfy == k)
        {
          this.field_flag = paramCursor.getLong(i);
        }
        else if (ggc == k)
        {
          this.field_digest = paramCursor.getString(i);
        }
        else if (ggd == k)
        {
          this.field_digestUser = paramCursor.getString(i);
        }
        else if (glq == k)
        {
          this.field_hasTrunc = paramCursor.getInt(i);
        }
        else if (glr == k)
        {
          this.field_parentRef = paramCursor.getString(i);
        }
        else if (gls == k)
        {
          this.field_attrflag = paramCursor.getInt(i);
        }
        else if (ggf == k)
        {
          this.field_editingMsg = paramCursor.getString(i);
        }
        else if (gge == k)
        {
          this.field_atCount = paramCursor.getInt(i);
        }
        else if (glt == k)
        {
          this.field_sightTime = paramCursor.getLong(i);
        }
        else if (glu == k)
        {
          this.field_unReadMuteCount = paramCursor.getInt(i);
        }
        else if (glv == k)
        {
          this.field_lastSeq = paramCursor.getLong(i);
        }
        else if (glw == k)
        {
          this.field_UnDeliverCount = paramCursor.getInt(i);
        }
        else if (glx == k)
        {
          this.field_UnReadInvite = paramCursor.getInt(i);
        }
        else if (gly == k)
        {
          this.field_firstUnDeliverSeq = paramCursor.getLong(i);
        }
        else if (gaJ == k)
        {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    GMTrace.o(13360972169216L, 99547);
  }
  
  public final void ct(String paramString)
  {
    GMTrace.i(13358958903296L, 99532);
    this.field_msgType = paramString;
    this.gfU = true;
    GMTrace.o(13358958903296L, 99532);
  }
  
  public final void cu(String paramString)
  {
    GMTrace.i(13359227338752L, 99534);
    this.field_digest = paramString;
    this.gfO = true;
    GMTrace.o(13359227338752L, 99534);
  }
  
  public final void cv(String paramString)
  {
    GMTrace.i(13359361556480L, 99535);
    this.field_digestUser = paramString;
    this.gfP = true;
    GMTrace.o(13359361556480L, 99535);
  }
  
  public final void cw(String paramString)
  {
    GMTrace.i(13359629991936L, 99537);
    this.field_parentRef = paramString;
    this.gle = true;
    GMTrace.o(13359629991936L, 99537);
  }
  
  public final void cx(String paramString)
  {
    GMTrace.i(13359898427392L, 99539);
    this.field_editingMsg = paramString;
    this.gfR = true;
    GMTrace.o(13359898427392L, 99539);
  }
  
  public final void dA(int paramInt)
  {
    GMTrace.i(13360166862848L, 99541);
    this.field_unReadMuteCount = paramInt;
    this.glh = true;
    GMTrace.o(13360166862848L, 99541);
  }
  
  public final void dB(int paramInt)
  {
    GMTrace.i(13360569516032L, 99544);
    this.field_UnDeliverCount = paramInt;
    this.glj = true;
    GMTrace.o(13360569516032L, 99544);
  }
  
  public final void dC(int paramInt)
  {
    GMTrace.i(13360703733760L, 99545);
    this.field_UnReadInvite = paramInt;
    this.glk = true;
    GMTrace.o(13360703733760L, 99545);
  }
  
  public final void ds(int paramInt)
  {
    GMTrace.i(13357616726016L, 99522);
    this.field_msgCount = paramInt;
    this.gfV = true;
    GMTrace.o(13357616726016L, 99522);
  }
  
  public final void dt(int paramInt)
  {
    GMTrace.i(13358019379200L, 99525);
    this.field_unReadCount = paramInt;
    this.gfK = true;
    GMTrace.o(13358019379200L, 99525);
  }
  
  public final void du(int paramInt)
  {
    GMTrace.i(13358287814656L, 99527);
    this.field_chatmode = paramInt;
    this.gkZ = true;
    GMTrace.o(13358287814656L, 99527);
  }
  
  public final void dv(int paramInt)
  {
    GMTrace.i(13358422032384L, 99528);
    this.field_status = paramInt;
    this.gaM = true;
    GMTrace.o(13358422032384L, 99528);
  }
  
  public final void dw(int paramInt)
  {
    GMTrace.i(13358556250112L, 99529);
    this.field_isSend = paramInt;
    this.gfT = true;
    GMTrace.o(13358556250112L, 99529);
  }
  
  public final void dx(int paramInt)
  {
    GMTrace.i(13359495774208L, 99536);
    this.field_hasTrunc = paramInt;
    this.gld = true;
    GMTrace.o(13359495774208L, 99536);
  }
  
  public final void dy(int paramInt)
  {
    GMTrace.i(13359764209664L, 99538);
    this.field_attrflag = paramInt;
    this.glf = true;
    GMTrace.o(13359764209664L, 99538);
  }
  
  public final void dz(int paramInt)
  {
    GMTrace.i(13360032645120L, 99540);
    this.field_atCount = paramInt;
    this.gfQ = true;
    GMTrace.o(13360032645120L, 99540);
  }
  
  public final String getUsername()
  {
    GMTrace.i(16290274082816L, 121372);
    String str = this.field_username;
    GMTrace.o(16290274082816L, 121372);
    return str;
  }
  
  public final long pE()
  {
    GMTrace.i(16290408300544L, 121373);
    long l = this.field_lastSeq;
    GMTrace.o(16290408300544L, 121373);
    return l;
  }
  
  public final int pF()
  {
    GMTrace.i(16290542518272L, 121374);
    int i = this.field_UnDeliverCount;
    GMTrace.o(16290542518272L, 121374);
    return i;
  }
  
  public final long pG()
  {
    GMTrace.i(16290676736000L, 121375);
    long l = this.field_firstUnDeliverSeq;
    GMTrace.o(16290676736000L, 121375);
    return l;
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(13361106386944L, 99548);
    ContentValues localContentValues = new ContentValues();
    if (this.gfV) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.gdi) {
      localContentValues.put("username", this.field_username);
    }
    if (this.gfK) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.gkZ) {
      localContentValues.put("chatmode", Integer.valueOf(this.field_chatmode));
    }
    if (this.gaM) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.gfT) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.gla) {
      localContentValues.put("conversationTime", Long.valueOf(this.field_conversationTime));
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.gbz) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_msgType == null) {
      this.field_msgType = "";
    }
    if (this.gfU) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.field_customNotify == null) {
      this.field_customNotify = "";
    }
    if (this.glb) {
      localContentValues.put("customNotify", this.field_customNotify);
    }
    if (this.glc) {
      localContentValues.put("showTips", Integer.valueOf(this.field_showTips));
    }
    if (this.gfw) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.gfO) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.gfP) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.gld) {
      localContentValues.put("hasTrunc", Integer.valueOf(this.field_hasTrunc));
    }
    if (this.gle) {
      localContentValues.put("parentRef", this.field_parentRef);
    }
    if (this.glf) {
      localContentValues.put("attrflag", Integer.valueOf(this.field_attrflag));
    }
    if (this.field_editingMsg == null) {
      this.field_editingMsg = "";
    }
    if (this.gfR) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.gfQ) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.glg) {
      localContentValues.put("sightTime", Long.valueOf(this.field_sightTime));
    }
    if (this.glh) {
      localContentValues.put("unReadMuteCount", Integer.valueOf(this.field_unReadMuteCount));
    }
    if (this.gli) {
      localContentValues.put("lastSeq", Long.valueOf(this.field_lastSeq));
    }
    if (this.glj) {
      localContentValues.put("UnDeliverCount", Integer.valueOf(this.field_UnDeliverCount));
    }
    if (this.glk) {
      localContentValues.put("UnReadInvite", Integer.valueOf(this.field_UnReadInvite));
    }
    if (this.gll) {
      localContentValues.put("firstUnDeliverSeq", Long.valueOf(this.field_firstUnDeliverSeq));
    }
    if (this.uvp > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.uvp));
    }
    GMTrace.o(13361106386944L, 99548);
    return localContentValues;
  }
  
  public final void s(long paramLong)
  {
    GMTrace.i(13358690467840L, 99530);
    this.field_conversationTime = paramLong;
    this.gla = true;
    GMTrace.o(13358690467840L, 99530);
  }
  
  public final void setContent(String paramString)
  {
    GMTrace.i(13358824685568L, 99531);
    this.field_content = paramString;
    this.gbz = true;
    GMTrace.o(13358824685568L, 99531);
  }
  
  public final void setUsername(String paramString)
  {
    GMTrace.i(13357750943744L, 99523);
    this.field_username = paramString;
    this.gdi = true;
    GMTrace.o(13357750943744L, 99523);
  }
  
  public final void t(long paramLong)
  {
    GMTrace.i(13359093121024L, 99533);
    this.field_flag = paramLong;
    this.gfw = true;
    GMTrace.o(13359093121024L, 99533);
  }
  
  public final void u(long paramLong)
  {
    GMTrace.i(13360435298304L, 99543);
    this.field_lastSeq = paramLong;
    this.gli = true;
    GMTrace.o(13360435298304L, 99543);
  }
  
  public final void v(long paramLong)
  {
    GMTrace.i(13360837951488L, 99546);
    this.field_firstUnDeliverSeq = paramLong;
    this.gll = true;
    GMTrace.o(13360837951488L, 99546);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */