package android.support.v7.preference;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.eu;
import android.support.v7.widget.ew;

final class aa
  extends ew
{
  private final eu a;
  private final String b;
  private final RecyclerView c;
  private final Preference d;
  
  public aa(eu parameu, RecyclerView paramRecyclerView, Preference paramPreference, String paramString)
  {
    this.a = parameu;
    this.c = paramRecyclerView;
    this.d = paramPreference;
    this.b = paramString;
  }
  
  private final void b()
  {
    this.a.b(this);
    Preference localPreference = this.d;
    if (localPreference != null) {}
    for (int i = ((ac)this.a).b(localPreference);; i = ((ac)this.a).a(this.b))
    {
      if (i != -1) {
        this.c.d(i);
      }
      return;
    }
  }
  
  public final void a()
  {
    b();
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    b();
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    b();
  }
  
  public final void a(int paramInt1, int paramInt2, Object paramObject)
  {
    b();
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    b();
  }
  
  public final void c(int paramInt1, int paramInt2)
  {
    b();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */