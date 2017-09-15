package com.tencent.mm.t;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class f
  extends com.tencent.mm.e.b.o
{
  public static c.a gTF;
  
  static
  {
    GMTrace.i(312190435328L, 2326);
    c.a locala = new c.a();
    locala.hXn = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.uvr.put("msgId", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.uvq = "msgId";
    locala.columns[1] = "xml";
    locala.uvr.put("xml", "TEXT");
    localStringBuilder.append(" xml TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appId";
    locala.uvr.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "title";
    locala.uvr.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "description";
    locala.uvr.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "source";
    locala.uvr.put("source", "TEXT");
    localStringBuilder.append(" source TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "type";
    locala.uvr.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    locala.columns[7] = "rowid";
    locala.uvs = localStringBuilder.toString();
    gTF = locala;
    if (com.tencent.mm.sdk.a.b.bIk()) {
      Assert.assertTrue(wE());
    }
    GMTrace.o(312190435328L, 2326);
  }
  
  public f()
  {
    GMTrace.i(311921999872L, 2324);
    GMTrace.o(311921999872L, 2324);
  }
  
  private static final boolean wE()
  {
    GMTrace.i(16382079008768L, 122056);
    Field[] arrayOfField = a.class.getDeclaredFields();
    int i = 0;
    int k;
    for (int j = 0; i < arrayOfField.length; j = k)
    {
      k = j;
      if (!Modifier.isStatic(arrayOfField[i].getModifiers())) {
        k = j + 1;
      }
      i += 1;
    }
    if (j > 185)
    {
      v.e("MicroMsg.AppMessage", "AppMessage.Content should not add new field!!! (%d) is over the limit(%d)!!!", new Object[] { Integer.valueOf(j), Integer.valueOf(185) });
      GMTrace.o(16382079008768L, 122056);
      return false;
    }
    v.i("MicroMsg.AppMessage", "AppMessage.Content nonStaticFieldCount: %d", new Object[] { Integer.valueOf(j) });
    GMTrace.o(16382079008768L, 122056);
    return true;
  }
  
  protected final c.a sY()
  {
    GMTrace.i(312056217600L, 2325);
    c.a locala = gTF;
    GMTrace.o(312056217600L, 2325);
    return locala;
  }
  
  public static class a
    extends c
  {
    private static final com.tencent.mm.a.f<Integer, a> hjT;
    public String action;
    public String appId;
    public String appName;
    public String canvasPageXml;
    public String content;
    public String desc;
    public String description;
    public String designerName;
    public String designerRediretctUrl;
    public String extInfo;
    public String fCN;
    public String fEU;
    public String fMX;
    public String fOl;
    public int fTr;
    public String fUH;
    public String fUI;
    public String fUK;
    public String fUL;
    public String fUM;
    public String fUN;
    public String fUO;
    public int fWv;
    public String filemd5;
    public String gxt;
    public int hhA;
    public int hhB;
    public String hhC;
    public String hhD;
    public int hhE;
    public String hhF;
    public String hhG;
    public int hhH;
    public String hhI;
    public String hhJ;
    public int hhK;
    public String hhL;
    public String hhM;
    public String hhN;
    public String hhO;
    public String hhP;
    public String hhQ;
    public String hhR;
    public String hhS;
    public String hhT;
    public String hhU;
    public String hhV;
    public String hhW;
    public String hhX;
    public String hhY;
    public String hhZ;
    public a hhd;
    public Map<String, String> hhe;
    public String hhf;
    public int hhg;
    public String hhh;
    public String hhi;
    public int hhj;
    public int hhk;
    public int hhl;
    public String hhm;
    public String hhn;
    public String hho;
    public int hhp;
    public int hhq;
    public int hhr;
    public int hhs;
    public int hht;
    public String hhu;
    public String hhv;
    public int hhw;
    public String hhx;
    public String hhy;
    public int hhz;
    public int hiA;
    public String hiB;
    public String hiC;
    public String hiD;
    public String hiE;
    public String hiF;
    public String hiG;
    public String hiH;
    public String hiI;
    public String hiJ;
    public String hiK;
    public String hiL;
    public String hiM;
    public int hiN;
    public String hiO;
    public String hiP;
    public String hiQ;
    public int hiR;
    public boolean hiS;
    public int hiT;
    public String hiU;
    public int hiV;
    public String hiW;
    public String hiX;
    public String hiY;
    public List<String> hiZ;
    public int hia;
    public int hib;
    public int hic;
    public String hid;
    public String hie;
    public String hif;
    public String hig;
    public String hih;
    public int hii;
    public String hij;
    public String hik;
    public String hil;
    public int him;
    public int hin;
    public String hio;
    public String hip;
    public int hiq;
    public int hir;
    public int his;
    public String hit;
    public String hiu;
    public String hiv;
    public String hiw;
    public String hix;
    public String hiy;
    public String hiz;
    public String hjA;
    public String hjB;
    public String hjC;
    public String hjD;
    public int hjE;
    public String hjF;
    public int hjG;
    public String hjH;
    public String hjI;
    public int hjJ;
    public int hjK;
    public String hjL;
    public String hjM;
    public int hjN;
    private final HashMap<Class<? extends c>, c> hjO;
    public Map<String, String> hjP;
    private String hjQ;
    private String hjR;
    private String hjS;
    public String hja;
    public List<String> hjb;
    public String hjc;
    public int hjd;
    public String hje;
    public String hjf;
    public String hjg;
    public String hjh;
    public String hji;
    public String hjj;
    public String hjk;
    public String hjl;
    public String hjm;
    public String hjn;
    public String hjo;
    public String hjp;
    public int hjq;
    public String hjr;
    public String hjs;
    public String hjt;
    public int hju;
    public String hjv;
    public String hjw;
    public String hjx;
    public String hjy;
    public String hjz;
    public String iconUrl;
    public String mediaTagName;
    public String messageAction;
    public String messageExt;
    public int pageType;
    public int sdkVer;
    public String secondUrl;
    public int showType;
    public String thumburl;
    public int tid;
    public String title;
    public int type;
    public String url;
    public String username;
    
    static
    {
      GMTrace.i(315143225344L, 2348);
      hjT = new com.tencent.mm.a.f(100);
      GMTrace.o(315143225344L, 2348);
    }
    
    public a()
    {
      GMTrace.i(313129959424L, 2333);
      this.hiS = false;
      this.hiT = 0;
      this.hju = 0;
      this.hjv = "";
      this.hjw = "";
      this.hjx = "";
      this.hjy = "";
      this.hjz = "";
      this.hjA = "";
      this.canvasPageXml = "";
      this.hjM = null;
      this.hjN = 0;
      this.hjO = new HashMap();
      GMTrace.o(313129959424L, 2333);
    }
    
    public static final a B(String paramString1, String paramString2)
    {
      GMTrace.i(313398394880L, 2335);
      if (bf.mA(paramString1))
      {
        GMTrace.o(313398394880L, 2335);
        return null;
      }
      int i = paramString1.indexOf('<');
      if (i > 0) {}
      for (Object localObject2 = paramString1.substring(i);; localObject2 = paramString1)
      {
        i = ((String)localObject2).hashCode();
        Object localObject1 = (a)hjT.get(Integer.valueOf(i));
        if (localObject1 != null)
        {
          GMTrace.o(313398394880L, 2335);
          return (a)localObject1;
        }
        long l1 = System.currentTimeMillis();
        localObject1 = null;
        if (!bf.mA(paramString2)) {
          localObject1 = av.PE(paramString2);
        }
        if (localObject1 == null) {
          localObject1 = bg.q((String)localObject2, "msg");
        }
        for (;;)
        {
          if (localObject1 == null)
          {
            v.e("MicroMsg.AppMessage", "parse msg failed");
            GMTrace.o(313398394880L, 2335);
            return null;
          }
          long l2 = System.currentTimeMillis();
          a locala = new a();
          locala.hjP = ((Map)localObject1);
          locala.hjQ = paramString1;
          locala.hjR = ((String)localObject2);
          locala.hjS = paramString2;
          try
          {
            locala.a((Map)localObject1, locala);
            paramString1 = f.b.hka.iterator();
            while (paramString1.hasNext())
            {
              localObject2 = (c)((com.tencent.mm.bn.b)paramString1.next()).get();
              ((c)localObject2).a((Map)localObject1, locala);
              locala.a((c)localObject2);
            }
            paramString1 = f.b.eU(locala.type);
          }
          catch (Exception paramString1)
          {
            v.e("MicroMsg.AppMessage", "parse amessage xml failed");
            v.e("MicroMsg.AppMessage", "exception:%s", new Object[] { bf.g(paramString1) });
            GMTrace.o(313398394880L, 2335);
            return null;
          }
          if (paramString1 != null)
          {
            paramString1.a((Map)localObject1, locala);
            locala.a(paramString1);
          }
          hjT.k(Integer.valueOf(i), locala);
          v.d("MicroMsg.AppMessage", "parseContent, time:%d, %d, %d", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(System.currentTimeMillis() - l1), Integer.valueOf(bf.mz(paramString2).hashCode()) });
          GMTrace.o(313398394880L, 2335);
          return locala;
        }
      }
    }
    
    public static a a(a parama)
    {
      GMTrace.i(314337918976L, 2342);
      if (parama == null)
      {
        parama = new a();
        GMTrace.o(314337918976L, 2342);
        return parama;
      }
      parama = parama.wF();
      GMTrace.o(314337918976L, 2342);
      return parama;
    }
    
    public static String a(a parama, String paramString, keep_SceneResult paramkeep_SceneResult)
    {
      GMTrace.i(14623692554240L, 108955);
      v.i("MicroMsg.AppMessage", "summersafecdn makeLocalContent aesKey[%s], filemd5[%s]", new Object[] { bf.Qi(parama.hhu), parama.filemd5 });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<msg>");
      if ((parama.hht != 0) && (parama.hhs != 0))
      {
        v.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb[%d, %d]", new Object[] { Integer.valueOf(parama.hht), Integer.valueOf(parama.hhs) });
        localStringBuilder.append(a(parama, paramString, paramkeep_SceneResult, parama.hht, parama.hhs));
      }
      for (;;)
      {
        localStringBuilder.append("</msg>");
        hjT.k(Integer.valueOf(localStringBuilder.toString().hashCode()), parama);
        parama = localStringBuilder.toString();
        GMTrace.o(14623692554240L, 108955);
        return parama;
        v.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb 0");
        localStringBuilder.append(a(parama, paramString, paramkeep_SceneResult, 0, 0));
      }
    }
    
    public static String a(a parama, String paramString, keep_SceneResult paramkeep_SceneResult, int paramInt1, int paramInt2)
    {
      GMTrace.i(314606354432L, 2344);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<appmsg appid=\"" + bf.PV(parama.appId) + "\" sdkver=\"" + parama.sdkVer + "\">");
      parama.a(localStringBuilder, parama, paramString, paramkeep_SceneResult, paramInt1, paramInt2);
      c localc = f.b.eU(parama.type);
      if (localc != null) {
        localc.a(localStringBuilder, parama, paramString, paramkeep_SceneResult, paramInt1, paramInt2);
      }
      localStringBuilder.append("</appmsg>");
      if (2 == parama.showType) {
        localStringBuilder.append("<ShakePageResult>").append(parama.hhm).append("</ShakePageResult>");
      }
      v.d("MicroMsg.AppMessage", "summerbig makeContent[%s]", new Object[] { localStringBuilder.toString() });
      parama = localStringBuilder.toString();
      GMTrace.o(314606354432L, 2344);
      return parama;
    }
    
    public static final a ek(String paramString)
    {
      GMTrace.i(313264177152L, 2334);
      paramString = B(paramString, null);
      GMTrace.o(313264177152L, 2334);
      return paramString;
    }
    
    public static String el(String paramString)
    {
      GMTrace.i(314874789888L, 2346);
      paramString = "<![CDATA[" + paramString + "]]>";
      GMTrace.o(314874789888L, 2346);
      return paramString;
    }
    
    private a wF()
    {
      GMTrace.i(16383421186048L, 122066);
      a locala = new a();
      if (this == null)
      {
        GMTrace.o(16383421186048L, 122066);
        return locala;
      }
      v.i("MicroMsg.AppMessage", "summerbig cloneContent srcContent aesKey[%s], filemd5[%s], appid[%s]", new Object[] { bf.Qi(this.hhu), this.filemd5, locala.appId });
      locala.action = this.action;
      locala.appId = this.appId;
      locala.appName = this.appName;
      locala.fWv = this.fWv;
      locala.fCN = this.fCN;
      locala.hhg = this.hhg;
      locala.content = this.content;
      locala.description = this.description;
      locala.username = this.username;
      locala.extInfo = this.extInfo;
      locala.mediaTagName = this.mediaTagName;
      locala.messageAction = this.messageAction;
      locala.messageExt = this.messageExt;
      locala.hhj = this.hhj;
      locala.hhh = this.hhh;
      locala.fOl = this.fOl;
      locala.hhf = this.hhf;
      locala.sdkVer = this.sdkVer;
      locala.title = this.title;
      locala.type = this.type;
      locala.showType = this.showType;
      locala.hhz = this.hhz;
      locala.hhA = this.hhA;
      locala.url = this.url;
      locala.hhi = this.hhi;
      locala.fUH = this.fUH;
      locala.fUI = this.fUI;
      locala.gxt = this.gxt;
      locala.thumburl = this.thumburl;
      locala.hhm = this.hhm;
      locala.hhx = this.hhx;
      locala.hhy = this.hhy;
      locala.hhB = this.hhB;
      locala.hhC = this.hhC;
      locala.hhE = this.hhE;
      locala.hhD = this.hhD;
      locala.hhH = this.hhH;
      locala.hhI = this.hhI;
      locala.hhK = this.hhK;
      locala.hhJ = this.hhJ;
      locala.hhF = this.hhF;
      locala.hhG = this.hhG;
      locala.hih = this.hih;
      locala.fMX = this.fMX;
      locala.hio = this.hio;
      locala.hip = this.hip;
      locala.hiq = this.hiq;
      locala.hir = this.hiq;
      locala.hij = this.hij;
      locala.him = this.him;
      locala.hii = this.hii;
      locala.hik = this.hik;
      locala.hil = this.hil;
      locala.hiA = this.hiA;
      locala.hiB = this.hiB;
      locala.hiC = this.hiC;
      locala.hhl = this.hhl;
      locala.fUK = this.fUK;
      locala.fUL = this.fUL;
      locala.fUM = this.fUM;
      locala.fUN = this.fUN;
      locala.hjs = this.hjs;
      locala.hjq = this.hjq;
      locala.designerName = this.designerName;
      locala.designerRediretctUrl = this.designerName;
      locala.tid = this.tid;
      locala.hjr = this.hjr;
      locala.desc = this.desc;
      locala.iconUrl = this.iconUrl;
      locala.secondUrl = this.secondUrl;
      locala.pageType = this.pageType;
      locala.hjt = this.hjt;
      locala.hju = this.hju;
      locala.hjv = this.hjv;
      locala.hjw = this.hjw;
      locala.hjx = this.hjx;
      locala.hjy = this.hjy;
      locala.hjz = this.hjz;
      locala.hjA = this.hjA;
      locala.canvasPageXml = this.canvasPageXml;
      locala.fUO = this.fUO;
      locala.hhn = this.hhn;
      locala.hhu = this.hhu;
      locala.filemd5 = this.filemd5;
      locala.hhk = this.hhk;
      locala.hhd = this.hhd;
      locala.hjB = this.hjB;
      locala.hjC = this.hjC;
      locala.hjE = this.hjE;
      locala.hjF = this.hjF;
      locala.hjJ = this.hjJ;
      locala.hjD = this.hjD;
      locala.hjK = this.hjK;
      locala.hjL = this.hjL;
      locala.hjH = this.hjH;
      locala.hjR = this.hjR;
      locala.hjS = this.hjS;
      locala.hjQ = this.hjQ;
      locala.hjP = this.hjP;
      Iterator localIterator = this.hjO.entrySet().iterator();
      while (localIterator.hasNext())
      {
        c localc = ((c)((Map.Entry)localIterator.next()).getValue()).wD();
        if (localc != null) {
          locala.a(localc);
        }
      }
      GMTrace.o(16383421186048L, 122066);
      return locala;
    }
    
    public final void a(c paramc)
    {
      GMTrace.i(16383152750592L, 122064);
      if (paramc == null)
      {
        v.printErrStackTrace("MicroMsg.AppMessage", new NullPointerException(""), "piece is null", new Object[0]);
        GMTrace.o(16383152750592L, 122064);
        return;
      }
      paramc.hhb = this;
      this.hjO.put(paramc.getClass(), paramc);
      GMTrace.o(16383152750592L, 122064);
    }
    
    public final void a(f paramf)
    {
      GMTrace.i(314740572160L, 2345);
      paramf.field_appId = this.appId;
      paramf.field_title = this.title;
      paramf.field_description = this.description;
      paramf.field_type = this.type;
      paramf.field_source = this.appName;
      GMTrace.o(314740572160L, 2345);
    }
    
    public final void a(StringBuilder paramStringBuilder, a parama, String paramString, keep_SceneResult paramkeep_SceneResult, int paramInt1, int paramInt2)
    {
      GMTrace.i(16383555403776L, 122067);
      paramStringBuilder.append("<title>" + bf.PV(parama.title) + "</title>");
      paramStringBuilder.append("<des>" + bf.PV(parama.description) + "</des>");
      paramStringBuilder.append("<username>" + bf.PV(parama.username) + "</username>");
      Object localObject2 = new StringBuilder("<action>");
      Object localObject1;
      if (bf.mA(parama.action))
      {
        localObject1 = "view";
        paramStringBuilder.append((String)localObject1 + "</action>");
        paramStringBuilder.append("<type>" + parama.type + "</type>");
        paramStringBuilder.append("<showtype>").append(parama.showType).append("</showtype>");
        paramStringBuilder.append("<content>" + bf.PV(parama.content) + "</content>");
        paramStringBuilder.append("<url>" + bf.PV(parama.url) + "</url>");
        paramStringBuilder.append("<lowurl>" + bf.PV(parama.hhf) + "</lowurl>");
        paramStringBuilder.append("<dataurl>" + bf.PV(parama.hhx) + "</dataurl>");
        paramStringBuilder.append("<lowdataurl>" + bf.PV(parama.hhy) + "</lowdataurl>");
        paramStringBuilder.append("<contentattr>").append(parama.hhl).append("</contentattr>");
        paramStringBuilder.append("<streamvideo>");
        paramStringBuilder.append("<streamvideourl>").append(bf.PV(parama.hjt)).append("</streamvideourl>");
        paramStringBuilder.append("<streamvideototaltime>").append(parama.hju).append("</streamvideototaltime>");
        paramStringBuilder.append("<streamvideotitle>").append(bf.PV(parama.hjv)).append("</streamvideotitle>");
        paramStringBuilder.append("<streamvideowording>").append(bf.PV(parama.hjw)).append("</streamvideowording>");
        paramStringBuilder.append("<streamvideoweburl>").append(bf.PV(parama.hjx)).append("</streamvideoweburl>");
        paramStringBuilder.append("<streamvideothumburl>").append(bf.PV(parama.hjy)).append("</streamvideothumburl>");
        paramStringBuilder.append("<streamvideoaduxinfo>").append(bf.PV(parama.hjz)).append("</streamvideoaduxinfo>");
        paramStringBuilder.append("<streamvideopublishid>").append(bf.PV(parama.hjA)).append("</streamvideopublishid>");
        paramStringBuilder.append("</streamvideo>");
        paramStringBuilder.append(String.format("<canvasPageItem><canvasPageXml><![CDATA[%s]]></canvasPageXml></canvasPageItem>", new Object[] { parama.canvasPageXml }));
        switch (parama.type)
        {
        }
      }
      for (;;)
      {
        paramStringBuilder.append("<appattach>");
        if ((paramkeep_SceneResult != null) && ((!bf.mA(paramString)) || (paramInt1 != 0) || (paramInt2 != 0))) {
          break label3279;
        }
        paramStringBuilder.append("<totallen>" + parama.hhg + "</totallen>");
        paramStringBuilder.append("<attachid>" + bf.PV(parama.fCN) + "</attachid>");
        paramStringBuilder.append("<cdnattachurl>" + bf.PV(parama.hhn) + "</cdnattachurl>");
        paramStringBuilder.append("<emoticonmd5>" + bf.PV(parama.hhi) + "</emoticonmd5>");
        paramStringBuilder.append("<aeskey>" + bf.PV(parama.hhu) + "</aeskey>");
        if ((paramInt1 != 0) && (paramInt2 != 0))
        {
          paramStringBuilder.append("<thumbheight>" + paramInt2 + "</thumbheight>");
          paramStringBuilder.append("<thumbwidth>" + paramInt1 + "</thumbwidth>");
        }
        paramStringBuilder.append("<fileext>" + bf.PV(parama.hhh) + "</fileext>");
        paramStringBuilder.append("<islargefilemsg>" + parama.hhk + "</islargefilemsg>");
        paramStringBuilder.append("</appattach>");
        paramStringBuilder.append("<extinfo>" + bf.PV(parama.extInfo) + "</extinfo>");
        paramStringBuilder.append("<androidsource>" + parama.hhj + "</androidsource>");
        if (!bf.mA(parama.fUH))
        {
          paramStringBuilder.append("<sourceusername>" + bf.PV(parama.fUH) + "</sourceusername>");
          paramStringBuilder.append("<sourcedisplayname>" + bf.PV(parama.fUI) + "</sourcedisplayname>");
          paramStringBuilder.append("<commenturl>" + bf.PV(parama.gxt) + "</commenturl>");
        }
        paramStringBuilder.append("<thumburl>" + bf.PV(parama.thumburl) + "</thumburl>");
        paramStringBuilder.append("<mediatagname>" + bf.PV(parama.mediaTagName) + "</mediatagname>");
        paramStringBuilder.append("<messageaction>" + el(bf.PV(parama.messageAction)) + "</messageaction>");
        paramStringBuilder.append("<messageext>" + el(bf.PV(parama.messageExt)) + "</messageext>");
        paramStringBuilder.append("<emoticongift>");
        paramStringBuilder.append("<packageflag>" + parama.hhE + "</packageflag>");
        paramStringBuilder.append("<packageid>" + bf.PV(parama.hhD) + "</packageid>");
        paramStringBuilder.append("</emoticongift>");
        paramStringBuilder.append("<emoticonshared>");
        paramStringBuilder.append("<packageflag>" + parama.hhK + "</packageflag>");
        paramStringBuilder.append("<packageid>" + bf.PV(parama.hhJ) + "</packageid>");
        paramStringBuilder.append("</emoticonshared>");
        paramStringBuilder.append("<designershared>");
        paramStringBuilder.append("<designeruin>" + parama.hjq + "</designeruin>");
        paramStringBuilder.append("<designername>" + parama.designerName + "</designername>");
        paramStringBuilder.append("<designerrediretcturl>" + parama.designerRediretctUrl + "</designerrediretcturl>");
        paramStringBuilder.append("</designershared>");
        paramStringBuilder.append("<emotionpageshared>");
        paramStringBuilder.append("<tid>" + parama.tid + "</tid>");
        paramStringBuilder.append("<title>" + parama.hjr + "</title>");
        paramStringBuilder.append("<desc>" + parama.desc + "</desc>");
        paramStringBuilder.append("<iconUrl>" + parama.iconUrl + "</iconUrl>");
        paramStringBuilder.append("<secondUrl>" + parama.secondUrl + "</secondUrl>");
        paramStringBuilder.append("<pageType>" + parama.pageType + "</pageType>");
        paramStringBuilder.append("</emotionpageshared>");
        paramStringBuilder.append("<webviewshared>");
        paramStringBuilder.append("<shareUrlOriginal>" + bf.PV(parama.fUK) + "</shareUrlOriginal>");
        paramStringBuilder.append("<shareUrlOpen>" + bf.PV(parama.fUL) + "</shareUrlOpen>");
        paramStringBuilder.append("<jsAppId>" + bf.PV(parama.fUM) + "</jsAppId>");
        paramStringBuilder.append("<publisherId>" + bf.PV(parama.fUN) + "</publisherId>");
        paramStringBuilder.append("</webviewshared>");
        paramStringBuilder.append("<template_id>" + bf.PV(parama.hih) + "</template_id>");
        v.i("MicroMsg.AppMessage", "summerbig makecontent content md5[%s]", new Object[] { parama.filemd5 });
        paramStringBuilder.append("<md5>" + bf.PV(parama.filemd5) + "</md5>");
        Iterator localIterator = f.b.hka.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (c)((com.tencent.mm.bn.b)localIterator.next()).get();
          localObject2 = parama.n(localObject1.getClass());
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
          ((c)localObject1).a(paramStringBuilder, parama, paramString, paramkeep_SceneResult, paramInt1, paramInt2);
        }
        localObject1 = bf.PV(parama.action);
        break;
        paramStringBuilder.append("<productitem type=\"" + parama.hhB + "\">");
        paramStringBuilder.append("<productinfo>" + bf.PV(parama.hhC) + "</productinfo>");
        paramStringBuilder.append("</productitem>");
        continue;
        paramStringBuilder.append("<mallproductitem type=\"" + parama.hhH + "\">");
        paramStringBuilder.append("<mallproductinfo>" + bf.PV(parama.hhI) + "</mallproductinfo>");
        paramStringBuilder.append("</mallproductitem>");
        continue;
        paramStringBuilder.append("<tvinfo>" + bf.PV(parama.hhF) + "</tvinfo>");
        continue;
        paramStringBuilder.append("<recorditem>" + bf.PV(parama.hhG) + "</recorditem>");
        continue;
        paramStringBuilder.append("<carditem>" + parama.hio + "</carditem>");
        continue;
        paramStringBuilder.append("<wcpayinfo>");
        paramStringBuilder.append("<paysubtype>" + parama.hii + "</paysubtype>");
        paramStringBuilder.append("<feedesc>" + parama.hij + "</feedesc>");
        paramStringBuilder.append("<transcationid>" + parama.hik + "</transcationid>");
        paramStringBuilder.append("<transferid>" + parama.hil + "</transferid>");
        paramStringBuilder.append("<invalidtime>" + parama.him + "</invalidtime>");
        paramStringBuilder.append("<pay_memo>" + parama.hjs + "</pay_memo>");
        paramStringBuilder.append("</wcpayinfo>");
        continue;
        paramStringBuilder.append("<wcpayinfo>");
        paramStringBuilder.append("<iconurl>" + bf.PV(parama.hiE) + "</iconurl>");
        paramStringBuilder.append("<scenetext>" + bf.PV(parama.hiJ) + "</scenetext>");
        paramStringBuilder.append("<url>" + bf.PV(parama.hiD) + "</url>");
        paramStringBuilder.append("<receivertitle>" + bf.PV(parama.hiF) + "</receivertitle>");
        paramStringBuilder.append("<sendertitle>" + bf.PV(parama.hiG) + "</sendertitle>");
        paramStringBuilder.append("<receiverdes>" + bf.PV(parama.hiI) + "</receiverdes>");
        paramStringBuilder.append("<senderdes>" + bf.PV(parama.hiH) + "</senderdes>");
        paramStringBuilder.append("<templateid>" + bf.PV(parama.hiK) + "</templateid>");
        paramStringBuilder.append("<sceneid>" + bf.PV(parama.hiL) + "</sceneid>");
        paramStringBuilder.append("<nativeurl>" + bf.PV(parama.hiM) + "</nativeurl>");
        paramStringBuilder.append("<innertype>" + bf.PV(new StringBuilder().append(parama.showType).toString()) + "</innertype>");
        paramStringBuilder.append("<localtype>" + bf.PV(new StringBuilder().append(parama.hiN).toString()) + "</localtype>");
        paramStringBuilder.append("<paymsgid>" + bf.PV(parama.hiO) + "</paymsgid>");
        paramStringBuilder.append("<imageid>" + bf.PV(parama.hiP) + "</imageid>");
        paramStringBuilder.append("<imageaeskey>" + bf.PV(parama.hiQ) + "</imageaeskey>");
        paramStringBuilder.append("<imagelength>" + bf.PV(new StringBuilder().append(parama.hiR).toString()) + "</imagelength>");
        paramStringBuilder.append("<droptips>" + bf.PV(new StringBuilder().append(parama.hiT).toString()) + "</droptips>");
        paramStringBuilder.append("</wcpayinfo>");
      }
      label3279:
      paramStringBuilder.append("<attachid>" + bf.PV(paramString) + "</attachid>");
      if ((paramkeep_SceneResult.field_fileLength > 0) && (!bf.mA(paramkeep_SceneResult.field_fileId)))
      {
        paramStringBuilder.append("<cdnattachurl>" + bf.PV(paramkeep_SceneResult.field_fileId) + "</cdnattachurl>");
        if ((parama.type == 19) || (parama.type == 24) || (parama.type == 4) || (parama.type == 3) || (parama.type == 7) || (parama.type == 27) || (parama.type == 26)) {
          break label3711;
        }
        paramStringBuilder.append("<totallen>" + paramkeep_SceneResult.field_fileLength + "</totallen>");
      }
      for (;;)
      {
        if (paramkeep_SceneResult.field_thumbimgLength > 0)
        {
          paramStringBuilder.append("<cdnthumburl>" + bf.PV(paramkeep_SceneResult.field_fileId) + "</cdnthumburl>");
          if (!bf.mA(paramkeep_SceneResult.field_thumbfilemd5)) {
            paramStringBuilder.append("<cdnthumbmd5>" + paramkeep_SceneResult.field_thumbfilemd5 + "</cdnthumbmd5>");
          }
          paramStringBuilder.append("<cdnthumblength>" + paramkeep_SceneResult.field_thumbimgLength + "</cdnthumblength>");
          paramStringBuilder.append("<cdnthumbheight>" + paramInt2 + "</cdnthumbheight>");
          paramStringBuilder.append("<cdnthumbwidth>" + paramInt1 + "</cdnthumbwidth>");
          paramStringBuilder.append("<cdnthumbaeskey>" + paramkeep_SceneResult.field_aesKey + "</cdnthumbaeskey>");
        }
        paramStringBuilder.append("<aeskey>" + bf.PV(paramkeep_SceneResult.field_aesKey) + "</aeskey>");
        paramStringBuilder.append("<encryver>1</encryver>");
        break;
        label3711:
        v.i("MicroMsg.AppMessage", "summersafecdn content.type[%d], len[%d] but not set", new Object[] { Integer.valueOf(parama.type), Integer.valueOf(paramkeep_SceneResult.field_fileLength) });
      }
      GMTrace.o(16383555403776L, 122067);
    }
    
    public final void a(Map<String, String> paramMap, a parama)
    {
      GMTrace.i(16383286968320L, 122065);
      for (;;)
      {
        int i;
        int j;
        try
        {
          this.hhe = paramMap;
          this.appId = ((String)paramMap.get(".msg.appmsg.$appid"));
          this.sdkVer = bf.getInt((String)paramMap.get(".msg.appmsg.$sdkver"), 0);
          this.title = bf.PF((String)paramMap.get(".msg.appmsg.title"));
          this.description = ((String)paramMap.get(".msg.appmsg.des"));
          this.username = ((String)paramMap.get(".msg.appmsg.username"));
          this.action = ((String)paramMap.get(".msg.appmsg.action"));
          this.type = bf.getInt((String)paramMap.get(".msg.appmsg.type"), 0);
          this.content = ((String)paramMap.get(".msg.appmsg.content"));
          this.url = ((String)paramMap.get(".msg.appmsg.url"));
          this.hhf = ((String)paramMap.get(".msg.appmsg.lowurl"));
          this.hhx = ((String)paramMap.get(".msg.appmsg.dataurl"));
          this.hhy = ((String)paramMap.get(".msg.appmsg.lowdataurl"));
          this.hhg = bf.getInt((String)paramMap.get(".msg.appmsg.appattach.totallen"), 0);
          this.fCN = ((String)paramMap.get(".msg.appmsg.appattach.attachid"));
          this.hhh = bf.PF((String)paramMap.get(".msg.appmsg.appattach.fileext"));
          this.hhi = ((String)paramMap.get(".msg.appmsg.appattach.emoticonmd5"));
          this.extInfo = ((String)paramMap.get(".msg.appmsg.extinfo"));
          this.hhj = bf.getInt((String)paramMap.get(".msg.appmsg.androidsource"), 0);
          this.fUH = ((String)paramMap.get(".msg.appmsg.sourceusername"));
          this.fUI = ((String)paramMap.get(".msg.appmsg.sourcedisplayname"));
          this.gxt = ((String)paramMap.get(".msg.commenturl"));
          this.thumburl = ((String)paramMap.get(".msg.appmsg.thumburl"));
          this.mediaTagName = ((String)paramMap.get(".msg.appmsg.mediatagname"));
          this.messageAction = ((String)paramMap.get(".msg.appmsg.messageaction"));
          this.messageExt = ((String)paramMap.get(".msg.appmsg.messageext"));
          this.fWv = bf.getInt((String)paramMap.get(".msg.appinfo.version"), 0);
          this.appName = ((String)paramMap.get(".msg.appinfo.appname"));
          this.fOl = ((String)paramMap.get(".msg.fromusername"));
          this.hhn = ((String)paramMap.get(".msg.appmsg.appattach.cdnattachurl"));
          this.hho = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumburl"));
          this.hhp = bf.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumblength"), 0);
          this.hhq = bf.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbheight"), 0);
          this.hhr = bf.getInt((String)paramMap.get(".msg.appmsg.appattach.cdnthumbwidth"), 0);
          this.hhs = bf.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbheight"), 0);
          this.hht = bf.getInt((String)paramMap.get(".msg.appmsg.appattach.thumbwidth"), 0);
          this.hhu = ((String)paramMap.get(".msg.appmsg.appattach.aeskey"));
          this.hhw = bf.getInt((String)paramMap.get(".msg.appmsg.appattach.encryver"), 1);
          this.hhv = ((String)paramMap.get(".msg.appmsg.appattach.cdnthumbaeskey"));
          this.hhk = bf.getInt((String)paramMap.get(".msg.appmsg.appattach.islargefilemsg"), 0);
          if ((this.hhk == 0) && (this.hhg > 26214400))
          {
            this.hhk = 1;
            v.i("MicroMsg.AppMessage", "summerbig content.attachlen[%d] set largefilemsg 1", new Object[] { Integer.valueOf(this.hhg) });
          }
          this.hhB = bf.getInt((String)paramMap.get(".msg.appmsg.productitem.$type"), 0);
          this.hhC = ((String)paramMap.get(".msg.appmsg.productitem.productinfo"));
          this.hhE = bf.getInt((String)paramMap.get(".msg.appmsg.emoticongift.packageflag"), 0);
          this.hhD = ((String)paramMap.get(".msg.appmsg.emoticongift.packageid"));
          this.hhJ = ((String)paramMap.get(".msg.appmsg.emoticonshared.packageid"));
          this.hhK = bf.getInt((String)paramMap.get(".msg.appmsg.emoticonshared.packageflag"), 0);
          this.hhF = ((String)paramMap.get(".msg.appmsg.tvinfo"));
          this.hhG = ((String)paramMap.get(".msg.appmsg.recorditem"));
          this.fUK = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOriginal"));
          this.fUL = ((String)paramMap.get(".msg.appmsg.webviewshared.shareUrlOpen"));
          this.fUM = ((String)paramMap.get(".msg.appmsg.webviewshared.jsAppId"));
          this.fUN = ((String)paramMap.get(".msg.appmsg.webviewshared.publisherId"));
          this.hjq = com.tencent.mm.a.o.aY((String)paramMap.get(".msg.appmsg.designershared.designeruin"));
          this.designerName = ((String)paramMap.get(".msg.appmsg.designershared.designername"));
          this.designerRediretctUrl = ((String)paramMap.get(".msg.appmsg.designershared.designerrediretcturl"));
          this.tid = bf.PX((String)paramMap.get(".msg.appmsg.emotionpageshared.tid"));
          this.hjr = ((String)paramMap.get(".msg.appmsg.emotionpageshared.title"));
          this.desc = ((String)paramMap.get(".msg.appmsg.emotionpageshared.desc"));
          this.iconUrl = ((String)paramMap.get(".msg.appmsg.emotionpageshared.iconUrl"));
          this.secondUrl = bf.ap((String)paramMap.get(".msg.appmsg.emotionpageshared.secondUrl"), "");
          this.pageType = bf.PX((String)paramMap.get(".msg.appmsg.emotionpageshared.pageType"));
          this.hjt = bf.ap((String)paramMap.get(".msg.appmsg.streamvideo.streamvideourl"), "");
          this.hju = bf.PX((String)paramMap.get(".msg.appmsg.streamvideo.streamvideototaltime"));
          this.hjv = bf.ap((String)paramMap.get(".msg.appmsg.streamvideo.streamvideotitle"), "");
          this.hjw = bf.ap((String)paramMap.get(".msg.appmsg.streamvideo.streamvideowording"), "");
          this.hjx = bf.ap((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoweburl"), "");
          this.hjy = bf.ap((String)paramMap.get(".msg.appmsg.streamvideo.streamvideothumburl"), "");
          this.hjz = bf.ap((String)paramMap.get(".msg.appmsg.streamvideo.streamvideoaduxinfo"), "");
          this.hjA = bf.ap((String)paramMap.get(".msg.appmsg.streamvideo.streamvideopublishid"), "");
          this.canvasPageXml = bf.ap((String)paramMap.get(".msg.appmsg.canvasPageItem.canvasPageXml"), "");
          this.hjC = ((String)paramMap.get(".msg.appmsg.weappinfo.username"));
          this.hjB = ((String)paramMap.get(".msg.appmsg.weappinfo.pagepath"));
          this.hjD = ((String)paramMap.get(".msg.appmsg.weappinfo.appid"));
          this.hjK = bf.getInt((String)paramMap.get(".msg.appmsg.weappinfo.version"), 0);
          this.hjE = bf.getInt((String)paramMap.get(".msg.appmsg.weappinfo.type"), 0);
          this.hjJ = bf.getInt((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.type"), 0);
          this.hjF = ((String)paramMap.get(".msg.appmsg.weappinfo.pkginfo.md5"));
          this.hjL = ((String)paramMap.get(".msg.appmsg.weappinfo.weappiconurl"));
          this.hjH = ((String)paramMap.get(".msg.appmsg.weappinfo.shareId"));
          this.hjI = ((String)paramMap.get(".msg.appmsg.weappinfo.sharekey"));
          i = parama.hjQ.indexOf("<cache");
          j = parama.hjQ.indexOf("</cache>");
          if (j - i > "<cache".length()) {
            this.hjM = parama.hjQ.substring(i, "</cache>".length() + j);
          }
          this.hjN = bf.getInt((String)paramMap.get(".msg.appmsg.soundtype"), 0);
          switch (this.type)
          {
          case 13: 
            if (this.type != 21) {
              break label3743;
            }
            this.showType = bf.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
            this.fUO = ((String)paramMap.get(".msg.appmsg.statextstr"));
            this.hhz = bf.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
            if ((this.hhz == 5) && (bf.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 1)) {
              this.hhz = 0;
            }
            this.hhA = bf.getInt((String)paramMap.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
            this.hhL = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.ranktitle"));
            this.hhM = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rankid"));
            if (bf.mA(this.hhM)) {
              this.hhM = ((String)paramMap.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo.rankid"));
            }
            this.hhN = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.rankdisplay"));
            this.hhO = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoretitle"));
            this.hhP = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoredisplay"));
            this.hhQ = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.tipdisplay"));
            this.hhR = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.color"));
            this.hhS = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightcolor"));
            this.hhT = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.linecolor"));
            this.hhV = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.fontcolor"));
            this.hhU = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightlinecolor"));
            this.hhX = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.rankviewtitle"));
            this.hhW = ((String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.championusername"));
            this.hia = bf.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
            this.hic = bf.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.timestamp"), 0);
            this.hib = bf.getInt((String)paramMap.get(".msg.appmsg.hardwareinfo.devicetype"), 0);
            this.hhY = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.motto"));
            this.hhZ = ((String)paramMap.get(".msg.appmsg.hardwareinfo.rankview.championinfo.coverimgurl"));
            localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.displayusername");
            this.hig = ((String)localObject);
            this.hie = ((String)localObject);
            localObject = (String)paramMap.get(".msg.appmsg.hardwareinfo.messagenodeinfo.title");
            this.hif = ((String)localObject);
            this.hid = ((String)localObject);
            this.hih = bf.mz((String)paramMap.get(".msg.appmsg.template_id"));
            this.filemd5 = ((String)paramMap.get(".msg.appmsg.md5"));
            this.hiA = bf.getInt((String)paramMap.get(".msg.appmsg.jumpcontrol.enable"), 0);
            this.hiB = ((String)paramMap.get(".msg.appmsg.jumpcontrol.jumpurl"));
            this.hiC = ((String)paramMap.get(".msg.appmsg.jumpcontrol.pushcontent"));
            paramMap = bg.q(parama.hjR, "msgoperation");
            if ((this != null) && (paramMap != null))
            {
              this.hhd = new a();
              this.hhd.gxE = ((String)paramMap.get(".msgoperation.expinfo.expidstr"));
              this.hhd.hjU = bf.getInt((String)paramMap.get(".msgoperation.appmsg.usedefaultthumb"), 0);
              this.hhd.hjV = bf.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatetitle"), 0);
              this.hhd.title = ((String)paramMap.get(".msgoperation.appmsg.title"));
              this.hhd.hjW = bf.getInt((String)paramMap.get(".msgoperation.appmsg.isupdatedesc"), 0);
              this.hhd.desc = ((String)paramMap.get(".msgoperation.appmsg.desc"));
              this.hhd.hjX = bf.getInt((String)paramMap.get(".msgoperation.appmsg.ishiddentail"), 0);
            }
            GMTrace.o(16383286968320L, 122065);
            return;
          }
        }
        catch (Exception paramMap)
        {
          v.e("MicroMsg.AppMessage", "parse amessage xml failed");
          v.e("MicroMsg.AppMessage", "exception:%s", new Object[] { bf.g(paramMap) });
          throw paramMap;
        }
        this.hhH = bf.getInt((String)paramMap.get(".msg.appmsg.mallproductitem.$type"), 0);
        this.hhI = ((String)paramMap.get(".msg.appmsg.mallproductitem.mallproductinfo"));
        continue;
        this.hii = bf.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.paysubtype"), 0);
        this.hij = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.feedesc"));
        this.hik = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.transcationid"));
        this.hil = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.transferid"));
        this.him = bf.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
        this.hin = bf.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.effectivedate"), 3);
        this.fTr = bf.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.total_fee"), 0);
        this.fEU = bf.ap((String)paramMap.get(".msg.appmsg.wcpayinfo.fee_type"), "ZAR");
        this.hjs = bf.ap((String)paramMap.get(".msg.appmsg.wcpayinfo.pay_memo"), "");
        continue;
        this.hiE = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.iconurl"));
        this.hiJ = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.scenetext"));
        this.hiD = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.url"));
        this.hiF = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.receivertitle"));
        this.hiG = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.sendertitle"));
        this.hiI = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.receiverdes"));
        this.hiH = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.senderdes"));
        this.hiK = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.templateid"));
        this.hiL = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.sceneid"));
        this.hiM = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.nativeurl"));
        this.hiN = bf.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.localtype"), 0);
        this.hiO = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.paymsgid"));
        this.hiP = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.imageid"));
        this.hiQ = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.imageaeskey"));
        this.hiR = bf.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.imagelength"), 0);
        this.hiT = bf.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.droptips"), 0);
        this.hiU = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.billno"));
        this.hiV = bf.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.newaatype"), 0);
        this.hiW = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receivertitle"));
        this.hiX = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launchertitle"));
        this.hiY = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.notinertitle"));
        Object localObject = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.receiverlist"));
        if (!bf.mA((String)localObject))
        {
          localObject = ((String)localObject).split("\\|");
          if ((localObject != null) && (localObject.length > 0))
          {
            this.hiZ = new ArrayList();
            this.hiZ.addAll(Arrays.asList((Object[])localObject));
          }
        }
        this.hja = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payertitle"));
        localObject = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.payerlist"));
        if (!bf.mA((String)localObject))
        {
          localObject = ((String)localObject).split("\\|");
          if ((localObject != null) && (localObject.length > 0))
          {
            this.hjb = new ArrayList();
            this.hjb.addAll(Arrays.asList((Object[])localObject));
          }
        }
        this.hjc = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.outtradeno"));
        this.hjd = bf.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.seq"), 0);
        this.hje = bf.mz((String)paramMap.get(".msg.appmsg.wcpayinfo.newaa.launcherusername"));
        continue;
        this.hjf = bf.mz((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.url"));
        this.hjg = bf.mz((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.templateid"));
        this.hjh = bf.mz((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.iconurl"));
        this.hji = bf.mz((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.miniiconurl"));
        this.hjj = bf.mz((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.backgroundurl"));
        this.hjk = bf.mz((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receivertitle"));
        this.hjl = bf.mz((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sendertitle"));
        this.hjm = bf.mz((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.scenetext"));
        this.hjn = bf.mz((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.senderdes"));
        this.hjo = bf.mz((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.receiverdes"));
        this.hjp = bf.mz((String)paramMap.get(".msg.appmsg.wcpaythirdinfo.sceneid"));
        continue;
        this.fMX = parama.hjQ;
        this.hio = "";
        this.hiq = bf.getInt((String)paramMap.get(".msg.appmsg.carditem.from_scene"), 2);
        this.hip = ((String)paramMap.get(".msg.appmsg.carditem.brand_name"));
        this.hir = bf.getInt((String)paramMap.get(".msg.appmsg.carditem.card_type"), -1);
        continue;
        if ((paramMap.get(".msg.alphainfo.url") != null) && (paramMap.get(".msg.alphainfo.md5") != null))
        {
          this.hiS = true;
          continue;
          this.hit = bf.ap((String)paramMap.get(".msg.appmsg.giftcard_info.order_id"), "");
          this.his = com.tencent.mm.a.o.aY((String)paramMap.get(".msg.appmsg.giftcard_info.biz_uin"));
          this.hiu = bf.ap((String)paramMap.get(".msg.appmsg.giftcard_info.app_name"), "");
          this.hiv = bf.ap((String)paramMap.get(".msg.appmsg.giftcard_info.recv_digest"), "");
          this.hiw = bf.ap((String)paramMap.get(".msg.appmsg.giftcard_info.send_digest"), "");
          this.hix = bf.ap((String)paramMap.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
          this.hiy = bf.ap((String)paramMap.get(".msg.appmsg.giftcard_info.title_color"), "");
          this.hiz = bf.ap((String)paramMap.get(".msg.appmsg.giftcard_info.des_color"), "");
          continue;
          label3743:
          if (this.type == 2001)
          {
            this.showType = bf.getInt((String)paramMap.get(".msg.appmsg.wcpayinfo.innertype"), 0);
          }
          else
          {
            this.showType = bf.getInt((String)paramMap.get(".msg.appmsg.showtype"), 0);
            switch (this.showType)
            {
            case 1: 
              if (bf.getInt((String)paramMap.get(".msg.appmsg.mmreader.category.$count"), 0) > 0) {
                this.content = av.ae(paramMap);
              }
              break;
            case 2: 
              localObject = parama.hjQ.toLowerCase();
              i = ((String)localObject).indexOf("<ShakePageResult>".toLowerCase());
              j = ((String)localObject).indexOf("</ShakePageResult>".toLowerCase());
              this.hhm = parama.hjQ.substring(i + 17, j);
              continue;
            }
          }
        }
      }
    }
    
    public final String getDescription()
    {
      GMTrace.i(17813376860160L, 132720);
      if ((this.hhd != null) && (this.hhd.hjW != 0))
      {
        str = this.hhd.desc;
        GMTrace.o(17813376860160L, 132720);
        return str;
      }
      String str = this.description;
      GMTrace.o(17813376860160L, 132720);
      return str;
    }
    
    public final String getTitle()
    {
      GMTrace.i(315009007616L, 2347);
      if ((this.hhd != null) && (this.hhd.hjV != 0))
      {
        str = this.hhd.title;
        GMTrace.o(315009007616L, 2347);
        return str;
      }
      String str = this.title;
      GMTrace.o(315009007616L, 2347);
      return str;
    }
    
    public final <T extends c> T n(Class<T> paramClass)
    {
      GMTrace.i(16689706041344L, 124348);
      paramClass = (c)this.hjO.get(paramClass);
      GMTrace.o(16689706041344L, 124348);
      return paramClass;
    }
    
    public static final class a
    {
      public String desc;
      public String gxE;
      public int hjU;
      public int hjV;
      public int hjW;
      public int hjX;
      public int hjY;
      public int hjZ;
      public String title;
      
      public a()
      {
        GMTrace.i(311116693504L, 2318);
        this.hjY = 0;
        this.hjZ = 0;
        GMTrace.o(311116693504L, 2318);
      }
    }
  }
  
  public static final class b
  {
    public static final ArrayList<com.tencent.mm.bn.b<? extends c>> hka;
    private static final HashMap<Integer, com.tencent.mm.bn.b<? extends c>> hkb;
    
    static
    {
      GMTrace.i(16383018532864L, 122063);
      hka = new ArrayList();
      hkb = new HashMap();
      GMTrace.o(16383018532864L, 122063);
    }
    
    public static void a(com.tencent.mm.bn.b<? extends c> paramb)
    {
      GMTrace.i(16382750097408L, 122061);
      hka.add(paramb);
      GMTrace.o(16382750097408L, 122061);
    }
    
    public static c eU(int paramInt)
    {
      GMTrace.i(16382884315136L, 122062);
      Object localObject = (com.tencent.mm.bn.b)hkb.get(Integer.valueOf(paramInt));
      if (localObject != null)
      {
        localObject = (c)((com.tencent.mm.bn.b)localObject).get();
        ((c)localObject).type = paramInt;
        GMTrace.o(16382884315136L, 122062);
        return (c)localObject;
      }
      v.w("MicroMsg.AppMessage", "get for type(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      GMTrace.o(16382884315136L, 122062);
      return null;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/t/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */