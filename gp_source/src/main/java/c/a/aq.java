package c.a;

final class aq
  implements ao
{
  private int a = 0;
  private final Object[] b;
  
  public aq(Object[] paramArrayOfObject)
  {
    this.b = paramArrayOfObject;
  }
  
  public final boolean execute(Object paramObject)
  {
    Object[] arrayOfObject = this.b;
    int i = this.a;
    this.a = (i + 1);
    arrayOfObject[i] = paramObject;
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/c/a/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */