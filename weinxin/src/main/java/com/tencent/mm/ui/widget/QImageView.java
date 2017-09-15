package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.RemoteViews.RemoteView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

@RemoteViews.RemoteView
public class QImageView
  extends View
{
  private static final a[] wvh;
  private static final Matrix.ScaleToFit[] wvi;
  private int CS;
  private boolean Xa;
  private Uri apg;
  private int iO;
  private Context mContext;
  public Drawable mDrawable;
  public Matrix mMatrix;
  private ColorFilter mn;
  private int sOf;
  private int wuS;
  private a wuT;
  private boolean wuU;
  private boolean wuV;
  private int wuW;
  private boolean wuX;
  private int[] wuY;
  private boolean wuZ;
  private int wva;
  private int wvb;
  private int wvc;
  private Matrix wvd;
  private final RectF wve;
  private final RectF wvf;
  private boolean wvg;
  
  static
  {
    GMTrace.i(1621752807424L, 12083);
    wvh = new a[] { a.wvj, a.wvk, a.wvl, a.wvm, a.wvn, a.wvo, a.wvp, a.wvq };
    wvi = new Matrix.ScaleToFit[] { Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END };
    GMTrace.o(1621752807424L, 12083);
  }
  
  public QImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(1618263146496L, 12057);
    this.mContext = paramContext;
    caA();
    GMTrace.o(1618263146496L, 12057);
  }
  
  public QImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1618397364224L, 12058);
    this.wuS = 0;
    this.wuU = false;
    this.wuV = false;
    this.iO = Integer.MAX_VALUE;
    this.sOf = Integer.MAX_VALUE;
    this.CS = 255;
    this.wuW = 256;
    this.wuX = false;
    this.mDrawable = null;
    this.wuY = null;
    this.wuZ = false;
    this.wva = 0;
    this.wvd = null;
    this.wve = new RectF();
    this.wvf = new RectF();
    this.Xa = false;
    this.mContext = paramContext;
    caA();
    this.Xa = false;
    this.wuV = false;
    this.iO = Integer.MAX_VALUE;
    this.sOf = Integer.MAX_VALUE;
    this.wvg = false;
    GMTrace.o(1618397364224L, 12058);
  }
  
  private static int Z(int paramInt1, int paramInt2, int paramInt3)
  {
    GMTrace.i(1620544847872L, 12074);
    int i = View.MeasureSpec.getMode(paramInt3);
    paramInt3 = View.MeasureSpec.getSize(paramInt3);
    switch (i)
    {
    }
    for (;;)
    {
      GMTrace.o(1620544847872L, 12074);
      return paramInt1;
      paramInt1 = Math.min(paramInt1, paramInt2);
      continue;
      paramInt1 = Math.min(Math.min(paramInt1, paramInt3), paramInt2);
      continue;
      paramInt1 = paramInt3;
    }
  }
  
  private void caA()
  {
    GMTrace.i(1618531581952L, 12059);
    this.mMatrix = new Matrix();
    this.wuT = a.wvm;
    GMTrace.o(1618531581952L, 12059);
  }
  
  private void caB()
  {
    Object localObject1 = null;
    GMTrace.i(1619739541504L, 12068);
    if (this.mDrawable != null)
    {
      GMTrace.o(1619739541504L, 12068);
      return;
    }
    Object localObject2 = getResources();
    if (localObject2 == null)
    {
      GMTrace.o(1619739541504L, 12068);
      return;
    }
    if (this.wuS != 0) {}
    while (this.apg != null)
    {
      try
      {
        localObject2 = ((Resources)localObject2).getDrawable(this.wuS);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          v.w("ImageView", "Unable to find resource: " + this.wuS, new Object[] { localException });
          this.apg = null;
        }
      }
      w((Drawable)localObject1);
      GMTrace.o(1619739541504L, 12068);
      return;
    }
    GMTrace.o(1619739541504L, 12068);
  }
  
  private void caC()
  {
    float f2 = 0.0F;
    GMTrace.i(1620813283328L, 12076);
    if ((this.mDrawable == null) || (!this.wuU))
    {
      GMTrace.o(1620813283328L, 12076);
      return;
    }
    int j = this.wvb;
    int k = this.wvc;
    int m = getWidth() - getPaddingLeft() - getPaddingRight();
    int n = getHeight() - getPaddingTop() - getPaddingBottom();
    if (((j < 0) || (m == j)) && ((k < 0) || (n == k))) {}
    for (int i = 1; (j <= 0) || (k <= 0) || (a.wvk == this.wuT); i = 0)
    {
      this.mDrawable.setBounds(0, 0, m, n);
      this.wvd = null;
      GMTrace.o(1620813283328L, 12076);
      return;
    }
    this.mDrawable.setBounds(0, 0, j, k);
    if (a.wvj == this.wuT)
    {
      if (this.mMatrix.isIdentity())
      {
        this.wvd = null;
        GMTrace.o(1620813283328L, 12076);
        return;
      }
      this.wvd = this.mMatrix;
      GMTrace.o(1620813283328L, 12076);
      return;
    }
    if (i != 0)
    {
      this.wvd = null;
      GMTrace.o(1620813283328L, 12076);
      return;
    }
    if (a.wvo == this.wuT)
    {
      this.wvd = this.mMatrix;
      this.wvd.setTranslate((int)((m - j) * 0.5F + 0.5F), (int)((n - k) * 0.5F + 0.5F));
      GMTrace.o(1620813283328L, 12076);
      return;
    }
    float f1;
    float f3;
    if (a.wvp == this.wuT)
    {
      this.wvd = this.mMatrix;
      if (j * n > m * k)
      {
        f1 = n / k;
        f3 = (m - j * f1) * 0.5F;
      }
      for (;;)
      {
        this.wvd.setScale(f1, f1);
        this.wvd.postTranslate((int)(f3 + 0.5F), (int)(f2 + 0.5F));
        GMTrace.o(1620813283328L, 12076);
        return;
        f1 = m / j;
        f2 = n;
        float f4 = k;
        f3 = 0.0F;
        f2 = (f2 - f4 * f1) * 0.5F;
      }
    }
    if (a.wvq == this.wuT)
    {
      this.wvd = this.mMatrix;
      if ((j <= m) && (k <= n)) {}
      for (f1 = 1.0F;; f1 = Math.min(m / j, n / k))
      {
        f2 = (int)((m - j * f1) * 0.5F + 0.5F);
        f3 = (int)((n - k * f1) * 0.5F + 0.5F);
        this.wvd.setScale(f1, f1);
        this.wvd.postTranslate(f2, f3);
        GMTrace.o(1620813283328L, 12076);
        return;
      }
    }
    this.wve.set(0.0F, 0.0F, j, k);
    this.wvf.set(0.0F, 0.0F, m, n);
    this.wvd = this.mMatrix;
    Matrix localMatrix = this.wvd;
    RectF localRectF1 = this.wve;
    RectF localRectF2 = this.wvf;
    a locala = this.wuT;
    localMatrix.setRectToRect(localRectF1, localRectF2, wvi[(locala.wvr - 1)]);
    GMTrace.o(1620813283328L, 12076);
  }
  
  private void caD()
  {
    GMTrace.i(1621484371968L, 12081);
    if ((this.mDrawable != null) && (this.wuX))
    {
      this.mDrawable = this.mDrawable.mutate();
      this.mDrawable.setColorFilter(this.mn);
      this.mDrawable.setAlpha(this.CS * this.wuW >> 8);
    }
    GMTrace.o(1621484371968L, 12081);
  }
  
  private void w(Drawable paramDrawable)
  {
    GMTrace.i(1620276412416L, 12072);
    if (this.mDrawable != null)
    {
      this.mDrawable.setCallback(null);
      unscheduleDrawable(this.mDrawable);
    }
    this.mDrawable = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(getDrawableState());
      }
      paramDrawable.setLevel(this.wva);
      this.wvb = paramDrawable.getIntrinsicWidth();
      this.wvc = paramDrawable.getIntrinsicHeight();
      caD();
      caC();
    }
    GMTrace.o(1620276412416L, 12072);
  }
  
  public final void a(a parama)
  {
    GMTrace.i(1620007976960L, 12070);
    if (parama == null) {
      throw new NullPointerException();
    }
    if (this.wuT != parama)
    {
      this.wuT = parama;
      if (this.wuT != a.wvo) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      setWillNotCacheDrawing(bool);
      requestLayout();
      invalidate();
      GMTrace.o(1620007976960L, 12070);
      return;
    }
  }
  
  protected void drawableStateChanged()
  {
    GMTrace.i(1620947501056L, 12077);
    super.drawableStateChanged();
    Drawable localDrawable = this.mDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
    GMTrace.o(1620947501056L, 12077);
  }
  
  public int getBaseline()
  {
    GMTrace.i(1621215936512L, 12079);
    if (this.Xa)
    {
      int i = getMeasuredHeight();
      GMTrace.o(1621215936512L, 12079);
      return i;
    }
    GMTrace.o(1621215936512L, 12079);
    return -1;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    GMTrace.i(1618800017408L, 12061);
    if (paramDrawable == this.mDrawable)
    {
      invalidate();
      GMTrace.o(1618800017408L, 12061);
      return;
    }
    super.invalidateDrawable(paramDrawable);
    GMTrace.o(1618800017408L, 12061);
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    GMTrace.i(1620142194688L, 12071);
    if (this.wuY == null)
    {
      arrayOfInt = super.onCreateDrawableState(paramInt);
      GMTrace.o(1620142194688L, 12071);
      return arrayOfInt;
    }
    if (!this.wuZ)
    {
      arrayOfInt = this.wuY;
      GMTrace.o(1620142194688L, 12071);
      return arrayOfInt;
    }
    int[] arrayOfInt = mergeDrawableStates(super.onCreateDrawableState(this.wuY.length + paramInt), this.wuY);
    GMTrace.o(1620142194688L, 12071);
    return arrayOfInt;
  }
  
  public void onDetachedFromWindow()
  {
    GMTrace.i(1621618589696L, 12082);
    super.onDetachedFromWindow();
    GMTrace.o(1621618589696L, 12082);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    GMTrace.i(1621081718784L, 12078);
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    super.onDraw(paramCanvas);
    if (this.mDrawable == null)
    {
      GMTrace.o(1621081718784L, 12078);
      return;
    }
    if ((this.wvb == 0) || (this.wvc == 0))
    {
      GMTrace.o(1621081718784L, 12078);
      return;
    }
    if ((this.wvd == null) && (getPaddingTop() == 0) && (getPaddingLeft() == 0))
    {
      this.mDrawable.draw(paramCanvas);
      GMTrace.o(1621081718784L, 12078);
      return;
    }
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    if (this.wvg)
    {
      int j = getScrollX();
      int k = getScrollY();
      paramCanvas.clipRect(getPaddingLeft() + j, getPaddingTop() + k, j + getRight() - getLeft() - getPaddingRight(), k + getBottom() - getTop() - getPaddingBottom());
    }
    paramCanvas.translate(getPaddingLeft(), getPaddingTop());
    if (this.wvd != null) {
      paramCanvas.concat(this.wvd);
    }
    this.mDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
    GMTrace.o(1621081718784L, 12078);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(1620679065600L, 12075);
    this.wuU = true;
    caC();
    GMTrace.o(1620679065600L, 12075);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    GMTrace.i(1620410630144L, 12073);
    caB();
    float f = 0.0F;
    int m = 0;
    int k;
    int i;
    int j;
    if (this.mDrawable == null)
    {
      this.wvb = -1;
      this.wvc = -1;
      k = 0;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      int i2 = getPaddingLeft();
      int i3 = getPaddingRight();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      if ((m != 0) || (i != 0))
      {
        paramInt1 = Z(k + i2 + i3, this.iO, paramInt1);
        paramInt2 = Z(j + n + i1, this.sOf, paramInt2);
        if ((f == 0.0F) || (Math.abs((paramInt1 - i2 - i3) / (paramInt2 - n - i1) - f) <= 1.0E-7D)) {
          break label428;
        }
        if (m == 0) {
          break label422;
        }
        j = (int)((paramInt2 - n - i1) * f) + i2 + i3;
        if (j > paramInt1) {
          break label422;
        }
        k = 1;
        paramInt1 = j;
        j = k;
        label188:
        if ((j != 0) || (i == 0)) {
          break label411;
        }
        i = (int)((paramInt1 - i2 - i3) / f) + n + i1;
        if (i > paramInt2) {
          break label411;
        }
        paramInt2 = paramInt1;
        paramInt1 = i;
      }
      for (;;)
      {
        setMeasuredDimension(paramInt2, paramInt1);
        GMTrace.o(1620410630144L, 12073);
        return;
        j = this.wvb;
        k = this.wvc;
        i = j;
        if (j <= 0) {
          i = 1;
        }
        j = k;
        if (k <= 0) {
          j = 1;
        }
        if (!this.wuV) {
          break label439;
        }
        m = View.MeasureSpec.getMode(paramInt1);
        k = View.MeasureSpec.getMode(paramInt2);
        if (m != 1073741824)
        {
          m = 1;
          label310:
          if (k == 1073741824) {
            break label350;
          }
        }
        label350:
        for (k = 1;; k = 0)
        {
          f = i / j;
          n = k;
          k = i;
          i = n;
          break;
          m = 0;
          break label310;
        }
        i = Math.max(k + (i2 + i3), getSuggestedMinimumWidth());
        j = Math.max(j + (n + i1), getSuggestedMinimumHeight());
        i = resolveSize(i, paramInt1);
        paramInt1 = resolveSize(j, paramInt2);
        paramInt2 = i;
        continue;
        label411:
        i = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = i;
        continue;
        label422:
        j = 0;
        break label188;
        label428:
        i = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = i;
      }
      label439:
      n = 0;
      k = i;
      i = n;
    }
  }
  
  protected boolean onSetAlpha(int paramInt)
  {
    GMTrace.i(1618934235136L, 12062);
    if (getBackground() == null)
    {
      paramInt = (paramInt >> 7) + paramInt;
      if (this.wuW != paramInt)
      {
        this.wuW = paramInt;
        this.wuX = true;
        caD();
      }
      GMTrace.o(1618934235136L, 12062);
      return true;
    }
    GMTrace.o(1618934235136L, 12062);
    return false;
  }
  
  public final void setAlpha(int paramInt)
  {
    GMTrace.i(1621350154240L, 12080);
    paramInt &= 0xFF;
    if (this.CS != paramInt)
    {
      this.CS = paramInt;
      this.wuX = true;
      caD();
      invalidate();
    }
    GMTrace.o(1621350154240L, 12080);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    GMTrace.i(1619471106048L, 12066);
    super.setBackgroundDrawable(paramDrawable);
    GMTrace.o(1619471106048L, 12066);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    GMTrace.i(1619605323776L, 12067);
    setImageDrawable(new BitmapDrawable(this.mContext.getResources(), paramBitmap));
    GMTrace.o(1619605323776L, 12067);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    GMTrace.i(1619336888320L, 12065);
    if (this.mDrawable != paramDrawable)
    {
      this.wuS = 0;
      this.apg = null;
      w(paramDrawable);
      invalidate();
    }
    GMTrace.o(1619336888320L, 12065);
  }
  
  public final void setImageResource(int paramInt)
  {
    GMTrace.i(1619068452864L, 12063);
    if ((this.apg != null) || (this.wuS != paramInt))
    {
      w(null);
      this.wuS = paramInt;
      this.apg = null;
      caB();
      invalidate();
    }
    GMTrace.o(1619068452864L, 12063);
  }
  
  @TargetApi(11)
  public void setLayerType(int paramInt, Paint paramPaint)
  {
    GMTrace.i(1619202670592L, 12064);
    if (((this.mDrawable instanceof PictureDrawable)) && (paramInt != 1))
    {
      GMTrace.o(1619202670592L, 12064);
      return;
    }
    super.setLayerType(paramInt, paramPaint);
    GMTrace.o(1619202670592L, 12064);
  }
  
  public void setSelected(boolean paramBoolean)
  {
    GMTrace.i(1619873759232L, 12069);
    super.setSelected(paramBoolean);
    Drawable localDrawable = this.mDrawable;
    if (localDrawable != null)
    {
      int j = localDrawable.getIntrinsicWidth();
      int i = j;
      if (j < 0) {
        i = this.wvb;
      }
      int k = localDrawable.getIntrinsicHeight();
      j = k;
      if (k < 0) {
        j = this.wvc;
      }
      if ((i != this.wvb) || (j != this.wvc))
      {
        this.wvb = i;
        this.wvc = j;
        requestLayout();
      }
    }
    GMTrace.o(1619873759232L, 12069);
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    GMTrace.i(1618665799680L, 12060);
    if ((this.mDrawable == paramDrawable) || (super.verifyDrawable(paramDrawable)))
    {
      GMTrace.o(1618665799680L, 12060);
      return true;
    }
    GMTrace.o(1618665799680L, 12060);
    return false;
  }
  
  public static enum a
  {
    final int wvr;
    
    static
    {
      GMTrace.i(1613565526016L, 12022);
      wvj = new a("MATRIX", 0, 0);
      wvk = new a("FIT_XY", 1, 1);
      wvl = new a("FIT_START", 2, 2);
      wvm = new a("FIT_CENTER", 3, 3);
      wvn = new a("FIT_END", 4, 4);
      wvo = new a("CENTER", 5, 5);
      wvp = new a("CENTER_CROP", 6, 6);
      wvq = new a("CENTER_INSIDE", 7, 7);
      wvs = new a[] { wvj, wvk, wvl, wvm, wvn, wvo, wvp, wvq };
      GMTrace.o(1613565526016L, 12022);
    }
    
    private a(int paramInt)
    {
      GMTrace.i(1613431308288L, 12021);
      this.wvr = paramInt;
      GMTrace.o(1613431308288L, 12021);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/QImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */