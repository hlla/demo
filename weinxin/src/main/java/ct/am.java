package ct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class am
  extends bh
{
  private static ArrayList e;
  private static Map f;
  public ArrayList a = null;
  public String b = "";
  private int c = 0;
  private Map d = null;
  
  public final void a(bf parambf)
  {
    this.c = parambf.a(this.c, 0, true);
    if (e == null)
    {
      e = new ArrayList();
      e.add("");
    }
    this.a = ((ArrayList)parambf.a(e, 1, true));
    this.b = parambf.a(2, false);
    if (f == null)
    {
      f = new HashMap();
      f.put("", "");
    }
    this.d = ((Map)parambf.a(f, 3, false));
  }
  
  public final void a(bg parambg)
  {
    parambg.a(this.c, 0);
    parambg.a(this.a, 1);
    if (this.b != null) {
      parambg.a(this.b, 2);
    }
    if (this.d != null) {
      parambg.a(this.d, 3);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */