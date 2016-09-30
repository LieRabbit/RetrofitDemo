package forthedream.retrofitdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;

import forthedream.retrofitdemo.databinding.ActivityMainBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{
    private ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mBinding.setPresenter(new Presenter());
        mBinding.setStudent(new Student(true));

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://172.19.199.242:8080/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        StudentServer studentServer = retrofit.create(StudentServer.class);
//        Student student = new Student(20,"xyy",99.9f);
//        Call<Student> studentCall = studentServer.getSearchStudentsJSON(student);
//        studentCall.enqueue(new Callback<Student>()
//        {
//            @Override
//            public void onResponse(Call<Student> call, Response<Student> response)
//            {
//                mBinding.setStudent(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<Student> call, Throwable t)
//            {
//
//            }
//        });
    }

    public class Presenter
    {
        public void update(Student student)
        {
            student.setName("已更新");
        }
    }
}
