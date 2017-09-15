package ct;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationUtils;
import java.util.LinkedList;
import java.util.ListIterator;

public final class cd
{
  private int a = 10;
  private int b = 4;
  private LinkedList<a> c = new LinkedList();
  private bs d = new bs();
  
  private boolean a(a parama, bk parambk)
  {
    boolean bool;
    if (parambk == null)
    {
      bool = true;
      return bool;
    }
    for (;;)
    {
      int i;
      int k;
      try
      {
        if (parama.d == 3)
        {
          bool = true;
          break;
        }
        if (this.c.size() >= this.b)
        {
          i = 1;
          if (i == 0) {
            continue;
          }
          i = 0;
          parambk = this.c.listIterator(this.c.size());
          int j = 0;
          if (!parambk.hasPrevious()) {
            break label195;
          }
          a locala = (a)parambk.previous();
          if (b.a.a(locala.a, locala.b, parama.a, parama.b) / ((Math.abs(locala.c - parama.c) + 1L) / 1000.0D) <= 80.0D) {
            continue;
          }
          k = 0;
          break label204;
          j += 1;
          k = this.b;
          if (j <= k) {
            break label198;
          }
          if (i <= 1) {
            continue;
          }
          bool = false;
          break;
        }
        i = 0;
        continue;
        k = 1;
        break label204;
        bool = true;
        break;
      }
      finally {}
      label195:
      continue;
      label198:
      continue;
      label204:
      do
      {
        break;
      } while (k != 0);
      i += 1;
    }
  }
  
  public final void a()
  {
    try
    {
      this.c.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(TencentLocation paramTencentLocation)
  {
    try
    {
      this.c.add(a.a(paramTencentLocation));
      if (this.c.size() > this.a) {
        this.c.removeFirst();
      }
      return;
    }
    finally
    {
      paramTencentLocation = finally;
      throw paramTencentLocation;
    }
  }
  
  public final boolean a(TencentLocation paramTencentLocation, bk parambk)
  {
    try
    {
      boolean bool = a(a.a(paramTencentLocation), parambk);
      return bool;
    }
    finally
    {
      paramTencentLocation = finally;
      throw paramTencentLocation;
    }
  }
  
  public final void b() {}
  
  static final class a
  {
    double a;
    double b;
    long c;
    int d;
    
    static a a(TencentLocation paramTencentLocation)
    {
      int i = 2;
      a locala = new a();
      locala.a = paramTencentLocation.getLatitude();
      locala.b = paramTencentLocation.getLongitude();
      locala.c = paramTencentLocation.getTime();
      paramTencentLocation.getSpeed();
      if (TencentLocationUtils.isFromGps(paramTencentLocation))
      {
        if (paramTencentLocation.getAccuracy() < 100.0F) {
          i = 3;
        }
        locala.d = i;
        return locala;
      }
      if (paramTencentLocation.getAccuracy() < 500.0F) {}
      for (;;)
      {
        locala.d = i;
        return locala;
        i = 1;
      }
    }
    
    public final String toString()
    {
      return "[" + this.a + "," + this.b + "]";
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */