package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.av;
import android.support.v4.widget.d;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;

public class AppCompatButton
  extends Button
  implements android.support.v4.view.ab, d
{
  private final ab b = new ab(this);
  private final az c;
  
  public AppCompatButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968715);
  }
  
  public AppCompatButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(hc.a(paramContext), paramAttributeSet, paramInt);
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
  
  public int getAutoSizeMaxTextSize()
  {
    if (a) {
      return super.getAutoSizeMaxTextSize();
    }
    az localaz = this.c;
    if (localaz != null) {
      return Math.round(localaz.b.a);
    }
    return -1;
  }
  
  public int getAutoSizeMinTextSize()
  {
    if (a) {
      return super.getAutoSizeMinTextSize();
    }
    az localaz = this.c;
    if (localaz != null) {
      return Math.round(localaz.b.b);
    }
    return -1;
  }
  
  public int getAutoSizeStepGranularity()
  {
    if (a) {
      return super.getAutoSizeStepGranularity();
    }
    az localaz = this.c;
    if (localaz != null) {
      return Math.round(localaz.b.c);
    }
    return -1;
  }
  
  public int[] getAutoSizeTextAvailableSizes()
  {
    if (a) {
      return super.getAutoSizeTextAvailableSizes();
    }
    az localaz = this.c;
    if (localaz == null) {
      return new int[0];
    }
    return localaz.b.d;
  }
  
  public int getAutoSizeTextType()
  {
    if (a)
    {
      if (super.getAutoSizeTextType() == 1) {
        return 1;
      }
      return 0;
    }
    az localaz = this.c;
    if (localaz != null) {
      return localaz.b.e;
    }
    return 0;
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
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Button.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(Button.class.getName());
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    az localaz = this.c;
    if (localaz != null) {
      localaz.b();
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if ((this.c != null) && (!a) && (this.c.b.d())) {
      this.c.b.c();
    }
  }
  
  public void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (a) {
      super.setAutoSizeTextTypeUniformWithConfiguration(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    az localaz;
    do
    {
      return;
      localaz = this.c;
    } while (localaz == null);
    localaz.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
  {
    if (a) {
      super.setAutoSizeTextTypeUniformWithPresetSizes(paramArrayOfInt, paramInt);
    }
    az localaz;
    do
    {
      return;
      localaz = this.c;
    } while (localaz == null);
    localaz.a(paramArrayOfInt, paramInt);
  }
  
  public void setAutoSizeTextTypeWithDefaults(int paramInt)
  {
    if (a) {
      super.setAutoSizeTextTypeWithDefaults(paramInt);
    }
    az localaz;
    do
    {
      return;
      localaz = this.c;
    } while (localaz == null);
    localaz.a(paramInt);
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
  
  public void setSupportAllCaps(boolean paramBoolean)
  {
    az localaz = this.c;
    if (localaz != null) {
      localaz.a(paramBoolean);
    }
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
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    if (a) {
      super.setTextSize(paramInt, paramFloat);
    }
    az localaz;
    do
    {
      return;
      localaz = this.c;
    } while (localaz == null);
    localaz.a(paramInt, paramFloat);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/AppCompatButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */