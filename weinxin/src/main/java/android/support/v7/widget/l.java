package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.a.a;
import android.support.v7.a.a.k;
import android.support.v7.e.a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class l
{
  private static final int[] Vp = { 16842804, 16843119, 16843117, 16843120, 16843118 };
  private static final int[] Vq = { a.a.textAllCaps };
  final TextView Vr;
  private an Vs;
  private an Vt;
  private an Vu;
  private an Vv;
  
  l(TextView paramTextView)
  {
    this.Vr = paramTextView;
  }
  
  protected static an a(Context paramContext, h paramh, int paramInt)
  {
    paramContext = paramh.e(paramContext, paramInt);
    if (paramContext != null)
    {
      paramh = new an();
      paramh.aeE = true;
      paramh.aeC = paramContext;
      return paramh;
    }
    return null;
  }
  
  static l d(TextView paramTextView)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      return new m(paramTextView);
    }
    return new l(paramTextView);
  }
  
  private void setAllCaps(boolean paramBoolean)
  {
    TextView localTextView = this.Vr;
    if (paramBoolean) {}
    for (a locala = new a(this.Vr.getContext());; locala = null)
    {
      localTextView.setTransformationMethod(locala);
      return;
    }
  }
  
  final void a(Drawable paramDrawable, an paraman)
  {
    if ((paramDrawable != null) && (paraman != null)) {
      h.a(paramDrawable, paraman, this.Vr.getDrawableState());
    }
  }
  
  void a(AttributeSet paramAttributeSet, int paramInt)
  {
    int j = 1;
    Context localContext = this.Vr.getContext();
    Object localObject = h.ey();
    TypedArray localTypedArray = localContext.obtainStyledAttributes(paramAttributeSet, Vp, paramInt, 0);
    int i = localTypedArray.getResourceId(0, -1);
    if (localTypedArray.hasValue(1)) {
      this.Vs = a(localContext, (h)localObject, localTypedArray.getResourceId(1, 0));
    }
    if (localTypedArray.hasValue(2)) {
      this.Vt = a(localContext, (h)localObject, localTypedArray.getResourceId(2, 0));
    }
    if (localTypedArray.hasValue(3)) {
      this.Vu = a(localContext, (h)localObject, localTypedArray.getResourceId(3, 0));
    }
    if (localTypedArray.hasValue(4)) {
      this.Vv = a(localContext, (h)localObject, localTypedArray.getResourceId(4, 0));
    }
    localTypedArray.recycle();
    boolean bool;
    if (!(this.Vr.getTransformationMethod() instanceof PasswordTransformationMethod))
    {
      if (i == -1) {
        break label268;
      }
      localObject = localContext.obtainStyledAttributes(i, a.k.dk);
      if (!((TypedArray)localObject).hasValue(a.k.Nu)) {
        break label260;
      }
      bool = ((TypedArray)localObject).getBoolean(a.k.Nu, false);
      i = 1;
      ((TypedArray)localObject).recycle();
    }
    for (;;)
    {
      paramAttributeSet = localContext.obtainStyledAttributes(paramAttributeSet, Vq, paramInt, 0);
      if (paramAttributeSet.hasValue(0)) {
        bool = paramAttributeSet.getBoolean(0, false);
      }
      for (paramInt = j;; paramInt = i)
      {
        paramAttributeSet.recycle();
        if (paramInt != 0) {
          setAllCaps(bool);
        }
        return;
      }
      label260:
      i = 0;
      bool = false;
      break;
      label268:
      i = 0;
      bool = false;
    }
  }
  
  void eB()
  {
    if ((this.Vs != null) || (this.Vt != null) || (this.Vu != null) || (this.Vv != null))
    {
      Drawable[] arrayOfDrawable = this.Vr.getCompoundDrawables();
      a(arrayOfDrawable[0], this.Vs);
      a(arrayOfDrawable[1], this.Vt);
      a(arrayOfDrawable[2], this.Vu);
      a(arrayOfDrawable[3], this.Vv);
    }
  }
  
  final void g(Context paramContext, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramInt, Vq);
    if (paramContext.hasValue(0)) {
      setAllCaps(paramContext.getBoolean(0, false));
    }
    paramContext.recycle();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */