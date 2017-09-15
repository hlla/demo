package ct;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class ad
{
  private static String d = "bott";
  public s a;
  public String b;
  public List c = new ArrayList();
  
  public ad(z paramz)
  {
    if ((paramz.o == 0) || (!paramz.b))
    {
      this.c.add(a(paramz));
      return;
    }
    if (!bc.d)
    {
      Object localObject = h.a();
      if (localObject != null)
      {
        localObject = ((a)localObject).a(paramz.c);
        if (localObject != null)
        {
          this.a = ((t.a)localObject).d;
          List localList = ((t.a)localObject).c;
          this.b = ((t.a)localObject).b;
          localObject = localList;
          if (localList != null)
          {
            localObject = localList;
            if (localList.size() > paramz.o) {
              localObject = localList.subList(0, paramz.o);
            }
          }
          boolean bool = a((List)localObject, this.a);
          if ((this.b != null) && (!this.b.contains(d)))
          {
            this.c.addAll((Collection)localObject);
            if ((this.a != null) && (!bool)) {
              this.c.add(this.a);
            }
            this.c.add(a(paramz));
            return;
          }
          if ((this.a != null) && (!bool)) {
            this.c.add(this.a);
          }
          this.c.add(a(paramz));
          this.c.addAll((Collection)localObject);
          return;
        }
        this.c.add(a(paramz));
        return;
      }
      this.c.add(a(paramz));
      return;
    }
    this.c.add(a(paramz));
  }
  
  private static s a(z paramz)
  {
    if (paramz.e != null) {
      return new s(paramz.c, paramz.e[0]);
    }
    return new s(paramz.c, -1);
  }
  
  private static boolean a(List paramList, s params)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((s)paramList.next()).a(params)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */