package android.support.v7.widget;

import android.support.v4.a.a;
import android.support.v4.view.ai;
import android.support.v4.view.am;
import android.support.v4.view.z;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class v
  extends aj
{
  private ArrayList<RecyclerView.t> VY = new ArrayList();
  private ArrayList<RecyclerView.t> VZ = new ArrayList();
  private ArrayList<b> Wa = new ArrayList();
  private ArrayList<a> Wb = new ArrayList();
  public ArrayList<ArrayList<RecyclerView.t>> Wc = new ArrayList();
  public ArrayList<ArrayList<b>> Wd = new ArrayList();
  public ArrayList<ArrayList<a>> We = new ArrayList();
  public ArrayList<RecyclerView.t> Wf = new ArrayList();
  public ArrayList<RecyclerView.t> Wg = new ArrayList();
  public ArrayList<RecyclerView.t> Wh = new ArrayList();
  public ArrayList<RecyclerView.t> Wi = new ArrayList();
  
  private void a(a parama)
  {
    if (parama.Wv != null) {
      a(parama, parama.Wv);
    }
    if (parama.Ww != null) {
      a(parama, parama.Ww);
    }
  }
  
  private void a(List<a> paramList, RecyclerView.t paramt)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramt)) && (locala.Wv == null) && (locala.Ww == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
  }
  
  private boolean a(a parama, RecyclerView.t paramt)
  {
    if (parama.Ww == paramt) {
      parama.Ww = null;
    }
    for (;;)
    {
      z.d(paramt.abf, 1.0F);
      z.b(paramt.abf, 0.0F);
      z.c(paramt.abf, 0.0F);
      k(paramt);
      return true;
      if (parama.Wv != paramt) {
        break;
      }
      parama.Wv = null;
    }
    return false;
  }
  
  private void e(RecyclerView.t paramt)
  {
    a.v(paramt.abf);
    d(paramt);
  }
  
  private static void g(List<RecyclerView.t> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      z.V(((RecyclerView.t)paramList.get(i)).abf).cancel();
      i -= 1;
    }
  }
  
  public boolean a(RecyclerView.t paramt, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramt.abf;
    paramInt1 = (int)(paramInt1 + z.R(paramt.abf));
    paramInt2 = (int)(paramInt2 + z.S(paramt.abf));
    e(paramt);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      q(paramt);
      return false;
    }
    if (i != 0) {
      z.b(localView, -i);
    }
    if (j != 0) {
      z.c(localView, -j);
    }
    this.Wa.add(new b(paramt, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean a(RecyclerView.t paramt1, RecyclerView.t paramt2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramt1 == paramt2) {
      return a(paramt1, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    float f1 = z.R(paramt1.abf);
    float f2 = z.S(paramt1.abf);
    float f3 = z.H(paramt1.abf);
    e(paramt1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    z.b(paramt1.abf, f1);
    z.c(paramt1.abf, f2);
    z.d(paramt1.abf, f3);
    if (paramt2 != null)
    {
      e(paramt2);
      z.b(paramt2.abf, -i);
      z.c(paramt2.abf, -j);
      z.d(paramt2.abf, 0.0F);
    }
    this.Wb.add(new a(paramt1, paramt2, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean a(RecyclerView.t paramt, List<Object> paramList)
  {
    return (!paramList.isEmpty()) || (super.a(paramt, paramList));
  }
  
  public final boolean b(RecyclerView.t paramt)
  {
    e(paramt);
    this.VY.add(paramt);
    return true;
  }
  
  public boolean c(RecyclerView.t paramt)
  {
    e(paramt);
    z.d(paramt.abf, 0.0F);
    this.VZ.add(paramt);
    return true;
  }
  
  public void d(RecyclerView.t paramt)
  {
    View localView = paramt.abf;
    z.V(localView).cancel();
    int i = this.Wa.size() - 1;
    while (i >= 0)
    {
      if (((b)this.Wa.get(i)).WB == paramt)
      {
        z.c(localView, 0.0F);
        z.b(localView, 0.0F);
        q(paramt);
        this.Wa.remove(i);
      }
      i -= 1;
    }
    a(this.Wb, paramt);
    if (this.VY.remove(paramt))
    {
      z.d(localView, 1.0F);
      k(paramt);
    }
    if (this.VZ.remove(paramt))
    {
      z.d(localView, 1.0F);
      k(paramt);
    }
    i = this.We.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.We.get(i);
      a(localArrayList, paramt);
      if (localArrayList.isEmpty()) {
        this.We.remove(i);
      }
      i -= 1;
    }
    i = this.Wd.size() - 1;
    if (i >= 0)
    {
      localArrayList = (ArrayList)this.Wd.get(i);
      int j = localArrayList.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if (((b)localArrayList.get(j)).WB != paramt) {
            break label293;
          }
          z.c(localView, 0.0F);
          z.b(localView, 0.0F);
          q(paramt);
          localArrayList.remove(j);
          if (localArrayList.isEmpty()) {
            this.Wd.remove(i);
          }
        }
        i -= 1;
        break;
        label293:
        j -= 1;
      }
    }
    i = this.Wc.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.Wc.get(i);
      if (localArrayList.remove(paramt))
      {
        z.d(localView, 1.0F);
        k(paramt);
        if (localArrayList.isEmpty()) {
          this.Wc.remove(i);
        }
      }
      i -= 1;
    }
    this.Wh.remove(paramt);
    this.Wf.remove(paramt);
    this.Wi.remove(paramt);
    this.Wg.remove(paramt);
    eK();
  }
  
  public void eJ()
  {
    int i;
    int j;
    label24:
    int k;
    if (!this.VY.isEmpty())
    {
      i = 1;
      if (this.Wa.isEmpty()) {
        break label72;
      }
      j = 1;
      if (this.Wb.isEmpty()) {
        break label77;
      }
      k = 1;
      label36:
      if (this.VZ.isEmpty()) {
        break label82;
      }
    }
    label72:
    label77:
    label82:
    for (int m = 1;; m = 0)
    {
      if ((i != 0) || (j != 0) || (m != 0) || (k != 0)) {
        break label88;
      }
      return;
      i = 0;
      break;
      j = 0;
      break label24;
      k = 0;
      break label36;
    }
    label88:
    final Object localObject1 = this.VY.iterator();
    final Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.t)((Iterator)localObject1).next();
      final ai localai = z.V(((RecyclerView.t)localObject2).abf);
      this.Wh.add(localObject2);
      localai.c(this.aag).p(0.0F).a(new c()
      {
        public final void p(View paramAnonymousView)
        {
          v.this.r(localObject2);
        }
        
        public final void q(View paramAnonymousView)
        {
          localai.a(null);
          z.d(paramAnonymousView, 1.0F);
          v.this.k(localObject2);
          v.this.Wh.remove(localObject2);
          v.this.eK();
        }
      }).start();
    }
    this.VY.clear();
    label260:
    label340:
    long l1;
    label415:
    long l2;
    if (j != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.Wa);
      this.Wd.add(localObject1);
      this.Wa.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          Iterator localIterator = localObject1.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (v.b)localIterator.next();
            v localv = v.this;
            RecyclerView.t localt = ((v.b)localObject).WB;
            int k = ((v.b)localObject).Wx;
            int i = ((v.b)localObject).Wy;
            int m = ((v.b)localObject).Wz;
            int j = ((v.b)localObject).WA;
            localObject = localt.abf;
            k = m - k;
            i = j - i;
            if (k != 0) {
              z.V((View)localObject).q(0.0F);
            }
            if (i != 0) {
              z.V((View)localObject).r(0.0F);
            }
            localObject = z.V((View)localObject);
            localv.Wg.add(localt);
            ((ai)localObject).c(localv.aah).a(new v.6(localv, localt, k, i, (ai)localObject)).start();
          }
          localObject1.clear();
          v.this.Wd.remove(localObject1);
        }
      };
      if (i != 0) {
        z.a(((b)((ArrayList)localObject1).get(0)).WB.abf, (Runnable)localObject2, this.aag);
      }
    }
    else
    {
      if (k != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.Wb);
        this.We.add(localObject1);
        this.Wb.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            Iterator localIterator = localObject1.iterator();
            if (localIterator.hasNext())
            {
              v.a locala = (v.a)localIterator.next();
              v localv = v.this;
              Object localObject1 = locala.Wv;
              if (localObject1 == null)
              {
                localObject1 = null;
                label46:
                localObject2 = locala.Ww;
                if (localObject2 == null) {
                  break label223;
                }
              }
              label223:
              for (Object localObject2 = ((RecyclerView.t)localObject2).abf;; localObject2 = null)
              {
                if (localObject1 != null)
                {
                  localObject1 = z.V((View)localObject1).c(localv.aai);
                  localv.Wi.add(locala.Wv);
                  ((ai)localObject1).q(locala.Wz - locala.Wx);
                  ((ai)localObject1).r(locala.WA - locala.Wy);
                  ((ai)localObject1).p(0.0F).a(new v.7(localv, locala, (ai)localObject1)).start();
                }
                if (localObject2 == null) {
                  break;
                }
                localObject1 = z.V((View)localObject2);
                localv.Wi.add(locala.Ww);
                ((ai)localObject1).q(0.0F).r(0.0F).c(localv.aai).p(1.0F).a(new v.8(localv, locala, (ai)localObject1, (View)localObject2)).start();
                break;
                localObject1 = ((RecyclerView.t)localObject1).abf;
                break label46;
              }
            }
            localObject1.clear();
            v.this.We.remove(localObject1);
          }
        };
        if (i == 0) {
          break label477;
        }
        z.a(((a)((ArrayList)localObject1).get(0)).Wv.abf, (Runnable)localObject2, this.aag);
      }
      if (m == 0) {
        break label485;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.VZ);
      this.Wc.add(localObject1);
      this.VZ.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          Iterator localIterator = localObject1.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.t localt = (RecyclerView.t)localIterator.next();
            v localv = v.this;
            ai localai = z.V(localt.abf);
            localv.Wf.add(localt);
            localai.p(1.0F).c(localv.aaf).a(new v.5(localv, localt, localai)).start();
          }
          localObject1.clear();
          v.this.Wc.remove(localObject1);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label505;
      }
      if (i == 0) {
        break label487;
      }
      l1 = this.aag;
      if (j == 0) {
        break label493;
      }
      l2 = this.aah;
      label425:
      if (k == 0) {
        break label499;
      }
    }
    label477:
    label485:
    label487:
    label493:
    label499:
    for (long l3 = this.aai;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      z.a(((RecyclerView.t)((ArrayList)localObject1).get(0)).abf, (Runnable)localObject2, l1 + l2);
      return;
      ((Runnable)localObject2).run();
      break label260;
      ((Runnable)localObject2).run();
      break label340;
      break;
      l1 = 0L;
      break label415;
      l2 = 0L;
      break label425;
    }
    label505:
    ((Runnable)localObject2).run();
  }
  
  public void eK()
  {
    if (!isRunning()) {
      fS();
    }
  }
  
  public final void eL()
  {
    int i = this.Wa.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (b)this.Wa.get(i);
      localObject2 = ((b)localObject1).WB.abf;
      z.c((View)localObject2, 0.0F);
      z.b((View)localObject2, 0.0F);
      q(((b)localObject1).WB);
      this.Wa.remove(i);
      i -= 1;
    }
    i = this.VY.size() - 1;
    while (i >= 0)
    {
      k((RecyclerView.t)this.VY.get(i));
      this.VY.remove(i);
      i -= 1;
    }
    i = this.VZ.size() - 1;
    while (i >= 0)
    {
      localObject1 = (RecyclerView.t)this.VZ.get(i);
      z.d(((RecyclerView.t)localObject1).abf, 1.0F);
      k((RecyclerView.t)localObject1);
      this.VZ.remove(i);
      i -= 1;
    }
    i = this.Wb.size() - 1;
    while (i >= 0)
    {
      a((a)this.Wb.get(i));
      i -= 1;
    }
    this.Wb.clear();
    if (!isRunning()) {
      return;
    }
    i = this.Wd.size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.Wd.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (b)((ArrayList)localObject1).get(j);
        View localView = ((b)localObject2).WB.abf;
        z.c(localView, 0.0F);
        z.b(localView, 0.0F);
        q(((b)localObject2).WB);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.Wd.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.Wc.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.Wc.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (RecyclerView.t)((ArrayList)localObject1).get(j);
        z.d(((RecyclerView.t)localObject2).abf, 1.0F);
        k((RecyclerView.t)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.Wc.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.We.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.We.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        a((a)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          this.We.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    g(this.Wh);
    g(this.Wg);
    g(this.Wf);
    g(this.Wi);
    fS();
  }
  
  public boolean isRunning()
  {
    return (!this.VZ.isEmpty()) || (!this.Wb.isEmpty()) || (!this.Wa.isEmpty()) || (!this.VY.isEmpty()) || (!this.Wg.isEmpty()) || (!this.Wh.isEmpty()) || (!this.Wf.isEmpty()) || (!this.Wi.isEmpty()) || (!this.Wd.isEmpty()) || (!this.Wc.isEmpty()) || (!this.We.isEmpty());
  }
  
  private static final class a
  {
    public int WA;
    public RecyclerView.t Wv;
    public RecyclerView.t Ww;
    public int Wx;
    public int Wy;
    public int Wz;
    
    private a(RecyclerView.t paramt1, RecyclerView.t paramt2)
    {
      this.Wv = paramt1;
      this.Ww = paramt2;
    }
    
    public a(RecyclerView.t paramt1, RecyclerView.t paramt2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this(paramt1, paramt2);
      this.Wx = paramInt1;
      this.Wy = paramInt2;
      this.Wz = paramInt3;
      this.WA = paramInt4;
    }
    
    public final String toString()
    {
      return "ChangeInfo{oldHolder=" + this.Wv + ", newHolder=" + this.Ww + ", fromX=" + this.Wx + ", fromY=" + this.Wy + ", toX=" + this.Wz + ", toY=" + this.WA + '}';
    }
  }
  
  private static final class b
  {
    public int WA;
    public RecyclerView.t WB;
    public int Wx;
    public int Wy;
    public int Wz;
    
    public b(RecyclerView.t paramt, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.WB = paramt;
      this.Wx = paramInt1;
      this.Wy = paramInt2;
      this.Wz = paramInt3;
      this.WA = paramInt4;
    }
  }
  
  private static class c
    implements am
  {
    public void as(View paramView) {}
    
    public void p(View paramView) {}
    
    public void q(View paramView) {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */