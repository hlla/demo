package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.y.a.a;
import com.tencent.mm.plugin.y.a.b;
import com.tencent.mm.plugin.y.a.c;
import com.tencent.mm.sdk.platformtools.v;

public class AdVideoPlayerLoadingBar
  extends RelativeLayout
  implements a
{
  public View ipa;
  public boolean jFd;
  public int kC;
  public b ptk;
  public ImageView ptl;
  public ImageView ptm;
  public ImageView ptn;
  public ImageView pto;
  public TextView ptp;
  public TextView ptq;
  public int ptr;
  private int pts;
  private int ptt;
  public float ptu;
  private int ptv;
  private int ptw;
  private int ptx;
  private int pty;
  
  public AdVideoPlayerLoadingBar(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(9250554249216L, 68922);
    this.ptk = null;
    this.ipa = null;
    this.ptm = null;
    this.ptn = null;
    this.pto = null;
    this.ptr = 0;
    this.kC = 0;
    this.pts = 0;
    this.ptt = 0;
    this.jFd = false;
    this.ptu = 0.0F;
    this.ptv = -1;
    this.ptw = -1;
    this.ptx = -1;
    this.pty = -1;
    init();
    GMTrace.o(9250554249216L, 68922);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(9250688466944L, 68923);
    this.ptk = null;
    this.ipa = null;
    this.ptm = null;
    this.ptn = null;
    this.pto = null;
    this.ptr = 0;
    this.kC = 0;
    this.pts = 0;
    this.ptt = 0;
    this.jFd = false;
    this.ptu = 0.0F;
    this.ptv = -1;
    this.ptw = -1;
    this.ptx = -1;
    this.pty = -1;
    init();
    GMTrace.o(9250688466944L, 68923);
  }
  
  public AdVideoPlayerLoadingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(9250822684672L, 68924);
    this.ptk = null;
    this.ipa = null;
    this.ptm = null;
    this.ptn = null;
    this.pto = null;
    this.ptr = 0;
    this.kC = 0;
    this.pts = 0;
    this.ptt = 0;
    this.jFd = false;
    this.ptu = 0.0F;
    this.ptv = -1;
    this.ptw = -1;
    this.ptx = -1;
    this.pty = -1;
    init();
    GMTrace.o(9250822684672L, 68924);
  }
  
  public static String hO(int paramInt)
  {
    GMTrace.i(9252701732864L, 68938);
    if (paramInt < 10)
    {
      String str = "0" + paramInt;
      GMTrace.o(9252701732864L, 68938);
      return str;
    }
    GMTrace.o(9252701732864L, 68938);
    return String.valueOf(paramInt);
  }
  
  public final void a(b paramb)
  {
    GMTrace.i(9251091120128L, 68926);
    this.ptk = paramb;
    GMTrace.o(9251091120128L, 68926);
  }
  
  public void bX(boolean paramBoolean)
  {
    GMTrace.i(9251627991040L, 68930);
    if (paramBoolean)
    {
      this.pto.setImageResource(a.c.onn);
      GMTrace.o(9251627991040L, 68930);
      return;
    }
    this.pto.setImageResource(a.c.ono);
    GMTrace.o(9251627991040L, 68930);
  }
  
  protected final int bce()
  {
    GMTrace.i(9251762208768L, 68931);
    int i = ((FrameLayout.LayoutParams)this.ptm.getLayoutParams()).leftMargin;
    int j = this.ptn.getPaddingLeft();
    i = Math.max(0, (int)((((FrameLayout.LayoutParams)this.ptn.getLayoutParams()).leftMargin - (i - j) + (bcj() - this.ptn.getPaddingLeft() - this.ptn.getPaddingRight()) / 2) * 1.0D / bch() * this.ptr));
    GMTrace.o(9251762208768L, 68931);
    return i;
  }
  
  public final int bcf()
  {
    GMTrace.i(9252030644224L, 68933);
    int i = this.ptr;
    GMTrace.o(9252030644224L, 68933);
    return i;
  }
  
  public final void bcg()
  {
    GMTrace.i(18915035971584L, 140928);
    this.ptq.setText(hO(this.ptr / 60) + ":" + hO(this.ptr % 60));
    bck();
    GMTrace.o(18915035971584L, 140928);
  }
  
  public final int bch()
  {
    GMTrace.i(9252299079680L, 68935);
    if (this.pts <= 0) {
      this.pts = this.ptm.getWidth();
    }
    int i = this.pts;
    GMTrace.o(9252299079680L, 68935);
    return i;
  }
  
  public final void bci()
  {
    GMTrace.i(9252433297408L, 68936);
    this.pts = 0;
    GMTrace.o(9252433297408L, 68936);
  }
  
  public int bcj()
  {
    GMTrace.i(18915170189312L, 140929);
    if (this.ptt <= 0) {
      this.ptt = this.ptn.getWidth();
    }
    int i = this.ptt;
    GMTrace.o(18915170189312L, 140929);
    return i;
  }
  
  public void bck()
  {
    GMTrace.i(9252567515136L, 68937);
    if (this.ptr == 0)
    {
      GMTrace.o(9252567515136L, 68937);
      return;
    }
    if (this.jFd)
    {
      GMTrace.o(9252567515136L, 68937);
      return;
    }
    if (this.ptn == null)
    {
      GMTrace.o(9252567515136L, 68937);
      return;
    }
    if (bch() == 0)
    {
      GMTrace.o(9252567515136L, 68937);
      return;
    }
    int i = (bcj() - this.ptn.getPaddingLeft() - this.ptn.getPaddingRight()) / 2;
    this.ptp.setText(hO(this.kC / 60) + ":" + hO(this.kC % 60));
    int j = ((FrameLayout.LayoutParams)this.ptm.getLayoutParams()).leftMargin;
    int k = this.ptn.getPaddingLeft();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ptn.getLayoutParams();
    localLayoutParams.leftMargin = (j - k + (int)(this.kC * 1.0D / this.ptr * bch()) - i);
    this.ptn.setLayoutParams(localLayoutParams);
    localLayoutParams = (FrameLayout.LayoutParams)this.ptl.getLayoutParams();
    localLayoutParams.width = ((int)(this.kC * 1.0D / this.ptr * bch()));
    this.ptl.setLayoutParams(localLayoutParams);
    GMTrace.o(9252567515136L, 68937);
  }
  
  public final void d(View.OnClickListener paramOnClickListener)
  {
    GMTrace.i(9251493773312L, 68929);
    this.pto.setOnClickListener(paramOnClickListener);
    GMTrace.o(9251493773312L, 68929);
  }
  
  public int getLayoutId()
  {
    GMTrace.i(9250956902400L, 68925);
    int i = a.b.onm;
    GMTrace.o(9250956902400L, 68925);
    return i;
  }
  
  public void init()
  {
    GMTrace.i(9251225337856L, 68927);
    this.ipa = View.inflate(getContext(), getLayoutId(), this);
    this.ptl = ((ImageView)this.ipa.findViewById(a.a.onj));
    this.ptm = ((ImageView)this.ipa.findViewById(a.a.oni));
    this.ptn = ((ImageView)this.ipa.findViewById(a.a.onk));
    this.pto = ((ImageView)this.ipa.findViewById(a.a.crB));
    this.ptp = ((TextView)this.ipa.findViewById(a.a.ong));
    this.ptq = ((TextView)this.ipa.findViewById(a.a.onh));
    this.ptn.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(9250151596032L, 68919);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          v.i("MicroMsg.VideoPlayerLoadingBar", "ontouch down");
          AdVideoPlayerLoadingBar.this.jFd = false;
          AdVideoPlayerLoadingBar.this.ptu = paramAnonymousMotionEvent.getX();
          if (AdVideoPlayerLoadingBar.this.ptk != null) {
            AdVideoPlayerLoadingBar.this.ptk.Ue();
          }
        }
        for (;;)
        {
          GMTrace.o(9250151596032L, 68919);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f = paramAnonymousMotionEvent.getX();
            paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.ptn.getLayoutParams();
            i = paramAnonymousView.leftMargin;
            int j = (int)(f - AdVideoPlayerLoadingBar.this.ptu);
            paramAnonymousView.leftMargin = AdVideoPlayerLoadingBar.a(AdVideoPlayerLoadingBar.this, j + i);
            AdVideoPlayerLoadingBar.this.ptn.setLayoutParams(paramAnonymousView);
            i = AdVideoPlayerLoadingBar.this.bce();
            if (AdVideoPlayerLoadingBar.this.ptr > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.ptl.getLayoutParams();
              paramAnonymousView.width = ((int)(i * 1.0D / AdVideoPlayerLoadingBar.this.ptr * AdVideoPlayerLoadingBar.this.bch()));
              AdVideoPlayerLoadingBar.this.ptl.setLayoutParams(paramAnonymousView);
            }
            AdVideoPlayerLoadingBar.this.ptp.setText(AdVideoPlayerLoadingBar.hO(i / 60) + ":" + AdVideoPlayerLoadingBar.hO(i % 60));
            AdVideoPlayerLoadingBar.this.jFd = true;
          }
          else if (AdVideoPlayerLoadingBar.this.jFd)
          {
            i = AdVideoPlayerLoadingBar.this.bce();
            if (AdVideoPlayerLoadingBar.this.ptk != null)
            {
              v.i("MicroMsg.VideoPlayerLoadingBar", "current time : " + i);
              AdVideoPlayerLoadingBar.this.ptk.hP(i);
            }
            AdVideoPlayerLoadingBar.this.jFd = false;
          }
        }
      }
    });
    this.ptn.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(9254043910144L, 68948);
        int i = (AdVideoPlayerLoadingBar.this.bcj() - AdVideoPlayerLoadingBar.this.ptn.getPaddingLeft() - AdVideoPlayerLoadingBar.this.ptn.getPaddingRight()) / 2;
        int j = ((FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.ptm.getLayoutParams()).leftMargin;
        int k = AdVideoPlayerLoadingBar.this.ptn.getPaddingLeft();
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)AdVideoPlayerLoadingBar.this.ptn.getLayoutParams();
        localLayoutParams.leftMargin = (j - k - i);
        AdVideoPlayerLoadingBar.this.ptn.setLayoutParams(localLayoutParams);
        GMTrace.o(9254043910144L, 68948);
      }
    });
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ptl.getLayoutParams();
    localLayoutParams.width = 0;
    this.ptl.setLayoutParams(localLayoutParams);
    GMTrace.o(9251225337856L, 68927);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(9251359555584L, 68928);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.pts = 0;
    if ((paramInt1 != this.ptv) || (paramInt2 != this.ptw) || (paramInt3 != this.ptx) || (paramInt4 != this.pty)) {
      bck();
    }
    this.ptv = paramInt1;
    this.ptw = paramInt2;
    this.ptx = paramInt3;
    this.pty = paramInt4;
    GMTrace.o(9251359555584L, 68928);
  }
  
  public void sD(int paramInt)
  {
    GMTrace.i(9252164861952L, 68934);
    this.ptr = paramInt;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(18914767536128L, 140926);
          AdVideoPlayerLoadingBar.this.bcg();
          GMTrace.o(18914767536128L, 140926);
        }
      });
      GMTrace.o(9252164861952L, 68934);
      return;
    }
    bcg();
    GMTrace.o(9252164861952L, 68934);
  }
  
  public void seek(int paramInt)
  {
    GMTrace.i(9251896426496L, 68932);
    this.kC = paramInt;
    bck();
    GMTrace.o(9251896426496L, 68932);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/sight/decode/ui/AdVideoPlayerLoadingBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */