package com.tencent.mm.c.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.b.b.a;
import com.tencent.mm.compatible.b.e.a;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.t;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.h.b;

public class h
  implements e.a, com.tencent.mm.y.h
{
  public a fAF;
  public b fAG;
  private a fAH;
  private String fAI;
  private boolean fAJ;
  private boolean fAK;
  public long fAL;
  public long fAM;
  public int fAN;
  public boolean fAO;
  public boolean fAP;
  public int fAQ;
  private b.a fAR;
  protected h.b fAS;
  protected com.tencent.mm.y.h.a fAT;
  private boolean fAU;
  private ai fAV;
  public String mFileName;
  
  public h(Context paramContext, boolean paramBoolean)
  {
    GMTrace.i(4476161228800L, 33350);
    this.fAF = null;
    this.fAH = null;
    this.mFileName = "";
    this.fAJ = false;
    this.fAK = false;
    this.fAM = 0L;
    this.fAN = 0;
    this.fAO = false;
    this.fAP = false;
    this.fAQ = 0;
    this.fAR = b.a.gNc;
    this.fAT = null;
    this.fAU = false;
    this.fAV = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(4475490140160L, 33345);
        q.a(h.this.mFileName, h.this);
        com.tencent.mm.modelvoice.m.LB().run();
        v.d("MicroMsg.SceneVoice.Recorder", "Start Send fileName :" + h.this.mFileName);
        GMTrace.o(4475490140160L, 33345);
        return false;
      }
    }, true);
    this.fAG = new b(paramContext);
    this.fAP = paramBoolean;
    v.i("MicroMsg.SceneVoice.Recorder", "new SceneVoiceRecorder, useSpeex: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    GMTrace.o(4476161228800L, 33350);
  }
  
  public final void a(com.tencent.mm.y.h.a parama)
  {
    GMTrace.i(4477771841536L, 33362);
    this.fAT = parama;
    GMTrace.o(4477771841536L, 33362);
  }
  
  public final void a(h.b paramb)
  {
    GMTrace.i(4477906059264L, 33363);
    this.fAS = paramb;
    GMTrace.o(4477906059264L, 33363);
  }
  
  public final boolean bx(String paramString)
  {
    GMTrace.i(4476966535168L, 33356);
    v.i("MicroMsg.SceneVoice.Recorder", "Start Record to  " + paramString);
    reset();
    this.fAI = paramString;
    this.fAL = bf.NB();
    if (paramString == null)
    {
      v.e("MicroMsg.SceneVoice.Recorder", "Start Record toUser null");
      GMTrace.o(4476966535168L, 33356);
      return false;
    }
    this.fAJ = paramString.equals("_USER_FOR_THROWBOTTLE_");
    if (paramString.equals("medianote"))
    {
      if ((com.tencent.mm.u.m.xP() & 0x4000) == 0) {
        this.fAK = true;
      }
    }
    else
    {
      if (this.fAP) {
        break label196;
      }
      if (!this.fAJ) {
        break label177;
      }
      this.mFileName = u.mg(com.tencent.mm.u.m.xL());
    }
    for (;;)
    {
      if ((this.mFileName != null) && (this.mFileName.length() > 0)) {
        break label207;
      }
      v.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", new Object[] { this.mFileName });
      GMTrace.o(4476966535168L, 33356);
      return false;
      this.fAK = false;
      break;
      label177:
      if (this.fAK) {
        this.mFileName = u.mg("medianote");
      } else {
        label196:
        this.mFileName = q.lY(paramString);
      }
    }
    label207:
    com.tencent.mm.compatible.b.e.qE().a(this);
    this.fAO = false;
    this.fAU = false;
    if ((com.tencent.mm.compatible.b.e.qL()) && (!com.tencent.mm.compatible.b.e.qE().qI()))
    {
      this.fAU = true;
      com.tencent.mm.compatible.b.e.qE().qG();
      ae.f(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(4476027011072L, 33349);
          if (!h.this.fAO)
          {
            v.d("MicroMsg.SceneVoice.Recorder", "after start bluetooth, timeout to directly start record");
            h.this.po();
          }
          GMTrace.o(4476027011072L, 33349);
        }
      }, 1000L);
    }
    for (;;)
    {
      GMTrace.o(4476966535168L, 33356);
      return true;
      po();
    }
  }
  
  public final void cW(int paramInt)
  {
    GMTrace.i(4477503406080L, 33360);
    v.d("MicroMsg.SceneVoice.Recorder", "dkbt Recorder onBluetoothHeadsetStateChange :" + paramInt);
    if (paramInt == 1) {
      po();
    }
    GMTrace.o(4477503406080L, 33360);
  }
  
  public final boolean cancel()
  {
    GMTrace.i(4477100752896L, 33357);
    v.d("MicroMsg.SceneVoice.Recorder", "cancel Record :" + this.mFileName);
    try
    {
      v.d("MicroMsg.SceneVoice.Recorder", "stop synchronized Record :" + this.mFileName);
      if (this.fAF != null)
      {
        this.fAF.oX();
        this.fAG.rY();
      }
      com.tencent.mm.compatible.b.e.qE().b(this);
      if (this.fAU)
      {
        com.tencent.mm.compatible.b.e.qE().qH();
        this.fAU = false;
      }
      q.lZ(this.mFileName);
      com.tencent.mm.modelvoice.m.LB().run();
      if ((this.fAF != null) && (!bf.mA(this.mFileName)) && (!this.fAP))
      {
        com.tencent.mm.compatible.g.a locala = new com.tencent.mm.compatible.g.a();
        locala.gSb = this.mFileName;
        locala.gSc = pn();
        locala.gSd = 1;
        locala.fFx = this.fAF.oY();
        g.oSF.A(10513, locala.rW());
      }
      this.mFileName = "";
      GMTrace.o(4477100752896L, 33357);
      return true;
    }
    finally {}
  }
  
  public String getFileName()
  {
    GMTrace.i(4476563881984L, 33353);
    String str = this.mFileName;
    GMTrace.o(4476563881984L, 33353);
    return str;
  }
  
  public final int getMaxAmplitude()
  {
    GMTrace.i(4476832317440L, 33355);
    if (this.fAF == null)
    {
      GMTrace.o(4476832317440L, 33355);
      return 0;
    }
    int i = this.fAF.getMaxAmplitude();
    GMTrace.o(4476832317440L, 33355);
    return i;
  }
  
  public boolean pd()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    GMTrace.i(4477234970624L, 33358);
    if (this.fAV != null)
    {
      this.fAV.KI();
      this.fAV.removeCallbacksAndMessages(null);
    }
    com.tencent.mm.compatible.b.e.qE().b(this);
    if (this.fAU)
    {
      com.tencent.mm.compatible.b.e.qE().qH();
      this.fAU = false;
    }
    this.fAN = ((int)pn());
    v.i("MicroMsg.SceneVoice.Recorder", "stop Record : %s, len: %s", new Object[] { this.mFileName, Integer.valueOf(this.fAN) });
    if ((this.fAF != null) && (!bf.mA(this.mFileName)) && (!this.fAP))
    {
      com.tencent.mm.compatible.g.a locala = new com.tencent.mm.compatible.g.a();
      locala.gSb = this.mFileName;
      locala.gSc = this.fAN;
      locala.gSd = 2;
      locala.fFx = this.fAF.oY();
      g.oSF.A(10513, locala.rW());
    }
    try
    {
      v.i("MicroMsg.SceneVoice.Recorder", "stop synchronized Record:%s, recorder:%s", new Object[] { this.mFileName, this.fAF });
      if (this.fAF != null)
      {
        this.fAF.oX();
        this.fAG.rY();
      }
      if (this.fAQ != 2)
      {
        q.mb(this.mFileName);
        this.mFileName = null;
        v.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by not onPart: " + bf.aB(this.fAL));
        bool1 = bool2;
        this.fAQ = -1;
        GMTrace.o(4477234970624L, 33358);
        return bool1;
      }
    }
    finally {}
    if ((this.fAN < 800L) || ((this.fAJ) && (this.fAN < 1000L)))
    {
      v.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by voiceLen: " + this.fAN);
      q.mb(this.mFileName);
      this.mFileName = "";
      bool1 = false;
    }
    for (;;)
    {
      this.mFileName = "";
      break;
      q.K(this.mFileName, this.fAN);
      com.tencent.mm.modelvoice.m.LB().run();
      v.i("MicroMsg.SceneVoice.Recorder", "Stop file success: " + this.mFileName);
    }
  }
  
  public final int pl()
  {
    GMTrace.i(4476429664256L, 33352);
    int i = this.fAN;
    GMTrace.o(4476429664256L, 33352);
    return i;
  }
  
  public final boolean pm()
  {
    GMTrace.i(4476698099712L, 33354);
    if (this.fAF == null)
    {
      GMTrace.o(4476698099712L, 33354);
      return false;
    }
    if (this.fAF.getStatus() == 1)
    {
      GMTrace.o(4476698099712L, 33354);
      return true;
    }
    GMTrace.o(4476698099712L, 33354);
    return false;
  }
  
  public final long pn()
  {
    GMTrace.i(4477369188352L, 33359);
    if (this.fAM == 0L)
    {
      GMTrace.o(4477369188352L, 33359);
      return 0L;
    }
    long l = bf.aB(this.fAM);
    GMTrace.o(4477369188352L, 33359);
    return l;
  }
  
  public final void po()
  {
    GMTrace.i(4477637623808L, 33361);
    if (this.fAO)
    {
      GMTrace.o(4477637623808L, 33361);
      return;
    }
    this.fAO = true;
    if (this.fAP)
    {
      this.fAR = b.a.gNb;
      this.fAF = new k();
      localObject = new com.tencent.mm.y.h.a()
      {
        public final void onError()
        {
          GMTrace.i(4489046130688L, 33446);
          h.this.fAG.rY();
          v.e("MicroMsg.SceneVoice.Recorder", "Record Failed file:" + h.this.mFileName);
          q.mb(h.this.mFileName);
          if (h.this.fAT != null) {
            h.this.fAT.onError();
          }
          GMTrace.o(4489046130688L, 33446);
        }
      };
      if (this.fAF != null) {
        this.fAF.a((com.tencent.mm.y.h.a)localObject);
      }
      this.fAH = new a();
      com.tencent.mm.sdk.f.e.post(this.fAH, "SceneVoiceRecorder_record");
      this.fAQ = 1;
      this.fAV.v(3000L, 3000L);
      v.d("MicroMsg.SceneVoice.Recorder", "start end time:" + bf.aB(this.fAL));
      GMTrace.o(4477637623808L, 33361);
      return;
    }
    Object localObject = aa.getContext().getSharedPreferences(aa.bIN(), 0);
    boolean bool;
    if (p.gQT.gNL == 1)
    {
      bool = false;
      label183:
      if (!((SharedPreferences)localObject).contains("settings_voicerecorder_mode")) {
        ((SharedPreferences)localObject).edit().putBoolean("settings_voicerecorder_mode", bool).commit();
      }
      v.i("AudioConfig", "getModeByConfig mVoiceRecordMode:%d defValue:%b settings_voicerecorder_mode:%b", new Object[] { Integer.valueOf(p.gQT.gNL), Boolean.valueOf(bool), Boolean.valueOf(((SharedPreferences)localObject).getBoolean("settings_voicerecorder_mode", bool)) });
      if (!((SharedPreferences)localObject).getBoolean("settings_voicerecorder_mode", bool)) {
        break label471;
      }
    }
    label471:
    for (localObject = b.a.gMY;; localObject = b.a.gMZ)
    {
      this.fAR = ((b.a)localObject);
      localObject = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("VoiceFormat");
      String str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("VoiceFormatToQQ");
      if (this.fAR == b.a.gMY)
      {
        if ((4 == bf.getInt((String)localObject, 4)) && (g.b.pk())) {
          this.fAR = b.a.gNa;
        }
        if ((this.fAI != null) && (this.fAI.endsWith("@qqim"))) {
          this.fAR = b.a.gMZ;
        }
      }
      if (this.fAR == b.a.gMY)
      {
        v.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode, still in pcm mode, force to amr mode");
        this.fAR = b.a.gMZ;
      }
      v.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode dynamicFormat:%s dynamicFormatQQ:%s recdMode:%s isSilkSoLoadSuccess:%b", new Object[] { localObject, str, this.fAR, Boolean.valueOf(g.b.pk()) });
      this.fAF = new t(this.fAR);
      break;
      bool = true;
      break label183;
    }
  }
  
  public final int pp()
  {
    GMTrace.i(4478040276992L, 33364);
    if (this.fAP)
    {
      GMTrace.o(4478040276992L, 33364);
      return 1;
    }
    if ((this.fAR == b.a.gMY) || (this.fAR == b.a.gMZ))
    {
      GMTrace.o(4478040276992L, 33364);
      return 0;
    }
    if (this.fAR == b.a.gNa)
    {
      GMTrace.o(4478040276992L, 33364);
      return 2;
    }
    GMTrace.o(4478040276992L, 33364);
    return -1;
  }
  
  public final void reset()
  {
    GMTrace.i(4476295446528L, 33351);
    if (this.fAF != null)
    {
      this.fAF.oX();
      this.fAG.rY();
      v.e("MicroMsg.SceneVoice.Recorder", "Reset recorder.stopReocrd");
    }
    this.mFileName = "";
    this.fAL = 0L;
    this.fAH = null;
    this.fAR = b.a.gNc;
    this.fAQ = 0;
    this.fAM = 0L;
    GMTrace.o(4476295446528L, 33351);
  }
  
  private final class a
    implements Runnable
  {
    ad handler;
    
    public a()
    {
      GMTrace.i(4478442930176L, 33367);
      this.handler = new ad()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          GMTrace.i(4479516672000L, 33375);
          if (h.this.fAQ <= 0)
          {
            GMTrace.o(4479516672000L, 33375);
            return;
          }
          paramAnonymousMessage = new StringBuilder("On Part :");
          if (h.this.fAS == null) {}
          for (boolean bool = true;; bool = false)
          {
            v.d("MicroMsg.SceneVoice.Recorder", bool);
            h.this.fAQ = 2;
            if (h.this.fAS != null) {
              h.this.fAS.BF();
            }
            GMTrace.o(4479516672000L, 33375);
            return;
          }
        }
      };
      GMTrace.o(4478442930176L, 33367);
    }
    
    public final void run()
    {
      boolean bool = true;
      GMTrace.i(4478577147904L, 33368);
      synchronized (h.this)
      {
        if (h.this.fAF == null)
        {
          v.e("MicroMsg.SceneVoice.Recorder", "Stop Record Failed recorder == null");
          GMTrace.o(4478577147904L, 33368);
          return;
        }
        String str = h.this.mFileName;
        if (!h.this.fAP) {}
        for (;;)
        {
          str = q.E(str, bool);
          v.d("MicroMsg.SceneVoice.Recorder", "Thread Started Record, fullPath: %s, useSpeex: %s", new Object[] { str, Boolean.valueOf(h.this.fAP) });
          if (h.this.fAF.bw(str)) {
            break;
          }
          q.mb(h.this.mFileName);
          h.this.mFileName = null;
          h.this.fAF = null;
          v.e("MicroMsg.SceneVoice.Recorder", "Thread Start Record  Error fileName[" + h.this.mFileName + "]");
          h.this.fAM = bf.NB();
          v.d("MicroMsg.SceneVoice.Recorder", "Thread Started Record fileName[" + h.this.mFileName + "] time:" + bf.aB(h.this.fAL));
          this.handler.sendEmptyMessageDelayed(0, 1L);
          GMTrace.o(4478577147904L, 33368);
          return;
          bool = false;
        }
        h.this.fAG.requestFocus();
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/c/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */