package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.a;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.aw.e.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ap;

public class VoiceSearchLayout
  extends LinearLayout
{
  private static final int[] jWM;
  private static final int[] sJZ;
  private static final int[] sKa;
  private int fFi;
  public boolean fOM;
  public final ai jXi;
  public View llc;
  public a sJQ;
  public Button sJR;
  public boolean sJS;
  public int sJT;
  public b sJU;
  public View sJV;
  public AnimationDrawable sJW;
  public com.tencent.mm.aw.e sJX;
  private boolean sJY;
  private int sKb;
  private int sKc;
  public int sKd;
  
  static
  {
    GMTrace.i(928652460032L, 6919);
    jWM = new int[] { R.g.blr, R.g.bls, R.g.blt, R.g.blu, R.g.blf, R.g.blg, R.g.blh, R.g.bli, R.g.blj, R.g.blk, R.g.bll, R.g.blm, R.g.bln, R.g.blo };
    sJZ = new int[] { R.g.blr, R.g.blr, R.g.blr, R.g.bls, R.g.blt, R.g.bls, R.g.blr, R.g.blu, R.g.blr, R.g.blr };
    sKa = new int[] { R.g.blp, R.g.blq, R.g.blq, R.g.blq, R.g.blp };
    GMTrace.o(928652460032L, 6919);
  }
  
  public VoiceSearchLayout(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(924625928192L, 6889);
    this.llc = null;
    this.sJQ = null;
    this.fOM = false;
    this.sJS = false;
    this.sJT = 0;
    this.sJY = false;
    this.fFi = 0;
    this.sKb = 0;
    this.sKc = 0;
    this.sKd = 0;
    this.jXi = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(1176015732736L, 8762);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          GMTrace.o(1176015732736L, 8762);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.bEG().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bEG()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          GMTrace.o(1176015732736L, 8762);
          return true;
        }
        com.tencent.mm.aw.e locale = VoiceSearchLayout.a(VoiceSearchLayout.this);
        v.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + locale.icA);
        int i = locale.icA;
        locale.icA = 0;
        if (i > com.tencent.mm.aw.e.fBt) {
          com.tencent.mm.aw.e.fBt = i;
        }
        v.d("getMaxAmplitude", " map: " + i + " max:" + com.tencent.mm.aw.e.fBt + " per:" + i * 100 / com.tencent.mm.aw.e.fBt);
        i = i * 100 / com.tencent.mm.aw.e.fBt;
        v.d("MicroMsg.VoiceSearchLayout", "addr vol:" + i);
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.bEH().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bEH()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            GMTrace.o(1176015732736L, 8762);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.bEI().length) {
            i = VoiceSearchLayout.bEI().length - 1;
          }
          v.d("MicroMsg.VoiceSearchLayout", "addr mvol:" + i);
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bEI()[k]);
          GMTrace.o(1176015732736L, 8762);
          return true;
          if (VoiceSearchLayout.d(VoiceSearchLayout.this) > VoiceSearchLayout.e(VoiceSearchLayout.this)) {
            VoiceSearchLayout.i(VoiceSearchLayout.this);
          } else {
            VoiceSearchLayout.j(VoiceSearchLayout.this);
          }
        }
      }
    }, true);
    init(paramContext);
    GMTrace.o(924625928192L, 6889);
  }
  
  public VoiceSearchLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(924491710464L, 6888);
    this.llc = null;
    this.sJQ = null;
    this.fOM = false;
    this.sJS = false;
    this.sJT = 0;
    this.sJY = false;
    this.fFi = 0;
    this.sKb = 0;
    this.sKc = 0;
    this.sKd = 0;
    this.jXi = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(1176015732736L, 8762);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          GMTrace.o(1176015732736L, 8762);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.bEG().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bEG()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          GMTrace.o(1176015732736L, 8762);
          return true;
        }
        com.tencent.mm.aw.e locale = VoiceSearchLayout.a(VoiceSearchLayout.this);
        v.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + locale.icA);
        int i = locale.icA;
        locale.icA = 0;
        if (i > com.tencent.mm.aw.e.fBt) {
          com.tencent.mm.aw.e.fBt = i;
        }
        v.d("getMaxAmplitude", " map: " + i + " max:" + com.tencent.mm.aw.e.fBt + " per:" + i * 100 / com.tencent.mm.aw.e.fBt);
        i = i * 100 / com.tencent.mm.aw.e.fBt;
        v.d("MicroMsg.VoiceSearchLayout", "addr vol:" + i);
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.bEH().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bEH()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            GMTrace.o(1176015732736L, 8762);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.bEI().length) {
            i = VoiceSearchLayout.bEI().length - 1;
          }
          v.d("MicroMsg.VoiceSearchLayout", "addr mvol:" + i);
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bEI()[k]);
          GMTrace.o(1176015732736L, 8762);
          return true;
          if (VoiceSearchLayout.d(VoiceSearchLayout.this) > VoiceSearchLayout.e(VoiceSearchLayout.this)) {
            VoiceSearchLayout.i(VoiceSearchLayout.this);
          } else {
            VoiceSearchLayout.j(VoiceSearchLayout.this);
          }
        }
      }
    }, true);
    init(paramContext);
    GMTrace.o(924491710464L, 6888);
  }
  
  @TargetApi(11)
  public VoiceSearchLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(924357492736L, 6887);
    this.llc = null;
    this.sJQ = null;
    this.fOM = false;
    this.sJS = false;
    this.sJT = 0;
    this.sJY = false;
    this.fFi = 0;
    this.sKb = 0;
    this.sKc = 0;
    this.sKd = 0;
    this.jXi = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(1176015732736L, 8762);
        if (VoiceSearchLayout.a(VoiceSearchLayout.this) == null)
        {
          GMTrace.o(1176015732736L, 8762);
          return true;
        }
        if (VoiceSearchLayout.b(VoiceSearchLayout.this) < VoiceSearchLayout.bEG().length)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bEG()[VoiceSearchLayout.c(VoiceSearchLayout.this)]);
          GMTrace.o(1176015732736L, 8762);
          return true;
        }
        com.tencent.mm.aw.e locale = VoiceSearchLayout.a(VoiceSearchLayout.this);
        v.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + locale.icA);
        int i = locale.icA;
        locale.icA = 0;
        if (i > com.tencent.mm.aw.e.fBt) {
          com.tencent.mm.aw.e.fBt = i;
        }
        v.d("getMaxAmplitude", " map: " + i + " max:" + com.tencent.mm.aw.e.fBt + " per:" + i * 100 / com.tencent.mm.aw.e.fBt);
        i = i * 100 / com.tencent.mm.aw.e.fBt;
        v.d("MicroMsg.VoiceSearchLayout", "addr vol:" + i);
        int k = VoiceSearchLayout.d(VoiceSearchLayout.this);
        if (VoiceSearchLayout.d(VoiceSearchLayout.this) == VoiceSearchLayout.e(VoiceSearchLayout.this))
        {
          if (i <= 10)
          {
            VoiceSearchLayout.f(VoiceSearchLayout.this);
            if (VoiceSearchLayout.g(VoiceSearchLayout.this) >= VoiceSearchLayout.bEH().length) {
              VoiceSearchLayout.h(VoiceSearchLayout.this);
            }
            VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bEH()[VoiceSearchLayout.g(VoiceSearchLayout.this)]);
            GMTrace.o(1176015732736L, 8762);
            return true;
          }
          int j = i / 5;
          i = j;
          if (j >= VoiceSearchLayout.bEI().length) {
            i = VoiceSearchLayout.bEI().length - 1;
          }
          v.d("MicroMsg.VoiceSearchLayout", "addr mvol:" + i);
          VoiceSearchLayout.b(VoiceSearchLayout.this, i);
        }
        for (;;)
        {
          VoiceSearchLayout.a(VoiceSearchLayout.this, VoiceSearchLayout.bEI()[k]);
          GMTrace.o(1176015732736L, 8762);
          return true;
          if (VoiceSearchLayout.d(VoiceSearchLayout.this) > VoiceSearchLayout.e(VoiceSearchLayout.this)) {
            VoiceSearchLayout.i(VoiceSearchLayout.this);
          } else {
            VoiceSearchLayout.j(VoiceSearchLayout.this);
          }
        }
      }
    }, true);
    init(paramContext);
    GMTrace.o(924357492736L, 6887);
  }
  
  private void init(Context paramContext)
  {
    GMTrace.i(924760145920L, 6890);
    this.llc = inflate(paramContext, R.i.cNr, this);
    this.sJR = ((Button)this.llc.findViewById(R.h.cNt));
    this.sJV = this.llc.findViewById(R.h.cNq);
    jp(false);
    reset();
    GMTrace.o(924760145920L, 6890);
  }
  
  private void jp(boolean paramBoolean)
  {
    GMTrace.i(925431234560L, 6895);
    if (paramBoolean)
    {
      this.sJR.setBackgroundResource(R.g.blb);
      this.sJW = ((AnimationDrawable)this.sJR.getBackground());
      if (this.sJW != null)
      {
        this.sJW.start();
        GMTrace.o(925431234560L, 6895);
      }
    }
    else
    {
      this.sJR.setBackgroundResource(R.g.ble);
    }
    GMTrace.o(925431234560L, 6895);
  }
  
  private static void qQ()
  {
    GMTrace.i(925968105472L, 6899);
    v.d("MicroMsg.VoiceSearchLayout", "resumeMusic");
    ap.yZ().qQ();
    GMTrace.o(925968105472L, 6899);
  }
  
  public final void a(boolean paramBoolean, i parami)
  {
    GMTrace.i(925833887744L, 6898);
    if (paramBoolean)
    {
      v.d("MicroMsg.VoiceSearchLayout", "pauseMusic");
      ap.yZ().qP();
      parami = new com.tencent.mm.compatible.b.i();
      if (!paramBoolean) {
        break label146;
      }
    }
    for (;;)
    {
      try
      {
        parami.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.k.dyr));
        parami.setAudioStreamType(5);
        parami.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
          public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            GMTrace.i(1164473008128L, 8676);
            paramAnonymousMediaPlayer.release();
            GMTrace.o(1164473008128L, 8676);
          }
        });
        parami.setOnErrorListener(new MediaPlayer.OnErrorListener()
        {
          public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            GMTrace.i(1198832746496L, 8932);
            GMTrace.o(1198832746496L, 8932);
            return false;
          }
        });
        parami.prepare();
        parami.setLooping(false);
        parami.start();
        GMTrace.o(925833887744L, 6898);
        return;
      }
      catch (Exception parami)
      {
        label146:
        v.printErrStackTrace("MicroMsg.VoiceSearchLayout", parami, "", new Object[0]);
        GMTrace.o(925833887744L, 6898);
      }
      qQ();
      break;
      parami.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/" + R.k.dxT));
    }
  }
  
  public final void bEF()
  {
    GMTrace.i(925028581376L, 6892);
    v.d("MicroMsg.VoiceSearchLayout", "checkStop " + this.fOM);
    if (this.fOM)
    {
      bEt();
      this.fOM = false;
    }
    GMTrace.o(925028581376L, 6892);
  }
  
  public final void bEt()
  {
    GMTrace.i(925162799104L, 6893);
    v.d("MicroMsg.VoiceSearchLayout", "doCancel " + this.fOM);
    if (this.fOM)
    {
      this.fOM = false;
      if (this.sJQ != null) {
        this.sJQ.bEK();
      }
    }
    reset();
    if (getVisibility() == 0)
    {
      setVisibility(8);
      if (this.sJU != null) {
        this.sJU.jq(false);
      }
    }
    qQ();
    if (this.sJX != null) {
      this.sJX.cancel();
    }
    if (this.jXi != null) {
      this.jXi.KI();
    }
    GMTrace.o(925162799104L, 6893);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    GMTrace.i(924894363648L, 6891);
    if (!this.sJS) {
      bEF();
    }
    GMTrace.o(924894363648L, 6891);
    return true;
  }
  
  public final void reset()
  {
    GMTrace.i(925297016832L, 6894);
    jp(false);
    this.fOM = false;
    this.sJS = false;
    this.sJR.setBackgroundResource(R.g.ble);
    this.sJV.setBackgroundDrawable(getResources().getDrawable(R.g.bld));
    GMTrace.o(925297016832L, 6894);
  }
  
  public void setVisibility(int paramInt)
  {
    GMTrace.i(925565452288L, 6896);
    Object localObject;
    if ((super.getVisibility() != paramInt) && (!this.sJY))
    {
      if (paramInt != 8) {
        break label86;
      }
      localObject = AnimationUtils.loadAnimation(getContext(), R.a.aQY);
      startAnimation((Animation)localObject);
      super.setVisibility(paramInt);
      if (this.sJU != null)
      {
        localObject = this.sJU;
        if (paramInt != 0) {
          break label100;
        }
      }
    }
    label86:
    label100:
    for (boolean bool = true;; bool = false)
    {
      ((b)localObject).jq(bool);
      GMTrace.o(925565452288L, 6896);
      return;
      localObject = AnimationUtils.loadAnimation(getContext(), R.a.aQX);
      break;
    }
  }
  
  public final void xj(int paramInt)
  {
    GMTrace.i(925699670016L, 6897);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.sJV.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    this.sJV.setLayoutParams(localLayoutParams);
    GMTrace.o(925699670016L, 6897);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String[] paramArrayOfString, long paramLong);
    
    public abstract void bEJ();
    
    public abstract void bEK();
  }
  
  public static abstract interface b
  {
    public abstract void jq(boolean paramBoolean);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/VoiceSearchLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */