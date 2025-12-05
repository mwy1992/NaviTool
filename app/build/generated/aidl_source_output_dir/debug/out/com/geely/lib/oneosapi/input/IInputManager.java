/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.geely.lib.oneosapi.input;
public interface IInputManager extends android.os.IInterface
{
  /** Default implementation for IInputManager. */
  public static class Default implements com.geely.lib.oneosapi.input.IInputManager
  {
    /** Transaction 1 - Placeholder */
    @Override public void method1() throws android.os.RemoteException
    {
    }
    /** Transaction 2 - Placeholder */
    @Override public void method2() throws android.os.RemoteException
    {
    }
    /** Transaction 3 */
    @Override public void registerListener(com.geely.lib.oneosapi.input.IInputListener listener, java.lang.String packageName, int[] keyCodes) throws android.os.RemoteException
    {
    }
    /** Transaction 4 */
    @Override public void unregisterListener(com.geely.lib.oneosapi.input.IInputListener listener, java.lang.String packageName) throws android.os.RemoteException
    {
    }
    /** Transaction 5 */
    @Override public int getSomething() throws android.os.RemoteException
    {
      return 0;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.geely.lib.oneosapi.input.IInputManager
  {
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.geely.lib.oneosapi.input.IInputManager interface,
     * generating a proxy if needed.
     */
    public static com.geely.lib.oneosapi.input.IInputManager asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.geely.lib.oneosapi.input.IInputManager))) {
        return ((com.geely.lib.oneosapi.input.IInputManager)iin);
      }
      return new com.geely.lib.oneosapi.input.IInputManager.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      if (code >= android.os.IBinder.FIRST_CALL_TRANSACTION && code <= android.os.IBinder.LAST_CALL_TRANSACTION) {
        data.enforceInterface(descriptor);
      }
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
      }
      switch (code)
      {
        case TRANSACTION_method1:
        {
          this.method1();
          reply.writeNoException();
          break;
        }
        case TRANSACTION_method2:
        {
          this.method2();
          reply.writeNoException();
          break;
        }
        case TRANSACTION_registerListener:
        {
          com.geely.lib.oneosapi.input.IInputListener _arg0;
          _arg0 = com.geely.lib.oneosapi.input.IInputListener.Stub.asInterface(data.readStrongBinder());
          java.lang.String _arg1;
          _arg1 = data.readString();
          int[] _arg2;
          _arg2 = data.createIntArray();
          this.registerListener(_arg0, _arg1, _arg2);
          reply.writeNoException();
          break;
        }
        case TRANSACTION_unregisterListener:
        {
          com.geely.lib.oneosapi.input.IInputListener _arg0;
          _arg0 = com.geely.lib.oneosapi.input.IInputListener.Stub.asInterface(data.readStrongBinder());
          java.lang.String _arg1;
          _arg1 = data.readString();
          this.unregisterListener(_arg0, _arg1);
          reply.writeNoException();
          break;
        }
        case TRANSACTION_getSomething:
        {
          int _result = this.getSomething();
          reply.writeNoException();
          reply.writeInt(_result);
          break;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
      return true;
    }
    private static class Proxy implements com.geely.lib.oneosapi.input.IInputManager
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      /** Transaction 1 - Placeholder */
      @Override public void method1() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_method1, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      /** Transaction 2 - Placeholder */
      @Override public void method2() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_method2, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      /** Transaction 3 */
      @Override public void registerListener(com.geely.lib.oneosapi.input.IInputListener listener, java.lang.String packageName, int[] keyCodes) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeStrongInterface(listener);
          _data.writeString(packageName);
          _data.writeIntArray(keyCodes);
          boolean _status = mRemote.transact(Stub.TRANSACTION_registerListener, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      /** Transaction 4 */
      @Override public void unregisterListener(com.geely.lib.oneosapi.input.IInputListener listener, java.lang.String packageName) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeStrongInterface(listener);
          _data.writeString(packageName);
          boolean _status = mRemote.transact(Stub.TRANSACTION_unregisterListener, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      /** Transaction 5 */
      @Override public int getSomething() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getSomething, _data, _reply, 0);
          _reply.readException();
          _result = _reply.readInt();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
    }
    static final int TRANSACTION_method1 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_method2 = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_registerListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    static final int TRANSACTION_unregisterListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    static final int TRANSACTION_getSomething = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
  }
  public static final java.lang.String DESCRIPTOR = "com.geely.lib.oneosapi.input.IInputManager";
  /** Transaction 1 - Placeholder */
  public void method1() throws android.os.RemoteException;
  /** Transaction 2 - Placeholder */
  public void method2() throws android.os.RemoteException;
  /** Transaction 3 */
  public void registerListener(com.geely.lib.oneosapi.input.IInputListener listener, java.lang.String packageName, int[] keyCodes) throws android.os.RemoteException;
  /** Transaction 4 */
  public void unregisterListener(com.geely.lib.oneosapi.input.IInputListener listener, java.lang.String packageName) throws android.os.RemoteException;
  /** Transaction 5 */
  public int getSomething() throws android.os.RemoteException;
}
