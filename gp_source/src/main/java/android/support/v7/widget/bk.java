package android.support.v7.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.ac;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.List;

public class bk
  extends gw
{
  public static final boolean DEBUG = false;
  public static TimeInterpolator sDefaultInterpolator;
  public ArrayList mAddAnimations = new ArrayList();
  public ArrayList mAdditionsList = new ArrayList();
  public ArrayList mChangeAnimations = new ArrayList();
  public ArrayList mChangesList = new ArrayList();
  public ArrayList mMoveAnimations = new ArrayList();
  public ArrayList mMovesList = new ArrayList();
  public ArrayList mPendingAdditions = new ArrayList();
  public ArrayList mPendingChanges = new ArrayList();
  public ArrayList mPendingMoves = new ArrayList();
  public ArrayList mPendingRemovals = new ArrayList();
  public ArrayList mRemoveAnimations = new ArrayList();
  
  private void animateRemoveImpl(fz paramfz)
  {
    View localView = paramfz.c;
    ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.mRemoveAnimations.add(paramfz);
    localViewPropertyAnimator.setDuration(getRemoveDuration()).alpha(0.0F).setListener(new bo(this, paramfz, localViewPropertyAnimator, localView)).start();
  }
  
  private void endChangeAnimation(List paramList, fz paramfz)
  {
    int i = paramList.size() - 1;
    if (i >= 0)
    {
      bt localbt = (bt)paramList.get(i);
      if (!endChangeAnimationIfNecessary(localbt, paramfz)) {}
      for (;;)
      {
        i -= 1;
        break;
        if ((localbt.d == null) && (localbt.c == null)) {
          paramList.remove(localbt);
        }
      }
    }
  }
  
  private void endChangeAnimationIfNecessary(bt parambt)
  {
    fz localfz = parambt.d;
    if (localfz != null) {
      endChangeAnimationIfNecessary(parambt, localfz);
    }
    localfz = parambt.c;
    if (localfz != null) {
      endChangeAnimationIfNecessary(parambt, localfz);
    }
  }
  
  private boolean endChangeAnimationIfNecessary(bt parambt, fz paramfz)
  {
    boolean bool = false;
    if (parambt.c == paramfz) {
      parambt.c = null;
    }
    for (;;)
    {
      paramfz.c.setAlpha(1.0F);
      paramfz.c.setTranslationX(0.0F);
      paramfz.c.setTranslationY(0.0F);
      dispatchChangeFinished(paramfz, bool);
      return true;
      if (parambt.d != paramfz) {
        break;
      }
      parambt.d = null;
      bool = true;
    }
    return false;
  }
  
  private void resetAnimation(fz paramfz)
  {
    if (sDefaultInterpolator == null) {
      sDefaultInterpolator = new ValueAnimator().getInterpolator();
    }
    paramfz.c.animate().setInterpolator(sDefaultInterpolator);
    endAnimation(paramfz);
  }
  
  public boolean animateAdd(fz paramfz)
  {
    resetAnimation(paramfz);
    paramfz.c.setAlpha(0.0F);
    this.mPendingAdditions.add(paramfz);
    return true;
  }
  
  void animateAddImpl(fz paramfz)
  {
    View localView = paramfz.c;
    ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.mAddAnimations.add(paramfz);
    localViewPropertyAnimator.alpha(1.0F).setDuration(getAddDuration()).setListener(new bp(this, paramfz, localView, localViewPropertyAnimator)).start();
  }
  
  public boolean animateChange(fz paramfz1, fz paramfz2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramfz1 != paramfz2)
    {
      float f1 = paramfz1.c.getTranslationX();
      float f2 = paramfz1.c.getTranslationY();
      float f3 = paramfz1.c.getAlpha();
      resetAnimation(paramfz1);
      int i = (int)(paramInt3 - paramInt1 - f1);
      int j = (int)(paramInt4 - paramInt2 - f2);
      paramfz1.c.setTranslationX(f1);
      paramfz1.c.setTranslationY(f2);
      paramfz1.c.setAlpha(f3);
      if (paramfz2 != null)
      {
        resetAnimation(paramfz2);
        paramfz2.c.setTranslationX(-i);
        paramfz2.c.setTranslationY(-j);
        paramfz2.c.setAlpha(0.0F);
      }
      this.mPendingChanges.add(new bt(paramfz1, paramfz2, paramInt1, paramInt2, paramInt3, paramInt4));
      return true;
    }
    return animateMove(paramfz1, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  void animateChangeImpl(bt parambt)
  {
    View localView = null;
    Object localObject1 = parambt.d;
    if (localObject1 != null) {}
    for (localObject1 = ((fz)localObject1).c;; localObject1 = null)
    {
      Object localObject2 = parambt.c;
      if (localObject2 != null) {
        localView = ((fz)localObject2).c;
      }
      if (localObject1 != null)
      {
        localObject2 = ((View)localObject1).animate().setDuration(getChangeDuration());
        this.mChangeAnimations.add(parambt.d);
        ((ViewPropertyAnimator)localObject2).translationX(parambt.e - parambt.a);
        ((ViewPropertyAnimator)localObject2).translationY(parambt.f - parambt.b);
        ((ViewPropertyAnimator)localObject2).alpha(0.0F).setListener(new br(this, parambt, (ViewPropertyAnimator)localObject2, (View)localObject1)).start();
      }
      if (localView != null)
      {
        localObject1 = localView.animate();
        this.mChangeAnimations.add(parambt.c);
        ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(getChangeDuration()).alpha(1.0F).setListener(new bs(this, parambt, (ViewPropertyAnimator)localObject1, localView)).start();
      }
      return;
    }
  }
  
  public boolean animateMove(fz paramfz, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramfz.c;
    paramInt1 += (int)localView.getTranslationX();
    paramInt2 += (int)paramfz.c.getTranslationY();
    resetAnimation(paramfz);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if (i != 0) {}
    while (j != 0)
    {
      if (i != 0) {
        localView.setTranslationX(-i);
      }
      if (j != 0) {
        localView.setTranslationY(-j);
      }
      this.mPendingMoves.add(new bu(paramfz, paramInt1, paramInt2, paramInt3, paramInt4));
      return true;
    }
    dispatchMoveFinished(paramfz);
    return false;
  }
  
  void animateMoveImpl(fz paramfz, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramfz.c;
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if (paramInt1 != 0) {
      localView.animate().translationX(0.0F);
    }
    if (paramInt2 != 0) {
      localView.animate().translationY(0.0F);
    }
    ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.mMoveAnimations.add(paramfz);
    localViewPropertyAnimator.setDuration(getMoveDuration()).setListener(new bq(this, paramfz, paramInt1, localView, paramInt2, localViewPropertyAnimator)).start();
  }
  
  public boolean animateRemove(fz paramfz)
  {
    resetAnimation(paramfz);
    this.mPendingRemovals.add(paramfz);
    return true;
  }
  
  public boolean canReuseUpdatedViewHolder(fz paramfz, List paramList)
  {
    return (!paramList.isEmpty()) || (super.canReuseUpdatedViewHolder(paramfz, paramList));
  }
  
  void cancelAll(List paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((fz)paramList.get(i)).c.animate().cancel();
      i -= 1;
    }
  }
  
  void dispatchFinishedWhenDone()
  {
    if (!isRunning()) {
      dispatchAnimationsFinished();
    }
  }
  
  public void endAnimation(fz paramfz)
  {
    View localView = paramfz.c;
    localView.animate().cancel();
    int i = this.mPendingMoves.size() - 1;
    for (;;)
    {
      if (i < 0)
      {
        endChangeAnimation(this.mPendingChanges, paramfz);
        if (this.mPendingRemovals.remove(paramfz))
        {
          localView.setAlpha(1.0F);
          dispatchRemoveFinished(paramfz);
        }
        if (this.mPendingAdditions.remove(paramfz))
        {
          localView.setAlpha(1.0F);
          dispatchAddFinished(paramfz);
        }
        i = this.mChangesList.size() - 1;
        ArrayList localArrayList;
        if (i >= 0)
        {
          localArrayList = (ArrayList)this.mChangesList.get(i);
          endChangeAnimation(localArrayList, paramfz);
          if (!localArrayList.isEmpty()) {}
          for (;;)
          {
            i -= 1;
            break;
            this.mChangesList.remove(i);
          }
        }
        i = this.mMovesList.size() - 1;
        if (i >= 0)
        {
          localArrayList = (ArrayList)this.mMovesList.get(i);
          int j = localArrayList.size() - 1;
          for (;;)
          {
            if (j >= 0)
            {
              if (((bu)localArrayList.get(j)).c != paramfz) {
                break label248;
              }
              localView.setTranslationY(0.0F);
              localView.setTranslationX(0.0F);
              dispatchMoveFinished(paramfz);
              localArrayList.remove(j);
              if (localArrayList.isEmpty()) {
                break label236;
              }
            }
            for (;;)
            {
              i -= 1;
              break;
              label236:
              this.mMovesList.remove(i);
            }
            label248:
            j -= 1;
          }
        }
        i = this.mAdditionsList.size() - 1;
        if (i >= 0)
        {
          localArrayList = (ArrayList)this.mAdditionsList.get(i);
          if (localArrayList.remove(paramfz))
          {
            localView.setAlpha(1.0F);
            dispatchAddFinished(paramfz);
            if (localArrayList.isEmpty()) {
              break label317;
            }
          }
          for (;;)
          {
            i -= 1;
            break;
            label317:
            this.mAdditionsList.remove(i);
          }
        }
        this.mRemoveAnimations.remove(paramfz);
        this.mAddAnimations.remove(paramfz);
        this.mChangeAnimations.remove(paramfz);
        this.mMoveAnimations.remove(paramfz);
        dispatchFinishedWhenDone();
        return;
      }
      if (((bu)this.mPendingMoves.get(i)).c == paramfz)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        dispatchMoveFinished(paramfz);
        this.mPendingMoves.remove(i);
      }
      i -= 1;
    }
  }
  
  public void endAnimations()
  {
    int i = this.mPendingMoves.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (bu)this.mPendingMoves.get(i);
      localObject2 = ((bu)localObject1).c.c;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      dispatchMoveFinished(((bu)localObject1).c);
      this.mPendingMoves.remove(i);
      i -= 1;
    }
    i = this.mPendingRemovals.size() - 1;
    while (i >= 0)
    {
      dispatchRemoveFinished((fz)this.mPendingRemovals.get(i));
      this.mPendingRemovals.remove(i);
      i -= 1;
    }
    i = this.mPendingAdditions.size() - 1;
    while (i >= 0)
    {
      localObject1 = (fz)this.mPendingAdditions.get(i);
      ((fz)localObject1).c.setAlpha(1.0F);
      dispatchAddFinished((fz)localObject1);
      this.mPendingAdditions.remove(i);
      i -= 1;
    }
    i = this.mPendingChanges.size() - 1;
    while (i >= 0)
    {
      endChangeAnimationIfNecessary((bt)this.mPendingChanges.get(i));
      i -= 1;
    }
    this.mPendingChanges.clear();
    if (isRunning())
    {
      i = this.mMovesList.size() - 1;
      int j;
      while (i >= 0)
      {
        localObject1 = (ArrayList)this.mMovesList.get(i);
        j = ((ArrayList)localObject1).size() - 1;
        if (j >= 0)
        {
          localObject2 = (bu)((ArrayList)localObject1).get(j);
          View localView = ((bu)localObject2).c.c;
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          dispatchMoveFinished(((bu)localObject2).c);
          ((ArrayList)localObject1).remove(j);
          if (!((ArrayList)localObject1).isEmpty()) {}
          for (;;)
          {
            j -= 1;
            break;
            this.mMovesList.remove(localObject1);
          }
        }
        i -= 1;
      }
      i = this.mAdditionsList.size() - 1;
      while (i >= 0)
      {
        localObject1 = (ArrayList)this.mAdditionsList.get(i);
        j = ((ArrayList)localObject1).size() - 1;
        if (j >= 0)
        {
          localObject2 = (fz)((ArrayList)localObject1).get(j);
          ((fz)localObject2).c.setAlpha(1.0F);
          dispatchAddFinished((fz)localObject2);
          ((ArrayList)localObject1).remove(j);
          if (!((ArrayList)localObject1).isEmpty()) {}
          for (;;)
          {
            j -= 1;
            break;
            this.mAdditionsList.remove(localObject1);
          }
        }
        i -= 1;
      }
      i = this.mChangesList.size() - 1;
      while (i >= 0)
      {
        localObject1 = (ArrayList)this.mChangesList.get(i);
        j = ((ArrayList)localObject1).size() - 1;
        if (j >= 0)
        {
          endChangeAnimationIfNecessary((bt)((ArrayList)localObject1).get(j));
          if (!((ArrayList)localObject1).isEmpty()) {}
          for (;;)
          {
            j -= 1;
            break;
            this.mChangesList.remove(localObject1);
          }
        }
        i -= 1;
      }
      cancelAll(this.mRemoveAnimations);
      cancelAll(this.mMoveAnimations);
      cancelAll(this.mAddAnimations);
      cancelAll(this.mChangeAnimations);
      dispatchAnimationsFinished();
    }
  }
  
  public boolean isRunning()
  {
    return (!this.mPendingAdditions.isEmpty()) || (!this.mPendingChanges.isEmpty()) || (!this.mPendingMoves.isEmpty()) || (!this.mPendingRemovals.isEmpty()) || (!this.mMoveAnimations.isEmpty()) || (!this.mRemoveAnimations.isEmpty()) || (!this.mAddAnimations.isEmpty()) || (!this.mChangeAnimations.isEmpty()) || (!this.mMovesList.isEmpty()) || (!this.mAdditionsList.isEmpty()) || (!this.mChangesList.isEmpty());
  }
  
  public void runPendingAnimations()
  {
    boolean bool1 = this.mPendingRemovals.isEmpty() ^ true;
    boolean bool2 = this.mPendingMoves.isEmpty() ^ true;
    boolean bool3 = this.mPendingChanges.isEmpty() ^ true;
    boolean bool4 = this.mPendingAdditions.isEmpty() ^ true;
    if (bool1) {}
    label393:
    label410:
    label420:
    while ((bool2) || (bool4) || (bool3))
    {
      ArrayList localArrayList = this.mPendingRemovals;
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        animateRemoveImpl((fz)localArrayList.get(i));
        i += 1;
      }
      this.mPendingRemovals.clear();
      Object localObject;
      if (bool2)
      {
        localArrayList = new ArrayList();
        localArrayList.addAll(this.mPendingMoves);
        this.mMovesList.add(localArrayList);
        this.mPendingMoves.clear();
        localObject = new bl(this, localArrayList);
        if (!bool1) {
          break label420;
        }
        ac.a(((bu)localArrayList.get(0)).c.c, (Runnable)localObject, getRemoveDuration());
      }
      for (;;)
      {
        if (bool3)
        {
          localArrayList = new ArrayList();
          localArrayList.addAll(this.mPendingChanges);
          this.mChangesList.add(localArrayList);
          this.mPendingChanges.clear();
          localObject = new bm(this, localArrayList);
          if (!bool1) {
            break label410;
          }
          ac.a(((bt)localArrayList.get(0)).d.c, (Runnable)localObject, getRemoveDuration());
        }
        for (;;)
        {
          if (bool4)
          {
            localArrayList = new ArrayList();
            localArrayList.addAll(this.mPendingAdditions);
            this.mAdditionsList.add(localArrayList);
            this.mPendingAdditions.clear();
            localObject = new bn(this, localArrayList);
            if (!bool1) {
              break label393;
            }
          }
          while ((bool2) || (bool3))
          {
            if (bool1) {}
            for (long l1 = getRemoveDuration();; l1 = 0L)
            {
              if (bool2) {}
              for (long l2 = getMoveDuration();; l2 = 0L)
              {
                if (bool3) {}
                for (long l3 = getChangeDuration();; l3 = 0L)
                {
                  l2 = Math.max(l2, l3);
                  ac.a(((fz)localArrayList.get(0)).c, (Runnable)localObject, l2 + l1);
                  return;
                }
              }
            }
          }
          ((Runnable)localObject).run();
          return;
          ((Runnable)localObject).run();
        }
        ((Runnable)localObject).run();
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/widget/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */