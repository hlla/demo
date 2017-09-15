package com.tencent.mm.ui.widget.celltextview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bm.a.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.celltextview.b.a.a;
import com.tencent.mm.ui.widget.celltextview.c.d;
import com.tencent.mm.ui.widget.celltextview.c.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CellTextView
  extends View
  implements com.tencent.mm.ui.widget.celltextview.b.a.b
{
  protected GestureDetector iWM;
  protected Context mContext;
  protected a.a wvU;
  protected String wvV;
  protected int wvW;
  protected int wvX;
  protected ArrayList<d> wvY;
  protected LinkedList<com.tencent.mm.ui.widget.celltextview.c.b> wvZ;
  protected b wwa;
  public TextView wwb;
  public boolean wwc;
  protected int xT;
  public c xoj;
  
  public CellTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(18757061705728L, 139751);
    this.wvV = null;
    this.wvW = -1;
    this.wvX = -1;
    this.xT = -13290187;
    b(paramContext, paramAttributeSet, 0);
    GMTrace.o(18757061705728L, 139751);
  }
  
  public CellTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(18757195923456L, 139752);
    this.wvV = null;
    this.wvW = -1;
    this.wvX = -1;
    this.xT = -13290187;
    b(paramContext, paramAttributeSet, paramInt);
    GMTrace.o(18757195923456L, 139752);
  }
  
  private void Co(int paramInt)
  {
    GMTrace.i(18759074971648L, 139766);
    caH().Co(paramInt);
    GMTrace.o(18759074971648L, 139766);
  }
  
  private void Wu(String paramString)
  {
    GMTrace.i(19012478042112L, 141654);
    if (paramString == null)
    {
      v.w("CellTextView", "[setText] text is null");
      GMTrace.o(19012478042112L, 141654);
      return;
    }
    setContentDescription(paramString);
    if (this.wwa != null)
    {
      b localb = this.wwa;
      TextView.BufferType localBufferType = TextView.BufferType.NORMAL;
      localb.Q(paramString);
    }
    this.wvY.clear();
    this.wwc = false;
    int i;
    if (!paramString.matches("^[[^\000-￿]\\u2005\\u000D\\u000A\\u0020-\\u007F\\u4E00-\\u9FA5\\u2010-\\u201f\\u2026-\\u2027\\u3001-\\u3002\\u300a-\\u3011\\uff01-\\uff0d\\uff1a-\\uff1f\\uff5e\\ue107-\\ue14c\\ue403-\\ue41D\\ue312]+$"))
    {
      i = 1;
      if (i == 0) {
        break label130;
      }
      this.wwb.setLayoutParams(getLayoutParams());
      this.wwb.setText(paramString);
      this.wwc = true;
    }
    for (;;)
    {
      requestLayout();
      invalidate();
      GMTrace.o(19012478042112L, 141654);
      return;
      i = 0;
      break;
      label130:
      this.wvY.add(new d(caH().getPaint(), 0, paramString, getTextSize()));
      caH().a(this.wvY, paramString);
    }
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    GMTrace.i(18758806536192L, 139764);
    this.mContext = paramContext;
    this.wvY = new ArrayList();
    this.wvZ = new LinkedList();
    this.iWM = new GestureDetector(paramContext, new a((byte)0));
    this.wwb = new TextView(paramContext);
    this.wwb.setClickable(true);
    this.wwb.setFocusable(true);
    caH();
    setOnTouchListener(new com.tencent.mm.ui.widget.celltextview.e.a());
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.fpb, paramInt, 0);
    for (;;)
    {
      int i5;
      int n;
      int i1;
      int i2;
      int i3;
      try
      {
        int i4 = paramAttributeSet.getIndexCount();
        m = 0;
        k = 0;
        j = 0;
        i = 0;
        paramInt = 0;
        if (paramInt >= i4) {
          break label1017;
        }
        i5 = paramAttributeSet.getIndex(paramInt);
        if (i5 == a.j.wyD)
        {
          setTextSize(paramAttributeSet.getDimensionPixelSize(i5, (int)com.tencent.mm.ui.widget.celltextview.g.b.f(paramContext, 13.0F)));
          n = m;
          i1 = k;
          i2 = j;
          i3 = i;
        }
        else if (i5 == a.j.wyC)
        {
          n = paramAttributeSet.getColor(i5, getResources().getColor(com.tencent.mm.bm.a.b.aVo));
          this.wwb.setTextColor(n);
          caH().setTextColor(n);
          invalidate();
          n = m;
          i1 = k;
          i2 = j;
          i3 = i;
        }
      }
      finally
      {
        paramAttributeSet.recycle();
      }
      if (i5 == a.j.wyA)
      {
        n = m;
        i1 = k;
        i2 = j;
        i3 = i;
        if (paramAttributeSet.getBoolean(i5, false))
        {
          Co(1);
          n = m;
          i1 = k;
          i2 = j;
          i3 = i;
        }
      }
      else if (i5 == a.j.wyq)
      {
        n = paramAttributeSet.getInt(i5, 16);
        this.wwb.setGravity(n);
        caH().Cq(n);
        n = m;
        i1 = k;
        i2 = j;
        i3 = i;
      }
      else if (i5 == a.j.wyt)
      {
        setMaxWidth(paramAttributeSet.getDimensionPixelSize(i5, -1));
        n = m;
        i1 = k;
        i2 = j;
        i3 = i;
      }
      else if (i5 == a.j.wyr)
      {
        n = paramAttributeSet.getDimensionPixelSize(i5, 0);
        this.wwb.setLineSpacing(n, 1.0F);
        caH().Cr(n);
        invalidate();
        n = m;
        i1 = k;
        i2 = j;
        i3 = i;
      }
      else if (i5 == a.j.wyv)
      {
        n = paramAttributeSet.getDimensionPixelSize(i5, -1);
        this.wwb.setMinWidth(n);
        caH().setMinWidth(n);
        n = m;
        i1 = k;
        i2 = j;
        i3 = i;
      }
      else if (i5 == a.j.wyu)
      {
        n = paramAttributeSet.getDimensionPixelSize(i5, -1);
        this.wwb.setMinHeight(n);
        caH().setMinHeight(n);
        n = m;
        i1 = k;
        i2 = j;
        i3 = i;
      }
      else if (i5 == a.j.wys)
      {
        Co(paramAttributeSet.getInt(i5, -1));
        n = m;
        i1 = k;
        i2 = j;
        i3 = i;
      }
      else if (i5 == a.j.wyB)
      {
        Wu(paramAttributeSet.getString(i5));
        n = m;
        i1 = k;
        i2 = j;
        i3 = i;
      }
      else if (i5 == a.j.wyE)
      {
        this.wvX = paramAttributeSet.getInt(i5, -1);
        n = m;
        i1 = k;
        i2 = j;
        i3 = i;
      }
      else if (i5 == a.j.wyF)
      {
        this.wvW = paramAttributeSet.getInt(i5, -1);
        n = m;
        i1 = k;
        i2 = j;
        i3 = i;
      }
      else if (i5 == a.j.wyp)
      {
        this.wvV = paramAttributeSet.getString(i5);
        n = m;
        i1 = k;
        i2 = j;
        i3 = i;
      }
      else if (i5 == a.j.wyx)
      {
        i3 = paramAttributeSet.getDimensionPixelSize(i5, 0);
        n = m;
        i1 = k;
        i2 = j;
      }
      else if (i5 == a.j.wyy)
      {
        i2 = paramAttributeSet.getDimensionPixelSize(i5, 0);
        n = m;
        i1 = k;
        i3 = i;
      }
      else if (i5 == a.j.wyz)
      {
        i1 = paramAttributeSet.getDimensionPixelSize(i5, 0);
        n = m;
        i2 = j;
        i3 = i;
      }
      else if (i5 == a.j.wyw)
      {
        n = paramAttributeSet.getDimensionPixelSize(i5, 0);
        i1 = k;
        i2 = j;
        i3 = i;
      }
      else
      {
        n = m;
        i1 = k;
        i2 = j;
        i3 = i;
        if (i5 == a.j.wyo)
        {
          n = paramAttributeSet.getResourceId(i5, -1);
          Drawable localDrawable = getResources().getDrawable(n);
          if (localDrawable != null) {
            caH().setBackgroundDrawable(localDrawable);
          }
          for (;;)
          {
            this.wwb.setBackground(localDrawable);
            n = m;
            i1 = k;
            i2 = j;
            i3 = i;
            break;
            caH().Cs(getResources().getColor(n));
          }
          label1017:
          setPadding(i, k, j, m);
          paramAttributeSet.recycle();
          paramContext = this.wvV;
          paramInt = this.wvW;
          i = this.wvX;
          caH().U(paramContext, paramInt, i);
          GMTrace.o(18758806536192L, 139764);
          return;
        }
      }
      paramInt += 1;
      int m = n;
      int k = i1;
      int j = i2;
      int i = i3;
    }
  }
  
  public final void S(CharSequence paramCharSequence)
  {
    GMTrace.i(19012612259840L, 141655);
    if (paramCharSequence == null)
    {
      GMTrace.o(19012612259840L, 141655);
      return;
    }
    setContentDescription(paramCharSequence);
    if ((paramCharSequence instanceof Spannable))
    {
      if (this.wwa != null)
      {
        localObject1 = this.wwa;
        localObject2 = TextView.BufferType.SPANNABLE;
        ((b)localObject1).Q(paramCharSequence);
      }
      this.wvY.clear();
      this.wwc = false;
      if (!paramCharSequence.toString().matches("^[[^\000-￿]\\u2005\\u000D\\u000A\\u0020-\\u007F\\u4E00-\\u9FA5\\u2010-\\u201f\\u2026-\\u2027\\u3001-\\u3002\\u300a-\\u3011\\uff01-\\uff0d\\uff1a-\\uff1f\\uff5e\\ue107-\\ue14c\\ue403-\\ue41D\\ue312]+$")) {}
      for (int i = 1; i != 0; i = 0)
      {
        this.wwc = true;
        this.wwb.setLayoutParams(getLayoutParams());
        this.wwb.setText(paramCharSequence);
        requestLayout();
        invalidate();
        GMTrace.o(19012612259840L, 141655);
        return;
      }
      this.wvZ.clear();
      Object localObject1 = caH().getPaint();
      Object localObject2 = this.wvZ;
      ArrayList localArrayList = new ArrayList();
      if ((TextUtils.isEmpty(paramCharSequence)) || (localObject2 == null)) {}
      for (;;)
      {
        this.wvY.addAll(localArrayList);
        caH().a(this.wvY, paramCharSequence);
        caH().aC(this.wvZ);
        break;
        if ((paramCharSequence instanceof Spannable))
        {
          int k = paramCharSequence.length();
          Spannable localSpannable = (Spannable)paramCharSequence;
          i = 0;
          if (i < k)
          {
            int j = localSpannable.nextSpanTransition(i, k, ForegroundColorSpan.class);
            int n = localSpannable.nextSpanTransition(i, k, BackgroundColorSpan.class);
            int i1 = localSpannable.nextSpanTransition(i, k, ClickableSpan.class);
            int i2 = localSpannable.nextSpanTransition(i, k, AbsoluteSizeSpan.class);
            int m = localSpannable.nextSpanTransition(i, k, ImageSpan.class);
            j = Math.min(m, Math.min(Math.min(i2, Math.min(j, i1)), n));
            Object localObject3 = (ImageSpan[])localSpannable.getSpans(i, j, ImageSpan.class);
            Object localObject4;
            if (localObject3.length > 0)
            {
              localObject3 = localObject3[0];
              localObject3 = new e((Paint)localObject1, localSpannable.subSequence(i, m).toString(), (ImageSpan)localObject3, i, m, ((Paint)localObject1).getTextSize());
              ((e)localObject3).az(((Paint)localObject1).getTextSize());
              localObject4 = (AbsoluteSizeSpan[])localSpannable.getSpans(i, m, AbsoluteSizeSpan.class);
              if (localObject4.length > 0) {
                ((e)localObject3).az(localObject4[0].getSize());
              }
              localArrayList.add(localObject3);
            }
            for (;;)
            {
              i = j;
              break;
              localObject3 = new d((Paint)localObject1);
              ((d)localObject3).az(((Paint)localObject1).getTextSize());
              ((d)localObject3).setColor(((Paint)localObject1).getColor());
              ((d)localObject3).setText(localSpannable.subSequence(i, j).toString());
              localObject4 = (ForegroundColorSpan[])localSpannable.getSpans(i, j, ForegroundColorSpan.class);
              if (localObject4.length > 0) {
                ((d)localObject3).setColor(localObject4[0].getForegroundColor());
              }
              localObject4 = (BackgroundColorSpan[])localSpannable.getSpans(i, j, BackgroundColorSpan.class);
              if (localObject4.length > 0) {
                ((d)localObject3).Ek(localObject4[0].getBackgroundColor());
              }
              localObject4 = (AbsoluteSizeSpan[])localSpannable.getSpans(i, j, AbsoluteSizeSpan.class);
              if (localObject4.length > 0) {
                ((d)localObject3).az(localObject4[0].getSize());
              }
              localObject4 = (ClickableSpan[])localSpannable.getSpans(i, j, ClickableSpan.class);
              if (localObject4.length > 0)
              {
                TextPaint localTextPaint = new TextPaint();
                localObject4[0].updateDrawState(localTextPaint);
                ((d)localObject3).setColor(localTextPaint.getColor());
                ((d)localObject3).setUnderlineText(localTextPaint.isUnderlineText());
                ((LinkedList)localObject2).add(new com.tencent.mm.ui.widget.celltextview.c.b(localObject4[0], i, j));
              }
              localArrayList.add(localObject3);
            }
          }
        }
      }
    }
    Wu(paramCharSequence.toString());
    GMTrace.o(19012612259840L, 141655);
  }
  
  public final void a(b paramb)
  {
    GMTrace.i(19012075388928L, 141651);
    this.wwa = paramb;
    GMTrace.o(19012075388928L, 141651);
  }
  
  public final a.a caH()
  {
    GMTrace.i(18757330141184L, 139753);
    if (this.wvU == null)
    {
      this.wvU = new com.tencent.mm.ui.widget.celltextview.d.a(this.mContext, this.wwb.getPaint());
      this.wvU.a(this);
    }
    a.a locala = this.wvU;
    GMTrace.o(18757330141184L, 139753);
    return locala;
  }
  
  public final String caI()
  {
    GMTrace.i(18918122979328L, 140951);
    if (this.wwc)
    {
      str = this.wwb.getText().toString();
      GMTrace.o(18918122979328L, 140951);
      return str;
    }
    String str = caH().caM();
    GMTrace.o(18918122979328L, 140951);
    return str;
  }
  
  @SuppressLint({"GetContentDescriptionOverride"})
  public CharSequence getContentDescription()
  {
    GMTrace.i(18917988761600L, 140950);
    Object localObject = (AccessibilityManager)getContext().getSystemService("accessibility");
    boolean bool1 = ((AccessibilityManager)localObject).isEnabled();
    boolean bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
    if ((bool1) && (bool2)) {}
    for (int i = 1; (i != 0) || (com.tencent.mm.sdk.a.b.bIk()); i = 0)
    {
      localObject = super.getContentDescription();
      GMTrace.o(18917988761600L, 140950);
      return (CharSequence)localObject;
    }
    GMTrace.o(18917988761600L, 140950);
    return "";
  }
  
  public int getPaddingBottom()
  {
    GMTrace.i(18758135447552L, 139759);
    int i = caH().getPaddingBottom();
    GMTrace.o(18758135447552L, 139759);
    return i;
  }
  
  public int getPaddingLeft()
  {
    GMTrace.i(18758269665280L, 139760);
    int i = caH().getPaddingLeft();
    GMTrace.o(18758269665280L, 139760);
    return i;
  }
  
  public int getPaddingRight()
  {
    GMTrace.i(18758403883008L, 139761);
    int i = caH().getPaddingRight();
    GMTrace.o(18758403883008L, 139761);
    return i;
  }
  
  public int getPaddingTop()
  {
    GMTrace.i(18758538100736L, 139762);
    int i = caH().getPaddingTop();
    GMTrace.o(18758538100736L, 139762);
    return i;
  }
  
  public final float getTextSize()
  {
    GMTrace.i(19012746477568L, 141656);
    float f = caH().getTextSize();
    GMTrace.o(19012746477568L, 141656);
    return f;
  }
  
  public final View getView()
  {
    GMTrace.i(18758672318464L, 139763);
    GMTrace.o(18758672318464L, 139763);
    return this;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    GMTrace.i(18757598576640L, 139755);
    super.onDraw(paramCanvas);
    if (!this.wwc)
    {
      caH().onDraw(paramCanvas);
      GMTrace.o(18757598576640L, 139755);
      return;
    }
    paramCanvas.save();
    paramCanvas.translate(getPaddingLeft(), getPaddingTop());
    this.wwb.getLayout().draw(paramCanvas);
    paramCanvas.restore();
    GMTrace.o(18757598576640L, 139755);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    GMTrace.i(18760148713472L, 139774);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (paramAccessibilityEvent.getEventType() == 8192)
    {
      paramAccessibilityEvent.setFromIndex(Selection.getSelectionStart(caI()));
      paramAccessibilityEvent.setToIndex(Selection.getSelectionEnd(caI()));
      if (!TextUtils.isEmpty(caI())) {
        paramAccessibilityEvent.setItemCount(caI().length());
      }
    }
    GMTrace.o(18760148713472L, 139774);
  }
  
  @TargetApi(19)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    GMTrace.i(18760282931200L, 139775);
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    if (!TextUtils.isEmpty(caI()))
    {
      paramAccessibilityNodeInfo.addAction(256);
      paramAccessibilityNodeInfo.addAction(512);
      paramAccessibilityNodeInfo.setMovementGranularities(31);
      if (Build.VERSION.SDK_INT >= 18) {
        paramAccessibilityNodeInfo.addAction(131072);
      }
    }
    if ((isFocused()) && (Build.VERSION.SDK_INT >= 18))
    {
      paramAccessibilityNodeInfo.addAction(16384);
      paramAccessibilityNodeInfo.addAction(32768);
      paramAccessibilityNodeInfo.addAction(65536);
    }
    if ((Build.VERSION.SDK_INT >= 19) && (caH().getMaxLines() > 1)) {
      paramAccessibilityNodeInfo.setMultiLine(true);
    }
    GMTrace.o(18760282931200L, 139775);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    GMTrace.i(18757464358912L, 139754);
    if (!this.wwc)
    {
      int i = View.MeasureSpec.getMode(paramInt1);
      int j = View.MeasureSpec.getSize(paramInt1);
      paramInt2 = paramInt1;
      if (i == 0)
      {
        paramInt2 = paramInt1;
        if (j == 0) {
          paramInt2 = Integer.MIN_VALUE;
        }
      }
      caH().Cp(paramInt2);
      setMeasuredDimension(caH().getMeasuredWidth(), caH().getMeasuredHeight());
      setContentDescription(caH().getText());
      GMTrace.o(18757464358912L, 139754);
      return;
    }
    this.wwb.measure(paramInt1, paramInt2);
    setMeasuredDimension(this.wwb.getMeasuredWidth(), this.wwb.getMeasuredHeight());
    GMTrace.o(18757464358912L, 139754);
  }
  
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    GMTrace.i(18760014495744L, 139773);
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    if (!TextUtils.isEmpty(caI())) {
      paramAccessibilityEvent.getText().add(caI());
    }
    GMTrace.o(18760014495744L, 139773);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    GMTrace.i(18757867012096L, 139757);
    this.iWM.onTouchEvent(paramMotionEvent);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    GMTrace.o(18757867012096L, 139757);
    return bool;
  }
  
  public void requestLayout()
  {
    GMTrace.i(18758001229824L, 139758);
    if (this.mContext != null) {
      caH().requestLayout();
    }
    super.requestLayout();
    GMTrace.o(18758001229824L, 139758);
  }
  
  public final void setMaxWidth(int paramInt)
  {
    GMTrace.i(19012343824384L, 141653);
    this.wwb.setMaxWidth(paramInt);
    caH().setMaxWidth(paramInt);
    GMTrace.o(19012343824384L, 141653);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(18757732794368L, 139756);
    super.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mContext != null)
    {
      caH().setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
      this.wwb.setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }
    GMTrace.o(18757732794368L, 139756);
  }
  
  public final void setTextSize(float paramFloat)
  {
    GMTrace.i(19012209606656L, 141652);
    int i = (int)(paramFloat / this.mContext.getResources().getDisplayMetrics().density + 0.5F);
    caH().setTextSize(paramFloat);
    this.wwb.setTextSize(1, i);
    requestLayout();
    invalidate();
    GMTrace.o(19012209606656L, 141652);
  }
  
  private final class a
    extends GestureDetector.SimpleOnGestureListener
  {
    private a()
    {
      GMTrace.i(18760685584384L, 139778);
      GMTrace.o(18760685584384L, 139778);
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      GMTrace.i(18760819802112L, 139779);
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if (CellTextView.b(CellTextView.this) != null) {
        CellTextView.b(CellTextView.this).dq(CellTextView.this);
      }
      v.i("CellTextView", "Double Tap (%s:%s)", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
      GMTrace.o(18760819802112L, 139779);
      return true;
    }
  }
  
  public static abstract interface b
  {
    public abstract void Q(CharSequence paramCharSequence);
  }
  
  public static abstract interface c
  {
    public abstract boolean dq(View paramView);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/celltextview/CellTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */