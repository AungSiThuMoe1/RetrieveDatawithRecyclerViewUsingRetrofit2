package com.aungsithumoe.retrievedatawithrecyclerviewusingretrofit2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetUserInformationService {
    @GET("GetUserInformation.php")
    Call<List<Users>> getUserInfo();

}
