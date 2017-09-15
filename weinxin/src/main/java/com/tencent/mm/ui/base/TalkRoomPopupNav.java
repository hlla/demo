package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a;

public class TalkRoomPopupNav
  extends LinearLayout
{
  public View lLY;
  public LinearLayout uTz;
  public a vnT;
  public LinearLayout vnU;
  private LinearLayout vnV;
  private ImageView vnW;
  public ImageView vnX;
  public ScaleAnimation vnY;
  public Animation vnZ;
  public int voa;
  public int vob;
  private ScaleAnimation voc;
  private Animation vod;
  public AlphaAnimation voe;
  public AlphaAnimation vof;
  
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(3292360867840L, 24530);
    this.voa = 0;
    this.vob = 0;
    KD();
    GMTrace.o(3292360867840L, 24530);
  }
  
  @TargetApi(11)
  public TalkRoomPopupNav(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(3292226650112L, 24529);
    this.voa = 0;
    this.vob = 0;
    KD();
    GMTrace.o(3292226650112L, 24529);
  }
  
  private void KD()
  {
    GMTrace.i(3293031956480L, 24535);
    inflate(getContext(), R.i.cHb, this);
    this.uTz = ((LinearLayout)findViewById(R.h.cmm));
    this.vnU = ((LinearLayout)findViewById(R.h.bJm));
    this.vnV = ((LinearLayout)findViewById(R.h.bJh));
    this.lLY = findViewById(R.h.cmi);
    this.vnW = ((ImageView)findViewById(R.h.cHc));
    this.vnX = ((ImageView)findViewById(R.h.cHd));
    this.vnX.setVisibility(8);
    this.uTz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(3200555941888L, 23846);
        if (TalkRoomPopupNav.a(TalkRoomPopupNav.this) != null) {
          TalkRoomPopupNav.a(TalkRoomPopupNav.this).bSJ();
        }
        GMTrace.o(3200555941888L, 23846);
      }
    });
    ((Button)findViewById(R.h.buR)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(3189684305920L, 23765);
        TalkRoomPopupNav.b(TalkRoomPopupNav.this);
        GMTrace.o(3189684305920L, 23765);
      }
    });
    ((Button)findViewById(R.h.buS)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        GMTrace.i(3365106876416L, 25072);
        TalkRoomPopupNav.b(TalkRoomPopupNav.this);
        if (TalkRoomPopupNav.a(TalkRoomPopupNav.this) != null) {
          TalkRoomPopupNav.a(TalkRoomPopupNav.this).bSK();
        }
        GMTrace.o(3365106876416L, 25072);
      }
    });
    this.voa = this.lLY.getLayoutParams().height;
    this.vob = this.vnU.getLayoutParams().height;
    GMTrace.o(3293031956480L, 24535);
  }
  
  public final void Ak(int paramInt)
  {
    GMTrace.i(3292629303296L, 24532);
    if (this.lLY != null) {
      this.lLY.setBackgroundResource(paramInt);
    }
    GMTrace.o(3292629303296L, 24532);
  }
  
  public final void Al(int paramInt)
  {
    GMTrace.i(3292763521024L, 24533);
    if (this.vnW != null) {
      this.vnW.setImageResource(paramInt);
    }
    GMTrace.o(3292763521024L, 24533);
  }
  
  public final void Am(int paramInt)
  {
    GMTrace.i(3292897738752L, 24534);
    if (paramInt < 0)
    {
      if (this.vnX != null) {
        this.vnX.setVisibility(8);
      }
      GMTrace.o(3292897738752L, 24534);
      return;
    }
    if (this.vnX != null)
    {
      this.vnX.setImageResource(paramInt);
      this.vnX.setVisibility(0);
    }
    GMTrace.o(3292897738752L, 24534);
  }
  
  public final void Tb(String paramString)
  {
    GMTrace.i(3292495085568L, 24531);
    ((TextView)findViewById(R.h.cKc)).setText(paramString);
    GMTrace.o(3292495085568L, 24531);
  }
  
  public final void stop()
  {
    GMTrace.i(3293166174208L, 24536);
    if ((this.voe != null) && (this.vof != null))
    {
      BackwardSupportUtil.a.c(this.vnX, this.voe);
      BackwardSupportUtil.a.c(this.vnX, this.vof);
      this.vnX.clearAnimation();
      this.voe = null;
      this.vof = null;
    }
    GMTrace.o(3293166174208L, 24536);
  }
  
  public static abstract interface a
  {
    public abstract void bSJ();
    
    public abstract void bSK();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/TalkRoomPopupNav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */