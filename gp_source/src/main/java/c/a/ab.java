package c.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public final class ab
  extends aa
  implements Externalizable
{
  public final void clear()
  {
    super.clear();
    long[] arrayOfLong = this.d;
    byte[] arrayOfByte = this.f;
    int j;
    for (int i = arrayOfLong.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      arrayOfLong[j] = 0L;
      arrayOfByte[j] = 0;
    }
  }
  
  protected final void d(int paramInt)
  {
    long[] arrayOfLong = this.d;
    int i = arrayOfLong.length;
    byte[] arrayOfByte = this.f;
    this.d = new long[paramInt];
    this.f = new byte[paramInt];
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt <= 0) {
        break;
      }
      if (arrayOfByte[i] == 1)
      {
        long l = arrayOfLong[i];
        paramInt = c(l);
        this.d[paramInt] = l;
        this.f[paramInt] = 1;
        paramInt = i;
      }
      else
      {
        paramInt = i;
      }
    }
  }
  
  public final boolean e(long paramLong)
  {
    boolean bool = false;
    int i = c(paramLong);
    if (i >= 0)
    {
      byte[] arrayOfByte = this.f;
      int j = arrayOfByte[i];
      this.d[i] = paramLong;
      arrayOfByte[i] = 1;
      if (j == 0) {
        bool = true;
      }
      a(bool);
      return true;
    }
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof ab))
    {
      paramObject = (ab)paramObject;
      bool1 = bool2;
      if (((d)paramObject).size() == size()) {
        bool1 = a(new ac((ab)paramObject));
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    ad localad = new ad(this);
    a(localad);
    return localad.a;
  }
  
  public final void readExternal(ObjectInput paramObjectInput)
  {
    paramObjectInput.readByte();
    int i = paramObjectInput.readInt();
    c(i);
    while (i > 0)
    {
      e(paramObjectInput.readLong());
      i -= 1;
    }
  }
  
  public final void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeByte(0);
    paramObjectOutput.writeInt(this.b);
    paramObjectOutput = new c(paramObjectOutput);
    if (!a(paramObjectOutput)) {
      throw paramObjectOutput.a;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/c/a/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */