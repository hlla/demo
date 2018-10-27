package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

public abstract class z
{
  private final DataSetObservable a = new DataSetObservable();
  private DataSetObserver b;
  
  /* Error */
  public final void S_()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 21	android/support/v4/view/z:b	Landroid/database/DataSetObserver;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +13 -> 21
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_0
    //   14: getfield 17	android/support/v4/view/z:a	Landroid/database/DataSetObservable;
    //   17: invokevirtual 24	android/database/DataSetObservable:notifyChanged	()V
    //   20: return
    //   21: aload_1
    //   22: invokevirtual 29	android/database/DataSetObserver:onChanged	()V
    //   25: goto -14 -> 11
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	z
    //   6	16	1	localDataSetObserver	DataSetObserver
    //   28	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   11	13	28	finally
    //   21	25	28	finally
    //   29	31	28	finally
  }
  
  public abstract int a();
  
  @Deprecated
  public Object a(View paramView, int paramInt)
  {
    throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
  }
  
  public Object a(ViewGroup paramViewGroup, int paramInt)
  {
    return a(paramViewGroup, paramInt);
  }
  
  public final void a(DataSetObserver paramDataSetObserver)
  {
    this.a.registerObserver(paramDataSetObserver);
  }
  
  @Deprecated
  public void a(View paramView, int paramInt, Object paramObject)
  {
    throw new UnsupportedOperationException("Required method destroyItem was not overridden");
  }
  
  public void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    a(paramViewGroup, paramInt, paramObject);
  }
  
  @Deprecated
  public void a(Object paramObject) {}
  
  public abstract boolean a(View paramView, Object paramObject);
  
  public int b(Object paramObject)
  {
    return -1;
  }
  
  public void b()
  {
    c();
  }
  
  public final void b(DataSetObserver paramDataSetObserver)
  {
    this.a.unregisterObserver(paramDataSetObserver);
  }
  
  public CharSequence c(int paramInt)
  {
    return null;
  }
  
  @Deprecated
  public void c() {}
  
  final void c(DataSetObserver paramDataSetObserver)
  {
    try
    {
      this.b = paramDataSetObserver;
      return;
    }
    finally {}
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/view/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */