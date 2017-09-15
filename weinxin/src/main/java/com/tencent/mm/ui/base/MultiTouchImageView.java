package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;

public class MultiTouchImageView
  extends ImageView
{
  public int imageHeight;
  public int imageWidth;
  public int lmx;
  public int lmy;
  protected ad mHandler;
  private boolean nEO;
  public float oZL;
  private a qAU;
  public boolean qAx;
  protected Bitmap qkI;
  private float vmA;
  private float vmB;
  float vmC;
  public boolean vmD;
  public Drawable vmE;
  protected Matrix vmk;
  protected Matrix vml;
  private final Matrix vmm;
  private final float[] vmn;
  int vmo;
  int vmp;
  private float vmq;
  private float vmr;
  private float vms;
  private float vmt;
  private float vmu;
  private float vmv;
  public boolean vmw;
  public boolean vmx;
  public boolean vmy;
  private float vmz;
  
  public MultiTouchImageView(Context paramContext, int paramInt1, int paramInt2)
  {
    this(paramContext, paramInt1, paramInt2, null);
    GMTrace.i(3154519261184L, 23503);
    GMTrace.o(3154519261184L, 23503);
  }
  
  public MultiTouchImageView(Context paramContext, int paramInt1, int paramInt2, a parama)
  {
    super(paramContext);
    GMTrace.i(3154385043456L, 23502);
    this.vmk = new Matrix();
    this.vml = new Matrix();
    this.vmm = new Matrix();
    this.vmn = new float[9];
    this.qkI = null;
    this.vmo = -1;
    this.vmp = -1;
    this.vmq = 0.0F;
    this.vmr = 0.0F;
    this.vms = 0.0F;
    this.nEO = false;
    this.vmt = 2.0F;
    this.vmu = 0.75F;
    this.vmv = 20.0F;
    this.vmw = false;
    this.vmx = false;
    this.vmy = false;
    this.qAx = true;
    this.mHandler = new ad();
    this.vmB = 1.0F;
    this.vmC = 0.0F;
    this.vmD = false;
    this.imageHeight = paramInt2;
    this.imageWidth = paramInt1;
    this.qAU = parama;
    init();
    GMTrace.o(3154385043456L, 23502);
  }
  
  public MultiTouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
    GMTrace.i(3154653478912L, 23504);
    GMTrace.o(3154653478912L, 23504);
  }
  
  private MultiTouchImageView(Context paramContext, AttributeSet paramAttributeSet, byte paramByte)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(3154787696640L, 23505);
    this.vmk = new Matrix();
    this.vml = new Matrix();
    this.vmm = new Matrix();
    this.vmn = new float[9];
    this.qkI = null;
    this.vmo = -1;
    this.vmp = -1;
    this.vmq = 0.0F;
    this.vmr = 0.0F;
    this.vms = 0.0F;
    this.nEO = false;
    this.vmt = 2.0F;
    this.vmu = 0.75F;
    this.vmv = 20.0F;
    this.vmw = false;
    this.vmx = false;
    this.vmy = false;
    this.qAx = true;
    this.mHandler = new ad();
    this.vmB = 1.0F;
    this.vmC = 0.0F;
    this.vmD = false;
    this.imageHeight = 0;
    this.imageWidth = 0;
    init();
    GMTrace.o(3154787696640L, 23505);
  }
  
  private void J(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f2 = 0.0F;
    GMTrace.i(3156264091648L, 23516);
    if ((this.qkI == null) && (!this.vmD))
    {
      GMTrace.o(3156264091648L, 23516);
      return;
    }
    if ((this.vmE == null) && (this.vmD))
    {
      GMTrace.o(3156264091648L, 23516);
      return;
    }
    Matrix localMatrix = bSB();
    RectF localRectF;
    float f1;
    float f3;
    if (this.vmD)
    {
      localRectF = new RectF(0.0F, 0.0F, this.vmE.getIntrinsicWidth(), this.vmE.getIntrinsicHeight());
      localMatrix.mapRect(localRectF);
      f1 = localRectF.height();
      f3 = localRectF.width();
      if (!paramBoolean2) {
        break label312;
      }
      if (f1 >= this.lmy) {
        break label263;
      }
      f1 = (this.lmy - f1) / 2.0F - localRectF.top;
    }
    for (;;)
    {
      label151:
      if (paramBoolean1) {
        if (f3 < this.lmx) {
          f2 = (this.lmx - f3) / 2.0F - localRectF.left;
        }
      }
      for (;;)
      {
        G(f2, f1);
        localMatrix = bSB();
        setImageMatrix(localMatrix);
        localMatrix.mapRect(localRectF);
        localRectF.height();
        localRectF.width();
        GMTrace.o(3156264091648L, 23516);
        return;
        localRectF = new RectF(0.0F, 0.0F, this.qkI.getWidth(), this.qkI.getHeight());
        break;
        label263:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label151;
        }
        if (localRectF.bottom >= this.lmy) {
          break label463;
        }
        f1 = this.lmy - localRectF.bottom;
        break label151;
        label312:
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break label151;
        }
        if (localRectF.bottom >= this.lmy) {
          break label463;
        }
        f1 = this.lmy - localRectF.bottom;
        break label151;
        if (localRectF.left > 0.0F)
        {
          f2 = -localRectF.left;
        }
        else if (localRectF.right < this.lmx)
        {
          f2 = this.lmx - localRectF.right;
          continue;
          if (localRectF.left > 0.0F) {
            f2 = -localRectF.left;
          } else if (localRectF.right < this.lmx) {
            f2 = this.lmx - localRectF.right;
          }
        }
      }
      label463:
      f1 = 0.0F;
    }
  }
  
  private void bSA()
  {
    boolean bool2 = true;
    GMTrace.i(3155861438464L, 23513);
    this.vmz = (this.lmx / this.imageWidth);
    this.vmA = (this.lmy / this.imageHeight);
    this.vmx = d.bh(this.imageWidth, this.imageHeight);
    this.vmy = d.bg(this.imageWidth, this.imageHeight);
    if ((this.vmx) && (this.imageWidth > this.lmx))
    {
      bool1 = true;
      this.vmx = bool1;
      if ((!this.vmy) || (this.imageHeight <= this.lmy)) {
        break label144;
      }
    }
    label144:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.vmy = bool1;
      this.oZL = this.vmz;
      GMTrace.o(3155861438464L, 23513);
      return;
      bool1 = false;
      break;
    }
  }
  
  private Matrix bSB()
  {
    GMTrace.i(3156666744832L, 23519);
    this.vmm.set(this.vmk);
    this.vmm.postConcat(this.vml);
    Matrix localMatrix = this.vmm;
    GMTrace.o(3156666744832L, 23519);
    return localMatrix;
  }
  
  private void g(final float paramFloat1, final float paramFloat2, final float paramFloat3)
  {
    GMTrace.i(3157472051200L, 23525);
    paramFloat1 = (paramFloat1 - getScale()) / 128.0F;
    float f = getScale();
    final long l = System.currentTimeMillis();
    this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(3285649981440L, 24480);
        long l = System.currentTimeMillis();
        float f1 = Math.min(this.vmF, (float)(l - l));
        float f2 = paramFloat1;
        float f3 = paramFloat2;
        MultiTouchImageView.this.f(f2 + f3 * f1, paramFloat3, this.oiO);
        if (f1 < this.vmF) {
          MultiTouchImageView.this.mHandler.post(this);
        }
        GMTrace.o(3285649981440L, 24480);
      }
    });
    GMTrace.o(3157472051200L, 23525);
  }
  
  private void init()
  {
    GMTrace.i(3156398309376L, 23517);
    v.d("dktest", "init screenWidth:" + this.lmx + " screenHeight :" + this.lmy);
    setScaleType(ImageView.ScaleType.MATRIX);
    float f = getContext().getResources().getDisplayMetrics().widthPixels / 720.0F;
    if (f > 1.0F) {
      this.vmB = f;
    }
    bSz();
    GMTrace.o(3156398309376L, 23517);
  }
  
  public final void E(float paramFloat1, float paramFloat2)
  {
    GMTrace.i(3155593003008L, 23511);
    bSA();
    g(this.oZL, paramFloat1, paramFloat2);
    GMTrace.o(3155593003008L, 23511);
  }
  
  public final void F(float paramFloat1, float paramFloat2)
  {
    GMTrace.i(3157337833472L, 23524);
    this.vmq = bSE();
    g(this.vmq, paramFloat1, paramFloat2);
    GMTrace.o(3157337833472L, 23524);
  }
  
  public final void G(float paramFloat1, float paramFloat2)
  {
    GMTrace.i(3157606268928L, 23526);
    this.vml.postTranslate(paramFloat1, paramFloat2);
    setImageMatrix(bSB());
    GMTrace.o(3157606268928L, 23526);
  }
  
  public final void at(float paramFloat)
  {
    GMTrace.i(3154250825728L, 23501);
    if (Float.compare(paramFloat, 1.0F) < 0)
    {
      v.w("MicroMsg.MultiTouchImageView", "max scale limit is less than 1.0, change nothing, return");
      GMTrace.o(3154250825728L, 23501);
      return;
    }
    this.vmv = paramFloat;
    GMTrace.o(3154250825728L, 23501);
  }
  
  public final void bSC()
  {
    boolean bool2 = true;
    GMTrace.i(3156800962560L, 23520);
    boolean bool1;
    if ((!this.qAx) || (!this.vmx))
    {
      bool1 = true;
      if (this.vmy) {
        break label55;
      }
    }
    for (;;)
    {
      J(bool1, bool2);
      GMTrace.o(3156800962560L, 23520);
      return;
      bool1 = false;
      break;
      label55:
      bool2 = false;
    }
  }
  
  public final void bSD()
  {
    GMTrace.i(3156935180288L, 23521);
    if ((this.vmw) && (0.0F == this.vmq)) {
      this.vmq = bSE();
    }
    GMTrace.o(3156935180288L, 23521);
  }
  
  public final float bSE()
  {
    GMTrace.i(3157203615744L, 23523);
    float f1 = this.oZL;
    if (this.vmz * 0.7F > f1) {
      f1 = this.vmz;
    }
    for (;;)
    {
      float f2 = f1;
      if (f1 < 1.0D) {
        f2 = 1.0F;
      }
      f1 = f2;
      if (f2 > this.vmr) {
        f1 = this.vmr;
      }
      GMTrace.o(3157203615744L, 23523);
      return f1;
      if (this.vmA * 0.7F > f1) {
        f1 = this.vmA;
      } else {
        f1 = this.oZL * this.vmt;
      }
    }
  }
  
  public final void bSz()
  {
    GMTrace.i(3155458785280L, 23510);
    this.vml.reset();
    bSA();
    f(this.oZL, 0.0F, 0.0F);
    GMTrace.o(3155458785280L, 23510);
  }
  
  public final void dZ(int paramInt1, int paramInt2)
  {
    GMTrace.i(3154921914368L, 23506);
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
    GMTrace.o(3154921914368L, 23506);
  }
  
  public final void f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool2 = false;
    GMTrace.i(3157069398016L, 23522);
    float f2 = getScale();
    float f1;
    if (this.vmw)
    {
      if (0.0F == this.vmq)
      {
        f1 = this.vmv * this.vmB;
        this.vmr = f1;
      }
    }
    else
    {
      if (paramFloat1 <= this.vmr * 2.0F) {
        break label190;
      }
      f1 = this.vmr * 2.0F + (paramFloat1 - this.vmr) * 0.1F;
      label81:
      paramFloat1 = f1 / f2;
      if (!this.vmD)
      {
        setImageMatrix(bSB());
        this.vml.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
      }
      if ((this.qAx) && (this.vmx)) {
        break label211;
      }
    }
    label190:
    label211:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!this.vmy) {
        bool2 = true;
      }
      J(bool1, bool2);
      if (this.qAU == null) {
        break label232;
      }
      if (paramFloat1 <= 1.0F) {
        break label217;
      }
      this.qAU.bko();
      GMTrace.o(3157069398016L, 23522);
      return;
      f1 = this.vmq;
      break;
      f1 = paramFloat1;
      if (paramFloat1 >= this.vms) {
        break label81;
      }
      f1 = this.vms;
      break label81;
    }
    label217:
    if (paramFloat1 < 1.0F) {
      this.qAU.bkn();
    }
    label232:
    GMTrace.o(3157069398016L, 23522);
  }
  
  public final float getScale()
  {
    GMTrace.i(3156532527104L, 23518);
    this.vml.getValues(this.vmn);
    bSA();
    this.vmr = (this.vmv * this.vmB);
    this.vms = (this.oZL * this.vmu);
    if (this.vmr < 1.0F) {
      this.vmr = 1.0F;
    }
    if (this.vms > 1.0F) {
      this.vms = 1.0F;
    }
    float f = this.vmn[0];
    GMTrace.o(3156532527104L, 23518);
    return f;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    GMTrace.i(3155727220736L, 23512);
    if ((paramConfiguration.orientation == 1) || (paramConfiguration.orientation == 2)) {
      this.nEO = false;
    }
    GMTrace.o(3155727220736L, 23512);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    GMTrace.i(3155324567552L, 23509);
    if ((!this.vmD) && (this.qkI != null) && (this.qkI.isRecycled()))
    {
      v.e("MicroMsg.MultiTouchImageView", "this bitmap is recycled! draw nothing!");
      GMTrace.o(3155324567552L, 23509);
      return;
    }
    super.onDraw(paramCanvas);
    GMTrace.o(3155324567552L, 23509);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(3155995656192L, 23514);
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      if (f.bmU())
      {
        new e();
        paramKeyEvent.startTracking();
      }
      GMTrace.o(3155995656192L, 23514);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(3155995656192L, 23514);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    GMTrace.i(3156129873920L, 23515);
    if (paramInt == 4)
    {
      if (f.bmU()) {
        new e();
      }
      for (bool1 = paramKeyEvent.isTracking(); bool1; bool1 = false)
      {
        bool1 = bool2;
        if (f.bmU())
        {
          new e();
          bool1 = paramKeyEvent.isCanceled();
        }
        if ((bool1) || (getScale() <= 1.0F)) {
          break;
        }
        f(1.0F, this.lmx / 2.0F, this.lmy / 2.0F);
        GMTrace.o(3156129873920L, 23515);
        return true;
      }
    }
    boolean bool1 = super.onKeyUp(paramInt, paramKeyEvent);
    GMTrace.o(3156129873920L, 23515);
    return bool1;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    GMTrace.i(3155056132096L, 23507);
    super.onMeasure(paramInt1, paramInt2);
    this.lmx = View.MeasureSpec.getSize(paramInt1);
    this.lmy = View.MeasureSpec.getSize(paramInt2);
    if (!this.nEO)
    {
      this.nEO = true;
      init();
    }
    GMTrace.o(3155056132096L, 23507);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    GMTrace.i(3155190349824L, 23508);
    this.vmD = false;
    this.qkI = paramBitmap;
    this.nEO = false;
    super.setImageBitmap(paramBitmap);
    GMTrace.o(3155190349824L, 23508);
  }
  
  public static abstract interface a
  {
    public abstract void bkn();
    
    public abstract void bko();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/MultiTouchImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */