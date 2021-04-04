package com.CabPortal.Services;

import com.CabPortal.DAO.DBHandler;
import com.CabPortal.models.*;
import io.dropwizard.hibernate.UnitOfWork;



public class AdminService {

    private DBHandler dbHandler;

    public AdminService(DBHandler dbHandler) {
        this.dbHandler=dbHandler;
    }

    public OnboardCityResponse onboardCity(OnboardCityRequest onboardCityRequest)  throws  Exception{
        return null;
    }


    public CheckCABIdleResponse checkIsCableIdle(CheckCABIdleRequest checkCABIdleRequest)  throws  Exception{
        return null;
    }


    public CheckHighDemandResponse getHighDemandCities(CheckHighDemandRequest checkHighDemandRequest)  throws  Exception{
        return null;
    }
}
