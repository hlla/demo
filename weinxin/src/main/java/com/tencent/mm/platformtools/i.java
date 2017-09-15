package com.tencent.mm.platformtools;

import android.graphics.Bitmap;
import com.tencent.gmtrace.GMTrace;

public abstract interface i
{
  public abstract void F(String paramString, boolean paramBoolean);
  
  public abstract b Nm();
  
  public abstract String Nn();
  
  public abstract String No();
  
  public abstract String Np();
  
  public abstract String Nq();
  
  public abstract boolean Nr();
  
  public abstract boolean Ns();
  
  public abstract Bitmap Nt();
  
  public abstract void Nu();
  
  public abstract Bitmap a(Bitmap paramBitmap, a parama, String paramString);
  
  public abstract void a(a parama, String paramString);
  
  public static enum a
  {
    static
    {
      GMTrace.i(473922797568L, 3531);
      ihn = new a("NET", 0);
      iho = new a("DISK", 1);
      ihp = new a[] { ihn, iho };
      GMTrace.o(473922797568L, 3531);
    }
    
    private a()
    {
      GMTrace.i(473788579840L, 3530);
      GMTrace.o(473788579840L, 3530);
    }
  }
  
  public static abstract interface b
  {
    public abstract Bitmap mt(String paramString);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/platformtools/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */