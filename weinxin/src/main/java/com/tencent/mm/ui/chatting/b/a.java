package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.ui.chatting.c.c;

public final class a
{
  public static abstract interface a
    extends c<a.b>
  {
    public abstract void Bc(int paramInt);
    
    public abstract String Oi();
    
    public abstract RecyclerView.a ak(String paramString, long paramLong);
    
    public abstract <T extends RecyclerView.a> T bWi();
    
    public abstract int bWj();
    
    public abstract void bWk();
    
    public abstract void bWl();
    
    public abstract boolean bWm();
    
    public abstract void bWn();
    
    public abstract <T extends RecyclerView.h> T eW(Context paramContext);
    
    public abstract RecyclerView.g eX(Context paramContext);
    
    public abstract void onResume();
    
    public abstract void r(boolean paramBoolean, int paramInt);
  }
  
  public static abstract interface b
    extends com.tencent.mm.ui.chatting.e.a<a.a>
  {
    public abstract void Bd(int paramInt);
    
    public abstract void Be(int paramInt);
    
    public abstract void bWl();
    
    public abstract void bWn();
    
    public abstract void bWo();
    
    public abstract void bWp();
    
    public abstract boolean bWq();
    
    public abstract View getChildAt(int paramInt);
    
    public abstract void ln(boolean paramBoolean);
    
    public abstract void s(boolean paramBoolean, int paramInt);
  }
  
  public static enum c
  {
    static
    {
      GMTrace.i(14956284084224L, 111433);
      vNQ = 1;
      vNR = new int[] { vNQ };
      GMTrace.o(14956284084224L, 111433);
    }
    
    public static int[] bWr()
    {
      GMTrace.i(14956149866496L, 111432);
      int[] arrayOfInt = (int[])vNR.clone();
      GMTrace.o(14956149866496L, 111432);
      return arrayOfInt;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/chatting/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */