package AWS_Classes.Lambda;

import android.os.AsyncTask;
import android.util.Log;

import com.amazonaws.mobileconnectors.lambdainvoker.LambdaFunctionException;

import AWS_Classes.LoginResponse;
import AWS_Classes.UserData;

/**
 * Created by Niko on 1/12/2016.
 */
public class LambdaAsyncLogin extends AsyncTask<UserData, Void, LoginResponse> {

    protected LambdaInterface myInterface;
    public LambdaResponse delegate = null;

    public LambdaAsyncLogin(LambdaInterface newInterface) {
        myInterface = newInterface;
    }

    @Override
    protected LoginResponse doInBackground(UserData... args) {

        try {
            return myInterface.callLogin(args[0]);
        }
        catch (LambdaFunctionException lfe) {
            Log.d("TAG", "Failed to invoke login", lfe);
            return null;
        }
    }


    @Override
    protected void onPostExecute(LoginResponse result) {
        if(result == null){
            return;
        }

        delegate.lambdaFinish(result);
    }

}
