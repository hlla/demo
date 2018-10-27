package com.google.android.finsky.dh;

import java.util.Arrays;

public final class b
{
  public final String[] a;
  public final String[] b;
  public final boolean c;
  public final int d;
  public final long e;
  public final int f;
  public final boolean g;
  public final boolean h;
  public final boolean i;
  public final boolean j;
  public final boolean k;
  public final boolean l;
  public final boolean m;
  public final boolean n;
  public final String o;
  public final String[] p;
  public final int q;
  private final int r;
  
  public b(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramString, paramArrayOfString1, paramArrayOfString2, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramInt1, paramInt2, 0L, false, paramInt3, paramInt4, false, null, false, false, false);
  }
  
  public b(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean5, int paramInt3, int paramInt4, boolean paramBoolean6, String[] paramArrayOfString3, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9)
  {
    this.o = paramString;
    this.a = paramArrayOfString1;
    this.b = paramArrayOfString2;
    this.m = paramBoolean1;
    this.n = paramBoolean2;
    this.i = paramBoolean3;
    this.j = paramBoolean4;
    this.f = paramInt1;
    this.d = paramInt2;
    this.e = paramLong;
    this.g = paramBoolean5;
    this.q = paramInt3;
    this.r = paramInt4;
    this.h = paramBoolean6;
    this.p = paramArrayOfString3;
    this.k = paramBoolean7;
    this.c = paramBoolean8;
    this.l = paramBoolean9;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if (!(paramObject instanceof b)) {
        break label279;
      }
      paramObject = (b)paramObject;
      if (this.f != ((b)paramObject).f) {
        break label277;
      }
      if (this.d != ((b)paramObject).d) {
        break label275;
      }
      if (this.e != ((b)paramObject).e) {
        break label273;
      }
      if (this.g != ((b)paramObject).g) {
        break label271;
      }
      if (this.i != ((b)paramObject).i) {
        break label269;
      }
      if (this.j != ((b)paramObject).j) {
        break label267;
      }
      if (this.m != ((b)paramObject).m) {
        break label265;
      }
      if (this.n != ((b)paramObject).n) {
        break label263;
      }
      if (this.q != ((b)paramObject).q) {
        break label261;
      }
      if (this.r != ((b)paramObject).r) {
        break label259;
      }
      if (!Arrays.equals(this.a, ((b)paramObject).a)) {
        break label257;
      }
      if (!Arrays.equals(this.b, ((b)paramObject).b)) {
        break label255;
      }
      String str = this.o;
      if (str == null) {
        break label246;
      }
      if (!str.equals(((b)paramObject).o)) {
        break label253;
      }
    }
    label246:
    while (((b)paramObject).o == null)
    {
      if (this.h == ((b)paramObject).h)
      {
        if (Arrays.equals(this.p, ((b)paramObject).p))
        {
          if (this.k == ((b)paramObject).k)
          {
            if (this.c == ((b)paramObject).c) {
              return this.l == ((b)paramObject).l;
            }
            return false;
          }
          return false;
        }
        return false;
      }
      return false;
    }
    label253:
    return false;
    label255:
    return false;
    label257:
    return false;
    label259:
    return false;
    label261:
    return false;
    label263:
    return false;
    label265:
    return false;
    label267:
    return false;
    label269:
    return false;
    label271:
    return false;
    label273:
    return false;
    label275:
    return false;
    label277:
    return false;
    label279:
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public final String toString()
  {
    return String.format("(packageName=%s,installedVersion=%d,installedDerivedApkId=%d,installedFrostingId=%d,isSystemApp=%s,certificateHashes=%s,certificateMD5Hashes=%s,isAppDebuggable=%s,splitNames=%s,isInstantApp=%s,disableUpdatePreviewApp=%s,isPassive=%s)", new Object[] { this.o, Integer.valueOf(this.f), Integer.valueOf(this.d), Long.valueOf(this.e), Boolean.valueOf(this.m), Arrays.deepToString(this.a), Arrays.deepToString(this.b), Boolean.valueOf(this.h), Arrays.deepToString(this.p), Boolean.valueOf(this.k), Boolean.valueOf(this.c), Boolean.valueOf(this.l) });
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/dh/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */