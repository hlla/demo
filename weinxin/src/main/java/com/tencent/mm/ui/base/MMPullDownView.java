package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.k;

public class MMPullDownView
  extends FrameLayout
  implements GestureDetector.OnGestureListener
{
  private static int vjX;
  private static final int vka;
  public int bgColor;
  public Context context;
  private GestureDetector nkc;
  private int vfQ;
  private int vhp;
  public int vjA;
  private int vjB;
  private boolean vjC;
  private boolean vjD;
  private boolean vjE;
  private boolean vjF;
  public boolean vjG;
  private boolean vjH;
  private boolean vjI;
  private boolean vjJ;
  public c vjK;
  public d vjL;
  private View vjM;
  private View vjN;
  private int vjO;
  private int vjP;
  private int vjQ;
  private boolean vjR;
  public f vjS;
  public boolean vjT;
  public k vjU;
  public boolean vjV;
  public a vjW;
  private ad vjY;
  boolean vjZ;
  public g vjy;
  public e vjz;
  public boolean vkb;
  private int vkc;
  public int vkd;
  public b vke;
  private Scroller yw;
  
  static
  {
    GMTrace.i(3298400665600L, 24575);
    vjX = 400;
    vka = Color.parseColor("#00000000");
    GMTrace.o(3298400665600L, 24575);
  }
  
  public MMPullDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(3294642569216L, 24547);
    GMTrace.o(3294642569216L, 24547);
  }
  
  public MMPullDownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(3294776786944L, 24548);
    this.vhp = 1;
    this.vjC = false;
    this.vjD = false;
    this.vjE = false;
    this.vjF = false;
    this.vjG = true;
    this.vjH = false;
    this.vjI = true;
    this.vjJ = true;
    this.vjP = 4;
    this.vjQ = 4;
    this.vjR = false;
    this.vjT = true;
    this.vjV = false;
    this.vjY = new ad()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        GMTrace.i(3300145496064L, 24588);
        super.handleMessage(paramAnonymousMessage);
        switch (MMPullDownView.a(MMPullDownView.this))
        {
        }
        for (;;)
        {
          v.i("MicroMsg.MMPullDownView", "updateDelayHandler handleMessage loadDataType[%d] loadDataEnd[%b]", new Object[] { Integer.valueOf(MMPullDownView.a(MMPullDownView.this)), Boolean.valueOf(MMPullDownView.this.vjG) });
          GMTrace.o(3300145496064L, 24588);
          return;
          if (MMPullDownView.b(MMPullDownView.this) != null) {
            MMPullDownView.this.vjG = MMPullDownView.b(MMPullDownView.this).akj();
          }
          if ((MMPullDownView.this.vjG) && (MMPullDownView.c(MMPullDownView.this).getVisibility() == 0))
          {
            MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
            continue;
            if (MMPullDownView.e(MMPullDownView.this) != null) {
              MMPullDownView.this.vjG = MMPullDownView.e(MMPullDownView.this).akg();
            }
            if ((MMPullDownView.this.vjG) && (MMPullDownView.f(MMPullDownView.this).getVisibility() == 0)) {
              MMPullDownView.this.scrollTo(0, MMPullDownView.d(MMPullDownView.this));
            }
          }
        }
      }
    };
    this.vjZ = false;
    this.vkb = false;
    this.bgColor = Color.parseColor("#ffffffff");
    this.vkc = Integer.MIN_VALUE;
    this.vkd = this.bgColor;
    this.yw = new Scroller(paramContext, new AccelerateInterpolator());
    this.vfQ = this.vhp;
    this.nkc = new GestureDetector(paramContext, this);
    this.vjU = new k(paramContext);
    this.context = paramContext;
    GMTrace.o(3294776786944L, 24548);
  }
  
  private void bSb()
  {
    GMTrace.i(3296521617408L, 24561);
    if (this.vjS != null) {
      this.vjS.biC();
    }
    Scroller localScroller;
    int i;
    int j;
    if (getScrollY() - this.vjA < 0)
    {
      if (this.vjI)
      {
        localScroller = this.yw;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.vjA + j, 200);
        postInvalidate();
      }
    }
    else if (getScrollY() > this.vjB)
    {
      if (!this.vjJ) {
        break label238;
      }
      this.yw.startScroll(0, getScrollY(), 0, this.vjB - getScrollY(), 200);
    }
    for (;;)
    {
      postInvalidate();
      this.vjE = false;
      GMTrace.o(3296521617408L, 24561);
      return;
      if (this.vjM.getVisibility() == 4)
      {
        localScroller = this.yw;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.vjA + j, 200);
      }
      if (this.vjM.getVisibility() == 0) {
        this.yw.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
      }
      this.vjO = 0;
      this.vjF = true;
      this.vjG = false;
      break;
      label238:
      if (this.vjN.getVisibility() == 4) {
        this.yw.startScroll(0, getScrollY(), 0, this.vjB - getScrollY(), 200);
      }
      if (this.vjN.getVisibility() == 0)
      {
        localScroller = this.yw;
        i = getScrollY();
        j = this.vjB;
        int k = getScrollY();
        localScroller.startScroll(0, i, 0, this.vjB + (j - k), 200);
      }
      this.vjO = 1;
      this.vjF = true;
      this.vjG = false;
    }
  }
  
  public void akz()
  {
    GMTrace.i(3294911004672L, 24549);
    View localView1 = inflate(this.context, a.h.cbN, null);
    View localView2 = inflate(this.context, a.h.cbN, null);
    addView(localView1, 0, new FrameLayout.LayoutParams(-1, -2));
    addView(localView2, new FrameLayout.LayoutParams(-1, -2));
    GMTrace.o(3294911004672L, 24549);
  }
  
  public void computeScroll()
  {
    GMTrace.i(3295716311040L, 24555);
    if (this.yw.computeScrollOffset())
    {
      scrollTo(this.yw.getCurrX(), this.yw.getCurrY());
      postInvalidate();
    }
    for (;;)
    {
      this.yw.isFinished();
      GMTrace.o(3295716311040L, 24555);
      return;
      if (this.vjF)
      {
        v.i("MicroMsg.MMPullDownView", "computeScroll loadDataBegin true UPDATE_DELAY");
        this.vjF = false;
        this.vjY.sendEmptyMessageDelayed(0, vjX);
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    GMTrace.i(3296118964224L, 24558);
    k localk = this.vjU;
    if (localk.wkE != null) {
      localk.wkD.onTouchEvent(paramMotionEvent);
    }
    if (!this.vjG)
    {
      GMTrace.o(3296118964224L, 24558);
      return true;
    }
    if (this.vjL == null)
    {
      this.vjC = false;
      if (this.vjK != null) {
        break label161;
      }
      this.vjD = false;
      label72:
      if (this.vjQ == 0)
      {
        if (!this.vjI) {
          break label177;
        }
        this.vjM.setVisibility(4);
      }
      label94:
      if (this.vjP == 0)
      {
        if (!this.vjJ) {
          break label188;
        }
        this.vjN.setVisibility(4);
      }
    }
    boolean bool;
    for (;;)
    {
      if (paramMotionEvent.getAction() != 1) {
        break label199;
      }
      bSb();
      bool = super.dispatchTouchEvent(paramMotionEvent);
      GMTrace.o(3296118964224L, 24558);
      return bool;
      this.vjC = this.vjL.akh();
      break;
      label161:
      this.vjD = this.vjK.aki();
      break label72;
      label177:
      this.vjM.setVisibility(0);
      break label94;
      label188:
      this.vjN.setVisibility(0);
    }
    label199:
    if (paramMotionEvent.getAction() == 3)
    {
      bSb();
      if (this.vjV)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        GMTrace.o(3296118964224L, 24558);
        return bool;
      }
      GMTrace.o(3296118964224L, 24558);
      return false;
    }
    if (this.nkc.onTouchEvent(paramMotionEvent))
    {
      paramMotionEvent.setAction(3);
      this.vjZ = true;
      bool = super.dispatchTouchEvent(paramMotionEvent);
      GMTrace.o(3296118964224L, 24558);
      return bool;
    }
    try
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      GMTrace.o(3296118964224L, 24558);
      return bool;
    }
    catch (Exception paramMotionEvent)
    {
      v.printErrStackTrace("MicroMsg.MMPullDownView", paramMotionEvent, "", new Object[0]);
      GMTrace.o(3296118964224L, 24558);
    }
    return true;
  }
  
  public final void kL(boolean paramBoolean)
  {
    GMTrace.i(3295045222400L, 24550);
    v.i("MicroMsg.MMPullDownView", "setIsTopShowAll showAll[%b], isTopShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.vjI), bf.bJP() });
    this.vjI = paramBoolean;
    GMTrace.o(3295045222400L, 24550);
  }
  
  public final void kM(boolean paramBoolean)
  {
    GMTrace.i(3295179440128L, 24551);
    v.i("MicroMsg.MMPullDownView", "setIsBottomShowAll showAll[%b], isBottomShowAll[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.vjJ), bf.bJP() });
    this.vjJ = paramBoolean;
    GMTrace.o(3295179440128L, 24551);
  }
  
  public final void kN(boolean paramBoolean)
  {
    GMTrace.i(3295313657856L, 24552);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.vjP = i;
      if (this.vjN != null) {
        this.vjN.setVisibility(this.vjP);
      }
      v.i("MicroMsg.MMPullDownView", "setBottomViewVisible visible[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bf.bJP() });
      GMTrace.o(3295313657856L, 24552);
      return;
    }
  }
  
  public final void kO(boolean paramBoolean)
  {
    GMTrace.i(3295447875584L, 24553);
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      this.vjQ = i;
      if (this.vjM != null) {
        this.vjM.setVisibility(this.vjQ);
      }
      v.i("MicroMsg.MMPullDownView", "setTopViewVisible visible[%b], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bf.bJP() });
      GMTrace.o(3295447875584L, 24553);
      return;
    }
  }
  
  public final void kP(boolean paramBoolean)
  {
    GMTrace.i(3296253181952L, 24559);
    v.i("MicroMsg.MMPullDownView", "forceTopLoadData start[%b] loadDataBegin[%b], loadDataEnd[%b], isTopShowAll[%b], getScrollY[%d], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.vjF), Boolean.valueOf(this.vjG), Boolean.valueOf(this.vjI), Integer.valueOf(getScrollY()), bf.bJP() });
    if (paramBoolean)
    {
      Scroller localScroller;
      int i;
      int j;
      if (this.vjI)
      {
        localScroller = this.yw;
        i = getScrollY();
        j = -getScrollY();
        localScroller.startScroll(0, i, 0, this.vjA + j, 200);
      }
      for (;;)
      {
        postInvalidate();
        GMTrace.o(3296253181952L, 24559);
        return;
        if ((this.vjM != null) && (this.vjM.getVisibility() == 4))
        {
          localScroller = this.yw;
          i = getScrollY();
          j = -getScrollY();
          localScroller.startScroll(0, i, 0, this.vjA + j, 200);
        }
        if ((this.vjM != null) && (this.vjM.getVisibility() == 0)) {
          this.yw.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
        }
        this.vjO = 0;
        this.vjF = true;
        this.vjG = false;
      }
    }
    if (!this.vjG)
    {
      this.vjG = true;
      this.vjF = false;
      if ((this.vjM != null) && (this.vjM.getVisibility() == 0)) {
        scrollTo(0, this.vjA);
      }
    }
    GMTrace.o(3296253181952L, 24559);
  }
  
  public final void kQ(boolean paramBoolean)
  {
    GMTrace.i(3296387399680L, 24560);
    v.i("MicroMsg.MMPullDownView", "forceBottomLoadData start[%b] loadDataBegin[%b] loadDataEnd[%b], isBottomShowAll[%b], getScrollY[%d], stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.vjF), Boolean.valueOf(this.vjG), Boolean.valueOf(this.vjJ), Integer.valueOf(getScrollY()), bf.bJP() });
    if (paramBoolean)
    {
      if (this.vjJ) {
        this.yw.startScroll(0, getScrollY(), 0, this.vjB - getScrollY(), 200);
      }
      for (;;)
      {
        postInvalidate();
        GMTrace.o(3296387399680L, 24560);
        return;
        if ((this.vjN != null) && (this.vjN.getVisibility() == 4)) {
          this.yw.startScroll(0, getScrollY(), 0, this.vjB - getScrollY(), 200);
        }
        if ((this.vjN != null) && (this.vjN.getVisibility() == 0))
        {
          Scroller localScroller = this.yw;
          int i = getScrollY();
          int j = this.vjB;
          int k = getScrollY();
          localScroller.startScroll(0, i, 0, this.vjB + (j - k), 200);
        }
        this.vjO = 1;
        this.vjF = true;
        this.vjG = false;
      }
    }
    if (!this.vjG)
    {
      this.vjG = true;
      this.vjF = false;
    }
    if ((this.vjN != null) && (this.vjN.getVisibility() == 0))
    {
      v.i("MicroMsg.MMPullDownView", "forceBottomLoadData false bottomView VISIBLE scroll to 0");
      scrollTo(0, this.vjA);
    }
    GMTrace.o(3296387399680L, 24560);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    GMTrace.i(3296655835136L, 24562);
    if (!this.yw.isFinished()) {
      this.yw.abortAnimation();
    }
    GMTrace.o(3296655835136L, 24562);
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    GMTrace.i(3296790052864L, 24563);
    v.v("MicroMsg.MMPullDownView", "on fling, velocityX %f velocityY %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    GMTrace.o(3296790052864L, 24563);
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    GMTrace.i(3295850528768L, 24556);
    if (this.vjW != null) {
      this.vjW.aqu();
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    GMTrace.o(3295850528768L, 24556);
    return bool;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(3295582093312L, 24554);
    v.d("MicroMsg.MMPullDownView", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (!this.vjR)
    {
      akz();
      this.vjR = true;
    }
    paramInt4 = getChildCount();
    paramInt1 = 0;
    paramInt2 = 0;
    for (;;)
    {
      if (paramInt1 < paramInt4)
      {
        View localView = getChildAt(paramInt1);
        int i = localView.getMeasuredHeight();
        paramInt3 = paramInt2;
        if (localView.getVisibility() != 8) {}
        try
        {
          localView.layout(0, paramInt2, localView.getMeasuredWidth(), paramInt2 + i);
          paramInt3 = paramInt2 + i;
          paramInt1 += 1;
          paramInt2 = paramInt3;
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          for (;;)
          {
            v.printErrStackTrace("MicroMsg.MMPullDownView", localArrayIndexOutOfBoundsException, "childCount: %d, i:%d, childHeight:%d", new Object[] { Integer.valueOf(paramInt4), Integer.valueOf(paramInt1), Integer.valueOf(i) });
          }
        }
      }
    }
    this.vjM = getChildAt(0);
    this.vjN = getChildAt(getChildCount() - 1);
    this.vjM.setVisibility(this.vjQ);
    this.vjN.setVisibility(this.vjP);
    this.vjA = this.vjM.getHeight();
    this.vjB = this.vjN.getHeight();
    this.vkc = this.vjA;
    if ((!this.vjH) && (this.vjA != 0))
    {
      this.vjH = true;
      scrollTo(0, this.vjA);
    }
    GMTrace.o(3295582093312L, 24554);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    GMTrace.i(3296924270592L, 24564);
    GMTrace.o(3296924270592L, 24564);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    GMTrace.i(3297058488320L, 24565);
    if (this.vjS != null) {
      this.vjS.an(paramFloat2);
    }
    if (paramFloat2 > 0.0F) {
      this.vjE = true;
    }
    int j;
    int i;
    while ((this.vjD) && ((this.vjE) || (getScrollY() - this.vjA > 0))) {
      if ((!this.vjT) && ((this.vjN.getVisibility() != 0) || ((this.vjE) && (getScrollY() >= this.vjA * 2))))
      {
        GMTrace.o(3297058488320L, 24565);
        return true;
        this.vjE = false;
      }
      else
      {
        j = (int)(paramFloat2 * 0.5D);
        i = j;
        if (j == 0)
        {
          if (paramFloat2 > 0.0F) {
            i = 1;
          }
        }
        else
        {
          v.v("check", "moveUp:" + i + " distanceY:" + paramFloat2 + " scrollY:" + getScrollY());
          if ((getScrollY() + i >= this.vjA) || (this.vjE)) {
            break label254;
          }
          j = this.vjA - getScrollY();
        }
        for (;;)
        {
          scrollBy(0, j);
          GMTrace.o(3297058488320L, 24565);
          return true;
          i = -1;
          break;
          label254:
          j = i;
          if (!this.vjT)
          {
            j = i;
            if (getScrollY() + i >= this.vjA * 2) {
              j = this.vjA * 2 - getScrollY();
            }
          }
        }
      }
    }
    if ((this.vjC) && ((!this.vjE) || (getScrollY() - this.vjA < 0)))
    {
      if ((!this.vjT) && ((this.vjM.getVisibility() != 0) || ((!this.vjE) && (getScrollY() <= 0))))
      {
        GMTrace.o(3297058488320L, 24565);
        return true;
      }
      j = (int)(paramFloat2 * 0.5D);
      i = j;
      if (j == 0)
      {
        if (paramFloat2 > 0.0F) {
          i = 1;
        }
      }
      else
      {
        if (getScrollY() + i <= this.vjA) {
          break label447;
        }
        j = this.vjA - getScrollY();
      }
      for (;;)
      {
        scrollBy(0, j);
        GMTrace.o(3297058488320L, 24565);
        return true;
        i = -1;
        break;
        label447:
        j = i;
        if (!this.vjT)
        {
          j = i;
          if (getScrollY() + i < 0) {
            j = -getScrollY();
          }
        }
      }
    }
    GMTrace.o(3297058488320L, 24565);
    return false;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    GMTrace.i(3297461141504L, 24568);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.vke != null) {
      this.vke.aql();
    }
    if (!this.vkb)
    {
      GMTrace.o(3297461141504L, 24568);
      return;
    }
    if (this.vkc == Integer.MIN_VALUE)
    {
      this.vkc = this.vjA;
      v.d("MicroMsg.MMPullDownView", "onScrollChanged static y:" + this.vkc);
    }
    if ((paramInt2 <= this.vkc) && (this.vkd != vka))
    {
      setBackgroundResource(a.f.bhb);
      this.vkd = vka;
      v.d("MicroMsg.MMPullDownView", "onScrollChanged full");
      GMTrace.o(3297461141504L, 24568);
      return;
    }
    if ((paramInt2 > this.vkc) && (this.vkd != this.bgColor))
    {
      v.d("MicroMsg.MMPullDownView", "onScrollChanged white");
      setBackgroundColor(this.bgColor);
      this.vkd = this.bgColor;
    }
    GMTrace.o(3297461141504L, 24568);
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    GMTrace.i(3297192706048L, 24566);
    GMTrace.o(3297192706048L, 24566);
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    GMTrace.i(3297326923776L, 24567);
    GMTrace.o(3297326923776L, 24567);
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    GMTrace.i(3295984746496L, 24557);
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      GMTrace.o(3295984746496L, 24557);
      return true;
      if (getScrollY() - this.vjA < 0) {
        this.vjC = true;
      }
      if (getScrollY() > this.vjB) {
        this.vjD = true;
      }
      bSb();
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean aqu();
  }
  
  public static abstract interface b
  {
    public abstract void aql();
  }
  
  public static abstract interface c
  {
    public abstract boolean aki();
  }
  
  public static abstract interface d
  {
    public abstract boolean akh();
  }
  
  public static abstract interface e
  {
    public abstract boolean akg();
  }
  
  public static abstract interface f
  {
    public abstract void an(float paramFloat);
    
    public abstract void biC();
  }
  
  public static abstract interface g
  {
    public abstract boolean akj();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/MMPullDownView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */