package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.v;

public abstract class n
  extends c
{
  public static final String[] gaA;
  private static final int gaJ;
  private static final int gaP;
  private static final int gcB;
  private static final int gcP;
  private static final int gdz;
  private static final int geA;
  private static final int geB;
  private static final int geC;
  private static final int geD;
  private static final int geE;
  private static final int geF;
  private static final int geG;
  private static final int geH;
  private static final int geI;
  private static final int geJ;
  private static final int geK;
  private static final int geL;
  private static final int geM;
  private static final int geN;
  private static final int geO;
  private static final int geP;
  private static final int geu;
  private static final int gev;
  private static final int gew;
  private static final int gex;
  private static final int gey;
  private static final int gez;
  public String field_appDiscription;
  public String field_appDiscription_en;
  public String field_appDiscription_tw;
  public String field_appIconUrl;
  public String field_appId;
  public int field_appInfoFlag;
  public String field_appName;
  public String field_appName_en;
  public String field_appName_hk;
  public String field_appName_tw;
  public String field_appStoreUrl;
  public long field_appSupportContentType;
  public String field_appType;
  public int field_appVersion;
  public String field_appWatermarkUrl;
  public int field_authFlag;
  public byte[] field_lvbuff;
  public long field_modifyTime;
  public String field_openId;
  public String field_packageName;
  public int field_serviceAppInfoFlag;
  public int field_serviceAppType;
  public int field_serviceShowFlag;
  public String field_signature;
  public int field_status;
  public long field_svrAppSupportContentType;
  private boolean gaM;
  private boolean gck;
  private boolean gcy;
  private boolean gdY;
  private boolean gdZ;
  private boolean gdm;
  public String geQ;
  public String geR;
  public String geS;
  public int geT;
  public int geU;
  public String geV;
  public String geW;
  public String geX;
  public String geY;
  public String geZ;
  private boolean gea;
  private boolean geb;
  private boolean gec;
  private boolean ged;
  private boolean gee;
  private boolean gef;
  private boolean geg;
  private boolean geh;
  private boolean gei;
  private boolean gej;
  private boolean gek;
  private boolean gel;
  private boolean gem;
  private boolean gen;
  public boolean geo;
  private boolean gep;
  private boolean geq;
  private boolean ger;
  private boolean ges;
  private boolean get;
  public String gfa;
  public int gfb;
  public String gfc;
  public String gfd;
  public String gfe;
  public String gff;
  public String gfg;
  public int gfh;
  public String gfi;
  private int gfj;
  public String gfk;
  public String gfl;
  public String gfm;
  public int gfn;
  
  static
  {
    GMTrace.i(4179003179008L, 31136);
    gaA = new String[] { "CREATE INDEX IF NOT EXISTS appInfo_status_Index ON AppInfo(status)" };
    gcB = "appId".hashCode();
    gdz = "appName".hashCode();
    geu = "appDiscription".hashCode();
    gev = "appIconUrl".hashCode();
    gew = "appStoreUrl".hashCode();
    gex = "appVersion".hashCode();
    gey = "appWatermarkUrl".hashCode();
    gez = "packageName".hashCode();
    gaP = "status".hashCode();
    gcP = "signature".hashCode();
    geA = "modifyTime".hashCode();
    geB = "appName_en".hashCode();
    geC = "appName_tw".hashCode();
    geD = "appName_hk".hashCode();
    geE = "appDiscription_en".hashCode();
    geF = "appDiscription_tw".hashCode();
    geG = "appType".hashCode();
    geH = "openId".hashCode();
    geI = "authFlag".hashCode();
    geJ = "appInfoFlag".hashCode();
    geK = "lvbuff".hashCode();
    geL = "serviceAppType".hashCode();
    geM = "serviceAppInfoFlag".hashCode();
    geN = "serviceShowFlag".hashCode();
    geO = "appSupportContentType".hashCode();
    geP = "svrAppSupportContentType".hashCode();
    gaJ = "rowid".hashCode();
    GMTrace.o(4179003179008L, 31136);
  }
  
  public n()
  {
    GMTrace.i(4176184606720L, 31115);
    this.gck = true;
    this.gdm = true;
    this.gdY = true;
    this.gdZ = true;
    this.gea = true;
    this.geb = true;
    this.gec = true;
    this.ged = true;
    this.gaM = true;
    this.gcy = true;
    this.gee = true;
    this.gef = true;
    this.geg = true;
    this.geh = true;
    this.gei = true;
    this.gej = true;
    this.gek = true;
    this.gel = true;
    this.gem = true;
    this.gen = true;
    this.geo = true;
    this.gep = true;
    this.geq = true;
    this.ger = true;
    this.ges = true;
    this.get = true;
    GMTrace.o(4176184606720L, 31115);
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(4176318824448L, 31116);
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null)
    {
      GMTrace.o(4176318824448L, 31116);
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (gcB == k)
      {
        this.field_appId = paramCursor.getString(i);
        this.gck = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (gdz == k) {
          this.field_appName = paramCursor.getString(i);
        } else if (geu == k) {
          this.field_appDiscription = paramCursor.getString(i);
        } else if (gev == k) {
          this.field_appIconUrl = paramCursor.getString(i);
        } else if (gew == k) {
          this.field_appStoreUrl = paramCursor.getString(i);
        } else if (gex == k) {
          this.field_appVersion = paramCursor.getInt(i);
        } else if (gey == k) {
          this.field_appWatermarkUrl = paramCursor.getString(i);
        } else if (gez == k) {
          this.field_packageName = paramCursor.getString(i);
        } else if (gaP == k) {
          this.field_status = paramCursor.getInt(i);
        } else if (gcP == k) {
          this.field_signature = paramCursor.getString(i);
        } else if (geA == k) {
          this.field_modifyTime = paramCursor.getLong(i);
        } else if (geB == k) {
          this.field_appName_en = paramCursor.getString(i);
        } else if (geC == k) {
          this.field_appName_tw = paramCursor.getString(i);
        } else if (geD == k) {
          this.field_appName_hk = paramCursor.getString(i);
        } else if (geE == k) {
          this.field_appDiscription_en = paramCursor.getString(i);
        } else if (geF == k) {
          this.field_appDiscription_tw = paramCursor.getString(i);
        } else if (geG == k) {
          this.field_appType = paramCursor.getString(i);
        } else if (geH == k) {
          this.field_openId = paramCursor.getString(i);
        } else if (geI == k) {
          this.field_authFlag = paramCursor.getInt(i);
        } else if (geJ == k) {
          this.field_appInfoFlag = paramCursor.getInt(i);
        } else if (geK == k) {
          this.field_lvbuff = paramCursor.getBlob(i);
        } else if (geL == k) {
          this.field_serviceAppType = paramCursor.getInt(i);
        } else if (geM == k) {
          this.field_serviceAppInfoFlag = paramCursor.getInt(i);
        } else if (geN == k) {
          this.field_serviceShowFlag = paramCursor.getInt(i);
        } else if (geO == k) {
          this.field_appSupportContentType = paramCursor.getLong(i);
        } else if (geP == k) {
          this.field_svrAppSupportContentType = paramCursor.getLong(i);
        } else if (gaJ == k) {
          this.uvp = paramCursor.getLong(i);
        }
      }
    }
    try
    {
      if (this.field_lvbuff != null)
      {
        i = this.field_lvbuff.length;
        if (i != 0) {}
      }
      else
      {
        GMTrace.o(4176318824448L, 31116);
        return;
      }
      paramCursor = new s();
      i = paramCursor.bh(this.field_lvbuff);
      if (i != 0)
      {
        v.e("MicroMsg.SDK.BaseAppInfo", "parse LVBuffer error:" + i);
        GMTrace.o(4176318824448L, 31116);
        return;
      }
      this.geQ = paramCursor.getString();
      this.geR = paramCursor.getString();
      this.geS = paramCursor.getString();
      this.geT = paramCursor.getInt();
      this.geU = paramCursor.getInt();
      this.geV = paramCursor.getString();
      this.geW = paramCursor.getString();
      this.geX = paramCursor.getString();
      this.geY = paramCursor.getString();
      if (!paramCursor.bIw()) {
        this.geZ = paramCursor.getString();
      }
      if (!paramCursor.bIw()) {
        this.gfa = paramCursor.getString();
      }
      if (!paramCursor.bIw()) {
        this.gfb = paramCursor.getInt();
      }
      if (!paramCursor.bIw()) {
        this.gfc = paramCursor.getString();
      }
      if (!paramCursor.bIw()) {
        this.gfd = paramCursor.getString();
      }
      if (!paramCursor.bIw()) {
        this.gfe = paramCursor.getString();
      }
      if (!paramCursor.bIw()) {
        this.gff = paramCursor.getString();
      }
      if (!paramCursor.bIw()) {
        this.gfg = paramCursor.getString();
      }
      if (!paramCursor.bIw()) {
        this.gfh = paramCursor.getInt();
      }
      if (!paramCursor.bIw()) {
        this.gfi = paramCursor.getString();
      }
      if (!paramCursor.bIw()) {
        this.gfj = paramCursor.getInt();
      }
      if (!paramCursor.bIw()) {
        this.gfk = paramCursor.getString();
      }
      if (!paramCursor.bIw()) {
        this.gfl = paramCursor.getString();
      }
      if (!paramCursor.bIw()) {
        this.gfm = paramCursor.getString();
      }
      if (!paramCursor.bIw()) {
        this.gfn = paramCursor.getInt();
      }
      GMTrace.o(4176318824448L, 31116);
      return;
    }
    catch (Exception paramCursor)
    {
      v.e("MicroMsg.SDK.BaseAppInfo", "get value failed");
      GMTrace.o(4176318824448L, 31116);
    }
  }
  
  public final void bB(String paramString)
  {
    GMTrace.i(4176587259904L, 31118);
    this.geQ = paramString;
    this.geo = true;
    GMTrace.o(4176587259904L, 31118);
  }
  
  public final void bC(String paramString)
  {
    GMTrace.i(4176721477632L, 31119);
    this.geR = paramString;
    this.geo = true;
    GMTrace.o(4176721477632L, 31119);
  }
  
  public final void bD(String paramString)
  {
    GMTrace.i(4176989913088L, 31121);
    this.geS = paramString;
    this.geo = true;
    GMTrace.o(4176989913088L, 31121);
  }
  
  public final void bE(String paramString)
  {
    GMTrace.i(4177124130816L, 31122);
    this.geV = paramString;
    this.geo = true;
    GMTrace.o(4177124130816L, 31122);
  }
  
  public final void bF(String paramString)
  {
    GMTrace.i(4177258348544L, 31123);
    this.geW = paramString;
    this.geo = true;
    GMTrace.o(4177258348544L, 31123);
  }
  
  public final void bG(String paramString)
  {
    GMTrace.i(4177526784000L, 31125);
    this.geX = paramString;
    this.geo = true;
    GMTrace.o(4177526784000L, 31125);
  }
  
  public final void bH(String paramString)
  {
    GMTrace.i(4177795219456L, 31127);
    this.geY = paramString;
    this.geo = true;
    GMTrace.o(4177795219456L, 31127);
  }
  
  public final void bI(String paramString)
  {
    GMTrace.i(4177929437184L, 31128);
    this.geZ = paramString;
    this.geo = true;
    GMTrace.o(4177929437184L, 31128);
  }
  
  public final void bJ(String paramString)
  {
    GMTrace.i(4178063654912L, 31129);
    this.gfa = paramString;
    this.geo = true;
    GMTrace.o(4178063654912L, 31129);
  }
  
  public final void bK(String paramString)
  {
    GMTrace.i(4178332090368L, 31131);
    this.gfc = paramString;
    this.geo = true;
    GMTrace.o(4178332090368L, 31131);
  }
  
  public final void bL(String paramString)
  {
    GMTrace.i(4178466308096L, 31132);
    this.gfd = paramString;
    this.geo = true;
    GMTrace.o(4178466308096L, 31132);
  }
  
  public final void bM(String paramString)
  {
    GMTrace.i(4178600525824L, 31133);
    this.gfe = paramString;
    this.geo = true;
    GMTrace.o(4178600525824L, 31133);
  }
  
  public final void bN(String paramString)
  {
    GMTrace.i(4178734743552L, 31134);
    this.gff = paramString;
    this.geo = true;
    GMTrace.o(4178734743552L, 31134);
  }
  
  public final void da(int paramInt)
  {
    GMTrace.i(4178197872640L, 31130);
    this.gfb = paramInt;
    this.geo = true;
    GMTrace.o(4178197872640L, 31130);
  }
  
  public final void db(int paramInt)
  {
    GMTrace.i(4178868961280L, 31135);
    this.gfh = paramInt;
    this.geo = true;
    GMTrace.o(4178868961280L, 31135);
  }
  
  public ContentValues pv()
  {
    GMTrace.i(4176453042176L, 31117);
    try
    {
      if (this.geo)
      {
        localObject = new s();
        ((s)localObject).bIx();
        ((s)localObject).Pl(this.geQ);
        ((s)localObject).Pl(this.geR);
        ((s)localObject).Pl(this.geS);
        ((s)localObject).yo(this.geT);
        ((s)localObject).yo(this.geU);
        ((s)localObject).Pl(this.geV);
        ((s)localObject).Pl(this.geW);
        ((s)localObject).Pl(this.geX);
        ((s)localObject).Pl(this.geY);
        ((s)localObject).Pl(this.geZ);
        ((s)localObject).Pl(this.gfa);
        ((s)localObject).yo(this.gfb);
        ((s)localObject).Pl(this.gfc);
        ((s)localObject).Pl(this.gfd);
        ((s)localObject).Pl(this.gfe);
        ((s)localObject).Pl(this.gff);
        ((s)localObject).Pl(this.gfg);
        ((s)localObject).yo(this.gfh);
        ((s)localObject).Pl(this.gfi);
        ((s)localObject).yo(this.gfj);
        ((s)localObject).Pl(this.gfk);
        ((s)localObject).Pl(this.gfl);
        ((s)localObject).Pl(this.gfm);
        ((s)localObject).yo(this.gfn);
        this.field_lvbuff = ((s)localObject).bIy();
      }
      Object localObject = new ContentValues();
      if (this.field_appId == null) {
        this.field_appId = "";
      }
      if (this.gck) {
        ((ContentValues)localObject).put("appId", this.field_appId);
      }
      if (this.gdm) {
        ((ContentValues)localObject).put("appName", this.field_appName);
      }
      if (this.gdY) {
        ((ContentValues)localObject).put("appDiscription", this.field_appDiscription);
      }
      if (this.gdZ) {
        ((ContentValues)localObject).put("appIconUrl", this.field_appIconUrl);
      }
      if (this.gea) {
        ((ContentValues)localObject).put("appStoreUrl", this.field_appStoreUrl);
      }
      if (this.geb) {
        ((ContentValues)localObject).put("appVersion", Integer.valueOf(this.field_appVersion));
      }
      if (this.gec) {
        ((ContentValues)localObject).put("appWatermarkUrl", this.field_appWatermarkUrl);
      }
      if (this.ged) {
        ((ContentValues)localObject).put("packageName", this.field_packageName);
      }
      if (this.gaM) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.gcy) {
        ((ContentValues)localObject).put("signature", this.field_signature);
      }
      if (this.gee) {
        ((ContentValues)localObject).put("modifyTime", Long.valueOf(this.field_modifyTime));
      }
      if (this.gef) {
        ((ContentValues)localObject).put("appName_en", this.field_appName_en);
      }
      if (this.geg) {
        ((ContentValues)localObject).put("appName_tw", this.field_appName_tw);
      }
      if (this.geh) {
        ((ContentValues)localObject).put("appName_hk", this.field_appName_hk);
      }
      if (this.gei) {
        ((ContentValues)localObject).put("appDiscription_en", this.field_appDiscription_en);
      }
      if (this.gej) {
        ((ContentValues)localObject).put("appDiscription_tw", this.field_appDiscription_tw);
      }
      if (this.gek) {
        ((ContentValues)localObject).put("appType", this.field_appType);
      }
      if (this.gel) {
        ((ContentValues)localObject).put("openId", this.field_openId);
      }
      if (this.gem) {
        ((ContentValues)localObject).put("authFlag", Integer.valueOf(this.field_authFlag));
      }
      if (this.gen) {
        ((ContentValues)localObject).put("appInfoFlag", Integer.valueOf(this.field_appInfoFlag));
      }
      if (this.geo) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.gep) {
        ((ContentValues)localObject).put("serviceAppType", Integer.valueOf(this.field_serviceAppType));
      }
      if (this.geq) {
        ((ContentValues)localObject).put("serviceAppInfoFlag", Integer.valueOf(this.field_serviceAppInfoFlag));
      }
      if (this.ger) {
        ((ContentValues)localObject).put("serviceShowFlag", Integer.valueOf(this.field_serviceShowFlag));
      }
      if (this.ges) {
        ((ContentValues)localObject).put("appSupportContentType", Long.valueOf(this.field_appSupportContentType));
      }
      if (this.get) {
        ((ContentValues)localObject).put("svrAppSupportContentType", Long.valueOf(this.field_svrAppSupportContentType));
      }
      if (this.uvp > 0L) {
        ((ContentValues)localObject).put("rowid", Long.valueOf(this.uvp));
      }
      GMTrace.o(4176453042176L, 31117);
      return (ContentValues)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        v.e("MicroMsg.SDK.BaseAppInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final String px()
  {
    GMTrace.i(4176855695360L, 31120);
    String str = this.geS;
    GMTrace.o(4176855695360L, 31120);
    return str;
  }
  
  public final String py()
  {
    GMTrace.i(4177392566272L, 31124);
    String str = this.geX;
    GMTrace.o(4177392566272L, 31124);
    return str;
  }
  
  public final String pz()
  {
    GMTrace.i(4177661001728L, 31126);
    String str = this.geY;
    GMTrace.o(4177661001728L, 31126);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/e/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */