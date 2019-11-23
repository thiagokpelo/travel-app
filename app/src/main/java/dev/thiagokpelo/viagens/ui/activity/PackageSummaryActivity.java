package dev.thiagokpelo.viagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import dev.thiagokpelo.viagens.R;
import dev.thiagokpelo.viagens.model.Package;
import dev.thiagokpelo.viagens.utils.CurrencyUtil;
import dev.thiagokpelo.viagens.utils.DateUtil;
import dev.thiagokpelo.viagens.utils.ResourceUtil;

public class PackageSummaryActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Resumo do pacote";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_summary);

        setTitle(APPBAR_TITLE);

        populatePackageSelected();
    }

    private void populatePackageSelected() {
        Intent intent = getIntent();

        if (intent.hasExtra(PackageConstants.PACKAGE_KEY)) {
            final Package packageSelected = (Package) intent.getSerializableExtra(PackageConstants.PACKAGE_KEY);
            populateAllProperties(packageSelected);
            buttonConfig(packageSelected);
        }
    }

    private void buttonConfig(final Package packageSelected) {
        Button button = findViewById(R.id.package_summary_call_to_action);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPayment(packageSelected);
            }
        });
    }

    private void goToPayment(Package item) {
        Intent intent = new Intent(PackageSummaryActivity.this, PaymentActivity.class);
        intent.putExtra(PackageConstants.PACKAGE_KEY, item);
        startActivity(intent);
    }

    private void populateAllProperties(Package item) {
        showLocal(item);
        showBanner(item);
        showDays(item);
        showPrice(item);
        showDate(item);
    }

    private void showDate(Package item) {
        TextView date = findViewById(R.id.package_summary_date);
        String fullDate = DateUtil.periodToString(item.getDays());

        date.setText(fullDate);
    }

    private void showPrice(Package item) {
        TextView price = findViewById(R.id.package_summary_price);
        String priceFormat = CurrencyUtil.brazilFormat(item.getPrice());
        price.setText(priceFormat);
    }

    private void showDays(Package item) {
        TextView days = findViewById(R.id.package_summary_days);
        String daysFormat = DateUtil.daysInTextFormat(item.getDays());
        days.setText(daysFormat);
    }

    private void showBanner(Package item) {
        ImageView banner = findViewById(R.id.package_summary_banner);
        Drawable drawable = ResourceUtil.getDrawable(this, item.getImage());
        banner.setImageDrawable(drawable);
    }

    private void showLocal(Package item) {
        TextView local = findViewById(R.id.package_summary_local);
        local.setText(item.getLocal());
    }
}
