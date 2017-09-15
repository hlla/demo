package com.tencent.mm.ui.chatting;

import com.tencent.gmtrace.GMTrace;

public abstract interface dx
{
  public abstract void a(a parama);
  
  public abstract void b(a parama);
  
  public abstract void bUu();
  
  public abstract boolean bUv();
  
  public static enum a
  {
    static
    {
      GMTrace.i(2501281579008L, 18636);
      vLq = new a("del", 0);
      vLr = new a("trans", 1);
      vLs = new a("fav", 2);
      vLt = new a[] { vLq, vLr, vLs };
      GMTrace.o(2501281579008L, 18636);
    }
    
    private a()
    {
      GMTrace.i(14965679325184L, 111503);
      GMTrace.o(14965679325184L, 111503);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */