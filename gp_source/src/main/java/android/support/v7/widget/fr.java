package android.support.v7.widget;

import android.support.v4.view.ac;
import java.util.ArrayList;

final class fr
  extends ew
{
  fr(RecyclerView paramRecyclerView) {}
  
  private final void b()
  {
    if (RecyclerView.d)
    {
      localRecyclerView = this.a;
      if ((localRecyclerView.o) && (localRecyclerView.p))
      {
        ac.a(localRecyclerView, localRecyclerView.K);
        return;
      }
    }
    RecyclerView localRecyclerView = this.a;
    localRecyclerView.i = true;
    localRecyclerView.requestLayout();
  }
  
  public final void a()
  {
    this.a.a(null);
    RecyclerView localRecyclerView = this.a;
    localRecyclerView.G.l = true;
    localRecyclerView.c(true);
    if (!this.a.h.d()) {
      this.a.requestLayout();
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a(null);
    x localx = this.a.h;
    if (paramInt1 != paramInt2)
    {
      if (paramInt3 != 1) {
        break label76;
      }
      localx.b.add(localx.a(8, paramInt1, paramInt2, null));
      localx.a |= 0x8;
      if (localx.b.size() == 1) {
        b();
      }
    }
    return;
    label76:
    throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
  }
  
  public final void a(int paramInt1, int paramInt2, Object paramObject)
  {
    this.a.a(null);
    x localx = this.a.h;
    if (paramInt2 > 0)
    {
      localx.b.add(localx.a(4, paramInt1, paramInt2, paramObject));
      localx.a |= 0x4;
      if (localx.b.size() == 1) {
        b();
      }
    }
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    this.a.a(null);
    x localx = this.a.h;
    if (paramInt2 > 0)
    {
      localx.b.add(localx.a(1, paramInt1, paramInt2, null));
      localx.a |= 0x1;
      if (localx.b.size() == 1) {
        b();
      }
    }
  }
  
  public final void c(int paramInt1, int paramInt2)
  {
    this.a.a(null);
    x localx = this.a.h;
    if (paramInt2 > 0)
    {
      localx.b.add(localx.a(2, paramInt1, paramInt2, null));
      localx.a |= 0x2;
      if (localx.b.size() == 1) {
        b();
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/fr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */