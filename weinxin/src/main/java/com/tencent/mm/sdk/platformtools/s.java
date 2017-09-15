package com.tencent.mm.sdk.platformtools;

import com.tencent.gmtrace.GMTrace;
import java.nio.ByteBuffer;

public final class s
{
  private ByteBuffer uqR;
  private boolean uqS;
  
  public s()
  {
    GMTrace.i(13911130636288L, 103646);
    GMTrace.o(13911130636288L, 103646);
  }
  
  private int yn(int paramInt)
  {
    GMTrace.i(13912472813568L, 103656);
    if (this.uqR.limit() - this.uqR.position() > paramInt)
    {
      GMTrace.o(13912472813568L, 103656);
      return 0;
    }
    ByteBuffer localByteBuffer = ByteBuffer.allocate(this.uqR.limit() + 4096);
    localByteBuffer.put(this.uqR.array(), 0, this.uqR.position());
    this.uqR = localByteBuffer;
    GMTrace.o(13912472813568L, 103656);
    return 0;
  }
  
  public final int Pl(String paramString)
  {
    GMTrace.i(13913009684480L, 103660);
    if (!this.uqS) {
      throw new Exception("Buffer For Parse");
    }
    byte[] arrayOfByte = null;
    if (paramString != null) {
      arrayOfByte = paramString.getBytes();
    }
    paramString = arrayOfByte;
    if (arrayOfByte == null) {
      paramString = new byte[0];
    }
    if (paramString.length > 2048) {
      throw new Exception("Buffer String Length Error");
    }
    yn(paramString.length + 2);
    this.uqR.putShort((short)paramString.length);
    if (paramString.length > 0) {
      this.uqR.put(paramString);
    }
    GMTrace.o(13913009684480L, 103660);
    return 0;
  }
  
  public final void bIv()
  {
    GMTrace.i(13912070160384L, 103653);
    if (this.uqS) {
      throw new Exception("Buffer For Build");
    }
    int i = this.uqR.getShort();
    if (i > 2048)
    {
      this.uqR = null;
      throw new Exception("Buffer String Length Error");
    }
    if (i == 0)
    {
      GMTrace.o(13912070160384L, 103653);
      return;
    }
    this.uqR.position(i + this.uqR.position());
    GMTrace.o(13912070160384L, 103653);
  }
  
  public final boolean bIw()
  {
    GMTrace.i(13912204378112L, 103654);
    if (this.uqR.limit() - this.uqR.position() <= 1)
    {
      GMTrace.o(13912204378112L, 103654);
      return true;
    }
    GMTrace.o(13912204378112L, 103654);
    return false;
  }
  
  public final int bIx()
  {
    GMTrace.i(13912338595840L, 103655);
    this.uqR = ByteBuffer.allocate(4096);
    this.uqR.put((byte)123);
    this.uqS = true;
    GMTrace.o(13912338595840L, 103655);
    return 0;
  }
  
  public final byte[] bIy()
  {
    GMTrace.i(13913143902208L, 103661);
    if (!this.uqS) {
      throw new Exception("Buffer For Parse");
    }
    yn(1);
    this.uqR.put((byte)125);
    byte[] arrayOfByte = new byte[this.uqR.position()];
    System.arraycopy(this.uqR.array(), 0, arrayOfByte, 0, arrayOfByte.length);
    GMTrace.o(13913143902208L, 103661);
    return arrayOfByte;
  }
  
  public final int bh(byte[] paramArrayOfByte)
  {
    GMTrace.i(13911264854016L, 103647);
    int i;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      i = -1;
    }
    while (i != 0)
    {
      this.uqR = null;
      GMTrace.o(13911264854016L, 103647);
      return -1;
      if (paramArrayOfByte[0] != 123) {
        i = -2;
      } else if (paramArrayOfByte[(paramArrayOfByte.length - 1)] != 125) {
        i = -3;
      } else {
        i = 0;
      }
    }
    this.uqR = ByteBuffer.wrap(paramArrayOfByte);
    this.uqR.position(1);
    this.uqS = false;
    GMTrace.o(13911264854016L, 103647);
    return 0;
  }
  
  public final int bi(byte[] paramArrayOfByte)
  {
    GMTrace.i(13912875466752L, 103659);
    if (!this.uqS) {
      throw new Exception("Buffer For Parse");
    }
    byte[] arrayOfByte = null;
    if (paramArrayOfByte != null) {
      arrayOfByte = paramArrayOfByte;
    }
    paramArrayOfByte = arrayOfByte;
    if (arrayOfByte == null) {
      paramArrayOfByte = new byte[0];
    }
    if (paramArrayOfByte.length > 2048) {
      throw new Exception("Buffer String Length Error");
    }
    yn(paramArrayOfByte.length + 2);
    this.uqR.putShort((short)paramArrayOfByte.length);
    if (paramArrayOfByte.length > 0) {
      this.uqR.put(paramArrayOfByte);
    }
    GMTrace.o(13912875466752L, 103659);
    return 0;
  }
  
  public final int es(long paramLong)
  {
    GMTrace.i(13912741249024L, 103658);
    if (!this.uqS) {
      throw new Exception("Buffer For Parse");
    }
    yn(8);
    this.uqR.putLong(paramLong);
    GMTrace.o(13912741249024L, 103658);
    return 0;
  }
  
  public final byte[] getBuffer()
  {
    GMTrace.i(13911667507200L, 103650);
    if (this.uqS) {
      throw new Exception("Buffer For Build");
    }
    int i = this.uqR.getShort();
    if (i > 2048)
    {
      this.uqR = null;
      throw new Exception("Buffer String Length Error");
    }
    if (i == 0)
    {
      GMTrace.o(13911667507200L, 103650);
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[i];
    this.uqR.get(arrayOfByte, 0, i);
    GMTrace.o(13911667507200L, 103650);
    return arrayOfByte;
  }
  
  public final int getInt()
  {
    GMTrace.i(13911399071744L, 103648);
    if (this.uqS) {
      throw new Exception("Buffer For Build");
    }
    int i = this.uqR.getInt();
    GMTrace.o(13911399071744L, 103648);
    return i;
  }
  
  public final long getLong()
  {
    GMTrace.i(13911533289472L, 103649);
    if (this.uqS) {
      throw new Exception("Buffer For Build");
    }
    long l = this.uqR.getLong();
    GMTrace.o(13911533289472L, 103649);
    return l;
  }
  
  public final String getString()
  {
    GMTrace.i(13911801724928L, 103651);
    if (this.uqS) {
      throw new Exception("Buffer For Build");
    }
    int i = this.uqR.getShort();
    if (i > 2048)
    {
      this.uqR = null;
      throw new Exception("Buffer String Length Error");
    }
    if (i == 0)
    {
      GMTrace.o(13911801724928L, 103651);
      return "";
    }
    Object localObject = new byte[i];
    this.uqR.get((byte[])localObject, 0, i);
    localObject = new String((byte[])localObject, "UTF-8");
    GMTrace.o(13911801724928L, 103651);
    return (String)localObject;
  }
  
  public final void ym(int paramInt)
  {
    GMTrace.i(13911935942656L, 103652);
    this.uqR.position(this.uqR.position() + paramInt);
    GMTrace.o(13911935942656L, 103652);
  }
  
  public final int yo(int paramInt)
  {
    GMTrace.i(13912607031296L, 103657);
    if (!this.uqS) {
      throw new Exception("Buffer For Parse");
    }
    yn(4);
    this.uqR.putInt(paramInt);
    GMTrace.o(13912607031296L, 103657);
    return 0;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/sdk/platformtools/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */