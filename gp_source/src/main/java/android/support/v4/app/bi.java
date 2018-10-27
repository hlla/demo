package android.support.v4.app;

import android.support.v4.view.ac;
import android.view.View;
import java.util.ArrayList;
import java.util.Map;

final class bi
  implements Runnable
{
  bi(ArrayList paramArrayList, Map paramMap) {}
  
  public final void run()
  {
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.b.get(i);
      String str = ac.v(localView);
      ac.a(localView, (String)this.a.get(str));
      i += 1;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */