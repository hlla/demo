package android.support.v4.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class PagerTitleStrip
  extends ViewGroup
  implements ViewPager.a
{
  private static final int[] xQ = { 16842804, 16842901, 16842904, 16842927 };
  private static final int[] xR = { 16843660 };
  private static final b xU = new c();
  private int tW;
  ViewPager xF;
  TextView xG;
  TextView xH;
  TextView xI;
  private int xJ = -1;
  private float xK = -1.0F;
  int xL;
  private boolean xM;
  private boolean xN;
  private final a xO = new a((byte)0);
  private WeakReference<u> xP;
  private int xS;
  int xT;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      xU = new d();
      return;
    }
  }
  
  public PagerTitleStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TextView localTextView = new TextView(paramContext);
    this.xG = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.xH = localTextView;
    addView(localTextView);
    localTextView = new TextView(paramContext);
    this.xI = localTextView;
    addView(localTextView);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, xQ);
    int i = paramAttributeSet.getResourceId(0, 0);
    if (i != 0)
    {
      this.xG.setTextAppearance(paramContext, i);
      this.xH.setTextAppearance(paramContext, i);
      this.xI.setTextAppearance(paramContext, i);
    }
    int j = paramAttributeSet.getDimensionPixelSize(1, 0);
    if (j != 0)
    {
      float f = j;
      this.xG.setTextSize(0, f);
      this.xH.setTextSize(0, f);
      this.xI.setTextSize(0, f);
    }
    if (paramAttributeSet.hasValue(2))
    {
      j = paramAttributeSet.getColor(2, 0);
      this.xG.setTextColor(j);
      this.xH.setTextColor(j);
      this.xI.setTextColor(j);
    }
    this.tW = paramAttributeSet.getInteger(3, 80);
    paramAttributeSet.recycle();
    this.xT = this.xH.getTextColors().getDefaultColor();
    this.xS = 153;
    j = this.xS << 24 | this.xT & 0xFFFFFF;
    this.xG.setTextColor(j);
    this.xI.setTextColor(j);
    this.xG.setEllipsize(TextUtils.TruncateAt.END);
    this.xH.setEllipsize(TextUtils.TruncateAt.END);
    this.xI.setEllipsize(TextUtils.TruncateAt.END);
    if (i != 0)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(i, xR);
      bool = paramAttributeSet.getBoolean(0, false);
      paramAttributeSet.recycle();
    }
    if (bool)
    {
      b(this.xG);
      b(this.xH);
      b(this.xI);
    }
    for (;;)
    {
      this.xL = ((int)(paramContext.getResources().getDisplayMetrics().density * 16.0F));
      return;
      this.xG.setSingleLine();
      this.xH.setSingleLine();
      this.xI.setSingleLine();
    }
  }
  
  private static void b(TextView paramTextView)
  {
    xU.b(paramTextView);
  }
  
  public void U(int paramInt)
  {
    this.xL = paramInt;
    requestLayout();
  }
  
  void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    int m;
    int i4;
    int k;
    int i3;
    int n;
    int i;
    int i2;
    int i1;
    int j;
    int i5;
    int i7;
    int i6;
    int i8;
    if (paramInt != this.xJ)
    {
      a(paramInt, this.xF.yr);
      this.xN = true;
      m = this.xG.getMeasuredWidth();
      i4 = this.xH.getMeasuredWidth();
      k = this.xI.getMeasuredWidth();
      i3 = i4 / 2;
      n = getWidth();
      i = getHeight();
      i2 = getPaddingLeft();
      i1 = getPaddingRight();
      paramInt = getPaddingTop();
      j = getPaddingBottom();
      i5 = i1 + i3;
      float f2 = 0.5F + paramFloat;
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = f2 - 1.0F;
      }
      i3 = n - i5 - (int)(f1 * (n - (i2 + i3) - i5)) - i3;
      i4 = i3 + i4;
      i7 = this.xG.getBaseline();
      i6 = this.xH.getBaseline();
      i5 = this.xI.getBaseline();
      i8 = Math.max(Math.max(i7, i6), i5);
      i7 = i8 - i7;
      i6 = i8 - i6;
      i5 = i8 - i5;
      i8 = this.xG.getMeasuredHeight();
      int i9 = this.xH.getMeasuredHeight();
      int i10 = this.xI.getMeasuredHeight();
      i8 = Math.max(Math.max(i8 + i7, i9 + i6), i10 + i5);
      switch (this.tW & 0x70)
      {
      default: 
        j = paramInt + i7;
        i = paramInt + i6;
        paramInt += i5;
      }
    }
    for (;;)
    {
      this.xH.layout(i3, i, i4, this.xH.getMeasuredHeight() + i);
      i = Math.min(i2, i3 - this.xL - m);
      this.xG.layout(i, j, m + i, this.xG.getMeasuredHeight() + j);
      i = Math.max(n - i1 - k, this.xL + i4);
      this.xI.layout(i, paramInt, i + k, this.xI.getMeasuredHeight() + paramInt);
      this.xK = paramFloat;
      this.xN = false;
      return;
      if ((paramBoolean) || (paramFloat != this.xK)) {
        break;
      }
      return;
      paramInt = (i - paramInt - j - i8) / 2;
      j = paramInt + i7;
      i = paramInt + i6;
      paramInt += i5;
      continue;
      paramInt = i - j - i8;
      j = paramInt + i7;
      i = paramInt + i6;
      paramInt += i5;
    }
  }
  
  final void a(int paramInt, u paramu)
  {
    Object localObject2 = null;
    int i;
    if (paramu != null)
    {
      i = paramu.getCount();
      this.xM = true;
      if ((paramInt <= 0) || (paramu == null)) {
        break label228;
      }
    }
    label228:
    for (Object localObject1 = paramu.bK();; localObject1 = null)
    {
      this.xG.setText((CharSequence)localObject1);
      TextView localTextView = this.xH;
      if ((paramu != null) && (paramInt < i)) {}
      for (localObject1 = paramu.bK();; localObject1 = null)
      {
        localTextView.setText((CharSequence)localObject1);
        localObject1 = localObject2;
        if (paramInt + 1 < i)
        {
          localObject1 = localObject2;
          if (paramu != null) {
            localObject1 = paramu.bK();
          }
        }
        this.xI.setText((CharSequence)localObject1);
        i = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int)((getWidth() - getPaddingLeft() - getPaddingRight()) * 0.8F)), Integer.MIN_VALUE);
        int j = View.MeasureSpec.makeMeasureSpec(Math.max(0, getHeight() - getPaddingTop() - getPaddingBottom()), Integer.MIN_VALUE);
        this.xG.measure(i, j);
        this.xH.measure(i, j);
        this.xI.measure(i, j);
        this.xJ = paramInt;
        if (!this.xN) {
          a(paramInt, this.xK, false);
        }
        this.xM = false;
        return;
        i = 0;
        break;
      }
    }
  }
  
  final void a(u paramu1, u paramu2)
  {
    if (paramu1 != null)
    {
      paramu1.unregisterDataSetObserver(this.xO);
      this.xP = null;
    }
    if (paramu2 != null)
    {
      paramu2.registerDataSetObserver(this.xO);
      this.xP = new WeakReference(paramu2);
    }
    if (this.xF != null)
    {
      this.xJ = -1;
      this.xK = -1.0F;
      a(this.xF.ys, paramu2);
      requestLayout();
    }
  }
  
  int getMinHeight()
  {
    int i = 0;
    Drawable localDrawable = getBackground();
    if (localDrawable != null) {
      i = localDrawable.getIntrinsicHeight();
    }
    return i;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    Object localObject = getParent();
    if (!(localObject instanceof ViewPager)) {
      throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }
    localObject = (ViewPager)localObject;
    u localu = ((ViewPager)localObject).yr;
    ((ViewPager)localObject).a(this.xO);
    ((ViewPager)localObject).zd = this.xO;
    this.xF = ((ViewPager)localObject);
    if (this.xP != null) {}
    for (localObject = (u)this.xP.get();; localObject = null)
    {
      a((u)localObject, localu);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.xF != null)
    {
      a(this.xF.yr, null);
      this.xF.a(null);
      this.xF.zd = null;
      this.xF = null;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f = 0.0F;
    if (this.xF != null)
    {
      if (this.xK >= 0.0F) {
        f = this.xK;
      }
      a(this.xJ, f, true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      throw new IllegalStateException("Must measure with an exact width");
    }
    int j = getPaddingTop() + getPaddingBottom();
    int k = getChildMeasureSpec(paramInt2, j, -2);
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = getChildMeasureSpec(paramInt1, (int)(i * 0.2F), -2);
    this.xG.measure(paramInt1, k);
    this.xH.measure(paramInt1, k);
    this.xI.measure(paramInt1, k);
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {}
    for (paramInt1 = View.MeasureSpec.getSize(paramInt2);; paramInt1 = Math.max(getMinHeight(), j + paramInt1))
    {
      setMeasuredDimension(i, z.resolveSizeAndState(paramInt1, paramInt2, z.N(this.xH) << 16));
      return;
      paramInt1 = this.xH.getMeasuredHeight();
    }
  }
  
  public void requestLayout()
  {
    if (!this.xM) {
      super.requestLayout();
    }
  }
  
  private final class a
    extends DataSetObserver
    implements ViewPager.d, ViewPager.e
  {
    private int xV;
    
    private a() {}
    
    public final void V(int paramInt)
    {
      float f = 0.0F;
      if (this.xV == 0)
      {
        PagerTitleStrip.this.a(PagerTitleStrip.this.xF.ys, PagerTitleStrip.this.xF.yr);
        if (PagerTitleStrip.a(PagerTitleStrip.this) >= 0.0F) {
          f = PagerTitleStrip.a(PagerTitleStrip.this);
        }
        PagerTitleStrip.this.a(PagerTitleStrip.this.xF.ys, f, true);
      }
    }
    
    public final void W(int paramInt)
    {
      this.xV = paramInt;
    }
    
    public final void a(int paramInt1, float paramFloat, int paramInt2)
    {
      paramInt2 = paramInt1;
      if (paramFloat > 0.5F) {
        paramInt2 = paramInt1 + 1;
      }
      PagerTitleStrip.this.a(paramInt2, paramFloat, false);
    }
    
    public final void b(u paramu1, u paramu2)
    {
      PagerTitleStrip.this.a(paramu1, paramu2);
    }
    
    public final void onChanged()
    {
      float f = 0.0F;
      PagerTitleStrip.this.a(PagerTitleStrip.this.xF.ys, PagerTitleStrip.this.xF.yr);
      if (PagerTitleStrip.a(PagerTitleStrip.this) >= 0.0F) {
        f = PagerTitleStrip.a(PagerTitleStrip.this);
      }
      PagerTitleStrip.this.a(PagerTitleStrip.this.xF.ys, f, true);
    }
  }
  
  static abstract interface b
  {
    public abstract void b(TextView paramTextView);
  }
  
  static final class c
    implements PagerTitleStrip.b
  {
    public final void b(TextView paramTextView)
    {
      paramTextView.setSingleLine();
    }
  }
  
  static final class d
    implements PagerTitleStrip.b
  {
    public final void b(TextView paramTextView)
    {
      paramTextView.setTransformationMethod(new v.a(paramTextView.getContext()));
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/view/PagerTitleStrip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */