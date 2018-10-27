package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.av;
import android.support.v7.b.a.a;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;

public class aa
  extends AutoCompleteTextView
  implements android.support.v4.view.ab
{
  private static final int[] a = { 16843126 };
  private final ab b;
  private final az c;
  
  public aa(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public aa(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968644);
  }
  
  public aa(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(hc.a(paramContext), paramAttributeSet, paramInt);
    paramContext = hf.a(getContext(), paramAttributeSet, a, paramInt, 0);
    if (paramContext.g(0)) {
      setDropDownBackgroundDrawable(paramContext.a(0));
    }
    paramContext.c.recycle();
    this.b = new ab(this);
    this.b.a(paramAttributeSet, paramInt);
    this.c = new az(this);
    this.c.a(paramAttributeSet, paramInt);
    this.c.a();
  }
  
  protected void drawableStateChanged()
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
  
  public ColorStateList getSupportBackgroundTintList()
  {
    ab localab = this.b;
    if (localab != null) {
      return localab.b();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    ab localab = this.b;
    if (localab != null) {
      return localab.c();
    }
    return null;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return ak.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    paramDrawable = this.b;
    if (paramDrawable != null) {
      paramDrawable.a();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    ab localab = this.b;
    if (localab != null) {
      localab.a(paramInt);
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(av.a(this, paramCallback));
  }
  
  public void setDropDownBackgroundResource(int paramInt)
  {
    setDropDownBackgroundDrawable(a.b(getContext(), paramInt));
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    ab localab = this.b;
    if (localab != null) {
      localab.a(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    ab localab = this.b;
    if (localab != null) {
      localab.a(paramMode);
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    az localaz = this.c;
    if (localaz != null) {
      localaz.a(paramContext, paramInt);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */