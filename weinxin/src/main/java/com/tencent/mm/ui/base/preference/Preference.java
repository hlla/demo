package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.c;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.m;
import com.tencent.mm.ui.r;
import java.util.List;

public class Preference
  implements Comparable<Preference>
{
  private boolean AK;
  public int PG;
  public String igr;
  public Drawable jQ;
  public int kpH;
  public final Context mContext;
  private Bundle mExtras;
  private CharSequence ouC;
  private CharSequence uI;
  private a vqd;
  private int vqe;
  private int vqf;
  private int vqg;
  private String vqh;
  boolean vqi;
  private boolean vqj;
  public boolean vqk;
  String vql;
  private Object vqm;
  private boolean vqn;
  private boolean vqo;
  private int vqp;
  int vqq;
  private boolean vqr;
  private List<Preference> vqs;
  private int[] xQ;
  
  public Preference(Context paramContext)
  {
    this(paramContext, null);
    GMTrace.i(3220151730176L, 23992);
    GMTrace.o(3220151730176L, 23992);
  }
  
  public Preference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842894);
    GMTrace.i(3220017512448L, 23991);
    GMTrace.o(3220017512448L, 23991);
  }
  
  public Preference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    GMTrace.i(3219883294720L, 23990);
    this.xQ = new int[] { a.c.title, a.c.summary };
    this.vqe = Integer.MAX_VALUE;
    this.AK = true;
    this.vqi = true;
    this.vqk = true;
    this.vqn = true;
    this.kpH = -1;
    this.vqo = true;
    this.vqp = a.h.dis;
    this.vqr = false;
    this.mContext = paramContext;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.m.frp, paramInt, 0);
    paramInt = paramAttributeSet.getIndexCount();
    if (paramInt >= 0)
    {
      int i = paramAttributeSet.getIndex(paramInt);
      if (i == a.m.hfQ) {
        this.PG = paramAttributeSet.getResourceId(i, 0);
      }
      for (;;)
      {
        paramInt -= 1;
        break;
        if (i == a.m.hfR)
        {
          this.igr = paramAttributeSet.getString(i);
        }
        else if (i == a.m.hfY)
        {
          this.vqf = paramAttributeSet.getResourceId(i, 0);
          this.uI = paramAttributeSet.getString(i);
          if (this.vqf != 0) {
            this.uI = paramContext.getString(this.vqf);
          }
        }
        else if (i == a.m.hfX)
        {
          this.ouC = paramAttributeSet.getString(i);
          this.vqg = paramAttributeSet.getResourceId(i, 0);
          if (this.vqg != 0) {
            this.ouC = paramContext.getString(this.vqg);
          }
        }
        else if (i == a.m.hfT)
        {
          this.vqe = paramAttributeSet.getInt(i, this.vqe);
        }
        else if (i == a.m.hfP)
        {
          this.vqh = paramAttributeSet.getString(i);
        }
        else if (i == a.m.hfS)
        {
          this.vqp = paramAttributeSet.getResourceId(i, this.vqp);
        }
        else if (i == a.m.hfZ)
        {
          this.vqq = paramAttributeSet.getResourceId(i, this.vqq);
        }
        else if (i == a.m.hfO)
        {
          this.AK = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == a.m.hfV)
        {
          this.vqi = paramAttributeSet.getBoolean(i, true);
        }
        else if (i == a.m.hfU)
        {
          this.vqk = paramAttributeSet.getBoolean(i, this.vqk);
        }
        else if (i == a.m.hfN)
        {
          this.vql = paramAttributeSet.getString(i);
        }
        else if (i == a.m.hfM)
        {
          this.vqm = null;
        }
        else if (i == a.m.hfW)
        {
          this.vqo = paramAttributeSet.getBoolean(i, this.vqo);
        }
      }
    }
    paramAttributeSet.recycle();
    if (!getClass().getName().startsWith("android.preference")) {
      this.vqr = true;
    }
    GMTrace.o(3219883294720L, 23990);
  }
  
  private void m(View paramView, boolean paramBoolean)
  {
    GMTrace.i(3220957036544L, 23998);
    paramView.setEnabled(paramBoolean);
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = paramView.getChildCount() - 1;
      while (i >= 0)
      {
        m(paramView.getChildAt(i), paramBoolean);
        i -= 1;
      }
    }
    GMTrace.o(3220957036544L, 23998);
  }
  
  private void notifyDependencyChange(boolean paramBoolean)
  {
    GMTrace.i(3222836084736L, 24012);
    List localList = this.vqs;
    if (localList == null)
    {
      GMTrace.o(3222836084736L, 24012);
      return;
    }
    int j = localList.size();
    int i = 0;
    if (i < j)
    {
      Preference localPreference = (Preference)localList.get(i);
      if (localPreference.vqn == paramBoolean) {
        if (paramBoolean) {
          break label103;
        }
      }
      label103:
      for (boolean bool = true;; bool = false)
      {
        localPreference.vqn = bool;
        localPreference.notifyDependencyChange(localPreference.shouldDisableDependents());
        localPreference.notifyChanged();
        i += 1;
        break;
      }
    }
    GMTrace.o(3222836084736L, 24012);
  }
  
  private boolean shouldDisableDependents()
  {
    GMTrace.i(3222970302464L, 24013);
    if (!isEnabled())
    {
      GMTrace.o(3222970302464L, 24013);
      return true;
    }
    GMTrace.o(3222970302464L, 24013);
    return false;
  }
  
  public void a(a parama)
  {
    GMTrace.i(3222567649280L, 24010);
    this.vqd = parama;
    GMTrace.o(3222567649280L, 24010);
  }
  
  public final boolean callChangeListener(Object paramObject)
  {
    GMTrace.i(3222433431552L, 24009);
    if (this.vqd == null)
    {
      GMTrace.o(3222433431552L, 24009);
      return true;
    }
    boolean bool = this.vqd.a(this, paramObject);
    GMTrace.o(3222433431552L, 24009);
    return bool;
  }
  
  public final Bundle getExtras()
  {
    GMTrace.i(17513937108992L, 130489);
    if (this.mExtras == null) {
      this.mExtras = new Bundle();
    }
    Bundle localBundle = this.mExtras;
    GMTrace.o(17513937108992L, 130489);
    return localBundle;
  }
  
  public int getLayoutResource()
  {
    GMTrace.i(18740821360640L, 139630);
    int i = this.vqp;
    GMTrace.o(18740821360640L, 139630);
    return i;
  }
  
  public CharSequence getSummary()
  {
    GMTrace.i(3221493907456L, 24002);
    CharSequence localCharSequence = this.ouC;
    GMTrace.o(3221493907456L, 24002);
    return localCharSequence;
  }
  
  public CharSequence getTitle()
  {
    GMTrace.i(3221359689728L, 24001);
    CharSequence localCharSequence = this.uI;
    GMTrace.o(3221359689728L, 24001);
    return localCharSequence;
  }
  
  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    GMTrace.i(3220554383360L, 23995);
    View localView = paramView;
    if (paramView == null) {
      localView = onCreateView(paramViewGroup);
    }
    onBindView(localView);
    GMTrace.o(3220554383360L, 23995);
    return localView;
  }
  
  public final boolean isEnabled()
  {
    GMTrace.i(3222030778368L, 24006);
    if ((this.AK) && (this.vqn))
    {
      GMTrace.o(3222030778368L, 24006);
      return true;
    }
    GMTrace.o(3222030778368L, 24006);
    return false;
  }
  
  public void notifyChanged()
  {
    GMTrace.i(3222701867008L, 24011);
    GMTrace.o(3222701867008L, 24011);
  }
  
  public void onBindView(View paramView)
  {
    int i = 0;
    GMTrace.i(3220822818816L, 23997);
    Object localObject = paramView.findViewById(a.g.content);
    if (localObject != null) {
      ((View)localObject).setMinimumHeight((int)(paramView.getResources().getDimensionPixelSize(a.e.aXP) * a.dL(this.mContext)));
    }
    localObject = (TextView)paramView.findViewById(16908310);
    if (localObject != null) {
      ((TextView)localObject).setText(getTitle());
    }
    localObject = (TextView)paramView.findViewById(16908304);
    if (localObject != null)
    {
      if (TextUtils.isEmpty(getSummary())) {
        break label238;
      }
      if (((TextView)localObject).getVisibility() != 0) {
        ((TextView)localObject).setVisibility(0);
      }
      ((TextView)localObject).setText(getSummary());
      if (this.kpH != -1) {
        ((TextView)localObject).setTextColor(this.kpH);
      }
    }
    localObject = (ImageView)paramView.findViewById(16908294);
    if (localObject != null)
    {
      if ((this.PG != 0) || (this.jQ != null))
      {
        if (this.jQ == null) {
          this.jQ = this.mContext.getResources().getDrawable(this.PG);
        }
        if (this.jQ != null) {
          ((ImageView)localObject).setImageDrawable(this.jQ);
        }
      }
      if (this.jQ == null) {
        break label256;
      }
    }
    for (;;)
    {
      ((ImageView)localObject).setVisibility(i);
      if (this.vqo) {
        m(paramView, isEnabled());
      }
      GMTrace.o(3220822818816L, 23997);
      return;
      label238:
      if (((TextView)localObject).getVisibility() == 8) {
        break;
      }
      ((TextView)localObject).setVisibility(8);
      break;
      label256:
      i = 8;
    }
  }
  
  public View onCreateView(ViewGroup paramViewGroup)
  {
    GMTrace.i(3220688601088L, 23996);
    LayoutInflater localLayoutInflater = r.eC(this.mContext);
    paramViewGroup = localLayoutInflater.inflate(this.vqp, paramViewGroup, false);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(16908312);
    if (localViewGroup != null)
    {
      if (this.vqq == 0) {
        break label71;
      }
      localLayoutInflater.inflate(this.vqq, localViewGroup);
    }
    for (;;)
    {
      GMTrace.o(3220688601088L, 23996);
      return paramViewGroup;
      label71:
      localViewGroup.setVisibility(8);
    }
  }
  
  public final void setEnabled(boolean paramBoolean)
  {
    GMTrace.i(3221896560640L, 24005);
    if (this.AK != paramBoolean)
    {
      this.AK = paramBoolean;
      notifyDependencyChange(shouldDisableDependents());
      notifyChanged();
    }
    GMTrace.o(3221896560640L, 24005);
  }
  
  public final void setKey(String paramString)
  {
    GMTrace.i(3222299213824L, 24008);
    this.igr = paramString;
    if (this.vqj)
    {
      int i;
      if (!TextUtils.isEmpty(this.igr)) {
        i = 1;
      }
      while (i == 0) {
        if (this.igr == null)
        {
          throw new IllegalStateException("Preference does not have a key assigned.");
          i = 0;
        }
        else
        {
          this.vqj = true;
        }
      }
    }
    GMTrace.o(3222299213824L, 24008);
  }
  
  public final void setLayoutResource(int paramInt)
  {
    GMTrace.i(3220285947904L, 23993);
    if (paramInt != this.vqp) {
      this.vqr = true;
    }
    this.vqp = paramInt;
    GMTrace.o(3220285947904L, 23993);
  }
  
  public final void setSelectable(boolean paramBoolean)
  {
    GMTrace.i(3222164996096L, 24007);
    if (this.vqi != paramBoolean)
    {
      this.vqi = paramBoolean;
      notifyChanged();
    }
    GMTrace.o(3222164996096L, 24007);
  }
  
  public void setSummary(int paramInt)
  {
    GMTrace.i(3221762342912L, 24004);
    setSummary(this.mContext.getString(paramInt));
    GMTrace.o(3221762342912L, 24004);
  }
  
  public void setSummary(CharSequence paramCharSequence)
  {
    GMTrace.i(3221628125184L, 24003);
    if (((paramCharSequence == null) && (this.ouC != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.ouC))))
    {
      this.ouC = paramCharSequence;
      notifyChanged();
    }
    GMTrace.o(3221628125184L, 24003);
  }
  
  public void setTitle(int paramInt)
  {
    GMTrace.i(3221225472000L, 24000);
    setTitle(this.mContext.getString(paramInt));
    this.vqf = paramInt;
    GMTrace.o(3221225472000L, 24000);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    GMTrace.i(3221091254272L, 23999);
    if (((paramCharSequence == null) && (this.uI != null)) || ((paramCharSequence != null) && (!paramCharSequence.equals(this.uI))))
    {
      this.vqf = 0;
      this.uI = paramCharSequence;
      notifyChanged();
    }
    GMTrace.o(3221091254272L, 23999);
  }
  
  public final void setWidgetLayoutResource(int paramInt)
  {
    GMTrace.i(3220420165632L, 23994);
    if (paramInt != this.vqq) {
      this.vqr = true;
    }
    this.vqq = paramInt;
    GMTrace.o(3220420165632L, 23994);
  }
  
  public String toString()
  {
    GMTrace.i(3223104520192L, 24014);
    Object localObject = new StringBuilder();
    CharSequence localCharSequence = getTitle();
    if (!TextUtils.isEmpty(localCharSequence)) {
      ((StringBuilder)localObject).append(localCharSequence).append(' ');
    }
    localCharSequence = getSummary();
    if (!TextUtils.isEmpty(localCharSequence)) {
      ((StringBuilder)localObject).append(localCharSequence).append(' ');
    }
    if (((StringBuilder)localObject).length() > 0) {
      ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 1);
    }
    localObject = ((StringBuilder)localObject).toString();
    GMTrace.o(3223104520192L, 24014);
    return (String)localObject;
  }
  
  public static class BaseSavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<BaseSavedState> CREATOR;
    
    static
    {
      GMTrace.i(3225117786112L, 24029);
      CREATOR = new Parcelable.Creator() {};
      GMTrace.o(3225117786112L, 24029);
    }
    
    public BaseSavedState(Parcel paramParcel)
    {
      super();
      GMTrace.i(3224983568384L, 24028);
      GMTrace.o(3224983568384L, 24028);
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean a(Preference paramPreference, Object paramObject);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ui/base/preference/Preference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */