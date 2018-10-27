package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.content.a.k;
import android.support.v4.view.ac;
import android.support.v4.view.b;
import android.support.v4.widget.av;
import android.support.v7.view.menu.ai;
import android.support.v7.view.menu.t;
import android.support.v7.widget.dj;
import android.support.v7.widget.dk;
import android.support.v7.widget.hq;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;

public class NavigationMenuItemView
  extends h
  implements ai
{
  private static final int[] b = { 16842912 };
  public boolean a;
  private final b c = new i(this);
  private FrameLayout d;
  private Drawable e;
  private final int f;
  private t g;
  private boolean h;
  private final CheckedTextView i;
  
  public NavigationMenuItemView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(0);
    LayoutInflater.from(paramContext).inflate(2131624147, this, true);
    this.f = paramContext.getResources().getDimensionPixelSize(2131165560);
    this.i = ((CheckedTextView)findViewById(2131427864));
    this.i.setDuplicateParentStateEnabled(true);
    ac.a(this.i, this.c);
  }
  
  public final void a(t paramt)
  {
    this.g = paramt;
    if (!paramt.isVisible()) {}
    for (int j = 8;; j = 0)
    {
      setVisibility(j);
      Object localObject;
      if (getBackground() != null)
      {
        setCheckable(paramt.isCheckable());
        setChecked(paramt.isChecked());
        setEnabled(paramt.isEnabled());
        setTitle(paramt.getTitle());
        setIcon(paramt.getIcon());
        localObject = paramt.getActionView();
        if (localObject == null) {}
        for (;;)
        {
          setContentDescription(paramt.getContentDescription());
          hq.a(this, paramt.getTooltipText());
          if ((this.g.getTitle() == null) && (this.g.getIcon() == null) && (this.g.getActionView() != null))
          {
            this.i.setVisibility(8);
            paramt = this.d;
            if (paramt != null)
            {
              paramt = (dk)paramt.getLayoutParams();
              paramt.width = -1;
              this.d.setLayoutParams(paramt);
            }
          }
          do
          {
            return;
            this.i.setVisibility(0);
            paramt = this.d;
          } while (paramt == null);
          paramt = (dk)paramt.getLayoutParams();
          paramt.width = -2;
          this.d.setLayoutParams(paramt);
          return;
          if (this.d == null) {
            this.d = ((FrameLayout)((ViewStub)findViewById(2131427863)).inflate());
          }
          this.d.removeAllViews();
          this.d.addView((View)localObject);
        }
      }
      TypedValue localTypedValue = new TypedValue();
      if (getContext().getTheme().resolveAttribute(2130968784, localTypedValue, true))
      {
        localObject = new StateListDrawable();
        ((StateListDrawable)localObject).addState(b, new ColorDrawable(localTypedValue.data));
        ((StateListDrawable)localObject).addState(EMPTY_STATE_SET, new ColorDrawable(0));
      }
      for (;;)
      {
        ac.a(this, (Drawable)localObject);
        break;
        localObject = null;
      }
    }
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public t getItemData()
  {
    return this.g;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    t localt = this.g;
    if ((localt != null) && (localt.isCheckable()) && (this.g.isChecked())) {
      mergeDrawableStates(arrayOfInt, b);
    }
    return arrayOfInt;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    refreshDrawableState();
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      this.c.a(this.i, 2048);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    refreshDrawableState();
    this.i.setChecked(paramBoolean);
  }
  
  public void setHorizontalPadding(int paramInt)
  {
    setPadding(paramInt, 0, paramInt, 0);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    int j;
    if (paramDrawable != null)
    {
      j = this.f;
      paramDrawable.setBounds(0, 0, j, j);
    }
    for (;;)
    {
      av.a(this.i, paramDrawable, null, null, null);
      return;
      if (this.h)
      {
        if (this.e == null)
        {
          this.e = k.a(getResources(), 2131231184, getContext().getTheme());
          paramDrawable = this.e;
          if (paramDrawable != null)
          {
            j = this.f;
            paramDrawable.setBounds(0, 0, j, j);
          }
        }
        paramDrawable = this.e;
      }
    }
  }
  
  public void setIconPadding(int paramInt)
  {
    this.i.setCompoundDrawablePadding(paramInt);
  }
  
  public void setNeedsEmptyIcon(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setTextAppearance(int paramInt)
  {
    av.a(this.i, paramInt);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    this.i.setTextColor(paramColorStateList);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.i.setText(paramCharSequence);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/internal/NavigationMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */