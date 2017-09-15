package com.tencent.mm.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;

public class RegByMobileSetPwdUI
  extends SetPwdUI
{
  private TextView pjl;
  private TextView qTr;
  private String sQH;
  private View uYG;
  private TextView uYH;
  private boolean uYI;
  
  public RegByMobileSetPwdUI()
  {
    GMTrace.i(2725425184768L, 20306);
    this.sQH = null;
    this.uYI = false;
    GMTrace.o(2725425184768L, 20306);
  }
  
  protected final void KD()
  {
    GMTrace.i(2725962055680L, 20310);
    if (!this.pnV) {
      bPO();
    }
    zd(R.l.eJK);
    this.pjl = ((TextView)findViewById(R.h.cLd));
    this.uYG = findViewById(R.h.bmL);
    this.qTr = ((TextView)findViewById(R.h.cxr));
    this.uYH = ((TextView)findViewById(R.h.bmP));
    if ((this.sQH != null) && (this.sQH.length() > 0)) {
      this.qTr.setText(this.sQH);
    }
    Object localObject3;
    Object localObject4;
    if ((this.uYI) || (!h.vG().uV()))
    {
      this.uYG.setVisibility(8);
      localObject1 = (TextView)findViewById(R.h.cqx);
      localObject2 = (TextView)findViewById(R.h.bEz);
      localObject3 = (EditText)findViewById(R.h.cxv);
      localObject4 = (EditText)findViewById(R.h.cxu);
      if (!u.bIz())
      {
        ((TextView)localObject1).setTextSize(1, 14.0F);
        ((TextView)localObject2).setTextSize(1, 14.0F);
        ((EditText)localObject3).setTextSize(1, 14.0F);
        ((EditText)localObject4).setTextSize(1, 14.0F);
      }
      float f1 = this.uYH.getPaint().measureText(this.uYH.getText().toString());
      float f2 = ((TextView)localObject1).getPaint().measureText(((TextView)localObject1).getText().toString());
      float f3 = ((TextView)localObject2).getPaint().measureText(((TextView)localObject2).getText().toString());
      f1 = Math.max(Math.max(f1, f2), f3);
      this.uYH.setWidth((int)f1);
      ((TextView)localObject1).setWidth((int)f1);
      ((TextView)localObject1).setWidth((int)f1);
      GMTrace.o(2725962055680L, 20310);
      return;
    }
    this.uYG.setVisibility(0);
    Object localObject2 = m.xM();
    Object localObject1 = localObject2;
    if (bf.mA((String)localObject2))
    {
      localObject2 = m.xL();
      localObject1 = localObject2;
      if (x.QP((String)localObject2)) {
        localObject1 = null;
      }
    }
    if (bf.mA((String)localObject1))
    {
      ap.yY();
      localObject1 = (String)c.vr().get(6, null);
      ap.yY();
      localObject2 = (String)c.vr().get(5, null);
      if (!bf.mA((String)localObject1)) {
        if (bf.Qg((String)localObject1).booleanValue())
        {
          new am();
          if (!((String)localObject1).startsWith("+")) {
            break label610;
          }
          localObject4 = ((String)localObject1).replace("+", "");
          localObject3 = am.yS((String)localObject4);
          localObject2 = localObject3;
          localObject1 = localObject4;
          if (localObject3 != null) {
            localObject1 = ((String)localObject4).substring(((String)localObject3).length());
          }
        }
      }
    }
    label610:
    for (localObject2 = localObject3;; localObject2 = "86")
    {
      localObject1 = am.formatNumber((String)localObject2, (String)localObject1);
      this.uYH.setText(R.l.eSK);
      this.pjl.setText((CharSequence)localObject1);
      this.qTr.setText(R.l.eJM);
      break;
      if (!bf.mA((String)localObject2))
      {
        this.pjl.setText((CharSequence)localObject2);
        this.uYH.setText(R.l.eSj);
        this.qTr.setText(R.l.eJL);
        break;
      }
      this.uYG.setVisibility(8);
      break;
      this.uYH.setText(R.l.eUF);
      this.pjl.setText((CharSequence)localObject1);
      break;
    }
  }
  
  protected final String bQJ()
  {
    GMTrace.i(2726096273408L, 20311);
    String str = ((EditText)findViewById(R.h.cxv)).getText().toString();
    GMTrace.o(2726096273408L, 20311);
    return str;
  }
  
  protected final String bQK()
  {
    GMTrace.i(2726230491136L, 20312);
    String str = ((EditText)findViewById(R.h.cxu)).getText().toString();
    GMTrace.o(2726230491136L, 20312);
    return str;
  }
  
  public final boolean bQO()
  {
    GMTrace.i(2726633144320L, 20315);
    GMTrace.o(2726633144320L, 20315);
    return true;
  }
  
  protected final int getLayoutId()
  {
    GMTrace.i(2725827837952L, 20309);
    int i = R.i.dmp;
    GMTrace.o(2725827837952L, 20309);
    return i;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(2725559402496L, 20307);
    super.onCreate(paramBundle);
    this.sQH = getIntent().getStringExtra("kintent_hint");
    this.pnV = getIntent().getBooleanExtra("kintent_cancelable", true);
    this.uYI = getIntent().getBooleanExtra("from_unbind", false);
    KD();
    GMTrace.o(2725559402496L, 20307);
  }
  
  public void onDestroy()
  {
    GMTrace.i(2725693620224L, 20308);
    super.onDestroy();
    GMTrace.o(2725693620224L, 20308);
  }
  
  protected final boolean s(int paramInt1, int paramInt2, String paramString)
  {
    GMTrace.i(2726498926592L, 20314);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      finish();
      GMTrace.o(2726498926592L, 20314);
      return true;
    }
    boolean bool = p(paramInt1, paramInt2, paramString);
    GMTrace.o(2726498926592L, 20314);
    return bool;
  }
  
  protected final void zw(int paramInt)
  {
    GMTrace.i(2726364708864L, 20313);
    switch (1.uXP[(paramInt - 1)])
    {
    }
    for (;;)
    {
      GMTrace.o(2726364708864L, 20313);
      return;
      g.h(this, R.l.eJF, R.l.eJH);
      GMTrace.o(2726364708864L, 20313);
      return;
      g.h(this, R.l.eJG, R.l.eJH);
      GMTrace.o(2726364708864L, 20313);
      return;
      g.h(this, R.l.eZO, R.l.eJH);
      GMTrace.o(2726364708864L, 20313);
      return;
      g.h(this, R.l.eZQ, R.l.eJH);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/account/RegByMobileSetPwdUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */