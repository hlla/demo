package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;

public final class bv
  extends fe
{
  private static final int[] a = { 16843284 };
  private final Rect b = new Rect();
  private Drawable c;
  private int d;
  
  public bv(Context paramContext)
  {
    paramContext = paramContext.obtainStyledAttributes(a);
    this.c = paramContext.getDrawable(0);
    if (this.c == null) {
      Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
    }
    paramContext.recycle();
    this.d = 1;
  }
  
  public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView)
  {
    int m = 0;
    int k = 0;
    int j;
    int i;
    if ((paramRecyclerView.getLayoutManager() != null) && (this.c != null))
    {
      if (this.d != 1) {
        break label188;
      }
      paramCanvas.save();
      if (!paramRecyclerView.getClipToPadding()) {
        break label177;
      }
      j = paramRecyclerView.getPaddingLeft();
      i = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
      paramCanvas.clipRect(j, paramRecyclerView.getPaddingTop(), i, paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom());
    }
    View localView;
    int n;
    int i1;
    for (;;)
    {
      m = paramRecyclerView.getChildCount();
      while (k < m)
      {
        localView = paramRecyclerView.getChildAt(k);
        RecyclerView.a(localView, this.b);
        n = this.b.bottom;
        n = Math.round(localView.getTranslationY()) + n;
        i1 = this.c.getIntrinsicHeight();
        this.c.setBounds(j, n - i1, i, n);
        this.c.draw(paramCanvas);
        k += 1;
      }
      paramCanvas.restore();
      return;
      label177:
      i = paramRecyclerView.getWidth();
      j = 0;
    }
    label188:
    paramCanvas.save();
    if (paramRecyclerView.getClipToPadding())
    {
      j = paramRecyclerView.getPaddingTop();
      i = paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom();
      paramCanvas.clipRect(paramRecyclerView.getPaddingLeft(), j, paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight(), i);
    }
    for (;;)
    {
      n = paramRecyclerView.getChildCount();
      k = m;
      while (k < n)
      {
        localView = paramRecyclerView.getChildAt(k);
        paramRecyclerView.getLayoutManager();
        RecyclerView.b(localView, this.b);
        m = this.b.right;
        m = Math.round(localView.getTranslationX()) + m;
        i1 = this.c.getIntrinsicWidth();
        this.c.setBounds(m - i1, j, m, i);
        this.c.draw(paramCanvas);
        k += 1;
      }
      paramCanvas.restore();
      return;
      i = paramRecyclerView.getHeight();
      j = 0;
    }
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, fw paramfw)
  {
    paramView = this.c;
    if (paramView == null)
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    if (this.d == 1)
    {
      paramRect.set(0, 0, 0, paramView.getIntrinsicHeight());
      return;
    }
    paramRect.set(0, 0, paramView.getIntrinsicWidth(), 0);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */