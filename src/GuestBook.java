public interface GuestBook extends java.rmi.Remote
{
	public void getMsg(String id,String mail,String msg) throws java.rmi.RemoteException;
}
