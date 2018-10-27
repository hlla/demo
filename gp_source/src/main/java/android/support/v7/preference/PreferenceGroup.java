package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.content.a.o;
import android.support.v4.g.v;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PreferenceGroup
  extends Preference
{
  public final v a = new v();
  public int b = Integer.MAX_VALUE;
  public List c = new ArrayList();
  private boolean d = false;
  private final Runnable e = new ab(this);
  private int f = 0;
  private final Handler g = new Handler();
  private boolean h = true;
  
  public PreferenceGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, (byte)0);
  }
  
  public PreferenceGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ap.K, paramInt, 0);
    this.h = o.a(paramContext, ap.M, ap.M, true);
    if (paramContext.hasValue(ap.L)) {
      c(o.a(paramContext, ap.L, ap.L));
    }
    paramContext.recycle();
  }
  
  public PreferenceGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    this(paramContext, paramAttributeSet, paramInt);
  }
  
  private final boolean c(Preference paramPreference)
  {
    for (;;)
    {
      try
      {
        paramPreference.p();
        if (paramPreference.w == this) {
          break label103;
        }
        boolean bool = this.c.remove(paramPreference);
        String str;
        if (bool)
        {
          str = paramPreference.r;
          if (str != null) {
            break label61;
          }
          if (this.d) {}
        }
        else
        {
          return bool;
        }
        paramPreference.o();
        continue;
        this.a.put(str, Long.valueOf(paramPreference.a_()));
      }
      finally {}
      label61:
      this.g.removeCallbacks(this.e);
      this.g.post(this.e);
      continue;
      label103:
      paramPreference.w = null;
    }
  }
  
  protected final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    int j = g();
    int i = 0;
    while (i < j)
    {
      d(i).a(paramBundle);
      i += 1;
    }
  }
  
  protected final void a(Parcelable paramParcelable)
  {
    if ((paramParcelable == null) || (!paramParcelable.getClass().equals(PreferenceGroup.SavedState.class)))
    {
      super.a(paramParcelable);
      return;
    }
    paramParcelable = (PreferenceGroup.SavedState)paramParcelable;
    this.b = paramParcelable.a;
    super.a(paramParcelable.getSuperState());
  }
  
  public final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    int j = g();
    int i = 0;
    while (i < j)
    {
      d(i).b(paramBoolean);
      i += 1;
    }
  }
  
  public final boolean a(Preference paramPreference)
  {
    if (!this.c.contains(paramPreference))
    {
      if (paramPreference.r != null) {
        break label227;
      }
      if (paramPreference.v == Integer.MAX_VALUE) {
        break label182;
      }
    }
    Object localObject3;
    for (;;)
    {
      int j = Collections.binarySearch(this.c, paramPreference);
      int i = j;
      if (j < 0) {
        i = -j - 1;
      }
      paramPreference.b(c_());
      for (;;)
      {
        try
        {
          this.c.add(i, paramPreference);
          localObject1 = this.y;
          localObject3 = paramPreference.r;
          if ((localObject3 != null) && (this.a.containsKey(localObject3)))
          {
            l = ((Long)this.a.get(localObject3)).longValue();
            this.a.remove(localObject3);
            paramPreference.p = l;
            paramPreference.m = true;
          }
        }
        finally {}
        try
        {
          paramPreference.a((ai)localObject1);
          paramPreference.m = false;
          paramPreference.w = this;
          if (this.d) {
            paramPreference.n();
          }
          m();
          return true;
        }
        finally
        {
          paramPreference.m = false;
        }
        long l = ((ai)localObject1).a();
      }
      label182:
      if (this.h)
      {
        i = this.f;
        this.f = (i + 1);
        paramPreference.a(i);
      }
      if ((paramPreference instanceof PreferenceGroup)) {
        ((PreferenceGroup)paramPreference).h = this.h;
      }
    }
    label227:
    for (Object localObject1 = this;; localObject1 = localObject3)
    {
      localObject3 = ((Preference)localObject1).w;
      if (localObject3 == null)
      {
        localObject3 = paramPreference.r;
        if (((PreferenceGroup)localObject1).c((CharSequence)localObject3) == null) {
          break;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Found duplicated key: \"");
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append("\". This can cause unintended behaviour,");
        ((StringBuilder)localObject1).append(" please use unique keys for every preference.");
        Log.e("PreferenceGroup", ((StringBuilder)localObject1).toString());
        break;
      }
    }
  }
  
  protected final void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    int j = g();
    int i = 0;
    while (i < j)
    {
      d(i).b(paramBundle);
      i += 1;
    }
  }
  
  public final boolean b(Preference paramPreference)
  {
    boolean bool = c(paramPreference);
    m();
    return bool;
  }
  
  public final Preference c(CharSequence paramCharSequence)
  {
    if (!TextUtils.equals(this.r, paramCharSequence))
    {
      int j = g();
      int i = 0;
      if (i < j)
      {
        Preference localPreference2 = d(i);
        String str = localPreference2.r;
        Preference localPreference1;
        if (str != null)
        {
          localPreference1 = localPreference2;
          if (str.equals(paramCharSequence)) {}
        }
        else
        {
          if (!(localPreference2 instanceof PreferenceGroup)) {}
          do
          {
            i += 1;
            break;
            localPreference1 = ((PreferenceGroup)localPreference2).c(paramCharSequence);
          } while (localPreference1 == null);
        }
        return localPreference1;
      }
      return null;
    }
    return this;
  }
  
  public final void c(int paramInt)
  {
    if ((paramInt != Integer.MAX_VALUE) && (!j()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" should have a key defined if it contains an expandable preference");
      Log.e("PreferenceGroup", localStringBuilder.toString());
    }
    this.b = paramInt;
  }
  
  protected final Parcelable d()
  {
    return new PreferenceGroup.SavedState(super.d(), this.b);
  }
  
  public final Preference d(int paramInt)
  {
    return (Preference)this.c.get(paramInt);
  }
  
  public final int g()
  {
    return this.c.size();
  }
  
  public final void n()
  {
    super.n();
    this.d = true;
    int j = g();
    int i = 0;
    while (i < j)
    {
      d(i).n();
      i += 1;
    }
  }
  
  public final void o()
  {
    int i = 0;
    super.o();
    this.d = false;
    int j = g();
    while (i < j)
    {
      d(i).o();
      i += 1;
    }
  }
  
  protected boolean q()
  {
    return true;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/PreferenceGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */