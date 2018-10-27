package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ac;
import android.support.v4.view.k;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class dj
  extends ViewGroup
{
  public static final int HORIZONTAL = 0;
  public static final int INDEX_BOTTOM = 2;
  public static final int INDEX_CENTER_VERTICAL = 0;
  public static final int INDEX_FILL = 3;
  public static final int INDEX_TOP = 1;
  public static final int SHOW_DIVIDER_BEGINNING = 1;
  public static final int SHOW_DIVIDER_END = 4;
  public static final int SHOW_DIVIDER_MIDDLE = 2;
  public static final int SHOW_DIVIDER_NONE = 0;
  public static final int VERTICAL = 1;
  public static final int VERTICAL_GRAVITY_COUNT = 4;
  public boolean mBaselineAligned = true;
  public int mBaselineAlignedChildIndex = -1;
  public int mBaselineChildTop = 0;
  public Drawable mDivider;
  public int mDividerHeight;
  public int mDividerPadding;
  public int mDividerWidth;
  public int mGravity = 8388659;
  public int[] mMaxAscent;
  public int[] mMaxDescent;
  public int mOrientation;
  public int mShowDividers;
  public int mTotalLength;
  public boolean mUseLargestChild;
  public float mWeightSum;
  
  public dj(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public dj(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public dj(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = hf.a(paramContext, paramAttributeSet, a.aZ, paramInt, 0);
    paramInt = paramContext.a(a.bg, -1);
    if (paramInt >= 0) {
      setOrientation(paramInt);
    }
    paramInt = paramContext.a(a.bf, -1);
    if (paramInt >= 0) {
      setGravity(paramInt);
    }
    boolean bool = paramContext.a(a.bd, true);
    if (!bool) {
      setBaselineAligned(bool);
    }
    this.mWeightSum = paramContext.a(a.bh, -1.0F);
    this.mBaselineAlignedChildIndex = paramContext.a(a.be, -1);
    this.mUseLargestChild = paramContext.a(a.bk, false);
    setDividerDrawable(paramContext.a(a.bi));
    this.mShowDividers = paramContext.a(a.bl, 0);
    this.mDividerPadding = paramContext.e(a.bj, 0);
    paramContext.c.recycle();
  }
  
  private void forceUniformHeight(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
    int i = 0;
    while (i < paramInt1)
    {
      View localView = getVirtualChildAt(i);
      if (localView.getVisibility() != 8)
      {
        dk localdk = (dk)localView.getLayoutParams();
        if (localdk.height == -1)
        {
          int k = localdk.width;
          localdk.width = localView.getMeasuredWidth();
          measureChildWithMargins(localView, paramInt2, 0, j, 0);
          localdk.width = k;
        }
      }
      i += 1;
    }
  }
  
  private void forceUniformWidth(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    int i = 0;
    while (i < paramInt1)
    {
      View localView = getVirtualChildAt(i);
      if (localView.getVisibility() != 8)
      {
        dk localdk = (dk)localView.getLayoutParams();
        if (localdk.width == -1)
        {
          int k = localdk.height;
          localdk.height = localView.getMeasuredHeight();
          measureChildWithMargins(localView, j, 0, paramInt2, 0);
          localdk.height = k;
        }
      }
      i += 1;
    }
  }
  
  private void setChildFrame(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof dk;
  }
  
  void drawDividersHorizontal(Canvas paramCanvas)
  {
    int k = getVirtualChildCount();
    boolean bool = id.a(this);
    int i = 0;
    View localView;
    dk localdk;
    if (i < k)
    {
      localView = getVirtualChildAt(i);
      if (localView == null) {}
      while ((localView.getVisibility() == 8) || (!hasDividerBeforeChildAt(i)))
      {
        i += 1;
        break;
      }
      localdk = (dk)localView.getLayoutParams();
      if (bool) {
        j = localView.getRight();
      }
      for (int j = localdk.rightMargin + j;; j = localView.getLeft() - localdk.leftMargin - this.mDividerWidth)
      {
        drawVerticalDivider(paramCanvas, j);
        break;
      }
    }
    if (hasDividerBeforeChildAt(k))
    {
      localView = getVirtualChildAt(k - 1);
      if (localView == null) {
        break label195;
      }
      localdk = (dk)localView.getLayoutParams();
      if (!bool) {
        break label178;
      }
      i = localView.getLeft() - localdk.leftMargin - this.mDividerWidth;
    }
    for (;;)
    {
      drawVerticalDivider(paramCanvas, i);
      return;
      label178:
      i = localView.getRight();
      i = localdk.rightMargin + i;
      continue;
      label195:
      if (!bool) {
        i = getWidth() - getPaddingRight() - this.mDividerWidth;
      } else {
        i = getPaddingLeft();
      }
    }
  }
  
  void drawDividersVertical(Canvas paramCanvas)
  {
    int j = getVirtualChildCount();
    int i = 0;
    View localView;
    dk localdk;
    if (i < j)
    {
      localView = getVirtualChildAt(i);
      if (localView == null) {}
      for (;;)
      {
        i += 1;
        break;
        if ((localView.getVisibility() != 8) && (hasDividerBeforeChildAt(i)))
        {
          localdk = (dk)localView.getLayoutParams();
          drawHorizontalDivider(paramCanvas, localView.getTop() - localdk.topMargin - this.mDividerHeight);
        }
      }
    }
    if (hasDividerBeforeChildAt(j))
    {
      localView = getVirtualChildAt(j - 1);
      if (localView != null) {
        break label127;
      }
    }
    for (i = getHeight() - getPaddingBottom() - this.mDividerHeight;; i = localdk.bottomMargin + i)
    {
      drawHorizontalDivider(paramCanvas, i);
      return;
      label127:
      localdk = (dk)localView.getLayoutParams();
      i = localView.getBottom();
    }
  }
  
  void drawHorizontalDivider(Canvas paramCanvas, int paramInt)
  {
    this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, paramInt, getWidth() - getPaddingRight() - this.mDividerPadding, this.mDividerHeight + paramInt);
    this.mDivider.draw(paramCanvas);
  }
  
  void drawVerticalDivider(Canvas paramCanvas, int paramInt)
  {
    this.mDivider.setBounds(paramInt, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + paramInt, getHeight() - getPaddingBottom() - this.mDividerPadding);
    this.mDivider.draw(paramCanvas);
  }
  
  protected dk generateDefaultLayoutParams()
  {
    int i = this.mOrientation;
    if (i == 0) {
      return new dk(-2);
    }
    if (i == 1) {
      return new dk(-1);
    }
    return null;
  }
  
  public dk generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new dk(getContext(), paramAttributeSet);
  }
  
  protected dk generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new dk(paramLayoutParams);
  }
  
  public int getBaseline()
  {
    int i = -1;
    if (this.mBaselineAlignedChildIndex < 0) {
      i = super.getBaseline();
    }
    int j;
    int k;
    View localView;
    do
    {
      return i;
      j = getChildCount();
      k = this.mBaselineAlignedChildIndex;
      if (j <= k) {
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
      }
      localView = getChildAt(k);
      j = localView.getBaseline();
      if (j != -1) {
        break;
      }
    } while (this.mBaselineAlignedChildIndex == 0);
    throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
    i = this.mBaselineChildTop;
    if (this.mOrientation == 1)
    {
      k = this.mGravity & 0x70;
      if (k != 48) {}
    }
    for (;;)
    {
      return ((dk)localView.getLayoutParams()).topMargin + i + j;
      switch (k)
      {
      default: 
        break;
      case 16: 
        i += (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - this.mTotalLength) / 2;
        break;
      case 80: 
        i = getBottom() - getTop() - getPaddingBottom() - this.mTotalLength;
      }
    }
  }
  
  public int getBaselineAlignedChildIndex()
  {
    return this.mBaselineAlignedChildIndex;
  }
  
  int getChildrenSkipCount(View paramView, int paramInt)
  {
    return 0;
  }
  
  public Drawable getDividerDrawable()
  {
    return this.mDivider;
  }
  
  public int getDividerPadding()
  {
    return this.mDividerPadding;
  }
  
  public int getDividerWidth()
  {
    return this.mDividerWidth;
  }
  
  public int getGravity()
  {
    return this.mGravity;
  }
  
  int getLocationOffset(View paramView)
  {
    return 0;
  }
  
  int getNextLocationOffset(View paramView)
  {
    return 0;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public int getShowDividers()
  {
    return this.mShowDividers;
  }
  
  View getVirtualChildAt(int paramInt)
  {
    return getChildAt(paramInt);
  }
  
  int getVirtualChildCount()
  {
    return getChildCount();
  }
  
  public float getWeightSum()
  {
    return this.mWeightSum;
  }
  
  protected boolean hasDividerBeforeChildAt(int paramInt)
  {
    int j = 1;
    int i;
    if (paramInt == 0) {
      i = (byte)(this.mShowDividers & 0x1);
    }
    do
    {
      return i;
      if (paramInt != getChildCount()) {
        break;
      }
      i = j;
    } while ((this.mShowDividers & 0x4) != 0);
    return false;
    if ((this.mShowDividers & 0x2) != 0)
    {
      paramInt -= 1;
      for (;;)
      {
        if (paramInt < 0) {
          break label76;
        }
        i = j;
        if (getChildAt(paramInt).getVisibility() != 8) {
          break;
        }
        paramInt -= 1;
      }
      label76:
      return false;
    }
    return false;
  }
  
  public boolean isBaselineAligned()
  {
    return this.mBaselineAligned;
  }
  
  public boolean isMeasureWithLargestChildEnabled()
  {
    return this.mUseLargestChild;
  }
  
  void layoutHorizontal(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = id.a(this);
    int k = getPaddingTop();
    int n = paramInt4 - paramInt2;
    int i1 = getPaddingBottom();
    int i2 = getPaddingBottom();
    int i3 = getVirtualChildCount();
    int i4 = this.mGravity;
    boolean bool2 = this.mBaselineAligned;
    int[] arrayOfInt1 = this.mMaxAscent;
    int[] arrayOfInt2 = this.mMaxDescent;
    switch (k.a(i4 & 0x800007, ac.h(this)))
    {
    default: 
      paramInt3 = getPaddingLeft();
    }
    for (;;)
    {
      int i;
      if (bool1) {
        i = -1;
      }
      for (int j = i3 - 1;; j = 0)
      {
        paramInt2 = 0;
        if (paramInt2 >= i3) {
          break;
        }
        int i6 = j + i * paramInt2;
        View localView = getVirtualChildAt(i6);
        if (localView == null) {
          paramInt1 = measureNullChild(i6) + paramInt3;
        }
        for (;;)
        {
          paramInt2 += 1;
          paramInt3 = paramInt1;
          break;
          if (localView.getVisibility() != 8)
          {
            int i5 = localView.getMeasuredWidth();
            int i7 = localView.getMeasuredHeight();
            dk localdk = (dk)localView.getLayoutParams();
            if (bool2) {
              if (localdk.height != -1) {
                paramInt4 = localView.getBaseline();
              }
            }
            for (;;)
            {
              int m = localdk.g;
              paramInt1 = m;
              if (m < 0) {
                paramInt1 = i4 & 0x70;
              }
              switch (paramInt1 & 0x70)
              {
              default: 
                paramInt1 = k;
              }
              for (;;)
              {
                paramInt4 = paramInt3;
                if (hasDividerBeforeChildAt(i6)) {
                  paramInt4 = paramInt3 + this.mDividerWidth;
                }
                paramInt3 = paramInt4 + localdk.leftMargin;
                setChildFrame(localView, paramInt3 + getLocationOffset(localView), paramInt1, i5, i7);
                paramInt1 = localdk.rightMargin;
                paramInt4 = getNextLocationOffset(localView);
                paramInt2 = getChildrenSkipCount(localView, i6) + paramInt2;
                paramInt1 = paramInt3 + (paramInt1 + i5 + paramInt4);
                break;
                paramInt1 = (n - k - i2 - i7) / 2 + k + localdk.topMargin - localdk.bottomMargin;
                continue;
                m = n - i1 - i7 - localdk.bottomMargin;
                paramInt1 = m;
                if (paramInt4 != -1)
                {
                  paramInt1 = localView.getMeasuredHeight();
                  paramInt1 = m - (arrayOfInt2[2] - (paramInt1 - paramInt4));
                  continue;
                  m = localdk.topMargin + k;
                  paramInt1 = m;
                  if (paramInt4 != -1) {
                    paramInt1 = m + (arrayOfInt1[1] - paramInt4);
                  }
                }
              }
              paramInt4 = -1;
              continue;
              paramInt4 = -1;
            }
          }
          paramInt1 = paramInt3;
        }
        i = 1;
      }
      paramInt3 = getPaddingLeft() + paramInt3 - paramInt1 - this.mTotalLength;
      continue;
      paramInt2 = getPaddingLeft();
      paramInt3 = (paramInt3 - paramInt1 - this.mTotalLength) / 2 + paramInt2;
    }
  }
  
  void layoutVertical(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    int j = paramInt3 - paramInt1;
    int k = getPaddingRight();
    int m = getPaddingRight();
    int n = getVirtualChildCount();
    int i1 = this.mGravity;
    switch (i1 & 0x70)
    {
    default: 
      paramInt1 = getPaddingTop();
    }
    for (;;)
    {
      paramInt3 = 0;
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      if (paramInt1 >= n) {
        break;
      }
      View localView = getVirtualChildAt(paramInt1);
      if (localView == null)
      {
        paramInt3 = measureNullChild(paramInt1) + paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
      }
      for (;;)
      {
        paramInt3 = paramInt2 + 1;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
        if (localView.getVisibility() != 8)
        {
          int i3 = localView.getMeasuredWidth();
          int i2 = localView.getMeasuredHeight();
          dk localdk = (dk)localView.getLayoutParams();
          paramInt4 = localdk.g;
          paramInt3 = paramInt4;
          if (paramInt4 < 0) {
            paramInt3 = i1 & 0x800007;
          }
          switch (k.a(paramInt3, ac.h(this)) & 0x7)
          {
          default: 
            paramInt3 = i + localdk.leftMargin;
          }
          for (;;)
          {
            paramInt4 = paramInt2;
            if (hasDividerBeforeChildAt(paramInt1)) {
              paramInt4 = paramInt2 + this.mDividerHeight;
            }
            paramInt4 += localdk.topMargin;
            setChildFrame(localView, paramInt3, paramInt4 + getLocationOffset(localView), i3, i2);
            paramInt3 = localdk.bottomMargin;
            i3 = getNextLocationOffset(localView);
            paramInt2 = getChildrenSkipCount(localView, paramInt1) + paramInt1;
            paramInt1 = paramInt4 + (paramInt3 + i2 + i3);
            break;
            paramInt3 = j - k - i3 - localdk.rightMargin;
            continue;
            paramInt3 = (j - i - m - i3) / 2 + i + localdk.leftMargin - localdk.rightMargin;
          }
        }
        paramInt3 = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
      }
      paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - this.mTotalLength;
      continue;
      paramInt1 = getPaddingTop() + (paramInt4 - paramInt2 - this.mTotalLength) / 2;
    }
  }
  
  void measureChildBeforeLayout(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    measureChildWithMargins(paramView, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  void measureHorizontal(int paramInt1, int paramInt2)
  {
    this.mTotalLength = 0;
    int i11 = getVirtualChildCount();
    int i13 = View.MeasureSpec.getMode(paramInt1);
    int i12 = View.MeasureSpec.getMode(paramInt2);
    if ((this.mMaxAscent == null) || (this.mMaxDescent == null))
    {
      this.mMaxAscent = new int[4];
      this.mMaxDescent = new int[4];
    }
    Object localObject = this.mMaxAscent;
    int[] arrayOfInt = this.mMaxDescent;
    localObject[3] = -1;
    localObject[2] = -1;
    localObject[1] = -1;
    localObject[0] = -1;
    arrayOfInt[3] = -1;
    arrayOfInt[2] = -1;
    arrayOfInt[1] = -1;
    arrayOfInt[0] = -1;
    boolean bool1 = this.mBaselineAligned;
    boolean bool2 = this.mUseLargestChild;
    if (i13 == 1073741824) {}
    for (int i6 = 1;; i6 = 0)
    {
      int i1 = 0;
      int n = 0;
      int i3 = 0;
      int i4 = 0;
      int m = 1;
      float f1 = 0.0F;
      int k = 0;
      int i = 0;
      int j = 0;
      int i2 = 0;
      View localView;
      int i5;
      int i7;
      label264:
      dk localdk;
      int i8;
      if (i2 < i11)
      {
        localView = getVirtualChildAt(i2);
        if (localView == null)
        {
          this.mTotalLength += measureNullChild(i2);
          i5 = j;
          j = i;
          i = i5;
        }
        for (;;)
        {
          i5 = j;
          i2 += 1;
          j = i;
          i = i5;
          break;
          if (localView.getVisibility() != 8) {
            break label264;
          }
          i7 = getChildrenSkipCount(localView, i2);
          i5 = i;
          i2 += i7;
          i = j;
          j = i5;
        }
        if (hasDividerBeforeChildAt(i2)) {
          this.mTotalLength += this.mDividerWidth;
        }
        localdk = (dk)localView.getLayoutParams();
        f1 += localdk.h;
        if ((i13 != 1073741824) || (localdk.width != 0) || (localdk.h <= 0.0F))
        {
          if (localdk.width == 0) {
            if (localdk.h > 0.0F)
            {
              localdk.width = -2;
              i5 = 0;
            }
          }
          for (;;)
          {
            if (f1 == 0.0F) {}
            for (i7 = this.mTotalLength;; i7 = 0)
            {
              measureChildBeforeLayout(localView, i2, paramInt1, i7, paramInt2, 0);
              if (i5 != Integer.MIN_VALUE) {
                localdk.width = i5;
              }
              i5 = localView.getMeasuredWidth();
              if (i6 != 0) {}
              for (this.mTotalLength += localdk.leftMargin + i5 + localdk.rightMargin + getNextLocationOffset(localView);; this.mTotalLength = Math.max(i7, i7 + i5 + localdk.leftMargin + localdk.rightMargin + getNextLocationOffset(localView)))
              {
                if (bool2)
                {
                  i5 = Math.max(i5, j);
                  j = i;
                  i = i5;
                }
                for (;;)
                {
                  if (i12 == 1073741824) {
                    i5 = 0;
                  }
                  for (;;)
                  {
                    i7 = localdk.topMargin + localdk.bottomMargin;
                    i8 = localView.getMeasuredHeight() + i7;
                    int i9 = View.combineMeasuredStates(n, localView.getMeasuredState());
                    if (bool1)
                    {
                      int i14 = localView.getBaseline();
                      if (i14 != -1)
                      {
                        i10 = localdk.g;
                        n = i10;
                        if (i10 < 0) {
                          n = this.mGravity;
                        }
                        n = ((n & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
                        localObject[n] = Math.max(localObject[n], i14);
                        arrayOfInt[n] = Math.max(arrayOfInt[n], i8 - i14);
                      }
                    }
                    int i10 = Math.max(i1, i8);
                    if (m != 0) {
                      if (localdk.height == -1) {
                        m = 1;
                      }
                    }
                    for (;;)
                    {
                      if (localdk.h <= 0.0F)
                      {
                        if (i5 == 0) {}
                        for (;;)
                        {
                          n = Math.max(i3, i8);
                          i1 = i4;
                          i5 = getChildrenSkipCount(localView, i2);
                          i4 = i1;
                          i3 = n;
                          i2 += i5;
                          i1 = i10;
                          n = i9;
                          break;
                          i8 = i7;
                        }
                      }
                      if (i5 == 0) {}
                      for (;;)
                      {
                        i1 = Math.max(i4, i8);
                        n = i3;
                        break;
                        i8 = i7;
                      }
                      m = 0;
                      continue;
                      m = 0;
                    }
                    if (localdk.height == -1)
                    {
                      k = 1;
                      i5 = 1;
                    }
                    else
                    {
                      i5 = 0;
                    }
                  }
                  i5 = i;
                  i = j;
                  j = i5;
                }
                i7 = this.mTotalLength;
              }
            }
            i5 = Integer.MIN_VALUE;
            continue;
            i5 = Integer.MIN_VALUE;
          }
        }
        if (i6 == 0) {
          i5 = this.mTotalLength;
        }
        for (this.mTotalLength = Math.max(i5, localdk.leftMargin + i5 + localdk.rightMargin);; this.mTotalLength += localdk.leftMargin + localdk.rightMargin)
        {
          if (bool1)
          {
            i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
            localView.measure(i5, i5);
            i5 = i;
            i = j;
            j = i5;
            break;
          }
          i = j;
          j = 1;
          break;
        }
      }
      if ((this.mTotalLength > 0) && (hasDividerBeforeChildAt(i11))) {
        this.mTotalLength += this.mDividerWidth;
      }
      i2 = localObject[1];
      if ((i2 != -1) || (localObject[0] != -1) || (localObject[2] != -1) || (localObject[3] != -1)) {
        i1 = Math.max(i1, Math.max(localObject[3], Math.max(localObject[0], Math.max(i2, localObject[2]))) + Math.max(arrayOfInt[3], Math.max(arrayOfInt[0], Math.max(arrayOfInt[1], arrayOfInt[2]))));
      }
      for (;;)
      {
        if (!bool2)
        {
          this.mTotalLength += getPaddingLeft() + getPaddingRight();
          i7 = View.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumWidth()), paramInt1, 0);
          i2 = (0xFFFFFF & i7) - this.mTotalLength;
          if (i != 0)
          {
            float f2 = this.mWeightSum;
            if (f2 <= 0.0F) {}
            for (;;)
            {
              localObject[3] = -1;
              localObject[2] = -1;
              localObject[1] = -1;
              localObject[0] = -1;
              arrayOfInt[3] = -1;
              arrayOfInt[2] = -1;
              arrayOfInt[1] = -1;
              arrayOfInt[0] = -1;
              this.mTotalLength = 0;
              i1 = -1;
              i4 = 0;
              j = m;
              m = i3;
              i = n;
              n = i1;
              i3 = i2;
              if (i4 >= i11)
              {
                this.mTotalLength += getPaddingLeft() + getPaddingRight();
                i2 = localObject[1];
                if ((i2 == -1) && (localObject[0] == -1) && (localObject[2] == -1))
                {
                  i1 = n;
                  if (localObject[3] == -1) {}
                }
                else
                {
                  i1 = Math.max(n, Math.max(localObject[3], Math.max(localObject[0], Math.max(i2, localObject[2]))) + Math.max(arrayOfInt[3], Math.max(arrayOfInt[0], Math.max(arrayOfInt[1], arrayOfInt[2]))));
                }
                i2 = j;
                j = m;
                n = i;
                i = i1;
                m = i2;
                label1341:
                if (m != 0) {
                  j = i;
                }
                for (;;)
                {
                  setMeasuredDimension(0xFF000000 & n | i7, View.resolveSizeAndState(Math.max(j + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), paramInt2, n << 16));
                  if (k != 0) {
                    forceUniformHeight(i11, paramInt1);
                  }
                  return;
                  if (i12 == 1073741824) {
                    j = i;
                  }
                }
              }
              localView = getVirtualChildAt(i4);
              if (localView == null)
              {
                i2 = m;
                m = i3;
                i1 = j;
                j = i;
                i = i2;
              }
              for (;;)
              {
                i4 += 1;
                i3 = m;
                m = i;
                i = j;
                j = i1;
                break;
                if (localView.getVisibility() != 8)
                {
                  localdk = (dk)localView.getLayoutParams();
                  float f3 = localdk.h;
                  f2 = f1;
                  i2 = i;
                  i1 = i3;
                  if (f3 > 0.0F)
                  {
                    i1 = (int)(i3 * f3 / f1);
                    i2 = i3 - i1;
                    i5 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom() + localdk.topMargin + localdk.bottomMargin, localdk.height);
                    if (localdk.width == 0) {
                      break label2014;
                    }
                  }
                  label2014:
                  while (i13 != 1073741824)
                  {
                    i3 = localView.getMeasuredWidth() + i1;
                    i1 = i3;
                    if (i3 < 0) {
                      i1 = 0;
                    }
                    localView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), i5);
                    i = View.combineMeasuredStates(i, localView.getMeasuredState() & 0xFF000000);
                    f2 = f1 - f3;
                    i1 = i2;
                    i2 = i;
                    if (i6 == 0) {
                      i = this.mTotalLength;
                    }
                    for (this.mTotalLength = Math.max(i, localView.getMeasuredWidth() + i + localdk.leftMargin + localdk.rightMargin + getNextLocationOffset(localView));; this.mTotalLength += localView.getMeasuredWidth() + localdk.leftMargin + localdk.rightMargin + getNextLocationOffset(localView))
                    {
                      if (i12 != 1073741824) {
                        if (localdk.height == -1) {
                          i = 1;
                        }
                      }
                      for (;;)
                      {
                        i3 = localdk.topMargin;
                        i5 = localdk.bottomMargin + i3;
                        i3 = localView.getMeasuredHeight() + i5;
                        n = Math.max(n, i3);
                        if (i == 0) {}
                        for (i = i3;; i = i5)
                        {
                          m = Math.max(m, i);
                          if (j != 0) {
                            if (localdk.height == -1) {
                              i = 1;
                            }
                          }
                          for (;;)
                          {
                            if (!bool1)
                            {
                              f1 = f2;
                              j = i2;
                              i2 = i;
                              i = m;
                              m = i1;
                              i1 = i2;
                              break;
                            }
                            i8 = localView.getBaseline();
                            if (i8 == -1)
                            {
                              f1 = f2;
                              j = i2;
                              i2 = i;
                              i = m;
                              m = i1;
                              i1 = i2;
                              break;
                            }
                            i5 = localdk.g;
                            j = i5;
                            if (i5 < 0) {
                              j = this.mGravity;
                            }
                            j = ((j & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
                            localObject[j] = Math.max(localObject[j], i8);
                            arrayOfInt[j] = Math.max(arrayOfInt[j], i3 - i8);
                            f1 = f2;
                            j = i2;
                            i2 = i;
                            i = m;
                            m = i1;
                            i1 = i2;
                            break;
                            i = 0;
                            continue;
                            i = 0;
                          }
                        }
                        i = 0;
                        continue;
                        i = 0;
                      }
                    }
                  }
                  if (i1 > 0) {}
                  for (;;)
                  {
                    localView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), i5);
                    break;
                    i1 = 0;
                  }
                }
                i1 = i;
                i2 = j;
                i = m;
                j = i1;
                m = i3;
                i1 = i2;
              }
              f1 = f2;
            }
          }
          if (i2 == 0) {}
          for (;;)
          {
            i = Math.max(i3, i4);
            if (!bool2)
            {
              j = i;
              i = i1;
              break label1341;
            }
            if (i13 == 1073741824)
            {
              j = i;
              i = i1;
              break label1341;
            }
            i2 = 0;
            if (i2 >= i11)
            {
              j = i;
              i = i1;
              break label1341;
            }
            localObject = getVirtualChildAt(i2);
            if (localObject == null) {}
            for (;;)
            {
              i2 += 1;
              break;
              if ((((View)localObject).getVisibility() != 8) && (((dk)((View)localObject).getLayoutParams()).h > 0.0F)) {
                ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(j, 1073741824), View.MeasureSpec.makeMeasureSpec(((View)localObject).getMeasuredHeight(), 1073741824));
              }
            }
            if (f1 > 0.0F) {
              break;
            }
          }
        }
        if (i13 == Integer.MIN_VALUE) {}
        for (;;)
        {
          this.mTotalLength = 0;
          i2 = 0;
          label2249:
          if (i2 < i11)
          {
            localView = getVirtualChildAt(i2);
            if (localView != null) {
              break label2293;
            }
            this.mTotalLength += measureNullChild(i2);
          }
          for (;;)
          {
            i2 += 1;
            break label2249;
            break;
            label2293:
            if (localView.getVisibility() == 8)
            {
              i2 = getChildrenSkipCount(localView, i2) + i2;
            }
            else
            {
              localdk = (dk)localView.getLayoutParams();
              if (i6 != 0)
              {
                i5 = this.mTotalLength;
                i7 = localdk.leftMargin;
                this.mTotalLength = (localdk.rightMargin + (i7 + j) + getNextLocationOffset(localView) + i5);
              }
              else
              {
                i5 = this.mTotalLength;
                i7 = localdk.leftMargin;
                this.mTotalLength = Math.max(i5, localdk.rightMargin + (i5 + j + i7) + getNextLocationOffset(localView));
              }
            }
          }
          if (i13 != 0) {
            break;
          }
        }
      }
    }
  }
  
  int measureNullChild(int paramInt)
  {
    return 0;
  }
  
  void measureVertical(int paramInt1, int paramInt2)
  {
    this.mTotalLength = 0;
    int i10 = getVirtualChildCount();
    int i11 = View.MeasureSpec.getMode(paramInt1);
    int i12 = View.MeasureSpec.getMode(paramInt2);
    int i13 = this.mBaselineAlignedChildIndex;
    boolean bool = this.mUseLargestChild;
    int i = 0;
    int j = 0;
    int i2 = 0;
    int i4 = 0;
    int k = 1;
    float f1 = 0.0F;
    int i1 = 0;
    int n = 0;
    int m = 0;
    int i3 = 0;
    View localView;
    int i5;
    int i6;
    label190:
    dk localdk;
    int i7;
    if (i3 < i10)
    {
      localView = getVirtualChildAt(i3);
      if (localView == null)
      {
        this.mTotalLength += measureNullChild(i3);
        i5 = m;
        m = n;
        n = k;
        k = i5;
      }
      for (;;)
      {
        i5 = m;
        i6 = n;
        i3 += 1;
        m = k;
        n = i5;
        k = i6;
        break;
        if (localView.getVisibility() != 8) {
          break label190;
        }
        i6 = getChildrenSkipCount(localView, i3);
        i5 = n;
        n = k;
        i3 += i6;
        k = m;
        m = i5;
      }
      if (hasDividerBeforeChildAt(i3)) {
        this.mTotalLength += this.mDividerHeight;
      }
      localdk = (dk)localView.getLayoutParams();
      f1 += localdk.h;
      if ((i12 == 1073741824) && (localdk.height == 0) && (localdk.h > 0.0F))
      {
        n = this.mTotalLength;
        this.mTotalLength = Math.max(n, localdk.topMargin + n + localdk.bottomMargin);
        i6 = 1;
        i5 = m;
        if ((i13 >= 0) && (i13 == i3 + 1)) {
          this.mBaselineChildTop = this.mTotalLength;
        }
        if ((i3 < i13) && (localdk.h > 0.0F)) {
          throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
        }
        if (i11 == 1073741824)
        {
          n = 0;
          m = i1;
        }
        for (;;)
        {
          i1 = localdk.leftMargin + localdk.rightMargin;
          i7 = localView.getMeasuredWidth() + i1;
          int i8 = Math.max(i, i7);
          int i9 = View.combineMeasuredStates(j, localView.getMeasuredState());
          if (k != 0) {
            if (localdk.width == -1) {
              i = 1;
            }
          }
          for (;;)
          {
            if (localdk.h <= 0.0F)
            {
              if (n == 0) {}
              for (;;)
              {
                j = Math.max(i2, i7);
                k = i4;
                n = getChildrenSkipCount(localView, i3);
                i4 = k;
                i2 = j;
                i7 = i3 + n;
                j = i9;
                i3 = i8;
                i1 = m;
                k = i5;
                m = i6;
                n = i;
                i = i3;
                i3 = i7;
                break;
                i7 = i1;
              }
            }
            if (n == 0) {}
            for (;;)
            {
              k = Math.max(i4, i7);
              j = i2;
              break;
              i7 = i1;
            }
            i = 0;
            continue;
            i = 0;
          }
          if (localdk.width == -1)
          {
            n = 1;
            m = 1;
          }
          else
          {
            n = 0;
            m = i1;
          }
        }
      }
      if (localdk.height == 0) {
        if (localdk.h > 0.0F)
        {
          localdk.height = -2;
          i5 = 0;
        }
      }
      for (;;)
      {
        if (f1 == 0.0F) {}
        for (i6 = this.mTotalLength;; i6 = 0)
        {
          measureChildBeforeLayout(localView, i3, paramInt1, 0, paramInt2, i6);
          if (i5 != Integer.MIN_VALUE) {
            localdk.height = i5;
          }
          i7 = localView.getMeasuredHeight();
          i5 = this.mTotalLength;
          this.mTotalLength = Math.max(i5, i5 + i7 + localdk.topMargin + localdk.bottomMargin + getNextLocationOffset(localView));
          i5 = m;
          i6 = n;
          if (!bool) {
            break;
          }
          i5 = Math.max(i7, m);
          i6 = n;
          break;
        }
        i5 = Integer.MIN_VALUE;
        continue;
        i5 = Integer.MIN_VALUE;
      }
    }
    if ((this.mTotalLength > 0) && (hasDividerBeforeChildAt(i10))) {
      this.mTotalLength += this.mDividerHeight;
    }
    if (!bool)
    {
      this.mTotalLength += getPaddingTop() + getPaddingBottom();
      i6 = View.resolveSizeAndState(Math.max(this.mTotalLength, getSuggestedMinimumHeight()), paramInt2, 0);
      i3 = (0xFFFFFF & i6) - this.mTotalLength;
      if (n != 0)
      {
        float f2 = this.mWeightSum;
        if (f2 <= 0.0F) {}
        for (;;)
        {
          this.mTotalLength = 0;
          m = k;
          k = i2;
          i2 = i;
          n = i3;
          i3 = 0;
          i = j;
          j = i2;
          if (i3 >= i10)
          {
            this.mTotalLength += getPaddingTop() + getPaddingBottom();
            n = i;
            i = j;
            j = n;
            n = m;
            m = k;
            label922:
            if (n != 0) {
              m = i;
            }
            for (;;)
            {
              setMeasuredDimension(View.resolveSizeAndState(Math.max(m + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), paramInt1, j), i6);
              if (i1 != 0) {
                forceUniformWidth(i10, paramInt2);
              }
              return;
              if (i11 == 1073741824) {
                m = i;
              }
            }
          }
          localView = getVirtualChildAt(i3);
          if (localView.getVisibility() != 8)
          {
            localdk = (dk)localView.getLayoutParams();
            f2 = localdk.h;
            if (f2 > 0.0F)
            {
              i4 = (int)(n * f2 / f1);
              i7 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localdk.leftMargin + localdk.rightMargin, localdk.width);
              if (localdk.height != 0)
              {
                label1082:
                i5 = i4 + localView.getMeasuredHeight();
                i2 = i5;
                if (i5 < 0) {
                  i2 = 0;
                }
                localView.measure(i7, View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
                i2 = View.combineMeasuredStates(i, localView.getMeasuredState() & 0xFF00);
                n -= i4;
                f1 -= f2;
                label1146:
                i = localdk.leftMargin;
                i4 = localdk.rightMargin + i;
                i5 = localView.getMeasuredWidth() + i4;
                j = Math.max(j, i5);
                i = i5;
                if (i11 != 1073741824)
                {
                  if (localdk.width != -1) {
                    i = i5;
                  }
                }
                else
                {
                  label1206:
                  k = Math.max(k, i);
                  if (m != 0) {
                    if (localdk.width == -1)
                    {
                      i = 1;
                      label1232:
                      m = this.mTotalLength;
                      i4 = localView.getMeasuredHeight();
                      i5 = localdk.topMargin;
                      this.mTotalLength = Math.max(m, localdk.bottomMargin + (i4 + m + i5) + getNextLocationOffset(localView));
                    }
                  }
                }
              }
            }
          }
          for (;;)
          {
            i3 += 1;
            m = i;
            i = i2;
            break;
            i = 0;
            break label1232;
            i = 0;
            break label1232;
            i = i4;
            break label1206;
            if (i12 != 1073741824) {
              break label1082;
            }
            if (i4 > 0) {}
            for (i2 = i4;; i2 = 0)
            {
              localView.measure(i7, View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
              break;
            }
            i2 = i;
            break label1146;
            i2 = i;
            i = m;
          }
          f1 = f2;
        }
      }
      if (i3 == 0) {}
      for (;;)
      {
        n = Math.max(i2, i4);
        if (!bool)
        {
          m = n;
          n = k;
          break label922;
        }
        if (i12 == 1073741824)
        {
          m = n;
          n = k;
          break label922;
        }
        i2 = 0;
        if (i2 >= i10)
        {
          m = n;
          n = k;
          break label922;
        }
        localView = getVirtualChildAt(i2);
        if (localView == null) {}
        for (;;)
        {
          i2 += 1;
          break;
          if ((localView.getVisibility() != 8) && (((dk)localView.getLayoutParams()).h > 0.0F)) {
            localView.measure(View.MeasureSpec.makeMeasureSpec(localView.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(m, 1073741824));
          }
        }
        if (f1 > 0.0F) {
          break;
        }
      }
    }
    if (i12 == Integer.MIN_VALUE) {}
    for (;;)
    {
      this.mTotalLength = 0;
      i3 = 0;
      label1548:
      if (i3 < i10)
      {
        localView = getVirtualChildAt(i3);
        if (localView != null) {
          break label1592;
        }
        this.mTotalLength += measureNullChild(i3);
      }
      for (;;)
      {
        i3 += 1;
        break label1548;
        break;
        label1592:
        if (localView.getVisibility() == 8)
        {
          i3 = getChildrenSkipCount(localView, i3) + i3;
        }
        else
        {
          localdk = (dk)localView.getLayoutParams();
          i5 = this.mTotalLength;
          i6 = localdk.topMargin;
          this.mTotalLength = Math.max(i5, localdk.bottomMargin + (i5 + m + i6) + getNextLocationOffset(localView));
        }
      }
      if (i12 != 0) {
        break;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mDivider != null)
    {
      if (this.mOrientation == 1) {
        drawDividersVertical(paramCanvas);
      }
    }
    else {
      return;
    }
    drawDividersHorizontal(paramCanvas);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(dj.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(dj.class.getName());
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mOrientation == 1)
    {
      layoutVertical(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    layoutHorizontal(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mOrientation == 1)
    {
      measureVertical(paramInt1, paramInt2);
      return;
    }
    measureHorizontal(paramInt1, paramInt2);
  }
  
  public void setBaselineAligned(boolean paramBoolean)
  {
    this.mBaselineAligned = paramBoolean;
  }
  
  public void setBaselineAlignedChildIndex(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getChildCount()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("base aligned child index out of range (0, ");
      localStringBuilder.append(getChildCount());
      localStringBuilder.append(")");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.mBaselineAlignedChildIndex = paramInt;
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    boolean bool = false;
    if (paramDrawable != this.mDivider)
    {
      this.mDivider = paramDrawable;
      if (paramDrawable == null) {
        break label51;
      }
      this.mDividerWidth = paramDrawable.getIntrinsicWidth();
    }
    for (this.mDividerHeight = paramDrawable.getIntrinsicHeight();; this.mDividerHeight = 0)
    {
      if (paramDrawable == null) {
        bool = true;
      }
      setWillNotDraw(bool);
      requestLayout();
      return;
      label51:
      this.mDividerWidth = 0;
    }
  }
  
  public void setDividerPadding(int paramInt)
  {
    this.mDividerPadding = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    if (this.mGravity != paramInt)
    {
      if ((0x800007 & paramInt) != 0) {
        break label46;
      }
      paramInt = 0x800003 | paramInt;
    }
    label46:
    for (;;)
    {
      int i = paramInt;
      if ((paramInt & 0x70) == 0) {
        i = paramInt | 0x30;
      }
      this.mGravity = i;
      requestLayout();
      return;
    }
  }
  
  public void setHorizontalGravity(int paramInt)
  {
    paramInt &= 0x800007;
    int i = this.mGravity;
    if ((0x800007 & i) != paramInt)
    {
      this.mGravity = (paramInt | i & 0xFF7FFFF8);
      requestLayout();
    }
  }
  
  public void setMeasureWithLargestChildEnabled(boolean paramBoolean)
  {
    this.mUseLargestChild = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.mOrientation != paramInt)
    {
      this.mOrientation = paramInt;
      requestLayout();
    }
  }
  
  public void setShowDividers(int paramInt)
  {
    if (paramInt != this.mShowDividers) {
      requestLayout();
    }
    this.mShowDividers = paramInt;
  }
  
  public void setVerticalGravity(int paramInt)
  {
    paramInt &= 0x70;
    int i = this.mGravity;
    if ((i & 0x70) != paramInt)
    {
      this.mGravity = (paramInt | i & 0xFFFFFF8F);
      requestLayout();
    }
  }
  
  public void setWeightSum(float paramFloat)
  {
    this.mWeightSum = Math.max(0.0F, paramFloat);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */