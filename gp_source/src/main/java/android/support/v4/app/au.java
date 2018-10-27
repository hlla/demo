package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.g.a;
import android.support.v4.g.j;
import android.support.v4.g.v;
import android.support.v4.view.ac;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

final class au
{
  public static final bf a;
  public static final bf b;
  private static final int[] c = { 0, 3, 0, 1, 5, 4, 7, 6, 9, 8 };
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (ba localba = new ba();; localba = null)
    {
      a = localba;
      b = a();
      return;
    }
  }
  
  private static az a(az paramaz, SparseArray paramSparseArray, int paramInt)
  {
    az localaz = paramaz;
    if (paramaz == null)
    {
      localaz = new az();
      paramSparseArray.put(paramInt, localaz);
    }
    return localaz;
  }
  
  private static bf a()
  {
    try
    {
      bf localbf = (bf)Class.forName("android.support.f.p").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      return localbf;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static bf a(Fragment paramFragment1, Fragment paramFragment2)
  {
    Object localObject1 = null;
    ArrayList localArrayList = new ArrayList();
    if (paramFragment1 != null)
    {
      Object localObject2 = paramFragment1.C();
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
      localObject2 = paramFragment1.B();
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
      paramFragment1 = paramFragment1.F();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
    }
    if (paramFragment2 != null)
    {
      paramFragment1 = paramFragment2.A();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
      paramFragment1 = paramFragment2.D();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
      paramFragment1 = paramFragment2.E();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
    }
    paramFragment1 = (Fragment)localObject1;
    if (!localArrayList.isEmpty())
    {
      if ((a == null) || (!a(a, localArrayList))) {
        break label145;
      }
      paramFragment1 = a;
    }
    label145:
    do
    {
      return paramFragment1;
      if ((b != null) && (a(b, localArrayList))) {
        return b;
      }
      if (a != null) {
        break;
      }
      paramFragment1 = (Fragment)localObject1;
    } while (b == null);
    throw new IllegalArgumentException("Invalid Transition types");
  }
  
  static a a(bf parambf, a parama, Object paramObject, az paramaz)
  {
    Fragment localFragment = paramaz.d;
    View localView = localFragment.U;
    if ((!parama.isEmpty()) && (paramObject != null) && (localView != null))
    {
      a locala = new a();
      parambf.a(locala, localView);
      parambf = paramaz.f;
      if (paramaz.e) {
        paramObject = localFragment.L();
      }
      for (parambf = parambf.p;; parambf = parambf.q)
      {
        if (parambf != null)
        {
          j.a(locala, parambf);
          j.a(locala, parama.values());
        }
        if (paramObject != null)
        {
          i = parambf.size() - 1;
          if (i >= 0)
          {
            paramaz = (String)parambf.get(i);
            paramObject = (View)locala.get(paramaz);
            if (paramObject == null)
            {
              paramObject = a(parama, paramaz);
              if (paramObject != null) {}
            }
            for (;;)
            {
              i -= 1;
              break;
              parama.remove(paramObject);
              continue;
              if (!paramaz.equals(ac.v((View)paramObject)))
              {
                paramaz = a(parama, paramaz);
                if (paramaz != null) {
                  parama.put(paramaz, ac.v((View)paramObject));
                }
              }
            }
          }
          return locala;
        }
        int i = parama.size() - 1;
        label204:
        if (i >= 0) {
          if (!locala.containsKey((String)parama.c(i))) {
            break label235;
          }
        }
        for (;;)
        {
          i -= 1;
          break label204;
          break;
          label235:
          parama.d(i);
        }
        paramObject = localFragment.K();
      }
    }
    parama.clear();
    return null;
  }
  
  static View a(a parama, az paramaz, Object paramObject, boolean paramBoolean)
  {
    paramaz = paramaz.f;
    if ((paramObject != null) && (parama != null))
    {
      paramObject = paramaz.p;
      if ((paramObject != null) && (!((ArrayList)paramObject).isEmpty()))
      {
        if (!paramBoolean) {}
        for (paramaz = (String)paramaz.q.get(0);; paramaz = (String)paramaz.p.get(0)) {
          return (View)parama.get(paramaz);
        }
      }
    }
    return null;
  }
  
  private static Object a(bf parambf, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean)
  {
    if ((paramFragment1 != null) && (paramFragment2 != null))
    {
      if (!paramBoolean) {}
      for (paramFragment1 = paramFragment1.E();; paramFragment1 = paramFragment2.F()) {
        return parambf.c(parambf.b(paramFragment1));
      }
    }
    return null;
  }
  
  private static Object a(bf parambf, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment != null)
    {
      if (!paramBoolean) {}
      for (paramFragment = paramFragment.A();; paramFragment = paramFragment.D()) {
        return parambf.b(paramFragment);
      }
    }
    return null;
  }
  
  private static String a(a parama, String paramString)
  {
    int j = parama.size();
    int i = 0;
    while (i < j) {
      if (!paramString.equals(parama.c(i))) {
        i += 1;
      } else {
        return (String)parama.b(i);
      }
    }
    return null;
  }
  
  static ArrayList a(bf parambf, Object paramObject, Fragment paramFragment, ArrayList paramArrayList, View paramView)
  {
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramFragment = paramFragment.U;
      if (paramFragment != null) {
        parambf.a(localArrayList, paramFragment);
      }
      if (paramArrayList != null) {
        localArrayList.removeAll(paramArrayList);
      }
      if (localArrayList.isEmpty()) {
        return localArrayList;
      }
      localArrayList.add(paramView);
      parambf.a(paramObject, localArrayList);
      return localArrayList;
    }
    return null;
  }
  
  static void a(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean1, a parama, boolean paramBoolean2)
  {
    int j = 0;
    if (!paramBoolean1) {}
    for (paramFragment1 = paramFragment1.K();; paramFragment1 = paramFragment2.K())
    {
      ArrayList localArrayList;
      int i;
      if (paramFragment1 != null)
      {
        paramFragment2 = new ArrayList();
        localArrayList = new ArrayList();
        if (parama == null) {
          break label100;
        }
        i = parama.size();
      }
      for (;;)
      {
        if (j < i)
        {
          localArrayList.add(parama.b(j));
          paramFragment2.add(parama.c(j));
          j += 1;
        }
        else
        {
          if (!paramBoolean2)
          {
            paramFragment1.a();
            return;
          }
          paramFragment1.a(localArrayList, paramFragment2);
          return;
          label100:
          i = 0;
        }
      }
    }
  }
  
  private static void a(bf parambf, Object paramObject1, Object paramObject2, a parama, boolean paramBoolean, f paramf)
  {
    ArrayList localArrayList = paramf.p;
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      if (paramBoolean) {
        break label66;
      }
    }
    label66:
    for (paramf = (String)paramf.p.get(0);; paramf = (String)paramf.q.get(0))
    {
      parama = (View)parama.get(paramf);
      parambf.a(paramObject1, parama);
      if (paramObject2 != null) {
        parambf.a(paramObject2, parama);
      }
      return;
    }
  }
  
  private static void a(f paramf, g paramg, SparseArray paramSparseArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    Fragment localFragment = paramg.d;
    int m;
    if (localFragment != null)
    {
      m = localFragment.m;
      if (m != 0) {
        if (!paramBoolean1) {
          break label643;
        }
      }
    }
    label643:
    for (int i = c[paramg.a];; i = paramg.a)
    {
      int j;
      int k;
      boolean bool;
      switch (i)
      {
      case 2: 
      default: 
        j = 0;
        k = 0;
        i = 0;
        bool = false;
        paramg = (az)paramSparseArray.get(m);
        if (bool)
        {
          paramg = a(paramg, paramSparseArray, m);
          paramg.d = localFragment;
          paramg.e = paramBoolean1;
          paramg.f = paramf;
        }
        for (;;)
        {
          if (paramBoolean2) {}
          while (i == 0)
          {
            if (j == 0) {
              paramf = paramg;
            }
            for (;;)
            {
              if ((!paramBoolean2) && (k != 0) && (paramf != null) && (paramf.d == localFragment)) {
                paramf.d = null;
              }
              return;
              if (paramg == null) {}
              while (paramg.a == null)
              {
                paramg = a(paramg, paramSparseArray, m);
                paramg.a = localFragment;
                paramg.b = paramBoolean1;
                paramg.c = paramf;
                paramf = paramg;
                break;
              }
              paramf = paramg;
            }
          }
          if (paramg == null) {}
          for (;;)
          {
            z localz = paramf.j;
            if ((localFragment.O > 0) || (localz.d <= 0) || (paramf.o)) {
              break;
            }
            localz.b(localFragment);
            localz.a(localFragment, 1, 0, 0, false);
            break;
            if (paramg.a == localFragment) {
              paramg.a = null;
            }
          }
        }
      case 1: 
      case 7: 
        if (paramBoolean2) {
          bool = localFragment.A;
        }
        for (;;)
        {
          j = 0;
          k = 0;
          i = 1;
          break;
          if (!localFragment.f)
          {
            if (!localFragment.t) {
              bool = true;
            } else {
              bool = false;
            }
          }
          else {
            bool = false;
          }
        }
      case 5: 
        if (!paramBoolean2) {
          bool = localFragment.t;
        }
        for (;;)
        {
          j = 0;
          k = 0;
          i = 1;
          break;
          if (localFragment.u)
          {
            if (!localFragment.t)
            {
              if (localFragment.f) {
                bool = true;
              } else {
                bool = false;
              }
            }
            else {
              bool = false;
            }
          }
          else {
            bool = false;
          }
        }
      case 4: 
        if (!paramBoolean2) {
          if (localFragment.f) {
            if (!localFragment.t) {
              i = 1;
            }
          }
        }
        for (;;)
        {
          j = i;
          k = 1;
          i = 0;
          bool = false;
          break;
          i = 0;
          continue;
          i = 0;
          continue;
          if (localFragment.u)
          {
            if (localFragment.f)
            {
              if (localFragment.t) {
                i = 1;
              } else {
                i = 0;
              }
            }
            else {
              i = 0;
            }
          }
          else {
            i = 0;
          }
        }
      }
      if (!paramBoolean2) {
        if (localFragment.f) {
          if (!localFragment.t) {
            i = 1;
          }
        }
      }
      for (;;)
      {
        j = i;
        k = 1;
        i = 0;
        bool = false;
        break;
        i = 0;
        continue;
        i = 0;
        continue;
        if (!localFragment.f)
        {
          paramg = localFragment.U;
          if (paramg != null)
          {
            if (paramg.getVisibility() == 0)
            {
              if (localFragment.G >= 0.0F) {
                i = 1;
              } else {
                i = 0;
              }
            }
            else {
              i = 0;
            }
          }
          else {
            i = 0;
          }
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  static void a(z paramz, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramz.d > 0)
    {
      SparseArray localSparseArray = new SparseArray();
      int i = paramInt1;
      Object localObject1;
      int k;
      int j;
      if (i < paramInt2)
      {
        localObject1 = (f)paramArrayList1.get(i);
        if (!((Boolean)paramArrayList2.get(i)).booleanValue())
        {
          k = ((f)localObject1).l.size();
          j = 0;
          while (j < k)
          {
            a((f)localObject1, (g)((f)localObject1).l.get(j), localSparseArray, false, paramBoolean);
            j += 1;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (((f)localObject1).j.c.a())
          {
            j = ((f)localObject1).l.size() - 1;
            while (j >= 0)
            {
              a((f)localObject1, (g)((f)localObject1).l.get(j), localSparseArray, true, paramBoolean);
              j -= 1;
            }
          }
        }
      }
      if (localSparseArray.size() != 0)
      {
        View localView = new View(paramz.f.b);
        int m = localSparseArray.size();
        i = 0;
        if (i < m)
        {
          int n = localSparseArray.keyAt(i);
          a locala1 = new a();
          j = paramInt2 - 1;
          Object localObject3;
          boolean bool1;
          Object localObject2;
          label332:
          Object localObject4;
          Object localObject5;
          while (j >= paramInt1)
          {
            localObject3 = (f)paramArrayList1.get(j);
            if (((f)localObject3).c(n))
            {
              bool1 = ((Boolean)paramArrayList2.get(j)).booleanValue();
              localObject1 = ((f)localObject3).p;
              if (localObject1 != null) {}
            }
            else
            {
              j -= 1;
              continue;
            }
            int i1 = ((ArrayList)localObject1).size();
            if (bool1)
            {
              localObject1 = ((f)localObject3).p;
              localObject2 = ((f)localObject3).q;
            }
            for (;;)
            {
              k = 0;
              if (k < i1)
              {
                localObject3 = (String)((ArrayList)localObject2).get(k);
                localObject4 = (String)((ArrayList)localObject1).get(k);
                localObject5 = (String)locala1.remove(localObject4);
                if (localObject5 == null) {
                  break label399;
                }
                locala1.put(localObject3, localObject5);
              }
              for (;;)
              {
                k += 1;
                break label332;
                break;
                label399:
                locala1.put(localObject3, localObject4);
              }
              localObject2 = ((f)localObject3).p;
              localObject1 = ((f)localObject3).q;
            }
          }
          Object localObject6 = (az)localSparseArray.valueAt(i);
          label470:
          Fragment localFragment1;
          Object localObject12;
          Object localObject7;
          boolean bool2;
          Object localObject8;
          Object localObject9;
          Object localObject10;
          Object localObject11;
          Fragment localFragment2;
          Fragment localFragment3;
          if (paramBoolean) {
            if (paramz.c.a())
            {
              localObject2 = (ViewGroup)paramz.c.a(n);
              if (localObject2 != null)
              {
                localFragment1 = ((az)localObject6).d;
                localObject12 = ((az)localObject6).a;
                localObject7 = a((Fragment)localObject12, localFragment1);
                if (localObject7 != null)
                {
                  bool1 = ((az)localObject6).e;
                  bool2 = ((az)localObject6).b;
                  localObject8 = new ArrayList();
                  localObject9 = new ArrayList();
                  localObject10 = a((bf)localObject7, localFragment1, bool1);
                  localObject11 = b((bf)localObject7, (Fragment)localObject12, bool2);
                  localFragment2 = ((az)localObject6).d;
                  localFragment3 = ((az)localObject6).a;
                  if (localFragment2 != null) {
                    localFragment2.U.setVisibility(0);
                  }
                  if (localFragment2 != null) {
                    break label1015;
                  }
                  localObject1 = null;
                  label593:
                  if (localObject10 == null) {
                    break label1002;
                  }
                  label598:
                  localObject5 = a((bf)localObject7, localObject11, (Fragment)localObject12, (ArrayList)localObject9, localView);
                  localObject3 = a((bf)localObject7, localObject10, localFragment1, (ArrayList)localObject8, localView);
                  a((ArrayList)localObject3, 4);
                  localObject6 = ((bf)localObject7).a(localObject11, localObject10, localObject1);
                  if (localObject12 != null) {
                    break label932;
                  }
                  label652:
                  localObject4 = new ArrayList();
                  k = ((ArrayList)localObject8).size();
                  j = 0;
                  while (j < k)
                  {
                    localObject12 = (View)((ArrayList)localObject8).get(j);
                    ((ArrayList)localObject4).add(ac.v((View)localObject12));
                    ac.a((View)localObject12, null);
                    j += 1;
                    continue;
                    cn.a((View)localObject2, new bg(n, (ArrayList)localObject8, (ArrayList)localObject4, (ArrayList)localObject9, (ArrayList)localObject5));
                    a((ArrayList)localObject3, 0);
                    ((bf)localObject7).a(localObject1, (ArrayList)localObject9, (ArrayList)localObject8);
                  }
                }
              }
            }
          }
          label812:
          label874:
          label890:
          label932:
          label1002:
          label1015:
          label1877:
          for (;;)
          {
            i += 1;
            break;
            ((bf)localObject7).a(localObject6, localObject10, (ArrayList)localObject3, localObject11, (ArrayList)localObject5, localObject1, (ArrayList)localObject8);
            ((bf)localObject7).a((ViewGroup)localObject2, localObject6);
            n = ((ArrayList)localObject8).size();
            localObject5 = new ArrayList();
            j = 0;
            if (j < n)
            {
              localObject10 = (View)((ArrayList)localObject9).get(j);
              localObject6 = ac.v((View)localObject10);
              ((ArrayList)localObject5).add(localObject6);
              if (localObject6 != null)
              {
                ac.a((View)localObject10, null);
                localObject10 = (String)locala1.get(localObject6);
                k = 0;
                if (k < n) {
                  break label890;
                }
              }
            }
            for (;;)
            {
              j += 1;
              break label812;
              break;
              if (!((String)localObject10).equals(((ArrayList)localObject4).get(k)))
              {
                k += 1;
                break label874;
              }
              ac.a((View)((ArrayList)localObject8).get(k), (String)localObject6);
            }
            if ((localObject11 == null) || (!((Fragment)localObject12).f) || (!((Fragment)localObject12).t) || (!((Fragment)localObject12).u)) {
              break label652;
            }
            ((Fragment)localObject12).d(true);
            ((bf)localObject7).b(localObject11, ((Fragment)localObject12).U, (ArrayList)localObject5);
            cn.a(((Fragment)localObject12).l, new av((ArrayList)localObject5));
            break label652;
            if ((localObject1 != null) || (localObject11 != null)) {
              break label598;
            }
            continue;
            if (localFragment3 != null)
            {
              bool1 = ((az)localObject6).e;
              if (!locala1.isEmpty()) {}
              for (localObject1 = a((bf)localObject7, localFragment2, localFragment3, bool1);; localObject1 = null)
              {
                localObject3 = b((bf)localObject7, locala1, localObject1, (az)localObject6);
                a locala2 = a((bf)localObject7, locala1, localObject1, (az)localObject6);
                if (!locala1.isEmpty())
                {
                  a((ArrayList)localObject9, (a)localObject3, locala1.keySet());
                  a((ArrayList)localObject8, locala2, locala1.values());
                }
                for (;;)
                {
                  if (localObject10 != null) {}
                  while ((localObject11 != null) || (localObject1 != null))
                  {
                    a(localFragment2, localFragment3, bool1, (a)localObject3, true);
                    if (localObject1 != null)
                    {
                      ((ArrayList)localObject8).add(localView);
                      ((bf)localObject7).a(localObject1, localView, (ArrayList)localObject9);
                      a((bf)localObject7, localObject1, localObject11, (a)localObject3, ((az)localObject6).b, ((az)localObject6).c);
                      localObject5 = new Rect();
                      localObject6 = a(locala2, (az)localObject6, localObject10, bool1);
                      localObject3 = localObject6;
                      localObject4 = localObject5;
                      if (localObject6 != null)
                      {
                        ((bf)localObject7).a(localObject10, (Rect)localObject5);
                        localObject4 = localObject5;
                      }
                    }
                    for (localObject3 = localObject6;; localObject3 = null)
                    {
                      cn.a((View)localObject2, new ax(localFragment2, localFragment3, bool1, locala2, (View)localObject3, (Rect)localObject4));
                      break;
                      localObject4 = null;
                    }
                  }
                  localObject1 = null;
                  break;
                  if (localObject3 != null) {
                    ((v)localObject3).clear();
                  }
                  if (locala2 != null)
                  {
                    locala2.clear();
                    localObject1 = null;
                  }
                  else
                  {
                    localObject1 = null;
                  }
                }
              }
            }
            localObject1 = null;
            break label593;
            localObject2 = null;
            break label470;
            if (paramz.c.a()) {}
            for (localObject3 = (ViewGroup)paramz.c.a(n);; localObject3 = null)
            {
              if (localObject3 == null) {
                break label1877;
              }
              localObject7 = ((az)localObject6).d;
              localObject11 = ((az)localObject6).a;
              localObject8 = a((Fragment)localObject11, (Fragment)localObject7);
              if (localObject8 == null) {
                break;
              }
              bool1 = ((az)localObject6).e;
              bool2 = ((az)localObject6).b;
              localObject9 = a((bf)localObject8, (Fragment)localObject7, bool1);
              localObject4 = b((bf)localObject8, (Fragment)localObject11, bool2);
              localObject12 = new ArrayList();
              localObject10 = new ArrayList();
              localFragment1 = ((az)localObject6).d;
              localFragment2 = ((az)localObject6).a;
              if (localFragment1 == null) {
                localObject1 = null;
              }
              for (;;)
              {
                if (localObject9 != null) {}
                while ((localObject1 != null) || (localObject4 != null))
                {
                  localObject5 = a((bf)localObject8, localObject4, (Fragment)localObject11, (ArrayList)localObject12, localView);
                  if (localObject5 != null) {
                    if (((ArrayList)localObject5).isEmpty()) {
                      localObject2 = null;
                    }
                  }
                  for (;;)
                  {
                    ((bf)localObject8).b(localObject9, localView);
                    localObject4 = ((bf)localObject8).a(localObject2, localObject9, localObject1);
                    localObject6 = new ArrayList();
                    ((bf)localObject8).a(localObject4, localObject9, (ArrayList)localObject6, localObject2, (ArrayList)localObject5, localObject1, (ArrayList)localObject10);
                    cn.a((View)localObject3, new aw(localObject9, (bf)localObject8, localView, (Fragment)localObject7, (ArrayList)localObject10, (ArrayList)localObject6, (ArrayList)localObject5, localObject2));
                    cn.a((View)localObject3, new bh((ArrayList)localObject10, locala1));
                    ((bf)localObject8).a((ViewGroup)localObject3, localObject4);
                    cn.a((View)localObject3, new bi((ArrayList)localObject10, locala1));
                    break;
                    localObject2 = localObject4;
                    continue;
                    localObject2 = null;
                  }
                }
                break;
                if (localFragment2 != null)
                {
                  bool1 = ((az)localObject6).e;
                  if (!locala1.isEmpty()) {}
                  for (localObject1 = a((bf)localObject8, localFragment1, localFragment2, bool1);; localObject1 = null)
                  {
                    localObject2 = b((bf)localObject8, locala1, localObject1, (az)localObject6);
                    if (!locala1.isEmpty()) {
                      ((ArrayList)localObject12).addAll(((a)localObject2).values());
                    }
                    for (;;)
                    {
                      if (localObject9 != null) {}
                      while ((localObject4 != null) || (localObject1 != null))
                      {
                        a(localFragment1, localFragment2, bool1, (a)localObject2, true);
                        if (localObject1 != null)
                        {
                          localObject5 = new Rect();
                          ((bf)localObject8).a(localObject1, localView, (ArrayList)localObject12);
                          a((bf)localObject8, localObject1, localObject4, (a)localObject2, ((az)localObject6).b, ((az)localObject6).c);
                          localObject2 = localObject5;
                          if (localObject9 != null) {
                            ((bf)localObject8).a(localObject9, (Rect)localObject5);
                          }
                        }
                        for (localObject2 = localObject5;; localObject2 = null)
                        {
                          cn.a((View)localObject3, new ay((bf)localObject8, locala1, localObject1, (az)localObject6, (ArrayList)localObject10, localView, localFragment1, localFragment2, bool1, (ArrayList)localObject12, localObject9, (Rect)localObject2));
                          break;
                        }
                      }
                      localObject1 = null;
                      break;
                      localObject1 = null;
                    }
                  }
                }
                localObject1 = null;
              }
            }
          }
        }
      }
    }
  }
  
  static void a(ArrayList paramArrayList, int paramInt)
  {
    if (paramArrayList != null)
    {
      int i = paramArrayList.size() - 1;
      while (i >= 0)
      {
        ((View)paramArrayList.get(i)).setVisibility(paramInt);
        i -= 1;
      }
    }
  }
  
  private static void a(ArrayList paramArrayList, a parama, Collection paramCollection)
  {
    int i = parama.size() - 1;
    if (i >= 0)
    {
      View localView = (View)parama.c(i);
      if (!paramCollection.contains(ac.v(localView))) {}
      for (;;)
      {
        i -= 1;
        break;
        paramArrayList.add(localView);
      }
    }
  }
  
  private static boolean a(bf parambf, List paramList)
  {
    boolean bool2 = false;
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      bool1 = bool2;
      if (!parambf.a(paramList.get(i))) {
        break label45;
      }
      i += 1;
    }
    boolean bool1 = true;
    label45:
    return bool1;
  }
  
  private static a b(bf parambf, a parama, Object paramObject, az paramaz)
  {
    if ((!parama.isEmpty()) && (paramObject != null))
    {
      paramObject = paramaz.a;
      a locala = new a();
      parambf.a(locala, ((Fragment)paramObject).U);
      parambf = paramaz.c;
      if (paramaz.b) {
        paramObject = ((Fragment)paramObject).K();
      }
      for (parambf = parambf.q;; parambf = parambf.p)
      {
        j.a(locala, parambf);
        if (paramObject != null)
        {
          int i = parambf.size() - 1;
          if (i >= 0)
          {
            paramaz = (String)parambf.get(i);
            paramObject = (View)locala.get(paramaz);
            if (paramObject == null) {
              parama.remove(paramaz);
            }
            for (;;)
            {
              i -= 1;
              break;
              if (!paramaz.equals(ac.v((View)paramObject)))
              {
                paramaz = (String)parama.remove(paramaz);
                parama.put(ac.v((View)paramObject), paramaz);
              }
            }
          }
        }
        else
        {
          j.a(parama, locala.keySet());
        }
        return locala;
        paramObject = ((Fragment)paramObject).L();
      }
    }
    parama.clear();
    return null;
  }
  
  private static Object b(bf parambf, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment != null)
    {
      if (!paramBoolean) {}
      for (paramFragment = paramFragment.C();; paramFragment = paramFragment.B()) {
        return parambf.b(paramFragment);
      }
    }
    return null;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */