package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.widget.av;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

public class AppCompatEditText
  extends EditText
  implements android.support.v4.view.ab
{
  private final ab a = new ab(this);
  private final az b;
  
  public AppCompatEditText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968874);
  }
  
  public AppCompatEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(hc.a(paramContext), paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
    this.b = new az(this);
    this.b.a(paramAttributeSet, paramInt);
    this.b.a();
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = this.a;
    if (localObject != null) {
      ((ab)localObject).d();
    }
    localObject = this.b;
    if (localObject != null) {
      ((az)localObject).a();
    }
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    ab localab = this.a;
    if (localab != null) {
      return localab.b();
    }
    return null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    ab localab = this.a;
    if (localab != null) {
      return localab.c();
    }
    return null;
  }
  
  public Editable getText()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return super.getText();
    }
    return super.getEditableText();
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return ak.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    paramDrawable = this.a;
    if (paramDrawable != null) {
      paramDrawable.a();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    ab localab = this.a;
    if (localab != null) {
      localab.a(paramInt);
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(av.a(this, paramCallback));
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    ab localab = this.a;
    if (localab != null) {
      localab.a(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    ab localab = this.a;
    if (localab != null) {
      localab.a(paramMode);
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    az localaz = this.b;
    if (localaz != null) {
      localaz.a(paramContext, paramInt);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/AppCompatEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */