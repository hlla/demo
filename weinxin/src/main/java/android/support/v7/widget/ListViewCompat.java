package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

public class ListViewCompat
  extends ListView
{
  private static final int[] YG = { 0 };
  final Rect YH = new Rect();
  int YI = 0;
  int YJ = 0;
  int YK = 0;
  int YL = 0;
  protected int YM;
  private Field YN;
  private a YO;
  
  public ListViewCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ListViewCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    try
    {
      this.YN = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
      this.YN.setAccessible(true);
      return;
    }
    catch (NoSuchFieldException paramContext) {}
  }
  
  public final int L(int paramInt1, int paramInt2)
  {
    int i = getListPaddingTop();
    int k = getListPaddingBottom();
    getListPaddingLeft();
    getListPaddingRight();
    int j = getDividerHeight();
    Object localObject = getDivider();
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter == null)
    {
      i += k;
      return i;
    }
    i = k + i;
    label66:
    label84:
    int n;
    label116:
    View localView;
    if ((j > 0) && (localObject != null))
    {
      int i1 = localListAdapter.getCount();
      k = 0;
      int m = 0;
      localObject = null;
      if (k >= i1) {
        break label251;
      }
      n = localListAdapter.getItemViewType(k);
      if (n == m) {
        break label253;
      }
      m = n;
      localObject = null;
      localView = localListAdapter.getView(k, (View)localObject, this);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null)
      {
        localObject = generateDefaultLayoutParams();
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (((ViewGroup.LayoutParams)localObject).height <= 0) {
        break label241;
      }
      n = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);
      label179:
      localView.measure(paramInt1, n);
      localView.forceLayout();
      if (k <= 0) {
        break label256;
      }
      i += j;
    }
    label241:
    label251:
    label253:
    label256:
    for (;;)
    {
      n = localView.getMeasuredHeight() + i;
      i = paramInt2;
      if (n >= paramInt2) {
        break;
      }
      k += 1;
      i = n;
      localObject = localView;
      break label84;
      j = 0;
      break label66;
      n = View.MeasureSpec.makeMeasureSpec(0, 0);
      break label179;
      return i;
      break label116;
    }
  }
  
  protected final void Q(boolean paramBoolean)
  {
    if (this.YO != null) {
      this.YO.AK = paramBoolean;
    }
  }
  
  void a(int paramInt, View paramView)
  {
    Rect localRect = this.YH;
    localRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    localRect.left -= this.YI;
    localRect.top -= this.YJ;
    localRect.right += this.YK;
    localRect.bottom += this.YL;
    try
    {
      boolean bool = this.YN.getBoolean(this);
      if (paramView.isEnabled() != bool)
      {
        paramView = this.YN;
        if (bool) {
          break label134;
        }
      }
      label134:
      for (bool = true;; bool = false)
      {
        paramView.set(this, Boolean.valueOf(bool));
        if (paramInt != -1) {
          refreshDrawableState();
        }
        return;
      }
      return;
    }
    catch (IllegalAccessException paramView) {}
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (!this.YH.isEmpty())
    {
      Drawable localDrawable = getSelector();
      if (localDrawable != null)
      {
        localDrawable.setBounds(this.YH);
        localDrawable.draw(paramCanvas);
      }
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void drawableStateChanged()
  {
    int i = 1;
    super.drawableStateChanged();
    Q(true);
    Drawable localDrawable = getSelector();
    if (localDrawable != null) {
      if ((!fg()) || (!isPressed())) {
        break label48;
      }
    }
    for (;;)
    {
      if (i != 0) {
        localDrawable.setState(getDrawableState());
      }
      return;
      label48:
      i = 0;
    }
  }
  
  protected boolean fg()
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.YM = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    if (paramDrawable != null) {}
    for (Object localObject = new a(paramDrawable);; localObject = null)
    {
      this.YO = ((a)localObject);
      super.setSelector(this.YO);
      localObject = new Rect();
      if (paramDrawable != null) {
        paramDrawable.getPadding((Rect)localObject);
      }
      this.YI = ((Rect)localObject).left;
      this.YJ = ((Rect)localObject).top;
      this.YK = ((Rect)localObject).right;
      this.YL = ((Rect)localObject).bottom;
      return;
    }
  }
  
  private static final class a
    extends a
  {
    boolean AK = true;
    
    public a(Drawable paramDrawable)
    {
      super();
    }
    
    public final void draw(Canvas paramCanvas)
    {
      if (this.AK) {
        super.draw(paramCanvas);
      }
    }
    
    public final void setHotspot(float paramFloat1, float paramFloat2)
    {
      if (this.AK) {
        super.setHotspot(paramFloat1, paramFloat2);
      }
    }
    
    public final void setHotspotBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (this.AK) {
        super.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    public final boolean setState(int[] paramArrayOfInt)
    {
      if (this.AK) {
        return super.setState(paramArrayOfInt);
      }
      return false;
    }
    
    public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (this.AK) {
        return super.setVisible(paramBoolean1, paramBoolean2);
      }
      return false;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/ListViewCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */