package com.tencent.mm.bd;

import com.tencent.gmtrace.GMTrace;
import java.io.OutputStream;

public class a
{
  protected static final int OPCODE_COMPUTESIZE = 1;
  protected static final int OPCODE_PARSEFROM = 2;
  protected static final int OPCODE_POPULATEBUILDERWITHFIELD = 3;
  protected static final int OPCODE_WRITEFIELDS = 0;
  public static a.a.a.a.a.b unknownTagHandler;
  
  static
  {
    GMTrace.i(14026021011456L, 104502);
    unknownTagHandler = new a.a.a.a.a.a();
    GMTrace.o(14026021011456L, 104502);
  }
  
  public a()
  {
    GMTrace.i(14026155229184L, 104503);
    GMTrace.o(14026155229184L, 104503);
  }
  
  public static int a(a.a.a.a.a parama)
  {
    int i = 0;
    GMTrace.i(14026423664640L, 104505);
    a.a.a.b.a.a locala = parama.xky;
    if ((locala.aIi == locala.bufferSize) && (!locala.mk(false))) {
      locala.aIj = 0;
    }
    for (;;)
    {
      parama.xkz = i;
      i = a.a.a.b.a.cL(parama.xkz);
      GMTrace.o(14026423664640L, 104505);
      return i;
      locala.aIj = locala.mL();
      if (locala.aIj == 0) {
        throw a.a.a.b.a.b.chW();
      }
      i = locala.aIj;
    }
  }
  
  public int a(int paramInt, Object... paramVarArgs)
  {
    GMTrace.i(14026692100096L, 104507);
    throw new Error("Cannot use this method");
  }
  
  public void a(a.a.a.c.a parama)
  {
    GMTrace.i(14026826317824L, 104508);
    a(0, new Object[] { parama });
    GMTrace.o(14026826317824L, 104508);
  }
  
  public boolean a(a.a.a.a.a parama, a parama1, int paramInt)
  {
    GMTrace.i(14027228971008L, 104511);
    if (a(3, new Object[] { parama, parama1, Integer.valueOf(paramInt) }) == 0)
    {
      GMTrace.o(14027228971008L, 104511);
      return true;
    }
    GMTrace.o(14027228971008L, 104511);
    return false;
  }
  
  public a aD(byte[] paramArrayOfByte)
  {
    GMTrace.i(14027094753280L, 104510);
    a(2, new Object[] { paramArrayOfByte });
    GMTrace.o(14027094753280L, 104510);
    return this;
  }
  
  public int aUd()
  {
    GMTrace.i(14026960535552L, 104509);
    try
    {
      int i = a(1, new Object[0]);
      GMTrace.o(14026960535552L, 104509);
      return i;
    }
    catch (Exception localException)
    {
      GMTrace.o(14026960535552L, 104509);
    }
    return 0;
  }
  
  public a aUe()
  {
    GMTrace.i(14026557882368L, 104506);
    GMTrace.o(14026557882368L, 104506);
    return this;
  }
  
  public byte[] toByteArray()
  {
    GMTrace.i(14026289446912L, 104504);
    aUe();
    byte[] arrayOfByte = new byte[aUd()];
    a.a.a.c.a locala = new a.a.a.c.a(arrayOfByte);
    a(locala);
    if (locala.hrr != null)
    {
      locala.hrr.write(locala.xkE);
      locala.hrr.flush();
    }
    GMTrace.o(14026289446912L, 104504);
    return arrayOfByte;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bd/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */