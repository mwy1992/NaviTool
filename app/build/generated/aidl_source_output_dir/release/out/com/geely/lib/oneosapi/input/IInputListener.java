/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.geely.lib.oneosapi.input;
public interface IInputListener extends android.os.IInterface
{
  /** Default implementation for IInputListener. */
  public static class Default implements com.geely.lib.oneosapi.input.IInputListener
  {
    /** Transaction 1 */
    @Override public void onKeyEvent(int keyCode, int event, int softKeyFunction) throws android.os.RemoteException
    {
    }
    /** Transaction 2 */
    @Override public void onShortClick(int keyCode, int softKeyFunction) throws android.os.RemoteException
    {
    }
    /** Transaction 3 */
    @Override public void onLongPressTriggered(int keyCode, int softKeyFunction) throws android.os.RemoteException
    {
    }
    /** Transaction 4 */
    @Override public void onHoldingPressStopped(int keyCode, int softKeyFunction) throws android.os.RemoteException
    {
    }
    /** Transaction 5 */
    @Override public void onLongPress(int keyCode, int softKeyFunction) throws android.os.RemoteException
    {
    }
    /** Transaction 6 */
    @Override public void onDoubleClick(int keyCode, int softKeyFunction) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.geely.lib.oneosapi.input.IInputListener
  {
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.geely.lib.oneosapi.input.IInputListener interface,
     * generating a proxy if needed.
     */
    public static com.geely.lib.oneosapi.input.IInputListener asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.geely.lib.oneosapi.input.IInputListener))) {
        return ((com.geely.lib.oneosapi.input.IInputListener)iin);
      }
      return new com.geely.lib.oneosapi.input.IInputListener.Stub.Proxy(obj);
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
        case TRANSACTION_onKeyEvent:
        {
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          int _arg2;
          _arg2 = data.readInt();
          this.onKeyEvent(_arg0, _arg1, _arg2);
          reply.writeNoException();
          break;
        }
        case TRANSACTION_onShortClick:
        {
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          this.onShortClick(_arg0, _arg1);
          reply.writeNoException();
          break;
        }
        case TRANSACTION_onLongPressTriggered:
        {
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          this.onLongPressTriggered(_arg0, _arg1);
          reply.writeNoException();
          break;
        }
        case TRANSACTION_onHoldingPressStopped:
        {
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          this.onHoldingPressStopped(_arg0, _arg1);
          reply.writeNoException();
          break;
        }
        case TRANSACTION_onLongPress:
        {
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          this.onLongPress(_arg0, _arg1);
          reply.writeNoException();
          break;
        }
        case TRANSACTION_onDoubleClick:
        {
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          this.onDoubleClick(_arg0, _arg1);
          reply.writeNoException();
          break;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
      return true;
    }
    private static class Proxy implements com.geely.lib.oneosapi.input.IInputListener
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
      /** Transaction 1 */
      @Override public void onKeyEvent(int keyCode, int event, int softKeyFunction) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(keyCode);
          _data.writeInt(event);
          _data.writeInt(softKeyFunction);
          boolean _status = mRemote.transact(Stub.TRANSACTION_onKeyEvent, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      /** Transaction 2 */
      @Override public void onShortClick(int keyCode, int softKeyFunction) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(keyCode);
          _data.writeInt(softKeyFunction);
          boolean _status = mRemote.transact(Stub.TRANSACTION_onShortClick, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      /** Transaction 3 */
      @Override public void onLongPressTriggered(int keyCode, int softKeyFunction) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(keyCode);
          _data.writeInt(softKeyFunction);
          boolean _status = mRemote.transact(Stub.TRANSACTION_onLongPressTriggered, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      /** Transaction 4 */
      @Override public void onHoldingPressStopped(int keyCode, int softKeyFunction) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(keyCode);
          _data.writeInt(softKeyFunction);
          boolean _status = mRemote.transact(Stub.TRANSACTION_onHoldingPressStopped, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      /** Transaction 5 */
      @Override public void onLongPress(int keyCode, int softKeyFunction) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(keyCode);
          _data.writeInt(softKeyFunction);
          boolean _status = mRemote.transact(Stub.TRANSACTION_onLongPress, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      /** Transaction 6 */
      @Override public void onDoubleClick(int keyCode, int softKeyFunction) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(keyCode);
          _data.writeInt(softKeyFunction);
          boolean _status = mRemote.transact(Stub.TRANSACTION_onDoubleClick, _data, _reply, 0);
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
    }
    static final int TRANSACTION_onKeyEvent = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_onShortClick = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_onLongPressTriggered = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    static final int TRANSACTION_onHoldingPressStopped = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    static final int TRANSACTION_onLongPress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
    static final int TRANSACTION_onDoubleClick = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
  }
  public static final java.lang.String DESCRIPTOR = "com.geely.lib.oneosapi.input.IInputListener";
  /** Transaction 1 */
  public void onKeyEvent(int keyCode, int event, int softKeyFunction) throws android.os.RemoteException;
  /** Transaction 2 */
  public void onShortClick(int keyCode, int softKeyFunction) throws android.os.RemoteException;
  /** Transaction 3 */
  public void onLongPressTriggered(int keyCode, int softKeyFunction) throws android.os.RemoteException;
  /** Transaction 4 */
  public void onHoldingPressStopped(int keyCode, int softKeyFunction) throws android.os.RemoteException;
  /** Transaction 5 */
  public void onLongPress(int keyCode, int softKeyFunction) throws android.os.RemoteException;
  /** Transaction 6 */
  public void onDoubleClick(int keyCode, int softKeyFunction) throws android.os.RemoteException;
}
