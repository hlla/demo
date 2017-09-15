package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.bg.a;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.g;
import java.util.ArrayList;

public class ProfileEditPhoneNumberView
  extends ProfileItemView
  implements MMPhoneNumberEditText.a
{
  public String sIa;
  public String sIb;
  public String[] sIc;
  private LinearLayout sId;
  private boolean sIe;
  public a sIf;
  
  public ProfileEditPhoneNumberView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(1182995054592L, 8814);
    this.sIe = false;
    GMTrace.o(1182995054592L, 8814);
  }
  
  public ProfileEditPhoneNumberView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(1183129272320L, 8815);
    this.sIe = false;
    GMTrace.o(1183129272320L, 8815);
  }
  
  private void aL(String paramString, boolean paramBoolean)
  {
    GMTrace.i(1184739885056L, 8827);
    MMPhoneNumberEditText localMMPhoneNumberEditText = (MMPhoneNumberEditText)LayoutInflater.from(getContext()).inflate(R.i.dld, null);
    if (paramBoolean)
    {
      localMMPhoneNumberEditText.sHH = true;
      localMMPhoneNumberEditText.sHF = localMMPhoneNumberEditText.getResources().getDrawable(R.k.dxk);
      localMMPhoneNumberEditText.sHF.setBounds(0, 0, localMMPhoneNumberEditText.sHF.getIntrinsicWidth(), localMMPhoneNumberEditText.sHF.getIntrinsicHeight());
      localMMPhoneNumberEditText.setFocusable(false);
      localMMPhoneNumberEditText.bEc();
    }
    localMMPhoneNumberEditText.sHG = this;
    localMMPhoneNumberEditText.setText(paramString);
    localMMPhoneNumberEditText.setSelection(localMMPhoneNumberEditText.getText().length());
    paramString = new LinearLayout.LayoutParams(-1, -2);
    paramString.setMargins(0, a.fromDPToPix(getContext(), 12), 0, 0);
    this.sId.addView(localMMPhoneNumberEditText, paramString);
    GMTrace.o(1184739885056L, 8827);
  }
  
  private void bEl()
  {
    GMTrace.i(1184068796416L, 8822);
    if (this.sIf != null) {
      this.sIf.adT();
    }
    GMTrace.o(1184068796416L, 8822);
  }
  
  private void h(MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    GMTrace.i(1184874102784L, 8828);
    this.sId.removeView(paramMMPhoneNumberEditText);
    this.sId.getChildAt(this.sId.getChildCount() - 1).requestFocus();
    GMTrace.o(1184874102784L, 8828);
  }
  
  public final boolean L(x paramx)
  {
    GMTrace.i(1183666143232L, 8819);
    this.kUK = paramx;
    GMTrace.o(1183666143232L, 8819);
    return true;
  }
  
  public final int aTJ()
  {
    GMTrace.i(1183263490048L, 8816);
    int i = R.i.dle;
    GMTrace.o(1183263490048L, 8816);
    return i;
  }
  
  public final boolean aTK()
  {
    GMTrace.i(1183800360960L, 8820);
    int j;
    if (!bf.mA(this.sIa))
    {
      aL(this.sIa, true);
      j = 1;
    }
    for (int i = 1;; i = 0)
    {
      int k = i;
      if (!bf.mA(this.sIb))
      {
        this.sIc = this.sIb.split(",");
        for (;;)
        {
          k = i;
          if (i >= this.sIc.length + j) {
            break;
          }
          aL(this.sIc[(i - j)].trim(), false);
          i += 1;
        }
      }
      if (k < 5) {
        aL(null, false);
      }
      for (this.sIe = false;; this.sIe = true)
      {
        GMTrace.o(1183800360960L, 8820);
        return false;
      }
      j = 0;
    }
  }
  
  public final void bEe()
  {
    GMTrace.i(1184471449600L, 8825);
    if (this.sId.getChildCount() - 1 < 5) {
      aL(null, false);
    }
    for (;;)
    {
      bEl();
      GMTrace.o(1184471449600L, 8825);
      return;
      this.sIe = true;
    }
  }
  
  public final void bEf()
  {
    GMTrace.i(1184337231872L, 8824);
    bEl();
    GMTrace.o(1184337231872L, 8824);
  }
  
  public final ArrayList<String> bEk()
  {
    GMTrace.i(1183934578688L, 8821);
    int j = this.sId.getChildCount();
    if (j == 1)
    {
      GMTrace.o(1183934578688L, 8821);
      return null;
    }
    ArrayList localArrayList = new ArrayList(j - 1);
    int i = 1;
    while (i < j)
    {
      String str = ((MMPhoneNumberEditText)this.sId.getChildAt(i)).getText().toString();
      if (!bf.mA(str)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    if (!bf.mA(this.sIa)) {
      localArrayList.remove(0);
    }
    GMTrace.o(1183934578688L, 8821);
    return localArrayList;
  }
  
  public void clearFocus()
  {
    GMTrace.i(1183531925504L, 8818);
    int i = 1;
    while (i < this.sId.getChildCount())
    {
      this.sId.getChildAt(i).clearFocus();
      i += 1;
    }
    GMTrace.o(1183531925504L, 8818);
  }
  
  public final void f(final MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    GMTrace.i(1184203014144L, 8823);
    if (paramMMPhoneNumberEditText.sHH)
    {
      g.a(getContext(), R.l.esg, 0, R.l.esf, R.l.ese, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(1152796065792L, 8589);
          ProfileEditPhoneNumberView.this.sIa = "";
          ProfileEditPhoneNumberView.this.sIf.bEm();
          ProfileEditPhoneNumberView.a(ProfileEditPhoneNumberView.this, paramMMPhoneNumberEditText);
          if (!ProfileEditPhoneNumberView.a(ProfileEditPhoneNumberView.this)) {
            ProfileEditPhoneNumberView.b(ProfileEditPhoneNumberView.this);
          }
          GMTrace.o(1152796065792L, 8589);
        }
      }, null);
      GMTrace.o(1184203014144L, 8823);
      return;
    }
    h(paramMMPhoneNumberEditText);
    if (this.sIe)
    {
      aL(null, false);
      this.sIe = false;
    }
    bEl();
    GMTrace.o(1184203014144L, 8823);
  }
  
  public final void g(MMPhoneNumberEditText paramMMPhoneNumberEditText)
  {
    GMTrace.i(1184605667328L, 8826);
    if (this.sId.getChildCount() - 1 == 1)
    {
      GMTrace.o(1184605667328L, 8826);
      return;
    }
    h(paramMMPhoneNumberEditText);
    if (this.sIe) {
      aL(null, false);
    }
    this.sIe = false;
    bEl();
    GMTrace.o(1184605667328L, 8826);
  }
  
  public final void init()
  {
    GMTrace.i(1183397707776L, 8817);
    this.sId = ((LinearLayout)findViewById(R.h.cgJ));
    GMTrace.o(1183397707776L, 8817);
  }
  
  public static abstract interface a
  {
    public abstract void adT();
    
    public abstract void bEm();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/ProfileEditPhoneNumberView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */