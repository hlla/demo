package com.android.launcher2;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;

class ShadowBuilder
  extends UpdateableShadowBuilder
{
  private static final float DEFAULT_SCALE_FACTOR = 0.9F;
  private static final String TAG = "ShadowBuilder";
  private Bitmap mBitmap;
  boolean mDrawGlow = false;
  private final Paint mPaint = new Paint();
  private float mPointFactor = 1.0F;
  private float mScale;
  private float mScaleFactor = 0.9F;
  private boolean mScaleInDraw;
  private int[] mTouch;
  
  public ShadowBuilder(View paramView)
  {
    this(paramView, 0.9F, 0.9F);
  }
  
  public ShadowBuilder(View paramView, float paramFloat1, float paramFloat2)
  {
    super(paramView);
    this.mScaleFactor = paramFloat1;
    this.mPointFactor = paramFloat2;
    this.mBitmap = createBitmap(paramView, this.mScaleFactor);
    init(paramView);
  }
  
  public ShadowBuilder(View paramView, Bitmap paramBitmap)
  {
    super(paramView);
    this.mBitmap = paramBitmap;
    init(paramView);
  }
  
  private Bitmap createBitmap(View paramView, float paramFloat)
  {
    if ((paramView instanceof SurfaceWidgetView))
    {
      int i = (int)(paramView.getWidth() * paramFloat);
      int j = (int)(paramView.getHeight() * paramFloat);
      Bitmap localBitmap = ((SurfaceWidgetView)paramView).getBitmap(i, j);
      if (localBitmap != null) {
        paramView.setVisibility(4);
      }
      this.mScaleInDraw = false;
      return localBitmap;
    }
    paramView = Workspace.createDragBitmap(paramView, new Canvas(), HolographicOutlineHelper.MAX_OUTER_BLUR_RADIUS);
    this.mScaleInDraw = true;
    return paramView;
  }
  
  private void init(View paramView)
  {
    float f = paramView.getScaleX();
    for (Object localObject = paramView.getParent(); (localObject instanceof View); localObject = ((ViewParent)localObject).getParent()) {
      f *= ((View)localObject).getScaleX();
    }
    this.mScale = 1.0F;
    localObject = (BaseItem)paramView.getTag();
    int i;
    int[] arrayOfInt;
    if ((paramView instanceof AppIconView))
    {
      this.mTouch = ((DynamicShadowMixin.Holder)paramView).getLastTouchPoint();
      if (this.mBitmap == null)
      {
        i = 0;
        arrayOfInt = this.mTouch;
        arrayOfInt[0] -= (paramView.getWidth() - i) / 2;
        this.mScale = f;
      }
    }
    for (;;)
    {
      if (((paramView instanceof ImageView)) || (BaseItem.isWidget((BaseItem)localObject))) {
        this.mDrawGlow = true;
      }
      resetPaint();
      return;
      i = this.mBitmap.getWidth();
      break;
      if ((!BaseItem.isWidget((BaseItem)localObject)) || (!(paramView instanceof DynamicShadowMixin.Holder))) {
        break label254;
      }
      this.mTouch = ((DynamicShadowMixin.Holder)paramView).getLastTouchPoint();
      i = HolographicOutlineHelper.MAX_OUTER_BLUR_RADIUS / 2;
      arrayOfInt = this.mTouch;
      arrayOfInt[0] += i;
      arrayOfInt = this.mTouch;
      arrayOfInt[1] += i;
      arrayOfInt = this.mTouch;
      arrayOfInt[0] = ((int)(arrayOfInt[0] * f));
      arrayOfInt = this.mTouch;
      arrayOfInt[1] = ((int)(arrayOfInt[1] * f));
    }
    label254:
    if (this.mBitmap == null)
    {
      i = 0;
      label263:
      if (this.mBitmap != null) {
        break label307;
      }
    }
    label307:
    for (int j = 0;; j = this.mBitmap.getHeight())
    {
      this.mTouch = new int[] { i / 2, j / 2 };
      break;
      i = this.mBitmap.getWidth();
      break label263;
    }
  }
  
  public Bitmap getBitmap()
  {
    return this.mBitmap;
  }
  
  public Paint getPaint()
  {
    return this.mPaint;
  }
  
  public int[] getTouchOffset()
  {
    int[] arrayOfInt = (int[])this.mTouch.clone();
    arrayOfInt[0] = ((int)(arrayOfInt[0] * (this.mPointFactor * this.mScale)));
    arrayOfInt[1] = ((int)(arrayOfInt[1] * (this.mPointFactor * this.mScale)));
    return arrayOfInt;
  }
  
  public void onDrawShadow(Canvas paramCanvas)
  {
    if ((this.mBitmap == null) || (this.mBitmap.isRecycled()))
    {
      Log.e("ShadowBuilder", "Bitmap is recycled; draw ignored");
      return;
    }
    int j = this.mBitmap.getWidth();
    int k = this.mBitmap.getHeight();
    if (this.mScaleInDraw) {
      paramCanvas.scale(this.mScaleFactor, this.mScaleFactor);
    }
    if (this.mDrawGlow) {}
    for (int i = HolographicOutlineHelper.MAX_OUTER_BLUR_RADIUS / 2;; i = 0)
    {
      RectF localRectF = new RectF(i, i, j - i, k - i);
      paramCanvas.drawBitmap(this.mBitmap, null, localRectF, this.mPaint);
      if (!this.mDrawGlow) {
        break;
      }
      Paint localPaint = new Paint();
      localPaint.setFilterBitmap(true);
      localPaint.setAntiAlias(true);
      Bitmap localBitmap = Bitmap.createBitmap(j, k, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas();
      localCanvas.setBitmap(localBitmap);
      localCanvas.drawBitmap(this.mBitmap, null, localRectF, localPaint);
      Workspace.sOutlineHelper.applyThickExpensiveOutlineWithBlur(localBitmap, localCanvas, -1, -1);
      localCanvas.setBitmap(null);
      localRectF.set(0.0F, 0.0F, j, k);
      paramCanvas.drawBitmap(localBitmap, null, localRectF, localPaint);
      return;
    }
  }
  
  public void onProvideShadowMetrics(Point paramPoint1, Point paramPoint2)
  {
    if (this.mBitmap == null)
    {
      Log.e("ShadowBuilder", "Bitmap is null. shadow metrics not provided");
      return;
    }
    paramPoint1.set(this.mBitmap.getWidth(), this.mBitmap.getHeight());
    paramPoint2.set((int)(this.mTouch[0] * this.mPointFactor), (int)(this.mTouch[1] * this.mPointFactor));
  }
  
  public void resetPaint()
  {
    this.mPaint.setColorFilter(new LightingColorFilter(-8421505, -16777216));
    this.mPaint.setFilterBitmap(true);
    this.mPaint.setAntiAlias(true);
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
  }
  
  public void setTouchOffset(int[] paramArrayOfInt)
  {
    this.mTouch = paramArrayOfInt;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/ShadowBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */