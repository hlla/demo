package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ai.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class RegByMobileVoiceVerifySelectUI
  extends MMPreference
  implements e
{
  private f isp;
  private String pjF;
  private LanguagePreference.a[] uYJ;
  
  public RegByMobileVoiceVerifySelectUI()
  {
    GMTrace.i(2727035797504L, 20318);
    GMTrace.o(2727035797504L, 20318);
  }
  
  public static String SP(String paramString)
  {
    GMTrace.i(2727975321600L, 20325);
    LanguagePreference.a[] arrayOfa = bQP();
    paramString = b.jP(paramString);
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      LanguagePreference.a locala = arrayOfa[i];
      if (locala.uWm.equalsIgnoreCase(paramString))
      {
        paramString = locala.uWk;
        GMTrace.o(2727975321600L, 20325);
        return paramString;
      }
      i += 1;
    }
    GMTrace.o(2727975321600L, 20325);
    return "English";
  }
  
  private static LanguagePreference.a[] bQP()
  {
    GMTrace.i(2728109539328L, 20326);
    String[] arrayOfString1 = aa.getContext().getString(R.l.dOe).trim().split(",");
    LanguagePreference.a[] arrayOfa = new LanguagePreference.a[arrayOfString1.length];
    int i = 0;
    while (i < arrayOfString1.length)
    {
      String[] arrayOfString2 = arrayOfString1[i].trim().split(":");
      arrayOfa[i] = new LanguagePreference.a(arrayOfString2[1], arrayOfString2[2], arrayOfString2[0], false);
      i += 1;
    }
    GMTrace.o(2728109539328L, 20326);
    return arrayOfa;
  }
  
  protected final void KD()
  {
    GMTrace.i(2727841103872L, 20324);
    aGY();
    this.pjF = getIntent().getExtras().getString("voice_verify_code");
    zd(R.l.dOh);
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(2678046326784L, 19953);
        RegByMobileVoiceVerifySelectUI.this.aGY();
        RegByMobileVoiceVerifySelectUI.this.finish();
        GMTrace.o(2678046326784L, 19953);
        return true;
      }
    });
    this.uYJ = bQP();
    if ((this.uYJ == null) || (this.uYJ.length <= 0))
    {
      GMTrace.o(2727841103872L, 20324);
      return;
    }
    this.isp.removeAll();
    Object localObject = new PreferenceCategory(this);
    this.isp.a((Preference)localObject);
    localObject = this.uYJ;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      LanguagePreference.a locala = localObject[i];
      if (locala.uWm.equalsIgnoreCase(this.pjF)) {
        locala.mCG = true;
      }
      LanguagePreference localLanguagePreference = new LanguagePreference(this);
      localLanguagePreference.a(locala);
      localLanguagePreference.setKey(locala.uWm);
      this.isp.a(localLanguagePreference);
      i += 1;
    }
    GMTrace.o(2727841103872L, 20324);
  }
  
  public final int OO()
  {
    GMTrace.i(2727572668416L, 20322);
    int i = R.i.cVw;
    GMTrace.o(2727572668416L, 20322);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(2727170015232L, 20319);
    GMTrace.o(2727170015232L, 20319);
  }
  
  public final boolean a(f paramf, Preference paramPreference)
  {
    GMTrace.i(2727706886144L, 20323);
    if ((paramPreference instanceof LanguagePreference))
    {
      paramf = ((LanguagePreference)paramPreference).uWj;
      if (paramf == null)
      {
        GMTrace.o(2727706886144L, 20323);
        return false;
      }
      paramPreference = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("voice_verify_language", paramf.uWk);
      localBundle.putString("voice_verify_code", paramf.uWm);
      paramPreference.putExtras(localBundle);
      setResult(0, paramPreference);
      finish();
      GMTrace.o(2727706886144L, 20323);
      return true;
    }
    GMTrace.o(2727706886144L, 20323);
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2727304232960L, 20320);
    super.onCreate(paramBundle);
    this.isp = this.vpG;
    KD();
    GMTrace.o(2727304232960L, 20320);
  }
  
  protected void onDestroy()
  {
    GMTrace.i(2727438450688L, 20321);
    super.onDestroy();
    GMTrace.o(2727438450688L, 20321);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/RegByMobileVoiceVerifySelectUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */