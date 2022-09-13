package v5_method_inject;

import javax.inject.Inject;

import android.util.Log;

import com.example.hiandroid.dagger.Dagger2LogTag;

public class Remote {

  @Inject
  public Remote() {
  }

  public void setListener(Car car) {
    Log.d(Dagger2LogTag.CAR5_LOG_TAG, "Remote connected");
  }
}
