package uk.ostmodern.incoming.test.receivers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import uk.ostmodern.incoming.test.R;
import uk.ostmodern.incoming.test.interfaces.IConnectivityChangeListener;
import uk.ostmodern.incoming.test.utils.InternetUtil;

public class ConnectivityChangeBroadcastReceiver extends BroadcastReceiver {
    private IConnectivityChangeListener mListener;
    private AlertDialog dialog;

    public ConnectivityChangeBroadcastReceiver(){}

    public ConnectivityChangeBroadcastReceiver(IConnectivityChangeListener listener) {
        mListener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            if (InternetUtil.hasInternet(context)) {
                if (dialog != null) {
                    dialog.dismiss();
                    dialog = null;
                    System.gc();
//                    mListener.connectivityChange(true);
                }
                mListener.connectivityChange(true);
            }else{
                if (dialog == null) {
                    final Context cont = context;
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle(context.getResources().getString(R.string.no_connection_header));
                    builder.setMessage(context.getResources().getString(R.string.no_connection));
                    builder.setPositiveButton(R.string.exit, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            cont.startActivity(intent);
                                                    ((Activity)cont).finish();
                                                    System.exit(0);
                        }
                    });
                    //                builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    //                    public void onClick(DialogInterface dialog, int id) {
                    //                        dialog.dismiss();
                    //                        ((Activity) cont).finish();
                    //                    }
                    //                });
                    dialog = builder.show();
                    dialog.setCancelable(false);
//                    mListener.connectivityChange(false);
                }else{
                    dialog.show();
                }
                mListener.connectivityChange(false);
            }
        }
    }
}
