package android.support.v4.content.a;

import java.util.List;

final class i
{
  public final int[] a;
  public final float[] b;
  
  i(int paramInt1, int paramInt2)
  {
    this.a = new int[] { paramInt1, paramInt2 };
    this.b = new float[] { 0.0F, 1.0F };
  }
  
  i(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = new int[] { paramInt1, paramInt2, paramInt3 };
    this.b = new float[] { 0.0F, 0.5F, 1.0F };
  }
  
  i(List paramList1, List paramList2)
  {
    int j = paramList1.size();
    this.a = new int[j];
    this.b = new float[j];
    int i = 0;
    while (i < j)
    {
      this.a[i] = ((Integer)paramList1.get(i)).intValue();
      this.b[i] = ((Float)paramList2.get(i)).floatValue();
      i += 1;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */