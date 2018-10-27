package android.support.design.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.design.internal.n;
import android.support.design.internal.o;
import android.support.v4.view.ac;
import android.support.v4.widget.av;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;

public final class a
  extends AppCompatButton
{
  private Drawable b;
  private int c;
  private int d;
  private int e;
  private int f;
  private ColorStateList g;
  private PorterDuff.Mode h;
  private final c i;
  
  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  private a(Context paramContext, AttributeSet paramAttributeSet, byte paramByte)
  {
    super(paramContext, paramAttributeSet, 2130969348);
    paramAttributeSet = n.a(paramContext, paramAttributeSet, d.a, 2130969348, 2132018440, new int[0]);
    this.e = paramAttributeSet.getDimensionPixelSize(d.k, 0);
    this.h = o.a(paramAttributeSet.getInt(d.n, -1), PorterDuff.Mode.SRC_IN);
    this.g = android.support.design.d.a.a(getContext(), paramAttributeSet, d.m);
    this.b = android.support.design.d.a.b(getContext(), paramAttributeSet, d.i);
    this.c = paramAttributeSet.getInteger(d.j, 1);
    this.f = paramAttributeSet.getDimensionPixelSize(d.l, 0);
    this.i = new c(this);
    c localc = this.i;
    localc.k = paramAttributeSet.getDimensionPixelOffset(d.c, 0);
    localc.l = paramAttributeSet.getDimensionPixelOffset(d.d, 0);
    localc.m = paramAttributeSet.getDimensionPixelOffset(d.e, 0);
    localc.j = paramAttributeSet.getDimensionPixelOffset(d.b, 0);
    localc.i = paramAttributeSet.getDimensionPixelSize(d.h, 0);
    localc.u = paramAttributeSet.getDimensionPixelSize(d.q, 0);
    localc.e = o.a(paramAttributeSet.getInt(d.g, -1), PorterDuff.Mode.SRC_IN);
    localc.d = android.support.design.d.a.a(localc.o.getContext(), paramAttributeSet, d.f);
    localc.s = android.support.design.d.a.a(localc.o.getContext(), paramAttributeSet, d.p);
    localc.q = android.support.design.d.a.a(localc.o.getContext(), paramAttributeSet, d.o);
    localc.g.setStyle(Paint.Style.STROKE);
    localc.g.setStrokeWidth(localc.u);
    paramContext = localc.g;
    Object localObject = localc.s;
    if (localObject != null) {}
    for (paramByte = ((ColorStateList)localObject).getColorForState(localc.o.getDrawableState(), 0);; paramByte = 0)
    {
      paramContext.setColor(paramByte);
      paramByte = ac.n(localc.o);
      int j = localc.o.getPaddingTop();
      int k = ac.o(localc.o);
      int m = localc.o.getPaddingBottom();
      localObject = localc.o;
      if (c.a) {}
      for (paramContext = localc.b();; paramContext = localc.a(new LayerDrawable(new Drawable[] { localc.v, localc.w })))
      {
        ((AppCompatButton)localObject).setBackgroundDrawable(paramContext);
        ac.a(localc.o, paramByte + localc.k, j + localc.m, k + localc.l, localc.j + m);
        paramAttributeSet.recycle();
        setCompoundDrawablePadding(this.e);
        a();
        return;
        localc.h = new GradientDrawable();
        localc.h.setCornerRadius(localc.i + 1.0E-5F);
        localc.h.setColor(-1);
        localc.v = android.support.v4.a.a.a.f(localc.h);
        android.support.v4.a.a.a.a(localc.v, localc.d);
        paramContext = localc.e;
        if (paramContext != null) {
          android.support.v4.a.a.a.a(localc.v, paramContext);
        }
        localc.r = new GradientDrawable();
        localc.r.setCornerRadius(localc.i + 1.0E-5F);
        localc.r.setColor(-1);
        localc.w = android.support.v4.a.a.a.f(localc.r);
        android.support.v4.a.a.a.a(localc.w, localc.q);
      }
    }
  }
  
  private final void a()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      this.b = ((Drawable)localObject).mutate();
      android.support.v4.a.a.a.a(this.b, this.g);
      localObject = this.h;
      if (localObject != null) {
        android.support.v4.a.a.a.a(this.b, (PorterDuff.Mode)localObject);
      }
      int k = this.f;
      int j = k;
      if (k == 0) {
        j = this.b.getIntrinsicWidth();
      }
      int m = this.f;
      k = m;
      if (m == 0) {
        k = this.b.getIntrinsicHeight();
      }
      localObject = this.b;
      m = this.d;
      ((Drawable)localObject).setBounds(m, 0, j + m, k);
    }
    av.a(this, this.b, null, null, null);
  }
  
  private final boolean b()
  {
    c localc = this.i;
    return (localc != null) && (!localc.c);
  }
  
  final void a(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public final ColorStateList getBackgroundTintList()
  {
    return getSupportBackgroundTintList();
  }
  
  public final PorterDuff.Mode getBackgroundTintMode()
  {
    return getSupportBackgroundTintMode();
  }
  
  public final int getCornerRadius()
  {
    if (b()) {
      return this.i.i;
    }
    return 0;
  }
  
  public final Drawable getIcon()
  {
    return this.b;
  }
  
  public final int getIconGravity()
  {
    return this.c;
  }
  
  public final int getIconPadding()
  {
    return this.e;
  }
  
  public final int getIconSize()
  {
    return this.f;
  }
  
  public final ColorStateList getIconTint()
  {
    return this.g;
  }
  
  public final PorterDuff.Mode getIconTintMode()
  {
    return this.h;
  }
  
  public final ColorStateList getRippleColor()
  {
    if (b()) {
      return this.i.q;
    }
    return null;
  }
  
  public final ColorStateList getStrokeColor()
  {
    if (b()) {
      return this.i.s;
    }
    return null;
  }
  
  public final int getStrokeWidth()
  {
    if (b()) {
      return this.i.u;
    }
    return 0;
  }
  
  public final ColorStateList getSupportBackgroundTintList()
  {
    if (b()) {
      return this.i.d;
    }
    return super.getSupportBackgroundTintList();
  }
  
  public final PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (b()) {
      return this.i.e;
    }
    return super.getSupportBackgroundTintMode();
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((Build.VERSION.SDK_INT < 21) && (b()))
    {
      c localc = this.i;
      if ((paramCanvas != null) && (localc.s != null) && (localc.u > 0))
      {
        localc.f.set(localc.o.getBackground().getBounds());
        localc.p.set(localc.f.left + localc.u / 2.0F + localc.k, localc.f.top + localc.u / 2.0F + localc.m, localc.f.right - localc.u / 2.0F - localc.l, localc.f.bottom - localc.u / 2.0F - localc.j);
        float f1 = localc.i - localc.u / 2.0F;
        paramCanvas.drawRoundRect(localc.p, f1, f1, localc.g);
      }
    }
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (Build.VERSION.SDK_INT == 21)
    {
      c localc = this.i;
      if (localc != null)
      {
        GradientDrawable localGradientDrawable = localc.n;
        if (localGradientDrawable != null) {
          localGradientDrawable.setBounds(localc.k, localc.m, paramInt3 - paramInt1 - localc.l, paramInt4 - paramInt2 - localc.j);
        }
      }
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.b != null) && (this.c == 2))
    {
      int j = (int)getPaint().measureText(getText().toString());
      paramInt2 = this.f;
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = this.b.getIntrinsicWidth();
      }
      paramInt2 = (getMeasuredWidth() - j - ac.o(this) - paramInt1 - this.e - ac.n(this)) / 2;
      paramInt1 = paramInt2;
      if (ac.h(this) == 1) {
        paramInt1 = -paramInt2;
      }
      if (this.d != paramInt1)
      {
        this.d = paramInt1;
        a();
      }
    }
  }
  
  public final void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    if (b())
    {
      Object localObject = this.i;
      if (c.a)
      {
        GradientDrawable localGradientDrawable = ((c)localObject).b;
        if (localGradientDrawable != null) {
          localGradientDrawable.setColor(paramInt);
        }
      }
      do
      {
        do
        {
          return;
        } while (c.a);
        localObject = ((c)localObject).h;
      } while (localObject == null);
      ((GradientDrawable)localObject).setColor(paramInt);
      return;
    }
    super.setBackgroundColor(paramInt);
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (b())
    {
      if (paramDrawable != getBackground())
      {
        Log.i("MaterialButton", "Setting a custom background is not supported.");
        c localc = this.i;
        localc.c = true;
        localc.o.setSupportBackgroundTintList(localc.d);
        localc.o.setSupportBackgroundTintMode(localc.e);
        super.setBackgroundDrawable(paramDrawable);
        return;
      }
      getBackground().setState(paramDrawable.getState());
      return;
    }
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public final void setBackgroundResource(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v7.b.a.a.b(getContext(), paramInt);; localDrawable = null)
    {
      setBackgroundDrawable(localDrawable);
      return;
    }
  }
  
  public final void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    setSupportBackgroundTintList(paramColorStateList);
  }
  
  public final void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    setSupportBackgroundTintMode(paramMode);
  }
  
  public final void setCornerRadius(int paramInt)
  {
    Object localObject2 = null;
    c localc;
    if (b())
    {
      localc = this.i;
      if (localc.i != paramInt)
      {
        localc.i = paramInt;
        if ((!c.a) || (localc.b == null) || (localc.t == null) || (localc.n == null)) {
          break label236;
        }
        if (Build.VERSION.SDK_INT == 21) {
          break label103;
        }
        f1 = paramInt + 1.0E-5F;
        localc.b.setCornerRadius(f1);
        localc.t.setCornerRadius(f1);
        localc.n.setCornerRadius(f1);
      }
    }
    label103:
    Object localObject1;
    label236:
    do
    {
      do
      {
        return;
        f1 = paramInt + 1.0E-5F;
        if (c.a) {
          if (localc.o.getBackground() != null) {
            localObject1 = (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)localc.o.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
          }
        }
        for (;;)
        {
          ((GradientDrawable)localObject1).setCornerRadius(f1);
          localObject1 = localObject2;
          if (c.a)
          {
            localObject1 = localObject2;
            if (localc.o.getBackground() != null) {
              localObject1 = (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)localc.o.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
            }
          }
          ((GradientDrawable)localObject1).setCornerRadius(f1);
          break;
          localObject1 = null;
          continue;
          localObject1 = null;
        }
      } while (c.a);
      localObject1 = localc.h;
    } while ((localObject1 == null) || (localc.r == null));
    float f1 = paramInt + 1.0E-5F;
    ((GradientDrawable)localObject1).setCornerRadius(f1);
    localc.r.setCornerRadius(f1);
    localc.o.invalidate();
  }
  
  public final void setCornerRadiusResource(int paramInt)
  {
    if (b()) {
      setCornerRadius(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public final void setIcon(Drawable paramDrawable)
  {
    if (this.b != paramDrawable)
    {
      this.b = paramDrawable;
      a();
    }
  }
  
  public final void setIconGravity(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void setIconPadding(int paramInt)
  {
    if (this.e != paramInt)
    {
      this.e = paramInt;
      setCompoundDrawablePadding(paramInt);
    }
  }
  
  public final void setIconResource(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v7.b.a.a.b(getContext(), paramInt);; localDrawable = null)
    {
      setIcon(localDrawable);
      return;
    }
  }
  
  public final void setIconSize(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("iconSize cannot be less than 0");
    }
    if (this.f != paramInt)
    {
      this.f = paramInt;
      a();
    }
  }
  
  public final void setIconTint(ColorStateList paramColorStateList)
  {
    if (this.g != paramColorStateList)
    {
      this.g = paramColorStateList;
      a();
    }
  }
  
  public final void setIconTintMode(PorterDuff.Mode paramMode)
  {
    if (this.h != paramMode)
    {
      this.h = paramMode;
      a();
    }
  }
  
  public final void setIconTintResource(int paramInt)
  {
    setIconTint(android.support.v7.b.a.a.a(getContext(), paramInt));
  }
  
  public final void setRippleColor(ColorStateList paramColorStateList)
  {
    Object localObject;
    if (b())
    {
      localObject = this.i;
      if (((c)localObject).q != paramColorStateList)
      {
        ((c)localObject).q = paramColorStateList;
        if ((!c.a) || (!(((c)localObject).o.getBackground() instanceof RippleDrawable))) {
          break label59;
        }
        ((RippleDrawable)((c)localObject).o.getBackground()).setColor(paramColorStateList);
      }
    }
    label59:
    do
    {
      do
      {
        return;
      } while (c.a);
      localObject = ((c)localObject).w;
    } while (localObject == null);
    android.support.v4.a.a.a.a((Drawable)localObject, paramColorStateList);
  }
  
  public final void setRippleColorResource(int paramInt)
  {
    if (b()) {
      setRippleColor(android.support.v7.b.a.a.a(getContext(), paramInt));
    }
  }
  
  public final void setStrokeColor(ColorStateList paramColorStateList)
  {
    int j = 0;
    if (b())
    {
      c localc = this.i;
      if (localc.s != paramColorStateList)
      {
        localc.s = paramColorStateList;
        Paint localPaint = localc.g;
        if (paramColorStateList != null) {
          j = paramColorStateList.getColorForState(localc.o.getDrawableState(), 0);
        }
        localPaint.setColor(j);
        localc.c();
      }
    }
  }
  
  public final void setStrokeColorResource(int paramInt)
  {
    if (b()) {
      setStrokeColor(android.support.v7.b.a.a.a(getContext(), paramInt));
    }
  }
  
  public final void setStrokeWidth(int paramInt)
  {
    if (b())
    {
      c localc = this.i;
      if (localc.u != paramInt)
      {
        localc.u = paramInt;
        localc.g.setStrokeWidth(paramInt);
        localc.c();
      }
    }
  }
  
  public final void setStrokeWidthResource(int paramInt)
  {
    if (b()) {
      setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public final void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (b())
    {
      localc = this.i;
      if (localc.d != paramColorStateList)
      {
        localc.d = paramColorStateList;
        if (!c.a) {
          break label36;
        }
        localc.a();
      }
    }
    label36:
    while (this.i == null)
    {
      c localc;
      do
      {
        return;
        paramColorStateList = localc.v;
      } while (paramColorStateList == null);
      android.support.v4.a.a.a.a(paramColorStateList, localc.d);
      return;
    }
    super.setSupportBackgroundTintList(paramColorStateList);
  }
  
  public final void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (b())
    {
      localObject = this.i;
      if (((c)localObject).e != paramMode)
      {
        ((c)localObject).e = paramMode;
        if (!c.a) {
          break label36;
        }
        ((c)localObject).a();
      }
    }
    label36:
    while (this.i == null)
    {
      Object localObject;
      do
      {
        do
        {
          return;
          paramMode = ((c)localObject).v;
        } while (paramMode == null);
        localObject = ((c)localObject).e;
      } while (localObject == null);
      android.support.v4.a.a.a.a(paramMode, (PorterDuff.Mode)localObject);
      return;
    }
    super.setSupportBackgroundTintMode(paramMode);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */