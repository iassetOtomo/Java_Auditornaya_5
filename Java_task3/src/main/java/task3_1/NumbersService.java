package task3_1;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NumbersService {
    @GET("/")
    Call<ResponseBody> getNumbers();
}