package com.tencent.mm.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.tencent.gmtrace.GMTrace;
import java.util.LinkedList;
import java.util.Queue;

public class HorizontalListView
  extends AdapterView<ListAdapter>
{
  protected ListAdapter FA;
  public a sPe;
  public boolean vfb;
  private int vfc;
  private int vfd;
  protected int vfe;
  protected int vff;
  private int vfg;
  private int vfh;
  private GestureDetector vfi;
  private Queue<View> vfj;
  private AdapterView.OnItemSelectedListener vfk;
  private AdapterView.OnItemClickListener vfl;
  private boolean vfm;
  private DataSetObserver vfn;
  private GestureDetector.OnGestureListener vfo;
  protected Scroller yw;
  
  public HorizontalListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(3173175525376L, 23642);
    this.vfb = true;
    this.vfc = -1;
    this.vfd = 0;
    this.vfg = Integer.MAX_VALUE;
    this.vfh = 0;
    this.vfj = new LinkedList();
    this.vfm = false;
    this.vfn = new DataSetObserver()
    {
      public final void onChanged()
      {
        GMTrace.i(3342021427200L, 24900);
        synchronized (HorizontalListView.this)
        {
          HorizontalListView.a(HorizontalListView.this);
          HorizontalListView.this.invalidate();
          HorizontalListView.this.requestLayout();
          GMTrace.o(3342021427200L, 24900);
          return;
        }
      }
      
      public final void onInvalidated()
      {
        GMTrace.i(3342155644928L, 24901);
        HorizontalListView.b(HorizontalListView.this);
        HorizontalListView.this.invalidate();
        HorizontalListView.this.requestLayout();
        GMTrace.o(3342155644928L, 24901);
      }
    };
    this.vfo = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(3353698369536L, 24987);
        boolean bool = HorizontalListView.this.bRt();
        GMTrace.o(3353698369536L, 24987);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        GMTrace.i(3353832587264L, 24988);
        boolean bool = HorizontalListView.this.as(paramAnonymousFloat1);
        GMTrace.o(3353832587264L, 24988);
        return bool;
      }
      
      public final boolean onScroll(MotionEvent arg1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        GMTrace.i(3353966804992L, 24989);
        synchronized (HorizontalListView.this)
        {
          paramAnonymousMotionEvent2 = HorizontalListView.this;
          paramAnonymousMotionEvent2.vff += (int)paramAnonymousFloat1;
          HorizontalListView.this.requestLayout();
          GMTrace.o(3353966804992L, 24989);
          return true;
        }
      }
      
      public final boolean onSingleTapConfirmed(MotionEvent paramAnonymousMotionEvent)
      {
        GMTrace.i(3354101022720L, 24990);
        Rect localRect = new Rect();
        int i = 0;
        for (;;)
        {
          if (i < HorizontalListView.this.getChildCount())
          {
            View localView = HorizontalListView.this.getChildAt(i);
            int j = localView.getLeft();
            int k = localView.getRight();
            localRect.set(j, localView.getTop(), k, localView.getBottom());
            if (!localRect.contains((int)paramAnonymousMotionEvent.getX(), (int)paramAnonymousMotionEvent.getY())) {
              break label225;
            }
            if (HorizontalListView.c(HorizontalListView.this) != null) {
              HorizontalListView.c(HorizontalListView.this).onItemClick(HorizontalListView.this, localView, HorizontalListView.d(HorizontalListView.this) + 1 + i, HorizontalListView.this.FA.getItemId(HorizontalListView.d(HorizontalListView.this) + 1 + i));
            }
            if (HorizontalListView.e(HorizontalListView.this) != null) {
              HorizontalListView.e(HorizontalListView.this).onItemSelected(HorizontalListView.this, localView, HorizontalListView.d(HorizontalListView.this) + 1 + i, HorizontalListView.this.FA.getItemId(HorizontalListView.d(HorizontalListView.this) + 1 + i));
            }
          }
          GMTrace.o(3354101022720L, 24990);
          return true;
          label225:
          i += 1;
        }
      }
    };
    KD();
    GMTrace.o(3173175525376L, 23642);
  }
  
  private void G(View paramView, int paramInt)
  {
    GMTrace.i(3174249267200L, 23650);
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new ViewGroup.LayoutParams(-1, -1);
    }
    addViewInLayout(paramView, paramInt, localLayoutParams1, true);
    paramView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    GMTrace.o(3174249267200L, 23650);
  }
  
  private void KD()
  {
    try
    {
      GMTrace.i(3173309743104L, 23643);
      this.vfc = -1;
      this.vfd = 0;
      this.vfh = 0;
      this.vfe = 0;
      this.vff = 0;
      this.vfg = Integer.MAX_VALUE;
      this.yw = new Scroller(getContext());
      this.vfi = new GestureDetector(getContext(), this.vfo);
      GMTrace.o(3173309743104L, 23643);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void reset()
  {
    try
    {
      GMTrace.i(3173980831744L, 23648);
      KD();
      removeAllViewsInLayout();
      requestLayout();
      GMTrace.o(3173980831744L, 23648);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected final boolean as(float paramFloat)
  {
    GMTrace.i(3174651920384L, 23653);
    try
    {
      this.yw.fling(this.vff, 0, (int)-paramFloat, 0, 0, this.vfg, 0, 0);
      requestLayout();
      GMTrace.o(3174651920384L, 23653);
      return true;
    }
    finally {}
  }
  
  protected final boolean bRt()
  {
    GMTrace.i(3174786138112L, 23654);
    this.yw.forceFinished(true);
    GMTrace.o(3174786138112L, 23654);
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    GMTrace.i(3174517702656L, 23652);
    if (this.sPe != null) {
      this.sPe.E(paramMotionEvent);
    }
    boolean bool1 = super.dispatchTouchEvent(paramMotionEvent);
    boolean bool2 = this.vfi.onTouchEvent(paramMotionEvent);
    GMTrace.o(3174517702656L, 23652);
    return bool1 | bool2;
  }
  
  public View getSelectedView()
  {
    GMTrace.i(3173712396288L, 23646);
    GMTrace.o(3173712396288L, 23646);
    return null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    try
    {
      GMTrace.i(3174383484928L, 23651);
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.FA == null)
      {
        GMTrace.o(3174383484928L, 23651);
        return;
      }
      if (this.vfm)
      {
        paramInt1 = this.vfe;
        KD();
        removeAllViewsInLayout();
        this.vff = paramInt1;
        this.vfm = false;
      }
      if (this.yw.computeScrollOffset()) {
        this.vff = this.yw.getCurrX();
      }
      if (this.vff <= 0)
      {
        this.vff = 0;
        this.yw.forceFinished(true);
      }
      if (this.vff >= this.vfg)
      {
        this.vff = this.vfg;
        this.yw.forceFinished(true);
      }
      paramInt2 = this.vfe - this.vff;
      for (View localView1 = getChildAt(0); (localView1 != null) && (localView1.getRight() + paramInt2 <= 0); localView1 = getChildAt(0))
      {
        this.vfh += localView1.getMeasuredWidth();
        this.vfj.offer(localView1);
        removeViewInLayout(localView1);
        this.vfc += 1;
      }
      for (;;)
      {
        localView1 = getChildAt(getChildCount() - 1);
        if ((localView1 == null) || (localView1.getLeft() + paramInt2 < getWidth())) {
          break;
        }
        this.vfj.offer(localView1);
        removeViewInLayout(localView1);
        this.vfd -= 1;
      }
      localView2 = getChildAt(getChildCount() - 1);
    }
    finally {}
    View localView2;
    if (localView2 != null)
    {
      paramInt1 = localView2.getRight();
      break label681;
      label321:
      while ((paramInt1 + paramInt2 < getWidth()) && (this.vfd < this.FA.getCount()))
      {
        localView2 = this.FA.getView(this.vfd, (View)this.vfj.poll(), this);
        G(localView2, -1);
        paramInt1 = localView2.getMeasuredWidth() + paramInt1;
        if (this.vfd == this.FA.getCount() - 1) {
          this.vfg = (this.vfe + paramInt1 - getWidth());
        }
        if (this.vfg < 0) {
          this.vfg = 0;
        }
        this.vfd += 1;
      }
      localView2 = getChildAt(0);
      if (localView2 != null)
      {
        paramInt1 = localView2.getLeft();
        break label684;
      }
    }
    label681:
    label684:
    for (;;)
    {
      if ((paramInt1 + paramInt2 > 0) && (this.vfc >= 0))
      {
        localView2 = this.FA.getView(this.vfc, (View)this.vfj.poll(), this);
        G(localView2, 0);
        paramInt3 = localView2.getMeasuredWidth();
        this.vfc -= 1;
        this.vfh -= localView2.getMeasuredWidth();
        paramInt1 -= paramInt3;
      }
      else
      {
        if (getChildCount() > 0)
        {
          this.vfh += paramInt2;
          paramInt2 = this.vfh;
          paramInt1 = i;
          while (paramInt1 < getChildCount())
          {
            localView2 = getChildAt(paramInt1);
            paramInt3 = localView2.getMeasuredWidth();
            localView2.layout(paramInt2, 0, paramInt2 + paramInt3, localView2.getMeasuredHeight());
            paramInt2 += paramInt3;
            paramInt1 += 1;
          }
        }
        this.vfe = this.vff;
        if (!this.yw.isFinished()) {
          post(new Runnable()
          {
            public final void run()
            {
              GMTrace.i(3314775228416L, 24697);
              HorizontalListView.this.requestLayout();
              GMTrace.o(3314775228416L, 24697);
            }
          });
        }
        GMTrace.o(3174383484928L, 23651);
        break;
        paramInt1 = 0;
        break label684;
        paramInt1 = 0;
        break label321;
      }
    }
  }
  
  public final void setAdapter(ListAdapter paramListAdapter)
  {
    GMTrace.i(3173846614016L, 23647);
    if (this.FA != null) {
      this.FA.unregisterDataSetObserver(this.vfn);
    }
    this.FA = paramListAdapter;
    this.FA.registerDataSetObserver(this.vfn);
    reset();
    GMTrace.o(3173846614016L, 23647);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    GMTrace.i(3173578178560L, 23645);
    this.vfl = paramOnItemClickListener;
    GMTrace.o(3173578178560L, 23645);
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    GMTrace.i(3173443960832L, 23644);
    this.vfk = paramOnItemSelectedListener;
    GMTrace.o(3173443960832L, 23644);
  }
  
  public void setSelection(int paramInt)
  {
    GMTrace.i(3174115049472L, 23649);
    GMTrace.o(3174115049472L, 23649);
  }
  
  public static abstract interface a
  {
    public abstract boolean E(MotionEvent paramMotionEvent);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/HorizontalListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */