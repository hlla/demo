package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.x;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.EditText;

public class AppCompatEditText
  extends EditText
  implements x
{
  private h Um = h.ey();
  private f Un = new f(this, this.Um);
  private l Uo;
  
  public AppCompatEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.editTextStyle);
  }
  
  public AppCompatEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(am.p(paramContext), paramAttributeSet, paramInt);
    this.Un.a(paramAttributeSet, paramInt);
    this.Uo = l.d(this);
    this.Uo.a(paramAttributeSet, paramInt);
    this.Uo.eB();
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
    if (this.Uo != null) {
      this.Uo.eB();
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
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.Uo != null) {
      this.Uo.g(paramContext, paramInt);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/AppCompatEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */