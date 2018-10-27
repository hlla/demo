package android.support.v7.app;

import android.content.res.Resources.NotFoundException;

final class ab
  implements Thread.UncaughtExceptionHandler
{
  ab(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) {}
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof Resources.NotFoundException))
    {
      localObject = paramThrowable.getMessage();
      if ((localObject != null) && ((((String)localObject).contains("drawable")) || (((String)localObject).contains("Drawable")))) {}
    }
    else
    {
      this.a.uncaughtException(paramThread, paramThrowable);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramThrowable.getMessage());
    ((StringBuilder)localObject).append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
    localObject = new Resources.NotFoundException(((StringBuilder)localObject).toString());
    ((Throwable)localObject).initCause(paramThrowable.getCause());
    ((Throwable)localObject).setStackTrace(paramThrowable.getStackTrace());
    this.a.uncaughtException(paramThread, (Throwable)localObject);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */