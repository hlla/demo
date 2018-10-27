package android.support.design.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.design.internal.CheckableImageButton;
import android.support.design.internal.n;
import android.support.design.internal.o;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ac;
import android.support.v4.widget.av;
import android.support.v7.widget.ae;
import android.support.v7.widget.al;
import android.support.v7.widget.bb;
import android.support.v7.widget.bw;
import android.support.v7.widget.hf;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class TextInputLayout
  extends LinearLayout
{
  private EditText A;
  private Drawable B;
  private int C;
  private ColorStateList D;
  private boolean E;
  private boolean F;
  private boolean G;
  private CharSequence H;
  private boolean I;
  private boolean J;
  private boolean K;
  private final int L;
  private boolean M;
  private final b N = new b(this);
  private final FrameLayout O;
  private boolean P;
  private Drawable Q;
  private CharSequence R;
  private CharSequence S;
  private Drawable T;
  private Drawable U;
  private boolean V;
  private ColorStateList W;
  public final android.support.design.internal.e a = new android.support.design.internal.e(this);
  private PorterDuff.Mode aa;
  private CheckableImageButton ab;
  private boolean ac;
  private final Rect ad = new Rect();
  private final RectF ae = new RectF();
  private Typeface af;
  public boolean b;
  public boolean c;
  public TextView d;
  public boolean e;
  private ValueAnimator f;
  private GradientDrawable g;
  private int h;
  private int i;
  private final int j;
  private final int k;
  private float l;
  private float m;
  private float n;
  private float o;
  private final int p;
  private int q;
  private final int r;
  private final int s;
  private int t;
  private int u;
  private final int v;
  private final int w;
  private ColorStateList x;
  private final int y;
  private final int z;
  
  public TextInputLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969656);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(n.a(paramContext, paramAttributeSet, paramInt), paramAttributeSet, paramInt);
    setOrientation(1);
    setWillNotDraw(false);
    setAddStatesFromChildren(true);
    this.O = new FrameLayout(paramContext);
    this.O.setAddStatesFromChildren(true);
    addView(this.O);
    Object localObject = this.a;
    ((android.support.design.internal.e)localObject).x = android.support.design.a.a.d;
    ((android.support.design.internal.e)localObject).d();
    localObject = this.a;
    ((android.support.design.internal.e)localObject).s = android.support.design.a.a.d;
    ((android.support.design.internal.e)localObject).d();
    this.a.a(8388659);
    paramAttributeSet = n.a(paramContext, paramAttributeSet, d.a, paramInt, new int[0]);
    this.J = paramAttributeSet.a(d.v, true);
    setHint(paramAttributeSet.c(d.b));
    this.I = paramAttributeSet.a(d.u, true);
    this.j = paramContext.getResources().getDimensionPixelOffset(2131166408);
    this.p = paramContext.getResources().getDimensionPixelOffset(2131166411);
    this.k = paramAttributeSet.d(d.f, 0);
    this.o = paramAttributeSet.f(d.j);
    this.n = paramAttributeSet.f(d.i);
    this.l = paramAttributeSet.f(d.g);
    this.m = paramAttributeSet.f(d.h);
    this.h = paramAttributeSet.b(d.d, 0);
    this.C = paramAttributeSet.b(d.k, 0);
    this.r = paramContext.getResources().getDimensionPixelSize(2131166413);
    this.s = paramContext.getResources().getDimensionPixelSize(2131166414);
    this.t = this.r;
    setBoxBackgroundMode(paramAttributeSet.a(d.e, 0));
    if (paramAttributeSet.g(d.c))
    {
      localObject = paramAttributeSet.e(d.c);
      this.D = ((ColorStateList)localObject);
      this.x = ((ColorStateList)localObject);
    }
    this.y = android.support.v4.content.d.c(paramContext, 2131099933);
    this.z = android.support.v4.content.d.c(paramContext, 2131099934);
    this.L = android.support.v4.content.d.c(paramContext, 2131099936);
    if (paramAttributeSet.g(d.w, -1) != -1) {
      setHintTextAppearance(paramAttributeSet.g(d.w, 0));
    }
    paramInt = paramAttributeSet.g(d.q, 0);
    boolean bool1 = paramAttributeSet.a(d.p, false);
    int i1 = paramAttributeSet.g(d.t, 0);
    boolean bool2 = paramAttributeSet.a(d.s, false);
    paramContext = paramAttributeSet.c(d.r);
    boolean bool3 = paramAttributeSet.a(d.l, false);
    setCounterMaxLength(paramAttributeSet.a(d.m, -1));
    this.w = paramAttributeSet.g(d.o, 0);
    this.v = paramAttributeSet.g(d.n, 0);
    this.V = paramAttributeSet.a(d.z, false);
    this.T = paramAttributeSet.a(d.y);
    this.S = paramAttributeSet.c(d.x);
    if (paramAttributeSet.g(d.A))
    {
      this.E = true;
      this.W = paramAttributeSet.e(d.A);
    }
    if (paramAttributeSet.g(d.B))
    {
      this.F = true;
      this.aa = o.a(paramAttributeSet.a(d.B, -1), null);
    }
    paramAttributeSet.c.recycle();
    setHelperTextEnabled(bool2);
    setHelperText(paramContext);
    setHelperTextTextAppearance(i1);
    setErrorEnabled(bool1);
    setErrorTextAppearance(paramInt);
    setCounterEnabled(bool3);
    k();
    ac.b(this, 2);
  }
  
  private final void a(float paramFloat)
  {
    if (this.a.n != paramFloat)
    {
      if (this.f == null)
      {
        this.f = new ValueAnimator();
        this.f.setInterpolator(android.support.design.a.a.c);
        this.f.setDuration(167L);
        this.f.addUpdateListener(new h(this));
      }
      this.f.setFloatValues(new float[] { this.a.n, paramFloat });
      this.f.start();
    }
  }
  
  private static void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int i2 = paramViewGroup.getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      View localView = paramViewGroup.getChildAt(i1);
      localView.setEnabled(paramBoolean);
      if (!(localView instanceof ViewGroup)) {}
      for (;;)
      {
        i1 += 1;
        break;
        a((ViewGroup)localView, paramBoolean);
      }
    }
  }
  
  private final void a(CharSequence paramCharSequence)
  {
    android.support.design.internal.e locale;
    if (!TextUtils.equals(paramCharSequence, this.H))
    {
      this.H = paramCharSequence;
      locale = this.a;
      if (paramCharSequence != null) {
        break label55;
      }
    }
    for (;;)
    {
      locale.v = paramCharSequence;
      locale.y = null;
      locale.e();
      locale.d();
      label55:
      do
      {
        if (!this.K) {
          m();
        }
        return;
      } while (paramCharSequence.equals(locale.v));
    }
  }
  
  private final Drawable c()
  {
    int i1 = this.i;
    if ((i1 != 1) && (i1 != 2)) {
      throw new IllegalStateException();
    }
    return this.g;
  }
  
  private final void d()
  {
    int i1 = this.i;
    if (i1 == 0) {
      this.g = null;
    }
    for (;;)
    {
      if (this.i != 0) {
        e();
      }
      f();
      return;
      if (i1 != 2)
      {
        if (!(this.g instanceof GradientDrawable)) {
          this.g = new GradientDrawable();
        }
      }
      else
      {
        if ((!this.J) || ((this.g instanceof a))) {
          break;
        }
        this.g = new a();
      }
    }
  }
  
  private final void e()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.O.getLayoutParams();
    int i1 = g();
    if (i1 != localLayoutParams.topMargin)
    {
      localLayoutParams.topMargin = i1;
      this.O.requestLayout();
    }
  }
  
  private final void f()
  {
    int i2 = 0;
    int i4;
    Object localObject1;
    int i1;
    if ((this.i != 0) && (this.g != null) && (this.A != null) && (getRight() != 0))
    {
      i4 = this.A.getLeft();
      localObject1 = this.A;
      i1 = i2;
      if (localObject1 != null) {
        switch (this.i)
        {
        default: 
          i1 = i2;
        }
      }
    }
    for (;;)
    {
      i2 = this.A.getRight();
      int i5 = this.A.getBottom() + this.j;
      int i3;
      if (this.i == 2)
      {
        int i6 = this.s / 2;
        i5 += i6;
        i2 -= i6;
        i3 = i1 - i6;
        i4 += i6;
      }
      for (i1 = i5;; i1 = i5)
      {
        this.g.setBounds(i4, i3, i2, i1);
        h();
        localObject1 = this.A;
        if (localObject1 != null)
        {
          Object localObject2 = ((EditText)localObject1).getBackground();
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (bw.c((Drawable)localObject2)) {
              localObject1 = ((Drawable)localObject2).mutate();
            }
            localObject2 = new Rect();
            android.support.design.internal.f.a(this, this.A, (Rect)localObject2);
            localObject2 = ((Drawable)localObject1).getBounds();
            if (((Rect)localObject2).left != ((Rect)localObject2).right)
            {
              Rect localRect = new Rect();
              ((Drawable)localObject1).getPadding(localRect);
              i1 = ((Rect)localObject2).left;
              i2 = localRect.left;
              i3 = ((Rect)localObject2).right;
              i4 = localRect.right;
              ((Drawable)localObject1).setBounds(i1 - i2, ((Rect)localObject2).top, i4 + i4 + i3, this.A.getBottom());
            }
          }
        }
        return;
        i3 = i1;
      }
      i1 = ((EditText)localObject1).getTop();
      continue;
      i1 = ((EditText)localObject1).getTop() + g();
    }
  }
  
  private final int g()
  {
    if (this.J) {}
    switch (this.i)
    {
    default: 
      return 0;
    case 2: 
      return (int)(this.a.b() / 2.0F);
    }
    return (int)this.a.b();
  }
  
  private final void h()
  {
    if (this.g != null) {
      switch (this.i)
      {
      }
    }
    for (;;)
    {
      Object localObject1 = this.A;
      if ((localObject1 != null) && (this.i == 2))
      {
        if (((EditText)localObject1).getBackground() != null) {
          this.B = this.A.getBackground();
        }
        ac.a(this.A, null);
      }
      localObject1 = this.A;
      if ((localObject1 != null) && (this.i == 1))
      {
        localObject2 = this.B;
        if (localObject2 != null) {
          ac.a((View)localObject1, (Drawable)localObject2);
        }
      }
      int i1 = this.t;
      if (i1 >= 0)
      {
        int i2 = this.q;
        if (i2 != 0) {
          this.g.setStroke(i1, i2);
        }
      }
      Object localObject2 = this.g;
      float f1;
      if (ac.h(this) != 1)
      {
        localObject1 = new float[8];
        f1 = this.o;
        localObject1[0] = f1;
        localObject1[1] = f1;
        f1 = this.n;
        localObject1[2] = f1;
        localObject1[3] = f1;
        f1 = this.l;
        localObject1[4] = f1;
        localObject1[5] = f1;
        f1 = this.m;
        localObject1[6] = f1;
        localObject1[7] = f1;
      }
      for (;;)
      {
        ((GradientDrawable)localObject2).setCornerRadii((float[])localObject1);
        this.g.setColor(this.h);
        invalidate();
        return;
        localObject1 = new float[8];
        f1 = this.n;
        localObject1[0] = f1;
        localObject1[1] = f1;
        f1 = this.o;
        localObject1[2] = f1;
        localObject1[3] = f1;
        f1 = this.m;
        localObject1[4] = f1;
        localObject1[5] = f1;
        f1 = this.l;
        localObject1[6] = f1;
        localObject1[7] = f1;
      }
      if (this.C == 0)
      {
        this.C = this.D.getColorForState(getDrawableState(), this.D.getDefaultColor());
        continue;
        this.t = 0;
      }
    }
  }
  
  private final void i()
  {
    if (this.A != null)
    {
      if ((this.V) && ((j()) || (this.ac))) {
        break label104;
      }
      localObject = this.ab;
      if ((localObject != null) && (((CheckableImageButton)localObject).getVisibility() == 0)) {
        this.ab.setVisibility(8);
      }
      if (this.U != null)
      {
        localObject = av.a(this.A);
        if (localObject[2] == this.U)
        {
          av.a(this.A, localObject[0], localObject[1], this.Q, localObject[3]);
          this.U = null;
        }
      }
    }
    return;
    label104:
    if (this.ab == null)
    {
      this.ab = ((CheckableImageButton)LayoutInflater.from(getContext()).inflate(2131624148, this.O, false));
      this.ab.setImageDrawable(this.T);
      this.ab.setContentDescription(this.S);
      this.O.addView(this.ab);
      this.ab.setOnClickListener(new g(this));
    }
    Object localObject = this.A;
    if ((localObject != null) && (ac.s((View)localObject) <= 0)) {
      this.A.setMinimumHeight(ac.s(this.ab));
    }
    this.ab.setVisibility(0);
    this.ab.setChecked(this.ac);
    if (this.U == null) {
      this.U = new ColorDrawable();
    }
    this.U.setBounds(0, 0, this.ab.getMeasuredWidth(), 1);
    localObject = av.a(this.A);
    Drawable localDrawable1 = localObject[2];
    Drawable localDrawable2 = this.U;
    if (localDrawable1 != localDrawable2) {
      this.Q = localDrawable1;
    }
    av.a(this.A, localObject[0], localObject[1], localDrawable2, localObject[3]);
    this.ab.setPadding(this.A.getPaddingLeft(), this.A.getPaddingTop(), this.A.getPaddingRight(), this.A.getPaddingBottom());
  }
  
  private final boolean j()
  {
    EditText localEditText = this.A;
    return (localEditText != null) && ((localEditText.getTransformationMethod() instanceof PasswordTransformationMethod));
  }
  
  private final void k()
  {
    Object localObject = this.T;
    if ((localObject != null) && ((this.E) || (this.F)))
    {
      this.T = android.support.v4.a.a.a.f((Drawable)localObject).mutate();
      if (this.E) {
        android.support.v4.a.a.a.a(this.T, this.W);
      }
      if (this.F) {
        android.support.v4.a.a.a.a(this.T, this.aa);
      }
      localObject = this.ab;
      if (localObject != null)
      {
        localObject = ((CheckableImageButton)localObject).getDrawable();
        Drawable localDrawable = this.T;
        if (localObject != localDrawable) {
          this.ab.setImageDrawable(localDrawable);
        }
      }
    }
  }
  
  private final boolean l()
  {
    return (this.J) && (!TextUtils.isEmpty(this.H)) && ((this.g instanceof a));
  }
  
  private final void m()
  {
    RectF localRectF;
    android.support.design.internal.e locale;
    boolean bool;
    if (l())
    {
      localRectF = this.ae;
      locale = this.a;
      bool = locale.a(locale.v);
      if (!bool) {
        break label202;
      }
    }
    label202:
    for (float f1 = locale.b.right - locale.a();; f1 = locale.b.left)
    {
      localRectF.left = f1;
      localRectF.top = locale.b.top;
      if (bool) {}
      for (f1 = locale.b.right;; f1 = localRectF.left + locale.a())
      {
        localRectF.right = f1;
        localRectF.bottom = (locale.b.top + locale.b());
        localRectF.left -= this.p;
        localRectF.top -= this.p;
        localRectF.right += this.p;
        localRectF.bottom += this.p;
        ((a)this.g).a(localRectF.left, localRectF.top, localRectF.right, localRectF.bottom);
        return;
      }
    }
  }
  
  final void a()
  {
    Object localObject1 = this.A;
    int i1;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((EditText)localObject1).getBackground();
      if (localObject1 != null)
      {
        i1 = Build.VERSION.SDK_INT;
        if (i1 != 21) {
          break label190;
        }
        localObject2 = this.A.getBackground();
        if ((localObject2 != null) && (!this.G))
        {
          Drawable localDrawable = ((Drawable)localObject2).getConstantState().newDrawable();
          if ((localObject2 instanceof DrawableContainer)) {
            this.G = android.support.design.internal.g.a((DrawableContainer)localObject2, localDrawable.getConstantState());
          }
          if (!this.G)
          {
            ac.a(this.A, localDrawable);
            this.G = true;
            d();
          }
        }
      }
    }
    for (;;)
    {
      if (bw.c((Drawable)localObject1)) {
        localObject1 = ((Drawable)localObject1).mutate();
      }
      for (;;)
      {
        if (this.N.d())
        {
          ((Drawable)localObject1).setColorFilter(ae.a(this.N.e(), PorterDuff.Mode.SRC_IN));
          return;
        }
        if (this.c)
        {
          localObject2 = this.d;
          if (localObject2 != null)
          {
            ((Drawable)localObject1).setColorFilter(ae.a(((TextView)localObject2).getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            return;
          }
        }
        android.support.v4.a.a.a.e((Drawable)localObject1);
        this.A.refreshDrawableState();
        return;
      }
      label190:
      if (i1 == 22) {
        break;
      }
    }
  }
  
  final void a(int paramInt)
  {
    boolean bool2 = this.c;
    if (this.u == -1)
    {
      this.d.setText(String.valueOf(paramInt));
      this.d.setContentDescription(null);
      this.c = false;
      if ((this.A != null) && (bool2 != this.c))
      {
        a(false, false);
        b();
        a();
      }
      return;
    }
    if (ac.m(this.d) == 1) {
      ac.d(this.d, 0);
    }
    if (paramInt > this.u) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.c = bool1;
      bool1 = this.c;
      TextView localTextView;
      if (bool2 != bool1)
      {
        localTextView = this.d;
        if (bool1) {
          break label240;
        }
      }
      label240:
      for (int i1 = this.w;; i1 = this.v)
      {
        a(localTextView, i1);
        if (this.c) {
          ac.d(this.d, 1);
        }
        localTextView = this.d;
        Context localContext = getContext();
        Integer localInteger = Integer.valueOf(paramInt);
        localTextView.setText(localContext.getString(2131951855, new Object[] { localInteger, Integer.valueOf(this.u) }));
        this.d.setContentDescription(getContext().getString(2131951854, new Object[] { localInteger, Integer.valueOf(this.u) }));
        break;
      }
    }
  }
  
  final void a(TextView paramTextView, int paramInt)
  {
    try
    {
      av.a(paramTextView, paramInt);
      if (Build.VERSION.SDK_INT < 23) {
        break label49;
      }
      paramInt = paramTextView.getTextColors().getDefaultColor();
      if (paramInt != -65281) {
        break label49;
      }
    }
    catch (Exception localException)
    {
      label49:
      for (;;) {}
    }
    av.a(paramTextView, 2132018071);
    paramTextView.setTextColor(android.support.v4.content.d.c(getContext(), 2131099771));
  }
  
  public final void a(boolean paramBoolean)
  {
    int i1;
    if (this.V)
    {
      i1 = this.A.getSelectionEnd();
      if (!j()) {
        break label66;
      }
      this.A.setTransformationMethod(null);
    }
    for (this.ac = true;; this.ac = false)
    {
      this.ab.setChecked(this.ac);
      if (paramBoolean) {
        this.ab.jumpDrawablesToCurrentState();
      }
      this.A.setSelection(i1);
      return;
      label66:
      this.A.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
  }
  
  final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool1 = isEnabled();
    Object localObject = this.A;
    int i1;
    if (localObject != null) {
      if (!TextUtils.isEmpty(((EditText)localObject).getText())) {
        i1 = 1;
      }
    }
    for (;;)
    {
      localObject = this.A;
      int i2;
      if (localObject != null) {
        if (((EditText)localObject).hasFocus()) {
          i2 = 1;
        }
      }
      for (;;)
      {
        boolean bool2 = this.N.d();
        localObject = this.x;
        if (localObject != null)
        {
          this.a.a((ColorStateList)localObject);
          this.a.b(this.x);
        }
        if (!bool1)
        {
          this.a.a(ColorStateList.valueOf(this.z));
          this.a.b(ColorStateList.valueOf(this.z));
        }
        for (;;)
        {
          if (i1 == 0) {
            if (isEnabled()) {}
          }
          for (;;)
          {
            if (paramBoolean2) {}
            label214:
            while (!this.K)
            {
              localObject = this.f;
              if (localObject == null) {}
              for (;;)
              {
                if (!paramBoolean1)
                {
                  break label214;
                  break label214;
                  this.a.a(0.0F);
                }
                for (;;)
                {
                  if ((l()) && ((((a)this.g).a.isEmpty() ^ true)) && (l())) {
                    ((a)this.g).a(0.0F, 0.0F, 0.0F, 0.0F);
                  }
                  this.K = true;
                  return;
                  if (!this.I) {
                    break;
                  }
                  a(0.0F);
                }
                if (((ValueAnimator)localObject).isRunning()) {
                  this.f.cancel();
                }
              }
            }
            return;
            if (i2 != 0) {}
            label280:
            while (bool2)
            {
              if (paramBoolean2) {}
              for (;;)
              {
                localObject = this.f;
                if (localObject == null) {}
                for (;;)
                {
                  if (!paramBoolean1) {
                    this.a.a(1.0F);
                  }
                  for (;;)
                  {
                    this.K = false;
                    if (!l()) {
                      break;
                    }
                    m();
                    return;
                    if (!this.I) {
                      break label280;
                    }
                    a(1.0F);
                  }
                  if (((ValueAnimator)localObject).isRunning()) {
                    this.f.cancel();
                  }
                }
                if (!this.K) {
                  break;
                }
              }
            }
          }
          if (bool2)
          {
            android.support.design.internal.e locale = this.a;
            localObject = this.N.h;
            if (localObject != null) {}
            for (localObject = ((TextView)localObject).getTextColors();; localObject = null)
            {
              locale.a((ColorStateList)localObject);
              break;
            }
          }
          if (this.c)
          {
            localObject = this.d;
            if (localObject != null)
            {
              this.a.a(((TextView)localObject).getTextColors());
              continue;
            }
          }
          if (i2 != 0)
          {
            localObject = this.D;
            if (localObject != null) {
              this.a.a((ColorStateList)localObject);
            }
          }
        }
        i2 = 0;
        continue;
        i2 = 0;
      }
      i1 = 0;
      continue;
      i1 = 0;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof EditText))
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      localLayoutParams.gravity = (localLayoutParams.gravity & 0xFFFFFF8F | 0x10);
      this.O.addView(paramView, localLayoutParams);
      this.O.setLayoutParams(paramLayoutParams);
      e();
      paramView = (EditText)paramView;
      if (this.A != null) {
        throw new IllegalArgumentException("We already have an EditText, can only have one");
      }
      if (!(paramView instanceof e)) {
        Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
      }
      this.A = paramView;
      d();
      setTextInputAccessibilityDelegate(new i(this));
      if (!j()) {
        this.a.a(this.A.getTypeface());
      }
      paramView = this.a;
      float f1 = this.A.getTextSize();
      if (paramView.q != f1)
      {
        paramView.q = f1;
        paramView.d();
      }
      paramInt = this.A.getGravity();
      this.a.a(paramInt & 0xFFFFFF8F | 0x30);
      paramView = this.a;
      if (paramView.p != paramInt)
      {
        paramView.p = paramInt;
        paramView.d();
      }
      this.A.addTextChangedListener(new f(this));
      if (this.x == null) {
        this.x = this.A.getHintTextColors();
      }
      if (this.J)
      {
        if (TextUtils.isEmpty(this.H))
        {
          this.R = this.A.getHint();
          setHint(this.R);
          this.A.setHint(null);
        }
        this.P = true;
      }
      if (this.d != null) {
        a(this.A.getText().length());
      }
      this.N.c();
      i();
      a(false, true);
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  final void b()
  {
    int i3 = 0;
    Object localObject;
    int i1;
    if ((this.g != null) && (this.i != 0))
    {
      localObject = this.A;
      if (localObject == null) {
        break label227;
      }
      if (!((EditText)localObject).hasFocus()) {
        break label222;
      }
      i1 = 1;
    }
    for (;;)
    {
      localObject = this.A;
      int i2 = i3;
      if (localObject != null)
      {
        i2 = i3;
        if (((EditText)localObject).isHovered()) {
          i2 = 1;
        }
      }
      if (this.i == 2)
      {
        if (isEnabled()) {
          break label127;
        }
        this.q = this.z;
      }
      for (;;)
      {
        if (i2 != 0) {}
        for (;;)
        {
          if (isEnabled())
          {
            this.t = this.s;
            h();
            return;
          }
          do
          {
            this.t = this.r;
            break;
          } while (i1 == 0);
        }
        label127:
        if (this.N.d())
        {
          this.q = this.N.e();
        }
        else
        {
          if (this.c)
          {
            localObject = this.d;
            if (localObject != null)
            {
              this.q = ((TextView)localObject).getCurrentTextColor();
              continue;
            }
          }
          if (i1 != 0) {
            this.q = this.C;
          } else if (i2 == 0) {
            this.q = this.y;
          } else {
            this.q = this.L;
          }
        }
      }
      label222:
      i1 = 0;
      continue;
      label227:
      i1 = 0;
    }
  }
  
  public void dispatchProvideAutofillStructure(ViewStructure paramViewStructure, int paramInt)
  {
    if (this.R != null)
    {
      localObject = this.A;
      if (localObject != null) {}
    }
    else
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      return;
    }
    boolean bool = this.P;
    this.P = false;
    Object localObject = ((EditText)localObject).getHint();
    this.A.setHint(this.R);
    try
    {
      super.dispatchProvideAutofillStructure(paramViewStructure, paramInt);
      return;
    }
    finally
    {
      this.A.setHint((CharSequence)localObject);
      this.P = bool;
    }
  }
  
  protected void dispatchRestoreInstanceState(SparseArray paramSparseArray)
  {
    this.e = true;
    super.dispatchRestoreInstanceState(paramSparseArray);
    this.e = false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject = this.g;
    if (localObject != null) {
      ((GradientDrawable)localObject).draw(paramCanvas);
    }
    super.draw(paramCanvas);
    int i2;
    float f4;
    float f3;
    int i1;
    if (this.J)
    {
      localObject = this.a;
      i2 = paramCanvas.save();
      if ((((android.support.design.internal.e)localObject).y != null) && (((android.support.design.internal.e)localObject).l))
      {
        f4 = ((android.support.design.internal.e)localObject).j;
        f3 = ((android.support.design.internal.e)localObject).k;
        if (!((android.support.design.internal.e)localObject).B) {
          break label231;
        }
        if (((android.support.design.internal.e)localObject).r == null) {
          break label225;
        }
        i1 = 1;
      }
    }
    for (;;)
    {
      if (i1 == 0)
      {
        ((android.support.design.internal.e)localObject).w.ascent();
        ((android.support.design.internal.e)localObject).w.descent();
      }
      for (float f2 = 0.0F;; f2 = ((android.support.design.internal.e)localObject).z * ((android.support.design.internal.e)localObject).t)
      {
        float f1 = f3;
        if (i1 != 0) {
          f1 = f3 + f2;
        }
        f2 = ((android.support.design.internal.e)localObject).t;
        if (f2 != 1.0F) {
          paramCanvas.scale(f2, f2, f4, f1);
        }
        if (i1 == 0)
        {
          CharSequence localCharSequence = ((android.support.design.internal.e)localObject).y;
          paramCanvas.drawText(localCharSequence, 0, localCharSequence.length(), f4, f1, ((android.support.design.internal.e)localObject).w);
        }
        for (;;)
        {
          paramCanvas.restoreToCount(i2);
          return;
          paramCanvas.drawBitmap(((android.support.design.internal.e)localObject).r, f4, f1, ((android.support.design.internal.e)localObject).A);
        }
      }
      label225:
      i1 = 0;
      continue;
      label231:
      i1 = 0;
    }
  }
  
  protected void drawableStateChanged()
  {
    boolean bool = true;
    Object localObject;
    if (!this.M)
    {
      this.M = true;
      super.drawableStateChanged();
      localObject = getDrawableState();
      if (!ac.I(this)) {
        break label123;
      }
      if (!isEnabled()) {
        break label118;
      }
    }
    for (;;)
    {
      a(bool, false);
      a();
      f();
      b();
      android.support.design.internal.e locale = this.a;
      if (locale != null)
      {
        locale.u = ((int[])localObject);
        localObject = locale.g;
        if (localObject != null) {
          break label108;
        }
      }
      for (;;)
      {
        localObject = locale.o;
        if ((localObject != null) && (((ColorStateList)localObject).isStateful())) {}
        label108:
        do
        {
          locale.d();
          invalidate();
          this.M = false;
          return;
        } while (((ColorStateList)localObject).isStateful());
      }
      label118:
      bool = false;
      continue;
      label123:
      bool = false;
    }
  }
  
  public int getBoxBackgroundColor()
  {
    return this.h;
  }
  
  public float getBoxCornerRadiusBottomEnd()
  {
    return this.l;
  }
  
  public float getBoxCornerRadiusBottomStart()
  {
    return this.m;
  }
  
  public float getBoxCornerRadiusTopEnd()
  {
    return this.n;
  }
  
  public float getBoxCornerRadiusTopStart()
  {
    return this.o;
  }
  
  public int getBoxStrokeColor()
  {
    return this.C;
  }
  
  public int getCounterMaxLength()
  {
    return this.u;
  }
  
  public ColorStateList getDefaultHintTextColor()
  {
    return this.x;
  }
  
  public EditText getEditText()
  {
    return this.A;
  }
  
  public CharSequence getError()
  {
    b localb = this.N;
    if (localb.e) {
      return localb.f;
    }
    return null;
  }
  
  public int getErrorCurrentTextColors()
  {
    return this.N.e();
  }
  
  public CharSequence getHelperText()
  {
    b localb = this.N;
    if (localb.j) {
      return localb.i;
    }
    return null;
  }
  
  public int getHelperTextCurrentTextColor()
  {
    TextView localTextView = this.N.l;
    if (localTextView != null) {
      return localTextView.getCurrentTextColor();
    }
    return -1;
  }
  
  public CharSequence getHint()
  {
    if (this.J) {
      return this.H;
    }
    return null;
  }
  
  public CharSequence getPasswordVisibilityToggleContentDescription()
  {
    return this.S;
  }
  
  public Drawable getPasswordVisibilityToggleDrawable()
  {
    return this.T;
  }
  
  public Typeface getTypeface()
  {
    return this.af;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.g != null) {
      f();
    }
    Object localObject2;
    Object localObject1;
    int i1;
    if (this.J)
    {
      localObject2 = this.A;
      if (localObject2 != null)
      {
        localObject1 = this.ad;
        android.support.design.internal.f.a(this, (View)localObject2, (Rect)localObject1);
        paramInt1 = ((Rect)localObject1).left;
        paramInt3 = this.A.getCompoundPaddingLeft() + paramInt1;
        i1 = ((Rect)localObject1).right - this.A.getCompoundPaddingRight();
        switch (this.i)
        {
        default: 
          paramInt1 = getPaddingTop();
        }
      }
    }
    for (;;)
    {
      localObject2 = this.a;
      int i2 = ((Rect)localObject1).top + this.A.getCompoundPaddingTop();
      int i3 = ((Rect)localObject1).bottom - this.A.getCompoundPaddingBottom();
      if (!android.support.design.internal.e.a(((android.support.design.internal.e)localObject2).m, paramInt3, i2, i1, i3))
      {
        ((android.support.design.internal.e)localObject2).m.set(paramInt3, i2, i1, i3);
        ((android.support.design.internal.e)localObject2).a = true;
        ((android.support.design.internal.e)localObject2).c();
      }
      localObject1 = this.a;
      paramInt2 = paramInt4 - paramInt2 - getPaddingBottom();
      if (!android.support.design.internal.e.a(((android.support.design.internal.e)localObject1).b, paramInt3, paramInt1, i1, paramInt2))
      {
        ((android.support.design.internal.e)localObject1).b.set(paramInt3, paramInt1, i1, paramInt2);
        ((android.support.design.internal.e)localObject1).a = true;
        ((android.support.design.internal.e)localObject1).c();
      }
      this.a.d();
      if ((l()) && (!this.K)) {
        m();
      }
      return;
      paramInt1 = c().getBounds().top - g();
      continue;
      paramInt1 = c().getBounds().top + this.k;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    i();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof TextInputLayout.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (TextInputLayout.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.e);
    setError(paramParcelable.a);
    if (paramParcelable.b) {
      a(true);
    }
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    TextInputLayout.SavedState localSavedState = new TextInputLayout.SavedState(super.onSaveInstanceState());
    if (this.N.d()) {
      localSavedState.a = getError();
    }
    localSavedState.b = this.ac;
    return localSavedState;
  }
  
  public void setBoxBackgroundColor(int paramInt)
  {
    if (this.h != paramInt)
    {
      this.h = paramInt;
      h();
    }
  }
  
  public void setBoxBackgroundColorResource(int paramInt)
  {
    setBoxBackgroundColor(android.support.v4.content.d.c(getContext(), paramInt));
  }
  
  public void setBoxBackgroundMode(int paramInt)
  {
    if (paramInt != this.i)
    {
      this.i = paramInt;
      d();
    }
  }
  
  public void setBoxStrokeColor(int paramInt)
  {
    if (this.C != paramInt)
    {
      this.C = paramInt;
      b();
    }
  }
  
  public void setCounterEnabled(boolean paramBoolean)
  {
    Object localObject;
    if (this.b != paramBoolean)
    {
      if (!paramBoolean) {
        break label122;
      }
      this.d = new bb(getContext());
      this.d.setId(2131429459);
      localObject = this.af;
      if (localObject != null) {
        this.d.setTypeface((Typeface)localObject);
      }
      this.d.setMaxLines(1);
      a(this.d, this.w);
      this.N.a(this.d, 2);
      localObject = this.A;
      if (localObject != null) {
        break label106;
      }
      a(0);
    }
    for (;;)
    {
      this.b = paramBoolean;
      return;
      label106:
      a(((EditText)localObject).getText().length());
      continue;
      label122:
      this.N.b(this.d, 2);
      this.d = null;
    }
  }
  
  public void setCounterMaxLength(int paramInt)
  {
    if (this.u != paramInt) {
      if (paramInt > 0) {
        break label54;
      }
    }
    label49:
    label54:
    for (this.u = -1;; this.u = paramInt)
    {
      EditText localEditText;
      if (this.b)
      {
        localEditText = this.A;
        if (localEditText == null) {
          break label49;
        }
      }
      for (paramInt = localEditText.getText().length();; paramInt = 0)
      {
        a(paramInt);
        return;
      }
    }
  }
  
  public void setDefaultHintTextColor(ColorStateList paramColorStateList)
  {
    this.x = paramColorStateList;
    this.D = paramColorStateList;
    if (this.A != null) {
      a(false, false);
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    a(this, paramBoolean);
    super.setEnabled(paramBoolean);
  }
  
  public void setError(CharSequence paramCharSequence)
  {
    if (!this.N.e)
    {
      if (!TextUtils.isEmpty(paramCharSequence)) {
        setErrorEnabled(true);
      }
    }
    else
    {
      if (TextUtils.isEmpty(paramCharSequence)) {
        break label85;
      }
      b localb = this.N;
      localb.b();
      localb.f = paramCharSequence;
      localb.h.setText(paramCharSequence);
      int i1 = localb.b;
      if (i1 != 1) {
        localb.c = 1;
      }
      localb.a(i1, localb.c, localb.a(localb.h, paramCharSequence));
    }
    return;
    label85:
    this.N.a();
  }
  
  public void setErrorEnabled(boolean paramBoolean)
  {
    b localb = this.N;
    if (localb.e != paramBoolean)
    {
      localb.b();
      if (!paramBoolean) {
        break label102;
      }
      localb.h = new bb(localb.d);
      localb.h.setId(2131429460);
      Typeface localTypeface = localb.n;
      if (localTypeface != null) {
        localb.h.setTypeface(localTypeface);
      }
      localb.a(localb.g);
      localb.h.setVisibility(4);
      ac.d(localb.h, 1);
      localb.a(localb.h, 0);
    }
    for (;;)
    {
      localb.e = paramBoolean;
      return;
      label102:
      localb.a();
      localb.b(localb.h, 0);
      localb.h = null;
      localb.m.a();
      localb.m.b();
    }
  }
  
  public void setErrorTextAppearance(int paramInt)
  {
    this.N.a(paramInt);
  }
  
  public void setErrorTextColor(ColorStateList paramColorStateList)
  {
    TextView localTextView = this.N.h;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  public void setHelperText(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence))
    {
      if (this.N.j) {
        setHelperTextEnabled(false);
      }
      return;
    }
    if (!this.N.j) {
      setHelperTextEnabled(true);
    }
    b localb = this.N;
    localb.b();
    localb.i = paramCharSequence;
    localb.l.setText(paramCharSequence);
    int i1 = localb.b;
    if (i1 != 2) {
      localb.c = 2;
    }
    localb.a(i1, localb.c, localb.a(localb.l, paramCharSequence));
  }
  
  public void setHelperTextColor(ColorStateList paramColorStateList)
  {
    TextView localTextView = this.N.l;
    if (localTextView != null) {
      localTextView.setTextColor(paramColorStateList);
    }
  }
  
  public void setHelperTextEnabled(boolean paramBoolean)
  {
    b localb = this.N;
    if (localb.j != paramBoolean)
    {
      localb.b();
      if (!paramBoolean) {
        break label105;
      }
      localb.l = new bb(localb.d);
      localb.l.setId(2131429461);
      Typeface localTypeface = localb.n;
      if (localTypeface != null) {
        localb.l.setTypeface(localTypeface);
      }
      localb.l.setVisibility(4);
      ac.d(localb.l, 1);
      localb.b(localb.k);
      localb.a(localb.l, 1);
    }
    for (;;)
    {
      localb.j = paramBoolean;
      return;
      label105:
      localb.b();
      int i1 = localb.b;
      if (i1 == 2) {
        localb.c = 0;
      }
      localb.a(i1, localb.c, localb.a(localb.l, null));
      localb.b(localb.l, 1);
      localb.l = null;
      localb.m.a();
      localb.m.b();
    }
  }
  
  public void setHelperTextTextAppearance(int paramInt)
  {
    this.N.b(paramInt);
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    if (this.J)
    {
      a(paramCharSequence);
      sendAccessibilityEvent(2048);
    }
  }
  
  public void setHintAnimationEnabled(boolean paramBoolean)
  {
    this.I = paramBoolean;
  }
  
  public void setHintEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.J)
    {
      this.J = paramBoolean;
      if (this.J) {
        break label76;
      }
      this.P = false;
      if ((!TextUtils.isEmpty(this.H)) && (TextUtils.isEmpty(this.A.getHint()))) {
        this.A.setHint(this.H);
      }
      a(null);
    }
    for (;;)
    {
      if (this.A != null) {
        e();
      }
      return;
      label76:
      CharSequence localCharSequence = this.A.getHint();
      if (!TextUtils.isEmpty(localCharSequence))
      {
        if (TextUtils.isEmpty(this.H)) {
          setHint(localCharSequence);
        }
        this.A.setHint(null);
      }
      this.P = true;
    }
  }
  
  public void setHintTextAppearance(int paramInt)
  {
    android.support.design.internal.e locale = this.a;
    hf localhf = hf.a(locale.C.getContext(), paramInt, android.support.v7.a.a.da);
    if (localhf.g(android.support.v7.a.a.dg)) {
      locale.g = localhf.e(android.support.v7.a.a.dg);
    }
    if (localhf.g(android.support.v7.a.a.dj)) {
      locale.h = localhf.e(android.support.v7.a.a.dj, (int)locale.h);
    }
    locale.c = localhf.a(android.support.v7.a.a.dc, 0);
    locale.d = localhf.a(android.support.v7.a.a.dd, 0.0F);
    locale.e = localhf.a(android.support.v7.a.a.de, 0.0F);
    locale.f = localhf.a(android.support.v7.a.a.df, 0.0F);
    localhf.c.recycle();
    locale.i = locale.b(paramInt);
    locale.d();
    this.D = this.a.g;
    if (this.A != null)
    {
      a(false, false);
      e();
    }
  }
  
  public void setPasswordVisibilityToggleContentDescription(int paramInt)
  {
    if (paramInt != 0) {}
    for (CharSequence localCharSequence = getResources().getText(paramInt);; localCharSequence = null)
    {
      setPasswordVisibilityToggleContentDescription(localCharSequence);
      return;
    }
  }
  
  public void setPasswordVisibilityToggleContentDescription(CharSequence paramCharSequence)
  {
    this.S = paramCharSequence;
    CheckableImageButton localCheckableImageButton = this.ab;
    if (localCheckableImageButton != null) {
      localCheckableImageButton.setContentDescription(paramCharSequence);
    }
  }
  
  public void setPasswordVisibilityToggleDrawable(int paramInt)
  {
    if (paramInt != 0) {}
    for (Drawable localDrawable = android.support.v7.b.a.a.b(getContext(), paramInt);; localDrawable = null)
    {
      setPasswordVisibilityToggleDrawable(localDrawable);
      return;
    }
  }
  
  public void setPasswordVisibilityToggleDrawable(Drawable paramDrawable)
  {
    this.T = paramDrawable;
    CheckableImageButton localCheckableImageButton = this.ab;
    if (localCheckableImageButton != null) {
      localCheckableImageButton.setImageDrawable(paramDrawable);
    }
  }
  
  public void setPasswordVisibilityToggleEnabled(boolean paramBoolean)
  {
    if (this.V != paramBoolean)
    {
      this.V = paramBoolean;
      if ((!paramBoolean) && (this.ac))
      {
        EditText localEditText = this.A;
        if (localEditText != null) {
          localEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
      }
      this.ac = false;
      i();
    }
  }
  
  public void setPasswordVisibilityToggleTintList(ColorStateList paramColorStateList)
  {
    this.W = paramColorStateList;
    this.E = true;
    k();
  }
  
  public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode paramMode)
  {
    this.aa = paramMode;
    this.F = true;
    k();
  }
  
  public void setTextInputAccessibilityDelegate(i parami)
  {
    EditText localEditText = this.A;
    if (localEditText != null) {
      ac.a(localEditText, parami);
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    if (paramTypeface != this.af)
    {
      this.af = paramTypeface;
      this.a.a(paramTypeface);
      Object localObject = this.N;
      if (paramTypeface != ((b)localObject).n)
      {
        ((b)localObject).n = paramTypeface;
        b.a(((b)localObject).h, paramTypeface);
        b.a(((b)localObject).l, paramTypeface);
      }
      localObject = this.d;
      if (localObject != null) {
        ((TextView)localObject).setTypeface(paramTypeface);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/textfield/TextInputLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */