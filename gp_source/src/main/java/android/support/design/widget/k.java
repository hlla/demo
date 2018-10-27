package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.b.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public final class k
  extends ViewGroup.MarginLayoutParams
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = -1;
  public View f;
  public int g = -1;
  public View h;
  public h i;
  public boolean j = false;
  public boolean k;
  public boolean l;
  public int m;
  public int n;
  public final Rect o = new Rect();
  private boolean p;
  private boolean q;
  
  public k()
  {
    super(-2, -2);
  }
  
  k(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, a.b);
    this.c = localTypedArray.getInteger(a.c, 0);
    this.g = localTypedArray.getResourceId(a.d, -1);
    this.a = localTypedArray.getInteger(a.e, 0);
    this.e = localTypedArray.getInteger(a.i, -1);
    this.d = localTypedArray.getInt(a.h, 0);
    this.b = localTypedArray.getInt(a.g, 0);
    this.j = localTypedArray.hasValue(a.f);
    if (this.j) {
      this.i = CoordinatorLayout.a(paramContext, paramAttributeSet, localTypedArray.getString(a.f));
    }
    localTypedArray.recycle();
    paramContext = this.i;
    if (paramContext != null) {
      paramContext.a(this);
    }
  }
  
  public k(k paramk)
  {
    super(paramk);
  }
  
  public k(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public k(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
  }
  
  final void a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.q = paramBoolean;
      return;
    }
    this.p = paramBoolean;
  }
  
  public final void a(h paramh)
  {
    if (this.i != paramh)
    {
      this.i = paramh;
      this.j = true;
      if (paramh != null) {
        paramh.a(this);
      }
    }
  }
  
  final boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      return this.p;
    }
    return this.q;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/widget/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */