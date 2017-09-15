package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.gmtrace.GMTrace;

public class RTChattingEmojiViewTo
  extends RTChattingEmojiView
{
  public RTChattingEmojiViewTo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1194000908288L, 8896);
    KD();
    GMTrace.o(1194000908288L, 8896);
  }
  
  public RTChattingEmojiViewTo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1194135126016L, 8897);
    KD();
    GMTrace.o(1194135126016L, 8897);
  }
  
  public final void KD()
  {
    GMTrace.i(1194269343744L, 8898);
    super.KD();
    this.sQf.gravity = 5;
    addView(this.sQc, this.sQf);
    GMTrace.o(1194269343744L, 8898);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/emoji/RTChattingEmojiViewTo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */