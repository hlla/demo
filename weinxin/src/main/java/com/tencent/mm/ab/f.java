package com.tencent.mm.ab;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.ab;

public final class f
  extends ab
{
  public f()
  {
    GMTrace.i(4500857290752L, 33534);
    GMTrace.o(4500857290752L, 33534);
  }
  
  public final boolean eX(int paramInt)
  {
    GMTrace.i(4501125726208L, 33536);
    if ((paramInt == 0) || (paramInt <= 604372991)) {}
    for (boolean bool = true;; bool = false)
    {
      v.i("MicroMsg.EmojiInfoDataTransfer", "in needTransfer, sVer = %d, result = %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      GMTrace.o(4501125726208L, 33536);
      return bool;
    }
  }
  
  public final String getTag()
  {
    GMTrace.i(4501259943936L, 33537);
    GMTrace.o(4501259943936L, 33537);
    return "MicroMsg.EmojiInfoDataTransfer";
  }
  
  public final void transfer(int paramInt)
  {
    GMTrace.i(4500991508480L, 33535);
    v.i("MicroMsg.EmojiInfoDataTransfer", "start transfer EmojiInfoStorage and EmojiGroupInfoStorage");
    v.i("MicroMsg.EmojiInfoDataTransfer", "end transfer EmojiInfoStorage and EmojiGroupInfoStorage");
    GMTrace.o(4500991508480L, 33535);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ab/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */