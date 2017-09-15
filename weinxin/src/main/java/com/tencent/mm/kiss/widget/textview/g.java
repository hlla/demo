package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.v;

public final class g
{
  protected f haD;
  public a haE;
  protected StaticLayout haF;
  protected boolean haG;
  int haH;
  int haI;
  private boolean haJ;
  boolean haK;
  private boolean haL;
  private boolean haM;
  View haN;
  private int haO;
  private int haP;
  protected CharSequence text;
  
  public g(View paramView, a parama)
  {
    GMTrace.i(441442107392L, 3289);
    this.text = null;
    this.haG = false;
    this.haJ = false;
    this.haK = false;
    this.haL = false;
    this.haM = false;
    this.haO = 0;
    this.haP = 0;
    this.haN = paramView;
    this.haE = parama;
    GMTrace.o(441442107392L, 3289);
  }
  
  private boolean eP(int paramInt)
  {
    GMTrace.i(444126461952L, 3309);
    if ((this.haG) || (this.haD == null) || (this.haF == null))
    {
      if (this.haE == null)
      {
        GMTrace.o(444126461952L, 3309);
        return false;
      }
      if (paramInt > 0)
      {
        wd();
        long l1 = 0L;
        if (h.DEBUG) {
          l1 = System.nanoTime();
        }
        this.haD = d.a(this.text, paramInt, this.haE).vW();
        this.haF = this.haD.haB;
        this.haG = false;
        if (h.DEBUG)
        {
          long l2 = System.nanoTime();
          v.d("MicroMsg.StaticTextViewHolder", "recreateLayoutIfNeed, width: %d, hasCode: %d, used: %fms, text: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Double.valueOf((l2 - l1) / 1000000.0D), this.text });
        }
        GMTrace.o(444126461952L, 3309);
        return true;
      }
    }
    GMTrace.o(444126461952L, 3309);
    return false;
  }
  
  public final Point aG(int paramInt1, int paramInt2)
  {
    GMTrace.i(444260679680L, 3310);
    long l = 0L;
    if (h.DEBUG) {
      l = System.nanoTime();
    }
    int n = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    eP(i);
    if (this.haF != null) {
      if (n == 1073741824) {
        paramInt1 = i;
      }
    }
    for (;;)
    {
      if (m == 1073741824) {
        paramInt2 = j;
      }
      Object localObject1;
      Object localObject2;
      for (;;)
      {
        localObject1 = new Point(paramInt1, paramInt2);
        if (h.DEBUG)
        {
          double d = (System.nanoTime() - l) / 1000000.0D;
          paramInt1 = hashCode();
          CharSequence localCharSequence = this.text;
          if (localObject1 != null) {
            break label606;
          }
          localObject2 = "";
          label130:
          v.d("MicroMsg.StaticTextViewHolder", "onMeasure used: %fms, hashCode: %d, text: %s result: %s", new Object[] { Double.valueOf(d), Integer.valueOf(paramInt1), localCharSequence, localObject2 });
        }
        GMTrace.o(444260679680L, 3310);
        return (Point)localObject1;
        paramInt1 = 0;
        if (this.haE.haq == null)
        {
          localObject1 = this.haF;
          if (this.haO == 0) {
            break label301;
          }
          paramInt1 = this.haO;
        }
        for (;;)
        {
          k = (int)Math.ceil(Layout.getDesiredWidth(this.haF.getText(), this.haF.getPaint()));
          paramInt2 = paramInt1;
          if (k > paramInt1) {
            paramInt2 = k;
          }
          if (h.DEBUG) {
            v.d("MicroMsg.StaticTextViewHolder", "onMeasure  hashCode: %d, des: %d newdes: %d", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt2), Integer.valueOf(k) });
          }
          if (n != Integer.MIN_VALUE) {
            break label622;
          }
          paramInt1 = Math.min(i, paramInt2);
          break;
          label301:
          paramInt2 = ((Layout)localObject1).getLineCount();
          localObject2 = ((Layout)localObject1).getText();
          float f = 0.0F;
          paramInt1 = 0;
          for (;;)
          {
            if (paramInt1 >= paramInt2 - 1) {
              break label358;
            }
            if (((CharSequence)localObject2).charAt(((Layout)localObject1).getLineEnd(paramInt1) - 1) != '\n')
            {
              paramInt1 = -1;
              break;
            }
            paramInt1 += 1;
          }
          label358:
          paramInt1 = 0;
          while (paramInt1 < paramInt2)
          {
            f = Math.max(f, ((Layout)localObject1).getLineWidth(paramInt1));
            paramInt1 += 1;
          }
          this.haO = ((int)Math.ceil(f));
          this.haO += this.haN.getPaddingLeft() + this.haN.getPaddingRight();
          paramInt1 = this.haO;
        }
        localObject1 = this.haF;
        if (this.haP == 0) {
          break label468;
        }
        i = this.haP;
        label447:
        paramInt2 = i;
        if (m == Integer.MIN_VALUE) {
          paramInt2 = Math.min(i, j);
        }
      }
      label468:
      i = ((Layout)localObject1).getLineCount();
      paramInt2 = i;
      if (this.haD.maxLines > 0)
      {
        paramInt2 = i;
        if (this.haD.maxLines < i) {
          paramInt2 = this.haD.maxLines;
        }
      }
      int k = this.haN.getPaddingTop();
      n = this.haN.getPaddingBottom();
      i = ((Layout)localObject1).getLineTop(paramInt2);
      int i1;
      if ((this.haE.minLines > 0) && (paramInt2 < this.haE.minLines)) {
        i1 = getLineHeight();
      }
      for (paramInt2 = (this.haE.minLines - paramInt2) * i1 + i;; paramInt2 = i)
      {
        this.haP = (paramInt2 + (k + n));
        i = this.haP;
        break label447;
        localObject1 = null;
        break;
        label606:
        localObject2 = ((Point)localObject1).toString();
        break label130;
      }
      label622:
      paramInt1 = paramInt2;
    }
  }
  
  public final void b(f paramf)
  {
    GMTrace.i(442113196032L, 3294);
    if ((paramf == null) || (paramf.haB == null))
    {
      this.haD = null;
      GMTrace.o(442113196032L, 3294);
      return;
    }
    if (this.haE == null)
    {
      com.tencent.mm.kiss.widget.textview.a.b localb = new com.tencent.mm.kiss.widget.textview.a.b();
      localb.haE = new a();
      localb.haE.maxLines = paramf.maxLines;
      localb.haE.maxLength = paramf.maxLength;
      localb.haE.haA = paramf.haA;
      localb.haE.hap = paramf.hap;
      localb.haE.haq = paramf.haq;
      localb.haE.gravity = paramf.gravity;
      localb.haE.haV = paramf.haA.getTextSize();
      localb.haE.textColor = paramf.haA.getColor();
      this.haE = localb.haE;
    }
    wd();
    this.haN.setWillNotDraw(false);
    this.haD = paramf;
    this.haF = paramf.haB;
    this.text = paramf.text;
    this.haJ = (this.text instanceof Spannable);
    if (this.haJ)
    {
      this.text = this.haD.text;
      com.tencent.mm.kiss.widget.textview.b.b.wg();
      com.tencent.mm.kiss.widget.textview.b.b.a((Spannable)this.text);
    }
    this.haN.requestLayout();
    this.haN.invalidate();
    GMTrace.o(442113196032L, 3294);
  }
  
  public final int getLineCount()
  {
    GMTrace.i(443589591040L, 3305);
    if (this.haF == null)
    {
      GMTrace.o(443589591040L, 3305);
      return 0;
    }
    int i = this.haF.getLineCount();
    GMTrace.o(443589591040L, 3305);
    return i;
  }
  
  public final int getLineHeight()
  {
    GMTrace.i(442650066944L, 3298);
    TextPaint localTextPaint2 = this.haD.haB.getPaint();
    TextPaint localTextPaint1 = localTextPaint2;
    if (localTextPaint2 == null) {
      localTextPaint1 = this.haE.haA;
    }
    int i = Math.round(localTextPaint1.getFontMetricsInt(null) * this.haE.hau + this.haE.hat);
    GMTrace.o(442650066944L, 3298);
    return i;
  }
  
  public final CharSequence getText()
  {
    GMTrace.i(443052720128L, 3301);
    CharSequence localCharSequence = this.text;
    GMTrace.o(443052720128L, 3301);
    return localCharSequence;
  }
  
  public final float getTextSize()
  {
    GMTrace.i(443186937856L, 3302);
    if (this.haD == null)
    {
      if (this.haE != null)
      {
        f = this.haE.haV;
        GMTrace.o(443186937856L, 3302);
        return f;
      }
      GMTrace.o(443186937856L, 3302);
      return 0.0F;
    }
    float f = this.haD.haA.getTextSize();
    GMTrace.o(443186937856L, 3302);
    return f;
  }
  
  public final void init()
  {
    GMTrace.i(441576325120L, 3290);
    this.text = "";
    this.haN.setWillNotDraw(false);
    GMTrace.o(441576325120L, 3290);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    GMTrace.i(443992244224L, 3308);
    if ((this.haF == null) || (this.haD == null))
    {
      boolean bool = eP(this.haN.getMeasuredWidth());
      if (h.DEBUG) {
        v.d("MicroMsg.StaticTextViewHolder", "onDraw, textLayout==null:%b, layoutWrapper==null:%b recreate:%b", new Object[] { this.haF, this.haD, Boolean.valueOf(bool) });
      }
      if (bool)
      {
        this.haN.requestLayout();
        this.haN.invalidate();
      }
      GMTrace.o(443992244224L, 3308);
      return;
    }
    long l = 0L;
    if (h.DEBUG) {
      l = System.nanoTime();
    }
    paramCanvas.save();
    int k = this.haN.getPaddingLeft();
    int m = this.haN.getPaddingTop();
    int n = this.haN.getRight() - this.haN.getLeft() - this.haN.getPaddingRight();
    int i1 = this.haN.getBottom() - this.haN.getTop() - this.haN.getPaddingBottom();
    paramCanvas.clipRect(k, m, n, i1);
    int j;
    int i;
    int i2;
    int i3;
    if ((this.haH == 0) || (this.haI == 0))
    {
      j = this.haN.getPaddingLeft();
      i = this.haN.getRight() - this.haN.getLeft() - this.haN.getPaddingLeft() - this.haN.getPaddingRight();
      i2 = this.haF.getWidth();
      if (i2 > i)
      {
        i = j;
        this.haH = i;
        j = this.haN.getPaddingTop();
        i2 = this.haN.getBottom() - this.haN.getTop() - this.haN.getPaddingTop() - this.haN.getPaddingBottom();
        i = 0;
        i3 = this.haF.getHeight();
        if (i3 <= i2) {
          break label574;
        }
        i = j;
        this.haI = i;
      }
    }
    else
    {
      paramCanvas.translate(this.haH, this.haI);
      this.haF.draw(paramCanvas, null, null, 0);
      paramCanvas.restore();
      if (h.DEBUG) {
        v.d("MicroMsg.StaticTextViewHolder", "onDraw used: %fms, hashCode: %d, text: %s clipLeft:%d clipTop:%d clipRight:%d clipBottom:%d", new Object[] { Double.valueOf((System.nanoTime() - l) / 1000000.0D), Integer.valueOf(hashCode()), this.text, Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
      }
      GMTrace.o(443992244224L, 3308);
      return;
    }
    switch (this.haD.gravity & 0x800007)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      i += j;
      break;
      i = 0;
      continue;
      i = i / 2 - i2 / 2;
      continue;
      i -= i2;
    }
    label574:
    switch (this.haD.gravity & 0x70)
    {
    }
    for (;;)
    {
      i += j;
      break;
      i = 0;
      continue;
      i = i2 / 2 - i3 / 2;
      continue;
      i = i2 - i3;
    }
  }
  
  public final boolean performClick()
  {
    GMTrace.i(443858026496L, 3307);
    if ((this.haM) || (!this.haK))
    {
      GMTrace.o(443858026496L, 3307);
      return false;
    }
    GMTrace.o(443858026496L, 3307);
    return true;
  }
  
  public final boolean q(MotionEvent paramMotionEvent)
  {
    int j = -1;
    boolean bool2 = false;
    GMTrace.i(443723808768L, 3306);
    int i;
    boolean bool1;
    float f2;
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      i = 1;
      bool1 = bool2;
      if (this.haN.isEnabled())
      {
        bool1 = bool2;
        if (this.haJ)
        {
          com.tencent.mm.kiss.widget.textview.b.b.wg();
          bool1 = com.tencent.mm.kiss.widget.textview.b.b.a(this.haN, this.haF, (Spannable)this.text, paramMotionEvent);
          this.haM = bool1;
          if ((!this.haL) || (i == 0)) {
            break label298;
          }
          float f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((f1 >= this.haH) && (f1 <= this.haF.getWidth() + this.haH)) {
            break label234;
          }
          i = 0;
          label143:
          if (i == 0) {
            break label298;
          }
          paramMotionEvent = (Spannable)this.text;
          if (this.text != null) {
            break label274;
          }
          i = -1;
          label166:
          if (this.text != null) {
            break label286;
          }
          label173:
          paramMotionEvent = (ClickableSpan[])paramMotionEvent.getSpans(i, j, ClickableSpan.class);
          if (paramMotionEvent.length <= 0) {
            break label298;
          }
          v.d("MicroMsg.StaticTextViewHolder", "perform clickable span click");
          paramMotionEvent[0].onClick(this.haN);
          bool1 = true;
        }
      }
    }
    label234:
    label274:
    label286:
    label298:
    for (;;)
    {
      GMTrace.o(443723808768L, 3306);
      return bool1;
      i = 0;
      break;
      if ((f2 < this.haI) || (f2 > this.haF.getHeight() + this.haI))
      {
        i = 0;
        break label143;
      }
      i = 1;
      break label143;
      i = Selection.getSelectionStart(this.text);
      break label166;
      j = Selection.getSelectionEnd(this.text);
      break label173;
    }
  }
  
  public final void setGravity(int paramInt)
  {
    GMTrace.i(442381631488L, 3296);
    if ((this.haE != null) && (paramInt != this.haE.gravity))
    {
      this.haE.gravity = paramInt;
      this.haG = true;
      if (h.DEBUG) {
        v.i("MicroMsg.StaticTextViewHolder", "setGravity isNeedRecreateLayout");
      }
    }
    GMTrace.o(442381631488L, 3296);
  }
  
  public final void setLines(int paramInt)
  {
    GMTrace.i(441844760576L, 3292);
    if ((this.haE.maxLines != paramInt) || (this.haE.minLines != paramInt))
    {
      this.haG = true;
      wd();
      this.haE.maxLines = paramInt;
      this.haE.minLines = paramInt;
      this.haN.requestLayout();
      this.haN.invalidate();
      if (h.DEBUG) {
        v.i("MicroMsg.StaticTextViewHolder", "setLines isNeedRecreateLayout");
      }
    }
    GMTrace.o(441844760576L, 3292);
  }
  
  public final void setMaxLines(int paramInt)
  {
    GMTrace.i(442515849216L, 3297);
    if ((this.haE != null) && (paramInt != this.haE.maxLines))
    {
      this.haE.maxLines = paramInt;
      this.haG = true;
      wd();
      if (h.DEBUG) {
        v.i("MicroMsg.StaticTextViewHolder", "setMaxLines isNeedRecreateLayout");
      }
      this.haN.requestLayout();
      this.haN.invalidate();
    }
    GMTrace.o(442515849216L, 3297);
  }
  
  public final void setSingleLine(boolean paramBoolean)
  {
    GMTrace.i(441710542848L, 3291);
    if (paramBoolean) {}
    for (int i = 1;; i = Integer.MAX_VALUE)
    {
      if (this.haE.maxLines != i)
      {
        this.haE.maxLines = i;
        this.haG = true;
        wd();
        this.haN.requestLayout();
        this.haN.invalidate();
      }
      GMTrace.o(441710542848L, 3291);
      return;
    }
  }
  
  public final void setText(CharSequence paramCharSequence, boolean paramBoolean)
  {
    GMTrace.i(442784284672L, 3299);
    if (paramCharSequence == null)
    {
      GMTrace.o(442784284672L, 3299);
      return;
    }
    if ((this.text == null) || (!this.text.equals(paramCharSequence)) || (paramBoolean))
    {
      this.text = paramCharSequence;
      this.haG = true;
      this.haN.requestLayout();
      this.haN.invalidate();
      if (h.DEBUG) {
        v.i("MicroMsg.StaticTextViewHolder", "setText isNeedRecreateLayout " + paramCharSequence + " hashcode " + hashCode() + " " + new ag().toString());
      }
    }
    GMTrace.o(442784284672L, 3299);
  }
  
  public final void setTextColor(int paramInt)
  {
    GMTrace.i(442247413760L, 3295);
    if ((this.haE != null) && (paramInt != this.haE.textColor))
    {
      this.haE.textColor = paramInt;
      this.haG = true;
      if (h.DEBUG) {
        v.i("MicroMsg.StaticTextViewHolder", "setTextColor isNeedRecreateLayout");
      }
    }
    GMTrace.o(442247413760L, 3295);
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    GMTrace.i(441978978304L, 3293);
    Object localObject = aa.getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      paramFloat = TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics());
      if ((paramFloat != 0.0F) && (this.haE != null) && (paramFloat != this.haE.haV))
      {
        this.haE.haV = paramFloat;
        this.haG = true;
        if (h.DEBUG) {
          v.i("MicroMsg.StaticTextViewHolder", "setRawTextSize isNeedRecreateLayout");
        }
      }
      GMTrace.o(441978978304L, 3293);
      return;
    }
  }
  
  public final Layout wb()
  {
    GMTrace.i(443321155584L, 3303);
    StaticLayout localStaticLayout = this.haF;
    GMTrace.o(443321155584L, 3303);
    return localStaticLayout;
  }
  
  public final f wc()
  {
    GMTrace.i(443455373312L, 3304);
    f localf = this.haD;
    GMTrace.o(443455373312L, 3304);
    return localf;
  }
  
  final void wd()
  {
    GMTrace.i(442918502400L, 3300);
    this.haP = 0;
    this.haO = 0;
    this.haH = 0;
    this.haI = 0;
    GMTrace.o(442918502400L, 3300);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/kiss/widget/textview/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */