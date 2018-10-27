package android.support.v7.preference;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.cq;
import android.support.v4.app.v;
import android.support.v7.preference.internal.AbstractMultiSelectListPreference;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ff;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class s
  extends Fragment
  implements aj, ak, al, e
{
  public RecyclerView a;
  private Handler aa = new t(this);
  private boolean ab;
  private boolean ac;
  private int ad = 2131624859;
  private final Runnable ae = new u(this);
  private Context af;
  public ai b;
  public Runnable c;
  private final w d = new w(this);
  
  public final void R()
  {
    if ((j() instanceof z)) {
      ((z)j()).a();
    }
  }
  
  final void S()
  {
    PreferenceScreen localPreferenceScreen = this.b.e;
    if (localPreferenceScreen != null)
    {
      this.a.setAdapter(new ae(localPreferenceScreen));
      localPreferenceScreen.n();
    }
  }
  
  public final Preference a(CharSequence paramCharSequence)
  {
    ai localai = this.b;
    if (localai != null) {
      return localai.a(paramCharSequence);
    }
    return null;
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Object localObject = this.af.obtainStyledAttributes(null, ap.F, 2130969431, 0);
    this.ad = ((TypedArray)localObject).getResourceId(ap.J, this.ad);
    paramBundle = ((TypedArray)localObject).getDrawable(ap.H);
    int i = ((TypedArray)localObject).getDimensionPixelSize(ap.I, -1);
    boolean bool = ((TypedArray)localObject).getBoolean(ap.G, true);
    ((TypedArray)localObject).recycle();
    localObject = paramLayoutInflater.cloneInContext(this.af);
    paramLayoutInflater = ((LayoutInflater)localObject).inflate(this.ad, paramViewGroup, false);
    paramViewGroup = paramLayoutInflater.findViewById(16908351);
    if (!(paramViewGroup instanceof ViewGroup)) {
      throw new RuntimeException("Content has view with id attribute 'android.R.id.list_container' that is not a ViewGroup class");
    }
    paramViewGroup = (ViewGroup)paramViewGroup;
    localObject = (RecyclerView)((LayoutInflater)localObject).inflate(2131624861, paramViewGroup, false);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager());
    ((RecyclerView)localObject).setAccessibilityDelegateCompat(new am((RecyclerView)localObject));
    if (localObject != null)
    {
      this.a = ((RecyclerView)localObject);
      w localw = this.d;
      ff localff = ((RecyclerView)localObject).u;
      if (localff != null) {
        localff.a("Cannot add item decoration during a scroll  or layout");
      }
      if (((RecyclerView)localObject).r.isEmpty()) {
        ((RecyclerView)localObject).setWillNotDraw(false);
      }
      ((RecyclerView)localObject).r.add(localw);
      ((RecyclerView)localObject).n();
      ((RecyclerView)localObject).requestLayout();
      localObject = this.d;
      if (paramBundle != null) {}
      for (((w)localObject).c = paramBundle.getIntrinsicHeight();; ((w)localObject).c = 0)
      {
        ((w)localObject).b = paramBundle;
        ((w)localObject).d.a.o();
        if (i != -1)
        {
          paramBundle = this.d;
          paramBundle.c = i;
          paramBundle.d.a.o();
        }
        this.d.a = bool;
        paramViewGroup.addView(this.a);
        this.aa.post(this.ae);
        return paramLayoutInflater;
      }
    }
    throw new RuntimeException("Could not create RecyclerView");
  }
  
  public final void a(int paramInt, String paramString)
  {
    Object localObject1 = this.b;
    if (localObject1 == null) {
      throw new RuntimeException("This should be called after super.onCreate.");
    }
    Object localObject2 = this.af;
    ((ai)localObject1).a(true);
    localObject2 = (PreferenceScreen)new ah((Context)localObject2, (ai)localObject1).a(paramInt);
    ((Preference)localObject2).a((ai)localObject1);
    ((ai)localObject1).a(false);
    localObject1 = localObject2;
    if (paramString != null)
    {
      localObject1 = ((PreferenceGroup)localObject2).c(paramString);
      if (!(localObject1 instanceof PreferenceScreen)) {}
    }
    else
    {
      paramString = (PreferenceScreen)localObject1;
      localObject1 = this.b;
      localObject2 = ((ai)localObject1).e;
      if (paramString != localObject2) {
        if (localObject2 != null) {
          break label152;
        }
      }
      for (;;)
      {
        ((ai)localObject1).e = paramString;
        if (paramString != null)
        {
          this.ab = true;
          if ((this.ac) && (!this.aa.hasMessages(1))) {
            this.aa.obtainMessage(1).sendToTarget();
          }
        }
        return;
        label152:
        ((Preference)localObject2).o();
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Preference object with key ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" is not a PreferenceScreen");
    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Object localObject = new TypedValue();
    j().getTheme().resolveAttribute(2130969442, (TypedValue)localObject, true);
    int j = ((TypedValue)localObject).resourceId;
    int i = j;
    if (j == 0) {
      i = 2132017871;
    }
    this.af = new ContextThemeWrapper(j(), i);
    this.b = new ai(this.af);
    this.b.c = this;
    localObject = this.g;
    if (localObject != null) {}
    for (localObject = ((Bundle)localObject).getString("android.support.v7.preference.PreferenceFragmentCompat.PREFERENCE_ROOT");; localObject = null)
    {
      a(paramBundle, (String)localObject);
      return;
    }
  }
  
  public abstract void a(Bundle paramBundle, String paramString);
  
  public final void a(View paramView, Bundle paramBundle)
  {
    super.a(paramView, paramBundle);
    if (paramBundle != null)
    {
      paramView = paramBundle.getBundle("android:preferences");
      if (paramView != null) {
        break label59;
      }
    }
    for (;;)
    {
      if (this.ab)
      {
        S();
        paramView = this.c;
        if (paramView != null)
        {
          paramView.run();
          this.c = null;
        }
      }
      this.ac = true;
      return;
      label59:
      paramBundle = this.b.e;
      if (paramBundle != null) {
        paramBundle.b(paramView);
      }
    }
  }
  
  public boolean a(Preference paramPreference)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramPreference.l != null)
    {
      bool1 = bool2;
      if ((j() instanceof y)) {
        bool1 = ((y)j()).a();
      }
    }
    return bool1;
  }
  
  public final void av_()
  {
    super.av_();
    ai localai = this.b;
    localai.d = this;
    localai.b = this;
  }
  
  public final void b(Preference paramPreference)
  {
    String str;
    Bundle localBundle;
    if (((!(j() instanceof x)) || (!((x)j()).a())) && (this.q.a("android.support.v14.preference.PreferenceFragment.DIALOG") == null))
    {
      if (!(paramPreference instanceof EditTextPreference)) {
        break label98;
      }
      str = paramPreference.r;
      paramPreference = new h();
      localBundle = new Bundle(1);
      localBundle.putString("key", str);
      paramPreference.f(localBundle);
    }
    for (;;)
    {
      paramPreference.a(this, 0);
      paramPreference.a(this.q, "android.support.v14.preference.PreferenceFragment.DIALOG");
      return;
      label98:
      if ((paramPreference instanceof ListPreference))
      {
        str = paramPreference.r;
        paramPreference = new j();
        localBundle = new Bundle(1);
        localBundle.putString("key", str);
        paramPreference.f(localBundle);
      }
      else
      {
        if (!(paramPreference instanceof AbstractMultiSelectListPreference)) {
          break;
        }
        str = paramPreference.r;
        paramPreference = new l();
        localBundle = new Bundle(1);
        localBundle.putString("key", str);
        paramPreference.f(localBundle);
      }
    }
    throw new IllegalArgumentException("Tried to display dialog for unknown preference type. Did you forget to override onDisplayPreferenceDialog()?");
  }
  
  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    PreferenceScreen localPreferenceScreen = this.b.e;
    if (localPreferenceScreen != null)
    {
      Bundle localBundle = new Bundle();
      localPreferenceScreen.a(localBundle);
      paramBundle.putBundle("android:preferences", localBundle);
    }
  }
  
  public void f()
  {
    this.aa.removeCallbacks(this.ae);
    this.aa.removeMessages(1);
    if (this.ab)
    {
      PreferenceScreen localPreferenceScreen = this.b.e;
      if (localPreferenceScreen != null) {
        localPreferenceScreen.o();
      }
    }
    this.a = null;
    super.f();
  }
  
  public final void o_()
  {
    super.o_();
    ai localai = this.b;
    localai.d = null;
    localai.b = null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */