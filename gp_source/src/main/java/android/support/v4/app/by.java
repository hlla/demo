package android.support.v4.app;

import android.a.b.ae;
import android.a.b.af;
import android.a.b.ag;
import android.a.b.ah;
import android.support.v4.g.w;
import java.util.HashMap;

class by
  extends ae
{
  private static final ag c = new bz();
  public boolean a = false;
  public w b = new w();
  
  static by a(ah paramah)
  {
    af localaf = new af(paramah, c);
    paramah = by.class.getCanonicalName();
    if (paramah == null) {
      throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("android.arch.lifecycle.ViewModelProvider.DefaultKey:");
    ((StringBuilder)localObject).append(paramah);
    String str = ((StringBuilder)localObject).toString();
    localObject = (ae)localaf.b.a.get(str);
    paramah = (ah)localObject;
    if (!by.class.isInstance(localObject))
    {
      paramah = localaf.a.a();
      localObject = (ae)localaf.b.a.put(str, paramah);
      if (localObject == null) {
        break label123;
      }
      ((ae)localObject).a();
    }
    label123:
    for (;;)
    {
      return (by)paramah;
    }
  }
  
  final bw a(int paramInt)
  {
    return (bw)this.b.a(paramInt, null);
  }
  
  protected final void a()
  {
    super.a();
    int j = this.b.b();
    int i = 0;
    while (i < j)
    {
      ((bw)this.b.c(i)).a(true);
      i += 1;
    }
    this.b.c();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */