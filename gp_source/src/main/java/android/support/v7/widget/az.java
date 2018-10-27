package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.a.k;
import android.support.v4.widget.av;
import android.support.v4.widget.d;
import android.support.v7.a.a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

final class az
{
  public boolean a;
  public final bc b;
  public Typeface c;
  public int d = 0;
  private hd e;
  private hd f;
  private hd g;
  private hd h;
  private hd i;
  private hd j;
  private final TextView k;
  
  az(TextView paramTextView)
  {
    this.k = paramTextView;
    this.b = new bc(this.k);
  }
  
  private static hd a(Context paramContext, ae paramae, int paramInt)
  {
    paramContext = paramae.b(paramContext, paramInt);
    if (paramContext != null)
    {
      paramae = new hd();
      paramae.a = true;
      paramae.c = paramContext;
      return paramae;
    }
    return null;
  }
  
  private final void a(Context paramContext, hf paramhf)
  {
    this.d = paramhf.a(a.dk, this.d);
    if ((paramhf.g(a.db)) || (paramhf.g(a.dm)))
    {
      this.c = null;
      if (!paramhf.g(a.dm))
      {
        m = a.db;
        if (!paramContext.isRestricted()) {
          paramContext = new ba(this, new WeakReference(this.k));
        }
      }
    }
    try
    {
      n = this.d;
      i1 = paramhf.c.getResourceId(m, 0);
      if (i1 == 0) {
        break label217;
      }
      if (paramhf.b == null) {
        paramhf.b = new TypedValue();
      }
      localContext = paramhf.a;
      localTypedValue = paramhf.b;
      if (localContext.isRestricted()) {
        break label212;
      }
      paramContext = k.a(localContext, i1, localTypedValue, n, paramContext, true);
      this.c = paramContext;
      if (this.c != null) {
        break label206;
      }
      bool = true;
      this.a = bool;
    }
    catch (UnsupportedOperationException paramContext)
    {
      for (;;) {}
    }
    catch (Resources.NotFoundException paramContext)
    {
      for (;;) {}
    }
    if (this.c == null)
    {
      paramContext = paramhf.d(m);
      if (paramContext != null) {
        this.c = Typeface.create(paramContext, this.d);
      }
    }
    label206:
    label212:
    label217:
    while (!paramhf.g(a.dl)) {
      for (;;)
      {
        int n;
        int i1;
        Context localContext;
        TypedValue localTypedValue;
        return;
        boolean bool = false;
        continue;
        paramContext = null;
        continue;
        paramContext = null;
        continue;
        int m = a.dm;
      }
    }
    this.a = false;
    switch (paramhf.a(a.dl, 1))
    {
    default: 
      return;
    case 1: 
      this.c = Typeface.SANS_SERIF;
      return;
    case 3: 
      this.c = Typeface.MONOSPACE;
      return;
    }
    this.c = Typeface.SERIF;
  }
  
  private final void a(Drawable paramDrawable, hd paramhd)
  {
    if ((paramDrawable != null) && (paramhd != null)) {
      ae.a(paramDrawable, paramhd, this.k.getDrawableState());
    }
  }
  
  final void a()
  {
    Drawable[] arrayOfDrawable;
    if ((this.g != null) || (this.j != null) || (this.h != null) || (this.e != null))
    {
      arrayOfDrawable = this.k.getCompoundDrawables();
      a(arrayOfDrawable[0], this.g);
      a(arrayOfDrawable[1], this.j);
      a(arrayOfDrawable[2], this.h);
      a(arrayOfDrawable[3], this.e);
    }
    if ((Build.VERSION.SDK_INT >= 17) && ((this.i != null) || (this.f != null)))
    {
      arrayOfDrawable = this.k.getCompoundDrawablesRelative();
      a(arrayOfDrawable[0], this.i);
      a(arrayOfDrawable[2], this.f);
    }
  }
  
  final void a(int paramInt)
  {
    Object localObject = this.b;
    if (((bc)localObject).e()) {}
    switch (paramInt)
    {
    default: 
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unknown auto-size text type: ");
      ((StringBuilder)localObject).append(paramInt);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    case 1: 
      DisplayMetrics localDisplayMetrics = ((bc)localObject).f.getResources().getDisplayMetrics();
      ((bc)localObject).a(TypedValue.applyDimension(2, 12.0F, localDisplayMetrics), TypedValue.applyDimension(2, 112.0F, localDisplayMetrics), 1.0F);
      if (((bc)localObject).b()) {
        ((bc)localObject).c();
      }
      return;
    }
    ((bc)localObject).e = 0;
    ((bc)localObject).b = -1.0F;
    ((bc)localObject).a = -1.0F;
    ((bc)localObject).c = -1.0F;
    ((bc)localObject).d = new int[0];
    ((bc)localObject).h = false;
  }
  
  final void a(int paramInt, float paramFloat)
  {
    if ((!d.a) && (!this.b.d())) {
      this.b.a(paramInt, paramFloat);
    }
  }
  
  final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    bc localbc = this.b;
    if (localbc.e())
    {
      DisplayMetrics localDisplayMetrics = localbc.f.getResources().getDisplayMetrics();
      localbc.a(TypedValue.applyDimension(paramInt4, paramInt1, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt2, localDisplayMetrics), TypedValue.applyDimension(paramInt4, paramInt3, localDisplayMetrics));
      if (localbc.b()) {
        localbc.c();
      }
    }
  }
  
  final void a(Context paramContext, int paramInt)
  {
    hf localhf = hf.a(paramContext, paramInt, a.da);
    if (localhf.g(a.dn)) {
      a(localhf.a(a.dn, false));
    }
    if ((Build.VERSION.SDK_INT < 23) && (localhf.g(a.dg)))
    {
      ColorStateList localColorStateList = localhf.e(a.dg);
      if (localColorStateList != null) {
        this.k.setTextColor(localColorStateList);
      }
    }
    a(paramContext, localhf);
    localhf.c.recycle();
    paramContext = this.c;
    if (paramContext != null) {
      this.k.setTypeface(paramContext, this.d);
    }
  }
  
  @SuppressLint({"NewApi"})
  final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    Context localContext = this.k.getContext();
    Object localObject1 = ae.a();
    Object localObject2 = hf.a(localContext, paramAttributeSet, a.ah, paramInt, 0);
    int m = ((hf)localObject2).g(a.ao, -1);
    if (((hf)localObject2).g(a.ak)) {
      this.g = a(localContext, (ae)localObject1, ((hf)localObject2).g(a.ak, 0));
    }
    if (((hf)localObject2).g(a.an)) {
      this.j = a(localContext, (ae)localObject1, ((hf)localObject2).g(a.an, 0));
    }
    if (((hf)localObject2).g(a.al)) {
      this.h = a(localContext, (ae)localObject1, ((hf)localObject2).g(a.al, 0));
    }
    if (((hf)localObject2).g(a.ai)) {
      this.e = a(localContext, (ae)localObject1, ((hf)localObject2).g(a.ai, 0));
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (((hf)localObject2).g(a.am)) {
        this.i = a(localContext, (ae)localObject1, ((hf)localObject2).g(a.am, 0));
      }
      if (((hf)localObject2).g(a.aj)) {
        this.f = a(localContext, (ae)localObject1, ((hf)localObject2).g(a.aj, 0));
      }
    }
    ((hf)localObject2).c.recycle();
    boolean bool3 = this.k.getTransformationMethod() instanceof PasswordTransformationMethod;
    boolean bool1;
    Object localObject3;
    Object localObject4;
    if (m == -1)
    {
      bool1 = false;
      m = 0;
      localObject2 = null;
      localObject1 = null;
      localObject3 = null;
      hf localhf = hf.a(localContext, paramAttributeSet, a.da, paramInt, 0);
      int n = m;
      boolean bool2 = bool1;
      if (!bool3)
      {
        n = m;
        bool2 = bool1;
        if (localhf.g(a.dn))
        {
          bool2 = localhf.a(a.dn, false);
          n = 1;
        }
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject4 = localObject2;
        localObject5 = localObject1;
      }
      for (;;)
      {
        a(localContext, localhf);
        localhf.c.recycle();
        if (localObject4 != null) {
          this.k.setTextColor((ColorStateList)localObject4);
        }
        if (localObject5 != null) {
          this.k.setHintTextColor((ColorStateList)localObject5);
        }
        if (localObject3 != null) {
          this.k.setLinkTextColor((ColorStateList)localObject3);
        }
        if (bool3) {}
        for (;;)
        {
          localObject1 = this.c;
          if (localObject1 != null) {
            this.k.setTypeface((Typeface)localObject1, this.d);
          }
          localObject1 = this.b;
          localObject2 = ((bc)localObject1).f.obtainStyledAttributes(paramAttributeSet, a.ap, paramInt, 0);
          if (((TypedArray)localObject2).hasValue(a.au)) {
            ((bc)localObject1).e = ((TypedArray)localObject2).getInt(a.au, 0);
          }
          if (((TypedArray)localObject2).hasValue(a.at)) {}
          for (float f1 = ((TypedArray)localObject2).getDimension(a.at, -1.0F);; f1 = -1.0F)
          {
            if (((TypedArray)localObject2).hasValue(a.ar)) {}
            for (float f2 = ((TypedArray)localObject2).getDimension(a.ar, -1.0F);; f2 = -1.0F)
            {
              if (((TypedArray)localObject2).hasValue(a.aq)) {}
              for (float f3 = ((TypedArray)localObject2).getDimension(a.aq, -1.0F);; f3 = -1.0F)
              {
                if (((TypedArray)localObject2).hasValue(a.as))
                {
                  paramInt = ((TypedArray)localObject2).getResourceId(a.as, 0);
                  if (paramInt > 0)
                  {
                    localObject3 = ((TypedArray)localObject2).getResources().obtainTypedArray(paramInt);
                    m = ((TypedArray)localObject3).length();
                    localObject4 = new int[m];
                    if (m > 0) {
                      break label926;
                    }
                  }
                }
                for (;;)
                {
                  ((TypedArray)localObject3).recycle();
                  ((TypedArray)localObject2).recycle();
                  if (((bc)localObject1).e()) {
                    if (((bc)localObject1).e == 1)
                    {
                      if (!((bc)localObject1).g)
                      {
                        localObject2 = ((bc)localObject1).f.getResources().getDisplayMetrics();
                        float f4 = f2;
                        if (f2 == -1.0F) {
                          f4 = TypedValue.applyDimension(2, 12.0F, (DisplayMetrics)localObject2);
                        }
                        f2 = f3;
                        if (f3 == -1.0F) {
                          f2 = TypedValue.applyDimension(2, 112.0F, (DisplayMetrics)localObject2);
                        }
                        f3 = f1;
                        if (f1 == -1.0F) {
                          f3 = 1.0F;
                        }
                        ((bc)localObject1).a(f4, f2, f3);
                      }
                      ((bc)localObject1).b();
                    }
                  }
                  for (;;)
                  {
                    if (d.a)
                    {
                      localObject1 = this.b;
                      if (((bc)localObject1).e != 0) {
                        break label836;
                      }
                    }
                    for (;;)
                    {
                      paramAttributeSet = hf.a(localContext, paramAttributeSet, a.ap);
                      paramInt = paramAttributeSet.e(a.av, -1);
                      m = paramAttributeSet.e(a.aw, -1);
                      n = paramAttributeSet.e(a.ax, -1);
                      paramAttributeSet.c.recycle();
                      if (paramInt != -1) {
                        av.b(this.k, paramInt);
                      }
                      if (m != -1) {
                        av.c(this.k, m);
                      }
                      if (n != -1) {
                        av.d(this.k, n);
                      }
                      return;
                      label836:
                      localObject1 = ((bc)localObject1).d;
                      if (localObject1.length > 0) {
                        if (this.k.getAutoSizeStepGranularity() != -1.0F) {
                          this.k.setAutoSizeTextTypeUniformWithConfiguration(Math.round(this.b.b), Math.round(this.b.a), Math.round(this.b.c), 0);
                        } else {
                          this.k.setAutoSizeTextTypeUniformWithPresetSizes((int[])localObject1, 0);
                        }
                      }
                    }
                    ((bc)localObject1).e = 0;
                  }
                  label926:
                  paramInt = 0;
                  while (paramInt < m)
                  {
                    localObject4[paramInt] = ((TypedArray)localObject3).getDimensionPixelSize(paramInt, -1);
                    paramInt += 1;
                  }
                  ((bc)localObject1).d = bc.a((int[])localObject4);
                  ((bc)localObject1).a();
                }
              }
            }
          }
          if (n != 0) {
            a(bool2);
          }
        }
        if (localhf.g(a.dg)) {
          localObject2 = localhf.e(a.dg);
        }
        if (localhf.g(a.dh)) {
          localObject1 = localhf.e(a.dh);
        }
        localObject5 = localObject1;
        localObject4 = localObject2;
        if (localhf.g(a.di))
        {
          localObject3 = localhf.e(a.di);
          localObject5 = localObject1;
          localObject4 = localObject2;
        }
      }
    }
    Object localObject5 = hf.a(localContext, m, a.da);
    if (!bool3) {
      if (((hf)localObject5).g(a.dn))
      {
        bool1 = ((hf)localObject5).a(a.dn, false);
        m = 1;
      }
    }
    for (;;)
    {
      a(localContext, (hf)localObject5);
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject2 = null;
        localObject4 = null;
        localObject1 = null;
        ((hf)localObject5).c.recycle();
        localObject3 = localObject1;
        localObject1 = localObject4;
        break;
      }
      if (((hf)localObject5).g(a.dg)) {}
      for (localObject1 = ((hf)localObject5).e(a.dg);; localObject1 = null)
      {
        if (((hf)localObject5).g(a.dh)) {}
        for (localObject2 = ((hf)localObject5).e(a.dh);; localObject2 = null)
        {
          if (((hf)localObject5).g(a.di))
          {
            localObject4 = ((hf)localObject5).e(a.di);
            localObject3 = localObject1;
            localObject1 = localObject4;
            localObject4 = localObject2;
            localObject2 = localObject3;
            break;
          }
          localObject3 = localObject1;
          localObject1 = null;
          localObject4 = localObject2;
          localObject2 = localObject3;
          break;
        }
      }
      bool1 = false;
      m = 0;
      continue;
      bool1 = false;
      m = 0;
    }
  }
  
  final void a(boolean paramBoolean)
  {
    this.k.setAllCaps(paramBoolean);
  }
  
  final void a(int[] paramArrayOfInt, int paramInt)
  {
    int m = 0;
    bc localbc = this.b;
    int n;
    int[] arrayOfInt;
    if (localbc.e())
    {
      n = paramArrayOfInt.length;
      if (n <= 0) {
        break label122;
      }
      arrayOfInt = new int[n];
      if (paramInt != 0) {
        break label75;
      }
      localObject = Arrays.copyOf(paramArrayOfInt, n);
      localbc.d = bc.a((int[])localObject);
      if (!localbc.a()) {
        break label131;
      }
    }
    for (;;)
    {
      if (localbc.b()) {
        localbc.c();
      }
      return;
      label75:
      DisplayMetrics localDisplayMetrics = localbc.f.getResources().getDisplayMetrics();
      for (;;)
      {
        localObject = arrayOfInt;
        if (m >= n) {
          break;
        }
        arrayOfInt[m] = Math.round(TypedValue.applyDimension(paramInt, paramArrayOfInt[m], localDisplayMetrics));
        m += 1;
      }
      label122:
      localbc.g = false;
    }
    label131:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("None of the preset sizes is valid: ");
    ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfInt));
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  final void b()
  {
    if (!d.a) {
      this.b.c();
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */