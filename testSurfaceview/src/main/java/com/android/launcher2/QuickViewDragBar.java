package com.android.launcher2;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

public class QuickViewDragBar
  extends FrameLayout
  implements DeleteDrawable.BulgeAnimationListener
{
  private static Rect sTempRect = new Rect();
  private Drawable mDeleteDrawable;
  private TextView mDeleteTextView;
  
  public QuickViewDragBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QuickViewDragBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QuickViewDragBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void setStates(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    setEnabled(paramBoolean1);
    this.mDeleteTextView.setEnabled(paramBoolean1);
    setSelected(paramBoolean2);
    setActivated(paramBoolean3);
  }
  
  public boolean checkOver(int paramInt1, int paramInt2)
  {
    sTempRect.set(getLeft(), getTop(), getRight(), getBottom());
    if (sTempRect.contains(paramInt1, paramInt2))
    {
      setStates(true, true, false);
      return true;
    }
    resetTrashCan();
    return false;
  }
  
  public void enableDelete(boolean paramBoolean)
  {
    this.mDeleteTextView.setEnabled(paramBoolean);
    setActivated(paramBoolean);
  }
  
  public void onBulgeAnimationEnded()
  {
    resetTrashCan();
  }
  
  public void onDrop()
  {
    setStates(true, true, true);
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.mDeleteTextView = ((TextView)findViewById(2131689517));
    this.mDeleteDrawable = HomeEditBar.findFirstDrawable(this.mDeleteTextView);
    if (this.mDeleteDrawable != null)
    {
      Drawable localDrawable1 = getContext().getResources().getDrawable(2130837806);
      Drawable localDrawable2 = getContext().getResources().getDrawable(2130837815);
      this.mDeleteDrawable = new DeleteDrawable(getContext(), this.mDeleteDrawable, localDrawable1, localDrawable2, true, this);
      if (getContext().getResources().getConfiguration().orientation != 2) {
        break label166;
      }
    }
    label166:
    for (int i = 1; (i != 0) && (LauncherApplication.isDeleteDropTargetTextRight()); i = 0)
    {
      this.mDeleteTextView.setCompoundDrawablesWithIntrinsicBounds(this.mDeleteDrawable, null, null, null);
      if (getResources().getConfiguration().smallestScreenWidthDp < 600)
      {
        float f = getResources().getDimension(2131624192) / 2.0F;
        this.mDeleteTextView.setTextSize(f);
      }
      return;
    }
    if ((LauncherApplication.isTabletLayout()) && (LauncherApplication.isDeleteDropTargetTextRight()))
    {
      this.mDeleteTextView.setCompoundDrawablesWithIntrinsicBounds(this.mDeleteDrawable, null, null, null);
      return;
    }
    this.mDeleteTextView.setCompoundDrawablesWithIntrinsicBounds(null, this.mDeleteDrawable, null, null);
  }
  
  public void resetTrashCan()
  {
    setStates(true, false, false);
  }
  
  public void setTextDisplayPositionRight(boolean paramBoolean)
  {
    if ((this.mDeleteTextView != null) && (this.mDeleteDrawable != null))
    {
      float f = getResources().getDimension(2131624192) / 2.0F;
      this.mDeleteTextView.setTextSize(f);
      if (paramBoolean) {
        this.mDeleteTextView.setCompoundDrawablesWithIntrinsicBounds(this.mDeleteDrawable, null, null, null);
      }
    }
    else
    {
      return;
    }
    this.mDeleteTextView.setCompoundDrawablesWithIntrinsicBounds(null, this.mDeleteDrawable, null, null);
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/QuickViewDragBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */