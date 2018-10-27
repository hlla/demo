package c.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;

public final class af
  extends aa
  implements Externalizable
{
  public transient Object[] e;
  
  private final boolean a(ai paramai)
  {
    boolean bool2 = true;
    byte[] arrayOfByte = this.f;
    long[] arrayOfLong = this.d;
    Object[] arrayOfObject = this.e;
    int i = arrayOfLong.length;
    for (;;)
    {
      int j = i - 1;
      boolean bool1 = bool2;
      if (i > 0)
      {
        if (arrayOfByte[j] == 1)
        {
          if (paramai.a(arrayOfLong[j], arrayOfObject[j]))
          {
            i = j;
            continue;
          }
          bool1 = false;
        }
      }
      else {
        return bool1;
      }
      i = j;
    }
  }
  
  public final Object a(long paramLong, Object paramObject)
  {
    boolean bool = true;
    int j = c(paramLong);
    Object localObject;
    if (j < 0)
    {
      j = -j - 1;
      localObject = this.e[j];
    }
    for (int i = 0;; i = 1)
    {
      byte[] arrayOfByte = this.f;
      int k = arrayOfByte[j];
      this.d[j] = paramLong;
      arrayOfByte[j] = 1;
      this.e[j] = paramObject;
      if (i != 0) {
        if (k != 0) {
          break label88;
        }
      }
      for (;;)
      {
        a(bool);
        return localObject;
        label88:
        bool = false;
      }
      localObject = null;
    }
  }
  
  protected final void b(int paramInt)
  {
    this.e[paramInt] = null;
    super.b(paramInt);
  }
  
  public final Object[] b()
  {
    Object[] arrayOfObject1 = new Object[size()];
    Object[] arrayOfObject2 = this.e;
    byte[] arrayOfByte = this.f;
    int i = arrayOfObject2.length;
    int j = 0;
    for (;;)
    {
      int k = i - 1;
      if (i <= 0) {
        break;
      }
      if (arrayOfByte[k] == 1)
      {
        arrayOfObject1[j] = arrayOfObject2[k];
        j += 1;
        i = k;
      }
      else
      {
        i = k;
      }
    }
    return arrayOfObject1;
  }
  
  protected final int c(int paramInt)
  {
    paramInt = super.c(paramInt);
    this.e = new Object[paramInt];
    return paramInt;
  }
  
  public final void clear()
  {
    super.clear();
    Object localObject = this.d;
    Arrays.fill((long[])localObject, 0, localObject.length, 0L);
    localObject = this.e;
    Arrays.fill((Object[])localObject, 0, localObject.length, null);
    localObject = this.f;
    Arrays.fill((byte[])localObject, 0, localObject.length, (byte)0);
  }
  
  protected final void d(int paramInt)
  {
    long[] arrayOfLong = this.d;
    int i = arrayOfLong.length;
    Object[] arrayOfObject = this.e;
    byte[] arrayOfByte = this.f;
    this.d = new long[paramInt];
    this.e = new Object[paramInt];
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
        this.e[paramInt] = arrayOfObject[i];
        this.f[paramInt] = 1;
        paramInt = i;
      }
      else
      {
        paramInt = i;
      }
    }
  }
  
  public final Object e(long paramLong)
  {
    int i = b(paramLong);
    if (i >= 0) {
      return this.e[i];
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof af))
    {
      paramObject = (af)paramObject;
      bool1 = bool2;
      if (((d)paramObject).size() == size()) {
        bool1 = a(new ag((af)paramObject));
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    ah localah = new ah(this);
    a(localah);
    return localah.a;
  }
  
  public final void readExternal(ObjectInput paramObjectInput)
  {
    paramObjectInput.readByte();
    int i = paramObjectInput.readInt();
    c(i);
    while (i > 0)
    {
      a(paramObjectInput.readLong(), paramObjectInput.readObject());
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/c/a/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */