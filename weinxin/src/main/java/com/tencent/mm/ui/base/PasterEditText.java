package com.tencent.mm.ui.base;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.gmtrace.GMTrace;

public class PasterEditText
  extends EditText
{
  private Context context;
  private ClipboardManager qzR;
  private int qzS;
  
  public PasterEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(13092670930944L, 97548);
    this.qzR = null;
    this.qzS = 0;
    this.context = paramContext;
    init();
    GMTrace.o(13092670930944L, 97548);
  }
  
  public PasterEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(13092805148672L, 97549);
    this.qzR = null;
    this.qzS = 0;
    init();
    GMTrace.o(13092805148672L, 97549);
  }
  
  private void init()
  {
    GMTrace.i(13093073584128L, 97551);
    this.qzR = ((ClipboardManager)this.context.getSystemService("clipboard"));
    GMTrace.o(13093073584128L, 97551);
  }
  
  public int bkb()
  {
    GMTrace.i(13092939366400L, 97550);
    int i = this.qzS;
    GMTrace.o(13092939366400L, 97550);
    return i;
  }
  
  public boolean onTextContextMenuItem(int paramInt)
  {
    GMTrace.i(13093207801856L, 97552);
    if (paramInt == 16908322) {
      if ((this.qzR != null) && (this.qzR.getText() != null) && ((this.qzR.getText() instanceof String)) && (this.qzR.getText() != null) && (this.qzR.getText().length() > 0)) {
        this.qzS += this.qzR.getText().length();
      }
    }
    for (boolean bool = super.onTextContextMenuItem(paramInt);; bool = super.onTextContextMenuItem(paramInt))
    {
      GMTrace.o(13093207801856L, 97552);
      return bool;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/PasterEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */