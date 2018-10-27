package android.support.constraint.a.a;

import java.util.ArrayList;
import java.util.Arrays;

public final class i
  extends o
{
  public boolean ac = false;
  public int ad = 2;
  public boolean ae = false;
  private boolean[] ag = new boolean[3];
  private f[] ah = new f[4];
  private f[] ai = new f[4];
  private int aj = 0;
  private f[] ak = new f[4];
  private m al;
  private android.support.constraint.a.e am = new android.support.constraint.a.e();
  private f[] an = new f[4];
  private int ao = 0;
  private int ap;
  private int aq;
  
  private final int a(android.support.constraint.a.e parame, f[] paramArrayOff, f paramf, int paramInt, boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[0] = true;
    paramArrayOfBoolean[1] = false;
    paramArrayOff[0] = null;
    paramArrayOff[2] = null;
    paramArrayOff[1] = null;
    paramArrayOff[3] = null;
    boolean bool1;
    Object localObject3;
    Object localObject5;
    Object localObject2;
    Object localObject4;
    Object localObject6;
    boolean bool2;
    int i;
    int j;
    f localf;
    a locala;
    if (paramInt == 0)
    {
      localObject1 = paramf.x.g;
      if (localObject1 != null) {
        if (((a)localObject1).d != this) {
          bool1 = false;
        }
      }
      for (;;)
      {
        paramf.t = null;
        if (paramf.W != 8) {}
        for (localObject3 = paramf;; localObject3 = null)
        {
          localObject5 = null;
          paramInt = 0;
          localObject1 = paramf;
          localObject2 = localObject3;
          for (;;)
          {
            if (((f)localObject1).K.g == null)
            {
              localObject4 = localObject2;
              localObject6 = localObject3;
            }
            do
            {
              do
              {
                do
                {
                  parame = ((f)localObject1).K.g;
                  bool2 = bool1;
                  if (parame != null)
                  {
                    bool2 = bool1;
                    if (parame.d != this) {
                      bool2 = false;
                    }
                  }
                  if ((paramf.x.g == null) || (((f)localObject5).K.g == null)) {
                    paramArrayOfBoolean[1] = true;
                  }
                  paramf.q = bool2;
                  ((f)localObject5).t = null;
                  paramArrayOff[0] = paramf;
                  paramArrayOff[2] = localObject4;
                  paramArrayOff[1] = localObject5;
                  paramArrayOff[3] = localObject6;
                  return paramInt;
                  ((f)localObject1).t = null;
                  if (((f)localObject1).W != 8) {
                    break;
                  }
                  localObject4 = ((f)localObject1).x;
                  parame.c(((a)localObject4).e, ((a)localObject4).g.e, 0, 5);
                  parame.c(((f)localObject1).K.e, ((f)localObject1).x.e, 0, 5);
                  localObject4 = localObject3;
                  localObject3 = localObject2;
                  localObject2 = localObject4;
                  i = paramInt;
                  if (((f)localObject1).W != 8)
                  {
                    i = paramInt;
                    if (((f)localObject1).s == h.b)
                    {
                      if (((f)localObject1).R == h.b) {
                        paramArrayOfBoolean[0] = false;
                      }
                      i = paramInt;
                      if (((f)localObject1).g <= 0.0F)
                      {
                        paramArrayOfBoolean[0] = false;
                        i = paramInt + 1;
                        localObject4 = this.ak;
                        j = localObject4.length;
                        if (i >= j) {
                          this.ak = ((f[])Arrays.copyOf((Object[])localObject4, j + j));
                        }
                        this.ak[paramInt] = localObject1;
                      }
                    }
                  }
                  localf = ((f)localObject1).K.g.d;
                  locala = localf.x.g;
                  localObject6 = localObject2;
                  localObject4 = localObject3;
                  paramInt = i;
                } while (locala == null);
                localObject6 = localObject2;
                localObject4 = localObject3;
                paramInt = i;
              } while (locala.d != localObject1);
              localObject6 = localObject2;
              localObject4 = localObject3;
              paramInt = i;
            } while (localf == localObject1);
            localObject5 = localf;
            localObject1 = localf;
            localObject4 = localObject3;
            localObject3 = localObject2;
            localObject2 = localObject4;
            paramInt = i;
          }
          if (localObject2 == null) {}
          for (localObject4 = localObject1;; localObject4 = localObject2)
          {
            if (localObject3 == null)
            {
              localObject2 = localObject1;
              localObject3 = localObject4;
              break;
            }
            if (localObject3 != localObject1)
            {
              ((f)localObject3).t = ((f)localObject1);
              localObject2 = localObject1;
              localObject3 = localObject4;
              break;
            }
            localObject2 = localObject1;
            localObject3 = localObject4;
            break;
          }
        }
        bool1 = true;
        continue;
        bool1 = true;
      }
    }
    Object localObject1 = paramf.M.g;
    if (localObject1 != null) {
      if (((a)localObject1).d != this) {
        bool1 = false;
      }
    }
    for (;;)
    {
      paramf.S = null;
      if (paramf.W != 8) {}
      for (localObject3 = paramf;; localObject3 = null)
      {
        localObject5 = null;
        paramInt = 0;
        localObject1 = paramf;
        localObject2 = localObject3;
        for (;;)
        {
          if (((f)localObject1).d.g == null)
          {
            localObject4 = localObject2;
            localObject6 = localObject3;
          }
          do
          {
            do
            {
              do
              {
                parame = ((f)localObject1).d.g;
                bool2 = bool1;
                if (parame != null)
                {
                  bool2 = bool1;
                  if (parame.d != this) {
                    bool2 = false;
                  }
                }
                if ((paramf.M.g == null) || (((f)localObject5).d.g == null)) {
                  paramArrayOfBoolean[1] = true;
                }
                paramf.P = bool2;
                ((f)localObject5).S = null;
                paramArrayOff[0] = paramf;
                paramArrayOff[2] = localObject4;
                paramArrayOff[1] = localObject5;
                paramArrayOff[3] = localObject6;
                return paramInt;
                ((f)localObject1).S = null;
                if (((f)localObject1).W != 8) {
                  break;
                }
                localObject4 = ((f)localObject1).M;
                parame.c(((a)localObject4).e, ((a)localObject4).g.e, 0, 5);
                parame.c(((f)localObject1).d.e, ((f)localObject1).M.e, 0, 5);
                localObject4 = localObject3;
                localObject3 = localObject2;
                localObject2 = localObject4;
                i = paramInt;
                if (((f)localObject1).W != 8)
                {
                  i = paramInt;
                  if (((f)localObject1).R == h.b)
                  {
                    if (((f)localObject1).s == h.b) {
                      paramArrayOfBoolean[0] = false;
                    }
                    i = paramInt;
                    if (((f)localObject1).g <= 0.0F)
                    {
                      paramArrayOfBoolean[0] = false;
                      i = paramInt + 1;
                      localObject4 = this.ak;
                      j = localObject4.length;
                      if (i >= j) {
                        this.ak = ((f[])Arrays.copyOf((Object[])localObject4, j + j));
                      }
                      this.ak[paramInt] = localObject1;
                    }
                  }
                }
                localf = ((f)localObject1).d.g.d;
                locala = localf.M.g;
                localObject6 = localObject2;
                localObject4 = localObject3;
                paramInt = i;
              } while (locala == null);
              localObject6 = localObject2;
              localObject4 = localObject3;
              paramInt = i;
            } while (locala.d != localObject1);
            localObject6 = localObject2;
            localObject4 = localObject3;
            paramInt = i;
          } while (localf == localObject1);
          localObject5 = localf;
          localObject1 = localf;
          localObject4 = localObject3;
          localObject3 = localObject2;
          localObject2 = localObject4;
          paramInt = i;
        }
        if (localObject2 == null) {}
        for (localObject4 = localObject1;; localObject4 = localObject2)
        {
          if (localObject3 == null)
          {
            localObject2 = localObject1;
            localObject3 = localObject4;
            break;
          }
          if (localObject3 != localObject1)
          {
            ((f)localObject3).S = ((f)localObject1);
            localObject2 = localObject1;
            localObject3 = localObject4;
            break;
          }
          localObject2 = localObject1;
          localObject3 = localObject4;
          break;
        }
      }
      bool1 = true;
      continue;
      bool1 = true;
    }
  }
  
  private final void a(f paramf, boolean[] paramArrayOfBoolean)
  {
    Object localObject2 = null;
    boolean bool2 = false;
    int k = 0;
    if ((paramf.s == h.b) && (paramf.R == h.b) && (paramf.g > 0.0F))
    {
      paramArrayOfBoolean[0] = false;
      return;
    }
    int j = paramf.d();
    if ((paramf.s == h.b) && (paramf.R != h.b) && (paramf.g > 0.0F))
    {
      paramArrayOfBoolean[0] = false;
      return;
    }
    paramf.w = true;
    int m;
    int i;
    if ((paramf instanceof j))
    {
      paramArrayOfBoolean = (j)paramf;
      if (paramArrayOfBoolean.ac == 1)
      {
        m = paramArrayOfBoolean.ad;
        j = m;
        i = k;
        if (m == -1)
        {
          i = paramArrayOfBoolean.ae;
          if (i == -1) {
            break label188;
          }
          j = 0;
        }
      }
    }
    for (;;)
    {
      m = j;
      k = i;
      if (paramf.W == 8)
      {
        k = paramf.X;
        m = j - k;
        k = i - k;
      }
      paramf.j = m;
      paramf.k = k;
      return;
      label188:
      j = 0;
      i = k;
      continue;
      i = j;
      continue;
      if ((paramf.K.d()) || (paramf.x.d()))
      {
        Object localObject1 = paramf.K;
        Object localObject3 = ((a)localObject1).g;
        a locala;
        if (localObject3 != null)
        {
          locala = paramf.x.g;
          if (locala != null) {
            break label852;
          }
        }
        label396:
        label440:
        label652:
        label777:
        label852:
        f localf;
        do
        {
          if (localObject3 != null)
          {
            localObject3 = ((a)localObject3).d;
            k = ((a)localObject1).b() + j;
            if (((f)localObject3).b())
            {
              i = k;
              localObject1 = localObject3;
            }
          }
          for (;;)
          {
            locala = paramf.x;
            localObject3 = locala.g;
            k = j;
            if (localObject3 != null)
            {
              localObject3 = ((a)localObject3).d;
              j += locala.b();
              if (!((f)localObject3).b()) {
                break label777;
              }
              k = j;
              localObject2 = localObject3;
            }
            for (;;)
            {
              boolean bool1;
              if (paramf.K.g != null) {
                if (!((f)localObject1).b()) {
                  if (paramf.K.g.h == e.g)
                  {
                    j = i + (((f)localObject1).k - ((f)localObject1).d());
                    if (!((f)localObject1).L) {
                      if (((f)localObject1).x.g != null) {
                        if (((f)localObject1).K.g != null) {
                          if (((f)localObject1).s == h.b)
                          {
                            bool1 = false;
                            paramf.L = bool1;
                            if (paramf.L)
                            {
                              paramArrayOfBoolean = ((f)localObject1).x.g;
                              if ((paramArrayOfBoolean == null) || (paramArrayOfBoolean.d != paramf)) {
                                i = j + (j - ((f)localObject1).k);
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
              for (;;)
              {
                if (paramf.x.g == null)
                {
                  j = k;
                  break;
                }
                if (!((f)localObject2).b())
                {
                  if (paramf.x.g.h == e.f) {
                    j = k + (((f)localObject2).j - ((f)localObject2).d());
                  }
                  for (;;)
                  {
                    if (!((f)localObject2).y)
                    {
                      bool1 = bool2;
                      if (((f)localObject2).x.g != null)
                      {
                        bool1 = bool2;
                        if (((f)localObject2).K.g != null)
                        {
                          if (((f)localObject2).s != h.b) {
                            break label652;
                          }
                          bool1 = bool2;
                        }
                      }
                    }
                    for (;;)
                    {
                      paramf.y = bool1;
                      if (paramf.y)
                      {
                        paramArrayOfBoolean = ((f)localObject2).K.g;
                        if ((paramArrayOfBoolean == null) || (paramArrayOfBoolean.d != paramf))
                        {
                          j += j - ((f)localObject2).j;
                          break;
                        }
                        break;
                      }
                      break;
                      bool1 = true;
                      continue;
                      bool1 = true;
                    }
                    j = k;
                    if (paramf.x.g.h == e.g) {
                      j = k + ((f)localObject2).j;
                    }
                  }
                }
                j = k;
                break;
                i = j;
                continue;
                i = j;
                continue;
                bool1 = true;
                break label440;
                bool1 = false;
                break label440;
                bool1 = false;
                break label440;
                bool1 = true;
                break label440;
                j = i;
                if (paramf.K.g.h != e.f) {
                  break label396;
                }
                j = i + ((f)localObject1).k;
                break label396;
              }
              localObject2 = localObject3;
              k = j;
              if (!((f)localObject3).w)
              {
                a((f)localObject3, paramArrayOfBoolean);
                localObject2 = localObject3;
                k = j;
              }
            }
            localObject1 = localObject3;
            i = k;
            if (!((f)localObject3).w)
            {
              a((f)localObject3, paramArrayOfBoolean);
              localObject1 = localObject3;
              i = k;
              continue;
              localObject1 = null;
              i = j;
            }
          }
          if (localObject3 == locala) {
            break label885;
          }
          localf = ((a)localObject3).d;
        } while ((localf != locala.d) || (localf == paramf.J));
        label885:
        paramArrayOfBoolean[0] = false;
        return;
      }
      k = paramf.aa + j;
      i = j;
      j = k;
    }
  }
  
  private final void b(f paramf, boolean[] paramArrayOfBoolean)
  {
    boolean bool2 = false;
    int k = 0;
    if ((paramf.R == h.b) && (paramf.s != h.b) && (paramf.g > 0.0F))
    {
      paramArrayOfBoolean[0] = false;
      return;
    }
    int j = paramf.e();
    paramf.V = true;
    int m;
    int i;
    if ((paramf instanceof j))
    {
      paramArrayOfBoolean = (j)paramf;
      if (paramArrayOfBoolean.ac == 0)
      {
        m = paramArrayOfBoolean.ad;
        j = m;
        i = k;
        if (m == -1)
        {
          i = paramArrayOfBoolean.ae;
          if (i == -1) {
            break label150;
          }
          j = 0;
        }
      }
    }
    for (;;)
    {
      m = i;
      k = j;
      if (paramf.W == 8)
      {
        m = paramf.o;
        k = j - m;
        m = i - m;
      }
      paramf.l = k;
      paramf.i = m;
      return;
      label150:
      j = 0;
      i = k;
      continue;
      i = j;
      continue;
      Object localObject1 = paramf.b;
      if ((((a)localObject1).g != null) || (paramf.M.g != null) || (paramf.d.g != null))
      {
        Object localObject3 = paramf.d.g;
        Object localObject2;
        if (localObject3 != null)
        {
          localObject2 = paramf.M.g;
          if (localObject2 != null) {
            break label1015;
          }
        }
        label502:
        label566:
        label798:
        label930:
        label1015:
        do
        {
          if (((a)localObject1).d())
          {
            localObject1 = paramf.b.g.d;
            if (!((f)localObject1).V) {
              b((f)localObject1, paramArrayOfBoolean);
            }
            k = Math.max(((f)localObject1).l - ((f)localObject1).o + j, j);
            m = Math.max(((f)localObject1).i - ((f)localObject1).o + j, j);
            j = m;
            i = k;
            if (paramf.W == 8)
            {
              j = paramf.o;
              i = k - j;
              j = m - j;
            }
            paramf.l = i;
            paramf.i = j;
            return;
          }
          if (paramf.M.d())
          {
            localObject1 = paramf.M;
            localObject2 = ((a)localObject1).g.d;
            i = ((a)localObject1).b() + j;
            if (((f)localObject2).b())
            {
              k = i;
              localObject1 = localObject2;
            }
          }
          for (;;)
          {
            if (paramf.d.d())
            {
              localObject2 = paramf.d;
              localObject3 = ((a)localObject2).g.d;
              j = ((a)localObject2).b() + j;
              if (((f)localObject3).b())
              {
                localObject2 = localObject3;
                i = j;
              }
            }
            for (;;)
            {
              boolean bool1;
              if (paramf.M.g != null) {
                if (!((f)localObject1).b()) {
                  if (paramf.M.g.h == e.h)
                  {
                    j = k + (((f)localObject1).l - ((f)localObject1).e());
                    if (!((f)localObject1).N)
                    {
                      paramArrayOfBoolean = ((f)localObject1).M.g;
                      if (paramArrayOfBoolean != null) {
                        if (paramArrayOfBoolean.d != paramf)
                        {
                          paramArrayOfBoolean = ((f)localObject1).d.g;
                          if (paramArrayOfBoolean != null) {
                            if (paramArrayOfBoolean.d != paramf) {
                              if (((f)localObject1).R == h.b)
                              {
                                bool1 = false;
                                paramf.N = bool1;
                                if (paramf.N)
                                {
                                  paramArrayOfBoolean = ((f)localObject1).d.g;
                                  if ((paramArrayOfBoolean == null) || (paramArrayOfBoolean.d != paramf)) {
                                    j += j - ((f)localObject1).l;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
              for (;;)
              {
                if (paramf.d.g == null) {
                  break label930;
                }
                if (!((f)localObject2).b())
                {
                  if (paramf.d.g.h == e.b) {
                    i = ((f)localObject2).i - ((f)localObject2).e() + i;
                  }
                  for (;;)
                  {
                    if (!((f)localObject2).e)
                    {
                      paramArrayOfBoolean = ((f)localObject2).M.g;
                      bool1 = bool2;
                      if (paramArrayOfBoolean != null)
                      {
                        bool1 = bool2;
                        if (paramArrayOfBoolean.d != paramf)
                        {
                          paramArrayOfBoolean = ((f)localObject2).d.g;
                          bool1 = bool2;
                          if (paramArrayOfBoolean != null)
                          {
                            bool1 = bool2;
                            if (paramArrayOfBoolean.d != paramf)
                            {
                              if (((f)localObject2).R != h.b) {
                                break label798;
                              }
                              bool1 = bool2;
                            }
                          }
                        }
                      }
                    }
                    for (;;)
                    {
                      paramf.e = bool1;
                      if (paramf.e)
                      {
                        paramArrayOfBoolean = ((f)localObject2).M.g;
                        if ((paramArrayOfBoolean == null) || (paramArrayOfBoolean.d != paramf))
                        {
                          i += i - ((f)localObject2).i;
                          break;
                        }
                        break;
                      }
                      break;
                      bool1 = true;
                      continue;
                      bool1 = true;
                    }
                    if (paramf.d.g.h == e.h) {
                      i = ((f)localObject2).i + i;
                    }
                  }
                }
                break;
                continue;
                continue;
                bool1 = true;
                break label566;
                bool1 = false;
                break label566;
                bool1 = false;
                break label566;
                bool1 = false;
                break label566;
                bool1 = false;
                break label566;
                bool1 = true;
                break label566;
                j = k;
                if (paramf.M.g.h != e.b) {
                  break label502;
                }
                j = k + ((f)localObject1).l;
                break label502;
                j = k;
                continue;
                j = k;
              }
              break;
              i = j;
              localObject2 = localObject3;
              if (!((f)localObject3).V)
              {
                b((f)localObject3, paramArrayOfBoolean);
                i = j;
                localObject2 = localObject3;
                continue;
                localObject2 = null;
                i = j;
              }
            }
            localObject1 = localObject2;
            k = i;
            if (!((f)localObject2).V)
            {
              b((f)localObject2, paramArrayOfBoolean);
              localObject1 = localObject2;
              k = i;
              continue;
              localObject1 = null;
              k = j;
            }
          }
          if (localObject3 == localObject2) {
            break label1048;
          }
          localObject3 = ((a)localObject3).d;
        } while ((localObject3 != ((a)localObject2).d) || (localObject3 == paramf.J));
        label1048:
        paramArrayOfBoolean[0] = false;
        return;
      }
      k = j + paramf.ab;
      i = j;
      j = k;
    }
  }
  
  private final boolean b(android.support.constraint.a.e parame)
  {
    a(parame);
    int i5 = this.af.size();
    int i = this.ad;
    int i6;
    Object localObject1;
    int m;
    int n;
    int k;
    int j;
    if (i == 2)
    {
      i6 = this.af.size();
      i = 0;
      if (i < i6)
      {
        localObject1 = (f)this.af.get(i);
        ((f)localObject1).u = -1;
        ((f)localObject1).T = -1;
        if ((((f)localObject1).s != h.b) && (((f)localObject1).R != h.b)) {}
        for (;;)
        {
          i += 1;
          break;
          ((f)localObject1).u = 1;
          ((f)localObject1).T = 1;
        }
      }
      i = 0;
      m = 0;
      n = 0;
      if (i != 0)
      {
        k = 0;
        i = 0;
        j = 0;
        if (j < i6)
        {
          localObject1 = (f)this.af.get(j);
          m = ((f)localObject1).u;
          if (m == 1) {
            label174:
            k += 1;
          }
          for (;;)
          {
            m = ((f)localObject1).T;
            if (m == 1) {
              label193:
              i += 1;
            }
            for (;;)
            {
              j += 1;
              break;
              if (m == -1) {
                break label193;
              }
            }
            if (m == -1) {
              break label174;
            }
          }
        }
        if (k != 0) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      j = 0;
      Object localObject2;
      Object localObject3;
      if (j < i5)
      {
        localObject1 = (f)this.af.get(j);
        if ((localObject1 instanceof i))
        {
          localObject2 = ((f)localObject1).s;
          localObject3 = ((f)localObject1).R;
          if (localObject2 == h.d) {
            ((f)localObject1).a(h.a);
          }
          if (localObject3 == h.d) {
            ((f)localObject1).b(h.a);
          }
          ((f)localObject1).a(parame);
          if (localObject2 == h.d) {
            ((f)localObject1).a((h)localObject2);
          }
          if (localObject3 != h.d) {}
          for (;;)
          {
            j += 1;
            break;
            ((f)localObject1).b((h)localObject3);
          }
        }
        if (i != 0)
        {
          if ((this.s != h.d) && (((f)localObject1).s == h.c))
          {
            localObject2 = ((f)localObject1).x;
            ((a)localObject2).e = parame.a(localObject2);
            localObject2 = ((f)localObject1).K;
            ((a)localObject2).e = parame.a(localObject2);
            k = ((f)localObject1).x.c;
            m = c() - ((f)localObject1).K.c;
            parame.a(((f)localObject1).x.e, k);
            parame.a(((f)localObject1).K.e, m);
            ((f)localObject1).b(k, m);
            ((f)localObject1).u = 2;
          }
          if ((this.R != h.d) && (((f)localObject1).R == h.c))
          {
            localObject2 = ((f)localObject1).M;
            ((a)localObject2).e = parame.a(localObject2);
            localObject2 = ((f)localObject1).d;
            ((a)localObject2).e = parame.a(localObject2);
            k = ((f)localObject1).M.c;
            m = f() - ((f)localObject1).d.c;
            parame.a(((f)localObject1).M.e, k);
            parame.a(((f)localObject1).d.e, m);
            if (((f)localObject1).c <= 0) {
              break label670;
            }
          }
        }
        for (;;)
        {
          localObject2 = ((f)localObject1).b;
          ((a)localObject2).e = parame.a(localObject2);
          parame.a(((f)localObject1).b.e, ((f)localObject1).c + k);
          label670:
          do
          {
            ((f)localObject1).c(k, m);
            ((f)localObject1).T = 2;
            ((f)localObject1).a(parame);
            break;
          } while (((f)localObject1).W != 8);
        }
      }
      if (this.aj <= 0)
      {
        if (this.ao > 0) {
          c(parame);
        }
        return true;
      }
      m = 0;
      label707:
      Object localObject5;
      int i1;
      if (m < this.aj)
      {
        localObject5 = this.ai[m];
        i1 = a(parame, this.ah, (f)localObject5, 0, this.ag);
        localObject2 = this.ah[2];
        if (localObject2 != null) {
          break label765;
        }
      }
      for (;;)
      {
        m += 1;
        break label707;
        break;
        label765:
        if (this.ag[1] == 0) {
          break label842;
        }
        i = ((f)localObject5).g();
        while (localObject2 != null)
        {
          parame.a(((f)localObject2).x.e, i);
          localObject1 = ((f)localObject2).t;
          i += ((f)localObject2).x.b() + ((f)localObject2).c() + ((f)localObject2).K.b();
          localObject2 = localObject1;
        }
      }
      label842:
      int i2 = ((f)localObject5).r;
      if (i2 != 2) {}
      Object localObject4;
      label973:
      label983:
      label1382:
      label1386:
      label1400:
      label1716:
      label1745:
      float f1;
      for (j = 0;; j = 1)
      {
        localObject1 = this.s;
        localObject3 = h.d;
        i = this.ad;
        if (i == 2) {}
        for (;;)
        {
          if (this.ag[0] == 0) {}
          label2664:
          label3136:
          label3158:
          label3239:
          label3334:
          do
          {
            do
            {
              if (i1 == 0)
              {
                localObject4 = null;
                i = 0;
                localObject6 = null;
                localObject3 = localObject2;
              }
              for (;;)
              {
                if (localObject3 != null)
                {
                  localObject1 = ((f)localObject3).t;
                  if (localObject1 == null)
                  {
                    localObject4 = this.ah[1];
                    i = 1;
                  }
                  for (;;)
                  {
                    if (j != 0)
                    {
                      localObject7 = ((f)localObject3).x;
                      k = ((a)localObject7).b();
                      if (localObject6 != null)
                      {
                        k += ((f)localObject6).K.b();
                        if (localObject2 != localObject3)
                        {
                          n = 3;
                          parame.a(((a)localObject7).e, ((a)localObject7).g.e, k, n);
                          if (((f)localObject3).s == h.b)
                          {
                            localObject6 = ((f)localObject3).K;
                            if (((f)localObject3).A == 1)
                            {
                              k = Math.max(((f)localObject3).E, ((f)localObject3).c());
                              parame.c(((a)localObject6).e, ((a)localObject7).e, k, 3);
                            }
                          }
                        }
                      }
                    }
                    for (;;)
                    {
                      if (i == 0) {}
                      for (;;)
                      {
                        localObject6 = localObject3;
                        localObject3 = localObject1;
                        break;
                        localObject1 = null;
                      }
                      parame.a(((a)localObject7).e, ((a)localObject7).g.e, ((a)localObject7).c, 3);
                      parame.b(((a)localObject6).e, ((a)localObject7).e, ((f)localObject3).E, 3);
                      continue;
                      continue;
                      n = 1;
                      break label983;
                      break label973;
                      if (i2 == 0) {}
                      while ((i == 0) || (localObject6 == null))
                      {
                        if (i2 == 0) {}
                        while ((i != 0) || (localObject6 != null))
                        {
                          localObject8 = ((f)localObject3).x;
                          localObject9 = ((f)localObject3).K;
                          k = ((a)localObject8).b();
                          n = ((a)localObject9).b();
                          parame.a(((a)localObject8).e, ((a)localObject8).g.e, k, 1);
                          parame.b(((a)localObject9).e, ((a)localObject9).g.e, -n, 1);
                          localObject7 = ((a)localObject8).g;
                          if (localObject7 != null) {}
                          for (localObject7 = ((a)localObject7).e;; localObject7 = null)
                          {
                            if (localObject6 == null)
                            {
                              localObject6 = ((f)localObject5).x.g;
                              if (localObject6 == null) {
                                break label1400;
                              }
                            }
                            for (localObject7 = ((a)localObject6).e;; localObject7 = null)
                            {
                              if (localObject1 == null)
                              {
                                localObject1 = ((f)localObject4).K.g;
                                if (localObject1 != null) {
                                  localObject1 = ((a)localObject1).d;
                                }
                              }
                              for (;;)
                              {
                                if (localObject1 != null)
                                {
                                  localObject6 = ((f)localObject1).x.e;
                                  if (i != 0)
                                  {
                                    localObject6 = ((f)localObject4).K.g;
                                    if (localObject6 == null) {
                                      break label1382;
                                    }
                                  }
                                  for (localObject6 = ((a)localObject6).e;; localObject6 = null)
                                  {
                                    if (localObject7 == null) {
                                      break label1386;
                                    }
                                    if (localObject6 != null)
                                    {
                                      parame.a(((a)localObject8).e, (android.support.constraint.a.h)localObject7, k, 0.5F, (android.support.constraint.a.h)localObject6, ((a)localObject9).e, n);
                                      break;
                                    }
                                    break;
                                  }
                                  break;
                                }
                                break;
                                localObject1 = null;
                              }
                            }
                          }
                        }
                        localObject6 = ((f)localObject3).x;
                        if (((a)localObject6).g == null)
                        {
                          parame.a(((a)localObject6).e, ((f)localObject3).g());
                          break;
                        }
                        k = ((a)localObject6).b();
                        parame.c(((f)localObject3).x.e, ((f)localObject5).x.g.e, k, 5);
                        break;
                      }
                      localObject6 = ((f)localObject3).K;
                      if (((a)localObject6).g == null)
                      {
                        parame.a(((a)localObject6).e, ((f)localObject3).g() + ((f)localObject3).n);
                      }
                      else
                      {
                        k = ((a)localObject6).b();
                        parame.c(((f)localObject3).K.e, ((f)localObject4).K.g.e, -k, 5);
                      }
                    }
                  }
                }
                if (j == 0) {
                  break;
                }
                localObject3 = ((f)localObject2).x;
                localObject6 = ((f)localObject4).K;
                i = ((a)localObject3).b();
                j = ((a)localObject6).b();
                localObject1 = ((f)localObject5).x.g;
                if (localObject1 != null) {}
                for (localObject1 = ((a)localObject1).e;; localObject1 = null)
                {
                  localObject2 = ((f)localObject4).K.g;
                  if (localObject2 != null) {}
                  for (localObject2 = ((a)localObject2).e;; localObject2 = null)
                  {
                    if ((localObject1 == null) || (localObject2 == null)) {
                      break label1716;
                    }
                    parame.b(((a)localObject6).e, (android.support.constraint.a.h)localObject2, -j, 1);
                    parame.a(((a)localObject3).e, (android.support.constraint.a.h)localObject1, i, ((f)localObject5).p, (android.support.constraint.a.h)localObject2, ((a)localObject6).e, j);
                    break;
                  }
                  break;
                }
                if (j == 0) {
                  break label1745;
                }
                localObject4 = null;
                i = 0;
                localObject6 = null;
                localObject3 = localObject2;
              }
              f1 = 0.0F;
              localObject3 = null;
              localObject1 = localObject2;
              localObject2 = localObject3;
              if (localObject1 != null)
              {
                if (((f)localObject1).s != h.b)
                {
                  j = ((f)localObject1).x.b();
                  i = j;
                  if (localObject2 != null) {
                    i = j + ((f)localObject2).K.b();
                  }
                  if (((f)localObject1).x.g.d.s == h.b) {}
                  for (j = 2;; j = 3)
                  {
                    localObject2 = ((f)localObject1).x;
                    parame.a(((a)localObject2).e, ((a)localObject2).g.e, i, j);
                    j = ((f)localObject1).K.b();
                    localObject2 = ((f)localObject1).K.g.d.x;
                    localObject3 = ((a)localObject2).g;
                    i = j;
                    if (localObject3 != null)
                    {
                      i = j;
                      if (((a)localObject3).d == localObject1) {
                        i = j + ((a)localObject2).b();
                      }
                    }
                    if (((f)localObject1).K.g.d.s == h.b) {}
                    for (j = 2;; j = 3)
                    {
                      localObject2 = ((f)localObject1).K;
                      parame.b(((a)localObject2).e, ((a)localObject2).g.e, -i, j);
                      localObject3 = ((f)localObject1).t;
                      localObject2 = localObject1;
                      localObject1 = localObject3;
                      break;
                    }
                  }
                }
                f1 += ((f)localObject1).v;
                localObject2 = ((f)localObject1).K;
                if (((a)localObject2).g != null)
                {
                  j = ((a)localObject2).b();
                  i = j;
                  if (localObject1 == this.ah[3]) {}
                }
                for (i = j + ((f)localObject1).K.g.d.x.b();; i = 0)
                {
                  parame.a(((f)localObject1).K.e, ((f)localObject1).x.e, 0, 1);
                  localObject2 = ((f)localObject1).K;
                  parame.b(((a)localObject2).e, ((a)localObject2).g.e, -i, 1);
                  break;
                }
              }
              if (i1 == 1)
              {
                localObject2 = this.ak[0];
                j = ((f)localObject2).x.b();
                localObject1 = ((f)localObject2).x.g;
                i = j;
                if (localObject1 != null) {
                  i = j + ((a)localObject1).b();
                }
                k = ((f)localObject2).K.b();
                localObject1 = ((f)localObject2).K.g;
                j = k;
                if (localObject1 != null) {
                  j = k + ((a)localObject1).b();
                }
                localObject1 = ((f)localObject5).K.g.e;
                localObject3 = this.ah;
                if (localObject2 == localObject3[3]) {
                  localObject1 = localObject3[1].K.g.e;
                }
                if (((f)localObject2).A == 1)
                {
                  localObject2 = ((f)localObject5).x;
                  parame.a(((a)localObject2).e, ((a)localObject2).g.e, i, 1);
                  parame.b(((f)localObject5).K.e, (android.support.constraint.a.h)localObject1, -j, 1);
                  parame.c(((f)localObject5).K.e, ((f)localObject5).x.e, ((f)localObject5).c(), 2);
                  break;
                }
                localObject3 = ((f)localObject2).x;
                parame.c(((a)localObject3).e, ((a)localObject3).g.e, i, 1);
                parame.c(((f)localObject2).K.e, (android.support.constraint.a.h)localObject1, -j, 1);
                break;
              }
              i = 0;
              n = i1 - 1;
              if (i >= n) {
                break;
              }
              localObject1 = this.ak;
              localObject3 = localObject1[i];
              k = i + 1;
              localObject4 = localObject1[k];
              localObject2 = ((f)localObject3).x;
              Object localObject6 = ((a)localObject2).e;
              Object localObject7 = ((f)localObject3).K.e;
              Object localObject8 = ((f)localObject4).x.e;
              localObject1 = ((f)localObject4).K.e;
              Object localObject9 = this.ah;
              if (localObject4 == localObject9[3]) {
                localObject1 = localObject9[1].K.e;
              }
              j = ((a)localObject2).b();
              localObject2 = ((f)localObject3).x.g;
              i = j;
              if (localObject2 != null)
              {
                localObject2 = ((a)localObject2).d.K;
                localObject9 = ((a)localObject2).g;
                i = j;
                if (localObject9 != null)
                {
                  i = j;
                  if (((a)localObject9).d == localObject3) {
                    i = j + ((a)localObject2).b();
                  }
                }
              }
              parame.a((android.support.constraint.a.h)localObject6, ((f)localObject3).x.g.e, i, 2);
              i = ((f)localObject3).K.b();
              if (((f)localObject3).K.g != null)
              {
                localObject2 = ((f)localObject3).t;
                if (localObject2 != null)
                {
                  localObject2 = ((f)localObject2).x;
                  if (((a)localObject2).g != null)
                  {
                    j = ((a)localObject2).b();
                    i = j + i;
                  }
                }
              }
              for (;;)
              {
                parame.b((android.support.constraint.a.h)localObject7, ((f)localObject3).K.g.e, -i, 2);
                if (k == n)
                {
                  j = ((f)localObject4).x.b();
                  localObject2 = ((f)localObject4).x.g;
                  i = j;
                  if (localObject2 != null)
                  {
                    localObject2 = ((a)localObject2).d.K;
                    localObject9 = ((a)localObject2).g;
                    i = j;
                    if (localObject9 != null)
                    {
                      i = j;
                      if (((a)localObject9).d == localObject4) {
                        i = j + ((a)localObject2).b();
                      }
                    }
                  }
                  parame.a((android.support.constraint.a.h)localObject8, ((f)localObject4).x.g.e, i, 2);
                  localObject2 = ((f)localObject4).K;
                  localObject9 = this.ah;
                  if (localObject4 == localObject9[3]) {
                    localObject2 = localObject9[1].K;
                  }
                  j = ((a)localObject2).b();
                  localObject9 = ((a)localObject2).g;
                  i = j;
                  if (localObject9 != null)
                  {
                    localObject9 = ((a)localObject9).d.x;
                    a locala = ((a)localObject9).g;
                    i = j;
                    if (locala != null)
                    {
                      i = j;
                      if (locala.d == localObject4) {
                        i = j + ((a)localObject9).b();
                      }
                    }
                  }
                  parame.b((android.support.constraint.a.h)localObject1, ((a)localObject2).g.e, -i, 2);
                }
                i = ((f)localObject5).C;
                if (i > 0) {
                  parame.b((android.support.constraint.a.h)localObject7, (android.support.constraint.a.h)localObject6, i, 2);
                }
                localObject2 = parame.b();
                ((android.support.constraint.a.b)localObject2).a(((f)localObject3).v, f1, ((f)localObject4).v, (android.support.constraint.a.h)localObject6, ((f)localObject3).x.b(), (android.support.constraint.a.h)localObject7, ((f)localObject3).K.b(), (android.support.constraint.a.h)localObject8, ((f)localObject4).x.b(), (android.support.constraint.a.h)localObject1, ((f)localObject4).K.b());
                parame.a((android.support.constraint.a.b)localObject2);
                i = k;
                break;
                j = 0;
                break label2664;
              }
            } while ((!((f)localObject5).q) || (i2 == 2) || (localObject1 == localObject3) || (((f)localObject5).r != 0));
            n = 0;
            localObject1 = null;
            i = 0;
            float f2 = 0.0F;
            localObject2 = localObject5;
            if (localObject2 != null)
            {
              if (((f)localObject2).W != 8)
              {
                k = i + 1;
                if (((f)localObject2).s != h.b)
                {
                  i2 = ((f)localObject2).c();
                  localObject1 = ((f)localObject2).x;
                  if (((a)localObject1).g != null)
                  {
                    i = ((a)localObject1).b();
                    localObject1 = ((f)localObject2).K;
                    if (((a)localObject1).g != null)
                    {
                      j = ((a)localObject1).b();
                      n = j + (n + i2 + i);
                      i = k;
                    }
                  }
                }
              }
              for (;;)
              {
                localObject1 = ((f)localObject2).K.g;
                if (localObject1 != null) {}
                for (localObject3 = ((a)localObject1).d;; localObject3 = null)
                {
                  localObject1 = localObject3;
                  if (localObject3 != null)
                  {
                    localObject4 = ((f)localObject3).x.g;
                    if (localObject4 != null) {
                      break label3239;
                    }
                    localObject1 = null;
                  }
                  for (;;)
                  {
                    localObject3 = localObject1;
                    localObject1 = localObject2;
                    localObject2 = localObject3;
                    break;
                    localObject1 = localObject3;
                    if (localObject4 != null)
                    {
                      localObject1 = localObject3;
                      if (((a)localObject4).d != localObject2) {
                        localObject1 = null;
                      }
                    }
                  }
                }
                j = 0;
                break label3158;
                i = 0;
                break label3136;
                f2 = ((f)localObject2).v + f2;
                i = k;
              }
            }
            if (localObject1 != null)
            {
              localObject1 = ((f)localObject1).K.g;
              if (localObject1 != null)
              {
                j = ((a)localObject1).d.aa;
                k = j;
                if (localObject1 != null)
                {
                  k = j;
                  if (((a)localObject1).d != this) {}
                }
              }
            }
            for (k = i();; k = 0)
            {
              float f5 = k - n;
              float f3 = f5 / (i + 1);
              if (i1 != 0)
              {
                f3 = f5 / i1;
                f1 = 0.0F;
                localObject1 = localObject5;
              }
              while (localObject1 != null)
              {
                localObject2 = ((f)localObject1).x;
                if (((a)localObject2).g != null) {}
                for (i = ((a)localObject2).b();; i = 0)
                {
                  localObject2 = ((f)localObject1).K;
                  if (((a)localObject2).g != null) {}
                  for (j = ((a)localObject2).b();; j = 0)
                  {
                    if (((f)localObject1).W == 8)
                    {
                      i = (int)(f1 - f3 / 2.0F + 0.5F);
                      parame.a(((f)localObject1).x.e, i);
                      parame.a(((f)localObject1).K.e, i);
                      localObject2 = ((f)localObject1).K.g;
                      if (localObject2 != null) {}
                      for (localObject2 = ((a)localObject2).d;; localObject2 = null)
                      {
                        localObject3 = localObject2;
                        if (localObject2 != null)
                        {
                          localObject4 = ((f)localObject2).x.g;
                          localObject3 = localObject2;
                          if (localObject4 != null)
                          {
                            localObject3 = localObject2;
                            if (((a)localObject4).d != localObject1) {
                              localObject3 = null;
                            }
                          }
                        }
                        if (localObject3 == this)
                        {
                          localObject1 = null;
                          break;
                        }
                        localObject1 = localObject3;
                        break;
                      }
                    }
                    float f4 = i;
                    f1 += f4;
                    parame.a(((f)localObject1).x.e, (int)(0.5F + f1));
                    if (((f)localObject1).s != h.b) {
                      f1 = ((f)localObject1).c() + f1;
                    }
                    for (;;)
                    {
                      parame.a(((f)localObject1).K.e, (int)(0.5F + f1));
                      f4 = f1;
                      if (i1 == 0) {
                        f4 = f1 + f3;
                      }
                      f1 = f4 + j;
                      break;
                      if (f2 != 0.0F) {
                        f1 = ((f)localObject1).v * f5 / f2 - f4 - j + f1;
                      } else {
                        f1 = f3 - f4 - j + f1;
                      }
                    }
                  }
                }
                f1 = f3;
                localObject1 = localObject5;
              }
              break;
              j = 0;
              break label3334;
            }
          } while (i != 8);
        }
      }
      if (i != 0)
      {
        i = 0;
      }
      else
      {
        return false;
        k = 0;
        j = 0;
        i1 = 0;
        if (i1 < i6)
        {
          localObject1 = (f)this.af.get(i1);
          if (((f)localObject1).u == -1)
          {
            if (this.s != h.d) {
              break label5703;
            }
            ((f)localObject1).u = 1;
          }
          for (;;)
          {
            if (((f)localObject1).T == -1)
            {
              if (this.R != h.d) {
                break label3914;
              }
              ((f)localObject1).T = 1;
            }
            label3914:
            int i4;
            for (;;)
            {
              if (((f)localObject1).T == -1) {
                k += 1;
              }
              for (;;)
              {
                if (((f)localObject1).u == -1) {
                  j += 1;
                }
                for (;;)
                {
                  i1 += 1;
                  break;
                }
              }
              if (((f)localObject1).R == h.b)
              {
                ((f)localObject1).T = 1;
              }
              else
              {
                if ((this.R != h.d) && (((f)localObject1).R == h.c))
                {
                  localObject2 = ((f)localObject1).M;
                  ((a)localObject2).e = parame.a(localObject2);
                  localObject2 = ((f)localObject1).d;
                  ((a)localObject2).e = parame.a(localObject2);
                  i2 = ((f)localObject1).M.c;
                  i3 = f() - ((f)localObject1).d.c;
                  parame.a(((f)localObject1).M.e, i2);
                  parame.a(((f)localObject1).d.e, i3);
                  if (((f)localObject1).c > 0) {}
                  for (;;)
                  {
                    localObject2 = ((f)localObject1).b;
                    ((a)localObject2).e = parame.a(localObject2);
                    parame.a(((f)localObject1).b.e, ((f)localObject1).c + i2);
                    do
                    {
                      ((f)localObject1).c(i2, i3);
                      ((f)localObject1).T = 2;
                      break;
                    } while (((f)localObject1).W != 8);
                  }
                }
                localObject2 = ((f)localObject1).M;
                localObject3 = ((a)localObject2).g;
                if (localObject3 == null) {
                  break label4413;
                }
                localObject4 = ((f)localObject1).d.g;
                if (localObject4 == null) {
                  break label4413;
                }
                if ((((a)localObject3).d == this) && (((a)localObject4).d == this))
                {
                  i3 = ((a)localObject2).b();
                  i2 = ((f)localObject1).d.b();
                  if (this.R == h.b) {}
                  for (i2 = ((f)localObject1).f() + i3;; i2 = ((f)localObject1).f() + i3)
                  {
                    localObject2 = ((f)localObject1).M;
                    ((a)localObject2).e = parame.a(localObject2);
                    localObject2 = ((f)localObject1).d;
                    ((a)localObject2).e = parame.a(localObject2);
                    parame.a(((f)localObject1).M.e, i3);
                    parame.a(((f)localObject1).d.e, i2);
                    if (((f)localObject1).c > 0) {}
                    for (;;)
                    {
                      localObject2 = ((f)localObject1).b;
                      ((a)localObject2).e = parame.a(localObject2);
                      parame.a(((f)localObject1).b.e, ((f)localObject1).c + i3);
                      do
                      {
                        ((f)localObject1).T = 2;
                        ((f)localObject1).c(i3, i2);
                        break;
                      } while (((f)localObject1).W != 8);
                    }
                    i4 = ((f)localObject1).f();
                    f1 = i3;
                    i3 = (int)((f() - i3 - i2 - i4) * ((f)localObject1).O + f1 + 0.5F);
                  }
                }
                ((f)localObject1).T = 1;
              }
            }
            label4413:
            if (localObject3 == null) {}
            label5337:
            while (((a)localObject3).d != this)
            {
              localObject4 = ((f)localObject1).d.g;
              if ((localObject4 != null) && (((a)localObject4).d == this))
              {
                ((a)localObject2).e = parame.a(localObject2);
                localObject2 = ((f)localObject1).d;
                ((a)localObject2).e = parame.a(localObject2);
                i2 = f() - ((f)localObject1).d.b();
                i3 = i2 - ((f)localObject1).f();
                parame.a(((f)localObject1).M.e, i3);
                parame.a(((f)localObject1).d.e, i2);
                if (((f)localObject1).c > 0) {}
                for (;;)
                {
                  localObject2 = ((f)localObject1).b;
                  ((a)localObject2).e = parame.a(localObject2);
                  parame.a(((f)localObject1).b.e, ((f)localObject1).c + i3);
                  do
                  {
                    ((f)localObject1).T = 2;
                    ((f)localObject1).c(i3, i2);
                    break;
                  } while (((f)localObject1).W != 8);
                }
              }
              if ((localObject3 != null) && (((a)localObject3).d.T == 2))
              {
                localObject3 = ((a)localObject3).e;
                ((a)localObject2).e = parame.a(localObject2);
                localObject2 = ((f)localObject1).d;
                ((a)localObject2).e = parame.a(localObject2);
                i2 = (int)(((android.support.constraint.a.h)localObject3).a + ((f)localObject1).M.b() + 0.5F);
                i3 = ((f)localObject1).f() + i2;
                parame.a(((f)localObject1).M.e, i2);
                parame.a(((f)localObject1).d.e, i3);
                if (((f)localObject1).c > 0) {}
                for (;;)
                {
                  localObject2 = ((f)localObject1).b;
                  ((a)localObject2).e = parame.a(localObject2);
                  parame.a(((f)localObject1).b.e, ((f)localObject1).c + i2);
                  do
                  {
                    ((f)localObject1).T = 2;
                    ((f)localObject1).c(i2, i3);
                    break;
                  } while (((f)localObject1).W != 8);
                }
              }
              if (localObject4 == null) {}
              while (((a)localObject4).d.T != 2)
              {
                localObject5 = ((f)localObject1).b.g;
                if ((localObject5 != null) && (((a)localObject5).d.T == 2))
                {
                  localObject3 = ((a)localObject5).e;
                  ((a)localObject2).e = parame.a(localObject2);
                  localObject2 = ((f)localObject1).d;
                  ((a)localObject2).e = parame.a(localObject2);
                  i2 = (int)(((android.support.constraint.a.h)localObject3).a - ((f)localObject1).c + 0.5F);
                  i3 = ((f)localObject1).f() + i2;
                  parame.a(((f)localObject1).M.e, i2);
                  parame.a(((f)localObject1).d.e, i3);
                  localObject2 = ((f)localObject1).b;
                  ((a)localObject2).e = parame.a(localObject2);
                  parame.a(((f)localObject1).b.e, ((f)localObject1).c + i2);
                  ((f)localObject1).T = 2;
                  ((f)localObject1).c(i2, i3);
                  break;
                }
                if (localObject5 != null) {}
                for (i2 = 1;; i2 = 0)
                {
                  if (localObject3 != null) {}
                  for (i3 = 1;; i3 = 0)
                  {
                    if (localObject4 != null) {}
                    for (i4 = 1;; i4 = 0)
                    {
                      if ((i2 != 0) || (i3 != 0) || (i4 != 0)) {
                        break label5337;
                      }
                      if ((localObject1 instanceof j))
                      {
                        localObject3 = (j)localObject1;
                        if (((j)localObject3).ac != 0) {
                          break;
                        }
                        ((a)localObject2).e = parame.a(localObject2);
                        localObject2 = ((f)localObject1).d;
                        ((a)localObject2).e = parame.a(localObject2);
                        i2 = ((j)localObject3).ad;
                        if (i2 != -1) {
                          f1 = i2;
                        }
                        for (;;)
                        {
                          i2 = (int)(f1 + 0.5F);
                          parame.a(((f)localObject1).M.e, i2);
                          parame.a(((f)localObject1).d.e, i2);
                          ((f)localObject1).T = 2;
                          ((f)localObject1).u = 2;
                          ((f)localObject1).c(i2, i2);
                          ((f)localObject1).b(0, c());
                          break;
                          if (((j)localObject3).ae != -1)
                          {
                            f1 = f() - ((j)localObject3).ae;
                          }
                          else
                          {
                            f1 = f();
                            f1 = ((j)localObject3).af * f1;
                          }
                        }
                      }
                      ((a)localObject2).e = parame.a(localObject2);
                      localObject2 = ((f)localObject1).d;
                      ((a)localObject2).e = parame.a(localObject2);
                      i2 = ((f)localObject1).ab;
                      i3 = ((f)localObject1).f();
                      parame.a(((f)localObject1).M.e, i2);
                      parame.a(((f)localObject1).d.e, i3 + i2);
                      if (((f)localObject1).c > 0) {}
                      for (;;)
                      {
                        localObject2 = ((f)localObject1).b;
                        ((a)localObject2).e = parame.a(localObject2);
                        parame.a(((f)localObject1).b.e, i2 + ((f)localObject1).c);
                        do
                        {
                          ((f)localObject1).T = 2;
                          break;
                        } while (((f)localObject1).W != 8);
                      }
                    }
                    break;
                  }
                }
              }
              localObject3 = ((a)localObject4).e;
              ((a)localObject2).e = parame.a(localObject2);
              localObject2 = ((f)localObject1).d;
              ((a)localObject2).e = parame.a(localObject2);
              i2 = (int)(((android.support.constraint.a.h)localObject3).a - ((f)localObject1).d.b() + 0.5F);
              i3 = i2 - ((f)localObject1).f();
              parame.a(((f)localObject1).M.e, i3);
              parame.a(((f)localObject1).d.e, i2);
              if (((f)localObject1).c > 0) {}
              for (;;)
              {
                localObject2 = ((f)localObject1).b;
                ((a)localObject2).e = parame.a(localObject2);
                parame.a(((f)localObject1).b.e, ((f)localObject1).c + i3);
                do
                {
                  ((f)localObject1).T = 2;
                  ((f)localObject1).c(i3, i2);
                  break;
                } while (((f)localObject1).W != 8);
              }
            }
            i2 = ((a)localObject2).b();
            int i3 = ((f)localObject1).f() + i2;
            localObject2 = ((f)localObject1).M;
            ((a)localObject2).e = parame.a(localObject2);
            localObject2 = ((f)localObject1).d;
            ((a)localObject2).e = parame.a(localObject2);
            parame.a(((f)localObject1).M.e, i2);
            parame.a(((f)localObject1).d.e, i3);
            if (((f)localObject1).c > 0) {}
            for (;;)
            {
              localObject2 = ((f)localObject1).b;
              ((a)localObject2).e = parame.a(localObject2);
              parame.a(((f)localObject1).b.e, ((f)localObject1).c + i2);
              do
              {
                ((f)localObject1).T = 2;
                ((f)localObject1).c(i2, i3);
                break;
              } while (((f)localObject1).W != 8);
            }
            label5703:
            if (((f)localObject1).s == h.b)
            {
              ((f)localObject1).u = 1;
            }
            else if ((this.s != h.d) && (((f)localObject1).s == h.c))
            {
              localObject2 = ((f)localObject1).x;
              ((a)localObject2).e = parame.a(localObject2);
              localObject2 = ((f)localObject1).K;
              ((a)localObject2).e = parame.a(localObject2);
              i2 = ((f)localObject1).x.c;
              i3 = c() - ((f)localObject1).K.c;
              parame.a(((f)localObject1).x.e, i2);
              parame.a(((f)localObject1).K.e, i3);
              ((f)localObject1).b(i2, i3);
              ((f)localObject1).u = 2;
            }
            else
            {
              localObject2 = ((f)localObject1).x;
              localObject3 = ((a)localObject2).g;
              if (localObject3 != null)
              {
                localObject4 = ((f)localObject1).K.g;
                if (localObject4 != null)
                {
                  if ((((a)localObject3).d == this) && (((a)localObject4).d == this))
                  {
                    i3 = ((a)localObject2).b();
                    i2 = ((f)localObject1).K.b();
                    if (this.s == h.b) {}
                    for (i2 = c() - i2;; i2 = ((f)localObject1).c() + i3)
                    {
                      localObject2 = ((f)localObject1).x;
                      ((a)localObject2).e = parame.a(localObject2);
                      localObject2 = ((f)localObject1).K;
                      ((a)localObject2).e = parame.a(localObject2);
                      parame.a(((f)localObject1).x.e, i3);
                      parame.a(((f)localObject1).K.e, i2);
                      ((f)localObject1).u = 2;
                      ((f)localObject1).b(i3, i2);
                      break;
                      i4 = ((f)localObject1).c();
                      i3 += (int)((c() - i3 - i2 - i4) * ((f)localObject1).p + 0.5F);
                    }
                  }
                  ((f)localObject1).u = 1;
                  continue;
                }
              }
              if (localObject3 == null) {}
              label6765:
              while (((a)localObject3).d != this)
              {
                localObject4 = ((f)localObject1).K.g;
                if ((localObject4 != null) && (((a)localObject4).d == this))
                {
                  ((a)localObject2).e = parame.a(localObject2);
                  localObject2 = ((f)localObject1).K;
                  ((a)localObject2).e = parame.a(localObject2);
                  i2 = c() - ((f)localObject1).K.b();
                  i3 = i2 - ((f)localObject1).c();
                  parame.a(((f)localObject1).x.e, i3);
                  parame.a(((f)localObject1).K.e, i2);
                  ((f)localObject1).u = 2;
                  ((f)localObject1).b(i3, i2);
                  break;
                }
                if ((localObject3 != null) && (((a)localObject3).d.u == 2))
                {
                  localObject3 = ((a)localObject3).e;
                  ((a)localObject2).e = parame.a(localObject2);
                  localObject2 = ((f)localObject1).K;
                  ((a)localObject2).e = parame.a(localObject2);
                  i2 = (int)(((android.support.constraint.a.h)localObject3).a + ((f)localObject1).x.b() + 0.5F);
                  i3 = ((f)localObject1).c() + i2;
                  parame.a(((f)localObject1).x.e, i2);
                  parame.a(((f)localObject1).K.e, i3);
                  ((f)localObject1).u = 2;
                  ((f)localObject1).b(i2, i3);
                  break;
                }
                if ((localObject4 != null) && (((a)localObject4).d.u == 2))
                {
                  localObject3 = ((a)localObject4).e;
                  ((a)localObject2).e = parame.a(localObject2);
                  localObject2 = ((f)localObject1).K;
                  ((a)localObject2).e = parame.a(localObject2);
                  i2 = (int)(((android.support.constraint.a.h)localObject3).a - ((f)localObject1).K.b() + 0.5F);
                  i3 = i2 - ((f)localObject1).c();
                  parame.a(((f)localObject1).x.e, i3);
                  parame.a(((f)localObject1).K.e, i2);
                  ((f)localObject1).u = 2;
                  ((f)localObject1).b(i3, i2);
                  break;
                }
                if (localObject3 != null) {}
                for (i2 = 1;; i2 = 0)
                {
                  if (localObject4 != null) {}
                  for (i3 = 1;; i3 = 0)
                  {
                    if ((i2 != 0) || (i3 != 0)) {
                      break label6765;
                    }
                    if ((localObject1 instanceof j))
                    {
                      localObject3 = (j)localObject1;
                      if (((j)localObject3).ac != 1) {
                        break;
                      }
                      ((a)localObject2).e = parame.a(localObject2);
                      localObject2 = ((f)localObject1).K;
                      ((a)localObject2).e = parame.a(localObject2);
                      i2 = ((j)localObject3).ad;
                      if (i2 != -1) {
                        f1 = i2;
                      }
                      for (;;)
                      {
                        i2 = (int)(f1 + 0.5F);
                        parame.a(((f)localObject1).x.e, i2);
                        parame.a(((f)localObject1).K.e, i2);
                        ((f)localObject1).u = 2;
                        ((f)localObject1).T = 2;
                        ((f)localObject1).b(i2, i2);
                        ((f)localObject1).c(0, f());
                        break;
                        if (((j)localObject3).ae != -1)
                        {
                          f1 = c() - ((j)localObject3).ae;
                        }
                        else
                        {
                          f1 = c();
                          f1 = ((j)localObject3).af * f1;
                        }
                      }
                    }
                    ((a)localObject2).e = parame.a(localObject2);
                    localObject2 = ((f)localObject1).K;
                    ((a)localObject2).e = parame.a(localObject2);
                    i2 = ((f)localObject1).aa;
                    i3 = ((f)localObject1).c();
                    parame.a(((f)localObject1).x.e, i2);
                    parame.a(((f)localObject1).K.e, i2 + i3);
                    ((f)localObject1).u = 2;
                    break;
                  }
                  break;
                }
              }
              i2 = ((a)localObject2).b();
              i3 = ((f)localObject1).c() + i2;
              localObject2 = ((f)localObject1).x;
              ((a)localObject2).e = parame.a(localObject2);
              localObject2 = ((f)localObject1).K;
              ((a)localObject2).e = parame.a(localObject2);
              parame.a(((f)localObject1).x.e, i2);
              parame.a(((f)localObject1).K.e, i3);
              ((f)localObject1).u = 2;
              ((f)localObject1).b(i2, i3);
            }
          }
        }
        if (k != 0) {
          label6886:
          if (n == k) {}
        }
        for (;;)
        {
          m = j;
          n = k;
          break;
          if (m == j)
          {
            i = 1;
          }
          else
          {
            continue;
            if (j != 0) {
              break label6886;
            }
            i = 1;
          }
        }
        if (i == 4) {
          break;
        }
        i = 1;
      }
    }
  }
  
  private final void c(android.support.constraint.a.e parame)
  {
    int m = 0;
    if (m < this.ao)
    {
      f localf = this.an[m];
      int i1 = a(parame, this.ah, localf, 1, this.ag);
      Object localObject2 = this.ah[2];
      if (localObject2 == null) {}
      int i;
      Object localObject1;
      int j;
      for (;;)
      {
        m += 1;
        break;
        if (this.ag[1] == 0) {
          break label146;
        }
        i = localf.h();
        while (localObject2 != null)
        {
          parame.a(((f)localObject2).M.e, i);
          localObject1 = ((f)localObject2).S;
          j = ((f)localObject2).M.b();
          k = ((f)localObject2).f();
          i += ((f)localObject2).d.b() + (j + k);
          localObject2 = localObject1;
        }
      }
      label146:
      int i2 = localf.Q;
      if (i2 != 2) {}
      for (int k = 0;; k = 1)
      {
        localObject1 = this.R;
        Object localObject3 = h.d;
        i = this.ad;
        if (i == 2) {}
        for (;;)
        {
          if (this.ag[0] == 0) {}
          label277:
          label287:
          label313:
          label318:
          label785:
          label804:
          label1124:
          label1153:
          label2064:
          label2536:
          label2558:
          label2639:
          label2734:
          do
          {
            Object localObject4;
            float f1;
            do
            {
              if (i1 == 0)
              {
                localObject4 = null;
                i = 0;
                localObject6 = null;
                localObject3 = localObject2;
              }
              a locala;
              for (;;)
              {
                if (localObject3 != null)
                {
                  localObject1 = ((f)localObject3).S;
                  if (localObject1 == null)
                  {
                    localObject5 = this.ah[1];
                    i = 1;
                  }
                  for (;;)
                  {
                    if (k != 0)
                    {
                      localObject7 = ((f)localObject3).M;
                      j = ((a)localObject7).b();
                      if (localObject6 != null)
                      {
                        j += ((f)localObject6).d.b();
                        if (localObject2 != localObject3)
                        {
                          n = 3;
                          localObject4 = ((a)localObject7).g;
                          if (localObject4 != null)
                          {
                            localObject6 = ((a)localObject7).e;
                            localObject4 = ((a)localObject4).e;
                            if (localObject6 == null) {
                              if (((f)localObject3).R == h.b)
                              {
                                localObject4 = ((f)localObject3).d;
                                if (((f)localObject3).z == 1)
                                {
                                  j = Math.max(((f)localObject3).D, ((f)localObject3).f());
                                  parame.c(((a)localObject4).e, ((a)localObject7).e, j, 3);
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                    for (;;)
                    {
                      if (i == 0) {}
                      for (;;)
                      {
                        localObject4 = localObject5;
                        localObject6 = localObject3;
                        localObject3 = localObject1;
                        break;
                        localObject1 = null;
                      }
                      parame.a(((a)localObject7).e, ((a)localObject7).g.e, ((a)localObject7).c, 3);
                      parame.b(((a)localObject4).e, ((a)localObject7).e, ((f)localObject3).D, 3);
                      continue;
                      continue;
                      if (localObject4 == null) {
                        break label318;
                      }
                      parame.a((android.support.constraint.a.h)localObject6, (android.support.constraint.a.h)localObject4, j, n);
                      break label318;
                      localObject6 = ((f)localObject3).b;
                      localObject4 = ((a)localObject6).g;
                      if (localObject4 != null)
                      {
                        localObject6 = ((a)localObject6).e;
                        localObject4 = ((a)localObject4).e;
                        j -= ((a)localObject7).b();
                        break label313;
                      }
                      localObject6 = null;
                      localObject4 = null;
                      break label313;
                      n = 1;
                      break label287;
                      break label277;
                      if (i2 == 0) {}
                      while ((i == 0) || (localObject6 == null))
                      {
                        if (i2 == 0) {}
                        while ((i != 0) || (localObject6 != null))
                        {
                          localObject8 = ((f)localObject3).M;
                          locala = ((f)localObject3).d;
                          j = ((a)localObject8).b();
                          n = locala.b();
                          parame.a(((a)localObject8).e, ((a)localObject8).g.e, j, 1);
                          parame.b(locala.e, locala.g.e, -n, 1);
                          localObject4 = ((a)localObject8).g;
                          if (localObject4 != null) {}
                          for (localObject7 = ((a)localObject4).e;; localObject7 = null)
                          {
                            if (localObject6 == null)
                            {
                              localObject4 = localf.M.g;
                              if (localObject4 == null) {
                                break label804;
                              }
                            }
                            for (localObject7 = ((a)localObject4).e;; localObject7 = null)
                            {
                              if (localObject1 == null)
                              {
                                localObject1 = ((f)localObject5).d.g;
                                if (localObject1 != null) {
                                  localObject4 = ((a)localObject1).d;
                                }
                              }
                              for (;;)
                              {
                                localObject1 = localObject4;
                                if (localObject4 == null) {
                                  break;
                                }
                                localObject6 = ((f)localObject4).M.e;
                                if (i != 0)
                                {
                                  localObject1 = ((f)localObject5).d.g;
                                  if (localObject1 == null) {
                                    break label785;
                                  }
                                }
                                for (localObject6 = ((a)localObject1).e;; localObject6 = null)
                                {
                                  localObject1 = localObject4;
                                  if (localObject7 == null) {
                                    break;
                                  }
                                  localObject1 = localObject4;
                                  if (localObject6 == null) {
                                    break;
                                  }
                                  parame.a(((a)localObject8).e, (android.support.constraint.a.h)localObject7, j, 0.5F, (android.support.constraint.a.h)localObject6, locala.e, n);
                                  localObject1 = localObject4;
                                  break;
                                }
                                localObject4 = null;
                                continue;
                                localObject4 = localObject1;
                              }
                            }
                          }
                        }
                        localObject4 = ((f)localObject3).M;
                        if (((a)localObject4).g == null)
                        {
                          parame.a(((a)localObject4).e, ((f)localObject3).h());
                          break;
                        }
                        j = ((a)localObject4).b();
                        parame.c(((f)localObject3).M.e, localf.M.g.e, j, 5);
                        break;
                      }
                      localObject4 = ((f)localObject3).d;
                      if (((a)localObject4).g == null)
                      {
                        parame.a(((a)localObject4).e, ((f)localObject3).h() + ((f)localObject3).m);
                      }
                      else
                      {
                        j = ((a)localObject4).b();
                        parame.c(((f)localObject3).d.e, ((f)localObject5).d.g.e, -j, 5);
                      }
                    }
                    localObject5 = localObject4;
                  }
                }
                if (k == 0) {
                  break;
                }
                localObject3 = ((f)localObject2).M;
                localObject5 = ((f)localObject4).d;
                i = ((a)localObject3).b();
                j = ((a)localObject5).b();
                localObject1 = localf.M.g;
                if (localObject1 != null) {}
                for (localObject1 = ((a)localObject1).e;; localObject1 = null)
                {
                  localObject2 = ((f)localObject4).d.g;
                  if (localObject2 != null) {}
                  for (localObject2 = ((a)localObject2).e;; localObject2 = null)
                  {
                    if ((localObject1 == null) || (localObject2 == null)) {
                      break label1124;
                    }
                    parame.b(((a)localObject5).e, (android.support.constraint.a.h)localObject2, -j, 1);
                    parame.a(((a)localObject3).e, (android.support.constraint.a.h)localObject1, i, localf.O, (android.support.constraint.a.h)localObject2, ((a)localObject5).e, j);
                    break;
                  }
                  break;
                }
                if (k == 0) {
                  break label1153;
                }
                localObject4 = null;
                i = 0;
                localObject6 = null;
                localObject3 = localObject2;
              }
              f1 = 0.0F;
              localObject1 = null;
              if (localObject2 != null)
              {
                if (((f)localObject2).R != h.b)
                {
                  j = ((f)localObject2).M.b();
                  i = j;
                  if (localObject1 != null) {
                    i = j + ((f)localObject1).d.b();
                  }
                  if (((f)localObject2).M.g.d.R == h.b) {}
                  for (j = 2;; j = 3)
                  {
                    localObject1 = ((f)localObject2).M;
                    parame.a(((a)localObject1).e, ((a)localObject1).g.e, i, j);
                    j = ((f)localObject2).d.b();
                    localObject1 = ((f)localObject2).d.g.d.M;
                    localObject3 = ((a)localObject1).g;
                    i = j;
                    if (localObject3 != null)
                    {
                      i = j;
                      if (((a)localObject3).d == localObject2) {
                        i = j + ((a)localObject1).b();
                      }
                    }
                    if (((f)localObject2).d.g.d.R == h.b) {}
                    for (j = 2;; j = 3)
                    {
                      localObject1 = ((f)localObject2).d;
                      parame.b(((a)localObject1).e, ((a)localObject1).g.e, -i, j);
                      localObject3 = ((f)localObject2).S;
                      localObject1 = localObject2;
                      localObject2 = localObject3;
                      break;
                    }
                  }
                }
                f1 += ((f)localObject2).U;
                localObject1 = ((f)localObject2).d;
                if (((a)localObject1).g != null)
                {
                  j = ((a)localObject1).b();
                  i = j;
                  if (localObject2 == this.ah[3]) {}
                }
                for (i = j + ((f)localObject2).d.g.d.M.b();; i = 0)
                {
                  parame.a(((f)localObject2).d.e, ((f)localObject2).M.e, 0, 1);
                  localObject1 = ((f)localObject2).d;
                  parame.b(((a)localObject1).e, ((a)localObject1).g.e, -i, 1);
                  break;
                }
              }
              if (i1 == 1)
              {
                localObject2 = this.ak[0];
                j = ((f)localObject2).M.b();
                localObject1 = ((f)localObject2).M.g;
                i = j;
                if (localObject1 != null) {
                  i = j + ((a)localObject1).b();
                }
                k = ((f)localObject2).d.b();
                localObject1 = ((f)localObject2).d.g;
                j = k;
                if (localObject1 != null) {
                  j = k + ((a)localObject1).b();
                }
                localObject1 = localf.d.g.e;
                localObject3 = this.ah;
                if (localObject2 == localObject3[3]) {
                  localObject1 = localObject3[1].d.g.e;
                }
                if (((f)localObject2).z == 1)
                {
                  localObject2 = localf.M;
                  parame.a(((a)localObject2).e, ((a)localObject2).g.e, i, 1);
                  parame.b(localf.d.e, (android.support.constraint.a.h)localObject1, -j, 1);
                  parame.c(localf.d.e, localf.M.e, localf.f(), 2);
                  break;
                }
                localObject3 = ((f)localObject2).M;
                parame.c(((a)localObject3).e, ((a)localObject3).g.e, i, 1);
                parame.c(((f)localObject2).d.e, (android.support.constraint.a.h)localObject1, -j, 1);
                break;
              }
              i = 0;
              n = i1 - 1;
              if (i >= n) {
                break;
              }
              localObject1 = this.ak;
              localObject3 = localObject1[i];
              k = i + 1;
              localObject4 = localObject1[k];
              localObject2 = ((f)localObject3).M;
              Object localObject5 = ((a)localObject2).e;
              Object localObject6 = ((f)localObject3).d.e;
              Object localObject7 = ((f)localObject4).M.e;
              localObject1 = ((f)localObject4).d.e;
              Object localObject8 = this.ah;
              if (localObject4 == localObject8[3]) {
                localObject1 = localObject8[1].d.e;
              }
              j = ((a)localObject2).b();
              localObject2 = ((f)localObject3).M.g;
              i = j;
              if (localObject2 != null)
              {
                localObject2 = ((a)localObject2).d.d;
                localObject8 = ((a)localObject2).g;
                i = j;
                if (localObject8 != null)
                {
                  i = j;
                  if (((a)localObject8).d == localObject3) {
                    i = j + ((a)localObject2).b();
                  }
                }
              }
              parame.a((android.support.constraint.a.h)localObject5, ((f)localObject3).M.g.e, i, 2);
              i = ((f)localObject3).d.b();
              if (((f)localObject3).d.g != null)
              {
                localObject2 = ((f)localObject3).S;
                if (localObject2 != null)
                {
                  localObject2 = ((f)localObject2).M;
                  if (((a)localObject2).g != null)
                  {
                    j = ((a)localObject2).b();
                    i = j + i;
                  }
                }
              }
              for (;;)
              {
                parame.b((android.support.constraint.a.h)localObject6, ((f)localObject3).d.g.e, -i, 2);
                if (k == n)
                {
                  j = ((f)localObject4).M.b();
                  localObject2 = ((f)localObject4).M.g;
                  i = j;
                  if (localObject2 != null)
                  {
                    localObject2 = ((a)localObject2).d.d;
                    localObject8 = ((a)localObject2).g;
                    i = j;
                    if (localObject8 != null)
                    {
                      i = j;
                      if (((a)localObject8).d == localObject4) {
                        i = j + ((a)localObject2).b();
                      }
                    }
                  }
                  parame.a((android.support.constraint.a.h)localObject7, ((f)localObject4).M.g.e, i, 2);
                  localObject2 = ((f)localObject4).d;
                  localObject8 = this.ah;
                  if (localObject4 == localObject8[3]) {
                    localObject2 = localObject8[1].d;
                  }
                  j = ((a)localObject2).b();
                  localObject8 = ((a)localObject2).g;
                  i = j;
                  if (localObject8 != null)
                  {
                    localObject8 = ((a)localObject8).d.M;
                    locala = ((a)localObject8).g;
                    i = j;
                    if (locala != null)
                    {
                      i = j;
                      if (locala.d == localObject4) {
                        i = j + ((a)localObject8).b();
                      }
                    }
                  }
                  parame.b((android.support.constraint.a.h)localObject1, ((a)localObject2).g.e, -i, 2);
                }
                i = localf.B;
                if (i > 0) {
                  parame.b((android.support.constraint.a.h)localObject6, (android.support.constraint.a.h)localObject5, i, 2);
                }
                localObject2 = parame.b();
                ((android.support.constraint.a.b)localObject2).a(((f)localObject3).U, f1, ((f)localObject4).U, (android.support.constraint.a.h)localObject5, ((f)localObject3).M.b(), (android.support.constraint.a.h)localObject6, ((f)localObject3).d.b(), (android.support.constraint.a.h)localObject7, ((f)localObject4).M.b(), (android.support.constraint.a.h)localObject1, ((f)localObject4).d.b());
                parame.a((android.support.constraint.a.b)localObject2);
                i = k;
                break;
                j = 0;
                break label2064;
              }
            } while ((!localf.P) || (i2 == 2) || (localObject1 == localObject3) || (localf.Q != 0));
            int n = 0;
            localObject1 = null;
            i = 0;
            float f2 = 0.0F;
            localObject2 = localf;
            if (localObject2 != null)
            {
              if (((f)localObject2).W != 8)
              {
                k = i + 1;
                if (((f)localObject2).R != h.b)
                {
                  i2 = ((f)localObject2).f();
                  localObject1 = ((f)localObject2).M;
                  if (((a)localObject1).g != null)
                  {
                    i = ((a)localObject1).b();
                    localObject1 = ((f)localObject2).d;
                    if (((a)localObject1).g != null)
                    {
                      j = ((a)localObject1).b();
                      n = j + (n + i2 + i);
                      i = k;
                    }
                  }
                }
              }
              for (;;)
              {
                localObject1 = ((f)localObject2).d.g;
                if (localObject1 != null) {}
                for (localObject3 = ((a)localObject1).d;; localObject3 = null)
                {
                  localObject1 = localObject3;
                  if (localObject3 != null)
                  {
                    localObject4 = ((f)localObject3).M.g;
                    if (localObject4 != null) {
                      break label2639;
                    }
                    localObject1 = null;
                  }
                  for (;;)
                  {
                    localObject3 = localObject1;
                    localObject1 = localObject2;
                    localObject2 = localObject3;
                    break;
                    localObject1 = localObject3;
                    if (localObject4 != null)
                    {
                      localObject1 = localObject3;
                      if (((a)localObject4).d != localObject2) {
                        localObject1 = null;
                      }
                    }
                  }
                }
                j = 0;
                break label2558;
                i = 0;
                break label2536;
                f2 = ((f)localObject2).U + f2;
                i = k;
              }
            }
            if (localObject1 != null)
            {
              localObject1 = ((f)localObject1).d.g;
              if (localObject1 != null)
              {
                j = ((a)localObject1).d.aa;
                k = j;
                if (localObject1 != null)
                {
                  k = j;
                  if (((a)localObject1).d != this) {}
                }
              }
            }
            for (k = j();; k = 0)
            {
              float f5 = k - n;
              f1 = f5 / (i + 1);
              float f3;
              if (i1 != 0)
              {
                f3 = f5 / i1;
                localObject1 = localf;
                f1 = 0.0F;
              }
              while (localObject1 != null)
              {
                localObject2 = ((f)localObject1).M;
                if (((a)localObject2).g != null) {}
                for (i = ((a)localObject2).b();; i = 0)
                {
                  localObject2 = ((f)localObject1).d;
                  if (((a)localObject2).g != null) {}
                  for (j = ((a)localObject2).b();; j = 0)
                  {
                    if (((f)localObject1).W == 8)
                    {
                      i = (int)(f1 - f3 / 2.0F + 0.5F);
                      parame.a(((f)localObject1).M.e, i);
                      parame.a(((f)localObject1).d.e, i);
                      localObject2 = ((f)localObject1).d.g;
                      if (localObject2 != null) {}
                      for (localObject2 = ((a)localObject2).d;; localObject2 = null)
                      {
                        localObject3 = localObject2;
                        if (localObject2 != null)
                        {
                          localObject4 = ((f)localObject2).M.g;
                          localObject3 = localObject2;
                          if (localObject4 != null)
                          {
                            localObject3 = localObject2;
                            if (((a)localObject4).d != localObject1) {
                              localObject3 = null;
                            }
                          }
                        }
                        if (localObject3 == this)
                        {
                          localObject1 = null;
                          break;
                        }
                        localObject1 = localObject3;
                        break;
                      }
                    }
                    float f4 = i;
                    f1 += f4;
                    parame.a(((f)localObject1).M.e, (int)(0.5F + f1));
                    if (((f)localObject1).R != h.b) {
                      f1 = ((f)localObject1).f() + f1;
                    }
                    for (;;)
                    {
                      parame.a(((f)localObject1).d.e, (int)(0.5F + f1));
                      f4 = f1;
                      if (i1 == 0) {
                        f4 = f1 + f3;
                      }
                      f1 = f4 + j;
                      break;
                      if (f2 != 0.0F) {
                        f1 = ((f)localObject1).U * f5 / f2 - f4 - j + f1;
                      } else {
                        f1 = f3 - f4 - j + f1;
                      }
                    }
                  }
                }
                f3 = f1;
                localObject1 = localf;
              }
              break;
              j = 0;
              break label2734;
            }
          } while (i != 8);
        }
      }
    }
  }
  
  public final void a()
  {
    this.am.a();
    super.a();
  }
  
  final void a(f paramf, int paramInt)
  {
    int i = 0;
    a locala1;
    Object localObject;
    a locala2;
    if (paramInt == 0)
    {
      locala1 = paramf.x;
      localObject = locala1.g;
      if (localObject != null)
      {
        localObject = ((a)localObject).d;
        locala2 = ((f)localObject).K.g;
        if (locala2 == null)
        {
          paramInt = 0;
          for (;;)
          {
            i = this.aj;
            if (paramInt >= i) {
              break;
            }
            if (this.ai[paramInt] == paramf) {
              break label130;
            }
            paramInt += 1;
          }
          localObject = this.ai;
          paramInt = localObject.length;
          if (i + 1 >= paramInt) {
            this.ai = ((f[])Arrays.copyOf((Object[])localObject, paramInt + paramInt));
          }
          localObject = this.ai;
          paramInt = this.aj;
          localObject[paramInt] = paramf;
          this.aj = (paramInt + 1);
        }
      }
    }
    label130:
    while (paramInt != 1) {
      for (;;)
      {
        return;
        if (locala2 != locala1)
        {
          paramInt = 0;
        }
        else if (localObject != paramf)
        {
          paramf = (f)localObject;
        }
        else
        {
          paramInt = 0;
          continue;
          paramInt = 0;
        }
      }
    }
    for (;;)
    {
      locala1 = paramf.M;
      localObject = locala1.g;
      paramInt = i;
      if (localObject != null)
      {
        localObject = ((a)localObject).d;
        locala2 = ((f)localObject).d.g;
        if (locala2 != null) {
          break label297;
        }
        paramInt = i;
      }
      label241:
      label297:
      do
      {
        do
        {
          for (;;)
          {
            i = this.ao;
            if (paramInt >= i) {
              break label241;
            }
            if (this.an[paramInt] == paramf) {
              break;
            }
            paramInt += 1;
          }
          localObject = this.an;
          paramInt = localObject.length;
          if (i + 1 >= paramInt) {
            this.an = ((f[])Arrays.copyOf((Object[])localObject, paramInt + paramInt));
          }
          localObject = this.an;
          paramInt = this.ao;
          localObject[paramInt] = paramf;
          this.ao = (paramInt + 1);
          return;
          paramInt = i;
        } while (locala2 != locala1);
        paramInt = i;
      } while (localObject == paramf);
      paramf = (f)localObject;
    }
  }
  
  public final void o()
  {
    int i5 = this.aa;
    int i6 = this.ab;
    int i7 = Math.max(0, c());
    int i8 = Math.max(0, f());
    this.ae = false;
    this.ac = false;
    Object localObject1;
    int j;
    int i;
    Object localObject3;
    Object localObject4;
    if (this.J != null)
    {
      if (this.al == null) {
        this.al = new m(this);
      }
      localObject1 = this.al;
      ((m)localObject1).d = this.aa;
      ((m)localObject1).e = this.ab;
      ((m)localObject1).c = c();
      ((m)localObject1).b = f();
      j = ((m)localObject1).a.size();
      i = 0;
      if (i < j)
      {
        localObject3 = (n)((m)localObject1).a.get(i);
        ((n)localObject3).a = a(((n)localObject3).a.h);
        localObject4 = ((n)localObject3).a;
        if (localObject4 == null)
        {
          ((n)localObject3).e = null;
          ((n)localObject3).c = 0;
          ((n)localObject3).d = d.b;
        }
        for (((n)localObject3).b = 0;; ((n)localObject3).b = ((a)localObject4).a)
        {
          i += 1;
          break;
          ((n)localObject3).e = ((a)localObject4).g;
          ((n)localObject3).c = ((a)localObject4).b();
          localObject4 = ((n)localObject3).a;
          ((n)localObject3).d = ((a)localObject4).f;
        }
      }
      this.aa = 0;
      this.ab = 0;
      j = this.a.size();
      i = 0;
      while (i < j)
      {
        ((a)this.a.get(i)).c();
        i += 1;
      }
      a(this.am.a);
    }
    for (;;)
    {
      localObject3 = this.R;
      localObject4 = this.s;
      Object localObject5;
      int i1;
      int n;
      int m;
      int k;
      int i4;
      label507:
      int i12;
      int i11;
      if (this.ad == 2) {
        if ((localObject3 == h.d) || (this.s == h.d))
        {
          localObject1 = this.af;
          localObject5 = this.ag;
          int i9 = ((ArrayList)localObject1).size();
          localObject5[0] = 1;
          i = 0;
          i1 = 0;
          n = 0;
          m = 0;
          k = 0;
          j = 0;
          i4 = 0;
          if (i4 >= i9)
          {
            n = Math.max(i1, n);
            this.aq = Math.max(this.G, Math.max(n, k));
            i = Math.max(i, m);
            this.ap = Math.max(this.F, Math.max(i, j));
            i = 0;
            while (i < i9)
            {
              localObject5 = (f)((ArrayList)localObject1).get(i);
              ((f)localObject5).w = false;
              ((f)localObject5).V = false;
              ((f)localObject5).y = false;
              ((f)localObject5).L = false;
              ((f)localObject5).N = false;
              ((f)localObject5).e = false;
              i += 1;
            }
            i12 = this.ag[0];
            if (i7 <= 0)
            {
              i11 = i12;
              label524:
              if (i11 != 0) {
                if (this.s == h.d)
                {
                  this.s = h.a;
                  if ((i7 > 0) && (i7 < this.aq))
                  {
                    this.ae = true;
                    a(i7);
                  }
                }
                else
                {
                  label571:
                  if (this.R == h.d)
                  {
                    this.R = h.a;
                    if ((i8 > 0) && (i8 < this.ap))
                    {
                      this.ac = true;
                      b(i8);
                    }
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        this.aj = 0;
        this.ao = 0;
        n = this.af.size();
        i = 0;
        if (i < n)
        {
          localObject1 = (f)this.af.get(i);
          if (!(localObject1 instanceof o)) {}
          for (;;)
          {
            i += 1;
            break;
            ((o)localObject1).o();
          }
        }
        i = 0;
        i12 = 1;
        if (i12 != 0) {
          m = i + 1;
        }
        try
        {
          this.am.a();
          i13 = b(this.am);
          i12 = i13;
          i13 = i12;
          if (i12 == 0) {
            break label818;
          }
          try
          {
            localObject1 = this.am;
            localObject5 = ((android.support.constraint.a.e)localObject1).b;
            ((android.support.constraint.a.d)localObject5).a((android.support.constraint.a.e)localObject1);
            ((android.support.constraint.a.e)localObject1).b((android.support.constraint.a.d)localObject5);
            ((android.support.constraint.a.e)localObject1).a((android.support.constraint.a.d)localObject5);
            i = 0;
            for (;;)
            {
              i13 = i12;
              if (i >= ((android.support.constraint.a.e)localObject1).d) {
                break;
              }
              localObject5 = localObject1.e[i];
              ((android.support.constraint.a.b)localObject5).c.a = ((android.support.constraint.a.b)localObject5).a;
              i += 1;
            }
            com.google.e.a.a.a.a.a.a.a(localException1);
          }
          catch (Exception localException1) {}
        }
        catch (Exception localException2)
        {
          int i13;
          Object localObject2;
          f localf;
          int i2;
          for (;;) {}
        }
        i13 = i12;
        label818:
        if (i13 != 0)
        {
          localObject2 = this.ag;
          localObject2[2] = 0;
          n();
          j = this.af.size();
          i = 0;
          if (i < j)
          {
            localObject5 = (f)this.af.get(i);
            ((f)localObject5).n();
            if ((((f)localObject5).s == h.b) && (((f)localObject5).c() < ((f)localObject5).Z)) {
              localObject2[2] = 1;
            }
            if (((f)localObject5).R != h.b) {}
            for (;;)
            {
              i += 1;
              break;
              if (((f)localObject5).f() < ((f)localObject5).Y) {
                localObject2[2] = 1;
              }
            }
          }
        }
        else
        {
          n();
          i = 0;
          if (i < n)
          {
            localObject2 = (f)this.af.get(i);
            if ((((f)localObject2).s != h.b) || (((f)localObject2).c() >= ((f)localObject2).Z)) {
              break label1485;
            }
            this.ag[2] = true;
          }
        }
        for (;;)
        {
          if (m < 8) {
            if (this.ag[2] != 0)
            {
              k = 0;
              i = 0;
              j = 0;
              while (j < n)
              {
                localObject2 = (f)this.af.get(j);
                k = Math.max(k, ((f)localObject2).aa + ((f)localObject2).c());
                i1 = ((f)localObject2).ab;
                i = Math.max(i, ((f)localObject2).f() + i1);
                j += 1;
              }
              j = Math.max(this.G, k);
              i = Math.max(this.F, i);
              if (localObject4 != h.d)
              {
                i13 = 0;
                i12 = i11;
                i11 = i13;
                label1116:
                if (localObject3 == h.d) {}
              }
            }
          }
          for (;;)
          {
            i = Math.max(this.G, c());
            i13 = i12;
            if (i > c())
            {
              a(i);
              this.s = h.a;
              i13 = 1;
              i11 = 1;
            }
            i = Math.max(this.F, f());
            i12 = i11;
            if (i > f())
            {
              b(i);
              this.R = h.a;
              i13 = 1;
              i12 = 1;
            }
            i11 = i12;
            int i14 = i13;
            int i16;
            int i15;
            if (i13 == 0)
            {
              if (this.s == h.d) {
                break label1328;
              }
              i16 = i13;
              i15 = i12;
            }
            for (;;)
            {
              if (this.R != h.d)
              {
                i14 = i16;
                i11 = i15;
              }
              for (;;)
              {
                i = m;
                i12 = i11;
                i11 = i14;
                break;
                i11 = i15;
                i14 = i16;
                if (i8 > 0)
                {
                  i11 = i15;
                  i14 = i16;
                  if (f() > i8)
                  {
                    this.ac = true;
                    this.R = h.a;
                    b(i8);
                    i14 = 1;
                    i11 = 1;
                  }
                }
              }
              label1328:
              i15 = i12;
              i16 = i13;
              if (i7 > 0)
              {
                i15 = i12;
                i16 = i13;
                if (c() > i7)
                {
                  this.ae = true;
                  this.s = h.a;
                  a(i7);
                  i16 = 1;
                  i15 = 1;
                }
              }
            }
            if (f() < i)
            {
              b(i);
              this.R = h.d;
              i12 = 1;
              i11 = 1;
              continue;
              if (c() < j)
              {
                a(j);
                this.s = h.d;
                i12 = 1;
                i11 = 1;
                break label1116;
              }
              i13 = 0;
              i12 = i11;
              i11 = i13;
              break label1116;
              i13 = 0;
              i12 = i11;
              i11 = i13;
              continue;
              i13 = 0;
              i12 = i11;
              i11 = i13;
            }
          }
          label1485:
          if (((f)localObject2).R != h.b) {}
          while (((f)localObject2).f() >= ((f)localObject2).Y)
          {
            i += 1;
            break;
          }
          this.ag[2] = true;
        }
        if (this.J != null)
        {
          j = Math.max(this.G, c());
          k = Math.max(this.F, f());
          localObject2 = this.al;
          this.aa = ((m)localObject2).d;
          this.ab = ((m)localObject2).e;
          a(((m)localObject2).c);
          b(((m)localObject2).b);
          m = ((m)localObject2).a.size();
          i = 0;
          while (i < m)
          {
            localObject5 = (n)((m)localObject2).a.get(i);
            a(((n)localObject5).a.h).a(((n)localObject5).e, ((n)localObject5).c, -1, ((n)localObject5).d, ((n)localObject5).b, false);
            i += 1;
          }
          a(j);
          b(k);
        }
        for (;;)
        {
          if (i11 == 0) {}
          for (;;)
          {
            a(this.am.a);
            localObject2 = this.J;
            localObject3 = this;
            while (localObject2 != null)
            {
              localObject4 = ((f)localObject2).J;
              if ((localObject2 instanceof i))
              {
                localObject3 = (i)localObject2;
                localObject2 = localObject4;
              }
              else
              {
                localObject2 = localObject4;
              }
            }
            if (this == localObject3) {
              m();
            }
            return;
            this.s = ((h)localObject4);
            this.R = ((h)localObject3);
          }
          this.aa = i5;
          this.ab = i6;
        }
        b(Math.max(this.F, this.ap));
        continue;
        continue;
        a(Math.max(this.G, this.aq));
        break label571;
        continue;
        i11 = i12;
        if (i8 <= 0) {
          break label524;
        }
        if (this.aq <= i7)
        {
          i11 = i12;
          if (this.ap <= i8) {
            break label524;
          }
          i11 = 0;
          break label524;
        }
        i11 = 0;
        break label524;
        localf = (f)((ArrayList)localObject2).get(i4);
        if (localf.b())
        {
          i2 = j;
          j = k;
          k = m;
          m = n;
          n = i1;
          i1 = i;
        }
        for (i = i2;; i = i2)
        {
          i4 += 1;
          i2 = i1;
          i1 = n;
          n = m;
          m = k;
          k = j;
          j = i;
          i = i2;
          break;
          if (!localf.w) {
            a(localf, (boolean[])localObject5);
          }
          if (!localf.V) {
            b(localf, (boolean[])localObject5);
          }
          if (localObject5[0] == 0) {
            break label507;
          }
          i2 = localf.j + localf.k - localf.c();
          int i3 = localf.l + localf.i - localf.f();
          if (localf.s == h.c) {
            i2 = localf.c() + localf.x.c + localf.K.c;
          }
          if (localf.R == h.c) {
            i3 = localf.f() + localf.M.c + localf.d.c;
          }
          int i10 = localf.W;
          if (i10 == 8) {
            i3 = 0;
          }
          if (i10 == 8) {
            i2 = 0;
          }
          i1 = Math.max(i1, localf.j);
          n = Math.max(n, localf.k);
          m = Math.max(m, localf.i);
          i = Math.max(i, localf.l);
          k = Math.max(k, i2);
          i2 = Math.max(j, i3);
          j = k;
          k = m;
          m = n;
          n = i1;
          i1 = i;
        }
        i11 = 0;
        continue;
        i11 = 0;
      }
      this.aa = 0;
      this.ab = 0;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/constraint/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */