package com.android.launcher2;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.TableMaskFilter;

public class HolographicOutlineHelper
{
  private static final int EXTRA_THICK = 2;
  static HolographicOutlineHelper INSTANCE;
  public static final int MAX_OUTER_BLUR_RADIUS;
  private static final int MEDIUM = 1;
  public static final int MIN_OUTER_BLUR_RADIUS;
  private static final int THICK = 0;
  private static final MaskFilter sCoarseClipTable = TableMaskFilter.CreateClipTable(0, 30);
  private static final BlurMaskFilter sExtraThickInnerBlurMaskFilter;
  private static final BlurMaskFilter sExtraThickOuterBlurMaskFilter;
  private static final BlurMaskFilter sMediumInnerBlurMaskFilter;
  private static final BlurMaskFilter sMediumOuterBlurMaskFilter;
  private static final BlurMaskFilter sThickInnerBlurMaskFilter;
  private static final BlurMaskFilter sThickOuterBlurMaskFilter;
  private static final BlurMaskFilter sThinOuterBlurMaskFilter;
  private final Paint mAlphaClipPaint = new Paint();
  private final Paint mBlurPaint = new Paint();
  private final Paint mErasePaint = new Paint();
  private final Paint mHolographicPaint = new Paint();
  private int[] mTempOffset = new int[2];
  
  static
  {
    float f = LauncherApplication.getScreenDensity();
    MIN_OUTER_BLUR_RADIUS = (int)(f * 1.0F);
    MAX_OUTER_BLUR_RADIUS = (int)(f * 12.0F);
    sExtraThickOuterBlurMaskFilter = new BlurMaskFilter(12.0F * f, BlurMaskFilter.Blur.OUTER);
    sThickOuterBlurMaskFilter = new BlurMaskFilter(4.0F * f, BlurMaskFilter.Blur.OUTER);
    sMediumOuterBlurMaskFilter = new BlurMaskFilter(f * 2.0F, BlurMaskFilter.Blur.OUTER);
    sThinOuterBlurMaskFilter = new BlurMaskFilter(f * 1.0F, BlurMaskFilter.Blur.OUTER);
    sExtraThickInnerBlurMaskFilter = new BlurMaskFilter(6.0F * f, BlurMaskFilter.Blur.NORMAL);
    sThickInnerBlurMaskFilter = new BlurMaskFilter(3.0F * f, BlurMaskFilter.Blur.NORMAL);
    sMediumInnerBlurMaskFilter = new BlurMaskFilter(f * 2.0F, BlurMaskFilter.Blur.NORMAL);
  }
  
  HolographicOutlineHelper()
  {
    this.mHolographicPaint.setFilterBitmap(true);
    this.mHolographicPaint.setAntiAlias(true);
    this.mBlurPaint.setFilterBitmap(true);
    this.mBlurPaint.setAntiAlias(true);
    this.mErasePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    this.mErasePaint.setFilterBitmap(true);
    this.mErasePaint.setAntiAlias(true);
    TableMaskFilter localTableMaskFilter = TableMaskFilter.CreateClipTable(20, 35);
    this.mAlphaClipPaint.setMaskFilter(localTableMaskFilter);
  }
  
  public static float highlightAlphaInterpolator(float paramFloat)
  {
    return (float)Math.pow((1.0F - paramFloat) * 0.6F, 1.5D);
  }
  
  public static HolographicOutlineHelper obtain()
  {
    if (INSTANCE == null) {
      INSTANCE = new HolographicOutlineHelper();
    }
    return INSTANCE;
  }
  
  public static float viewAlphaInterpolator(float paramFloat)
  {
    if (paramFloat < 0.95F) {
      return (float)Math.pow(paramFloat / 0.95F, 1.5D);
    }
    return 1.0F;
  }
  
  void applyExpensiveOutlineWithBlur(Bitmap paramBitmap, Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3)
  {
    applyExpensiveOutlineWithBlur(paramBitmap, paramCanvas, paramInt1, paramInt2, this.mAlphaClipPaint, paramInt3);
  }
  
  void applyExpensiveOutlineWithBlur(Bitmap paramBitmap, Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint, int paramInt3)
  {
    Object localObject = paramPaint;
    if (paramPaint == null) {
      localObject = this.mAlphaClipPaint;
    }
    localObject = paramBitmap.extractAlpha((Paint)localObject, this.mTempOffset);
    label71:
    int[] arrayOfInt1;
    Bitmap localBitmap1;
    switch (paramInt3)
    {
    default: 
      throw new RuntimeException("Invalid blur thickness");
    case 2: 
      paramPaint = sExtraThickOuterBlurMaskFilter;
      this.mBlurPaint.setMaskFilter(paramPaint);
      arrayOfInt1 = new int[2];
      localBitmap1 = ((Bitmap)localObject).extractAlpha(this.mBlurPaint, arrayOfInt1);
      if (paramInt3 == 2) {
        this.mBlurPaint.setMaskFilter(sMediumOuterBlurMaskFilter);
      }
      break;
    }
    int[] arrayOfInt2;
    Bitmap localBitmap2;
    for (;;)
    {
      arrayOfInt2 = new int[2];
      localBitmap2 = ((Bitmap)localObject).extractAlpha(this.mBlurPaint, arrayOfInt2);
      paramCanvas.setBitmap((Bitmap)localObject);
      paramCanvas.drawColor(-16777216, PorterDuff.Mode.SRC_OUT);
      switch (paramInt3)
      {
      default: 
        throw new RuntimeException("Invalid blur thickness");
        paramPaint = sThickOuterBlurMaskFilter;
        break label71;
        paramPaint = sMediumOuterBlurMaskFilter;
        break label71;
        this.mBlurPaint.setMaskFilter(sThinOuterBlurMaskFilter);
      }
    }
    paramPaint = sExtraThickInnerBlurMaskFilter;
    for (;;)
    {
      this.mBlurPaint.setMaskFilter(paramPaint);
      paramPaint = new int[2];
      Bitmap localBitmap3 = ((Bitmap)localObject).extractAlpha(this.mBlurPaint, paramPaint);
      paramCanvas.setBitmap(localBitmap3);
      paramCanvas.drawBitmap((Bitmap)localObject, -paramPaint[0], -paramPaint[1], this.mErasePaint);
      paramCanvas.drawRect(0.0F, 0.0F, -paramPaint[0], localBitmap3.getHeight(), this.mErasePaint);
      paramCanvas.drawRect(0.0F, 0.0F, localBitmap3.getWidth(), -paramPaint[1], this.mErasePaint);
      paramCanvas.setBitmap(paramBitmap);
      paramCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
      this.mHolographicPaint.setColor(paramInt1);
      paramCanvas.drawBitmap(localBitmap3, paramPaint[0], paramPaint[1], this.mHolographicPaint);
      paramCanvas.drawBitmap(localBitmap1, arrayOfInt1[0], arrayOfInt1[1], this.mHolographicPaint);
      this.mHolographicPaint.setColor(paramInt2);
      paramCanvas.drawBitmap(localBitmap2, arrayOfInt2[0], arrayOfInt2[1], this.mHolographicPaint);
      paramCanvas.setBitmap(null);
      localBitmap2.recycle();
      localBitmap1.recycle();
      localBitmap3.recycle();
      ((Bitmap)localObject).recycle();
      return;
      paramPaint = sThickInnerBlurMaskFilter;
      continue;
      paramPaint = sMediumInnerBlurMaskFilter;
    }
  }
  
  void applyExtraThickExpensiveOutlineWithBlur(Bitmap paramBitmap, Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    applyExpensiveOutlineWithBlur(paramBitmap, paramCanvas, paramInt1, paramInt2, 2);
  }
  
  void applyMediumExpensiveOutlineWithBlur(Bitmap paramBitmap, Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    applyExpensiveOutlineWithBlur(paramBitmap, paramCanvas, paramInt1, paramInt2, 1);
  }
  
  void applyMediumExpensiveOutlineWithBlur(Bitmap paramBitmap, Canvas paramCanvas, int paramInt1, int paramInt2, Paint paramPaint)
  {
    applyExpensiveOutlineWithBlur(paramBitmap, paramCanvas, paramInt1, paramInt2, paramPaint, 1);
  }
  
  void applyOuterBlur(Bitmap paramBitmap, Canvas paramCanvas, int paramInt)
  {
    this.mBlurPaint.setMaskFilter(sThickOuterBlurMaskFilter);
    paramBitmap = paramBitmap.extractAlpha(this.mBlurPaint, this.mTempOffset);
    this.mHolographicPaint.setMaskFilter(sCoarseClipTable);
    this.mHolographicPaint.setAlpha(200);
    this.mHolographicPaint.setColor(paramInt);
    paramCanvas.drawBitmap(paramBitmap, this.mTempOffset[0], this.mTempOffset[1], this.mHolographicPaint);
    paramBitmap.recycle();
  }
  
  void applyThickExpensiveOutlineWithBlur(Bitmap paramBitmap, Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    applyExpensiveOutlineWithBlur(paramBitmap, paramCanvas, paramInt1, paramInt2, 0);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/HolographicOutlineHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */