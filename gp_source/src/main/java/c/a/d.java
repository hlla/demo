package c.a;

public abstract class d
  implements Cloneable
{
  public boolean a = false;
  public transient int b;
  private int c;
  private float d = 0.5F;
  private transient int e;
  private float f = 0.5F;
  private int g;
  
  public d()
  {
    this((byte)0);
  }
  
  private d(byte paramByte)
  {
    c((int)Math.ceil(20.0D));
  }
  
  private final void e(int paramInt)
  {
    this.g = Math.min(paramInt - 1, (int)Math.floor(paramInt * this.f));
    this.e = (paramInt - this.b);
  }
  
  private final void f(int paramInt)
  {
    float f1 = this.d;
    if (f1 != 0.0F) {
      this.c = Math.round(f1 * paramInt);
    }
  }
  
  protected abstract int a();
  
  public final void a(int paramInt)
  {
    if (paramInt > this.g - size())
    {
      d(b.a((int)Math.ceil(paramInt + size() / this.f) + 1));
      e(a());
    }
  }
  
  protected final void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      int i = this.b + 1;
      this.b = i;
      int j = this.g;
      if ((i > j) || (this.e == 0))
      {
        if (this.b <= j) {
          break label67;
        }
        i = a();
      }
      label67:
      for (i = b.a(i + i);; i = a())
      {
        d(i);
        e(a());
        return;
      }
      this.e -= 1;
    }
  }
  
  protected void b(int paramInt)
  {
    this.b -= 1;
    if (this.d != 0.0F)
    {
      this.c -= 1;
      if ((!this.a) && (this.c <= 0))
      {
        d(b.a((int)Math.ceil(size() / this.f) + 1));
        e(a());
        if (this.d != 0.0F) {
          f(size());
        }
      }
    }
  }
  
  protected int c(int paramInt)
  {
    int i = b.a(paramInt);
    e(i);
    f(paramInt);
    return i;
  }
  
  public void clear()
  {
    this.b = 0;
    this.e = a();
  }
  
  public Object clone()
  {
    try
    {
      Object localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  protected abstract void d(int paramInt);
  
  public boolean isEmpty()
  {
    return this.b == 0;
  }
  
  public int size()
  {
    return this.b;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/c/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */