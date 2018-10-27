package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ac;
import android.support.v4.view.k;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class AlertDialogLayout
  extends dj
{
  public AlertDialogLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public AlertDialogLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getPaddingLeft();
    int k = paramInt3 - paramInt1;
    int m = getPaddingRight();
    int n = getPaddingRight();
    paramInt1 = getMeasuredHeight();
    int i1 = getChildCount();
    int i2 = getGravity();
    switch (i2 & 0x70)
    {
    default: 
      paramInt1 = getPaddingTop();
    }
    for (;;)
    {
      Object localObject = getDividerDrawable();
      if (localObject != null) {}
      for (paramInt3 = ((Drawable)localObject).getIntrinsicHeight();; paramInt3 = 0)
      {
        paramInt4 = 0;
        if (paramInt4 >= i1) {
          break;
        }
        localObject = getChildAt(paramInt4);
        paramInt2 = paramInt1;
        int i3;
        int i4;
        dk localdk;
        int i;
        if (localObject != null)
        {
          paramInt2 = paramInt1;
          if (((View)localObject).getVisibility() != 8)
          {
            i3 = ((View)localObject).getMeasuredWidth();
            i4 = ((View)localObject).getMeasuredHeight();
            localdk = (dk)((View)localObject).getLayoutParams();
            i = localdk.g;
            paramInt2 = i;
            if (i < 0) {
              paramInt2 = i2 & 0x800007;
            }
            switch (k.a(paramInt2, ac.h(this)) & 0x7)
            {
            default: 
              paramInt2 = localdk.leftMargin + j;
            }
          }
        }
        for (;;)
        {
          i = paramInt1;
          if (hasDividerBeforeChildAt(paramInt4)) {
            i = paramInt1 + paramInt3;
          }
          paramInt1 = i + localdk.topMargin;
          ((View)localObject).layout(paramInt2, paramInt1, i3 + paramInt2, paramInt1 + i4);
          paramInt2 = paramInt1 + (localdk.bottomMargin + i4);
          paramInt4 += 1;
          paramInt1 = paramInt2;
          break;
          paramInt2 = k - m - i3 - localdk.rightMargin;
          continue;
          paramInt2 = (k - j - n - i3) / 2 + j + localdk.leftMargin - localdk.rightMargin;
        }
      }
      paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - paramInt1;
      continue;
      paramInt3 = getPaddingTop();
      paramInt1 = (paramInt4 - paramInt2 - paramInt1) / 2 + paramInt3;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = getChildCount();
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    int i = 0;
    int j;
    if (i >= i3)
    {
      int i5 = View.MeasureSpec.getMode(paramInt2);
      int i2 = View.MeasureSpec.getSize(paramInt2);
      int i4 = View.MeasureSpec.getMode(paramInt1);
      i = getPaddingTop();
      j = getPaddingBottom() + i;
      if (localObject4 != null)
      {
        ((View)localObject4).measure(paramInt1, 0);
        j += ((View)localObject4).getMeasuredHeight();
      }
      for (int k = View.combineMeasuredStates(0, ((View)localObject4).getMeasuredState());; k = 0)
      {
        int m;
        if (localObject2 == null)
        {
          i = 0;
          m = 0;
          int i1;
          if (localObject1 == null)
          {
            i1 = 0;
            i2 -= j;
            if (localObject2 != null)
            {
              int i6 = Math.min(i2, m);
              m = i2;
              n = i;
              if (i6 > 0)
              {
                m = i2 - i6;
                n = i + i6;
              }
              ((View)localObject2).measure(paramInt1, View.MeasureSpec.makeMeasureSpec(n, 1073741824));
              n = ((View)localObject2).getMeasuredHeight();
              k = View.combineMeasuredStates(k, ((View)localObject2).getMeasuredState());
              j = n + (j - i);
              i = k;
              n = m;
            }
            for (;;)
            {
              if (localObject1 == null)
              {
                m = i;
                k = j;
              }
              for (;;)
              {
                j = 0;
                i = 0;
                for (;;)
                {
                  if (i >= i3)
                  {
                    setMeasuredDimension(View.resolveSizeAndState(j + (getPaddingLeft() + getPaddingRight()), paramInt1, m), View.resolveSizeAndState(k, paramInt2, 0));
                    if (i4 == 1073741824) {
                      break;
                    }
                    i = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
                    paramInt1 = 0;
                    while (paramInt1 < i3)
                    {
                      localObject1 = getChildAt(paramInt1);
                      if (((View)localObject1).getVisibility() != 8)
                      {
                        localObject2 = (dk)((View)localObject1).getLayoutParams();
                        if (((dk)localObject2).width == -1)
                        {
                          j = ((dk)localObject2).height;
                          ((dk)localObject2).height = ((View)localObject1).getMeasuredHeight();
                          measureChildWithMargins((View)localObject1, i, 0, paramInt2, 0);
                          ((dk)localObject2).height = j;
                        }
                      }
                      paramInt1 += 1;
                    }
                  }
                  localObject1 = getChildAt(i);
                  n = j;
                  if (((View)localObject1).getVisibility() != 8) {
                    n = Math.max(j, ((View)localObject1).getMeasuredWidth());
                  }
                  i += 1;
                  j = n;
                }
                k = j;
                m = i;
                if (n > 0)
                {
                  ((View)localObject1).measure(paramInt1, View.MeasureSpec.makeMeasureSpec(n + i1, i5));
                  k = j - i1 + ((View)localObject1).getMeasuredHeight();
                  m = View.combineMeasuredStates(i, ((View)localObject1).getMeasuredState());
                }
              }
              n = i2;
              i = k;
            }
          }
          if (i5 != 0) {}
          for (int n = View.MeasureSpec.makeMeasureSpec(Math.max(0, i2 - j), i5);; n = 0)
          {
            ((View)localObject1).measure(paramInt1, n);
            i1 = ((View)localObject1).getMeasuredHeight();
            j += i1;
            k = View.combineMeasuredStates(k, ((View)localObject1).getMeasuredState());
            break;
          }
        }
        ((View)localObject2).measure(paramInt1, 0);
        for (localObject3 = localObject2;; localObject3 = ((ViewGroup)localObject3).getChildAt(0))
        {
          i = ac.s((View)localObject3);
          if (i > 0) {
            break label623;
          }
          if (!(localObject3 instanceof ViewGroup)) {
            break label618;
          }
          localObject3 = (ViewGroup)localObject3;
          if (((ViewGroup)localObject3).getChildCount() != 1) {
            break;
          }
        }
        i = 0;
        label618:
        label623:
        for (;;)
        {
          m = ((View)localObject2).getMeasuredHeight();
          j += i;
          k = View.combineMeasuredStates(k, ((View)localObject2).getMeasuredState());
          m -= i;
          break;
          i = 0;
        }
      }
    }
    Object localObject3 = getChildAt(i);
    if (((View)localObject3).getVisibility() != 8)
    {
      j = ((View)localObject3).getId();
      if (j == 2131429537) {
        localObject4 = localObject3;
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (j == 2131427576)
      {
        localObject2 = localObject3;
      }
      else
      {
        if ((j != 2131427741) && (j != 2131427813)) {}
        while (localObject1 != null)
        {
          super.onMeasure(paramInt1, paramInt2);
          return;
        }
        localObject1 = localObject3;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/AlertDialogLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */