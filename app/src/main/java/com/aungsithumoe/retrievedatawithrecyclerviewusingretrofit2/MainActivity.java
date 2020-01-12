package com.aungsithumoe.retrievedatawithrecyclerviewusingretrofit2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_user_info)
    RecyclerView rvUserInfo;
    List<Users> usersList;
    UserInformationAdapter userInformationAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        usersList = new ArrayList<>();

        //create adapter
        userInformationAdapter = new UserInformationAdapter(this);

        // create layoutmanager
        rvUserInfo.setLayoutManager(new GridLayoutManager(this,3));

        // set adapter
        rvUserInfo.setAdapter(userInformationAdapter);


        Users users = new Users("Test Name", "1234","");
        Users users1 = new Users("Test Name1", "1234","");
        usersList.add(users);
        usersList.add(users1);
        Call<List<Users>> callUserInformation = APIClient.getClient().create(GetUserInformationService.class).getUserInfo();
        callUserInformation.enqueue(new Callback<List<Users>>() {
            @Override
            public void onResponse(Call<List<Users>> call, Response<List<Users>> response) {

                if(response.body() != null)
                {
                    userInformationAdapter.addUserList(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<Users>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Fail"+ t.getMessage(),Toast.LENGTH_LONG).show();
                System.out.println("Fail:::" + t.getMessage());
            }
        });

    }
}
