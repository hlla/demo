package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.a.c;
import android.support.design.a.g;
import android.support.design.a.h;
import android.support.design.a.i;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.e;
import android.support.v4.view.ai;
import android.support.v4.view.an;
import android.support.v4.view.z;
import android.support.v4.widget.Space;
import android.support.v7.widget.h;
import android.support.v7.widget.w;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.List;

public class TextInputLayout
  extends LinearLayout
{
  private u eJ;
  private final f gH = new f(this);
  private EditText kM;
  boolean kN;
  CharSequence kO;
  private Paint kP;
  private LinearLayout kQ;
  private int kR;
  private boolean kS;
  private TextView kT;
  private int kU;
  private boolean kV;
  private CharSequence kW;
  private boolean kX;
  private TextView kY;
  private int kZ;
  private int la;
  private int lb;
  private boolean lc;
  private ColorStateList ld;
  private ColorStateList le;
  private boolean lf;
  private boolean lg;
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    t.g(paramContext);
    setOrientation(1);
    setWillNotDraw(false);
    setAddStatesFromChildren(true);
    this.gH.a(a.et);
    f localf = this.gH;
    localf.gn = new AccelerateInterpolator();
    localf.N();
    this.gH.n(8388659);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.dr, paramInt, a.h.aU);
    this.kN = paramContext.getBoolean(a.i.dB, true);
    setHint(paramContext.getText(a.i.ds));
    this.lf = paramContext.getBoolean(a.i.dA, true);
    if (paramContext.hasValue(a.i.dt))
    {
      paramAttributeSet = paramContext.getColorStateList(a.i.dt);
      this.le = paramAttributeSet;
      this.ld = paramAttributeSet;
    }
    if (paramContext.getResourceId(a.i.dC, -1) != -1)
    {
      paramInt = paramContext.getResourceId(a.i.dC, 0);
      this.gH.o(paramInt);
      this.le = ColorStateList.valueOf(this.gH.fS);
      if (this.kM != null)
      {
        k(false);
        paramAttributeSet = b(this.kM.getLayoutParams());
        this.kM.setLayoutParams(paramAttributeSet);
        this.kM.requestLayout();
      }
    }
    this.kU = paramContext.getResourceId(a.i.dz, 0);
    boolean bool1 = paramContext.getBoolean(a.i.dy, false);
    boolean bool2 = paramContext.getBoolean(a.i.du, false);
    paramInt = paramContext.getInt(a.i.dv, -1);
    if (this.kZ != paramInt)
    {
      if (paramInt <= 0) {
        break label454;
      }
      this.kZ = paramInt;
      if (this.kX)
      {
        if (this.kM != null) {
          break label462;
        }
        paramInt = 0;
        B(paramInt);
      }
    }
    this.la = paramContext.getResourceId(a.i.dx, 0);
    this.lb = paramContext.getResourceId(a.i.dw, 0);
    paramContext.recycle();
    l(bool1);
    if (this.kX != bool2)
    {
      if (!bool2) {
        break label532;
      }
      this.kY = new TextView(getContext());
      this.kY.setMaxLines(1);
    }
    for (;;)
    {
      try
      {
        this.kY.setTextAppearance(getContext(), this.la);
        a(this.kY, -1);
        if (this.kM == null)
        {
          B(0);
          this.kX = bool2;
          if (z.G(this) == 0) {
            z.i(this, 1);
          }
          z.a(this, new a());
          return;
          label454:
          this.kZ = -1;
          break;
          label462:
          paramInt = this.kM.getText().length();
        }
      }
      catch (Exception paramContext)
      {
        this.kY.setTextAppearance(getContext(), a.h.aI);
        this.kY.setTextColor(android.support.v4.content.a.b(getContext(), a.c.af));
        continue;
        B(this.kM.getText().length());
        continue;
      }
      label532:
      a(this.kY);
      this.kY = null;
    }
  }
  
  private void B(int paramInt)
  {
    boolean bool2 = this.lc;
    if (this.kZ == -1)
    {
      this.kY.setText(String.valueOf(paramInt));
      this.lc = false;
      if ((this.kM != null) && (bool2 != this.lc))
      {
        k(false);
        at();
      }
      return;
    }
    boolean bool1;
    label66:
    TextView localTextView;
    Context localContext;
    if (paramInt > this.kZ)
    {
      bool1 = true;
      this.lc = bool1;
      if (bool2 != this.lc)
      {
        localTextView = this.kY;
        localContext = getContext();
        if (!this.lc) {
          break label158;
        }
      }
    }
    label158:
    for (int i = this.lb;; i = this.la)
    {
      localTextView.setTextAppearance(localContext, i);
      this.kY.setText(getContext().getString(a.g.aH, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.kZ) }));
      break;
      bool1 = false;
      break label66;
    }
  }
  
  private void a(TextView paramTextView)
  {
    if (this.kQ != null)
    {
      this.kQ.removeView(paramTextView);
      int i = this.kR - 1;
      this.kR = i;
      if (i == 0) {
        this.kQ.setVisibility(8);
      }
    }
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    if (this.kQ == null)
    {
      this.kQ = new LinearLayout(getContext());
      this.kQ.setOrientation(0);
      addView(this.kQ, -1, -2);
      Space localSpace = new Space(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0, 1.0F);
      this.kQ.addView(localSpace, localLayoutParams);
      if (this.kM != null) {
        as();
      }
    }
    this.kQ.setVisibility(0);
    this.kQ.addView(paramTextView, paramInt);
    this.kR += 1;
  }
  
  private void as()
  {
    z.c(this.kQ, z.P(this.kM), 0, z.Q(this.kM), this.kM.getPaddingBottom());
  }
  
  private void at()
  {
    int i = Build.VERSION.SDK_INT;
    if ((i != 21) || (i != 22)) {}
    Object localObject2;
    do
    {
      localObject2 = this.kM.getBackground();
      if (localObject2 != null) {
        break;
      }
      return;
      localObject2 = this.kM.getBackground();
    } while ((localObject2 == null) || (this.lg));
    Object localObject1 = ((Drawable)localObject2).getConstantState().newDrawable();
    Drawable.ConstantState localConstantState;
    if ((localObject2 instanceof DrawableContainer))
    {
      localObject2 = (DrawableContainer)localObject2;
      localConstantState = ((Drawable)localObject1).getConstantState();
      if (Build.VERSION.SDK_INT < 9) {
        break label126;
      }
    }
    label126:
    for (boolean bool = i.a((DrawableContainer)localObject2, localConstantState);; bool = i.b((DrawableContainer)localObject2, localConstantState))
    {
      this.lg = bool;
      if (this.lg) {
        break;
      }
      this.kM.setBackgroundDrawable((Drawable)localObject1);
      this.lg = true;
      break;
    }
    localObject1 = localObject2;
    if (w.o((Drawable)localObject2)) {
      localObject1 = ((Drawable)localObject2).mutate();
    }
    if ((this.kV) && (this.kT != null))
    {
      ((Drawable)localObject1).setColorFilter(h.a(this.kT.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      return;
    }
    if ((this.lc) && (this.kY != null))
    {
      ((Drawable)localObject1).setColorFilter(h.a(this.kY.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      return;
    }
    ((Drawable)localObject1).clearColorFilter();
    this.kM.refreshDrawableState();
  }
  
  private LinearLayout.LayoutParams b(ViewGroup.LayoutParams paramLayoutParams)
  {
    Paint localPaint;
    if ((paramLayoutParams instanceof LinearLayout.LayoutParams))
    {
      paramLayoutParams = (LinearLayout.LayoutParams)paramLayoutParams;
      if (!this.kN) {
        break label113;
      }
      if (this.kP == null) {
        this.kP = new Paint();
      }
      localPaint = this.kP;
      localObject = this.gH;
      if (((f)localObject).fZ == null) {
        break label106;
      }
    }
    label106:
    for (Object localObject = ((f)localObject).fZ;; localObject = Typeface.DEFAULT)
    {
      localPaint.setTypeface((Typeface)localObject);
      this.kP.setTextSize(this.gH.fQ);
      paramLayoutParams.topMargin = ((int)-this.kP.ascent());
      return paramLayoutParams;
      paramLayoutParams = new LinearLayout.LayoutParams(paramLayoutParams);
      break;
    }
    label113:
    paramLayoutParams.topMargin = 0;
    return paramLayoutParams;
  }
  
  private CharSequence getError()
  {
    if (this.kS) {
      return this.kW;
    }
    return null;
  }
  
  private void k(boolean paramBoolean)
  {
    int k = 1;
    int i;
    int j;
    if ((this.kM != null) && (!TextUtils.isEmpty(this.kM.getText())))
    {
      i = 1;
      Object localObject = getDrawableState();
      int m = localObject.length;
      j = 0;
      label38:
      if (j >= m) {
        break label210;
      }
      if (localObject[j] != 16842908) {
        break label203;
      }
      j = 1;
      label56:
      if (TextUtils.isEmpty(getError())) {
        break label215;
      }
      label66:
      if (this.ld != null)
      {
        localObject = this.gH;
        m = this.ld.getDefaultColor();
        if (((f)localObject).fR != m)
        {
          ((f)localObject).fR = m;
          ((f)localObject).N();
        }
      }
      if ((!this.lc) || (this.kY == null)) {
        break label221;
      }
      this.gH.l(this.kY.getCurrentTextColor());
    }
    for (;;)
    {
      if ((i != 0) || (j != 0) || (k != 0))
      {
        if ((this.eJ != null) && (this.eJ.ll.isRunning())) {
          this.eJ.ll.cancel();
        }
        if ((paramBoolean) && (this.lf))
        {
          m(1.0F);
          return;
          i = 0;
          break;
          label203:
          j += 1;
          break label38;
          label210:
          j = 0;
          break label56;
          label215:
          k = 0;
          break label66;
          label221:
          if ((j != 0) && (this.le != null))
          {
            this.gH.l(this.le.getDefaultColor());
            continue;
          }
          if (this.ld == null) {
            continue;
          }
          this.gH.l(this.ld.getDefaultColor());
          continue;
        }
        this.gH.e(1.0F);
        return;
      }
    }
    if ((this.eJ != null) && (this.eJ.ll.isRunning())) {
      this.eJ.ll.cancel();
    }
    if ((paramBoolean) && (this.lf))
    {
      m(0.0F);
      return;
    }
    this.gH.e(0.0F);
  }
  
  private void l(boolean paramBoolean)
  {
    if (this.kS != paramBoolean)
    {
      if (this.kT != null) {
        z.V(this.kT).cancel();
      }
      if (!paramBoolean) {
        break label124;
      }
    }
    for (this.kT = new TextView(getContext());; this.kT = null)
    {
      try
      {
        this.kT.setTextAppearance(getContext(), this.kU);
        this.kT.setVisibility(4);
        z.O(this.kT);
        a(this.kT, 0);
        this.kS = paramBoolean;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.kT.setTextAppearance(getContext(), a.h.aI);
          this.kT.setTextColor(android.support.v4.content.a.b(getContext(), a.c.af));
        }
      }
      label124:
      this.kV = false;
      at();
      a(this.kT);
    }
  }
  
  private void m(float paramFloat)
  {
    if (this.gH.fJ == paramFloat) {
      return;
    }
    if (this.eJ == null)
    {
      this.eJ = aa.av();
      this.eJ.setInterpolator(a.es);
      this.eJ.setDuration(200);
      this.eJ.a(new u.c()
      {
        public final void a(u paramAnonymousu)
        {
          TextInputLayout.d(TextInputLayout.this).e(paramAnonymousu.ll.ax());
        }
      });
    }
    this.eJ.e(this.gH.fJ, paramFloat);
    this.eJ.ll.start();
  }
  
  private void setHint(CharSequence paramCharSequence)
  {
    if (this.kN)
    {
      this.kO = paramCharSequence;
      this.gH.setText(paramCharSequence);
      sendAccessibilityEvent(2048);
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof EditText))
    {
      Object localObject = (EditText)paramView;
      if (this.kM != null) {
        throw new IllegalArgumentException("We already have an EditText, can only have one");
      }
      this.kM = ((EditText)localObject);
      localObject = this.gH;
      Typeface localTypeface = this.kM.getTypeface();
      ((f)localObject).ga = localTypeface;
      ((f)localObject).fZ = localTypeface;
      ((f)localObject).N();
      localObject = this.gH;
      float f = this.kM.getTextSize();
      if (((f)localObject).fP != f)
      {
        ((f)localObject).fP = f;
        ((f)localObject).N();
      }
      paramInt = this.kM.getGravity();
      this.gH.n(0x800007 & paramInt | 0x30);
      this.gH.m(paramInt);
      this.kM.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          TextInputLayout.a(TextInputLayout.this);
          if (TextInputLayout.b(TextInputLayout.this)) {
            TextInputLayout.a(TextInputLayout.this, paramAnonymousEditable.length());
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      if (this.ld == null) {
        this.ld = this.kM.getHintTextColors();
      }
      if ((this.kN) && (TextUtils.isEmpty(this.kO)))
      {
        setHint(this.kM.getHint());
        this.kM.setHint(null);
      }
      if (this.kY != null) {
        B(this.kM.getText().length());
      }
      if (this.kQ != null) {
        as();
      }
      k(false);
      super.addView(paramView, 0, b(paramLayoutParams));
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.kN) {
      this.gH.draw(paramCanvas);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.kN) && (this.kM != null))
    {
      paramInt1 = this.kM.getLeft() + this.kM.getCompoundPaddingLeft();
      paramInt3 = this.kM.getRight() - this.kM.getCompoundPaddingRight();
      this.gH.a(paramInt1, this.kM.getTop() + this.kM.getCompoundPaddingTop(), paramInt3, this.kM.getBottom() - this.kM.getCompoundPaddingBottom());
      this.gH.b(paramInt1, getPaddingTop(), paramInt3, paramInt4 - paramInt2 - getPaddingBottom());
      this.gH.N();
    }
  }
  
  protected void onRestoreInstanceState(final Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    paramParcelable = paramParcelable.lj;
    boolean bool2;
    boolean bool1;
    if (!TextUtils.equals(this.kW, paramParcelable))
    {
      this.kW = paramParcelable;
      if (!this.kS)
      {
        if (!TextUtils.isEmpty(paramParcelable)) {
          l(true);
        }
      }
      else
      {
        bool2 = z.aj(this);
        if (TextUtils.isEmpty(paramParcelable)) {
          break label183;
        }
        bool1 = true;
        this.kV = bool1;
        if (!this.kV) {
          break label188;
        }
        this.kT.setText(paramParcelable);
        this.kT.setVisibility(0);
        if (bool2)
        {
          if (z.H(this.kT) == 1.0F) {
            z.d(this.kT, 0.0F);
          }
          z.V(this.kT).p(1.0F).c(200L).b(a.ev).a(new an()
          {
            public final void p(View paramAnonymousView)
            {
              paramAnonymousView.setVisibility(0);
            }
          }).start();
        }
      }
    }
    for (;;)
    {
      at();
      k(true);
      requestLayout();
      return;
      label183:
      bool1 = false;
      break;
      label188:
      if (this.kT.getVisibility() == 0) {
        if (bool2) {
          z.V(this.kT).p(0.0F).c(200L).b(a.eu).a(new an()
          {
            public final void q(View paramAnonymousView)
            {
              TextInputLayout.c(TextInputLayout.this).setText(paramParcelable);
              paramAnonymousView.setVisibility(4);
            }
          }).start();
        } else {
          this.kT.setVisibility(4);
        }
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.kV) {
      localSavedState.lj = getError();
    }
    return localSavedState;
  }
  
  public void refreshDrawableState()
  {
    super.refreshDrawableState();
    k(z.aj(this));
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    CharSequence lj;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      this.lj = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.lj + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      TextUtils.writeToParcel(this.lj, paramParcel, paramInt);
    }
  }
  
  private final class a
    extends android.support.v4.view.a
  {
    public a() {}
    
    public final void a(View paramView, b paramb)
    {
      super.a(paramView, paramb);
      paramb.setClassName(TextInputLayout.class.getSimpleName());
      paramView = TextInputLayout.d(TextInputLayout.this).mText;
      if (!TextUtils.isEmpty(paramView)) {
        paramb.setText(paramView);
      }
      if (TextInputLayout.e(TextInputLayout.this) != null)
      {
        paramView = TextInputLayout.e(TextInputLayout.this);
        b.zK.f(paramb.zL, paramView);
      }
      if (TextInputLayout.c(TextInputLayout.this) != null) {}
      for (paramView = TextInputLayout.c(TextInputLayout.this).getText();; paramView = null)
      {
        if (!TextUtils.isEmpty(paramView))
        {
          b.zK.j(paramb.zL, true);
          b.zK.a(paramb.zL, paramView);
        }
        return;
      }
    }
    
    public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
    }
    
    public final void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramView = TextInputLayout.d(TextInputLayout.this).mText;
      if (!TextUtils.isEmpty(paramView)) {
        paramAccessibilityEvent.getText().add(paramView);
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/TextInputLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */