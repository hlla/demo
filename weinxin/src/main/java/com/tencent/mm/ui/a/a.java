package com.tencent.mm.ui.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Vibrator;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.u;
import java.util.Locale;

public final class a
{
  Vibrator jWR;
  private AccessibilityManager jl;
  public Context ty;
  public TextToSpeech uVf;
  
  public a(Context paramContext)
  {
    GMTrace.i(1875155877888L, 13971);
    this.uVf = null;
    this.ty = paramContext;
    this.jl = ((AccessibilityManager)this.ty.getSystemService("accessibility"));
    GMTrace.o(1875155877888L, 13971);
  }
  
  public final void F(View paramView, int paramInt)
  {
    GMTrace.i(14612552482816L, 108872);
    if (!bQx())
    {
      GMTrace.o(14612552482816L, 108872);
      return;
    }
    if ((this.ty == null) || (paramView == null))
    {
      GMTrace.o(14612552482816L, 108872);
      return;
    }
    paramInt = Math.max(paramInt, 1);
    b localb = new b();
    localb.SJ(this.ty.getResources().getQuantityString(a.i.heG, paramInt, new Object[] { Integer.valueOf(paramInt) }));
    localb.cX(paramView);
    GMTrace.o(14612552482816L, 108872);
  }
  
  public final void a(View paramView, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    GMTrace.i(1875424313344L, 13973);
    if (!bQx())
    {
      GMTrace.o(1875424313344L, 13973);
      return;
    }
    if ((this.ty == null) || (paramView == null))
    {
      GMTrace.o(1875424313344L, 13973);
      return;
    }
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null))
    {
      GMTrace.o(1875424313344L, 13973);
      return;
    }
    b localb = new b();
    localb.SJ(paramString1);
    if (paramInt > 0) {
      localb.SJ(this.ty.getResources().getQuantityString(a.i.heH, 1, new Object[] { Integer.valueOf(paramInt) }));
    }
    localb.SJ(paramString2).SJ(paramString3);
    localb.cX(paramView);
    GMTrace.o(1875424313344L, 13973);
  }
  
  public final boolean bQx()
  {
    GMTrace.i(1875290095616L, 13972);
    boolean bool1 = this.jl.isEnabled();
    boolean bool2 = this.jl.isTouchExplorationEnabled();
    if ((bool1) && (bool2))
    {
      GMTrace.o(1875290095616L, 13972);
      return true;
    }
    GMTrace.o(1875290095616L, 13972);
    return false;
  }
  
  private static final class a
  {
    public static final a uVh;
    
    static
    {
      GMTrace.i(1875692748800L, 13975);
      uVh = new a(aa.getContext());
      GMTrace.o(1875692748800L, 13975);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */