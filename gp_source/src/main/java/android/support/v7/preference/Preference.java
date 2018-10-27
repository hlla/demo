package android.support.v7.preference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.a.o;
import android.support.v4.content.d;
import android.support.v4.view.a.a;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Preference
  implements Comparable
{
  public boolean A = true;
  public int B;
  private boolean C;
  private boolean D;
  private boolean E = true;
  private boolean F = true;
  private boolean G = true;
  private boolean H = true;
  private CharSequence I;
  private boolean a = true;
  private boolean b = true;
  private boolean c;
  private final View.OnClickListener d = new n(this);
  private Object e;
  private String f;
  private boolean g = true;
  private List h;
  private Bundle i;
  public Context j;
  public boolean k = true;
  public String l;
  public boolean m;
  public Drawable n;
  public int o;
  public long p;
  public Intent q;
  public String r;
  public int s = 2131624850;
  public p t;
  public q u;
  public int v = Integer.MAX_VALUE;
  public PreferenceGroup w;
  public boolean x = true;
  public ai y;
  public CharSequence z;
  
  public Preference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Preference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, o.a(paramContext, 2130969441, 16842894));
  }
  
  public Preference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public Preference(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.j = paramContext;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ap.E, paramInt1, paramInt2);
    this.o = o.a(paramContext, ap.am, ap.W, 0);
    this.r = o.b(paramContext, ap.ap, ap.Y);
    this.z = o.c(paramContext, ap.ax, ap.ag);
    this.I = o.c(paramContext, ap.aw, ap.af);
    this.v = o.a(paramContext, ap.ar, ap.aa);
    this.l = o.b(paramContext, ap.al, ap.V);
    this.s = o.a(paramContext, ap.aq, ap.Z, 2131624850);
    this.B = o.a(paramContext, ap.ay, ap.ah, 0);
    this.k = o.a(paramContext, ap.ak, ap.U, true);
    this.F = o.a(paramContext, ap.at, ap.ac, true);
    this.x = o.a(paramContext, ap.as, ap.ab, true);
    this.f = o.b(paramContext, ap.aj, ap.T);
    this.a = o.a(paramContext, ap.Q, ap.Q, this.F);
    this.b = o.a(paramContext, ap.R, ap.R, this.F);
    if (paramContext.hasValue(ap.ai)) {
      this.e = a(paramContext, ap.ai);
    }
    for (;;)
    {
      this.G = o.a(paramContext, ap.au, ap.ad, true);
      this.C = paramContext.hasValue(ap.av);
      if (this.C) {
        this.H = o.a(paramContext, ap.av, ap.ae, true);
      }
      this.D = o.a(paramContext, ap.an, ap.X, false);
      this.A = o.a(paramContext, ap.ao, ap.ao, true);
      paramContext.recycle();
      return;
      if (paramContext.hasValue(ap.S)) {
        this.e = a(paramContext, ap.S);
      }
    }
  }
  
  private final Preference a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ai localai = this.y;
      if (localai != null) {
        return localai.a(paramString);
      }
    }
    return null;
  }
  
  private final void a(View paramView, boolean paramBoolean)
  {
    paramView.setEnabled(paramBoolean);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i1 = paramView.getChildCount() - 1;
      while (i1 >= 0)
      {
        a(paramView.getChildAt(i1), paramBoolean);
        i1 -= 1;
      }
    }
  }
  
  private final void d(boolean paramBoolean)
  {
    if (this.g == paramBoolean)
    {
      this.g = (paramBoolean ^ true);
      a(c_());
      b_();
    }
  }
  
  public Object a(TypedArray paramTypedArray, int paramInt)
  {
    return null;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt != this.v)
    {
      this.v = paramInt;
      m();
    }
  }
  
  public final void a(SharedPreferences.Editor paramEditor)
  {
    if ((this.y.a ^ true)) {
      paramEditor.apply();
    }
  }
  
  void a(Bundle paramBundle)
  {
    if (j())
    {
      this.c = false;
      Parcelable localParcelable = d();
      if (!this.c) {
        throw new IllegalStateException("Derived class did not call super.onSaveInstanceState()");
      }
      if (localParcelable != null) {
        paramBundle.putParcelable(this.r, localParcelable);
      }
    }
  }
  
  public void a(Parcelable paramParcelable)
  {
    this.c = true;
    if ((paramParcelable != Preference.BaseSavedState.EMPTY_STATE) && (paramParcelable != null)) {
      throw new IllegalArgumentException("Wrong state class -- expecting Preference State");
    }
  }
  
  public void a(a parama) {}
  
  protected final void a(ai paramai)
  {
    this.y = paramai;
    if (!this.m) {
      this.p = paramai.a();
    }
    if ((!k()) || (!l().contains(this.r)))
    {
      paramai = this.e;
      if (paramai != null) {
        a(paramai);
      }
      return;
    }
    a(null);
  }
  
  public void a(ao paramao)
  {
    paramao.c.setOnClickListener(this.d);
    paramao.c.setId(0);
    Object localObject1 = (TextView)paramao.a(16908310);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = this.z;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label383;
      }
      ((TextView)localObject1).setText((CharSequence)localObject2);
      ((TextView)localObject1).setVisibility(0);
      if (this.C) {
        ((TextView)localObject1).setSingleLine(this.H);
      }
    }
    for (;;)
    {
      localObject1 = (TextView)paramao.a(16908304);
      if (localObject1 != null)
      {
        localObject2 = f();
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label373;
        }
        ((TextView)localObject1).setText((CharSequence)localObject2);
        ((TextView)localObject1).setVisibility(0);
      }
      for (;;)
      {
        localObject1 = (ImageView)paramao.a(16908294);
        int i1;
        if (localObject1 != null)
        {
          i1 = this.o;
          if ((i1 != 0) || (this.n != null)) {
            if (this.n == null) {
              break label358;
            }
          }
        }
        for (;;)
        {
          localObject2 = this.n;
          if (localObject2 != null) {
            ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
          }
          if (this.n != null)
          {
            ((ImageView)localObject1).setVisibility(0);
            localObject1 = paramao.a(2131428313);
            if (localObject1 == null) {
              localObject1 = paramao.a(16908350);
            }
            for (;;)
            {
              if (localObject1 == null) {}
              for (;;)
              {
                if (this.G) {
                  a(paramao.c, i());
                }
                for (;;)
                {
                  boolean bool = this.F;
                  paramao.c.setFocusable(bool);
                  paramao.c.setClickable(bool);
                  paramao.a = this.a;
                  paramao.b = this.b;
                  return;
                  a(paramao.c, true);
                }
                if (this.n == null) {
                  break;
                }
                ((View)localObject1).setVisibility(0);
              }
              if (!this.D) {}
              for (i1 = 8;; i1 = 4)
              {
                ((View)localObject1).setVisibility(i1);
                break;
              }
            }
          }
          if (!this.D) {}
          for (i1 = 8;; i1 = 4)
          {
            ((ImageView)localObject1).setVisibility(i1);
            break;
          }
          label358:
          this.n = d.a(this.j, i1);
        }
        label373:
        ((TextView)localObject1).setVisibility(8);
      }
      label383:
      ((TextView)localObject1).setVisibility(8);
    }
  }
  
  public void a(View paramView)
  {
    if (i())
    {
      e();
      paramView = this.u;
      if (paramView != null) {
        paramView.a();
      }
    }
    else
    {
      return;
    }
    paramView = this.y;
    if (paramView == null) {}
    do
    {
      paramView = this.q;
      if (paramView == null) {
        break;
      }
      this.j.startActivity(paramView);
      return;
      paramView = paramView.d;
    } while ((paramView == null) || (!paramView.a(this)));
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) && (this.I != null)) {}
    for (;;)
    {
      this.I = paramCharSequence;
      b_();
      do
      {
        return;
      } while ((paramCharSequence == null) || (paramCharSequence.equals(this.I)));
    }
  }
  
  public void a(Object paramObject) {}
  
  public void a(boolean paramBoolean)
  {
    List localList = this.h;
    if (localList != null)
    {
      int i2 = localList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ((Preference)localList.get(i1)).d(paramBoolean);
        i1 += 1;
      }
    }
  }
  
  long a_()
  {
    return this.p;
  }
  
  protected final int b(int paramInt)
  {
    int i1 = paramInt;
    if (k()) {
      i1 = this.y.b().getInt(this.r, paramInt);
    }
    return i1;
  }
  
  public final Set b(Set paramSet)
  {
    Set localSet = paramSet;
    if (k()) {
      localSet = this.y.b().getStringSet(this.r, paramSet);
    }
    return localSet;
  }
  
  void b(Bundle paramBundle)
  {
    if (j())
    {
      paramBundle = paramBundle.getParcelable(this.r);
      if (paramBundle != null)
      {
        this.c = false;
        a(paramBundle);
        if (!this.c) {
          throw new IllegalStateException("Derived class did not call super.onRestoreInstanceState()");
        }
      }
    }
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) && (this.z != null)) {}
    for (;;)
    {
      this.z = paramCharSequence;
      b_();
      do
      {
        return;
      } while ((paramCharSequence == null) || (paramCharSequence.equals(this.z)));
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    if (this.E == paramBoolean)
    {
      this.E = (paramBoolean ^ true);
      a(c_());
      b_();
    }
  }
  
  public void b_()
  {
    p localp = this.t;
    if (localp != null) {
      localp.a(this);
    }
  }
  
  protected final boolean c(String paramString)
  {
    if (k())
    {
      if (!TextUtils.equals(paramString, d(null)))
      {
        SharedPreferences.Editor localEditor = this.y.c();
        localEditor.putString(this.r, paramString);
        a(localEditor);
      }
      return true;
    }
    return false;
  }
  
  protected final boolean c(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (k()) {
      bool = this.y.b().getBoolean(this.r, paramBoolean);
    }
    return bool;
  }
  
  public boolean c_()
  {
    return i() ^ true;
  }
  
  public Parcelable d()
  {
    this.c = true;
    return Preference.BaseSavedState.EMPTY_STATE;
  }
  
  protected final String d(String paramString)
  {
    String str = paramString;
    if (k()) {
      str = this.y.b().getString(this.r, paramString);
    }
    return str;
  }
  
  protected void e() {}
  
  public CharSequence f()
  {
    return this.I;
  }
  
  public final Bundle h()
  {
    if (this.i == null) {
      this.i = new Bundle();
    }
    return this.i;
  }
  
  public boolean i()
  {
    return (this.k) && (this.g) && (this.E);
  }
  
  public final boolean j()
  {
    return TextUtils.isEmpty(this.r) ^ true;
  }
  
  public final boolean k()
  {
    return (this.y != null) && (this.x) && (j());
  }
  
  public final SharedPreferences l()
  {
    ai localai = this.y;
    if (localai != null) {
      return localai.b();
    }
    return null;
  }
  
  protected final void m()
  {
    p localp = this.t;
    if (localp != null) {
      localp.a();
    }
  }
  
  public void n()
  {
    if (!TextUtils.isEmpty(this.f))
    {
      localObject = a(this.f);
      if (localObject != null)
      {
        if (((Preference)localObject).h == null) {
          ((Preference)localObject).h = new ArrayList();
        }
        ((Preference)localObject).h.add(this);
        d(((Preference)localObject).c_());
      }
    }
    else
    {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Dependency \"");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append("\" not found for preference \"");
    ((StringBuilder)localObject).append(this.r);
    ((StringBuilder)localObject).append("\" (title: \"");
    ((StringBuilder)localObject).append(this.z);
    ((StringBuilder)localObject).append("\"");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void o()
  {
    p();
  }
  
  final void p()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = a((String)localObject);
      if (localObject != null)
      {
        localObject = ((Preference)localObject).h;
        if (localObject != null) {
          ((List)localObject).remove(this);
        }
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    CharSequence localCharSequence = this.z;
    if (!TextUtils.isEmpty(localCharSequence))
    {
      localStringBuilder.append(localCharSequence);
      localStringBuilder.append(' ');
    }
    localCharSequence = f();
    if (!TextUtils.isEmpty(localCharSequence))
    {
      localStringBuilder.append(localCharSequence);
      localStringBuilder.append(' ');
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.setLength(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/Preference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */