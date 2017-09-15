package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class h<T>
  extends a<T>
{
  private boolean aoW = false;
  private ArrayList<Integer> aoX;
  
  public h(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private int bX(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.aoX.size())) {
      throw new IllegalArgumentException("Position " + paramInt + " is out of bounds for this buffer");
    }
    return ((Integer)this.aoX.get(paramInt)).intValue();
  }
  
  private void jQ()
  {
    for (;;)
    {
      int i;
      String str2;
      try
      {
        if (this.aoW) {
          break label190;
        }
        int j = this.aoy.aoJ;
        this.aoX = new ArrayList();
        if (j <= 0) {
          break label185;
        }
        this.aoX.add(Integer.valueOf(0));
        String str3 = jP();
        i = this.aoy.bV(0);
        String str1 = this.aoy.b(str3, 0, i);
        i = 1;
        if (i >= j) {
          break label185;
        }
        int k = this.aoy.bV(i);
        str2 = this.aoy.b(str3, i, k);
        if (str2 == null) {
          throw new NullPointerException("Missing value for markerColumn: " + str3 + ", at row: " + i + ", for window: " + k);
        }
      }
      finally {}
      if (!str2.equals(localObject1))
      {
        this.aoX.add(Integer.valueOf(i));
        Object localObject2 = str2;
        break label193;
        label185:
        this.aoW = true;
        label190:
        return;
      }
      label193:
      i += 1;
    }
  }
  
  public abstract T aj(int paramInt1, int paramInt2);
  
  public final T get(int paramInt)
  {
    jQ();
    int k = bX(paramInt);
    int j;
    if ((paramInt < 0) || (paramInt == this.aoX.size()))
    {
      j = 0;
      return (T)aj(k, j);
    }
    if (paramInt == this.aoX.size() - 1) {}
    for (int i = this.aoy.aoJ - ((Integer)this.aoX.get(paramInt)).intValue();; i = ((Integer)this.aoX.get(paramInt + 1)).intValue() - ((Integer)this.aoX.get(paramInt)).intValue())
    {
      j = i;
      if (i != 1) {
        break;
      }
      paramInt = bX(paramInt);
      this.aoy.bV(paramInt);
      j = i;
      break;
    }
  }
  
  public final int getCount()
  {
    jQ();
    return this.aoX.size();
  }
  
  public abstract String jP();
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/data/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */