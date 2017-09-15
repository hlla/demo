package ct;

import java.util.HashMap;
import java.util.Map;

public final class ao
  extends bh
{
  private static Map c;
  public Map a = null;
  public int b = 0;
  
  public final void a(bf parambf)
  {
    if (c == null)
    {
      c = new HashMap();
      c.put(Integer.valueOf(0), Byte.valueOf((byte)0));
    }
    this.a = ((Map)parambf.a(c, 0, true));
    this.b = parambf.a(this.b, 1, true);
  }
  
  public final void a(bg parambg)
  {
    parambg.a(this.a, 0);
    parambg.a(this.b, 1);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */