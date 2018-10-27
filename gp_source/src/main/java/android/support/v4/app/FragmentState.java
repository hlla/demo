package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentState
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new as();
  public final Bundle a;
  public final String b;
  public final int c;
  public final boolean d;
  public final int e;
  public final boolean f;
  public final boolean g;
  public final int h;
  public Fragment i;
  public final boolean j;
  public Bundle k;
  public final String l;
  
  FragmentState(Parcel paramParcel)
  {
    this.b = paramParcel.readString();
    this.h = paramParcel.readInt();
    if (paramParcel.readInt() != 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.f = bool1;
      this.e = paramParcel.readInt();
      this.c = paramParcel.readInt();
      this.l = paramParcel.readString();
      if (paramParcel.readInt() != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        this.j = bool1;
        if (paramParcel.readInt() != 0) {}
        for (bool1 = true;; bool1 = false)
        {
          this.d = bool1;
          this.a = paramParcel.readBundle();
          if (paramParcel.readInt() != 0) {}
          for (bool1 = bool2;; bool1 = false)
          {
            this.g = bool1;
            this.k = paramParcel.readBundle();
            return;
          }
        }
      }
    }
  }
  
  FragmentState(Fragment paramFragment)
  {
    this.b = paramFragment.getClass().getName();
    this.h = paramFragment.x;
    this.f = paramFragment.r;
    this.e = paramFragment.p;
    this.c = paramFragment.m;
    this.l = paramFragment.P;
    this.j = paramFragment.J;
    this.d = paramFragment.o;
    this.a = paramFragment.g;
    this.g = paramFragment.t;
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


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/FragmentState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */