package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.f.b;
import android.support.v4.f.c;
import android.support.v4.widget.av;
import android.support.v4.widget.d;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class bb
  extends TextView
  implements android.support.v4.view.ab, d
{
  private final ab b = new ab(this);
  private Future c;
  private final az d;
  
  public bb(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public bb(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842884);
  }
  
  public bb(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(hc.a(paramContext), paramAttributeSet, paramInt);
    this.b.a(paramAttributeSet, paramInt);
    this.d = new az(this);
    this.d.a(paramAttributeSet, paramInt);
    this.d.a();
  }
  
  private final void a()
  {
    Future localFuture = this.c;
    if (localFuture != null) {}
    try
    {
      this.c = null;
      av.a(this, (b)localFuture.get());
      return;
    }
    catch (InterruptedException localInterruptedException) {}catch (ExecutionException localExecutionException) {}
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = this.b;
    if (localObject != null) {
      ((ab)localObject).d();
    }
    localObject = this.d;
    if (localObject != null) {
      ((az)localObject).a();
    }
  }
  
  public int getAutoSizeMaxTextSize()
  {
    if (a) {
      return super.getAutoSizeMaxTextSize();
    }
    az localaz = this.d;
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
    az localaz = this.d;
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
    az localaz = this.d;
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
    az localaz = this.d;
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
    az localaz = this.d;
    if (localaz != null) {
      return localaz.b.e;
    }
    return 0;
  }
  
  public int getFirstBaselineToTopHeight()
  {
    return getPaddingTop() - getPaint().getFontMetricsInt().top;
  }
  
  public int getLastBaselineToBottomHeight()
  {
    return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
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
  
  public CharSequence getText()
  {
    a();
    return super.getText();
  }
  
  public c getTextMetricsParamsCompat()
  {
    return av.b(this);
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return ak.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    az localaz = this.d;
    if (localaz != null) {
      localaz.b();
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    a();
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    if ((this.d != null) && (!a) && (this.d.b.d())) {
      this.d.b.c();
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
      localaz = this.d;
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
      localaz = this.d;
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
      localaz = this.d;
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
  
  public void setFirstBaselineToTopHeight(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      super.setFirstBaselineToTopHeight(paramInt);
      return;
    }
    av.b(this, paramInt);
  }
  
  public void setLastBaselineToBottomHeight(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      super.setLastBaselineToBottomHeight(paramInt);
      return;
    }
    av.c(this, paramInt);
  }
  
  public void setLineHeight(int paramInt)
  {
    av.d(this, paramInt);
  }
  
  public void setPrecomputedText(b paramb)
  {
    av.a(this, paramb);
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
    az localaz = this.d;
    if (localaz != null) {
      localaz.a(paramContext, paramInt);
    }
  }
  
  public void setTextFuture(Future paramFuture)
  {
    this.c = paramFuture;
    requestLayout();
  }
  
  public void setTextMetricsParamsCompat(c paramc)
  {
    int j = 1;
    if (Build.VERSION.SDK_INT < 18)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        getPaint().set(paramc.c);
        setBreakStrategy(paramc.a);
        setHyphenationFrequency(paramc.b);
        return;
      }
      float f = paramc.c.getTextScaleX();
      getPaint().set(paramc.c);
      if (f == getTextScaleX()) {
        setTextScaleX(f / 2.0F + 1.0F);
      }
      setTextScaleX(f);
      return;
    }
    TextDirectionHeuristic localTextDirectionHeuristic = paramc.d;
    int i = j;
    if (localTextDirectionHeuristic != TextDirectionHeuristics.FIRSTSTRONG_RTL)
    {
      i = j;
      if (localTextDirectionHeuristic != TextDirectionHeuristics.FIRSTSTRONG_LTR)
      {
        if (localTextDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
          break label201;
        }
        if (localTextDirectionHeuristic == TextDirectionHeuristics.LTR) {
          break label196;
        }
        if (localTextDirectionHeuristic == TextDirectionHeuristics.RTL) {
          break label191;
        }
        if (localTextDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
          break label186;
        }
        if (localTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
          break label180;
        }
        i = j;
        if (localTextDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
          i = 7;
        }
      }
    }
    for (;;)
    {
      setTextDirection(i);
      break;
      label180:
      i = 6;
      continue;
      label186:
      i = 5;
      continue;
      label191:
      i = 4;
      continue;
      label196:
      i = 3;
      continue;
      label201:
      i = 2;
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
      localaz = this.d;
    } while (localaz == null);
    localaz.a(paramInt, paramFloat);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */