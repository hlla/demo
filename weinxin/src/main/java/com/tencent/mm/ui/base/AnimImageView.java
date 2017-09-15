package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.bg.a;

public class AnimImageView
  extends TextView
{
  private boolean aJi;
  private Context context;
  private AlphaAnimation oOg;
  private AnimationDrawable oOh;
  private int type;
  public boolean veA;
  private AnimationDrawable veB;
  
  public AnimImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(3289810731008L, 24511);
    this.aJi = false;
    this.veA = false;
    this.type = 1;
    this.context = paramContext;
    aWP();
    GMTrace.o(3289810731008L, 24511);
  }
  
  public AnimImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(3289944948736L, 24512);
    this.aJi = false;
    this.veA = false;
    this.type = 1;
    this.context = paramContext;
    aWP();
    GMTrace.o(3289944948736L, 24512);
  }
  
  private void aWP()
  {
    GMTrace.i(3290079166464L, 24513);
    this.oOg = new AlphaAnimation(0.1F, 1.0F);
    this.oOg.setDuration(1000L);
    this.oOg.setRepeatCount(-1);
    this.oOg.setRepeatMode(2);
    this.oOh = new AnimationDrawable();
    Drawable localDrawable = getResources().getDrawable(R.k.dvq);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.oOh.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(R.k.dvr);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.oOh.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(R.k.dvs);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.oOh.addFrame(localDrawable, 300);
    this.oOh.setOneShot(false);
    this.oOh.setVisible(true, true);
    this.veB = new AnimationDrawable();
    localDrawable = getResources().getDrawable(R.k.dvA);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.veB.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(R.k.dvB);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.veB.addFrame(localDrawable, 300);
    localDrawable = getResources().getDrawable(R.k.dvC);
    localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    this.veB.addFrame(localDrawable, 300);
    this.veB.setOneShot(false);
    this.veB.setVisible(true, true);
    GMTrace.o(3290079166464L, 24513);
  }
  
  public final void aWQ()
  {
    GMTrace.i(3289676513280L, 24510);
    if ((this.oOg != null) && (this.oOg.isInitialized())) {
      setAnimation(null);
    }
    if ((this.type == 1) || (this.type == 2))
    {
      this.aJi = false;
      setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.oOh.stop();
      this.veB.stop();
    }
    GMTrace.o(3289676513280L, 24510);
  }
  
  public final void bRr()
  {
    GMTrace.i(3289542295552L, 24509);
    switch (this.type)
    {
    default: 
      GMTrace.o(3289542295552L, 24509);
      return;
    case 2: 
      if (this.veA) {
        setBackgroundResource(R.e.aTc);
      }
    case 1: 
      while (!this.aJi)
      {
        this.aJi = true;
        if (!this.veA) {
          break label128;
        }
        setCompoundDrawablesWithIntrinsicBounds(this.oOh, null, null, null);
        this.oOh.stop();
        this.oOh.start();
        GMTrace.o(3289542295552L, 24509);
        return;
        setBackgroundResource(R.e.aTd);
      }
      label128:
      setCompoundDrawablesWithIntrinsicBounds(null, null, this.veB, null);
      this.veB.stop();
      this.veB.start();
      GMTrace.o(3289542295552L, 24509);
      return;
    }
    if (this.veA) {
      setBackgroundDrawable(a.a(this.context, R.g.bdS));
    }
    for (;;)
    {
      setAnimation(this.oOg);
      this.oOg.startNow();
      break;
      setBackgroundDrawable(a.a(this.context, R.g.bei));
    }
  }
  
  public int getBaseline()
  {
    GMTrace.i(3290481819648L, 24516);
    try
    {
      int i = super.getBaseline();
      GMTrace.o(3290481819648L, 24516);
      return i;
    }
    catch (Throwable localThrowable)
    {
      GMTrace.o(3290481819648L, 24516);
    }
    return -1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    GMTrace.i(3290347601920L, 24515);
    try
    {
      super.onDraw(paramCanvas);
      GMTrace.o(3290347601920L, 24515);
      return;
    }
    catch (Throwable paramCanvas)
    {
      GMTrace.o(3290347601920L, 24515);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    GMTrace.i(3290213384192L, 24514);
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      GMTrace.o(3290213384192L, 24514);
      return;
    }
    catch (Throwable localThrowable)
    {
      GMTrace.o(3290213384192L, 24514);
    }
  }
  
  public boolean onPreDraw()
  {
    GMTrace.i(3290616037376L, 24517);
    try
    {
      boolean bool = super.onPreDraw();
      GMTrace.o(3290616037376L, 24517);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      GMTrace.o(3290616037376L, 24517);
    }
    return true;
  }
  
  public final void setType(int paramInt)
  {
    GMTrace.i(14474710876160L, 107845);
    this.type = paramInt;
    if (this.veA)
    {
      if (paramInt == 2)
      {
        setBackgroundResource(R.e.aTc);
        GMTrace.o(14474710876160L, 107845);
        return;
      }
      setBackgroundDrawable(a.a(this.context, R.g.bdS));
      GMTrace.o(14474710876160L, 107845);
      return;
    }
    if (paramInt == 2)
    {
      setBackgroundResource(R.e.aTd);
      GMTrace.o(14474710876160L, 107845);
      return;
    }
    setBackgroundDrawable(a.a(this.context, R.g.bei));
    GMTrace.o(14474710876160L, 107845);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/AnimImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */