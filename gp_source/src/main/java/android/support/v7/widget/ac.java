package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.av;
import android.support.v7.b.a.a;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

public final class ac
  extends CheckedTextView
{
  private static final int[] a = { 16843016 };
  private final az b = new az(this);
  
  public ac(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  private ac(Context paramContext, AttributeSet paramAttributeSet, byte paramByte)
  {
    super(hc.a(paramContext), paramAttributeSet, 16843720);
    this.b.a(paramAttributeSet, 16843720);
    this.b.a();
    paramContext = hf.a(getContext(), paramAttributeSet, a, 16843720, 0);
    setCheckMarkDrawable(paramContext.a(0));
    paramContext.c.recycle();
  }
  
  protected final void drawableStateChanged()
  {
    super.drawableStateChanged();
    az localaz = this.b;
    if (localaz != null) {
      localaz.a();
    }
  }
  
  public final InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    return ak.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this);
  }
  
  public final void setCheckMarkDrawable(int paramInt)
  {
    setCheckMarkDrawable(a.b(getContext(), paramInt));
  }
  
  public final void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(av.a(this, paramCallback));
  }
  
  public final void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    az localaz = this.b;
    if (localaz != null) {
      localaz.a(paramContext, paramInt);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */