package com.google.android.finsky.bw;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.a.a.a;
import android.support.v4.content.d;
import android.text.TextUtils;
import com.google.android.finsky.bo.c;
import com.google.android.finsky.bo.f;
import com.google.wireless.android.finsky.dfe.nano.gi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class h
{
  public static c a;
  public static boolean b;
  private static List c;
  
  public static int a(int paramInt)
  {
    int i = 2131099980;
    switch (paramInt)
    {
    case 5: 
    default: 
      paramInt = i;
      if (!b) {
        paramInt = 2131100095;
      }
    case 6: 
    case 4: 
    case 3: 
      do
      {
        return paramInt;
        return 2131100123;
        return 2131100080;
        paramInt = i;
      } while (b);
      return 2131099992;
    case 2: 
      return 2131100108;
    }
    return 2131100015;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      return -1;
    case 4: 
      return 2131886187;
    case 13: 
      return 2131886116;
    case 6: 
      return 2131886189;
    case 3: 
      if (paramInt2 != 1) {
        return 2131886140;
      }
      return 2131886129;
    case 2: 
      return 2131886165;
    }
    return 2131886185;
  }
  
  public static int a(Context paramContext, int paramInt)
  {
    return paramContext.getResources().getColor(c(paramInt));
  }
  
  public static int a(List paramList1, List paramList2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public static Drawable a(Context paramContext, int paramInt1, int paramInt2)
  {
    Drawable localDrawable = a.f(d.a(paramContext, paramInt1)).mutate();
    a.a(localDrawable, a(paramContext, paramInt2));
    return localDrawable;
  }
  
  public static String a(int paramInt, List paramList)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 3;
    }
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        gi localgi = (gi)paramList.next();
        if ((localgi.a == i) && (!TextUtils.isEmpty(localgi.c))) {
          return localgi.c;
        }
      }
      return null;
    }
    return null;
  }
  
  public static String a(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramResources = new StringBuilder(34);
      paramResources.append("Unsupported doc type (");
      paramResources.append(paramInt);
      paramResources.append(")");
      throw new IllegalArgumentException(paramResources.toString());
    case 64: 
      return paramResources.getString(2131953102, new Object[] { paramResources.getString(2131951757) });
    case 44: 
      return paramResources.getString(2131953104);
    case 20: 
      return paramResources.getString(2131953109);
    case 19: 
      return paramResources.getString(2131953110);
    case 18: 
      return paramResources.getString(2131953111);
    case 16: 
    case 17: 
    case 24: 
    case 25: 
      return paramResources.getString(2131953108);
    case 6: 
      return paramResources.getString(2131953105);
    case 5: 
      return paramResources.getString(2131953103);
    case 4: 
      return paramResources.getString(2131953107);
    case 2: 
      return paramResources.getString(2131953106);
    }
    return paramResources.getString(2131953101);
  }
  
  public static String a(String paramString, int paramInt, Resources paramResources)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    switch (paramInt)
    {
    default: 
      return null;
    case 64: 
      return paramResources.getString(2131951961, new Object[] { paramString });
    case 44: 
      return paramResources.getString(2131951963, new Object[] { paramString });
    case 18: 
    case 19: 
    case 20: 
      return paramResources.getString(2131951968, new Object[] { paramString });
    case 16: 
    case 17: 
    case 24: 
    case 25: 
      return paramResources.getString(2131951966, new Object[] { paramString });
    case 15: 
      return paramResources.getString(2131951967, new Object[] { paramString });
    case 8: 
      return paramResources.getString(2131951964, new Object[] { paramString });
    case 6: 
      return paramResources.getString(2131951965, new Object[] { paramString });
    case 5: 
      return paramResources.getString(2131951962, new Object[] { paramString });
    case 3: 
      return paramResources.getString(2131951960, new Object[] { paramString });
    case 2: 
    case 4: 
      return paramResources.getString(2131951958, new Object[] { paramString });
    }
    return paramResources.getString(2131951959, new Object[] { paramString });
  }
  
  public static List a()
  {
    if (c == null)
    {
      ArrayList localArrayList = new ArrayList();
      c = localArrayList;
      Collections.addAll(localArrayList, new Integer[] { Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(6) });
    }
    return c;
  }
  
  public static int b(int paramInt)
  {
    int i = 2131099985;
    switch (paramInt)
    {
    case 5: 
    default: 
      paramInt = i;
      if (!b) {
        paramInt = 2131100100;
      }
    case 6: 
    case 4: 
    case 3: 
      do
      {
        return paramInt;
        return 2131100128;
        return 2131100085;
        paramInt = i;
      } while (b);
      return 2131099997;
    case 2: 
      return 2131100113;
    }
    return 2131100020;
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 5: 
    default: 
      StringBuilder localStringBuilder = new StringBuilder(35);
      localStringBuilder.append("Unsupported backendId (");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(")");
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 4: 
      return 2131951998;
    case 6: 
      return 2131952000;
    case 3: 
      if (paramInt2 != 1)
      {
        if (a.cY().a(12657575L)) {
          return 2131952602;
        }
        return 2131952605;
      }
      return 2131952344;
    case 2: 
      return 2131951999;
    }
    return 2131951997;
  }
  
  public static ColorStateList b(Context paramContext, int paramInt)
  {
    return paramContext.getResources().getColorStateList(d(paramInt));
  }
  
  public static int c(int paramInt)
  {
    int i = 2131099980;
    switch (paramInt)
    {
    case 5: 
    default: 
      paramInt = i;
      if (!b) {
        paramInt = 2131100095;
      }
    case 6: 
    case 4: 
    case 3: 
      do
      {
        return paramInt;
        return 2131100123;
        return 2131100080;
        paramInt = i;
      } while (b);
      return 2131099992;
    case 2: 
      return 2131100108;
    }
    return 2131100015;
  }
  
  public static int c(Context paramContext, int paramInt)
  {
    return paramContext.getResources().getColor(e(paramInt));
  }
  
  public static int d(int paramInt)
  {
    int i = 2131099985;
    switch (paramInt)
    {
    case 5: 
    default: 
      paramInt = i;
      if (!b) {
        paramInt = 2131100100;
      }
    case 6: 
    case 4: 
    case 3: 
      do
      {
        return paramInt;
        return 2131100128;
        return 2131100085;
        paramInt = i;
      } while (b);
      return 2131099997;
    case 2: 
      return 2131100113;
    }
    return 2131100020;
  }
  
  public static ColorStateList d(Context paramContext, int paramInt)
  {
    int i = 2131099989;
    switch (paramInt)
    {
    case 5: 
    default: 
      if (b) {
        paramInt = i;
      }
      break;
    }
    for (;;)
    {
      return paramContext.getResources().getColorStateList(paramInt);
      paramInt = 2131100104;
      continue;
      paramInt = 2131100024;
      continue;
      paramInt = 2131100132;
      continue;
      paramInt = 2131100089;
      continue;
      paramInt = i;
      if (!b)
      {
        paramInt = 2131100001;
        continue;
        paramInt = 2131100117;
      }
    }
  }
  
  public static int e(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      if (!b) {
        break;
      }
    case 13: 
    case 6: 
    case 4: 
    case 3: 
      do
      {
        return 2131099988;
        return 2131100103;
        return 2131100103;
        return 2131100132;
        return 2131100089;
      } while (b);
      return 2131100001;
    case 2: 
      return 2131100117;
    }
    return 2131100024;
  }
  
  public static ColorStateList e(Context paramContext, int paramInt)
  {
    int i = 2131099982;
    switch (paramInt)
    {
    case 5: 
    default: 
      if (b) {
        paramInt = i;
      }
      break;
    }
    for (;;)
    {
      return paramContext.getResources().getColorStateList(paramInt);
      paramInt = 2131100097;
      continue;
      paramInt = 2131100017;
      continue;
      paramInt = 2131100125;
      continue;
      paramInt = 2131100082;
      continue;
      paramInt = i;
      if (!b)
      {
        paramInt = 2131099994;
        continue;
        paramInt = 2131100110;
      }
    }
  }
  
  public static int f(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 64: 
      return 2131951913;
    case 44: 
      return 2131951915;
    case 28: 
      return 2131951943;
    case 20: 
      return 2131951977;
    case 19: 
      return 2131951978;
    case 18: 
      return 2131951979;
    case 16: 
    case 17: 
    case 24: 
    case 25: 
      return 2131951946;
    case 8: 
      return 2131951924;
    case 6: 
      return 2131951935;
    case 5: 
      return 2131951916;
    case 4: 
      return 2131951938;
    case 3: 
      return 2131951937;
    case 2: 
      return 2131951936;
    }
    return 2131951912;
  }
  
  public static int f(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    switch (paramInt)
    {
    default: 
      paramContext = new StringBuilder(39);
      paramContext.append("Unsupported document type (");
      paramContext.append(paramInt);
      paramContext.append(")");
      throw new IllegalArgumentException(paramContext.toString());
    case 8: 
    case 30: 
      return paramContext.getDimensionPixelSize(2131166947);
    case 3: 
    case 5: 
    case 6: 
    case 16: 
    case 17: 
    case 44: 
    case 64: 
      return paramContext.getDimensionPixelSize(2131167372);
    case 2: 
    case 4: 
    case 24: 
    case 25: 
      return paramContext.getDimensionPixelSize(2131167370);
    }
    return paramContext.getDimensionPixelSize(2131167369);
  }
  
  public static int g(int paramInt)
  {
    int i = 2131231221;
    switch (paramInt)
    {
    case 5: 
    default: 
      paramInt = i;
      if (!b) {
        paramInt = 2131231245;
      }
    case 6: 
    case 4: 
    case 3: 
      do
      {
        return paramInt;
        return 2131231257;
        return 2131231239;
        paramInt = i;
      } while (b);
      return 2131231224;
    case 2: 
      return 2131231251;
    }
    return 2131231230;
  }
  
  public static int g(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getResources();
    switch (paramInt)
    {
    default: 
      paramContext = new StringBuilder(39);
      paramContext.append("Unsupported document type (");
      paramContext.append(paramInt);
      paramContext.append(")");
      throw new IllegalArgumentException(paramContext.toString());
    case 44: 
      return paramContext.getDimensionPixelSize(2131167372);
    case 8: 
    case 30: 
      return paramContext.getDimensionPixelSize(2131166947);
    case 3: 
      return paramContext.getDimensionPixelSize(2131167372) / 2;
    case 2: 
    case 4: 
    case 5: 
    case 6: 
    case 16: 
    case 17: 
    case 24: 
    case 25: 
    case 64: 
      return paramContext.getDimensionPixelSize(2131167370);
    }
    return paramContext.getDimensionPixelSize(2131167369);
  }
  
  public static int h(int paramInt)
  {
    int i = 2131231219;
    switch (paramInt)
    {
    case 5: 
    case 7: 
    case 8: 
    case 9: 
    default: 
      paramInt = i;
      if (!b) {
        paramInt = 2131231242;
      }
    case 10: 
    case 6: 
    case 4: 
    case 3: 
      do
      {
        return paramInt;
        return 2131231233;
        return 2131231254;
        return 2131231236;
        paramInt = i;
      } while (b);
      return 2131231216;
    case 2: 
      return 2131231248;
    }
    return 2131231227;
  }
  
  public static int h(Context paramContext, int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      paramContext = new StringBuilder(36);
      paramContext.append("Unsupported backend ID (");
      paramContext.append(paramInt);
      paramContext.append(")");
      throw new IllegalArgumentException(paramContext.toString());
    case 3: 
      if (!b) {
        paramInt = 2131100387;
      }
      break;
    }
    for (;;)
    {
      return paramContext.getResources().getColor(paramInt);
      paramInt = 2131100388;
      continue;
      paramInt = 2131100389;
      continue;
      paramInt = 2131100392;
      continue;
      paramInt = 2131100390;
      continue;
      paramInt = 2131100391;
    }
  }
  
  public static int i(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      StringBuilder localStringBuilder = new StringBuilder(36);
      localStringBuilder.append("Unsupported backend ID (");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(")");
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 6: 
      return 2131100214;
    case 4: 
      return 2131100212;
    case 3: 
      return 2131100210;
    case 2: 
      return 2131100213;
    }
    return 2131100211;
  }
  
  public static int i(Context paramContext, int paramInt)
  {
    int i = 2131100278;
    switch (paramInt)
    {
    case 5: 
    default: 
      paramInt = i;
      if (!b) {
        paramInt = 2131100282;
      }
      break;
    }
    for (;;)
    {
      return paramContext.getResources().getColor(paramInt);
      paramInt = 2131100279;
      continue;
      paramInt = 2131100284;
      continue;
      paramInt = 2131100281;
      continue;
      paramInt = i;
      if (!b)
      {
        paramInt = 2131100277;
        continue;
        paramInt = 2131100283;
      }
    }
  }
  
  public static int j(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return -1;
    case 6: 
      return 2131886195;
    case 4: 
      return 2131886193;
    case 3: 
      return 2131886147;
    case 2: 
      return 2131886194;
    }
    return 2131886192;
  }
  
  public static Drawable j(Context paramContext, int paramInt)
  {
    return a(paramContext, 2131231103, paramInt);
  }
  
  public static ColorStateList k(Context paramContext, int paramInt)
  {
    int j = c(paramInt);
    int[] arrayOfInt = { 16842908 };
    paramInt = paramContext.getResources().getColor(j);
    int i = paramContext.getResources().getColor(j);
    j = paramContext.getResources().getColor(j);
    int k = paramContext.getResources().getColor(2131100168);
    return new ColorStateList(new int[][] { { 16842913 }, arrayOfInt, { 16842919 }, new int[0] }, new int[] { paramInt, i, j, k });
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/com/google/android/finsky/bw/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */