package c.a;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;

public final class v
  extends t
  implements Externalizable
{
  private transient Object[] e;
  
  private final boolean a(y paramy)
  {
    boolean bool2 = true;
    byte[] arrayOfByte = this.f;
    int[] arrayOfInt = this.d;
    Object[] arrayOfObject = this.e;
    int i = arrayOfInt.length;
    for (;;)
    {
      int j = i - 1;
      boolean bool1 = bool2;
      if (i > 0)
      {
        if (arrayOfByte[j] == 1)
        {
          if (paramy.a(arrayOfInt[j], arrayOfObject[j]))
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
  
  public final Object a(int paramInt, Object paramObject)
  {
    boolean bool = true;
    int j = f(paramInt);
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
      this.d[j] = paramInt;
      arrayOfByte[j] = 1;
      this.e[j] = paramObject;
      if (i != 0) {
        if (k != 0) {
          break label86;
        }
      }
      for (;;)
      {
        a(bool);
        return localObject;
        label86:
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
    Arrays.fill((int[])localObject, 0, localObject.length, 0);
    localObject = this.e;
    Arrays.fill((Object[])localObject, 0, localObject.length, null);
    localObject = this.f;
    Arrays.fill((byte[])localObject, 0, localObject.length, (byte)0);
  }
  
  protected final void d(int paramInt)
  {
    int[] arrayOfInt = this.d;
    int i = arrayOfInt.length;
    Object[] arrayOfObject = this.e;
    byte[] arrayOfByte = this.f;
    this.d = new int[paramInt];
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
        paramInt = arrayOfInt[i];
        int j = f(paramInt);
        this.d[j] = paramInt;
        this.e[j] = arrayOfObject[i];
        this.f[j] = 1;
        paramInt = i;
      }
      else
      {
        paramInt = i;
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof v))
    {
      paramObject = (v)paramObject;
      bool1 = bool2;
      if (((d)paramObject).size() == size()) {
        bool1 = a(new w((v)paramObject));
      }
    }
    return bool1;
  }
  
  public final Object h(int paramInt)
  {
    paramInt = e(paramInt);
    if (paramInt >= 0) {
      return this.e[paramInt];
    }
    return null;
  }
  
  public final int hashCode()
  {
    x localx = new x(this);
    a(localx);
    return localx.a;
  }
  
  public final void readExternal(ObjectInput paramObjectInput)
  {
    paramObjectInput.readByte();
    int i = paramObjectInput.readInt();
    c(i);
    while (i > 0)
    {
      a(paramObjectInput.readInt(), paramObjectInput.readObject());
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/c/a/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */