package android.support.v7.widget;

import android.view.View;

final class hw
{
  private hx a;
  private final hy b;
  
  hw(hy paramhy)
  {
    this.b = paramhy;
    this.a = new hx();
  }
  
  final View a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = this.b.a();
    int k = this.b.b();
    if (paramInt2 > paramInt1) {}
    for (int i = 1;; i = -1)
    {
      Object localObject1 = null;
      Object localObject2;
      if (paramInt1 != paramInt2)
      {
        View localView = this.b.a(paramInt1);
        int m = this.b.a(localView);
        int n = this.b.b(localView);
        localObject2 = this.a;
        ((hx)localObject2).e = j;
        ((hx)localObject2).d = k;
        ((hx)localObject2).c = m;
        ((hx)localObject2).b = n;
        if (paramInt3 != 0)
        {
          ((hx)localObject2).a = 0;
          ((hx)localObject2).a(paramInt3);
          localObject2 = localView;
          if (this.a.a()) {}
        }
        else
        {
          if (paramInt4 != 0)
          {
            localObject2 = this.a;
            ((hx)localObject2).a = 0;
            ((hx)localObject2).a(paramInt4);
            if (this.a.a()) {
              localObject1 = localView;
            }
          }
          for (;;)
          {
            paramInt1 += i;
            break;
          }
        }
      }
      else
      {
        localObject2 = localObject1;
      }
      return (View)localObject2;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/hw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */