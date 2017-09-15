package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.design.a.a;
import android.util.StateSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class j
  extends l
{
  private int ib;
  private r ic;
  public boolean ie;
  o jdField_if;
  
  j(VisibilityAwareImageButton paramVisibilityAwareImageButton, p paramp)
  {
    super(paramVisibilityAwareImageButton, paramp);
    this.ib = paramVisibilityAwareImageButton.getResources().getInteger(17694720);
    this.ic = new r();
    paramp = this.ic;
    View localView = paramp.an();
    if (localView != paramVisibilityAwareImageButton)
    {
      if (localView != null)
      {
        localView = paramp.an();
        int j = paramp.jA.size();
        int i = 0;
        while (i < j)
        {
          Animation localAnimation = ((r.a)paramp.jA.get(i)).mAnimation;
          if (localView.getAnimation() == localAnimation) {
            localView.clearAnimation();
          }
          i += 1;
        }
        paramp.fh = null;
        paramp.jB = null;
        paramp.jC = null;
      }
      if (paramVisibilityAwareImageButton != null) {
        paramp.fh = new WeakReference(paramVisibilityAwareImageButton);
      }
    }
    this.ic.a(PRESSED_ENABLED_STATE_SET, c(new b((byte)0)));
    this.ic.a(iu, c(new b((byte)0)));
    this.ic.a(EMPTY_STATE_SET, c(new c((byte)0)));
  }
  
  private Animation c(Animation paramAnimation)
  {
    paramAnimation.setInterpolator(a.et);
    paramAnimation.setDuration(this.ib);
    return paramAnimation;
  }
  
  void X()
  {
    r localr = this.ic;
    if (localr.jC != null)
    {
      View localView = localr.an();
      if ((localView != null) && (localView.getAnimation() == localr.jC)) {
        localView.clearAnimation();
      }
    }
  }
  
  void a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode, int paramInt1, int paramInt2)
  {
    this.in = android.support.v4.b.a.a.g(ad());
    android.support.v4.b.a.a.a(this.in, paramColorStateList);
    if (paramMode != null) {
      android.support.v4.b.a.a.a(this.in, paramMode);
    }
    this.io = android.support.v4.b.a.a.g(ad());
    android.support.v4.b.a.a.a(this.io, new ColorStateList(new int[][] { iu, PRESSED_ENABLED_STATE_SET, new int[0] }, new int[] { paramInt1, paramInt1, 0 }));
    if (paramInt2 > 0)
    {
      this.iq = a(paramInt2, paramColorStateList);
      paramColorStateList = new Drawable[3];
      paramColorStateList[0] = this.iq;
      paramColorStateList[1] = this.in;
      paramColorStateList[2] = this.io;
    }
    for (;;)
    {
      this.ir = new LayerDrawable(paramColorStateList);
      this.jdField_if = new o(this.iv.getResources(), this.ir, this.iw.V(), this.is, this.is + this.it);
      paramColorStateList = this.jdField_if;
      paramColorStateList.jg = false;
      paramColorStateList.invalidateSelf();
      this.iw.setBackgroundDrawable(this.jdField_if);
      return;
      this.iq = null;
      paramColorStateList = new Drawable[2];
      paramColorStateList[0] = this.in;
      paramColorStateList[1] = this.io;
    }
  }
  
  void a(final l.a parama, boolean paramBoolean)
  {
    if ((this.ie) || (this.iv.getVisibility() != 0)) {
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.iv.getContext(), a.a.U);
    localAnimation.setInterpolator(a.eu);
    localAnimation.setDuration(200L);
    localAnimation.setAnimationListener(new b() {});
    this.iv.startAnimation(localAnimation);
  }
  
  void b(Rect paramRect)
  {
    this.jdField_if.getPadding(paramRect);
  }
  
  void b(final l.a parama, boolean paramBoolean)
  {
    if ((this.iv.getVisibility() != 0) || (this.ie))
    {
      this.iv.clearAnimation();
      this.iv.i(0, false);
      Animation localAnimation = AnimationUtils.loadAnimation(this.iv.getContext(), a.a.T);
      localAnimation.setDuration(200L);
      localAnimation.setInterpolator(a.ev);
      localAnimation.setAnimationListener(new b() {});
      this.iv.startAnimation(localAnimation);
    }
  }
  
  void b(int[] paramArrayOfInt)
  {
    r localr = this.ic;
    int j = localr.jA.size();
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = (r.a)localr.jA.get(i);
      if (!StateSet.stateSetMatches(((r.a)localObject).jF, paramArrayOfInt)) {}
    }
    for (paramArrayOfInt = (int[])localObject;; paramArrayOfInt = null)
    {
      if (paramArrayOfInt != localr.jB)
      {
        if ((localr.jB != null) && (localr.jC != null))
        {
          localObject = localr.an();
          if ((localObject != null) && (((View)localObject).getAnimation() == localr.jC)) {
            ((View)localObject).clearAnimation();
          }
          localr.jC = null;
        }
        localr.jB = paramArrayOfInt;
        localObject = (View)localr.fh.get();
        if ((paramArrayOfInt != null) && (localObject != null) && (((View)localObject).getVisibility() == 0))
        {
          localr.jC = paramArrayOfInt.mAnimation;
          paramArrayOfInt = localr.an();
          if (paramArrayOfInt != null) {
            paramArrayOfInt.startAnimation(localr.jC);
          }
        }
      }
      return;
      i += 1;
      break;
    }
  }
  
  void i(float paramFloat)
  {
    if (this.jdField_if != null)
    {
      this.jdField_if.d(paramFloat, this.it + paramFloat);
      ab();
    }
  }
  
  void j(float paramFloat)
  {
    if (this.jdField_if != null)
    {
      o localo = this.jdField_if;
      float f = this.is;
      localo.d(localo.jb, f + paramFloat);
      ab();
    }
  }
  
  final void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.in != null) {
      android.support.v4.b.a.a.a(this.in, paramColorStateList);
    }
    if (this.iq != null) {
      this.iq.c(paramColorStateList);
    }
  }
  
  final void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.in != null) {
      android.support.v4.b.a.a.a(this.in, paramMode);
    }
  }
  
  private abstract class a
    extends Animation
  {
    private float ij;
    private float ik;
    
    private a() {}
    
    protected abstract float Y();
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      paramTransformation = j.this.jdField_if;
      paramTransformation.d(this.ij + this.ik * paramFloat, paramTransformation.iZ);
    }
    
    public void reset()
    {
      super.reset();
      this.ij = j.this.jdField_if.jb;
      this.ik = (Y() - this.ij);
    }
  }
  
  private final class b
    extends j.a
  {
    private b()
    {
      super((byte)0);
    }
    
    protected final float Y()
    {
      return j.this.is + j.this.it;
    }
  }
  
  private final class c
    extends j.a
  {
    private c()
    {
      super((byte)0);
    }
    
    protected final float Y()
    {
      return j.this.is;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */