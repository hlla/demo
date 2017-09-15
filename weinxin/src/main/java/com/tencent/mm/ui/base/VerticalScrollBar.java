package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public abstract class VerticalScrollBar
  extends View
{
  private float haV;
  private Paint jVY;
  public float mRT;
  public int mRU;
  public String[] mRV;
  private int mRW;
  private float mRX;
  private float mRY;
  private o mRZ;
  private TextView mSa;
  private int mSb;
  public a voh;
  
  public VerticalScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(3160424841216L, 23547);
    this.mRX = 0.0F;
    aet();
    setFocusable(true);
    setFocusableInTouchMode(true);
    this.mSb = BackwardSupportUtil.b.a(paramContext, 3.0F);
    paramAttributeSet = inflate(paramContext, aES(), null);
    int i = BackwardSupportUtil.b.a(paramContext, this.mRU);
    this.mRZ = new o(paramAttributeSet, i, i);
    this.mSa = ((TextView)paramAttributeSet.findViewById(a.g.cEV));
    this.jVY = new Paint();
    this.jVY.setAntiAlias(true);
    this.jVY.setColor(-11119018);
    this.jVY.setTextAlign(Paint.Align.CENTER);
    GMTrace.o(3160424841216L, 23547);
  }
  
  public abstract int aES();
  
  public abstract void aet();
  
  protected void onDraw(Canvas paramCanvas)
  {
    GMTrace.i(3160559058944L, 23548);
    super.onDraw(paramCanvas);
    final int i = getMeasuredHeight();
    final int j = getMeasuredWidth();
    this.haV = (i / (this.mRV.length * this.mRT));
    this.jVY.setTextSize(this.haV);
    if (this.mRX != this.haV)
    {
      this.mRX = this.haV;
      post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(3278402224128L, 24426);
          if (VerticalScrollBar.this.mRV.length <= 0)
          {
            GMTrace.o(3278402224128L, 24426);
            return;
          }
          int i = (int)VerticalScrollBar.a(VerticalScrollBar.this).measureText(VerticalScrollBar.this.mRV[(VerticalScrollBar.this.mRV.length - 1)]) + a.fromDPToPix(VerticalScrollBar.this.getContext(), 8);
          if (i > j)
          {
            ViewGroup.LayoutParams localLayoutParams = VerticalScrollBar.this.getLayoutParams();
            localLayoutParams.width = i;
            localLayoutParams.height = i;
            VerticalScrollBar.this.setLayoutParams(localLayoutParams);
          }
          GMTrace.o(3278402224128L, 24426);
        }
      });
    }
    i = 0;
    while (i < this.mRV.length)
    {
      paramCanvas.drawText(this.mRV[i], j / 2.0F, this.haV + i * this.haV * this.mRT, this.jVY);
      i += 1;
    }
    GMTrace.o(3160559058944L, 23548);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    GMTrace.i(3160693276672L, 23549);
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2))
    {
      this.mRY = paramMotionEvent.getY();
      if (this.mRY < 0.0F) {
        this.mRY = 0.0F;
      }
      if (this.mRY > getMeasuredHeight()) {
        this.mRY = getMeasuredHeight();
      }
      setBackgroundDrawable(a.a(getContext(), a.f.bjp));
      int j = (int)(this.mRY / (this.haV * this.mRT));
      int i = j;
      if (j >= this.mRV.length) {
        i = this.mRV.length - 1;
      }
      this.mRW = i;
      if (this.mRW != -1) {
        break label229;
      }
      this.mSa.setText(a.k.ePn);
      this.mRZ.showAtLocation(this, 17, 0, 0);
      if (this.voh != null)
      {
        if (this.mRW != -1) {
          break label248;
        }
        this.voh.rZ(a.V(getContext(), a.k.ePn));
      }
    }
    for (;;)
    {
      invalidate();
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        setBackgroundResource(0);
        this.mRZ.dismiss();
      }
      GMTrace.o(3160693276672L, 23549);
      return true;
      label229:
      this.mSa.setText(this.mRV[this.mRW]);
      break;
      label248:
      this.voh.rZ(this.mRV[this.mRW]);
    }
  }
  
  public static abstract interface a
  {
    public abstract void rZ(String paramString);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/VerticalScrollBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */