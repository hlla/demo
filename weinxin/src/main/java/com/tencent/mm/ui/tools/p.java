package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.m;
import android.support.v4.view.m.e;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.j;
import com.tencent.mm.s.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public class p
{
  public final String TAG;
  public ad hgD;
  public MenuItem lGg;
  public boolean wlS;
  public boolean wlT;
  private boolean wlU;
  private boolean wlV;
  public boolean wlW;
  public f wlX;
  public b wlY;
  private SearchViewNotRealTimeHelper.a wlZ;
  private boolean wma;
  private ArrayList<String> wmb;
  private boolean wmc;
  public int wmd;
  private int wme;
  public a wmf;
  
  public p()
  {
    GMTrace.i(2011252654080L, 14985);
    this.wlS = false;
    this.wlT = false;
    this.wlU = false;
    this.wlV = true;
    this.wlW = true;
    this.lGg = null;
    this.hgD = new ad(Looper.getMainLooper());
    this.wlX = null;
    this.wma = true;
    this.wmd = a.k.dGG;
    this.wme = 0;
    this.wma = true;
    this.wlS = false;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
    GMTrace.o(2011252654080L, 14985);
  }
  
  public p(boolean paramBoolean1, boolean paramBoolean2)
  {
    GMTrace.i(2011386871808L, 14986);
    this.wlS = false;
    this.wlT = false;
    this.wlU = false;
    this.wlV = true;
    this.wlW = true;
    this.lGg = null;
    this.hgD = new ad(Looper.getMainLooper());
    this.wlX = null;
    this.wma = true;
    this.wmd = a.k.dGG;
    this.wme = 0;
    this.wma = true;
    this.wlS = true;
    this.TAG = ("MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis()));
    GMTrace.o(2011386871808L, 14986);
  }
  
  private void b(final Activity paramActivity, Menu paramMenu)
  {
    GMTrace.i(2012729049088L, 14996);
    if ((this.wlV) && ((this.wlT) || (this.wlU)))
    {
      this.wlU = false;
      if (paramMenu != null)
      {
        int i = 0;
        while (i < paramMenu.size())
        {
          MenuItem localMenuItem = paramMenu.getItem(i);
          if (localMenuItem.getItemId() != a.g.cjD) {
            localMenuItem.setVisible(false);
          }
          i += 1;
        }
      }
      this.hgD.postDelayed(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(1954746990592L, 14564);
          if (p.this.lGg == null)
          {
            v.w(p.this.TAG, "on post expand search menu, but item is null");
            GMTrace.o(1954746990592L, 14564);
            return;
          }
          v.i(p.this.TAG, "try to expand action view, searchViewExpand %B", new Object[] { Boolean.valueOf(p.this.wlT) });
          if (p.this.wlS) {
            if (!p.this.wlT) {
              m.b(p.this.lGg);
            }
          }
          for (;;)
          {
            final View localView = m.a(p.this.lGg);
            if ((localView != null) && (p.this.wlT))
            {
              localView.findViewById(a.g.bKI).requestFocus();
              if (p.this.wlW) {
                p.this.hgD.postDelayed(new Runnable()
                {
                  public final void run()
                  {
                    GMTrace.i(1964544884736L, 14637);
                    ((InputMethodManager)p.10.this.nJ.getSystemService("input_method")).showSoftInput(localView.findViewById(a.g.bKI), 0);
                    GMTrace.o(1964544884736L, 14637);
                  }
                }, 128L);
              }
            }
            GMTrace.o(1954746990592L, 14564);
            return;
            if (p.this.wmf != null) {
              p.this.wmf.bZG();
            }
          }
        }
      }, 128L);
    }
    GMTrace.o(2012729049088L, 14996);
  }
  
  public final void Uf(String paramString)
  {
    GMTrace.i(2011655307264L, 14988);
    if (this.wlX == null)
    {
      GMTrace.o(2011655307264L, 14988);
      return;
    }
    this.wlX.Uf(paramString);
    GMTrace.o(2011655307264L, 14988);
  }
  
  public void a(Activity paramActivity, Menu paramMenu)
  {
    GMTrace.i(2012594831360L, 14995);
    v.v(this.TAG, "on prepare options menu, searchViewExpand %B, triggerExpand %B, canExpand %B", new Object[] { Boolean.valueOf(this.wlT), Boolean.valueOf(this.wlU), Boolean.valueOf(this.wlV) });
    if (paramActivity == null)
    {
      v.w(this.TAG, "on hanle status fail, activity is null");
      GMTrace.o(2012594831360L, 14995);
      return;
    }
    this.lGg = paramMenu.findItem(a.g.cjD);
    if (this.lGg == null)
    {
      v.w(this.TAG, "can not find search menu, error");
      GMTrace.o(2012594831360L, 14995);
      return;
    }
    this.lGg.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        GMTrace.i(1923340042240L, 14330);
        GMTrace.o(1923340042240L, 14330);
        return false;
      }
    });
    b(paramActivity, paramMenu);
    GMTrace.o(2012594831360L, 14995);
  }
  
  public final void a(final FragmentActivity paramFragmentActivity, Menu paramMenu)
  {
    GMTrace.i(2012460613632L, 14994);
    v.v(this.TAG, "on create options menu");
    if (paramFragmentActivity == null)
    {
      v.w(this.TAG, "on add search menu, activity is null");
      GMTrace.o(2012460613632L, 14994);
      return;
    }
    if (this.wlX == null)
    {
      if (this.wma)
      {
        this.wlX = new ActionBarSearchView(paramFragmentActivity);
        this.wlX.lF(this.wmc);
        this.wlX.ak(this.wmb);
      }
    }
    else
    {
      this.wlX.a(new ActionBarSearchView.b()
      {
        public final void OG()
        {
          GMTrace.i(1968839852032L, 14669);
          if (p.this.wlY != null) {
            p.this.wlY.OG();
          }
          GMTrace.o(1968839852032L, 14669);
        }
        
        public final void aHg()
        {
          GMTrace.i(17517829423104L, 130518);
          if (p.this.wlY != null) {
            p.this.wlY.OH();
          }
          GMTrace.o(17517829423104L, 130518);
        }
        
        public final void aHh()
        {
          GMTrace.i(1968571416576L, 14667);
          if (!p.this.wlT)
          {
            v.v(p.this.TAG, "onVoiceSearchRequired, but not in searching");
            GMTrace.o(1968571416576L, 14667);
            return;
          }
          p.this.bGB();
          GMTrace.o(1968571416576L, 14667);
        }
        
        public final void zC(String paramAnonymousString)
        {
          GMTrace.i(1968705634304L, 14668);
          if (!p.this.wlT)
          {
            v.v(p.this.TAG, "onSearchTextChange %s, but not in searching", new Object[] { paramAnonymousString });
            GMTrace.o(1968705634304L, 14668);
            return;
          }
          if (p.this.wlY != null) {
            p.this.wlY.mR(paramAnonymousString);
          }
          GMTrace.o(1968705634304L, 14668);
        }
      });
      this.wlX.lB(bGA());
      this.wlX.setOnEditorActionListener(new TextView.OnEditorActionListener()
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          GMTrace.i(1972866383872L, 14699);
          if ((3 == paramAnonymousInt) && (p.this.wlY != null))
          {
            boolean bool = p.this.wlY.mQ(p.this.bzR());
            GMTrace.o(1972866383872L, 14699);
            return bool;
          }
          GMTrace.o(1972866383872L, 14699);
          return false;
        }
      });
      if (this.wme != 0) {
        this.wlX.BY(this.wme);
      }
      this.lGg = paramMenu.add(0, a.g.cjD, 0, this.wmd);
      this.lGg.setEnabled(this.wlV);
      this.lGg.setIcon(a.j.dsK);
      m.a(this.lGg, (View)this.wlX);
      if (!this.wlS) {
        break label316;
      }
      m.a(this.lGg, 9);
      label237:
      if (!this.wlS) {
        break label327;
      }
      m.a(this.lGg, new m.e()
      {
        public final boolean onMenuItemActionCollapse(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(1964008013824L, 14633);
          p.this.b(paramFragmentActivity, false);
          GMTrace.o(1964008013824L, 14633);
          return true;
        }
        
        public final boolean onMenuItemActionExpand(MenuItem paramAnonymousMenuItem)
        {
          GMTrace.i(1963873796096L, 14632);
          p.this.a(paramFragmentActivity, false);
          GMTrace.o(1963873796096L, 14632);
          return true;
        }
      });
    }
    for (;;)
    {
      this.wlX.a(new ActionBarSearchView.a()
      {
        public final void aHi()
        {
          GMTrace.i(1994609655808L, 14861);
          if (p.this.wlS)
          {
            if (p.this.lGg != null)
            {
              m.c(p.this.lGg);
              GMTrace.o(1994609655808L, 14861);
            }
          }
          else if (p.this.wmf != null) {
            p.this.wmf.collapseActionView();
          }
          GMTrace.o(1994609655808L, 14861);
        }
      });
      GMTrace.o(2012460613632L, 14994);
      return;
      this.wlX = new SearchViewNotRealTimeHelper(paramFragmentActivity);
      this.wlX.a(this.wlZ);
      break;
      label316:
      m.a(this.lGg, 2);
      break label237;
      label327:
      this.wmf = new a()
      {
        public final void bZG()
        {
          GMTrace.i(2050846883840L, 15280);
          p.this.a(paramFragmentActivity, true);
          GMTrace.o(2050846883840L, 15280);
        }
        
        public final void collapseActionView()
        {
          GMTrace.i(2050981101568L, 15281);
          p.this.b(paramFragmentActivity, true);
          GMTrace.o(2050981101568L, 15281);
        }
      };
    }
  }
  
  public final void a(final FragmentActivity paramFragmentActivity, final boolean paramBoolean)
  {
    GMTrace.i(2013534355456L, 15002);
    v.d(this.TAG, "doNewExpand, searchViewExpand " + this.wlT);
    if (!this.wlT)
    {
      this.wlT = true;
      b(paramFragmentActivity, null);
      this.hgD.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(1964813320192L, 14639);
          if ((paramFragmentActivity == null) || (paramFragmentActivity.isFinishing()))
          {
            v.w(p.this.TAG, "want to expand search view, but activity status error");
            GMTrace.o(1964813320192L, 14639);
            return;
          }
          if (paramBoolean) {
            paramFragmentActivity.aQ();
          }
          GMTrace.o(1964813320192L, 14639);
        }
      });
      if (this.wlY != null) {
        this.wlY.OF();
      }
    }
    GMTrace.o(2013534355456L, 15002);
  }
  
  public final void b(final FragmentActivity paramFragmentActivity, final boolean paramBoolean)
  {
    GMTrace.i(2013668573184L, 15003);
    v.d(this.TAG, "doNewCollapse, searchViewExpand " + this.wlT);
    if (this.wlT)
    {
      this.wlT = false;
      bGC();
      if (this.wlX != null) {
        this.wlX.lE(false);
      }
      this.hgD.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(1941056782336L, 14462);
          if ((paramFragmentActivity == null) || (paramFragmentActivity.isFinishing()))
          {
            v.w(p.this.TAG, "want to collapse search view, but activity status error");
            GMTrace.o(1941056782336L, 14462);
            return;
          }
          if (paramBoolean) {
            paramFragmentActivity.aQ();
          }
          GMTrace.o(1941056782336L, 14462);
        }
      });
      if (this.wlY != null) {
        this.hgD.post(new Runnable()
        {
          public final void run()
          {
            GMTrace.i(1968034545664L, 14663);
            p.this.wlY.OE();
            GMTrace.o(1968034545664L, 14663);
          }
        });
      }
    }
    this.hgD.post(new Runnable()
    {
      public final void run()
      {
        GMTrace.i(1943070048256L, 14477);
        if (p.this.lGg == null)
        {
          v.w(p.this.TAG, "want to collapse search view, but search menu item is null");
          GMTrace.o(1943070048256L, 14477);
          return;
        }
        if ((paramFragmentActivity != null) && (!paramFragmentActivity.isFinishing()))
        {
          Object localObject2 = paramFragmentActivity;
          localObject1 = (InputMethodManager)((FragmentActivity)localObject2).getSystemService("input_method");
          if (localObject1 != null)
          {
            localObject2 = ((FragmentActivity)localObject2).getCurrentFocus();
            if (localObject2 != null)
            {
              localObject2 = ((View)localObject2).getWindowToken();
              if (localObject2 != null) {
                ((InputMethodManager)localObject1).hideSoftInputFromWindow((IBinder)localObject2, 0);
              }
            }
          }
        }
        Object localObject1 = m.a(p.this.lGg);
        if (localObject1 != null) {
          ((View)localObject1).findViewById(a.g.bKI).clearFocus();
        }
        GMTrace.o(1943070048256L, 14477);
      }
    });
    GMTrace.o(2013668573184L, 15003);
  }
  
  public boolean bGA()
  {
    GMTrace.i(2012057960448L, 14991);
    GMTrace.o(2012057960448L, 14991);
    return false;
  }
  
  public void bGB()
  {
    GMTrace.i(2012192178176L, 14992);
    GMTrace.o(2012192178176L, 14992);
  }
  
  public void bGC()
  {
    GMTrace.i(2012326395904L, 14993);
    GMTrace.o(2012326395904L, 14993);
  }
  
  public final void bZF()
  {
    GMTrace.i(2013131702272L, 14999);
    v.d(this.TAG, "do collapse");
    if ((this.wlT) && (this.lGg != null))
    {
      if (this.wlS)
      {
        m.c(this.lGg);
        GMTrace.o(2013131702272L, 14999);
        return;
      }
      if (this.wmf != null) {
        this.wmf.collapseActionView();
      }
    }
    GMTrace.o(2013131702272L, 14999);
  }
  
  public final boolean bZj()
  {
    GMTrace.i(2013265920000L, 15000);
    if (this.wlX != null)
    {
      boolean bool = this.wlX.bZj();
      GMTrace.o(2013265920000L, 15000);
      return bool;
    }
    GMTrace.o(2013265920000L, 15000);
    return false;
  }
  
  public final boolean bZk()
  {
    GMTrace.i(2013400137728L, 15001);
    if (this.wlX != null)
    {
      boolean bool = this.wlX.bZk();
      GMTrace.o(2013400137728L, 15001);
      return bool;
    }
    GMTrace.o(2013400137728L, 15001);
    return false;
  }
  
  public final String bzR()
  {
    GMTrace.i(2011521089536L, 14987);
    if (this.wlX != null)
    {
      String str = this.wlX.bzR();
      GMTrace.o(2011521089536L, 14987);
      return str;
    }
    GMTrace.o(2011521089536L, 14987);
    return "";
  }
  
  public final void clearFocus()
  {
    GMTrace.i(2011923742720L, 14990);
    if (this.wlX != null) {
      this.wlX.bZi();
    }
    GMTrace.o(2011923742720L, 14990);
  }
  
  public final void lH(boolean paramBoolean)
  {
    boolean bool1 = false;
    GMTrace.i(2012997484544L, 14998);
    String str = this.TAG;
    boolean bool2 = this.wlT;
    if (this.lGg == null) {
      bool1 = true;
    }
    v.d(str, "do expand, expanded[%B], search menu item null[%B]", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
    if (this.wlT)
    {
      GMTrace.o(2012997484544L, 14998);
      return;
    }
    if (!this.wlV)
    {
      v.w(this.TAG, "can not expand now");
      GMTrace.o(2012997484544L, 14998);
      return;
    }
    this.wlW = paramBoolean;
    if (this.lGg != null)
    {
      this.hgD.post(new Runnable()
      {
        public final void run()
        {
          GMTrace.i(2016487145472L, 15024);
          if (p.this.lGg == null)
          {
            v.w(p.this.TAG, "post do expand search menu, but search menu item is null");
            GMTrace.o(2016487145472L, 15024);
            return;
          }
          if (p.this.wlS)
          {
            m.b(p.this.lGg);
            GMTrace.o(2016487145472L, 15024);
            return;
          }
          if (p.this.wmf != null) {
            p.this.wmf.bZG();
          }
          GMTrace.o(2016487145472L, 15024);
        }
      });
      GMTrace.o(2012997484544L, 14998);
      return;
    }
    this.wlU = true;
    GMTrace.o(2012997484544L, 14998);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    GMTrace.i(2012863266816L, 14997);
    v.v(this.TAG, "on key down, key code %d, expand %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.wlT) });
    if ((4 == paramInt) && (this.wlT))
    {
      bZF();
      GMTrace.o(2012863266816L, 14997);
      return true;
    }
    GMTrace.o(2012863266816L, 14997);
    return false;
  }
  
  public final void setHint(CharSequence paramCharSequence)
  {
    GMTrace.i(2011789524992L, 14989);
    if (this.wlX == null)
    {
      GMTrace.o(2011789524992L, 14989);
      return;
    }
    this.wlX.setHint(paramCharSequence);
    GMTrace.o(2011789524992L, 14989);
  }
  
  public static abstract interface a
  {
    public abstract void bZG();
    
    public abstract void collapseActionView();
  }
  
  public static abstract interface b
  {
    public abstract void OE();
    
    public abstract void OF();
    
    public abstract void OG();
    
    public abstract void OH();
    
    public abstract boolean mQ(String paramString);
    
    public abstract void mR(String paramString);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/tools/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */