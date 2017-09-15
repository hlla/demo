package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.aw.f;
import com.tencent.mm.aw.f.a;
import com.tencent.mm.aw.f.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ai.a;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Set;

public abstract class VoiceInputLayout
  extends LinearLayout
{
  private final ai jXi;
  private ad kgF;
  protected int sIV;
  public b sJq;
  private f sJr;
  protected boolean sJs;
  private int sJt;
  private int sJu;
  protected a sJv;
  private ad sJw;
  
  public VoiceInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1176418385920L, 8765);
    this.sJq = null;
    this.sJs = false;
    this.sIV = 1;
    this.sJt = 3000;
    this.sJu = 10000;
    this.kgF = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(1165412532224L, 8683);
        if (paramAnonymousMessage.what != 0)
        {
          if (paramAnonymousMessage.what == 1) {
            v.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.sIV) });
          }
        }
        else
        {
          v.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.sIV) });
          if (VoiceInputLayout.this.sIV == 3) {
            break label103;
          }
          GMTrace.o(1165412532224L, 8683);
          return;
        }
        GMTrace.o(1165412532224L, 8683);
        return;
        label103:
        VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
        VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(1);
        if (VoiceInputLayout.b(VoiceInputLayout.this) != null) {
          VoiceInputLayout.b(VoiceInputLayout.this).bx(true);
        }
        VoiceInputLayout.this.reset(true);
        GMTrace.o(1165412532224L, 8683);
      }
    };
    this.sJw = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(1166352056320L, 8690);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          GMTrace.o(1166352056320L, 8690);
          return;
          VoiceInputLayout.this.bEu();
          GMTrace.o(1166352056320L, 8690);
          return;
          paramAnonymousMessage = paramAnonymousMessage.getData();
          VoiceInputLayout.this.S(paramAnonymousMessage.getInt("localCode"), paramAnonymousMessage.getInt("errType"), paramAnonymousMessage.getInt("errCode"));
        }
      }
    };
    this.jXi = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(1171049676800L, 8725);
        if (VoiceInputLayout.b(VoiceInputLayout.this) == null)
        {
          GMTrace.o(1171049676800L, 8725);
          return true;
        }
        f localf = VoiceInputLayout.b(VoiceInputLayout.this);
        int i = localf.icA;
        localf.icA = 0;
        if (i > f.fBt) {
          f.fBt = i;
        }
        i = i * 100 / f.fBt;
        if (VoiceInputLayout.this.sIV == 2) {
          VoiceInputLayout.this.xh(i);
        }
        GMTrace.o(1171049676800L, 8725);
        return true;
      }
    }, true);
    GMTrace.o(1176418385920L, 8765);
  }
  
  @TargetApi(11)
  public VoiceInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1176284168192L, 8764);
    this.sJq = null;
    this.sJs = false;
    this.sIV = 1;
    this.sJt = 3000;
    this.sJu = 10000;
    this.kgF = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(1165412532224L, 8683);
        if (paramAnonymousMessage.what != 0)
        {
          if (paramAnonymousMessage.what == 1) {
            v.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.sIV) });
          }
        }
        else
        {
          v.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.sIV) });
          if (VoiceInputLayout.this.sIV == 3) {
            break label103;
          }
          GMTrace.o(1165412532224L, 8683);
          return;
        }
        GMTrace.o(1165412532224L, 8683);
        return;
        label103:
        VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
        VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(1);
        if (VoiceInputLayout.b(VoiceInputLayout.this) != null) {
          VoiceInputLayout.b(VoiceInputLayout.this).bx(true);
        }
        VoiceInputLayout.this.reset(true);
        GMTrace.o(1165412532224L, 8683);
      }
    };
    this.sJw = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(1166352056320L, 8690);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          GMTrace.o(1166352056320L, 8690);
          return;
          VoiceInputLayout.this.bEu();
          GMTrace.o(1166352056320L, 8690);
          return;
          paramAnonymousMessage = paramAnonymousMessage.getData();
          VoiceInputLayout.this.S(paramAnonymousMessage.getInt("localCode"), paramAnonymousMessage.getInt("errType"), paramAnonymousMessage.getInt("errCode"));
        }
      }
    };
    this.jXi = new ai(new ai.a()
    {
      public final boolean oQ()
      {
        GMTrace.i(1171049676800L, 8725);
        if (VoiceInputLayout.b(VoiceInputLayout.this) == null)
        {
          GMTrace.o(1171049676800L, 8725);
          return true;
        }
        f localf = VoiceInputLayout.b(VoiceInputLayout.this);
        int i = localf.icA;
        localf.icA = 0;
        if (i > f.fBt) {
          f.fBt = i;
        }
        i = i * 100 / f.fBt;
        if (VoiceInputLayout.this.sIV == 2) {
          VoiceInputLayout.this.xh(i);
        }
        GMTrace.o(1171049676800L, 8725);
        return true;
      }
    }, true);
    GMTrace.o(1176284168192L, 8764);
  }
  
  public final void S(int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(1177760563200L, 8775);
    v.d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    this.sIV = 1;
    onReset();
    if (this.sJq != null) {
      this.sJq.T(paramInt1, paramInt2, paramInt3);
    }
    GMTrace.o(1177760563200L, 8775);
  }
  
  public final void a(a parama)
  {
    GMTrace.i(1176149950464L, 8763);
    this.sJv = parama;
    GMTrace.o(1176149950464L, 8763);
  }
  
  public final void bEs()
  {
    GMTrace.i(1177089474560L, 8770);
    if ((com.tencent.mm.n.a.aJ(getContext())) || (com.tencent.mm.n.a.aH(getContext())))
    {
      v.d("MicroMsg.VoiceInputLayout", "voip is running, cann't record voice");
      onReset();
      GMTrace.o(1177089474560L, 8770);
      return;
    }
    boolean bool = com.tencent.mm.pluginsdk.i.a.aS(getContext(), "android.permission.RECORD_AUDIO");
    v.d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", new Object[] { Boolean.valueOf(bool) });
    if (bool)
    {
      v.d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", new Object[] { Integer.valueOf(this.sIV) });
      if (this.sIV == 1)
      {
        this.sIV = 2;
        if (this.sJq != null) {
          this.sJq.bEy();
        }
        this.jXi.v(50L, 50L);
        jn(true);
        this.sJr = new f(new f.b()
        {
          public final void LQ()
          {
            GMTrace.i(1201517101056L, 8952);
            v.d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", new Object[] { Integer.valueOf(VoiceInputLayout.this.sIV) });
            if (VoiceInputLayout.c(VoiceInputLayout.this) != null) {
              VoiceInputLayout.c(VoiceInputLayout.this).KI();
            }
            VoiceInputLayout.d(VoiceInputLayout.this).sendEmptyMessage(0);
            GMTrace.o(1201517101056L, 8952);
          }
          
          public final void LV()
          {
            GMTrace.i(1201651318784L, 8953);
            v.d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(1);
            VoiceInputLayout.e(VoiceInputLayout.this).bEC();
            VoiceInputLayout.this.reset(false);
            GMTrace.o(1201651318784L, 8953);
          }
          
          public final void a(String[] paramAnonymousArrayOfString, Set<String> paramAnonymousSet)
          {
            GMTrace.i(1201785536512L, 8954);
            VoiceInputLayout.e(VoiceInputLayout.this).b(paramAnonymousArrayOfString, paramAnonymousSet);
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
            VoiceInputLayout.a(VoiceInputLayout.this).sendEmptyMessageDelayed(0, VoiceInputLayout.f(VoiceInputLayout.this));
            GMTrace.o(1201785536512L, 8954);
          }
          
          public final void u(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            GMTrace.i(1201919754240L, 8955);
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(0);
            VoiceInputLayout.a(VoiceInputLayout.this).removeMessages(1);
            Message localMessage = new Message();
            Bundle localBundle = new Bundle();
            localBundle.putInt("localCode", paramAnonymousInt1);
            localBundle.putInt("errType", paramAnonymousInt2);
            localBundle.putInt("errCode", paramAnonymousInt3);
            localMessage.setData(localBundle);
            localMessage.what = 1;
            VoiceInputLayout.d(VoiceInputLayout.this).sendMessage(localMessage);
            GMTrace.o(1201919754240L, 8955);
          }
        });
        f localf = this.sJr;
        v.i("MicroMsg.SceneVoiceInputAddr", "start record");
        e.b(new f.a(localf), "SceneVoiceInputAddr_record", 10);
      }
      GMTrace.o(1177089474560L, 8770);
      return;
    }
    if ((getContext() instanceof Activity)) {
      com.tencent.mm.pluginsdk.i.a.d((Activity)getContext(), "android.permission.RECORD_AUDIO");
    }
    GMTrace.o(1177089474560L, 8770);
  }
  
  public final void bEt()
  {
    GMTrace.i(1177223692288L, 8771);
    v.d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", new Object[] { Integer.valueOf(this.sIV) });
    if (this.sIV == 1)
    {
      GMTrace.o(1177223692288L, 8771);
      return;
    }
    this.sIV = 1;
    if (this.sJq != null) {
      this.sJq.bEA();
    }
    if (this.sJr != null) {
      this.sJr.bx(true);
    }
    onReset();
    GMTrace.o(1177223692288L, 8771);
  }
  
  public final void bEu()
  {
    GMTrace.i(1177492127744L, 8773);
    v.d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", new Object[] { Integer.valueOf(this.sIV) });
    if (this.sIV != 2)
    {
      GMTrace.o(1177492127744L, 8773);
      return;
    }
    this.sIV = 3;
    this.kgF.removeMessages(0);
    this.kgF.sendEmptyMessageDelayed(0, this.sJt);
    this.kgF.sendEmptyMessageDelayed(1, this.sJu);
    jo(false);
    GMTrace.o(1177492127744L, 8773);
  }
  
  public final void bEv()
  {
    GMTrace.i(1177626345472L, 8774);
    S(12, -1, -1);
    GMTrace.o(1177626345472L, 8774);
  }
  
  public final int bEw()
  {
    GMTrace.i(1178028998656L, 8777);
    int i = this.sIV;
    GMTrace.o(1178028998656L, 8777);
    return i;
  }
  
  public final void be()
  {
    GMTrace.i(1177357910016L, 8772);
    v.d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", new Object[] { Integer.valueOf(this.sIV) });
    if ((this.sIV == 1) || (this.sIV != 2))
    {
      GMTrace.o(1177357910016L, 8772);
      return;
    }
    this.sIV = 3;
    if (this.sJq != null) {
      this.sJq.bEz();
    }
    if (this.jXi != null) {
      this.jXi.KI();
    }
    this.kgF.removeMessages(0);
    this.kgF.sendEmptyMessageDelayed(0, this.sJt);
    this.kgF.sendEmptyMessageDelayed(1, this.sJu);
    jo(true);
    if (this.sJr != null) {
      this.sJr.ap(true);
    }
    GMTrace.o(1177357910016L, 8772);
  }
  
  public final void jm(boolean paramBoolean)
  {
    GMTrace.i(16684471549952L, 124309);
    this.sJs = paramBoolean;
    GMTrace.o(16684471549952L, 124309);
  }
  
  protected abstract void jn(boolean paramBoolean);
  
  protected abstract void jo(boolean paramBoolean);
  
  protected abstract void onReset();
  
  protected final void reset(boolean paramBoolean)
  {
    GMTrace.i(1177894780928L, 8776);
    v.d("MicroMsg.VoiceInputLayout", "reset currentState %s", new Object[] { Integer.valueOf(this.sIV) });
    if (this.sIV == 1)
    {
      GMTrace.o(1177894780928L, 8776);
      return;
    }
    this.sIV = 1;
    onReset();
    if ((paramBoolean) && (this.sJq != null)) {
      this.sJq.bEB();
    }
    GMTrace.o(1177894780928L, 8776);
  }
  
  protected abstract void xh(int paramInt);
  
  public static abstract interface a
  {
    public abstract void bEx();
  }
  
  public static abstract interface b
  {
    public abstract void T(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void b(String[] paramArrayOfString, Set<String> paramSet);
    
    public abstract void bEA();
    
    public abstract void bEB();
    
    public abstract void bEC();
    
    public abstract void bEy();
    
    public abstract void bEz();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/VoiceInputLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */