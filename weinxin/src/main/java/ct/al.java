package ct;

import java.util.HashMap;
import java.util.Map;

public final class al
  extends bh
{
  private static Map h;
  private static an i;
  private static aj j;
  private static Map k;
  private static Map l;
  public Map a = null;
  public an b = null;
  public aj c = null;
  private String d = "";
  private int e = 0;
  private Map f = null;
  private Map g = null;
  
  public final void a(bf parambf)
  {
    this.d = parambf.a(0, true);
    this.e = parambf.a(this.e, 1, true);
    Object localObject;
    if (h == null)
    {
      h = new HashMap();
      localObject = new am();
      h.put("", localObject);
    }
    this.a = ((Map)parambf.a(h, 2, true));
    if (i == null) {
      i = new an();
    }
    this.b = ((an)parambf.a(i, 3, false));
    if (j == null) {
      j = new aj();
    }
    this.c = ((aj)parambf.a(j, 4, false));
    if (k == null)
    {
      k = new HashMap();
      k.put("", "");
    }
    this.f = ((Map)parambf.a(k, 5, false));
    if (l == null)
    {
      l = new HashMap();
      localObject = (byte[])new byte[1];
      ((byte[])localObject)[0] = 0;
      l.put("", localObject);
    }
    this.g = ((Map)parambf.a(l, 6, false));
  }
  
  public final void a(bg parambg)
  {
    parambg.a(this.d, 0);
    parambg.a(this.e, 1);
    parambg.a(this.a, 2);
    if (this.b != null) {
      parambg.a(this.b, 3);
    }
    if (this.c != null) {
      parambg.a(this.c, 4);
    }
    if (this.f != null) {
      parambg.a(this.f, 5);
    }
    if (this.g != null) {
      parambg.a(this.g, 6);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */