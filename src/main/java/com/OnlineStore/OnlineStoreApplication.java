package com.OnlineStore;

import com.OnlineStore.CartService.DiscountHandler;
import com.OnlineStore.models.Department;
import com.OnlineStore.models.Product;
import com.OnlineStore.db.DepartmentDAO;
import com.OnlineStore.db.ProductDAO;
import com.OnlineStore.resources.CartResource;
import com.OnlineStore.resources.ProductResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import java.util.Map;


public class OnlineStoreApplication extends Application<OnlineStoreConfiguration> {
    public static void main(String[] args) throws Exception {
        new OnlineStoreApplication().run(args);
    }

    private final HibernateBundle<OnlineStoreConfiguration> hibernateBundle =
            new HibernateBundle<OnlineStoreConfiguration>(Product.class, Department.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(OnlineStoreConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    @Override
    public void initialize(Bootstrap<OnlineStoreConfiguration> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );

//        bootstrap.addCommand(new RenderCommand());
        bootstrap.addBundle(new AssetsBundle());
        bootstrap.addBundle(new MigrationsBundle<OnlineStoreConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(OnlineStoreConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(new ViewBundle<OnlineStoreConfiguration>() {
            @Override
            public Map<String, Map<String, String>> getViewConfiguration(OnlineStoreConfiguration configuration) {
                return configuration.getViewRendererConfiguration();
            }
        });
    }

    public void run(OnlineStoreConfiguration onlineStoreConfiguration, Environment environment) throws Exception {
        final DepartmentDAO departmentDAO = new DepartmentDAO(hibernateBundle.getSessionFactory());
        final ProductDAO productDAO = new ProductDAO(hibernateBundle.getSessionFactory(), departmentDAO);
        environment.jersey().register(new ProductResource(productDAO, departmentDAO));
        environment.jersey().register(new CartResource(productDAO, departmentDAO, new DiscountHandler(productDAO,departmentDAO)));
    }
}
