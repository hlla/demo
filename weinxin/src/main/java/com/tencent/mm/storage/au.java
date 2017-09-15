package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.an.a.a;
import com.tencent.mm.b.f;
import com.tencent.mm.e.a.ls;
import com.tencent.mm.e.a.nw;
import com.tencent.mm.e.a.ny;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.i.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.c;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.t.n;
import java.util.Map;
import junit.framework.Assert;

public final class au
  extends n
{
  public static String uIb;
  public static String uIc;
  public boolean uId;
  private String uIe;
  
  static
  {
    GMTrace.i(13300171538432L, 99094);
    uIb = "voip_content_voice";
    uIc = "voip_content_video";
    GMTrace.o(13300171538432L, 99094);
  }
  
  public au()
  {
    GMTrace.i(13294131740672L, 99049);
    this.uId = false;
    GMTrace.o(13294131740672L, 99049);
  }
  
  public au(String paramString)
  {
    GMTrace.i(13294265958400L, 99050);
    this.uId = false;
    super.cH(paramString);
    GMTrace.o(13294265958400L, 99050);
  }
  
  public static au Y(au paramau)
  {
    GMTrace.i(13297621401600L, 99075);
    if (paramau == null)
    {
      v.d("MicroMsg.MsgInfo", "convertFrom msg is null ");
      GMTrace.o(13297621401600L, 99075);
      return null;
    }
    au localau = new au();
    localau.x(paramau.field_msgId);
    localau.y(paramau.field_msgSvrId);
    localau.setType(paramau.field_type);
    localau.dv(paramau.field_status);
    localau.dw(paramau.field_isSend);
    localau.field_isShowTimer = paramau.field_isShowTimer;
    localau.gxc = true;
    localau.z(paramau.field_createTime);
    localau.cH(paramau.field_talker);
    localau.setContent(paramau.field_content);
    localau.cI(paramau.field_imgPath);
    localau.cJ(paramau.field_reserved);
    localau.field_lvbuffer = paramau.field_lvbuffer;
    localau.gtq = true;
    localau.cK(paramau.field_transContent);
    localau.cM(paramau.gxt);
    localau.dG(paramau.gxu);
    localau.cN(paramau.gxv);
    GMTrace.o(13297621401600L, 99075);
    return localau;
  }
  
  public static boolean af(Map<String, String> paramMap)
  {
    GMTrace.i(13299232014336L, 99087);
    if ((paramMap != null) && (paramMap.containsKey(".sysmsg.$type")) && (((String)paramMap.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication"))) {}
    for (boolean bool = true;; bool = false)
    {
      v.d("MicroMsg.MsgInfo", "isAddChatroomInviteMsg:%s", new Object[] { Boolean.valueOf(bool) });
      GMTrace.o(13299232014336L, 99087);
      return bool;
    }
  }
  
  public static boolean ag(Map<String, String> paramMap)
  {
    GMTrace.i(13299366232064L, 99088);
    if ((paramMap != null) && (paramMap.containsKey(".sysmsg.$type")) && (((String)paramMap.get(".sysmsg.$type")).equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval"))) {}
    for (boolean bool = true;; bool = false)
    {
      v.d("MicroMsg.MsgInfo", "isAddChatroomInviteAcceptMsg:%s", new Object[] { Boolean.valueOf(bool) });
      GMTrace.o(13299366232064L, 99088);
      return bool;
    }
  }
  
  public static void eB(long paramLong)
  {
    GMTrace.i(13299634667520L, 99090);
    if ((100000000L > paramLong) && (-10L < paramLong)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue("msgId not in the reasonable scope", bool);
      GMTrace.o(13299634667520L, 99090);
      return;
    }
  }
  
  public final boolean RD(String paramString)
  {
    GMTrace.i(13298963578880L, 99085);
    if ((!bf.mA(this.gxv)) && (!bf.mA(paramString)))
    {
      Object localObject = bg.q(this.gxv, "msgsource");
      if (localObject == null)
      {
        GMTrace.o(13298963578880L, 99085);
        return false;
      }
      localObject = (String)((Map)localObject).get(".msgsource.atuserlist");
      if (!bf.mA((String)localObject))
      {
        localObject = ((String)localObject).split(",");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          if (localObject[i].trim().equals(paramString))
          {
            GMTrace.o(13298963578880L, 99085);
            return true;
          }
          i += 1;
        }
      }
    }
    GMTrace.o(13298963578880L, 99085);
    return false;
  }
  
  public final boolean axH()
  {
    GMTrace.i(13294400176128L, 99051);
    if ((this.field_type & 0xFFFF) == 49)
    {
      GMTrace.o(13294400176128L, 99051);
      return true;
    }
    GMTrace.o(13294400176128L, 99051);
    return false;
  }
  
  public final void b(Cursor paramCursor)
  {
    GMTrace.i(13299500449792L, 99089);
    super.b(paramCursor);
    paramCursor = this.field_content;
    if ((paramCursor != null) && (paramCursor.length() > 2097152))
    {
      final long l = this.field_msgId;
      StringBuilder localStringBuilder = new StringBuilder(1024);
      localStringBuilder.append("Very big message: \nmsgId = ").append(l).append('\n').append("msgSvrId = ").append(this.field_msgSvrId).append('\n').append("type = ").append(this.field_type).append('\n').append("createTime = ").append(this.field_createTime).append('\n').append("talker = ").append(this.field_talker).append('\n').append("flag = ").append(this.field_flag).append('\n').append("content.length() = ").append(paramCursor.length()).append('\n').append("content = ").append(paramCursor.substring(0, 256));
      v.e("MicroMsg.MsgInfo", localStringBuilder.toString());
      setType(1);
      setContent("");
      paramCursor = Y(this);
      com.tencent.mm.kernel.h.vL().D(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(18782563074048L, 139941);
          ((com.tencent.mm.plugin.messenger.foundation.a.h)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJQ().a(l, this.uIf);
          GMTrace.o(18782563074048L, 139941);
        }
      });
    }
    eB(this.field_msgId);
    GMTrace.o(13299500449792L, 99089);
  }
  
  public final boolean bLN()
  {
    GMTrace.i(13294534393856L, 99052);
    if (this.field_type == 285212721)
    {
      GMTrace.o(13294534393856L, 99052);
      return true;
    }
    GMTrace.o(13294534393856L, 99052);
    return false;
  }
  
  public final boolean bLO()
  {
    GMTrace.i(13294668611584L, 99053);
    if (this.field_type == 486539313)
    {
      GMTrace.o(13294668611584L, 99053);
      return true;
    }
    GMTrace.o(13294668611584L, 99053);
    return false;
  }
  
  public final boolean bLP()
  {
    GMTrace.i(13294802829312L, 99054);
    if (this.field_type == 34)
    {
      GMTrace.o(13294802829312L, 99054);
      return true;
    }
    GMTrace.o(13294802829312L, 99054);
    return false;
  }
  
  public final boolean bLQ()
  {
    GMTrace.i(13294937047040L, 99055);
    if (this.field_type == 436207665)
    {
      GMTrace.o(13294937047040L, 99055);
      return true;
    }
    GMTrace.o(13294937047040L, 99055);
    return false;
  }
  
  public final boolean bLR()
  {
    GMTrace.i(13295071264768L, 99056);
    if (this.field_type == 469762097)
    {
      GMTrace.o(13295071264768L, 99056);
      return true;
    }
    GMTrace.o(13295071264768L, 99056);
    return false;
  }
  
  public final boolean bLS()
  {
    GMTrace.i(13295205482496L, 99057);
    if (this.field_type == 301989937)
    {
      GMTrace.o(13295205482496L, 99057);
      return true;
    }
    GMTrace.o(13295205482496L, 99057);
    return false;
  }
  
  public final boolean bLT()
  {
    GMTrace.i(13295339700224L, 99058);
    if ((this.field_type == 50) || (this.field_type == 53))
    {
      GMTrace.o(13295339700224L, 99058);
      return true;
    }
    GMTrace.o(13295339700224L, 99058);
    return false;
  }
  
  public final boolean bLU()
  {
    GMTrace.i(13295473917952L, 99059);
    if (this.field_type == 52)
    {
      GMTrace.o(13295473917952L, 99059);
      return true;
    }
    GMTrace.o(13295473917952L, 99059);
    return false;
  }
  
  public final boolean bLV()
  {
    GMTrace.i(13295608135680L, 99060);
    if (this.field_type == 318767153)
    {
      GMTrace.o(13295608135680L, 99060);
      return true;
    }
    GMTrace.o(13295608135680L, 99060);
    return false;
  }
  
  public final boolean bLW()
  {
    GMTrace.i(13295742353408L, 99061);
    if (this.field_type == 10002)
    {
      GMTrace.o(13295742353408L, 99061);
      return true;
    }
    GMTrace.o(13295742353408L, 99061);
    return false;
  }
  
  public final boolean bLX()
  {
    GMTrace.i(13295876571136L, 99062);
    switch (this.field_type)
    {
    default: 
      GMTrace.o(13295876571136L, 99062);
      return false;
    }
    GMTrace.o(13295876571136L, 99062);
    return true;
  }
  
  public final boolean bLY()
  {
    GMTrace.i(13296010788864L, 99063);
    if (this.field_type == 42)
    {
      GMTrace.o(13296010788864L, 99063);
      return true;
    }
    GMTrace.o(13296010788864L, 99063);
    return false;
  }
  
  public final boolean bLZ()
  {
    GMTrace.i(13296145006592L, 99064);
    if (this.field_type == 48)
    {
      GMTrace.o(13296145006592L, 99064);
      return true;
    }
    GMTrace.o(13296145006592L, 99064);
    return false;
  }
  
  public final boolean bMa()
  {
    GMTrace.i(13296279224320L, 99065);
    switch (this.field_type)
    {
    default: 
      GMTrace.o(13296279224320L, 99065);
      return false;
    }
    GMTrace.o(13296279224320L, 99065);
    return true;
  }
  
  public final boolean bMb()
  {
    GMTrace.i(13296547659776L, 99067);
    if (this.field_type == 43)
    {
      GMTrace.o(13296547659776L, 99067);
      return true;
    }
    GMTrace.o(13296547659776L, 99067);
    return false;
  }
  
  public final boolean bMc()
  {
    GMTrace.i(13296681877504L, 99068);
    if (this.field_type == 62)
    {
      GMTrace.o(13296681877504L, 99068);
      return true;
    }
    GMTrace.o(13296681877504L, 99068);
    return false;
  }
  
  public final boolean bMd()
  {
    GMTrace.i(13296816095232L, 99069);
    if (this.field_type == 47)
    {
      GMTrace.o(13296816095232L, 99069);
      return true;
    }
    GMTrace.o(13296816095232L, 99069);
    return false;
  }
  
  public final boolean bMe()
  {
    GMTrace.i(13296950312960L, 99070);
    if (this.field_type == 1048625)
    {
      GMTrace.o(13296950312960L, 99070);
      return true;
    }
    GMTrace.o(13296950312960L, 99070);
    return false;
  }
  
  public final boolean bMf()
  {
    GMTrace.i(13297084530688L, 99071);
    if (this.field_type == 268435505)
    {
      GMTrace.o(13297084530688L, 99071);
      return true;
    }
    GMTrace.o(13297084530688L, 99071);
    return false;
  }
  
  public final boolean bMg()
  {
    GMTrace.i(13297218748416L, 99072);
    if (this.field_type == -1879048191)
    {
      GMTrace.o(13297218748416L, 99072);
      return true;
    }
    GMTrace.o(13297218748416L, 99072);
    return false;
  }
  
  public final boolean bMh()
  {
    GMTrace.i(13297352966144L, 99073);
    switch (this.field_type)
    {
    case 56: 
    default: 
      GMTrace.o(13297352966144L, 99073);
      return false;
    }
    GMTrace.o(13297352966144L, 99073);
    return true;
  }
  
  public final boolean bMi()
  {
    GMTrace.i(13297487183872L, 99074);
    String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("TranslateMsgOff");
    if ((!bf.mA(str)) && (bf.PX(str) != 0)) {
      v.d("MicroMsg.MsgInfo", "isTranslateFeatureOn false");
    }
    for (int i = 0; (i != 0) && (!bf.mA(this.field_transContent)); i = 1)
    {
      GMTrace.o(13297487183872L, 99074);
      return true;
    }
    GMTrace.o(13297487183872L, 99074);
    return false;
  }
  
  public final boolean bMj()
  {
    GMTrace.i(13297889837056L, 99077);
    if ((this.gxy & 0x1) > 0)
    {
      GMTrace.o(13297889837056L, 99077);
      return true;
    }
    GMTrace.o(13297889837056L, 99077);
    return false;
  }
  
  public final void bMk()
  {
    GMTrace.i(13298024054784L, 99078);
    if (bMl()) {
      dG(this.gxu & 0xFFFFFFDF);
    }
    GMTrace.o(13298024054784L, 99078);
  }
  
  public final boolean bMl()
  {
    GMTrace.i(13298158272512L, 99079);
    if ((this.gxu & 0x20) > 0)
    {
      GMTrace.o(13298158272512L, 99079);
      return true;
    }
    GMTrace.o(13298158272512L, 99079);
    return false;
  }
  
  public final boolean bMm()
  {
    GMTrace.i(13298292490240L, 99080);
    if ((bMi()) && ((this.gxu & 0x10) > 0))
    {
      GMTrace.o(13298292490240L, 99080);
      return true;
    }
    GMTrace.o(13298292490240L, 99080);
    return false;
  }
  
  public final void bMn()
  {
    GMTrace.i(13298426707968L, 99081);
    if (!bMi())
    {
      GMTrace.o(13298426707968L, 99081);
      return;
    }
    dG(this.gxu | 0x10);
    GMTrace.o(13298426707968L, 99081);
  }
  
  public final void bMo()
  {
    GMTrace.i(13298560925696L, 99082);
    dG(this.gxu | 0x300);
    GMTrace.o(13298560925696L, 99082);
  }
  
  public final boolean bMp()
  {
    GMTrace.i(13298695143424L, 99083);
    if ((this.gxu & 0x300) == 0)
    {
      if ((this.gxu & 0x300) == 0)
      {
        GMTrace.o(13298695143424L, 99083);
        return false;
      }
      GMTrace.o(13298695143424L, 99083);
      return true;
    }
    GMTrace.o(13298695143424L, 99083);
    return true;
  }
  
  public final boolean bMq()
  {
    GMTrace.i(14608123297792L, 108839);
    if ((this.gxu & 0x40) == 0)
    {
      GMTrace.o(14608123297792L, 108839);
      return false;
    }
    GMTrace.o(14608123297792L, 108839);
    return true;
  }
  
  public final boolean bMr()
  {
    GMTrace.i(14608257515520L, 108840);
    if ((!bf.mA(this.gxv)) && ((this.gxv.contains("announcement@all")) || (this.gxv.contains("notify@all")))) {}
    for (boolean bool = true;; bool = false)
    {
      v.d("MicroMsg.MsgInfo", "isAtAll isAtAll:%s", new Object[] { Boolean.valueOf(bool) });
      GMTrace.o(14608257515520L, 108840);
      return bool;
    }
  }
  
  public final String bMs()
  {
    GMTrace.i(13299903102976L, 99092);
    if (!bLW())
    {
      GMTrace.o(13299903102976L, 99092);
      return "";
    }
    if (this.uIe == null) {
      bMt();
    }
    String str = this.uIe;
    GMTrace.o(13299903102976L, 99092);
    return str;
  }
  
  public final com.tencent.mm.an.a bMt()
  {
    GMTrace.i(13300037320704L, 99093);
    v.i("MicroMsg.MsgInfo", "[parseNewXmlSysMsg]");
    com.tencent.mm.an.a locala = a.a.b(f.q(this.field_content, "sysmsg"), this);
    if (locala != null)
    {
      v.i("MicroMsg.MsgInfo", "BaseNewXmlMsg:%s", new Object[] { locala });
      locala.HU();
      this.uIe = locala.hMG;
    }
    for (;;)
    {
      GMTrace.o(13300037320704L, 99093);
      return locala;
      v.e("MicroMsg.MsgInfo", "[parseNewXmlSysMsg] null == pBaseNewXmlMsg");
    }
  }
  
  public final void dv(int paramInt)
  {
    GMTrace.i(13297755619328L, 99076);
    super.dv(paramInt);
    Object localObject;
    if (this.field_isSend == 1)
    {
      if ((!bMa()) && (!bLZ()) && (!bLY())) {
        paramInt = 1;
      }
      while (paramInt != 0) {
        if (this.field_status == 5)
        {
          v.e("MicroMsg.MsgInfo", "set msg status fail, msgId:%d, type:%d, userName:%s %s", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(this.field_type), this.field_talker, bf.bJP() });
          localObject = new nw();
          ((nw)localObject).fUS.fCQ = this;
          com.tencent.mm.sdk.b.a.uql.m((b)localObject);
          GMTrace.o(13297755619328L, 99076);
          return;
          paramInt = 0;
        }
        else
        {
          if (this.field_status != 2) {
            break label246;
          }
          v.d("MicroMsg.MsgInfo", "successfully send msgId:%d, type:%d", new Object[] { Long.valueOf(this.field_msgId), Integer.valueOf(this.field_type) });
          localObject = new ny();
          ((ny)localObject).fUU.fCQ = this;
          com.tencent.mm.sdk.b.a.uql.m((b)localObject);
          GMTrace.o(13297755619328L, 99076);
          return;
        }
      }
    }
    if (this.field_isSend == 0)
    {
      localObject = new ls();
      ((ls)localObject).fSH.fCQ = this;
      com.tencent.mm.sdk.b.a.uql.m((b)localObject);
    }
    label246:
    GMTrace.o(13297755619328L, 99076);
  }
  
  public final boolean isSystem()
  {
    GMTrace.i(13296413442048L, 99066);
    if (this.field_type == 10000)
    {
      GMTrace.o(13296413442048L, 99066);
      return true;
    }
    GMTrace.o(13296413442048L, 99066);
    return false;
  }
  
  public final ContentValues pv()
  {
    GMTrace.i(13299768885248L, 99091);
    eB(this.field_msgId);
    ContentValues localContentValues = super.pv();
    GMTrace.o(13299768885248L, 99091);
    return localContentValues;
  }
  
  public final void yA(int paramInt)
  {
    GMTrace.i(13298829361152L, 99084);
    switch (paramInt)
    {
    default: 
      v.w("MicroMsg.MsgInfo", "Illgeal forwardflag !!!");
      GMTrace.o(13298829361152L, 99084);
      return;
    }
    dG(this.gxu | paramInt);
    GMTrace.o(13298829361152L, 99084);
  }
  
  public static final class a
  {
    private String aJE;
    public String fER;
    public int gkh;
    private String gkr;
    private String gks;
    public String gkw;
    private String gkx;
    public String gtH;
    public String hBM;
    public String hBN;
    public String hBO;
    public String hBR;
    public String orr;
    public String otA;
    public long oty;
    public String rTh;
    public int rUD;
    public int scene;
    public String signature;
    public int uIh;
    public String uIi;
    public String uIj;
    public String uIk;
    public String uIl;
    public String uIm;
    
    private a()
    {
      GMTrace.i(13322854334464L, 99263);
      this.rTh = "";
      this.fER = "";
      this.gtH = "";
      this.hBN = "";
      this.hBM = "";
      this.aJE = "";
      this.uIh = 0;
      this.scene = 0;
      this.uIi = "";
      this.uIj = "";
      this.oty = 0L;
      this.hBO = "";
      this.hBR = "";
      this.rUD = 0;
      this.gkw = "";
      this.orr = "";
      this.gkx = "";
      this.uIk = "";
      this.uIl = "";
      this.otA = "";
      this.uIm = "";
      GMTrace.o(13322854334464L, 99263);
    }
    
    public static a RE(String paramString)
    {
      GMTrace.i(13322988552192L, 99264);
      locala = new a();
      localObject = bf.ap(paramString, "").trim();
      paramString = (String)localObject;
      if (!((String)localObject).startsWith("<"))
      {
        int i = ((String)localObject).indexOf(":");
        paramString = (String)localObject;
        if (i != -1) {
          paramString = ((String)localObject).substring(i + 1);
        }
      }
      localObject = bg.q(paramString, "msg");
      if (localObject != null) {}
      for (;;)
      {
        try
        {
          if (((Map)localObject).get(".msg.$fromusername") != null) {
            continue;
          }
          locala.rTh = ((String)((Map)localObject).get(".msg.$username"));
          if (((Map)localObject).get(".msg.$fromnickname") != null) {
            continue;
          }
          locala.fER = ((String)((Map)localObject).get(".msg.$nickname"));
        }
        catch (Exception paramString)
        {
          v.e("MicroMsg.MsgInfo", "exception:%s", new Object[] { bf.g(paramString) });
          continue;
          locala.fER = ((String)((Map)localObject).get(".msg.$fromnickname"));
          continue;
          paramString = (String)((Map)localObject).get(".msg.$certflag");
          continue;
        }
        locala.gtH = ((String)((Map)localObject).get(".msg.$alias"));
        locala.hBN = ((String)((Map)localObject).get(".msg.$fullpy"));
        locala.hBM = ((String)((Map)localObject).get(".msg.$shortpy"));
        locala.aJE = ((String)((Map)localObject).get(".msg.$source"));
        locala.uIh = Integer.valueOf((String)((Map)localObject).get(".msg.$imagestatus")).intValue();
        locala.scene = Integer.valueOf((String)((Map)localObject).get(".msg.$scene")).intValue();
        locala.uIi = ((String)((Map)localObject).get(".msg.$mobileidentify"));
        locala.uIj = ((String)((Map)localObject).get(".msg.$mobilelongidentify"));
        if ((((Map)localObject).get(".msg.$qqnum") != null) && (((String)((Map)localObject).get(".msg.$qqnum")).length() > 0)) {
          locala.oty = Long.valueOf((String)((Map)localObject).get(".msg.$qqnum")).longValue();
        }
        locala.signature = ((String)((Map)localObject).get(".msg.$sign"));
        if ((((Map)localObject).get(".msg.$sex") != null) && (((String)((Map)localObject).get(".msg.$sex")).length() > 0)) {
          locala.gkh = Integer.valueOf((String)((Map)localObject).get(".msg.$sex")).intValue();
        }
        locala.gks = ((String)((Map)localObject).get(".msg.$city"));
        locala.gkr = ((String)((Map)localObject).get(".msg.$province"));
        locala.hBO = ((String)((Map)localObject).get(".msg.$qqnickname"));
        locala.hBR = ((String)((Map)localObject).get(".msg.$qqremark"));
        if (!TextUtils.isEmpty((CharSequence)((Map)localObject).get(".msg.$certflag"))) {
          continue;
        }
        paramString = "0";
        locala.rUD = Integer.valueOf(paramString).intValue();
        locala.gkw = bf.mz((String)((Map)localObject).get(".msg.$certinfo"));
        locala.orr = bf.mz((String)((Map)localObject).get(".msg.$brandIconUrl"));
        locala.gkx = bf.mz((String)((Map)localObject).get(".msg.$regionCode"));
        locala.uIk = bf.mz((String)((Map)localObject).get(".msg.$bigheadimgurl"));
        locala.uIl = bf.mz((String)((Map)localObject).get(".msg.$smallheadimgurl"));
        locala.otA = bf.mz((String)((Map)localObject).get(".msg.$googlecontact"));
        locala.uIm = bf.mz((String)((Map)localObject).get(".msg.$antispamticket"));
        v.i("MicroMsg.MsgInfo", "dkverify FriendContent user:[%s] ticket:[%s] big:[%s] sm:[%s]", new Object[] { locala.rTh, locala.uIm, locala.uIk, locala.uIl });
        GMTrace.o(13322988552192L, 99264);
        return locala;
        locala.rTh = ((String)((Map)localObject).get(".msg.$fromusername"));
      }
    }
    
    public final String bMu()
    {
      GMTrace.i(15694078935040L, 116930);
      String str = this.rTh;
      GMTrace.o(15694078935040L, 116930);
      return str;
    }
    
    public final String bMv()
    {
      GMTrace.i(13323525423104L, 99268);
      String str = this.uIi;
      GMTrace.o(13323525423104L, 99268);
      return str;
    }
    
    public final long bMw()
    {
      GMTrace.i(13323659640832L, 99269);
      long l = this.oty;
      GMTrace.o(13323659640832L, 99269);
      return l;
    }
    
    public final String bMx()
    {
      GMTrace.i(13323793858560L, 99270);
      if ((this.hBR != null) && (this.hBR.length() > 0))
      {
        str = this.hBR;
        GMTrace.o(13323793858560L, 99270);
        return str;
      }
      if ((this.hBO != null) && (this.hBO.length() > 0))
      {
        str = this.hBO;
        GMTrace.o(13323793858560L, 99270);
        return str;
      }
      String str = Long.toString(this.oty);
      GMTrace.o(13323793858560L, 99270);
      return str;
    }
    
    public final String bMy()
    {
      GMTrace.i(13323928076288L, 99271);
      String str = this.uIj;
      GMTrace.o(13323928076288L, 99271);
      return str;
    }
    
    public final int bMz()
    {
      GMTrace.i(13324330729472L, 99274);
      int i = this.rUD;
      GMTrace.o(13324330729472L, 99274);
      return i;
    }
    
    public final int bzw()
    {
      GMTrace.i(13323391205376L, 99267);
      int i = this.scene;
      GMTrace.o(13323391205376L, 99267);
      return i;
    }
    
    public final String getCity()
    {
      GMTrace.i(13324062294016L, 99272);
      Object localObject;
      if (!bf.mA(this.gkx))
      {
        localObject = this.gkx.split("_");
        if (localObject.length > 0)
        {
          if (localObject.length <= 2) {
            break label76;
          }
          this.gks = RegionCodeDecoder.bMF().ac(localObject[0], localObject[1], localObject[2]);
        }
      }
      for (;;)
      {
        localObject = this.gks;
        GMTrace.o(13324062294016L, 99272);
        return (String)localObject;
        label76:
        if (localObject.length == 2) {
          this.gks = RegionCodeDecoder.bMF().eL(localObject[0], localObject[1]);
        } else {
          this.gks = "";
        }
      }
    }
    
    public final String getDisplayName()
    {
      GMTrace.i(13323256987648L, 99266);
      if (!TextUtils.isEmpty(this.fER))
      {
        str = this.fER;
        GMTrace.o(13323256987648L, 99266);
        return str;
      }
      if (!TextUtils.isEmpty(this.gtH))
      {
        str = this.gtH;
        GMTrace.o(13323256987648L, 99266);
        return str;
      }
      v.f("MicroMsg.MsgInfo", "username is nullOrNil");
      String str = bf.mz(this.rTh);
      GMTrace.o(13323256987648L, 99266);
      return str;
    }
    
    public final String getProvince()
    {
      GMTrace.i(13324196511744L, 99273);
      Object localObject;
      if (!bf.mA(this.gkx))
      {
        localObject = this.gkx.split("_");
        if (localObject.length > 0) {
          if ((localObject.length <= 2) || (!RegionCodeDecoder.RQ(localObject[0]))) {
            break label82;
          }
        }
      }
      label82:
      for (this.gkr = RegionCodeDecoder.bMF().eL(localObject[0], localObject[1]);; this.gkr = RegionCodeDecoder.bMF().RR(localObject[0]))
      {
        localObject = this.gkr;
        GMTrace.o(13324196511744L, 99273);
        return (String)localObject;
      }
    }
  }
  
  public static final class b
  {
    public int fNU;
    public String label;
    public double mZn;
    public double mZo;
    public String nbU;
    public String rTh;
    public String sAk;
    public String uIn;
    public String uIo;
    public String uIp;
    public String uIq;
    
    public b()
    {
      GMTrace.i(13312519569408L, 99186);
      this.rTh = "";
      this.mZn = 0.0D;
      this.mZo = 0.0D;
      this.fNU = 0;
      this.label = "";
      this.nbU = "";
      this.uIn = "";
      this.uIo = null;
      this.uIp = null;
      this.uIq = null;
      this.sAk = "";
      GMTrace.o(13312519569408L, 99186);
    }
    
    public static b RF(String paramString)
    {
      GMTrace.i(13312788004864L, 99188);
      b localb = new b();
      paramString = bg.q(paramString, "msg");
      if (paramString != null)
      {
        localb.rTh = bf.ap((String)paramString.get(".msg.location.$fromusername"), "");
        localb.mZn = bf.PZ((String)paramString.get(".msg.location.$x"));
        localb.mZo = bf.PZ((String)paramString.get(".msg.location.$y"));
        localb.label = bf.ap((String)paramString.get(".msg.location.$label"), "");
        localb.uIn = bf.ap((String)paramString.get(".msg.location.$maptype"), "");
        localb.fNU = bf.PX((String)paramString.get(".msg.location.$scale"));
        localb.uIq = bf.ap((String)paramString.get(".msg.location.$localLocationen"), "");
        localb.uIo = bf.ap((String)paramString.get(".msg.location.$localLocationcn"), "");
        localb.uIp = bf.ap((String)paramString.get(".msg.location.$localLocationtw"), "");
        localb.nbU = bf.ap((String)paramString.get(".msg.location.$poiname"), "");
        localb.sAk = bf.ap((String)paramString.get(".msg.location.$infourl"), "");
      }
      GMTrace.o(13312788004864L, 99188);
      return localb;
    }
    
    public final String toString()
    {
      GMTrace.i(13312385351680L, 99185);
      String str = String.format("%d-%d-%d", new Object[] { Integer.valueOf((int)(this.mZn * 1000000.0D)), Integer.valueOf((int)(this.mZo * 1000000.0D)), Integer.valueOf(this.fNU) });
      GMTrace.o(13312385351680L, 99185);
      return str;
    }
  }
  
  public static final class c
  {
    public String content;
    public String hRv;
    public boolean lHO;
    public String oxJ;
    public String title;
    public String uIr;
    
    private c()
    {
      GMTrace.i(13305271812096L, 99132);
      this.title = "";
      this.content = "";
      this.hRv = "";
      this.uIr = "";
      this.lHO = false;
      GMTrace.o(13305271812096L, 99132);
    }
    
    public static c RG(String paramString)
    {
      GMTrace.i(13305406029824L, 99133);
      c localc = new c();
      paramString = bg.q(paramString, "msg");
      if (paramString != null) {}
      try
      {
        localc.title = ((String)paramString.get(".msg.pushmail.content.subject"));
        localc.content = ((String)paramString.get(".msg.pushmail.content.digest"));
        localc.hRv = ((String)paramString.get(".msg.pushmail.content.sender"));
        localc.uIr = ((String)paramString.get(".msg.pushmail.waplink"));
        localc.lHO = bf.mz((String)paramString.get(".msg.pushmail.content.attach")).equalsIgnoreCase("true");
        localc.oxJ = ((String)paramString.get(".msg.pushmail.mailid"));
        GMTrace.o(13305406029824L, 99133);
        return localc;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          v.e("MicroMsg.MsgInfo", "exception:%s", new Object[] { bf.g(paramString) });
        }
      }
    }
    
    public final String bMA()
    {
      GMTrace.i(13305540247552L, 99134);
      String str = this.uIr;
      GMTrace.o(13305540247552L, 99134);
      return str;
    }
  }
  
  public static final class d
  {
    public String chatroomName;
    public String content;
    private String countryCode;
    public String fER;
    public int fJB;
    public int gkh;
    public String gtH;
    public String hBM;
    public String hBN;
    public String hBO;
    private String hBR;
    private String hnw;
    private String hnx;
    public String orn;
    public String otA;
    public long oty;
    public String rTh;
    public String sKl;
    public String sKm;
    public int scene;
    public String signature;
    public int uIh;
    public String uIi;
    public String uIj;
    public String uIk;
    public String uIl;
    public int uIs;
    public String uIt;
    public String uIu;
    public int uIv;
    public String uIw;
    public String uIx;
    
    private d()
    {
      GMTrace.i(13302453239808L, 99111);
      this.rTh = "";
      this.gtH = "";
      this.fER = "";
      this.hBN = "";
      this.hBM = "";
      this.content = "";
      this.uIh = 0;
      this.scene = 0;
      this.uIi = "";
      this.uIj = "";
      this.oty = 0L;
      this.hBO = "";
      this.hBR = "";
      this.uIs = 0;
      this.uIk = "";
      this.uIl = "";
      this.chatroomName = "";
      GMTrace.o(13302453239808L, 99111);
    }
    
    public static d RH(String paramString)
    {
      GMTrace.i(13302587457536L, 99112);
      d locald = new d();
      paramString = bg.q(paramString, "msg");
      if (paramString != null) {}
      try
      {
        locald.rTh = ((String)paramString.get(".msg.$fromusername"));
        locald.gtH = ((String)paramString.get(".msg.$alias"));
        locald.fER = ((String)paramString.get(".msg.$fromnickname"));
        locald.hBN = ((String)paramString.get(".msg.$fullpy"));
        locald.hBM = ((String)paramString.get(".msg.$shortpy"));
        locald.content = ((String)paramString.get(".msg.$content"));
        locald.uIh = Integer.valueOf((String)paramString.get(".msg.$imagestatus")).intValue();
        locald.scene = Integer.valueOf((String)paramString.get(".msg.$scene")).intValue();
        locald.uIi = ((String)paramString.get(".msg.$mhash"));
        locald.uIj = ((String)paramString.get(".msg.$mfullhash"));
        if ((paramString.get(paramString.get(".msg.$qqnum")) != null) && (((String)paramString.get(paramString.get(".msg.$qqnum"))).length() > 0)) {
          locald.oty = Long.valueOf((String)paramString.get(".msg.$qqnum")).longValue();
        }
        locald.hBO = ((String)paramString.get(".msg.$qqnickname"));
        locald.hBR = ((String)paramString.get(".msg.$qqremark"));
        locald.signature = ((String)paramString.get(".msg.$sign"));
        if ((paramString.get(".msg.$sex") != null) && (((String)paramString.get(".msg.$sex")).length() > 0)) {
          locald.gkh = Integer.valueOf((String)paramString.get(".msg.$sex")).intValue();
        }
        locald.hnw = ((String)paramString.get(".msg.$city"));
        locald.hnx = ((String)paramString.get(".msg.$province"));
        locald.countryCode = ((String)paramString.get(".msg.$country"));
        if (paramString.get(".msg.$snsflag") != null)
        {
          locald.uIs = Integer.valueOf((String)paramString.get(".msg.$snsflag")).intValue();
          locald.uIt = ((String)paramString.get(".msg.$snsbgimgid"));
        }
        locald.orn = ((String)paramString.get(".msg.$ticket"));
        v.d("MicroMsg.MsgInfo", "dkverify ticket:%s", new Object[] { locald.orn });
        locald.uIk = bf.mz((String)paramString.get(".msg.$bigheadimgurl"));
        locald.uIl = bf.mz((String)paramString.get(".msg.$smallheadimgurl"));
        locald.fJB = Integer.valueOf(bf.ap((String)paramString.get(".msg.$opcode"), "0")).intValue();
        locald.uIu = bf.mz((String)paramString.get(".msg.$encryptusername"));
        locald.otA = bf.mz((String)paramString.get(".msg.$googlecontact"));
        v.d("MicroMsg.MsgInfo", "dkavatar VerifyContent user:[%s] big:[%s] sm:[%s]", new Object[] { locald.rTh, locald.uIk, locald.uIl });
        locald.chatroomName = bf.mz((String)paramString.get(".msg.$chatroomusername"));
        locald.sKl = ((String)paramString.get(".msg.$sourceusername"));
        locald.sKm = ((String)paramString.get(".msg.$sourcenickname"));
        locald.uIv = bf.getInt((String)paramString.get(".msg.Antispam.$isSuspiciousUser"), 0);
        if (locald.uIv == 1)
        {
          locald.uIw = ((String)paramString.get(".msg.Antispam.safetyWarning"));
          locald.uIx = ((String)paramString.get(".msg.Antispam.safetyWarningDetail"));
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          v.printErrStackTrace("MicroMsg.MsgInfo", paramString, "", new Object[0]);
        }
      }
      GMTrace.o(13302587457536L, 99112);
      return locald;
    }
    
    public final int bMB()
    {
      GMTrace.i(13303526981632L, 99119);
      int i = this.uIs;
      GMTrace.o(13303526981632L, 99119);
      return i;
    }
    
    public final String bMC()
    {
      GMTrace.i(13303661199360L, 99120);
      String str = this.uIt;
      GMTrace.o(13303661199360L, 99120);
      return str;
    }
    
    public final String bMu()
    {
      GMTrace.i(15693944717312L, 116929);
      String str = this.rTh;
      GMTrace.o(15693944717312L, 116929);
      return str;
    }
    
    public final String bMv()
    {
      GMTrace.i(13303124328448L, 99116);
      String str = this.uIi;
      GMTrace.o(13303124328448L, 99116);
      return str;
    }
    
    public final int bzw()
    {
      GMTrace.i(13302990110720L, 99115);
      int i = this.scene;
      GMTrace.o(13302990110720L, 99115);
      return i;
    }
    
    public final String getCity()
    {
      GMTrace.i(13303258546176L, 99117);
      if ((!bf.mA(this.countryCode)) && (!bf.mA(this.hnx)))
      {
        if (bf.mA(this.hnw))
        {
          str = RegionCodeDecoder.bMF().eL(this.countryCode, this.hnx);
          GMTrace.o(13303258546176L, 99117);
          return str;
        }
        str = RegionCodeDecoder.bMF().ac(this.countryCode, this.hnx, this.hnw);
        GMTrace.o(13303258546176L, 99117);
        return str;
      }
      String str = this.hnw;
      GMTrace.o(13303258546176L, 99117);
      return str;
    }
    
    public final String getDisplayName()
    {
      GMTrace.i(13302855892992L, 99114);
      if ((this.fER != null) && (this.fER.length() > 0))
      {
        str = this.fER;
        GMTrace.o(13302855892992L, 99114);
        return str;
      }
      v.f("MicroMsg.MsgInfo", "username is nullOrNil");
      String str = this.rTh;
      GMTrace.o(13302855892992L, 99114);
      return str;
    }
    
    public final String getProvince()
    {
      GMTrace.i(13303392763904L, 99118);
      if (!bf.mA(this.countryCode))
      {
        if ((!bf.mA(this.hnx)) && (!bf.mA(this.hnw)) && (RegionCodeDecoder.RQ(this.countryCode)))
        {
          str = RegionCodeDecoder.bMF().eL(this.countryCode, this.hnx);
          GMTrace.o(13303392763904L, 99118);
          return str;
        }
        str = RegionCodeDecoder.bMF().RR(this.countryCode);
        GMTrace.o(13303392763904L, 99118);
        return str;
      }
      String str = this.hnx;
      GMTrace.o(13303392763904L, 99118);
      return str;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */