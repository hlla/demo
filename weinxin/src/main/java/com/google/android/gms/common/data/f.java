package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import java.util.Arrays;

public abstract class f
{
  public int aoU;
  private int aoV;
  public final DataHolder aoy;
  
  public f(DataHolder paramDataHolder, int paramInt)
  {
    this.aoy = ((DataHolder)w.Z(paramDataHolder));
    if ((paramInt >= 0) && (paramInt < this.aoy.aoJ)) {}
    for (boolean bool = true;; bool = false)
    {
      w.ac(bool);
      this.aoU = paramInt;
      this.aoV = this.aoy.bV(this.aoU);
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof f))
    {
      paramObject = (f)paramObject;
      bool1 = bool2;
      if (v.d(Integer.valueOf(((f)paramObject).aoU), Integer.valueOf(this.aoU)))
      {
        bool1 = bool2;
        if (v.d(Integer.valueOf(((f)paramObject).aoV), Integer.valueOf(this.aoV)))
        {
          bool1 = bool2;
          if (((f)paramObject).aoy == this.aoy) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final byte[] getByteArray(String paramString)
  {
    DataHolder localDataHolder = this.aoy;
    int i = this.aoU;
    int j = this.aoV;
    localDataHolder.f(paramString, i);
    return localDataHolder.aoG[j].getBlob(i, localDataHolder.aoF.getInt(paramString));
  }
  
  public final int getInteger(String paramString)
  {
    DataHolder localDataHolder = this.aoy;
    int i = this.aoU;
    int j = this.aoV;
    localDataHolder.f(paramString, i);
    return localDataHolder.aoG[j].getInt(i, localDataHolder.aoF.getInt(paramString));
  }
  
  public final String getString(String paramString)
  {
    return this.aoy.b(paramString, this.aoU, this.aoV);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.aoU), Integer.valueOf(this.aoV), this.aoy });
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/data/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */