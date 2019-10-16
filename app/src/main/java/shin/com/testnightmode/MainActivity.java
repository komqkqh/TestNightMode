package shin.com.testnightmode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_theme = findViewById(R.id.btn_theme);
        btn_theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AppCompatDelegate.getDefaultNightMode() != AppCompatDelegate.MODE_NIGHT_NO){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
            }
        });
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        int currentNightMode = newConfig.uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (currentNightMode) {
            case Configuration.UI_MODE_NIGHT_NO:
                // Night mode is not active, we're using the light theme
                Log.i("TEST","onConfigurationChanged ::: UI_MODE_NIGHT_NO");
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                // Night mode is active, we're using dark theme
                Log.i("TEST","onConfigurationChanged ::: UI_MODE_NIGHT_YES");
                break;
        }
    }
}
