package v2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hiandroid.dagger.v2.engine.Block;
import com.example.hiandroid.dagger.v2.engine.Cylinders;
import com.example.hiandroid.dagger.v2.engine.SparkPlugs;
import com.example.hiandroid.dagger.v2.wheel.Rims;
import com.example.hiandroid.dagger.v2.wheel.Tires;

public class Car2Activity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // We have to initiate all these objects here and then pass them to our engine and wheels.
    // This could go on and on for many different objects and on different places in our App.
    // 缺点: This manual dependency injection really pollutes all our calling sites.
    //
    // Whenever we change a constructor or how we have to configure one of these classes,
    // then we have to update these changes everywhere(really tedious process).
    //
    // This is where dependency injection frameworks like Dagger come into play.
    // Dependency injection frameworks' main responsibility is to get rid of all this boilerplate code.
    // So we basically teach Dagger how to construct all these objects and then it creates them at the right time and in the right order.
    Block block = new Block();
    Cylinders cylinders = new Cylinders();
    SparkPlugs sparkPlugs = new SparkPlugs();
    Rims rims = new Rims();
    Tires tires = new Tires();

    Engine engine = new Engine(block, cylinders, sparkPlugs);
    Wheels wheels = new Wheels(rims, tires);

    Car car = new Car(engine, wheels);

  }
}
