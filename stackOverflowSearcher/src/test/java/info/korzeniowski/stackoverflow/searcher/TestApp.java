package info.korzeniowski.stackoverflow.searcher;

import javax.inject.Singleton;

import dagger.Component;
import info.korzeniowski.stackoverflow.searcher.module.MockDatabaseModule;
import info.korzeniowski.stackoverflow.searcher.module.MockStackOverflowModule;
import info.korzeniowski.stackoverflow.searcher.test.ViewTest;

public class TestApp extends App {

    @Singleton
    @Component(
            modules = {
                    MainModule.class,
                    MockDatabaseModule.class,
                    HttpClientModule.class,
                    MockStackOverflowModule.class
            })
    public interface TestApplicationComponent extends ApplicationComponent {
        void inject(ViewTest object);
    }

    @Override
    public void onCreate() {
        // Android Studio doesn't see this Class
        component = Dagger_TestApp_TestApplicationComponent.builder()
                .mainModule(new MainModule(this))
                .build();
    }

    public TestApplicationComponent component() {
        return (TestApplicationComponent) component;
    }
}