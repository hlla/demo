package android.support.v4.app;

import android.os.Build.VERSION;
import android.support.v4.e.a;
import android.support.v4.e.g;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

final class d
  extends p
  implements Runnable
{
  static final boolean nM;
  int mIndex = -1;
  String mName;
  final m nN;
  a nO;
  a nP;
  int nQ;
  int nR;
  int nS;
  int nT;
  int nU;
  int nV;
  int nW;
  boolean nX;
  boolean nY = true;
  boolean nZ;
  int oa;
  CharSequence ob;
  int oc;
  CharSequence od;
  ArrayList<String> oe;
  ArrayList<String> of;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false)
    {
      nM = bool;
      return;
    }
  }
  
  public d(m paramm)
  {
    this.nN = paramm;
  }
  
  private b a(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2, boolean paramBoolean)
  {
    int n = 0;
    b localb = new b();
    localb.oE = new View(this.nN.ph.mContext);
    int j = 0;
    int i = 0;
    int k = n;
    int m = i;
    if (j < paramSparseArray1.size())
    {
      if (!a(paramSparseArray1.keyAt(j), localb, paramBoolean, paramSparseArray1, paramSparseArray2)) {
        break label164;
      }
      i = 1;
    }
    label164:
    for (;;)
    {
      j += 1;
      break;
      while (k < paramSparseArray2.size())
      {
        j = paramSparseArray2.keyAt(k);
        i = m;
        if (paramSparseArray1.get(j) == null)
        {
          i = m;
          if (a(j, localb, paramBoolean, paramSparseArray1, paramSparseArray2)) {
            i = 1;
          }
        }
        k += 1;
        m = i;
      }
      paramSparseArray1 = localb;
      if (m == 0) {
        paramSparseArray1 = null;
      }
      return paramSparseArray1;
    }
  }
  
  private a<String, View> a(b paramb, Fragment paramFragment, boolean paramBoolean)
  {
    a locala2 = new a();
    a locala1 = locala2;
    if (this.oe != null)
    {
      q.a(locala2, paramFragment.mView);
      if (!paramBoolean) {
        break label74;
      }
      g.a(locala2, this.of);
    }
    label74:
    for (locala1 = locala2; paramBoolean; locala1 = a(this.oe, this.of, locala2))
    {
      if (paramFragment.pJ != null) {
        paramFragment = paramFragment.pJ;
      }
      a(paramb, locala1, false);
      return locala1;
    }
    if (paramFragment.pK != null) {
      paramFragment = paramFragment.pK;
    }
    b(paramb, locala1, false);
    return locala1;
  }
  
  static a<String, View> a(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, a<String, View> parama)
  {
    if (parama.isEmpty()) {
      return parama;
    }
    a locala = new a();
    int j = paramArrayList1.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)parama.get(paramArrayList1.get(i));
      if (localView != null) {
        locala.put(paramArrayList2.get(i), localView);
      }
      i += 1;
    }
    return locala;
  }
  
  private static Object a(Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, a<String, View> parama, View paramView)
  {
    Object localObject = paramObject;
    if (paramObject != null)
    {
      paramFragment = paramFragment.mView;
      localObject = paramObject;
      if (paramObject != null)
      {
        q.a(paramArrayList, paramFragment);
        if (parama != null) {
          paramArrayList.removeAll(parama.values());
        }
        if (!paramArrayList.isEmpty()) {
          break label52;
        }
        localObject = null;
      }
    }
    return localObject;
    label52:
    paramArrayList.add(paramView);
    q.b((Transition)paramObject, paramArrayList);
    return paramObject;
  }
  
  private void a(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    paramFragment.pg = this.nN;
    if (paramString != null)
    {
      if ((paramFragment.mTag != null) && (!paramString.equals(paramFragment.mTag))) {
        throw new IllegalStateException("Can't change tag of fragment " + paramFragment + ": was " + paramFragment.mTag + " now " + paramString);
      }
      paramFragment.mTag = paramString;
    }
    if (paramInt1 != 0)
    {
      if ((paramFragment.pk != 0) && (paramFragment.pk != paramInt1)) {
        throw new IllegalStateException("Can't change container ID of fragment " + paramFragment + ": was " + paramFragment.pk + " now " + paramInt1);
      }
      paramFragment.pk = paramInt1;
      paramFragment.pl = paramInt1;
    }
    paramString = new a();
    paramString.ou = paramInt2;
    paramString.ov = paramFragment;
    a(paramString);
  }
  
  public static void a(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean, a<String, View> parama)
  {
    if (paramBoolean) {}
    for (paramFragment1 = paramFragment2.pJ;; paramFragment1 = paramFragment1.pJ)
    {
      if (paramFragment1 != null)
      {
        new ArrayList(parama.keySet());
        new ArrayList(parama.values());
      }
      return;
    }
  }
  
  private static void a(b paramb, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    if (paramArrayList1 != null)
    {
      int i = 0;
      while (i < paramArrayList1.size())
      {
        String str1 = (String)paramArrayList1.get(i);
        String str2 = (String)paramArrayList2.get(i);
        a(paramb.oB, str1, str2);
        i += 1;
      }
    }
  }
  
  private static void a(a<String, String> parama, String paramString1, String paramString2)
  {
    int i;
    if ((paramString1 != null) && (paramString2 != null)) {
      i = 0;
    }
    while (i < parama.size())
    {
      if (paramString1.equals(parama.valueAt(i)))
      {
        parama.setValueAt(i, paramString2);
        return;
      }
      i += 1;
    }
    parama.put(paramString1, paramString2);
  }
  
  private void a(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    if (!this.nN.qs.onHasView()) {}
    a locala;
    do
    {
      return;
      locala = this.nO;
    } while (locala == null);
    switch (locala.ou)
    {
    }
    for (;;)
    {
      locala = locala.os;
      break;
      b(paramSparseArray1, paramSparseArray2, locala.ov);
      continue;
      Object localObject1 = locala.ov;
      if (this.nN.qk != null)
      {
        int i = 0;
        if (i < this.nN.qk.size())
        {
          Fragment localFragment = (Fragment)this.nN.qk.get(i);
          Object localObject2;
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (localFragment.pl != ((Fragment)localObject1).pl) {}
          }
          else
          {
            if (localFragment != localObject1) {
              break label197;
            }
            localObject2 = null;
            paramSparseArray2.remove(localFragment.pl);
          }
          for (;;)
          {
            i += 1;
            localObject1 = localObject2;
            break;
            label197:
            a(paramSparseArray1, paramSparseArray2, localFragment);
            localObject2 = localObject1;
          }
        }
      }
      b(paramSparseArray1, paramSparseArray2, locala.ov);
      continue;
      a(paramSparseArray1, paramSparseArray2, locala.ov);
      continue;
      a(paramSparseArray1, paramSparseArray2, locala.ov);
      continue;
      b(paramSparseArray1, paramSparseArray2, locala.ov);
      continue;
      a(paramSparseArray1, paramSparseArray2, locala.ov);
      continue;
      b(paramSparseArray1, paramSparseArray2, locala.ov);
    }
  }
  
  private static void a(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2, Fragment paramFragment)
  {
    if (paramFragment != null)
    {
      int i = paramFragment.pl;
      if ((i != 0) && (!paramFragment.pm))
      {
        if ((paramFragment.isAdded()) && (paramFragment.mView != null) && (paramSparseArray1.get(i) == null)) {
          paramSparseArray1.put(i, paramFragment);
        }
        if (paramSparseArray2.get(i) == paramFragment) {
          paramSparseArray2.remove(i);
        }
      }
    }
  }
  
  private boolean a(final int paramInt, final b paramb, final boolean paramBoolean, final SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    final ViewGroup localViewGroup = (ViewGroup)this.nN.qs.onFindViewById(paramInt);
    if (localViewGroup == null) {
      return false;
    }
    final Object localObject4 = (Fragment)paramSparseArray2.get(paramInt);
    final Object localObject5 = (Fragment)paramSparseArray1.get(paramInt);
    Object localObject2;
    label66:
    Object localObject3;
    final ArrayList localArrayList1;
    Object localObject1;
    if (localObject4 == null)
    {
      localObject2 = null;
      if ((localObject4 != null) && (localObject5 != null)) {
        break label181;
      }
      paramSparseArray1 = null;
      if (localObject5 != null) {
        break label272;
      }
      localObject3 = null;
      localArrayList1 = new ArrayList();
      if (paramSparseArray1 == null) {
        break label1036;
      }
      localObject1 = a(paramb, (Fragment)localObject5, paramBoolean);
      if (!((a)localObject1).isEmpty()) {
        break label324;
      }
      localObject1 = null;
      paramSparseArray2 = null;
    }
    for (;;)
    {
      if ((localObject2 == null) && (paramSparseArray2 == null) && (localObject3 == null))
      {
        return false;
        if (paramBoolean) {
          if (((Fragment)localObject4).pE == Fragment.oQ) {
            paramSparseArray1 = ((Fragment)localObject4).pD;
          }
        }
        for (;;)
        {
          localObject2 = q.e(paramSparseArray1);
          break;
          paramSparseArray1 = ((Fragment)localObject4).pE;
          continue;
          paramSparseArray1 = ((Fragment)localObject4).pB;
        }
        label181:
        if (paramBoolean) {
          if (((Fragment)localObject5).pG == Fragment.oQ) {
            paramSparseArray1 = ((Fragment)localObject5).pF;
          }
        }
        for (;;)
        {
          if (paramSparseArray1 != null) {
            break label234;
          }
          paramSparseArray1 = null;
          break;
          paramSparseArray1 = ((Fragment)localObject5).pG;
          continue;
          paramSparseArray1 = ((Fragment)localObject4).pF;
        }
        label234:
        paramSparseArray2 = (Transition)paramSparseArray1;
        if (paramSparseArray2 == null)
        {
          paramSparseArray1 = null;
          break label66;
        }
        paramSparseArray1 = new TransitionSet();
        paramSparseArray1.addTransition(paramSparseArray2);
        break label66;
        label272:
        if (paramBoolean) {
          if (((Fragment)localObject5).pC == Fragment.oQ) {
            paramSparseArray2 = ((Fragment)localObject5).pB;
          }
        }
        for (;;)
        {
          localObject3 = q.e(paramSparseArray2);
          break;
          paramSparseArray2 = ((Fragment)localObject5).pC;
          continue;
          paramSparseArray2 = ((Fragment)localObject5).pD;
        }
        label324:
        if (paramBoolean) {}
        for (paramSparseArray2 = ((Fragment)localObject5).pJ;; paramSparseArray2 = ((Fragment)localObject4).pJ)
        {
          if (paramSparseArray2 != null)
          {
            new ArrayList(((a)localObject1).keySet());
            new ArrayList(((a)localObject1).values());
          }
          localViewGroup.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              localViewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
              Object localObject1;
              d.b localb;
              Object localObject2;
              a locala;
              if (paramSparseArray1 != null)
              {
                q.a(paramSparseArray1, localArrayList1);
                localArrayList1.clear();
                localObject1 = d.this;
                localb = paramb;
                boolean bool = paramBoolean;
                localObject2 = localObject4;
                locala = new a();
                View localView = ((Fragment)localObject2).mView;
                if ((localView == null) || (((d)localObject1).oe == null)) {
                  break label243;
                }
                q.a(locala, localView);
                if (!bool) {
                  break label233;
                }
                locala = d.a(((d)localObject1).oe, ((d)localObject1).of, locala);
                if (!bool) {
                  break label246;
                }
                if (((Fragment)localObject2).pK != null) {
                  localObject2 = ((Fragment)localObject2).pK;
                }
                ((d)localObject1).a(localb, locala, true);
              }
              for (;;)
              {
                q.a(paramSparseArray1, paramb.oE, locala, localArrayList1);
                localObject1 = d.this;
                localb = paramb;
                if ((((d)localObject1).of != null) && (!locala.isEmpty()))
                {
                  localObject1 = (View)locala.get(((d)localObject1).of.get(0));
                  if (localObject1 != null) {
                    localb.oD.rt = ((View)localObject1);
                  }
                }
                d.a(localObject4, localObject5, paramBoolean, locala);
                return true;
                label233:
                g.a(locala, ((d)localObject1).of);
                label243:
                break;
                label246:
                if (((Fragment)localObject2).pJ != null) {
                  localObject1 = ((Fragment)localObject2).pJ;
                }
                d.b(localb, locala, true);
              }
            }
          });
          paramSparseArray2 = paramSparseArray1;
          break;
        }
      }
      ArrayList localArrayList2 = new ArrayList();
      Object localObject6 = a(localObject3, (Fragment)localObject5, localArrayList2, (a)localObject1, paramb.oE);
      if ((this.of != null) && (localObject1 != null))
      {
        paramSparseArray1 = (View)((a)localObject1).get(this.of.get(0));
        if (paramSparseArray1 != null)
        {
          if (localObject6 != null) {
            q.a(localObject6, paramSparseArray1);
          }
          if (paramSparseArray2 != null) {
            q.a(paramSparseArray2, paramSparseArray1);
          }
        }
      }
      q.b local1 = new q.b()
      {
        public final View getView()
        {
          return localObject4.mView;
        }
      };
      localObject5 = new ArrayList();
      a locala = new a();
      if (localObject4 != null) {
        if (paramBoolean) {
          if (((Fragment)localObject4).pH == null) {
            paramBoolean = true;
          }
        }
      }
      for (;;)
      {
        localObject3 = (Transition)localObject2;
        paramSparseArray1 = (Transition)localObject6;
        Object localObject7 = (Transition)paramSparseArray2;
        if ((localObject3 != null) && (paramSparseArray1 != null)) {}
        for (;;)
        {
          if (paramBoolean)
          {
            localObject4 = new TransitionSet();
            if (localObject3 != null) {
              ((TransitionSet)localObject4).addTransition((Transition)localObject3);
            }
            if (paramSparseArray1 != null) {
              ((TransitionSet)localObject4).addTransition(paramSparseArray1);
            }
            if (localObject7 != null) {
              ((TransitionSet)localObject4).addTransition((Transition)localObject7);
            }
            paramSparseArray1 = (SparseArray<Fragment>)localObject4;
          }
          label1021:
          for (;;)
          {
            if (paramSparseArray1 != null)
            {
              localObject3 = paramb.oE;
              localObject4 = paramb.oD;
              localObject7 = paramb.oB;
              if ((localObject2 != null) || (paramSparseArray2 != null))
              {
                Transition localTransition = (Transition)localObject2;
                if (localTransition != null) {
                  localTransition.addTarget((View)localObject3);
                }
                if (paramSparseArray2 != null) {
                  q.a(paramSparseArray2, (View)localObject3, (Map)localObject1, localArrayList1);
                }
                localViewGroup.getViewTreeObserver().addOnPreDrawListener(new q.2(localViewGroup, localTransition, (View)localObject3, local1, (Map)localObject7, locala, (ArrayList)localObject5));
                if (localTransition != null) {
                  localTransition.setEpicenterCallback(new q.3((q.a)localObject4));
                }
              }
              localViewGroup.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
              {
                public final boolean onPreDraw()
                {
                  localViewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
                  d.this.a(paramb, paramInt, paramSparseArray1);
                  return true;
                }
              });
              q.a(paramSparseArray1, paramb.oE, true);
              a(paramb, paramInt, paramSparseArray1);
              TransitionManager.beginDelayedTransition(localViewGroup, (Transition)paramSparseArray1);
              localObject1 = paramb.oE;
              paramb = paramb.oC;
              localObject2 = (Transition)localObject2;
              localObject3 = (Transition)localObject6;
              paramSparseArray2 = (Transition)paramSparseArray2;
              localObject4 = (Transition)paramSparseArray1;
              if (localObject4 != null) {
                localViewGroup.getViewTreeObserver().addOnPreDrawListener(new q.4(localViewGroup, (Transition)localObject2, (ArrayList)localObject5, (Transition)localObject3, localArrayList2, paramSparseArray2, localArrayList1, locala, paramb, (Transition)localObject4, (View)localObject1));
              }
            }
            if (paramSparseArray1 == null) {
              break label1024;
            }
            return true;
            paramBoolean = ((Fragment)localObject4).pH.booleanValue();
            break;
            if (((Fragment)localObject4).pI == null)
            {
              paramBoolean = true;
              break;
            }
            paramBoolean = ((Fragment)localObject4).pI.booleanValue();
            break;
            if ((paramSparseArray1 != null) && (localObject3 != null)) {
              paramSparseArray1 = new TransitionSet().addTransition(paramSparseArray1).addTransition((Transition)localObject3).setOrdering(1);
            }
            for (;;)
            {
              if (localObject7 == null) {
                break label1021;
              }
              localObject3 = new TransitionSet();
              if (paramSparseArray1 != null) {
                ((TransitionSet)localObject3).addTransition(paramSparseArray1);
              }
              ((TransitionSet)localObject3).addTransition((Transition)localObject7);
              paramSparseArray1 = (SparseArray<Fragment>)localObject3;
              break;
              if (paramSparseArray1 == null)
              {
                paramSparseArray1 = (SparseArray<Fragment>)localObject3;
                if (localObject3 == null) {
                  paramSparseArray1 = null;
                }
              }
            }
          }
          label1024:
          return false;
          paramBoolean = true;
        }
        paramBoolean = true;
      }
      label1036:
      localObject1 = null;
      paramSparseArray2 = paramSparseArray1;
    }
  }
  
  static void b(b paramb, a<String, View> parama, boolean paramBoolean)
  {
    int j = parama.size();
    int i = 0;
    if (i < j)
    {
      String str1 = (String)parama.keyAt(i);
      String str2 = ((View)parama.valueAt(i)).getTransitionName();
      if (paramBoolean) {
        a(paramb.oB, str1, str2);
      }
      for (;;)
      {
        i += 1;
        break;
        a(paramb.oB, str2, str1);
      }
    }
  }
  
  private void b(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2, Fragment paramFragment)
  {
    if (paramFragment != null)
    {
      int i = paramFragment.pl;
      if (i != 0)
      {
        if (!paramFragment.isAdded()) {
          paramSparseArray2.put(i, paramFragment);
        }
        if (paramSparseArray1.get(i) == paramFragment) {
          paramSparseArray1.remove(i);
        }
      }
      if ((paramFragment.mState <= 0) && (this.nN.qr > 0))
      {
        this.nN.h(paramFragment);
        this.nN.a(paramFragment, 1, 0, 0, false);
      }
    }
  }
  
  private int m(boolean paramBoolean)
  {
    if (this.nZ) {
      throw new IllegalStateException("commit already called");
    }
    if (m.DEBUG)
    {
      new StringBuilder("Commit: ").append(this);
      a("  ", new PrintWriter(new android.support.v4.e.d("FragmentManager")));
    }
    this.nZ = true;
    if (this.nX) {}
    for (this.mIndex = this.nN.a(this);; this.mIndex = -1)
    {
      this.nN.a(this, paramBoolean);
      return this.mIndex;
    }
  }
  
  final void D(int paramInt)
  {
    if (!this.nX) {}
    for (;;)
    {
      return;
      if (m.DEBUG) {
        new StringBuilder("Bump nesting in ").append(this).append(" by ").append(paramInt);
      }
      for (a locala = this.nO; locala != null; locala = locala.os)
      {
        Fragment localFragment;
        if (locala.ov != null)
        {
          localFragment = locala.ov;
          localFragment.pf += paramInt;
          if (m.DEBUG) {
            new StringBuilder("Bump nesting of ").append(locala.ov).append(" to ").append(locala.ov.pf);
          }
        }
        if (locala.oA != null)
        {
          int i = locala.oA.size() - 1;
          while (i >= 0)
          {
            localFragment = (Fragment)locala.oA.get(i);
            localFragment.pf += paramInt;
            if (m.DEBUG) {
              new StringBuilder("Bump nesting of ").append(localFragment).append(" to ").append(localFragment.pf);
            }
            i -= 1;
          }
        }
      }
    }
  }
  
  public final b a(boolean paramBoolean, b paramb, SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    if (m.DEBUG)
    {
      new StringBuilder("popFromBackStack: ").append(this);
      a("  ", new PrintWriter(new android.support.v4.e.d("FragmentManager")));
    }
    b localb = paramb;
    if (nM)
    {
      localb = paramb;
      if (this.nN.qr > 0)
      {
        if (paramb != null) {
          break label220;
        }
        if (paramSparseArray1.size() == 0)
        {
          localb = paramb;
          if (paramSparseArray2.size() == 0) {}
        }
        else
        {
          localb = a(paramSparseArray1, paramSparseArray2, true);
        }
      }
    }
    label99:
    D(-1);
    int i;
    label112:
    int j;
    label120:
    int k;
    if (localb != null)
    {
      i = 0;
      if (localb == null) {
        break label254;
      }
      j = 0;
      paramb = this.nP;
      if (paramb == null) {
        break label543;
      }
      if (localb == null) {
        break label263;
      }
      k = 0;
      label137:
      if (localb == null) {
        break label272;
      }
    }
    label220:
    label254:
    label263:
    label272:
    for (int m = 0;; m = paramb.oz) {
      switch (paramb.ou)
      {
      default: 
        throw new IllegalArgumentException("Unknown cmd: " + paramb.ou);
        localb = paramb;
        if (paramBoolean) {
          break label99;
        }
        a(paramb, this.of, this.oe);
        localb = paramb;
        break label99;
        i = this.nW;
        break label112;
        j = this.nV;
        break label120;
        k = paramb.oy;
        break label137;
      }
    }
    paramSparseArray1 = paramb.ov;
    paramSparseArray1.pt = m;
    this.nN.a(paramSparseArray1, m.H(j), i);
    for (;;)
    {
      paramb = paramb.ot;
      break;
      paramSparseArray1 = paramb.ov;
      if (paramSparseArray1 != null)
      {
        paramSparseArray1.pt = m;
        this.nN.a(paramSparseArray1, m.H(j), i);
      }
      if (paramb.oA != null)
      {
        m = 0;
        while (m < paramb.oA.size())
        {
          paramSparseArray1 = (Fragment)paramb.oA.get(m);
          paramSparseArray1.pt = k;
          this.nN.a(paramSparseArray1, false);
          m += 1;
        }
        paramSparseArray1 = paramb.ov;
        paramSparseArray1.pt = k;
        this.nN.a(paramSparseArray1, false);
        continue;
        paramSparseArray1 = paramb.ov;
        paramSparseArray1.pt = k;
        this.nN.c(paramSparseArray1, m.H(j), i);
        continue;
        paramSparseArray1 = paramb.ov;
        paramSparseArray1.pt = m;
        this.nN.b(paramSparseArray1, m.H(j), i);
        continue;
        paramSparseArray1 = paramb.ov;
        paramSparseArray1.pt = k;
        this.nN.e(paramSparseArray1, m.H(j), i);
        continue;
        paramSparseArray1 = paramb.ov;
        paramSparseArray1.pt = k;
        this.nN.d(paramSparseArray1, m.H(j), i);
      }
    }
    label543:
    if (paramBoolean)
    {
      this.nN.a(this.nN.qr, m.H(j), i, true);
      localb = null;
    }
    if (this.mIndex >= 0)
    {
      paramb = this.nN;
      i = this.mIndex;
    }
    try
    {
      paramb.qo.set(i, null);
      if (paramb.qp == null) {
        paramb.qp = new ArrayList();
      }
      if (m.DEBUG) {}
      paramb.qp.add(Integer.valueOf(i));
      this.mIndex = -1;
      return localb;
    }
    finally {}
  }
  
  public final p a(int paramInt, Fragment paramFragment)
  {
    a(paramInt, paramFragment, null, 1);
    return this;
  }
  
  public final p a(int paramInt, Fragment paramFragment, String paramString)
  {
    a(paramInt, paramFragment, paramString, 1);
    return this;
  }
  
  public final p a(Fragment paramFragment)
  {
    a locala = new a();
    locala.ou = 3;
    locala.ov = paramFragment;
    a(locala);
    return this;
  }
  
  public final p a(Fragment paramFragment, String paramString)
  {
    a(0, paramFragment, paramString, 1);
    return this;
  }
  
  final void a(a parama)
  {
    if (this.nO == null)
    {
      this.nP = parama;
      this.nO = parama;
    }
    for (;;)
    {
      parama.ow = this.nR;
      parama.ox = this.nS;
      parama.oy = this.nT;
      parama.oz = this.nU;
      this.nQ += 1;
      return;
      parama.ot = this.nP;
      this.nP.os = parama;
      this.nP = parama;
    }
  }
  
  public final void a(b paramb, int paramInt, Object paramObject)
  {
    if (this.nN.qk != null)
    {
      int i = 0;
      if (i < this.nN.qk.size())
      {
        Fragment localFragment = (Fragment)this.nN.qk.get(i);
        if ((localFragment.mView != null) && (localFragment.pu != null) && (localFragment.pl == paramInt))
        {
          if (!localFragment.pm) {
            break label125;
          }
          if (!paramb.oC.contains(localFragment.mView))
          {
            q.a(paramObject, localFragment.mView, true);
            paramb.oC.add(localFragment.mView);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label125:
          q.a(paramObject, localFragment.mView, false);
          paramb.oC.remove(localFragment.mView);
        }
      }
    }
  }
  
  final void a(b paramb, a<String, View> parama, boolean paramBoolean)
  {
    int i;
    int j;
    label13:
    String str;
    Object localObject;
    if (this.of == null)
    {
      i = 0;
      j = 0;
      if (j >= i) {
        return;
      }
      str = (String)this.oe.get(j);
      localObject = (View)parama.get((String)this.of.get(j));
      if (localObject != null)
      {
        localObject = ((View)localObject).getTransitionName();
        if (!paramBoolean) {
          break label103;
        }
        a(paramb.oB, str, (String)localObject);
      }
    }
    for (;;)
    {
      j += 1;
      break label13;
      i = this.of.size();
      break;
      label103:
      a(paramb.oB, (String)localObject, str);
    }
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter)
  {
    a(paramString, paramPrintWriter, true);
  }
  
  public final void a(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(this.mName);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(this.mIndex);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(this.nZ);
      if (this.nV != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(this.nV));
        paramPrintWriter.print(" mTransitionStyle=#");
        paramPrintWriter.println(Integer.toHexString(this.nW));
      }
      if ((this.nR != 0) || (this.nS != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.nR));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.nS));
      }
      if ((this.nT != 0) || (this.nU != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(this.nT));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(this.nU));
      }
      if ((this.oa != 0) || (this.ob != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.oa));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(this.ob);
      }
      if ((this.oc != 0) || (this.od != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.oc));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(this.od);
      }
    }
    if (this.nO != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      String str2 = paramString + "    ";
      a locala = this.nO;
      int i = 0;
      while (locala != null)
      {
        String str1;
        int j;
        switch (locala.ou)
        {
        default: 
          str1 = "cmd=" + locala.ou;
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  Op #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.print(str1);
          paramPrintWriter.print(" ");
          paramPrintWriter.println(locala.ov);
          if (paramBoolean)
          {
            if ((locala.ow != 0) || (locala.ox != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("enterAnim=#");
              paramPrintWriter.print(Integer.toHexString(locala.ow));
              paramPrintWriter.print(" exitAnim=#");
              paramPrintWriter.println(Integer.toHexString(locala.ox));
            }
            if ((locala.oy != 0) || (locala.oz != 0))
            {
              paramPrintWriter.print(paramString);
              paramPrintWriter.print("popEnterAnim=#");
              paramPrintWriter.print(Integer.toHexString(locala.oy));
              paramPrintWriter.print(" popExitAnim=#");
              paramPrintWriter.println(Integer.toHexString(locala.oz));
            }
          }
          if ((locala.oA == null) || (locala.oA.size() <= 0)) {
            break label804;
          }
          j = 0;
          label638:
          if (j >= locala.oA.size()) {
            break label804;
          }
          paramPrintWriter.print(str2);
          if (locala.oA.size() == 1) {
            paramPrintWriter.print("Removed: ");
          }
          break;
        }
        for (;;)
        {
          paramPrintWriter.println(locala.oA.get(j));
          j += 1;
          break label638;
          str1 = "NULL";
          break;
          str1 = "ADD";
          break;
          str1 = "REPLACE";
          break;
          str1 = "REMOVE";
          break;
          str1 = "HIDE";
          break;
          str1 = "SHOW";
          break;
          str1 = "DETACH";
          break;
          str1 = "ATTACH";
          break;
          if (j == 0) {
            paramPrintWriter.println("Removed:");
          }
          paramPrintWriter.print(str2);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(j);
          paramPrintWriter.print(": ");
        }
        label804:
        locala = locala.os;
        i += 1;
      }
    }
  }
  
  public final p b(int paramInt, Fragment paramFragment)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
    a(paramInt, paramFragment, null, 2);
    return this;
  }
  
  public final p b(Fragment paramFragment)
  {
    a locala = new a();
    locala.ou = 6;
    locala.ov = paramFragment;
    a(locala);
    return this;
  }
  
  public final void b(SparseArray<Fragment> paramSparseArray1, SparseArray<Fragment> paramSparseArray2)
  {
    if (!this.nN.qs.onHasView()) {}
    a locala;
    do
    {
      return;
      locala = this.nP;
    } while (locala == null);
    switch (locala.ou)
    {
    }
    for (;;)
    {
      locala = locala.ot;
      break;
      a(paramSparseArray1, paramSparseArray2, locala.ov);
      continue;
      if (locala.oA != null)
      {
        int i = locala.oA.size() - 1;
        while (i >= 0)
        {
          b(paramSparseArray1, paramSparseArray2, (Fragment)locala.oA.get(i));
          i -= 1;
        }
      }
      a(paramSparseArray1, paramSparseArray2, locala.ov);
      continue;
      b(paramSparseArray1, paramSparseArray2, locala.ov);
      continue;
      b(paramSparseArray1, paramSparseArray2, locala.ov);
      continue;
      a(paramSparseArray1, paramSparseArray2, locala.ov);
      continue;
      b(paramSparseArray1, paramSparseArray2, locala.ov);
      continue;
      a(paramSparseArray1, paramSparseArray2, locala.ov);
    }
  }
  
  public final p c(Fragment paramFragment)
  {
    a locala = new a();
    locala.ou = 7;
    locala.ov = paramFragment;
    a(locala);
    return this;
  }
  
  public final int commit()
  {
    return m(false);
  }
  
  public final int commitAllowingStateLoss()
  {
    return m(true);
  }
  
  public final p g(int paramInt1, int paramInt2)
  {
    this.nR = paramInt1;
    this.nS = paramInt2;
    this.nT = 0;
    this.nU = 0;
    return this;
  }
  
  public final void run()
  {
    if (m.DEBUG) {
      new StringBuilder("Run: ").append(this);
    }
    if ((this.nX) && (this.mIndex < 0)) {
      throw new IllegalStateException("addToBackStack() called after commit()");
    }
    D(1);
    Object localObject1;
    if ((nM) && (this.nN.qr > 0))
    {
      localObject1 = new SparseArray();
      localObject2 = new SparseArray();
      a((SparseArray)localObject1, (SparseArray)localObject2);
    }
    for (Object localObject2 = a((SparseArray)localObject1, (SparseArray)localObject2, false);; localObject2 = null)
    {
      int i;
      label111:
      int j;
      label118:
      a locala;
      int k;
      if (localObject2 != null)
      {
        i = 0;
        if (localObject2 == null) {
          break label229;
        }
        j = 0;
        locala = this.nO;
        if (locala == null) {
          break label694;
        }
        if (localObject2 == null) {
          break label237;
        }
        k = 0;
        label136:
        if (localObject2 == null) {
          break label246;
        }
      }
      label229:
      label237:
      label246:
      for (int m = 0;; m = locala.ox) {
        switch (locala.ou)
        {
        default: 
          throw new IllegalArgumentException("Unknown cmd: " + locala.ou);
          i = this.nW;
          break label111;
          j = this.nV;
          break label118;
          k = locala.ow;
          break label136;
        }
      }
      localObject1 = locala.ov;
      ((Fragment)localObject1).pt = k;
      this.nN.a((Fragment)localObject1, false);
      for (;;)
      {
        locala = locala.os;
        break;
        localObject1 = locala.ov;
        int i1 = ((Fragment)localObject1).pl;
        Object localObject3 = localObject1;
        if (this.nN.qk != null)
        {
          int n = this.nN.qk.size() - 1;
          localObject3 = localObject1;
          if (n >= 0)
          {
            localObject3 = (Fragment)this.nN.qk.get(n);
            if (m.DEBUG) {
              new StringBuilder("OP_REPLACE: adding=").append(localObject1).append(" old=").append(localObject3);
            }
            if (((Fragment)localObject3).pl == i1) {
              if (localObject3 == localObject1)
              {
                locala.ov = null;
                localObject1 = null;
              }
            }
            for (;;)
            {
              n -= 1;
              break;
              if (locala.oA == null) {
                locala.oA = new ArrayList();
              }
              locala.oA.add(localObject3);
              ((Fragment)localObject3).pt = m;
              if (this.nX)
              {
                ((Fragment)localObject3).pf += 1;
                if (m.DEBUG) {
                  new StringBuilder("Bump nesting of ").append(localObject3).append(" to ").append(((Fragment)localObject3).pf);
                }
              }
              this.nN.a((Fragment)localObject3, j, i);
            }
          }
        }
        if (localObject3 != null)
        {
          ((Fragment)localObject3).pt = k;
          this.nN.a((Fragment)localObject3, false);
          continue;
          localObject1 = locala.ov;
          ((Fragment)localObject1).pt = m;
          this.nN.a((Fragment)localObject1, j, i);
          continue;
          localObject1 = locala.ov;
          ((Fragment)localObject1).pt = m;
          this.nN.b((Fragment)localObject1, j, i);
          continue;
          localObject1 = locala.ov;
          ((Fragment)localObject1).pt = k;
          this.nN.c((Fragment)localObject1, j, i);
          continue;
          localObject1 = locala.ov;
          ((Fragment)localObject1).pt = m;
          this.nN.d((Fragment)localObject1, j, i);
          continue;
          localObject1 = locala.ov;
          ((Fragment)localObject1).pt = k;
          this.nN.e((Fragment)localObject1, j, i);
        }
      }
      label694:
      this.nN.a(this.nN.qr, j, i, true);
      if (this.nX)
      {
        localObject1 = this.nN;
        if (((m)localObject1).qm == null) {
          ((m)localObject1).qm = new ArrayList();
        }
        ((m)localObject1).qm.add(this);
        ((m)localObject1).aZ();
      }
      return;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (this.mIndex >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(this.mIndex);
    }
    if (this.mName != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(this.mName);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class a
  {
    ArrayList<Fragment> oA;
    a os;
    a ot;
    int ou;
    Fragment ov;
    int ow;
    int ox;
    int oy;
    int oz;
  }
  
  public final class b
  {
    public a<String, String> oB = new a();
    public ArrayList<View> oC = new ArrayList();
    public q.a oD = new q.a();
    public View oE;
    
    public b() {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/app/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */