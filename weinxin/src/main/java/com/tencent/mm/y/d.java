package com.tencent.mm.y;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.storage.au;
import java.util.HashMap;

public abstract interface d
{
  public abstract b b(a parama);
  
  public abstract void h(au paramau);
  
  public static final class a
  {
    public bu hsc;
    public boolean hsd;
    public boolean hse;
    public boolean hsf;
    
    public a(bu parambu, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      GMTrace.i(13242994786304L, 98668);
      this.hsd = false;
      this.hse = false;
      this.hsf = false;
      this.hsc = parambu;
      this.hsd = paramBoolean1;
      this.hse = paramBoolean2;
      this.hsf = paramBoolean3;
      GMTrace.o(13242994786304L, 98668);
    }
    
    public final String toString()
    {
      GMTrace.i(13243129004032L, 98669);
      String str = String.format("AddMsgInfo(%d), get[%b], fault[%b], up[%b]", new Object[] { Integer.valueOf(hashCode()), Boolean.valueOf(this.hsd), Boolean.valueOf(this.hse), Boolean.valueOf(this.hsf) });
      GMTrace.o(13243129004032L, 98669);
      return str;
    }
  }
  
  public static final class b
  {
    public au fCQ;
    public boolean hsg;
    
    public b(au paramau, boolean paramBoolean)
    {
      GMTrace.i(13242592133120L, 98665);
      this.fCQ = paramau;
      this.hsg = paramBoolean;
      GMTrace.o(13242592133120L, 98665);
    }
  }
  
  public static final class c
  {
    private static HashMap<Object, d> hsh;
    
    static
    {
      GMTrace.i(13242457915392L, 98664);
      hsh = new HashMap();
      GMTrace.o(13242457915392L, 98664);
    }
    
    public static void a(Object paramObject, d paramd)
    {
      GMTrace.i(13242055262208L, 98661);
      hsh.put(paramObject, paramd);
      GMTrace.o(13242055262208L, 98661);
    }
    
    public static void aA(Object paramObject)
    {
      GMTrace.i(13242189479936L, 98662);
      hsh.remove(paramObject);
      GMTrace.o(13242189479936L, 98662);
    }
    
    public static d aB(Object paramObject)
    {
      GMTrace.i(13242323697664L, 98663);
      paramObject = (d)hsh.get(paramObject);
      GMTrace.o(13242323697664L, 98663);
      return (d)paramObject;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/y/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */