package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ui.base.MMTagPanelScrollView;

public class LabelContainerView
  extends MMTagPanelScrollView
{
  boolean vVX;
  boolean vVY;
  boolean vVZ;
  float vWa;
  float vWb;
  float vWc;
  float vWd;
  public a vWe;
  boolean wL;
  float wQ;
  float wR;
  float wS;
  float wT;
  private int wz;
  
  public LabelContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1792477757440L, 13355);
    this.wL = true;
    this.vVX = false;
    this.vVY = true;
    this.vVZ = false;
    bXQ();
    GMTrace.o(1792477757440L, 13355);
  }
  
  public LabelContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1792343539712L, 13354);
    this.wL = true;
    this.vVX = false;
    this.vVY = true;
    this.vVZ = false;
    bXQ();
    GMTrace.o(1792343539712L, 13354);
  }
  
  private void bXQ()
  {
    GMTrace.i(1792746192896L, 13357);
    int i = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    this.wz = (i * i);
    GMTrace.o(1792746192896L, 13357);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    GMTrace.i(1792880410624L, 13358);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    GMTrace.o(1792880410624L, 13358);
    return bool;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    GMTrace.i(1792611975168L, 13356);
    int n = paramMotionEvent.getAction();
    int i;
    if ((n & 0xFF) == 6)
    {
      i = 1;
      if (i == 0) {
        break label114;
      }
    }
    int m;
    float f2;
    label114:
    for (int j = paramMotionEvent.getActionIndex();; j = -1)
    {
      m = paramMotionEvent.getPointerCount();
      int k = 0;
      float f3;
      for (f2 = 0.0F; k < m; f2 = f3)
      {
        float f4 = f1;
        f3 = f2;
        if (j != k)
        {
          f3 = f2 + paramMotionEvent.getX(k);
          f4 = f1 + paramMotionEvent.getY(k);
        }
        k += 1;
        f1 = f4;
      }
      i = 0;
      break;
    }
    if (i != 0)
    {
      i = m - 1;
      f2 /= i;
      f1 /= i;
      switch (n)
      {
      }
    }
    for (;;)
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      GMTrace.o(1792611975168L, 13356);
      return bool;
      i = m;
      break;
      this.vVY = true;
      this.vWb = f2;
      this.vWa = f2;
      this.vWd = f1;
      this.vWc = f1;
      this.vVZ = true;
      continue;
      i = (int)(f2 - this.vWa);
      j = (int)(f1 - this.vWc);
      if (j * j + i * i > this.wz)
      {
        this.vVY = false;
        GMTrace.o(1792611975168L, 13356);
        return true;
        this.vVY = true;
        this.vVZ = false;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    GMTrace.i(1793014628352L, 13359);
    int n = paramMotionEvent.getAction();
    int i;
    if ((n & 0xFF) == 6)
    {
      i = 1;
      if (i == 0) {
        break label114;
      }
    }
    int m;
    float f2;
    label114:
    for (int j = paramMotionEvent.getActionIndex();; j = -1)
    {
      m = paramMotionEvent.getPointerCount();
      int k = 0;
      float f3;
      for (f2 = 0.0F; k < m; f2 = f3)
      {
        float f4 = f1;
        f3 = f2;
        if (j != k)
        {
          f3 = f2 + paramMotionEvent.getX(k);
          f4 = f1 + paramMotionEvent.getY(k);
        }
        k += 1;
        f1 = f4;
      }
      i = 0;
      break;
    }
    if (i != 0)
    {
      i = m - 1;
      f2 /= i;
      f1 /= i;
      switch (n)
      {
      }
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      GMTrace.o(1793014628352L, 13359);
      return bool;
      i = m;
      break;
      this.wL = true;
      this.wQ = f2;
      this.wS = f2;
      this.wR = f1;
      this.wT = f1;
      this.vVX = true;
      continue;
      if (!this.vVX)
      {
        this.wL = true;
        this.wQ = f2;
        this.wS = f2;
        this.wR = f1;
        this.wT = f1;
        this.vVX = true;
      }
      if (this.vWe != null) {
        this.vWe.aoB();
      }
      i = (int)(f2 - this.wS);
      j = (int)(f1 - this.wT);
      if (j * j + i * i > this.wz)
      {
        this.wL = false;
        continue;
        if (((this.wL) || (!this.vVX)) && (this.vWe != null)) {
          this.vWe.aoA();
        }
        this.wL = true;
        this.vVX = false;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void aoA();
    
    public abstract void aoB();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/contact/LabelContainerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */