package com.tencent.mm.pluginsdk.ui.emoji;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.gmtrace.GMTrace;

public class PreViewEmojiView
  extends MMEmojiView
{
  public int hP;
  
  public PreViewEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1198295875584L, 8928);
    this.hP = 0;
    GMTrace.o(1198295875584L, 8928);
  }
  
  public PreViewEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1198430093312L, 8929);
    this.hP = 0;
    GMTrace.o(1198430093312L, 8929);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    GMTrace.i(1198564311040L, 8930);
    super.onMeasure(paramInt1, paramInt2);
    if (this.hP > 0) {
      setMeasuredDimension(this.hP, this.hP);
    }
    GMTrace.o(1198564311040L, 8930);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/emoji/PreViewEmojiView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */