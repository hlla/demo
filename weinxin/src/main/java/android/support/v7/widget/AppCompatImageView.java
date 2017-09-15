package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.x;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageView
  extends ImageView
  implements x
{
  private f Un;
  private i hT;
  
  public AppCompatImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AppCompatImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(am.p(paramContext), paramAttributeSet, paramInt);
    paramContext = h.ey();
    this.Un = new f(this, paramContext);
    this.Un.a(paramAttributeSet, paramInt);
    this.hT = new i(this, paramContext);
    this.hT.a(paramAttributeSet, paramInt);
  }
  
  public final void a(PorterDuff.Mode paramMode)
  {
    if (this.Un != null) {
      this.Un.a(paramMode);
    }
  }
  
  public final ColorStateList bL()
  {
    if (this.Un != null) {
      return this.Un.bL();
    }
    return null;
  }
  
  public final PorterDuff.Mode bM()
  {
    if (this.Un != null) {
      return this.Un.bM();
    }
    return null;
  }
  
  public final void d(ColorStateList paramColorStateList)
  {
    if (this.Un != null) {
      this.Un.d(paramColorStateList);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.Un != null) {
      this.Un.ev();
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (this.Un != null) {
      this.Un.f(null);
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (this.Un != null) {
      this.Un.aK(paramInt);
    }
  }
  
  public void setImageResource(int paramInt)
  {
    this.hT.setImageResource(paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/AppCompatImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */