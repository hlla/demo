package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.v;

public abstract class af
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gbQ;
  private static final int gdj;
  private static final int geK;
  private static final int ghK;
  private static final int gjR;
  private static final int gjS;
  private static final int gjT;
  private static final int gjU;
  private static final int gjV;
  private static final int gjW;
  private static final int gjX;
  private static final int gjY;
  private static final int gjZ;
  private static final int gka;
  private static final int gkb;
  private static final int gkc;
  private static final int gkd;
  private static final int gke;
  private static final int gkf;
  private int cFR;
  public String fOz;
  private String field_alias;
  public int field_chatroomFlag;
  public String field_conRemark;
  public String field_conRemarkPYFull;
  public String field_conRemarkPYShort;
  public String field_contactLabelIds;
  public int field_deleteFlag;
  public String field_domainList;
  public String field_encryptUsername;
  public byte[] field_lvbuff;
  public String field_nickname;
  private String field_pyInitial;
  private String field_quanPin;
  public int field_showHead;
  public int field_type;
  public String field_username;
  public int field_verifyFlag;
  public int field_weiboFlag;
  public String field_weiboNickname;
  private boolean gbu;
  private boolean gdi;
  private boolean geo;
  private boolean ghG;
  private boolean gjC;
  private boolean gjD;
  private boolean gjE;
  private boolean gjF;
  private boolean gjG;
  private boolean gjH;
  private boolean gjI;
  private boolean gjJ;
  private boolean gjK;
  private boolean gjL;
  private boolean gjM;
  private boolean gjN;
  private boolean gjO;
  private boolean gjP;
  private boolean gjQ;
  public String gkA;
  public String gkB;
  public String gkC;
  public String gkD;
  public String gkE;
  public String gkF;
  public String gkG;
  public String gkH;
  private int gkI;
  public int gkg;
  public int gkh;
  public String gki;
  public long gkj;
  public String gkk;
  public int gkl;
  public int gkm;
  public String gkn;
  public String gko;
  public int gkp;
  public int gkq;
  private String gkr;
  private String gks;
  public String gkt;
  public int gku;
  public String gkv;
  public String gkw;
  public String gkx;
  public int gky;
  public int gkz;
  public String signature;
  public int uin;
  
  static
  {
    GMTrace.i(13357348290560L, 99520);
    gaA = new String[] { "CREATE INDEX IF NOT EXISTS deleteflag_index ON Contact(deleteFlag)" };
    gdj = "username".hashCode();
    gjR = "alias".hashCode();
    gjS = "conRemark".hashCode();
    gjT = "domainList".hashCode();
    ghK = "nickname".hashCode();
    gjU = "pyInitial".hashCode();
    gjV = "quanPin".hashCode();
    gjW = "showHead".hashCode();
    gbQ = "type".hashCode();
    gjX = "weiboFlag".hashCode();
    gjY = "weiboNickname".hashCode();
    gjZ = "conRemarkPYFull".hashCode();
    gka = "conRemarkPYShort".hashCode();
    geK = "lvbuff".hashCode();
    gkb = "verifyFlag".hashCode();
    gkc = "encryptUsername".hashCode();
    gkd = "chatroomFlag".hashCode();
    gke = "deleteFlag".hashCode();
    gkf = "contactLabelIds".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(13357348290560L, 99520);
  }
  
  public af()
  {
    GMTrace.i(13349026791424L, 99458);
    this.gdi = false;
    this.gjC = false;
    this.gjD = false;
    this.gjE = false;
    this.ghG = false;
    this.gjF = false;
    this.gjG = false;
    this.gjH = false;
    this.gbu = false;
    this.gjI = false;
    this.gjJ = false;
    this.gjK = false;
    this.gjL = false;
    this.geo = false;
    this.gjM = false;
    this.gjN = false;
    this.gjO = false;
    this.gjP = false;
    this.gjQ = false;
    GMTrace.o(13349026791424L, 99458);
  }
  
  public void b(Cursor paramCursor)
  {
    GMTrace.i(13352248016896L, 99482);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(13352248016896L, 99482);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gdj == k)
      {
        this.field_username = paramCursor.getString(i);
        this.gdi = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gjR == k) {
          this.field_alias = paramCursor.getString(i);
        } else if (gjS == k) {
          this.field_conRemark = paramCursor.getString(i);
        } else if (gjT == k) {
          this.field_domainList = paramCursor.getString(i);
        } else if (ghK == k) {
          this.field_nickname = paramCursor.getString(i);
        } else if (gjU == k) {
          this.field_pyInitial = paramCursor.getString(i);
        } else if (gjV == k) {
          this.field_quanPin = paramCursor.getString(i);
        } else if (gjW == k) {
          this.field_showHead = paramCursor.getInt(i);
        } else if (gbQ == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (gjX == k) {
          this.field_weiboFlag = paramCursor.getInt(i);
        } else if (gjY == k) {
          this.field_weiboNickname = paramCursor.getString(i);
        } else if (gjZ == k) {
          this.field_conRemarkPYFull = paramCursor.getString(i);
        } else if (gka == k) {
          this.field_conRemarkPYShort = paramCursor.getString(i);
        } else if (geK == k) {
          this.field_lvbuff = paramCursor.getBlob(i);
        } else if (gkb == k) {
          this.field_verifyFlag = paramCursor.getInt(i);
        } else if (gkc == k) {
          this.field_encryptUsername = paramCursor.getString(i);
        } else if (gkd == k) {
          this.field_chatroomFlag = paramCursor.getInt(i);
        } else if (gke == k) {
          this.field_deleteFlag = paramCursor.getInt(i);
        } else if (gkf == k) {
          this.field_contactLabelIds = paramCursor.getString(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    pD();
    GMTrace.o(13352248016896L, 99482);
  }
  
  public void bO(String paramString)
  {
    GMTrace.i(13349429444608L, 99461);
    this.field_alias = paramString;
    this.gjC = true;
    GMTrace.o(13349429444608L, 99461);
  }
  
  public void bP(String paramString)
  {
    GMTrace.i(13349697880064L, 99463);
    this.field_conRemark = paramString;
    this.gjD = true;
    GMTrace.o(13349697880064L, 99463);
  }
  
  public void bQ(String paramString)
  {
    GMTrace.i(13349832097792L, 99464);
    this.field_domainList = paramString;
    this.gjE = true;
    GMTrace.o(13349832097792L, 99464);
  }
  
  public void bR(String paramString)
  {
    GMTrace.i(13349966315520L, 99465);
    this.field_nickname = paramString;
    this.ghG = true;
    GMTrace.o(13349966315520L, 99465);
  }
  
  public void bS(String paramString)
  {
    GMTrace.i(13350100533248L, 99466);
    this.field_pyInitial = paramString;
    this.gjF = true;
    GMTrace.o(13350100533248L, 99466);
  }
  
  public void bT(String paramString)
  {
    GMTrace.i(13350368968704L, 99468);
    this.field_quanPin = paramString;
    this.gjG = true;
    GMTrace.o(13350368968704L, 99468);
  }
  
  public void bU(String paramString)
  {
    GMTrace.i(13351040057344L, 99473);
    this.field_weiboNickname = paramString;
    this.gjJ = true;
    GMTrace.o(13351040057344L, 99473);
  }
  
  public void bV(String paramString)
  {
    GMTrace.i(13351174275072L, 99474);
    this.field_conRemarkPYFull = paramString;
    this.gjK = true;
    GMTrace.o(13351174275072L, 99474);
  }
  
  public void bW(String paramString)
  {
    GMTrace.i(13351308492800L, 99475);
    this.field_conRemarkPYShort = paramString;
    this.gjL = true;
    GMTrace.o(13351308492800L, 99475);
  }
  
  public void bX(String paramString)
  {
    GMTrace.i(13351711145984L, 99478);
    this.field_encryptUsername = paramString;
    this.gjN = true;
    GMTrace.o(13351711145984L, 99478);
  }
  
  public void bY(String paramString)
  {
    GMTrace.i(13352113799168L, 99481);
    this.field_contactLabelIds = paramString;
    this.gjQ = true;
    GMTrace.o(13352113799168L, 99481);
  }
  
  public void bZ(String paramString)
  {
    GMTrace.i(13352784887808L, 99486);
    this.gki = paramString;
    this.geo = true;
    GMTrace.o(13352784887808L, 99486);
  }
  
  public void ca(String paramString)
  {
    GMTrace.i(13353187540992L, 99489);
    this.gkk = paramString;
    this.geo = true;
    GMTrace.o(13353187540992L, 99489);
  }
  
  public void cb(String paramString)
  {
    GMTrace.i(13353321758720L, 99490);
    this.fOz = paramString;
    this.geo = true;
    GMTrace.o(13353321758720L, 99490);
  }
  
  public void cc(String paramString)
  {
    GMTrace.i(13353724411904L, 99493);
    this.gkn = paramString;
    this.geo = true;
    GMTrace.o(13353724411904L, 99493);
  }
  
  public void cd(String paramString)
  {
    GMTrace.i(13353858629632L, 99494);
    this.gko = paramString;
    this.geo = true;
    GMTrace.o(13353858629632L, 99494);
  }
  
  public void ce(String paramString)
  {
    GMTrace.i(13354261282816L, 99497);
    this.signature = paramString;
    this.geo = true;
    GMTrace.o(13354261282816L, 99497);
  }
  
  public void cf(String paramString)
  {
    GMTrace.i(13354529718272L, 99499);
    this.gkr = paramString;
    this.geo = true;
    GMTrace.o(13354529718272L, 99499);
  }
  
  public void cg(String paramString)
  {
    GMTrace.i(13354798153728L, 99501);
    this.gks = paramString;
    this.geo = true;
    GMTrace.o(13354798153728L, 99501);
  }
  
  public void ch(String paramString)
  {
    GMTrace.i(13354932371456L, 99502);
    this.gkt = paramString;
    this.geo = true;
    GMTrace.o(13354932371456L, 99502);
  }
  
  public void ci(String paramString)
  {
    GMTrace.i(13355469242368L, 99506);
    this.gkv = paramString;
    this.geo = true;
    GMTrace.o(13355469242368L, 99506);
  }
  
  public void cj(String paramString)
  {
    GMTrace.i(13355603460096L, 99507);
    this.gkw = paramString;
    this.geo = true;
    GMTrace.o(13355603460096L, 99507);
  }
  
  public void ck(String paramString)
  {
    GMTrace.i(13355737677824L, 99508);
    this.gkx = paramString;
    this.geo = true;
    GMTrace.o(13355737677824L, 99508);
  }
  
  public void cl(String paramString)
  {
    GMTrace.i(13356140331008L, 99511);
    this.gkA = paramString;
    this.geo = true;
    GMTrace.o(13356140331008L, 99511);
  }
  
  public void cm(String paramString)
  {
    GMTrace.i(13356274548736L, 99512);
    this.gkB = paramString;
    this.geo = true;
    GMTrace.o(13356274548736L, 99512);
  }
  
  public void cn(String paramString)
  {
    GMTrace.i(13356408766464L, 99513);
    this.gkC = paramString;
    this.geo = true;
    GMTrace.o(13356408766464L, 99513);
  }
  
  public void co(String paramString)
  {
    GMTrace.i(13356542984192L, 99514);
    this.gkD = paramString;
    this.geo = true;
    GMTrace.o(13356542984192L, 99514);
  }
  
  public void cp(String paramString)
  {
    GMTrace.i(13356677201920L, 99515);
    this.gkE = paramString;
    this.geo = true;
    GMTrace.o(13356677201920L, 99515);
  }
  
  public void cq(String paramString)
  {
    GMTrace.i(13356811419648L, 99516);
    this.gkF = paramString;
    this.geo = true;
    GMTrace.o(13356811419648L, 99516);
  }
  
  public void cr(String paramString)
  {
    GMTrace.i(13356945637376L, 99517);
    this.gkG = paramString;
    this.geo = true;
    GMTrace.o(13356945637376L, 99517);
  }
  
  public void cs(String paramString)
  {
    GMTrace.i(13357079855104L, 99518);
    this.gkH = paramString;
    this.geo = true;
    GMTrace.o(13357079855104L, 99518);
  }
  
  public void dc(int paramInt)
  {
    GMTrace.i(13350637404160L, 99470);
    this.field_showHead = paramInt;
    this.gjH = true;
    GMTrace.o(13350637404160L, 99470);
  }
  
  public void dd(int paramInt)
  {
    GMTrace.i(13350905839616L, 99472);
    this.field_weiboFlag = paramInt;
    this.gjI = true;
    GMTrace.o(13350905839616L, 99472);
  }
  
  public void de(int paramInt)
  {
    GMTrace.i(13351576928256L, 99477);
    this.field_verifyFlag = paramInt;
    this.gjM = true;
    GMTrace.o(13351576928256L, 99477);
  }
  
  public void df(int paramInt)
  {
    GMTrace.i(13351845363712L, 99479);
    this.field_chatroomFlag = paramInt;
    this.gjO = true;
    GMTrace.o(13351845363712L, 99479);
  }
  
  public void dg(int paramInt)
  {
    GMTrace.i(13351979581440L, 99480);
    this.field_deleteFlag = paramInt;
    this.gjP = true;
    GMTrace.o(13351979581440L, 99480);
  }
  
  public void dh(int paramInt)
  {
    GMTrace.i(13352516452352L, 99484);
    this.gkg = paramInt;
    this.geo = true;
    GMTrace.o(13352516452352L, 99484);
  }
  
  public void di(int paramInt)
  {
    GMTrace.i(13352650670080L, 99485);
    this.gkh = paramInt;
    this.geo = true;
    GMTrace.o(13352650670080L, 99485);
  }
  
  public void dj(int paramInt)
  {
    GMTrace.i(13353053323264L, 99488);
    this.uin = paramInt;
    this.geo = true;
    GMTrace.o(13353053323264L, 99488);
  }
  
  public void dk(int paramInt)
  {
    GMTrace.i(13353455976448L, 99491);
    this.gkl = paramInt;
    this.geo = true;
    GMTrace.o(13353455976448L, 99491);
  }
  
  public void dl(int paramInt)
  {
    GMTrace.i(13353590194176L, 99492);
    this.gkm = paramInt;
    this.geo = true;
    GMTrace.o(13353590194176L, 99492);
  }
  
  public void dm(int paramInt)
  {
    GMTrace.i(13353992847360L, 99495);
    this.gkp = paramInt;
    this.geo = true;
    GMTrace.o(13353992847360L, 99495);
  }
  
  public void dn(int paramInt)
  {
    GMTrace.i(13354127065088L, 99496);
    this.gkq = paramInt;
    this.geo = true;
    GMTrace.o(13354127065088L, 99496);
  }
  
  public void jdMethod_do(int paramInt)
  {
    GMTrace.i(13355066589184L, 99503);
    this.gku = paramInt;
    this.geo = true;
    GMTrace.o(13355066589184L, 99503);
  }
  
  public void dp(int paramInt)
  {
    GMTrace.i(13355871895552L, 99509);
    this.gky = paramInt;
    this.geo = true;
    GMTrace.o(13355871895552L, 99509);
  }
  
  public void dq(int paramInt)
  {
    GMTrace.i(13356006113280L, 99510);
    this.gkz = paramInt;
    this.geo = true;
    GMTrace.o(13356006113280L, 99510);
  }
  
  public final void dr(int paramInt)
  {
    GMTrace.i(17535814598656L, 130652);
    this.gkI = paramInt;
    this.geo = true;
    GMTrace.o(17535814598656L, 130652);
  }
  
  public String getCity()
  {
    GMTrace.i(13354663936000L, 99500);
    String str = this.gks;
    GMTrace.o(13354663936000L, 99500);
    return str;
  }
  
  public String getProvince()
  {
    GMTrace.i(13354395500544L, 99498);
    String str = this.gkr;
    GMTrace.o(13354395500544L, 99498);
    return str;
  }
  
  public int getSource()
  {
    GMTrace.i(13355200806912L, 99504);
    int i = this.cFR;
    GMTrace.o(13355200806912L, 99504);
    return i;
  }
  
  public final String getUsername()
  {
    GMTrace.i(13349295226880L, 99460);
    String str = this.field_username;
    GMTrace.o(13349295226880L, 99460);
    return str;
  }
  
  public String pA()
  {
    GMTrace.i(13349563662336L, 99462);
    String str = this.field_alias;
    GMTrace.o(13349563662336L, 99462);
    return str;
  }
  
  public String pB()
  {
    GMTrace.i(13350234750976L, 99467);
    String str = this.field_pyInitial;
    GMTrace.o(13350234750976L, 99467);
    return str;
  }
  
  public String pC()
  {
    GMTrace.i(13350503186432L, 99469);
    String str = this.field_quanPin;
    GMTrace.o(13350503186432L, 99469);
    return str;
  }
  
  public final void pD()
  {
    GMTrace.i(13357214072832L, 99519);
    try
    {
      if (this.field_lvbuff != null)
      {
        i = this.field_lvbuff.length;
        if (i != 0) {}
      }
      else
      {
        GMTrace.o(13357214072832L, 99519);
        return;
      }
      s locals = new s();
      int i = locals.bh(this.field_lvbuff);
      if (i != 0)
      {
        v.e("MicroMsg.SDK.BaseContact", "parse LVBuffer error:" + i);
        GMTrace.o(13357214072832L, 99519);
        return;
      }
      this.gkg = locals.getInt();
      this.gkh = locals.getInt();
      this.gki = locals.getString();
      this.gkj = locals.getLong();
      this.uin = locals.getInt();
      this.gkk = locals.getString();
      this.fOz = locals.getString();
      this.gkl = locals.getInt();
      this.gkm = locals.getInt();
      this.gkn = locals.getString();
      this.gko = locals.getString();
      this.gkp = locals.getInt();
      this.gkq = locals.getInt();
      this.signature = locals.getString();
      this.gkr = locals.getString();
      this.gks = locals.getString();
      this.gkt = locals.getString();
      this.gku = locals.getInt();
      this.cFR = locals.getInt();
      this.gkv = locals.getString();
      this.field_verifyFlag = locals.getInt();
      this.gkw = locals.getString();
      if (!locals.bIw()) {
        this.gkx = locals.getString();
      }
      if (!locals.bIw()) {
        this.gky = locals.getInt();
      }
      if (!locals.bIw()) {
        this.gkz = locals.getInt();
      }
      if (!locals.bIw()) {
        this.gkA = locals.getString();
      }
      if (!locals.bIw()) {
        this.gkB = locals.getString();
      }
      if (!locals.bIw()) {
        this.gkC = locals.getString();
      }
      if (!locals.bIw()) {
        this.gkD = locals.getString();
      }
      if (!locals.bIw()) {
        this.gkE = locals.getString();
      }
      if (!locals.bIw()) {
        this.gkF = locals.getString();
      }
      if (!locals.bIw()) {
        this.gkG = locals.getString();
      }
      if (!locals.bIw()) {
        this.gkH = locals.getString();
      }
      if (!locals.bIw()) {
        this.gkI = locals.getInt();
      }
      GMTrace.o(13357214072832L, 99519);
      return;
    }
    catch (Exception localException)
    {
      v.e("MicroMsg.SDK.BaseContact", "get value failed");
      GMTrace.o(13357214072832L, 99519);
    }
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(13352382234624L, 99483);
    try
    {
      if (this.geo)
      {
        localObject = new s();
        ((s)localObject).bIx();
        ((s)localObject).yo(this.gkg);
        ((s)localObject).yo(this.gkh);
        ((s)localObject).Pl(this.gki);
        ((s)localObject).es(this.gkj);
        ((s)localObject).yo(this.uin);
        ((s)localObject).Pl(this.gkk);
        ((s)localObject).Pl(this.fOz);
        ((s)localObject).yo(this.gkl);
        ((s)localObject).yo(this.gkm);
        ((s)localObject).Pl(this.gkn);
        ((s)localObject).Pl(this.gko);
        ((s)localObject).yo(this.gkp);
        ((s)localObject).yo(this.gkq);
        ((s)localObject).Pl(this.signature);
        ((s)localObject).Pl(this.gkr);
        ((s)localObject).Pl(this.gks);
        ((s)localObject).Pl(this.gkt);
        ((s)localObject).yo(this.gku);
        ((s)localObject).yo(this.cFR);
        ((s)localObject).Pl(this.gkv);
        ((s)localObject).yo(this.field_verifyFlag);
        ((s)localObject).Pl(this.gkw);
        ((s)localObject).Pl(this.gkx);
        ((s)localObject).yo(this.gky);
        ((s)localObject).yo(this.gkz);
        ((s)localObject).Pl(this.gkA);
        ((s)localObject).Pl(this.gkB);
        ((s)localObject).Pl(this.gkC);
        ((s)localObject).Pl(this.gkD);
        ((s)localObject).Pl(this.gkE);
        ((s)localObject).Pl(this.gkF);
        ((s)localObject).Pl(this.gkG);
        ((s)localObject).Pl(this.gkH);
        ((s)localObject).yo(this.gkI);
        this.field_lvbuff = ((s)localObject).bIy();
      }
      Object localObject = new ContentValues();
      if (this.field_username == null) {
        this.field_username = "";
      }
      if (this.gdi) {
        ((ContentValues)localObject).put("username", this.field_username);
      }
      if (this.field_alias == null) {
        this.field_alias = "";
      }
      if (this.gjC) {
        ((ContentValues)localObject).put("alias", this.field_alias);
      }
      if (this.field_conRemark == null) {
        this.field_conRemark = "";
      }
      if (this.gjD) {
        ((ContentValues)localObject).put("conRemark", this.field_conRemark);
      }
      if (this.field_domainList == null) {
        this.field_domainList = "";
      }
      if (this.gjE) {
        ((ContentValues)localObject).put("domainList", this.field_domainList);
      }
      if (this.field_nickname == null) {
        this.field_nickname = "";
      }
      if (this.ghG) {
        ((ContentValues)localObject).put("nickname", this.field_nickname);
      }
      if (this.field_pyInitial == null) {
        this.field_pyInitial = "";
      }
      if (this.gjF) {
        ((ContentValues)localObject).put("pyInitial", this.field_pyInitial);
      }
      if (this.field_quanPin == null) {
        this.field_quanPin = "";
      }
      if (this.gjG) {
        ((ContentValues)localObject).put("quanPin", this.field_quanPin);
      }
      if (this.gjH) {
        ((ContentValues)localObject).put("showHead", Integer.valueOf(this.field_showHead));
      }
      if (this.gbu) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.gjI) {
        ((ContentValues)localObject).put("weiboFlag", Integer.valueOf(this.field_weiboFlag));
      }
      if (this.field_weiboNickname == null) {
        this.field_weiboNickname = "";
      }
      if (this.gjJ) {
        ((ContentValues)localObject).put("weiboNickname", this.field_weiboNickname);
      }
      if (this.field_conRemarkPYFull == null) {
        this.field_conRemarkPYFull = "";
      }
      if (this.gjK) {
        ((ContentValues)localObject).put("conRemarkPYFull", this.field_conRemarkPYFull);
      }
      if (this.field_conRemarkPYShort == null) {
        this.field_conRemarkPYShort = "";
      }
      if (this.gjL) {
        ((ContentValues)localObject).put("conRemarkPYShort", this.field_conRemarkPYShort);
      }
      if (this.geo) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.gjM) {
        ((ContentValues)localObject).put("verifyFlag", Integer.valueOf(this.field_verifyFlag));
      }
      if (this.field_encryptUsername == null) {
        this.field_encryptUsername = "";
      }
      if (this.gjN) {
        ((ContentValues)localObject).put("encryptUsername", this.field_encryptUsername);
      }
      if (this.gjO) {
        ((ContentValues)localObject).put("chatroomFlag", Integer.valueOf(this.field_chatroomFlag));
      }
      if (this.gjP) {
        ((ContentValues)localObject).put("deleteFlag", Integer.valueOf(this.field_deleteFlag));
      }
      if (this.field_contactLabelIds == null) {
        this.field_contactLabelIds = "";
      }
      if (this.gjQ) {
        ((ContentValues)localObject).put("contactLabelIds", this.field_contactLabelIds);
      }
      if (this.uvp > 0L) {
        ((ContentValues)localObject).put("rowid", Long.valueOf(this.uvp));
      }
      GMTrace.o(13352382234624L, 99483);
      return (ContentValues)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.e("MicroMsg.SDK.BaseContact", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public void r(long paramLong)
  {
    GMTrace.i(13352919105536L, 99487);
    this.gkj = paramLong;
    this.geo = true;
    GMTrace.o(13352919105536L, 99487);
  }
  
  public void setSource(int paramInt)
  {
    GMTrace.i(13355335024640L, 99505);
    this.cFR = paramInt;
    this.geo = true;
    GMTrace.o(13355335024640L, 99505);
  }
  
  public void setType(int paramInt)
  {
    GMTrace.i(13350771621888L, 99471);
    this.field_type = paramInt;
    this.gbu = true;
    GMTrace.o(13350771621888L, 99471);
  }
  
  public void setUsername(String paramString)
  {
    GMTrace.i(13349161009152L, 99459);
    this.field_username = paramString;
    this.gdi = true;
    GMTrace.o(13349161009152L, 99459);
  }
  
  public void u(byte[] paramArrayOfByte)
  {
    GMTrace.i(13351442710528L, 99476);
    this.field_lvbuff = paramArrayOfByte;
    this.geo = true;
    GMTrace.o(13351442710528L, 99476);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */