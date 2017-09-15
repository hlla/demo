package ct;

public final class aj
  extends bh
{
  private static ao g;
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public ao f = null;
  
  public final void a(bf parambf)
  {
    this.a = parambf.a(this.a, 0, false);
    this.b = parambf.a(this.b, 1, false);
    this.c = parambf.a(this.c, 2, false);
    this.d = parambf.a(this.d, 3, false);
    this.e = parambf.a(this.e, 4, false);
    if (g == null) {
      g = new ao();
    }
    this.f = ((ao)parambf.a(g, 5, false));
  }
  
  public final void a(bg parambg)
  {
    parambg.a(this.a, 0);
    parambg.a(this.b, 1);
    parambg.a(this.c, 2);
    parambg.a(this.d, 3);
    parambg.a(this.e, 4);
    if (this.f != null) {
      parambg.a(this.f, 5);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */