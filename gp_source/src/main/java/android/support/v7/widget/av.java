package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SpinnerAdapter;

final class av
  extends du
{
  public ListAdapter a;
  public CharSequence b;
  public final Rect c = new Rect();
  
  public av(AppCompatSpinner paramAppCompatSpinner, Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.e = paramAppCompatSpinner;
    f();
    this.l = new aw(this);
  }
  
  final void a()
  {
    Object localObject = this.q.getBackground();
    int i;
    if (localObject != null)
    {
      ((Drawable)localObject).getPadding(this.d.c);
      if (!id.a(this.d)) {
        i = -this.d.c.left;
      }
    }
    for (;;)
    {
      int m = this.d.getPaddingLeft();
      int n = this.d.getPaddingRight();
      int i1 = this.d.getWidth();
      localObject = this.d;
      int j = ((AppCompatSpinner)localObject).a;
      if (j == -2)
      {
        j = ((AppCompatSpinner)localObject).a((SpinnerAdapter)this.a, this.q.getBackground());
        int k = this.d.getContext().getResources().getDisplayMetrics().widthPixels - this.d.c.left - this.d.c.right;
        if (j > k)
        {
          j = k;
          b(Math.max(j, i1 - m - n));
        }
      }
      for (;;)
      {
        if (id.a(this.d)) {
          i = i1 - n - this.i + i;
        }
        for (;;)
        {
          this.g = i;
          return;
          i += m;
        }
        break;
        if (j == -1) {
          b(i1 - m - n);
        } else {
          b(j);
        }
      }
      i = this.d.c.right;
      continue;
      localObject = this.d.c;
      ((Rect)localObject).right = 0;
      ((Rect)localObject).left = 0;
      i = 0;
    }
  }
  
  public final void a(ListAdapter paramListAdapter)
  {
    super.a(paramListAdapter);
    this.a = paramListAdapter;
  }
  
  public final void b()
  {
    boolean bool = this.q.isShowing();
    a();
    h();
    super.b();
    this.h.setChoiceMode(1);
    int i = this.d.getSelectedItemPosition();
    Object localObject = this.h;
    if ((this.q.isShowing()) && (localObject != null))
    {
      ((bx)localObject).a = false;
      ((bx)localObject).setSelection(i);
      if (((bx)localObject).getChoiceMode() != 0) {
        ((bx)localObject).setItemChecked(i, true);
      }
    }
    if (!bool)
    {
      localObject = this.d.getViewTreeObserver();
      if (localObject != null)
      {
        ax localax = new ax(this);
        ((ViewTreeObserver)localObject).addOnGlobalLayoutListener(localax);
        a(new ay(this, localax));
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */