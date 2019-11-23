package dev.thiagokpelo.viagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        final List<Package> packages = new PackageDAO().list();
        packagesList.setAdapter(new PackageListAdapter(packages, this));
        packagesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                goToPackageSummary(packages.get(position));
            }
        });
    }

    private void goToPackageSummary(Package item) {
        Intent intent = new Intent(PackageListActivity.this, PackageSummaryActivity.class);
        intent.putExtra(PackageConstants.PACKAGE_KEY, item);
        startActivity(intent);
    }
}
