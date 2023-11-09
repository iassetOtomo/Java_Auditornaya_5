package task3_2;
import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.File;
import java.io.IOException;

public class task3_2 {
    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://prime.tms-studio.ru:8085/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        PrimeRequest primeRequest = new PrimeRequest();
        System.out.println(primeRequest.numbers);

        PrimeService primeService = retrofit.create(PrimeService.class);
        Response<PrimeResponse> response = primeService.primeResponce(primeRequest).execute();
        System.out.println(response.body().answer);

        File file = new File("prime_response.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, response.body());
    }
}
