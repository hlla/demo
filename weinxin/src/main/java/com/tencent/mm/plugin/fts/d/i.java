package com.tencent.mm.plugin.fts.d;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.plugin.fts.d.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract interface i
{
  public abstract void QZ();
  
  public abstract void a(String paramString, ad paramad, HashSet<String> paramHashSet);
  
  public abstract void axO();
  
  public abstract LinkedList<Integer> axP();
  
  public abstract int getType();
  
  public abstract int mO(int paramInt);
  
  public abstract a mP(int paramInt);
  
  public static final class a
  {
    public int hOY;
    public List<String> iIX;
    public int mba;
    public boolean mbb;
    public int mbc;
    public boolean mbd;
    public List<com.tencent.mm.plugin.fts.a.a.i> mbe;
    public int mbf;
    
    public a()
    {
      GMTrace.i(16701248765952L, 124434);
      this.mba = Integer.MAX_VALUE;
      this.mbb = true;
      this.mbc = Integer.MAX_VALUE;
      this.mbd = false;
      this.hOY = 0;
      this.mbe = null;
      this.iIX = new LinkedList();
      this.mbf = 0;
      GMTrace.o(16701248765952L, 124434);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(i parami, String paramString);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/plugin/fts/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */