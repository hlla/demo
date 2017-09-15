package ct;

import java.util.Iterator;

public final class cx
{
  private final String a;
  
  public cx(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException();
    }
    this.a = paramString;
  }
  
  public final StringBuilder a(StringBuilder paramStringBuilder, Iterator<?> paramIterator)
  {
    Object localObject;
    if (paramIterator.hasNext())
    {
      localObject = paramIterator.next();
      if (localObject != null) {
        paramStringBuilder.append(localObject.toString());
      }
    }
    while (paramIterator.hasNext())
    {
      localObject = paramIterator.next();
      if (localObject != null)
      {
        paramStringBuilder.append(this.a);
        paramStringBuilder.append(localObject.toString());
      }
    }
    return paramStringBuilder;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/cx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */