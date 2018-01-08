package com.android.launcher2;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class RotateHelper
{
  public static void applyStyle(int paramInt, View paramView)
  {
    TypedArray localTypedArray = paramView.getContext().obtainStyledAttributes(paramInt, ShadowStyleable.View);
    setViewAttributes(localTypedArray, paramView);
    localTypedArray.recycle();
  }
  
  public static void applyStyle(int paramInt, LinearLayout paramLinearLayout)
  {
    applyStyle(paramInt, paramLinearLayout);
    TypedArray localTypedArray = paramLinearLayout.getContext().obtainStyledAttributes(paramInt, ShadowStyleable.LinearLayout);
    setLinearLayoutAttributes(localTypedArray, paramLinearLayout);
    localTypedArray.recycle();
  }
  
  public static void applyStyle(int paramInt, TextView paramTextView)
  {
    applyStyle(paramInt, paramTextView);
    TypedArray localTypedArray = paramTextView.getContext().obtainStyledAttributes(paramInt, ShadowStyleable.TextView);
    setTextViewAttributes(localTypedArray, paramTextView);
    localTypedArray.recycle();
  }
  
  public static void applyStyleLayout(int paramInt, View paramView)
  {
    Object localObject1 = paramView.getLayoutParams();
    Object localObject2;
    TypedArray localTypedArray;
    label91:
    int j;
    if ((localObject1 instanceof FrameLayout.LayoutParams))
    {
      localObject2 = (FrameLayout.LayoutParams)localObject1;
      localTypedArray = paramView.getContext().obtainStyledAttributes(paramInt, ShadowStyleable.FrameLayout_Layout);
      ((FrameLayout.LayoutParams)localObject2).gravity = localTypedArray.getInt(ShadowStyleable.FrameLayout_Layout_layout_gravity, ((FrameLayout.LayoutParams)localObject2).gravity);
      localTypedArray.recycle();
      if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
        break label378;
      }
      localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
      paramView = paramView.getContext().obtainStyledAttributes(paramInt, ShadowStyleable.ViewGroup_MarginLayout);
      i = paramView.getIndexCount();
      paramInt = 0;
      if (paramInt >= i) {
        break label373;
      }
      j = paramView.getIndex(paramInt);
      if (j != ShadowStyleable.ViewGroup_MarginLayout_layout_width) {
        break label203;
      }
      ((ViewGroup.MarginLayoutParams)localObject1).width = paramView.getLayoutDimension(j, ((ViewGroup.MarginLayoutParams)localObject1).width);
    }
    for (;;)
    {
      paramInt += 1;
      break label91;
      if (!(localObject1 instanceof LinearLayout.LayoutParams)) {
        break;
      }
      localObject2 = (LinearLayout.LayoutParams)localObject1;
      localTypedArray = paramView.getContext().obtainStyledAttributes(paramInt, ShadowStyleable.LinearLayout_Layout);
      ((LinearLayout.LayoutParams)localObject2).gravity = localTypedArray.getInt(ShadowStyleable.LinearLayout_Layout_layout_gravity, ((LinearLayout.LayoutParams)localObject2).gravity);
      ((LinearLayout.LayoutParams)localObject2).weight = localTypedArray.getFloat(ShadowStyleable.LinearLayout_Layout_layout_weight, ((LinearLayout.LayoutParams)localObject2).weight);
      localTypedArray.recycle();
      break;
      label203:
      if (j == ShadowStyleable.ViewGroup_MarginLayout_layout_height)
      {
        ((ViewGroup.MarginLayoutParams)localObject1).height = paramView.getLayoutDimension(j, ((ViewGroup.MarginLayoutParams)localObject1).height);
      }
      else if (j == ShadowStyleable.ViewGroup_MarginLayout_layout_margin)
      {
        j = paramView.getDimensionPixelSize(j, ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = j;
        ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = j;
        ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = j;
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = j;
      }
      else if (j == ShadowStyleable.ViewGroup_MarginLayout_layout_marginLeft)
      {
        ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = paramView.getDimensionPixelSize(j, ((ViewGroup.MarginLayoutParams)localObject1).leftMargin);
      }
      else if (j == ShadowStyleable.ViewGroup_MarginLayout_layout_marginTop)
      {
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramView.getDimensionPixelSize(j, ((ViewGroup.MarginLayoutParams)localObject1).topMargin);
      }
      else if (j == ShadowStyleable.ViewGroup_MarginLayout_layout_marginRight)
      {
        ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = paramView.getDimensionPixelSize(j, ((ViewGroup.MarginLayoutParams)localObject1).rightMargin);
      }
      else if (j == ShadowStyleable.ViewGroup_MarginLayout_layout_marginBottom)
      {
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = paramView.getDimensionPixelSize(j, ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
      }
    }
    label373:
    paramView.recycle();
    label378:
    while (localObject1 == null) {
      return;
    }
    paramView = paramView.getContext().obtainStyledAttributes(paramInt, ShadowStyleable.ViewGroup_Layout);
    int i = paramView.getIndexCount();
    paramInt = 0;
    if (paramInt < i)
    {
      j = paramView.getIndex(paramInt);
      if (j == ShadowStyleable.ViewGroup_MarginLayout_layout_width) {
        ((ViewGroup.LayoutParams)localObject1).width = paramView.getLayoutDimension(j, ((ViewGroup.LayoutParams)localObject1).width);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if (j == ShadowStyleable.ViewGroup_MarginLayout_layout_height) {
          ((ViewGroup.LayoutParams)localObject1).height = paramView.getLayoutDimension(j, ((ViewGroup.LayoutParams)localObject1).height);
        }
      }
    }
    paramView.recycle();
  }
  
  public static void setLinearLayoutAttributes(TypedArray paramTypedArray, LinearLayout paramLinearLayout)
  {
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    if (i < j)
    {
      int k = paramTypedArray.getIndex(i);
      if (k == ShadowStyleable.LinearLayout_gravity) {
        paramLinearLayout.setGravity(paramTypedArray.getInt(k, 51));
      }
      for (;;)
      {
        i += 1;
        break;
        if (k == ShadowStyleable.LinearLayout_orientation) {
          paramLinearLayout.setOrientation(paramTypedArray.getInt(k, 0));
        } else if (k == ShadowStyleable.LinearLayout_baselineAligned) {
          paramLinearLayout.setBaselineAligned(paramTypedArray.getBoolean(k, true));
        } else if (k == ShadowStyleable.LinearLayout_baselineAlignedChildIndex) {
          paramLinearLayout.setBaselineAlignedChildIndex(paramTypedArray.getInt(k, -1));
        } else if (k == ShadowStyleable.LinearLayout_divider) {
          paramLinearLayout.setDividerDrawable(paramTypedArray.getDrawable(k));
        } else if (k == ShadowStyleable.LinearLayout_measureWithLargestChild) {
          paramLinearLayout.setMeasureWithLargestChildEnabled(paramTypedArray.getBoolean(k, false));
        } else if (k == ShadowStyleable.LinearLayout_showDividers) {
          paramLinearLayout.setShowDividers(paramTypedArray.getInt(k, 0));
        } else if (k == ShadowStyleable.LinearLayout_dividerPadding) {
          paramLinearLayout.setDividerPadding(paramTypedArray.getInt(k, 0));
        }
      }
    }
  }
  
  public static void setTextViewAttributes(TypedArray paramTypedArray, TextView paramTextView)
  {
    int m = paramTypedArray.getIndexCount();
    int i = -1;
    int k = 0;
    if (k < m)
    {
      int n = paramTypedArray.getIndex(k);
      int j;
      if (n == ShadowStyleable.TextView_textSize)
      {
        float f = paramTypedArray.getDimension(n, -1.0F);
        j = i;
        if (f != -1.0F)
        {
          j = i;
          if (f != paramTextView.getTextSize())
          {
            paramTextView.setTextSize(0, f);
            j = i;
          }
        }
      }
      for (;;)
      {
        k += 1;
        i = j;
        break;
        if (n == ShadowStyleable.TextView_ellipsize)
        {
          TextUtils.TruncateAt localTruncateAt = null;
          switch (paramTypedArray.getInt(n, -1))
          {
          }
          for (;;)
          {
            paramTextView.setEllipsize(localTruncateAt);
            j = i;
            break;
            localTruncateAt = TextUtils.TruncateAt.START;
            continue;
            localTruncateAt = TextUtils.TruncateAt.MIDDLE;
            continue;
            localTruncateAt = TextUtils.TruncateAt.END;
            continue;
            localTruncateAt = TextUtils.TruncateAt.MARQUEE;
          }
        }
        if (n == ShadowStyleable.TextView_gravity)
        {
          paramTextView.setGravity(paramTypedArray.getInt(n, -1));
          j = i;
        }
        else if (n == ShadowStyleable.TextView_lines)
        {
          j = paramTypedArray.getInt(n, -1);
        }
        else if (n == ShadowStyleable.TextView_scrollHorizontally)
        {
          paramTextView.setHorizontallyScrolling(paramTypedArray.getBoolean(n, false));
          j = i;
        }
        else if (n == ShadowStyleable.TextView_singleLine)
        {
          boolean bool = paramTypedArray.getBoolean(n, false);
          if (bool) {
            i = 1;
          }
          paramTextView.setSingleLine(bool);
          j = i;
        }
        else
        {
          j = i;
          if (n == ShadowStyleable.TextView_drawablePadding)
          {
            paramTextView.setCompoundDrawablePadding(paramTypedArray.getDimensionPixelSize(n, 0));
            j = i;
          }
        }
      }
    }
    if (i != -1) {
      paramTextView.setLines(i);
    }
  }
  
  public static void setViewAttributes(TypedArray paramTypedArray, View paramView)
  {
    int i4 = paramView.getPaddingLeft();
    int i2 = paramView.getPaddingTop();
    int i3 = paramView.getPaddingRight();
    int i5 = paramView.getPaddingBottom();
    int i6 = paramTypedArray.getIndexCount();
    int i1 = 0;
    if (i1 < i6)
    {
      int i = paramTypedArray.getIndex(i1);
      int n;
      int m;
      int k;
      int j;
      if (i == ShadowStyleable.View_background)
      {
        paramView.setBackground(paramTypedArray.getDrawable(i));
        n = i2;
        m = i3;
        k = i4;
        j = i5;
      }
      for (;;)
      {
        i1 += 1;
        i5 = j;
        i4 = k;
        i3 = m;
        i2 = n;
        break;
        if (i == ShadowStyleable.View_padding)
        {
          i = paramTypedArray.getDimensionPixelSize(i, -1);
          j = i5;
          k = i4;
          m = i3;
          n = i2;
          if (i >= 0)
          {
            j = i;
            m = i;
            n = i;
            k = i;
          }
        }
        else if (i == ShadowStyleable.View_paddingLeft)
        {
          k = paramTypedArray.getDimensionPixelSize(i, i4);
          j = i5;
          m = i3;
          n = i2;
        }
        else if (i == ShadowStyleable.View_paddingTop)
        {
          n = paramTypedArray.getDimensionPixelSize(i, i2);
          j = i5;
          k = i4;
          m = i3;
        }
        else if (i == ShadowStyleable.View_paddingRight)
        {
          m = paramTypedArray.getDimensionPixelSize(i, i3);
          j = i5;
          k = i4;
          n = i2;
        }
        else if (i == ShadowStyleable.View_paddingBottom)
        {
          j = paramTypedArray.getDimensionPixelSize(i, i5);
          k = i4;
          m = i3;
          n = i2;
        }
        else if (i == ShadowStyleable.View_clickable)
        {
          paramView.setClickable(paramTypedArray.getBoolean(i, false));
          j = i5;
          k = i4;
          m = i3;
          n = i2;
        }
        else if (i == ShadowStyleable.View_longClickable)
        {
          paramView.setLongClickable(paramTypedArray.getBoolean(i, false));
          j = i5;
          k = i4;
          m = i3;
          n = i2;
        }
        else if (i == ShadowStyleable.View_minWidth)
        {
          paramView.setMinimumWidth(paramTypedArray.getDimensionPixelSize(i, 0));
          j = i5;
          k = i4;
          m = i3;
          n = i2;
        }
        else if (i == ShadowStyleable.View_minHeight)
        {
          paramView.setMinimumHeight(paramTypedArray.getDimensionPixelSize(i, 0));
          j = i5;
          k = i4;
          m = i3;
          n = i2;
        }
        else if (i == ShadowStyleable.View_alpha)
        {
          paramView.setAlpha(paramTypedArray.getFloat(i, 1.0F));
          j = i5;
          k = i4;
          m = i3;
          n = i2;
        }
        else if (i == ShadowStyleable.View_transformPivotX)
        {
          paramView.setPivotX(paramTypedArray.getDimensionPixelOffset(i, 0));
          j = i5;
          k = i4;
          m = i3;
          n = i2;
        }
        else if (i == ShadowStyleable.View_transformPivotY)
        {
          paramView.setPivotY(paramTypedArray.getDimensionPixelOffset(i, 0));
          j = i5;
          k = i4;
          m = i3;
          n = i2;
        }
        else if (i == ShadowStyleable.View_translationX)
        {
          paramView.setTranslationX(paramTypedArray.getDimensionPixelOffset(i, 0));
          j = i5;
          k = i4;
          m = i3;
          n = i2;
        }
        else if (i == ShadowStyleable.View_translationY)
        {
          paramView.setTranslationY(paramTypedArray.getDimensionPixelOffset(i, 0));
          j = i5;
          k = i4;
          m = i3;
          n = i2;
        }
        else if (i == ShadowStyleable.View_scaleX)
        {
          paramView.setScaleX(paramTypedArray.getFloat(i, 1.0F));
          j = i5;
          k = i4;
          m = i3;
          n = i2;
        }
        else if (i == ShadowStyleable.View_scaleY)
        {
          paramView.setScaleY(paramTypedArray.getFloat(i, 1.0F));
          j = i5;
          k = i4;
          m = i3;
          n = i2;
        }
        else if (i == ShadowStyleable.View_rotation)
        {
          paramView.setRotation(paramTypedArray.getFloat(i, 0.0F));
          j = i5;
          k = i4;
          m = i3;
          n = i2;
        }
        else if (i == ShadowStyleable.View_rotationX)
        {
          paramView.setRotationX(paramTypedArray.getFloat(i, 0.0F));
          j = i5;
          k = i4;
          m = i3;
          n = i2;
        }
        else
        {
          j = i5;
          k = i4;
          m = i3;
          n = i2;
          if (i == ShadowStyleable.View_rotationY)
          {
            paramView.setRotationY(paramTypedArray.getFloat(i, 0.0F));
            j = i5;
            k = i4;
            m = i3;
            n = i2;
          }
        }
      }
    }
    paramView.setPadding(Math.max(0, i4), Math.max(0, i2), Math.max(0, i3), Math.max(0, i5));
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/RotateHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */