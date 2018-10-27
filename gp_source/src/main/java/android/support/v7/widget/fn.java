package android.support.v7.widget;

import android.util.SparseArray;
import java.util.ArrayList;

public class fn
{
  public int a = 0;
  private SparseArray b = new SparseArray();
  
  static long a(long paramLong1, long paramLong2)
  {
    long l = paramLong2;
    if (paramLong1 != 0L) {
      l = paramLong1 / 4L * 3L + paramLong2 / 4L;
    }
    return l;
  }
  
  public int a(int paramInt)
  {
    return c(paramInt).d.size();
  }
  
  public void a()
  {
    int i = 0;
    while (i < this.b.size())
    {
      ((fo)this.b.valueAt(i)).d.clear();
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = c(paramInt1);
    ((fo)localObject).c = paramInt2;
    localObject = ((fo)localObject).d;
    while (((ArrayList)localObject).size() > paramInt2) {
      ((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
    }
  }
  
  public void a(fz paramfz)
  {
    int i = paramfz.g;
    ArrayList localArrayList = c(i).d;
    if (((fo)this.b.get(i)).c > localArrayList.size())
    {
      paramfz.p();
      localArrayList.add(paramfz);
    }
  }
  
  public fz b(int paramInt)
  {
    Object localObject = (fo)this.b.get(paramInt);
    if ((localObject != null) && (!((fo)localObject).d.isEmpty()))
    {
      localObject = ((fo)localObject).d;
      return (fz)((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
    }
    return null;
  }
  
  final void b()
  {
    this.a += 1;
  }
  
  final fo c(int paramInt)
  {
    fo localfo2 = (fo)this.b.get(paramInt);
    fo localfo1 = localfo2;
    if (localfo2 == null)
    {
      localfo1 = new fo();
      this.b.put(paramInt, localfo1);
    }
    return localfo1;
  }
  
  final void c()
  {
    this.a -= 1;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/fn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */