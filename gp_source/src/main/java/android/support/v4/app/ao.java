package android.support.v4.app;

import java.util.ArrayList;

final class ao
  implements an
{
  private final int a;
  private final int b;
  private final String c;
  
  ao(z paramz, String paramString, int paramInt1, int paramInt2)
  {
    this.c = paramString;
    this.b = paramInt1;
    this.a = paramInt2;
  }
  
  public final boolean a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    Object localObject = this.d.g;
    if ((localObject != null) && (this.b < 0) && (this.c == null))
    {
      localObject = ((Fragment)localObject).j;
      if ((localObject != null) && (((v)localObject).d())) {}
    }
    else
    {
      return this.d.a(paramArrayList1, paramArrayList2, this.c, this.b, this.a);
    }
    return false;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */