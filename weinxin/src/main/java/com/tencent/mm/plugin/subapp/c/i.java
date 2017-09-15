package com.tencent.mm.plugin.subapp.c;

import android.content.ContentValues;
import android.os.Message;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.b.e.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.m;
import com.tencent.mm.y.h.a;
import com.tencent.mm.y.h.b;

public final class i
  implements e.a, com.tencent.mm.y.h
{
  private static int fBt;
  public String fyw;
  public com.tencent.mm.modelvoice.k fyy;
  private int jTo;
  public long lLS;
  protected h.b qRJ;
  protected h.a qRK;
  public boolean qRL;
  private a qRM;
  public long qRN;
  public int qRO;
  private ai qRP;
  
  static
  {
    GMTrace.i(5835786813440L, 43480);
    fBt = 100;
    GMTrace.o(5835786813440L, 43480);
  }
  
  public i()
  {
    GMTrace.i(5832565587968L, 43456);
    this.fyy = null;
    this.qRK = null;
    this.jTo = 0;
    this.fyw = "";
    this.qRL = false;
    this.lLS = 0L;
    this.qRN = 0L;
    this.qRO = 0;
    this.qRP = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(5829478580224L, 43433);
        String str = i.this.fyw;
        g localg;
        if (str != null)
        {
          localg = h.Hj(str);
          if (localg != null) {
            break label93;
          }
          v.d("MicroMsg.VoiceRemindLogic", "startSend null record : " + str);
        }
        for (;;)
        {
          d.bmS().run();
          v.d("MicroMsg.VoiceRemindRecorder", "Start Send fileName :" + i.this.fyw);
          GMTrace.o(5829478580224L, 43433);
          return false;
          label93:
          if (localg.field_status == 1)
          {
            localg.field_status = 2;
            localg.fRM = 64;
            h.a(localg);
          }
        }
      }
    }, true);
    GMTrace.o(5832565587968L, 43456);
  }
  
  public static boolean mb(String paramString)
  {
    GMTrace.i(16029891690496L, 119432);
    boolean bool = h.mb(paramString);
    GMTrace.o(16029891690496L, 119432);
    return bool;
  }
  
  public final void a(h.a parama)
  {
    GMTrace.i(5834041982976L, 43467);
    this.qRK = parama;
    GMTrace.o(5834041982976L, 43467);
  }
  
  public final void a(h.b paramb)
  {
    GMTrace.i(5834176200704L, 43468);
    this.qRJ = paramb;
    GMTrace.o(5834176200704L, 43468);
  }
  
  public final boolean bx(String paramString)
  {
    GMTrace.i(5833236676608L, 43461);
    String str = k.lv(m.xL());
    Object localObject = new g();
    ((g)localObject).field_filename = str;
    ((g)localObject).field_user = paramString;
    ((g)localObject).field_createtime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_clientid = str;
    ((g)localObject).field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    ((g)localObject).field_status = 1;
    ((g)localObject).field_human = m.xL();
    ((g)localObject).fRM = -1;
    paramString = d.bmR();
    v.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert");
    localObject = ((g)localObject).pv();
    int i = (int)paramString.gUp.insert("VoiceRemindInfo", "", (ContentValues)localObject);
    v.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert result" + i);
    paramString = str;
    if (i == -1) {
      paramString = null;
    }
    this.fyw = paramString;
    ap.yZ().a(this);
    i = ap.yZ().qG();
    this.qRL = false;
    if (i != 0) {
      cW(100);
    }
    for (;;)
    {
      GMTrace.o(5833236676608L, 43461);
      return false;
      new ad()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          GMTrace.i(5838873821184L, 43503);
          v.d("MicroMsg.VoiceRemindRecorder", " Recorder handleMessage");
          if (i.this.qRL)
          {
            GMTrace.o(5838873821184L, 43503);
            return;
          }
          ap.yZ().b(i.this);
          ap.yZ().qH();
          i.this.cW(200);
          GMTrace.o(5838873821184L, 43503);
        }
      }.sendEmptyMessageDelayed(0, 50L);
    }
  }
  
  public final void cW(int paramInt)
  {
    GMTrace.i(5832699805696L, 43457);
    v.d("MicroMsg.VoiceRemindRecorder", " Recorder onBluetoothHeadsetStateChange :" + paramInt);
    if (this.qRL)
    {
      GMTrace.o(5832699805696L, 43457);
      return;
    }
    this.qRL = true;
    ap.yZ().b(this);
    this.fyy = new com.tencent.mm.modelvoice.k();
    new h.a()
    {
      public final void onError()
      {
        GMTrace.i(5838202732544L, 43498);
        v.e("MicroMsg.VoiceRemindRecorder", "Record Failed file:" + i.this.fyw);
        i.mb(i.this.fyw);
        if (i.this.qRK != null) {
          i.this.qRK.onError();
        }
        GMTrace.o(5838202732544L, 43498);
      }
    };
    this.qRM = new a();
    com.tencent.mm.sdk.f.e.post(this.qRM, "VoiceRemindRecorder_record");
    this.qRO = 1;
    this.qRP.v(3000L, 3000L);
    v.d("MicroMsg.VoiceRemindRecorder", "start end time:" + bf.aB(this.qRN));
    GMTrace.o(5832699805696L, 43457);
  }
  
  public final boolean cancel()
  {
    GMTrace.i(5833370894336L, 43462);
    v.d("MicroMsg.VoiceRemindRecorder", "cancel Record :" + this.fyw);
    try
    {
      v.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fyw);
      if (this.fyy != null) {
        this.fyy.oX();
      }
      String str = this.fyw;
      if (str != null)
      {
        v.d("MicroMsg.VoiceRemindLogic", "Mark Canceled fileName[" + str + "]");
        g localg = h.Hj(str);
        if (localg != null)
        {
          localg.field_status = 8;
          localg.field_totallen = c.ly(h.at(str, false));
          localg.fRM = 64;
          h.a(localg);
        }
      }
      d.bmS().run();
      this.fyw = "";
      GMTrace.o(5833370894336L, 43462);
      return true;
    }
    finally {}
  }
  
  public final String getFileName()
  {
    GMTrace.i(5832968241152L, 43459);
    String str = this.fyw;
    GMTrace.o(5832968241152L, 43459);
    return str;
  }
  
  public final int getMaxAmplitude()
  {
    GMTrace.i(5832834023424L, 43458);
    if (this.fyy != null)
    {
      int i = this.fyy.getMaxAmplitude();
      if (i > fBt) {
        fBt = i;
      }
      v.d("getMaxAmplitude", " map: " + i + " max:" + fBt + " per:" + i * 100 / fBt);
      i = i * 100 / fBt;
      GMTrace.o(5832834023424L, 43458);
      return i;
    }
    GMTrace.o(5832834023424L, 43458);
    return 0;
  }
  
  public final boolean pd()
  {
    boolean bool1 = true;
    boolean bool2 = false;
    GMTrace.i(5833505112064L, 43463);
    ap.yZ().qH();
    v.d("MicroMsg.VoiceRemindRecorder", "stop Record :" + this.fyw);
    try
    {
      v.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fyw);
      if (this.fyy != null) {
        this.fyy.oX();
      }
      if (this.qRO != 2)
      {
        h.mb(this.fyw);
        this.fyw = null;
        v.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fyw + " by not onPart: " + bf.aB(this.qRN));
        bool1 = bool2;
        this.qRO = -1;
        GMTrace.o(5833505112064L, 43463);
        return bool1;
      }
    }
    finally {}
    this.jTo = ((int)pn());
    if ((this.jTo < 800L) || (this.jTo < 1000L))
    {
      v.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fyw + " by voiceLen: " + this.jTo);
      h.mb(this.fyw);
      this.fyw = "";
      bool1 = false;
    }
    String str;
    int i;
    g localg;
    for (;;)
    {
      this.fyw = "";
      break;
      str = this.fyw;
      i = this.jTo;
      if (str != null)
      {
        v.d("MicroMsg.VoiceRemindLogic", "StopRecord fileName[" + str + "]");
        localg = h.Hj(str);
        if (localg != null)
        {
          if ((localg.field_status != 97) && (localg.field_status != 98)) {
            localg.field_status = 3;
          }
          localg.field_totallen = c.ly(h.at(str, false));
          if (localg.field_totallen > 0) {
            break label417;
          }
          h.lB(str);
        }
      }
      d.bmS().run();
      v.d("MicroMsg.VoiceRemindRecorder", "Stop file success: " + this.fyw);
    }
    label417:
    localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
    localg.field_voicelenght = i;
    localg.fRM = 3424;
    au localau = new au();
    localau.cH(localg.field_user);
    localau.setType(34);
    localau.dw(1);
    localau.cI(str);
    if (localg.field_status == 97)
    {
      localau.dv(2);
      localau.setContent(f.b(localg.field_human, localg.field_voicelenght, false));
    }
    for (;;)
    {
      localau.z(ay.gk(localg.field_user));
      localg.field_msglocalid = ((int)ay.i(localau));
      h.a(localg);
      break;
      if (localg.field_status == 98)
      {
        localau.dv(5);
        localau.setContent(f.b(localg.field_human, -1L, true));
      }
      else
      {
        localau.dv(1);
      }
    }
  }
  
  public final int pl()
  {
    GMTrace.i(5833907765248L, 43466);
    int i = this.jTo;
    GMTrace.o(5833907765248L, 43466);
    return i;
  }
  
  public final boolean pm()
  {
    GMTrace.i(5833102458880L, 43460);
    if (this.fyy == null)
    {
      GMTrace.o(5833102458880L, 43460);
      return false;
    }
    if (this.fyy.mStatus == 1)
    {
      GMTrace.o(5833102458880L, 43460);
      return true;
    }
    GMTrace.o(5833102458880L, 43460);
    return false;
  }
  
  public final long pn()
  {
    GMTrace.i(5833639329792L, 43464);
    if (this.lLS <= 0L)
    {
      GMTrace.o(5833639329792L, 43464);
      return 0L;
    }
    long l = bf.aB(this.lLS);
    GMTrace.o(5833639329792L, 43464);
    return l;
  }
  
  public final int pp()
  {
    GMTrace.i(5834310418432L, 43469);
    GMTrace.o(5834310418432L, 43469);
    return 0;
  }
  
  public final void reset()
  {
    GMTrace.i(5833773547520L, 43465);
    if (this.fyy != null)
    {
      this.fyy.oX();
      v.e("MicroMsg.VoiceRemindRecorder", "Reset recorder.stopReocrd");
    }
    this.fyw = "";
    this.qRN = 0L;
    this.qRM = null;
    this.qRO = 0;
    this.lLS = 0L;
    GMTrace.o(5833773547520L, 43465);
  }
  
  private final class a
    implements Runnable
  {
    ad handler;
    
    public a()
    {
      GMTrace.i(5839276474368L, 43506);
      this.handler = new ad()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          GMTrace.i(5843034570752L, 43534);
          if (i.this.qRO <= 0)
          {
            GMTrace.o(5843034570752L, 43534);
            return;
          }
          paramAnonymousMessage = new StringBuilder("On Part :");
          if (i.this.qRJ == null) {}
          for (boolean bool = true;; bool = false)
          {
            v.d("MicroMsg.VoiceRemindRecorder", bool);
            i.this.qRO = 2;
            if (i.this.qRJ != null) {
              i.this.qRJ.BF();
            }
            GMTrace.o(5843034570752L, 43534);
            return;
          }
        }
      };
      GMTrace.o(5839276474368L, 43506);
    }
    
    public final void run()
    {
      GMTrace.i(5839410692096L, 43507);
      if (i.this.fyy == null)
      {
        v.e("MicroMsg.VoiceRemindRecorder", "Stop Record Failed recorder == null");
        GMTrace.o(5839410692096L, 43507);
        return;
      }
      synchronized (i.this)
      {
        if (!i.this.fyy.bw(h.at(i.this.fyw, true)))
        {
          i.mb(i.this.fyw);
          i.this.fyw = null;
          v.d("MicroMsg.VoiceRemindRecorder", "Thread Start Record  Error fileName[" + i.this.fyw + "]");
          i.this.fyy = null;
        }
        i.this.lLS = bf.NB();
        v.d("MicroMsg.VoiceRemindRecorder", "Thread Started Record fileName[" + i.this.fyw + "] time:" + bf.aB(i.this.qRN));
        this.handler.sendEmptyMessageDelayed(0, 1L);
        GMTrace.o(5839410692096L, 43507);
        return;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/subapp/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */