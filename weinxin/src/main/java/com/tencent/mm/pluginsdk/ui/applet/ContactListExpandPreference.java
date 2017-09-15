package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.comm.a.b;
import com.tencent.mm.plugin.comm.a.d;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.List;

public class ContactListExpandPreference
  extends Preference
{
  private int sLD;
  public e sLE;
  public g sLF;
  
  public ContactListExpandPreference(Context paramContext, int paramInt)
  {
    super(paramContext);
    GMTrace.i(949993078784L, 7078);
    this.sLD = -1;
    if (paramInt == 0) {
      bER();
    }
    for (;;)
    {
      setLayoutResource(a.e.kBU);
      GMTrace.o(949993078784L, 7078);
      return;
      if (paramInt == 1)
      {
        this.sLD = 1;
        this.sLF = new g();
      }
    }
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    GMTrace.i(950127296512L, 7079);
    this.sLD = -1;
    bER();
    setLayoutResource(a.e.kBU);
    GMTrace.o(950127296512L, 7079);
  }
  
  public ContactListExpandPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    GMTrace.i(950261514240L, 7080);
    this.sLD = -1;
    bER();
    setLayoutResource(a.e.kBU);
    GMTrace.o(950261514240L, 7080);
  }
  
  private void bER()
  {
    GMTrace.i(950395731968L, 7081);
    this.sLD = 0;
    this.sLE = new e(this.mContext);
    GMTrace.o(950395731968L, 7081);
  }
  
  public final void MR(String paramString)
  {
    GMTrace.i(951603691520L, 7090);
    if (this.sLE != null) {
      this.sLE.sKQ.sLs = paramString;
    }
    GMTrace.o(951603691520L, 7090);
  }
  
  public final void a(a parama)
  {
    GMTrace.i(953348521984L, 7103);
    if (this.sLE != null) {
      this.sLE.qQn = parama;
    }
    GMTrace.o(953348521984L, 7103);
  }
  
  public final void a(g.b paramb)
  {
    GMTrace.i(953214304256L, 7102);
    if (this.sLE != null) {
      this.sLE.sKR = paramb;
    }
    GMTrace.o(953214304256L, 7102);
  }
  
  public final void a(d paramd)
  {
    GMTrace.i(950798385152L, 7084);
    if (this.sLE != null) {
      this.sLE.sKQ.sLl = paramd;
    }
    GMTrace.o(950798385152L, 7084);
  }
  
  public final void a(com.tencent.mm.ui.base.preference.f paramf, String paramString)
  {
    GMTrace.i(950664167424L, 7083);
    if (this.sLE != null)
    {
      e locale = this.sLE;
      if ((paramf == null) || (paramString == null))
      {
        GMTrace.o(950664167424L, 7083);
        return;
      }
      locale.isp = paramf;
      locale.sKM = paramString;
      paramf.aV(paramString, true);
    }
    GMTrace.o(950664167424L, 7083);
  }
  
  public final void aN(List<String> paramList)
  {
    GMTrace.i(953080086528L, 7101);
    if (this.sLE != null)
    {
      f localf = this.sLE.sKQ;
      localf.bw(paramList);
      localf.notifyChanged();
    }
    GMTrace.o(953080086528L, 7101);
  }
  
  public final void ae(ArrayList<x> paramArrayList)
  {
    GMTrace.i(951201038336L, 7087);
    if (this.sLE != null)
    {
      e locale = this.sLE;
      locale.sKQ.ad(paramArrayList);
      locale.zD(null);
    }
    GMTrace.o(951201038336L, 7087);
  }
  
  public final void bES()
  {
    GMTrace.i(951335256064L, 7088);
    if (this.sLE != null) {
      this.sLE.sKQ.sLx = false;
    }
    GMTrace.o(951335256064L, 7088);
  }
  
  public final void bET()
  {
    GMTrace.i(952408997888L, 7096);
    if (this.sLE != null)
    {
      f localf = this.sLE.sKQ;
      localf.ktA = false;
      localf.notifyChanged();
    }
    GMTrace.o(952408997888L, 7096);
  }
  
  public final ContactListExpandPreference bEU()
  {
    GMTrace.i(952811651072L, 7099);
    if (this.sLE != null) {
      this.sLE.sKQ.sLo = false;
    }
    GMTrace.o(952811651072L, 7099);
    return this;
  }
  
  public final void bEV()
  {
    boolean bool = false;
    GMTrace.i(952945868800L, 7100);
    if (this.sLE != null)
    {
      e locale = this.sLE;
      locale.sKO = false;
      if (locale.sKO) {
        bool = true;
      }
      locale.sKP = bool;
    }
    GMTrace.o(952945868800L, 7100);
  }
  
  public final Object getItem(int paramInt)
  {
    GMTrace.i(18726996934656L, 139527);
    if ((this.sLE != null) && (this.sLE.sKQ.xo(paramInt)))
    {
      Object localObject = this.sLE.sKQ.getItem(paramInt);
      GMTrace.o(18726996934656L, 139527);
      return localObject;
    }
    GMTrace.o(18726996934656L, 139527);
    return null;
  }
  
  public final ContactListExpandPreference jr(boolean paramBoolean)
  {
    GMTrace.i(952543215616L, 7097);
    if (this.sLE != null) {
      this.sLE.sKQ.sLn = paramBoolean;
    }
    GMTrace.o(952543215616L, 7097);
    return this;
  }
  
  public final ContactListExpandPreference js(boolean paramBoolean)
  {
    GMTrace.i(952677433344L, 7098);
    if (this.sLE != null) {
      this.sLE.sKQ.sLm = paramBoolean;
    }
    GMTrace.o(952677433344L, 7098);
    return this;
  }
  
  public final void k(String paramString, List<String> paramList)
  {
    GMTrace.i(951066820608L, 7086);
    if (this.sLE != null)
    {
      e locale = this.sLE;
      locale.username = paramString;
      Object localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList(0);
      }
      locale.sKQ.bw((List)localObject);
      locale.zD(paramString);
    }
    GMTrace.o(951066820608L, 7086);
  }
  
  public final void notifyChanged()
  {
    GMTrace.i(950932602880L, 7085);
    if (this.sLE != null) {
      this.sLE.aVC();
    }
    GMTrace.o(950932602880L, 7085);
  }
  
  public final void onBindView(View paramView)
  {
    GMTrace.i(950529949696L, 7082);
    ViewGroup localViewGroup;
    if (this.sLD == 1)
    {
      g localg = this.sLF;
      if (paramView.getId() == a.d.kBO)
      {
        localViewGroup = (ViewGroup)paramView;
        if (localg.row != 0) {
          break label244;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getResources().getDimensionPixelSize(a.b.aXv), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(a.b.aXy));
        label84:
        if (((localg.sKQ.sLk % f.sLa != f.sLa - 1) && (localg.sKQ.sLk % f.sLa != 0)) || (!localg.krC) || (localg.row != localg.sKQ.getCount() / f.sLa - 1)) {
          break label340;
        }
        localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), 0);
      }
      for (;;)
      {
        label170:
        if (localg.sKQ != null)
        {
          localViewGroup.setOnClickListener(localg.oOv);
          int j;
          if (localViewGroup.getChildCount() > f.sLa)
          {
            j = localViewGroup.getChildCount();
            i = 0;
            for (;;)
            {
              if (i < j - f.sLa)
              {
                localViewGroup.removeViewAt(i);
                i += 1;
                continue;
                localViewGroup = (ViewGroup)paramView.findViewById(a.d.kBO);
                break;
                label244:
                if (localg.row == localg.sKQ.getCount() / f.sLa - 1)
                {
                  localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(a.b.aXv));
                  break label84;
                }
                localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getResources().getDimensionPixelSize(a.b.aXy), localViewGroup.getPaddingRight(), localViewGroup.getResources().getDimensionPixelSize(a.b.aXy));
                break label84;
                label340:
                if ((localg.krC) || (localg.sKQ.sLk % f.sLa != 0) || (localg.row != localg.sKQ.getCount() / f.sLa - 1)) {
                  break label170;
                }
                localViewGroup.setPadding(localViewGroup.getPaddingLeft(), localViewGroup.getPaddingTop(), localViewGroup.getPaddingRight(), (int)localViewGroup.getContext().getResources().getDimension(a.b.aXQ));
                break label170;
              }
            }
            localViewGroup.requestLayout();
          }
          int i = 0;
          if (i < localg.sLG)
          {
            View localView;
            label469:
            LinearLayout.LayoutParams localLayoutParams;
            if (localViewGroup.getChildAt(i) == null)
            {
              localView = View.inflate(localViewGroup.getContext(), a.e.dmA, null);
              localViewGroup.addView(localView);
              localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
              if (f.sLa != 4) {
                break label657;
              }
              j = localViewGroup.getResources().getDimensionPixelSize(a.b.aXG);
              localLayoutParams.setMargins(j, 0, j, 0);
            }
            for (;;)
            {
              if ((!localg.sKQ.bEP()) && (localg.sKQ.sLk == 1))
              {
                j = localViewGroup.getResources().getDimensionPixelSize(a.b.aWF);
                localLayoutParams.setMargins(j, 0, j, 0);
              }
              localView.setLayoutParams(localLayoutParams);
              j = localg.row * localg.sLG + i;
              localg.sKQ.getView(j, localView, localViewGroup);
              if (localg.sKW != null) {
                localView.setOnClickListener(new g.3(localg, localViewGroup, j));
              }
              if (localg.sLH != null) {
                localView.setOnLongClickListener(new g.4(localg, localViewGroup, j));
              }
              i += 1;
              break;
              localView = localViewGroup.getChildAt(i);
              break label469;
              label657:
              j = localViewGroup.getResources().getDimensionPixelSize(a.b.aXy);
              localLayoutParams.setMargins(j, 0, j, 0);
            }
          }
          if ((!localg.sKQ.bEP()) && (localg.sKQ.sLk <= 1)) {
            break label729;
          }
          ((LinearLayout)localViewGroup).setGravity(17);
        }
      }
    }
    for (;;)
    {
      super.onBindView(paramView);
      GMTrace.o(950529949696L, 7082);
      return;
      label729:
      ((LinearLayout)localViewGroup).setGravity(19);
    }
  }
  
  public final void refresh()
  {
    GMTrace.i(16673197260800L, 124225);
    if (this.sLE != null) {
      this.sLE.sKQ.notifyChanged();
    }
    GMTrace.o(16673197260800L, 124225);
  }
  
  public final boolean xo(int paramInt)
  {
    GMTrace.i(951737909248L, 7091);
    if (this.sLE != null)
    {
      boolean bool = this.sLE.sKQ.xo(paramInt);
      GMTrace.o(951737909248L, 7091);
      return bool;
    }
    GMTrace.o(951737909248L, 7091);
    return false;
  }
  
  public final String xp(int paramInt)
  {
    GMTrace.i(952006344704L, 7093);
    if ((this.sLE != null) && (this.sLE.sKQ.xo(paramInt)))
    {
      String str = ((x)this.sLE.sKQ.getItem(paramInt)).field_username;
      GMTrace.o(952006344704L, 7093);
      return str;
    }
    GMTrace.o(952006344704L, 7093);
    return "";
  }
  
  public final String xq(int paramInt)
  {
    GMTrace.i(952140562432L, 7094);
    if ((this.sLE != null) && (this.sLE.sKQ.xo(paramInt)))
    {
      String str = ((x)this.sLE.sKQ.getItem(paramInt)).field_nickname;
      GMTrace.o(952140562432L, 7094);
      return str;
    }
    GMTrace.o(952140562432L, 7094);
    return "";
  }
  
  public final String xr(int paramInt)
  {
    GMTrace.i(952274780160L, 7095);
    if ((this.sLE != null) && (this.sLE.sKQ.xo(paramInt)))
    {
      String str = ((x)this.sLE.sKQ.getItem(paramInt)).field_conRemark;
      GMTrace.o(952274780160L, 7095);
      return str;
    }
    GMTrace.o(952274780160L, 7095);
    return "";
  }
  
  public static abstract interface a
  {
    public abstract void ajm();
    
    public abstract void kG(int paramInt);
    
    public abstract void kH(int paramInt);
    
    public abstract void kI(int paramInt);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/pluginsdk/ui/applet/ContactListExpandPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */