package a.a.a.a;

import java.util.LinkedList;

public final class a
{
  private final a.a.a.a.a.b unknownTagHandler;
  public final a.a.a.b.a.a xky;
  public int xkz = 0;
  
  public a(byte[] paramArrayOfByte, a.a.a.a.a.b paramb)
  {
    this.xky = new a.a.a.b.a.a(paramArrayOfByte, paramArrayOfByte.length);
    this.unknownTagHandler = paramb;
  }
  
  public final LinkedList<byte[]> Eg(int paramInt)
  {
    return this.xky.Eg(paramInt);
  }
  
  public final int chN()
  {
    return this.xky.mL();
  }
  
  public final LinkedList<Integer> chO()
  {
    a.a.a.b.a.a locala = this.xky;
    LinkedList localLinkedList = new LinkedList();
    for (;;)
    {
      if (locala.aIi >= locala.bufferSize) {
        return localLinkedList;
      }
      localLinkedList.add(Integer.valueOf(locala.mL()));
    }
  }
  
  public final String chP()
  {
    return this.xky.readString();
  }
  
  public final boolean chQ()
  {
    return this.xky.mL() != 0;
  }
  
  public final com.tencent.mm.bd.b chR()
  {
    a.a.a.b.a.a locala = this.xky;
    int i = locala.mL();
    if ((i < locala.bufferSize - locala.aIi) && (i > 0))
    {
      com.tencent.mm.bd.b localb = com.tencent.mm.bd.b.h(locala.buffer, locala.aIi, i);
      locala.aIi = (i + locala.aIi);
      return localb;
    }
    return com.tencent.mm.bd.b.aU(locala.cD(i));
  }
  
  public final void chS()
  {
    int i = a.a.a.b.a.cK(this.xkz);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FieldNumber: ").append(a.a.a.b.a.cL(this.xkz)).append(" - ");
    switch (i)
    {
    case 3: 
    case 4: 
    default: 
      return;
    case 5: 
      localStringBuffer.append("float value: ").append(Float.toString(this.xky.readFloat()));
      return;
    case 1: 
      localStringBuffer.append("double value: ").append(Double.toString(this.xky.readDouble()));
      return;
    case 2: 
      localStringBuffer.append("Length delimited (String or ByteString) value: ").append(this.xky.readString());
      return;
    }
    localStringBuffer.append("varint (long, int or boolean) value: ").append(this.xky.mM());
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/a/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */