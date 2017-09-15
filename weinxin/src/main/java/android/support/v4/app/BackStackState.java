package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;

final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator() {};
  final int mIndex;
  final String mName;
  final int nV;
  final int nW;
  final int[] oF;
  final int oa;
  final CharSequence ob;
  final int oc;
  final CharSequence od;
  final ArrayList<String> oe;
  final ArrayList<String> of;
  
  public BackStackState(Parcel paramParcel)
  {
    this.oF = paramParcel.createIntArray();
    this.nV = paramParcel.readInt();
    this.nW = paramParcel.readInt();
    this.mName = paramParcel.readString();
    this.mIndex = paramParcel.readInt();
    this.oa = paramParcel.readInt();
    this.ob = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.oc = paramParcel.readInt();
    this.od = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.oe = paramParcel.createStringArrayList();
    this.of = paramParcel.createStringArrayList();
  }
  
  public BackStackState(d paramd)
  {
    d.a locala = paramd.nO;
    int j;
    for (int i = 0; locala != null; i = j)
    {
      j = i;
      if (locala.oA != null) {
        j = i + locala.oA.size();
      }
      locala = locala.os;
    }
    this.oF = new int[i + paramd.nQ * 7];
    if (!paramd.nX) {
      throw new IllegalStateException("Not on back stack");
    }
    locala = paramd.nO;
    i = 0;
    if (locala != null)
    {
      int[] arrayOfInt = this.oF;
      j = i + 1;
      arrayOfInt[i] = locala.ou;
      arrayOfInt = this.oF;
      int k = j + 1;
      if (locala.ov != null) {}
      for (i = locala.ov.mIndex;; i = -1)
      {
        arrayOfInt[j] = i;
        arrayOfInt = this.oF;
        i = k + 1;
        arrayOfInt[k] = locala.ow;
        arrayOfInt = this.oF;
        j = i + 1;
        arrayOfInt[i] = locala.ox;
        arrayOfInt = this.oF;
        i = j + 1;
        arrayOfInt[j] = locala.oy;
        arrayOfInt = this.oF;
        j = i + 1;
        arrayOfInt[i] = locala.oz;
        if (locala.oA == null) {
          break label314;
        }
        k = locala.oA.size();
        arrayOfInt = this.oF;
        i = j + 1;
        arrayOfInt[j] = k;
        j = 0;
        while (j < k)
        {
          this.oF[i] = ((Fragment)locala.oA.get(j)).mIndex;
          j += 1;
          i += 1;
        }
      }
      for (;;)
      {
        locala = locala.os;
        break;
        label314:
        arrayOfInt = this.oF;
        i = j + 1;
        arrayOfInt[j] = 0;
      }
    }
    this.nV = paramd.nV;
    this.nW = paramd.nW;
    this.mName = paramd.mName;
    this.mIndex = paramd.mIndex;
    this.oa = paramd.oa;
    this.ob = paramd.ob;
    this.oc = paramd.oc;
    this.od = paramd.od;
    this.oe = paramd.oe;
    this.of = paramd.of;
  }
  
  public final d a(m paramm)
  {
    d locald = new d(paramm);
    int k = 0;
    int i = 0;
    while (i < this.oF.length)
    {
      d.a locala = new d.a();
      Object localObject = this.oF;
      int j = i + 1;
      locala.ou = localObject[i];
      if (m.DEBUG) {
        new StringBuilder("Instantiate ").append(locald).append(" op #").append(k).append(" base fragment #").append(this.oF[j]);
      }
      localObject = this.oF;
      i = j + 1;
      j = localObject[j];
      if (j >= 0) {}
      for (locala.ov = ((Fragment)paramm.qj.get(j));; locala.ov = null)
      {
        localObject = this.oF;
        j = i + 1;
        locala.ow = localObject[i];
        localObject = this.oF;
        i = j + 1;
        locala.ox = localObject[j];
        localObject = this.oF;
        j = i + 1;
        locala.oy = localObject[i];
        localObject = this.oF;
        i = j + 1;
        locala.oz = localObject[j];
        localObject = this.oF;
        j = i + 1;
        int n = localObject[i];
        i = j;
        if (n <= 0) {
          break;
        }
        locala.oA = new ArrayList(n);
        int m = 0;
        for (;;)
        {
          i = j;
          if (m >= n) {
            break;
          }
          if (m.DEBUG) {
            new StringBuilder("Instantiate ").append(locald).append(" set remove fragment #").append(this.oF[j]);
          }
          localObject = (Fragment)paramm.qj.get(this.oF[j]);
          locala.oA.add(localObject);
          m += 1;
          j += 1;
        }
      }
      locald.nR = locala.ow;
      locald.nS = locala.ox;
      locald.nT = locala.oy;
      locald.nU = locala.oz;
      locald.a(locala);
      k += 1;
    }
    locald.nV = this.nV;
    locald.nW = this.nW;
    locald.mName = this.mName;
    locald.mIndex = this.mIndex;
    locald.nX = true;
    locald.oa = this.oa;
    locald.ob = this.ob;
    locald.oc = this.oc;
    locald.od = this.od;
    locald.oe = this.oe;
    locald.of = this.of;
    locald.D(1);
    return locald;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeIntArray(this.oF);
    paramParcel.writeInt(this.nV);
    paramParcel.writeInt(this.nW);
    paramParcel.writeString(this.mName);
    paramParcel.writeInt(this.mIndex);
    paramParcel.writeInt(this.oa);
    TextUtils.writeToParcel(this.ob, paramParcel, 0);
    paramParcel.writeInt(this.oc);
    TextUtils.writeToParcel(this.od, paramParcel, 0);
    paramParcel.writeStringList(this.oe);
    paramParcel.writeStringList(this.of);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/app/BackStackState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */