package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.l;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.aa;

public abstract class h
  extends Fragment
{
  public boolean uOa;
  public boolean uOb;
  private FragmentActivity uOc;
  
  public h()
  {
    GMTrace.i(2079435259904L, 15493);
    this.uOb = false;
    this.uOa = false;
    GMTrace.o(2079435259904L, 15493);
  }
  
  public h(boolean paramBoolean)
  {
    GMTrace.i(2079301042176L, 15492);
    this.uOb = false;
    this.uOa = paramBoolean;
    GMTrace.o(2079301042176L, 15492);
  }
  
  public final SharedPreferences SA(String paramString)
  {
    GMTrace.i(2080106348544L, 15498);
    paramString = bOZ().getSharedPreferences(paramString, 0);
    GMTrace.o(2080106348544L, 15498);
    return paramString;
  }
  
  public final long SB(String paramString)
  {
    GMTrace.i(2081582743552L, 15509);
    long l;
    if ((this.uOa) && (this.oW == null))
    {
      l = bOZ().getIntent().getLongExtra(paramString, -1L);
      GMTrace.o(2081582743552L, 15509);
      return l;
    }
    if (this.oW != null)
    {
      l = this.oW.getLong(paramString, -1L);
      GMTrace.o(2081582743552L, 15509);
      return l;
    }
    GMTrace.o(2081582743552L, 15509);
    return -1L;
  }
  
  public final Boolean aS(String paramString, boolean paramBoolean)
  {
    GMTrace.i(2081448525824L, 15508);
    if ((this.uOa) && (this.oW == null))
    {
      paramBoolean = bOZ().getIntent().getBooleanExtra(paramString, paramBoolean);
      GMTrace.o(2081448525824L, 15508);
      return Boolean.valueOf(paramBoolean);
    }
    paramBoolean = this.oW.getBoolean(paramString, paramBoolean);
    GMTrace.o(2081448525824L, 15508);
    return Boolean.valueOf(paramBoolean);
  }
  
  public FragmentActivity bOZ()
  {
    GMTrace.i(2080240566272L, 15499);
    if (this.uOc == null) {
      this.uOc = aG();
    }
    FragmentActivity localFragmentActivity = this.uOc;
    GMTrace.o(2080240566272L, 15499);
    return localFragmentActivity;
  }
  
  public final void bPa()
  {
    GMTrace.i(2081716961280L, 15510);
    if (this.uOa) {
      bOZ().setResult(-1);
    }
    GMTrace.o(2081716961280L, 15510);
  }
  
  public final View findViewById(int paramInt)
  {
    GMTrace.i(2080374784000L, 15500);
    View localView2 = this.mView;
    View localView1 = null;
    if (localView2 != null) {
      localView1 = localView2.findViewById(paramInt);
    }
    if (localView1 != null)
    {
      GMTrace.o(2080374784000L, 15500);
      return localView1;
    }
    localView1 = bOZ().findViewById(paramInt);
    GMTrace.o(2080374784000L, 15500);
    return localView1;
  }
  
  public void finish()
  {
    GMTrace.i(2079703695360L, 15495);
    if (this.uOa)
    {
      if (bOZ() != null)
      {
        bOZ().finish();
        GMTrace.o(2079703695360L, 15495);
      }
    }
    else if (bOZ() != null) {
      bOZ().aR().popBackStack();
    }
    GMTrace.o(2079703695360L, 15495);
  }
  
  public final int getIntExtra(String paramString, int paramInt)
  {
    GMTrace.i(2079837913088L, 15496);
    if ((this.uOa) && (this.oW == null) && (bOZ() != null))
    {
      paramInt = bOZ().getIntent().getIntExtra(paramString, paramInt);
      GMTrace.o(2079837913088L, 15496);
      return paramInt;
    }
    if (this.oW != null)
    {
      paramInt = this.oW.getInt(paramString, paramInt);
      GMTrace.o(2079837913088L, 15496);
      return paramInt;
    }
    GMTrace.o(2079837913088L, 15496);
    return paramInt;
  }
  
  public final String getStringExtra(String paramString)
  {
    GMTrace.i(2079972130816L, 15497);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.uOa)
    {
      localObject1 = localObject2;
      if (bOZ() != null) {
        localObject1 = bOZ().getIntent().getStringExtra(paramString);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.oW != null) {
        localObject2 = this.oW.getString(paramString);
      }
    }
    GMTrace.o(2079972130816L, 15497);
    return (String)localObject2;
  }
  
  public final WindowManager getWindowManager()
  {
    GMTrace.i(2081180090368L, 15506);
    if (bOZ() != null)
    {
      WindowManager localWindowManager = bOZ().getWindowManager();
      GMTrace.o(2081180090368L, 15506);
      return localWindowManager;
    }
    GMTrace.o(2081180090368L, 15506);
    return null;
  }
  
  public final boolean isFinishing()
  {
    GMTrace.i(2080911654912L, 15504);
    if (bOZ() == null)
    {
      GMTrace.o(2080911654912L, 15504);
      return true;
    }
    boolean bool = bOZ().isFinishing();
    GMTrace.o(2080911654912L, 15504);
    return bool;
  }
  
  public final boolean isShowing()
  {
    GMTrace.i(2081985396736L, 15512);
    if (!this.uOb)
    {
      GMTrace.o(2081985396736L, 15512);
      return true;
    }
    GMTrace.o(2081985396736L, 15512);
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2079032606720L, 15490);
    super.onCreate(paramBundle);
    this.uOc = aG();
    GMTrace.o(2079032606720L, 15490);
  }
  
  public void onDestroy()
  {
    GMTrace.i(2079166824448L, 15491);
    super.onDestroy();
    this.uOb = true;
    GMTrace.o(2079166824448L, 15491);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2080643219456L, 15502);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      finish();
      GMTrace.o(2080643219456L, 15502);
      return true;
    }
    if ((paramInt == 82) && (paramKeyEvent.getAction() == 1))
    {
      boolean bool = onKeyUp(paramInt, paramKeyEvent);
      GMTrace.o(2080643219456L, 15502);
      return bool;
    }
    GMTrace.o(2080643219456L, 15502);
    return false;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2080777437184L, 15503);
    GMTrace.o(2080777437184L, 15503);
    return false;
  }
  
  public final void overridePendingTransition(int paramInt1, int paramInt2)
  {
    GMTrace.i(2081851179008L, 15511);
    if (bOZ() != null) {
      bOZ().overridePendingTransition(paramInt1, paramInt2);
    }
    GMTrace.o(2081851179008L, 15511);
  }
  
  public final void sendBroadcast(Intent paramIntent)
  {
    GMTrace.i(2080509001728L, 15501);
    bOZ().sendBroadcast(paramIntent);
    GMTrace.o(2080509001728L, 15501);
  }
  
  public final void setRequestedOrientation(int paramInt)
  {
    GMTrace.i(2081045872640L, 15505);
    if (bOZ() != null) {
      bOZ().setRequestedOrientation(paramInt);
    }
    GMTrace.o(2081045872640L, 15505);
  }
  
  public void startActivity(Intent paramIntent)
  {
    GMTrace.i(2079569477632L, 15494);
    FragmentActivity localFragmentActivity = bOZ();
    if (localFragmentActivity == null)
    {
      aa.getContext().startActivity(paramIntent);
      GMTrace.o(2079569477632L, 15494);
      return;
    }
    localFragmentActivity.a(this, paramIntent, -1);
    GMTrace.o(2079569477632L, 15494);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */