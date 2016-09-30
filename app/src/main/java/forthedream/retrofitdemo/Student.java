package forthedream.retrofitdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lierabbit on 2016/9/29.
 */
public class Student extends BaseObservable
{
    private int mId;
    private String mName;
    private float mScore;

    public Student(int id, String name, float score)
    {
        mId = id;
        mName = name;
        mScore = score;
    }

    public Student(boolean isFirst)
    {
        if(isFirst)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://172.19.193.179:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            StudentServer studentServer = retrofit.create(StudentServer.class);
            Student student = new Student(20,"xyy",99.9f);
            Call<Student> studentCall = studentServer.getSearchStudentsJSON(student);
            studentCall.enqueue(new Callback<Student>()
            {
                @Override
                public void onResponse(Call<Student> call, Response<Student> response)
                {
                    mId = response.body().getId();
                    mName = response.body().getName();
                    mScore = response.body().getScore();
                    notifyChange();
                }

                @Override
                public void onFailure(Call<Student> call, Throwable t)
                {

                }
            });
        }
    }

    public int getId()
    {
        return mId;
    }

    public void setId(int id)
    {
        mId = id;
    }

    @Bindable
    public String getName()
    {
        return mName;
    }

    public void setName(String name)
    {
        mName = name;
        notifyPropertyChanged(BR.name);
    }

    public float getScore()
    {
        return mScore;
    }

    public void setScore(float score)
    {
        mScore = score;
    }
}
