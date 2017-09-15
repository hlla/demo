package com.tencent.mm.protocal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JsapiPermissionWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<JsapiPermissionWrapper> CREATOR;
  public static final JsapiPermissionWrapper sXt;
  public static final JsapiPermissionWrapper sXu;
  public static final JsapiPermissionWrapper sXv;
  public static final JsapiPermissionWrapper sXw;
  private Set<Integer> sXA;
  public byte[] sXx;
  private int sXy;
  private Set<Integer> sXz;
  
  static
  {
    GMTrace.i(4058207223808L, 30236);
    sXt = new JsapiPermissionWrapper(1);
    sXu = new JsapiPermissionWrapper(2);
    sXv = new JsapiPermissionWrapper(3);
    sXw = new JsapiPermissionWrapper(4);
    CREATOR = new Parcelable.Creator() {};
    GMTrace.o(4058207223808L, 30236);
  }
  
  public JsapiPermissionWrapper()
  {
    GMTrace.i(4055791304704L, 30218);
    this.sXx = null;
    this.sXy = 0;
    this.sXx = null;
    GMTrace.o(4055791304704L, 30218);
  }
  
  public JsapiPermissionWrapper(int paramInt)
  {
    GMTrace.i(4056059740160L, 30220);
    this.sXx = null;
    this.sXy = 0;
    this.sXy = paramInt;
    this.sXx = new byte[0];
    GMTrace.o(4056059740160L, 30220);
  }
  
  public JsapiPermissionWrapper(Parcel paramParcel)
  {
    GMTrace.i(4056999264256L, 30227);
    this.sXx = null;
    this.sXy = 0;
    this.sXx = paramParcel.createByteArray();
    this.sXy = paramParcel.readInt();
    o(paramParcel.createIntArray());
    p(paramParcel.createIntArray());
    GMTrace.o(4056999264256L, 30227);
  }
  
  public JsapiPermissionWrapper(byte[] paramArrayOfByte)
  {
    GMTrace.i(4055925522432L, 30219);
    this.sXx = null;
    this.sXy = 0;
    if (paramArrayOfByte == null)
    {
      this.sXx = null;
      GMTrace.o(4055925522432L, 30219);
      return;
    }
    this.sXx = paramArrayOfByte;
    GMTrace.o(4055925522432L, 30219);
  }
  
  public static boolean bHc()
  {
    GMTrace.i(4056462393344L, 30223);
    GMTrace.o(4056462393344L, 30223);
    return true;
  }
  
  private int[] bHd()
  {
    GMTrace.i(4057401917440L, 30230);
    if (this.sXz != null)
    {
      int[] arrayOfInt = new int[this.sXz.size()];
      Iterator localIterator = this.sXz.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (localInteger == null) {}
        for (int j = 0;; j = localInteger.intValue())
        {
          arrayOfInt[i] = j;
          i += 1;
          break;
        }
      }
      GMTrace.o(4057401917440L, 30230);
      return arrayOfInt;
    }
    GMTrace.o(4057401917440L, 30230);
    return new int[0];
  }
  
  private int[] bHe()
  {
    GMTrace.i(4057670352896L, 30232);
    if (this.sXA != null)
    {
      int[] arrayOfInt = new int[this.sXA.size()];
      Iterator localIterator = this.sXA.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        if (localInteger == null) {}
        for (int j = 0;; j = localInteger.intValue())
        {
          arrayOfInt[i] = j;
          i += 1;
          break;
        }
      }
      GMTrace.o(4057670352896L, 30232);
      return arrayOfInt;
    }
    GMTrace.o(4057670352896L, 30232);
    return new int[0];
  }
  
  public final void a(int paramInt, byte paramByte)
  {
    int i = 0;
    GMTrace.i(17506555133952L, 130434);
    if ((this.sXx == null) || (paramInt < 0) || (paramInt >= this.sXx.length))
    {
      if (this.sXx == null) {}
      for (;;)
      {
        v.e("MicroMsg.JsapiPermissionWrapper", "setPermission pos out of range, %s, %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        GMTrace.o(17506555133952L, 130434);
        return;
        i = this.sXx.length;
      }
    }
    this.sXx[paramInt] = paramByte;
    GMTrace.o(17506555133952L, 130434);
  }
  
  public int describeContents()
  {
    GMTrace.i(4056730828800L, 30225);
    GMTrace.o(4056730828800L, 30225);
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    GMTrace.i(4057938788352L, 30234);
    if (!(paramObject instanceof JsapiPermissionWrapper))
    {
      GMTrace.o(4057938788352L, 30234);
      return false;
    }
    paramObject = (JsapiPermissionWrapper)paramObject;
    if (this.sXx == ((JsapiPermissionWrapper)paramObject).sXx)
    {
      GMTrace.o(4057938788352L, 30234);
      return true;
    }
    if ((this.sXx == null) || (((JsapiPermissionWrapper)paramObject).sXx == null) || (this.sXx.length != ((JsapiPermissionWrapper)paramObject).sXx.length))
    {
      GMTrace.o(4057938788352L, 30234);
      return false;
    }
    int i = 0;
    while (i < this.sXx.length)
    {
      if (this.sXx[i] != paramObject.sXx[i])
      {
        GMTrace.o(4057938788352L, 30234);
        return false;
      }
      i += 1;
    }
    GMTrace.o(4057938788352L, 30234);
    return true;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    GMTrace.i(4057267699712L, 30229);
    this.sXx = paramBundle.getByteArray("jsapi_perm_wrapper_bytes");
    this.sXy = paramBundle.getInt("jsapi_perm_wrapper_hardcodePermission");
    o(paramBundle.getIntArray("jsapi_perm_wrapper_blacklist"));
    p(paramBundle.getIntArray("jsapi_perm_wrapper_whitelist"));
    GMTrace.o(4057267699712L, 30229);
  }
  
  public final boolean ns(int paramInt)
  {
    GMTrace.i(4056328175616L, 30222);
    if (xS(paramInt) == 1)
    {
      GMTrace.o(4056328175616L, 30222);
      return true;
    }
    GMTrace.o(4056328175616L, 30222);
    return false;
  }
  
  public final void o(int[] paramArrayOfInt)
  {
    GMTrace.i(4057536135168L, 30231);
    if (this.sXz == null) {
      this.sXz = new HashSet();
    }
    while ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        this.sXz.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
      this.sXz.clear();
    }
    GMTrace.o(4057536135168L, 30231);
  }
  
  public final void p(int[] paramArrayOfInt)
  {
    GMTrace.i(4057804570624L, 30233);
    if (this.sXA == null) {
      this.sXA = new HashSet();
    }
    while ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        this.sXA.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
      this.sXA.clear();
    }
    GMTrace.o(4057804570624L, 30233);
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    GMTrace.i(4057133481984L, 30228);
    paramBundle.putByteArray("jsapi_perm_wrapper_bytes", this.sXx);
    paramBundle.putInt("jsapi_perm_wrapper_hardcodePermission", this.sXy);
    paramBundle.putIntArray("jsapi_perm_wrapper_blacklist", bHd());
    paramBundle.putIntArray("jsapi_perm_wrapper_whitelist", bHe());
    GMTrace.o(4057133481984L, 30228);
  }
  
  public String toString()
  {
    GMTrace.i(4056596611072L, 30224);
    if (this.sXx == null)
    {
      GMTrace.o(4056596611072L, 30224);
      return "null";
    }
    long l = System.currentTimeMillis();
    Object localObject = new StringBuilder(180);
    byte[] arrayOfByte = this.sXx;
    int j = arrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append(arrayOfByte[i]);
      i += 1;
    }
    localObject = ((StringBuilder)localObject).toString();
    v.d("MicroMsg.JsapiPermissionWrapper", "toString cost %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    GMTrace.o(4056596611072L, 30224);
    return (String)localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GMTrace.i(4056865046528L, 30226);
    paramParcel.writeByteArray(this.sXx);
    paramParcel.writeInt(this.sXy);
    paramParcel.writeIntArray(bHd());
    paramParcel.writeIntArray(bHe());
    GMTrace.o(4056865046528L, 30226);
  }
  
  public final int xS(int paramInt)
  {
    GMTrace.i(4056193957888L, 30221);
    if ((this.sXA != null) && (this.sXA.contains(Integer.valueOf(paramInt)))) {}
    for (int i = 1; i != 0; i = 0)
    {
      GMTrace.o(4056193957888L, 30221);
      return 1;
    }
    if ((this.sXz != null) && (this.sXz.contains(Integer.valueOf(paramInt)))) {}
    for (i = 1; i != 0; i = 0)
    {
      GMTrace.o(4056193957888L, 30221);
      return 0;
    }
    if (this.sXy == 1)
    {
      if ((paramInt == 34) || (paramInt == 75))
      {
        v.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
        GMTrace.o(4056193957888L, 30221);
        return 0;
      }
      GMTrace.o(4056193957888L, 30221);
      return 1;
    }
    if (this.sXy == 2)
    {
      if (paramInt == -3)
      {
        GMTrace.o(4056193957888L, 30221);
        return 1;
      }
      GMTrace.o(4056193957888L, 30221);
      return 0;
    }
    if (this.sXy == 3)
    {
      if ((paramInt == 34) || (paramInt == 75) || (paramInt == 23))
      {
        v.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
        GMTrace.o(4056193957888L, 30221);
        return 0;
      }
      GMTrace.o(4056193957888L, 30221);
      return 1;
    }
    if (this.sXy == 4)
    {
      if ((paramInt == 34) || (paramInt == 75))
      {
        v.i("MicroMsg.JsapiPermissionWrapper", "hy: on reserved bytes control : %d", new Object[] { Integer.valueOf(paramInt) });
        GMTrace.o(4056193957888L, 30221);
        return 0;
      }
      GMTrace.o(4056193957888L, 30221);
      return 1;
    }
    if ((paramInt == -2) || (paramInt == -3))
    {
      GMTrace.o(4056193957888L, 30221);
      return 1;
    }
    if ((this.sXx == null) || (paramInt < 0) || (paramInt >= this.sXx.length))
    {
      GMTrace.o(4056193957888L, 30221);
      return 0;
    }
    paramInt = this.sXx[paramInt];
    GMTrace.o(4056193957888L, 30221);
    return paramInt;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/protocal/JsapiPermissionWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */