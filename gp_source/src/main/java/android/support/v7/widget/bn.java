package android.support.v7.widget;

import java.util.ArrayList;

final class bn
  implements Runnable
{
  bn(bk parambk, ArrayList paramArrayList) {}
  
  public final void run()
  {
    ArrayList localArrayList = this.b;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      fz localfz = (fz)localArrayList.get(i);
      this.a.animateAddImpl(localfz);
      i += 1;
    }
    this.b.clear();
    this.a.mAdditionsList.remove(this.b);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */