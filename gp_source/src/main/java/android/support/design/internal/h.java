package android.support.design.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.dj;
import android.util.AttributeSet;
import android.view.Gravity;

public class h
  extends dj
{
  private Drawable a;
  private boolean b = false;
  private int c = 119;
  private boolean d = true;
  private final Rect e = new Rect();
  private final Rect f = new Rect();
  
  public h(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public h(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public h(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = n.a(paramContext, paramAttributeSet, j.a, paramInt, 0, new int[0]);
    this.c = paramContext.getInt(j.c, this.c);
    paramAttributeSet = paramContext.getDrawable(j.b);
    if (paramAttributeSet != null) {
      setForeground(paramAttributeSet);
    }
    this.d = paramContext.getBoolean(j.d, true);
    paramContext.recycle();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable = this.a;
    Rect localRect1;
    Rect localRect2;
    int i;
    int j;
    if (localDrawable != null) {
      if (this.b)
      {
        this.b = false;
        localRect1 = this.f;
        localRect2 = this.e;
        i = getRight() - getLeft();
        j = getBottom() - getTop();
        if (!this.d) {
          break label111;
        }
        localRect1.set(0, 0, i, j);
      }
    }
    for (;;)
    {
      Gravity.apply(this.c, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), localRect1, localRect2);
      localDrawable.setBounds(localRect2);
      localDrawable.draw(paramCanvas);
      return;
      label111:
      localRect1.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), j - getPaddingBottom());
    }
  }
  
  @TargetApi(21)
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    super.drawableHotspotChanged(paramFloat1, paramFloat2);
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      localDrawable.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.a;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      this.a.setState(getDrawableState());
    }
  }
  
  public Drawable getForeground()
  {
    return this.a;
  }
  
  public int getForegroundGravity()
  {
    return this.c;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Drawable localDrawable = this.a;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.b |= paramBoolean;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.b = true;
  }
  
  public void setForeground(Drawable paramDrawable)
  {
    Drawable localDrawable = this.a;
    if (localDrawable != paramDrawable)
    {
      if (localDrawable != null)
      {
        localDrawable.setCallback(null);
        unscheduleDrawable(this.a);
      }
      this.a = paramDrawable;
      if (paramDrawable == null) {
        break label92;
      }
      setWillNotDraw(false);
      paramDrawable.setCallback(this);
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(getDrawableState());
      }
      if (this.c == 119) {
        paramDrawable.getPadding(new Rect());
      }
    }
    for (;;)
    {
      requestLayout();
      invalidate();
      return;
      label92:
      setWillNotDraw(true);
    }
  }
  
  public void setForegroundGravity(int paramInt)
  {
    if (this.c != paramInt)
    {
      if ((0x800007 & paramInt) != 0) {
        break label77;
      }
      paramInt = 0x800003 | paramInt;
    }
    label77:
    for (;;)
    {
      int i = paramInt;
      if ((paramInt & 0x70) == 0) {
        i = paramInt | 0x30;
      }
      this.c = i;
      if ((this.c == 119) && (this.a != null))
      {
        Rect localRect = new Rect();
        this.a.getPadding(localRect);
      }
      requestLayout();
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */