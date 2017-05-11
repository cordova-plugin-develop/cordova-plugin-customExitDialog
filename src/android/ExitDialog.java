package org.apache.cordova.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONException;

/**
 * Created by Alex on 2017/5/6.
 *
 */

public class ExitDialog extends CordovaPlugin{

    @Override
    public boolean execute(String action, CordovaArgs args, final CallbackContext callbackContext) throws JSONException {
        if("showExit".equals(action)){
            AlertDialog.Builder builder = new AlertDialog.Builder(cordova.getActivity());
            builder.setTitle("提示");
            builder.setMessage(args.getString(0));
            builder.setPositiveButton("去意已绝", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    callbackContext.success("exit");
                }
            });
            builder.setNegativeButton("后悔了", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    callbackContext.error("cancel");
                    dialog.dismiss();
                }
            });
            builder.create().show();
            return true;
        }

        return super.execute(action, args, callbackContext);
    }
}
