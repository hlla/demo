package android.support.v7.widget;

import java.util.ArrayList;

final class bm
  implements Runnable
{
  bm(bk parambk, ArrayList paramArrayList) {}
  
  public final void run()
  {
    ArrayList localArrayList = this.b;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      bt localbt = (bt)localArrayList.get(i);
      this.a.animateChangeImpl(localbt);
      i += 1;
    }
    this.b.clear();
    this.a.mChangesList.remove(this.b);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */