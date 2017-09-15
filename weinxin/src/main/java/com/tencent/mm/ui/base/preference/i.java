package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.h;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.q;

public abstract class i
  extends q
{
  public SharedPreferences hgn;
  public boolean lCL;
  public ListView mTv;
  public boolean qYz;
  public h vpG;
  
  public i()
  {
    GMTrace.i(3214783021056L, 23952);
    this.lCL = false;
    this.qYz = false;
    GMTrace.o(3214783021056L, 23952);
  }
  
  public static boolean bSP()
  {
    GMTrace.i(3215722545152L, 23959);
    GMTrace.o(3215722545152L, 23959);
    return false;
  }
  
  public abstract int OO();
  
  public abstract boolean a(f paramf, Preference paramPreference);
  
  protected final int getLayoutId()
  {
    GMTrace.i(3214917238784L, 23953);
    int i = a.h.hei;
    GMTrace.o(3214917238784L, 23953);
    return i;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    GMTrace.i(3215185674240L, 23955);
    super.onActivityCreated(paramBundle);
    this.hgn = SA(bOZ().getPackageName() + "_preferences");
    this.vpG = new h(this.uRf.uRz, this.hgn);
    this.mTv = ((ListView)findViewById(16908298));
    this.vpG.b(new Preference.a()
    {
      public final boolean a(Preference paramAnonymousPreference, Object paramAnonymousObject)
      {
        GMTrace.i(3204850909184L, 23878);
        if ((!i.this.qYz) && (paramAnonymousPreference.isEnabled()) && (paramAnonymousPreference.vqi))
        {
          i.this.qYz = true;
          if (!(paramAnonymousPreference instanceof CheckBoxPreference)) {
            break label180;
          }
          paramAnonymousObject = (CheckBoxPreference)paramAnonymousPreference;
          ((CheckBoxPreference)paramAnonymousObject).vox = ((CheckBoxPreference)paramAnonymousObject).isChecked();
          if (((Preference)paramAnonymousObject).vqk) {
            i.this.hgn.edit().putBoolean(paramAnonymousPreference.igr, ((CheckBoxPreference)paramAnonymousObject).isChecked()).commit();
          }
          i.this.lCL = true;
        }
        label180:
        for (int i = 1;; i = 0)
        {
          if (paramAnonymousPreference.igr != null) {
            i.this.a(i.this.vpG, paramAnonymousPreference);
          }
          if (i != 0) {
            i.this.vpG.notifyDataSetChanged();
          }
          i.this.qYz = false;
          if (i != 0)
          {
            GMTrace.o(3204850909184L, 23878);
            return true;
          }
          GMTrace.o(3204850909184L, 23878);
          return false;
        }
      }
    });
    int i = OO();
    if (i != -1) {
      this.vpG.addPreferencesFromResource(i);
    }
    this.mTv.setAdapter(this.vpG);
    this.mTv.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, final View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(3218943770624L, 23983);
        if (paramAnonymousInt < i.this.mTv.getHeaderViewsCount())
        {
          GMTrace.o(3218943770624L, 23983);
          return;
        }
        int i = i.this.mTv.getHeaderViewsCount();
        paramAnonymousAdapterView = (Preference)i.this.vpG.getItem(paramAnonymousInt - i);
        if ((paramAnonymousAdapterView.isEnabled()) && (paramAnonymousAdapterView.vqi))
        {
          if ((paramAnonymousAdapterView instanceof CheckBoxPreference))
          {
            GMTrace.o(3218943770624L, 23983);
            return;
          }
          if ((paramAnonymousAdapterView instanceof DialogPreference))
          {
            paramAnonymousView = (DialogPreference)paramAnonymousAdapterView;
            paramAnonymousView.showDialog();
            paramAnonymousView.voH = new DialogPreference.a()
            {
              public final void bSM()
              {
                GMTrace.i(3211427577856L, 23927);
                i.this.lCL = true;
                if (paramAnonymousView.vqk) {
                  i.this.hgn.edit().putString(paramAnonymousAdapterView.igr, paramAnonymousView.getValue()).commit();
                }
                i.this.vpG.notifyDataSetChanged();
                GMTrace.o(3211427577856L, 23927);
              }
            };
          }
          if ((paramAnonymousAdapterView instanceof EditPreference))
          {
            paramAnonymousView = (EditPreference)paramAnonymousAdapterView;
            paramAnonymousView.showDialog();
            paramAnonymousView.voJ = new EditPreference.a()
            {
              public final void bSM()
              {
                GMTrace.i(3235720986624L, 24108);
                i.this.lCL = true;
                if (paramAnonymousView.vqk) {
                  i.this.hgn.edit().putString(paramAnonymousAdapterView.igr, paramAnonymousView.value).commit();
                }
                i.this.vpG.notifyDataSetChanged();
                GMTrace.o(3235720986624L, 24108);
              }
            };
          }
          if (paramAnonymousAdapterView.igr != null) {
            i.this.a(i.this.vpG, paramAnonymousAdapterView);
          }
        }
        GMTrace.o(3218943770624L, 23983);
      }
    });
    this.mTv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        GMTrace.i(3202300772352L, 23859);
        if (paramAnonymousInt < i.this.mTv.getHeaderViewsCount())
        {
          GMTrace.o(3202300772352L, 23859);
          return false;
        }
        int i = i.this.mTv.getHeaderViewsCount();
        i.this.vpG.getItem(paramAnonymousInt - i);
        paramAnonymousAdapterView = i.this.vpG;
        paramAnonymousAdapterView = i.this.mTv;
        boolean bool = i.bSP();
        GMTrace.o(3202300772352L, 23859);
        return bool;
      }
    });
    GMTrace.o(3215185674240L, 23955);
  }
  
  public final boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    GMTrace.i(3215319891968L, 23956);
    boolean bool = super.onContextItemSelected(paramMenuItem);
    GMTrace.o(3215319891968L, 23956);
    return bool;
  }
  
  public void onResume()
  {
    GMTrace.i(3215051456512L, 23954);
    super.onResume();
    this.vpG.notifyDataSetChanged();
    GMTrace.o(3215051456512L, 23954);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/preference/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */