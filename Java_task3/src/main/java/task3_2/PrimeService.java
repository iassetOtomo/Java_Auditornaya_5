package task3_2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PrimeService {
    @POST("/")
    Call<PrimeResponse> primeResponce(@Body PrimeRequest primeRequest);
}
