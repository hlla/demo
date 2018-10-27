package android.support.v7.widget;

import java.util.Arrays;

final class db
{
  public cy[][] a;
  public cy[] b;
  private int c;
  private int[] f;
  
  db(da paramda, cy[] paramArrayOfcy)
  {
    paramda = this.e;
    int k = paramda.length;
    this.b = new cy[k];
    this.c = (this.b.length - 1);
    int i = this.d.a() + 1;
    paramArrayOfcy = new cy[i][];
    int[] arrayOfInt = new int[i];
    i = 0;
    int m;
    while (i < k)
    {
      m = paramda[i].a.b;
      arrayOfInt[m] += 1;
      i += 1;
    }
    i = 0;
    while (i < arrayOfInt.length)
    {
      paramArrayOfcy[i] = new cy[arrayOfInt[i]];
      i += 1;
    }
    Arrays.fill(arrayOfInt, 0);
    k = paramda.length;
    i = j;
    while (i < k)
    {
      Object localObject = paramda[i];
      j = ((cy)localObject).a.b;
      cy localcy = paramArrayOfcy[j];
      m = arrayOfInt[j];
      arrayOfInt[j] = (m + 1);
      localcy[m] = localObject;
      i += 1;
    }
    this.a = paramArrayOfcy;
    this.f = new int[this.d.a() + 1];
  }
  
  final void a(int paramInt)
  {
    Object localObject1 = this.f;
    switch (localObject1[paramInt])
    {
    default: 
      return;
    }
    localObject1[paramInt] = 1;
    localObject1 = this.a[paramInt];
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      a(((cy)localObject2).a.a);
      cy[] arrayOfcy = this.b;
      int k = this.c;
      this.c = (k - 1);
      arrayOfcy[k] = localObject2;
      i += 1;
    }
    this.f[paramInt] = 2;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */