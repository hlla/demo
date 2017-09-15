package ct;

import android.location.Location;
import java.util.LinkedList;

public final class bw
{
  private static bw a = new bw();
  private a b = a.a;
  private LinkedList<ch> c = new LinkedList();
  
  public static bw a()
  {
    return a;
  }
  
  public final int a(ch paramch)
  {
    if (paramch != null)
    {
      try
      {
        while (this.c.size() > 9) {
          this.c.remove(0);
        }
        if (this.c.size() <= 0) {
          break label136;
        }
      }
      finally {}
      for (;;)
      {
        ch localch = (ch)this.c.getFirst();
        long l1 = paramch.b;
        long l2 = localch.b;
        double d = b.a.a(localch.a.getLatitude(), localch.a.getLongitude(), paramch.a.getLatitude(), paramch.a.getLongitude());
        if ((l1 - l2 <= 180000L) || (d <= 500.0D)) {
          break;
        }
        this.c.remove(0);
      }
      label136:
      paramch = new ch(paramch);
      this.c.add(paramch);
    }
    int i = this.c.size();
    return i;
  }
  
  public final long b()
  {
    for (;;)
    {
      double d1;
      double d2;
      long l1;
      try
      {
        int i;
        Object localObject3;
        if (this.c.size() < 2)
        {
          d1 = 0.0D;
          if (this.c.size() < 2) {
            continue;
          }
          int j = this.c.size();
          d2 = 0.0D;
          l1 = 0L;
          i = 1;
          if (i < j)
          {
            localObject1 = (ch)this.c.get(i);
            localObject3 = (ch)this.c.get(i - 1);
            double d3 = b.a.a(((ch)localObject3).a.getLatitude(), ((ch)localObject3).a.getLongitude(), ((ch)localObject1).a.getLatitude(), ((ch)localObject1).a.getLongitude());
            long l2 = ((ch)localObject1).b;
            long l3 = ((ch)localObject3).b;
            d2 = d3 + d2;
            l1 = l2 - l3 + l1;
            i += 1;
            continue;
          }
        }
        else
        {
          i = this.c.size() - 1;
          localObject1 = (ch)this.c.get(i);
          localObject3 = (ch)this.c.get(i - 1);
          if (((ch)localObject1).b == ((ch)localObject3).b) {
            break label485;
          }
          l1 = ((ch)localObject1).b - ((ch)localObject3).b;
          d1 = b.a.a(((ch)localObject3).a.getLatitude(), ((ch)localObject3).a.getLongitude(), ((ch)localObject1).a.getLatitude(), ((ch)localObject1).a.getLongitude()) / l1 * 1000.0D;
          continue;
        }
        if (l1 > 0L)
        {
          d2 = d2 / l1 * 1000.0D;
          if (this.c.size() < 2)
          {
            l1 = 0L;
            i = this.c.size();
            if (i >= 2) {
              continue;
            }
            this.b = a.a;
            localObject1 = this.b;
            localObject3 = a.c;
            if (localObject1 != localObject3) {
              break label477;
            }
            l1 = 90000L;
            return l1;
          }
        }
        else
        {
          d2 = 0.0D;
          continue;
        }
        Object localObject1 = (ch)this.c.getFirst();
        l1 = ((ch)this.c.getLast()).b - ((ch)localObject1).b;
        continue;
        if ((i > 6) && (d1 < 3.0D) && (d2 < 6.0D))
        {
          this.b = a.c;
          continue;
        }
        if (l1 <= 60000L) {
          break label467;
        }
      }
      finally {}
      if ((d1 < 3.0D) && (d2 < 3.0D))
      {
        this.b = a.c;
      }
      else
      {
        label467:
        this.b = a.b;
        continue;
        label477:
        l1 = 30000L;
        continue;
        label485:
        l1 = 500L;
      }
    }
  }
  
  static enum a
  {
    static
    {
      a locala = a;
      locala = b;
      locala = c;
    }
    
    private a() {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */