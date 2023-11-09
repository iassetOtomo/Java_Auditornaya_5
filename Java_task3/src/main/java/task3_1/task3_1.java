package task3_1;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

public class task3_1 {
    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("http://prime.tms-studio.ru:8085/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        NumbersService numbersService = retrofit.create(NumbersService.class);
        Response<ResponseBody> response = numbersService.getNumbers().execute();

        String s = response.body().string();
        System.out.println(s);

        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNumbers arrayNumbers = objectMapper.readValue(s, ArrayNumbers.class);

        System.out.println("Максимальное значение : " + arrayNumbers.getMax());
        System.out.println("Минимальное значение : " + arrayNumbers.getMin());
        System.out.println("Среднее значение : " + arrayNumbers.getAvg());
    }
}
