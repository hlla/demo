package c.a;

import java.util.Iterator;

public final class m
  extends n
{
  protected m(f paramf)
  {
    super(paramf, (byte)0);
  }
  
  public final boolean a(Object paramObject)
  {
    return this.a.contains(paramObject);
  }
  
  public final boolean b(Object paramObject)
  {
    return this.a.remove(paramObject) != null;
  }
  
  public final Iterator iterator()
  {
    return new al(this.a);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/c/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */