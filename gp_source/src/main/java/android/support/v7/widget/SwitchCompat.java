package android.support.v7.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ac;
import android.support.v4.widget.av;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import java.util.List;

public class SwitchCompat
  extends CompoundButton
{
  private static final int[] b = { 16842912 };
  private static final Property c = new gz(Float.class, "thumbPos");
  private final TextPaint A = new TextPaint(1);
  private Drawable B;
  private int C;
  private ColorStateList D = null;
  private PorterDuff.Mode E = null;
  private int F;
  private int G;
  private int H;
  private float I;
  private float J;
  private Drawable K;
  private ColorStateList L = null;
  private PorterDuff.Mode M = null;
  private VelocityTracker N = VelocityTracker.obtain();
  public float a;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private int h;
  private Layout i;
  private Layout j;
  private ObjectAnimator k;
  private boolean l;
  private boolean m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private TransformationMethod u;
  private int v;
  private final Rect w = new Rect();
  private ColorStateList x;
  private CharSequence y;
  private CharSequence z;
  
  public SwitchCompat(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969601);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = getResources();
    this.A.density = ((Resources)localObject).getDisplayMetrics().density;
    localObject = hf.a(paramContext, paramAttributeSet, android.support.v7.a.a.cL, paramInt, 0);
    this.B = ((hf)localObject).a(android.support.v7.a.a.cO);
    paramAttributeSet = this.B;
    if (paramAttributeSet != null) {
      paramAttributeSet.setCallback(this);
    }
    this.K = ((hf)localObject).a(android.support.v7.a.a.cX);
    paramAttributeSet = this.K;
    if (paramAttributeSet != null) {
      paramAttributeSet.setCallback(this);
    }
    this.z = ((hf)localObject).c(android.support.v7.a.a.cN);
    this.y = ((hf)localObject).c(android.support.v7.a.a.cM);
    this.l = ((hf)localObject).a(android.support.v7.a.a.cP, true);
    this.C = ((hf)localObject).e(android.support.v7.a.a.cU, 0);
    this.q = ((hf)localObject).e(android.support.v7.a.a.cR, 0);
    this.r = ((hf)localObject).e(android.support.v7.a.a.cS, 0);
    this.m = ((hf)localObject).a(android.support.v7.a.a.cQ, false);
    paramAttributeSet = ((hf)localObject).e(android.support.v7.a.a.cV);
    if (paramAttributeSet != null)
    {
      this.D = paramAttributeSet;
      this.d = true;
    }
    paramAttributeSet = bw.a(((hf)localObject).a(android.support.v7.a.a.cW, -1), null);
    if (this.E != paramAttributeSet)
    {
      this.E = paramAttributeSet;
      this.e = true;
    }
    if ((this.d) || (this.e)) {
      b();
    }
    paramAttributeSet = ((hf)localObject).e(android.support.v7.a.a.cY);
    if (paramAttributeSet != null)
    {
      this.L = paramAttributeSet;
      this.f = true;
    }
    paramAttributeSet = bw.a(((hf)localObject).a(android.support.v7.a.a.cZ, -1), null);
    if (this.M != paramAttributeSet)
    {
      this.M = paramAttributeSet;
      this.g = true;
    }
    if ((this.f) || (this.g)) {
      a();
    }
    paramInt = ((hf)localObject).g(android.support.v7.a.a.cT, 0);
    hf localhf;
    if (paramInt != 0)
    {
      localhf = hf.a(paramContext, paramInt, android.support.v7.a.a.da);
      paramAttributeSet = localhf.e(android.support.v7.a.a.dg);
      if (paramAttributeSet == null) {
        break label765;
      }
    }
    label765:
    for (this.x = paramAttributeSet;; this.x = getTextColors())
    {
      paramInt = localhf.e(android.support.v7.a.a.dj, 0);
      float f1;
      if (paramInt != 0)
      {
        f1 = paramInt;
        if (f1 != this.A.getTextSize())
        {
          this.A.setTextSize(f1);
          requestLayout();
        }
      }
      paramInt = localhf.a(1, -1);
      int i1 = localhf.a(android.support.v7.a.a.dk, -1);
      switch (paramInt)
      {
      default: 
        paramAttributeSet = null;
      }
      for (;;)
      {
        if (i1 <= 0)
        {
          this.A.setFakeBoldText(false);
          this.A.setTextSkewX(0.0F);
          setSwitchTypeface(paramAttributeSet);
          if (localhf.a(android.support.v7.a.a.dn, false)) {}
          for (this.u = new android.support.v7.f.a(getContext());; this.u = null)
          {
            localhf.c.recycle();
            ((hf)localObject).c.recycle();
            paramContext = ViewConfiguration.get(paramContext);
            this.H = paramContext.getScaledTouchSlop();
            this.h = paramContext.getScaledMinimumFlingVelocity();
            refreshDrawableState();
            setChecked(isChecked());
            return;
          }
        }
        if (paramAttributeSet != null) {}
        for (paramAttributeSet = Typeface.create(paramAttributeSet, i1);; paramAttributeSet = Typeface.defaultFromStyle(i1))
        {
          setSwitchTypeface(paramAttributeSet);
          if (paramAttributeSet != null) {}
          for (paramInt = paramAttributeSet.getStyle();; paramInt = 0)
          {
            paramInt = i1 & (paramInt ^ 0xFFFFFFFF);
            paramAttributeSet = this.A;
            if ((paramInt & 0x1) == 0) {}
            for (boolean bool = false;; bool = true)
            {
              paramAttributeSet.setFakeBoldText(bool);
              paramAttributeSet = this.A;
              if ((paramInt & 0x2) != 0) {}
              for (f1 = -0.25F;; f1 = 0.0F)
              {
                paramAttributeSet.setTextSkewX(f1);
                break;
              }
            }
          }
        }
        paramAttributeSet = Typeface.SANS_SERIF;
        continue;
        paramAttributeSet = Typeface.MONOSPACE;
        continue;
        paramAttributeSet = Typeface.SERIF;
      }
    }
  }
  
  private final Layout a(CharSequence paramCharSequence)
  {
    Object localObject = this.u;
    if (localObject != null) {
      paramCharSequence = ((TransformationMethod)localObject).getTransformation(paramCharSequence, this);
    }
    for (;;)
    {
      localObject = this.A;
      if (paramCharSequence != null) {}
      for (int i1 = (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, (TextPaint)localObject));; i1 = 0) {
        return new StaticLayout(paramCharSequence, (TextPaint)localObject, i1, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      }
    }
  }
  
  private final void a()
  {
    Drawable localDrawable = this.K;
    if ((localDrawable != null) && ((this.f) || (this.g)))
    {
      this.K = localDrawable.mutate();
      if (this.f) {
        android.support.v4.a.a.a.a(this.K, this.L);
      }
      if (this.g) {
        android.support.v4.a.a.a.a(this.K, this.M);
      }
      if (this.K.isStateful()) {
        this.K.setState(getDrawableState());
      }
    }
  }
  
  private final void b()
  {
    Drawable localDrawable = this.B;
    if ((localDrawable != null) && ((this.d) || (this.e)))
    {
      this.B = localDrawable.mutate();
      if (this.d) {
        android.support.v4.a.a.a.a(this.B, this.D);
      }
      if (this.e) {
        android.support.v4.a.a.a.a(this.B, this.E);
      }
      if (this.B.isStateful()) {
        this.B.setState(getDrawableState());
      }
    }
  }
  
  private final boolean c()
  {
    return this.a > 0.5F;
  }
  
  private final int d()
  {
    if (id.a(this)) {}
    for (float f1 = 1.0F - this.a;; f1 = this.a) {
      return (int)(f1 * e() + 0.5F);
    }
  }
  
  private final int e()
  {
    Object localObject = this.K;
    if (localObject != null)
    {
      Rect localRect = this.w;
      ((Drawable)localObject).getPadding(localRect);
      localObject = this.B;
      if (localObject != null) {}
      for (localObject = bw.a((Drawable)localObject);; localObject = bw.a) {
        return this.v - this.F - localRect.left - localRect.right - ((Rect)localObject).left - ((Rect)localObject).right;
      }
    }
    return 0;
  }
  
  final void a(float paramFloat)
  {
    this.a = paramFloat;
    invalidate();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = this.w;
    int i7 = this.p;
    int i5 = this.t;
    int i3 = this.s;
    int i6 = this.n;
    int i8 = i7 + d();
    Object localObject = this.B;
    if (localObject != null) {}
    for (localObject = bw.a((Drawable)localObject);; localObject = bw.a)
    {
      Drawable localDrawable = this.K;
      int i9;
      int i2;
      int i4;
      if (localDrawable != null)
      {
        localDrawable.getPadding(localRect);
        i9 = localRect.left;
        if (localObject == null)
        {
          i1 = i6;
          i2 = i5;
          i4 = i3;
          i3 = i1;
          this.K.setBounds(i7, i2, i4, i3);
        }
      }
      for (int i1 = i9 + i8;; i1 = i8)
      {
        localObject = this.B;
        if (localObject != null)
        {
          ((Drawable)localObject).getPadding(localRect);
          i2 = i1 - localRect.left;
          i1 = i1 + this.F + localRect.right;
          this.B.setBounds(i2, i5, i1, i6);
          localObject = getBackground();
          if (localObject != null) {
            android.support.v4.a.a.a.a((Drawable)localObject, i2, i5, i1, i6);
          }
        }
        super.draw(paramCanvas);
        return;
        if (((Rect)localObject).left > localRect.left) {}
        for (i1 = ((Rect)localObject).left - localRect.left + i7;; i1 = i7)
        {
          if (((Rect)localObject).top > localRect.top) {}
          for (i2 = ((Rect)localObject).top - localRect.top + i5;; i2 = i5)
          {
            i4 = i3;
            if (((Rect)localObject).right > localRect.right) {
              i4 = i3 - (((Rect)localObject).right - localRect.right);
            }
            if (((Rect)localObject).bottom > localRect.bottom)
            {
              i3 = i6 - (((Rect)localObject).bottom - localRect.bottom);
              i7 = i1;
              break;
            }
            i3 = i6;
            i7 = i1;
            break;
          }
        }
      }
    }
  }
  
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      super.drawableHotspotChanged(paramFloat1, paramFloat2);
    }
    Drawable localDrawable = this.B;
    if (localDrawable != null) {
      android.support.v4.a.a.a.a(localDrawable, paramFloat1, paramFloat2);
    }
    localDrawable = this.K;
    if (localDrawable != null) {
      android.support.v4.a.a.a.a(localDrawable, paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    boolean bool2 = false;
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable = this.B;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt);
      }
    }
    localDrawable = this.K;
    bool2 = bool1;
    if (localDrawable != null)
    {
      bool2 = bool1;
      if (localDrawable.isStateful()) {
        bool2 = bool1 | localDrawable.setState(arrayOfInt);
      }
    }
    if (bool2) {
      invalidate();
    }
  }
  
  public int getCompoundPaddingLeft()
  {
    int i1;
    if (!id.a(this)) {
      i1 = super.getCompoundPaddingLeft();
    }
    int i2;
    do
    {
      return i1;
      i2 = super.getCompoundPaddingLeft() + this.v;
      i1 = i2;
    } while (TextUtils.isEmpty(getText()));
    return i2 + this.r;
  }
  
  public int getCompoundPaddingRight()
  {
    int i1;
    if (id.a(this)) {
      i1 = super.getCompoundPaddingRight();
    }
    int i2;
    do
    {
      return i1;
      i2 = super.getCompoundPaddingRight() + this.v;
      i1 = i2;
    } while (TextUtils.isEmpty(getText()));
    return i2 + this.r;
  }
  
  public boolean getShowText()
  {
    return this.l;
  }
  
  public boolean getSplitTrack()
  {
    return this.m;
  }
  
  public int getSwitchMinWidth()
  {
    return this.q;
  }
  
  public int getSwitchPadding()
  {
    return this.r;
  }
  
  public CharSequence getTextOff()
  {
    return this.y;
  }
  
  public CharSequence getTextOn()
  {
    return this.z;
  }
  
  public Drawable getThumbDrawable()
  {
    return this.B;
  }
  
  public int getThumbTextPadding()
  {
    return this.C;
  }
  
  public ColorStateList getThumbTintList()
  {
    return this.D;
  }
  
  public PorterDuff.Mode getThumbTintMode()
  {
    return this.E;
  }
  
  public Drawable getTrackDrawable()
  {
    return this.K;
  }
  
  public ColorStateList getTrackTintList()
  {
    return this.L;
  }
  
  public PorterDuff.Mode getTrackTintMode()
  {
    return this.M;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Object localObject = this.B;
    if (localObject != null) {
      ((Drawable)localObject).jumpToCurrentState();
    }
    localObject = this.K;
    if (localObject != null) {
      ((Drawable)localObject).jumpToCurrentState();
    }
    localObject = this.k;
    if ((localObject != null) && (((ObjectAnimator)localObject).isStarted()))
    {
      this.k.end();
      this.k = null;
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, b);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject1 = this.w;
    Object localObject3 = this.K;
    if (localObject3 != null) {
      ((Drawable)localObject3).getPadding((Rect)localObject1);
    }
    for (;;)
    {
      int i2 = this.t;
      int i3 = this.n;
      int i4 = ((Rect)localObject1).top;
      int i5 = ((Rect)localObject1).bottom;
      Object localObject2 = this.B;
      if (localObject3 != null)
      {
        if (this.m) {
          break label248;
        }
        ((Drawable)localObject3).draw(paramCanvas);
      }
      for (;;)
      {
        int i6 = paramCanvas.save();
        if (localObject2 != null) {
          ((Drawable)localObject2).draw(paramCanvas);
        }
        if (!c()) {}
        for (localObject1 = this.i;; localObject1 = this.j)
        {
          if (localObject1 != null)
          {
            localObject3 = getDrawableState();
            localObject4 = this.x;
            if (localObject4 != null) {
              this.A.setColor(((ColorStateList)localObject4).getColorForState((int[])localObject3, 0));
            }
            this.A.drawableState = ((int[])localObject3);
            if (localObject2 == null) {
              break label231;
            }
            localObject2 = ((Drawable)localObject2).getBounds();
            i1 = ((Rect)localObject2).left;
          }
          label231:
          for (i1 = ((Rect)localObject2).right + i1;; i1 = getWidth())
          {
            paramCanvas.translate(i1 / 2 - ((Layout)localObject1).getWidth() / 2, (i2 + i4 + (i3 - i5)) / 2 - ((Layout)localObject1).getHeight() / 2);
            ((Layout)localObject1).draw(paramCanvas);
            paramCanvas.restoreToCount(i6);
            return;
          }
        }
        label248:
        if (localObject2 == null) {
          break;
        }
        Object localObject4 = bw.a((Drawable)localObject2);
        ((Drawable)localObject2).copyBounds((Rect)localObject1);
        ((Rect)localObject1).left += ((Rect)localObject4).left;
        ((Rect)localObject1).right -= ((Rect)localObject4).right;
        int i1 = paramCanvas.save();
        paramCanvas.clipRect((Rect)localObject1, Region.Op.DIFFERENCE);
        ((Drawable)localObject3).draw(paramCanvas);
        paramCanvas.restoreToCount(i1);
      }
      ((Rect)localObject1).setEmpty();
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("android.widget.Switch");
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName("android.widget.Switch");
    if (!isChecked()) {}
    for (CharSequence localCharSequence1 = this.y;; localCharSequence1 = this.z)
    {
      CharSequence localCharSequence2;
      if (!TextUtils.isEmpty(localCharSequence1))
      {
        localCharSequence2 = paramAccessibilityNodeInfo.getText();
        if (TextUtils.isEmpty(localCharSequence2)) {
          paramAccessibilityNodeInfo.setText(localCharSequence1);
        }
      }
      else
      {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localCharSequence2);
      localStringBuilder.append(' ');
      localStringBuilder.append(localCharSequence1);
      paramAccessibilityNodeInfo.setText(localStringBuilder);
      return;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = 0;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Rect localRect;
    Object localObject;
    if (this.B != null)
    {
      localRect = this.w;
      localObject = this.K;
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(localRect);
        localObject = bw.a(this.B);
        paramInt2 = Math.max(0, ((Rect)localObject).left - localRect.left);
      }
    }
    for (paramInt1 = Math.max(0, ((Rect)localObject).right - localRect.right);; paramInt1 = i1)
    {
      if (id.a(this))
      {
        paramInt3 = getPaddingLeft() + paramInt2;
        paramInt4 = this.v + paramInt3 - paramInt2 - paramInt1;
      }
      for (;;)
      {
        switch (getGravity() & 0x70)
        {
        default: 
          paramInt2 = getPaddingTop();
          paramInt1 = this.o + paramInt2;
        }
        for (;;)
        {
          this.p = paramInt3;
          this.t = paramInt2;
          this.n = paramInt1;
          this.s = paramInt4;
          return;
          paramInt1 = getHeight() - getPaddingBottom();
          paramInt2 = paramInt1 - this.o;
          continue;
          paramInt2 = getPaddingTop();
          i1 = getHeight();
          int i2 = getPaddingBottom();
          paramInt1 = this.o;
          paramInt2 = (paramInt2 + i1 - i2) / 2 - paramInt1 / 2;
          paramInt1 = paramInt2 + paramInt1;
        }
        paramInt4 = getWidth() - getPaddingRight() - paramInt1;
        paramInt3 = paramInt1 + (paramInt2 + (paramInt4 - this.v));
      }
      localRect.setEmpty();
      break;
      paramInt2 = 0;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.l)
    {
      if (this.j == null) {
        this.j = a(this.z);
      }
      if (this.i == null) {
        this.i = a(this.y);
      }
    }
    Object localObject = this.w;
    Drawable localDrawable = this.B;
    int i2;
    int i1;
    if (localDrawable != null)
    {
      localDrawable.getPadding((Rect)localObject);
      i2 = this.B.getIntrinsicWidth() - ((Rect)localObject).left - ((Rect)localObject).right;
      i1 = this.B.getIntrinsicHeight();
    }
    for (;;)
    {
      int i3;
      int i4;
      if (this.l)
      {
        i3 = Math.max(this.j.getWidth(), this.i.getWidth());
        i4 = this.C;
        i3 += i4 + i4;
      }
      for (;;)
      {
        this.F = Math.max(i3, i2);
        localDrawable = this.K;
        if (localDrawable != null) {
          localDrawable.getPadding((Rect)localObject);
        }
        for (i2 = this.K.getIntrinsicHeight();; i2 = 0)
        {
          int i6 = ((Rect)localObject).left;
          int i5 = ((Rect)localObject).right;
          localObject = this.B;
          i4 = i5;
          i3 = i6;
          if (localObject != null)
          {
            localObject = bw.a((Drawable)localObject);
            i3 = Math.max(i6, ((Rect)localObject).left);
            i4 = Math.max(i5, ((Rect)localObject).right);
          }
          i5 = this.q;
          i6 = this.F;
          i3 = Math.max(i5, i4 + (i3 + (i6 + i6)));
          i1 = Math.max(i2, i1);
          this.v = i3;
          this.o = i1;
          super.onMeasure(paramInt1, paramInt2);
          if (getMeasuredHeight() < i1) {
            setMeasuredDimension(getMeasuredWidthAndState(), i1);
          }
          return;
          ((Rect)localObject).setEmpty();
        }
        i3 = 0;
      }
      i1 = 0;
      i2 = 0;
    }
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    if (!isChecked()) {}
    for (CharSequence localCharSequence = this.y;; localCharSequence = this.z)
    {
      if (localCharSequence != null) {
        paramAccessibilityEvent.getText().add(localCharSequence);
      }
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f3 = 1.0F;
    boolean bool1 = true;
    this.N.addMovement(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    float f1;
    int i1;
    for (;;)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      return bool1;
      f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if ((isEnabled()) && (this.B != null))
      {
        int i3 = d();
        this.B.getPadding(this.w);
        i1 = this.t;
        int i2 = this.H;
        i3 = i3 + this.p - i2;
        int i4 = this.F;
        int i5 = this.w.left;
        int i6 = this.w.right;
        int i7 = this.H;
        int i8 = this.n;
        if ((f1 > i3) && (f1 < i4 + i3 + i5 + i6 + i7) && (f2 > i1 - i2) && (f2 < i8 + i7))
        {
          this.G = 1;
          this.I = f1;
          this.J = f2;
          continue;
          switch (this.G)
          {
          default: 
            break;
          case 1: 
            f1 = paramMotionEvent.getX();
            f2 = paramMotionEvent.getY();
            if ((Math.abs(f1 - this.I) > this.H) || (Math.abs(f2 - this.J) > this.H))
            {
              this.G = 2;
              getParent().requestDisallowInterceptTouchEvent(true);
              this.I = f1;
              this.J = f2;
              return true;
            }
            break;
          case 2: 
            float f4 = paramMotionEvent.getX();
            i1 = e();
            f1 = f4 - this.I;
            if (i1 != 0) {
              f1 /= i1;
            }
            for (;;)
            {
              f2 = f1;
              if (id.a(this)) {
                f2 = -f1;
              }
              float f5 = this.a;
              f1 = f2 + f5;
              if (f1 >= 0.0F) {
                if (f1 > 1.0F) {
                  f1 = f3;
                }
              }
              while (f1 != f5)
              {
                this.I = f4;
                a(f1);
                return true;
                continue;
                f1 = 0.0F;
              }
              break;
              if (f1 > 0.0F) {
                f1 = 1.0F;
              } else {
                f1 = -1.0F;
              }
            }
            if (this.G == 2) {
              break label470;
            }
            this.G = 0;
            this.N.clear();
          }
        }
      }
    }
    label470:
    this.G = 0;
    if (paramMotionEvent.getAction() == 1) {
      if (isEnabled()) {
        i1 = 1;
      }
    }
    for (;;)
    {
      boolean bool2 = isChecked();
      if (i1 != 0)
      {
        this.N.computeCurrentVelocity(1000);
        f1 = this.N.getXVelocity();
        if (Math.abs(f1) > this.h) {
          if (!id.a(this)) {
            if (f1 > 0.0F) {
              bool1 = true;
            }
          }
        }
      }
      for (;;)
      {
        if (bool1 != bool2) {
          playSoundEffect(0);
        }
        setChecked(bool1);
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        localMotionEvent.setAction(3);
        super.onTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
        super.onTouchEvent(paramMotionEvent);
        return true;
        bool1 = false;
        continue;
        if (f1 < 0.0F)
        {
          bool1 = true;
        }
        else
        {
          bool1 = false;
          continue;
          bool1 = c();
          continue;
          bool1 = bool2;
        }
      }
      i1 = 0;
      continue;
      i1 = 0;
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    float f2 = 0.0F;
    float f1 = 0.0F;
    super.setChecked(paramBoolean);
    paramBoolean = isChecked();
    if ((getWindowToken() == null) || (!ac.I(this)))
    {
      ObjectAnimator localObjectAnimator = this.k;
      if (localObjectAnimator != null) {
        localObjectAnimator.cancel();
      }
      if (!paramBoolean) {}
      for (;;)
      {
        a(f1);
        return;
        f1 = 1.0F;
      }
    }
    if (!paramBoolean) {}
    for (f1 = f2;; f1 = 1.0F)
    {
      this.k = ObjectAnimator.ofFloat(this, c, new float[] { f1 });
      this.k.setDuration(250L);
      if (Build.VERSION.SDK_INT >= 18) {
        this.k.setAutoCancel(true);
      }
      this.k.start();
      return;
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(av.a(this, paramCallback));
  }
  
  public void setShowText(boolean paramBoolean)
  {
    if (this.l != paramBoolean)
    {
      this.l = paramBoolean;
      requestLayout();
    }
  }
  
  public void setSplitTrack(boolean paramBoolean)
  {
    this.m = paramBoolean;
    invalidate();
  }
  
  public void setSwitchMinWidth(int paramInt)
  {
    this.q = paramInt;
    requestLayout();
  }
  
  public void setSwitchPadding(int paramInt)
  {
    this.r = paramInt;
    requestLayout();
  }
  
  public void setSwitchTypeface(Typeface paramTypeface)
  {
    if (((this.A.getTypeface() != null) && (!this.A.getTypeface().equals(paramTypeface))) || ((this.A.getTypeface() == null) && (paramTypeface != null)))
    {
      this.A.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    }
  }
  
  public void setTextOff(CharSequence paramCharSequence)
  {
    this.y = paramCharSequence;
    requestLayout();
  }
  
  public void setTextOn(CharSequence paramCharSequence)
  {
    this.z = paramCharSequence;
    requestLayout();
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = this.B;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    this.B = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  public void setThumbResource(int paramInt)
  {
    setThumbDrawable(android.support.v7.b.a.a.b(getContext(), paramInt));
  }
  
  public void setThumbTextPadding(int paramInt)
  {
    this.C = paramInt;
    requestLayout();
  }
  
  public void setThumbTintList(ColorStateList paramColorStateList)
  {
    this.D = paramColorStateList;
    this.d = true;
    b();
  }
  
  public void setThumbTintMode(PorterDuff.Mode paramMode)
  {
    this.E = paramMode;
    this.e = true;
    b();
  }
  
  public void setTrackDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = this.K;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    this.K = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    requestLayout();
  }
  
  public void setTrackResource(int paramInt)
  {
    setTrackDrawable(android.support.v7.b.a.a.b(getContext(), paramInt));
  }
  
  public void setTrackTintList(ColorStateList paramColorStateList)
  {
    this.L = paramColorStateList;
    this.f = true;
    a();
  }
  
  public void setTrackTintMode(PorterDuff.Mode paramMode)
  {
    this.M = paramMode;
    this.g = true;
    a();
  }
  
  public void toggle()
  {
    setChecked(isChecked() ^ true);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.B) || (paramDrawable == this.K);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/SwitchCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */