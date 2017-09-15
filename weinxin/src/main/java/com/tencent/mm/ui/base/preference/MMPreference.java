package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public abstract class MMPreference
  extends MMActivity
{
  public SharedPreferences hgn;
  private boolean lCL;
  public ListView mTv;
  private boolean qYz;
  public h vpG;
  protected RelativeLayout vpH;
  protected TextView vpI;
  protected ImageView vpJ;
  
  public MMPreference()
  {
    GMTrace.i(3225252003840L, 24030);
    this.lCL = false;
    this.qYz = false;
    GMTrace.o(3225252003840L, 24030);
  }
  
  public boolean ON()
  {
    GMTrace.i(3225520439296L, 24032);
    GMTrace.o(3225520439296L, 24032);
    return true;
  }
  
  public abstract int OO();
  
  public h a(SharedPreferences paramSharedPreferences)
  {
    GMTrace.i(3226728398848L, 24041);
    paramSharedPreferences = new h(this, paramSharedPreferences);
    GMTrace.o(3226728398848L, 24041);
    return paramSharedPreferences;
  }
  
  public abstract boolean a(f paramf, Preference paramPreference);
  
  public View aZL()
  {
    GMTrace.i(16764867969024L, 124908);
    GMTrace.o(16764867969024L, 124908);
    return null;
  }
  
  public int aek()
  {
    GMTrace.i(3226459963392L, 24039);
    GMTrace.o(3226459963392L, 24039);
    return -1;
  }
  
  public View agP()
  {
    GMTrace.i(3226594181120L, 24040);
    GMTrace.o(3226594181120L, 24040);
    return null;
  }
  
  public int getLayoutId()
  {
    GMTrace.i(3225386221568L, 24031);
    int i = a.h.ckb;
    GMTrace.o(3225386221568L, 24031);
    return i;
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    GMTrace.i(3225923092480L, 24035);
    boolean bool = super.onContextItemSelected(paramMenuItem);
    GMTrace.o(3225923092480L, 24035);
    return bool;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    GMTrace.i(3225788874752L, 24034);
    super.onCreate(paramBundle);
    this.hgn = getSharedPreferences(getPackageName() + "_preferences", 0);
    this.vpG = a(this.hgn);
    this.mTv = ((ListView)findViewById(16908298));
    this.vpH = ((RelativeLayout)findViewById(a.g.hcH));
    this.vpI = ((TextView)findViewById(a.g.hcG));
    this.vpJ = ((ImageView)findViewById(a.g.hcF));
    int i = aek();
    if (i != -1)
    {
      paramBundle = getLayoutInflater().inflate(i, null);
      this.mTv.addHeaderView(paramBundle);
    }
    paramBundle = agP();
    if (paramBundle != null)
    {
      if (paramBundle.getLayoutParams() == null) {
        break label308;
      }
      paramBundle.setLayoutParams(new AbsListView.LayoutParams(paramBundle.getLayoutParams()));
    }
    for (;;)
    {
      this.mTv.addFooterView(paramBundle);
      paramBundle = aZL();
      if (paramBundle != null)
      {
        FrameLayout localFrameLayout = (FrameLayout)findViewById(a.g.hcE);
        localFrameLayout.addView(paramBundle);
        localFrameLayout.setVisibility(0);
      }
      this.vpG.b(new Preference.a()
      {
        public final boolean a(Preference paramAnonymousPreference, Object paramAnonymousObject)
        {
          GMTrace.i(3202569207808L, 23861);
          if ((!MMPreference.a(MMPreference.this)) && (paramAnonymousPreference.isEnabled()) && (paramAnonymousPreference.vqi))
          {
            MMPreference.a(MMPreference.this, true);
            if (!(paramAnonymousPreference instanceof CheckBoxPreference)) {
              break label182;
            }
            paramAnonymousObject = (CheckBoxPreference)paramAnonymousPreference;
            ((CheckBoxPreference)paramAnonymousObject).vox = ((CheckBoxPreference)paramAnonymousObject).isChecked();
            if (((Preference)paramAnonymousObject).vqk) {
              MMPreference.b(MMPreference.this).edit().putBoolean(paramAnonymousPreference.igr, ((CheckBoxPreference)paramAnonymousObject).isChecked()).commit();
            }
            MMPreference.c(MMPreference.this);
          }
          label182:
          for (int i = 1;; i = 0)
          {
            if (paramAnonymousPreference.igr != null) {
              MMPreference.this.a(MMPreference.d(MMPreference.this), paramAnonymousPreference);
            }
            if (i != 0) {
              MMPreference.d(MMPreference.this).notifyDataSetChanged();
            }
            MMPreference.a(MMPreference.this, false);
            if (i != 0)
            {
              GMTrace.o(3202569207808L, 23861);
              return true;
            }
            GMTrace.o(3202569207808L, 23861);
            return false;
          }
        }
      });
      i = OO();
      if (i != -1) {
        this.vpG.addPreferencesFromResource(i);
      }
      this.mTv.setAdapter(this.vpG);
      this.mTv.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(final AdapterView<?> paramAnonymousAdapterView, final View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          GMTrace.i(3235452551168L, 24106);
          paramAnonymousAdapterView = (Preference)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            GMTrace.o(3235452551168L, 24106);
            return;
          }
          if ((paramAnonymousAdapterView.isEnabled()) && (paramAnonymousAdapterView.vqi))
          {
            if ((paramAnonymousAdapterView instanceof CheckBoxPreference))
            {
              GMTrace.o(3235452551168L, 24106);
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
                  GMTrace.i(3217198940160L, 23970);
                  MMPreference.c(MMPreference.this);
                  if (paramAnonymousView.vqk) {
                    MMPreference.b(MMPreference.this).edit().putString(paramAnonymousAdapterView.igr, paramAnonymousView.getValue()).commit();
                  }
                  MMPreference.d(MMPreference.this).notifyDataSetChanged();
                  GMTrace.o(3217198940160L, 23970);
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
                  GMTrace.i(3235989422080L, 24110);
                  MMPreference.c(MMPreference.this);
                  if (paramAnonymousView.vqk) {
                    MMPreference.b(MMPreference.this).edit().putString(paramAnonymousAdapterView.igr, paramAnonymousView.value).commit();
                  }
                  MMPreference.d(MMPreference.this).notifyDataSetChanged();
                  GMTrace.o(3235989422080L, 24110);
                }
              };
            }
            if (paramAnonymousAdapterView.igr != null) {
              MMPreference.this.a(MMPreference.d(MMPreference.this), paramAnonymousAdapterView);
            }
          }
          GMTrace.o(3235452551168L, 24106);
        }
      });
      this.mTv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          GMTrace.i(3224849350656L, 24027);
          if (paramAnonymousInt < MMPreference.e(MMPreference.this).getHeaderViewsCount())
          {
            GMTrace.o(3224849350656L, 24027);
            return false;
          }
          paramAnonymousInt -= MMPreference.e(MMPreference.this).getHeaderViewsCount();
          if (paramAnonymousInt >= MMPreference.d(MMPreference.this).getCount())
          {
            v.e("MicroMsg.mmui.MMPreference", "itemlongclick, outofindex, %d, %d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(MMPreference.d(MMPreference.this).getCount()) });
            GMTrace.o(3224849350656L, 24027);
            return false;
          }
          MMPreference.d(MMPreference.this).getItem(paramAnonymousInt);
          GMTrace.o(3224849350656L, 24027);
          return false;
        }
      });
      this.mTv.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          GMTrace.i(3240418607104L, 24143);
          GMTrace.o(3240418607104L, 24143);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          GMTrace.i(3240284389376L, 24142);
          if (1 == paramAnonymousInt)
          {
            paramAnonymousAbsListView = MMPreference.this.getCurrentFocus();
            if (paramAnonymousAbsListView != null) {
              paramAnonymousAbsListView.clearFocus();
            }
          }
          GMTrace.o(3240284389376L, 24142);
        }
      });
      GMTrace.o(3225788874752L, 24034);
      return;
      label308:
      v.e("MicroMsg.mmui.MMPreference", "[arthurdan.mmpreference] Notice!!! footer.getLayoutParams() is null!!!\n");
    }
  }
  
  public void onResume()
  {
    GMTrace.i(3225654657024L, 24033);
    if (ON()) {
      this.vpG.notifyDataSetChanged();
    }
    super.onResume();
    GMTrace.o(3225654657024L, 24033);
  }
  
  public final void setSelection(int paramInt)
  {
    GMTrace.i(3226325745664L, 24038);
    this.mTv.setSelection(paramInt);
    GMTrace.o(3226325745664L, 24038);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/preference/MMPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */