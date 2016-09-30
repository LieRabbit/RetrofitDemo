package forthedream.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by lierabbit on 2016/9/30.
 */

public interface StudentServer
{
    @GET("HelloWorld/json")
    Call<Student> getSearchStudents(@Query("id") int id, @Query("name") String name, @Query("score") float score);

    @POST("HelloWorld/json")
    Call<Student> getSearchStudentsJSON(@Body Student student);
}
