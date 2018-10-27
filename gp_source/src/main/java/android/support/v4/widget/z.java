package android.support.v4.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;

final class z
  implements Runnable
{
  z(y paramy) {}
  
  public final void run()
  {
    int k = 0;
    Object localObject2 = this.a;
    int n = ((y)localObject2).b.c;
    int m = ((y)localObject2).a;
    if (m != 3) {}
    for (int i = 0;; i = 1)
    {
      if (m != 3)
      {
        localObject1 = ((y)localObject2).c.a(5);
        j = ((y)localObject2).c.getWidth();
        j -= n;
        if (localObject1 != null) {
          if ((i == 0) || (((View)localObject1).getLeft() >= j)) {
            break label218;
          }
        }
        for (;;)
        {
          if (((y)localObject2).c.a((View)localObject1) == 0)
          {
            v localv = (v)((View)localObject1).getLayoutParams();
            ((y)localObject2).b.a((View)localObject1, j, ((View)localObject1).getTop());
            localv.b = true;
            ((y)localObject2).c.invalidate();
            ((y)localObject2).c();
            localObject1 = ((y)localObject2).c;
            if (!((DrawerLayout)localObject1).d)
            {
              long l = SystemClock.uptimeMillis();
              localObject2 = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
              j = ((DrawerLayout)localObject1).getChildCount();
              i = k;
              while (i < j)
              {
                ((DrawerLayout)localObject1).getChildAt(i).dispatchTouchEvent((MotionEvent)localObject2);
                i += 1;
              }
              ((MotionEvent)localObject2).recycle();
              ((DrawerLayout)localObject1).d = true;
            }
          }
          label218:
          do
          {
            return;
          } while ((m == 3) || (((View)localObject1).getLeft() <= j));
        }
      }
      Object localObject1 = ((y)localObject2).c.a(3);
      if (localObject1 != null) {}
      for (int j = -((View)localObject1).getWidth();; j = 0)
      {
        j += n;
        break;
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/widget/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */