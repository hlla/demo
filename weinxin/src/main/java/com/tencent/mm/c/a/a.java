package com.tencent.mm.c.a;

import android.content.Context;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.compatible.b.e.a;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.b.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.modelvoice.d.a;
import com.tencent.mm.modelvoice.d.b;
import com.tencent.mm.modelvoice.i;
import com.tencent.mm.modelvoice.j;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.f.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.ap.b;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.g;
import com.tencent.mm.y.g.a;
import junit.framework.Assert;

public final class a
  implements e.a, g
{
  public static String fyP;
  public Context context;
  private d fyG;
  public boolean fyH;
  private boolean fyI;
  public boolean fyJ;
  private int fyK;
  private boolean fyL;
  public boolean fyM;
  public boolean fyN;
  public String fyO;
  private b.a fyQ;
  public com.tencent.mm.y.g.b fyR;
  public g.a fyS;
  
  static
  {
    GMTrace.i(18913022705664L, 140913);
    fyP = null;
    GMTrace.o(18913022705664L, 140913);
  }
  
  public a(Context paramContext)
  {
    this(paramContext, 0);
    GMTrace.i(4493206880256L, 33477);
    GMTrace.o(4493206880256L, 33477);
  }
  
  public a(Context paramContext, int paramInt)
  {
    GMTrace.i(4493341097984L, 33478);
    this.fyG = null;
    this.context = null;
    this.fyH = false;
    this.fyI = false;
    this.fyJ = false;
    this.fyK = 0;
    this.fyL = false;
    this.fyM = false;
    this.fyN = true;
    this.fyO = null;
    this.fyQ = new b.a()
    {
      public final void cX(int paramAnonymousInt)
      {
        GMTrace.i(17480248459264L, 130238);
        v.i("MicroMsg.SceneVoicePlayer", "on audio focus chage: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if ((paramAnonymousInt == -2) || (paramAnonymousInt == -3))
        {
          if (a.this.isPlaying())
          {
            v.v("MicroMsg.SceneVoicePlayer", "alvinluo current fileName: %s, lastFileName: %s", new Object[] { a.this.fyO, a.fyP });
            if ((a.this.fyO == null) || (a.this.fyO.equals(a.fyP)))
            {
              a.this.ao(false);
              GMTrace.o(17480248459264L, 130238);
            }
          }
        }
        else
        {
          if ((paramAnonymousInt == 1) || (paramAnonymousInt == 2) || (paramAnonymousInt == 3))
          {
            a.this.oR();
            GMTrace.o(17480248459264L, 130238);
            return;
          }
          if (paramAnonymousInt == -1) {
            a.this.ap(false);
          }
        }
        GMTrace.o(17480248459264L, 130238);
      }
    };
    this.fyR = null;
    this.context = paramContext;
    this.fyK = paramInt;
    new com.tencent.mm.c.b.g.b();
    GMTrace.o(4493341097984L, 33478);
  }
  
  private void oT()
  {
    GMTrace.i(4495085928448L, 33491);
    d.a local3 = new d.a()
    {
      public final void oW()
      {
        GMTrace.i(17480919547904L, 130243);
        com.tencent.mm.sdk.f.e.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(17479711588352L, 130234);
            try
            {
              if (p.gQT.gNM == 1) {
                Thread.sleep(300L);
              }
              v.i("MicroMsg.SceneVoicePlayer", "onCompletion, intOnCompletion: %s, shouldPlayComplete: %s", new Object[] { a.this.fyS, Boolean.valueOf(a.this.fyN) });
              ae.v(new Runnable()
              {
                public final void run()
                {
                  GMTrace.i(17480114241536L, 130237);
                  com.tencent.mm.compatible.b.e.qE().c(a.this.fyH, false);
                  ap.b localb;
                  if (a.this.fyN)
                  {
                    Context localContext = a.this.context;
                    int i = a.a.jyU;
                    boolean bool = a.this.fyH;
                    ap.a local1 = new ap.a()
                    {
                      public final void oW()
                      {
                        GMTrace.i(17480651112448L, 130241);
                        v.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                        if (!a.this.isPlaying())
                        {
                          com.tencent.mm.compatible.b.e.qE().b(a.this);
                          v.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.this.fyJ) });
                          if (!a.this.fyJ) {
                            com.tencent.mm.compatible.b.e.qE().qH();
                          }
                          a.this.fyJ = false;
                          a.this.fyM = false;
                          com.tencent.mm.compatible.b.e.qE().setMode(0);
                          v.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                        }
                        GMTrace.o(17480651112448L, 130241);
                      }
                    };
                    if (bool)
                    {
                      localb = ap.b.utd;
                      ap.a(localContext, i, localb, false, local1);
                    }
                  }
                  for (;;)
                  {
                    if (a.this.fyS == null) {
                      break label299;
                    }
                    v.i("MicroMsg.SceneVoicePlayer", "intOnCompletion onCompletion()");
                    a.this.fyS.oW();
                    GMTrace.o(17480114241536L, 130237);
                    return;
                    localb = ap.b.ute;
                    break;
                    v.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                    if (!a.this.isPlaying())
                    {
                      com.tencent.mm.compatible.b.e.qE().b(a.this);
                      v.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[] { Boolean.valueOf(a.this.fyJ) });
                      if (!a.this.fyJ) {
                        com.tencent.mm.compatible.b.e.qE().qH();
                      }
                      a.this.fyJ = false;
                      a.this.fyM = false;
                      com.tencent.mm.compatible.b.e.qE().setMode(0);
                      v.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                    }
                  }
                  label299:
                  v.e("MicroMsg.SceneVoicePlayer", "intOnCompletion is null!!!");
                  GMTrace.o(17480114241536L, 130237);
                }
              });
              GMTrace.o(17479711588352L, 130234);
              return;
            }
            catch (Exception localException)
            {
              v.e("MicroMsg.SceneVoicePlayer", "exception:%s", new Object[] { bf.g(localException) });
              GMTrace.o(17479711588352L, 130234);
            }
          }
        }, "SceneVoice_onCompletion");
        GMTrace.o(17480919547904L, 130243);
      }
    };
    if (this.fyG != null) {
      this.fyG.a(local3);
    }
    GMTrace.o(4495085928448L, 33491);
  }
  
  private void setError()
  {
    GMTrace.i(4494817492992L, 33489);
    d.b local2 = new d.b()
    {
      public final void onError()
      {
        GMTrace.i(17479845806080L, 130235);
        com.tencent.mm.compatible.b.e.qE().b(a.this);
        if (a.this.fyM)
        {
          com.tencent.mm.compatible.b.e.qE().qH();
          a.this.fyM = false;
        }
        com.tencent.mm.compatible.b.e.qE().setMode(0);
        if (a.this.fyR != null) {
          ae.v(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(4492267356160L, 33470);
              a.this.fyR.onError();
              GMTrace.o(4492267356160L, 33470);
            }
          });
        }
        GMTrace.o(17479845806080L, 130235);
      }
    };
    if (this.fyG != null) {
      this.fyG.a(local2);
    }
    GMTrace.o(4494817492992L, 33489);
  }
  
  public final void a(g.a parama)
  {
    GMTrace.i(4494951710720L, 33490);
    this.fyS = parama;
    GMTrace.o(4494951710720L, 33490);
  }
  
  public final void a(com.tencent.mm.y.g.b paramb)
  {
    GMTrace.i(4494683275264L, 33488);
    this.fyR = paramb;
    GMTrace.o(4494683275264L, 33488);
  }
  
  public final boolean a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    GMTrace.i(4493743751168L, 33481);
    v.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(true), Integer.valueOf(paramInt1), Integer.valueOf(this.fyK) });
    if (paramString.length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (FileOp.aO(paramString)) {
        break;
      }
      v.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[] { paramString, paramString });
      GMTrace.o(4493743751168L, 33481);
      return false;
    }
    int i = paramInt1;
    if (paramInt1 == -1) {
      i = o.e(paramString, this.fyK, true);
    }
    if (i == 0) {
      if (this.context != null) {
        this.fyG = new s(this.context);
      }
    }
    for (;;)
    {
      if (this.fyG != null) {
        this.fyG.b(this.fyQ);
      }
      this.fyH = paramBoolean;
      this.fyL = paramBoolean;
      if ((com.tencent.mm.compatible.b.e.qE().qO()) || (com.tencent.mm.compatible.b.e.qE().qI()))
      {
        v.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(com.tencent.mm.compatible.b.e.qE().qO()), Boolean.valueOf(com.tencent.mm.compatible.b.e.qE().qI()) });
        this.fyH = false;
      }
      com.tencent.mm.compatible.b.e.qE().c(this.fyH, false);
      oT();
      setError();
      com.tencent.mm.compatible.b.e.qE().a(this);
      if (!com.tencent.mm.compatible.b.e.qE().qO())
      {
        com.tencent.mm.compatible.b.e.qE().qG();
        this.fyM = true;
      }
      if (this.fyG.c(paramString, this.fyH, paramInt2)) {
        break;
      }
      v.i("MicroMsg.SceneVoicePlayer", "start play fileName[" + paramString + "], [" + paramBoolean + "]");
      com.tencent.mm.compatible.b.e.qE().qH();
      this.fyM = false;
      GMTrace.o(4493743751168L, 33481);
      return false;
      this.fyG = new s();
      continue;
      if (i == 1)
      {
        if (this.context != null) {
          this.fyG = new j(this.context);
        } else {
          this.fyG = new j();
        }
      }
      else if (i == 2) {
        if (this.context != null) {
          this.fyG = new i(this.context);
        } else {
          this.fyG = new i();
        }
      }
    }
    GMTrace.o(4493743751168L, 33481);
    return true;
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    GMTrace.i(4493609533440L, 33480);
    v.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt), Integer.valueOf(this.fyK) });
    boolean bool;
    if (paramString.length() > 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      fyP = this.fyO;
      this.fyO = paramString;
      if (!paramBoolean2) {
        break label142;
      }
      str = paramString;
      label90:
      if (FileOp.aO(str)) {
        break label160;
      }
      if (!paramBoolean2) {
        break label151;
      }
    }
    label142:
    label151:
    for (String str = paramString;; str = q.jt(paramString))
    {
      v.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", new Object[] { paramString, str });
      GMTrace.o(4493609533440L, 33480);
      return false;
      bool = false;
      break;
      str = q.jt(paramString);
      break label90;
    }
    label160:
    int i = paramInt;
    if (paramInt == -1) {
      i = o.e(paramString, this.fyK, paramBoolean2);
    }
    if (i == 0) {
      if (this.context != null)
      {
        this.fyG = new s(this.context);
        if (this.fyG != null) {
          this.fyG.b(this.fyQ);
        }
        this.fyH = paramBoolean1;
        this.fyL = paramBoolean1;
        if ((com.tencent.mm.compatible.b.e.qE().qO()) || (com.tencent.mm.compatible.b.e.qE().qI()))
        {
          v.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", new Object[] { Boolean.valueOf(com.tencent.mm.compatible.b.e.qE().qO()), Boolean.valueOf(com.tencent.mm.compatible.b.e.qE().qI()) });
          this.fyH = false;
        }
        com.tencent.mm.compatible.b.e.qE().c(this.fyH, false);
        oT();
        setError();
        str = null;
        if (!paramBoolean2) {
          break label534;
        }
        str = paramString;
      }
    }
    for (;;)
    {
      com.tencent.mm.compatible.b.e.qE().a(this);
      if (!com.tencent.mm.compatible.b.e.qE().qO())
      {
        com.tencent.mm.compatible.b.e.qE().qG();
        this.fyM = true;
      }
      if (this.fyG.C(str, this.fyH)) {
        break label550;
      }
      v.i("MicroMsg.SceneVoicePlayer", "start play error fileName[" + paramString + "], [" + paramBoolean1 + "]");
      com.tencent.mm.compatible.b.e.qE().qH();
      this.fyM = false;
      GMTrace.o(4493609533440L, 33480);
      return false;
      this.fyG = new s();
      break;
      if (i == 1)
      {
        if (this.context != null)
        {
          this.fyG = new j(this.context);
          break;
        }
        this.fyG = new j();
        break;
      }
      if (i != 2) {
        break;
      }
      if (this.context != null)
      {
        this.fyG = new i(this.context);
        break;
      }
      this.fyG = new i();
      break;
      label534:
      if (this.fyK == 0) {
        str = q.jt(paramString);
      }
    }
    label550:
    GMTrace.o(4493609533440L, 33480);
    return true;
  }
  
  public final boolean ao(boolean paramBoolean)
  {
    GMTrace.i(17480382676992L, 130239);
    if (this.fyG == null)
    {
      GMTrace.o(17480382676992L, 130239);
      return false;
    }
    v.i("MicroMsg.SceneVoicePlayer", "pause");
    if (this.fyG.isPlaying()) {}
    for (paramBoolean = this.fyG.ao(paramBoolean);; paramBoolean = false)
    {
      if ((paramBoolean) && (this.fyM))
      {
        com.tencent.mm.compatible.b.e.qE().qH();
        this.fyM = false;
      }
      com.tencent.mm.compatible.b.e.qE().setMode(0);
      GMTrace.o(17480382676992L, 130239);
      return paramBoolean;
    }
  }
  
  public final void ap(boolean paramBoolean)
  {
    GMTrace.i(14893872840704L, 110968);
    if (this.fyG == null)
    {
      GMTrace.o(14893872840704L, 110968);
      return;
    }
    v.i("MicroMsg.SceneVoicePlayer", "stop, isRequestStartBluetooth: %b, player.isPlaying: %b, fromStart: %b", new Object[] { Boolean.valueOf(this.fyM), Boolean.valueOf(this.fyG.isPlaying()), Boolean.valueOf(paramBoolean) });
    this.fyG.pd();
    com.tencent.mm.compatible.b.e.qE().b(this);
    if ((this.fyM) && (!paramBoolean))
    {
      com.tencent.mm.compatible.b.e.qE().qH();
      this.fyM = false;
    }
    com.tencent.mm.compatible.b.e.qE().setMode(0);
    GMTrace.o(14893872840704L, 110968);
  }
  
  public final void aq(boolean paramBoolean)
  {
    GMTrace.i(4494549057536L, 33487);
    if (this.fyH == paramBoolean)
    {
      GMTrace.o(4494549057536L, 33487);
      return;
    }
    this.fyH = paramBoolean;
    if ((this.fyG != null) && (this.fyG.isPlaying())) {
      this.fyG.aq(paramBoolean);
    }
    com.tencent.mm.compatible.b.e.qE().c(paramBoolean, false);
    GMTrace.o(4494549057536L, 33487);
  }
  
  public final void ar(boolean paramBoolean)
  {
    GMTrace.i(14894007058432L, 110969);
    v.i("MicroMsg.SceneVoicePlayer", "setContinuousPlay() continuousPlay:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.fyJ = paramBoolean;
    GMTrace.o(14894007058432L, 110969);
  }
  
  public final void cW(int paramInt)
  {
    GMTrace.i(4495488581632L, 33494);
    v.i("MicroMsg.SceneVoicePlayer", "onBluetoothHeadsetStateChange, status: %d, currentSpeaker: %b, bluetoothResumeSpeaker: %b, isRequestStartBluetooth: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.fyH), Boolean.valueOf(this.fyL), Boolean.valueOf(this.fyM) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      GMTrace.o(4495488581632L, 33494);
      return;
      aq(false);
      GMTrace.o(4495488581632L, 33494);
      return;
      aq(this.fyL);
      if (this.fyM)
      {
        com.tencent.mm.compatible.b.e.qE().qH();
        this.fyM = false;
        GMTrace.o(4495488581632L, 33494);
        return;
        aq(this.fyL);
        if ((this.fyG != null) && (this.fyG.isPlaying()))
        {
          com.tencent.mm.compatible.b.e.qE().qG();
          this.fyM = true;
          GMTrace.o(4495488581632L, 33494);
          return;
          if ((this.fyG != null) && (this.fyG.isPlaying()))
          {
            com.tencent.mm.compatible.b.e.qE().qG();
            this.fyM = true;
          }
        }
      }
    }
  }
  
  public final boolean h(String paramString, boolean paramBoolean)
  {
    GMTrace.i(4494146404352L, 33484);
    paramBoolean = a(paramString, paramBoolean, false, -1);
    GMTrace.o(4494146404352L, 33484);
    return paramBoolean;
  }
  
  public final boolean isPlaying()
  {
    GMTrace.i(4493475315712L, 33479);
    if (this.fyG == null)
    {
      GMTrace.o(4493475315712L, 33479);
      return false;
    }
    boolean bool = this.fyG.isPlaying();
    GMTrace.o(4493475315712L, 33479);
    return bool;
  }
  
  public final boolean oR()
  {
    GMTrace.i(4494012186624L, 33483);
    if (this.fyG == null)
    {
      GMTrace.o(4494012186624L, 33483);
      return false;
    }
    v.i("MicroMsg.SceneVoicePlayer", "resume");
    boolean bool = this.fyG.oR();
    if (bool)
    {
      com.tencent.mm.compatible.b.e.qE().qG();
      this.fyM = true;
      if (com.tencent.mm.compatible.b.e.qE().qI()) {
        this.fyH = false;
      }
      com.tencent.mm.compatible.b.e.qE().c(this.fyH, false);
    }
    GMTrace.o(4494012186624L, 33483);
    return bool;
  }
  
  public final boolean oS()
  {
    GMTrace.i(4494280622080L, 33485);
    boolean bool = this.fyI;
    GMTrace.o(4494280622080L, 33485);
    return bool;
  }
  
  public final double oU()
  {
    GMTrace.i(4495220146176L, 33492);
    if (this.fyG == null)
    {
      GMTrace.o(4495220146176L, 33492);
      return 0.0D;
    }
    double d = this.fyG.oU();
    GMTrace.o(4495220146176L, 33492);
    return d;
  }
  
  public final boolean oV()
  {
    GMTrace.i(4495354363904L, 33493);
    if (this.fyG == null)
    {
      GMTrace.o(4495354363904L, 33493);
      return false;
    }
    if (this.fyG.getStatus() == 2)
    {
      GMTrace.o(4495354363904L, 33493);
      return true;
    }
    GMTrace.o(4495354363904L, 33493);
    return false;
  }
  
  public final boolean pause()
  {
    GMTrace.i(4493877968896L, 33482);
    boolean bool = ao(true);
    GMTrace.o(4493877968896L, 33482);
    return bool;
  }
  
  public final void stop()
  {
    GMTrace.i(4494414839808L, 33486);
    ap(false);
    GMTrace.o(4494414839808L, 33486);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/c/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */