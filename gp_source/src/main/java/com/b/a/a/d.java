package com.b.a.a;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class d
  extends AbstractList
{
  private static final f c = f.a(d.class);
  public Iterator a;
  public List b;
  
  public d(List paramList, Iterator paramIterator)
  {
    this.b = paramList;
    this.a = paramIterator;
  }
  
  public Object get(int paramInt)
  {
    if (this.b.size() > paramInt) {
      return this.b.get(paramInt);
    }
    if (this.a.hasNext())
    {
      this.b.add(this.a.next());
      return get(paramInt);
    }
    throw new NoSuchElementException();
  }
  
  public Iterator iterator()
  {
    return new e(this);
  }
  
  public int size()
  {
    c.a("potentially expensive size() call");
    c.a("blowup running");
    while (this.a.hasNext()) {
      this.b.add(this.a.next());
    }
    return this.b.size();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/b/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */