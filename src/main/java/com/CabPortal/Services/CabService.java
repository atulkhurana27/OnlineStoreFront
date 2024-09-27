package com.CabPortal.Services;

import com.CabPortal.DAO.DBHandler;
import com.CabPortal.models.*;


public class CabService {

    private DBHandler dbHandler;

    public CabService(DBHandler dbHandler) {
        this.dbHandler=dbHandler;
    }

    public CabRegistrationResponse registerCab(CabRegistrationRequest registerCabRequestBody)  throws  Exception{
        CabRegistrationResponse cabRegistrationResponseBody = new CabRegistrationResponse();
        return null;
    }

    public UpdateCabDataResponse updateCabMetadata(UpdateCabDataRequest updateCabDataRequest)  throws  Exception{
        return null;
    }

    public CabHistoryResponse getCabHistory(CabHistoryRequest cabHistoryRequest)  throws  Exception {
        return null;

    }
}
