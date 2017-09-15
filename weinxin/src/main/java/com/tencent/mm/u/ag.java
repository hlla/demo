package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;

@Deprecated
public abstract interface ag
{
  public static final class a
  {
    public static ag.b hlA;
    public static ag.e hlB;
    public static ag.c hlC;
    public static ag.f hlD;
    
    public static ag.b yI()
    {
      GMTrace.i(616864677888L, 4596);
      ag.b localb = hlA;
      GMTrace.o(616864677888L, 4596);
      return localb;
    }
  }
  
  public static abstract interface b
  {
    public abstract void J(String paramString1, String paramString2);
    
    public abstract void K(String paramString1, String paramString2);
    
    public abstract void a(String paramString1, String paramString2, a parama);
    
    public abstract void gc(String paramString);
    
    public static abstract interface a
    {
      public abstract void p(String paramString, boolean paramBoolean);
    }
  }
  
  public static abstract interface c
  {
    public abstract String eY(int paramInt);
    
    public abstract String eZ(int paramInt);
    
    public abstract boolean fa(int paramInt);
    
    public abstract String u(int paramInt, boolean paramBoolean);
    
    public abstract void yJ();
  }
  
  public static abstract interface d
  {
    public abstract void h(String paramString, long paramLong);
  }
  
  public static abstract interface e
  {
    public abstract void aH(int paramInt1, int paramInt2);
  }
  
  public static abstract interface f
  {
    public abstract boolean K(long paramLong);
    
    public abstract void a(ag.d paramd);
    
    public abstract void b(ag.d paramd);
    
    public abstract void gd(String paramString);
    
    public abstract void yK();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */