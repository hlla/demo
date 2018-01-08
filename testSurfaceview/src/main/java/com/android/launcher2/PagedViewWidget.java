package com.android.launcher2;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PagedViewWidget
  extends LinearLayout
  implements Checkable
{
  private static final int sPreviewFadeInDuration = 80;
  private static final int sPreviewFadeInStaggerDuration = 20;
  private float mCheckedAlpha = 1.0F;
  private ObjectAnimator mCheckedAlphaAnimator;
  private int mCheckedFadeInDuration;
  private int mCheckedFadeOutDuration;
  private Rect mDeleteRegion = new Rect();
  private String mDimensionsFormatString;
  private final int mHighlightColor;
  private ImageView mImage;
  private boolean mIsChecked;
  private Drawable mOverlay = null;
  private DynamicShadowMixin mShadowMixin;
  private String mTalkbackDimen;
  int spanX;
  int spanY;
  
  public PagedViewWidget(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PagedViewWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PagedViewWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.getResources();
    if (paramContext.getInteger(2131492866) > 0)
    {
      this.mCheckedAlpha = (paramContext.getInteger(2131492866) / 256.0F);
      this.mCheckedFadeInDuration = paramContext.getInteger(2131492864);
      this.mCheckedFadeOutDuration = paramContext.getInteger(2131492865);
    }
    this.mDimensionsFormatString = paramContext.getString(2131755014);
    this.mTalkbackDimen = paramContext.getString(2131755015);
    setHapticFeedbackEnabled(false);
    setWillNotDraw(false);
    setClipToPadding(false);
    this.mHighlightColor = paramContext.getColor(2131361829);
  }
  
  private void setChildrenAlpha(float paramFloat)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).setAlpha(paramFloat);
      i += 1;
    }
  }
  
  public void applyCellSpan(int paramInt1, int paramInt2)
  {
    TextView localTextView = (TextView)findViewById(2131689494);
    if (localTextView != null)
    {
      localTextView.setText(String.format(this.mDimensionsFormatString, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      localTextView.setContentDescription(String.format(this.mTalkbackDimen, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    this.spanY = paramInt2;
    this.spanX = paramInt1;
  }
  
  public void applyHighLightLabel(String paramString1, String paramString2)
  {
    TextView localTextView = (TextView)findViewById(2131689493);
    int i = paramString2.length();
    SpannableString localSpannableString = new SpannableString(paramString1);
    char[] arrayOfChar = TextUtils.getPrefixCharForIndian(localTextView.getPaint(), paramString1, paramString2.toCharArray());
    int j;
    if (arrayOfChar != null)
    {
      paramString2 = new String(arrayOfChar);
      j = paramString1.toLowerCase().indexOf(paramString2.toLowerCase());
      i = paramString2.length();
    }
    for (;;)
    {
      if (j > -1) {
        localSpannableString.setSpan(new ForegroundColorSpan(this.mHighlightColor), j, j + i, 0);
      }
      localTextView.setText(localSpannableString);
      return;
      j = paramString1.toLowerCase().indexOf(paramString2.toLowerCase());
    }
  }
  
  public void applyLabel(String paramString)
  {
    TextView localTextView = (TextView)findViewById(2131689493);
    localTextView.setText(paramString);
    localTextView.setHoverPopupType(0);
  }
  
  void applyPreview(FastBitmapDrawable paramFastBitmapDrawable, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mImage != null) && (paramFastBitmapDrawable != null))
    {
      this.mImage.setImageDrawable(paramFastBitmapDrawable);
      this.mShadowMixin = new DynamicShadowMixin(this.mImage);
      this.mShadowMixin.setViewToInvalidate((View)getParent());
      if (paramBoolean2)
      {
        this.mImage.setAlpha(0.0F);
        this.mImage.animate().alpha(1.0F).setDuration(paramInt * 20 + 80).start();
      }
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Utilities.onViewDraw(this, paramCanvas);
    super.draw(paramCanvas);
    Drawable localDrawable = this.mOverlay;
    if ((localDrawable != null) && (localDrawable.isVisible()) && (this.mImage != null))
    {
      localDrawable.mutate();
      int m = this.mOverlay.getIntrinsicWidth();
      int k = this.mOverlay.getIntrinsicHeight();
      Rect localRect = new Rect();
      int j = k;
      int i = m;
      if (this.mOverlay.getPadding(localRect))
      {
        i = m + (localRect.left + localRect.right);
        j = k + (localRect.top + localRect.bottom);
      }
      m = j / 2;
      localRect = new Rect(0, 0, this.mImage.getWidth(), this.mImage.getHeight());
      offsetDescendantRectToMyCoords(this.mImage, localRect);
      int n = localRect.top;
      k = localRect.right - i + getScrollX();
      m = n - m + getScrollY();
      this.mDeleteRegion.set(k, m, k + i, m + j);
      localDrawable.setBounds(this.mDeleteRegion);
      localDrawable.draw(paramCanvas);
    }
  }
  
  public void drawShadow(Canvas paramCanvas)
  {
    if (this.mShadowMixin != null)
    {
      View localView = (View)this.mImage.getParent();
      paramCanvas.translate(getLeft() + getScrollX() + localView.getLeft(), getTop() + getScrollY() + localView.getTop() + localView.getTranslationY());
      this.mShadowMixin.draw(paramCanvas);
    }
  }
  
  public ViewParent invalidateChildInParent(int[] paramArrayOfInt, Rect paramRect)
  {
    paramArrayOfInt = super.invalidateChildInParent(paramArrayOfInt, paramRect);
    ((View)getParent()).invalidate();
    return paramArrayOfInt;
  }
  
  public boolean isChecked()
  {
    return this.mIsChecked;
  }
  
  public boolean isDeleteRequested(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((this.mOverlay == null) || ((i & 0xFF) != 1)) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    return this.mDeleteRegion.contains((int)f1, (int)f2);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.mImage = ((ImageView)findViewById(2131689495));
  }
  
  protected boolean onSetAlpha(int paramInt)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!super.onTouchEvent(paramMotionEvent)) {}
    return true;
  }
  
  public void setCellSpanVisible(boolean paramBoolean)
  {
    TextView localTextView = (TextView)findViewById(2131689494);
    if (localTextView != null) {
      if (!paramBoolean) {
        break label26;
      }
    }
    label26:
    for (int i = 0;; i = 4)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    setChecked(paramBoolean, true);
  }
  
  void setChecked(boolean paramBoolean1, boolean paramBoolean2)
  {
    float f;
    int i;
    if (this.mIsChecked != paramBoolean1)
    {
      this.mIsChecked = paramBoolean1;
      if (!this.mIsChecked) {
        break label97;
      }
      f = this.mCheckedAlpha;
      i = this.mCheckedFadeInDuration;
      if (this.mCheckedAlphaAnimator != null) {
        this.mCheckedAlphaAnimator.cancel();
      }
      if (!paramBoolean2) {
        break label108;
      }
      this.mCheckedAlphaAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { getAlpha(), f });
      this.mCheckedAlphaAnimator.setDuration(i);
      this.mCheckedAlphaAnimator.start();
    }
    for (;;)
    {
      invalidate();
      return;
      label97:
      f = 1.0F;
      i = this.mCheckedFadeOutDuration;
      break;
      label108:
      setAlpha(f);
    }
  }
  
  public void setLabelVisible(boolean paramBoolean)
  {
    TextView localTextView = (TextView)findViewById(2131689493);
    if (localTextView != null) {
      if (!paramBoolean) {
        break label26;
      }
    }
    label26:
    for (int i = 0;; i = 4)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void setOverlay(Drawable paramDrawable)
  {
    if (this.mOverlay != paramDrawable)
    {
      this.mOverlay = paramDrawable;
      invalidate();
    }
  }
  
  public void toggle()
  {
    if (!this.mIsChecked) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/PagedViewWidget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */