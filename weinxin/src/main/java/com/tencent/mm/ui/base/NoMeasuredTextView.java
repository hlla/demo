package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Editable.Factory;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.Spannable.Factory;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.bf;

@SuppressLint({"ResourceAsColor"})
public class NoMeasuredTextView
  extends View
{
  private static final BoringLayout.Metrics vnq;
  private int PN;
  private ColorStateList ec;
  public TextPaint gm;
  private int iO;
  private CharSequence mText;
  private int tW;
  private boolean vks;
  private int vmJ;
  private Editable.Factory vmK;
  private Spannable.Factory vmL;
  private TextUtils.TruncateAt vmM;
  private CharSequence vmN;
  private int vmO;
  private KeyListener vmP;
  private Layout vmQ;
  private float vmR;
  private float vmS;
  private int vmT;
  private int vmU;
  private int vmV;
  private int vmW;
  private boolean vmX;
  private boolean vmY;
  private int vmZ;
  private boolean vna;
  private BoringLayout vnb;
  private boolean vnc;
  private int vnd;
  private Paint.FontMetricsInt vne;
  private boolean vnf;
  public boolean vng;
  private b vnh;
  private boolean vni;
  private boolean vnj;
  private boolean vnk;
  private boolean vnl;
  private int vnm;
  private int vnn;
  private int vno;
  private int vnp;
  
  static
  {
    GMTrace.i(3264309362688L, 24321);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.measureText("H");
    vnq = new BoringLayout.Metrics();
    GMTrace.o(3264309362688L, 24321);
  }
  
  public NoMeasuredTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(3259477524480L, 24285);
    this.vmK = Editable.Factory.getInstance();
    this.vmL = Spannable.Factory.getInstance();
    this.vmM = null;
    this.vmO = a.vnr;
    this.tW = 51;
    this.vmR = 1.0F;
    this.vmS = 0.0F;
    this.vmT = Integer.MAX_VALUE;
    this.vmU = 1;
    this.vmV = 0;
    this.vmW = 1;
    this.iO = Integer.MAX_VALUE;
    this.vmX = false;
    this.PN = 0;
    this.vmY = false;
    this.vmZ = -1;
    this.vna = true;
    this.vnc = false;
    this.vnf = false;
    this.vng = false;
    this.vni = false;
    this.vnj = false;
    this.vnk = false;
    this.vnl = false;
    this.vnm = -1;
    this.vnn = -1;
    this.vno = -1;
    this.vnp = -1;
    this.mText = "";
    this.vmN = "";
    this.gm = new TextPaint(1);
    this.gm.density = getResources().getDisplayMetrics().density;
    setDrawingCacheEnabled(false);
    this.vne = this.gm.getFontMetricsInt();
    bSI();
    bSd();
    setEllipsize(null);
    GMTrace.o(3259477524480L, 24285);
  }
  
  private void a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    GMTrace.i(3259611742208L, 24286);
    Object localObject2 = this.vnh;
    int i;
    if ((paramDrawable1 != null) || (paramDrawable2 != null))
    {
      i = 1;
      if (i != 0) {
        break label206;
      }
      if (localObject2 != null)
      {
        if (((b)localObject2).vnI != 0) {
          break label66;
        }
        this.vnh = null;
      }
    }
    for (;;)
    {
      invalidate();
      GMTrace.o(3259611742208L, 24286);
      return;
      i = 0;
      break;
      label66:
      if (((b)localObject2).vny != null) {
        ((b)localObject2).vny.setCallback(null);
      }
      ((b)localObject2).vny = null;
      if (((b)localObject2).vnw != null) {
        ((b)localObject2).vnw.setCallback(null);
      }
      ((b)localObject2).vnw = null;
      if (((b)localObject2).vnz != null) {
        ((b)localObject2).vnz.setCallback(null);
      }
      ((b)localObject2).vnz = null;
      if (((b)localObject2).vnx != null) {
        ((b)localObject2).vnx.setCallback(null);
      }
      ((b)localObject2).vnx = null;
      ((b)localObject2).vnG = 0;
      ((b)localObject2).vnC = 0;
      paramDrawable1 = (Drawable)localObject2;
      paramDrawable1.vnH = 0;
      paramDrawable1.vnD = 0;
      label183:
      paramDrawable1.vnE = 0;
      paramDrawable1.vnA = 0;
      paramDrawable1.vnF = 0;
      paramDrawable1.vnB = 0;
    }
    label206:
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new b();
      this.vnh = ((b)localObject1);
    }
    if ((((b)localObject1).vny != paramDrawable1) && (((b)localObject1).vny != null)) {
      ((b)localObject1).vny.setCallback(null);
    }
    ((b)localObject1).vny = paramDrawable1;
    if ((((b)localObject1).vnw != null) && (((b)localObject1).vnw != null)) {
      ((b)localObject1).vnw.setCallback(null);
    }
    ((b)localObject1).vnw = null;
    if ((((b)localObject1).vnz != paramDrawable2) && (((b)localObject1).vnz != null)) {
      ((b)localObject1).vnz.setCallback(null);
    }
    ((b)localObject1).vnz = paramDrawable2;
    if ((((b)localObject1).vnx != null) && (((b)localObject1).vnx != null)) {
      ((b)localObject1).vnx.setCallback(null);
    }
    ((b)localObject1).vnx = null;
    localObject2 = ((b)localObject1).vnv;
    int[] arrayOfInt = getDrawableState();
    if (paramDrawable1 != null)
    {
      paramDrawable1.setState(arrayOfInt);
      paramDrawable1.copyBounds((Rect)localObject2);
      paramDrawable1.setCallback(this);
      ((b)localObject1).vnC = ((Rect)localObject2).width();
      ((b)localObject1).vnG = ((Rect)localObject2).height();
    }
    for (;;)
    {
      paramDrawable1 = (Drawable)localObject1;
      if (paramDrawable2 == null) {
        break;
      }
      paramDrawable2.setState(arrayOfInt);
      paramDrawable2.copyBounds((Rect)localObject2);
      paramDrawable2.setCallback(this);
      ((b)localObject1).vnD = ((Rect)localObject2).width();
      ((b)localObject1).vnH = ((Rect)localObject2).height();
      paramDrawable1 = (Drawable)localObject1;
      break label183;
      ((b)localObject1).vnG = 0;
      ((b)localObject1).vnC = 0;
    }
  }
  
  private int bSF()
  {
    GMTrace.i(3262296096768L, 24306);
    int j = 0;
    int k = this.tW & 0x70;
    Layout localLayout = this.vmQ;
    int i = j;
    int m;
    int n;
    if (k != 48)
    {
      m = getMeasuredHeight() - getExtendedPaddingTop() - getExtendedPaddingBottom();
      n = localLayout.getHeight();
      i = j;
      if (n < m) {
        if (k != 80) {
          break label88;
        }
      }
    }
    label88:
    for (i = m - n;; i = m - n >> 1)
    {
      GMTrace.o(3262296096768L, 24306);
      return i;
    }
  }
  
  private void bSG()
  {
    GMTrace.i(3262832967680L, 24310);
    if (((this.vmQ instanceof BoringLayout)) && (this.vnb == null)) {
      this.vnb = ((BoringLayout)this.vmQ);
    }
    this.vmQ = null;
    GMTrace.o(3262832967680L, 24310);
  }
  
  private void bSH()
  {
    GMTrace.i(3262967185408L, 24311);
    if (this.vmX) {}
    for (int i = this.iO - getCompoundPaddingLeft() - getCompoundPaddingRight();; i = getRight() - getLeft() - getCompoundPaddingLeft() - getCompoundPaddingRight())
    {
      int j = i;
      if (i <= 0) {
        j = 0;
      }
      ea(j, j);
      GMTrace.o(3262967185408L, 24311);
      return;
    }
  }
  
  private void bSI()
  {
    GMTrace.i(3263369838592L, 24314);
    if (this.vnd == 0) {
      this.vnd = ((int)(Math.ceil(this.vne.descent - this.vne.ascent) + 2.0D));
    }
    GMTrace.o(3263369838592L, 24314);
  }
  
  private void ea(int paramInt1, int paramInt2)
  {
    GMTrace.i(3263101403136L, 24312);
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      Layout.Alignment localAlignment;
      switch (this.tW & 0x7)
      {
      default: 
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
        if ((this.vmM == null) || (this.vmP != null)) {
          break;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label153;
        }
        this.vmQ = new StaticLayout(this.vmN, 0, this.vmN.length(), this.gm, paramInt1, localAlignment, this.vmR, this.vmS, this.vna, this.vmM, paramInt2);
        GMTrace.o(3263101403136L, 24312);
        return;
        localAlignment = Layout.Alignment.ALIGN_CENTER;
        break;
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
        break;
      }
      label153:
      this.vmQ = new StaticLayout(this.vmN, this.gm, paramInt1, localAlignment, this.vmR, this.vmS, this.vna);
      GMTrace.o(3263101403136L, 24312);
      return;
    }
  }
  
  private int getCompoundPaddingBottom()
  {
    GMTrace.i(3260551266304L, 24293);
    b localb = this.vnh;
    if ((localb == null) || (localb.vnx == null) || (!this.vnl))
    {
      i = getPaddingBottom();
      GMTrace.o(3260551266304L, 24293);
      return i;
    }
    int i = getPaddingBottom();
    int j = localb.vnI;
    int k = localb.vnB;
    GMTrace.o(3260551266304L, 24293);
    return k + (i + j);
  }
  
  private int getCompoundPaddingLeft()
  {
    GMTrace.i(3260685484032L, 24294);
    b localb = this.vnh;
    if ((localb == null) || (localb.vny == null) || (!this.vni))
    {
      i = getPaddingLeft();
      GMTrace.o(3260685484032L, 24294);
      return i;
    }
    int i = getPaddingLeft();
    int j = localb.vnI;
    int k = localb.vnC;
    GMTrace.o(3260685484032L, 24294);
    return k + (i + j);
  }
  
  private int getCompoundPaddingRight()
  {
    GMTrace.i(3260819701760L, 24295);
    b localb = this.vnh;
    if ((localb == null) || (localb.vnz == null) || (!this.vnj))
    {
      i = getPaddingRight();
      GMTrace.o(3260819701760L, 24295);
      return i;
    }
    int i = getPaddingRight();
    int j = localb.vnI;
    int k = localb.vnD;
    GMTrace.o(3260819701760L, 24295);
    return k + (i + j);
  }
  
  private int getCompoundPaddingTop()
  {
    GMTrace.i(3260417048576L, 24292);
    b localb = this.vnh;
    if ((localb == null) || (localb.vnw == null) || (!this.vnk))
    {
      i = getPaddingTop();
      GMTrace.o(3260417048576L, 24292);
      return i;
    }
    int i = getPaddingTop();
    int j = localb.vnI;
    int k = localb.vnA;
    GMTrace.o(3260417048576L, 24292);
    return k + (i + j);
  }
  
  private int getExtendedPaddingBottom()
  {
    GMTrace.i(3261088137216L, 24297);
    if ((this.vmQ == null) || (this.vmU != 1))
    {
      i = getCompoundPaddingBottom();
      GMTrace.o(3261088137216L, 24297);
      return i;
    }
    if (this.vmQ.getLineCount() <= this.vmT)
    {
      i = getCompoundPaddingBottom();
      GMTrace.o(3261088137216L, 24297);
      return i;
    }
    int j = getCompoundPaddingTop();
    int i = getCompoundPaddingBottom();
    j = getHeight() - j - i;
    int k = this.vmQ.getLineTop(this.vmT);
    if (k >= j)
    {
      GMTrace.o(3261088137216L, 24297);
      return i;
    }
    int m = this.tW & 0x70;
    if (m == 48)
    {
      GMTrace.o(3261088137216L, 24297);
      return i + j - k;
    }
    if (m == 80)
    {
      GMTrace.o(3261088137216L, 24297);
      return i;
    }
    j = (j - k) / 2;
    GMTrace.o(3261088137216L, 24297);
    return i + j;
  }
  
  private int getExtendedPaddingTop()
  {
    GMTrace.i(3260953919488L, 24296);
    if ((this.vmQ == null) || (this.vmU != 1))
    {
      i = getCompoundPaddingTop();
      GMTrace.o(3260953919488L, 24296);
      return i;
    }
    if (this.vmQ.getLineCount() <= this.vmT)
    {
      i = getCompoundPaddingTop();
      GMTrace.o(3260953919488L, 24296);
      return i;
    }
    int i = getCompoundPaddingTop();
    int j = getCompoundPaddingBottom();
    j = getHeight() - i - j;
    int k = this.vmQ.getLineTop(this.vmT);
    if (k >= j)
    {
      GMTrace.o(3260953919488L, 24296);
      return i;
    }
    int m = this.tW & 0x70;
    if (m == 48)
    {
      GMTrace.o(3260953919488L, 24296);
      return i;
    }
    if (m == 80)
    {
      GMTrace.o(3260953919488L, 24296);
      return i + j - k;
    }
    j = (j - k) / 2;
    GMTrace.o(3260953919488L, 24296);
    return i + j;
  }
  
  private void updateTextColors()
  {
    int i = 0;
    GMTrace.i(3261893443584L, 24303);
    int j = this.ec.getColorForState(getDrawableState(), 0);
    if (j != this.vmJ)
    {
      this.vmJ = j;
      i = 1;
    }
    if (i != 0) {
      invalidate();
    }
    GMTrace.o(3261893443584L, 24303);
  }
  
  public final void Ai(int paramInt)
  {
    GMTrace.i(3259745959936L, 24287);
    if (paramInt != this.vnm)
    {
      this.vnm = paramInt;
      Drawable localDrawable = getResources().getDrawable(paramInt);
      if ((localDrawable != null) && ((this.vnh == null) || (this.vnh.vny != localDrawable)))
      {
        localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        a(localDrawable, null);
      }
    }
    GMTrace.o(3259745959936L, 24287);
  }
  
  public final void Aj(int paramInt)
  {
    GMTrace.i(3259880177664L, 24288);
    if (paramInt != this.vnn)
    {
      this.vnn = paramInt;
      Drawable localDrawable = getResources().getDrawable(paramInt);
      if ((localDrawable != null) && ((this.vnh == null) || (this.vnh.vnz != localDrawable)))
      {
        localDrawable.setBounds(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
        a(null, localDrawable);
      }
    }
    GMTrace.o(3259880177664L, 24288);
  }
  
  public final void H(float paramFloat)
  {
    GMTrace.i(3261356572672L, 24299);
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      paramFloat = TypedValue.applyDimension(0, paramFloat, ((Resources)localObject).getDisplayMetrics());
      if (paramFloat != this.gm.getTextSize())
      {
        this.gm.setTextSize(paramFloat);
        this.vne = this.gm.getFontMetricsInt();
        this.vnd = ((int)(Math.ceil(this.vne.descent - this.vne.ascent) + 2.0D));
        if (this.vmQ != null)
        {
          bSG();
          requestLayout();
          invalidate();
        }
      }
      GMTrace.o(3261356572672L, 24299);
      return;
    }
  }
  
  public final void bSd()
  {
    GMTrace.i(3263504056320L, 24315);
    this.vks = true;
    this.vmV = 1;
    this.vmT = 1;
    this.vmW = 1;
    this.vmU = 1;
    requestLayout();
    invalidate();
    GMTrace.o(3263504056320L, 24315);
  }
  
  protected int computeHorizontalScrollRange()
  {
    GMTrace.i(3263772491776L, 24317);
    if (this.vmQ != null)
    {
      i = this.vmQ.getWidth();
      GMTrace.o(3263772491776L, 24317);
      return i;
    }
    int i = super.computeHorizontalScrollRange();
    GMTrace.o(3263772491776L, 24317);
    return i;
  }
  
  protected int computeVerticalScrollExtent()
  {
    GMTrace.i(3264040927232L, 24319);
    int i = getHeight();
    int j = getCompoundPaddingTop();
    int k = getCompoundPaddingBottom();
    GMTrace.o(3264040927232L, 24319);
    return i - j - k;
  }
  
  protected int computeVerticalScrollRange()
  {
    GMTrace.i(3263906709504L, 24318);
    if (this.vmQ != null)
    {
      i = this.vmQ.getHeight();
      GMTrace.o(3263906709504L, 24318);
      return i;
    }
    int i = super.computeVerticalScrollRange();
    GMTrace.o(3263906709504L, 24318);
    return i;
  }
  
  protected void drawableStateChanged()
  {
    GMTrace.i(3260014395392L, 24289);
    super.drawableStateChanged();
    if ((this.ec != null) && (this.ec.isStateful())) {
      updateTextColors();
    }
    b localb = this.vnh;
    if (localb != null)
    {
      int[] arrayOfInt = getDrawableState();
      if ((localb.vnw != null) && (localb.vnw.isStateful())) {
        localb.vnw.setState(arrayOfInt);
      }
      if ((localb.vnx != null) && (localb.vnx.isStateful())) {
        localb.vnx.setState(arrayOfInt);
      }
      if ((localb.vny != null) && (localb.vny.isStateful())) {
        localb.vny.setState(arrayOfInt);
      }
      if ((localb.vnz != null) && (localb.vnz.isStateful())) {
        localb.vnz.setState(arrayOfInt);
      }
    }
    GMTrace.o(3260014395392L, 24289);
  }
  
  public int getBaseline()
  {
    GMTrace.i(3262698749952L, 24309);
    if (this.vmQ == null)
    {
      i = super.getBaseline();
      GMTrace.o(3262698749952L, 24309);
      return i;
    }
    if ((this.tW & 0x70) != 48) {}
    for (int i = bSF();; i = 0)
    {
      int j = getExtendedPaddingTop();
      int k = this.vmQ.getLineBaseline(0);
      GMTrace.o(3262698749952L, 24309);
      return i + j + k;
    }
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    GMTrace.i(3262564532224L, 24308);
    if (this.vmQ == null)
    {
      super.getFocusedRect(paramRect);
      GMTrace.o(3262564532224L, 24308);
      return;
    }
    int i = Selection.getSelectionEnd(this.mText);
    if (i < 0)
    {
      super.getFocusedRect(paramRect);
      GMTrace.o(3262564532224L, 24308);
      return;
    }
    int j = this.vmQ.getLineForOffset(i);
    paramRect.top = this.vmQ.getLineTop(j);
    paramRect.bottom = this.vmQ.getLineBottom(j);
    paramRect.left = ((int)this.vmQ.getPrimaryHorizontal(i));
    paramRect.right = (paramRect.left + 1);
    int k = getCompoundPaddingLeft();
    j = getExtendedPaddingTop();
    i = j;
    if ((this.tW & 0x70) != 48) {
      i = j + bSF();
    }
    paramRect.offset(k, i);
    GMTrace.o(3262564532224L, 24308);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    GMTrace.i(3260282830848L, 24291);
    Rect localRect;
    int m;
    int k;
    b localb;
    int i;
    int j;
    int n;
    int i1;
    int i2;
    if (verifyDrawable(paramDrawable))
    {
      localRect = paramDrawable.getBounds();
      m = getScrollX();
      k = getScrollY();
      localb = this.vnh;
      i = k;
      j = m;
      if (localb != null)
      {
        if (paramDrawable != localb.vny) {
          break label158;
        }
        i = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        j = m + getPaddingLeft();
        i = k + ((i1 - i2 - n - i - localb.vnG) / 2 + i);
      }
    }
    for (;;)
    {
      invalidate(localRect.left + j, localRect.top + i, j + localRect.right, i + localRect.bottom);
      GMTrace.o(3260282830848L, 24291);
      return;
      label158:
      if (paramDrawable == localb.vnz)
      {
        i = getCompoundPaddingTop();
        n = getCompoundPaddingBottom();
        i1 = getBottom();
        i2 = getTop();
        j = m + (getRight() - getLeft() - getPaddingRight() - localb.vnD);
        i = k + ((i1 - i2 - n - i - localb.vnH) / 2 + i);
      }
      else if (paramDrawable == localb.vnw)
      {
        i = getCompoundPaddingLeft();
        j = getCompoundPaddingRight();
        j = m + ((getRight() - getLeft() - j - i - localb.vnE) / 2 + i);
        i = k + getPaddingTop();
      }
      else
      {
        i = k;
        j = m;
        if (paramDrawable == localb.vnx)
        {
          i = getCompoundPaddingLeft();
          j = getCompoundPaddingRight();
          j = m + (i + (getRight() - getLeft() - j - i - localb.vnF) / 2);
          i = k + (getBottom() - getTop() - getPaddingBottom() - localb.vnB);
        }
      }
    }
  }
  
  public final void kS(boolean paramBoolean)
  {
    GMTrace.i(3259209089024L, 24283);
    if (this.vni != paramBoolean) {
      invalidate();
    }
    this.vni = paramBoolean;
    GMTrace.o(3259209089024L, 24283);
  }
  
  public final void kT(boolean paramBoolean)
  {
    GMTrace.i(3259343306752L, 24284);
    if (this.vnj != paramBoolean) {
      invalidate();
    }
    this.vnj = paramBoolean;
    GMTrace.o(3259343306752L, 24284);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    GMTrace.i(3262430314496L, 24307);
    super.onDraw(paramCanvas);
    int m = getCompoundPaddingLeft();
    int i1 = getCompoundPaddingTop();
    int i = getCompoundPaddingRight();
    int i7 = getCompoundPaddingBottom();
    int j = getScrollX();
    int i2 = getScrollY();
    int i3 = getRight();
    int i4 = getLeft();
    int i5 = getBottom();
    int i6 = getTop();
    int k = getWidth();
    int n = getHeight();
    b localb = this.vnh;
    float f2 = -1.0F;
    float f1 = f2;
    float f3;
    if (localb != null)
    {
      i7 = i5 - i6 - i7 - i1;
      int i8 = i3 - i4 - i - m;
      if ((this.vni) && (localb.vny != null))
      {
        paramCanvas.save();
        paramCanvas.translate(getPaddingLeft() + j, i2 + i1 + (i7 - localb.vnG) / 2);
        localb.vny.draw(paramCanvas);
        paramCanvas.restore();
      }
      f3 = f2;
      if (this.vnj)
      {
        f3 = f2;
        if (localb.vnz != null)
        {
          paramCanvas.save();
          if (!this.vnc) {
            break label701;
          }
          f1 = this.gm.measureText(this.mText, 0, this.mText.length());
          f2 = f1;
          paramCanvas.translate(f1 + j - getPaddingRight(), i1 + i2 + (i7 - localb.vnH) / 2);
          localb.vnz.draw(paramCanvas);
          paramCanvas.restore();
          f3 = f2;
        }
      }
      if ((this.vnk) && (localb.vnw != null))
      {
        paramCanvas.save();
        paramCanvas.translate(j + m + (i8 - localb.vnE) / 2, getPaddingTop() + i2);
        localb.vnw.draw(paramCanvas);
        paramCanvas.restore();
      }
      f1 = f3;
      if (this.vnl)
      {
        f1 = f3;
        if (localb.vnx != null)
        {
          paramCanvas.save();
          paramCanvas.translate(j + m + (i8 - localb.vnF) / 2, i2 + i5 - i6 - getPaddingBottom() - localb.vnB);
          localb.vnx.draw(paramCanvas);
          paramCanvas.restore();
          f1 = f3;
        }
      }
    }
    i1 = this.vmJ;
    this.gm.setColor(i1);
    this.gm.drawableState = getDrawableState();
    paramCanvas.save();
    i1 = getExtendedPaddingTop();
    i7 = getExtendedPaddingBottom();
    paramCanvas.clipRect(m + j, i1 + i2, i3 - i4 - i + j, i5 - i6 - i7 + i2);
    j = 0;
    i = 0;
    if ((this.tW & 0x70) != 48)
    {
      j = bSF();
      i = bSF();
    }
    paramCanvas.translate(m, i1 + j);
    if (this.vnc)
    {
      f3 = (n - (this.vne.bottom - this.vne.top)) / 2 - this.vne.top;
      j = 0;
      i = j;
      if ((this.tW & 0x7) != 3) {}
      switch (this.tW & 0x7)
      {
      default: 
        i = j;
        label660:
        paramCanvas.drawText(this.mText, 0, this.mText.length(), i, f3, this.gm);
      }
    }
    for (;;)
    {
      paramCanvas.restore();
      GMTrace.o(3262430314496L, 24307);
      return;
      label701:
      f1 = (float)Math.ceil(Layout.getDesiredWidth(this.vmN, this.gm));
      break;
      f2 = f1;
      if (f1 == -1.0F) {
        f2 = this.gm.measureText(this.mText, 0, this.mText.length());
      }
      i = (int)(k - getPaddingRight() - f2);
      break label660;
      f2 = f1;
      if (f1 == -1.0F) {
        f2 = this.gm.measureText(this.mText, 0, this.mText.length());
      }
      i = (int)(k - getPaddingRight() - f2) / 2;
      break label660;
      if (this.vmQ == null) {
        bSH();
      }
      this.vmQ.draw(paramCanvas, null, null, i - j);
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    GMTrace.i(3264175144960L, 24320);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    CharSequence localCharSequence2 = getContentDescription();
    CharSequence localCharSequence1 = localCharSequence2;
    if (bf.mA((String)localCharSequence2)) {
      localCharSequence1 = this.mText;
    }
    paramAccessibilityNodeInfo.setText(localCharSequence1);
    GMTrace.o(3264175144960L, 24320);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(3262161879040L, 24305);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.vnf) && (getMeasuredWidth() > 0))
    {
      setText(TextUtils.ellipsize(this.mText, this.gm, getMeasuredWidth() - getCompoundPaddingRight() - getCompoundPaddingLeft(), TextUtils.TruncateAt.END));
      this.vnf = false;
    }
    GMTrace.o(3262161879040L, 24305);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    GMTrace.i(3263235620864L, 24313);
    View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    if (k == 0)
    {
      setMeasuredDimension(k, this.vnd);
      GMTrace.o(3263235620864L, 24313);
      return;
    }
    if (this.vnc)
    {
      if (this.vnd == 0) {
        bSI();
      }
      setMeasuredDimension(k, this.vnd);
      GMTrace.o(3263235620864L, 24313);
      return;
    }
    paramInt1 = getCompoundPaddingLeft() + getCompoundPaddingRight();
    if (this.vmX)
    {
      paramInt1 = this.iO - paramInt1;
      if (this.vmQ != null) {
        break label179;
      }
      ea(paramInt1, paramInt1);
      label132:
      if (m != 1073741824) {
        break label210;
      }
      this.vmZ = -1;
      paramInt1 = j;
    }
    label179:
    label208:
    label210:
    Layout localLayout;
    for (;;)
    {
      scrollTo(0, 0);
      setMeasuredDimension(k, paramInt1);
      GMTrace.o(3263235620864L, 24313);
      return;
      paramInt1 = k - paramInt1;
      break;
      if (this.vmQ.getWidth() != paramInt1) {}
      for (paramInt2 = 1;; paramInt2 = 0)
      {
        if (paramInt2 == 0) {
          break label208;
        }
        ea(paramInt1, paramInt1);
        break;
      }
      break label132;
      localLayout = this.vmQ;
      if (localLayout != null) {
        break label248;
      }
      paramInt2 = 0;
      this.vmZ = paramInt2;
      paramInt1 = paramInt2;
      if (m == Integer.MIN_VALUE) {
        paramInt1 = Math.min(paramInt2, j);
      }
    }
    label248:
    paramInt2 = localLayout.getLineCount();
    paramInt1 = getCompoundPaddingTop();
    int n = getCompoundPaddingBottom() + paramInt1;
    paramInt1 = localLayout.getLineTop(paramInt2) + n;
    int i;
    if (this.vmU == 1)
    {
      i = paramInt2;
      if (paramInt2 > this.vmT)
      {
        paramInt1 = localLayout.getLineTop(this.vmT) + localLayout.getBottomPadding() + n;
        i = this.vmT;
      }
      label319:
      if (this.vmW != 1) {
        break label397;
      }
      paramInt2 = paramInt1;
      if (i < this.vmV) {
        paramInt2 = Math.round(this.gm.getFontMetricsInt(null) * this.vmR + this.vmS);
      }
    }
    label397:
    for (paramInt2 = paramInt1 + (this.vmV - i) * paramInt2;; paramInt2 = Math.max(paramInt1, this.vmV))
    {
      paramInt2 = Math.max(paramInt2, getSuggestedMinimumHeight());
      break;
      paramInt1 = Math.min(paramInt1, this.vmT);
      i = paramInt2;
      break label319;
    }
  }
  
  public final void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    GMTrace.i(3263638274048L, 24316);
    this.vmM = paramTruncateAt;
    if (this.vmQ != null)
    {
      bSG();
      requestLayout();
      invalidate();
    }
    GMTrace.o(3263638274048L, 24316);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(3261222354944L, 24298);
    if ((paramInt1 != getPaddingLeft()) || (paramInt3 != getPaddingRight()) || (paramInt2 != getPaddingTop()) || (paramInt4 != getPaddingBottom())) {
      bSG();
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    invalidate();
    GMTrace.o(3261222354944L, 24298);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    GMTrace.i(3262027661312L, 24304);
    int k = this.vmO;
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (!localObject.equals(this.mText))
    {
      label76:
      int i;
      int j;
      if ((localObject instanceof Spanned))
      {
        this.vnc = false;
        if ((k != a.vnt) && (this.vmP == null)) {
          break label197;
        }
        paramCharSequence = this.vmK.newEditable((CharSequence)localObject);
        i = getCompoundPaddingRight();
        j = getCompoundPaddingLeft() + i;
        localObject = paramCharSequence;
        if (this.vng)
        {
          if (!this.vmX) {
            break label221;
          }
          i = this.iO;
          if (getMeasuredWidth() > 0) {
            i = Math.min(this.iO, getMeasuredWidth());
          }
          localObject = TextUtils.ellipsize(paramCharSequence, this.gm, i - j, TextUtils.TruncateAt.END);
        }
      }
      for (;;)
      {
        this.vmO = k;
        this.mText = ((CharSequence)localObject);
        this.vmN = ((CharSequence)localObject);
        if (!this.vnc) {
          break label262;
        }
        bSI();
        invalidate();
        GMTrace.o(3262027661312L, 24304);
        return;
        this.vnc = true;
        break;
        label197:
        paramCharSequence = (CharSequence)localObject;
        if (k != a.vns) {
          break label76;
        }
        paramCharSequence = this.vmL.newSpannable((CharSequence)localObject);
        break label76;
        label221:
        if (getMeasuredWidth() > 0)
        {
          localObject = TextUtils.ellipsize(paramCharSequence, this.gm, getMeasuredWidth() - j, TextUtils.TruncateAt.END);
        }
        else
        {
          this.vnf = true;
          localObject = paramCharSequence;
        }
      }
      label262:
      if (getWidth() != 0)
      {
        if (this.vmQ == null)
        {
          bSH();
          if (this.vmQ.getHeight() != getHeight()) {
            requestLayout();
          }
          invalidate();
          GMTrace.o(3262027661312L, 24304);
          return;
        }
        i = this.vmQ.getHeight();
        k = this.vmQ.getWidth();
        ea(k, k - j);
        if (this.vmM != TextUtils.TruncateAt.MARQUEE)
        {
          if ((getLayoutParams().height != -2) && (getLayoutParams().height != -1))
          {
            invalidate();
            GMTrace.o(3262027661312L, 24304);
            return;
          }
          j = this.vmQ.getHeight();
          if ((j == i) && (j == getHeight()))
          {
            invalidate();
            GMTrace.o(3262027661312L, 24304);
            return;
          }
        }
      }
      requestLayout();
      invalidate();
    }
    GMTrace.o(3262027661312L, 24304);
  }
  
  public final void setTextColor(int paramInt)
  {
    GMTrace.i(3261490790400L, 24300);
    this.ec = ColorStateList.valueOf(paramInt);
    updateTextColors();
    GMTrace.o(3261490790400L, 24300);
  }
  
  public final void setTextColor(ColorStateList paramColorStateList)
  {
    GMTrace.i(3261625008128L, 24301);
    if (paramColorStateList == null) {
      throw new NullPointerException();
    }
    if (this.ec == paramColorStateList)
    {
      GMTrace.o(3261625008128L, 24301);
      return;
    }
    this.ec = paramColorStateList;
    updateTextColors();
    GMTrace.o(3261625008128L, 24301);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    GMTrace.i(3260148613120L, 24290);
    boolean bool = super.verifyDrawable(paramDrawable);
    if ((!bool) && (this.vnh != null))
    {
      if ((paramDrawable == this.vnh.vny) || (paramDrawable == this.vnh.vnw) || (paramDrawable == this.vnh.vnz) || (paramDrawable == this.vnh.vnx))
      {
        GMTrace.o(3260148613120L, 24290);
        return true;
      }
      GMTrace.o(3260148613120L, 24290);
      return false;
    }
    GMTrace.o(3260148613120L, 24290);
    return bool;
  }
  
  public final void wa()
  {
    GMTrace.i(3261759225856L, 24302);
    int i = 0;
    if (5 != (this.tW & 0x7)) {
      i = 1;
    }
    if (53 != this.tW) {
      invalidate();
    }
    this.tW = 53;
    if ((this.vmQ != null) && (i != 0)) {
      ea(this.vmQ.getWidth(), getWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight());
    }
    GMTrace.o(3261759225856L, 24302);
  }
  
  public static enum a
  {
    static
    {
      GMTrace.i(3294374133760L, 24545);
      vnr = 1;
      vns = 2;
      vnt = 3;
      vnu = new int[] { vnr, vns, vnt };
      GMTrace.o(3294374133760L, 24545);
    }
  }
  
  final class b
  {
    int vnA;
    int vnB;
    int vnC;
    int vnD;
    int vnE;
    int vnF;
    int vnG;
    int vnH;
    int vnI;
    final Rect vnv;
    Drawable vnw;
    Drawable vnx;
    Drawable vny;
    Drawable vnz;
    
    b()
    {
      GMTrace.i(3335981629440L, 24855);
      this.vnv = new Rect();
      GMTrace.o(3335981629440L, 24855);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/NoMeasuredTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */