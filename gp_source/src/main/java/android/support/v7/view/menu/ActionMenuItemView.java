package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.a.a;
import android.support.v7.widget.bb;
import android.support.v7.widget.ch;
import android.support.v7.widget.hq;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;

public class ActionMenuItemView
  extends bb
  implements ai, android.support.v7.widget.r, View.OnClickListener
{
  public t b;
  public r c;
  public c d;
  private boolean e;
  private boolean f;
  private ch g;
  private Drawable h;
  private int i;
  private int j;
  private int k;
  private CharSequence l;
  
  public ActionMenuItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ActionMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Resources localResources = paramContext.getResources();
    this.e = e();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.v, paramInt, 0);
    this.j = paramContext.getDimensionPixelSize(a.w, 0);
    paramContext.recycle();
    this.i = ((int)(localResources.getDisplayMetrics().density * 32.0F + 0.5F));
    setOnClickListener(this);
    this.k = -1;
    setSaveEnabled(false);
  }
  
  private final boolean e()
  {
    Configuration localConfiguration = getContext().getResources().getConfiguration();
    int m = localConfiguration.screenWidthDp;
    int n = localConfiguration.screenHeightDp;
    if (m < 480)
    {
      if (m < 640) {}
      while (n < 480)
      {
        if (localConfiguration.orientation == 2) {
          break;
        }
        return false;
      }
    }
    return true;
  }
  
  private final void f()
  {
    int n = 0;
    Object localObject2 = null;
    boolean bool = TextUtils.isEmpty(this.l);
    int m;
    if (this.h != null)
    {
      m = n;
      if ((this.b.f & 0x4) == 4)
      {
        if (this.e) {
          break label183;
        }
        if (this.f) {
          break label178;
        }
        m = n;
      }
    }
    for (;;)
    {
      m = (bool ^ true) & m;
      if (m != 0) {}
      for (Object localObject1 = this.l;; localObject1 = null)
      {
        setText((CharSequence)localObject1);
        localObject1 = this.b.getContentDescription();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          setContentDescription((CharSequence)localObject1);
          localObject1 = this.b.getTooltipText();
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            hq.a(this, (CharSequence)localObject1);
            return;
          }
          localObject1 = localObject2;
          if (m == 0) {
            localObject1 = this.b.getTitle();
          }
          hq.a(this, (CharSequence)localObject1);
          return;
        }
        if (m == 0) {}
        for (localObject1 = this.b.getTitle();; localObject1 = null)
        {
          setContentDescription((CharSequence)localObject1);
          break;
        }
      }
      label178:
      m = 1;
      continue;
      label183:
      m = 1;
      continue;
      m = 1;
    }
  }
  
  public final void a(t paramt)
  {
    this.b = paramt;
    setIcon(paramt.getIcon());
    setTitle(paramt.a(this));
    setId(paramt.getItemId());
    if (!paramt.isVisible()) {}
    for (int m = 8;; m = 0)
    {
      setVisibility(m);
      setEnabled(paramt.isEnabled());
      if ((paramt.hasSubMenu()) && (this.g == null)) {
        this.g = new b(this);
      }
      return;
    }
  }
  
  public final boolean a()
  {
    return true;
  }
  
  public final boolean b()
  {
    return TextUtils.isEmpty(getText()) ^ true;
  }
  
  public final boolean c()
  {
    return (b()) && (this.b.getIcon() == null);
  }
  
  public final boolean d()
  {
    return b();
  }
  
  public t getItemData()
  {
    return this.b;
  }
  
  public void onClick(View paramView)
  {
    paramView = this.c;
    if (paramView != null) {
      paramView.a(this.b);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.e = e();
    f();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool = b();
    if (bool)
    {
      m = this.k;
      if (m >= 0) {
        super.setPadding(m, getPaddingTop(), getPaddingRight(), getPaddingBottom());
      }
    }
    super.onMeasure(paramInt1, paramInt2);
    int m = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int n = getMeasuredWidth();
    if (m == Integer.MIN_VALUE) {}
    for (paramInt1 = Math.min(paramInt1, this.j);; paramInt1 = this.j)
    {
      if ((m == 1073741824) || (this.j <= 0)) {}
      for (;;)
      {
        if ((!bool) && (this.h != null)) {
          super.setPadding((getMeasuredWidth() - this.h.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        return;
        if (n < paramInt1) {
          super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), paramInt2);
        }
      }
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(null);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b.hasSubMenu())
    {
      ch localch = this.g;
      if ((localch != null) && (localch.onTouch(this, paramMotionEvent))) {}
    }
    else
    {
      return super.onTouchEvent(paramMotionEvent);
    }
    return true;
  }
  
  public void setCheckable(boolean paramBoolean) {}
  
  public void setChecked(boolean paramBoolean) {}
  
  public void setExpandedFormat(boolean paramBoolean)
  {
    if (this.f != paramBoolean)
    {
      this.f = paramBoolean;
      t localt = this.b;
      if (localt != null) {
        localt.b.h();
      }
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    this.h = paramDrawable;
    int i1;
    int n;
    int m;
    if (paramDrawable != null)
    {
      int i2 = paramDrawable.getIntrinsicWidth();
      int i3 = paramDrawable.getIntrinsicHeight();
      i1 = this.i;
      n = i3;
      m = i2;
      if (i2 > i1)
      {
        n = (int)(i3 * (i1 / i2));
        m = i1;
      }
      if (n <= i1) {
        break label101;
      }
      float f1 = m;
      m = (int)(i1 / n * f1);
    }
    for (;;)
    {
      paramDrawable.setBounds(0, 0, m, i1);
      setCompoundDrawables(paramDrawable, null, null, null);
      f();
      return;
      label101:
      i1 = n;
    }
  }
  
  public void setItemInvoker(r paramr)
  {
    this.c = paramr;
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.k = paramInt1;
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setPopupCallback(c paramc)
  {
    this.d = paramc;
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.l = paramCharSequence;
    f();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/ActionMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */