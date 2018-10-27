package b.a;

import e.a.a;

public final class b
  implements d
{
  private a a;
  
  public final Object a()
  {
    a locala = this.a;
    if (locala == null) {
      throw new IllegalStateException();
    }
    return locala.a();
  }
  
  public final void a(a parama)
  {
    if (parama == null) {
      throw new IllegalArgumentException();
    }
    if (this.a != null) {
      throw new IllegalStateException();
    }
    this.a = parama;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */