package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;

public class ThreeDotsLoadingView
  extends FrameLayout
{
  private boolean AJ;
  private ViewGroup wvQ;
  private ImageView wvR;
  private ImageView wvS;
  private ImageView wvT;
  
  public ThreeDotsLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(16428249907200L, 122400);
    this.AJ = false;
    init(paramContext);
    GMTrace.o(16428249907200L, 122400);
  }
  
  public ThreeDotsLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(16428384124928L, 122401);
    this.AJ = false;
    init(paramContext);
    GMTrace.o(16428384124928L, 122401);
  }
  
  private static AnimationDrawable b(float[] paramArrayOfFloat)
  {
    GMTrace.i(16429055213568L, 122406);
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.setOneShot(false);
    localAnimationDrawable.addFrame(f(-16777216, paramArrayOfFloat[0]), 0);
    localAnimationDrawable.addFrame(f(-16777216, paramArrayOfFloat[1]), 300);
    localAnimationDrawable.addFrame(f(-16777216, paramArrayOfFloat[2]), 300);
    localAnimationDrawable.addFrame(f(-16777216, paramArrayOfFloat[3]), 300);
    GMTrace.o(16429055213568L, 122406);
    return localAnimationDrawable;
  }
  
  private static Drawable f(int paramInt, float paramFloat)
  {
    GMTrace.i(16429189431296L, 122407);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new OvalShape());
    localShapeDrawable.setIntrinsicHeight(32);
    localShapeDrawable.setIntrinsicWidth(32);
    localShapeDrawable.getPaint().setColor(-16777216);
    localShapeDrawable.getPaint().setAlpha((int)(255.0F * paramFloat));
    GMTrace.o(16429189431296L, 122407);
    return localShapeDrawable;
  }
  
  private void init(Context paramContext)
  {
    GMTrace.i(16428518342656L, 122402);
    this.wvQ = ((ViewGroup)LayoutInflater.from(paramContext).inflate(a.h.hdM, this, true));
    this.wvR = ((ImageView)this.wvQ.findViewById(a.g.hcm));
    this.wvS = ((ImageView)this.wvQ.findViewById(a.g.hcn));
    this.wvT = ((ImageView)this.wvQ.findViewById(a.g.hco));
    this.wvR.setImageDrawable(b(new float[] { 0.1F, 0.4F, 0.2F, 0.1F }));
    this.wvS.setImageDrawable(b(new float[] { 0.1F, 0.1F, 0.4F, 0.2F }));
    this.wvT.setImageDrawable(b(new float[] { 0.1F, 0.2F, 0.1F, 0.4F }));
    GMTrace.o(16428518342656L, 122402);
  }
  
  public final void VW()
  {
    GMTrace.i(16428920995840L, 122405);
    this.AJ = false;
    ((AnimationDrawable)this.wvR.getDrawable()).stop();
    ((AnimationDrawable)this.wvS.getDrawable()).stop();
    ((AnimationDrawable)this.wvT.getDrawable()).stop();
    GMTrace.o(16428920995840L, 122405);
  }
  
  public final void caG()
  {
    GMTrace.i(16428786778112L, 122404);
    if (this.AJ)
    {
      GMTrace.o(16428786778112L, 122404);
      return;
    }
    this.AJ = true;
    ((AnimationDrawable)this.wvR.getDrawable()).start();
    ((AnimationDrawable)this.wvS.getDrawable()).start();
    ((AnimationDrawable)this.wvT.getDrawable()).start();
    GMTrace.o(16428786778112L, 122404);
  }
  
  public void setVisibility(int paramInt)
  {
    GMTrace.i(16428652560384L, 122403);
    if ((8 == paramInt) || (4 == paramInt)) {
      VW();
    }
    super.setVisibility(paramInt);
    GMTrace.o(16428652560384L, 122403);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/ThreeDotsLoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */