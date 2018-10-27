package android.support.design.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.g.v;
import android.support.v4.view.AbsSavedState;

public class ExtendableSavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator CREATOR = new a();
  public final v a;
  
  ExtendableSavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    int j = paramParcel.readInt();
    paramClassLoader = new String[j];
    paramParcel.readStringArray(paramClassLoader);
    Bundle[] arrayOfBundle = new Bundle[j];
    paramParcel.readTypedArray(arrayOfBundle, Bundle.CREATOR);
    this.a = new v(j);
    int i = 0;
    while (i < j)
    {
      this.a.put(paramClassLoader[i], arrayOfBundle[i]);
      i += 1;
    }
  }
  
  public ExtendableSavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
    this.a = new v();
  }
  
  public String toString()
  {
    String str1 = Integer.toHexString(System.identityHashCode(this));
    String str2 = String.valueOf(this.a);
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 30 + String.valueOf(str2).length());
    localStringBuilder.append("ExtendableSavedState{");
    localStringBuilder.append(str1);
    localStringBuilder.append(" states=");
    localStringBuilder.append(str2);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    int i = this.a.size();
    paramParcel.writeInt(i);
    String[] arrayOfString = new String[i];
    Bundle[] arrayOfBundle = new Bundle[i];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfString[paramInt] = ((String)this.a.b(paramInt));
      arrayOfBundle[paramInt] = ((Bundle)this.a.c(paramInt));
      paramInt += 1;
    }
    paramParcel.writeStringArray(arrayOfString);
    paramParcel.writeTypedArray(arrayOfBundle, 0);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/design/stateful/ExtendableSavedState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */