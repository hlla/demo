package android.support.v4.os;

public class OperationCanceledException
  extends RuntimeException
{
  public OperationCanceledException()
  {
    this((byte)0);
  }
  
  private OperationCanceledException(byte paramByte)
  {
    super("The operation has been canceled.");
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/os/OperationCanceledException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */