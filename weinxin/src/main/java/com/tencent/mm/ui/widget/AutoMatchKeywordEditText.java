package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.widget.EditText;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public class AutoMatchKeywordEditText
  extends MMEditText
{
  public a wqg;
  private int wqh;
  private int wqi;
  
  public AutoMatchKeywordEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1637858934784L, 12203);
    init();
    GMTrace.o(1637858934784L, 12203);
  }
  
  public AutoMatchKeywordEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1637724717056L, 12202);
    init();
    GMTrace.o(1637724717056L, 12202);
  }
  
  private void init()
  {
    GMTrace.i(1637993152512L, 12204);
    this.wqh = getSelectionStart();
    this.wqi = getSelectionEnd();
    GMTrace.o(1637993152512L, 12204);
  }
  
  public void extendSelection(int paramInt)
  {
    GMTrace.i(1638530023424L, 12208);
    v.d("MicroMsg.AutoMatchKeywordEditText", "extendSelection");
    super.extendSelection(paramInt);
    this.wqh = getSelectionStart();
    this.wqi = getSelectionEnd();
    GMTrace.o(1638530023424L, 12208);
  }
  
  public boolean moveCursorToVisibleOffset()
  {
    GMTrace.i(1638664241152L, 12209);
    v.d("MicroMsg.AutoMatchKeywordEditText", "moveCursorToVisibleOffset");
    boolean bool = super.moveCursorToVisibleOffset();
    GMTrace.o(1638664241152L, 12209);
    return bool;
  }
  
  public boolean onDragEvent(DragEvent paramDragEvent)
  {
    GMTrace.i(1638932676608L, 12211);
    v.d("MicroMsg.AutoMatchKeywordEditText", "onDragEvent");
    boolean bool = super.onDragEvent(paramDragEvent);
    GMTrace.o(1638932676608L, 12211);
    return bool;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    GMTrace.i(1638127370240L, 12205);
    super.onDraw(paramCanvas);
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if ((this.wqh != i) || (this.wqi != j))
    {
      this.wqh = i;
      this.wqi = j;
      if (this.wqg != null) {
        this.wqg.a(this, getSelectionStart(), getSelectionEnd());
      }
    }
    GMTrace.o(1638127370240L, 12205);
  }
  
  public boolean performAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    GMTrace.i(1638798458880L, 12210);
    v.d("MicroMsg.AutoMatchKeywordEditText", "performAccessibilityAction");
    boolean bool = super.performAccessibilityAction(paramInt, paramBundle);
    GMTrace.o(1638798458880L, 12210);
    return bool;
  }
  
  public void setSelection(int paramInt)
  {
    GMTrace.i(1638261587968L, 12206);
    v.d("MicroMsg.AutoMatchKeywordEditText", "setSelection");
    int i = getSelectionStart();
    int j = getSelectionEnd();
    super.setSelection(paramInt);
    this.wqh = getSelectionStart();
    this.wqi = getSelectionEnd();
    if (((i != getSelectionStart()) || (j != getSelectionEnd())) && (this.wqg != null)) {
      this.wqg.a(this, getSelectionStart(), getSelectionEnd());
    }
    GMTrace.o(1638261587968L, 12206);
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    GMTrace.i(1638395805696L, 12207);
    v.d("MicroMsg.AutoMatchKeywordEditText", "setSelection.");
    int i = getSelectionStart();
    int j = getSelectionEnd();
    super.setSelection(paramInt1, paramInt2);
    this.wqh = getSelectionStart();
    this.wqi = getSelectionEnd();
    if (((i != getSelectionStart()) || (j != getSelectionEnd())) && (this.wqg != null)) {
      this.wqg.a(this, getSelectionStart(), getSelectionEnd());
    }
    GMTrace.o(1638395805696L, 12207);
  }
  
  public static abstract interface a
  {
    public abstract void a(EditText paramEditText, int paramInt1, int paramInt2);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/widget/AutoMatchKeywordEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */