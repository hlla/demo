package android.support.v4.content;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

final class r
  extends FutureTask
{
  r(o paramo, Callable paramCallable)
  {
    super(paramCallable);
  }
  
  protected final void done()
  {
    try
    {
      Object localObject = get();
      this.a.c(localObject);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException = localInterruptedException;
      Log.w("AsyncTask", localInterruptedException);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      localExecutionException = localExecutionException;
      throw new RuntimeException("An error occurred while executing doInBackground()", localExecutionException.getCause());
    }
    catch (CancellationException localCancellationException)
    {
      localCancellationException = localCancellationException;
      this.a.c(null);
      return;
    }
    finally
    {
      localThrowable = finally;
      throw new RuntimeException("An error occurred while executing doInBackground()", localThrowable);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/content/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */