package ct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class an
  extends bh
{
  private static Map c;
  public Map a = null;
  public long b = 0L;
  
  public final void a(bf parambf)
  {
    if (c == null)
    {
      c = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("");
      c.put(Integer.valueOf(0), localArrayList);
    }
    this.a = ((Map)parambf.a(c, 0, false));
    this.b = parambf.a(this.b, 1, false);
  }
  
  public final void a(bg parambg)
  {
    if (this.a != null) {
      parambg.a(this.a, 0);
    }
    parambg.a(this.b, 1);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */