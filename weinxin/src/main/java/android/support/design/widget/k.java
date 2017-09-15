package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.view.z;
import android.view.ViewPropertyAnimator;

class k
  extends j
{
  public boolean ie;
  
  k(VisibilityAwareImageButton paramVisibilityAwareImageButton, p paramp)
  {
    super(paramVisibilityAwareImageButton, paramp);
  }
  
  boolean Z()
  {
    return true;
  }
  
  final void a(final l.a parama, boolean paramBoolean)
  {
    if ((this.ie) || (this.iv.getVisibility() != 0)) {}
    do
    {
      return;
      if ((z.aj(this.iv)) && (!this.iv.isInEditMode())) {
        break;
      }
      this.iv.i(8, false);
    } while (parama == null);
    return;
    this.iv.animate().cancel();
    this.iv.animate().scaleX(0.0F).scaleY(0.0F).alpha(0.0F).setDuration(200L).setInterpolator(a.eu).setListener(new AnimatorListenerAdapter()
    {
      private boolean il;
      
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        k.this.ie = false;
        this.il = true;
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        k.this.ie = false;
        if (!this.il) {
          k.this.iv.i(8, this.ig);
        }
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        k.this.ie = true;
        this.il = false;
        k.this.iv.i(0, this.ig);
      }
    });
  }
  
  final void aa()
  {
    float f1 = this.iv.getRotation();
    Object localObject;
    if (this.jdField_if != null)
    {
      localObject = this.jdField_if;
      float f2 = -f1;
      if (((o)localObject).fF != f2)
      {
        ((o)localObject).fF = f2;
        ((o)localObject).invalidateSelf();
      }
    }
    if (this.iq != null)
    {
      localObject = this.iq;
      f1 = -f1;
      if (f1 != ((d)localObject).fF)
      {
        ((d)localObject).fF = f1;
        ((d)localObject).invalidateSelf();
      }
    }
  }
  
  final void b(final l.a parama, boolean paramBoolean)
  {
    if ((this.ie) || (this.iv.getVisibility() != 0))
    {
      if ((z.aj(this.iv)) && (!this.iv.isInEditMode()))
      {
        this.iv.animate().cancel();
        if (this.iv.getVisibility() != 0)
        {
          this.iv.setAlpha(0.0F);
          this.iv.setScaleY(0.0F);
          this.iv.setScaleX(0.0F);
        }
        this.iv.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(200L).setInterpolator(a.ev).setListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            k.this.iv.i(0, this.ig);
          }
        });
      }
    }
    else {
      return;
    }
    this.iv.i(0, false);
    this.iv.setAlpha(1.0F);
    this.iv.setScaleY(1.0F);
    this.iv.setScaleX(1.0F);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/design/widget/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */