package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class avu
  extends com.tencent.mm.bd.a
{
  public String tXF;
  public boolean tXG;
  
  public avu()
  {
    GMTrace.i(14031926591488L, 104546);
    GMTrace.o(14031926591488L, 104546);
  }
  
  public final avu OU(String paramString)
  {
    GMTrace.i(14032060809216L, 104547);
    this.tXF = paramString;
    this.tXG = true;
    GMTrace.o(14032060809216L, 104547);
    return this;
  }
  
  public final void a(a.a.a.c.a parama)
  {
    GMTrace.i(14032597680128L, 104551);
    if (this.tXG) {
      parama.e(1, this.tXF);
    }
    GMTrace.o(14032597680128L, 104551);
  }
  
  public final boolean a(a.a.a.a.a parama, com.tencent.mm.bd.a parama1, int paramInt)
  {
    GMTrace.i(14032731897856L, 104552);
    parama1 = (avu)parama1;
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      GMTrace.o(14032731897856L, 104552);
      return bool;
      parama1.OU(parama.xky.readString());
    }
  }
  
  public final int aUd()
  {
    GMTrace.i(14032329244672L, 104549);
    int i = 0;
    if (this.tXG) {
      i = a.a.a.b.b.a.f(1, this.tXF) + 0;
    }
    GMTrace.o(14032329244672L, 104549);
    return i + 0;
  }
  
  public final byte[] toByteArray()
  {
    GMTrace.i(14032463462400L, 104550);
    byte[] arrayOfByte = super.toByteArray();
    GMTrace.o(14032463462400L, 104550);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    GMTrace.i(14032195026944L, 104548);
    String str = this.tXF;
    GMTrace.o(14032195026944L, 104548);
    return str;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/avu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */