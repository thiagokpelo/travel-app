package dev.thiagokpelo.viagens.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import dev.thiagokpelo.viagens.R;
import dev.thiagokpelo.viagens.dao.PackageDAO;
import dev.thiagokpelo.viagens.model.Package;
import dev.thiagokpelo.viagens.ui.adapters.PackageListAdapter;

public class PackageListActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_list);
        setTitle(APPBAR_TITLE);
        listConfig();
    }

    private void listConfig() {
        ListView packagesList = findViewById(R.id.listview);
        List<Package> packages = new PackageDAO().list();
        packagesList.setAdapter(new PackageListAdapter(packages, this));
    }
}
