package android.support.f;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ap
{
  public final ArrayList a = new ArrayList();
  public final Map b = new HashMap();
  public View c;
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof ap))
    {
      View localView = this.c;
      paramObject = (ap)paramObject;
      if ((localView == ((ap)paramObject).c) && (this.b.equals(((ap)paramObject).b))) {
        return true;
      }
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.c.hashCode() * 31 + this.b.hashCode();
  }
  
  public final String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TransitionValues@");
    ((StringBuilder)localObject1).append(Integer.toHexString(hashCode()));
    ((StringBuilder)localObject1).append(":\n");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("    view = ");
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append("\n");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("    values:");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = this.b.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("    ");
      localStringBuilder.append(str);
      localStringBuilder.append(": ");
      localStringBuilder.append(this.b.get(str));
      localStringBuilder.append("\n");
      localObject1 = localStringBuilder.toString();
    }
    return (String)localObject1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */