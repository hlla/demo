package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.EditText;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.k;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;

public class EditPreference
  extends Preference
{
  public h oGr;
  public String value;
  public Preference.a voE;
  public a voJ;
  private EditText voK;
  
  public EditPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(3202703425536L, 23862);
    GMTrace.o(3202703425536L, 23862);
  }
  
  public EditPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(3202837643264L, 23863);
    GMTrace.o(3202837643264L, 23863);
  }
  
  public final void a(Preference.a parama)
  {
    GMTrace.i(3202971860992L, 23864);
    this.voE = parama;
    GMTrace.o(3202971860992L, 23864);
  }
  
  public final void showDialog()
  {
    GMTrace.i(3203106078720L, 23865);
    final EditText localEditText;
    if (this.voK != null) {
      localEditText = this.voK;
    }
    for (;;)
    {
      Object localObject = localEditText.getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams))
      {
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        int i = localEditText.getResources().getDimensionPixelSize(a.e.aXs);
        ((ViewGroup.MarginLayoutParams)localObject).leftMargin = i;
        ((ViewGroup.MarginLayoutParams)localObject).rightMargin = i;
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = i;
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = i;
      }
      if (localEditText.getParent() != null) {
        ((ViewGroup)localEditText.getParent()).removeView(localEditText);
      }
      this.oGr = g.a(this.mContext, getTitle().toString(), localEditText, a.V(this.mContext, a.k.dHL), a.V(this.mContext, a.k.dGk), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3241492348928L, 24151);
          if (EditPreference.this.oGr != null) {
            EditPreference.this.oGr.dismiss();
          }
          EditPreference.this.value = localEditText.getText().toString();
          if (EditPreference.this.voJ != null) {
            EditPreference.this.voJ.bSM();
          }
          if (EditPreference.this.voE != null) {
            EditPreference.this.voE.a(EditPreference.this, EditPreference.this.value);
          }
          GMTrace.o(3241492348928L, 24151);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          GMTrace.i(3208877441024L, 23908);
          if (EditPreference.this.oGr != null) {
            EditPreference.this.oGr.dismiss();
          }
          GMTrace.o(3208877441024L, 23908);
        }
      });
      GMTrace.o(3203106078720L, 23865);
      return;
      localEditText = new EditText(this.mContext);
      localEditText.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      localEditText.setSingleLine(true);
      localEditText.setText(this.value);
    }
  }
  
  public static abstract interface a
  {
    public abstract void bSM();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/preference/EditPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */