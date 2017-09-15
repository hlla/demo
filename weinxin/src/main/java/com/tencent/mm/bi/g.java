package com.tencent.mm.bi;

import android.content.Context;
import android.text.SpannableString;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.pluginsdk.ui.d.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bf;

public final class g
  implements d
{
  private static g uxc;
  private int uxb;
  
  private g()
  {
    GMTrace.i(4517097635840L, 33655);
    this.uxb = 300;
    GMTrace.o(4517097635840L, 33655);
  }
  
  public static g bKx()
  {
    GMTrace.i(4517231853568L, 33656);
    if (uxc == null) {
      uxc = new g();
    }
    g localg = uxc;
    GMTrace.o(4517231853568L, 33656);
    return localg;
  }
  
  public final SpannableString b(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    GMTrace.i(4517366071296L, 33657);
    if ((paramCharSequence == null) || (bf.mA(paramCharSequence.toString())))
    {
      paramContext = new SpannableString("");
      GMTrace.o(4517366071296L, 33657);
      return paramContext;
    }
    if ((paramCharSequence == null) || (bf.mA(paramCharSequence.toString())))
    {
      paramContext = new SpannableString("");
      GMTrace.o(4517366071296L, 33657);
      return paramContext;
    }
    if ((paramCharSequence instanceof SpannableString)) {}
    for (paramContext = (SpannableString)paramCharSequence;; paramContext = new SpannableString(paramCharSequence))
    {
      paramCharSequence = new PInt();
      paramCharSequence.value = this.uxb;
      paramContext = b.bKo().a(paramContext, paramInt, paramCharSequence);
      paramContext = f.bKu().a(paramContext, paramInt, paramCharSequence.value);
      GMTrace.o(4517366071296L, 33657);
      return paramContext;
    }
  }
  
  public final SpannableString d(Context paramContext, CharSequence paramCharSequence, float paramFloat)
  {
    GMTrace.i(4517500289024L, 33658);
    if ((paramCharSequence == null) || (bf.mA(paramCharSequence.toString())))
    {
      paramContext = new SpannableString("");
      GMTrace.o(4517500289024L, 33658);
      return paramContext;
    }
    paramContext = b(paramContext, paramCharSequence, (int)paramFloat);
    GMTrace.o(4517500289024L, 33658);
    return paramContext;
  }
  
  public final boolean x(CharSequence paramCharSequence)
  {
    GMTrace.i(18616133091328L, 138701);
    if (f.bKu().Qy(paramCharSequence.toString()) != null)
    {
      GMTrace.o(18616133091328L, 138701);
      return true;
    }
    GMTrace.o(18616133091328L, 138701);
    return false;
  }
  
  public final boolean y(CharSequence paramCharSequence)
  {
    GMTrace.i(18616267309056L, 138702);
    b.bKo();
    boolean bool = b.Qw(paramCharSequence.toString());
    GMTrace.o(18616267309056L, 138702);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/bi/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */