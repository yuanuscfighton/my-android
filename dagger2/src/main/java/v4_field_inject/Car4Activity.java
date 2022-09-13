package v4_field_inject;

import javax.inject.Inject;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hiandroid.R;

public class Car4Activity extends AppCompatActivity {

  // error_msg= Dagger does not support injection into private fields
  // also, member variable cannot be final, because you may want to change its value.
  @Inject
  Car mCar;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.car3_activity_layout);

    CarComponent component = DaggerCarComponent.create();
    component.inject(this);
    mCar.drive();
  }

  // In Car4Activity, we cannot do constructor injection, because Android System instantiates them.
}
