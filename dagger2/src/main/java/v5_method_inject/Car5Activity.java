package v5_method_inject;

import javax.inject.Inject;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hiandroid.R;

public class Car5Activity extends AppCompatActivity {

  @Inject
  Car mCar;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.car3_activity_layout);

    CarComponent component = DaggerCarComponent.create();
    component.inject(Car5Activity.this);

    mCar.drive();
  }
}
