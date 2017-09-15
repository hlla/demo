package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.v;

public abstract class ce
  extends c
{
  public static final String[] gaA;
  private static final int gaI;
  private static final int gaJ;
  private static final int gaP;
  private static final int gbN;
  private static final int gbQ;
  private static final int gbV;
  private static final int gfW;
  private static final int gfy;
  private static final int ggh;
  private static final int got;
  private static final int gsA;
  private static final int gtC;
  private static final int gxk;
  private static final int gxl;
  private static final int gxm;
  private static final int gxn;
  private static final int gxo;
  private static final int gxp;
  private static final int gxq;
  private static final int gxr;
  private static final int gxs;
  private String fUO;
  public long field_bizChatId;
  public String field_bizChatUserId;
  private String field_bizClientMsgId;
  public String field_content;
  public long field_createTime;
  public int field_flag;
  public String field_imgPath;
  public int field_isSend;
  public int field_isShowTimer;
  public byte[] field_lvbuffer;
  public long field_msgId;
  public long field_msgSeq;
  public long field_msgSvrId;
  public String field_reserved;
  public int field_status;
  public String field_talker;
  public int field_talkerId;
  public String field_transBrandWording;
  public String field_transContent;
  public int field_type;
  private boolean gaE;
  private boolean gaM;
  private boolean gbr;
  private boolean gbu;
  private boolean gbz;
  private boolean gfI;
  private boolean gfT;
  private boolean gfw;
  private boolean god;
  private boolean gsu;
  public boolean gtq;
  public int gxA;
  public int gxB;
  public String gxC;
  public String gxD;
  public String gxE;
  public int gxF;
  private boolean gxb;
  public boolean gxc;
  private boolean gxd;
  private boolean gxe;
  public boolean gxf;
  private boolean gxg;
  private boolean gxh;
  private boolean gxi;
  public boolean gxj;
  public String gxt;
  public int gxu;
  public String gxv;
  public int gxw;
  public int gxx;
  public int gxy;
  public int gxz;
  
  static
  {
    GMTrace.i(13348892573696L, 99457);
    gaA = new String[0];
    gaI = "msgId".hashCode();
    gxk = "msgSvrId".hashCode();
    gbQ = "type".hashCode();
    gaP = "status".hashCode();
    ggh = "isSend".hashCode();
    gxl = "isShowTimer".hashCode();
    gbN = "createTime".hashCode();
    got = "talker".hashCode();
    gbV = "content".hashCode();
    gxm = "imgPath".hashCode();
    gxn = "reserved".hashCode();
    gtC = "lvbuffer".hashCode();
    gxo = "talkerId".hashCode();
    gxp = "transContent".hashCode();
    gxq = "transBrandWording".hashCode();
    gxr = "bizClientMsgId".hashCode();
    gfW = "bizChatId".hashCode();
    gxs = "bizChatUserId".hashCode();
    gsA = "msgSeq".hashCode();
    gfy = "flag".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(13348892573696L, 99457);
  }
  
  public ce()
  {
    GMTrace.i(13344060735488L, 99421);
    this.gaE = false;
    this.gxb = false;
    this.gbu = false;
    this.gaM = false;
    this.gfT = false;
    this.gxc = false;
    this.gbr = false;
    this.god = false;
    this.gbz = false;
    this.gxd = false;
    this.gxe = false;
    this.gtq = false;
    this.gxf = false;
    this.gxg = false;
    this.gxh = false;
    this.gxi = false;
    this.gfI = false;
    this.gxj = false;
    this.gsu = false;
    this.gfw = false;
    GMTrace.o(13344060735488L, 99421);
  }
  
  public final void A(long paramLong)
  {
    GMTrace.i(13347013525504L, 99443);
    this.field_bizChatId = paramLong;
    this.gfI = true;
    GMTrace.o(13347013525504L, 99443);
  }
  
  public final void B(long paramLong)
  {
    GMTrace.i(13347147743232L, 99444);
    this.field_msgSeq = paramLong;
    this.gsu = true;
    GMTrace.o(13347147743232L, 99444);
  }
  
  public void b(Cursor paramCursor)
  {
    GMTrace.i(13347416178688L, 99446);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(13347416178688L, 99446);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gaI == k)
      {
        this.field_msgId = paramCursor.getLong(i);
        this.gaE = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gxk == k) {
          this.field_msgSvrId = paramCursor.getLong(i);
        } else if (gbQ == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (gaP == k) {
          this.field_status = paramCursor.getInt(i);
        } else if (ggh == k) {
          this.field_isSend = paramCursor.getInt(i);
        } else if (gxl == k) {
          this.field_isShowTimer = paramCursor.getInt(i);
        } else if (gbN == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (got == k) {
          this.field_talker = paramCursor.getString(i);
        } else if (gbV == k) {
          this.field_content = paramCursor.getString(i);
        } else if (gxm == k) {
          this.field_imgPath = paramCursor.getString(i);
        } else if (gxn == k) {
          this.field_reserved = paramCursor.getString(i);
        } else if (gtC == k) {
          this.field_lvbuffer = paramCursor.getBlob(i);
        } else if (gxo == k) {
          this.field_talkerId = paramCursor.getInt(i);
        } else if (gxp == k) {
          this.field_transContent = paramCursor.getString(i);
        } else if (gxq == k) {
          this.field_transBrandWording = paramCursor.getString(i);
        } else if (gxr == k) {
          this.field_bizClientMsgId = paramCursor.getString(i);
        } else if (gfW == k) {
          this.field_bizChatId = paramCursor.getLong(i);
        } else if (gxs == k) {
          this.field_bizChatUserId = paramCursor.getString(i);
        } else if (gsA == k) {
          this.field_msgSeq = paramCursor.getLong(i);
        } else if (gfy == k) {
          this.field_flag = paramCursor.getInt(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    try
    {
      if (this.field_lvbuffer != null)
      {
        i = this.field_lvbuffer.length;
        if (i != 0) {}
      }
      else
      {
        GMTrace.o(13347416178688L, 99446);
        return;
      }
      paramCursor = new s();
      i = paramCursor.bh(this.field_lvbuffer);
      if (i != 0)
      {
        v.e("MicroMsg.SDK.BaseMsgInfo", "parse LVBuffer error:" + i);
        GMTrace.o(13347416178688L, 99446);
        return;
      }
      if (!paramCursor.bIw()) {
        this.gxt = paramCursor.getString();
      }
      if (!paramCursor.bIw()) {
        this.gxu = paramCursor.getInt();
      }
      if (!paramCursor.bIw()) {
        this.gxv = paramCursor.getString();
      }
      if (!paramCursor.bIw()) {
        this.gxw = paramCursor.getInt();
      }
      if (!paramCursor.bIw()) {
        this.gxx = paramCursor.getInt();
      }
      if (!paramCursor.bIw()) {
        this.gxy = paramCursor.getInt();
      }
      if (!paramCursor.bIw()) {
        this.gxz = paramCursor.getInt();
      }
      if (!paramCursor.bIw()) {
        this.gxA = paramCursor.getInt();
      }
      if (!paramCursor.bIw()) {
        this.gxB = paramCursor.getInt();
      }
      if (!paramCursor.bIw()) {
        this.gxC = paramCursor.getString();
      }
      if (!paramCursor.bIw()) {
        this.gxD = paramCursor.getString();
      }
      if (!paramCursor.bIw()) {
        this.gxE = paramCursor.getString();
      }
      if (!paramCursor.bIw()) {
        this.gxF = paramCursor.getInt();
      }
      if (!paramCursor.bIw()) {
        this.fUO = paramCursor.getString();
      }
      GMTrace.o(13347416178688L, 99446);
      return;
    }
    catch (Exception paramCursor)
    {
      v.e("MicroMsg.SDK.BaseMsgInfo", "get value failed");
      GMTrace.o(13347416178688L, 99446);
    }
  }
  
  public final void cH(String paramString)
  {
    GMTrace.i(13345671348224L, 99433);
    this.field_talker = paramString;
    this.god = true;
    GMTrace.o(13345671348224L, 99433);
  }
  
  public final void cI(String paramString)
  {
    GMTrace.i(13346208219136L, 99437);
    this.field_imgPath = paramString;
    this.gxd = true;
    GMTrace.o(13346208219136L, 99437);
  }
  
  public final void cJ(String paramString)
  {
    GMTrace.i(13346476654592L, 99439);
    this.field_reserved = paramString;
    this.gxe = true;
    GMTrace.o(13346476654592L, 99439);
  }
  
  public final void cK(String paramString)
  {
    GMTrace.i(13346745090048L, 99441);
    this.field_transContent = paramString;
    this.gxg = true;
    GMTrace.o(13346745090048L, 99441);
  }
  
  public final void cL(String paramString)
  {
    GMTrace.i(13346879307776L, 99442);
    this.field_bizClientMsgId = paramString;
    this.gxi = true;
    GMTrace.o(13346879307776L, 99442);
  }
  
  public final void cM(String paramString)
  {
    GMTrace.i(13347684614144L, 99448);
    this.gxt = paramString;
    this.gtq = true;
    GMTrace.o(13347684614144L, 99448);
  }
  
  public final void cN(String paramString)
  {
    GMTrace.i(13347953049600L, 99450);
    this.gxv = paramString;
    this.gtq = true;
    GMTrace.o(13347953049600L, 99450);
  }
  
  public final void cO(String paramString)
  {
    GMTrace.i(13348489920512L, 99454);
    this.gxD = paramString;
    this.gtq = true;
    GMTrace.o(13348489920512L, 99454);
  }
  
  public final void cP(String paramString)
  {
    GMTrace.i(13348624138240L, 99455);
    this.gxE = paramString;
    this.gtq = true;
    GMTrace.o(13348624138240L, 99455);
  }
  
  public final void dF(int paramInt)
  {
    GMTrace.i(13347281960960L, 99445);
    this.field_flag = paramInt;
    this.gfw = true;
    GMTrace.o(13347281960960L, 99445);
  }
  
  public final void dG(int paramInt)
  {
    GMTrace.i(13347818831872L, 99449);
    this.gxu = paramInt;
    this.gtq = true;
    GMTrace.o(13347818831872L, 99449);
  }
  
  public final void dH(int paramInt)
  {
    GMTrace.i(13348087267328L, 99451);
    this.gxw = paramInt;
    this.gtq = true;
    GMTrace.o(13348087267328L, 99451);
  }
  
  public final void dI(int paramInt)
  {
    GMTrace.i(13348221485056L, 99452);
    this.gxx = paramInt;
    this.gtq = true;
    GMTrace.o(13348221485056L, 99452);
  }
  
  public final void dJ(int paramInt)
  {
    GMTrace.i(13348355702784L, 99453);
    this.gxB = paramInt;
    this.gtq = true;
    GMTrace.o(13348355702784L, 99453);
  }
  
  public final void dK(int paramInt)
  {
    GMTrace.i(13348758355968L, 99456);
    this.gxF = paramInt;
    this.gtq = true;
    GMTrace.o(13348758355968L, 99456);
  }
  
  public void dv(int paramInt)
  {
    GMTrace.i(13345000259584L, 99428);
    this.field_status = paramInt;
    this.gaM = true;
    GMTrace.o(13345000259584L, 99428);
  }
  
  public final void dw(int paramInt)
  {
    GMTrace.i(13345134477312L, 99429);
    this.field_isSend = paramInt;
    this.gfT = true;
    GMTrace.o(13345134477312L, 99429);
  }
  
  public final int getType()
  {
    GMTrace.i(13344866041856L, 99427);
    int i = this.field_type;
    GMTrace.o(13344866041856L, 99427);
    return i;
  }
  
  public final long pH()
  {
    GMTrace.i(13344329170944L, 99423);
    long l = this.field_msgId;
    GMTrace.o(13344329170944L, 99423);
    return l;
  }
  
  public final long pI()
  {
    GMTrace.i(13344597606400L, 99425);
    long l = this.field_msgSvrId;
    GMTrace.o(13344597606400L, 99425);
    return l;
  }
  
  public final int pJ()
  {
    GMTrace.i(13345268695040L, 99430);
    int i = this.field_isSend;
    GMTrace.o(13345268695040L, 99430);
    return i;
  }
  
  public final long pK()
  {
    GMTrace.i(13345537130496L, 99432);
    long l = this.field_createTime;
    GMTrace.o(13345537130496L, 99432);
    return l;
  }
  
  public final String pL()
  {
    GMTrace.i(13345805565952L, 99434);
    String str = this.field_talker;
    GMTrace.o(13345805565952L, 99434);
    return str;
  }
  
  public final String pM()
  {
    GMTrace.i(13346074001408L, 99436);
    String str = this.field_content;
    GMTrace.o(13346074001408L, 99436);
    return str;
  }
  
  public final String pN()
  {
    GMTrace.i(13346342436864L, 99438);
    String str = this.field_imgPath;
    GMTrace.o(13346342436864L, 99438);
    return str;
  }
  
  public ContentValues pv()
  {
    GMTrace.i(13347550396416L, 99447);
    try
    {
      if (this.gtq)
      {
        localObject = new s();
        ((s)localObject).bIx();
        ((s)localObject).Pl(this.gxt);
        ((s)localObject).yo(this.gxu);
        ((s)localObject).Pl(this.gxv);
        ((s)localObject).yo(this.gxw);
        ((s)localObject).yo(this.gxx);
        ((s)localObject).yo(this.gxy);
        ((s)localObject).yo(this.gxz);
        ((s)localObject).yo(this.gxA);
        ((s)localObject).yo(this.gxB);
        ((s)localObject).Pl(this.gxC);
        ((s)localObject).Pl(this.gxD);
        ((s)localObject).Pl(this.gxE);
        ((s)localObject).yo(this.gxF);
        ((s)localObject).Pl(this.fUO);
        this.field_lvbuffer = ((s)localObject).bIy();
      }
      Object localObject = new ContentValues();
      if (this.gaE) {
        ((ContentValues)localObject).put("msgId", Long.valueOf(this.field_msgId));
      }
      if (this.gxb) {
        ((ContentValues)localObject).put("msgSvrId", Long.valueOf(this.field_msgSvrId));
      }
      if (this.gbu) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.gaM) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.gfT) {
        ((ContentValues)localObject).put("isSend", Integer.valueOf(this.field_isSend));
      }
      if (this.gxc) {
        ((ContentValues)localObject).put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
      }
      if (this.gbr) {
        ((ContentValues)localObject).put("createTime", Long.valueOf(this.field_createTime));
      }
      if (this.god) {
        ((ContentValues)localObject).put("talker", this.field_talker);
      }
      if (this.field_content == null) {
        this.field_content = "";
      }
      if (this.gbz) {
        ((ContentValues)localObject).put("content", this.field_content);
      }
      if (this.gxd) {
        ((ContentValues)localObject).put("imgPath", this.field_imgPath);
      }
      if (this.gxe) {
        ((ContentValues)localObject).put("reserved", this.field_reserved);
      }
      if (this.gtq) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.gxf) {
        ((ContentValues)localObject).put("talkerId", Integer.valueOf(this.field_talkerId));
      }
      if (this.field_transContent == null) {
        this.field_transContent = "";
      }
      if (this.gxg) {
        ((ContentValues)localObject).put("transContent", this.field_transContent);
      }
      if (this.field_transBrandWording == null) {
        this.field_transBrandWording = "";
      }
      if (this.gxh) {
        ((ContentValues)localObject).put("transBrandWording", this.field_transBrandWording);
      }
      if (this.field_bizClientMsgId == null) {
        this.field_bizClientMsgId = "";
      }
      if (this.gxi) {
        ((ContentValues)localObject).put("bizClientMsgId", this.field_bizClientMsgId);
      }
      if (this.gfI) {
        ((ContentValues)localObject).put("bizChatId", Long.valueOf(this.field_bizChatId));
      }
      if (this.field_bizChatUserId == null) {
        this.field_bizChatUserId = "";
      }
      if (this.gxj) {
        ((ContentValues)localObject).put("bizChatUserId", this.field_bizChatUserId);
      }
      if (this.gsu) {
        ((ContentValues)localObject).put("msgSeq", Long.valueOf(this.field_msgSeq));
      }
      if (this.gfw) {
        ((ContentValues)localObject).put("flag", Integer.valueOf(this.field_flag));
      }
      if (this.uvp > 0L) {
        ((ContentValues)localObject).put("rowid", Long.valueOf(this.uvp));
      }
      GMTrace.o(13347550396416L, 99447);
      return (ContentValues)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.e("MicroMsg.SDK.BaseMsgInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void setContent(String paramString)
  {
    GMTrace.i(13345939783680L, 99435);
    this.field_content = paramString;
    this.gbz = true;
    GMTrace.o(13345939783680L, 99435);
  }
  
  public final void setType(int paramInt)
  {
    GMTrace.i(13344731824128L, 99426);
    this.field_type = paramInt;
    this.gbu = true;
    GMTrace.o(13344731824128L, 99426);
  }
  
  public final void x(long paramLong)
  {
    GMTrace.i(13344194953216L, 99422);
    this.field_msgId = paramLong;
    this.gaE = true;
    GMTrace.o(13344194953216L, 99422);
  }
  
  public final void y(long paramLong)
  {
    GMTrace.i(13344463388672L, 99424);
    this.field_msgSvrId = paramLong;
    this.gxb = true;
    GMTrace.o(13344463388672L, 99424);
  }
  
  public final void z(long paramLong)
  {
    GMTrace.i(13345402912768L, 99431);
    this.field_createTime = paramLong;
    this.gbr = true;
    GMTrace.o(13345402912768L, 99431);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */