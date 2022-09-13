import static com.example.hiandroid.dagger.Dagger2LogTag.DAGGER_ACTIVITY_LOG_TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hiandroid.R;
import com.example.hiandroid.dagger.v5_method_inject.Car5Activity;

public class Dagger2Activity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.dagger2_layout);

    findViewById(R.id.start_car_x_dagger_activity_button)
        .setOnClickListener(v -> {
          Log.d(DAGGER_ACTIVITY_LOG_TAG, "启动" + Dagger2Activity.class.getSimpleName());
          Intent intent = new Intent(Dagger2Activity.this, Car5Activity.class);
          startActivity(intent);
        });

  }
}
