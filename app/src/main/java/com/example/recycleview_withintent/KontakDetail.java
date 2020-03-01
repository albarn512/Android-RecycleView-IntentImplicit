package com.example.recycleview_withintent;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.MenuItem;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.bumptech.glide.Glide;

public class KontakDetail extends AppCompatActivity {
    TextView tvDes, tvNama;
    ImageView ivKontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ivKontak = findViewById(R.id.iv_kontak);
        tvDes = findViewById(R.id.tv_deskripsi);
        tvNama = findViewById(R.id.tv_nama);

        getIncomingIntent();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void getIncomingIntent(){
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int ivThumb = bundle.getInt("img_url");
            Glide.with(getApplicationContext()).load(ivThumb).into(ivKontak);
            String getDesc = bundle.getString("deskripsi");
            String getTitle = bundle.getString("nama");

            tvDes.setText(getDesc);
            tvNama.setText(getTitle);

        }


    }
}
