package c.a;

import java.util.ConcurrentModificationException;

abstract class z
{
  public int a;
  public final d b;
  public int c;
  
  public z(d paramd)
  {
    this.b = paramd;
    this.a = this.b.size();
    this.c = this.b.a();
  }
  
  protected abstract int a();
  
  public boolean hasNext()
  {
    return a() >= 0;
  }
  
  public void remove()
  {
    if (this.a != this.b.size()) {
      throw new ConcurrentModificationException();
    }
    try
    {
      d locald = this.b;
      locald.a = true;
      locald.b(this.c);
      this.b.a = false;
      this.a -= 1;
      return;
    }
    finally
    {
      this.b.a = false;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/c/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */