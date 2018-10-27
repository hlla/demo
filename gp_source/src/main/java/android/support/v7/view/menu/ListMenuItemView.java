package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ac;
import android.support.v7.a.a;
import android.support.v7.widget.hf;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.SelectionBoundsAdjuster;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.TextView;

public class ListMenuItemView
  extends LinearLayout
  implements ai, AbsListView.SelectionBoundsAdjuster
{
  private Drawable a;
  private CheckBox b;
  private LinearLayout c;
  private boolean d;
  private ImageView e;
  private boolean f;
  private ImageView g;
  private LayoutInflater h;
  private t i;
  private boolean j;
  private RadioButton k;
  private TextView l;
  private Drawable m;
  private ImageView n;
  private int o;
  private Context p;
  private TextView q;
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969328);
  }
  
  public ListMenuItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = hf.a(getContext(), paramAttributeSet, a.bU, paramInt, 0);
    this.a = paramAttributeSet.a(a.bV);
    this.o = paramAttributeSet.g(a.bW, -1);
    this.j = paramAttributeSet.a(a.bX, false);
    this.p = paramContext;
    this.m = paramAttributeSet.a(a.bY);
    paramContext = paramContext.getTheme().obtainStyledAttributes(null, new int[] { 16843049 }, 2130968867, 0);
    this.f = paramContext.hasValue(0);
    paramAttributeSet.c.recycle();
    paramContext.recycle();
  }
  
  private final void a(View paramView, int paramInt)
  {
    LinearLayout localLinearLayout = this.c;
    if (localLinearLayout != null)
    {
      localLinearLayout.addView(paramView, paramInt);
      return;
    }
    addView(paramView, paramInt);
  }
  
  private final void b()
  {
    this.k = ((RadioButton)d().inflate(2131623953, this, false));
    a(this.k, -1);
  }
  
  private final void c()
  {
    this.b = ((CheckBox)d().inflate(2131623950, this, false));
    a(this.b, -1);
  }
  
  private final LayoutInflater d()
  {
    if (this.h == null) {
      this.h = LayoutInflater.from(getContext());
    }
    return this.h;
  }
  
  public final void a(t paramt)
  {
    int i3 = 8;
    this.i = paramt;
    if (!paramt.isVisible()) {}
    for (int i1 = 8;; i1 = 0)
    {
      setVisibility(i1);
      setTitle(paramt.a(this));
      setCheckable(paramt.isCheckable());
      boolean bool = paramt.d();
      paramt.c();
      if (bool) {
        if (this.i.d()) {
          i1 = 0;
        }
      }
      for (;;)
      {
        Object localObject;
        char c1;
        if (i1 == 0)
        {
          TextView localTextView = this.l;
          localObject = this.i;
          c1 = ((t)localObject).c();
          if (c1 == 0)
          {
            localObject = "";
            localTextView.setText((CharSequence)localObject);
          }
        }
        else
        {
          if (this.l.getVisibility() != i1) {
            this.l.setVisibility(i1);
          }
          setIcon(paramt.getIcon());
          setEnabled(paramt.isEnabled());
          bool = paramt.hasSubMenu();
          localObject = this.n;
          if (localObject == null)
          {
            setContentDescription(paramt.getContentDescription());
            return;
          }
          if (!bool) {}
          for (i1 = i3;; i1 = 0)
          {
            ((ImageView)localObject).setVisibility(i1);
            break;
          }
        }
        Resources localResources = ((t)localObject).b.c.getResources();
        StringBuilder localStringBuilder = new StringBuilder();
        if (ViewConfiguration.get(((t)localObject).b.c).hasPermanentMenuKey()) {
          localStringBuilder.append(localResources.getString(2131951645));
        }
        if (!((t)localObject).b.c()) {}
        for (int i2 = ((t)localObject).e;; i2 = ((t)localObject).d)
        {
          t.a(localStringBuilder, i2, 65536, localResources.getString(2131951641));
          t.a(localStringBuilder, i2, 4096, localResources.getString(2131951637));
          t.a(localStringBuilder, i2, 2, localResources.getString(2131951636));
          t.a(localStringBuilder, i2, 1, localResources.getString(2131951642));
          t.a(localStringBuilder, i2, 4, localResources.getString(2131951644));
          t.a(localStringBuilder, i2, 8, localResources.getString(2131951640));
          switch (c1)
          {
          default: 
            localStringBuilder.append(c1);
          }
          for (;;)
          {
            localObject = localStringBuilder.toString();
            break;
            localStringBuilder.append(localResources.getString(2131951643));
            continue;
            localStringBuilder.append(localResources.getString(2131951639));
            continue;
            localStringBuilder.append(localResources.getString(2131951638));
          }
        }
        i1 = 8;
        continue;
        i1 = 8;
      }
    }
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public void adjustListItemSelectionBounds(Rect paramRect)
  {
    Object localObject = this.e;
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
    {
      localObject = (LinearLayout.LayoutParams)this.e.getLayoutParams();
      int i1 = paramRect.top;
      int i2 = this.e.getHeight();
      int i3 = ((LinearLayout.LayoutParams)localObject).topMargin;
      paramRect.top = (((LinearLayout.LayoutParams)localObject).bottomMargin + (i2 + i3) + i1);
    }
  }
  
  public t getItemData()
  {
    return this.i;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ac.a(this, this.a);
    this.q = ((TextView)findViewById(2131429479));
    int i1 = this.o;
    if (i1 != -1) {
      this.q.setTextAppearance(this.p, i1);
    }
    this.l = ((TextView)findViewById(2131429260));
    this.n = ((ImageView)findViewById(2131429352));
    ImageView localImageView = this.n;
    if (localImageView != null) {
      localImageView.setImageDrawable(this.m);
    }
    this.e = ((ImageView)findViewById(2131428251));
    this.c = ((LinearLayout)findViewById(2131427738));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.g != null) && (this.j))
    {
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.g.getLayoutParams();
      if ((localLayoutParams.height > 0) && (localLayoutParams1.width <= 0)) {
        localLayoutParams1.width = localLayoutParams.height;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if (paramBoolean) {}
    while ((this.k != null) || (this.b != null))
    {
      Object localObject2;
      if (this.i.e())
      {
        if (this.k == null) {
          b();
        }
        localObject2 = this.k;
      }
      for (Object localObject1 = this.b;; localObject1 = this.k)
      {
        if (paramBoolean)
        {
          ((CompoundButton)localObject2).setChecked(this.i.isChecked());
          if (((CompoundButton)localObject2).getVisibility() != 0) {
            ((CompoundButton)localObject2).setVisibility(0);
          }
          if ((localObject1 != null) && (((CompoundButton)localObject1).getVisibility() != 8)) {
            ((CompoundButton)localObject1).setVisibility(8);
          }
        }
        do
        {
          return;
          localObject1 = this.b;
          if (localObject1 != null) {
            ((CheckBox)localObject1).setVisibility(8);
          }
          localObject1 = this.k;
        } while (localObject1 == null);
        ((RadioButton)localObject1).setVisibility(8);
        return;
        if (this.b == null) {
          c();
        }
        localObject2 = this.b;
      }
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.i.e()) {
      if (this.k == null) {
        b();
      }
    }
    for (Object localObject = this.k;; localObject = this.b)
    {
      ((CompoundButton)localObject).setChecked(paramBoolean);
      return;
      if (this.b == null) {
        c();
      }
    }
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.d = paramBoolean;
    this.j = paramBoolean;
  }
  
  public void setGroupDividerEnabled(boolean paramBoolean)
  {
    int i1 = 8;
    ImageView localImageView = this.e;
    if (localImageView != null) {
      if (!this.f) {
        break label25;
      }
    }
    for (;;)
    {
      localImageView.setVisibility(i1);
      return;
      label25:
      if (paramBoolean) {
        i1 = 0;
      }
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    int i1;
    if (!this.i.b.j) {
      if (!this.d) {
        i1 = 0;
      }
    }
    for (;;)
    {
      if (i1 != 0) {}
      while (this.j)
      {
        ImageView localImageView = this.g;
        if (localImageView != null) {}
        while ((paramDrawable != null) || (this.j))
        {
          if (localImageView == null)
          {
            this.g = ((ImageView)d().inflate(2131623951, this, false));
            a(this.g, 0);
          }
          if (paramDrawable != null) {}
          while (this.j)
          {
            localImageView = this.g;
            if (i1 == 0) {
              paramDrawable = null;
            }
            localImageView.setImageDrawable(paramDrawable);
            if (this.g.getVisibility() != 0) {
              this.g.setVisibility(0);
            }
            return;
          }
          this.g.setVisibility(8);
          return;
        }
        return;
      }
      return;
      i1 = 1;
      continue;
      i1 = 1;
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.q.setText(paramCharSequence);
      if (this.q.getVisibility() != 0) {
        this.q.setVisibility(0);
      }
    }
    while (this.q.getVisibility() == 8) {
      return;
    }
    this.q.setVisibility(8);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/view/menu/ListMenuItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */