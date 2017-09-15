package com.tencent.mm.protocal.c;

import com.tencent.gmtrace.GMTrace;

public final class avt
  extends com.tencent.mm.bd.a
{
  public int tXB;
  private boolean tXC;
  public com.tencent.mm.bd.b tXD;
  public boolean tXE;
  
  public avt()
  {
    GMTrace.i(14028705366016L, 104522);
    GMTrace.o(14028705366016L, 104522);
  }
  
  private avt bHn()
  {
    GMTrace.i(14029510672384L, 104528);
    if (!this.tXC) {
      throw new a.a.a.b("Not all required fields were included (false = not included in message),  iLen:" + this.tXC);
    }
    GMTrace.o(14029510672384L, 104528);
    return this;
  }
  
  private avt yh(int paramInt)
  {
    GMTrace.i(14028839583744L, 104523);
    this.tXB = paramInt;
    this.tXC = true;
    GMTrace.o(14028839583744L, 104523);
    return this;
  }
  
  public final void a(a.a.a.c.a parama)
  {
    GMTrace.i(14029913325568L, 104531);
    parama.eO(1, this.tXB);
    if (this.tXE) {
      parama.b(2, this.tXD);
    }
    GMTrace.o(14029913325568L, 104531);
  }
  
  public final boolean a(a.a.a.a.a parama, com.tencent.mm.bd.a parama1, int paramInt)
  {
    GMTrace.i(14030047543296L, 104532);
    parama1 = (avt)parama1;
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      GMTrace.o(14030047543296L, 104532);
      return bool;
      parama1.yh(parama.xky.mL());
      continue;
      parama1.b(parama.chR());
    }
  }
  
  public final int aUd()
  {
    GMTrace.i(14029644890112L, 104529);
    int j = a.a.a.a.eL(1, this.tXB) + 0;
    int i = j;
    if (this.tXE) {
      i = j + a.a.a.a.a(2, this.tXD);
    }
    GMTrace.o(14029644890112L, 104529);
    return i + 0;
  }
  
  public final avt b(com.tencent.mm.bd.b paramb)
  {
    GMTrace.i(14029242236928L, 104526);
    if (paramb == null) {
      bb(null);
    }
    this.tXD = paramb;
    this.tXE = true;
    yh(this.tXD.sWU.length);
    GMTrace.o(14029242236928L, 104526);
    return this;
  }
  
  public final avt bb(byte[] paramArrayOfByte)
  {
    GMTrace.i(14028973801472L, 104524);
    paramArrayOfByte = com.tencent.mm.bd.b.aU(paramArrayOfByte);
    b(paramArrayOfByte);
    yh(paramArrayOfByte.sWU.length);
    GMTrace.o(14028973801472L, 104524);
    return this;
  }
  
  public final avt bc(byte[] paramArrayOfByte)
  {
    GMTrace.i(14030181761024L, 104533);
    paramArrayOfByte = new a.a.a.a.a(paramArrayOfByte, unknownTagHandler);
    for (int i = a(paramArrayOfByte);; i = a(paramArrayOfByte))
    {
      if (i <= 0)
      {
        paramArrayOfByte = bHn();
        GMTrace.o(14030181761024L, 104533);
        return paramArrayOfByte;
      }
      if (!a(paramArrayOfByte, this, i)) {
        paramArrayOfByte.chS();
      }
    }
  }
  
  public final byte[] toByteArray()
  {
    GMTrace.i(14029779107840L, 104530);
    bHn();
    byte[] arrayOfByte = super.toByteArray();
    GMTrace.o(14029779107840L, 104530);
    return arrayOfByte;
  }
  
  public final String toString()
  {
    GMTrace.i(14029376454656L, 104527);
    String str2 = new StringBuilder(String.valueOf("")).append(getClass().getName()).append("(").toString() + "iLen = " + this.tXB + "   ";
    String str1 = str2;
    if (this.tXE) {
      str1 = str2 + "Buffer = " + this.tXD + "   ";
    }
    str1 = str1 + ")";
    GMTrace.o(14029376454656L, 104527);
    return str1;
  }
  
  public final avt z(byte[] paramArrayOfByte, int paramInt)
  {
    GMTrace.i(14029108019200L, 104525);
    paramArrayOfByte = com.tencent.mm.bd.b.h(paramArrayOfByte, 0, paramInt);
    b(paramArrayOfByte);
    yh(paramArrayOfByte.sWU.length);
    GMTrace.o(14029108019200L, 104525);
    return this;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/c/avt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */