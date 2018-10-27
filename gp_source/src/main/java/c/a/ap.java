package c.a;

public abstract class ap
  extends d
{
  public transient byte[] f;
  
  protected final int a()
  {
    return this.f.length;
  }
  
  protected void b(int paramInt)
  {
    this.f[paramInt] = 2;
    super.b(paramInt);
  }
  
  protected int c(int paramInt)
  {
    paramInt = super.c(paramInt);
    this.f = new byte[paramInt];
    return paramInt;
  }
  
  public Object clone()
  {
    ap localap = (ap)super.clone();
    localap.f = ((byte[])this.f.clone());
    return localap;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/c/a/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */