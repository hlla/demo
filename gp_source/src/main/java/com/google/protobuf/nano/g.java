package com.google.protobuf.nano;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public abstract class g
{
  public static final int UNSET_ENUM_VALUE = Integer.MIN_VALUE;
  public volatile int cachedSize = -1;
  
  public static final g a(g paramg, byte[] paramArrayOfByte)
  {
    return a(paramg, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static final g a(g paramg, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = a.a(paramArrayOfByte, paramInt1, paramInt2);
      paramg.a(paramArrayOfByte);
      paramArrayOfByte.a(0);
      return paramg;
    }
    catch (InvalidProtocolBufferNanoException paramg)
    {
      throw paramg;
    }
    catch (IOException paramg)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", paramg);
    }
  }
  
  public static final void a(g paramg, byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = CodedOutputByteBufferNano.a(paramArrayOfByte, 0, paramInt);
      paramg.a(paramArrayOfByte);
      paramArrayOfByte.b();
      return;
    }
    catch (IOException paramg)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramg);
    }
  }
  
  public static final boolean a(g paramg1, g paramg2)
  {
    boolean bool2 = false;
    if (paramg1 != paramg2)
    {
      boolean bool1 = bool2;
      if (paramg1 != null)
      {
        bool1 = bool2;
        if (paramg2 != null)
        {
          bool1 = bool2;
          if (paramg1.getClass() == paramg2.getClass())
          {
            int i = paramg1.p();
            bool1 = bool2;
            if (paramg2.p() == i)
            {
              byte[] arrayOfByte1 = new byte[i];
              byte[] arrayOfByte2 = new byte[i];
              a(paramg1, arrayOfByte1, i);
              a(paramg2, arrayOfByte2, i);
              bool1 = Arrays.equals(arrayOfByte1, arrayOfByte2);
            }
          }
        }
      }
      return bool1;
    }
    return true;
  }
  
  public static final byte[] a(g paramg)
  {
    byte[] arrayOfByte = new byte[paramg.p()];
    a(paramg, arrayOfByte, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public static final g b(g paramg)
  {
    try
    {
      paramg = a((g)paramg.getClass().getConstructor(new Class[0]).newInstance(new Object[0]), a(paramg));
      return paramg;
    }
    catch (NoSuchMethodException paramg)
    {
      throw new IllegalStateException(paramg);
    }
    catch (InstantiationException paramg)
    {
      throw new IllegalStateException(paramg);
    }
    catch (InvocationTargetException paramg)
    {
      throw new IllegalStateException(paramg);
    }
    catch (IllegalAccessException paramg)
    {
      throw new IllegalStateException(paramg);
    }
    catch (InvalidProtocolBufferNanoException paramg)
    {
      throw new IllegalStateException(paramg);
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public abstract g a(a parama);
  
  public void a(CodedOutputByteBufferNano paramCodedOutputByteBufferNano) {}
  
  public g aq_()
  {
    return (g)super.clone();
  }
  
  public final int o()
  {
    if (this.cachedSize < 0) {
      p();
    }
    return this.cachedSize;
  }
  
  public final int p()
  {
    int i = a();
    this.cachedSize = i;
    return i;
  }
  
  public String toString()
  {
    return h.a(this);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/protobuf/nano/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */