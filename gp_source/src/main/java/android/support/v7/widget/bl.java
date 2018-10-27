package android.support.v7.widget;

import java.util.ArrayList;

final class bl
  implements Runnable
{
  bl(bk parambk, ArrayList paramArrayList) {}
  
  public final void run()
  {
    ArrayList localArrayList = this.b;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      bu localbu = (bu)localArrayList.get(i);
      this.a.animateMoveImpl(localbu.c, localbu.a, localbu.b, localbu.d, localbu.e);
      i += 1;
    }
    this.b.clear();
    this.a.mMovesList.remove(this.b);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */