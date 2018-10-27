package c.a;

import java.io.IOException;
import java.io.ObjectOutput;

final class c
  implements ai, aj, an, ao, y
{
  public IOException a;
  private final ObjectOutput b;
  
  c(ObjectOutput paramObjectOutput)
  {
    this.b = paramObjectOutput;
  }
  
  public final boolean a(int paramInt, Object paramObject)
  {
    try
    {
      this.b.writeInt(paramInt);
      this.b.writeObject(paramObject);
      return true;
    }
    catch (IOException paramObject)
    {
      this.a = ((IOException)paramObject);
    }
    return false;
  }
  
  public final boolean a(long paramLong)
  {
    try
    {
      this.b.writeLong(paramLong);
      return true;
    }
    catch (IOException localIOException)
    {
      this.a = localIOException;
    }
    return false;
  }
  
  public final boolean a(long paramLong, Object paramObject)
  {
    try
    {
      this.b.writeLong(paramLong);
      this.b.writeObject(paramObject);
      return true;
    }
    catch (IOException paramObject)
    {
      this.a = ((IOException)paramObject);
    }
    return false;
  }
  
  public final boolean a(Object paramObject1, Object paramObject2)
  {
    try
    {
      this.b.writeObject(paramObject1);
      this.b.writeObject(paramObject2);
      return true;
    }
    catch (IOException paramObject1)
    {
      this.a = ((IOException)paramObject1);
    }
    return false;
  }
  
  public final boolean execute(Object paramObject)
  {
    try
    {
      this.b.writeObject(paramObject);
      return true;
    }
    catch (IOException paramObject)
    {
      this.a = ((IOException)paramObject);
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/c/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */