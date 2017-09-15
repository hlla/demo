package com.tencent.mm.storage;

import com.tencent.gmtrace.GMTrace;

public class aq
{
  public final boolean fFL;
  private final String fRU;
  private final String kuS;
  private final String name;
  private final String type;
  private boolean uIa;
  
  public aq()
  {
    GMTrace.i(1538000945152L, 11459);
    this.type = "";
    this.name = "";
    this.fRU = "";
    this.kuS = "";
    this.fFL = true;
    GMTrace.o(1538000945152L, 11459);
  }
  
  public aq(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(1538135162880L, 11460);
    this.type = paramString1;
    this.name = paramString2;
    this.fRU = paramString3;
    this.kuS = paramString4;
    this.fFL = paramBoolean1;
    this.uIa = paramBoolean2;
    GMTrace.o(1538135162880L, 11460);
  }
  
  public final String bLM()
  {
    GMTrace.i(1538537816064L, 11463);
    if (this.kuS == null)
    {
      GMTrace.o(1538537816064L, 11463);
      return "";
    }
    String str = this.kuS;
    GMTrace.o(1538537816064L, 11463);
    return str;
  }
  
  public final String getType()
  {
    GMTrace.i(1538269380608L, 11461);
    if (this.type == null)
    {
      GMTrace.o(1538269380608L, 11461);
      return "";
    }
    String str = this.type;
    GMTrace.o(1538269380608L, 11461);
    return str;
  }
  
  public final String tK()
  {
    GMTrace.i(1538403598336L, 11462);
    if (this.fRU == null)
    {
      GMTrace.o(1538403598336L, 11462);
      return "";
    }
    String str = this.fRU;
    GMTrace.o(1538403598336L, 11462);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */