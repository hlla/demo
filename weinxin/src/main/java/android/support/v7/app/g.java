package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.support.v7.view.f.a;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ViewStubCompat;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.Window.Callback;
import android.widget.PopupWindow;
import java.util.Calendar;

class g
  extends f
{
  private static m GF;
  private int GG = -100;
  private boolean GH;
  boolean GI = true;
  
  g(Context paramContext, Window paramWindow, c paramc)
  {
    super(paramContext, paramWindow, paramc);
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new a(paramCallback);
  }
  
  int at(int paramInt)
  {
    Location localLocation1 = null;
    Object localObject;
    m.a locala;
    boolean bool;
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 0: 
      if (GF == null) {
        GF = new m(this.mContext.getApplicationContext());
      }
      localObject = GF;
      locala = m.HS;
      if (m.a(locala))
      {
        bool = locala.HU;
        if (bool) {
          return 2;
        }
      }
      else
      {
        if (android.support.v4.content.e.d(((m)localObject).mContext, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
          break label223;
        }
      }
      break;
    }
    label188:
    label223:
    for (Location localLocation2 = ((m)localObject).o("network");; localLocation2 = null)
    {
      if (android.support.v4.content.e.d(((m)localObject).mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
        localLocation1 = ((m)localObject).o("gps");
      }
      if ((localLocation1 != null) && (localLocation2 != null))
      {
        localObject = localLocation2;
        if (localLocation1.getTime() > localLocation2.getTime()) {
          localObject = localLocation1;
        }
      }
      for (;;)
      {
        if (localObject == null) {
          break label188;
        }
        m.b((Location)localObject);
        bool = locala.HU;
        break;
        localObject = localLocation2;
        if (localLocation1 != null) {
          localObject = localLocation1;
        }
      }
      paramInt = Calendar.getInstance().get(11);
      if ((paramInt < 6) || (paramInt >= 22))
      {
        bool = true;
        break;
      }
      bool = false;
      break;
      return 1;
      return -1;
    }
  }
  
  public final boolean cS()
  {
    this.GH = true;
    Resources localResources;
    Configuration localConfiguration;
    int j;
    if (this.GG == -100)
    {
      i = d.Gs;
      i = at(i);
      if (i == -1) {
        break label116;
      }
      localResources = this.mContext.getResources();
      localConfiguration = localResources.getConfiguration();
      j = localConfiguration.uiMode;
      if (i != 2) {
        break label108;
      }
    }
    label108:
    for (int i = 32;; i = 16)
    {
      if ((j & 0x30) == i) {
        break label114;
      }
      localConfiguration = new Configuration(localConfiguration);
      localConfiguration.uiMode = (i | localConfiguration.uiMode & 0xFFFFFFCF);
      localResources.updateConfiguration(localConfiguration, null);
      return true;
      i = this.GG;
      break;
    }
    label114:
    return false;
    label116:
    return false;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((paramBundle != null) && (this.GG == -100)) {
      this.GG = paramBundle.getInt("appcompat:local_night_mode", -100);
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.GG != -100) {
      paramBundle.putInt("appcompat:local_night_mode", this.GG);
    }
  }
  
  class a
    extends e.a
  {
    a(Window.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    final ActionMode a(ActionMode.Callback paramCallback)
    {
      f.a locala = new f.a(g.this.mContext, paramCallback);
      g localg = g.this;
      if (localg.GP != null) {
        localg.GP.finish();
      }
      AppCompatDelegateImplV7.b localb1 = new AppCompatDelegateImplV7.b(localg, locala);
      paramCallback = localg.cP();
      if (paramCallback != null) {
        localg.GP = paramCallback.a(localb1);
      }
      label345:
      boolean bool;
      if (localg.GP == null)
      {
        localg.cX();
        if (localg.GP != null) {
          localg.GP.finish();
        }
        AppCompatDelegateImplV7.b localb2 = new AppCompatDelegateImplV7.b(localg, localb1);
        Object localObject;
        if (localg.GQ == null)
        {
          if (!localg.GB) {
            break label545;
          }
          localObject = new TypedValue();
          paramCallback = localg.mContext.getTheme();
          paramCallback.resolveAttribute(a.a.actionBarTheme, (TypedValue)localObject, true);
          if (((TypedValue)localObject).resourceId == 0) {
            break label536;
          }
          Resources.Theme localTheme = localg.mContext.getResources().newTheme();
          localTheme.setTo(paramCallback);
          localTheme.applyStyle(((TypedValue)localObject).resourceId, true);
          paramCallback = new android.support.v7.view.d(localg.mContext, 0);
          paramCallback.getTheme().setTo(localTheme);
          localg.GQ = new ActionBarContextView(paramCallback);
          localg.GR = new PopupWindow(paramCallback, null, a.a.IG);
          android.support.v4.widget.m.a(localg.GR, 2);
          localg.GR.setContentView(localg.GQ);
          localg.GR.setWidth(-1);
          paramCallback.getTheme().resolveAttribute(a.a.actionBarSize, (TypedValue)localObject, true);
          int i = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject).data, paramCallback.getResources().getDisplayMetrics());
          localg.GQ.ay(i);
          localg.GR.setHeight(-2);
          localg.GS = new AppCompatDelegateImplV7.5(localg);
        }
        if (localg.GQ != null)
        {
          localg.cX();
          localg.GQ.dO();
          paramCallback = localg.GQ.getContext();
          localObject = localg.GQ;
          if (localg.GR != null) {
            break label591;
          }
          bool = true;
          label392:
          paramCallback = new android.support.v7.view.e(paramCallback, (ActionBarContextView)localObject, localb2, bool);
          if (!localb1.a(paramCallback, paramCallback.getMenu())) {
            break label596;
          }
          paramCallback.invalidate();
          localg.GQ.c(paramCallback);
          localg.GP = paramCallback;
          z.d(localg.GQ, 0.0F);
          localg.GT = z.V(localg.GQ).p(1.0F);
          localg.GT.a(new AppCompatDelegateImplV7.6(localg));
          if (localg.GR != null) {
            localg.Fe.getDecorView().post(localg.GS);
          }
        }
      }
      for (;;)
      {
        localg.GP = localg.GP;
        paramCallback = localg.GP;
        if (paramCallback == null) {
          break label605;
        }
        return locala.b(paramCallback);
        label536:
        paramCallback = localg.mContext;
        break;
        label545:
        paramCallback = (ViewStubCompat)localg.GV.findViewById(a.f.JS);
        if (paramCallback == null) {
          break label345;
        }
        paramCallback.Du = LayoutInflater.from(localg.cV());
        localg.GQ = ((ActionBarContextView)paramCallback.inflate());
        break label345;
        label591:
        bool = false;
        break label392;
        label596:
        localg.GP = null;
      }
      label605:
      return null;
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      if (g.this.GI) {
        return a(paramCallback);
      }
      return super.onWindowStartingActionMode(paramCallback);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/app/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */