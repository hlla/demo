package android.support.design.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.design.a.a;
import android.support.v4.view.ac;
import android.support.v4.widget.Space;
import android.support.v4.widget.av;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

final class b
{
  public Animator a;
  public int b;
  public int c;
  public final Context d;
  public boolean e;
  public CharSequence f;
  public int g;
  public TextView h;
  public CharSequence i;
  public boolean j;
  public int k;
  public TextView l;
  public final TextInputLayout m;
  public Typeface n;
  private FrameLayout o;
  private final float p;
  private int q;
  private LinearLayout r;
  private int s;
  
  public b(TextInputLayout paramTextInputLayout)
  {
    this.d = paramTextInputLayout.getContext();
    this.m = paramTextInputLayout;
    this.p = this.d.getResources().getDimensionPixelSize(2131165580);
  }
  
  private static void a(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      paramViewGroup.setVisibility(8);
    }
  }
  
  static void a(TextView paramTextView, Typeface paramTypeface)
  {
    if (paramTextView != null) {
      paramTextView.setTypeface(paramTypeface);
    }
  }
  
  private final void a(List paramList, boolean paramBoolean, TextView paramTextView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramTextView != null) && (paramBoolean)) {
      if (paramInt1 != paramInt3) {
        break label128;
      }
    }
    for (;;)
    {
      float f1;
      if (paramInt1 == paramInt3)
      {
        f1 = 1.0F;
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramTextView, View.ALPHA, new float[] { f1 });
        localObjectAnimator.setDuration(167L);
        localObjectAnimator.setInterpolator(a.d);
        paramList.add(localObjectAnimator);
        if (paramInt1 == paramInt3)
        {
          paramTextView = ObjectAnimator.ofFloat(paramTextView, View.TRANSLATION_Y, new float[] { -this.p, 0.0F });
          paramTextView.setDuration(217L);
          paramTextView.setInterpolator(a.e);
          paramList.add(paramTextView);
        }
      }
      label128:
      do
      {
        return;
        f1 = 0.0F;
        break;
      } while (paramInt1 != paramInt2);
    }
  }
  
  private static boolean c(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 1) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private final TextView d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 2: 
      return this.l;
    }
    return this.h;
  }
  
  final void a()
  {
    this.f = null;
    b();
    if (this.b == 1) {
      if ((!this.j) || (TextUtils.isEmpty(this.i))) {
        break label61;
      }
    }
    label61:
    for (this.c = 2;; this.c = 0)
    {
      a(this.b, this.c, a(this.h, null));
      return;
    }
  }
  
  final void a(int paramInt)
  {
    this.g = paramInt;
    TextView localTextView = this.h;
    if (localTextView != null) {
      this.m.a(localTextView, paramInt);
    }
  }
  
  final void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = new AnimatorSet();
      this.a = ((Animator)localObject);
      ArrayList localArrayList = new ArrayList();
      a(localArrayList, this.j, this.l, 2, paramInt1, paramInt2);
      a(localArrayList, this.e, this.h, 1, paramInt1, paramInt2);
      android.support.design.a.b.a((AnimatorSet)localObject, localArrayList);
      ((AnimatorSet)localObject).addListener(new c(this, paramInt2, d(paramInt1), paramInt1, d(paramInt2)));
      ((AnimatorSet)localObject).start();
    }
    for (;;)
    {
      this.m.a();
      this.m.a(paramBoolean, false);
      this.m.b();
      return;
      if (paramInt1 != paramInt2)
      {
        if (paramInt2 != 0)
        {
          localObject = d(paramInt2);
          if (localObject != null)
          {
            ((TextView)localObject).setVisibility(0);
            ((TextView)localObject).setAlpha(1.0F);
          }
        }
        if (paramInt1 != 0)
        {
          localObject = d(paramInt1);
          if (localObject != null)
          {
            ((TextView)localObject).setVisibility(4);
            if (paramInt1 == 1) {
              ((TextView)localObject).setText(null);
            }
          }
        }
        this.b = paramInt2;
      }
    }
  }
  
  final void a(TextView paramTextView, int paramInt)
  {
    if ((this.r == null) && (this.o == null))
    {
      this.r = new LinearLayout(this.d);
      this.r.setOrientation(0);
      this.m.addView(this.r, -1, -2);
      this.o = new FrameLayout(this.d);
      this.r.addView(this.o, -1, new FrameLayout.LayoutParams(-2, -2));
      Space localSpace = new Space(this.d);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0, 1.0F);
      this.r.addView(localSpace, localLayoutParams);
      if (this.m.getEditText() != null) {
        c();
      }
    }
    if (c(paramInt))
    {
      this.o.setVisibility(0);
      this.o.addView(paramTextView);
      this.q += 1;
    }
    for (;;)
    {
      this.r.setVisibility(0);
      this.s += 1;
      return;
      this.r.addView(paramTextView, paramInt);
    }
  }
  
  final boolean a(TextView paramTextView, CharSequence paramCharSequence)
  {
    if (ac.I(this.m))
    {
      if (this.m.isEnabled())
      {
        if (this.c != this.b) {}
        while ((paramTextView == null) || (!TextUtils.equals(paramTextView.getText(), paramCharSequence))) {
          return true;
        }
        return false;
      }
      return false;
    }
    return false;
  }
  
  final void b()
  {
    Animator localAnimator = this.a;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
  }
  
  final void b(int paramInt)
  {
    this.k = paramInt;
    TextView localTextView = this.l;
    if (localTextView != null) {
      av.a(localTextView, paramInt);
    }
  }
  
  final void b(TextView paramTextView, int paramInt)
  {
    if (this.r != null)
    {
      if (!c(paramInt)) {
        break label71;
      }
      FrameLayout localFrameLayout = this.o;
      if (localFrameLayout == null) {
        break label71;
      }
      this.q -= 1;
      a(localFrameLayout, this.q);
      this.o.removeView(paramTextView);
    }
    for (;;)
    {
      this.s -= 1;
      a(this.r, this.s);
      return;
      label71:
      this.r.removeView(paramTextView);
    }
  }
  
  final void c()
  {
    if ((this.r != null) && (this.m.getEditText() != null)) {
      ac.a(this.r, ac.n(this.m.getEditText()), 0, ac.o(this.m.getEditText()), 0);
    }
  }
  
  final boolean d()
  {
    return (this.c == 1) && (this.h != null) && (!TextUtils.isEmpty(this.f));
  }
  
  final int e()
  {
    TextView localTextView = this.h;
    if (localTextView != null) {
      return localTextView.getCurrentTextColor();
    }
    return -1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/textfield/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */