package android.support.design.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.aa;
import android.support.v4.view.ac;
import android.support.v4.view.o;
import android.support.v4.widget.av;
import android.support.v7.app.d;
import android.support.v7.widget.hq;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class m
  extends LinearLayout
{
  public Drawable a;
  public ImageView b;
  public TextView c;
  public View d;
  public ImageView e;
  public TextView f;
  private int h = 2;
  private k i;
  
  public m(c paramc, Context paramContext)
  {
    super(paramContext);
    a(paramContext);
    ac.a(this, paramc.j, paramc.k, paramc.i, paramc.h);
    setGravity(17);
    setOrientation(paramc.a ^ true);
    setClickable(true);
    paramc = getContext();
    if (Build.VERSION.SDK_INT >= 24) {}
    for (paramc = new aa(PointerIcon.getSystemIcon(paramc, 1002));; paramc = new aa(null))
    {
      ac.a(this, paramc);
      return;
    }
  }
  
  final void a()
  {
    k localk = this.i;
    if (localk != null) {}
    for (Object localObject1 = localk.b;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        localObject1 = this.d;
        if (localObject1 != null)
        {
          removeView((View)localObject1);
          this.d = null;
        }
        this.c = null;
        this.b = null;
        if (this.d == null)
        {
          if (this.e == null)
          {
            localObject1 = (ImageView)LayoutInflater.from(getContext()).inflate(2131624139, this, false);
            addView((View)localObject1, 0);
            this.e = ((ImageView)localObject1);
          }
          if (this.f == null)
          {
            localObject1 = (TextView)LayoutInflater.from(getContext()).inflate(2131624140, this, false);
            addView((View)localObject1);
            this.f = ((TextView)localObject1);
            this.h = this.f.getMaxLines();
          }
          av.a(this.f, this.g.n);
          localObject1 = this.g.o;
          if (localObject1 != null) {
            this.f.setTextColor((ColorStateList)localObject1);
          }
          a(this.f, this.e);
        }
        for (;;)
        {
          if ((localk != null) && (!TextUtils.isEmpty(localk.a))) {
            setContentDescription(localk.a);
          }
          boolean bool;
          if (localk != null)
          {
            localObject1 = localk.c;
            if (localObject1 == null) {
              throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            if (((c)localObject1).getSelectedTabPosition() == localk.d) {
              bool = true;
            }
          }
          for (;;)
          {
            setSelected(bool);
            return;
            bool = false;
            continue;
            bool = false;
          }
          localObject1 = this.c;
          if ((localObject1 != null) || (this.b != null)) {
            a((TextView)localObject1, this.b);
          }
        }
      }
      Object localObject2 = ((View)localObject1).getParent();
      if (localObject2 == this) {}
      for (;;)
      {
        this.d = ((View)localObject1);
        localObject2 = this.f;
        if (localObject2 != null) {
          ((TextView)localObject2).setVisibility(8);
        }
        localObject2 = this.e;
        if (localObject2 != null)
        {
          ((ImageView)localObject2).setVisibility(8);
          this.e.setImageDrawable(null);
        }
        this.c = ((TextView)((View)localObject1).findViewById(16908308));
        localObject2 = this.c;
        if (localObject2 == null) {}
        for (;;)
        {
          this.b = ((ImageView)((View)localObject1).findViewById(16908294));
          break;
          this.h = ((TextView)localObject2).getMaxLines();
        }
        if (localObject2 != null) {
          ((ViewGroup)localObject2).removeView((View)localObject1);
        }
        addView((View)localObject1);
      }
    }
  }
  
  final void a(Context paramContext)
  {
    Object localObject = null;
    int j = this.g.c;
    if (j != 0)
    {
      this.a = android.support.v7.b.a.a.b(paramContext, j);
      paramContext = this.a;
      if ((paramContext != null) && (paramContext.isStateful())) {
        this.a.setState(getDrawableState());
      }
    }
    for (;;)
    {
      paramContext = new GradientDrawable();
      paramContext.setColor(0);
      GradientDrawable localGradientDrawable;
      ColorStateList localColorStateList;
      if (this.g.l != null)
      {
        localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setCornerRadius(1.0E-5F);
        localGradientDrawable.setColor(-1);
        localColorStateList = android.support.design.e.a.a(this.g.l);
        if (Build.VERSION.SDK_INT >= 21)
        {
          boolean bool = this.g.s;
          if (!bool)
          {
            if (!bool) {
              localObject = localGradientDrawable;
            }
            paramContext = new RippleDrawable(localColorStateList, paramContext, (Drawable)localObject);
          }
        }
      }
      for (;;)
      {
        ac.a(this, paramContext);
        this.g.invalidate();
        return;
        paramContext = null;
        break;
        localObject = android.support.v4.a.a.a.f(localGradientDrawable);
        android.support.v4.a.a.a.a((Drawable)localObject, localColorStateList);
        paramContext = new LayerDrawable(new Drawable[] { paramContext, localObject });
      }
      this.a = null;
    }
  }
  
  final void a(k paramk)
  {
    if (paramk != this.i)
    {
      this.i = paramk;
      a();
    }
  }
  
  final void a(TextView paramTextView, ImageView paramImageView)
  {
    Object localObject = this.i;
    if (localObject != null) {}
    for (localObject = ((k)localObject).e;; localObject = null)
    {
      if (paramImageView == null) {}
      for (;;)
      {
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        int j = bool ^ true;
        if (paramTextView == null) {}
        for (;;)
        {
          if (paramImageView != null)
          {
            paramTextView = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
            if (j == 0) {
              break label175;
            }
            if (paramImageView.getVisibility() != 0) {
              break label170;
            }
            j = this.g.b(8);
          }
          for (;;)
          {
            if (this.g.a) {
              if (j != o.b(paramTextView))
              {
                o.b(paramTextView, j);
                paramTextView.bottomMargin = 0;
                paramImageView.setLayoutParams(paramTextView);
                paramImageView.requestLayout();
              }
            }
            for (;;)
            {
              paramTextView = this.i;
              if (paramTextView != null) {}
              for (paramTextView = paramTextView.a;; paramTextView = null)
              {
                if (!bool) {
                  paramTextView = null;
                }
                hq.a(this, paramTextView);
                return;
              }
              if (j != paramTextView.bottomMargin)
              {
                paramTextView.bottomMargin = j;
                o.b(paramTextView, 0);
                paramImageView.setLayoutParams(paramTextView);
                paramImageView.requestLayout();
              }
            }
            label170:
            j = 0;
            continue;
            label175:
            j = 0;
          }
          if (j != 0)
          {
            paramTextView.setText((CharSequence)localObject);
            paramTextView.setVisibility(0);
            setVisibility(0);
          }
          else
          {
            paramTextView.setVisibility(8);
            paramTextView.setText(null);
          }
        }
        paramImageView.setVisibility(8);
        paramImageView.setImageDrawable(null);
      }
    }
  }
  
  protected final void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable = this.a;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (this.a.setState(arrayOfInt)))
    {
      invalidate();
      this.g.invalidate();
    }
  }
  
  public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(d.class.getName());
  }
  
  @TargetApi(14)
  public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(d.class.getName());
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt1);
    int m = this.g.g;
    if (m <= 0) {}
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      float f1;
      Object localObject;
      if (this.f != null)
      {
        f1 = this.g.q;
        k = this.h;
        localObject = this.e;
        if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0)) {
          break label268;
        }
        localObject = this.f;
        if (localObject != null) {
          break label240;
        }
        j = k;
      }
      for (;;)
      {
        float f2 = this.f.getTextSize();
        k = this.f.getLineCount();
        m = this.f.getMaxLines();
        if (f1 != f2) {}
        for (;;)
        {
          if (this.g.b != 1) {}
          do
          {
            do
            {
              do
              {
                this.f.setTextSize(0, f1);
                this.f.setMaxLines(j);
                super.onMeasure(paramInt1, paramInt2);
                return;
              } while ((f1 <= f2) || (k != 1));
              localObject = this.f.getLayout();
              if (localObject == null) {
                break;
              }
              f2 = ((Layout)localObject).getLineWidth(0);
            } while (f1 / ((Layout)localObject).getPaint().getTextSize() * f2 <= getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
            return;
          } while ((m < 0) || (j == m));
        }
        label240:
        j = k;
        if (((TextView)localObject).getLineCount() > 1)
        {
          f1 = this.g.p;
          j = k;
          continue;
          label268:
          j = 1;
        }
      }
      if (k == 0) {}
      while (j > m)
      {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(m, Integer.MIN_VALUE);
        break;
      }
    }
  }
  
  public final boolean performClick()
  {
    boolean bool2 = super.performClick();
    boolean bool1 = bool2;
    if (this.i != null)
    {
      if (!bool2) {
        playSoundEffect(0);
      }
      this.i.a();
      bool1 = true;
    }
    return bool1;
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    isSelected();
    super.setSelected(paramBoolean);
    Object localObject = this.f;
    if (localObject != null) {
      ((TextView)localObject).setSelected(paramBoolean);
    }
    localObject = this.e;
    if (localObject != null) {
      ((ImageView)localObject).setSelected(paramBoolean);
    }
    localObject = this.d;
    if (localObject != null) {
      ((View)localObject).setSelected(paramBoolean);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/g/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */