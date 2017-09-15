package com.tencent.mm.j;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.a.o;
import com.tencent.mm.e.b.af;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;
import java.util.Map;

public class a
  extends af
{
  public static c.a gTF;
  private static a gTH;
  public long gTG;
  public int versionCode;
  
  static
  {
    GMTrace.i(13263127445504L, 98818);
    c.a locala = new c.a();
    locala.hXn = new Field[19];
    locala.columns = new String[20];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.uvr.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.uvq = "username";
    locala.columns[1] = "alias";
    locala.uvr.put("alias", "TEXT default '' ");
    localStringBuilder.append(" alias TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "conRemark";
    locala.uvr.put("conRemark", "TEXT default '' ");
    localStringBuilder.append(" conRemark TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "domainList";
    locala.uvr.put("domainList", "TEXT default '' ");
    localStringBuilder.append(" domainList TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "nickname";
    locala.uvr.put("nickname", "TEXT default '' ");
    localStringBuilder.append(" nickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "pyInitial";
    locala.uvr.put("pyInitial", "TEXT default '' ");
    localStringBuilder.append(" pyInitial TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "quanPin";
    locala.uvr.put("quanPin", "TEXT default '' ");
    localStringBuilder.append(" quanPin TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "showHead";
    locala.uvr.put("showHead", "INTEGER default '0' ");
    localStringBuilder.append(" showHead INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "type";
    locala.uvr.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "weiboFlag";
    locala.uvr.put("weiboFlag", "INTEGER default '0' ");
    localStringBuilder.append(" weiboFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "weiboNickname";
    locala.uvr.put("weiboNickname", "TEXT default '' ");
    localStringBuilder.append(" weiboNickname TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "conRemarkPYFull";
    locala.uvr.put("conRemarkPYFull", "TEXT default '' ");
    localStringBuilder.append(" conRemarkPYFull TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "conRemarkPYShort";
    locala.uvr.put("conRemarkPYShort", "TEXT default '' ");
    localStringBuilder.append(" conRemarkPYShort TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "lvbuff";
    locala.uvr.put("lvbuff", "BLOB");
    localStringBuilder.append(" lvbuff BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "verifyFlag";
    locala.uvr.put("verifyFlag", "INTEGER default '0' ");
    localStringBuilder.append(" verifyFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "encryptUsername";
    locala.uvr.put("encryptUsername", "TEXT default '' ");
    localStringBuilder.append(" encryptUsername TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "chatroomFlag";
    locala.uvr.put("chatroomFlag", "INTEGER");
    localStringBuilder.append(" chatroomFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "deleteFlag";
    locala.uvr.put("deleteFlag", "INTEGER default '0' ");
    localStringBuilder.append(" deleteFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "contactLabelIds";
    locala.uvr.put("contactLabelIds", "TEXT default '' ");
    localStringBuilder.append(" contactLabelIds TEXT default '' ");
    locala.columns[19] = "rowid";
    locala.uvs = localStringBuilder.toString();
    gTF = locala;
    gTH = null;
    GMTrace.o(13263127445504L, 98818);
  }
  
  public a()
  {
    GMTrace.i(13249437237248L, 98716);
    this.versionCode = 0;
    super.setUsername("");
    super.bR("");
    super.bS("");
    super.bT("");
    super.bO("");
    super.bP("");
    super.bW("");
    super.bV("");
    super.bQ("");
    super.dd(0);
    super.bU("");
    super.dc(0);
    super.setType(0);
    super.de(0);
    super.df(0);
    super.bY("");
    super.di(0);
    super.ch("");
    super.jdMethod_do(0);
    super.dj(0);
    super.ca("");
    super.cb("");
    super.dk(0);
    super.dl(0);
    super.cc("");
    super.cd("");
    super.dm(1);
    super.dh(0);
    super.dn(0);
    super.ce("");
    super.cf("");
    super.cg("");
    super.setSource(0);
    super.cj("");
    super.ci("");
    super.r(0L);
    super.bZ("");
    super.ck("");
    super.dp(0);
    super.cn("");
    super.co("");
    super.cp("");
    super.cs("");
    this.versionCode = 0;
    GMTrace.o(13249437237248L, 98716);
  }
  
  public a(String paramString)
  {
    this();
    GMTrace.i(13249303019520L, 98715);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    setUsername(str);
    GMTrace.o(13249303019520L, 98715);
  }
  
  public static void a(a parama)
  {
    GMTrace.i(13249571454976L, 98717);
    gTH = parama;
    GMTrace.o(13249571454976L, 98717);
  }
  
  public static String dM(String paramString)
  {
    GMTrace.i(13249705672704L, 98718);
    if (gTH != null)
    {
      paramString = gTH.bs(paramString);
      GMTrace.o(13249705672704L, 98718);
      return paramString;
    }
    GMTrace.o(13249705672704L, 98718);
    return null;
  }
  
  public static String dN(String paramString)
  {
    GMTrace.i(13255745470464L, 98763);
    if (paramString == null)
    {
      GMTrace.o(13255745470464L, 98763);
      return null;
    }
    if (paramString.toLowerCase().endsWith("@t.qq.com"))
    {
      paramString = "@" + paramString.replace("@t.qq.com", "");
      GMTrace.o(13255745470464L, 98763);
      return paramString;
    }
    if (paramString.toLowerCase().endsWith("@qqim"))
    {
      paramString = paramString.replace("@qqim", "");
      long l = Long.valueOf(paramString).longValue();
      if (l < 0L)
      {
        paramString = new o(l).toString();
        GMTrace.o(13255745470464L, 98763);
        return paramString;
      }
      GMTrace.o(13255745470464L, 98763);
      return paramString;
    }
    GMTrace.o(13255745470464L, 98763);
    return paramString;
  }
  
  public static boolean ez(int paramInt)
  {
    GMTrace.i(13252926898176L, 98742);
    if ((paramInt & 0x1) != 0)
    {
      GMTrace.o(13252926898176L, 98742);
      return true;
    }
    GMTrace.o(13252926898176L, 98742);
    return false;
  }
  
  private static boolean isLetter(char paramChar)
  {
    GMTrace.i(13254403293184L, 98753);
    if (((paramChar >= 'A') && (paramChar <= 'Z')) || ((paramChar >= 'a') && (paramChar <= 'z')))
    {
      GMTrace.o(13254403293184L, 98753);
      return true;
    }
    GMTrace.o(13254403293184L, 98753);
    return false;
  }
  
  private int tO()
  {
    GMTrace.i(13256148123648L, 98766);
    int i = this.versionCode + 1;
    this.versionCode = i;
    GMTrace.o(13256148123648L, 98766);
    return i;
  }
  
  public static int tt()
  {
    GMTrace.i(13252255809536L, 98737);
    GMTrace.o(13252255809536L, 98737);
    return 1;
  }
  
  public static int tu()
  {
    GMTrace.i(13252390027264L, 98738);
    GMTrace.o(13252390027264L, 98738);
    return 8;
  }
  
  public static int tv()
  {
    GMTrace.i(16765539057664L, 124913);
    GMTrace.o(16765539057664L, 124913);
    return 524288;
  }
  
  public static int tw()
  {
    GMTrace.i(13252524244992L, 98739);
    GMTrace.o(13252524244992L, 98739);
    return 16;
  }
  
  public static int tx()
  {
    GMTrace.i(13252658462720L, 98740);
    GMTrace.o(13252658462720L, 98740);
    return 32;
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(13256013905920L, 98765);
    super.b(paramCursor);
    this.gTG = this.uvp;
    super.u(null);
    GMTrace.o(13256013905920L, 98765);
  }
  
  public final void bO(String paramString)
  {
    GMTrace.i(13256416559104L, 98768);
    if (!bf.eB(pA(), paramString))
    {
      super.bO(paramString);
      tO();
    }
    GMTrace.o(13256416559104L, 98768);
  }
  
  public final void bP(String paramString)
  {
    GMTrace.i(13256550776832L, 98769);
    if (!bf.eB(this.field_conRemark, paramString))
    {
      super.bP(paramString);
      tO();
    }
    GMTrace.o(13256550776832L, 98769);
  }
  
  public final void bQ(String paramString)
  {
    GMTrace.i(13256684994560L, 98770);
    if (!bf.eB(this.field_domainList, paramString))
    {
      super.bQ(paramString);
      tO();
    }
    GMTrace.o(13256684994560L, 98770);
  }
  
  public final void bR(String paramString)
  {
    GMTrace.i(13256819212288L, 98771);
    if (!bf.eB(this.field_nickname, paramString))
    {
      super.bR(paramString);
      tO();
    }
    GMTrace.o(13256819212288L, 98771);
  }
  
  public final void bS(String paramString)
  {
    GMTrace.i(13256953430016L, 98772);
    if (!bf.eB(pB(), paramString))
    {
      super.bS(paramString);
      tO();
    }
    GMTrace.o(13256953430016L, 98772);
  }
  
  public final void bT(String paramString)
  {
    GMTrace.i(13257087647744L, 98773);
    if (!bf.eB(pC(), paramString))
    {
      super.bT(paramString);
      tO();
    }
    GMTrace.o(13257087647744L, 98773);
  }
  
  public final void bU(String paramString)
  {
    GMTrace.i(13257624518656L, 98777);
    if (!bf.eB(this.field_weiboNickname, paramString))
    {
      super.bU(paramString);
      tO();
    }
    GMTrace.o(13257624518656L, 98777);
  }
  
  public final void bV(String paramString)
  {
    GMTrace.i(13257758736384L, 98778);
    if (!bf.eB(this.field_conRemarkPYFull, paramString))
    {
      super.bV(paramString);
      tO();
    }
    GMTrace.o(13257758736384L, 98778);
  }
  
  public final void bW(String paramString)
  {
    GMTrace.i(13257892954112L, 98779);
    if (!bf.eB(this.field_conRemarkPYShort, paramString))
    {
      super.bW(paramString);
      tO();
    }
    GMTrace.o(13257892954112L, 98779);
  }
  
  public final void bX(String paramString)
  {
    GMTrace.i(13258295607296L, 98782);
    if (!bf.eB(this.field_encryptUsername, paramString))
    {
      super.bX(paramString);
      tO();
    }
    GMTrace.o(13258295607296L, 98782);
  }
  
  public final void bY(String paramString)
  {
    GMTrace.i(13258698260480L, 98785);
    if (!bf.eB(this.field_contactLabelIds, paramString))
    {
      super.bY(paramString);
      tO();
    }
    GMTrace.o(13258698260480L, 98785);
  }
  
  public final void bZ(String paramString)
  {
    GMTrace.i(13259100913664L, 98788);
    if (!bf.eB(this.gki, paramString))
    {
      super.bZ(paramString);
      tO();
    }
    GMTrace.o(13259100913664L, 98788);
  }
  
  public final void ca(String paramString)
  {
    GMTrace.i(13259503566848L, 98791);
    if (!bf.eB(this.gkk, paramString))
    {
      super.ca(paramString);
      tO();
    }
    GMTrace.o(13259503566848L, 98791);
  }
  
  public final void cb(String paramString)
  {
    GMTrace.i(13259637784576L, 98792);
    if (!bf.eB(this.fOz, paramString))
    {
      super.cb(paramString);
      tO();
    }
    GMTrace.o(13259637784576L, 98792);
  }
  
  public final void cc(String paramString)
  {
    GMTrace.i(13260040437760L, 98795);
    if (!bf.eB(this.gkn, paramString))
    {
      super.cc(paramString);
      tO();
    }
    GMTrace.o(13260040437760L, 98795);
  }
  
  public final void cd(String paramString)
  {
    GMTrace.i(13260174655488L, 98796);
    if (!bf.eB(this.gko, paramString))
    {
      super.cd(paramString);
      tO();
    }
    GMTrace.o(13260174655488L, 98796);
  }
  
  public final void ce(String paramString)
  {
    GMTrace.i(13260577308672L, 98799);
    if (!bf.eB(this.signature, paramString))
    {
      super.ce(paramString);
      tO();
    }
    GMTrace.o(13260577308672L, 98799);
  }
  
  public void cf(String paramString)
  {
    GMTrace.i(13260711526400L, 98800);
    if (!bf.eB(getProvince(), paramString))
    {
      super.cf(paramString);
      tO();
    }
    GMTrace.o(13260711526400L, 98800);
  }
  
  public void cg(String paramString)
  {
    GMTrace.i(13260845744128L, 98801);
    if (!bf.eB(getCity(), paramString))
    {
      super.cg(paramString);
      tO();
    }
    GMTrace.o(13260845744128L, 98801);
  }
  
  public final void ch(String paramString)
  {
    GMTrace.i(13260979961856L, 98802);
    if (!bf.eB(this.gkt, paramString))
    {
      super.ch(paramString);
      tO();
    }
    GMTrace.o(13260979961856L, 98802);
  }
  
  public final void ci(String paramString)
  {
    GMTrace.i(13261382615040L, 98805);
    if (!bf.eB(this.gkv, paramString))
    {
      super.ci(paramString);
      tO();
    }
    GMTrace.o(13261382615040L, 98805);
  }
  
  public final void cj(String paramString)
  {
    GMTrace.i(13261516832768L, 98806);
    if (!bf.eB(this.gkw, paramString))
    {
      super.cj(paramString);
      tO();
    }
    GMTrace.o(13261516832768L, 98806);
  }
  
  public void ck(String paramString)
  {
    GMTrace.i(13261651050496L, 98807);
    if (!bf.eB(this.gkx, paramString))
    {
      super.ck(paramString);
      tO();
    }
    GMTrace.o(13261651050496L, 98807);
  }
  
  public final void cl(String paramString)
  {
    GMTrace.i(13262053703680L, 98810);
    if (!bf.eB(this.gkA, paramString))
    {
      super.cl(paramString);
      tO();
    }
    GMTrace.o(13262053703680L, 98810);
  }
  
  public final void cm(String paramString)
  {
    GMTrace.i(13262187921408L, 98811);
    if (!bf.eB(this.gkB, paramString))
    {
      super.cm(paramString);
      tO();
    }
    GMTrace.o(13262187921408L, 98811);
  }
  
  public final void cn(String paramString)
  {
    GMTrace.i(13262322139136L, 98812);
    if (!bf.eB(this.gkC, paramString))
    {
      super.cn(paramString);
      tO();
    }
    GMTrace.o(13262322139136L, 98812);
  }
  
  public final void co(String paramString)
  {
    GMTrace.i(13262456356864L, 98813);
    if (!bf.eB(this.gkD, paramString))
    {
      super.co(paramString);
      tO();
    }
    GMTrace.o(13262456356864L, 98813);
  }
  
  public final void cp(String paramString)
  {
    GMTrace.i(13262590574592L, 98814);
    if (!bf.eB(this.gkE, paramString))
    {
      super.cp(paramString);
      tO();
    }
    GMTrace.o(13262590574592L, 98814);
  }
  
  public final void cq(String paramString)
  {
    GMTrace.i(13262724792320L, 98815);
    if (!bf.eB(this.gkF, paramString))
    {
      super.cq(paramString);
      tO();
    }
    GMTrace.o(13262724792320L, 98815);
  }
  
  public final void cr(String paramString)
  {
    GMTrace.i(13262859010048L, 98816);
    if (!bf.eB(this.gkG, paramString))
    {
      super.cr(paramString);
      tO();
    }
    GMTrace.o(13262859010048L, 98816);
  }
  
  public final void cs(String paramString)
  {
    GMTrace.i(13262993227776L, 98817);
    if (!bf.eB(this.gkH, paramString))
    {
      super.cs(paramString);
      tO();
    }
    GMTrace.o(13262993227776L, 98817);
  }
  
  public final void dc(int paramInt)
  {
    GMTrace.i(13257221865472L, 98774);
    if (!bf.dN(this.field_showHead, paramInt))
    {
      super.dc(paramInt);
      tO();
    }
    GMTrace.o(13257221865472L, 98774);
  }
  
  public final void dd(int paramInt)
  {
    GMTrace.i(13257490300928L, 98776);
    if (!bf.dN(this.field_weiboFlag, paramInt))
    {
      super.dd(paramInt);
      tO();
    }
    GMTrace.o(13257490300928L, 98776);
  }
  
  public final void de(int paramInt)
  {
    GMTrace.i(13258161389568L, 98781);
    if (!bf.dN(this.field_verifyFlag, paramInt))
    {
      super.de(paramInt);
      tO();
    }
    GMTrace.o(13258161389568L, 98781);
  }
  
  public final void df(int paramInt)
  {
    GMTrace.i(13258429825024L, 98783);
    if (!bf.dN(this.field_chatroomFlag, paramInt))
    {
      super.df(paramInt);
      tO();
    }
    GMTrace.o(13258429825024L, 98783);
  }
  
  public final void dg(int paramInt)
  {
    GMTrace.i(13258564042752L, 98784);
    if (!bf.dN(this.field_deleteFlag, paramInt))
    {
      super.dg(paramInt);
      tO();
    }
    GMTrace.o(13258564042752L, 98784);
  }
  
  public final void dh(int paramInt)
  {
    GMTrace.i(13258832478208L, 98786);
    if (!bf.dN(this.gkg, paramInt))
    {
      super.dh(paramInt);
      tO();
    }
    GMTrace.o(13258832478208L, 98786);
  }
  
  public final void di(int paramInt)
  {
    GMTrace.i(13258966695936L, 98787);
    if (!bf.dN(this.gkh, paramInt))
    {
      super.di(paramInt);
      tO();
    }
    GMTrace.o(13258966695936L, 98787);
  }
  
  public final void dj(int paramInt)
  {
    GMTrace.i(13259369349120L, 98790);
    if (!bf.dN(this.uin, paramInt))
    {
      super.dj(paramInt);
      tO();
    }
    GMTrace.o(13259369349120L, 98790);
  }
  
  public final void dk(int paramInt)
  {
    GMTrace.i(13259772002304L, 98793);
    if (!bf.dN(this.gkl, paramInt))
    {
      super.dk(paramInt);
      tO();
    }
    GMTrace.o(13259772002304L, 98793);
  }
  
  public final void dl(int paramInt)
  {
    GMTrace.i(13259906220032L, 98794);
    if (!bf.dN(this.gkm, paramInt))
    {
      super.dl(paramInt);
      tO();
    }
    GMTrace.o(13259906220032L, 98794);
  }
  
  public final void dm(int paramInt)
  {
    GMTrace.i(13260308873216L, 98797);
    if (!bf.dN(this.gkp, paramInt))
    {
      super.dm(paramInt);
      tO();
    }
    GMTrace.o(13260308873216L, 98797);
  }
  
  public final void dn(int paramInt)
  {
    GMTrace.i(13260443090944L, 98798);
    if (!bf.dN(this.gkq, paramInt))
    {
      super.dn(paramInt);
      tO();
    }
    GMTrace.o(13260443090944L, 98798);
  }
  
  public final void jdMethod_do(int paramInt)
  {
    GMTrace.i(13261114179584L, 98803);
    if (!bf.dN(this.gku, paramInt))
    {
      super.jdMethod_do(paramInt);
      tO();
    }
    GMTrace.o(13261114179584L, 98803);
  }
  
  public final void dp(int paramInt)
  {
    GMTrace.i(13261785268224L, 98808);
    if (!bf.dN(this.gky, paramInt))
    {
      super.dp(paramInt);
      tO();
    }
    GMTrace.o(13261785268224L, 98808);
  }
  
  public final void dq(int paramInt)
  {
    GMTrace.i(13261919485952L, 98809);
    if (!bf.dN(this.gkz, paramInt))
    {
      super.dq(paramInt);
      tO();
    }
    GMTrace.o(13261919485952L, 98809);
  }
  
  public final void eA(int paramInt)
  {
    GMTrace.i(13255879688192L, 98764);
    df(this.field_chatroomFlag & 0xFFFFFFFE | paramInt & 0x1);
    GMTrace.o(13255879688192L, 98764);
  }
  
  public final int getSource()
  {
    GMTrace.i(13255477035008L, 98761);
    int i = super.getSource();
    GMTrace.o(13255477035008L, 98761);
    return i % 1000000;
  }
  
  public final boolean isHidden()
  {
    GMTrace.i(13253061115904L, 98743);
    if ((this.field_type & 0x20) != 0)
    {
      GMTrace.o(13253061115904L, 98743);
      return true;
    }
    GMTrace.o(13253061115904L, 98743);
    return false;
  }
  
  public final String pA()
  {
    GMTrace.i(13254940164096L, 98757);
    if (gTH != null) {}
    for (String str = gTH.bt(this.field_username); str == null; str = null)
    {
      str = super.pA();
      GMTrace.o(13254940164096L, 98757);
      return str;
    }
    GMTrace.o(13254940164096L, 98757);
    return str;
  }
  
  public final String pB()
  {
    GMTrace.i(13254671728640L, 98755);
    if ((super.pB() == null) || (super.pB().length() < 0))
    {
      str = pC();
      GMTrace.o(13254671728640L, 98755);
      return str;
    }
    String str = super.pB();
    GMTrace.o(13254671728640L, 98755);
    return str;
  }
  
  public final String pC()
  {
    GMTrace.i(13254805946368L, 98756);
    if ((super.pC() == null) || (super.pC().length() < 0))
    {
      str = this.field_nickname;
      GMTrace.o(13254805946368L, 98756);
      return str;
    }
    String str = super.pC();
    GMTrace.o(13254805946368L, 98756);
    return str;
  }
  
  public final void r(long paramLong)
  {
    GMTrace.i(13259235131392L, 98789);
    if (!bf.x(this.gkj, paramLong))
    {
      super.r(paramLong);
      tO();
    }
    GMTrace.o(13259235131392L, 98789);
  }
  
  public final c.a sY()
  {
    GMTrace.i(13249168801792L, 98714);
    c.a locala = gTF;
    GMTrace.o(13249168801792L, 98714);
    return locala;
  }
  
  public final int sZ()
  {
    GMTrace.i(13249839890432L, 98719);
    int j = 32;
    int i;
    if ((this.field_conRemarkPYShort != null) && (!this.field_conRemarkPYShort.equals("")))
    {
      i = this.field_conRemarkPYShort.charAt(0);
      if ((i < 97) || (i > 122)) {
        break label258;
      }
      j = (char)(i - 32);
    }
    for (;;)
    {
      GMTrace.o(13249839890432L, 98719);
      return j;
      if ((this.field_conRemarkPYFull != null) && (!this.field_conRemarkPYFull.equals("")))
      {
        i = this.field_conRemarkPYFull.charAt(0);
        break;
      }
      if ((super.pB() != null) && (!super.pB().equals("")))
      {
        i = super.pB().charAt(0);
        break;
      }
      if ((super.pC() != null) && (!super.pC().equals("")))
      {
        i = super.pC().charAt(0);
        break;
      }
      if ((this.field_nickname != null) && (!this.field_nickname.equals("")) && (isLetter(this.field_nickname.charAt(0))))
      {
        i = this.field_nickname.charAt(0);
        break;
      }
      i = j;
      if (this.field_username == null) {
        break;
      }
      i = j;
      if (this.field_username.equals("")) {
        break;
      }
      i = j;
      if (!isLetter(this.field_username.charAt(0))) {
        break;
      }
      i = this.field_username.charAt(0);
      break;
      label258:
      if (i >= 65)
      {
        j = i;
        if (i <= 90) {}
      }
      else
      {
        j = 123;
      }
    }
  }
  
  public final void setSource(int paramInt)
  {
    GMTrace.i(13261248397312L, 98804);
    if (!bf.dN(super.getSource(), paramInt))
    {
      super.setSource(paramInt);
      tO();
    }
    GMTrace.o(13261248397312L, 98804);
  }
  
  public final void setType(int paramInt)
  {
    GMTrace.i(13257356083200L, 98775);
    if (!bf.dN(this.field_type, paramInt))
    {
      super.setType(paramInt);
      tO();
    }
    GMTrace.o(13257356083200L, 98775);
  }
  
  public final void setUsername(String paramString)
  {
    GMTrace.i(13256282341376L, 98767);
    if (!bf.eB(this.field_username, paramString))
    {
      super.setUsername(paramString);
      tO();
    }
    GMTrace.o(13256282341376L, 98767);
  }
  
  public final boolean tA()
  {
    GMTrace.i(13253329551360L, 98745);
    if ((this.field_type & 0x8) != 0)
    {
      GMTrace.o(13253329551360L, 98745);
      return true;
    }
    GMTrace.o(13253329551360L, 98745);
    return false;
  }
  
  public final boolean tB()
  {
    GMTrace.i(16765673275392L, 124914);
    if ((0x80000 & this.field_type) != 0)
    {
      GMTrace.o(16765673275392L, 124914);
      return true;
    }
    GMTrace.o(16765673275392L, 124914);
    return false;
  }
  
  public final boolean tC()
  {
    GMTrace.i(13253463769088L, 98746);
    if ((this.field_type & 0x40) != 0)
    {
      GMTrace.o(13253463769088L, 98746);
      return true;
    }
    GMTrace.o(13253463769088L, 98746);
    return false;
  }
  
  public final boolean tD()
  {
    GMTrace.i(13253597986816L, 98747);
    if ((this.field_type & 0x200) != 0)
    {
      GMTrace.o(13253597986816L, 98747);
      return true;
    }
    GMTrace.o(13253597986816L, 98747);
    return false;
  }
  
  public final boolean tE()
  {
    GMTrace.i(13253732204544L, 98748);
    if ((this.field_type & 0x400) == 0)
    {
      GMTrace.o(13253732204544L, 98748);
      return true;
    }
    GMTrace.o(13253732204544L, 98748);
    return false;
  }
  
  public final boolean tF()
  {
    GMTrace.i(13253866422272L, 98749);
    if ((this.field_type & 0x100) != 0)
    {
      GMTrace.o(13253866422272L, 98749);
      return true;
    }
    GMTrace.o(13253866422272L, 98749);
    return false;
  }
  
  public final boolean tG()
  {
    GMTrace.i(13254000640000L, 98750);
    if ((this.field_type & 0x800) != 0)
    {
      GMTrace.o(13254000640000L, 98750);
      return true;
    }
    GMTrace.o(13254000640000L, 98750);
    return false;
  }
  
  public final boolean tH()
  {
    GMTrace.i(13254134857728L, 98751);
    if ((0x8000 & this.field_type) != 0)
    {
      GMTrace.o(13254134857728L, 98751);
      return true;
    }
    GMTrace.o(13254134857728L, 98751);
    return false;
  }
  
  public final void tI()
  {
    GMTrace.i(13254269075456L, 98752);
    setType(this.field_type | 0x8000);
    GMTrace.o(13254269075456L, 98752);
  }
  
  public final int tJ()
  {
    GMTrace.i(13254537510912L, 98754);
    int i = (int)this.gTG;
    GMTrace.o(13254537510912L, 98754);
    return i;
  }
  
  public final String tK()
  {
    GMTrace.i(13255074381824L, 98758);
    if (gTH != null) {}
    for (String str = gTH.bs(this.field_username); str != null; str = null)
    {
      GMTrace.o(13255074381824L, 98758);
      return str;
    }
    if ((this.field_nickname == null) || (this.field_nickname.length() <= 0))
    {
      str = tM();
      GMTrace.o(13255074381824L, 98758);
      return str;
    }
    str = this.field_nickname;
    GMTrace.o(13255074381824L, 98758);
    return str;
  }
  
  public final String tL()
  {
    GMTrace.i(13255208599552L, 98759);
    if ((this.field_conRemark != null) && (!this.field_conRemark.trim().equals("")))
    {
      str = this.field_conRemark;
      GMTrace.o(13255208599552L, 98759);
      return str;
    }
    String str = tK();
    GMTrace.o(13255208599552L, 98759);
    return str;
  }
  
  public final String tM()
  {
    GMTrace.i(13255342817280L, 98760);
    String str = pA();
    if (!bf.mA(str))
    {
      GMTrace.o(13255342817280L, 98760);
      return str;
    }
    str = dN(this.field_username);
    if ((str != null) && (str.length() != 0))
    {
      GMTrace.o(13255342817280L, 98760);
      return str;
    }
    str = this.field_username;
    GMTrace.o(13255342817280L, 98760);
    return str;
  }
  
  public final int tN()
  {
    GMTrace.i(13255611252736L, 98762);
    int i = super.getSource();
    GMTrace.o(13255611252736L, 98762);
    return i;
  }
  
  public final void ta()
  {
    GMTrace.i(13249974108160L, 98720);
    setType(0);
    GMTrace.o(13249974108160L, 98720);
  }
  
  public final void tb()
  {
    GMTrace.i(13250108325888L, 98721);
    setType(this.field_type | 0x4);
    GMTrace.o(13250108325888L, 98721);
  }
  
  public final void tc()
  {
    GMTrace.i(13250242543616L, 98722);
    setType(this.field_type | 0x1);
    GMTrace.o(13250242543616L, 98722);
  }
  
  public final void td()
  {
    GMTrace.i(13250376761344L, 98723);
    v.w("MicroMsg.RContact", "unSetContact!! user:%s oldType:%d [%s]", new Object[] { this.field_username, Integer.valueOf(this.field_type), bf.bJP() });
    setType(this.field_type & 0xFFFFFFFE);
    GMTrace.o(13250376761344L, 98723);
  }
  
  public final void te()
  {
    GMTrace.i(13250510979072L, 98724);
    setType(this.field_type | 0x8);
    GMTrace.o(13250510979072L, 98724);
  }
  
  public final void tf()
  {
    GMTrace.i(13250645196800L, 98725);
    setType(this.field_type & 0xFFFFFFF7);
    GMTrace.o(13250645196800L, 98725);
  }
  
  public final void tg()
  {
    GMTrace.i(16765270622208L, 124911);
    setType(this.field_type | 0x80000);
    GMTrace.o(16765270622208L, 124911);
  }
  
  public final void th()
  {
    GMTrace.i(16765404839936L, 124912);
    setType(this.field_type & 0xFFF7FFFF);
    GMTrace.o(16765404839936L, 124912);
  }
  
  public final void ti()
  {
    GMTrace.i(13250779414528L, 98726);
    setType(this.field_type | 0x2);
    GMTrace.o(13250779414528L, 98726);
  }
  
  public final void tj()
  {
    GMTrace.i(13250913632256L, 98727);
    setType(this.field_type & 0xFFFFFFFD);
    GMTrace.o(13250913632256L, 98727);
  }
  
  public final void tk()
  {
    GMTrace.i(13251047849984L, 98728);
    setType(this.field_type & 0xF7FF);
    GMTrace.o(13251047849984L, 98728);
  }
  
  public final void tl()
  {
    GMTrace.i(13251182067712L, 98729);
    setType(this.field_type | 0x20);
    GMTrace.o(13251182067712L, 98729);
  }
  
  public final void tm()
  {
    GMTrace.i(13251316285440L, 98730);
    setType(this.field_type & 0xFFFFFFDF);
    GMTrace.o(13251316285440L, 98730);
  }
  
  public final void tn()
  {
    GMTrace.i(13251450503168L, 98731);
    setType(this.field_type | 0x40);
    GMTrace.o(13251450503168L, 98731);
  }
  
  public final void to()
  {
    GMTrace.i(13251584720896L, 98732);
    setType(this.field_type & 0xFFFFFFBF);
    GMTrace.o(13251584720896L, 98732);
  }
  
  public final void tp()
  {
    GMTrace.i(13251718938624L, 98733);
    setType(this.field_type | 0x200);
    GMTrace.o(13251718938624L, 98733);
  }
  
  public final void tq()
  {
    GMTrace.i(13251853156352L, 98734);
    setType(this.field_type & 0xFDFF);
    GMTrace.o(13251853156352L, 98734);
  }
  
  public final void tr()
  {
    GMTrace.i(13251987374080L, 98735);
    setType(this.field_type | 0x100);
    GMTrace.o(13251987374080L, 98735);
  }
  
  public final void ts()
  {
    GMTrace.i(13252121591808L, 98736);
    setType(this.field_type & 0xFEFF);
    GMTrace.o(13252121591808L, 98736);
  }
  
  public final boolean ty()
  {
    GMTrace.i(13252792680448L, 98741);
    boolean bool = ez(this.field_type);
    GMTrace.o(13252792680448L, 98741);
    return bool;
  }
  
  public final boolean tz()
  {
    GMTrace.i(13253195333632L, 98744);
    if ((this.field_type & 0x4) != 0)
    {
      GMTrace.o(13253195333632L, 98744);
      return true;
    }
    GMTrace.o(13253195333632L, 98744);
    return false;
  }
  
  public final void u(byte[] paramArrayOfByte)
  {
    GMTrace.i(13258027171840L, 98780);
    if (!bf.isEqual(this.field_lvbuff, paramArrayOfByte))
    {
      super.u(paramArrayOfByte);
      tO();
    }
    GMTrace.o(13258027171840L, 98780);
  }
  
  public static abstract interface a
  {
    public abstract String bs(String paramString);
    
    public abstract String bt(String paramString);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/j/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */