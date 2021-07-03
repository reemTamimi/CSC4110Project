package edu.wsu.chronicillnessawareness.Posts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import edu.wsu.chronicillnessawareness.Model.MyListModel;
import edu.wsu.chronicillnessawareness.R;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        MyListModel[] myListData = new MyListModel[] {
                new MyListModel("User1","Description about the post", android.R.drawable.ic_dialog_email),
                new MyListModel("User2","Description about the post", android.R.drawable.ic_dialog_info),
                new MyListModel("User3","Description about the post", android.R.drawable.ic_delete),
                new MyListModel("User4","Description about the post", android.R.drawable.ic_dialog_dialer),
                new MyListModel("User5","Description about the post", android.R.drawable.ic_dialog_alert),
                new MyListModel("User6","Description about the post", android.R.drawable.ic_dialog_map),
                new MyListModel("User7","Description about the post", android.R.drawable.ic_dialog_email),
                new MyListModel("User8","Description about the post", android.R.drawable.ic_dialog_info),
                new MyListModel("User9","Description about the post", android.R.drawable.ic_delete),
                new MyListModel("User10","Description about the post", android.R.drawable.ic_dialog_dialer),
                new MyListModel("User11","Description about the post", android.R.drawable.ic_dialog_alert),
                new MyListModel("User12","Description about the post", android.R.drawable.ic_dialog_map),
        };

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_posts);
        GroupAdapter adapter = new GroupAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}

