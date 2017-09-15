package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentState
  implements Parcelable
{
  public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator() {};
  final int mIndex;
  final String mTag;
  Bundle oT;
  final Bundle oW;
  final boolean pc;
  final int pk;
  final int pl;
  final boolean pn;
  final boolean po;
  final String qU;
  Fragment qV;
  
  public FragmentState(Parcel paramParcel)
  {
    this.qU = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      this.pc = bool1;
      this.pk = paramParcel.readInt();
      this.pl = paramParcel.readInt();
      this.mTag = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label110;
      }
      bool1 = true;
      label69:
      this.po = bool1;
      if (paramParcel.readInt() == 0) {
        break label115;
      }
    }
    label110:
    label115:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.pn = bool1;
      this.oW = paramParcel.readBundle();
      this.oT = paramParcel.readBundle();
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label69;
    }
  }
  
  public FragmentState(Fragment paramFragment)
  {
    this.qU = paramFragment.getClass().getName();
    this.mIndex = paramFragment.mIndex;
    this.pc = paramFragment.pc;
    this.pk = paramFragment.pk;
    this.pl = paramFragment.pl;
    this.mTag = paramFragment.mTag;
    this.po = paramFragment.po;
    this.pn = paramFragment.pn;
    this.oW = paramFragment.oW;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeString(this.qU);
    paramParcel.writeInt(this.mIndex);
    if (this.pc)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.pk);
      paramParcel.writeInt(this.pl);
      paramParcel.writeString(this.mTag);
      if (!this.po) {
        break label106;
      }
      paramInt = 1;
      label65:
      paramParcel.writeInt(paramInt);
      if (!this.pn) {
        break label111;
      }
    }
    label106:
    label111:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeBundle(this.oW);
      paramParcel.writeBundle(this.oT);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label65;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/app/FragmentState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */