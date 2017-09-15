package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CheckedTextView;

public class AppCompatCheckedTextView
  extends CheckedTextView
{
  private static final int[] PZ = { 16843016 };
  private h Um;
  private l Uo = l.d(this);
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16843720);
  }
  
  public AppCompatCheckedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(am.p(paramContext), paramAttributeSet, paramInt);
    this.Uo.a(paramAttributeSet, paramInt);
    this.Uo.eB();
    this.Um = h.ey();
    paramContext = ap.a(getContext(), paramAttributeSet, PZ, paramInt);
    setCheckMarkDrawable(paramContext.getDrawable(0));
    paramContext.aeG.recycle();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.Uo != null) {
      this.Uo.eB();
    }
  }
  
  public void setCheckMarkDrawable(int paramInt)
  {
    if (this.Um != null)
    {
      setCheckMarkDrawable(this.Um.a(getContext(), paramInt, false));
      return;
    }
    super.setCheckMarkDrawable(paramInt);
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.Uo != null) {
      this.Uo.g(paramContext, paramInt);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/AppCompatCheckedTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */