package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.y.a.a;
import com.tencent.mm.plugin.y.a.b;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.v;

public class VideoPlayerSeekBar
  extends AdVideoPlayerLoadingBar
  implements g
{
  public boolean fKu;
  private PInt sUY;
  private int sUZ;
  private int sVa;
  private int sVb;
  
  public VideoPlayerSeekBar(Context paramContext)
  {
    super(paramContext);
    GMTrace.i(1079647404032L, 8044);
    this.sUY = new PInt();
    this.fKu = false;
    this.sUZ = -1;
    this.sVa = -1;
    this.sVb = -1;
    GMTrace.o(1079647404032L, 8044);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1079781621760L, 8045);
    this.sUY = new PInt();
    this.fKu = false;
    this.sUZ = -1;
    this.sVa = -1;
    this.sVb = -1;
    GMTrace.o(1079781621760L, 8045);
  }
  
  public VideoPlayerSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1079915839488L, 8046);
    this.sUY = new PInt();
    this.fKu = false;
    this.sUZ = -1;
    this.sVa = -1;
    this.sVb = -1;
    GMTrace.o(1079915839488L, 8046);
  }
  
  private int bGw()
  {
    GMTrace.i(1080318492672L, 8049);
    if (this.sVa == -1) {
      this.sVa = this.ptn.getPaddingLeft();
    }
    int i = this.sVa;
    GMTrace.o(1080318492672L, 8049);
    return i;
  }
  
  private int bGx()
  {
    GMTrace.i(1080452710400L, 8050);
    if (this.sVb == -1) {
      this.sVb = this.ptn.getPaddingRight();
    }
    int i = this.sVb;
    GMTrace.o(1080452710400L, 8050);
    return i;
  }
  
  public void bX(boolean paramBoolean)
  {
    GMTrace.i(1081258016768L, 8056);
    this.fKu = paramBoolean;
    super.bX(paramBoolean);
    GMTrace.o(1081258016768L, 8056);
  }
  
  protected final int bcj()
  {
    GMTrace.i(1080184274944L, 8048);
    if (this.sUZ == -1) {
      this.sUZ = this.ptn.getWidth();
    }
    int i = this.sUZ;
    GMTrace.o(1080184274944L, 8048);
    return i;
  }
  
  public final void bck()
  {
    GMTrace.i(1080989581312L, 8054);
    if (this.ptr == 0)
    {
      GMTrace.o(1080989581312L, 8054);
      return;
    }
    if (this.jFd)
    {
      GMTrace.o(1080989581312L, 8054);
      return;
    }
    if (this.ptn == null)
    {
      GMTrace.o(1080989581312L, 8054);
      return;
    }
    if (bch() == 0)
    {
      GMTrace.o(1080989581312L, 8054);
      return;
    }
    this.ptp.setText(hO(this.kC / 60) + ":" + hO(this.kC % 60));
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ptn.getLayoutParams();
    int j = bch();
    int i = this.kC;
    if (i <= 0)
    {
      this.ptm.getLayoutParams();
      i = 0;
    }
    for (;;)
    {
      localLayoutParams.leftMargin = i;
      this.ptn.setLayoutParams(localLayoutParams);
      localLayoutParams = (FrameLayout.LayoutParams)this.ptl.getLayoutParams();
      double d = this.kC * 1.0D / this.ptr;
      localLayoutParams.width = ((int)(j * d));
      this.ptl.setLayoutParams(localLayoutParams);
      requestLayout();
      GMTrace.o(1080989581312L, 8054);
      return;
      if (i >= this.ptr) {
        i = j - (bcj() - bGw() - bGx()) / 2;
      } else {
        i = (int)(i * 1.0D / this.ptr * j);
      }
    }
  }
  
  public final void f(View.OnClickListener paramOnClickListener)
  {
    GMTrace.i(1081123799040L, 8055);
    if (this.pto != null) {
      this.pto.setOnClickListener(paramOnClickListener);
    }
    GMTrace.o(1081123799040L, 8055);
  }
  
  public int getLayoutId()
  {
    GMTrace.i(15305652830208L, 114036);
    int i = a.b.cLO;
    GMTrace.o(15305652830208L, 114036);
    return i;
  }
  
  public void init()
  {
    GMTrace.i(1080050057216L, 8047);
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
        GMTrace.i(1104209248256L, 8227);
        if (paramAnonymousMotionEvent.getAction() == 0)
        {
          v.i("MicroMsg.VideoPlayerSeekBar", "ontouch down");
          VideoPlayerSeekBar.a(VideoPlayerSeekBar.this);
          VideoPlayerSeekBar.a(VideoPlayerSeekBar.this, paramAnonymousMotionEvent.getX());
          if (VideoPlayerSeekBar.b(VideoPlayerSeekBar.this) != null) {
            VideoPlayerSeekBar.c(VideoPlayerSeekBar.this).Ue();
          }
        }
        for (;;)
        {
          GMTrace.o(1104209248256L, 8227);
          return true;
          int i;
          if (paramAnonymousMotionEvent.getAction() == 2)
          {
            float f = paramAnonymousMotionEvent.getX();
            paramAnonymousView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.d(VideoPlayerSeekBar.this).getLayoutParams();
            paramAnonymousMotionEvent = VideoPlayerSeekBar.this;
            i = paramAnonymousView.leftMargin;
            i = VideoPlayerSeekBar.a(paramAnonymousMotionEvent, (int)(f - VideoPlayerSeekBar.e(VideoPlayerSeekBar.this)) + i, VideoPlayerSeekBar.f(VideoPlayerSeekBar.this));
            paramAnonymousView.leftMargin = i;
            VideoPlayerSeekBar.g(VideoPlayerSeekBar.this).setLayoutParams(paramAnonymousView);
            int j = VideoPlayerSeekBar.f(VideoPlayerSeekBar.this).value;
            if (VideoPlayerSeekBar.h(VideoPlayerSeekBar.this) > 0)
            {
              paramAnonymousView = (FrameLayout.LayoutParams)VideoPlayerSeekBar.i(VideoPlayerSeekBar.this).getLayoutParams();
              paramAnonymousView.width = i;
              VideoPlayerSeekBar.j(VideoPlayerSeekBar.this).setLayoutParams(paramAnonymousView);
            }
            VideoPlayerSeekBar.k(VideoPlayerSeekBar.this).setText(VideoPlayerSeekBar.hO(j / 60) + ":" + VideoPlayerSeekBar.hO(j % 60));
            VideoPlayerSeekBar.l(VideoPlayerSeekBar.this);
          }
          else
          {
            i = VideoPlayerSeekBar.m(VideoPlayerSeekBar.this);
            if (VideoPlayerSeekBar.n(VideoPlayerSeekBar.this)) {
              i = VideoPlayerSeekBar.a(VideoPlayerSeekBar.this, VideoPlayerSeekBar.f(VideoPlayerSeekBar.this).value);
            }
            if (VideoPlayerSeekBar.o(VideoPlayerSeekBar.this) != null)
            {
              v.i("MicroMsg.VideoPlayerSeekBar", "current time : " + i);
              VideoPlayerSeekBar.p(VideoPlayerSeekBar.this).hP(i);
            }
            VideoPlayerSeekBar.q(VideoPlayerSeekBar.this);
          }
        }
      }
    });
    GMTrace.o(1080050057216L, 8047);
  }
  
  public final void jh(boolean paramBoolean)
  {
    GMTrace.i(16402614321152L, 122209);
    bX(paramBoolean);
    GMTrace.o(16402614321152L, 122209);
  }
  
  public final void sD(int paramInt)
  {
    GMTrace.i(1080855363584L, 8053);
    this.ptr = paramInt;
    this.kC = 0;
    this.ptq.setText(hO(this.ptr / 60) + ":" + hO(this.ptr % 60));
    bck();
    GMTrace.o(1080855363584L, 8053);
  }
  
  public final void seek(int paramInt)
  {
    GMTrace.i(1080721145856L, 8052);
    v.d("MicroMsg.VideoPlayerSeekBar", "seek position : " + paramInt);
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= this.ptr) {
      paramInt = this.ptr;
    }
    if (this.kC != paramInt)
    {
      this.kC = paramInt;
      bck();
    }
    GMTrace.o(1080721145856L, 8052);
  }
  
  public final void tp(int paramInt)
  {
    GMTrace.i(16402480103424L, 122208);
    seek(paramInt);
    GMTrace.o(16402480103424L, 122208);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/tools/VideoPlayerSeekBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */