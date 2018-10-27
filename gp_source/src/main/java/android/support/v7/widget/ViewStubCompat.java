package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.lang.ref.WeakReference;

public final class ViewStubCompat
  extends View
{
  private ic a;
  private int b;
  private WeakReference c;
  private LayoutInflater d;
  private int e = 0;
  
  public ViewStubCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewStubCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.dR, paramInt, 0);
    this.b = paramContext.getResourceId(a.dT, -1);
    this.e = paramContext.getResourceId(a.dU, 0);
    setId(paramContext.getResourceId(a.dS, -1));
    paramContext.recycle();
    setVisibility(8);
    setWillNotDraw(true);
  }
  
  public final View a()
  {
    Object localObject1 = getParent();
    if ((localObject1 != null) && ((localObject1 instanceof ViewGroup)))
    {
      if (this.e != 0)
      {
        ViewGroup localViewGroup = (ViewGroup)localObject1;
        Object localObject2 = this.d;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = LayoutInflater.from(getContext());
        }
        localObject1 = ((LayoutInflater)localObject1).inflate(this.e, localViewGroup, false);
        int i = this.b;
        if (i != -1) {
          ((View)localObject1).setId(i);
        }
        i = localViewGroup.indexOfChild(this);
        localViewGroup.removeViewInLayout(this);
        localObject2 = getLayoutParams();
        if (localObject2 != null) {
          localViewGroup.addView((View)localObject1, i, (ViewGroup.LayoutParams)localObject2);
        }
        for (;;)
        {
          this.c = new WeakReference(localObject1);
          localObject2 = this.a;
          if (localObject2 != null) {
            ((ic)localObject2).a();
          }
          return (View)localObject1;
          localViewGroup.addView((View)localObject1, i);
        }
      }
    }
    else {
      throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }
    throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
  }
  
  protected final void dispatchDraw(Canvas paramCanvas) {}
  
  @SuppressLint({"MissingSuperCall"})
  public final void draw(Canvas paramCanvas) {}
  
  public final int getInflatedId()
  {
    return this.b;
  }
  
  public final LayoutInflater getLayoutInflater()
  {
    return this.d;
  }
  
  public final int getLayoutResource()
  {
    return this.e;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(0, 0);
  }
  
  public final void setInflatedId(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void setLayoutInflater(LayoutInflater paramLayoutInflater)
  {
    this.d = paramLayoutInflater;
  }
  
  public final void setLayoutResource(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void setOnInflateListener(ic paramic)
  {
    this.a = paramic;
  }
  
  public final void setVisibility(int paramInt)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (View)((WeakReference)localObject).get();
      if (localObject != null) {
        ((View)localObject).setVisibility(paramInt);
      }
    }
    else
    {
      super.setVisibility(paramInt);
      if (paramInt == 0) {}
      for (;;)
      {
        a();
        return;
        if (paramInt != 4) {
          break;
        }
      }
    }
    throw new IllegalStateException("setVisibility called on un-referenced view");
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ViewStubCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */