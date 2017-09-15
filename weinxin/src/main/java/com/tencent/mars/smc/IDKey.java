package com.tencent.mars.smc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IDKey
  implements Parcelable
{
  public static final Parcelable.Creator<IDKey> CREATOR = new Parcelable.Creator()
  {
    public final IDKey createFromParcel(Parcel paramAnonymousParcel)
    {
      return new IDKey(paramAnonymousParcel);
    }
    
    public final IDKey[] newArray(int paramAnonymousInt)
    {
      return new IDKey[paramAnonymousInt];
    }
  };
  private long id;
  private long key;
  private long value;
  
  public IDKey()
  {
    this.id = 0L;
    this.key = 0L;
    this.value = 0L;
  }
  
  public IDKey(int paramInt1, int paramInt2, int paramInt3)
  {
    this.id = paramInt1;
    this.key = paramInt2;
    this.value = paramInt3;
  }
  
  protected IDKey(Parcel paramParcel)
  {
    this.id = paramParcel.readLong();
    this.key = paramParcel.readLong();
    this.value = paramParcel.readLong();
  }
  
  public long GetID()
  {
    return this.id;
  }
  
  public long GetKey()
  {
    return this.key;
  }
  
  public long GetValue()
  {
    return this.value;
  }
  
  public void SetID(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void SetKey(int paramInt)
  {
    this.key = paramInt;
  }
  
  public void SetValue(int paramInt)
  {
    this.value = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.id);
    paramParcel.writeLong(this.key);
    paramParcel.writeLong(this.value);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mars/smc/IDKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */