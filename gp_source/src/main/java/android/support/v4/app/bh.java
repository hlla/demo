package android.support.v4.app;

import android.support.v4.view.ac;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class bh
  implements Runnable
{
  bh(ArrayList paramArrayList, Map paramMap) {}
  
  public final void run()
  {
    int j = this.b.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)this.b.get(i);
      String str = ac.v(localView);
      if (str == null)
      {
        i += 1;
      }
      else
      {
        Iterator localIterator = this.a.entrySet().iterator();
        Map.Entry localEntry;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localEntry = (Map.Entry)localIterator.next();
        } while (!str.equals(localEntry.getValue()));
        for (str = (String)localEntry.getKey();; str = null)
        {
          ac.a(localView, str);
          break;
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */