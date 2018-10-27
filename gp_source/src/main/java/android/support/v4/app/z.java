package android.support.v4.app;

import android.a.b.ah;
import android.a.b.k;
import android.a.b.o;
import android.a.b.t;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.g.c;
import android.support.v4.view.ac;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater.Factory2;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class z
  extends v
  implements LayoutInflater.Factory2
{
  private static Field F = null;
  private static final Interpolator l;
  private static final Interpolator m = new DecelerateInterpolator(2.5F);
  private ArrayList A;
  private SparseArray B = null;
  private Bundle C = null;
  private boolean D;
  private ArrayList E;
  public final ArrayList a = new ArrayList();
  public ArrayList b;
  public s c;
  public int d = 0;
  public boolean e;
  public u f;
  public Fragment g;
  public aq h;
  public boolean i;
  public ArrayList j;
  public ArrayList k;
  private SparseArray n;
  private ArrayList o;
  private ArrayList p;
  private ArrayList q;
  private ArrayList r;
  private boolean s;
  private Runnable t = new aa(this);
  private boolean u;
  private final CopyOnWriteArrayList v = new CopyOnWriteArrayList();
  private boolean w;
  private int x = 0;
  private Fragment y;
  private ArrayList z;
  
  static
  {
    l = new DecelerateInterpolator(1.5F);
    new AccelerateInterpolator(2.5F);
    new AccelerateInterpolator(1.5F);
  }
  
  private static ai a(float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localAlphaAnimation.setInterpolator(l);
    localAlphaAnimation.setDuration(220L);
    return new ai(localAlphaAnimation);
  }
  
  private static ai a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setInterpolator(m);
    ((ScaleAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(paramFloat3, paramFloat4);
    ((AlphaAnimation)localObject).setInterpolator(l);
    ((AlphaAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    return new ai(localAnimationSet);
  }
  
  private final ai a(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i1 = paramFragment.H();
    Fragment.aZ_();
    Fragment.ba_();
    boolean bool;
    if (i1 != 0)
    {
      bool = "anim".equals(this.f.b.getResources().getResourceTypeName(i1));
      if (!bool) {}
    }
    try
    {
      paramFragment = AnimationUtils.loadAnimation(this.f.b, i1);
      if (paramFragment != null)
      {
        paramFragment = new ai(paramFragment);
        return paramFragment;
      }
    }
    catch (RuntimeException paramFragment)
    {
      try
      {
        paramFragment = AnimatorInflater.loadAnimator(this.f.b, i1);
        if (paramFragment == null) {
          break label135;
        }
        paramFragment = new ai(paramFragment);
        return paramFragment;
      }
      catch (RuntimeException paramFragment)
      {
        if (bool) {
          break label355;
        }
      }
      paramFragment = AnimationUtils.loadAnimation(this.f.b, i1);
      if (paramFragment != null) {
        return new ai(paramFragment);
      }
      if (paramInt1 != 0)
      {
        switch (paramInt1)
        {
        default: 
          paramInt1 = -1;
        }
        for (;;)
        {
          if (paramInt1 >= 0)
          {
            switch (paramInt1)
            {
            default: 
              paramInt1 = paramInt2;
              if (paramInt2 == 0)
              {
                paramInt1 = paramInt2;
                if (this.f.e()) {
                  paramInt1 = this.f.f();
                }
              }
              if (paramInt1 != 0) {
                return null;
              }
              return null;
            case 6: 
              return a(1.0F, 0.0F);
            case 5: 
              return a(0.0F, 1.0F);
            case 4: 
              return a(1.0F, 1.075F, 1.0F, 0.0F);
            case 3: 
              return a(0.975F, 1.0F, 0.0F, 1.0F);
            case 2: 
              return a(1.0F, 0.975F, 1.0F, 0.0F);
            }
            return a(1.125F, 1.0F, 0.0F, 1.0F);
          }
          return null;
          if (!paramBoolean)
          {
            paramInt1 = 2;
          }
          else
          {
            paramInt1 = 1;
            continue;
            if (!paramBoolean)
            {
              paramInt1 = 4;
            }
            else
            {
              paramInt1 = 3;
              continue;
              if (!paramBoolean) {
                paramInt1 = 6;
              } else {
                paramInt1 = 5;
              }
            }
          }
        }
      }
      return null;
    }
    catch (Resources.NotFoundException paramFragment)
    {
      label135:
      throw paramFragment;
    }
    label355:
    throw paramFragment;
  }
  
  private static Animation.AnimationListener a(Animation paramAnimation)
  {
    try
    {
      if (F != null) {}
      for (;;)
      {
        return (Animation.AnimationListener)F.get(paramAnimation);
        Field localField = Animation.class.getDeclaredField("mListener");
        F = localField;
        localField.setAccessible(true);
      }
      return null;
    }
    catch (NoSuchFieldException paramAnimation)
    {
      Log.e("FragmentManager", "No field with the name mListener is found in Animation class", paramAnimation);
      return null;
    }
    catch (IllegalAccessException paramAnimation)
    {
      Log.e("FragmentManager", "Cannot access Animation's mListener field", paramAnimation);
    }
  }
  
  private final void a(Fragment paramFragment, Context paramContext)
  {
    Object localObject = this.y;
    if (localObject == null) {}
    for (;;)
    {
      paramFragment = this.v.iterator();
      while (paramFragment.hasNext()) {
        paramFragment.next();
      }
      localObject = ((Fragment)localObject).q;
      if ((localObject instanceof z)) {
        ((z)localObject).a(paramFragment, paramContext);
      }
    }
  }
  
  private final void a(Fragment paramFragment, Bundle paramBundle)
  {
    Object localObject = this.y;
    if (localObject == null) {}
    for (;;)
    {
      paramFragment = this.v.iterator();
      while (paramFragment.hasNext()) {
        paramFragment.next();
      }
      localObject = ((Fragment)localObject).q;
      if ((localObject instanceof z)) {
        ((z)localObject).a(paramFragment, paramBundle);
      }
    }
  }
  
  private final void a(Fragment paramFragment, View paramView, Bundle paramBundle)
  {
    Object localObject = this.y;
    if (localObject == null) {}
    for (;;)
    {
      paramFragment = this.v.iterator();
      while (paramFragment.hasNext()) {
        paramFragment.next();
      }
      localObject = ((Fragment)localObject).q;
      if ((localObject instanceof z)) {
        ((z)localObject).a(paramFragment, paramView, paramBundle);
      }
    }
  }
  
  static void a(aq paramaq)
  {
    if (paramaq != null)
    {
      Object localObject = paramaq.b;
      if (localObject == null) {}
      for (;;)
      {
        paramaq = paramaq.a;
        if (paramaq == null) {
          break;
        }
        paramaq = paramaq.iterator();
        while (paramaq.hasNext()) {
          a((aq)paramaq.next());
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((Fragment)((Iterator)localObject).next()).K = true;
        }
      }
    }
  }
  
  private static void a(View paramView, ai paramai)
  {
    if ((paramView != null) && (paramai != null) && (paramView != null) && (paramai != null) && (Build.VERSION.SDK_INT >= 19) && (paramView.getLayerType() == 0) && (ac.A(paramView)))
    {
      localObject = paramai.a;
      if (!(localObject instanceof AlphaAnimation))
      {
        if ((localObject instanceof AnimationSet))
        {
          localObject = ((AnimationSet)localObject).getAnimations();
          int i1 = 0;
          for (;;)
          {
            if (i1 >= ((List)localObject).size()) {
              break label128;
            }
            if ((((List)localObject).get(i1) instanceof AlphaAnimation)) {
              break;
            }
            i1 += 1;
          }
        }
        if (!a(paramai.b)) {}
      }
      else
      {
        localObject = paramai.b;
        if (localObject == null) {
          break label129;
        }
        ((Animator)localObject).addListener(new aj(paramView));
      }
    }
    label128:
    return;
    label129:
    Object localObject = a(paramai.a);
    paramView.setLayerType(2, null);
    paramai.a.setAnimationListener(new af(paramView, (Animation.AnimationListener)localObject));
  }
  
  private final void a(RuntimeException paramRuntimeException)
  {
    Log.e("FragmentManager", paramRuntimeException.getMessage());
    Log.e("FragmentManager", "Activity state:");
    PrintWriter localPrintWriter = new PrintWriter(new android.support.v4.g.g("FragmentManager"));
    u localu = this.f;
    if (localu != null) {}
    try
    {
      localu.a("  ", localPrintWriter, new String[0]);
      for (;;)
      {
        throw paramRuntimeException;
        try
        {
          a("  ", null, localPrintWriter, new String[0]);
        }
        catch (Exception localException1)
        {
          Log.e("FragmentManager", "Failed dumping state", localException1);
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Log.e("FragmentManager", "Failed dumping state", localException2);
      }
    }
  }
  
  private final void a(ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2)
  {
    boolean bool2 = ((f)paramArrayList1.get(paramInt1)).o;
    Object localObject1 = this.E;
    int i3;
    int i1;
    int i2;
    if (localObject1 == null)
    {
      this.E = new ArrayList();
      this.E.addAll(this.a);
      localObject1 = this.g;
      int i4 = paramInt1;
      i3 = 0;
      Object localObject3;
      Object localObject2;
      if (i4 < paramInt2)
      {
        localObject3 = (f)paramArrayList1.get(i4);
        ArrayList localArrayList;
        if (!((Boolean)paramArrayList2.get(i4)).booleanValue())
        {
          localArrayList = this.E;
          i1 = 0;
          localObject2 = localObject1;
          if (i1 < ((f)localObject3).l.size())
          {
            localObject2 = (g)((f)localObject3).l.get(i1);
            switch (((g)localObject2).a)
            {
            }
            for (;;)
            {
              i1 += 1;
              break;
              localArrayList.add(((g)localObject2).d);
              continue;
              ((f)localObject3).l.add(i1, new g(9, (Fragment)localObject1));
              localObject1 = ((g)localObject2).d;
              i1 += 1;
              continue;
              localArrayList.remove(((g)localObject2).d);
              localObject2 = ((g)localObject2).d;
              if (localObject2 == localObject1)
              {
                ((f)localObject3).l.add(i1, new g(9, (Fragment)localObject2));
                localObject1 = null;
                i1 += 1;
              }
              else
              {
                continue;
                localObject4 = ((g)localObject2).d;
                int i6 = ((Fragment)localObject4).m;
                int i5 = localArrayList.size() - 1;
                i2 = 0;
                if (i5 >= 0)
                {
                  Fragment localFragment = (Fragment)localArrayList.get(i5);
                  if (localFragment.m != i6) {}
                  for (;;)
                  {
                    i5 -= 1;
                    break;
                    if (localFragment != localObject4) {
                      break label380;
                    }
                    i2 = 1;
                  }
                  label380:
                  if (localFragment == localObject1)
                  {
                    ((f)localObject3).l.add(i1, new g(9, localFragment));
                    i1 += 1;
                    localObject1 = null;
                  }
                  for (;;)
                  {
                    g localg = new g(3, localFragment);
                    localg.b = ((g)localObject2).b;
                    localg.e = ((g)localObject2).e;
                    localg.c = ((g)localObject2).c;
                    localg.f = ((g)localObject2).f;
                    ((f)localObject3).l.add(i1, localg);
                    localArrayList.remove(localFragment);
                    i1 += 1;
                    break;
                  }
                }
                if (i2 != 0)
                {
                  ((f)localObject3).l.remove(i1);
                  i1 -= 1;
                }
                else
                {
                  ((g)localObject2).a = 1;
                  localArrayList.add(localObject4);
                }
              }
            }
          }
        }
        do
        {
          if (i3 == 0) {
            if (!((f)localObject3).a) {
              i1 = 0;
            }
          }
          for (;;)
          {
            i4 += 1;
            localObject1 = localObject2;
            i3 = i1;
            break;
            i1 = 1;
            continue;
            i1 = 1;
          }
          localArrayList = this.E;
          i1 = 0;
          localObject2 = localObject1;
        } while (i1 >= ((f)localObject3).l.size());
        Object localObject4 = (g)((f)localObject3).l.get(i1);
        localObject2 = localObject1;
        switch (((g)localObject4).a)
        {
        default: 
          localObject2 = localObject1;
        }
        for (;;)
        {
          i1 += 1;
          localObject1 = localObject2;
          break;
          localArrayList.remove(((g)localObject4).d);
          localObject2 = localObject1;
          continue;
          localObject2 = ((g)localObject4).d;
          continue;
          localObject2 = null;
          continue;
          localArrayList.add(((g)localObject4).d);
          localObject2 = localObject1;
        }
      }
      this.E.clear();
      if (!bool2)
      {
        au.a(this, paramArrayList1, paramArrayList2, paramInt1, paramInt2, false);
        i1 = paramInt1;
        label782:
        if (i1 < paramInt2)
        {
          localObject1 = (f)paramArrayList1.get(i1);
          boolean bool1;
          if (((Boolean)paramArrayList2.get(i1)).booleanValue())
          {
            ((f)localObject1).b(-1);
            if (i1 == paramInt2 - 1)
            {
              bool1 = true;
              label833:
              ((f)localObject1).a(bool1);
            }
          }
          for (;;)
          {
            i1 += 1;
            break;
            bool1 = false;
            break label833;
            ((f)localObject1).b(1);
            ((f)localObject1).d();
          }
        }
        if (bool2)
        {
          localObject1 = new c();
          i1 = this.d;
          if (i1 > 0)
          {
            i2 = Math.min(i1, 3);
            i4 = this.a.size();
            i1 = 0;
            if (i1 < i4)
            {
              localObject2 = (Fragment)this.a.get(i1);
              if (((Fragment)localObject2).O < i2)
              {
                a((Fragment)localObject2, i2, ((Fragment)localObject2).H(), ((Fragment)localObject2).I(), false);
                if (((Fragment)localObject2).U != null) {
                  break label981;
                }
              }
              for (;;)
              {
                i1 += 1;
                break;
                label981:
                if ((!((Fragment)localObject2).t) && (((Fragment)localObject2).A)) {
                  ((c)localObject1).add(localObject2);
                }
              }
            }
          }
          i1 = paramInt2 - 1;
          while (i1 >= paramInt1)
          {
            localObject2 = (f)paramArrayList1.get(i1);
            ((Boolean)paramArrayList2.get(i1)).booleanValue();
            i2 = 0;
            while (i2 < ((f)localObject2).l.size())
            {
              localObject3 = ((g)((f)localObject2).l.get(i2)).d;
              if ((localObject3 != null) && (((Fragment)localObject3).f) && (((Fragment)localObject3).U != null) && (!((Fragment)localObject3).o) && (!((Fragment)localObject3).t)) {
                ((Fragment)localObject3).P();
              }
              i2 += 1;
            }
            i1 -= 1;
          }
          i2 = ((c)localObject1).size();
          i1 = 0;
          while (i1 < i2)
          {
            localObject2 = (Fragment)localObject1.a[i1];
            if (!((Fragment)localObject2).f)
            {
              localObject3 = ((Fragment)localObject2).U;
              ((Fragment)localObject2).G = ((View)localObject3).getAlpha();
              ((View)localObject3).setAlpha(0.0F);
            }
            i1 += 1;
          }
        }
      }
    }
    for (;;)
    {
      i2 = paramInt2;
      if (i2 == paramInt1) {
        i1 = paramInt1;
      }
      for (;;)
      {
        if (i1 < paramInt2)
        {
          localObject1 = (f)paramArrayList1.get(i1);
          if (!((Boolean)paramArrayList2.get(i1)).booleanValue()) {}
          for (;;)
          {
            i1 += 1;
            break;
            paramInt1 = ((f)localObject1).i;
            if (paramInt1 >= 0) {
              try
              {
                this.q.set(paramInt1, null);
                if (this.o != null) {}
                for (;;)
                {
                  this.o.add(Integer.valueOf(paramInt1));
                  ((f)localObject1).i = -1;
                  break;
                  this.o = new ArrayList();
                }
                if (i3 == 0) {
                  break label1430;
                }
              }
              finally {}
            }
          }
        }
        if (this.p == null) {
          break;
        }
        paramInt1 = 0;
        while (paramInt1 < this.p.size())
        {
          ((y)this.p.get(paramInt1)).a();
          paramInt1 += 1;
        }
        i1 = paramInt1;
        if (bool2)
        {
          au.a(this, paramArrayList1, paramArrayList2, paramInt1, i2, true);
          a(this.d, true);
          i1 = paramInt1;
        }
      }
      i1 = paramInt1;
      break label782;
      ((ArrayList)localObject1).clear();
      break;
      label1430:
      return;
    }
  }
  
  private static boolean a(Animator paramAnimator)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAnimator != null)
    {
      if (!(paramAnimator instanceof ValueAnimator)) {
        break label59;
      }
      paramAnimator = ((ValueAnimator)paramAnimator).getValues();
      i1 = 0;
      for (;;)
      {
        bool1 = bool2;
        if (i1 >= paramAnimator.length) {
          break label57;
        }
        if ("alpha".equals(paramAnimator[i1].getPropertyName())) {
          break;
        }
        i1 += 1;
      }
      bool1 = true;
    }
    label57:
    label59:
    do
    {
      return bool1;
      bool1 = bool2;
    } while (!(paramAnimator instanceof AnimatorSet));
    paramAnimator = ((AnimatorSet)paramAnimator).getChildAnimations();
    int i1 = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i1 >= paramAnimator.size()) {
        break;
      }
      if (a((Animator)paramAnimator.get(i1))) {
        break label113;
      }
      i1 += 1;
    }
    label113:
    return true;
  }
  
  private final void b(Fragment paramFragment, Context paramContext)
  {
    Object localObject = this.y;
    if (localObject == null) {}
    for (;;)
    {
      paramFragment = this.v.iterator();
      while (paramFragment.hasNext()) {
        paramFragment.next();
      }
      localObject = ((Fragment)localObject).q;
      if ((localObject instanceof z)) {
        ((z)localObject).b(paramFragment, paramContext);
      }
    }
  }
  
  private final void b(Fragment paramFragment, Bundle paramBundle)
  {
    Object localObject = this.y;
    if (localObject == null) {}
    for (;;)
    {
      paramFragment = this.v.iterator();
      while (paramFragment.hasNext()) {
        paramFragment.next();
      }
      localObject = ((Fragment)localObject).q;
      if ((localObject instanceof z)) {
        ((z)localObject).b(paramFragment, paramBundle);
      }
    }
  }
  
  private final void b(Fragment paramFragment, boolean paramBoolean)
  {
    Object localObject = this.y;
    if (localObject == null) {}
    for (;;)
    {
      paramFragment = this.v.iterator();
      while (paramFragment.hasNext())
      {
        localObject = (al)paramFragment.next();
        if (!paramBoolean) {
          ((al)localObject).a.a();
        }
      }
      localObject = ((Fragment)localObject).q;
      if ((localObject instanceof z)) {
        ((z)localObject).b(paramFragment, true);
      }
    }
  }
  
  private final void b(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    Object localObject1 = this.A;
    if (localObject1 != null) {}
    for (int i1 = ((ArrayList)localObject1).size();; i1 = 0)
    {
      int i2 = 0;
      if (i2 >= i1) {
        break;
      }
      localObject1 = (ap)this.A.get(i2);
      int i3;
      if ((paramArrayList1 != null) && (!((ap)localObject1).a))
      {
        i3 = paramArrayList1.indexOf(((ap)localObject1).c);
        if ((i3 != -1) && (((Boolean)paramArrayList2.get(i3)).booleanValue())) {
          ((ap)localObject1).c();
        }
      }
      label261:
      label270:
      label293:
      label361:
      label422:
      label424:
      for (;;)
      {
        i2 += 1;
        break;
        if (((ap)localObject1).b == 0) {}
        for (;;)
        {
          this.A.remove(i2);
          i2 -= 1;
          i1 -= 1;
          if ((paramArrayList1 != null) && (!((ap)localObject1).a))
          {
            i3 = paramArrayList1.indexOf(((ap)localObject1).c);
            if ((i3 != -1) && (((Boolean)paramArrayList2.get(i3)).booleanValue()))
            {
              ((ap)localObject1).c();
              break;
            }
          }
          ((ap)localObject1).b();
          break;
          if (paramArrayList1 == null) {
            break label424;
          }
          f localf = ((ap)localObject1).c;
          int i8 = paramArrayList1.size();
          int i4;
          int i7;
          if (i8 != 0)
          {
            int i9 = localf.l.size();
            i4 = -1;
            int i5 = 0;
            if (i5 < i9)
            {
              Object localObject2 = ((g)localf.l.get(i5)).d;
              if (localObject2 != null)
              {
                i3 = ((Fragment)localObject2).m;
                if (i3 == 0) {}
                while (i3 == i4)
                {
                  i3 = i4;
                  i5 += 1;
                  i4 = i3;
                  break;
                }
                i4 = 0;
                if (i4 < i8)
                {
                  localObject2 = (f)paramArrayList1.get(i4);
                  int i10 = ((f)localObject2).l.size();
                  int i6 = 0;
                  for (;;)
                  {
                    if (i6 < i10)
                    {
                      Fragment localFragment = ((g)((f)localObject2).l.get(i6)).d;
                      if (localFragment != null)
                      {
                        i7 = localFragment.m;
                        if (i7 != i3)
                        {
                          i6 += 1;
                          continue;
                        }
                        i3 = 1;
                      }
                    }
                  }
                }
              }
            }
          }
          for (;;)
          {
            if (i3 != 0) {
              break label422;
            }
            break;
            i7 = 0;
            break label361;
            i4 += 1;
            break label293;
            break label270;
            i3 = 0;
            break label261;
            i3 = 0;
            continue;
            i3 = 0;
          }
        }
      }
    }
  }
  
  private final void c(Fragment paramFragment, Bundle paramBundle)
  {
    Object localObject = this.y;
    if (localObject == null) {}
    for (;;)
    {
      paramFragment = this.v.iterator();
      while (paramFragment.hasNext()) {
        paramFragment.next();
      }
      localObject = ((Fragment)localObject).q;
      if ((localObject instanceof z)) {
        ((z)localObject).c(paramFragment, paramBundle);
      }
    }
  }
  
  private final boolean c(String paramString, int paramInt)
  {
    k();
    a(true);
    Object localObject = this.g;
    if (localObject == null) {}
    do
    {
      do
      {
        boolean bool = a(this.k, this.j, paramString, -1, paramInt);
        if (bool) {
          this.e = true;
        }
        try
        {
          a(this.k, this.j);
          j();
          l();
          return bool;
        }
        finally
        {
          j();
        }
      } while (paramString != null);
      localObject = ((Fragment)localObject).j;
    } while ((localObject == null) || (!((v)localObject).d()));
    return true;
  }
  
  private final boolean c(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    try
    {
      ArrayList localArrayList = this.z;
      if ((localArrayList != null) && (localArrayList.size() != 0))
      {
        int i2 = this.z.size();
        int i1 = 0;
        boolean bool = false;
        for (;;)
        {
          if (i1 >= i2)
          {
            this.z.clear();
            this.f.d.removeCallbacks(this.t);
            return (byte)bool;
          }
          bool |= ((an)this.z.get(i1)).a(paramArrayList1, paramArrayList2);
          i1 += 1;
        }
      }
      return false;
    }
    finally {}
  }
  
  public static int d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 8194: 
      return 4097;
    case 4099: 
      return 4099;
    }
    return 8194;
  }
  
  public static void d(Fragment paramFragment)
  {
    if (!paramFragment.t)
    {
      paramFragment.t = true;
      paramFragment.u ^= true;
    }
  }
  
  private final void d(Fragment paramFragment, Bundle paramBundle)
  {
    Object localObject = this.y;
    if (localObject == null) {}
    for (;;)
    {
      paramFragment = this.v.iterator();
      while (paramFragment.hasNext()) {
        paramFragment.next();
      }
      localObject = ((Fragment)localObject).q;
      if ((localObject instanceof z)) {
        ((z)localObject).d(paramFragment, paramBundle);
      }
    }
  }
  
  public static void e(Fragment paramFragment)
  {
    if (paramFragment.t)
    {
      paramFragment.t = false;
      paramFragment.u ^= true;
    }
  }
  
  private final void i(Fragment paramFragment)
  {
    a(paramFragment, this.d, 0, 0, false);
  }
  
  private final void j(Fragment paramFragment)
  {
    SparseArray localSparseArray;
    if (paramFragment.y != null)
    {
      localSparseArray = this.B;
      if (localSparseArray != null) {
        break label62;
      }
      this.B = new SparseArray();
    }
    for (;;)
    {
      paramFragment.y.saveHierarchyState(this.B);
      if (this.B.size() > 0)
      {
        paramFragment.N = this.B;
        this.B = null;
      }
      return;
      label62:
      localSparseArray.clear();
    }
  }
  
  private final void k(Fragment paramFragment)
  {
    Object localObject = this.y;
    if (localObject == null) {}
    for (;;)
    {
      paramFragment = this.v.iterator();
      while (paramFragment.hasNext()) {
        paramFragment.next();
      }
      localObject = ((Fragment)localObject).q;
      if ((localObject instanceof z)) {
        ((z)localObject).k(paramFragment);
      }
    }
  }
  
  private final void l(Fragment paramFragment)
  {
    Object localObject = this.y;
    if (localObject == null) {}
    for (;;)
    {
      paramFragment = this.v.iterator();
      while (paramFragment.hasNext()) {
        paramFragment.next();
      }
      localObject = ((Fragment)localObject).q;
      if ((localObject instanceof z)) {
        ((z)localObject).l(paramFragment);
      }
    }
  }
  
  private final void m(Fragment paramFragment)
  {
    Object localObject = this.y;
    if (localObject == null) {}
    for (;;)
    {
      paramFragment = this.v.iterator();
      while (paramFragment.hasNext()) {
        paramFragment.next();
      }
      localObject = ((Fragment)localObject).q;
      if ((localObject instanceof z)) {
        ((z)localObject).m(paramFragment);
      }
    }
  }
  
  private final void n(Fragment paramFragment)
  {
    Object localObject = this.y;
    if (localObject == null) {}
    for (;;)
    {
      paramFragment = this.v.iterator();
      while (paramFragment.hasNext()) {
        paramFragment.next();
      }
      localObject = ((Fragment)localObject).q;
      if ((localObject instanceof z)) {
        ((z)localObject).n(paramFragment);
      }
    }
  }
  
  private final void o(Fragment paramFragment)
  {
    Object localObject = this.y;
    if (localObject == null) {}
    for (;;)
    {
      paramFragment = this.v.iterator();
      while (paramFragment.hasNext()) {
        paramFragment.next();
      }
      localObject = ((Fragment)localObject).q;
      if ((localObject instanceof z)) {
        ((z)localObject).o(paramFragment);
      }
    }
  }
  
  private final void p(Fragment paramFragment)
  {
    Object localObject = this.y;
    if (localObject == null) {}
    for (;;)
    {
      paramFragment = this.v.iterator();
      while (paramFragment.hasNext()) {
        paramFragment.next();
      }
      localObject = ((Fragment)localObject).q;
      if ((localObject instanceof z)) {
        ((z)localObject).p(paramFragment);
      }
    }
  }
  
  private final void w()
  {
    if (this.n != null)
    {
      int i1 = 0;
      if (i1 < this.n.size())
      {
        Fragment localFragment = (Fragment)this.n.valueAt(i1);
        if (localFragment == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          if (localFragment.n) {
            if (this.e)
            {
              this.u = true;
            }
            else
            {
              localFragment.n = false;
              a(localFragment, this.d, 0, 0, false);
            }
          }
        }
      }
    }
  }
  
  private final void x()
  {
    if (i()) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
  }
  
  private final void y()
  {
    if (this.A != null) {
      while (!this.A.isEmpty()) {
        ((ap)this.A.remove(0)).b();
      }
    }
  }
  
  private final void z()
  {
    int i1;
    ArrayList localArrayList1;
    Object localObject2;
    Object localObject1;
    Object localObject4;
    ArrayList localArrayList2;
    Object localObject3;
    label99:
    label104:
    int i2;
    if (this.n != null)
    {
      i1 = 0;
      localArrayList1 = null;
      localObject2 = null;
      localObject1 = null;
      for (;;)
      {
        localObject4 = localObject1;
        localArrayList2 = localArrayList1;
        localObject3 = localObject2;
        if (i1 >= this.n.size()) {
          break label314;
        }
        localObject4 = (Fragment)this.n.valueAt(i1);
        if (localObject4 != null) {
          break;
        }
        i1 += 1;
      }
      if (!((Fragment)localObject4).J)
      {
        localObject3 = ((Fragment)localObject4).j;
        if (localObject3 != null)
        {
          ((z)localObject3).z();
          localObject3 = ((Fragment)localObject4).j.h;
          if (localObject2 != null)
          {
            if (localObject2 != null) {
              ((ArrayList)localObject2).add(localObject3);
            }
            if (localArrayList1 == null) {
              if (((Fragment)localObject4).Y != null)
              {
                localArrayList1 = new ArrayList(this.n.size());
                i2 = 0;
                while (i2 < i1)
                {
                  localArrayList1.add(null);
                  i2 += 1;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localArrayList1 != null)
      {
        localArrayList1.add(((Fragment)localObject4).Y);
        break;
      }
      break;
      continue;
      if (localObject3 == null) {
        break label104;
      }
      localArrayList2 = new ArrayList(this.n.size());
      i2 = 0;
      for (;;)
      {
        localObject2 = localArrayList2;
        if (i2 >= i1) {
          break;
        }
        localArrayList2.add(null);
        i2 += 1;
      }
      localObject3 = ((Fragment)localObject4).k;
      break label99;
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = new ArrayList();
      }
      ((ArrayList)localObject3).add(localObject4);
      localObject1 = ((Fragment)localObject4).Q;
      if (localObject1 != null) {}
      for (i2 = ((Fragment)localObject1).x;; i2 = -1)
      {
        ((Fragment)localObject4).R = i2;
        localObject1 = localObject3;
        break;
      }
      localArrayList2 = null;
      localObject3 = null;
      localObject4 = null;
      label314:
      if (localObject4 != null) {}
      while ((localObject3 != null) || (localArrayList2 != null))
      {
        this.h = new aq((List)localObject4, (List)localObject3, localArrayList2);
        return;
      }
      this.h = null;
      return;
    }
  }
  
  public final int a(f paramf)
  {
    try
    {
      localArrayList = this.o;
      if (localArrayList == null) {}
      while (localArrayList.size() <= 0)
      {
        if (this.q != null) {}
        for (;;)
        {
          i1 = this.q.size();
          this.q.add(paramf);
          return i1;
          this.q = new ArrayList();
        }
      }
    }
    finally {}
    ArrayList localArrayList = this.o;
    int i1 = ((Integer)localArrayList.remove(localArrayList.size() - 1)).intValue();
    this.q.set(i1, paramf);
    return i1;
  }
  
  public final Fragment a(int paramInt)
  {
    int i1 = this.a.size() - 1;
    if (i1 >= 0)
    {
      localObject = (Fragment)this.a.get(i1);
      if (localObject == null) {}
      while (((Fragment)localObject).p != paramInt)
      {
        i1 -= 1;
        break;
      }
      return (Fragment)localObject;
    }
    Object localObject = this.n;
    if (localObject != null)
    {
      i1 = ((SparseArray)localObject).size() - 1;
      if (i1 >= 0)
      {
        localObject = (Fragment)this.n.valueAt(i1);
        if (localObject == null) {}
        while (((Fragment)localObject).p != paramInt)
        {
          i1 -= 1;
          break;
        }
        return (Fragment)localObject;
      }
    }
    return null;
  }
  
  public final Fragment a(Bundle paramBundle, String paramString)
  {
    int i1 = paramBundle.getInt(paramString, -1);
    if (i1 != -1)
    {
      paramBundle = (Fragment)this.n.get(i1);
      if (paramBundle == null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Fragment no longer exists for key ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(": index ");
        localStringBuilder.append(i1);
        a(new IllegalStateException(localStringBuilder.toString()));
      }
      return paramBundle;
    }
    return null;
  }
  
  public final Fragment a(String paramString)
  {
    int i1;
    if (paramString != null)
    {
      i1 = this.a.size() - 1;
      if (i1 >= 0)
      {
        localObject = (Fragment)this.a.get(i1);
        if (localObject == null) {}
        while (!paramString.equals(((Fragment)localObject).P))
        {
          i1 -= 1;
          break;
        }
        return (Fragment)localObject;
      }
    }
    Object localObject = this.n;
    if ((localObject != null) && (paramString != null))
    {
      i1 = ((SparseArray)localObject).size() - 1;
      if (i1 >= 0)
      {
        localObject = (Fragment)this.n.valueAt(i1);
        if (localObject == null) {}
        while (!paramString.equals(((Fragment)localObject).P))
        {
          i1 -= 1;
          break;
        }
        return (Fragment)localObject;
      }
    }
    return null;
  }
  
  public final at a()
  {
    return new f(this);
  }
  
  final void a(int paramInt, boolean paramBoolean)
  {
    if (this.f != null) {}
    label134:
    while (paramInt == 0)
    {
      if (paramBoolean) {}
      while (paramInt != this.d)
      {
        this.d = paramInt;
        if (this.n != null)
        {
          int i1 = this.a.size();
          paramInt = 0;
          while (paramInt < i1)
          {
            a((Fragment)this.a.get(paramInt));
            paramInt += 1;
          }
          i1 = this.n.size();
          paramInt = 0;
          Object localObject;
          if (paramInt < i1)
          {
            localObject = (Fragment)this.n.valueAt(paramInt);
            if (localObject == null) {}
            for (;;)
            {
              paramInt += 1;
              break;
              if (((Fragment)localObject).H) {}
              for (;;)
              {
                if (((Fragment)localObject).A) {
                  break label134;
                }
                a((Fragment)localObject);
                break;
                if (!((Fragment)localObject).o) {
                  break;
                }
              }
            }
          }
          w();
          if (this.w)
          {
            localObject = this.f;
            if ((localObject != null) && (this.d == 4))
            {
              ((u)localObject).d();
              this.w = false;
            }
          }
        }
        return;
      }
      return;
    }
    throw new IllegalStateException("No activity");
  }
  
  public final void a(Configuration paramConfiguration)
  {
    int i1 = 0;
    if (i1 < this.a.size())
    {
      Object localObject = (Fragment)this.a.get(i1);
      if (localObject == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        ((Fragment)localObject).onConfigurationChanged(paramConfiguration);
        localObject = ((Fragment)localObject).j;
        if (localObject != null) {
          ((z)localObject).a(paramConfiguration);
        }
      }
    }
  }
  
  public final void a(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (paramFragment.x < 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Fragment ");
      localStringBuilder.append(paramFragment);
      localStringBuilder.append(" is not currently in the FragmentManager");
      a(new IllegalStateException(localStringBuilder.toString()));
    }
    paramBundle.putInt(paramString, paramFragment.x);
  }
  
  final void a(Parcelable paramParcelable, aq arg2)
  {
    FragmentManagerState localFragmentManagerState;
    List localList;
    Object localObject2;
    int i1;
    if (paramParcelable != null)
    {
      localFragmentManagerState = (FragmentManagerState)paramParcelable;
      if (localFragmentManagerState.a != null)
      {
        if (??? == null) {
          break label1539;
        }
        paramParcelable = ???.b;
        localList = ???.a;
        localObject2 = ???.c;
        if (paramParcelable == null) {
          break label1534;
        }
        i1 = paramParcelable.size();
      }
    }
    for (;;)
    {
      int i2 = 0;
      Object localObject1;
      int i3;
      Object localObject3;
      int i4;
      Object localObject4;
      while (i2 < i1)
      {
        localObject1 = (Fragment)paramParcelable.get(i2);
        i3 = 0;
        for (;;)
        {
          localObject3 = localFragmentManagerState.a;
          i4 = localObject3.length;
          if ((i3 >= i4) || (localObject3[i3].h == ((Fragment)localObject1).x)) {
            break;
          }
          i3 += 1;
        }
        if (i3 == i4)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("Could not find active fragment with index ");
          ((StringBuilder)localObject3).append(((Fragment)localObject1).x);
          a(new IllegalStateException(((StringBuilder)localObject3).toString()));
        }
        localObject3 = localFragmentManagerState.a[i3];
        ((FragmentState)localObject3).i = ((Fragment)localObject1);
        ((Fragment)localObject1).N = null;
        ((Fragment)localObject1).h = 0;
        ((Fragment)localObject1).w = false;
        ((Fragment)localObject1).f = false;
        ((Fragment)localObject1).Q = null;
        localObject4 = ((FragmentState)localObject3).k;
        if (localObject4 != null)
        {
          ((Bundle)localObject4).setClassLoader(this.f.b.getClassLoader());
          ((Fragment)localObject1).N = ((FragmentState)localObject3).k.getSparseParcelableArray("android:view_state");
          ((Fragment)localObject1).L = ((FragmentState)localObject3).k;
        }
        i2 += 1;
      }
      this.n = new SparseArray(localFragmentManagerState.a.length);
      i1 = 0;
      for (;;)
      {
        paramParcelable = localFragmentManagerState.a;
        if (i1 >= paramParcelable.length) {
          break label698;
        }
        localObject3 = paramParcelable[i1];
        if (localObject3 != null) {
          break;
        }
        i1 += 1;
      }
      if (localList != null) {
        if (i1 < localList.size()) {
          paramParcelable = (aq)localList.get(i1);
        }
      }
      for (;;)
      {
        if (localObject2 != null) {
          if (i1 < ((List)localObject2).size()) {
            localObject1 = (ah)((List)localObject2).get(i1);
          }
        }
        for (;;)
        {
          localObject4 = this.f;
          Object localObject5 = this.c;
          Fragment localFragment = this.y;
          Context localContext;
          if (((FragmentState)localObject3).i == null)
          {
            localContext = ((u)localObject4).b;
            Bundle localBundle = ((FragmentState)localObject3).a;
            if (localBundle != null) {
              localBundle.setClassLoader(localContext.getClassLoader());
            }
            if (localObject5 != null) {
              break label651;
            }
          }
          label651:
          for (((FragmentState)localObject3).i = Fragment.a(localContext, ((FragmentState)localObject3).b, ((FragmentState)localObject3).a);; ((FragmentState)localObject3).i = ((s)localObject5).a(localContext, ((FragmentState)localObject3).b, ((FragmentState)localObject3).a))
          {
            localObject5 = ((FragmentState)localObject3).k;
            if (localObject5 != null)
            {
              ((Bundle)localObject5).setClassLoader(localContext.getClassLoader());
              ((FragmentState)localObject3).i.L = ((FragmentState)localObject3).k;
            }
            ((FragmentState)localObject3).i.a(((FragmentState)localObject3).h, localFragment);
            localFragment = ((FragmentState)localObject3).i;
            localFragment.r = ((FragmentState)localObject3).f;
            localFragment.I = true;
            localFragment.p = ((FragmentState)localObject3).e;
            localFragment.m = ((FragmentState)localObject3).c;
            localFragment.P = ((FragmentState)localObject3).l;
            localFragment.J = ((FragmentState)localObject3).j;
            localFragment.o = ((FragmentState)localObject3).d;
            localFragment.t = ((FragmentState)localObject3).g;
            localFragment.q = ((u)localObject4).c;
            localObject4 = ((FragmentState)localObject3).i;
            ((Fragment)localObject4).k = paramParcelable;
            ((Fragment)localObject4).Y = ((ah)localObject1);
            this.n.put(((Fragment)localObject4).x, localObject4);
            ((FragmentState)localObject3).i = null;
            break;
          }
          localObject1 = null;
          continue;
          localObject1 = null;
        }
        paramParcelable = null;
        continue;
        paramParcelable = null;
      }
      label698:
      if (??? == null)
      {
        this.a.clear();
        if (localFragmentManagerState.b == null) {}
        label1145:
        label1180:
        label1213:
        label1232:
        label1269:
        do
        {
          paramParcelable = localFragmentManagerState.c;
          if (paramParcelable != null)
          {
            this.b = new ArrayList(paramParcelable.length);
            i1 = 0;
            for (;;)
            {
              paramParcelable = localFragmentManagerState.c;
              if (i1 >= paramParcelable.length) {
                break label1232;
              }
              paramParcelable = paramParcelable[i1];
              ??? = new f(this);
              i2 = 0;
              if (i2 < paramParcelable.g.length)
              {
                localObject1 = new g();
                i3 = i2 + 1;
                localObject2 = paramParcelable.g;
                ((g)localObject1).a = localObject2[i2];
                i2 = i3 + 1;
                i3 = localObject2[i3];
                if (i3 >= 0) {}
                for (((g)localObject1).d = ((Fragment)this.n.get(i3));; ((g)localObject1).d = null)
                {
                  localObject2 = paramParcelable.g;
                  i3 = i2 + 1;
                  ((g)localObject1).b = localObject2[i2];
                  i2 = i3 + 1;
                  ((g)localObject1).c = localObject2[i3];
                  i3 = i2 + 1;
                  ((g)localObject1).e = localObject2[i2];
                  i2 = i3 + 1;
                  ((g)localObject1).f = localObject2[i3];
                  ???.g = ((g)localObject1).b;
                  ???.h = ((g)localObject1).c;
                  ???.m = ((g)localObject1).e;
                  ???.n = ((g)localObject1).f;
                  ???.a((g)localObject1);
                  break;
                }
              }
              ???.r = paramParcelable.k;
              ???.s = paramParcelable.l;
              ???.k = paramParcelable.f;
              ???.i = paramParcelable.e;
              ???.a = true;
              ???.d = paramParcelable.c;
              ???.e = paramParcelable.d;
              ???.b = paramParcelable.a;
              ???.c = paramParcelable.b;
              ???.p = paramParcelable.i;
              ???.q = paramParcelable.j;
              ???.o = paramParcelable.h;
              ???.b(1);
              this.b.add(???);
              i4 = ???.i;
              if (i4 >= 0) {
                break;
              }
              i1 += 1;
            }
            for (;;)
            {
              try
              {
                if (this.q == null) {
                  break label1213;
                }
                i3 = this.q.size();
                i2 = i3;
                if (i4 >= i3) {
                  break label1180;
                }
                this.q.set(i4, ???);
                break;
              }
              finally {}
              this.q.add(null);
              if (this.o != null) {}
              for (;;)
              {
                this.o.add(Integer.valueOf(i2));
                i2 += 1;
                if (i2 < i4) {
                  break label1145;
                }
                this.q.add(???);
                break;
                this.o = new ArrayList();
              }
              this.q = new ArrayList();
            }
          }
          this.b = null;
          i1 = localFragmentManagerState.e;
          if (i1 >= 0) {
            this.g = ((Fragment)this.n.get(i1));
          }
          this.x = localFragmentManagerState.d;
          return;
          i1 = 0;
          paramParcelable = localFragmentManagerState.b;
        } while (i1 >= paramParcelable.length);
        paramParcelable = (Fragment)this.n.get(paramParcelable[i1]);
        if (paramParcelable == null)
        {
          ??? = new StringBuilder();
          ???.append("No instantiated fragment for index #");
          ???.append(localFragmentManagerState.b[i1]);
          a(new IllegalStateException(???.toString()));
        }
        paramParcelable.f = true;
        if (this.a.contains(paramParcelable)) {
          throw new IllegalStateException("Already added!");
        }
      }
      synchronized (this.a)
      {
        this.a.add(paramParcelable);
        i1 += 1;
        break label1269;
        paramParcelable = ???.b;
        if (paramParcelable != null) {}
        for (i1 = paramParcelable.size();; i1 = 0)
        {
          i2 = 0;
          while (i2 < i1)
          {
            ??? = (Fragment)paramParcelable.get(i2);
            i3 = ???.R;
            if (i3 >= 0)
            {
              ???.Q = ((Fragment)this.n.get(i3));
              if (???.Q == null)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("Re-attaching retained fragment ");
                ((StringBuilder)localObject1).append(???);
                ((StringBuilder)localObject1).append(" target no longer exists: ");
                ((StringBuilder)localObject1).append(???.R);
                Log.w("FragmentManager", ((StringBuilder)localObject1).toString());
              }
            }
            i2 += 1;
          }
        }
        label1534:
        i1 = 0;
        continue;
        label1539:
        localList = null;
        localObject2 = null;
      }
    }
  }
  
  final void a(Fragment paramFragment)
  {
    int i2;
    if (paramFragment != null)
    {
      i2 = this.d;
      i1 = i2;
      if (paramFragment.H) {
        if (!paramFragment.bw_()) {
          break label602;
        }
      }
    }
    label198:
    label240:
    label251:
    label602:
    for (int i1 = Math.min(i2, 1);; i1 = Math.min(i2, 0))
    {
      a(paramFragment, i1, paramFragment.I(), paramFragment.J(), false);
      Object localObject1 = paramFragment.U;
      if (localObject1 == null)
      {
        if (paramFragment.u) {
          if (paramFragment.U != null)
          {
            localObject1 = a(paramFragment, paramFragment.I(), paramFragment.t ^ true, paramFragment.J());
            if (localObject1 == null) {
              break label251;
            }
            localObject2 = ((ai)localObject1).b;
            if (localObject2 == null) {
              break label251;
            }
            ((Animator)localObject2).setTarget(paramFragment.U);
            if (!paramFragment.t) {
              break label240;
            }
            if (!paramFragment.Q()) {
              break label198;
            }
            paramFragment.d(false);
          }
        }
        for (;;)
        {
          a(paramFragment.U, (ai)localObject1);
          ((ai)localObject1).b.start();
          if ((paramFragment.f) && (paramFragment.s) && (paramFragment.D)) {
            this.w = true;
          }
          paramFragment.u = false;
          boolean bool = paramFragment.t;
          Fragment.aW_();
          return;
          localObject2 = paramFragment.l;
          View localView = paramFragment.U;
          ((ViewGroup)localObject2).startViewTransition(localView);
          ((ai)localObject1).b.addListener(new ae((ViewGroup)localObject2, localView, paramFragment));
          continue;
          paramFragment.U.setVisibility(0);
        }
        if (localObject1 != null)
        {
          a(paramFragment.U, (ai)localObject1);
          paramFragment.U.startAnimation(((ai)localObject1).a);
          ((ai)localObject1).a.start();
        }
        if (paramFragment.t) {
          if (!paramFragment.Q()) {
            i1 = 8;
          }
        }
        for (;;)
        {
          paramFragment.U.setVisibility(i1);
          if (!paramFragment.Q()) {
            break;
          }
          paramFragment.d(false);
          break;
          i1 = 0;
          continue;
          i1 = 0;
        }
      }
      Object localObject2 = paramFragment.l;
      if (localObject2 == null) {
        localObject1 = null;
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject1 = ((Fragment)localObject1).U;
          localObject2 = paramFragment.l;
          i1 = ((ViewGroup)localObject2).indexOfChild((View)localObject1);
          i2 = ((ViewGroup)localObject2).indexOfChild(paramFragment.U);
          if (i2 < i1)
          {
            ((ViewGroup)localObject2).removeViewAt(i2);
            ((ViewGroup)localObject2).addView(paramFragment.U, i1);
          }
        }
        if ((!paramFragment.A) || (paramFragment.l == null)) {
          break;
        }
        float f1 = paramFragment.G;
        if (f1 > 0.0F) {
          paramFragment.U.setAlpha(f1);
        }
        paramFragment.G = 0.0F;
        paramFragment.A = false;
        localObject1 = a(paramFragment, paramFragment.I(), true, paramFragment.J());
        if (localObject1 == null) {
          break;
        }
        a(paramFragment.U, (ai)localObject1);
        localObject2 = ((ai)localObject1).a;
        if (localObject2 != null)
        {
          paramFragment.U.startAnimation((Animation)localObject2);
          break;
        }
        ((ai)localObject1).b.setTarget(paramFragment.U);
        ((ai)localObject1).b.start();
        break;
        if (localObject1 != null)
        {
          i1 = this.a.indexOf(paramFragment) - 1;
          if (i1 >= 0)
          {
            localObject1 = (Fragment)this.a.get(i1);
            if (((Fragment)localObject1).l != localObject2) {}
            while (((Fragment)localObject1).U == null)
            {
              i1 -= 1;
              break;
            }
          }
          else
          {
            localObject1 = null;
          }
        }
        else
        {
          localObject1 = null;
        }
      }
    }
  }
  
  final void a(Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i1;
    label17:
    label41:
    label56:
    int i2;
    label159:
    Object localObject1;
    if ((paramFragment.f) && (!paramFragment.o))
    {
      i1 = paramInt1;
      paramInt1 = i1;
      if (paramFragment.H)
      {
        paramInt1 = paramFragment.O;
        if (i1 <= paramInt1) {
          paramInt1 = i1;
        }
      }
      else if (paramFragment.n)
      {
        if (paramFragment.O >= 3)
        {
          i2 = paramFragment.O;
          if (i2 <= paramInt1)
          {
            if ((!paramFragment.r) || (paramFragment.w))
            {
              if ((paramFragment.M() != null) || (paramFragment.N() != null))
              {
                paramFragment.d_(null);
                paramFragment.a(null);
                a(paramFragment, paramFragment.O(), 0, 0, true);
              }
              paramInt2 = paramInt1;
            }
            switch (paramFragment.O)
            {
            default: 
              for (i1 = paramInt1;; i1 = paramInt1)
              {
                if (paramFragment.O != i1)
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("moveToState: Fragment state for ");
                  ((StringBuilder)localObject1).append(paramFragment);
                  ((StringBuilder)localObject1).append(" not updated inline; ");
                  ((StringBuilder)localObject1).append("expected state ");
                  ((StringBuilder)localObject1).append(i1);
                  ((StringBuilder)localObject1).append(" found ");
                  ((StringBuilder)localObject1).append(paramFragment.O);
                  Log.w("FragmentManager", ((StringBuilder)localObject1).toString());
                  paramFragment.O = i1;
                }
                return;
                label256:
                localObject1 = paramFragment.j;
                if (localObject1 != null) {
                  ((z)localObject1).r();
                }
                paramFragment.C.a(k.f);
                if (paramFragment.U != null) {
                  paramFragment.X.a(k.f);
                }
                k(paramFragment);
                paramInt1 = paramInt2;
                label306:
                if (paramInt1 > 3)
                {
                  localObject1 = paramFragment.j;
                  if (localObject1 != null)
                  {
                    ((z)localObject1).o();
                    paramFragment.j.k();
                  }
                  paramFragment.O = 4;
                  paramFragment.i = false;
                  paramFragment.w();
                  if (!paramFragment.i)
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("Fragment ");
                    ((StringBuilder)localObject1).append(paramFragment);
                    ((StringBuilder)localObject1).append(" did not call through to super.onResume()");
                    throw new SuperNotCalledException(((StringBuilder)localObject1).toString());
                  }
                  localObject1 = paramFragment.j;
                  if (localObject1 != null)
                  {
                    ((z)localObject1).s();
                    paramFragment.j.k();
                  }
                  paramFragment.C.a(k.e);
                  if (paramFragment.U != null) {
                    paramFragment.X.a(k.e);
                  }
                  l(paramFragment);
                  paramFragment.L = null;
                  paramFragment.N = null;
                  break;
                }
              }
              paramFragment.L = null;
            }
          }
        }
      }
    }
    for (;;)
    {
      paramInt1 = paramInt2;
      if (paramInt2 <= 2) {
        break label306;
      }
      localObject1 = paramFragment.j;
      if (localObject1 != null)
      {
        ((z)localObject1).o();
        paramFragment.j.k();
      }
      paramFragment.O = 3;
      paramFragment.i = false;
      paramFragment.av_();
      if (paramFragment.i) {
        break label256;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Fragment ");
      ((StringBuilder)localObject1).append(paramFragment);
      ((StringBuilder)localObject1).append(" did not call through to super.onStart()");
      throw new SuperNotCalledException(((StringBuilder)localObject1).toString());
      paramFragment.C.a(k.b);
      b(paramFragment, paramFragment.L);
      label601:
      paramFragment.K = false;
      label606:
      label701:
      label725:
      Object localObject2;
      if ((paramFragment.r) && (!paramFragment.F))
      {
        paramFragment.b(paramFragment.g(paramFragment.L), null, paramFragment.L);
        localObject1 = paramFragment.U;
        if (localObject1 != null)
        {
          paramFragment.y = ((View)localObject1);
          ((View)localObject1).setSaveFromParentEnabled(false);
          if (paramFragment.t) {
            paramFragment.U.setVisibility(8);
          }
          paramFragment.a(paramFragment.U, paramFragment.L);
          a(paramFragment, paramFragment.U, paramFragment.L);
        }
      }
      else if (paramInt2 > 1)
      {
        if (!paramFragment.r)
        {
          paramInt1 = paramFragment.m;
          if (paramInt1 != 0) {
            break label1093;
          }
          localObject1 = null;
        }
        label847:
        label1093:
        do
        {
          do
          {
            paramFragment.l = ((ViewGroup)localObject1);
            paramFragment.b(paramFragment.g(paramFragment.L), (ViewGroup)localObject1, paramFragment.L);
            localObject2 = paramFragment.U;
            if (localObject2 != null)
            {
              paramFragment.y = ((View)localObject2);
              ((View)localObject2).setSaveFromParentEnabled(false);
              if (localObject1 != null) {
                ((ViewGroup)localObject1).addView(paramFragment.U);
              }
              if (paramFragment.t) {
                paramFragment.U.setVisibility(8);
              }
              paramFragment.a(paramFragment.U, paramFragment.L);
              a(paramFragment, paramFragment.U, paramFragment.L);
              if (paramFragment.U.getVisibility() == 0) {
                if (paramFragment.l != null)
                {
                  paramBoolean = true;
                  paramFragment.A = paramBoolean;
                }
              }
            }
            for (;;)
            {
              localObject1 = paramFragment.L;
              localObject2 = paramFragment.j;
              if (localObject2 != null) {
                ((z)localObject2).o();
              }
              paramFragment.O = 2;
              paramFragment.i = false;
              paramFragment.d((Bundle)localObject1);
              if (!paramFragment.i)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("Fragment ");
                ((StringBuilder)localObject1).append(paramFragment);
                ((StringBuilder)localObject1).append(" did not call through to super.onActivityCreated()");
                throw new SuperNotCalledException(((StringBuilder)localObject1).toString());
              }
              localObject1 = paramFragment.j;
              if (localObject1 != null) {
                ((z)localObject1).q();
              }
              c(paramFragment, paramFragment.L);
              if (paramFragment.U == null) {
                break;
              }
              localObject1 = paramFragment.L;
              localObject2 = paramFragment.N;
              if (localObject2 != null)
              {
                paramFragment.y.restoreHierarchyState((SparseArray)localObject2);
                paramFragment.N = null;
              }
              paramFragment.i = false;
              paramFragment.i((Bundle)localObject1);
              if (paramFragment.i) {
                break;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Fragment ");
              ((StringBuilder)localObject1).append(paramFragment);
              ((StringBuilder)localObject1).append(" did not call through to super.onViewStateRestored()");
              throw new SuperNotCalledException(((StringBuilder)localObject1).toString());
              paramBoolean = false;
              break label847;
              paramBoolean = false;
              break label847;
              paramFragment.y = null;
            }
            if (paramInt1 == -1)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Cannot create fragment ");
              ((StringBuilder)localObject1).append(paramFragment);
              ((StringBuilder)localObject1).append(" for a container view with no id");
              a(new IllegalArgumentException(((StringBuilder)localObject1).toString()));
            }
            localObject2 = (ViewGroup)this.c.a(paramFragment.m);
            localObject1 = localObject2;
          } while (localObject2 != null);
          localObject1 = localObject2;
        } while (paramFragment.I);
      }
      try
      {
        localObject1 = paramFragment.k().getResourceName(paramFragment.m);
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("No view found for id 0x");
        ((StringBuilder)localObject3).append(Integer.toHexString(paramFragment.m));
        ((StringBuilder)localObject3).append(" (");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(") for fragment ");
        ((StringBuilder)localObject3).append(paramFragment);
        a(new IllegalArgumentException(((StringBuilder)localObject3).toString()));
        localObject1 = localObject2;
        break label725;
        continue;
        paramFragment.y = null;
        break label701;
        paramInt2 = paramInt1;
        if (paramInt1 <= 0) {
          break label606;
        }
        localObject1 = paramFragment.L;
        paramInt2 = paramInt1;
        if (localObject1 != null)
        {
          ((Bundle)localObject1).setClassLoader(this.f.b.getClassLoader());
          paramFragment.N = paramFragment.L.getSparseParcelableArray("android:view_state");
          paramFragment.Q = a(paramFragment.L, "android:target_state");
          if (paramFragment.Q != null) {
            paramFragment.S = paramFragment.L.getInt("android:target_req_state", 0);
          }
          localObject1 = paramFragment.M;
          paramFragment.T = paramFragment.L.getBoolean("android:user_visible_hint", true);
          paramInt2 = paramInt1;
          if (!paramFragment.T)
          {
            paramFragment.n = true;
            paramInt2 = paramInt1;
            if (paramInt1 > 2) {
              paramInt2 = 2;
            }
          }
        }
        paramFragment.v = this.f;
        localObject1 = this.y;
        paramFragment.E = ((Fragment)localObject1);
        if (localObject1 == null) {}
        for (localObject1 = this.f.c;; localObject1 = ((Fragment)localObject1).j)
        {
          paramFragment.q = ((z)localObject1);
          localObject1 = paramFragment.Q;
          if (localObject1 != null)
          {
            localObject1 = this.n.get(((Fragment)localObject1).x);
            localObject2 = paramFragment.Q;
            if (localObject1 != localObject2)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Fragment ");
              ((StringBuilder)localObject1).append(paramFragment);
              ((StringBuilder)localObject1).append(" declared target fragment ");
              ((StringBuilder)localObject1).append(paramFragment.Q);
              ((StringBuilder)localObject1).append(" that does not belong to this FragmentManager!");
              throw new IllegalStateException(((StringBuilder)localObject1).toString());
            }
            if (((Fragment)localObject2).O <= 0) {
              a((Fragment)localObject2, 1, 0, 0, true);
            }
          }
          a(paramFragment, this.f.b);
          paramFragment.i = false;
          paramFragment.a(this.f.b);
          if (!paramFragment.i)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Fragment ");
            ((StringBuilder)localObject1).append(paramFragment);
            ((StringBuilder)localObject1).append(" did not call through to super.onAttach()");
            throw new SuperNotCalledException(((StringBuilder)localObject1).toString());
          }
          if (paramFragment.E != null) {
            Fragment.t();
          }
          b(paramFragment, this.f.b);
          if (!paramFragment.z)
          {
            a(paramFragment, paramFragment.L);
            localObject1 = paramFragment.L;
            localObject2 = paramFragment.j;
            if (localObject2 != null) {
              ((z)localObject2).o();
            }
            paramFragment.O = 1;
            paramFragment.i = false;
            paramFragment.a((Bundle)localObject1);
            paramFragment.z = true;
            if (paramFragment.i) {
              break;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Fragment ");
            ((StringBuilder)localObject1).append(paramFragment);
            ((StringBuilder)localObject1).append(" did not call through to super.onCreate()");
            throw new SuperNotCalledException(((StringBuilder)localObject1).toString());
          }
          paramFragment.h(paramFragment.L);
          paramFragment.O = 1;
          break label601;
        }
        i1 = paramInt1;
        if (i2 <= paramInt1) {
          break label159;
        }
        switch (i2)
        {
        default: 
          i1 = paramInt1;
          break;
        case 1: 
          i1 = paramInt1;
          if (paramInt1 > 0) {
            break;
          }
          if (this.s)
          {
            if (paramFragment.M() == null) {
              break label2369;
            }
            localObject1 = paramFragment.M();
            paramFragment.d_(null);
            ((View)localObject1).clearAnimation();
          }
          for (;;)
          {
            if ((paramFragment.M() != null) || (paramFragment.N() != null))
            {
              paramFragment.e(paramInt1);
              i1 = 1;
              break;
            }
            if (paramFragment.K) {
              paramFragment.O = 0;
            }
            for (;;)
            {
              paramFragment.i = false;
              paramFragment.au_();
              paramFragment.B = null;
              if (!paramFragment.i)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("Fragment ");
                ((StringBuilder)localObject1).append(paramFragment);
                ((StringBuilder)localObject1).append(" did not call through to super.onDetach()");
                throw new SuperNotCalledException(((StringBuilder)localObject1).toString());
              }
              localObject1 = paramFragment.j;
              if (localObject1 != null)
              {
                if (!paramFragment.K)
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("Child FragmentManager of ");
                  ((StringBuilder)localObject1).append(paramFragment);
                  ((StringBuilder)localObject1).append(" was not ");
                  ((StringBuilder)localObject1).append(" destroyed and this fragment is not retaining instance");
                  throw new IllegalStateException(((StringBuilder)localObject1).toString());
                }
                ((z)localObject1).u();
                paramFragment.j = null;
              }
              p(paramFragment);
              i1 = paramInt1;
              if (paramBoolean) {
                break;
              }
              if (paramFragment.K)
              {
                paramFragment.v = null;
                paramFragment.E = null;
                paramFragment.q = null;
                i1 = paramInt1;
                break;
              }
              paramInt2 = paramFragment.x;
              i1 = paramInt1;
              if (paramInt2 < 0) {
                break;
              }
              this.n.put(paramInt2, null);
              paramFragment.x = -1;
              paramFragment.Z = null;
              paramFragment.f = false;
              paramFragment.H = false;
              paramFragment.r = false;
              paramFragment.w = false;
              paramFragment.I = false;
              paramFragment.h = 0;
              paramFragment.q = null;
              paramFragment.j = null;
              paramFragment.v = null;
              paramFragment.p = 0;
              paramFragment.m = 0;
              paramFragment.P = null;
              paramFragment.t = false;
              paramFragment.o = false;
              paramFragment.K = false;
              i1 = paramInt1;
              break;
              paramFragment.C.a(k.c);
              localObject1 = paramFragment.j;
              if (localObject1 != null) {
                ((z)localObject1).u();
              }
              paramFragment.O = 0;
              paramFragment.i = false;
              paramFragment.z = false;
              paramFragment.y();
              if (!paramFragment.i)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("Fragment ");
                ((StringBuilder)localObject1).append(paramFragment);
                ((StringBuilder)localObject1).append(" did not call through to super.onDestroy()");
                throw new SuperNotCalledException(((StringBuilder)localObject1).toString());
              }
              paramFragment.j = null;
              o(paramFragment);
            }
            if (paramFragment.N() != null)
            {
              localObject1 = paramFragment.N();
              paramFragment.a(null);
              ((Animator)localObject1).cancel();
            }
          }
        case 4: 
          if (paramInt1 < 4)
          {
            if (paramFragment.U != null) {
              paramFragment.X.a(k.d);
            }
            paramFragment.C.a(k.d);
            localObject1 = paramFragment.j;
            if (localObject1 != null) {
              break label3072;
            }
          }
        case 3: 
        case 2: 
          for (;;)
          {
            label2369:
            paramFragment.O = 3;
            paramFragment.i = false;
            paramFragment.x();
            if (!paramFragment.i)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Fragment ");
              ((StringBuilder)localObject1).append(paramFragment);
              ((StringBuilder)localObject1).append(" did not call through to super.onPause()");
              throw new SuperNotCalledException(((StringBuilder)localObject1).toString());
            }
            b(paramFragment, false);
            if (paramInt1 < 3)
            {
              paramFragment.C.a(k.g);
              localObject1 = paramFragment.j;
              if (localObject1 != null) {
                ((z)localObject1).t();
              }
              paramFragment.O = 2;
              paramFragment.i = false;
              paramFragment.o_();
              if (!paramFragment.i)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("Fragment ");
                ((StringBuilder)localObject1).append(paramFragment);
                ((StringBuilder)localObject1).append(" did not call through to super.onStop()");
                throw new SuperNotCalledException(((StringBuilder)localObject1).toString());
              }
              m(paramFragment);
            }
            if (paramInt1 >= 2) {
              break;
            }
            if ((paramFragment.U != null) && (this.f.b()) && (paramFragment.N == null)) {
              j(paramFragment);
            }
            localObject1 = paramFragment.j;
            if (localObject1 == null) {}
            for (;;)
            {
              paramFragment.O = 1;
              paramFragment.i = false;
              paramFragment.f();
              if (!paramFragment.i)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("Fragment ");
                ((StringBuilder)localObject1).append(paramFragment);
                ((StringBuilder)localObject1).append(" did not call through to super.onDestroyView()");
                throw new SuperNotCalledException(((StringBuilder)localObject1).toString());
              }
              bt.a(paramFragment).a();
              paramFragment.F = false;
              n(paramFragment);
              localObject1 = paramFragment.U;
              if (localObject1 != null)
              {
                localObject2 = paramFragment.l;
                if (localObject2 != null)
                {
                  ((ViewGroup)localObject2).endViewTransition((View)localObject1);
                  paramFragment.U.clearAnimation();
                  if (this.d <= 0) {
                    break label3057;
                  }
                  if (this.s) {
                    break label3051;
                  }
                  if (paramFragment.U.getVisibility() != 0) {
                    break label3045;
                  }
                  if (paramFragment.G < 0.0F) {
                    break label3039;
                  }
                  localObject1 = a(paramFragment, paramInt2, false, paramInt3);
                }
              }
              for (;;)
              {
                paramFragment.G = 0.0F;
                if (localObject1 == null) {}
                for (;;)
                {
                  paramFragment.l.removeView(paramFragment.U);
                  paramFragment.l = null;
                  paramFragment.U = null;
                  paramFragment.V = null;
                  paramFragment.W.a(null);
                  paramFragment.y = null;
                  paramFragment.w = false;
                  break;
                  localObject2 = paramFragment.U;
                  localObject3 = paramFragment.l;
                  ((ViewGroup)localObject3).startViewTransition((View)localObject2);
                  paramFragment.e(paramInt1);
                  Object localObject4 = ((ai)localObject1).a;
                  if (localObject4 != null)
                  {
                    localObject4 = new ak((Animation)localObject4, (ViewGroup)localObject3, (View)localObject2);
                    paramFragment.d_(paramFragment.U);
                    ((Animation)localObject4).setAnimationListener(new ab(this, a((Animation)localObject4), (ViewGroup)localObject3, paramFragment));
                    a((View)localObject2, (ai)localObject1);
                    paramFragment.U.startAnimation((Animation)localObject4);
                  }
                  else
                  {
                    localObject4 = ((ai)localObject1).b;
                    paramFragment.a((Animator)localObject4);
                    ((Animator)localObject4).addListener(new ad(this, (ViewGroup)localObject3, (View)localObject2, paramFragment));
                    ((Animator)localObject4).setTarget(paramFragment.U);
                    a(paramFragment.U, (ai)localObject1);
                    ((Animator)localObject4).start();
                  }
                }
                label3039:
                localObject1 = null;
                continue;
                label3045:
                localObject1 = null;
                continue;
                label3051:
                localObject1 = null;
                continue;
                label3057:
                localObject1 = null;
              }
              ((z)localObject1).c(1);
            }
            label3072:
            ((z)localObject1).c(3);
          }
          if (paramInt1 > 2)
          {
            paramInt1 = 2;
            break label56;
          }
          break label56;
          break label56;
          if (paramInt1 != 0) {}
          while (!paramFragment.bw_())
          {
            paramInt1 = paramFragment.O;
            break;
          }
          paramInt1 = 1;
          break label41;
          i1 = paramInt1;
          if (paramInt1 <= 1) {
            break label17;
          }
          i1 = 1;
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        for (;;)
        {
          String str = "unknown";
        }
      }
      break label306;
      paramInt2 = paramInt1;
    }
  }
  
  public final void a(Fragment paramFragment, boolean paramBoolean)
  {
    b(paramFragment);
    if (!paramFragment.o) {
      if (this.a.contains(paramFragment))
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("Fragment already added: ");
        ((StringBuilder)???).append(paramFragment);
        throw new IllegalStateException(((StringBuilder)???).toString());
      }
    }
    synchronized (this.a)
    {
      this.a.add(paramFragment);
      paramFragment.f = true;
      paramFragment.H = false;
      if (paramFragment.U == null) {
        paramFragment.u = false;
      }
      if ((paramFragment.s) && (paramFragment.D)) {
        this.w = true;
      }
      if (paramBoolean) {
        i(paramFragment);
      }
      return;
    }
  }
  
  public final void a(an paraman, boolean paramBoolean)
  {
    int i2 = 1;
    if (paramBoolean) {}
    for (;;)
    {
      int i1;
      try
      {
        if ((this.s) || (this.f == null)) {
          break label167;
        }
        if (this.z != null)
        {
          this.z.add(paraman);
          try
          {
            paraman = this.A;
            if (paraman != null)
            {
              if (!paraman.isEmpty())
              {
                i1 = 1;
                paraman = this.z;
                if (paraman != null)
                {
                  if (paraman.size() == 1)
                  {
                    break label192;
                    this.f.d.removeCallbacks(this.t);
                    this.f.d.post(this.t);
                    return;
                    if (i2 == 0) {
                      continue;
                    }
                    continue;
                  }
                  i2 = 0;
                  break label192;
                }
                i2 = 0;
                break label192;
              }
              i1 = 0;
              continue;
            }
            i1 = 0;
            continue;
            paraman = finally;
          }
          finally {}
        }
        this.z = new ArrayList();
      }
      finally {}
      continue;
      label167:
      if (!paramBoolean) {
        throw new IllegalStateException("Activity has been destroyed");
      }
      return;
      x();
      break;
      label192:
      if (i1 == 0) {}
    }
  }
  
  final void a(f paramf, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!paramBoolean1) {
      paramf.d();
    }
    for (;;)
    {
      Object localObject = new ArrayList(1);
      ArrayList localArrayList = new ArrayList(1);
      ((ArrayList)localObject).add(paramf);
      localArrayList.add(Boolean.valueOf(paramBoolean1));
      if (paramBoolean2) {
        au.a(this, (ArrayList)localObject, localArrayList, 0, 1, true);
      }
      if (!paramBoolean3) {}
      for (;;)
      {
        localObject = this.n;
        if (localObject == null) {
          break;
        }
        int i2 = ((SparseArray)localObject).size();
        int i1 = 0;
        if (i1 >= i2) {
          break;
        }
        localObject = (Fragment)this.n.valueAt(i1);
        if (localObject == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          if ((((Fragment)localObject).U != null) && (((Fragment)localObject).A) && (paramf.c(((Fragment)localObject).m)))
          {
            float f1 = ((Fragment)localObject).G;
            if (f1 > 0.0F) {
              ((Fragment)localObject).U.setAlpha(f1);
            }
            if (!paramBoolean3)
            {
              ((Fragment)localObject).G = -1.0F;
              ((Fragment)localObject).A = false;
            }
            else
            {
              ((Fragment)localObject).G = 0.0F;
            }
          }
        }
        a(this.d, true);
      }
      paramf.a(paramBoolean3);
    }
  }
  
  public final void a(u paramu, s params, Fragment paramFragment)
  {
    if (this.f != null) {
      throw new IllegalStateException("Already attached");
    }
    this.f = paramu;
    this.c = params;
    this.y = paramFragment;
  }
  
  public final void a(x paramx)
  {
    this.v.add(new al(paramx));
  }
  
  public final void a(y paramy)
  {
    if (this.p == null) {
      this.p = new ArrayList();
    }
    this.p.add(paramy);
  }
  
  public final void a(String paramString, int paramInt)
  {
    a(new ao(this, paramString, -1, paramInt), false);
  }
  
  public final void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int i3 = 0;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("    ");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = this.n;
    int i1;
    if (localObject2 != null)
    {
      i2 = ((SparseArray)localObject2).size();
      if (i2 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        i1 = 0;
        if (i1 < i2)
        {
          localObject2 = (Fragment)this.n.valueAt(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localObject2);
          if (localObject2 == null) {}
          for (;;)
          {
            i1 += 1;
            break;
            ((Fragment)localObject2).a((String)localObject1, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          }
        }
      }
    }
    int i2 = this.a.size();
    if (i2 > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Added Fragments:");
      i1 = 0;
      while (i1 < i2)
      {
        paramFileDescriptor = (Fragment)this.a.get(i1);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(i1);
        paramPrintWriter.print(": ");
        paramPrintWriter.println(paramFileDescriptor.toString());
        i1 += 1;
      }
    }
    paramFileDescriptor = this.r;
    if (paramFileDescriptor != null)
    {
      i2 = paramFileDescriptor.size();
      if (i2 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        i1 = 0;
        while (i1 < i2)
        {
          paramFileDescriptor = (Fragment)this.r.get(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          i1 += 1;
        }
      }
    }
    paramFileDescriptor = this.b;
    if (paramFileDescriptor != null)
    {
      int i4 = paramFileDescriptor.size();
      if (i4 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        i1 = 0;
        while (i1 < i4)
        {
          paramArrayOfString = (f)this.b.get(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramArrayOfString.toString());
          paramPrintWriter.print((String)localObject1);
          paramPrintWriter.print("mName=");
          paramPrintWriter.print(paramArrayOfString.k);
          paramPrintWriter.print(" mIndex=");
          paramPrintWriter.print(paramArrayOfString.i);
          paramPrintWriter.print(" mCommitted=");
          paramPrintWriter.println(paramArrayOfString.f);
          if (paramArrayOfString.r != 0)
          {
            paramPrintWriter.print((String)localObject1);
            paramPrintWriter.print("mTransition=#");
            paramPrintWriter.print(Integer.toHexString(paramArrayOfString.r));
            paramPrintWriter.print(" mTransitionStyle=#");
            paramPrintWriter.println(Integer.toHexString(paramArrayOfString.s));
          }
          if ((paramArrayOfString.g != 0) || (paramArrayOfString.h != 0))
          {
            paramPrintWriter.print((String)localObject1);
            paramPrintWriter.print("mEnterAnim=#");
            paramPrintWriter.print(Integer.toHexString(paramArrayOfString.g));
            paramPrintWriter.print(" mExitAnim=#");
            paramPrintWriter.println(Integer.toHexString(paramArrayOfString.h));
          }
          if ((paramArrayOfString.m != 0) || (paramArrayOfString.n != 0))
          {
            paramPrintWriter.print((String)localObject1);
            paramPrintWriter.print("mPopEnterAnim=#");
            paramPrintWriter.print(Integer.toHexString(paramArrayOfString.m));
            paramPrintWriter.print(" mPopExitAnim=#");
            paramPrintWriter.println(Integer.toHexString(paramArrayOfString.n));
          }
          if ((paramArrayOfString.d != 0) || (paramArrayOfString.e != null))
          {
            paramPrintWriter.print((String)localObject1);
            paramPrintWriter.print("mBreadCrumbTitleRes=#");
            paramPrintWriter.print(Integer.toHexString(paramArrayOfString.d));
            paramPrintWriter.print(" mBreadCrumbTitleText=");
            paramPrintWriter.println(paramArrayOfString.e);
          }
          if ((paramArrayOfString.b != 0) || (paramArrayOfString.c != null))
          {
            paramPrintWriter.print((String)localObject1);
            paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
            paramPrintWriter.print(Integer.toHexString(paramArrayOfString.b));
            paramPrintWriter.print(" mBreadCrumbShortTitleText=");
            paramPrintWriter.println(paramArrayOfString.c);
          }
          if (!paramArrayOfString.l.isEmpty())
          {
            paramPrintWriter.print((String)localObject1);
            paramPrintWriter.println("Operations:");
            paramFileDescriptor = new StringBuilder();
            paramFileDescriptor.append((String)localObject1);
            paramFileDescriptor.append("    ");
            int i5 = paramArrayOfString.l.size();
            i2 = 0;
            if (i2 < i5)
            {
              localObject2 = (g)paramArrayOfString.l.get(i2);
              switch (((g)localObject2).a)
              {
              default: 
                paramFileDescriptor = new StringBuilder();
                paramFileDescriptor.append("cmd=");
                paramFileDescriptor.append(((g)localObject2).a);
                paramFileDescriptor = paramFileDescriptor.toString();
              }
              for (;;)
              {
                paramPrintWriter.print((String)localObject1);
                paramPrintWriter.print("  Op #");
                paramPrintWriter.print(i2);
                paramPrintWriter.print(": ");
                paramPrintWriter.print(paramFileDescriptor);
                paramPrintWriter.print(" ");
                paramPrintWriter.println(((g)localObject2).d);
                if ((((g)localObject2).b != 0) || (((g)localObject2).c != 0))
                {
                  paramPrintWriter.print((String)localObject1);
                  paramPrintWriter.print("enterAnim=#");
                  paramPrintWriter.print(Integer.toHexString(((g)localObject2).b));
                  paramPrintWriter.print(" exitAnim=#");
                  paramPrintWriter.println(Integer.toHexString(((g)localObject2).c));
                }
                if ((((g)localObject2).e != 0) || (((g)localObject2).f != 0))
                {
                  paramPrintWriter.print((String)localObject1);
                  paramPrintWriter.print("popEnterAnim=#");
                  paramPrintWriter.print(Integer.toHexString(((g)localObject2).e));
                  paramPrintWriter.print(" popExitAnim=#");
                  paramPrintWriter.println(Integer.toHexString(((g)localObject2).f));
                }
                i2 += 1;
                break;
                paramFileDescriptor = "UNSET_PRIMARY_NAV";
                continue;
                paramFileDescriptor = "SET_PRIMARY_NAV";
                continue;
                paramFileDescriptor = "ATTACH";
                continue;
                paramFileDescriptor = "DETACH";
                continue;
                paramFileDescriptor = "SHOW";
                continue;
                paramFileDescriptor = "HIDE";
                continue;
                paramFileDescriptor = "REMOVE";
                continue;
                paramFileDescriptor = "REPLACE";
                continue;
                paramFileDescriptor = "ADD";
                continue;
                paramFileDescriptor = "NULL";
              }
            }
          }
          i1 += 1;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramFileDescriptor = this.q;
        if (paramFileDescriptor == null)
        {
          paramFileDescriptor = this.o;
          if ((paramFileDescriptor == null) || (paramFileDescriptor.size() <= 0))
          {
            paramFileDescriptor = this.z;
            if (paramFileDescriptor != null)
            {
              i2 = paramFileDescriptor.size();
              if (i2 > 0)
              {
                paramPrintWriter.print(paramString);
                paramPrintWriter.println("Pending Actions:");
                i1 = i3;
                if (i1 < i2)
                {
                  paramFileDescriptor = (an)this.z.get(i1);
                  paramPrintWriter.print(paramString);
                  paramPrintWriter.print("  #");
                  paramPrintWriter.print(i1);
                  paramPrintWriter.print(": ");
                  paramPrintWriter.println(paramFileDescriptor);
                  i1 += 1;
                  continue;
                }
              }
            }
            paramPrintWriter.print(paramString);
            paramPrintWriter.println("FragmentManager misc state:");
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  mHost=");
            paramPrintWriter.println(this.f);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  mContainer=");
            paramPrintWriter.println(this.c);
            if (this.y != null)
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("  mParent=");
              paramPrintWriter.println(this.y);
            }
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  mCurState=");
            paramPrintWriter.print(this.d);
            paramPrintWriter.print(" mStateSaved=");
            paramPrintWriter.print(this.i);
            paramPrintWriter.print(" mStopped=");
            paramPrintWriter.print(this.D);
            paramPrintWriter.print(" mDestroyed=");
            paramPrintWriter.println(this.s);
            if (this.w)
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("  mNeedMenuInvalidate=");
              paramPrintWriter.println(this.w);
            }
            return;
          }
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("mAvailBackStackIndices: ");
          paramPrintWriter.println(Arrays.toString(this.o.toArray()));
          continue;
        }
        i2 = paramFileDescriptor.size();
      }
      finally {}
      if (i2 > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack Indices:");
        i1 = 0;
        while (i1 < i2)
        {
          paramFileDescriptor = (f)this.q.get(i1);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i1);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor);
          i1 += 1;
        }
      }
    }
  }
  
  final void a(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    int i1 = 0;
    if ((paramArrayList1 != null) && (!paramArrayList1.isEmpty()))
    {
      if ((paramArrayList2 == null) || (paramArrayList1.size() != paramArrayList2.size())) {
        throw new IllegalStateException("Internal error with the back stack records");
      }
      b(paramArrayList1, paramArrayList2);
      int i4 = paramArrayList1.size();
      int i2 = 0;
      while (i1 < i4)
      {
        int i3;
        if (((f)paramArrayList1.get(i1)).o)
        {
          i3 = i1;
          i1 = i2;
          i2 = i1;
          i1 = i3 + 1;
        }
        else
        {
          if (i2 == i1) {}
          for (;;)
          {
            i3 = i1 + 1;
            i2 = i3;
            if (((Boolean)paramArrayList2.get(i1)).booleanValue()) {
              for (;;)
              {
                i2 = i3;
                if (i3 >= i4) {
                  break;
                }
                i2 = i3;
                if (!((Boolean)paramArrayList2.get(i3)).booleanValue()) {
                  break;
                }
                i2 = i3;
                if (((f)paramArrayList1.get(i3)).o) {
                  break;
                }
                i3 += 1;
              }
            }
            a(paramArrayList1, paramArrayList2, i1, i2);
            i3 = i2 - 1;
            i1 = i2;
            break;
            a(paramArrayList1, paramArrayList2, i2, i1);
          }
        }
      }
      if (i2 != i4) {
        a(paramArrayList1, paramArrayList2, i2, i4);
      }
    }
  }
  
  /* Error */
  final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 589	android/support/v4/app/z:e	Z
    //   4: ifeq +14 -> 18
    //   7: new 661	java/lang/IllegalStateException
    //   10: dup
    //   11: ldc_w 1405
    //   14: invokespecial 664	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   17: athrow
    //   18: aload_0
    //   19: getfield 159	android/support/v4/app/z:f	Landroid/support/v4/app/u;
    //   22: ifnonnull +14 -> 36
    //   25: new 661	java/lang/IllegalStateException
    //   28: dup
    //   29: ldc_w 1407
    //   32: invokespecial 664	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   35: athrow
    //   36: invokestatic 1413	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   39: aload_0
    //   40: getfield 159	android/support/v4/app/z:f	Landroid/support/v4/app/u;
    //   43: getfield 607	android/support/v4/app/u:d	Landroid/os/Handler;
    //   46: invokevirtual 1416	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   49: if_acmpeq +14 -> 63
    //   52: new 661	java/lang/IllegalStateException
    //   55: dup
    //   56: ldc_w 1418
    //   59: invokespecial 664	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   62: athrow
    //   63: iload_1
    //   64: ifeq +49 -> 113
    //   67: aload_0
    //   68: getfield 582	android/support/v4/app/z:k	Ljava/util/ArrayList;
    //   71: ifnonnull +25 -> 96
    //   74: aload_0
    //   75: new 77	java/util/ArrayList
    //   78: dup
    //   79: invokespecial 78	java/util/ArrayList:<init>	()V
    //   82: putfield 582	android/support/v4/app/z:k	Ljava/util/ArrayList;
    //   85: aload_0
    //   86: new 77	java/util/ArrayList
    //   89: dup
    //   90: invokespecial 78	java/util/ArrayList:<init>	()V
    //   93: putfield 584	android/support/v4/app/z:j	Ljava/util/ArrayList;
    //   96: aload_0
    //   97: iconst_1
    //   98: putfield 589	android/support/v4/app/z:e	Z
    //   101: aload_0
    //   102: aconst_null
    //   103: aconst_null
    //   104: invokespecial 1401	android/support/v4/app/z:b	(Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    //   107: aload_0
    //   108: iconst_0
    //   109: putfield 589	android/support/v4/app/z:e	Z
    //   112: return
    //   113: aload_0
    //   114: invokespecial 1236	android/support/v4/app/z:x	()V
    //   117: goto -50 -> 67
    //   120: astore_2
    //   121: aload_0
    //   122: iconst_0
    //   123: putfield 589	android/support/v4/app/z:e	Z
    //   126: aload_2
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	z
    //   0	128	1	paramBoolean	boolean
    //   120	7	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   101	107	120	finally
  }
  
  public final boolean a(Menu paramMenu)
  {
    boolean bool4;
    if (this.d > 0)
    {
      int i1 = 0;
      boolean bool3 = false;
      bool4 = bool3;
      if (i1 < this.a.size())
      {
        Object localObject = (Fragment)this.a.get(i1);
        bool4 = bool3;
        boolean bool1;
        if (localObject != null)
        {
          bool4 = bool3;
          if (!((Fragment)localObject).t)
          {
            if (!((Fragment)localObject).s) {
              break label132;
            }
            if (!((Fragment)localObject).D) {
              break label127;
            }
            bool1 = true;
          }
        }
        for (;;)
        {
          localObject = ((Fragment)localObject).j;
          boolean bool2 = bool1;
          if (localObject != null) {
            bool2 = bool1 | ((z)localObject).a(paramMenu);
          }
          bool4 = bool3;
          if (bool2) {
            bool4 = true;
          }
          i1 += 1;
          bool3 = bool4;
          break;
          label127:
          bool1 = false;
          continue;
          label132:
          bool1 = false;
        }
      }
    }
    else
    {
      bool4 = false;
    }
    return bool4;
  }
  
  public final boolean a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int i4 = 0;
    if (this.d > 0)
    {
      int i2 = 0;
      Object localObject1 = null;
      boolean bool2 = false;
      int i1;
      if (i2 < this.a.size())
      {
        Fragment localFragment = (Fragment)this.a.get(i2);
        boolean bool3;
        Object localObject2;
        if (localFragment == null)
        {
          bool3 = bool2;
          localObject2 = localObject1;
        }
        do
        {
          i2 += 1;
          localObject1 = localObject2;
          bool2 = bool3;
          break;
          localObject2 = localObject1;
          bool3 = bool2;
        } while (localFragment.t);
        if (localFragment.s) {
          if (localFragment.D)
          {
            localFragment.a(paramMenu, paramMenuInflater);
            i1 = 1;
          }
        }
        for (;;)
        {
          localObject2 = localFragment.j;
          int i3 = i1;
          boolean bool1;
          if (localObject2 != null) {
            bool1 = i1 | ((z)localObject2).a(paramMenu, paramMenuInflater);
          }
          localObject2 = localObject1;
          bool3 = bool2;
          if (!bool1) {
            break;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(localFragment);
          bool3 = true;
          break;
          i1 = 0;
          continue;
          i1 = 0;
        }
      }
      if (this.r != null)
      {
        i1 = i4;
        if (i1 < this.r.size())
        {
          paramMenu = (Fragment)this.r.get(i1);
          if ((localObject1 != null) && (((ArrayList)localObject1).contains(paramMenu))) {}
          for (;;)
          {
            i1 += 1;
            break;
            Fragment.z();
          }
        }
      }
      this.r = ((ArrayList)localObject1);
      return bool2;
    }
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.d > 0)
    {
      int i1 = 0;
      bool1 = bool2;
      if (i1 < this.a.size())
      {
        Object localObject = (Fragment)this.a.get(i1);
        if (localObject == null) {}
        do
        {
          do
          {
            i1 += 1;
            break;
          } while (((Fragment)localObject).t);
          if ((((Fragment)localObject).s) && (((Fragment)localObject).D) && (((Fragment)localObject).a_(paramMenuItem))) {
            break label108;
          }
          localObject = ((Fragment)localObject).j;
        } while ((localObject == null) || (!((z)localObject).a(paramMenuItem)));
        label108:
        bool1 = true;
      }
    }
    return bool1;
  }
  
  final boolean a(ArrayList paramArrayList1, ArrayList paramArrayList2, String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      label19:
      int i1;
      if (paramString != null)
      {
        if (paramString == null) {
          break label308;
        }
        i1 = ((ArrayList)localObject).size() - 1;
        if (i1 >= 0)
        {
          localObject = (f)this.b.get(i1);
          if ((paramString == null) || (!paramString.equals(((f)localObject).k)))
          {
            if (paramInt1 < 0) {}
            while (paramInt1 != ((f)localObject).i)
            {
              i1 -= 1;
              break;
            }
          }
        }
        if (i1 < 0) {
          break label306;
        }
        if ((paramInt2 & 0x1) == 0) {
          break label299;
        }
        paramInt2 = i1 - 1;
        if (paramInt2 < 0) {
          break label292;
        }
        localObject = (f)this.b.get(paramInt2);
        if ((paramString != null) && (paramString.equals(((f)localObject).k))) {}
        do
        {
          paramInt2 -= 1;
          break;
          if (paramInt1 < 0) {
            break label285;
          }
        } while (paramInt1 == ((f)localObject).i);
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        if (paramInt1 != this.b.size() - 1)
        {
          paramInt2 = this.b.size() - 1;
          for (;;)
          {
            if (paramInt2 > paramInt1)
            {
              paramArrayList1.add(this.b.remove(paramInt2));
              paramArrayList2.add(Boolean.valueOf(true));
              paramInt2 -= 1;
              continue;
              if ((paramInt1 >= 0) || ((paramInt2 & 0x1) != 0)) {
                break;
              }
              paramInt1 = ((ArrayList)localObject).size() - 1;
              if (paramInt1 < 0) {
                break label319;
              }
              paramArrayList1.add(this.b.remove(paramInt1));
              paramArrayList2.add(Boolean.valueOf(true));
            }
          }
          return true;
        }
        return false;
        label285:
        paramInt1 = paramInt2;
        continue;
        label292:
        paramInt1 = paramInt2;
        continue;
        label299:
        paramInt1 = i1;
        continue;
        label306:
        return false;
        label308:
        if (paramInt1 >= 0) {
          break label19;
        }
        paramInt1 = -1;
      }
      label319:
      return false;
    }
    return false;
  }
  
  public final Fragment b(String paramString)
  {
    Object localObject = this.n;
    if ((localObject != null) && (paramString != null))
    {
      int i1 = ((SparseArray)localObject).size() - 1;
      if (i1 >= 0)
      {
        Fragment localFragment = (Fragment)this.n.valueAt(i1);
        if (localFragment == null) {}
        for (;;)
        {
          i1 -= 1;
          break;
          localObject = localFragment;
          if (!paramString.equals(localFragment.Z))
          {
            localObject = localFragment.j;
            if (localObject == null) {
              break label86;
            }
          }
          label86:
          for (localObject = ((z)localObject).b(paramString); localObject != null; localObject = null) {
            return (Fragment)localObject;
          }
        }
      }
    }
    return null;
  }
  
  public final void b(int paramInt)
  {
    if (paramInt < 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Bad id: ");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    a(new ao(this, null, paramInt, 1), false);
  }
  
  final void b(Fragment paramFragment)
  {
    if (paramFragment.x < 0)
    {
      int i1 = this.x;
      this.x = (i1 + 1);
      paramFragment.a(i1, this.y);
      if (this.n == null) {
        this.n = new SparseArray();
      }
      this.n.put(paramFragment.x, paramFragment);
    }
  }
  
  public final void b(x paramx)
  {
    synchronized (this.v)
    {
      int i2 = this.v.size();
      int i1 = 0;
      while (i1 < i2) {
        if (((al)this.v.get(i1)).a != paramx) {
          i1 += 1;
        } else {
          this.v.remove(i1);
        }
      }
      return;
    }
  }
  
  public final void b(y paramy)
  {
    ArrayList localArrayList = this.p;
    if (localArrayList != null) {
      localArrayList.remove(paramy);
    }
  }
  
  public final void b(Menu paramMenu)
  {
    if (this.d > 0)
    {
      int i1 = 0;
      if (i1 < this.a.size())
      {
        Object localObject = (Fragment)this.a.get(i1);
        if (localObject == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          if (!((Fragment)localObject).t)
          {
            localObject = ((Fragment)localObject).j;
            if (localObject != null) {
              ((z)localObject).b(paramMenu);
            }
          }
        }
      }
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    int i1 = this.a.size() - 1;
    if (i1 >= 0)
    {
      Object localObject = (Fragment)this.a.get(i1);
      if (localObject == null) {}
      for (;;)
      {
        i1 -= 1;
        break;
        localObject = ((Fragment)localObject).j;
        if (localObject != null) {
          ((z)localObject).b(paramBoolean);
        }
      }
    }
  }
  
  public final boolean b()
  {
    boolean bool = k();
    y();
    return bool;
  }
  
  public final boolean b(MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.d > 0)
    {
      int i1 = 0;
      bool1 = bool2;
      if (i1 < this.a.size())
      {
        Object localObject = (Fragment)this.a.get(i1);
        if (localObject == null) {}
        do
        {
          do
          {
            i1 += 1;
            break;
          } while (((Fragment)localObject).t);
          localObject = ((Fragment)localObject).j;
        } while ((localObject == null) || (!((z)localObject).b(paramMenuItem)));
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean b(String paramString, int paramInt)
  {
    x();
    return c(paramString, paramInt);
  }
  
  public final void c()
  {
    a(new ao(this, null, -1, 0), false);
  }
  
  final void c(int paramInt)
  {
    try
    {
      this.e = true;
      a(paramInt, false);
      this.e = false;
      k();
      return;
    }
    finally
    {
      this.e = false;
    }
  }
  
  public final void c(Fragment paramFragment)
  {
    boolean bool = paramFragment.bw_();
    if (!paramFragment.o) {}
    synchronized (this.a)
    {
      this.a.remove(paramFragment);
      if ((paramFragment.s) && (paramFragment.D)) {
        this.w = true;
      }
      paramFragment.f = false;
      paramFragment.H = true;
      do
      {
        return;
      } while (!(bool ^ true));
    }
  }
  
  public final void c(boolean paramBoolean)
  {
    int i1 = this.a.size() - 1;
    if (i1 >= 0)
    {
      Object localObject = (Fragment)this.a.get(i1);
      if (localObject == null) {}
      for (;;)
      {
        i1 -= 1;
        break;
        localObject = ((Fragment)localObject).j;
        if (localObject != null) {
          ((z)localObject).c(paramBoolean);
        }
      }
    }
  }
  
  public final boolean d()
  {
    x();
    return c(null, 0);
  }
  
  public final int e()
  {
    ArrayList localArrayList = this.b;
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  public final w f()
  {
    return (w)this.b.get(0);
  }
  
  public final void f(Fragment paramFragment)
  {
    if (!paramFragment.o)
    {
      paramFragment.o = true;
      if (!paramFragment.f) {}
    }
    synchronized (this.a)
    {
      this.a.remove(paramFragment);
      if ((paramFragment.s) && (paramFragment.D)) {
        this.w = true;
      }
      paramFragment.f = false;
      return;
    }
  }
  
  public final List g()
  {
    if (this.a.isEmpty()) {
      return Collections.emptyList();
    }
    synchronized (this.a)
    {
      List localList = (List)this.a.clone();
      return localList;
    }
  }
  
  public final void g(Fragment paramFragment)
  {
    if (paramFragment.o)
    {
      paramFragment.o = false;
      if (!paramFragment.f) {
        if (this.a.contains(paramFragment))
        {
          ??? = new StringBuilder();
          ((StringBuilder)???).append("Fragment already added: ");
          ((StringBuilder)???).append(paramFragment);
          throw new IllegalStateException(((StringBuilder)???).toString());
        }
      }
    }
    synchronized (this.a)
    {
      this.a.add(paramFragment);
      paramFragment.f = true;
      if ((paramFragment.s) && (paramFragment.D)) {
        this.w = true;
      }
      return;
    }
  }
  
  public final void h(Fragment paramFragment)
  {
    if ((paramFragment != null) && ((this.n.get(paramFragment.x) != paramFragment) || ((paramFragment.v != null) && (paramFragment.q != this))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Fragment ");
      localStringBuilder.append(paramFragment);
      localStringBuilder.append(" is not an active fragment of FragmentManager ");
      localStringBuilder.append(this);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.g = paramFragment;
  }
  
  public final boolean h()
  {
    return this.s;
  }
  
  public final boolean i()
  {
    return (this.i) || (this.D);
  }
  
  final void j()
  {
    this.e = false;
    this.j.clear();
    this.k.clear();
  }
  
  public final boolean k()
  {
    a(true);
    boolean bool = false;
    for (;;)
    {
      if (c(this.k, this.j)) {
        this.e = true;
      }
      try
      {
        a(this.k, this.j);
        j();
        bool = true;
      }
      finally
      {
        j();
      }
    }
    l();
    n();
    return bool;
  }
  
  final void l()
  {
    if (this.u)
    {
      this.u = false;
      w();
    }
  }
  
  final Parcelable m()
  {
    ArrayList localArrayList = null;
    Object localObject3 = null;
    int i3 = 0;
    y();
    Object localObject1 = this.n;
    if (localObject1 != null) {}
    for (int i1 = ((SparseArray)localObject1).size();; i1 = 0)
    {
      int i2 = 0;
      Object localObject2;
      int i4;
      Object localObject4;
      if (i2 >= i1)
      {
        k();
        this.i = true;
        this.h = null;
        localObject2 = this.n;
        localObject1 = localArrayList;
        if (localObject2 != null)
        {
          localObject1 = localArrayList;
          if (((SparseArray)localObject2).size() > 0)
          {
            i4 = this.n.size();
            localObject4 = new FragmentState[i4];
            i2 = 0;
            i1 = 0;
            if (i2 < i4)
            {
              Fragment localFragment = (Fragment)this.n.valueAt(i2);
              FragmentState localFragmentState;
              if (localFragment != null)
              {
                if (localFragment.x < 0)
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("Failure saving state: active ");
                  ((StringBuilder)localObject1).append(localFragment);
                  ((StringBuilder)localObject1).append(" has cleared index: ");
                  ((StringBuilder)localObject1).append(localFragment.x);
                  a(new IllegalStateException(((StringBuilder)localObject1).toString()));
                }
                localFragmentState = new FragmentState(localFragment);
                localObject4[i2] = localFragmentState;
                if ((localFragment.O <= 0) || (localFragmentState.k != null))
                {
                  localFragmentState.k = localFragment.L;
                  i1 = 1;
                }
              }
              for (;;)
              {
                i2 += 1;
                break;
                if (this.C == null) {
                  this.C = new Bundle();
                }
                localObject1 = this.C;
                localFragment.e((Bundle)localObject1);
                localObject2 = localFragment.j;
                if (localObject2 != null)
                {
                  localObject2 = ((z)localObject2).m();
                  if (localObject2 != null) {
                    ((Bundle)localObject1).putParcelable("android:support:fragments", (Parcelable)localObject2);
                  }
                }
                d(localFragment, this.C);
                if (!this.C.isEmpty())
                {
                  localObject1 = this.C;
                  this.C = null;
                }
                for (;;)
                {
                  if (localFragment.U != null) {
                    j(localFragment);
                  }
                  if (localFragment.N == null) {}
                  for (;;)
                  {
                    if (localFragment.T) {}
                    for (;;)
                    {
                      localFragmentState.k = ((Bundle)localObject1);
                      localObject1 = localFragment.Q;
                      if (localObject1 != null)
                      {
                        if (((Fragment)localObject1).x < 0)
                        {
                          localObject1 = new StringBuilder();
                          ((StringBuilder)localObject1).append("Failure saving state: ");
                          ((StringBuilder)localObject1).append(localFragment);
                          ((StringBuilder)localObject1).append(" has target not in fragment manager: ");
                          ((StringBuilder)localObject1).append(localFragment.Q);
                          a(new IllegalStateException(((StringBuilder)localObject1).toString()));
                        }
                        if (localFragmentState.k == null) {
                          localFragmentState.k = new Bundle();
                        }
                        a(localFragmentState.k, "android:target_state", localFragment.Q);
                        i1 = localFragment.S;
                        if (i1 != 0)
                        {
                          localFragmentState.k.putInt("android:target_req_state", i1);
                          i1 = 1;
                          break;
                        }
                        i1 = 1;
                        break;
                      }
                      i1 = 1;
                      break;
                      localObject2 = localObject1;
                      if (localObject1 == null) {
                        localObject2 = new Bundle();
                      }
                      ((Bundle)localObject2).putBoolean("android:user_visible_hint", localFragment.T);
                      localObject1 = localObject2;
                    }
                    localObject2 = localObject1;
                    if (localObject1 == null) {
                      localObject2 = new Bundle();
                    }
                    ((Bundle)localObject2).putSparseParcelableArray("android:view_state", localFragment.N);
                    localObject1 = localObject2;
                  }
                  localObject1 = null;
                }
              }
            }
            localObject1 = localArrayList;
            if (i1 != 0)
            {
              i2 = this.a.size();
              if (i2 > 0)
              {
                localObject2 = new int[i2];
                i1 = 0;
                for (;;)
                {
                  localObject1 = localObject2;
                  if (i1 >= i2) {
                    break;
                  }
                  localObject2[i1] = ((Fragment)this.a.get(i1)).x;
                  if (localObject2[i1] < 0)
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("Failure saving state: active ");
                    ((StringBuilder)localObject1).append(this.a.get(i1));
                    ((StringBuilder)localObject1).append(" has cleared index: ");
                    ((StringBuilder)localObject1).append(localObject2[i1]);
                    a(new IllegalStateException(((StringBuilder)localObject1).toString()));
                  }
                  i1 += 1;
                }
              }
              localObject1 = null;
              localArrayList = this.b;
              localObject2 = localObject3;
              if (localArrayList != null)
              {
                i2 = localArrayList.size();
                localObject2 = localObject3;
                if (i2 > 0)
                {
                  localObject3 = new BackStackState[i2];
                  i1 = i3;
                  for (;;)
                  {
                    localObject2 = localObject3;
                    if (i1 >= i2) {
                      break;
                    }
                    localObject3[i1] = new BackStackState((f)this.b.get(i1));
                    i1 += 1;
                  }
                }
              }
              localObject3 = new FragmentManagerState();
              ((FragmentManagerState)localObject3).a = ((FragmentState[])localObject4);
              ((FragmentManagerState)localObject3).b = ((int[])localObject1);
              ((FragmentManagerState)localObject3).c = ((BackStackState[])localObject2);
              localObject1 = this.g;
              if (localObject1 != null) {
                ((FragmentManagerState)localObject3).e = ((Fragment)localObject1).x;
              }
              ((FragmentManagerState)localObject3).d = this.x;
              z();
              localObject1 = localObject3;
            }
          }
        }
        return (Parcelable)localObject1;
      }
      localObject1 = (Fragment)this.n.valueAt(i2);
      if (localObject1 == null) {}
      for (;;)
      {
        i2 += 1;
        break;
        if (((Fragment)localObject1).M() != null)
        {
          i4 = ((Fragment)localObject1).O();
          localObject2 = ((Fragment)localObject1).M();
          localObject4 = ((View)localObject2).getAnimation();
          if (localObject4 != null)
          {
            ((Animation)localObject4).cancel();
            ((View)localObject2).clearAnimation();
          }
          ((Fragment)localObject1).d_(null);
          a((Fragment)localObject1, i4, 0, 0, false);
        }
        else if (((Fragment)localObject1).N() != null)
        {
          ((Fragment)localObject1).N().end();
        }
      }
    }
  }
  
  final void n()
  {
    SparseArray localSparseArray = this.n;
    if (localSparseArray != null)
    {
      int i1 = localSparseArray.size() - 1;
      while (i1 >= 0)
      {
        if (this.n.valueAt(i1) == null)
        {
          localSparseArray = this.n;
          localSparseArray.delete(localSparseArray.keyAt(i1));
        }
        i1 -= 1;
      }
    }
  }
  
  public final void o()
  {
    this.h = null;
    this.i = false;
    this.D = false;
    int i2 = this.a.size();
    int i1 = 0;
    if (i1 < i2)
    {
      Object localObject = (Fragment)this.a.get(i1);
      if (localObject == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        localObject = ((Fragment)localObject).j;
        if (localObject != null) {
          ((z)localObject).o();
        }
      }
    }
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if ("fragment".equals(paramString))
    {
      paramString = paramAttributeSet.getAttributeValue(null, "class");
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, am.a);
      if (paramString == null) {
        paramString = localTypedArray.getString(0);
      }
      for (;;)
      {
        int i3 = localTypedArray.getResourceId(1, -1);
        String str = localTypedArray.getString(2);
        localTypedArray.recycle();
        if (Fragment.a(this.f.b, paramString))
        {
          if (paramView != null) {}
          for (int i1 = paramView.getId();; i1 = 0)
          {
            if (i1 != -1) {}
            while ((i3 != -1) || (str != null))
            {
              if (i3 != -1) {}
              for (paramView = a(i3);; paramView = null)
              {
                if (paramView != null) {}
                for (;;)
                {
                  if (paramView != null) {}
                  for (;;)
                  {
                    int i2;
                    if (paramView == null)
                    {
                      paramView = this.c.a(paramContext, paramString, null);
                      paramView.r = true;
                      if (i3 != 0)
                      {
                        i2 = i3;
                        paramView.p = i2;
                        paramView.m = i1;
                        paramView.P = str;
                        paramView.w = true;
                        paramView.q = this;
                        paramView.v = this.f;
                        paramContext = paramView.L;
                        paramView.s();
                        a(paramView, true);
                      }
                    }
                    for (;;)
                    {
                      if ((this.d <= 0) && (paramView.r)) {
                        a(paramView, 1, 0, 0, false);
                      }
                      for (;;)
                      {
                        paramContext = paramView.U;
                        if (paramContext == null)
                        {
                          paramView = new StringBuilder();
                          paramView.append("Fragment ");
                          paramView.append(paramString);
                          paramView.append(" did not create a view.");
                          throw new IllegalStateException(paramView.toString());
                        }
                        if (i3 == 0) {}
                        for (;;)
                        {
                          if (paramView.U.getTag() == null) {
                            paramView.U.setTag(str);
                          }
                          return paramView.U;
                          paramContext.setId(i3);
                        }
                        i(paramView);
                      }
                      i2 = i1;
                      break;
                      if (paramView.w)
                      {
                        paramView = new StringBuilder();
                        paramView.append(paramAttributeSet.getPositionDescription());
                        paramView.append(": Duplicate id 0x");
                        paramView.append(Integer.toHexString(i3));
                        paramView.append(", tag ");
                        paramView.append(str);
                        paramView.append(", or parent id 0x");
                        paramView.append(Integer.toHexString(i1));
                        paramView.append(" with another fragment for ");
                        paramView.append(paramString);
                        throw new IllegalArgumentException(paramView.toString());
                      }
                      paramView.w = true;
                      paramView.v = this.f;
                      if (!paramView.K)
                      {
                        paramContext = paramView.L;
                        paramView.s();
                      }
                    }
                    if (i1 != -1) {
                      paramView = a(i1);
                    }
                  }
                  if (str != null) {
                    paramView = a(str);
                  }
                }
              }
            }
            paramView = new StringBuilder();
            paramView.append(paramAttributeSet.getPositionDescription());
            paramView.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
            paramView.append(paramString);
            throw new IllegalArgumentException(paramView.toString());
          }
        }
        return null;
      }
    }
    return null;
  }
  
  public final View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
  
  public final void p()
  {
    this.i = false;
    this.D = false;
    c(1);
  }
  
  public final void q()
  {
    this.i = false;
    this.D = false;
    c(2);
  }
  
  public final void r()
  {
    this.i = false;
    this.D = false;
    c(3);
  }
  
  public final void s()
  {
    this.i = false;
    this.D = false;
    c(4);
  }
  
  public final void t()
  {
    this.D = true;
    c(2);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    Fragment localFragment = this.y;
    if (localFragment != null) {
      android.support.v4.g.f.a(localFragment, localStringBuilder);
    }
    for (;;)
    {
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
      android.support.v4.g.f.a(this.f, localStringBuilder);
    }
  }
  
  public final void u()
  {
    this.s = true;
    k();
    c(0);
    this.f = null;
    this.c = null;
    this.y = null;
  }
  
  public final void v()
  {
    int i1 = 0;
    if (i1 < this.a.size())
    {
      Object localObject = (Fragment)this.a.get(i1);
      if (localObject == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        ((Fragment)localObject).onLowMemory();
        localObject = ((Fragment)localObject).j;
        if (localObject != null) {
          ((z)localObject).v();
        }
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */