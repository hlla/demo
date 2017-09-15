package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.h;

public class AlphabetScrollBar
  extends VerticalScrollBar
{
  public AlphabetScrollBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(3369401843712L, 25104);
    GMTrace.o(3369401843712L, 25104);
  }
  
  protected final int aES()
  {
    GMTrace.i(3369536061440L, 25105);
    int i = a.h.don;
    GMTrace.o(3369536061440L, 25105);
    return i;
  }
  
  public void aet()
  {
    GMTrace.i(3369267625984L, 25103);
    this.mRV = new String[] { "↑", "☆", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
    this.mRT = 1.3F;
    this.mRU = 79;
    GMTrace.o(3369267625984L, 25103);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/AlphabetScrollBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */