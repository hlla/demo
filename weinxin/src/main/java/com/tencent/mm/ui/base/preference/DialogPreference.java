package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;
import java.util.HashMap;

public final class DialogPreference
  extends Preference
{
  public h oGr;
  public Preference.a voE;
  public final d voG;
  public a voH;
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    GMTrace.i(3204985126912L, 23879);
    GMTrace.o(3204985126912L, 23879);
  }
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(3205119344640L, 23880);
    this.voG = new d(paramContext);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.fpd, paramInt, 0);
    paramInt = paramAttributeSet.getResourceId(a.m.hfs, -1);
    if (paramInt != -1) {
      this.voG.voC = paramContext.getResources().getStringArray(paramInt);
    }
    this.voG.voD = paramAttributeSet.getTextArray(a.m.hft);
    paramAttributeSet.recycle();
    this.voG.bSL();
    GMTrace.o(3205119344640L, 23880);
  }
  
  public final void a(Preference.a parama)
  {
    GMTrace.i(3205253562368L, 23881);
    this.voE = parama;
    GMTrace.o(3205253562368L, 23881);
  }
  
  public final String getValue()
  {
    GMTrace.i(3205387780096L, 23882);
    String str = this.voG.value;
    GMTrace.o(3205387780096L, 23882);
    return str;
  }
  
  public final void onBindView(View paramView)
  {
    GMTrace.i(3205656215552L, 23884);
    c localc = (c)this.voG.values.get(this.voG.value);
    if (localc != null) {
      setSummary(localc.text);
    }
    super.onBindView(paramView);
    GMTrace.o(3205656215552L, 23884);
  }
  
  public final void setValue(String paramString)
  {
    GMTrace.i(3205521997824L, 23883);
    this.voG.value = paramString;
    paramString = (c)this.voG.values.get(paramString);
    if (paramString == null)
    {
      this.voG.opj = -1;
      GMTrace.o(3205521997824L, 23883);
      return;
    }
    this.voG.opj = paramString.id;
    GMTrace.o(3205521997824L, 23883);
  }
  
  protected final void showDialog()
  {
    GMTrace.i(3205790433280L, 23885);
    ListView localListView = (ListView)View.inflate(this.mContext, a.h.diq, null);
    localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(3237734252544L, 24123);
        if (DialogPreference.this.oGr != null) {
          DialogPreference.this.oGr.dismiss();
        }
        DialogPreference.this.setValue((String)DialogPreference.this.voG.voD[paramAnonymousInt]);
        if (DialogPreference.this.voH != null) {
          DialogPreference.this.voH.bSM();
        }
        if (DialogPreference.this.voE != null) {
          DialogPreference.this.voE.a(DialogPreference.this, DialogPreference.this.getValue());
        }
        GMTrace.o(3237734252544L, 24123);
      }
    });
    localListView.setAdapter(this.voG);
    h.a locala = new h.a(this.mContext);
    locala.SV(getTitle().toString());
    locala.db(localListView);
    this.oGr = locala.WD();
    this.oGr.show();
    g.a(this.mContext, this.oGr);
    GMTrace.o(3205790433280L, 23885);
  }
  
  public static abstract interface a
  {
    public abstract void bSM();
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/preference/DialogPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */