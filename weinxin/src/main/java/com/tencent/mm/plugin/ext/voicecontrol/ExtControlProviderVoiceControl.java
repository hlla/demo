package com.tencent.mm.plugin.ext.voicecontrol;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.protocal.c.da;
import com.tencent.mm.protocal.c.dc;
import com.tencent.mm.protocal.c.dd;
import com.tencent.mm.protocal.c.de;
import com.tencent.mm.protocal.c.df;
import com.tencent.mm.protocal.c.dg;
import com.tencent.mm.protocal.c.dh;
import com.tencent.mm.protocal.c.di;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.b.c;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.LinkedList;

public class ExtControlProviderVoiceControl
  extends ExtContentProviderBase
  implements com.tencent.mm.y.e
{
  private static final String[] loq;
  private Context context;
  private String[] loC;
  private int loD;
  private int lpC;
  private long lpD;
  private long lpE;
  private long lpF;
  com.tencent.mm.pluginsdk.f.a.a lpG;
  private long lpH;
  private boolean lpI;
  private com.qq.wx.voice.embed.recognizer.c lpJ;
  
  static
  {
    GMTrace.i(5708951060480L, 42535);
    loq = new String[] { "retCode" };
    GMTrace.o(5708951060480L, 42535);
  }
  
  public ExtControlProviderVoiceControl(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    GMTrace.i(5707072012288L, 42521);
    this.loC = null;
    this.loD = -1;
    this.lpC = 4;
    this.lpG = new com.tencent.mm.pluginsdk.f.a.a();
    this.lpH = 0L;
    this.lpJ = new com.qq.wx.voice.embed.recognizer.c()
    {
      public final void a(com.qq.wx.voice.embed.recognizer.a paramAnonymousa)
      {
        GMTrace.i(5709487931392L, 42539);
        if (paramAnonymousa == null)
        {
          v.w("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetResult restult is null");
          GMTrace.o(5709487931392L, 42539);
          return;
        }
        v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl use time2:%s,text: %s,name: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.this)), paramAnonymousa.text, paramAnonymousa.name });
        if (!bf.mA(paramAnonymousa.name))
        {
          ExtControlProviderVoiceControl.c(ExtControlProviderVoiceControl.this);
          ExtControlProviderVoiceControl.b(ExtControlProviderVoiceControl.this, paramAnonymousa.name);
        }
        GMTrace.o(5709487931392L, 42539);
      }
      
      public final void cO(int paramAnonymousInt)
      {
        GMTrace.i(5709622149120L, 42540);
        v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetError:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        GMTrace.o(5709622149120L, 42540);
      }
    };
    this.loC = paramArrayOfString;
    this.loD = paramInt;
    this.context = paramContext;
    GMTrace.o(5707072012288L, 42521);
  }
  
  private static boolean a(a parama, int paramInt1, int paramInt2)
  {
    GMTrace.i(5707474665472L, 42524);
    if (parama == null)
    {
      v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue netscene null");
      GMTrace.o(5707474665472L, 42524);
      return false;
    }
    if (parama.lpU == null)
    {
      v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue uploadCmd null");
      GMTrace.o(5707474665472L, 42524);
      return false;
    }
    if (parama.lpU.teV == null)
    {
      v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue UploadCtx null");
      GMTrace.o(5707474665472L, 42524);
      return false;
    }
    new dg();
    Object localObject = parama.lpU;
    ((dg)localObject).teV.tfe = paramInt1;
    ((dg)localObject).teV.tff = paramInt2;
    byte[] arrayOfByte = com.tencent.mm.a.e.d(parama.lpT, paramInt1, paramInt2);
    v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue %s, startPos=%s, dataLen=%s", new Object[] { Integer.valueOf(parama.lpR), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty, %s", new Object[] { parama.lpT });
      GMTrace.o(5707474665472L, 42524);
      return false;
    }
    ((dg)localObject).tfc = com.tencent.mm.bd.b.aU(arrayOfByte);
    localObject = new a(parama.lpR, parama.appId, parama.hrb, parama.lpT, (dg)localObject);
    ((a)localObject).hrc = parama.hrc;
    ap.vd().a((k)localObject, 0);
    GMTrace.o(5707474665472L, 42524);
    return true;
  }
  
  public static boolean a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    GMTrace.i(5707340447744L, 42523);
    v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "uploadVoiceStart ");
    Object localObject1;
    if (paramInt1 != 4)
    {
      localObject2 = paramString2 + ".speex";
      new com.tencent.mm.c.c.d();
      localObject1 = localObject2;
      if (!com.tencent.mm.c.c.d.t(paramString2, (String)localObject2))
      {
        v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] decodePCMToSpeex error,pcmPath:%s,speexFilePath:%s", new Object[] { paramString2, localObject2 });
        GMTrace.o(5707340447744L, 42523);
        return false;
      }
    }
    else
    {
      localObject1 = paramString2;
    }
    int i = com.tencent.mm.a.e.aN((String)localObject1);
    Object localObject2 = new di();
    ((di)localObject2).tfg = 4;
    ((di)localObject2).tfh = 4;
    ((di)localObject2).tfi = paramInt3;
    ((di)localObject2).tfj = paramInt4;
    dh localdh = new dh();
    localdh.tfd = i;
    localdh.tfe = 0;
    if (i <= 16384) {
      localdh.tff = i;
    }
    for (paramString2 = com.tencent.mm.a.e.d((String)localObject1, 0, i);; paramString2 = com.tencent.mm.a.e.d((String)localObject1, 0, 16384))
    {
      v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoice appId=%s, FileType=%s, EncodeType=%s, sampleRate=%s, bps=%s, fileLen=%s, limit=%s", new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(i), Integer.valueOf(16384) });
      if ((paramString2 != null) && (paramString2.length > 0)) {
        break;
      }
      v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty");
      GMTrace.o(5707340447744L, 42523);
      return false;
      localdh.tff = 16384;
    }
    dg localdg = new dg();
    localdg.tfb = ((di)localObject2);
    localdg.teV = localdh;
    localdg.tfc = com.tencent.mm.bd.b.aU(paramString2);
    paramInt1 = bf.NA().hashCode();
    if (paramInt1 != Integer.MIN_VALUE) {}
    for (paramInt1 = Math.abs(paramInt1);; paramInt1 = Integer.MIN_VALUE)
    {
      paramString1 = new a(paramInt1, paramString1, i, (String)localObject1, localdg);
      ap.vd().a(paramString1, 0);
      GMTrace.o(5707340447744L, 42523);
      return true;
    }
  }
  
  private void vz(final String paramString)
  {
    GMTrace.i(5707877318656L, 42527);
    ap.yY();
    x localx = com.tencent.mm.u.c.wR().Rb(paramString);
    if ((localx == null) || (!com.tencent.mm.j.a.ez(localx.field_type)))
    {
      v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] username is not contact, countDown");
      this.lpC = 3505;
      this.lpG.countDown();
      GMTrace.o(5707877318656L, 42527);
      return;
    }
    com.tencent.mm.compatible.a.a.a(11, new a.a()
    {
      public final void run()
      {
        GMTrace.i(5705998270464L, 42513);
        ExtControlProviderVoiceControl.c(ExtControlProviderVoiceControl.this, paramString);
        GMTrace.o(5705998270464L, 42513);
      }
    });
    this.lpC = 1;
    v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] jump to chattingUI : %s, countDown", new Object[] { paramString });
    this.lpG.countDown();
    GMTrace.o(5707877318656L, 42527);
  }
  
  public final void a(int paramInt1, int paramInt2, final String paramString, k paramk)
  {
    GMTrace.i(5707743100928L, 42526);
    v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] onSceneEnd errType=%s, errCode=%s, errMsg=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramk == null)
    {
      v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene null, countDown");
      this.lpC = 3506;
      this.lpG.countDown();
      GMTrace.o(5707743100928L, 42526);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] errType、errCode not ok, countDown");
      this.lpC = 3507;
      this.lpG.countDown();
      GMTrace.o(5707743100928L, 42526);
      return;
    }
    v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene.getType()=%s", new Object[] { Integer.valueOf(paramk.getType()) });
    if (paramk.getType() == 985)
    {
      if (this.lpI)
      {
        v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] localVoiceControlSucess, no need to process");
        GMTrace.o(5707743100928L, 42526);
        return;
      }
      final a locala = (a)paramk;
      paramString = (a)paramk;
      if ((paramString.gUq != null) && (paramString.gUq.hrT.hsa != null)) {}
      for (paramString = (dc)paramString.gUq.hrT.hsa; paramString == null; paramString = null)
      {
        v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp null, countDown");
        this.lpC = 3508;
        this.lpG.countDown();
        GMTrace.o(5707743100928L, 42526);
        return;
      }
      locala.lpS = paramString.teO;
      paramInt1 = locala.fJr;
      if (paramString.teO == null)
      {
        paramk = "null";
        v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] opCode=%s, resp.Cookies=%s", new Object[] { Integer.valueOf(paramInt1), paramk });
        if (locala.fJr != 1) {
          break label465;
        }
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 != 0)
        {
          if (paramString.teV == null) {
            v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp.UploadCtx is null");
          }
          v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadMode resp: Interval=%s, Timeout=%s, StartPos=%s, DataLen=%s", new Object[] { Integer.valueOf(paramString.teT), Integer.valueOf(paramString.teU), Integer.valueOf(paramString.teV.tfe), Integer.valueOf(paramString.teV.tff) });
          if (paramString.teV.tfe >= locala.hrb)
          {
            ae.f(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(5706937794560L, 42520);
                v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode getVoiceControlResult");
                a locala = locala;
                int i = paramString.teU;
                v.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] setGetResultTimeOut %s", new Object[] { Integer.valueOf(i) });
                locala.lpW = i;
                ExtControlProviderVoiceControl.this.a(locala.lpR, locala.appId, locala.lpS);
                GMTrace.o(5706937794560L, 42520);
              }
            }, paramString.teT);
            GMTrace.o(5707743100928L, 42526);
            return;
            paramk = new String(paramString.teO.sWU);
            break;
            label465:
            paramInt1 = 0;
            continue;
          }
          v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] continue upload voice");
          if ((paramString.teV.tfe != 0) && (paramString.teV.tfe == locala.hrc))
          {
            v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] avoid duplicate doscene");
            GMTrace.o(5707743100928L, 42526);
            return;
          }
          locala.hrc = paramString.teV.tfe;
          if (paramString.teV.tfe + paramString.teV.tff < locala.hrb)
          {
            if (!a(locala, paramString.teV.tfe, paramString.teV.tff))
            {
              v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail1, countDown");
              this.lpC = 3510;
              this.lpG.countDown();
              GMTrace.o(5707743100928L, 42526);
            }
          }
          else if (!a(locala, paramString.teV.tfe, locala.hrb - paramString.teV.tfe))
          {
            v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail2, countDown");
            this.lpC = 3510;
            this.lpG.countDown();
            GMTrace.o(5707743100928L, 42526);
            return;
          }
          GMTrace.o(5707743100928L, 42526);
          return;
        }
      }
      long l1;
      if (locala.fJr == 2)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1364;
        }
        v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "");
        l1 = System.currentTimeMillis() - locala.lpX;
        if (l1 <= locala.lpW) {
          break label793;
        }
        v.w("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] isGetResultTimeOut %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.lpW) });
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label830;
        }
        this.lpC = 3509;
        this.lpG.countDown();
        GMTrace.o(5707743100928L, 42526);
        return;
        paramInt1 = 0;
        break;
        label793:
        v.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] time %s, %s", new Object[] { Long.valueOf(l1), Integer.valueOf(locala.lpW) });
      }
      label830:
      if (paramString.teW != null) {
        v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode resp VoiceId=%s, RecognizeRet=%s", new Object[] { Integer.valueOf(paramString.teW.teP), Integer.valueOf(paramString.teW.teX) });
      }
      if ((paramString.teW == null) || (paramString.teW.teX != 0))
      {
        if (System.currentTimeMillis() - this.lpF >= paramString.teT)
        {
          ae.v(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(5709219495936L, 42537);
              ExtControlProviderVoiceControl.this.a(locala.lpR, locala.appId, locala.lpS);
              GMTrace.o(5709219495936L, 42537);
            }
          });
          GMTrace.o(5707743100928L, 42526);
          return;
        }
        long l2 = paramString.teT - (System.currentTimeMillis() - this.lpF);
        l1 = l2;
        if (l2 > paramString.teT) {
          l1 = paramString.teT;
        }
        ae.f(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(5709890584576L, 42542);
            ExtControlProviderVoiceControl.this.a(locala.lpR, locala.appId, locala.lpS);
            GMTrace.o(5709890584576L, 42542);
          }
        }, l1);
        GMTrace.o(5707743100928L, 42526);
        return;
      }
      if (paramString.teW.teY == null)
      {
        v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo null, countDown");
        this.lpC = 3511;
        this.lpG.countDown();
        GMTrace.o(5707743100928L, 42526);
        return;
      }
      if ((paramString.teW.teY.teZ == null) || (paramString.teW.teY.teZ.size() <= 0))
      {
        v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo.Items null, countDown");
        this.lpC = 3511;
        this.lpG.countDown();
        GMTrace.o(5707743100928L, 42526);
        return;
      }
      if (paramString.teW.teY.teZ.size() == 0)
      {
        this.lpC = 3511;
        this.lpG.countDown();
        GMTrace.o(5707743100928L, 42526);
        return;
      }
      if (paramString.teW.teY.teZ.size() == 1)
      {
        vz(((df)paramString.teW.teY.teZ.get(0)).tfa);
        GMTrace.o(5707743100928L, 42526);
        return;
      }
      paramk = new String[paramString.teW.teY.teZ.size()];
      paramInt1 = 0;
      while (paramInt1 < paramk.length)
      {
        paramk[paramInt1] = ((df)paramString.teW.teY.teZ.get(paramInt1)).tfa;
        v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp result item: %s", new Object[] { paramk[paramInt1] });
        paramInt1 += 1;
      }
      paramString = new Intent();
      paramString.putExtra("VoiceSearchResultUI_Resultlist", paramk);
      paramString.putExtra("VoiceSearchResultUI_VoiceId", locala.lpR);
      paramString.putExtra("VoiceSearchResultUI_IsVoiceControl", true);
      paramString.setFlags(67108864);
      paramString.putExtra("VoiceSearchResultUI_ShowType", 1);
      com.tencent.mm.bb.d.a(this.context, ".ui.voicesearch.VoiceSearchResultUI", paramString);
      v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene end countDown");
      this.lpC = 1;
      this.lpG.countDown();
      GMTrace.o(5707743100928L, 42526);
      return;
    }
    label1364:
    GMTrace.o(5707743100928L, 42526);
  }
  
  public final boolean a(int paramInt, String paramString, com.tencent.mm.bd.b paramb)
  {
    GMTrace.i(5707608883200L, 42525);
    v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult voiceId=%s, appId=%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.lpE == 0L) {
      this.lpE = System.currentTimeMillis();
    }
    this.lpF = System.currentTimeMillis();
    da localda = new da();
    localda.teO = paramb;
    paramString = new a(paramInt, paramString, localda, this.lpE);
    ap.vd().a(paramString, 0);
    GMTrace.o(5707608883200L, 42525);
    return true;
  }
  
  public Cursor query(final Uri paramUri, final String[] paramArrayOfString1, final String paramString1, final String[] paramArrayOfString2, final String paramString2)
  {
    GMTrace.i(5707206230016L, 42522);
    v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] query(), ApiId=%s", new Object[] { Integer.valueOf(this.loD) });
    this.lpD = 0L;
    this.lpE = 0L;
    a(paramUri, this.context, this.loD, this.loC);
    if (paramUri == null)
    {
      v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "uri == null");
      bS(3, 5);
      paramUri = ma(5);
      GMTrace.o(5707206230016L, 42522);
      return paramUri;
    }
    long l1 = System.currentTimeMillis();
    if (bf.mA(this.loL))
    {
      v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "AppID == null");
      bS(3, 7);
      paramUri = ma(7);
      GMTrace.o(5707206230016L, 42522);
      return paramUri;
    }
    if (bf.mA(aqR()))
    {
      v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "PkgName == null");
      bS(3, 6);
      paramUri = ma(6);
      GMTrace.o(5707206230016L, 42522);
      return paramUri;
    }
    long l2 = System.currentTimeMillis();
    long l3 = System.currentTimeMillis();
    long l4 = System.currentTimeMillis();
    int i = aqS();
    if (i != 1)
    {
      v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "invalid appid ! return code = " + i);
      bS(2, i);
      paramUri = ma(i);
      GMTrace.o(5707206230016L, 42522);
      return paramUri;
    }
    v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] getAppIdAndPkg = %s, checkIsLogin = %s", new Object[] { Long.valueOf(l2 - l1), Long.valueOf(l4 - l3) });
    switch (this.loD)
    {
    default: 
      bS(3, 15);
      paramUri = ma(15);
      GMTrace.o(5707206230016L, 42522);
      return paramUri;
    }
    v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "voiceControl");
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 4))
    {
      v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      bS(3, 3501);
      this.lpC = 3501;
      paramUri = ma(3501);
      GMTrace.o(5707206230016L, 42522);
      return paramUri;
    }
    paramUri = paramArrayOfString2[0];
    paramArrayOfString1 = paramArrayOfString2[1];
    paramString1 = paramArrayOfString2[2];
    paramString2 = paramArrayOfString2[3];
    paramArrayOfString2 = paramArrayOfString2[4];
    v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] args: %s, %s, %s, %s %s", new Object[] { paramUri, paramArrayOfString1, paramString1, paramString2, paramArrayOfString2 });
    if ((bf.mA(paramUri)) || (bf.mA(paramArrayOfString1)) || (bf.mA(paramString1)) || (bf.mA(paramString2)) || (bf.mA(paramArrayOfString2)))
    {
      bS(3, 3502);
      v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
      paramUri = ma(3502);
      GMTrace.o(5707206230016L, 42522);
      return paramUri;
    }
    if (!com.tencent.mm.a.e.aO(paramArrayOfString2))
    {
      v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] speex file not exist");
      bS(3, 3503);
      paramUri = ma(3503);
      GMTrace.o(5707206230016L, 42522);
      return paramUri;
    }
    this.lpD = System.currentTimeMillis();
    ap.vd().a(985, this);
    this.lpG.b(13000L, new Runnable()
    {
      public final void run()
      {
        GMTrace.i(5710159020032L, 42544);
        int i = bf.getInt(paramUri, 4);
        if (i == 1) {
          ExtControlProviderVoiceControl.a(ExtControlProviderVoiceControl.this, paramArrayOfString2);
        }
        for (;;)
        {
          if (!ExtControlProviderVoiceControl.a(ExtControlProviderVoiceControl.a(ExtControlProviderVoiceControl.this), i, bf.getInt(paramArrayOfString1, 4), bf.getInt(paramString1, 16000), bf.getInt(paramString2, 16), paramArrayOfString2))
          {
            v.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] !ok countDown");
            ExtControlProviderVoiceControl.a(ExtControlProviderVoiceControl.this, 3504);
            ExtControlProviderVoiceControl.this.lpG.countDown();
          }
          GMTrace.o(5710159020032L, 42544);
          return;
          v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] not pcm, don't run localVoiceControl");
        }
      }
    });
    v.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] finish uploadVoice = %s, getResult = %s", new Object[] { Long.valueOf(this.lpE - this.lpD), Long.valueOf(System.currentTimeMillis() - this.lpE) });
    ap.vd().b(985, this);
    z(10, 0, 1);
    if (1 != this.lpC) {
      z(11, 4, 1);
    }
    for (;;)
    {
      lZ(0);
      paramUri = ma(this.lpC);
      GMTrace.o(5707206230016L, 42522);
      return paramUri;
      z(10, 0, 1);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/ext/voicecontrol/ExtControlProviderVoiceControl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */