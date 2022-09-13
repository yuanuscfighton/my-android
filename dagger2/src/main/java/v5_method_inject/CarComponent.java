package v5_method_inject;

import dagger.Component;

@Component
public interface CarComponent {

  public void inject(Car5Activity activity);
}
