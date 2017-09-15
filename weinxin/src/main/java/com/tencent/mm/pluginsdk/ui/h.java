package com.tencent.mm.pluginsdk.ui;

import com.tencent.gmtrace.GMTrace;

public abstract interface h
{
  public abstract void KF();
  
  public abstract void KG();
  
  public abstract int KJ();
  
  public abstract boolean N(float paramFloat);
  
  public abstract void Uq();
  
  public abstract int Ur();
  
  public abstract int Us();
  
  public abstract int Ut();
  
  public abstract boolean Uu();
  
  public abstract void Uv();
  
  public abstract void a(g paramg);
  
  public abstract void a(d paramd);
  
  public abstract void b(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract void bQ(boolean paramBoolean);
  
  public abstract boolean hQ(int paramInt);
  
  public abstract boolean isPlaying();
  
  public abstract boolean pause();
  
  public abstract void start();
  
  public abstract void stop();
  
  public abstract boolean w(int paramInt, boolean paramBoolean);
  
  public static abstract interface a
  {
    public abstract void K(String paramString, boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void TZ();
    
    public abstract void Ua();
    
    public abstract void Ub();
    
    public abstract void Uc();
    
    public abstract void bp(int paramInt1, int paramInt2);
    
    public abstract void onError(int paramInt1, int paramInt2);
  }
  
  public static abstract interface c
  {
    public abstract void A(int paramInt, String paramString);
    
    public abstract void a(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean);
  }
  
  public static enum d
  {
    static
    {
      GMTrace.i(17470182129664L, 130163);
      sHp = new d("DEFAULT", 0);
      sHq = new d("FILL", 1);
      sHr = new d("CONTAIN", 2);
      sHs = new d("COVER", 3);
      sHt = new d[] { sHp, sHq, sHr, sHs };
      GMTrace.o(17470182129664L, 130163);
    }
    
    private d()
    {
      GMTrace.i(17470047911936L, 130162);
      GMTrace.o(17470047911936L, 130162);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */