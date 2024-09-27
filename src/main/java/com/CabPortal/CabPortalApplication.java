package com.CabPortal;

import com.CabPortal.DAO.DBHandler;
import com.CabPortal.DAO1.*;
import com.CabPortal.Entities1.*;
import com.CabPortal.Services.AdminService;
import com.CabPortal.Services.CabService;
import com.CabPortal.Services.UserService;
import com.CabPortal.resources.AdminResource;
import com.CabPortal.resources.CabResource;
import com.CabPortal.resources.UserResource;
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

public class CabPortalApplication extends Application<CabPortalConfiguration> {
    public static void main(String[] args) throws Exception {
        new CabPortalApplication().run(args);
    }

    private final HibernateBundle<CabPortalConfiguration> hibernateBundle =
            new HibernateBundle<CabPortalConfiguration>(User.class, City.class, Cab.class, Booking.class, Trip.class,
                    CabLocationMapping.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(CabPortalConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    @Override
    public void initialize(Bootstrap<CabPortalConfiguration> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );

        //        bootstrap.addCommand(new RenderCommand());
        bootstrap.addBundle(new AssetsBundle());
        bootstrap.addBundle(new MigrationsBundle<CabPortalConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(CabPortalConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(new ViewBundle<CabPortalConfiguration>() {
            @Override
            public Map<String, Map<String, String>> getViewConfiguration(CabPortalConfiguration configuration) {
                return configuration.getViewRendererConfiguration();
            }
        });
    }

    public void run(CabPortalConfiguration CabPortalConfiguration, Environment environment) throws Exception {
//        final BookingDAO bookingDAO = new BookingDAO(hibernateBundle.getSessionFactory());
//        final CabDAO cabDAO = new CabDAO(hibernateBundle.getSessionFactory());
//        final CabLocationMappingDAO cabLocationMappingDAO = new CabLocationMappingDAO(hibernateBundle.getSessionFactory());
//        final CityDAO cityDAO = new CityDAO(hibernateBundle.getSessionFactory());
//        final TripDAO tripDAO = new TripDAO(hibernateBundle.getSessionFactory());
//        final UserDAO userDAO = new UserDAO(hibernateBundle.getSessionFactory());
        final DBHandler dbHandler=new DBHandler();
        final AdminService adminService = new AdminService(dbHandler);
        final CabService cabService = new CabService(dbHandler);
        final UserService userService = new UserService(dbHandler);
        environment.jersey().register(new AdminResource(adminService));
        environment.jersey().register(new CabResource(cabService));
        environment.jersey().register(new UserResource(userService));
    }
}
