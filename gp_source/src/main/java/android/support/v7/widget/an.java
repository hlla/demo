package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v7.b.a.a;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

public final class an
  extends MultiAutoCompleteTextView
  implements android.support.v4.view.ab
{
  private static final int[] a = { 16843126 };
  private final ab b;
  private final az c;
  
  public an(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  private an(Context paramContext, AttributeSet paramAttributeSet, byte paramByte)
  {
    super(hc.a(paramContext), paramAttributeSet, 2130968644);
    paramContext = hf.a(getContext(), paramAttributeSet, a, 2130968644, 0);
    if (paramContext.g(0)) {
      setDropDownBackgroundDrawable(paramContext.a(0));
    }
    paramContext.c.recycle();
    this.b = new ab(this);
    this.b.a(paramAttributeSet, 2130968644);
    this.c = new az(this);
    this.c.a(paramAttributeSet, 2130968644);
    this.c.a();
  }
  
  protected final void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = this.b;
    if (localObject != null) {
      ((ab)localObject).d();
    }
    localObject = this.c;
    if (localObject != null) {
      ((az)localObject).a();
    }
  }
  
  public final ColorStateList getSupportBackgroundTintList()
  {
    ab localab = this.b;
    if (localab != null) {
      return localab.b();
    }
    return null;
  }
  
  public final PorterDuff.Mode getSupportBackgroundTintMode()
  {
    ab localab = this.b;
    if (localab != null) {
      return localab.c();
    }
    return null;
  }
  
  public final InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return ak.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    paramDrawable = this.b;
    if (paramDrawable != null) {
      paramDrawable.a();
    }
  }
  
  public final void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    ab localab = this.b;
    if (localab != null) {
      localab.a(paramInt);
    }
  }
  
  public final void setDropDownBackgroundResource(int paramInt)
  {
    setDropDownBackgroundDrawable(a.b(getContext(), paramInt));
  }
  
  public final void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    ab localab = this.b;
    if (localab != null) {
      localab.a(paramColorStateList);
    }
  }
  
  public final void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    ab localab = this.b;
    if (localab != null) {
      localab.a(paramMode);
    }
  }
  
  public final void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    az localaz = this.c;
    if (localaz != null) {
      localaz.a(paramContext, paramInt);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */