package com.tencent.mm.ui.widget;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.gmtrace.GMTrace;

public final class a
  extends i
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  private int iE;
  private int iXc;
  private int iXd;
  private int kQQ;
  private GestureDetector wW;
  public DragSortListView wqA;
  public int wqB;
  private GestureDetector.OnGestureListener wqC;
  private int wqj;
  boolean wqk;
  public boolean wql;
  public boolean wqm;
  private GestureDetector wqn;
  private int wqo;
  private int wqp;
  private int wqq;
  private int[] wqr;
  private int wqs;
  private int wqt;
  private boolean wqu;
  public float wqv;
  private int wqw;
  private int wqx;
  private int wqy;
  private boolean wqz;
  
  public a(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramDragSortListView);
    GMTrace.i(13048781733888L, 97221);
    this.wqj = 0;
    this.wqk = true;
    this.wql = false;
    this.wqm = false;
    this.wqo = -1;
    this.wqp = -1;
    this.wqq = -1;
    this.wqr = new int[2];
    this.wqu = false;
    this.wqv = 500.0F;
    this.wqC = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        GMTrace.i(13048379080704L, 97218);
        int i;
        if ((a.this.wql) && (a.this.wqm))
        {
          i = a.this.wqA.getWidth() / 5;
          if (paramAnonymousFloat1 <= a.this.wqv) {
            break label97;
          }
          if (a.this.wqB > -i) {
            a.this.wqA.au(paramAnonymousFloat1);
          }
        }
        for (;;)
        {
          a.this.wqm = false;
          GMTrace.o(13048379080704L, 97218);
          return false;
          label97:
          if ((paramAnonymousFloat1 < -a.this.wqv) && (a.this.wqB < i)) {
            a.this.wqA.au(paramAnonymousFloat1);
          }
        }
      }
    };
    this.wqA = paramDragSortListView;
    this.wW = new GestureDetector(paramDragSortListView.getContext(), this);
    this.wqn = new GestureDetector(paramDragSortListView.getContext(), this.wqC);
    this.wqn.setIsLongpressEnabled(false);
    this.iE = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
    this.wqw = paramInt1;
    this.wqx = paramInt4;
    this.wqy = paramInt5;
    this.kQQ = paramInt3;
    this.wqj = paramInt2;
    GMTrace.o(13048781733888L, 97221);
  }
  
  private boolean Y(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    GMTrace.i(13048915951616L, 97222);
    if ((this.wqk) && (!this.wqm)) {}
    for (int i = 12;; i = 0)
    {
      if ((this.wql) && (this.wqm)) {
        i = i | 0x1 | 0x2;
      }
      for (;;)
      {
        DragSortListView localDragSortListView = this.wqA;
        paramInt1 -= this.wqA.getHeaderViewsCount();
        boolean bool1 = bool2;
        if (localDragSortListView.wrt)
        {
          if (localDragSortListView.wru != null) {
            break label114;
          }
          bool1 = bool2;
        }
        for (;;)
        {
          this.wqu = bool1;
          bool1 = this.wqu;
          GMTrace.o(13048915951616L, 97222);
          return bool1;
          label114:
          View localView = localDragSortListView.wru.Ck(paramInt1);
          bool1 = bool2;
          if (localView != null) {
            bool1 = localDragSortListView.a(paramInt1, localView, i, paramInt2, paramInt3);
          }
        }
      }
    }
  }
  
  private int k(MotionEvent paramMotionEvent, int paramInt)
  {
    GMTrace.i(13049318604800L, 97225);
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    i = this.wqA.pointToPosition(i, j);
    j = this.wqA.getHeaderViewsCount();
    int k = this.wqA.getFooterViewsCount();
    int m = this.wqA.getCount();
    if ((i != -1) && (i >= j) && (i < m - k))
    {
      View localView = this.wqA.getChildAt(i - this.wqA.getFirstVisiblePosition());
      k = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
      if (paramInt == 0) {}
      for (paramMotionEvent = localView; paramMotionEvent != null; paramMotionEvent = localView.findViewById(paramInt))
      {
        paramMotionEvent.getLocationOnScreen(this.wqr);
        if ((k <= this.wqr[0]) || (j <= this.wqr[1]) || (k >= this.wqr[0] + paramMotionEvent.getWidth())) {
          break;
        }
        paramInt = this.wqr[1];
        if (j >= paramMotionEvent.getHeight() + paramInt) {
          break;
        }
        this.wqs = localView.getLeft();
        this.wqt = localView.getTop();
        GMTrace.o(13049318604800L, 97225);
        return i;
      }
    }
    GMTrace.o(13049318604800L, 97225);
    return -1;
  }
  
  public final void d(Point paramPoint)
  {
    GMTrace.i(13049184387072L, 97224);
    if ((this.wql) && (this.wqm)) {
      this.wqB = paramPoint.x;
    }
    GMTrace.o(13049184387072L, 97224);
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    int i = -1;
    GMTrace.i(13049452822528L, 97226);
    if ((this.wql) && (this.kQQ == 0)) {
      this.wqq = k(paramMotionEvent, this.wqx);
    }
    this.wqo = k(paramMotionEvent, this.wqw);
    if ((this.wqo != -1) && (this.wqj == 0)) {
      Y(this.wqo, (int)paramMotionEvent.getX() - this.wqs, (int)paramMotionEvent.getY() - this.wqt);
    }
    this.wqm = false;
    this.wqz = true;
    this.wqB = 0;
    if (this.kQQ == 1) {
      i = k(paramMotionEvent, this.wqy);
    }
    this.wqp = i;
    GMTrace.o(13049452822528L, 97226);
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    GMTrace.i(13049855475712L, 97229);
    GMTrace.o(13049855475712L, 97229);
    return false;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    GMTrace.i(13049721257984L, 97228);
    if ((this.wqo != -1) && (this.wqj == 2))
    {
      this.wqA.performHapticFeedback(0);
      Y(this.wqo, this.iXc - this.wqs, this.iXd - this.wqt);
    }
    GMTrace.o(13049721257984L, 97228);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    GMTrace.i(13049587040256L, 97227);
    int i = (int)paramMotionEvent1.getX();
    int j = (int)paramMotionEvent1.getY();
    int k = (int)paramMotionEvent2.getX();
    int m = (int)paramMotionEvent2.getY();
    int n = k - this.wqs;
    int i1 = m - this.wqt;
    if ((this.wqz) && (!this.wqu) && ((this.wqo != -1) || (this.wqp != -1)))
    {
      if (this.wqo == -1) {
        break label197;
      }
      if ((this.wqj != 1) || (Math.abs(m - j) <= this.iE) || (!this.wqk)) {
        break label147;
      }
      Y(this.wqo, n, i1);
    }
    for (;;)
    {
      GMTrace.o(13049587040256L, 97227);
      return false;
      label147:
      if ((this.wqj != 0) && (Math.abs(k - i) > this.iE) && (this.wql))
      {
        this.wqm = true;
        Y(this.wqp, n, i1);
        continue;
        label197:
        if (this.wqp != -1) {
          if ((Math.abs(k - i) > this.iE) && (this.wql))
          {
            this.wqm = true;
            Y(this.wqp, n, i1);
          }
          else if (Math.abs(m - j) > this.iE)
          {
            this.wqz = false;
          }
        }
      }
    }
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent)
  {
    GMTrace.i(13050123911168L, 97231);
    GMTrace.o(13050123911168L, 97231);
  }
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    GMTrace.i(13049989693440L, 97230);
    if ((this.wql) && (this.kQQ == 0) && (this.wqq != -1))
    {
      paramMotionEvent = this.wqA;
      int i = this.wqq;
      int j = this.wqA.getHeaderViewsCount();
      paramMotionEvent.wrI = false;
      paramMotionEvent.l(i - j, 0.0F);
    }
    GMTrace.o(13049989693440L, 97230);
    return true;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    GMTrace.i(13049050169344L, 97223);
    if ((!this.wqA.wqX) || (this.wqA.wrK))
    {
      GMTrace.o(13049050169344L, 97223);
      return false;
    }
    this.wW.onTouchEvent(paramMotionEvent);
    if ((this.wql) && (this.wqu) && (this.kQQ == 1)) {
      this.wqn.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
    case 0: 
      for (;;)
      {
        GMTrace.o(13049050169344L, 97223);
        return false;
        this.iXc = ((int)paramMotionEvent.getX());
        this.iXd = ((int)paramMotionEvent.getY());
      }
    case 1: 
      if ((this.wql) && (this.wqm)) {
        if (this.wqB < 0) {
          break label213;
        }
      }
      break;
    }
    label213:
    for (int i = this.wqB;; i = -this.wqB)
    {
      if (i > this.wqA.getWidth() / 2) {
        this.wqA.au(0.0F);
      }
      this.wqm = false;
      this.wqu = false;
      break;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */