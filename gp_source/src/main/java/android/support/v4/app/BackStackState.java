package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;

final class BackStackState
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new h();
  public final int a;
  public final CharSequence b;
  public final int c;
  public final CharSequence d;
  public final int e;
  public final String f;
  public final int[] g;
  public final boolean h;
  public final ArrayList i;
  public final ArrayList j;
  public final int k;
  public final int l;
  
  public BackStackState(Parcel paramParcel)
  {
    this.g = paramParcel.createIntArray();
    this.k = paramParcel.readInt();
    this.l = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.c = paramParcel.readInt();
    this.d = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.a = paramParcel.readInt();
    this.b = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    this.i = paramParcel.createStringArrayList();
    this.j = paramParcel.createStringArrayList();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.h = bool;
      return;
    }
  }
  
  public BackStackState(f paramf)
  {
    int i1 = paramf.l.size();
    this.g = new int[i1 * 6];
    if (paramf.a)
    {
      int m = 0;
      int n = 0;
      if (m < i1)
      {
        g localg = (g)paramf.l.get(m);
        int[] arrayOfInt = this.g;
        int i2 = n + 1;
        arrayOfInt[n] = localg.a;
        int i3 = i2 + 1;
        Fragment localFragment = localg.d;
        if (localFragment != null) {}
        for (n = localFragment.x;; n = -1)
        {
          arrayOfInt[i2] = n;
          n = i3 + 1;
          arrayOfInt[i3] = localg.b;
          i2 = n + 1;
          arrayOfInt[n] = localg.c;
          i3 = i2 + 1;
          arrayOfInt[i2] = localg.e;
          n = i3 + 1;
          arrayOfInt[i3] = localg.f;
          m += 1;
          break;
        }
      }
      this.k = paramf.r;
      this.l = paramf.s;
      this.f = paramf.k;
      this.e = paramf.i;
      this.c = paramf.d;
      this.d = paramf.e;
      this.a = paramf.b;
      this.b = paramf.c;
      this.i = paramf.p;
      this.j = paramf.q;
      this.h = paramf.o;
      return;
    }
    throw new IllegalStateException("Not on back stack");
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/BackStackState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */