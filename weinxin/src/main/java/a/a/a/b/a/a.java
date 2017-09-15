package a.a.a.b.a;

import java.io.InputStream;
import java.util.LinkedList;

public final class a
{
  private int aIh = 0;
  public int aIi;
  public int aIj = 0;
  private int aIk = Integer.MAX_VALUE;
  private int aIn = 67108864;
  public byte[] buffer;
  public int bufferSize;
  private InputStream xkC;
  private int xkD = 0;
  
  public a(byte[] paramArrayOfByte, int paramInt)
  {
    this.buffer = paramArrayOfByte;
    this.bufferSize = (paramInt + 0);
    this.aIi = 0;
    this.xkC = null;
  }
  
  private int[] Eh(int paramInt)
  {
    int j = this.buffer[paramInt];
    int i = paramInt + 1;
    if (j >= 0) {
      return new int[] { j, i };
    }
    paramInt = j & 0x7F;
    j = this.buffer[i];
    if (j >= 0)
    {
      i += 1;
      paramInt |= j << 7;
    }
    int k;
    do
    {
      for (;;)
      {
        return new int[] { paramInt, i };
        paramInt |= (j & 0x7F) << 7;
        j = this.buffer[i];
        if (j >= 0)
        {
          i += 1;
          paramInt |= j << 14;
        }
        else
        {
          paramInt |= (j & 0x7F) << 14;
          j = this.buffer[i];
          if (j < 0) {
            break;
          }
          i += 1;
          paramInt |= j << 21;
        }
      }
      k = this.buffer[i];
      paramInt = paramInt | (j & 0x7F) << 21 | k << 28;
      j = i + 1;
      i = j;
    } while (k >= 0);
    paramInt = 0;
    for (;;)
    {
      if (paramInt >= 5) {
        throw b.chV();
      }
      if (this.buffer[j] >= 0) {
        return new int[] { k, j + 1 };
      }
      paramInt += 1;
    }
  }
  
  private void cE(int paramInt)
  {
    if (paramInt < 0) {
      throw b.chU();
    }
    if (this.xkD + this.aIi + paramInt > this.aIk)
    {
      cE(this.aIk - this.xkD - this.aIi);
      throw b.chT();
    }
    if (paramInt < this.bufferSize - this.aIi) {
      this.aIi += paramInt;
    }
    for (;;)
    {
      return;
      int i = this.bufferSize - this.aIi;
      this.xkD += i;
      this.aIi = 0;
      this.bufferSize = 0;
      while (i < paramInt)
      {
        if (this.xkC == null) {}
        for (int j = -1; j <= 0; j = (int)this.xkC.skip(paramInt - i)) {
          throw b.chT();
        }
        i += j;
        this.xkD = (j + this.xkD);
      }
    }
  }
  
  private byte mP()
  {
    if (this.aIi == this.bufferSize) {
      mk(true);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.aIi;
    this.aIi = (i + 1);
    return arrayOfByte[i];
  }
  
  public final LinkedList<byte[]> Eg(int paramInt)
  {
    LinkedList localLinkedList = new LinkedList();
    int i = mL();
    try
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(this.buffer, this.aIi, arrayOfByte, 0, i);
      localLinkedList.add(arrayOfByte);
      this.aIi = (i + this.aIi);
      i = this.aIi;
      if (this.aIi == this.bufferSize) {
        return localLinkedList;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      throw new OutOfMemoryError("alloc bytes:" + i);
    }
    Object localObject = Eh(i);
    for (i = localObject[0];; i = localObject[0])
    {
      if (a.a.a.b.a.cL(i) != paramInt) {}
      do
      {
        return localLinkedList;
        this.aIi = localObject[1];
        i = mL();
        localObject = new byte[i];
        System.arraycopy(this.buffer, this.aIi, localObject, 0, i);
        localLinkedList.add(localObject);
        this.aIi = (i + this.aIi);
      } while (this.aIi == this.bufferSize);
      localObject = Eh(this.aIi);
    }
  }
  
  public final byte[] cD(int paramInt)
  {
    if (paramInt < 0) {
      throw b.chU();
    }
    if (this.xkD + this.aIi + paramInt > this.aIk)
    {
      cE(this.aIk - this.xkD - this.aIi);
      throw b.chT();
    }
    if (paramInt <= this.bufferSize - this.aIi)
    {
      localObject = new byte[paramInt];
      System.arraycopy(this.buffer, this.aIi, localObject, 0, paramInt);
      this.aIi += paramInt;
      return (byte[])localObject;
    }
    if (paramInt < 2048)
    {
      localObject = new byte[paramInt];
      i = this.bufferSize - this.aIi;
      System.arraycopy(this.buffer, this.aIi, localObject, 0, i);
      this.aIi = this.bufferSize;
      mk(true);
      for (;;)
      {
        if (paramInt - i <= this.bufferSize)
        {
          System.arraycopy(this.buffer, 0, localObject, i, paramInt - i);
          this.aIi = (paramInt - i);
          return (byte[])localObject;
        }
        System.arraycopy(this.buffer, 0, localObject, i, this.bufferSize);
        i += this.bufferSize;
        this.aIi = this.bufferSize;
        mk(true);
      }
    }
    int m = this.aIi;
    int n = this.bufferSize;
    this.xkD += this.bufferSize;
    this.aIi = 0;
    this.bufferSize = 0;
    Object localObject = new LinkedList();
    int i = paramInt - (n - m);
    byte[] arrayOfByte1;
    if (i <= 0)
    {
      arrayOfByte1 = new byte[paramInt];
      i = n - m;
      System.arraycopy(this.buffer, m, arrayOfByte1, 0, i);
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt >= ((LinkedList)localObject).size())
      {
        return arrayOfByte1;
        arrayOfByte1 = new byte[Math.min(i, 2048)];
        int j = 0;
        for (;;)
        {
          if (j >= arrayOfByte1.length)
          {
            j = arrayOfByte1.length;
            ((LinkedList)localObject).add(arrayOfByte1);
            i -= j;
            break;
          }
          if (this.xkC == null) {}
          for (int k = -1; k == -1; k = this.xkC.read(arrayOfByte1, j, arrayOfByte1.length - j)) {
            throw b.chT();
          }
          this.xkD += k;
          j += k;
        }
      }
      byte[] arrayOfByte2 = (byte[])((LinkedList)localObject).get(paramInt);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, arrayOfByte2.length);
      i += arrayOfByte2.length;
      paramInt += 1;
    }
  }
  
  public final int mL()
  {
    int i = mP();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = mP();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = mP();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = mP();
      if (k >= 0) {
        return i | k << 21;
      }
      j = mP();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    } while (j >= 0);
    int j = 0;
    for (;;)
    {
      if (j >= 5) {
        throw b.chV();
      }
      i = k;
      if (mP() >= 0) {
        break;
      }
      j += 1;
    }
  }
  
  public final long mM()
  {
    int i = 0;
    long l = 0L;
    for (;;)
    {
      if (i >= 64) {
        throw b.chV();
      }
      int j = mP();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
  }
  
  public final boolean mk(boolean paramBoolean)
  {
    if (this.aIi < this.bufferSize) {
      throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }
    if (this.xkD + this.bufferSize == this.aIk)
    {
      if (paramBoolean) {
        throw b.chT();
      }
      return false;
    }
    this.xkD += this.bufferSize;
    this.aIi = 0;
    if (this.xkC == null) {}
    for (int i = -1;; i = this.xkC.read(this.buffer))
    {
      this.bufferSize = i;
      if (this.bufferSize != -1) {
        break label117;
      }
      this.bufferSize = 0;
      if (!paramBoolean) {
        break;
      }
      throw b.chT();
    }
    return false;
    label117:
    this.bufferSize += this.aIh;
    i = this.xkD + this.bufferSize;
    if (i > this.aIk)
    {
      this.aIh = (i - this.aIk);
      this.bufferSize -= this.aIh;
    }
    for (;;)
    {
      i = this.xkD + this.bufferSize + this.aIh;
      if ((i <= this.aIn) && (i >= 0)) {
        break;
      }
      throw b.chX();
      this.aIh = 0;
    }
    return true;
  }
  
  public final double readDouble()
  {
    int i = mP();
    int j = mP();
    int k = mP();
    int m = mP();
    int n = mP();
    int i1 = mP();
    int i2 = mP();
    int i3 = mP();
    long l = i;
    return Double.longBitsToDouble((j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56);
  }
  
  public final float readFloat()
  {
    return Float.intBitsToFloat(mP() & 0xFF | (mP() & 0xFF) << 8 | (mP() & 0xFF) << 16 | (mP() & 0xFF) << 24);
  }
  
  public final String readString()
  {
    int i = mL();
    if ((i < this.bufferSize - this.aIi) && (i > 0))
    {
      String str = new String(this.buffer, this.aIi, i, "UTF-8");
      this.aIi = (i + this.aIi);
      return str;
    }
    return new String(cD(i), "UTF-8");
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/a/a/a/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */