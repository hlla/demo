package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.v;

public final class b
{
  String aIO;
  private String fFN;
  public int fRM;
  String gTO;
  String gkk;
  String hAA;
  String hAB;
  String hAC;
  long hAD;
  String hAa;
  long hAb;
  String hAc;
  String hAd;
  String hAe;
  String hAf;
  String hAg;
  public int hAh;
  public byte[] hAi;
  public int hAj;
  public String hAk;
  public int hAl;
  public String hAm;
  public String hAn;
  public String hAo;
  int hAp;
  public String hAq;
  int hAr;
  int hAs;
  String hAt;
  public String hAu;
  String hAv;
  int hAw;
  String hAx;
  long hAy;
  int hAz;
  public String hre;
  public int hrh;
  private int id;
  public int status;
  public int type;
  public String username;
  
  public b()
  {
    GMTrace.i(4422876790784L, 32953);
    this.fRM = -1;
    this.id = 0;
    this.fFN = "";
    this.hAa = "";
    this.hAb = 0L;
    this.gTO = "";
    this.hAc = "";
    this.hAd = "";
    this.username = "";
    this.aIO = "";
    this.hAe = "";
    this.hAf = "";
    this.type = 0;
    this.hAg = "";
    this.gkk = "";
    this.status = 0;
    this.hre = "";
    this.hrh = 0;
    this.hAh = 0;
    this.hAk = "";
    this.hAl = 0;
    this.hAm = "";
    this.hAn = "";
    this.hAo = "";
    this.hAp = 0;
    this.hAq = "";
    this.hAr = 0;
    this.hAs = 0;
    this.hAt = "";
    this.hAu = "";
    this.hAv = "";
    this.hAw = -1;
    this.hAx = "";
    this.hAy = -1L;
    this.hAz = -1;
    this.hAA = "";
    this.hAB = "";
    this.hAC = "";
    this.hAD = 0L;
    GMTrace.o(4422876790784L, 32953);
  }
  
  private byte[] EP()
  {
    GMTrace.i(4423279443968L, 32956);
    try
    {
      Object localObject = new s();
      ((s)localObject).bIx();
      ((s)localObject).Pl(this.hAk);
      ((s)localObject).yo(this.hAl);
      ((s)localObject).Pl(this.hAm);
      ((s)localObject).Pl(this.hAn);
      ((s)localObject).Pl(this.hAo);
      ((s)localObject).yo(this.hAp);
      ((s)localObject).Pl(this.hAq);
      ((s)localObject).yo(this.hAr);
      ((s)localObject).yo(this.hAs);
      ((s)localObject).Pl(this.hAt);
      ((s)localObject).Pl(this.hAu);
      ((s)localObject).Pl(this.hAv);
      ((s)localObject).yo(this.hAw);
      ((s)localObject).Pl(this.hAx);
      ((s)localObject).es(this.hAy);
      ((s)localObject).yo(this.hAz);
      ((s)localObject).Pl(this.hAA);
      ((s)localObject).Pl(this.hAB);
      ((s)localObject).Pl(this.hAC);
      ((s)localObject).es(this.hAD);
      localObject = ((s)localObject).bIy();
      GMTrace.o(4423279443968L, 32956);
      return (byte[])localObject;
    }
    catch (Exception localException)
    {
      v.printErrStackTrace("MicroMsg.AddrUpload", localException, "", new Object[0]);
      GMTrace.o(4423279443968L, 32956);
    }
    return null;
  }
  
  public static int iY(String paramString)
  {
    GMTrace.i(4423413661696L, 32957);
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString.substring(0, 8), 16);
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        v.printErrStackTrace("MicroMsg.AddrUpload", localException, "md5: %s", new Object[] { paramString });
      }
    }
    i = (int)l1;
    GMTrace.o(4423413661696L, 32957);
    return i;
  }
  
  public final String EQ()
  {
    GMTrace.i(4423682097152L, 32959);
    if (this.fFN == null)
    {
      GMTrace.o(4423682097152L, 32959);
      return "";
    }
    String str = this.fFN;
    GMTrace.o(4423682097152L, 32959);
    return str;
  }
  
  public final String ER()
  {
    GMTrace.i(4423816314880L, 32960);
    if (this.hAa == null)
    {
      GMTrace.o(4423816314880L, 32960);
      return "";
    }
    String str = this.hAa;
    GMTrace.o(4423816314880L, 32960);
    return str;
  }
  
  public final String ES()
  {
    GMTrace.i(4423950532608L, 32961);
    if (this.gTO == null)
    {
      GMTrace.o(4423950532608L, 32961);
      return "";
    }
    String str = this.gTO;
    GMTrace.o(4423950532608L, 32961);
    return str;
  }
  
  public final String ET()
  {
    GMTrace.i(4424084750336L, 32962);
    if (this.hAc == null)
    {
      GMTrace.o(4424084750336L, 32962);
      return "";
    }
    String str = this.hAc;
    GMTrace.o(4424084750336L, 32962);
    return str;
  }
  
  public final String EU()
  {
    GMTrace.i(4424218968064L, 32963);
    if (this.hAd == null)
    {
      GMTrace.o(4424218968064L, 32963);
      return "";
    }
    String str = this.hAd;
    GMTrace.o(4424218968064L, 32963);
    return str;
  }
  
  public final String EV()
  {
    GMTrace.i(4424487403520L, 32965);
    if (this.aIO == null)
    {
      GMTrace.o(4424487403520L, 32965);
      return "";
    }
    String str = this.aIO;
    GMTrace.o(4424487403520L, 32965);
    return str;
  }
  
  public final String EW()
  {
    GMTrace.i(4424621621248L, 32966);
    if (this.hAe == null)
    {
      GMTrace.o(4424621621248L, 32966);
      return "";
    }
    String str = this.hAe;
    GMTrace.o(4424621621248L, 32966);
    return str;
  }
  
  public final String EX()
  {
    GMTrace.i(4424755838976L, 32967);
    if (this.hAf == null)
    {
      GMTrace.o(4424755838976L, 32967);
      return "";
    }
    String str = this.hAf;
    GMTrace.o(4424755838976L, 32967);
    return str;
  }
  
  public final String EY()
  {
    GMTrace.i(4424890056704L, 32968);
    if (this.hAg == null)
    {
      GMTrace.o(4424890056704L, 32968);
      return "";
    }
    String str = this.hAg;
    GMTrace.o(4424890056704L, 32968);
    return str;
  }
  
  public final String EZ()
  {
    GMTrace.i(4425024274432L, 32969);
    if (this.gkk == null)
    {
      GMTrace.o(4425024274432L, 32969);
      return "";
    }
    String str = this.gkk;
    GMTrace.o(4425024274432L, 32969);
    return str;
  }
  
  public final void Fa()
  {
    GMTrace.i(4425158492160L, 32970);
    this.hAh |= 0x1;
    GMTrace.o(4425158492160L, 32970);
  }
  
  public final boolean Fb()
  {
    GMTrace.i(4425292709888L, 32971);
    if ((this.hAh & 0x1) == 0)
    {
      GMTrace.o(4425292709888L, 32971);
      return true;
    }
    GMTrace.o(4425292709888L, 32971);
    return false;
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4423011008512L, 32954);
    iZ(paramCursor.getString(1));
    this.hAa = paramCursor.getString(2);
    this.hAb = paramCursor.getLong(3);
    this.gTO = paramCursor.getString(4);
    this.hAc = paramCursor.getString(5);
    this.hAd = paramCursor.getString(6);
    this.username = paramCursor.getString(7);
    this.aIO = paramCursor.getString(8);
    this.hAe = paramCursor.getString(9);
    this.hAf = paramCursor.getString(10);
    this.type = paramCursor.getInt(11);
    this.hAg = paramCursor.getString(12);
    this.gkk = paramCursor.getString(13);
    int i = paramCursor.getInt(14);
    byte[] arrayOfByte;
    if (i == 65536)
    {
      this.status = 0;
      this.hAh = paramCursor.getInt(17);
      this.hre = paramCursor.getString(15);
      this.hrh = paramCursor.getInt(18);
      this.hAi = paramCursor.getBlob(19);
      if (!bf.bm(this.hAi)) {
        arrayOfByte = this.hAi;
      }
    }
    for (;;)
    {
      try
      {
        locals = new s();
        i = locals.bh(arrayOfByte);
        if (i == 0) {
          continue;
        }
        v.e("MicroMsg.AddrUpload", "parse LVBuffer error:" + i);
      }
      catch (Exception localException)
      {
        s locals;
        v.printErrStackTrace("MicroMsg.AddrUpload", localException, "", new Object[0]);
        continue;
      }
      this.hAj = paramCursor.getInt(20);
      GMTrace.o(4423011008512L, 32954);
      return;
      this.status = i;
      break;
      this.hAk = locals.getString();
      this.hAl = locals.getInt();
      this.hAm = locals.getString();
      this.hAn = locals.getString();
      this.hAo = locals.getString();
      this.hAp = locals.getInt();
      this.hAq = locals.getString();
      this.hAr = locals.getInt();
      this.hAs = locals.getInt();
      this.hAt = locals.getString();
      this.hAu = locals.getString();
      this.hAv = locals.getString();
      this.hAw = locals.getInt();
      this.hAx = locals.getString();
      this.hAy = locals.getLong();
      this.hAz = locals.getInt();
      this.hAA = locals.getString();
      this.hAB = locals.getString();
      this.hAC = locals.getString();
      this.hAD = locals.getLong();
    }
  }
  
  public final String getUsername()
  {
    GMTrace.i(4424353185792L, 32964);
    if (this.username == null)
    {
      GMTrace.o(4424353185792L, 32964);
      return "";
    }
    String str = this.username;
    GMTrace.o(4424353185792L, 32964);
    return str;
  }
  
  public final void iZ(String paramString)
  {
    GMTrace.i(4423547879424L, 32958);
    this.fFN = paramString;
    this.id = iY(paramString);
    GMTrace.o(4423547879424L, 32958);
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(4423145226240L, 32955);
    ContentValues localContentValues = new ContentValues();
    if ((this.fRM & 0x1) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.fRM & 0x2) != 0) {
      localContentValues.put("md5", EQ());
    }
    if ((this.fRM & 0x4) != 0) {
      localContentValues.put("peopleid", ER());
    }
    if ((this.fRM & 0x8) != 0) {
      localContentValues.put("uploadtime", Long.valueOf(this.hAb));
    }
    if ((this.fRM & 0x10) != 0) {
      localContentValues.put("realname", ES());
    }
    if ((this.fRM & 0x20) != 0) {
      localContentValues.put("realnamepyinitial", ET());
    }
    if ((this.fRM & 0x40) != 0) {
      localContentValues.put("realnamequanpin", EU());
    }
    if ((this.fRM & 0x80) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.fRM & 0x100) != 0) {
      localContentValues.put("nickname", EV());
    }
    if ((this.fRM & 0x200) != 0) {
      localContentValues.put("nicknamepyinitial", EW());
    }
    if ((this.fRM & 0x400) != 0) {
      localContentValues.put("nicknamequanpin", EX());
    }
    if ((this.fRM & 0x800) != 0) {
      localContentValues.put("type", Integer.valueOf(this.type));
    }
    if ((this.fRM & 0x1000) != 0) {
      localContentValues.put("moblie", EY());
    }
    if ((this.fRM & 0x2000) != 0) {
      localContentValues.put("email", EZ());
    }
    int i;
    if ((this.fRM & 0x4000) != 0)
    {
      i = this.status;
      if (i != 0) {
        break label495;
      }
      localContentValues.put("status", Integer.valueOf(65536));
    }
    for (;;)
    {
      if ((this.fRM & 0x8000) != 0) {
        localContentValues.put("reserved1", this.hre);
      }
      if ((this.fRM & 0x20000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.hAh));
      }
      if ((this.fRM & 0x40000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.hrh));
      }
      if ((this.fRM & 0x80000) != 0)
      {
        this.hAi = EP();
        localContentValues.put("lvbuf", this.hAi);
      }
      if ((this.fRM & 0x100000) != 0) {
        localContentValues.put("showhead", Integer.valueOf(this.hAj));
      }
      GMTrace.o(4423145226240L, 32955);
      return localContentValues;
      label495:
      localContentValues.put("status", Integer.valueOf(i));
    }
  }
  
  public final int sZ()
  {
    GMTrace.i(4425426927616L, 32972);
    int i = 32;
    int j;
    if (!bf.mA(ET()))
    {
      i = ET().charAt(0);
      if ((i < 97) || (i > 122)) {
        break label82;
      }
      j = (char)(i - 32);
    }
    for (;;)
    {
      GMTrace.o(4425426927616L, 32972);
      return j;
      if (bf.mA(EU())) {
        break;
      }
      i = EU().charAt(0);
      break;
      label82:
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
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelfriend/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */