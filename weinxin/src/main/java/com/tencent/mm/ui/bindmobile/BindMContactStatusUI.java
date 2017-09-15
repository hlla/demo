package com.tencent.mm.ui.bindmobile;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMWizardActivity;

public class BindMContactStatusUI
  extends MMWizardActivity
{
  private Button jKW;
  private ImageView vau;
  private TextView vav;
  private TextView vrZ;
  
  public BindMContactStatusUI()
  {
    GMTrace.i(3146734632960L, 23445);
    GMTrace.o(3146734632960L, 23445);
  }
  
  protected final void KD()
  {
    GMTrace.i(3147137286144L, 23448);
    this.vau = ((ImageView)findViewById(R.h.bsV));
    this.vrZ = ((TextView)findViewById(R.h.bsT));
    this.vav = ((TextView)findViewById(R.h.bsR));
    this.jKW = ((Button)findViewById(R.h.bsU));
    if (m.Fm() == m.a.hBa)
    {
      this.vau.setImageResource(R.k.dxx);
      ap.yY();
      String str2 = (String)c.vr().get(6, null);
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!str2.equals("")) {}
      }
      else
      {
        ap.yY();
        str1 = (String)c.vr().get(4097, null);
      }
      this.vav.setText(getString(R.l.dNG));
      this.vrZ.setText(getString(R.l.dOa, new Object[] { str1 }));
    }
    for (;;)
    {
      this.jKW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          GMTrace.i(3100832169984L, 23103);
          BindMContactStatusUI.a(BindMContactStatusUI.this);
          GMTrace.o(3100832169984L, 23103);
        }
      });
      GMTrace.o(3147137286144L, 23448);
      return;
      this.vau.setImageResource(R.k.dxy);
      this.vav.setText(R.l.dNQ);
      this.vrZ.setText(R.l.dNQ);
      this.vav.setVisibility(8);
    }
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(3147003068416L, 23447);
    int i = R.i.cVu;
    GMTrace.o(3147003068416L, 23447);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3146868850688L, 23446);
    super.onCreate(paramBundle);
    zd(R.l.dNJ);
    KD();
    GMTrace.o(3146868850688L, 23446);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(3147271503872L, 23449);
    if (paramInt == 4)
    {
      zp(1);
      GMTrace.o(3147271503872L, 23449);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    GMTrace.o(3147271503872L, 23449);
    return bool;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/bindmobile/BindMContactStatusUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */