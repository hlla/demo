package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bm.a.b;
import com.tencent.mm.bm.a.c;
import com.tencent.mm.bm.a.h;

public class MMSwitchBtn
  extends View
{
  private int maxHeight;
  private int maxWidth;
  private int mwa;
  private Paint nQD;
  private float qNE;
  private float qNF;
  private long wug;
  private int wuh;
  private int wui;
  private int wuj;
  private boolean wuk;
  private boolean wul;
  private int wum;
  private int wun;
  private int wuo;
  private float wup;
  private float wuq;
  private int wur;
  private int wus;
  private int wut;
  public boolean wuu;
  private RectF wuv;
  private RectF wuw;
  private b wux;
  public a wuy;
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(13067303780352L, 97359);
    this.wuk = false;
    this.wul = false;
    this.wun = 80;
    this.wuo = 300;
    this.wuu = false;
    this.nQD = new Paint(1);
    this.wuv = new RectF();
    this.wuw = new RectF();
    this.wux = new b();
    init();
    GMTrace.o(13067303780352L, 97359);
  }
  
  public MMSwitchBtn(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(13067169562624L, 97358);
    this.wuk = false;
    this.wul = false;
    this.wun = 80;
    this.wuo = 300;
    this.wuu = false;
    this.nQD = new Paint(1);
    this.wuv = new RectF();
    this.wuw = new RectF();
    this.wux = new b();
    init();
    GMTrace.o(13067169562624L, 97358);
  }
  
  private void bZM()
  {
    GMTrace.i(13068377522176L, 97367);
    if (this.wuw.left > this.wuh)
    {
      lQ(true);
      GMTrace.o(13068377522176L, 97367);
      return;
    }
    lQ(false);
    GMTrace.o(13068377522176L, 97367);
  }
  
  private void cat()
  {
    GMTrace.i(13067840651264L, 97363);
    if (this.wuj < this.maxHeight) {
      this.wuw.top = ((this.maxHeight - this.wuj) / 2 + this.wum);
    }
    for (this.wuw.bottom = (this.wuw.top + this.wuj - this.wum * 2); this.wuu; this.wuw.bottom = (this.maxHeight - this.wum))
    {
      this.wuw.left = (this.wui + this.wum);
      this.wuw.right = (this.maxWidth - this.wum);
      GMTrace.o(13067840651264L, 97363);
      return;
      this.wuw.top = this.wum;
    }
    this.wuw.left = this.wum;
    this.wuw.right = ((int)(this.wuq * 2.0F) + this.wum);
    GMTrace.o(13067840651264L, 97363);
  }
  
  private void cau()
  {
    GMTrace.i(13067974868992L, 97364);
    if (this.wuw.left < this.wum) {
      this.wuw.left = this.wum;
    }
    if (this.wuw.left > this.wui + this.wum) {
      this.wuw.left = (this.wui + this.wum);
    }
    this.wuw.right = (this.wuw.left + (int)(this.wuq * 2.0F));
    GMTrace.o(13067974868992L, 97364);
  }
  
  private void du(boolean paramBoolean)
  {
    GMTrace.i(13068243304448L, 97366);
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(paramBoolean);
    }
    GMTrace.o(13068243304448L, 97366);
  }
  
  private void init()
  {
    GMTrace.i(13067437998080L, 97360);
    this.wum = getResources().getDimensionPixelSize(a.c.aXU);
    this.wup = getResources().getDimensionPixelSize(a.c.wxN);
    this.wuq = getResources().getDimensionPixelSize(a.c.wxM);
    this.wur = getResources().getColor(a.b.white);
    this.wus = getResources().getColor(a.b.wxH);
    this.wut = getResources().getColor(a.b.wxI);
    this.mwa = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    GMTrace.o(13067437998080L, 97360);
  }
  
  private void lQ(boolean paramBoolean)
  {
    GMTrace.i(13068109086720L, 97365);
    this.wuk = true;
    this.wux.reset();
    if (paramBoolean) {
      this.wux.wuA = (this.wui - this.wuw.left + this.wum);
    }
    for (this.wux.direction = 1;; this.wux.direction = 0)
    {
      this.wux.wuz = this.wuw.left;
      this.wux.setDuration(this.wun * this.wux.wuA / this.wui);
      startAnimation(this.wux);
      GMTrace.o(13068109086720L, 97365);
      return;
      this.wux.wuA = (this.wuw.left);
    }
  }
  
  public final void lP(boolean paramBoolean)
  {
    GMTrace.i(13067572215808L, 97361);
    if (this.wuu != paramBoolean)
    {
      clearAnimation();
      this.wuu = paramBoolean;
      cat();
      this.wuk = false;
      invalidate();
    }
    if (paramBoolean) {}
    for (String str = getContext().getString(a.h.wyl);; str = getContext().getString(a.h.wym))
    {
      setContentDescription(str);
      GMTrace.o(13067572215808L, 97361);
      return;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    GMTrace.i(13068645957632L, 97369);
    this.nQD.setColor(this.wus);
    this.nQD.setAlpha(255);
    paramCanvas.drawRoundRect(this.wuv, this.wup, this.wup, this.nQD);
    this.nQD.setColor(this.wut);
    this.nQD.setAlpha(Math.min(255, (int)(255.0F * ((this.wuw.left - this.wum) / this.wui))));
    paramCanvas.drawRoundRect(this.wuv, this.wup, this.wup, this.nQD);
    this.nQD.setColor(this.wur);
    paramCanvas.drawRoundRect(this.wuw, this.wuq, this.wuq, this.nQD);
    GMTrace.o(13068645957632L, 97369);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(13067706433536L, 97362);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.maxWidth = (paramInt3 - paramInt1);
    this.maxHeight = (paramInt4 - paramInt2);
    this.wui = (this.maxWidth - (int)(this.wuq * 2.0F) - this.wum * 2);
    this.wuh = (this.wui / 2);
    this.wuj = getResources().getDimensionPixelSize(a.c.wxL);
    if (this.wuj < this.maxHeight) {
      this.wuv.top = ((this.maxHeight - this.wuj) / 2);
    }
    for (this.wuv.bottom = (this.wuv.top + this.wuj);; this.wuv.bottom = this.maxHeight)
    {
      this.wuv.left = 0.0F;
      this.wuv.right = this.maxWidth;
      cat();
      this.nQD.setStyle(Paint.Style.FILL);
      this.nQD.setColor(this.wus);
      GMTrace.o(13067706433536L, 97362);
      return;
      this.wuv.top = 0.0F;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = 0;
    GMTrace.i(13068511739904L, 97368);
    if (this.wuk)
    {
      GMTrace.o(13068511739904L, 97368);
      return true;
    }
    if (!isEnabled())
    {
      GMTrace.o(13068511739904L, 97368);
      return true;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      if (this.wul) {
        invalidate();
      }
      GMTrace.o(13068511739904L, 97368);
      return true;
      clearAnimation();
      this.qNE = paramMotionEvent.getX();
      this.qNF = paramMotionEvent.getY();
      this.wug = SystemClock.elapsedRealtime();
      this.wul = false;
      continue;
      float f1;
      float f2;
      if (this.wul)
      {
        du(true);
        f1 = paramMotionEvent.getX();
        f2 = this.qNE;
        RectF localRectF = this.wuw;
        localRectF.left = (f1 - f2 + localRectF.left);
        cau();
      }
      for (;;)
      {
        this.qNE = paramMotionEvent.getX();
        this.qNF = paramMotionEvent.getY();
        break;
        float f3 = paramMotionEvent.getX() - this.qNE;
        f2 = paramMotionEvent.getY() - this.qNF;
        int i = j;
        if (Math.abs(f3) >= this.mwa / 10.0F)
        {
          f1 = f2;
          if (f2 == 0.0F) {
            f1 = 1.0F;
          }
          i = j;
          if (Math.abs(f3 / f1) > 3.0F) {
            i = 1;
          }
        }
        if (i != 0)
        {
          this.wul = true;
          du(true);
        }
      }
      boolean bool;
      if (SystemClock.elapsedRealtime() - this.wug < this.wuo) {
        if (!this.wuu)
        {
          bool = true;
          label325:
          lQ(bool);
        }
      }
      for (;;)
      {
        du(false);
        this.wul = false;
        break;
        bool = false;
        break label325;
        bZM();
      }
      if (this.wul) {
        bZM();
      }
      du(false);
      this.wul = false;
    }
  }
  
  public static abstract interface a
  {
    public abstract void bK(boolean paramBoolean);
  }
  
  private final class b
    extends Animation
  {
    int direction;
    long wuA;
    float wuz;
    
    public b()
    {
      GMTrace.i(13052137177088L, 97246);
      this.direction = 0;
      this.wuz = 0.0F;
      this.wuA = 0L;
      setInterpolator(new AccelerateDecelerateInterpolator());
      setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          boolean bool2 = true;
          GMTrace.i(13071598747648L, 97391);
          boolean bool3 = MMSwitchBtn.a(MMSwitchBtn.this);
          if (MMSwitchBtn.b.this.direction == 1)
          {
            bool1 = true;
            if (bool3 != bool1)
            {
              paramAnonymousAnimation = MMSwitchBtn.this;
              if (MMSwitchBtn.b.this.direction != 1) {
                break label112;
              }
            }
          }
          label112:
          for (boolean bool1 = bool2;; bool1 = false)
          {
            MMSwitchBtn.a(paramAnonymousAnimation, bool1);
            MMSwitchBtn.this.post(new Runnable()
            {
              public final void run()
              {
                GMTrace.i(13069988134912L, 97379);
                if (MMSwitchBtn.b(MMSwitchBtn.this) != null) {
                  MMSwitchBtn.b(MMSwitchBtn.this).bK(MMSwitchBtn.a(MMSwitchBtn.this));
                }
                GMTrace.o(13069988134912L, 97379);
              }
            });
            MMSwitchBtn.c(MMSwitchBtn.this);
            GMTrace.o(13071598747648L, 97391);
            return;
            bool1 = false;
            break;
          }
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation)
        {
          GMTrace.i(13071464529920L, 97390);
          GMTrace.o(13071464529920L, 97390);
        }
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          GMTrace.i(13071330312192L, 97389);
          GMTrace.o(13071330312192L, 97389);
        }
      });
      GMTrace.o(13052137177088L, 97246);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      GMTrace.i(13052271394816L, 97247);
      if (this.direction == 0) {}
      for (MMSwitchBtn.d(MMSwitchBtn.this).left = (this.wuz - (float)this.wuA * paramFloat);; MMSwitchBtn.d(MMSwitchBtn.this).left = (this.wuz + (float)this.wuA * paramFloat))
      {
        MMSwitchBtn.e(MMSwitchBtn.this);
        MMSwitchBtn.this.invalidate();
        GMTrace.o(13052271394816L, 97247);
        return;
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/MMSwitchBtn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */